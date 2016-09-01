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
package com.bydan.erp.nomina.business.logic;

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
import com.bydan.erp.nomina.util.*;
import com.bydan.erp.nomina.util.CargoConstantesFunciones;
import com.bydan.erp.nomina.util.CargoParameterReturnGeneral;
//import com.bydan.erp.nomina.util.CargoParameterGeneral;
import com.bydan.erp.nomina.business.entity.Cargo;
import com.bydan.erp.nomina.business.logic.CargoLogicAdditional;
import com.bydan.erp.nomina.business.dataaccess.*;
import com.bydan.erp.nomina.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;
import com.bydan.erp.contabilidad.business.logic.*;
import com.bydan.erp.tesoreria.business.logic.*;
import com.bydan.erp.cartera.business.logic.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.tesoreria.util.*;
import com.bydan.erp.cartera.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;
import com.bydan.erp.tesoreria.business.dataaccess.*;
import com.bydan.erp.cartera.business.dataaccess.*;








@SuppressWarnings("unused")
public class CargoLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(CargoLogic.class);
	
	protected CargoDataAccess cargoDataAccess; 	
	protected Cargo cargo;
	protected List<Cargo> cargos;
	protected Object cargoObject;	
	protected List<Object> cargosObject;
	
	public static ClassValidator<Cargo> cargoValidator = new ClassValidator<Cargo>(Cargo.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected CargoLogicAdditional cargoLogicAdditional=null;
	
	public CargoLogicAdditional getCargoLogicAdditional() {
		return this.cargoLogicAdditional;
	}
	
	public void setCargoLogicAdditional(CargoLogicAdditional cargoLogicAdditional) {
		try {
			this.cargoLogicAdditional=cargoLogicAdditional;
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
	
	
	
	
	public  CargoLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.cargoDataAccess = new CargoDataAccess();
			
			this.cargos= new ArrayList<Cargo>();
			this.cargo= new Cargo();
			
			this.cargoObject=new Object();
			this.cargosObject=new ArrayList<Object>();
				
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
			
			this.cargoDataAccess.setConnexionType(this.connexionType);
			this.cargoDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  CargoLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.cargoDataAccess = new CargoDataAccess();
			this.cargos= new ArrayList<Cargo>();
			this.cargo= new Cargo();
			this.cargoObject=new Object();
			this.cargosObject=new ArrayList<Object>();
			
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
			
			this.cargoDataAccess.setConnexionType(this.connexionType);
			this.cargoDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public Cargo getCargo() throws Exception {	
		CargoLogicAdditional.checkCargoToGet(cargo,this.datosCliente,this.arrDatoGeneral);
		CargoLogicAdditional.updateCargoToGet(cargo,this.arrDatoGeneral);
		
		return cargo;
	}
		
	public void setCargo(Cargo newCargo) {
		this.cargo = newCargo;
	}
	
	public CargoDataAccess getCargoDataAccess() {
		return cargoDataAccess;
	}
	
	public void setCargoDataAccess(CargoDataAccess newcargoDataAccess) {
		this.cargoDataAccess = newcargoDataAccess;
	}
	
	public List<Cargo> getCargos() throws Exception {		
		this.quitarCargosNulos();
		
		CargoLogicAdditional.checkCargoToGets(cargos,this.datosCliente,this.arrDatoGeneral);
		
		for (Cargo cargoLocal: cargos ) {
			CargoLogicAdditional.updateCargoToGet(cargoLocal,this.arrDatoGeneral);
		}
		
		return cargos;
	}
	
	public void setCargos(List<Cargo> newCargos) {
		this.cargos = newCargos;
	}
	
	public Object getCargoObject() {	
		this.cargoObject=this.cargoDataAccess.getEntityObject();
		return this.cargoObject;
	}
		
	public void setCargoObject(Object newCargoObject) {
		this.cargoObject = newCargoObject;
	}
	
	public List<Object> getCargosObject() {		
		this.cargosObject=this.cargoDataAccess.getEntitiesObject();
		return this.cargosObject;
	}
		
	public void setCargosObject(List<Object> newCargosObject) {
		this.cargosObject = newCargosObject;
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
		
		if(this.cargoDataAccess!=null) {
			this.cargoDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Cargo.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			cargoDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			cargoDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		cargo = new  Cargo();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Cargo.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			cargo=cargoDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.cargo,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				CargoConstantesFunciones.refrescarForeignKeysDescripcionesCargo(this.cargo);
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
		cargo = new  Cargo();
		  		  
        try {
			
			cargo=cargoDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.cargo,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				CargoConstantesFunciones.refrescarForeignKeysDescripcionesCargo(this.cargo);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		cargo = new  Cargo();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Cargo.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			cargo=cargoDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.cargo,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				CargoConstantesFunciones.refrescarForeignKeysDescripcionesCargo(this.cargo);
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
		cargo = new  Cargo();
		  		  
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
		cargo = new  Cargo();
		  		  
        try {
			
			cargo=cargoDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.cargo,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				CargoConstantesFunciones.refrescarForeignKeysDescripcionesCargo(this.cargo);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		cargo = new  Cargo();
		  		  
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
		cargo = new  Cargo();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Cargo.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =cargoDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		cargo = new  Cargo();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=cargoDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		cargo = new  Cargo();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Cargo.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =cargoDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		cargo = new  Cargo();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=cargoDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		cargo = new  Cargo();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Cargo.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =cargoDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		cargo = new  Cargo();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=cargoDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		cargos = new  ArrayList<Cargo>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Cargo.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			CargoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cargos=cargoDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarCargo(cargos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CargoConstantesFunciones.refrescarForeignKeysDescripcionesCargo(this.cargos);
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
		cargos = new  ArrayList<Cargo>();
		  		  
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
		cargos = new  ArrayList<Cargo>();
		  		  
        try {			
			CargoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cargos=cargoDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarCargo(cargos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CargoConstantesFunciones.refrescarForeignKeysDescripcionesCargo(this.cargos);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		cargos = new  ArrayList<Cargo>();
		  		  
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
		cargos = new  ArrayList<Cargo>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Cargo.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			CargoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cargos=cargoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarCargo(cargos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CargoConstantesFunciones.refrescarForeignKeysDescripcionesCargo(this.cargos);
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
		cargos = new  ArrayList<Cargo>();
		  		  
        try {
			CargoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cargos=cargoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarCargo(cargos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CargoConstantesFunciones.refrescarForeignKeysDescripcionesCargo(this.cargos);
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
		cargos = new  ArrayList<Cargo>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Cargo.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			CargoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cargos=cargoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarCargo(cargos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CargoConstantesFunciones.refrescarForeignKeysDescripcionesCargo(this.cargos);
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
		cargos = new  ArrayList<Cargo>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			CargoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cargos=cargoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarCargo(cargos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CargoConstantesFunciones.refrescarForeignKeysDescripcionesCargo(this.cargos);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		cargo = new  Cargo();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Cargo.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			CargoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cargo=cargoDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarCargo(cargo);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CargoConstantesFunciones.refrescarForeignKeysDescripcionesCargo(this.cargo);
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
		cargo = new  Cargo();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			CargoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cargo=cargoDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarCargo(cargo);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CargoConstantesFunciones.refrescarForeignKeysDescripcionesCargo(this.cargo);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		cargos = new  ArrayList<Cargo>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Cargo.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			CargoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cargos=cargoDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarCargo(cargos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CargoConstantesFunciones.refrescarForeignKeysDescripcionesCargo(this.cargos);
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
		cargos = new  ArrayList<Cargo>();
		  		  
        try {
			CargoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cargos=cargoDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarCargo(cargos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CargoConstantesFunciones.refrescarForeignKeysDescripcionesCargo(this.cargos);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosCargosWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		cargos = new  ArrayList<Cargo>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Cargo.class.getSimpleName()+"-getTodosCargosWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			CargoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cargos=cargoDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarCargo(cargos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CargoConstantesFunciones.refrescarForeignKeysDescripcionesCargo(this.cargos);
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
	
	public  void  getTodosCargos(String sFinalQuery,Pagination pagination)throws Exception {
		cargos = new  ArrayList<Cargo>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			CargoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cargos=cargoDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarCargo(cargos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CargoConstantesFunciones.refrescarForeignKeysDescripcionesCargo(this.cargos);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarCargo(Cargo cargo) throws Exception {
		Boolean estaValidado=false;
		
		if(cargo.getIsNew() || cargo.getIsChanged()) { 
			this.invalidValues = cargoValidator.getInvalidValues(cargo);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(cargo);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarCargo(List<Cargo> Cargos) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(Cargo cargoLocal:cargos) {				
			estaValidadoObjeto=this.validarGuardarCargo(cargoLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarCargo(List<Cargo> Cargos) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarCargo(cargos)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarCargo(Cargo Cargo) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarCargo(cargo)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(Cargo cargo) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+cargo.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=CargoConstantesFunciones.getCargoLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"cargo","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(CargoConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(CargoConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveCargoWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Cargo.class.getSimpleName()+"-saveCargoWithConnection");connexion.begin();			
			
			CargoLogicAdditional.checkCargoToSave(this.cargo,this.datosCliente,connexion,this.arrDatoGeneral);
			
			CargoLogicAdditional.updateCargoToSave(this.cargo,this.arrDatoGeneral);
			
			CargoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.cargo,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowCargo();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarCargo(this.cargo)) {
				CargoDataAccess.save(this.cargo, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.cargo,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			CargoLogicAdditional.checkCargoToSaveAfter(this.cargo,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowCargo();
			
			connexion.commit();			
			
			if(this.cargo.getIsDeleted()) {
				this.cargo=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveCargo()throws Exception {	
		try {	
			
			CargoLogicAdditional.checkCargoToSave(this.cargo,this.datosCliente,connexion,this.arrDatoGeneral);
			
			CargoLogicAdditional.updateCargoToSave(this.cargo,this.arrDatoGeneral);
			
			CargoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.cargo,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarCargo(this.cargo)) {			
				CargoDataAccess.save(this.cargo, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.cargo,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			CargoLogicAdditional.checkCargoToSaveAfter(this.cargo,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.cargo.getIsDeleted()) {
				this.cargo=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveCargosWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Cargo.class.getSimpleName()+"-saveCargosWithConnection");connexion.begin();			
			
			CargoLogicAdditional.checkCargoToSaves(cargos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowCargos();
			
			Boolean validadoTodosCargo=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(Cargo cargoLocal:cargos) {		
				if(cargoLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				CargoLogicAdditional.updateCargoToSave(cargoLocal,this.arrDatoGeneral);
	        	
				CargoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),cargoLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarCargo(cargoLocal)) {
					CargoDataAccess.save(cargoLocal, connexion);				
				} else {
					validadoTodosCargo=false;
				}
			}
			
			if(!validadoTodosCargo) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			CargoLogicAdditional.checkCargoToSavesAfter(cargos,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowCargos();
			
			connexion.commit();		
			
			this.quitarCargosEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveCargos()throws Exception {				
		 try {	
			CargoLogicAdditional.checkCargoToSaves(cargos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosCargo=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(Cargo cargoLocal:cargos) {				
				if(cargoLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				CargoLogicAdditional.updateCargoToSave(cargoLocal,this.arrDatoGeneral);
	        	
				CargoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),cargoLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarCargo(cargoLocal)) {				
					CargoDataAccess.save(cargoLocal, connexion);				
				} else {
					validadoTodosCargo=false;
				}
			}
			
			if(!validadoTodosCargo) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			CargoLogicAdditional.checkCargoToSavesAfter(cargos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarCargosEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public CargoParameterReturnGeneral procesarAccionCargos(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<Cargo> cargos,CargoParameterReturnGeneral cargoParameterGeneral)throws Exception {
		 try {	
			CargoParameterReturnGeneral cargoReturnGeneral=new CargoParameterReturnGeneral();
	
			CargoLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,cargos,cargoParameterGeneral,cargoReturnGeneral);
			
			return cargoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public CargoParameterReturnGeneral procesarAccionCargosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<Cargo> cargos,CargoParameterReturnGeneral cargoParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Cargo.class.getSimpleName()+"-procesarAccionCargosWithConnection");connexion.begin();			
			
			CargoParameterReturnGeneral cargoReturnGeneral=new CargoParameterReturnGeneral();
	
			CargoLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,cargos,cargoParameterGeneral,cargoReturnGeneral);
			
			this.connexion.commit();
			
			return cargoReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public CargoParameterReturnGeneral procesarEventosCargos(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<Cargo> cargos,Cargo cargo,CargoParameterReturnGeneral cargoParameterGeneral,Boolean isEsNuevoCargo,ArrayList<Classe> clases)throws Exception {
		 try {	
			CargoParameterReturnGeneral cargoReturnGeneral=new CargoParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				cargoReturnGeneral.setConRecargarPropiedades(true);
			}
			
			CargoLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,cargos,cargo,cargoParameterGeneral,cargoReturnGeneral,isEsNuevoCargo,clases);
			
			return cargoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public CargoParameterReturnGeneral procesarEventosCargosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<Cargo> cargos,Cargo cargo,CargoParameterReturnGeneral cargoParameterGeneral,Boolean isEsNuevoCargo,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Cargo.class.getSimpleName()+"-procesarEventosCargosWithConnection");connexion.begin();			
			
			CargoParameterReturnGeneral cargoReturnGeneral=new CargoParameterReturnGeneral();
	
			cargoReturnGeneral.setCargo(cargo);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				cargoReturnGeneral.setConRecargarPropiedades(true);
			}
			
			CargoLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,cargos,cargo,cargoParameterGeneral,cargoReturnGeneral,isEsNuevoCargo,clases);
			
			this.connexion.commit();
			
			return cargoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public CargoParameterReturnGeneral procesarImportacionCargosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,CargoParameterReturnGeneral cargoParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Cargo.class.getSimpleName()+"-procesarImportacionCargosWithConnection");connexion.begin();			
			
			CargoParameterReturnGeneral cargoReturnGeneral=new CargoParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.cargos=new ArrayList<Cargo>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.cargo=new Cargo();
				
				
				if(conColumnasBase) {this.cargo.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.cargo.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.cargo.setcodigo(arrColumnas[iColumn++]);
				this.cargo.setnombre(arrColumnas[iColumn++]);
				this.cargo.setvalor_anticipo(Double.parseDouble(arrColumnas[iColumn++]));
				this.cargo.setporcentaje_anticipo(Double.parseDouble(arrColumnas[iColumn++]));
				this.cargo.setes_jefe(Boolean.parseBoolean(arrColumnas[iColumn++]));
				this.cargo.setes_anual(Boolean.parseBoolean(arrColumnas[iColumn++]));
				this.cargo.setporcentaje(Double.parseDouble(arrColumnas[iColumn++]));
				this.cargo.setvalor(Double.parseDouble(arrColumnas[iColumn++]));
				
				this.cargos.add(this.cargo);
			}
			
			this.saveCargos();
			
			this.connexion.commit();
			
			cargoReturnGeneral.setConRetornoEstaProcesado(true);
			cargoReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return cargoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarCargosEliminados() throws Exception {				
		
		List<Cargo> cargosAux= new ArrayList<Cargo>();
		
		for(Cargo cargo:cargos) {
			if(!cargo.getIsDeleted()) {
				cargosAux.add(cargo);
			}
		}
		
		cargos=cargosAux;
	}
	
	public void quitarCargosNulos() throws Exception {				
		
		List<Cargo> cargosAux= new ArrayList<Cargo>();
		
		for(Cargo cargo : this.cargos) {
			if(cargo==null) {
				cargosAux.add(cargo);
			}
		}
		
		//this.cargos=cargosAux;
		
		this.cargos.removeAll(cargosAux);
	}
	
	public void getSetVersionRowCargoWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(cargo.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((cargo.getIsDeleted() || (cargo.getIsChanged()&&!cargo.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=cargoDataAccess.getSetVersionRowCargo(connexion,cargo.getId());
				
				if(!cargo.getVersionRow().equals(timestamp)) {	
					cargo.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				cargo.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowCargo()throws Exception {	
		
		if(cargo.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((cargo.getIsDeleted() || (cargo.getIsChanged()&&!cargo.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=cargoDataAccess.getSetVersionRowCargo(connexion,cargo.getId());
			
			try {							
				if(!cargo.getVersionRow().equals(timestamp)) {	
					cargo.setVersionRow(timestamp);
				}
				
				cargo.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowCargosWithConnection()throws Exception {	
		if(cargos!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(Cargo cargoAux:cargos) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(cargoAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(cargoAux.getIsDeleted() || (cargoAux.getIsChanged()&&!cargoAux.getIsNew())) {
						
						timestamp=cargoDataAccess.getSetVersionRowCargo(connexion,cargoAux.getId());
						
						if(!cargo.getVersionRow().equals(timestamp)) {	
							cargoAux.setVersionRow(timestamp);
						}
								
						cargoAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowCargos()throws Exception {	
		if(cargos!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(Cargo cargoAux:cargos) {
					if(cargoAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(cargoAux.getIsDeleted() || (cargoAux.getIsChanged()&&!cargoAux.getIsNew())) {
						
						timestamp=cargoDataAccess.getSetVersionRowCargo(connexion,cargoAux.getId());
						
						if(!cargoAux.getVersionRow().equals(timestamp)) {	
							cargoAux.setVersionRow(timestamp);
						}
						
													
						cargoAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public CargoParameterReturnGeneral cargarCombosLoteForeignKeyCargoWithConnection(String finalQueryGlobalEmpresa,String finalQueryGlobalCargo,String finalQueryGlobalCuentaContable,String finalQueryGlobalNumeroPatronal,String finalQueryGlobalTipoPago_NM,String finalQueryGlobalCargoGrupo) throws Exception {
		CargoParameterReturnGeneral  cargoReturnGeneral =new CargoParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Cargo.class.getSimpleName()+"-cargarCombosLoteForeignKeyCargoWithConnection");connexion.begin();
			
			cargoReturnGeneral =new CargoParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			cargoReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Cargo> cargosForeignKey=new ArrayList<Cargo>();
			CargoLogic cargoLogic=new CargoLogic();
			cargoLogic.setConnexion(this.connexion);
			cargoLogic.getCargoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCargo.equals("NONE")) {
				cargoLogic.getTodosCargos(finalQueryGlobalCargo,new Pagination());
				cargosForeignKey=cargoLogic.getCargos();
			}

			cargoReturnGeneral.setcargosForeignKey(cargosForeignKey);


			List<CuentaContable> cuentacontablesForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontableLogic=new CuentaContableLogic();
			cuentacontableLogic.setConnexion(this.connexion);
			cuentacontableLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContable.equals("NONE")) {
				cuentacontableLogic.getTodosCuentaContables(finalQueryGlobalCuentaContable,new Pagination());
				cuentacontablesForeignKey=cuentacontableLogic.getCuentaContables();
			}

			cargoReturnGeneral.setcuentacontablesForeignKey(cuentacontablesForeignKey);


			List<NumeroPatronal> numeropatronalsForeignKey=new ArrayList<NumeroPatronal>();
			NumeroPatronalLogic numeropatronalLogic=new NumeroPatronalLogic();
			numeropatronalLogic.setConnexion(this.connexion);
			numeropatronalLogic.getNumeroPatronalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalNumeroPatronal.equals("NONE")) {
				numeropatronalLogic.getTodosNumeroPatronals(finalQueryGlobalNumeroPatronal,new Pagination());
				numeropatronalsForeignKey=numeropatronalLogic.getNumeroPatronals();
			}

			cargoReturnGeneral.setnumeropatronalsForeignKey(numeropatronalsForeignKey);


			List<TipoPago_NM> tipopago_nmsForeignKey=new ArrayList<TipoPago_NM>();
			TipoPago_NMLogic tipopago_nmLogic=new TipoPago_NMLogic();
			tipopago_nmLogic.setConnexion(this.connexion);
			tipopago_nmLogic.getTipoPago_NMDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoPago_NM.equals("NONE")) {
				tipopago_nmLogic.getTodosTipoPago_NMs(finalQueryGlobalTipoPago_NM,new Pagination());
				tipopago_nmsForeignKey=tipopago_nmLogic.getTipoPago_NMs();
			}

			cargoReturnGeneral.settipopago_nmsForeignKey(tipopago_nmsForeignKey);


			List<CargoGrupo> cargogruposForeignKey=new ArrayList<CargoGrupo>();
			CargoGrupoLogic cargogrupoLogic=new CargoGrupoLogic();
			cargogrupoLogic.setConnexion(this.connexion);
			cargogrupoLogic.getCargoGrupoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCargoGrupo.equals("NONE")) {
				cargogrupoLogic.getTodosCargoGrupos(finalQueryGlobalCargoGrupo,new Pagination());
				cargogruposForeignKey=cargogrupoLogic.getCargoGrupos();
			}

			cargoReturnGeneral.setcargogruposForeignKey(cargogruposForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return cargoReturnGeneral;
	}
	
	public CargoParameterReturnGeneral cargarCombosLoteForeignKeyCargo(String finalQueryGlobalEmpresa,String finalQueryGlobalCargo,String finalQueryGlobalCuentaContable,String finalQueryGlobalNumeroPatronal,String finalQueryGlobalTipoPago_NM,String finalQueryGlobalCargoGrupo) throws Exception {
		CargoParameterReturnGeneral  cargoReturnGeneral =new CargoParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			cargoReturnGeneral =new CargoParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			cargoReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Cargo> cargosForeignKey=new ArrayList<Cargo>();
			CargoLogic cargoLogic=new CargoLogic();
			cargoLogic.setConnexion(this.connexion);
			cargoLogic.getCargoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCargo.equals("NONE")) {
				cargoLogic.getTodosCargos(finalQueryGlobalCargo,new Pagination());
				cargosForeignKey=cargoLogic.getCargos();
			}

			cargoReturnGeneral.setcargosForeignKey(cargosForeignKey);


			List<CuentaContable> cuentacontablesForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontableLogic=new CuentaContableLogic();
			cuentacontableLogic.setConnexion(this.connexion);
			cuentacontableLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContable.equals("NONE")) {
				cuentacontableLogic.getTodosCuentaContables(finalQueryGlobalCuentaContable,new Pagination());
				cuentacontablesForeignKey=cuentacontableLogic.getCuentaContables();
			}

			cargoReturnGeneral.setcuentacontablesForeignKey(cuentacontablesForeignKey);


			List<NumeroPatronal> numeropatronalsForeignKey=new ArrayList<NumeroPatronal>();
			NumeroPatronalLogic numeropatronalLogic=new NumeroPatronalLogic();
			numeropatronalLogic.setConnexion(this.connexion);
			numeropatronalLogic.getNumeroPatronalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalNumeroPatronal.equals("NONE")) {
				numeropatronalLogic.getTodosNumeroPatronals(finalQueryGlobalNumeroPatronal,new Pagination());
				numeropatronalsForeignKey=numeropatronalLogic.getNumeroPatronals();
			}

			cargoReturnGeneral.setnumeropatronalsForeignKey(numeropatronalsForeignKey);


			List<TipoPago_NM> tipopago_nmsForeignKey=new ArrayList<TipoPago_NM>();
			TipoPago_NMLogic tipopago_nmLogic=new TipoPago_NMLogic();
			tipopago_nmLogic.setConnexion(this.connexion);
			tipopago_nmLogic.getTipoPago_NMDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoPago_NM.equals("NONE")) {
				tipopago_nmLogic.getTodosTipoPago_NMs(finalQueryGlobalTipoPago_NM,new Pagination());
				tipopago_nmsForeignKey=tipopago_nmLogic.getTipoPago_NMs();
			}

			cargoReturnGeneral.settipopago_nmsForeignKey(tipopago_nmsForeignKey);


			List<CargoGrupo> cargogruposForeignKey=new ArrayList<CargoGrupo>();
			CargoGrupoLogic cargogrupoLogic=new CargoGrupoLogic();
			cargogrupoLogic.setConnexion(this.connexion);
			cargogrupoLogic.getCargoGrupoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCargoGrupo.equals("NONE")) {
				cargogrupoLogic.getTodosCargoGrupos(finalQueryGlobalCargoGrupo,new Pagination());
				cargogruposForeignKey=cargogrupoLogic.getCargoGrupos();
			}

			cargoReturnGeneral.setcargogruposForeignKey(cargogruposForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return cargoReturnGeneral;
	}
	
	public void cargarRelacionesLoteForeignKeyCargoWithConnection() throws Exception {
		ArrayList<Classe> classes=new ArrayList<Classe>();		
		
		
			AsistenciaMensualLogic asistenciamensualLogic=new AsistenciaMensualLogic();
			EmpleadoEstructuraLogic empleadoestructuraLogic=new EmpleadoEstructuraLogic();
			EmpleadoLogic empleadoLogic=new EmpleadoLogic();
			CargoLogic cargoLogic=new CargoLogic();
		
		try {
			
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Cargo.class.getSimpleName()+"-cargarRelacionesLoteForeignKeyCargoWithConnection");connexion.begin();
			
			
			classes.add(new Classe(AsistenciaMensual.class));
			classes.add(new Classe(EmpleadoEstructura.class));
			classes.add(new Classe(Empleado.class));
			classes.add(new Classe(Cargo.class));
											
			

			asistenciamensualLogic.setConnexion(this.getConnexion());
			asistenciamensualLogic.setDatosCliente(this.datosCliente);
			asistenciamensualLogic.setIsConRefrescarForeignKeys(true);

			empleadoestructuraLogic.setConnexion(this.getConnexion());
			empleadoestructuraLogic.setDatosCliente(this.datosCliente);
			empleadoestructuraLogic.setIsConRefrescarForeignKeys(true);

			empleadoLogic.setConnexion(this.getConnexion());
			empleadoLogic.setDatosCliente(this.datosCliente);
			empleadoLogic.setIsConRefrescarForeignKeys(true);

			cargoLogic.setConnexion(this.getConnexion());
			cargoLogic.setDatosCliente(this.datosCliente);
			cargoLogic.setIsConRefrescarForeignKeys(true);
			
			this.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
			
			for(Cargo cargo:this.cargos) {
				

				classes=new ArrayList<Classe>();
				classes=AsistenciaMensualConstantesFunciones.getClassesForeignKeysOfAsistenciaMensual(new ArrayList<Classe>(),DeepLoadType.NONE);

				asistenciamensualLogic.setAsistenciaMensuals(cargo.asistenciamensuals);
				asistenciamensualLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=EmpleadoEstructuraConstantesFunciones.getClassesForeignKeysOfEmpleadoEstructura(new ArrayList<Classe>(),DeepLoadType.NONE);

				empleadoestructuraLogic.setEmpleadoEstructuras(cargo.empleadoestructuras);
				empleadoestructuraLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=EmpleadoConstantesFunciones.getClassesForeignKeysOfEmpleado(new ArrayList<Classe>(),DeepLoadType.NONE);

				empleadoLogic.setEmpleados(cargo.empleados);
				empleadoLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=CargoConstantesFunciones.getClassesForeignKeysOfCargo(new ArrayList<Classe>(),DeepLoadType.NONE);

				cargoLogic.setCargos(cargo.cargos);
				cargoLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
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
	
	public void deepLoad(Cargo cargo,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			CargoLogicAdditional.updateCargoToGet(cargo,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		cargo.setEmpresa(cargoDataAccess.getEmpresa(connexion,cargo));
		cargo.setCargo(cargoDataAccess.getCargo(connexion,cargo));
		cargo.setCuentaContable(cargoDataAccess.getCuentaContable(connexion,cargo));
		cargo.setNumeroPatronal(cargoDataAccess.getNumeroPatronal(connexion,cargo));
		cargo.setTipoPago_NM(cargoDataAccess.getTipoPago_NM(connexion,cargo));
		cargo.setCargoGrupo(cargoDataAccess.getCargoGrupo(connexion,cargo));
		cargo.setAsistenciaMensuals(cargoDataAccess.getAsistenciaMensuals(connexion,cargo));
		cargo.setEmpleadoEstructuras(cargoDataAccess.getEmpleadoEstructuras(connexion,cargo));
		cargo.setEmpleados(cargoDataAccess.getEmpleados(connexion,cargo));
		cargo.setCargos(cargoDataAccess.getCargos(connexion,cargo));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				cargo.setEmpresa(cargoDataAccess.getEmpresa(connexion,cargo));
				continue;
			}

			if(clas.clas.equals(Cargo.class)) {
				cargo.setCargo(cargoDataAccess.getCargo(connexion,cargo));
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				cargo.setCuentaContable(cargoDataAccess.getCuentaContable(connexion,cargo));
				continue;
			}

			if(clas.clas.equals(NumeroPatronal.class)) {
				cargo.setNumeroPatronal(cargoDataAccess.getNumeroPatronal(connexion,cargo));
				continue;
			}

			if(clas.clas.equals(TipoPago_NM.class)) {
				cargo.setTipoPago_NM(cargoDataAccess.getTipoPago_NM(connexion,cargo));
				continue;
			}

			if(clas.clas.equals(CargoGrupo.class)) {
				cargo.setCargoGrupo(cargoDataAccess.getCargoGrupo(connexion,cargo));
				continue;
			}

			if(clas.clas.equals(AsistenciaMensual.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				cargo.setAsistenciaMensuals(cargoDataAccess.getAsistenciaMensuals(connexion,cargo));

				if(this.isConDeep) {
					AsistenciaMensualLogic asistenciamensualLogic= new AsistenciaMensualLogic(this.connexion);
					asistenciamensualLogic.setAsistenciaMensuals(cargo.getAsistenciaMensuals());
					ArrayList<Classe> classesLocal=AsistenciaMensualConstantesFunciones.getClassesForeignKeysOfAsistenciaMensual(new ArrayList<Classe>(),DeepLoadType.NONE);
					asistenciamensualLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					AsistenciaMensualConstantesFunciones.refrescarForeignKeysDescripcionesAsistenciaMensual(asistenciamensualLogic.getAsistenciaMensuals());
					cargo.setAsistenciaMensuals(asistenciamensualLogic.getAsistenciaMensuals());
				}

				continue;
			}

			if(clas.clas.equals(EmpleadoEstructura.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				cargo.setEmpleadoEstructuras(cargoDataAccess.getEmpleadoEstructuras(connexion,cargo));

				if(this.isConDeep) {
					EmpleadoEstructuraLogic empleadoestructuraLogic= new EmpleadoEstructuraLogic(this.connexion);
					empleadoestructuraLogic.setEmpleadoEstructuras(cargo.getEmpleadoEstructuras());
					ArrayList<Classe> classesLocal=EmpleadoEstructuraConstantesFunciones.getClassesForeignKeysOfEmpleadoEstructura(new ArrayList<Classe>(),DeepLoadType.NONE);
					empleadoestructuraLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					EmpleadoEstructuraConstantesFunciones.refrescarForeignKeysDescripcionesEmpleadoEstructura(empleadoestructuraLogic.getEmpleadoEstructuras());
					cargo.setEmpleadoEstructuras(empleadoestructuraLogic.getEmpleadoEstructuras());
				}

				continue;
			}

			if(clas.clas.equals(Empleado.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				cargo.setEmpleados(cargoDataAccess.getEmpleados(connexion,cargo));

				if(this.isConDeep) {
					EmpleadoLogic empleadoLogic= new EmpleadoLogic(this.connexion);
					empleadoLogic.setEmpleados(cargo.getEmpleados());
					ArrayList<Classe> classesLocal=EmpleadoConstantesFunciones.getClassesForeignKeysOfEmpleado(new ArrayList<Classe>(),DeepLoadType.NONE);
					empleadoLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					EmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesEmpleado(empleadoLogic.getEmpleados());
					cargo.setEmpleados(empleadoLogic.getEmpleados());
				}

				continue;
			}

			if(clas.clas.equals(Cargo.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				cargo.setCargos(cargoDataAccess.getCargos(connexion,cargo));

				if(this.isConDeep) {
					CargoLogic cargoLogic= new CargoLogic(this.connexion);
					cargoLogic.setCargos(cargo.getCargos());
					ArrayList<Classe> classesLocal=CargoConstantesFunciones.getClassesForeignKeysOfCargo(new ArrayList<Classe>(),DeepLoadType.NONE);
					cargoLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					CargoConstantesFunciones.refrescarForeignKeysDescripcionesCargo(cargoLogic.getCargos());
					cargo.setCargos(cargoLogic.getCargos());
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
			cargo.setEmpresa(cargoDataAccess.getEmpresa(connexion,cargo));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Cargo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cargo.setCargo(cargoDataAccess.getCargo(connexion,cargo));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cargo.setCuentaContable(cargoDataAccess.getCuentaContable(connexion,cargo));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(NumeroPatronal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cargo.setNumeroPatronal(cargoDataAccess.getNumeroPatronal(connexion,cargo));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoPago_NM.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cargo.setTipoPago_NM(cargoDataAccess.getTipoPago_NM(connexion,cargo));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CargoGrupo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cargo.setCargoGrupo(cargoDataAccess.getCargoGrupo(connexion,cargo));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(AsistenciaMensual.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(AsistenciaMensual.class));
			cargo.setAsistenciaMensuals(cargoDataAccess.getAsistenciaMensuals(connexion,cargo));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(EmpleadoEstructura.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(EmpleadoEstructura.class));
			cargo.setEmpleadoEstructuras(cargoDataAccess.getEmpleadoEstructuras(connexion,cargo));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Empleado.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(Empleado.class));
			cargo.setEmpleados(cargoDataAccess.getEmpleados(connexion,cargo));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Cargo.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(Cargo.class));
			cargo.setCargos(cargoDataAccess.getCargos(connexion,cargo));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		cargo.setEmpresa(cargoDataAccess.getEmpresa(connexion,cargo));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(cargo.getEmpresa(),isDeep,deepLoadType,clases);
				
		cargo.setCargo(cargoDataAccess.getCargo(connexion,cargo));
		CargoLogic cargoLogic= new CargoLogic(connexion);
		cargoLogic.deepLoad(cargo.getCargo(),isDeep,deepLoadType,clases);
				
		cargo.setCuentaContable(cargoDataAccess.getCuentaContable(connexion,cargo));
		CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
		cuentacontableLogic.deepLoad(cargo.getCuentaContable(),isDeep,deepLoadType,clases);
				
		cargo.setNumeroPatronal(cargoDataAccess.getNumeroPatronal(connexion,cargo));
		NumeroPatronalLogic numeropatronalLogic= new NumeroPatronalLogic(connexion);
		numeropatronalLogic.deepLoad(cargo.getNumeroPatronal(),isDeep,deepLoadType,clases);
				
		cargo.setTipoPago_NM(cargoDataAccess.getTipoPago_NM(connexion,cargo));
		TipoPago_NMLogic tipopago_nmLogic= new TipoPago_NMLogic(connexion);
		tipopago_nmLogic.deepLoad(cargo.getTipoPago_NM(),isDeep,deepLoadType,clases);
				
		cargo.setCargoGrupo(cargoDataAccess.getCargoGrupo(connexion,cargo));
		CargoGrupoLogic cargogrupoLogic= new CargoGrupoLogic(connexion);
		cargogrupoLogic.deepLoad(cargo.getCargoGrupo(),isDeep,deepLoadType,clases);
				

		cargo.setAsistenciaMensuals(cargoDataAccess.getAsistenciaMensuals(connexion,cargo));

		for(AsistenciaMensual asistenciamensual:cargo.getAsistenciaMensuals()) {
			AsistenciaMensualLogic asistenciamensualLogic= new AsistenciaMensualLogic(connexion);
			asistenciamensualLogic.deepLoad(asistenciamensual,isDeep,deepLoadType,clases);
		}

		cargo.setEmpleadoEstructuras(cargoDataAccess.getEmpleadoEstructuras(connexion,cargo));

		for(EmpleadoEstructura empleadoestructura:cargo.getEmpleadoEstructuras()) {
			EmpleadoEstructuraLogic empleadoestructuraLogic= new EmpleadoEstructuraLogic(connexion);
			empleadoestructuraLogic.deepLoad(empleadoestructura,isDeep,deepLoadType,clases);
		}

		cargo.setEmpleados(cargoDataAccess.getEmpleados(connexion,cargo));

		for(Empleado empleado:cargo.getEmpleados()) {
			EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
			empleadoLogic.deepLoad(empleado,isDeep,deepLoadType,clases);
		}

		cargo.setCargos(cargoDataAccess.getCargos(connexion,cargo));

		for(Cargo cargoRecursivo:cargo.getCargos()) {
			CargoLogic cargoRecursivoLogic= new CargoLogic(connexion);
			cargoRecursivoLogic.deepLoad(cargoRecursivo,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				cargo.setEmpresa(cargoDataAccess.getEmpresa(connexion,cargo));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(cargo.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Cargo.class)) {
				cargo.setCargo(cargoDataAccess.getCargo(connexion,cargo));
				CargoLogic cargoLogic= new CargoLogic(connexion);
				cargoLogic.deepLoad(cargo.getCargo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				cargo.setCuentaContable(cargoDataAccess.getCuentaContable(connexion,cargo));
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepLoad(cargo.getCuentaContable(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(NumeroPatronal.class)) {
				cargo.setNumeroPatronal(cargoDataAccess.getNumeroPatronal(connexion,cargo));
				NumeroPatronalLogic numeropatronalLogic= new NumeroPatronalLogic(connexion);
				numeropatronalLogic.deepLoad(cargo.getNumeroPatronal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoPago_NM.class)) {
				cargo.setTipoPago_NM(cargoDataAccess.getTipoPago_NM(connexion,cargo));
				TipoPago_NMLogic tipopago_nmLogic= new TipoPago_NMLogic(connexion);
				tipopago_nmLogic.deepLoad(cargo.getTipoPago_NM(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CargoGrupo.class)) {
				cargo.setCargoGrupo(cargoDataAccess.getCargoGrupo(connexion,cargo));
				CargoGrupoLogic cargogrupoLogic= new CargoGrupoLogic(connexion);
				cargogrupoLogic.deepLoad(cargo.getCargoGrupo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(AsistenciaMensual.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				cargo.setAsistenciaMensuals(cargoDataAccess.getAsistenciaMensuals(connexion,cargo));

				for(AsistenciaMensual asistenciamensual:cargo.getAsistenciaMensuals()) {
					AsistenciaMensualLogic asistenciamensualLogic= new AsistenciaMensualLogic(connexion);
					asistenciamensualLogic.deepLoad(asistenciamensual,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(EmpleadoEstructura.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				cargo.setEmpleadoEstructuras(cargoDataAccess.getEmpleadoEstructuras(connexion,cargo));

				for(EmpleadoEstructura empleadoestructura:cargo.getEmpleadoEstructuras()) {
					EmpleadoEstructuraLogic empleadoestructuraLogic= new EmpleadoEstructuraLogic(connexion);
					empleadoestructuraLogic.deepLoad(empleadoestructura,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(Empleado.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				cargo.setEmpleados(cargoDataAccess.getEmpleados(connexion,cargo));

				for(Empleado empleado:cargo.getEmpleados()) {
					EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
					empleadoLogic.deepLoad(empleado,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(Cargo.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				cargo.setCargos(cargoDataAccess.getCargos(connexion,cargo));

				for(Cargo cargoRecursivo:cargo.getCargos()) {
					CargoLogic cargoRecursivoLogic= new CargoLogic(connexion);
					cargoRecursivoLogic.deepLoad(cargoRecursivo,isDeep,deepLoadType,clases);
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
			cargo.setEmpresa(cargoDataAccess.getEmpresa(connexion,cargo));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(cargo.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Cargo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cargo.setCargo(cargoDataAccess.getCargo(connexion,cargo));
			CargoLogic cargoLogic= new CargoLogic(connexion);
			cargoLogic.deepLoad(cargo.getCargo(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cargo.setCuentaContable(cargoDataAccess.getCuentaContable(connexion,cargo));
			CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
			cuentacontableLogic.deepLoad(cargo.getCuentaContable(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(NumeroPatronal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cargo.setNumeroPatronal(cargoDataAccess.getNumeroPatronal(connexion,cargo));
			NumeroPatronalLogic numeropatronalLogic= new NumeroPatronalLogic(connexion);
			numeropatronalLogic.deepLoad(cargo.getNumeroPatronal(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoPago_NM.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cargo.setTipoPago_NM(cargoDataAccess.getTipoPago_NM(connexion,cargo));
			TipoPago_NMLogic tipopago_nmLogic= new TipoPago_NMLogic(connexion);
			tipopago_nmLogic.deepLoad(cargo.getTipoPago_NM(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(CargoGrupo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cargo.setCargoGrupo(cargoDataAccess.getCargoGrupo(connexion,cargo));
			CargoGrupoLogic cargogrupoLogic= new CargoGrupoLogic(connexion);
			cargogrupoLogic.deepLoad(cargo.getCargoGrupo(),isDeep,deepLoadType,clases);
				
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(AsistenciaMensual.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(AsistenciaMensual.class));
			cargo.setAsistenciaMensuals(cargoDataAccess.getAsistenciaMensuals(connexion,cargo));

			for(AsistenciaMensual asistenciamensual:cargo.getAsistenciaMensuals()) {
				AsistenciaMensualLogic asistenciamensualLogic= new AsistenciaMensualLogic(connexion);
				asistenciamensualLogic.deepLoad(asistenciamensual,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(EmpleadoEstructura.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(EmpleadoEstructura.class));
			cargo.setEmpleadoEstructuras(cargoDataAccess.getEmpleadoEstructuras(connexion,cargo));

			for(EmpleadoEstructura empleadoestructura:cargo.getEmpleadoEstructuras()) {
				EmpleadoEstructuraLogic empleadoestructuraLogic= new EmpleadoEstructuraLogic(connexion);
				empleadoestructuraLogic.deepLoad(empleadoestructura,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Empleado.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(Empleado.class));
			cargo.setEmpleados(cargoDataAccess.getEmpleados(connexion,cargo));

			for(Empleado empleado:cargo.getEmpleados()) {
				EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
				empleadoLogic.deepLoad(empleado,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Cargo.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(Cargo.class));
			cargo.setCargos(cargoDataAccess.getCargos(connexion,cargo));

			for(Cargo cargoRecursivo:cargo.getCargos()) {
				CargoLogic cargoRecursivoLogic= new CargoLogic(connexion);
				cargoRecursivoLogic.deepLoad(cargoRecursivo,isDeep,deepLoadType,clases);
			}
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(Cargo cargo,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			CargoLogicAdditional.updateCargoToSave(cargo,this.arrDatoGeneral);
			
CargoDataAccess.save(cargo, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(cargo.getEmpresa(),connexion);

		CargoDataAccess.save(cargo.getCargo(),connexion);

		CuentaContableDataAccess.save(cargo.getCuentaContable(),connexion);

		NumeroPatronalDataAccess.save(cargo.getNumeroPatronal(),connexion);

		TipoPago_NMDataAccess.save(cargo.getTipoPago_NM(),connexion);

		CargoGrupoDataAccess.save(cargo.getCargoGrupo(),connexion);

		for(AsistenciaMensual asistenciamensual:cargo.getAsistenciaMensuals()) {
			asistenciamensual.setid_cargo(cargo.getId());
			AsistenciaMensualDataAccess.save(asistenciamensual,connexion);
		}

		for(EmpleadoEstructura empleadoestructura:cargo.getEmpleadoEstructuras()) {
			empleadoestructura.setid_cargo(cargo.getId());
			EmpleadoEstructuraDataAccess.save(empleadoestructura,connexion);
		}

		for(Empleado empleado:cargo.getEmpleados()) {
			empleado.setid_cargo(cargo.getId());
			EmpleadoDataAccess.save(empleado,connexion);
		}

		for(Cargo cargoRecursivo:cargo.getCargos()) {
			cargoRecursivo.setid_cargo(cargo.getId());
			CargoDataAccess.save(cargoRecursivo,connexion);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(cargo.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(Cargo.class)) {
				CargoDataAccess.save(cargo.getCargo(),connexion);
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(cargo.getCuentaContable(),connexion);
				continue;
			}

			if(clas.clas.equals(NumeroPatronal.class)) {
				NumeroPatronalDataAccess.save(cargo.getNumeroPatronal(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoPago_NM.class)) {
				TipoPago_NMDataAccess.save(cargo.getTipoPago_NM(),connexion);
				continue;
			}

			if(clas.clas.equals(CargoGrupo.class)) {
				CargoGrupoDataAccess.save(cargo.getCargoGrupo(),connexion);
				continue;
			}


			if(clas.clas.equals(AsistenciaMensual.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(AsistenciaMensual asistenciamensual:cargo.getAsistenciaMensuals()) {
					asistenciamensual.setid_cargo(cargo.getId());
					AsistenciaMensualDataAccess.save(asistenciamensual,connexion);
				}
				continue;
			}

			if(clas.clas.equals(EmpleadoEstructura.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(EmpleadoEstructura empleadoestructura:cargo.getEmpleadoEstructuras()) {
					empleadoestructura.setid_cargo(cargo.getId());
					EmpleadoEstructuraDataAccess.save(empleadoestructura,connexion);
				}
				continue;
			}

			if(clas.clas.equals(Empleado.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(Empleado empleado:cargo.getEmpleados()) {
					empleado.setid_cargo(cargo.getId());
					EmpleadoDataAccess.save(empleado,connexion);
				}
				continue;
			}

			if(clas.clas.equals(Cargo.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(Cargo cargoRecursivo:cargo.getCargos()) {
					cargoRecursivo.setid_cargo(cargo.getId());
					CargoDataAccess.save(cargoRecursivo,connexion);
				}
				continue;
			}
		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(cargo.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(cargo.getEmpresa(),isDeep,deepLoadType,clases);
				

		CargoDataAccess.save(cargo.getCargo(),connexion);
		CargoLogic cargoLogic= new CargoLogic(connexion);
		cargoLogic.deepLoad(cargo.getCargo(),isDeep,deepLoadType,clases);
				

		CuentaContableDataAccess.save(cargo.getCuentaContable(),connexion);
		CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
		cuentacontableLogic.deepLoad(cargo.getCuentaContable(),isDeep,deepLoadType,clases);
				

		NumeroPatronalDataAccess.save(cargo.getNumeroPatronal(),connexion);
		NumeroPatronalLogic numeropatronalLogic= new NumeroPatronalLogic(connexion);
		numeropatronalLogic.deepLoad(cargo.getNumeroPatronal(),isDeep,deepLoadType,clases);
				

		TipoPago_NMDataAccess.save(cargo.getTipoPago_NM(),connexion);
		TipoPago_NMLogic tipopago_nmLogic= new TipoPago_NMLogic(connexion);
		tipopago_nmLogic.deepLoad(cargo.getTipoPago_NM(),isDeep,deepLoadType,clases);
				

		CargoGrupoDataAccess.save(cargo.getCargoGrupo(),connexion);
		CargoGrupoLogic cargogrupoLogic= new CargoGrupoLogic(connexion);
		cargogrupoLogic.deepLoad(cargo.getCargoGrupo(),isDeep,deepLoadType,clases);
				

		for(AsistenciaMensual asistenciamensual:cargo.getAsistenciaMensuals()) {
			AsistenciaMensualLogic asistenciamensualLogic= new AsistenciaMensualLogic(connexion);
			asistenciamensual.setid_cargo(cargo.getId());
			AsistenciaMensualDataAccess.save(asistenciamensual,connexion);
			asistenciamensualLogic.deepSave(asistenciamensual,isDeep,deepLoadType,clases);
		}

		for(EmpleadoEstructura empleadoestructura:cargo.getEmpleadoEstructuras()) {
			EmpleadoEstructuraLogic empleadoestructuraLogic= new EmpleadoEstructuraLogic(connexion);
			empleadoestructura.setid_cargo(cargo.getId());
			EmpleadoEstructuraDataAccess.save(empleadoestructura,connexion);
			empleadoestructuraLogic.deepSave(empleadoestructura,isDeep,deepLoadType,clases);
		}

		for(Empleado empleado:cargo.getEmpleados()) {
			EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
			empleado.setid_cargo(cargo.getId());
			EmpleadoDataAccess.save(empleado,connexion);
			empleadoLogic.deepSave(empleado,isDeep,deepLoadType,clases);
		}

		for(Cargo cargoRecursivo:cargo.getCargos()) {
			CargoLogic cargoRecursivoLogic= new CargoLogic(connexion);
			cargoRecursivo.setid_cargo(cargo.getId());
			CargoDataAccess.save(cargoRecursivo,connexion);
			cargoRecursivoLogic.deepSave(cargoRecursivo,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(cargo.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(cargo.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Cargo.class)) {
				CargoDataAccess.save(cargo.getCargo(),connexion);
				CargoLogic cargoLogic= new CargoLogic(connexion);
				cargoLogic.deepSave(cargo.getCargo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(cargo.getCuentaContable(),connexion);
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepSave(cargo.getCuentaContable(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(NumeroPatronal.class)) {
				NumeroPatronalDataAccess.save(cargo.getNumeroPatronal(),connexion);
				NumeroPatronalLogic numeropatronalLogic= new NumeroPatronalLogic(connexion);
				numeropatronalLogic.deepSave(cargo.getNumeroPatronal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoPago_NM.class)) {
				TipoPago_NMDataAccess.save(cargo.getTipoPago_NM(),connexion);
				TipoPago_NMLogic tipopago_nmLogic= new TipoPago_NMLogic(connexion);
				tipopago_nmLogic.deepSave(cargo.getTipoPago_NM(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CargoGrupo.class)) {
				CargoGrupoDataAccess.save(cargo.getCargoGrupo(),connexion);
				CargoGrupoLogic cargogrupoLogic= new CargoGrupoLogic(connexion);
				cargogrupoLogic.deepSave(cargo.getCargoGrupo(),isDeep,deepLoadType,clases);				
				continue;
			}


			if(clas.clas.equals(AsistenciaMensual.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(AsistenciaMensual asistenciamensual:cargo.getAsistenciaMensuals()) {
					AsistenciaMensualLogic asistenciamensualLogic= new AsistenciaMensualLogic(connexion);
					asistenciamensual.setid_cargo(cargo.getId());
					AsistenciaMensualDataAccess.save(asistenciamensual,connexion);
					asistenciamensualLogic.deepSave(asistenciamensual,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(EmpleadoEstructura.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(EmpleadoEstructura empleadoestructura:cargo.getEmpleadoEstructuras()) {
					EmpleadoEstructuraLogic empleadoestructuraLogic= new EmpleadoEstructuraLogic(connexion);
					empleadoestructura.setid_cargo(cargo.getId());
					EmpleadoEstructuraDataAccess.save(empleadoestructura,connexion);
					empleadoestructuraLogic.deepSave(empleadoestructura,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(Empleado.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(Empleado empleado:cargo.getEmpleados()) {
					EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
					empleado.setid_cargo(cargo.getId());
					EmpleadoDataAccess.save(empleado,connexion);
					empleadoLogic.deepSave(empleado,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(Cargo.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(Cargo cargoRecursivo:cargo.getCargos()) {
					CargoLogic cargoRecursivoLogic= new CargoLogic(connexion);
					cargoRecursivo.setid_cargo(cargo.getId());
					CargoDataAccess.save(cargoRecursivo,connexion);
					cargoRecursivoLogic.deepSave(cargoRecursivo,isDeep,deepLoadType,clases);
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
			this.getNewConnexionToDeep(Cargo.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(cargo,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				CargoConstantesFunciones.refrescarForeignKeysDescripcionesCargo(cargo);
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
			this.deepLoad(this.cargo,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				CargoConstantesFunciones.refrescarForeignKeysDescripcionesCargo(this.cargo);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(Cargo.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(cargos!=null) {
				for(Cargo cargo:cargos) {
					this.deepLoad(cargo,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					CargoConstantesFunciones.refrescarForeignKeysDescripcionesCargo(cargos);
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
			if(cargos!=null) {
				for(Cargo cargo:cargos) {
					this.deepLoad(cargo,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					CargoConstantesFunciones.refrescarForeignKeysDescripcionesCargo(cargos);
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
			this.getNewConnexionToDeep(Cargo.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(cargo,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(Cargo.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(cargos!=null) {
				for(Cargo cargo:cargos) {
					this.deepSave(cargo,isDeep,deepLoadType,clases);
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
			if(cargos!=null) {
				for(Cargo cargo:cargos) {
					this.deepSave(cargo,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getCargosFK_IdCargoWithConnection(String sFinalQuery,Pagination pagination,Long id_cargo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Cargo.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCargo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCargo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cargo,CargoConstantesFunciones.IDCARGO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCargo);

			CargoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCargo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			cargos=cargoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CargoConstantesFunciones.refrescarForeignKeysDescripcionesCargo(this.cargos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getCargosFK_IdCargo(String sFinalQuery,Pagination pagination,Long id_cargo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCargo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCargo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cargo,CargoConstantesFunciones.IDCARGO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCargo);

			CargoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCargo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			cargos=cargoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CargoConstantesFunciones.refrescarForeignKeysDescripcionesCargo(this.cargos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getCargosFK_IdCargoGrupoWithConnection(String sFinalQuery,Pagination pagination,Long id_cargo_grupo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Cargo.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCargoGrupo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCargoGrupo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cargo_grupo,CargoConstantesFunciones.IDCARGOGRUPO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCargoGrupo);

			CargoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCargoGrupo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			cargos=cargoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CargoConstantesFunciones.refrescarForeignKeysDescripcionesCargo(this.cargos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getCargosFK_IdCargoGrupo(String sFinalQuery,Pagination pagination,Long id_cargo_grupo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCargoGrupo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCargoGrupo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cargo_grupo,CargoConstantesFunciones.IDCARGOGRUPO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCargoGrupo);

			CargoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCargoGrupo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			cargos=cargoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CargoConstantesFunciones.refrescarForeignKeysDescripcionesCargo(this.cargos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getCargosFK_IdCuentaContableWithConnection(String sFinalQuery,Pagination pagination,Long id_cuenta_contable)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Cargo.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContable= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContable.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable,CargoConstantesFunciones.IDCUENTACONTABLE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContable);

			CargoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContable","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			cargos=cargoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CargoConstantesFunciones.refrescarForeignKeysDescripcionesCargo(this.cargos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getCargosFK_IdCuentaContable(String sFinalQuery,Pagination pagination,Long id_cuenta_contable)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContable= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContable.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable,CargoConstantesFunciones.IDCUENTACONTABLE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContable);

			CargoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContable","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			cargos=cargoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CargoConstantesFunciones.refrescarForeignKeysDescripcionesCargo(this.cargos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getCargosFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Cargo.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,CargoConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			CargoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			cargos=cargoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CargoConstantesFunciones.refrescarForeignKeysDescripcionesCargo(this.cargos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getCargosFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,CargoConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			CargoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			cargos=cargoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CargoConstantesFunciones.refrescarForeignKeysDescripcionesCargo(this.cargos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getCargosFK_IdNumeroPatronalWithConnection(String sFinalQuery,Pagination pagination,Long id_numero_patronal)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Cargo.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidNumeroPatronal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidNumeroPatronal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_numero_patronal,CargoConstantesFunciones.IDNUMEROPATRONAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidNumeroPatronal);

			CargoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdNumeroPatronal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			cargos=cargoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CargoConstantesFunciones.refrescarForeignKeysDescripcionesCargo(this.cargos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getCargosFK_IdNumeroPatronal(String sFinalQuery,Pagination pagination,Long id_numero_patronal)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidNumeroPatronal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidNumeroPatronal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_numero_patronal,CargoConstantesFunciones.IDNUMEROPATRONAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidNumeroPatronal);

			CargoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdNumeroPatronal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			cargos=cargoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CargoConstantesFunciones.refrescarForeignKeysDescripcionesCargo(this.cargos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getCargosFK_IdTipoPago_NMWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_pago__n_m)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Cargo.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoPago_NM= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoPago_NM.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_pago__n_m,CargoConstantesFunciones.IDTIPOPAGO_NM,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoPago_NM);

			CargoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoPago_NM","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			cargos=cargoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CargoConstantesFunciones.refrescarForeignKeysDescripcionesCargo(this.cargos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getCargosFK_IdTipoPago_NM(String sFinalQuery,Pagination pagination,Long id_tipo_pago__n_m)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoPago_NM= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoPago_NM.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_pago__n_m,CargoConstantesFunciones.IDTIPOPAGO_NM,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoPago_NM);

			CargoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoPago_NM","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			cargos=cargoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CargoConstantesFunciones.refrescarForeignKeysDescripcionesCargo(this.cargos);
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
			if(CargoConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,CargoDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,Cargo cargo,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(CargoConstantesFunciones.ISCONAUDITORIA) {
				if(cargo.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,CargoDataAccess.TABLENAME, cargo.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(CargoConstantesFunciones.ISCONAUDITORIADETALLE) {
						////CargoLogic.registrarAuditoriaDetallesCargo(connexion,cargo,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(cargo.getIsDeleted()) {
					/*if(!cargo.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,CargoDataAccess.TABLENAME, cargo.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////CargoLogic.registrarAuditoriaDetallesCargo(connexion,cargo,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,CargoDataAccess.TABLENAME, cargo.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(cargo.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,CargoDataAccess.TABLENAME, cargo.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(CargoConstantesFunciones.ISCONAUDITORIADETALLE) {
						////CargoLogic.registrarAuditoriaDetallesCargo(connexion,cargo,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesCargo(Connexion connexion,Cargo cargo)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(cargo.getIsNew()||!cargo.getid_empresa().equals(cargo.getCargoOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(cargo.getCargoOriginal().getid_empresa()!=null)
				{
					strValorActual=cargo.getCargoOriginal().getid_empresa().toString();
				}
				if(cargo.getid_empresa()!=null)
				{
					strValorNuevo=cargo.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CargoConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(cargo.getIsNew()||!cargo.getid_cargo().equals(cargo.getCargoOriginal().getid_cargo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(cargo.getCargoOriginal().getid_cargo()!=null)
				{
					strValorActual=cargo.getCargoOriginal().getid_cargo().toString();
				}
				if(cargo.getid_cargo()!=null)
				{
					strValorNuevo=cargo.getid_cargo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CargoConstantesFunciones.IDCARGO,strValorActual,strValorNuevo);
			}	
			
			if(cargo.getIsNew()||!cargo.getid_cuenta_contable().equals(cargo.getCargoOriginal().getid_cuenta_contable()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(cargo.getCargoOriginal().getid_cuenta_contable()!=null)
				{
					strValorActual=cargo.getCargoOriginal().getid_cuenta_contable().toString();
				}
				if(cargo.getid_cuenta_contable()!=null)
				{
					strValorNuevo=cargo.getid_cuenta_contable().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CargoConstantesFunciones.IDCUENTACONTABLE,strValorActual,strValorNuevo);
			}	
			
			if(cargo.getIsNew()||!cargo.getid_numero_patronal().equals(cargo.getCargoOriginal().getid_numero_patronal()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(cargo.getCargoOriginal().getid_numero_patronal()!=null)
				{
					strValorActual=cargo.getCargoOriginal().getid_numero_patronal().toString();
				}
				if(cargo.getid_numero_patronal()!=null)
				{
					strValorNuevo=cargo.getid_numero_patronal().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CargoConstantesFunciones.IDNUMEROPATRONAL,strValorActual,strValorNuevo);
			}	
			
			if(cargo.getIsNew()||!cargo.getid_tipo_pago__n_m().equals(cargo.getCargoOriginal().getid_tipo_pago__n_m()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(cargo.getCargoOriginal().getid_tipo_pago__n_m()!=null)
				{
					strValorActual=cargo.getCargoOriginal().getid_tipo_pago__n_m().toString();
				}
				if(cargo.getid_tipo_pago__n_m()!=null)
				{
					strValorNuevo=cargo.getid_tipo_pago__n_m().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CargoConstantesFunciones.IDTIPOPAGO_NM,strValorActual,strValorNuevo);
			}	
			
			if(cargo.getIsNew()||!cargo.getid_cargo_grupo().equals(cargo.getCargoOriginal().getid_cargo_grupo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(cargo.getCargoOriginal().getid_cargo_grupo()!=null)
				{
					strValorActual=cargo.getCargoOriginal().getid_cargo_grupo().toString();
				}
				if(cargo.getid_cargo_grupo()!=null)
				{
					strValorNuevo=cargo.getid_cargo_grupo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CargoConstantesFunciones.IDCARGOGRUPO,strValorActual,strValorNuevo);
			}	
			
			if(cargo.getIsNew()||!cargo.getcodigo().equals(cargo.getCargoOriginal().getcodigo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(cargo.getCargoOriginal().getcodigo()!=null)
				{
					strValorActual=cargo.getCargoOriginal().getcodigo();
				}
				if(cargo.getcodigo()!=null)
				{
					strValorNuevo=cargo.getcodigo() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CargoConstantesFunciones.CODIGO,strValorActual,strValorNuevo);
			}	
			
			if(cargo.getIsNew()||!cargo.getnombre().equals(cargo.getCargoOriginal().getnombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(cargo.getCargoOriginal().getnombre()!=null)
				{
					strValorActual=cargo.getCargoOriginal().getnombre();
				}
				if(cargo.getnombre()!=null)
				{
					strValorNuevo=cargo.getnombre() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CargoConstantesFunciones.NOMBRE,strValorActual,strValorNuevo);
			}	
			
			if(cargo.getIsNew()||!cargo.getvalor_anticipo().equals(cargo.getCargoOriginal().getvalor_anticipo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(cargo.getCargoOriginal().getvalor_anticipo()!=null)
				{
					strValorActual=cargo.getCargoOriginal().getvalor_anticipo().toString();
				}
				if(cargo.getvalor_anticipo()!=null)
				{
					strValorNuevo=cargo.getvalor_anticipo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CargoConstantesFunciones.VALORANTICIPO,strValorActual,strValorNuevo);
			}	
			
			if(cargo.getIsNew()||!cargo.getporcentaje_anticipo().equals(cargo.getCargoOriginal().getporcentaje_anticipo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(cargo.getCargoOriginal().getporcentaje_anticipo()!=null)
				{
					strValorActual=cargo.getCargoOriginal().getporcentaje_anticipo().toString();
				}
				if(cargo.getporcentaje_anticipo()!=null)
				{
					strValorNuevo=cargo.getporcentaje_anticipo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CargoConstantesFunciones.PORCENTAJEANTICIPO,strValorActual,strValorNuevo);
			}	
			
			if(cargo.getIsNew()||!cargo.getes_jefe().equals(cargo.getCargoOriginal().getes_jefe()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(cargo.getCargoOriginal().getes_jefe()!=null)
				{
					strValorActual=cargo.getCargoOriginal().getes_jefe().toString();
				}
				if(cargo.getes_jefe()!=null)
				{
					strValorNuevo=cargo.getes_jefe().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CargoConstantesFunciones.ESJEFE,strValorActual,strValorNuevo);
			}	
			
			if(cargo.getIsNew()||!cargo.getes_anual().equals(cargo.getCargoOriginal().getes_anual()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(cargo.getCargoOriginal().getes_anual()!=null)
				{
					strValorActual=cargo.getCargoOriginal().getes_anual().toString();
				}
				if(cargo.getes_anual()!=null)
				{
					strValorNuevo=cargo.getes_anual().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CargoConstantesFunciones.ESANUAL,strValorActual,strValorNuevo);
			}	
			
			if(cargo.getIsNew()||!cargo.getporcentaje().equals(cargo.getCargoOriginal().getporcentaje()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(cargo.getCargoOriginal().getporcentaje()!=null)
				{
					strValorActual=cargo.getCargoOriginal().getporcentaje().toString();
				}
				if(cargo.getporcentaje()!=null)
				{
					strValorNuevo=cargo.getporcentaje().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CargoConstantesFunciones.PORCENTAJE,strValorActual,strValorNuevo);
			}	
			
			if(cargo.getIsNew()||!cargo.getvalor().equals(cargo.getCargoOriginal().getvalor()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(cargo.getCargoOriginal().getvalor()!=null)
				{
					strValorActual=cargo.getCargoOriginal().getvalor().toString();
				}
				if(cargo.getvalor()!=null)
				{
					strValorNuevo=cargo.getvalor().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CargoConstantesFunciones.VALOR,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveCargoRelacionesWithConnection(Cargo cargo,List<AsistenciaMensual> asistenciamensuals,List<EmpleadoEstructura> empleadoestructuras,List<Empleado> empleados,List<Cargo> cargos) throws Exception {

		if(!cargo.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveCargoRelacionesBase(cargo,asistenciamensuals,empleadoestructuras,empleados,cargos,true);
		}
	}

	public void saveCargoRelaciones(Cargo cargo,List<AsistenciaMensual> asistenciamensuals,List<EmpleadoEstructura> empleadoestructuras,List<Empleado> empleados,List<Cargo> cargos)throws Exception {

		if(!cargo.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveCargoRelacionesBase(cargo,asistenciamensuals,empleadoestructuras,empleados,cargos,false);
		}
	}

	public void saveCargoRelacionesBase(Cargo cargo,List<AsistenciaMensual> asistenciamensuals,List<EmpleadoEstructura> empleadoestructuras,List<Empleado> empleados,List<Cargo> cargos,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("Cargo-saveRelacionesWithConnection");}
	
			cargo.setAsistenciaMensuals(asistenciamensuals);
			cargo.setEmpleadoEstructuras(empleadoestructuras);
			cargo.setEmpleados(empleados);
			cargo.setCargos(cargos);

			this.setCargo(cargo);

			if(CargoLogicAdditional.validarSaveRelaciones(cargo,this)) {

				CargoLogicAdditional.updateRelacionesToSave(cargo,this);

				if((cargo.getIsNew()||cargo.getIsChanged())&&!cargo.getIsDeleted()) {
					this.saveCargo();
					this.saveCargoRelacionesDetalles(asistenciamensuals,empleadoestructuras,empleados,cargos);

				} else if(cargo.getIsDeleted()) {
					this.saveCargoRelacionesDetalles(asistenciamensuals,empleadoestructuras,empleados,cargos);
					this.saveCargo();
				}

				CargoLogicAdditional.updateRelacionesToSaveAfter(cargo,this);

			} else {
				throw new Exception("LOS DATOS SON INVALIDOS");
			}

			if(conConexion) {connexion.commit();}

		} catch(Exception e) {
			
			AsistenciaMensualConstantesFunciones.InicializarGeneralEntityAuxiliaresAsistenciaMensuals(asistenciamensuals,true,true);
			EmpleadoEstructuraConstantesFunciones.InicializarGeneralEntityAuxiliaresEmpleadoEstructuras(empleadoestructuras,true,true);
			EmpleadoConstantesFunciones.InicializarGeneralEntityAuxiliaresEmpleados(empleados,true,true);
			CargoConstantesFunciones.InicializarGeneralEntityAuxiliaresCargos(cargos,true,true);

			if(conConexion){connexion.rollback();}
			Funciones.manageException(logger,e);
			throw e;

		} finally {
			if(conConexion){this.closeNewConnexionToDeep();}
		}
	}
	
	
	private void saveCargoRelacionesDetalles(List<AsistenciaMensual> asistenciamensuals,List<EmpleadoEstructura> empleadoestructuras,List<Empleado> empleados,List<Cargo> cargos)throws Exception {
		try {
	

			Long idCargoActual=this.getCargo().getId();

			AsistenciaMensualLogic asistenciamensualLogic_Desde_Cargo=new AsistenciaMensualLogic();
			asistenciamensualLogic_Desde_Cargo.setAsistenciaMensuals(asistenciamensuals);

			asistenciamensualLogic_Desde_Cargo.setConnexion(this.getConnexion());
			asistenciamensualLogic_Desde_Cargo.setDatosCliente(this.datosCliente);

			for(AsistenciaMensual asistenciamensual_Desde_Cargo:asistenciamensualLogic_Desde_Cargo.getAsistenciaMensuals()) {
				asistenciamensual_Desde_Cargo.setid_cargo(idCargoActual);
			}

			asistenciamensualLogic_Desde_Cargo.saveAsistenciaMensuals();

			EmpleadoEstructuraLogic empleadoestructuraLogic_Desde_Cargo=new EmpleadoEstructuraLogic();
			empleadoestructuraLogic_Desde_Cargo.setEmpleadoEstructuras(empleadoestructuras);

			empleadoestructuraLogic_Desde_Cargo.setConnexion(this.getConnexion());
			empleadoestructuraLogic_Desde_Cargo.setDatosCliente(this.datosCliente);

			for(EmpleadoEstructura empleadoestructura_Desde_Cargo:empleadoestructuraLogic_Desde_Cargo.getEmpleadoEstructuras()) {
				empleadoestructura_Desde_Cargo.setid_cargo(idCargoActual);
			}

			empleadoestructuraLogic_Desde_Cargo.saveEmpleadoEstructuras();

			EmpleadoLogic empleadoLogic_Desde_Cargo=new EmpleadoLogic();
			empleadoLogic_Desde_Cargo.setEmpleados(empleados);

			empleadoLogic_Desde_Cargo.setConnexion(this.getConnexion());
			empleadoLogic_Desde_Cargo.setDatosCliente(this.datosCliente);

			for(Empleado empleado_Desde_Cargo:empleadoLogic_Desde_Cargo.getEmpleados()) {
				empleado_Desde_Cargo.setid_cargo(idCargoActual);

				empleadoLogic_Desde_Cargo.setEmpleado(empleado_Desde_Cargo);
				empleadoLogic_Desde_Cargo.saveEmpleado();
			}


			CargoLogic cargoLogicHijos_Desde_Cargo=new CargoLogic();
			cargoLogicHijos_Desde_Cargo.setCargos(cargos);

			cargoLogicHijos_Desde_Cargo.setConnexion(this.getConnexion());
			cargoLogicHijos_Desde_Cargo.setDatosCliente(this.datosCliente);

			for(Cargo cargoHijos_Desde_Cargo:cargoLogicHijos_Desde_Cargo.getCargos()) {
				cargoHijos_Desde_Cargo.setid_cargo(idCargoActual);

				cargoLogicHijos_Desde_Cargo.setCargo(cargoHijos_Desde_Cargo);
				cargoLogicHijos_Desde_Cargo.saveCargo();
			}


		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfCargo(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=CargoConstantesFunciones.getClassesForeignKeysOfCargo(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfCargo(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=CargoConstantesFunciones.getClassesRelationshipsOfCargo(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

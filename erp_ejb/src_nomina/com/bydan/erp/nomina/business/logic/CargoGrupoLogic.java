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
import com.bydan.erp.nomina.util.CargoGrupoConstantesFunciones;
import com.bydan.erp.nomina.util.CargoGrupoParameterReturnGeneral;
//import com.bydan.erp.nomina.util.CargoGrupoParameterGeneral;
import com.bydan.erp.nomina.business.entity.CargoGrupo;
import com.bydan.erp.nomina.business.logic.CargoGrupoLogicAdditional;
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
public class CargoGrupoLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(CargoGrupoLogic.class);
	
	protected CargoGrupoDataAccess cargogrupoDataAccess; 	
	protected CargoGrupo cargogrupo;
	protected List<CargoGrupo> cargogrupos;
	protected Object cargogrupoObject;	
	protected List<Object> cargogruposObject;
	
	public static ClassValidator<CargoGrupo> cargogrupoValidator = new ClassValidator<CargoGrupo>(CargoGrupo.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected CargoGrupoLogicAdditional cargogrupoLogicAdditional=null;
	
	public CargoGrupoLogicAdditional getCargoGrupoLogicAdditional() {
		return this.cargogrupoLogicAdditional;
	}
	
	public void setCargoGrupoLogicAdditional(CargoGrupoLogicAdditional cargogrupoLogicAdditional) {
		try {
			this.cargogrupoLogicAdditional=cargogrupoLogicAdditional;
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
	
	
	
	
	public  CargoGrupoLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.cargogrupoDataAccess = new CargoGrupoDataAccess();
			
			this.cargogrupos= new ArrayList<CargoGrupo>();
			this.cargogrupo= new CargoGrupo();
			
			this.cargogrupoObject=new Object();
			this.cargogruposObject=new ArrayList<Object>();
				
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
			
			this.cargogrupoDataAccess.setConnexionType(this.connexionType);
			this.cargogrupoDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  CargoGrupoLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.cargogrupoDataAccess = new CargoGrupoDataAccess();
			this.cargogrupos= new ArrayList<CargoGrupo>();
			this.cargogrupo= new CargoGrupo();
			this.cargogrupoObject=new Object();
			this.cargogruposObject=new ArrayList<Object>();
			
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
			
			this.cargogrupoDataAccess.setConnexionType(this.connexionType);
			this.cargogrupoDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public CargoGrupo getCargoGrupo() throws Exception {	
		CargoGrupoLogicAdditional.checkCargoGrupoToGet(cargogrupo,this.datosCliente,this.arrDatoGeneral);
		CargoGrupoLogicAdditional.updateCargoGrupoToGet(cargogrupo,this.arrDatoGeneral);
		
		return cargogrupo;
	}
		
	public void setCargoGrupo(CargoGrupo newCargoGrupo) {
		this.cargogrupo = newCargoGrupo;
	}
	
	public CargoGrupoDataAccess getCargoGrupoDataAccess() {
		return cargogrupoDataAccess;
	}
	
	public void setCargoGrupoDataAccess(CargoGrupoDataAccess newcargogrupoDataAccess) {
		this.cargogrupoDataAccess = newcargogrupoDataAccess;
	}
	
	public List<CargoGrupo> getCargoGrupos() throws Exception {		
		this.quitarCargoGruposNulos();
		
		CargoGrupoLogicAdditional.checkCargoGrupoToGets(cargogrupos,this.datosCliente,this.arrDatoGeneral);
		
		for (CargoGrupo cargogrupoLocal: cargogrupos ) {
			CargoGrupoLogicAdditional.updateCargoGrupoToGet(cargogrupoLocal,this.arrDatoGeneral);
		}
		
		return cargogrupos;
	}
	
	public void setCargoGrupos(List<CargoGrupo> newCargoGrupos) {
		this.cargogrupos = newCargoGrupos;
	}
	
	public Object getCargoGrupoObject() {	
		this.cargogrupoObject=this.cargogrupoDataAccess.getEntityObject();
		return this.cargogrupoObject;
	}
		
	public void setCargoGrupoObject(Object newCargoGrupoObject) {
		this.cargogrupoObject = newCargoGrupoObject;
	}
	
	public List<Object> getCargoGruposObject() {		
		this.cargogruposObject=this.cargogrupoDataAccess.getEntitiesObject();
		return this.cargogruposObject;
	}
		
	public void setCargoGruposObject(List<Object> newCargoGruposObject) {
		this.cargogruposObject = newCargoGruposObject;
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
		
		if(this.cargogrupoDataAccess!=null) {
			this.cargogrupoDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CargoGrupo.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			cargogrupoDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			cargogrupoDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		cargogrupo = new  CargoGrupo();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CargoGrupo.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			cargogrupo=cargogrupoDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.cargogrupo,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				CargoGrupoConstantesFunciones.refrescarForeignKeysDescripcionesCargoGrupo(this.cargogrupo);
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
		cargogrupo = new  CargoGrupo();
		  		  
        try {
			
			cargogrupo=cargogrupoDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.cargogrupo,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				CargoGrupoConstantesFunciones.refrescarForeignKeysDescripcionesCargoGrupo(this.cargogrupo);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		cargogrupo = new  CargoGrupo();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CargoGrupo.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			cargogrupo=cargogrupoDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.cargogrupo,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				CargoGrupoConstantesFunciones.refrescarForeignKeysDescripcionesCargoGrupo(this.cargogrupo);
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
		cargogrupo = new  CargoGrupo();
		  		  
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
		cargogrupo = new  CargoGrupo();
		  		  
        try {
			
			cargogrupo=cargogrupoDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.cargogrupo,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				CargoGrupoConstantesFunciones.refrescarForeignKeysDescripcionesCargoGrupo(this.cargogrupo);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		cargogrupo = new  CargoGrupo();
		  		  
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
		cargogrupo = new  CargoGrupo();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CargoGrupo.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =cargogrupoDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		cargogrupo = new  CargoGrupo();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=cargogrupoDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		cargogrupo = new  CargoGrupo();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CargoGrupo.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =cargogrupoDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		cargogrupo = new  CargoGrupo();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=cargogrupoDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		cargogrupo = new  CargoGrupo();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CargoGrupo.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =cargogrupoDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		cargogrupo = new  CargoGrupo();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=cargogrupoDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		cargogrupos = new  ArrayList<CargoGrupo>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CargoGrupo.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			CargoGrupoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cargogrupos=cargogrupoDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarCargoGrupo(cargogrupos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CargoGrupoConstantesFunciones.refrescarForeignKeysDescripcionesCargoGrupo(this.cargogrupos);
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
		cargogrupos = new  ArrayList<CargoGrupo>();
		  		  
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
		cargogrupos = new  ArrayList<CargoGrupo>();
		  		  
        try {			
			CargoGrupoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cargogrupos=cargogrupoDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarCargoGrupo(cargogrupos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CargoGrupoConstantesFunciones.refrescarForeignKeysDescripcionesCargoGrupo(this.cargogrupos);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		cargogrupos = new  ArrayList<CargoGrupo>();
		  		  
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
		cargogrupos = new  ArrayList<CargoGrupo>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CargoGrupo.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			CargoGrupoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cargogrupos=cargogrupoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarCargoGrupo(cargogrupos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CargoGrupoConstantesFunciones.refrescarForeignKeysDescripcionesCargoGrupo(this.cargogrupos);
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
		cargogrupos = new  ArrayList<CargoGrupo>();
		  		  
        try {
			CargoGrupoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cargogrupos=cargogrupoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarCargoGrupo(cargogrupos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CargoGrupoConstantesFunciones.refrescarForeignKeysDescripcionesCargoGrupo(this.cargogrupos);
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
		cargogrupos = new  ArrayList<CargoGrupo>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CargoGrupo.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			CargoGrupoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cargogrupos=cargogrupoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarCargoGrupo(cargogrupos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CargoGrupoConstantesFunciones.refrescarForeignKeysDescripcionesCargoGrupo(this.cargogrupos);
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
		cargogrupos = new  ArrayList<CargoGrupo>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			CargoGrupoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cargogrupos=cargogrupoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarCargoGrupo(cargogrupos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CargoGrupoConstantesFunciones.refrescarForeignKeysDescripcionesCargoGrupo(this.cargogrupos);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		cargogrupo = new  CargoGrupo();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CargoGrupo.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			CargoGrupoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cargogrupo=cargogrupoDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarCargoGrupo(cargogrupo);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CargoGrupoConstantesFunciones.refrescarForeignKeysDescripcionesCargoGrupo(this.cargogrupo);
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
		cargogrupo = new  CargoGrupo();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			CargoGrupoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cargogrupo=cargogrupoDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarCargoGrupo(cargogrupo);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CargoGrupoConstantesFunciones.refrescarForeignKeysDescripcionesCargoGrupo(this.cargogrupo);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		cargogrupos = new  ArrayList<CargoGrupo>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CargoGrupo.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			CargoGrupoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cargogrupos=cargogrupoDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarCargoGrupo(cargogrupos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CargoGrupoConstantesFunciones.refrescarForeignKeysDescripcionesCargoGrupo(this.cargogrupos);
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
		cargogrupos = new  ArrayList<CargoGrupo>();
		  		  
        try {
			CargoGrupoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cargogrupos=cargogrupoDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarCargoGrupo(cargogrupos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CargoGrupoConstantesFunciones.refrescarForeignKeysDescripcionesCargoGrupo(this.cargogrupos);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosCargoGruposWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		cargogrupos = new  ArrayList<CargoGrupo>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CargoGrupo.class.getSimpleName()+"-getTodosCargoGruposWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			CargoGrupoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cargogrupos=cargogrupoDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarCargoGrupo(cargogrupos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CargoGrupoConstantesFunciones.refrescarForeignKeysDescripcionesCargoGrupo(this.cargogrupos);
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
	
	public  void  getTodosCargoGrupos(String sFinalQuery,Pagination pagination)throws Exception {
		cargogrupos = new  ArrayList<CargoGrupo>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			CargoGrupoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cargogrupos=cargogrupoDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarCargoGrupo(cargogrupos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CargoGrupoConstantesFunciones.refrescarForeignKeysDescripcionesCargoGrupo(this.cargogrupos);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarCargoGrupo(CargoGrupo cargogrupo) throws Exception {
		Boolean estaValidado=false;
		
		if(cargogrupo.getIsNew() || cargogrupo.getIsChanged()) { 
			this.invalidValues = cargogrupoValidator.getInvalidValues(cargogrupo);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(cargogrupo);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarCargoGrupo(List<CargoGrupo> CargoGrupos) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(CargoGrupo cargogrupoLocal:cargogrupos) {				
			estaValidadoObjeto=this.validarGuardarCargoGrupo(cargogrupoLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarCargoGrupo(List<CargoGrupo> CargoGrupos) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarCargoGrupo(cargogrupos)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarCargoGrupo(CargoGrupo CargoGrupo) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarCargoGrupo(cargogrupo)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(CargoGrupo cargogrupo) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+cargogrupo.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=CargoGrupoConstantesFunciones.getCargoGrupoLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"cargogrupo","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(CargoGrupoConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(CargoGrupoConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveCargoGrupoWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CargoGrupo.class.getSimpleName()+"-saveCargoGrupoWithConnection");connexion.begin();			
			
			CargoGrupoLogicAdditional.checkCargoGrupoToSave(this.cargogrupo,this.datosCliente,connexion,this.arrDatoGeneral);
			
			CargoGrupoLogicAdditional.updateCargoGrupoToSave(this.cargogrupo,this.arrDatoGeneral);
			
			CargoGrupoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.cargogrupo,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowCargoGrupo();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarCargoGrupo(this.cargogrupo)) {
				CargoGrupoDataAccess.save(this.cargogrupo, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.cargogrupo,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			CargoGrupoLogicAdditional.checkCargoGrupoToSaveAfter(this.cargogrupo,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowCargoGrupo();
			
			connexion.commit();			
			
			if(this.cargogrupo.getIsDeleted()) {
				this.cargogrupo=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveCargoGrupo()throws Exception {	
		try {	
			
			CargoGrupoLogicAdditional.checkCargoGrupoToSave(this.cargogrupo,this.datosCliente,connexion,this.arrDatoGeneral);
			
			CargoGrupoLogicAdditional.updateCargoGrupoToSave(this.cargogrupo,this.arrDatoGeneral);
			
			CargoGrupoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.cargogrupo,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarCargoGrupo(this.cargogrupo)) {			
				CargoGrupoDataAccess.save(this.cargogrupo, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.cargogrupo,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			CargoGrupoLogicAdditional.checkCargoGrupoToSaveAfter(this.cargogrupo,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.cargogrupo.getIsDeleted()) {
				this.cargogrupo=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveCargoGruposWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CargoGrupo.class.getSimpleName()+"-saveCargoGruposWithConnection");connexion.begin();			
			
			CargoGrupoLogicAdditional.checkCargoGrupoToSaves(cargogrupos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowCargoGrupos();
			
			Boolean validadoTodosCargoGrupo=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(CargoGrupo cargogrupoLocal:cargogrupos) {		
				if(cargogrupoLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				CargoGrupoLogicAdditional.updateCargoGrupoToSave(cargogrupoLocal,this.arrDatoGeneral);
	        	
				CargoGrupoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),cargogrupoLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarCargoGrupo(cargogrupoLocal)) {
					CargoGrupoDataAccess.save(cargogrupoLocal, connexion);				
				} else {
					validadoTodosCargoGrupo=false;
				}
			}
			
			if(!validadoTodosCargoGrupo) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			CargoGrupoLogicAdditional.checkCargoGrupoToSavesAfter(cargogrupos,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowCargoGrupos();
			
			connexion.commit();		
			
			this.quitarCargoGruposEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveCargoGrupos()throws Exception {				
		 try {	
			CargoGrupoLogicAdditional.checkCargoGrupoToSaves(cargogrupos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosCargoGrupo=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(CargoGrupo cargogrupoLocal:cargogrupos) {				
				if(cargogrupoLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				CargoGrupoLogicAdditional.updateCargoGrupoToSave(cargogrupoLocal,this.arrDatoGeneral);
	        	
				CargoGrupoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),cargogrupoLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarCargoGrupo(cargogrupoLocal)) {				
					CargoGrupoDataAccess.save(cargogrupoLocal, connexion);				
				} else {
					validadoTodosCargoGrupo=false;
				}
			}
			
			if(!validadoTodosCargoGrupo) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			CargoGrupoLogicAdditional.checkCargoGrupoToSavesAfter(cargogrupos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarCargoGruposEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public CargoGrupoParameterReturnGeneral procesarAccionCargoGrupos(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<CargoGrupo> cargogrupos,CargoGrupoParameterReturnGeneral cargogrupoParameterGeneral)throws Exception {
		 try {	
			CargoGrupoParameterReturnGeneral cargogrupoReturnGeneral=new CargoGrupoParameterReturnGeneral();
	
			CargoGrupoLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,cargogrupos,cargogrupoParameterGeneral,cargogrupoReturnGeneral);
			
			return cargogrupoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public CargoGrupoParameterReturnGeneral procesarAccionCargoGruposWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<CargoGrupo> cargogrupos,CargoGrupoParameterReturnGeneral cargogrupoParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CargoGrupo.class.getSimpleName()+"-procesarAccionCargoGruposWithConnection");connexion.begin();			
			
			CargoGrupoParameterReturnGeneral cargogrupoReturnGeneral=new CargoGrupoParameterReturnGeneral();
	
			CargoGrupoLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,cargogrupos,cargogrupoParameterGeneral,cargogrupoReturnGeneral);
			
			this.connexion.commit();
			
			return cargogrupoReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public CargoGrupoParameterReturnGeneral procesarEventosCargoGrupos(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<CargoGrupo> cargogrupos,CargoGrupo cargogrupo,CargoGrupoParameterReturnGeneral cargogrupoParameterGeneral,Boolean isEsNuevoCargoGrupo,ArrayList<Classe> clases)throws Exception {
		 try {	
			CargoGrupoParameterReturnGeneral cargogrupoReturnGeneral=new CargoGrupoParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				cargogrupoReturnGeneral.setConRecargarPropiedades(true);
			}
			
			CargoGrupoLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,cargogrupos,cargogrupo,cargogrupoParameterGeneral,cargogrupoReturnGeneral,isEsNuevoCargoGrupo,clases);
			
			return cargogrupoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public CargoGrupoParameterReturnGeneral procesarEventosCargoGruposWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<CargoGrupo> cargogrupos,CargoGrupo cargogrupo,CargoGrupoParameterReturnGeneral cargogrupoParameterGeneral,Boolean isEsNuevoCargoGrupo,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CargoGrupo.class.getSimpleName()+"-procesarEventosCargoGruposWithConnection");connexion.begin();			
			
			CargoGrupoParameterReturnGeneral cargogrupoReturnGeneral=new CargoGrupoParameterReturnGeneral();
	
			cargogrupoReturnGeneral.setCargoGrupo(cargogrupo);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				cargogrupoReturnGeneral.setConRecargarPropiedades(true);
			}
			
			CargoGrupoLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,cargogrupos,cargogrupo,cargogrupoParameterGeneral,cargogrupoReturnGeneral,isEsNuevoCargoGrupo,clases);
			
			this.connexion.commit();
			
			return cargogrupoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public CargoGrupoParameterReturnGeneral procesarImportacionCargoGruposWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,CargoGrupoParameterReturnGeneral cargogrupoParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CargoGrupo.class.getSimpleName()+"-procesarImportacionCargoGruposWithConnection");connexion.begin();			
			
			CargoGrupoParameterReturnGeneral cargogrupoReturnGeneral=new CargoGrupoParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.cargogrupos=new ArrayList<CargoGrupo>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.cargogrupo=new CargoGrupo();
				
				
				if(conColumnasBase) {this.cargogrupo.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.cargogrupo.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.cargogrupo.setcodigo(arrColumnas[iColumn++]);
				this.cargogrupo.setnombre(arrColumnas[iColumn++]);
				
				this.cargogrupos.add(this.cargogrupo);
			}
			
			this.saveCargoGrupos();
			
			this.connexion.commit();
			
			cargogrupoReturnGeneral.setConRetornoEstaProcesado(true);
			cargogrupoReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return cargogrupoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarCargoGruposEliminados() throws Exception {				
		
		List<CargoGrupo> cargogruposAux= new ArrayList<CargoGrupo>();
		
		for(CargoGrupo cargogrupo:cargogrupos) {
			if(!cargogrupo.getIsDeleted()) {
				cargogruposAux.add(cargogrupo);
			}
		}
		
		cargogrupos=cargogruposAux;
	}
	
	public void quitarCargoGruposNulos() throws Exception {				
		
		List<CargoGrupo> cargogruposAux= new ArrayList<CargoGrupo>();
		
		for(CargoGrupo cargogrupo : this.cargogrupos) {
			if(cargogrupo==null) {
				cargogruposAux.add(cargogrupo);
			}
		}
		
		//this.cargogrupos=cargogruposAux;
		
		this.cargogrupos.removeAll(cargogruposAux);
	}
	
	public void getSetVersionRowCargoGrupoWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(cargogrupo.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((cargogrupo.getIsDeleted() || (cargogrupo.getIsChanged()&&!cargogrupo.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=cargogrupoDataAccess.getSetVersionRowCargoGrupo(connexion,cargogrupo.getId());
				
				if(!cargogrupo.getVersionRow().equals(timestamp)) {	
					cargogrupo.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				cargogrupo.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowCargoGrupo()throws Exception {	
		
		if(cargogrupo.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((cargogrupo.getIsDeleted() || (cargogrupo.getIsChanged()&&!cargogrupo.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=cargogrupoDataAccess.getSetVersionRowCargoGrupo(connexion,cargogrupo.getId());
			
			try {							
				if(!cargogrupo.getVersionRow().equals(timestamp)) {	
					cargogrupo.setVersionRow(timestamp);
				}
				
				cargogrupo.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowCargoGruposWithConnection()throws Exception {	
		if(cargogrupos!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(CargoGrupo cargogrupoAux:cargogrupos) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(cargogrupoAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(cargogrupoAux.getIsDeleted() || (cargogrupoAux.getIsChanged()&&!cargogrupoAux.getIsNew())) {
						
						timestamp=cargogrupoDataAccess.getSetVersionRowCargoGrupo(connexion,cargogrupoAux.getId());
						
						if(!cargogrupo.getVersionRow().equals(timestamp)) {	
							cargogrupoAux.setVersionRow(timestamp);
						}
								
						cargogrupoAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowCargoGrupos()throws Exception {	
		if(cargogrupos!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(CargoGrupo cargogrupoAux:cargogrupos) {
					if(cargogrupoAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(cargogrupoAux.getIsDeleted() || (cargogrupoAux.getIsChanged()&&!cargogrupoAux.getIsNew())) {
						
						timestamp=cargogrupoDataAccess.getSetVersionRowCargoGrupo(connexion,cargogrupoAux.getId());
						
						if(!cargogrupoAux.getVersionRow().equals(timestamp)) {	
							cargogrupoAux.setVersionRow(timestamp);
						}
						
													
						cargogrupoAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public CargoGrupoParameterReturnGeneral cargarCombosLoteForeignKeyCargoGrupoWithConnection(String finalQueryGlobalEmpresa) throws Exception {
		CargoGrupoParameterReturnGeneral  cargogrupoReturnGeneral =new CargoGrupoParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CargoGrupo.class.getSimpleName()+"-cargarCombosLoteForeignKeyCargoGrupoWithConnection");connexion.begin();
			
			cargogrupoReturnGeneral =new CargoGrupoParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			cargogrupoReturnGeneral.setempresasForeignKey(empresasForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return cargogrupoReturnGeneral;
	}
	
	public CargoGrupoParameterReturnGeneral cargarCombosLoteForeignKeyCargoGrupo(String finalQueryGlobalEmpresa) throws Exception {
		CargoGrupoParameterReturnGeneral  cargogrupoReturnGeneral =new CargoGrupoParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			cargogrupoReturnGeneral =new CargoGrupoParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			cargogrupoReturnGeneral.setempresasForeignKey(empresasForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return cargogrupoReturnGeneral;
	}
	
	public void cargarRelacionesLoteForeignKeyCargoGrupoWithConnection() throws Exception {
		ArrayList<Classe> classes=new ArrayList<Classe>();		
		
		
			CargoLogic cargoLogic=new CargoLogic();
		
		try {
			
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CargoGrupo.class.getSimpleName()+"-cargarRelacionesLoteForeignKeyCargoGrupoWithConnection");connexion.begin();
			
			
			classes.add(new Classe(Cargo.class));
											
			

			cargoLogic.setConnexion(this.getConnexion());
			cargoLogic.setDatosCliente(this.datosCliente);
			cargoLogic.setIsConRefrescarForeignKeys(true);
			
			this.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
			
			for(CargoGrupo cargogrupo:this.cargogrupos) {
				

				classes=new ArrayList<Classe>();
				classes=CargoConstantesFunciones.getClassesForeignKeysOfCargo(new ArrayList<Classe>(),DeepLoadType.NONE);

				cargoLogic.setCargos(cargogrupo.cargos);
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
	
	public void deepLoad(CargoGrupo cargogrupo,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			CargoGrupoLogicAdditional.updateCargoGrupoToGet(cargogrupo,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		cargogrupo.setEmpresa(cargogrupoDataAccess.getEmpresa(connexion,cargogrupo));
		cargogrupo.setCargos(cargogrupoDataAccess.getCargos(connexion,cargogrupo));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				cargogrupo.setEmpresa(cargogrupoDataAccess.getEmpresa(connexion,cargogrupo));
				continue;
			}

			if(clas.clas.equals(Cargo.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				cargogrupo.setCargos(cargogrupoDataAccess.getCargos(connexion,cargogrupo));

				if(this.isConDeep) {
					CargoLogic cargoLogic= new CargoLogic(this.connexion);
					cargoLogic.setCargos(cargogrupo.getCargos());
					ArrayList<Classe> classesLocal=CargoConstantesFunciones.getClassesForeignKeysOfCargo(new ArrayList<Classe>(),DeepLoadType.NONE);
					cargoLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					CargoConstantesFunciones.refrescarForeignKeysDescripcionesCargo(cargoLogic.getCargos());
					cargogrupo.setCargos(cargoLogic.getCargos());
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
			cargogrupo.setEmpresa(cargogrupoDataAccess.getEmpresa(connexion,cargogrupo));
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
			cargogrupo.setCargos(cargogrupoDataAccess.getCargos(connexion,cargogrupo));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		cargogrupo.setEmpresa(cargogrupoDataAccess.getEmpresa(connexion,cargogrupo));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(cargogrupo.getEmpresa(),isDeep,deepLoadType,clases);
				

		cargogrupo.setCargos(cargogrupoDataAccess.getCargos(connexion,cargogrupo));

		for(Cargo cargo:cargogrupo.getCargos()) {
			CargoLogic cargoLogic= new CargoLogic(connexion);
			cargoLogic.deepLoad(cargo,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				cargogrupo.setEmpresa(cargogrupoDataAccess.getEmpresa(connexion,cargogrupo));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(cargogrupo.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Cargo.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				cargogrupo.setCargos(cargogrupoDataAccess.getCargos(connexion,cargogrupo));

				for(Cargo cargo:cargogrupo.getCargos()) {
					CargoLogic cargoLogic= new CargoLogic(connexion);
					cargoLogic.deepLoad(cargo,isDeep,deepLoadType,clases);
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
			cargogrupo.setEmpresa(cargogrupoDataAccess.getEmpresa(connexion,cargogrupo));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(cargogrupo.getEmpresa(),isDeep,deepLoadType,clases);
				
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
			cargogrupo.setCargos(cargogrupoDataAccess.getCargos(connexion,cargogrupo));

			for(Cargo cargo:cargogrupo.getCargos()) {
				CargoLogic cargoLogic= new CargoLogic(connexion);
				cargoLogic.deepLoad(cargo,isDeep,deepLoadType,clases);
			}
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(CargoGrupo cargogrupo,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			CargoGrupoLogicAdditional.updateCargoGrupoToSave(cargogrupo,this.arrDatoGeneral);
			
CargoGrupoDataAccess.save(cargogrupo, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(cargogrupo.getEmpresa(),connexion);

		for(Cargo cargo:cargogrupo.getCargos()) {
			cargo.setid_cargo_grupo(cargogrupo.getId());
			CargoDataAccess.save(cargo,connexion);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(cargogrupo.getEmpresa(),connexion);
				continue;
			}


			if(clas.clas.equals(Cargo.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(Cargo cargo:cargogrupo.getCargos()) {
					cargo.setid_cargo_grupo(cargogrupo.getId());
					CargoDataAccess.save(cargo,connexion);
				}
				continue;
			}
		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(cargogrupo.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(cargogrupo.getEmpresa(),isDeep,deepLoadType,clases);
				

		for(Cargo cargo:cargogrupo.getCargos()) {
			CargoLogic cargoLogic= new CargoLogic(connexion);
			cargo.setid_cargo_grupo(cargogrupo.getId());
			CargoDataAccess.save(cargo,connexion);
			cargoLogic.deepSave(cargo,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(cargogrupo.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(cargogrupo.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}


			if(clas.clas.equals(Cargo.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(Cargo cargo:cargogrupo.getCargos()) {
					CargoLogic cargoLogic= new CargoLogic(connexion);
					cargo.setid_cargo_grupo(cargogrupo.getId());
					CargoDataAccess.save(cargo,connexion);
					cargoLogic.deepSave(cargo,isDeep,deepLoadType,clases);
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
			this.getNewConnexionToDeep(CargoGrupo.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(cargogrupo,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				CargoGrupoConstantesFunciones.refrescarForeignKeysDescripcionesCargoGrupo(cargogrupo);
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
			this.deepLoad(this.cargogrupo,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				CargoGrupoConstantesFunciones.refrescarForeignKeysDescripcionesCargoGrupo(this.cargogrupo);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(CargoGrupo.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(cargogrupos!=null) {
				for(CargoGrupo cargogrupo:cargogrupos) {
					this.deepLoad(cargogrupo,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					CargoGrupoConstantesFunciones.refrescarForeignKeysDescripcionesCargoGrupo(cargogrupos);
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
			if(cargogrupos!=null) {
				for(CargoGrupo cargogrupo:cargogrupos) {
					this.deepLoad(cargogrupo,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					CargoGrupoConstantesFunciones.refrescarForeignKeysDescripcionesCargoGrupo(cargogrupos);
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
			this.getNewConnexionToDeep(CargoGrupo.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(cargogrupo,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(CargoGrupo.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(cargogrupos!=null) {
				for(CargoGrupo cargogrupo:cargogrupos) {
					this.deepSave(cargogrupo,isDeep,deepLoadType,clases);
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
			if(cargogrupos!=null) {
				for(CargoGrupo cargogrupo:cargogrupos) {
					this.deepSave(cargogrupo,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getCargoGruposFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CargoGrupo.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,CargoGrupoConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			CargoGrupoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			cargogrupos=cargogrupoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CargoGrupoConstantesFunciones.refrescarForeignKeysDescripcionesCargoGrupo(this.cargogrupos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getCargoGruposFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,CargoGrupoConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			CargoGrupoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			cargogrupos=cargogrupoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CargoGrupoConstantesFunciones.refrescarForeignKeysDescripcionesCargoGrupo(this.cargogrupos);
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
			if(CargoGrupoConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,CargoGrupoDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,CargoGrupo cargogrupo,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(CargoGrupoConstantesFunciones.ISCONAUDITORIA) {
				if(cargogrupo.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,CargoGrupoDataAccess.TABLENAME, cargogrupo.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(CargoGrupoConstantesFunciones.ISCONAUDITORIADETALLE) {
						////CargoGrupoLogic.registrarAuditoriaDetallesCargoGrupo(connexion,cargogrupo,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(cargogrupo.getIsDeleted()) {
					/*if(!cargogrupo.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,CargoGrupoDataAccess.TABLENAME, cargogrupo.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////CargoGrupoLogic.registrarAuditoriaDetallesCargoGrupo(connexion,cargogrupo,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,CargoGrupoDataAccess.TABLENAME, cargogrupo.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(cargogrupo.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,CargoGrupoDataAccess.TABLENAME, cargogrupo.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(CargoGrupoConstantesFunciones.ISCONAUDITORIADETALLE) {
						////CargoGrupoLogic.registrarAuditoriaDetallesCargoGrupo(connexion,cargogrupo,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesCargoGrupo(Connexion connexion,CargoGrupo cargogrupo)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(cargogrupo.getIsNew()||!cargogrupo.getid_empresa().equals(cargogrupo.getCargoGrupoOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(cargogrupo.getCargoGrupoOriginal().getid_empresa()!=null)
				{
					strValorActual=cargogrupo.getCargoGrupoOriginal().getid_empresa().toString();
				}
				if(cargogrupo.getid_empresa()!=null)
				{
					strValorNuevo=cargogrupo.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CargoGrupoConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(cargogrupo.getIsNew()||!cargogrupo.getcodigo().equals(cargogrupo.getCargoGrupoOriginal().getcodigo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(cargogrupo.getCargoGrupoOriginal().getcodigo()!=null)
				{
					strValorActual=cargogrupo.getCargoGrupoOriginal().getcodigo();
				}
				if(cargogrupo.getcodigo()!=null)
				{
					strValorNuevo=cargogrupo.getcodigo() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CargoGrupoConstantesFunciones.CODIGO,strValorActual,strValorNuevo);
			}	
			
			if(cargogrupo.getIsNew()||!cargogrupo.getnombre().equals(cargogrupo.getCargoGrupoOriginal().getnombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(cargogrupo.getCargoGrupoOriginal().getnombre()!=null)
				{
					strValorActual=cargogrupo.getCargoGrupoOriginal().getnombre();
				}
				if(cargogrupo.getnombre()!=null)
				{
					strValorNuevo=cargogrupo.getnombre() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CargoGrupoConstantesFunciones.NOMBRE,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveCargoGrupoRelacionesWithConnection(CargoGrupo cargogrupo,List<Cargo> cargos) throws Exception {

		if(!cargogrupo.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveCargoGrupoRelacionesBase(cargogrupo,cargos,true);
		}
	}

	public void saveCargoGrupoRelaciones(CargoGrupo cargogrupo,List<Cargo> cargos)throws Exception {

		if(!cargogrupo.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveCargoGrupoRelacionesBase(cargogrupo,cargos,false);
		}
	}

	public void saveCargoGrupoRelacionesBase(CargoGrupo cargogrupo,List<Cargo> cargos,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("CargoGrupo-saveRelacionesWithConnection");}
	
			cargogrupo.setCargos(cargos);

			this.setCargoGrupo(cargogrupo);

			if(CargoGrupoLogicAdditional.validarSaveRelaciones(cargogrupo,this)) {

				CargoGrupoLogicAdditional.updateRelacionesToSave(cargogrupo,this);

				if((cargogrupo.getIsNew()||cargogrupo.getIsChanged())&&!cargogrupo.getIsDeleted()) {
					this.saveCargoGrupo();
					this.saveCargoGrupoRelacionesDetalles(cargos);

				} else if(cargogrupo.getIsDeleted()) {
					this.saveCargoGrupoRelacionesDetalles(cargos);
					this.saveCargoGrupo();
				}

				CargoGrupoLogicAdditional.updateRelacionesToSaveAfter(cargogrupo,this);

			} else {
				throw new Exception("LOS DATOS SON INVALIDOS");
			}

			if(conConexion) {connexion.commit();}

		} catch(Exception e) {
			
			CargoConstantesFunciones.InicializarGeneralEntityAuxiliaresCargos(cargos,true,true);

			if(conConexion){connexion.rollback();}
			Funciones.manageException(logger,e);
			throw e;

		} finally {
			if(conConexion){this.closeNewConnexionToDeep();}
		}
	}
	
	
	private void saveCargoGrupoRelacionesDetalles(List<Cargo> cargos)throws Exception {
		try {
	

			Long idCargoGrupoActual=this.getCargoGrupo().getId();

			CargoLogic cargoLogic_Desde_CargoGrupo=new CargoLogic();
			cargoLogic_Desde_CargoGrupo.setCargos(cargos);

			cargoLogic_Desde_CargoGrupo.setConnexion(this.getConnexion());
			cargoLogic_Desde_CargoGrupo.setDatosCliente(this.datosCliente);

			for(Cargo cargo_Desde_CargoGrupo:cargoLogic_Desde_CargoGrupo.getCargos()) {
				cargo_Desde_CargoGrupo.setid_cargo_grupo(idCargoGrupoActual);

				cargoLogic_Desde_CargoGrupo.setCargo(cargo_Desde_CargoGrupo);
				cargoLogic_Desde_CargoGrupo.saveCargo();

				Long idCargoActual=cargo_Desde_CargoGrupo.getId();

				AsistenciaMensualLogic asistenciamensualLogic_Desde_Cargo=new AsistenciaMensualLogic();

				if(cargo_Desde_CargoGrupo.getAsistenciaMensuals()==null){
					cargo_Desde_CargoGrupo.setAsistenciaMensuals(new ArrayList<AsistenciaMensual>());
				}

				asistenciamensualLogic_Desde_Cargo.setAsistenciaMensuals(cargo_Desde_CargoGrupo.getAsistenciaMensuals());

				asistenciamensualLogic_Desde_Cargo.setConnexion(this.getConnexion());
				asistenciamensualLogic_Desde_Cargo.setDatosCliente(this.datosCliente);

				for(AsistenciaMensual asistenciamensual_Desde_Cargo:asistenciamensualLogic_Desde_Cargo.getAsistenciaMensuals()) {
					asistenciamensual_Desde_Cargo.setid_cargo(idCargoActual);
				}

				asistenciamensualLogic_Desde_Cargo.saveAsistenciaMensuals();

				EmpleadoEstructuraLogic empleadoestructuraLogic_Desde_Cargo=new EmpleadoEstructuraLogic();

				if(cargo_Desde_CargoGrupo.getEmpleadoEstructuras()==null){
					cargo_Desde_CargoGrupo.setEmpleadoEstructuras(new ArrayList<EmpleadoEstructura>());
				}

				empleadoestructuraLogic_Desde_Cargo.setEmpleadoEstructuras(cargo_Desde_CargoGrupo.getEmpleadoEstructuras());

				empleadoestructuraLogic_Desde_Cargo.setConnexion(this.getConnexion());
				empleadoestructuraLogic_Desde_Cargo.setDatosCliente(this.datosCliente);

				for(EmpleadoEstructura empleadoestructura_Desde_Cargo:empleadoestructuraLogic_Desde_Cargo.getEmpleadoEstructuras()) {
					empleadoestructura_Desde_Cargo.setid_cargo(idCargoActual);
				}

				empleadoestructuraLogic_Desde_Cargo.saveEmpleadoEstructuras();

				EmpleadoLogic empleadoLogic_Desde_Cargo=new EmpleadoLogic();

				if(cargo_Desde_CargoGrupo.getEmpleados()==null){
					cargo_Desde_CargoGrupo.setEmpleados(new ArrayList<Empleado>());
				}

				empleadoLogic_Desde_Cargo.setEmpleados(cargo_Desde_CargoGrupo.getEmpleados());

				empleadoLogic_Desde_Cargo.setConnexion(this.getConnexion());
				empleadoLogic_Desde_Cargo.setDatosCliente(this.datosCliente);

				for(Empleado empleado_Desde_Cargo:empleadoLogic_Desde_Cargo.getEmpleados()) {
					empleado_Desde_Cargo.setid_cargo(idCargoActual);

					empleadoLogic_Desde_Cargo.setEmpleado(empleado_Desde_Cargo);
					empleadoLogic_Desde_Cargo.saveEmpleado();
				}


				CargoLogic cargoLogicHijos_Desde_Cargo=new CargoLogic();

				if(cargo_Desde_CargoGrupo.getCargos()==null){
					cargo_Desde_CargoGrupo.setCargos(new ArrayList<Cargo>());
				}

				cargoLogicHijos_Desde_Cargo.setCargos(cargo_Desde_CargoGrupo.getCargos());

				cargoLogicHijos_Desde_Cargo.setConnexion(this.getConnexion());
				cargoLogicHijos_Desde_Cargo.setDatosCliente(this.datosCliente);

				for(Cargo cargoHijos_Desde_Cargo:cargoLogicHijos_Desde_Cargo.getCargos()) {
					cargoHijos_Desde_Cargo.setid_cargo(idCargoActual);

					cargoLogicHijos_Desde_Cargo.setCargo(cargoHijos_Desde_Cargo);
					cargoLogicHijos_Desde_Cargo.saveCargo();
				}

			}


		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfCargoGrupo(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=CargoGrupoConstantesFunciones.getClassesForeignKeysOfCargoGrupo(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfCargoGrupo(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=CargoGrupoConstantesFunciones.getClassesRelationshipsOfCargoGrupo(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

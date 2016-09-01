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
package com.bydan.erp.puntoventa.business.logic;

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
import com.bydan.erp.puntoventa.util.*;
import com.bydan.erp.puntoventa.util.TarjetaCreditoConexionConstantesFunciones;
import com.bydan.erp.puntoventa.util.TarjetaCreditoConexionParameterReturnGeneral;
//import com.bydan.erp.puntoventa.util.TarjetaCreditoConexionParameterGeneral;
import com.bydan.erp.puntoventa.business.entity.TarjetaCreditoConexion;
import com.bydan.erp.puntoventa.business.logic.TarjetaCreditoConexionLogicAdditional;
import com.bydan.erp.puntoventa.business.dataaccess.*;
import com.bydan.erp.puntoventa.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;


import com.bydan.erp.seguridad.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;








@SuppressWarnings("unused")
public class TarjetaCreditoConexionLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(TarjetaCreditoConexionLogic.class);
	
	protected TarjetaCreditoConexionDataAccess tarjetacreditoconexionDataAccess; 	
	protected TarjetaCreditoConexion tarjetacreditoconexion;
	protected List<TarjetaCreditoConexion> tarjetacreditoconexions;
	protected Object tarjetacreditoconexionObject;	
	protected List<Object> tarjetacreditoconexionsObject;
	
	public static ClassValidator<TarjetaCreditoConexion> tarjetacreditoconexionValidator = new ClassValidator<TarjetaCreditoConexion>(TarjetaCreditoConexion.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected TarjetaCreditoConexionLogicAdditional tarjetacreditoconexionLogicAdditional=null;
	
	public TarjetaCreditoConexionLogicAdditional getTarjetaCreditoConexionLogicAdditional() {
		return this.tarjetacreditoconexionLogicAdditional;
	}
	
	public void setTarjetaCreditoConexionLogicAdditional(TarjetaCreditoConexionLogicAdditional tarjetacreditoconexionLogicAdditional) {
		try {
			this.tarjetacreditoconexionLogicAdditional=tarjetacreditoconexionLogicAdditional;
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
	
	
	
	
	public  TarjetaCreditoConexionLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.tarjetacreditoconexionDataAccess = new TarjetaCreditoConexionDataAccess();
			
			this.tarjetacreditoconexions= new ArrayList<TarjetaCreditoConexion>();
			this.tarjetacreditoconexion= new TarjetaCreditoConexion();
			
			this.tarjetacreditoconexionObject=new Object();
			this.tarjetacreditoconexionsObject=new ArrayList<Object>();
				
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
			
			this.tarjetacreditoconexionDataAccess.setConnexionType(this.connexionType);
			this.tarjetacreditoconexionDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  TarjetaCreditoConexionLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.tarjetacreditoconexionDataAccess = new TarjetaCreditoConexionDataAccess();
			this.tarjetacreditoconexions= new ArrayList<TarjetaCreditoConexion>();
			this.tarjetacreditoconexion= new TarjetaCreditoConexion();
			this.tarjetacreditoconexionObject=new Object();
			this.tarjetacreditoconexionsObject=new ArrayList<Object>();
			
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
			
			this.tarjetacreditoconexionDataAccess.setConnexionType(this.connexionType);
			this.tarjetacreditoconexionDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public TarjetaCreditoConexion getTarjetaCreditoConexion() throws Exception {	
		TarjetaCreditoConexionLogicAdditional.checkTarjetaCreditoConexionToGet(tarjetacreditoconexion,this.datosCliente,this.arrDatoGeneral);
		TarjetaCreditoConexionLogicAdditional.updateTarjetaCreditoConexionToGet(tarjetacreditoconexion,this.arrDatoGeneral);
		
		return tarjetacreditoconexion;
	}
		
	public void setTarjetaCreditoConexion(TarjetaCreditoConexion newTarjetaCreditoConexion) {
		this.tarjetacreditoconexion = newTarjetaCreditoConexion;
	}
	
	public TarjetaCreditoConexionDataAccess getTarjetaCreditoConexionDataAccess() {
		return tarjetacreditoconexionDataAccess;
	}
	
	public void setTarjetaCreditoConexionDataAccess(TarjetaCreditoConexionDataAccess newtarjetacreditoconexionDataAccess) {
		this.tarjetacreditoconexionDataAccess = newtarjetacreditoconexionDataAccess;
	}
	
	public List<TarjetaCreditoConexion> getTarjetaCreditoConexions() throws Exception {		
		this.quitarTarjetaCreditoConexionsNulos();
		
		TarjetaCreditoConexionLogicAdditional.checkTarjetaCreditoConexionToGets(tarjetacreditoconexions,this.datosCliente,this.arrDatoGeneral);
		
		for (TarjetaCreditoConexion tarjetacreditoconexionLocal: tarjetacreditoconexions ) {
			TarjetaCreditoConexionLogicAdditional.updateTarjetaCreditoConexionToGet(tarjetacreditoconexionLocal,this.arrDatoGeneral);
		}
		
		return tarjetacreditoconexions;
	}
	
	public void setTarjetaCreditoConexions(List<TarjetaCreditoConexion> newTarjetaCreditoConexions) {
		this.tarjetacreditoconexions = newTarjetaCreditoConexions;
	}
	
	public Object getTarjetaCreditoConexionObject() {	
		this.tarjetacreditoconexionObject=this.tarjetacreditoconexionDataAccess.getEntityObject();
		return this.tarjetacreditoconexionObject;
	}
		
	public void setTarjetaCreditoConexionObject(Object newTarjetaCreditoConexionObject) {
		this.tarjetacreditoconexionObject = newTarjetaCreditoConexionObject;
	}
	
	public List<Object> getTarjetaCreditoConexionsObject() {		
		this.tarjetacreditoconexionsObject=this.tarjetacreditoconexionDataAccess.getEntitiesObject();
		return this.tarjetacreditoconexionsObject;
	}
		
	public void setTarjetaCreditoConexionsObject(List<Object> newTarjetaCreditoConexionsObject) {
		this.tarjetacreditoconexionsObject = newTarjetaCreditoConexionsObject;
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
		
		if(this.tarjetacreditoconexionDataAccess!=null) {
			this.tarjetacreditoconexionDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TarjetaCreditoConexion.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			tarjetacreditoconexionDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			tarjetacreditoconexionDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		tarjetacreditoconexion = new  TarjetaCreditoConexion();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TarjetaCreditoConexion.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			tarjetacreditoconexion=tarjetacreditoconexionDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tarjetacreditoconexion,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TarjetaCreditoConexionConstantesFunciones.refrescarForeignKeysDescripcionesTarjetaCreditoConexion(this.tarjetacreditoconexion);
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
		tarjetacreditoconexion = new  TarjetaCreditoConexion();
		  		  
        try {
			
			tarjetacreditoconexion=tarjetacreditoconexionDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tarjetacreditoconexion,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TarjetaCreditoConexionConstantesFunciones.refrescarForeignKeysDescripcionesTarjetaCreditoConexion(this.tarjetacreditoconexion);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		tarjetacreditoconexion = new  TarjetaCreditoConexion();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TarjetaCreditoConexion.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			tarjetacreditoconexion=tarjetacreditoconexionDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tarjetacreditoconexion,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TarjetaCreditoConexionConstantesFunciones.refrescarForeignKeysDescripcionesTarjetaCreditoConexion(this.tarjetacreditoconexion);
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
		tarjetacreditoconexion = new  TarjetaCreditoConexion();
		  		  
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
		tarjetacreditoconexion = new  TarjetaCreditoConexion();
		  		  
        try {
			
			tarjetacreditoconexion=tarjetacreditoconexionDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tarjetacreditoconexion,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TarjetaCreditoConexionConstantesFunciones.refrescarForeignKeysDescripcionesTarjetaCreditoConexion(this.tarjetacreditoconexion);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		tarjetacreditoconexion = new  TarjetaCreditoConexion();
		  		  
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
		tarjetacreditoconexion = new  TarjetaCreditoConexion();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TarjetaCreditoConexion.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =tarjetacreditoconexionDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tarjetacreditoconexion = new  TarjetaCreditoConexion();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=tarjetacreditoconexionDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		tarjetacreditoconexion = new  TarjetaCreditoConexion();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TarjetaCreditoConexion.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =tarjetacreditoconexionDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tarjetacreditoconexion = new  TarjetaCreditoConexion();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=tarjetacreditoconexionDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		tarjetacreditoconexion = new  TarjetaCreditoConexion();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TarjetaCreditoConexion.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =tarjetacreditoconexionDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tarjetacreditoconexion = new  TarjetaCreditoConexion();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=tarjetacreditoconexionDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		tarjetacreditoconexions = new  ArrayList<TarjetaCreditoConexion>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TarjetaCreditoConexion.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			TarjetaCreditoConexionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tarjetacreditoconexions=tarjetacreditoconexionDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTarjetaCreditoConexion(tarjetacreditoconexions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TarjetaCreditoConexionConstantesFunciones.refrescarForeignKeysDescripcionesTarjetaCreditoConexion(this.tarjetacreditoconexions);
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
		tarjetacreditoconexions = new  ArrayList<TarjetaCreditoConexion>();
		  		  
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
		tarjetacreditoconexions = new  ArrayList<TarjetaCreditoConexion>();
		  		  
        try {			
			TarjetaCreditoConexionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tarjetacreditoconexions=tarjetacreditoconexionDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarTarjetaCreditoConexion(tarjetacreditoconexions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TarjetaCreditoConexionConstantesFunciones.refrescarForeignKeysDescripcionesTarjetaCreditoConexion(this.tarjetacreditoconexions);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		tarjetacreditoconexions = new  ArrayList<TarjetaCreditoConexion>();
		  		  
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
		tarjetacreditoconexions = new  ArrayList<TarjetaCreditoConexion>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TarjetaCreditoConexion.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			TarjetaCreditoConexionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tarjetacreditoconexions=tarjetacreditoconexionDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTarjetaCreditoConexion(tarjetacreditoconexions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TarjetaCreditoConexionConstantesFunciones.refrescarForeignKeysDescripcionesTarjetaCreditoConexion(this.tarjetacreditoconexions);
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
		tarjetacreditoconexions = new  ArrayList<TarjetaCreditoConexion>();
		  		  
        try {
			TarjetaCreditoConexionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tarjetacreditoconexions=tarjetacreditoconexionDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTarjetaCreditoConexion(tarjetacreditoconexions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TarjetaCreditoConexionConstantesFunciones.refrescarForeignKeysDescripcionesTarjetaCreditoConexion(this.tarjetacreditoconexions);
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
		tarjetacreditoconexions = new  ArrayList<TarjetaCreditoConexion>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TarjetaCreditoConexion.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TarjetaCreditoConexionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tarjetacreditoconexions=tarjetacreditoconexionDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTarjetaCreditoConexion(tarjetacreditoconexions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TarjetaCreditoConexionConstantesFunciones.refrescarForeignKeysDescripcionesTarjetaCreditoConexion(this.tarjetacreditoconexions);
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
		tarjetacreditoconexions = new  ArrayList<TarjetaCreditoConexion>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TarjetaCreditoConexionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tarjetacreditoconexions=tarjetacreditoconexionDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTarjetaCreditoConexion(tarjetacreditoconexions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TarjetaCreditoConexionConstantesFunciones.refrescarForeignKeysDescripcionesTarjetaCreditoConexion(this.tarjetacreditoconexions);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		tarjetacreditoconexion = new  TarjetaCreditoConexion();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TarjetaCreditoConexion.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TarjetaCreditoConexionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tarjetacreditoconexion=tarjetacreditoconexionDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTarjetaCreditoConexion(tarjetacreditoconexion);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TarjetaCreditoConexionConstantesFunciones.refrescarForeignKeysDescripcionesTarjetaCreditoConexion(this.tarjetacreditoconexion);
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
		tarjetacreditoconexion = new  TarjetaCreditoConexion();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TarjetaCreditoConexionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tarjetacreditoconexion=tarjetacreditoconexionDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTarjetaCreditoConexion(tarjetacreditoconexion);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TarjetaCreditoConexionConstantesFunciones.refrescarForeignKeysDescripcionesTarjetaCreditoConexion(this.tarjetacreditoconexion);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		tarjetacreditoconexions = new  ArrayList<TarjetaCreditoConexion>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TarjetaCreditoConexion.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			TarjetaCreditoConexionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tarjetacreditoconexions=tarjetacreditoconexionDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTarjetaCreditoConexion(tarjetacreditoconexions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TarjetaCreditoConexionConstantesFunciones.refrescarForeignKeysDescripcionesTarjetaCreditoConexion(this.tarjetacreditoconexions);
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
		tarjetacreditoconexions = new  ArrayList<TarjetaCreditoConexion>();
		  		  
        try {
			TarjetaCreditoConexionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tarjetacreditoconexions=tarjetacreditoconexionDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTarjetaCreditoConexion(tarjetacreditoconexions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TarjetaCreditoConexionConstantesFunciones.refrescarForeignKeysDescripcionesTarjetaCreditoConexion(this.tarjetacreditoconexions);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosTarjetaCreditoConexionsWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		tarjetacreditoconexions = new  ArrayList<TarjetaCreditoConexion>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TarjetaCreditoConexion.class.getSimpleName()+"-getTodosTarjetaCreditoConexionsWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TarjetaCreditoConexionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tarjetacreditoconexions=tarjetacreditoconexionDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarTarjetaCreditoConexion(tarjetacreditoconexions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TarjetaCreditoConexionConstantesFunciones.refrescarForeignKeysDescripcionesTarjetaCreditoConexion(this.tarjetacreditoconexions);
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
	
	public  void  getTodosTarjetaCreditoConexions(String sFinalQuery,Pagination pagination)throws Exception {
		tarjetacreditoconexions = new  ArrayList<TarjetaCreditoConexion>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TarjetaCreditoConexionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tarjetacreditoconexions=tarjetacreditoconexionDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarTarjetaCreditoConexion(tarjetacreditoconexions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TarjetaCreditoConexionConstantesFunciones.refrescarForeignKeysDescripcionesTarjetaCreditoConexion(this.tarjetacreditoconexions);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarTarjetaCreditoConexion(TarjetaCreditoConexion tarjetacreditoconexion) throws Exception {
		Boolean estaValidado=false;
		
		if(tarjetacreditoconexion.getIsNew() || tarjetacreditoconexion.getIsChanged()) { 
			this.invalidValues = tarjetacreditoconexionValidator.getInvalidValues(tarjetacreditoconexion);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(tarjetacreditoconexion);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarTarjetaCreditoConexion(List<TarjetaCreditoConexion> TarjetaCreditoConexions) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(TarjetaCreditoConexion tarjetacreditoconexionLocal:tarjetacreditoconexions) {				
			estaValidadoObjeto=this.validarGuardarTarjetaCreditoConexion(tarjetacreditoconexionLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarTarjetaCreditoConexion(List<TarjetaCreditoConexion> TarjetaCreditoConexions) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarTarjetaCreditoConexion(tarjetacreditoconexions)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarTarjetaCreditoConexion(TarjetaCreditoConexion TarjetaCreditoConexion) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarTarjetaCreditoConexion(tarjetacreditoconexion)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(TarjetaCreditoConexion tarjetacreditoconexion) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+tarjetacreditoconexion.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=TarjetaCreditoConexionConstantesFunciones.getTarjetaCreditoConexionLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"tarjetacreditoconexion","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(TarjetaCreditoConexionConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(TarjetaCreditoConexionConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveTarjetaCreditoConexionWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TarjetaCreditoConexion.class.getSimpleName()+"-saveTarjetaCreditoConexionWithConnection");connexion.begin();			
			
			TarjetaCreditoConexionLogicAdditional.checkTarjetaCreditoConexionToSave(this.tarjetacreditoconexion,this.datosCliente,connexion,this.arrDatoGeneral);
			
			TarjetaCreditoConexionLogicAdditional.updateTarjetaCreditoConexionToSave(this.tarjetacreditoconexion,this.arrDatoGeneral);
			
			TarjetaCreditoConexionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.tarjetacreditoconexion,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowTarjetaCreditoConexion();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarTarjetaCreditoConexion(this.tarjetacreditoconexion)) {
				TarjetaCreditoConexionDataAccess.save(this.tarjetacreditoconexion, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.tarjetacreditoconexion,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			TarjetaCreditoConexionLogicAdditional.checkTarjetaCreditoConexionToSaveAfter(this.tarjetacreditoconexion,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowTarjetaCreditoConexion();
			
			connexion.commit();			
			
			if(this.tarjetacreditoconexion.getIsDeleted()) {
				this.tarjetacreditoconexion=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveTarjetaCreditoConexion()throws Exception {	
		try {	
			
			TarjetaCreditoConexionLogicAdditional.checkTarjetaCreditoConexionToSave(this.tarjetacreditoconexion,this.datosCliente,connexion,this.arrDatoGeneral);
			
			TarjetaCreditoConexionLogicAdditional.updateTarjetaCreditoConexionToSave(this.tarjetacreditoconexion,this.arrDatoGeneral);
			
			TarjetaCreditoConexionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.tarjetacreditoconexion,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarTarjetaCreditoConexion(this.tarjetacreditoconexion)) {			
				TarjetaCreditoConexionDataAccess.save(this.tarjetacreditoconexion, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.tarjetacreditoconexion,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			TarjetaCreditoConexionLogicAdditional.checkTarjetaCreditoConexionToSaveAfter(this.tarjetacreditoconexion,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.tarjetacreditoconexion.getIsDeleted()) {
				this.tarjetacreditoconexion=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveTarjetaCreditoConexionsWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TarjetaCreditoConexion.class.getSimpleName()+"-saveTarjetaCreditoConexionsWithConnection");connexion.begin();			
			
			TarjetaCreditoConexionLogicAdditional.checkTarjetaCreditoConexionToSaves(tarjetacreditoconexions,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowTarjetaCreditoConexions();
			
			Boolean validadoTodosTarjetaCreditoConexion=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(TarjetaCreditoConexion tarjetacreditoconexionLocal:tarjetacreditoconexions) {		
				if(tarjetacreditoconexionLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				TarjetaCreditoConexionLogicAdditional.updateTarjetaCreditoConexionToSave(tarjetacreditoconexionLocal,this.arrDatoGeneral);
	        	
				TarjetaCreditoConexionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),tarjetacreditoconexionLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarTarjetaCreditoConexion(tarjetacreditoconexionLocal)) {
					TarjetaCreditoConexionDataAccess.save(tarjetacreditoconexionLocal, connexion);				
				} else {
					validadoTodosTarjetaCreditoConexion=false;
				}
			}
			
			if(!validadoTodosTarjetaCreditoConexion) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			TarjetaCreditoConexionLogicAdditional.checkTarjetaCreditoConexionToSavesAfter(tarjetacreditoconexions,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowTarjetaCreditoConexions();
			
			connexion.commit();		
			
			this.quitarTarjetaCreditoConexionsEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveTarjetaCreditoConexions()throws Exception {				
		 try {	
			TarjetaCreditoConexionLogicAdditional.checkTarjetaCreditoConexionToSaves(tarjetacreditoconexions,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosTarjetaCreditoConexion=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(TarjetaCreditoConexion tarjetacreditoconexionLocal:tarjetacreditoconexions) {				
				if(tarjetacreditoconexionLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				TarjetaCreditoConexionLogicAdditional.updateTarjetaCreditoConexionToSave(tarjetacreditoconexionLocal,this.arrDatoGeneral);
	        	
				TarjetaCreditoConexionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),tarjetacreditoconexionLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarTarjetaCreditoConexion(tarjetacreditoconexionLocal)) {				
					TarjetaCreditoConexionDataAccess.save(tarjetacreditoconexionLocal, connexion);				
				} else {
					validadoTodosTarjetaCreditoConexion=false;
				}
			}
			
			if(!validadoTodosTarjetaCreditoConexion) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			TarjetaCreditoConexionLogicAdditional.checkTarjetaCreditoConexionToSavesAfter(tarjetacreditoconexions,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarTarjetaCreditoConexionsEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public TarjetaCreditoConexionParameterReturnGeneral procesarAccionTarjetaCreditoConexions(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<TarjetaCreditoConexion> tarjetacreditoconexions,TarjetaCreditoConexionParameterReturnGeneral tarjetacreditoconexionParameterGeneral)throws Exception {
		 try {	
			TarjetaCreditoConexionParameterReturnGeneral tarjetacreditoconexionReturnGeneral=new TarjetaCreditoConexionParameterReturnGeneral();
	
			TarjetaCreditoConexionLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,tarjetacreditoconexions,tarjetacreditoconexionParameterGeneral,tarjetacreditoconexionReturnGeneral);
			
			return tarjetacreditoconexionReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public TarjetaCreditoConexionParameterReturnGeneral procesarAccionTarjetaCreditoConexionsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<TarjetaCreditoConexion> tarjetacreditoconexions,TarjetaCreditoConexionParameterReturnGeneral tarjetacreditoconexionParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TarjetaCreditoConexion.class.getSimpleName()+"-procesarAccionTarjetaCreditoConexionsWithConnection");connexion.begin();			
			
			TarjetaCreditoConexionParameterReturnGeneral tarjetacreditoconexionReturnGeneral=new TarjetaCreditoConexionParameterReturnGeneral();
	
			TarjetaCreditoConexionLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,tarjetacreditoconexions,tarjetacreditoconexionParameterGeneral,tarjetacreditoconexionReturnGeneral);
			
			this.connexion.commit();
			
			return tarjetacreditoconexionReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public TarjetaCreditoConexionParameterReturnGeneral procesarEventosTarjetaCreditoConexions(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<TarjetaCreditoConexion> tarjetacreditoconexions,TarjetaCreditoConexion tarjetacreditoconexion,TarjetaCreditoConexionParameterReturnGeneral tarjetacreditoconexionParameterGeneral,Boolean isEsNuevoTarjetaCreditoConexion,ArrayList<Classe> clases)throws Exception {
		 try {	
			TarjetaCreditoConexionParameterReturnGeneral tarjetacreditoconexionReturnGeneral=new TarjetaCreditoConexionParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				tarjetacreditoconexionReturnGeneral.setConRecargarPropiedades(true);
			}
			
			TarjetaCreditoConexionLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,tarjetacreditoconexions,tarjetacreditoconexion,tarjetacreditoconexionParameterGeneral,tarjetacreditoconexionReturnGeneral,isEsNuevoTarjetaCreditoConexion,clases);
			
			return tarjetacreditoconexionReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public TarjetaCreditoConexionParameterReturnGeneral procesarEventosTarjetaCreditoConexionsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<TarjetaCreditoConexion> tarjetacreditoconexions,TarjetaCreditoConexion tarjetacreditoconexion,TarjetaCreditoConexionParameterReturnGeneral tarjetacreditoconexionParameterGeneral,Boolean isEsNuevoTarjetaCreditoConexion,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TarjetaCreditoConexion.class.getSimpleName()+"-procesarEventosTarjetaCreditoConexionsWithConnection");connexion.begin();			
			
			TarjetaCreditoConexionParameterReturnGeneral tarjetacreditoconexionReturnGeneral=new TarjetaCreditoConexionParameterReturnGeneral();
	
			tarjetacreditoconexionReturnGeneral.setTarjetaCreditoConexion(tarjetacreditoconexion);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				tarjetacreditoconexionReturnGeneral.setConRecargarPropiedades(true);
			}
			
			TarjetaCreditoConexionLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,tarjetacreditoconexions,tarjetacreditoconexion,tarjetacreditoconexionParameterGeneral,tarjetacreditoconexionReturnGeneral,isEsNuevoTarjetaCreditoConexion,clases);
			
			this.connexion.commit();
			
			return tarjetacreditoconexionReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public TarjetaCreditoConexionParameterReturnGeneral procesarImportacionTarjetaCreditoConexionsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,TarjetaCreditoConexionParameterReturnGeneral tarjetacreditoconexionParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TarjetaCreditoConexion.class.getSimpleName()+"-procesarImportacionTarjetaCreditoConexionsWithConnection");connexion.begin();			
			
			TarjetaCreditoConexionParameterReturnGeneral tarjetacreditoconexionReturnGeneral=new TarjetaCreditoConexionParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.tarjetacreditoconexions=new ArrayList<TarjetaCreditoConexion>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.tarjetacreditoconexion=new TarjetaCreditoConexion();
				
				
				if(conColumnasBase) {this.tarjetacreditoconexion.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.tarjetacreditoconexion.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				
				this.tarjetacreditoconexions.add(this.tarjetacreditoconexion);
			}
			
			this.saveTarjetaCreditoConexions();
			
			this.connexion.commit();
			
			tarjetacreditoconexionReturnGeneral.setConRetornoEstaProcesado(true);
			tarjetacreditoconexionReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return tarjetacreditoconexionReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarTarjetaCreditoConexionsEliminados() throws Exception {				
		
		List<TarjetaCreditoConexion> tarjetacreditoconexionsAux= new ArrayList<TarjetaCreditoConexion>();
		
		for(TarjetaCreditoConexion tarjetacreditoconexion:tarjetacreditoconexions) {
			if(!tarjetacreditoconexion.getIsDeleted()) {
				tarjetacreditoconexionsAux.add(tarjetacreditoconexion);
			}
		}
		
		tarjetacreditoconexions=tarjetacreditoconexionsAux;
	}
	
	public void quitarTarjetaCreditoConexionsNulos() throws Exception {				
		
		List<TarjetaCreditoConexion> tarjetacreditoconexionsAux= new ArrayList<TarjetaCreditoConexion>();
		
		for(TarjetaCreditoConexion tarjetacreditoconexion : this.tarjetacreditoconexions) {
			if(tarjetacreditoconexion==null) {
				tarjetacreditoconexionsAux.add(tarjetacreditoconexion);
			}
		}
		
		//this.tarjetacreditoconexions=tarjetacreditoconexionsAux;
		
		this.tarjetacreditoconexions.removeAll(tarjetacreditoconexionsAux);
	}
	
	public void getSetVersionRowTarjetaCreditoConexionWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(tarjetacreditoconexion.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((tarjetacreditoconexion.getIsDeleted() || (tarjetacreditoconexion.getIsChanged()&&!tarjetacreditoconexion.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=tarjetacreditoconexionDataAccess.getSetVersionRowTarjetaCreditoConexion(connexion,tarjetacreditoconexion.getId());
				
				if(!tarjetacreditoconexion.getVersionRow().equals(timestamp)) {	
					tarjetacreditoconexion.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				tarjetacreditoconexion.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowTarjetaCreditoConexion()throws Exception {	
		
		if(tarjetacreditoconexion.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((tarjetacreditoconexion.getIsDeleted() || (tarjetacreditoconexion.getIsChanged()&&!tarjetacreditoconexion.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=tarjetacreditoconexionDataAccess.getSetVersionRowTarjetaCreditoConexion(connexion,tarjetacreditoconexion.getId());
			
			try {							
				if(!tarjetacreditoconexion.getVersionRow().equals(timestamp)) {	
					tarjetacreditoconexion.setVersionRow(timestamp);
				}
				
				tarjetacreditoconexion.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowTarjetaCreditoConexionsWithConnection()throws Exception {	
		if(tarjetacreditoconexions!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(TarjetaCreditoConexion tarjetacreditoconexionAux:tarjetacreditoconexions) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(tarjetacreditoconexionAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(tarjetacreditoconexionAux.getIsDeleted() || (tarjetacreditoconexionAux.getIsChanged()&&!tarjetacreditoconexionAux.getIsNew())) {
						
						timestamp=tarjetacreditoconexionDataAccess.getSetVersionRowTarjetaCreditoConexion(connexion,tarjetacreditoconexionAux.getId());
						
						if(!tarjetacreditoconexion.getVersionRow().equals(timestamp)) {	
							tarjetacreditoconexionAux.setVersionRow(timestamp);
						}
								
						tarjetacreditoconexionAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowTarjetaCreditoConexions()throws Exception {	
		if(tarjetacreditoconexions!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(TarjetaCreditoConexion tarjetacreditoconexionAux:tarjetacreditoconexions) {
					if(tarjetacreditoconexionAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(tarjetacreditoconexionAux.getIsDeleted() || (tarjetacreditoconexionAux.getIsChanged()&&!tarjetacreditoconexionAux.getIsNew())) {
						
						timestamp=tarjetacreditoconexionDataAccess.getSetVersionRowTarjetaCreditoConexion(connexion,tarjetacreditoconexionAux.getId());
						
						if(!tarjetacreditoconexionAux.getVersionRow().equals(timestamp)) {	
							tarjetacreditoconexionAux.setVersionRow(timestamp);
						}
						
													
						tarjetacreditoconexionAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public TarjetaCreditoConexionParameterReturnGeneral cargarCombosLoteForeignKeyTarjetaCreditoConexionWithConnection(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalTarjetaCredito,String finalQueryGlobalConexion) throws Exception {
		TarjetaCreditoConexionParameterReturnGeneral  tarjetacreditoconexionReturnGeneral =new TarjetaCreditoConexionParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TarjetaCreditoConexion.class.getSimpleName()+"-cargarCombosLoteForeignKeyTarjetaCreditoConexionWithConnection");connexion.begin();
			
			tarjetacreditoconexionReturnGeneral =new TarjetaCreditoConexionParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			tarjetacreditoconexionReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			tarjetacreditoconexionReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<TarjetaCredito> tarjetacreditosForeignKey=new ArrayList<TarjetaCredito>();
			TarjetaCreditoLogic tarjetacreditoLogic=new TarjetaCreditoLogic();
			tarjetacreditoLogic.setConnexion(this.connexion);
			tarjetacreditoLogic.getTarjetaCreditoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTarjetaCredito.equals("NONE")) {
				tarjetacreditoLogic.getTodosTarjetaCreditos(finalQueryGlobalTarjetaCredito,new Pagination());
				tarjetacreditosForeignKey=tarjetacreditoLogic.getTarjetaCreditos();
			}

			tarjetacreditoconexionReturnGeneral.settarjetacreditosForeignKey(tarjetacreditosForeignKey);


			List<Conexion> conexionsForeignKey=new ArrayList<Conexion>();
			ConexionLogic conexionLogic=new ConexionLogic();
			conexionLogic.setConnexion(this.connexion);
			conexionLogic.getConexionDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalConexion.equals("NONE")) {
				conexionLogic.getTodosConexions(finalQueryGlobalConexion,new Pagination());
				conexionsForeignKey=conexionLogic.getConexions();
			}

			tarjetacreditoconexionReturnGeneral.setconexionsForeignKey(conexionsForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return tarjetacreditoconexionReturnGeneral;
	}
	
	public TarjetaCreditoConexionParameterReturnGeneral cargarCombosLoteForeignKeyTarjetaCreditoConexion(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalTarjetaCredito,String finalQueryGlobalConexion) throws Exception {
		TarjetaCreditoConexionParameterReturnGeneral  tarjetacreditoconexionReturnGeneral =new TarjetaCreditoConexionParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			tarjetacreditoconexionReturnGeneral =new TarjetaCreditoConexionParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			tarjetacreditoconexionReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			tarjetacreditoconexionReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<TarjetaCredito> tarjetacreditosForeignKey=new ArrayList<TarjetaCredito>();
			TarjetaCreditoLogic tarjetacreditoLogic=new TarjetaCreditoLogic();
			tarjetacreditoLogic.setConnexion(this.connexion);
			tarjetacreditoLogic.getTarjetaCreditoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTarjetaCredito.equals("NONE")) {
				tarjetacreditoLogic.getTodosTarjetaCreditos(finalQueryGlobalTarjetaCredito,new Pagination());
				tarjetacreditosForeignKey=tarjetacreditoLogic.getTarjetaCreditos();
			}

			tarjetacreditoconexionReturnGeneral.settarjetacreditosForeignKey(tarjetacreditosForeignKey);


			List<Conexion> conexionsForeignKey=new ArrayList<Conexion>();
			ConexionLogic conexionLogic=new ConexionLogic();
			conexionLogic.setConnexion(this.connexion);
			conexionLogic.getConexionDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalConexion.equals("NONE")) {
				conexionLogic.getTodosConexions(finalQueryGlobalConexion,new Pagination());
				conexionsForeignKey=conexionLogic.getConexions();
			}

			tarjetacreditoconexionReturnGeneral.setconexionsForeignKey(conexionsForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return tarjetacreditoconexionReturnGeneral;
	}
	
	
	public void deepLoad(TarjetaCreditoConexion tarjetacreditoconexion,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			TarjetaCreditoConexionLogicAdditional.updateTarjetaCreditoConexionToGet(tarjetacreditoconexion,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		tarjetacreditoconexion.setEmpresa(tarjetacreditoconexionDataAccess.getEmpresa(connexion,tarjetacreditoconexion));
		tarjetacreditoconexion.setSucursal(tarjetacreditoconexionDataAccess.getSucursal(connexion,tarjetacreditoconexion));
		tarjetacreditoconexion.setTarjetaCredito(tarjetacreditoconexionDataAccess.getTarjetaCredito(connexion,tarjetacreditoconexion));
		tarjetacreditoconexion.setConexion(tarjetacreditoconexionDataAccess.getConexion(connexion,tarjetacreditoconexion));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				tarjetacreditoconexion.setEmpresa(tarjetacreditoconexionDataAccess.getEmpresa(connexion,tarjetacreditoconexion));
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				tarjetacreditoconexion.setSucursal(tarjetacreditoconexionDataAccess.getSucursal(connexion,tarjetacreditoconexion));
				continue;
			}

			if(clas.clas.equals(TarjetaCredito.class)) {
				tarjetacreditoconexion.setTarjetaCredito(tarjetacreditoconexionDataAccess.getTarjetaCredito(connexion,tarjetacreditoconexion));
				continue;
			}

			if(clas.clas.equals(Conexion.class)) {
				tarjetacreditoconexion.setConexion(tarjetacreditoconexionDataAccess.getConexion(connexion,tarjetacreditoconexion));
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
			tarjetacreditoconexion.setEmpresa(tarjetacreditoconexionDataAccess.getEmpresa(connexion,tarjetacreditoconexion));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			tarjetacreditoconexion.setSucursal(tarjetacreditoconexionDataAccess.getSucursal(connexion,tarjetacreditoconexion));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TarjetaCredito.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			tarjetacreditoconexion.setTarjetaCredito(tarjetacreditoconexionDataAccess.getTarjetaCredito(connexion,tarjetacreditoconexion));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Conexion.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			tarjetacreditoconexion.setConexion(tarjetacreditoconexionDataAccess.getConexion(connexion,tarjetacreditoconexion));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		tarjetacreditoconexion.setEmpresa(tarjetacreditoconexionDataAccess.getEmpresa(connexion,tarjetacreditoconexion));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(tarjetacreditoconexion.getEmpresa(),isDeep,deepLoadType,clases);
				
		tarjetacreditoconexion.setSucursal(tarjetacreditoconexionDataAccess.getSucursal(connexion,tarjetacreditoconexion));
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(tarjetacreditoconexion.getSucursal(),isDeep,deepLoadType,clases);
				
		tarjetacreditoconexion.setTarjetaCredito(tarjetacreditoconexionDataAccess.getTarjetaCredito(connexion,tarjetacreditoconexion));
		TarjetaCreditoLogic tarjetacreditoLogic= new TarjetaCreditoLogic(connexion);
		tarjetacreditoLogic.deepLoad(tarjetacreditoconexion.getTarjetaCredito(),isDeep,deepLoadType,clases);
				
		tarjetacreditoconexion.setConexion(tarjetacreditoconexionDataAccess.getConexion(connexion,tarjetacreditoconexion));
		ConexionLogic conexionLogic= new ConexionLogic(connexion);
		conexionLogic.deepLoad(tarjetacreditoconexion.getConexion(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				tarjetacreditoconexion.setEmpresa(tarjetacreditoconexionDataAccess.getEmpresa(connexion,tarjetacreditoconexion));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(tarjetacreditoconexion.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				tarjetacreditoconexion.setSucursal(tarjetacreditoconexionDataAccess.getSucursal(connexion,tarjetacreditoconexion));
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepLoad(tarjetacreditoconexion.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TarjetaCredito.class)) {
				tarjetacreditoconexion.setTarjetaCredito(tarjetacreditoconexionDataAccess.getTarjetaCredito(connexion,tarjetacreditoconexion));
				TarjetaCreditoLogic tarjetacreditoLogic= new TarjetaCreditoLogic(connexion);
				tarjetacreditoLogic.deepLoad(tarjetacreditoconexion.getTarjetaCredito(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Conexion.class)) {
				tarjetacreditoconexion.setConexion(tarjetacreditoconexionDataAccess.getConexion(connexion,tarjetacreditoconexion));
				ConexionLogic conexionLogic= new ConexionLogic(connexion);
				conexionLogic.deepLoad(tarjetacreditoconexion.getConexion(),isDeep,deepLoadType,clases);				
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
			tarjetacreditoconexion.setEmpresa(tarjetacreditoconexionDataAccess.getEmpresa(connexion,tarjetacreditoconexion));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(tarjetacreditoconexion.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			tarjetacreditoconexion.setSucursal(tarjetacreditoconexionDataAccess.getSucursal(connexion,tarjetacreditoconexion));
			SucursalLogic sucursalLogic= new SucursalLogic(connexion);
			sucursalLogic.deepLoad(tarjetacreditoconexion.getSucursal(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TarjetaCredito.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			tarjetacreditoconexion.setTarjetaCredito(tarjetacreditoconexionDataAccess.getTarjetaCredito(connexion,tarjetacreditoconexion));
			TarjetaCreditoLogic tarjetacreditoLogic= new TarjetaCreditoLogic(connexion);
			tarjetacreditoLogic.deepLoad(tarjetacreditoconexion.getTarjetaCredito(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Conexion.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			tarjetacreditoconexion.setConexion(tarjetacreditoconexionDataAccess.getConexion(connexion,tarjetacreditoconexion));
			ConexionLogic conexionLogic= new ConexionLogic(connexion);
			conexionLogic.deepLoad(tarjetacreditoconexion.getConexion(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(TarjetaCreditoConexion tarjetacreditoconexion,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			TarjetaCreditoConexionLogicAdditional.updateTarjetaCreditoConexionToSave(tarjetacreditoconexion,this.arrDatoGeneral);
			
TarjetaCreditoConexionDataAccess.save(tarjetacreditoconexion, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(tarjetacreditoconexion.getEmpresa(),connexion);

		SucursalDataAccess.save(tarjetacreditoconexion.getSucursal(),connexion);

		TarjetaCreditoDataAccess.save(tarjetacreditoconexion.getTarjetaCredito(),connexion);

		ConexionDataAccess.save(tarjetacreditoconexion.getConexion(),connexion);
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(tarjetacreditoconexion.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(tarjetacreditoconexion.getSucursal(),connexion);
				continue;
			}

			if(clas.clas.equals(TarjetaCredito.class)) {
				TarjetaCreditoDataAccess.save(tarjetacreditoconexion.getTarjetaCredito(),connexion);
				continue;
			}

			if(clas.clas.equals(Conexion.class)) {
				ConexionDataAccess.save(tarjetacreditoconexion.getConexion(),connexion);
				continue;
			}

		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(tarjetacreditoconexion.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(tarjetacreditoconexion.getEmpresa(),isDeep,deepLoadType,clases);
				

		SucursalDataAccess.save(tarjetacreditoconexion.getSucursal(),connexion);
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(tarjetacreditoconexion.getSucursal(),isDeep,deepLoadType,clases);
				

		TarjetaCreditoDataAccess.save(tarjetacreditoconexion.getTarjetaCredito(),connexion);
		TarjetaCreditoLogic tarjetacreditoLogic= new TarjetaCreditoLogic(connexion);
		tarjetacreditoLogic.deepLoad(tarjetacreditoconexion.getTarjetaCredito(),isDeep,deepLoadType,clases);
				

		ConexionDataAccess.save(tarjetacreditoconexion.getConexion(),connexion);
		ConexionLogic conexionLogic= new ConexionLogic(connexion);
		conexionLogic.deepLoad(tarjetacreditoconexion.getConexion(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(tarjetacreditoconexion.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(tarjetacreditoconexion.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(tarjetacreditoconexion.getSucursal(),connexion);
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepSave(tarjetacreditoconexion.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TarjetaCredito.class)) {
				TarjetaCreditoDataAccess.save(tarjetacreditoconexion.getTarjetaCredito(),connexion);
				TarjetaCreditoLogic tarjetacreditoLogic= new TarjetaCreditoLogic(connexion);
				tarjetacreditoLogic.deepSave(tarjetacreditoconexion.getTarjetaCredito(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Conexion.class)) {
				ConexionDataAccess.save(tarjetacreditoconexion.getConexion(),connexion);
				ConexionLogic conexionLogic= new ConexionLogic(connexion);
				conexionLogic.deepSave(tarjetacreditoconexion.getConexion(),isDeep,deepLoadType,clases);				
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
			this.getNewConnexionToDeep(TarjetaCreditoConexion.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(tarjetacreditoconexion,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				TarjetaCreditoConexionConstantesFunciones.refrescarForeignKeysDescripcionesTarjetaCreditoConexion(tarjetacreditoconexion);
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
			this.deepLoad(this.tarjetacreditoconexion,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				TarjetaCreditoConexionConstantesFunciones.refrescarForeignKeysDescripcionesTarjetaCreditoConexion(this.tarjetacreditoconexion);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(TarjetaCreditoConexion.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(tarjetacreditoconexions!=null) {
				for(TarjetaCreditoConexion tarjetacreditoconexion:tarjetacreditoconexions) {
					this.deepLoad(tarjetacreditoconexion,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					TarjetaCreditoConexionConstantesFunciones.refrescarForeignKeysDescripcionesTarjetaCreditoConexion(tarjetacreditoconexions);
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
			if(tarjetacreditoconexions!=null) {
				for(TarjetaCreditoConexion tarjetacreditoconexion:tarjetacreditoconexions) {
					this.deepLoad(tarjetacreditoconexion,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					TarjetaCreditoConexionConstantesFunciones.refrescarForeignKeysDescripcionesTarjetaCreditoConexion(tarjetacreditoconexions);
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
			this.getNewConnexionToDeep(TarjetaCreditoConexion.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(tarjetacreditoconexion,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(TarjetaCreditoConexion.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(tarjetacreditoconexions!=null) {
				for(TarjetaCreditoConexion tarjetacreditoconexion:tarjetacreditoconexions) {
					this.deepSave(tarjetacreditoconexion,isDeep,deepLoadType,clases);
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
			if(tarjetacreditoconexions!=null) {
				for(TarjetaCreditoConexion tarjetacreditoconexion:tarjetacreditoconexions) {
					this.deepSave(tarjetacreditoconexion,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getTarjetaCreditoConexionsFK_IdConexionWithConnection(String sFinalQuery,Pagination pagination,Long id_conexion)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TarjetaCreditoConexion.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidConexion= new ParameterSelectionGeneral();
			parameterSelectionGeneralidConexion.setParameterSelectionGeneralEqual(ParameterType.LONG,id_conexion,TarjetaCreditoConexionConstantesFunciones.IDCONEXION,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidConexion);

			TarjetaCreditoConexionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdConexion","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tarjetacreditoconexions=tarjetacreditoconexionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TarjetaCreditoConexionConstantesFunciones.refrescarForeignKeysDescripcionesTarjetaCreditoConexion(this.tarjetacreditoconexions);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTarjetaCreditoConexionsFK_IdConexion(String sFinalQuery,Pagination pagination,Long id_conexion)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidConexion= new ParameterSelectionGeneral();
			parameterSelectionGeneralidConexion.setParameterSelectionGeneralEqual(ParameterType.LONG,id_conexion,TarjetaCreditoConexionConstantesFunciones.IDCONEXION,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidConexion);

			TarjetaCreditoConexionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdConexion","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tarjetacreditoconexions=tarjetacreditoconexionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TarjetaCreditoConexionConstantesFunciones.refrescarForeignKeysDescripcionesTarjetaCreditoConexion(this.tarjetacreditoconexions);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getTarjetaCreditoConexionsFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TarjetaCreditoConexion.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,TarjetaCreditoConexionConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			TarjetaCreditoConexionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tarjetacreditoconexions=tarjetacreditoconexionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TarjetaCreditoConexionConstantesFunciones.refrescarForeignKeysDescripcionesTarjetaCreditoConexion(this.tarjetacreditoconexions);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTarjetaCreditoConexionsFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,TarjetaCreditoConexionConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			TarjetaCreditoConexionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tarjetacreditoconexions=tarjetacreditoconexionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TarjetaCreditoConexionConstantesFunciones.refrescarForeignKeysDescripcionesTarjetaCreditoConexion(this.tarjetacreditoconexions);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getTarjetaCreditoConexionsFK_IdSucursalWithConnection(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TarjetaCreditoConexion.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,TarjetaCreditoConexionConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			TarjetaCreditoConexionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tarjetacreditoconexions=tarjetacreditoconexionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TarjetaCreditoConexionConstantesFunciones.refrescarForeignKeysDescripcionesTarjetaCreditoConexion(this.tarjetacreditoconexions);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTarjetaCreditoConexionsFK_IdSucursal(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,TarjetaCreditoConexionConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			TarjetaCreditoConexionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tarjetacreditoconexions=tarjetacreditoconexionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TarjetaCreditoConexionConstantesFunciones.refrescarForeignKeysDescripcionesTarjetaCreditoConexion(this.tarjetacreditoconexions);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getTarjetaCreditoConexionsFK_IdTarjetaCreditoWithConnection(String sFinalQuery,Pagination pagination,Long id_tarjeta_credito)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TarjetaCreditoConexion.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTarjetaCredito= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTarjetaCredito.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tarjeta_credito,TarjetaCreditoConexionConstantesFunciones.IDTARJETACREDITO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTarjetaCredito);

			TarjetaCreditoConexionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTarjetaCredito","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tarjetacreditoconexions=tarjetacreditoconexionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TarjetaCreditoConexionConstantesFunciones.refrescarForeignKeysDescripcionesTarjetaCreditoConexion(this.tarjetacreditoconexions);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTarjetaCreditoConexionsFK_IdTarjetaCredito(String sFinalQuery,Pagination pagination,Long id_tarjeta_credito)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTarjetaCredito= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTarjetaCredito.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tarjeta_credito,TarjetaCreditoConexionConstantesFunciones.IDTARJETACREDITO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTarjetaCredito);

			TarjetaCreditoConexionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTarjetaCredito","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tarjetacreditoconexions=tarjetacreditoconexionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TarjetaCreditoConexionConstantesFunciones.refrescarForeignKeysDescripcionesTarjetaCreditoConexion(this.tarjetacreditoconexions);
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
			if(TarjetaCreditoConexionConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,TarjetaCreditoConexionDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,TarjetaCreditoConexion tarjetacreditoconexion,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(TarjetaCreditoConexionConstantesFunciones.ISCONAUDITORIA) {
				if(tarjetacreditoconexion.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TarjetaCreditoConexionDataAccess.TABLENAME, tarjetacreditoconexion.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(TarjetaCreditoConexionConstantesFunciones.ISCONAUDITORIADETALLE) {
						////TarjetaCreditoConexionLogic.registrarAuditoriaDetallesTarjetaCreditoConexion(connexion,tarjetacreditoconexion,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(tarjetacreditoconexion.getIsDeleted()) {
					/*if(!tarjetacreditoconexion.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,TarjetaCreditoConexionDataAccess.TABLENAME, tarjetacreditoconexion.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////TarjetaCreditoConexionLogic.registrarAuditoriaDetallesTarjetaCreditoConexion(connexion,tarjetacreditoconexion,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TarjetaCreditoConexionDataAccess.TABLENAME, tarjetacreditoconexion.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(tarjetacreditoconexion.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TarjetaCreditoConexionDataAccess.TABLENAME, tarjetacreditoconexion.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(TarjetaCreditoConexionConstantesFunciones.ISCONAUDITORIADETALLE) {
						////TarjetaCreditoConexionLogic.registrarAuditoriaDetallesTarjetaCreditoConexion(connexion,tarjetacreditoconexion,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesTarjetaCreditoConexion(Connexion connexion,TarjetaCreditoConexion tarjetacreditoconexion)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(tarjetacreditoconexion.getIsNew()||!tarjetacreditoconexion.getid_empresa().equals(tarjetacreditoconexion.getTarjetaCreditoConexionOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tarjetacreditoconexion.getTarjetaCreditoConexionOriginal().getid_empresa()!=null)
				{
					strValorActual=tarjetacreditoconexion.getTarjetaCreditoConexionOriginal().getid_empresa().toString();
				}
				if(tarjetacreditoconexion.getid_empresa()!=null)
				{
					strValorNuevo=tarjetacreditoconexion.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TarjetaCreditoConexionConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(tarjetacreditoconexion.getIsNew()||!tarjetacreditoconexion.getid_sucursal().equals(tarjetacreditoconexion.getTarjetaCreditoConexionOriginal().getid_sucursal()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tarjetacreditoconexion.getTarjetaCreditoConexionOriginal().getid_sucursal()!=null)
				{
					strValorActual=tarjetacreditoconexion.getTarjetaCreditoConexionOriginal().getid_sucursal().toString();
				}
				if(tarjetacreditoconexion.getid_sucursal()!=null)
				{
					strValorNuevo=tarjetacreditoconexion.getid_sucursal().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TarjetaCreditoConexionConstantesFunciones.IDSUCURSAL,strValorActual,strValorNuevo);
			}	
			
			if(tarjetacreditoconexion.getIsNew()||!tarjetacreditoconexion.getid_tarjeta_credito().equals(tarjetacreditoconexion.getTarjetaCreditoConexionOriginal().getid_tarjeta_credito()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tarjetacreditoconexion.getTarjetaCreditoConexionOriginal().getid_tarjeta_credito()!=null)
				{
					strValorActual=tarjetacreditoconexion.getTarjetaCreditoConexionOriginal().getid_tarjeta_credito().toString();
				}
				if(tarjetacreditoconexion.getid_tarjeta_credito()!=null)
				{
					strValorNuevo=tarjetacreditoconexion.getid_tarjeta_credito().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TarjetaCreditoConexionConstantesFunciones.IDTARJETACREDITO,strValorActual,strValorNuevo);
			}	
			
			if(tarjetacreditoconexion.getIsNew()||!tarjetacreditoconexion.getid_conexion().equals(tarjetacreditoconexion.getTarjetaCreditoConexionOriginal().getid_conexion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tarjetacreditoconexion.getTarjetaCreditoConexionOriginal().getid_conexion()!=null)
				{
					strValorActual=tarjetacreditoconexion.getTarjetaCreditoConexionOriginal().getid_conexion().toString();
				}
				if(tarjetacreditoconexion.getid_conexion()!=null)
				{
					strValorNuevo=tarjetacreditoconexion.getid_conexion().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TarjetaCreditoConexionConstantesFunciones.IDCONEXION,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveTarjetaCreditoConexionRelacionesWithConnection(TarjetaCreditoConexion tarjetacreditoconexion) throws Exception {

		if(!tarjetacreditoconexion.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveTarjetaCreditoConexionRelacionesBase(tarjetacreditoconexion,true);
		}
	}

	public void saveTarjetaCreditoConexionRelaciones(TarjetaCreditoConexion tarjetacreditoconexion)throws Exception {

		if(!tarjetacreditoconexion.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveTarjetaCreditoConexionRelacionesBase(tarjetacreditoconexion,false);
		}
	}

	public void saveTarjetaCreditoConexionRelacionesBase(TarjetaCreditoConexion tarjetacreditoconexion,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("TarjetaCreditoConexion-saveRelacionesWithConnection");}
	

			this.setTarjetaCreditoConexion(tarjetacreditoconexion);

			if(TarjetaCreditoConexionLogicAdditional.validarSaveRelaciones(tarjetacreditoconexion,this)) {

				TarjetaCreditoConexionLogicAdditional.updateRelacionesToSave(tarjetacreditoconexion,this);

				if((tarjetacreditoconexion.getIsNew()||tarjetacreditoconexion.getIsChanged())&&!tarjetacreditoconexion.getIsDeleted()) {
					this.saveTarjetaCreditoConexion();
					this.saveTarjetaCreditoConexionRelacionesDetalles();

				} else if(tarjetacreditoconexion.getIsDeleted()) {
					this.saveTarjetaCreditoConexionRelacionesDetalles();
					this.saveTarjetaCreditoConexion();
				}

				TarjetaCreditoConexionLogicAdditional.updateRelacionesToSaveAfter(tarjetacreditoconexion,this);

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
	
	
	private void saveTarjetaCreditoConexionRelacionesDetalles()throws Exception {
		try {
	

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfTarjetaCreditoConexion(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=TarjetaCreditoConexionConstantesFunciones.getClassesForeignKeysOfTarjetaCreditoConexion(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTarjetaCreditoConexion(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=TarjetaCreditoConexionConstantesFunciones.getClassesRelationshipsOfTarjetaCreditoConexion(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

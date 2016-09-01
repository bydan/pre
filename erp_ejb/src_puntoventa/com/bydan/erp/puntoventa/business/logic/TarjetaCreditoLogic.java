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
import com.bydan.erp.puntoventa.util.TarjetaCreditoConstantesFunciones;
import com.bydan.erp.puntoventa.util.TarjetaCreditoParameterReturnGeneral;
//import com.bydan.erp.puntoventa.util.TarjetaCreditoParameterGeneral;
import com.bydan.erp.puntoventa.business.entity.TarjetaCredito;
import com.bydan.erp.puntoventa.business.logic.TarjetaCreditoLogicAdditional;
import com.bydan.erp.puntoventa.business.dataaccess.*;
import com.bydan.erp.puntoventa.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;
import com.bydan.erp.tesoreria.business.logic.*;
import com.bydan.erp.contabilidad.business.logic.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.tesoreria.util.*;
import com.bydan.erp.contabilidad.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.tesoreria.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;








@SuppressWarnings("unused")
public class TarjetaCreditoLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(TarjetaCreditoLogic.class);
	
	protected TarjetaCreditoDataAccess tarjetacreditoDataAccess; 	
	protected TarjetaCredito tarjetacredito;
	protected List<TarjetaCredito> tarjetacreditos;
	protected Object tarjetacreditoObject;	
	protected List<Object> tarjetacreditosObject;
	
	public static ClassValidator<TarjetaCredito> tarjetacreditoValidator = new ClassValidator<TarjetaCredito>(TarjetaCredito.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected TarjetaCreditoLogicAdditional tarjetacreditoLogicAdditional=null;
	
	public TarjetaCreditoLogicAdditional getTarjetaCreditoLogicAdditional() {
		return this.tarjetacreditoLogicAdditional;
	}
	
	public void setTarjetaCreditoLogicAdditional(TarjetaCreditoLogicAdditional tarjetacreditoLogicAdditional) {
		try {
			this.tarjetacreditoLogicAdditional=tarjetacreditoLogicAdditional;
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
	
	
	
	
	public  TarjetaCreditoLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.tarjetacreditoDataAccess = new TarjetaCreditoDataAccess();
			
			this.tarjetacreditos= new ArrayList<TarjetaCredito>();
			this.tarjetacredito= new TarjetaCredito();
			
			this.tarjetacreditoObject=new Object();
			this.tarjetacreditosObject=new ArrayList<Object>();
				
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
			
			this.tarjetacreditoDataAccess.setConnexionType(this.connexionType);
			this.tarjetacreditoDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  TarjetaCreditoLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.tarjetacreditoDataAccess = new TarjetaCreditoDataAccess();
			this.tarjetacreditos= new ArrayList<TarjetaCredito>();
			this.tarjetacredito= new TarjetaCredito();
			this.tarjetacreditoObject=new Object();
			this.tarjetacreditosObject=new ArrayList<Object>();
			
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
			
			this.tarjetacreditoDataAccess.setConnexionType(this.connexionType);
			this.tarjetacreditoDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public TarjetaCredito getTarjetaCredito() throws Exception {	
		TarjetaCreditoLogicAdditional.checkTarjetaCreditoToGet(tarjetacredito,this.datosCliente,this.arrDatoGeneral);
		TarjetaCreditoLogicAdditional.updateTarjetaCreditoToGet(tarjetacredito,this.arrDatoGeneral);
		
		return tarjetacredito;
	}
		
	public void setTarjetaCredito(TarjetaCredito newTarjetaCredito) {
		this.tarjetacredito = newTarjetaCredito;
	}
	
	public TarjetaCreditoDataAccess getTarjetaCreditoDataAccess() {
		return tarjetacreditoDataAccess;
	}
	
	public void setTarjetaCreditoDataAccess(TarjetaCreditoDataAccess newtarjetacreditoDataAccess) {
		this.tarjetacreditoDataAccess = newtarjetacreditoDataAccess;
	}
	
	public List<TarjetaCredito> getTarjetaCreditos() throws Exception {		
		this.quitarTarjetaCreditosNulos();
		
		TarjetaCreditoLogicAdditional.checkTarjetaCreditoToGets(tarjetacreditos,this.datosCliente,this.arrDatoGeneral);
		
		for (TarjetaCredito tarjetacreditoLocal: tarjetacreditos ) {
			TarjetaCreditoLogicAdditional.updateTarjetaCreditoToGet(tarjetacreditoLocal,this.arrDatoGeneral);
		}
		
		return tarjetacreditos;
	}
	
	public void setTarjetaCreditos(List<TarjetaCredito> newTarjetaCreditos) {
		this.tarjetacreditos = newTarjetaCreditos;
	}
	
	public Object getTarjetaCreditoObject() {	
		this.tarjetacreditoObject=this.tarjetacreditoDataAccess.getEntityObject();
		return this.tarjetacreditoObject;
	}
		
	public void setTarjetaCreditoObject(Object newTarjetaCreditoObject) {
		this.tarjetacreditoObject = newTarjetaCreditoObject;
	}
	
	public List<Object> getTarjetaCreditosObject() {		
		this.tarjetacreditosObject=this.tarjetacreditoDataAccess.getEntitiesObject();
		return this.tarjetacreditosObject;
	}
		
	public void setTarjetaCreditosObject(List<Object> newTarjetaCreditosObject) {
		this.tarjetacreditosObject = newTarjetaCreditosObject;
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
		
		if(this.tarjetacreditoDataAccess!=null) {
			this.tarjetacreditoDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TarjetaCredito.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			tarjetacreditoDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			tarjetacreditoDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		tarjetacredito = new  TarjetaCredito();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TarjetaCredito.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			tarjetacredito=tarjetacreditoDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tarjetacredito,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TarjetaCreditoConstantesFunciones.refrescarForeignKeysDescripcionesTarjetaCredito(this.tarjetacredito);
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
		tarjetacredito = new  TarjetaCredito();
		  		  
        try {
			
			tarjetacredito=tarjetacreditoDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tarjetacredito,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TarjetaCreditoConstantesFunciones.refrescarForeignKeysDescripcionesTarjetaCredito(this.tarjetacredito);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		tarjetacredito = new  TarjetaCredito();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TarjetaCredito.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			tarjetacredito=tarjetacreditoDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tarjetacredito,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TarjetaCreditoConstantesFunciones.refrescarForeignKeysDescripcionesTarjetaCredito(this.tarjetacredito);
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
		tarjetacredito = new  TarjetaCredito();
		  		  
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
		tarjetacredito = new  TarjetaCredito();
		  		  
        try {
			
			tarjetacredito=tarjetacreditoDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tarjetacredito,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TarjetaCreditoConstantesFunciones.refrescarForeignKeysDescripcionesTarjetaCredito(this.tarjetacredito);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		tarjetacredito = new  TarjetaCredito();
		  		  
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
		tarjetacredito = new  TarjetaCredito();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TarjetaCredito.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =tarjetacreditoDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tarjetacredito = new  TarjetaCredito();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=tarjetacreditoDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		tarjetacredito = new  TarjetaCredito();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TarjetaCredito.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =tarjetacreditoDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tarjetacredito = new  TarjetaCredito();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=tarjetacreditoDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		tarjetacredito = new  TarjetaCredito();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TarjetaCredito.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =tarjetacreditoDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tarjetacredito = new  TarjetaCredito();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=tarjetacreditoDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		tarjetacreditos = new  ArrayList<TarjetaCredito>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TarjetaCredito.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			TarjetaCreditoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tarjetacreditos=tarjetacreditoDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTarjetaCredito(tarjetacreditos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TarjetaCreditoConstantesFunciones.refrescarForeignKeysDescripcionesTarjetaCredito(this.tarjetacreditos);
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
		tarjetacreditos = new  ArrayList<TarjetaCredito>();
		  		  
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
		tarjetacreditos = new  ArrayList<TarjetaCredito>();
		  		  
        try {			
			TarjetaCreditoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tarjetacreditos=tarjetacreditoDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarTarjetaCredito(tarjetacreditos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TarjetaCreditoConstantesFunciones.refrescarForeignKeysDescripcionesTarjetaCredito(this.tarjetacreditos);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		tarjetacreditos = new  ArrayList<TarjetaCredito>();
		  		  
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
		tarjetacreditos = new  ArrayList<TarjetaCredito>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TarjetaCredito.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			TarjetaCreditoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tarjetacreditos=tarjetacreditoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTarjetaCredito(tarjetacreditos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TarjetaCreditoConstantesFunciones.refrescarForeignKeysDescripcionesTarjetaCredito(this.tarjetacreditos);
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
		tarjetacreditos = new  ArrayList<TarjetaCredito>();
		  		  
        try {
			TarjetaCreditoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tarjetacreditos=tarjetacreditoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTarjetaCredito(tarjetacreditos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TarjetaCreditoConstantesFunciones.refrescarForeignKeysDescripcionesTarjetaCredito(this.tarjetacreditos);
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
		tarjetacreditos = new  ArrayList<TarjetaCredito>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TarjetaCredito.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TarjetaCreditoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tarjetacreditos=tarjetacreditoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTarjetaCredito(tarjetacreditos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TarjetaCreditoConstantesFunciones.refrescarForeignKeysDescripcionesTarjetaCredito(this.tarjetacreditos);
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
		tarjetacreditos = new  ArrayList<TarjetaCredito>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TarjetaCreditoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tarjetacreditos=tarjetacreditoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTarjetaCredito(tarjetacreditos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TarjetaCreditoConstantesFunciones.refrescarForeignKeysDescripcionesTarjetaCredito(this.tarjetacreditos);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		tarjetacredito = new  TarjetaCredito();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TarjetaCredito.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TarjetaCreditoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tarjetacredito=tarjetacreditoDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTarjetaCredito(tarjetacredito);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TarjetaCreditoConstantesFunciones.refrescarForeignKeysDescripcionesTarjetaCredito(this.tarjetacredito);
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
		tarjetacredito = new  TarjetaCredito();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TarjetaCreditoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tarjetacredito=tarjetacreditoDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTarjetaCredito(tarjetacredito);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TarjetaCreditoConstantesFunciones.refrescarForeignKeysDescripcionesTarjetaCredito(this.tarjetacredito);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		tarjetacreditos = new  ArrayList<TarjetaCredito>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TarjetaCredito.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			TarjetaCreditoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tarjetacreditos=tarjetacreditoDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTarjetaCredito(tarjetacreditos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TarjetaCreditoConstantesFunciones.refrescarForeignKeysDescripcionesTarjetaCredito(this.tarjetacreditos);
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
		tarjetacreditos = new  ArrayList<TarjetaCredito>();
		  		  
        try {
			TarjetaCreditoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tarjetacreditos=tarjetacreditoDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTarjetaCredito(tarjetacreditos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TarjetaCreditoConstantesFunciones.refrescarForeignKeysDescripcionesTarjetaCredito(this.tarjetacreditos);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosTarjetaCreditosWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		tarjetacreditos = new  ArrayList<TarjetaCredito>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TarjetaCredito.class.getSimpleName()+"-getTodosTarjetaCreditosWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TarjetaCreditoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tarjetacreditos=tarjetacreditoDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarTarjetaCredito(tarjetacreditos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TarjetaCreditoConstantesFunciones.refrescarForeignKeysDescripcionesTarjetaCredito(this.tarjetacreditos);
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
	
	public  void  getTodosTarjetaCreditos(String sFinalQuery,Pagination pagination)throws Exception {
		tarjetacreditos = new  ArrayList<TarjetaCredito>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TarjetaCreditoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tarjetacreditos=tarjetacreditoDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarTarjetaCredito(tarjetacreditos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TarjetaCreditoConstantesFunciones.refrescarForeignKeysDescripcionesTarjetaCredito(this.tarjetacreditos);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarTarjetaCredito(TarjetaCredito tarjetacredito) throws Exception {
		Boolean estaValidado=false;
		
		if(tarjetacredito.getIsNew() || tarjetacredito.getIsChanged()) { 
			this.invalidValues = tarjetacreditoValidator.getInvalidValues(tarjetacredito);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(tarjetacredito);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarTarjetaCredito(List<TarjetaCredito> TarjetaCreditos) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(TarjetaCredito tarjetacreditoLocal:tarjetacreditos) {				
			estaValidadoObjeto=this.validarGuardarTarjetaCredito(tarjetacreditoLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarTarjetaCredito(List<TarjetaCredito> TarjetaCreditos) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarTarjetaCredito(tarjetacreditos)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarTarjetaCredito(TarjetaCredito TarjetaCredito) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarTarjetaCredito(tarjetacredito)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(TarjetaCredito tarjetacredito) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+tarjetacredito.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=TarjetaCreditoConstantesFunciones.getTarjetaCreditoLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"tarjetacredito","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(TarjetaCreditoConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(TarjetaCreditoConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveTarjetaCreditoWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TarjetaCredito.class.getSimpleName()+"-saveTarjetaCreditoWithConnection");connexion.begin();			
			
			TarjetaCreditoLogicAdditional.checkTarjetaCreditoToSave(this.tarjetacredito,this.datosCliente,connexion,this.arrDatoGeneral);
			
			TarjetaCreditoLogicAdditional.updateTarjetaCreditoToSave(this.tarjetacredito,this.arrDatoGeneral);
			
			TarjetaCreditoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.tarjetacredito,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowTarjetaCredito();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarTarjetaCredito(this.tarjetacredito)) {
				TarjetaCreditoDataAccess.save(this.tarjetacredito, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.tarjetacredito,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			TarjetaCreditoLogicAdditional.checkTarjetaCreditoToSaveAfter(this.tarjetacredito,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowTarjetaCredito();
			
			connexion.commit();			
			
			if(this.tarjetacredito.getIsDeleted()) {
				this.tarjetacredito=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveTarjetaCredito()throws Exception {	
		try {	
			
			TarjetaCreditoLogicAdditional.checkTarjetaCreditoToSave(this.tarjetacredito,this.datosCliente,connexion,this.arrDatoGeneral);
			
			TarjetaCreditoLogicAdditional.updateTarjetaCreditoToSave(this.tarjetacredito,this.arrDatoGeneral);
			
			TarjetaCreditoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.tarjetacredito,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarTarjetaCredito(this.tarjetacredito)) {			
				TarjetaCreditoDataAccess.save(this.tarjetacredito, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.tarjetacredito,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			TarjetaCreditoLogicAdditional.checkTarjetaCreditoToSaveAfter(this.tarjetacredito,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.tarjetacredito.getIsDeleted()) {
				this.tarjetacredito=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveTarjetaCreditosWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TarjetaCredito.class.getSimpleName()+"-saveTarjetaCreditosWithConnection");connexion.begin();			
			
			TarjetaCreditoLogicAdditional.checkTarjetaCreditoToSaves(tarjetacreditos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowTarjetaCreditos();
			
			Boolean validadoTodosTarjetaCredito=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(TarjetaCredito tarjetacreditoLocal:tarjetacreditos) {		
				if(tarjetacreditoLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				TarjetaCreditoLogicAdditional.updateTarjetaCreditoToSave(tarjetacreditoLocal,this.arrDatoGeneral);
	        	
				TarjetaCreditoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),tarjetacreditoLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarTarjetaCredito(tarjetacreditoLocal)) {
					TarjetaCreditoDataAccess.save(tarjetacreditoLocal, connexion);				
				} else {
					validadoTodosTarjetaCredito=false;
				}
			}
			
			if(!validadoTodosTarjetaCredito) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			TarjetaCreditoLogicAdditional.checkTarjetaCreditoToSavesAfter(tarjetacreditos,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowTarjetaCreditos();
			
			connexion.commit();		
			
			this.quitarTarjetaCreditosEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveTarjetaCreditos()throws Exception {				
		 try {	
			TarjetaCreditoLogicAdditional.checkTarjetaCreditoToSaves(tarjetacreditos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosTarjetaCredito=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(TarjetaCredito tarjetacreditoLocal:tarjetacreditos) {				
				if(tarjetacreditoLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				TarjetaCreditoLogicAdditional.updateTarjetaCreditoToSave(tarjetacreditoLocal,this.arrDatoGeneral);
	        	
				TarjetaCreditoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),tarjetacreditoLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarTarjetaCredito(tarjetacreditoLocal)) {				
					TarjetaCreditoDataAccess.save(tarjetacreditoLocal, connexion);				
				} else {
					validadoTodosTarjetaCredito=false;
				}
			}
			
			if(!validadoTodosTarjetaCredito) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			TarjetaCreditoLogicAdditional.checkTarjetaCreditoToSavesAfter(tarjetacreditos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarTarjetaCreditosEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public TarjetaCreditoParameterReturnGeneral procesarAccionTarjetaCreditos(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<TarjetaCredito> tarjetacreditos,TarjetaCreditoParameterReturnGeneral tarjetacreditoParameterGeneral)throws Exception {
		 try {	
			TarjetaCreditoParameterReturnGeneral tarjetacreditoReturnGeneral=new TarjetaCreditoParameterReturnGeneral();
	
			TarjetaCreditoLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,tarjetacreditos,tarjetacreditoParameterGeneral,tarjetacreditoReturnGeneral);
			
			return tarjetacreditoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public TarjetaCreditoParameterReturnGeneral procesarAccionTarjetaCreditosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<TarjetaCredito> tarjetacreditos,TarjetaCreditoParameterReturnGeneral tarjetacreditoParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TarjetaCredito.class.getSimpleName()+"-procesarAccionTarjetaCreditosWithConnection");connexion.begin();			
			
			TarjetaCreditoParameterReturnGeneral tarjetacreditoReturnGeneral=new TarjetaCreditoParameterReturnGeneral();
	
			TarjetaCreditoLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,tarjetacreditos,tarjetacreditoParameterGeneral,tarjetacreditoReturnGeneral);
			
			this.connexion.commit();
			
			return tarjetacreditoReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public TarjetaCreditoParameterReturnGeneral procesarEventosTarjetaCreditos(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<TarjetaCredito> tarjetacreditos,TarjetaCredito tarjetacredito,TarjetaCreditoParameterReturnGeneral tarjetacreditoParameterGeneral,Boolean isEsNuevoTarjetaCredito,ArrayList<Classe> clases)throws Exception {
		 try {	
			TarjetaCreditoParameterReturnGeneral tarjetacreditoReturnGeneral=new TarjetaCreditoParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				tarjetacreditoReturnGeneral.setConRecargarPropiedades(true);
			}
			
			TarjetaCreditoLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,tarjetacreditos,tarjetacredito,tarjetacreditoParameterGeneral,tarjetacreditoReturnGeneral,isEsNuevoTarjetaCredito,clases);
			
			return tarjetacreditoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public TarjetaCreditoParameterReturnGeneral procesarEventosTarjetaCreditosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<TarjetaCredito> tarjetacreditos,TarjetaCredito tarjetacredito,TarjetaCreditoParameterReturnGeneral tarjetacreditoParameterGeneral,Boolean isEsNuevoTarjetaCredito,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TarjetaCredito.class.getSimpleName()+"-procesarEventosTarjetaCreditosWithConnection");connexion.begin();			
			
			TarjetaCreditoParameterReturnGeneral tarjetacreditoReturnGeneral=new TarjetaCreditoParameterReturnGeneral();
	
			tarjetacreditoReturnGeneral.setTarjetaCredito(tarjetacredito);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				tarjetacreditoReturnGeneral.setConRecargarPropiedades(true);
			}
			
			TarjetaCreditoLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,tarjetacreditos,tarjetacredito,tarjetacreditoParameterGeneral,tarjetacreditoReturnGeneral,isEsNuevoTarjetaCredito,clases);
			
			this.connexion.commit();
			
			return tarjetacreditoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public TarjetaCreditoParameterReturnGeneral procesarImportacionTarjetaCreditosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,TarjetaCreditoParameterReturnGeneral tarjetacreditoParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TarjetaCredito.class.getSimpleName()+"-procesarImportacionTarjetaCreditosWithConnection");connexion.begin();			
			
			TarjetaCreditoParameterReturnGeneral tarjetacreditoReturnGeneral=new TarjetaCreditoParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.tarjetacreditos=new ArrayList<TarjetaCredito>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.tarjetacredito=new TarjetaCredito();
				
				
				if(conColumnasBase) {this.tarjetacredito.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.tarjetacredito.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.tarjetacredito.setcodigo(arrColumnas[iColumn++]);
				this.tarjetacredito.setnombre(arrColumnas[iColumn++]);
				this.tarjetacredito.setnombre_corto(arrColumnas[iColumn++]);
				this.tarjetacredito.setdigito_valido(Integer.parseInt(arrColumnas[iColumn++]));
				this.tarjetacredito.setdigito_tarjeta(Integer.parseInt(arrColumnas[iColumn++]));
				this.tarjetacredito.setcomision(Double.parseDouble(arrColumnas[iColumn++]));
				this.tarjetacredito.setinteres(Double.parseDouble(arrColumnas[iColumn++]));
				this.tarjetacredito.setmonto_minimo(Double.parseDouble(arrColumnas[iColumn++]));
				this.tarjetacredito.setporcentaje_retencion(Double.parseDouble(arrColumnas[iColumn++]));
				this.tarjetacredito.setcomision_retencion(Double.parseDouble(arrColumnas[iColumn++]));
				this.tarjetacredito.setes_retencion_redondeo(Boolean.parseBoolean(arrColumnas[iColumn++]));
				this.tarjetacredito.setes_pago_banco_redondeo(Boolean.parseBoolean(arrColumnas[iColumn++]));
				this.tarjetacredito.setes_comision_redondeo(Boolean.parseBoolean(arrColumnas[iColumn++]));
				
				this.tarjetacreditos.add(this.tarjetacredito);
			}
			
			this.saveTarjetaCreditos();
			
			this.connexion.commit();
			
			tarjetacreditoReturnGeneral.setConRetornoEstaProcesado(true);
			tarjetacreditoReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return tarjetacreditoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarTarjetaCreditosEliminados() throws Exception {				
		
		List<TarjetaCredito> tarjetacreditosAux= new ArrayList<TarjetaCredito>();
		
		for(TarjetaCredito tarjetacredito:tarjetacreditos) {
			if(!tarjetacredito.getIsDeleted()) {
				tarjetacreditosAux.add(tarjetacredito);
			}
		}
		
		tarjetacreditos=tarjetacreditosAux;
	}
	
	public void quitarTarjetaCreditosNulos() throws Exception {				
		
		List<TarjetaCredito> tarjetacreditosAux= new ArrayList<TarjetaCredito>();
		
		for(TarjetaCredito tarjetacredito : this.tarjetacreditos) {
			if(tarjetacredito==null) {
				tarjetacreditosAux.add(tarjetacredito);
			}
		}
		
		//this.tarjetacreditos=tarjetacreditosAux;
		
		this.tarjetacreditos.removeAll(tarjetacreditosAux);
	}
	
	public void getSetVersionRowTarjetaCreditoWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(tarjetacredito.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((tarjetacredito.getIsDeleted() || (tarjetacredito.getIsChanged()&&!tarjetacredito.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=tarjetacreditoDataAccess.getSetVersionRowTarjetaCredito(connexion,tarjetacredito.getId());
				
				if(!tarjetacredito.getVersionRow().equals(timestamp)) {	
					tarjetacredito.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				tarjetacredito.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowTarjetaCredito()throws Exception {	
		
		if(tarjetacredito.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((tarjetacredito.getIsDeleted() || (tarjetacredito.getIsChanged()&&!tarjetacredito.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=tarjetacreditoDataAccess.getSetVersionRowTarjetaCredito(connexion,tarjetacredito.getId());
			
			try {							
				if(!tarjetacredito.getVersionRow().equals(timestamp)) {	
					tarjetacredito.setVersionRow(timestamp);
				}
				
				tarjetacredito.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowTarjetaCreditosWithConnection()throws Exception {	
		if(tarjetacreditos!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(TarjetaCredito tarjetacreditoAux:tarjetacreditos) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(tarjetacreditoAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(tarjetacreditoAux.getIsDeleted() || (tarjetacreditoAux.getIsChanged()&&!tarjetacreditoAux.getIsNew())) {
						
						timestamp=tarjetacreditoDataAccess.getSetVersionRowTarjetaCredito(connexion,tarjetacreditoAux.getId());
						
						if(!tarjetacredito.getVersionRow().equals(timestamp)) {	
							tarjetacreditoAux.setVersionRow(timestamp);
						}
								
						tarjetacreditoAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowTarjetaCreditos()throws Exception {	
		if(tarjetacreditos!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(TarjetaCredito tarjetacreditoAux:tarjetacreditos) {
					if(tarjetacreditoAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(tarjetacreditoAux.getIsDeleted() || (tarjetacreditoAux.getIsChanged()&&!tarjetacreditoAux.getIsNew())) {
						
						timestamp=tarjetacreditoDataAccess.getSetVersionRowTarjetaCredito(connexion,tarjetacreditoAux.getId());
						
						if(!tarjetacreditoAux.getVersionRow().equals(timestamp)) {	
							tarjetacreditoAux.setVersionRow(timestamp);
						}
						
													
						tarjetacreditoAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public TarjetaCreditoParameterReturnGeneral cargarCombosLoteForeignKeyTarjetaCreditoWithConnection(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalBanco,String finalQueryGlobalTipoRetencion,String finalQueryGlobalCuentaContable,String finalQueryGlobalTipoRetencionIva,String finalQueryGlobalCuentaContableComision,String finalQueryGlobalFormulaPagoBanco,String finalQueryGlobalCuentaContableDiferencia,String finalQueryGlobalFormulaRetencion,String finalQueryGlobalFormulaComision) throws Exception {
		TarjetaCreditoParameterReturnGeneral  tarjetacreditoReturnGeneral =new TarjetaCreditoParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TarjetaCredito.class.getSimpleName()+"-cargarCombosLoteForeignKeyTarjetaCreditoWithConnection");connexion.begin();
			
			tarjetacreditoReturnGeneral =new TarjetaCreditoParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			tarjetacreditoReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			tarjetacreditoReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Banco> bancosForeignKey=new ArrayList<Banco>();
			BancoLogic bancoLogic=new BancoLogic();
			bancoLogic.setConnexion(this.connexion);
			bancoLogic.getBancoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalBanco.equals("NONE")) {
				bancoLogic.getTodosBancos(finalQueryGlobalBanco,new Pagination());
				bancosForeignKey=bancoLogic.getBancos();
			}

			tarjetacreditoReturnGeneral.setbancosForeignKey(bancosForeignKey);


			List<TipoRetencion> tiporetencionsForeignKey=new ArrayList<TipoRetencion>();
			TipoRetencionLogic tiporetencionLogic=new TipoRetencionLogic();
			tiporetencionLogic.setConnexion(this.connexion);
			tiporetencionLogic.getTipoRetencionDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoRetencion.equals("NONE")) {
				tiporetencionLogic.getTodosTipoRetencions(finalQueryGlobalTipoRetencion,new Pagination());
				tiporetencionsForeignKey=tiporetencionLogic.getTipoRetencions();
			}

			tarjetacreditoReturnGeneral.settiporetencionsForeignKey(tiporetencionsForeignKey);


			List<CuentaContable> cuentacontablesForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontableLogic=new CuentaContableLogic();
			cuentacontableLogic.setConnexion(this.connexion);
			cuentacontableLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContable.equals("NONE")) {
				cuentacontableLogic.getTodosCuentaContables(finalQueryGlobalCuentaContable,new Pagination());
				cuentacontablesForeignKey=cuentacontableLogic.getCuentaContables();
			}

			tarjetacreditoReturnGeneral.setcuentacontablesForeignKey(cuentacontablesForeignKey);


			List<TipoRetencionIva> tiporetencionivasForeignKey=new ArrayList<TipoRetencionIva>();
			TipoRetencionIvaLogic tiporetencionivaLogic=new TipoRetencionIvaLogic();
			tiporetencionivaLogic.setConnexion(this.connexion);
			tiporetencionivaLogic.getTipoRetencionIvaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoRetencionIva.equals("NONE")) {
				tiporetencionivaLogic.getTodosTipoRetencionIvas(finalQueryGlobalTipoRetencionIva,new Pagination());
				tiporetencionivasForeignKey=tiporetencionivaLogic.getTipoRetencionIvas();
			}

			tarjetacreditoReturnGeneral.settiporetencionivasForeignKey(tiporetencionivasForeignKey);


			List<CuentaContable> cuentacontablecomisionsForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontablecomisionLogic=new CuentaContableLogic();
			cuentacontablecomisionLogic.setConnexion(this.connexion);
			cuentacontablecomisionLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContableComision.equals("NONE")) {
				cuentacontablecomisionLogic.getTodosCuentaContables(finalQueryGlobalCuentaContableComision,new Pagination());
				cuentacontablecomisionsForeignKey=cuentacontablecomisionLogic.getCuentaContables();
			}

			tarjetacreditoReturnGeneral.setcuentacontablecomisionsForeignKey(cuentacontablecomisionsForeignKey);


			List<Formula> formulapagobancosForeignKey=new ArrayList<Formula>();
			FormulaLogic formulapagobancoLogic=new FormulaLogic();
			formulapagobancoLogic.setConnexion(this.connexion);
			formulapagobancoLogic.getFormulaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalFormulaPagoBanco.equals("NONE")) {
				formulapagobancoLogic.getTodosFormulas(finalQueryGlobalFormulaPagoBanco,new Pagination());
				formulapagobancosForeignKey=formulapagobancoLogic.getFormulas();
			}

			tarjetacreditoReturnGeneral.setformulapagobancosForeignKey(formulapagobancosForeignKey);


			List<CuentaContable> cuentacontablediferenciasForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontablediferenciaLogic=new CuentaContableLogic();
			cuentacontablediferenciaLogic.setConnexion(this.connexion);
			cuentacontablediferenciaLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContableDiferencia.equals("NONE")) {
				cuentacontablediferenciaLogic.getTodosCuentaContables(finalQueryGlobalCuentaContableDiferencia,new Pagination());
				cuentacontablediferenciasForeignKey=cuentacontablediferenciaLogic.getCuentaContables();
			}

			tarjetacreditoReturnGeneral.setcuentacontablediferenciasForeignKey(cuentacontablediferenciasForeignKey);


			List<Formula> formularetencionsForeignKey=new ArrayList<Formula>();
			FormulaLogic formularetencionLogic=new FormulaLogic();
			formularetencionLogic.setConnexion(this.connexion);
			formularetencionLogic.getFormulaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalFormulaRetencion.equals("NONE")) {
				formularetencionLogic.getTodosFormulas(finalQueryGlobalFormulaRetencion,new Pagination());
				formularetencionsForeignKey=formularetencionLogic.getFormulas();
			}

			tarjetacreditoReturnGeneral.setformularetencionsForeignKey(formularetencionsForeignKey);


			List<Formula> formulacomisionsForeignKey=new ArrayList<Formula>();
			FormulaLogic formulacomisionLogic=new FormulaLogic();
			formulacomisionLogic.setConnexion(this.connexion);
			formulacomisionLogic.getFormulaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalFormulaComision.equals("NONE")) {
				formulacomisionLogic.getTodosFormulas(finalQueryGlobalFormulaComision,new Pagination());
				formulacomisionsForeignKey=formulacomisionLogic.getFormulas();
			}

			tarjetacreditoReturnGeneral.setformulacomisionsForeignKey(formulacomisionsForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return tarjetacreditoReturnGeneral;
	}
	
	public TarjetaCreditoParameterReturnGeneral cargarCombosLoteForeignKeyTarjetaCredito(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalBanco,String finalQueryGlobalTipoRetencion,String finalQueryGlobalCuentaContable,String finalQueryGlobalTipoRetencionIva,String finalQueryGlobalCuentaContableComision,String finalQueryGlobalFormulaPagoBanco,String finalQueryGlobalCuentaContableDiferencia,String finalQueryGlobalFormulaRetencion,String finalQueryGlobalFormulaComision) throws Exception {
		TarjetaCreditoParameterReturnGeneral  tarjetacreditoReturnGeneral =new TarjetaCreditoParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			tarjetacreditoReturnGeneral =new TarjetaCreditoParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			tarjetacreditoReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			tarjetacreditoReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Banco> bancosForeignKey=new ArrayList<Banco>();
			BancoLogic bancoLogic=new BancoLogic();
			bancoLogic.setConnexion(this.connexion);
			bancoLogic.getBancoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalBanco.equals("NONE")) {
				bancoLogic.getTodosBancos(finalQueryGlobalBanco,new Pagination());
				bancosForeignKey=bancoLogic.getBancos();
			}

			tarjetacreditoReturnGeneral.setbancosForeignKey(bancosForeignKey);


			List<TipoRetencion> tiporetencionsForeignKey=new ArrayList<TipoRetencion>();
			TipoRetencionLogic tiporetencionLogic=new TipoRetencionLogic();
			tiporetencionLogic.setConnexion(this.connexion);
			tiporetencionLogic.getTipoRetencionDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoRetencion.equals("NONE")) {
				tiporetencionLogic.getTodosTipoRetencions(finalQueryGlobalTipoRetencion,new Pagination());
				tiporetencionsForeignKey=tiporetencionLogic.getTipoRetencions();
			}

			tarjetacreditoReturnGeneral.settiporetencionsForeignKey(tiporetencionsForeignKey);


			List<CuentaContable> cuentacontablesForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontableLogic=new CuentaContableLogic();
			cuentacontableLogic.setConnexion(this.connexion);
			cuentacontableLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContable.equals("NONE")) {
				cuentacontableLogic.getTodosCuentaContables(finalQueryGlobalCuentaContable,new Pagination());
				cuentacontablesForeignKey=cuentacontableLogic.getCuentaContables();
			}

			tarjetacreditoReturnGeneral.setcuentacontablesForeignKey(cuentacontablesForeignKey);


			List<TipoRetencionIva> tiporetencionivasForeignKey=new ArrayList<TipoRetencionIva>();
			TipoRetencionIvaLogic tiporetencionivaLogic=new TipoRetencionIvaLogic();
			tiporetencionivaLogic.setConnexion(this.connexion);
			tiporetencionivaLogic.getTipoRetencionIvaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoRetencionIva.equals("NONE")) {
				tiporetencionivaLogic.getTodosTipoRetencionIvas(finalQueryGlobalTipoRetencionIva,new Pagination());
				tiporetencionivasForeignKey=tiporetencionivaLogic.getTipoRetencionIvas();
			}

			tarjetacreditoReturnGeneral.settiporetencionivasForeignKey(tiporetencionivasForeignKey);


			List<CuentaContable> cuentacontablecomisionsForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontablecomisionLogic=new CuentaContableLogic();
			cuentacontablecomisionLogic.setConnexion(this.connexion);
			cuentacontablecomisionLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContableComision.equals("NONE")) {
				cuentacontablecomisionLogic.getTodosCuentaContables(finalQueryGlobalCuentaContableComision,new Pagination());
				cuentacontablecomisionsForeignKey=cuentacontablecomisionLogic.getCuentaContables();
			}

			tarjetacreditoReturnGeneral.setcuentacontablecomisionsForeignKey(cuentacontablecomisionsForeignKey);


			List<Formula> formulapagobancosForeignKey=new ArrayList<Formula>();
			FormulaLogic formulapagobancoLogic=new FormulaLogic();
			formulapagobancoLogic.setConnexion(this.connexion);
			formulapagobancoLogic.getFormulaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalFormulaPagoBanco.equals("NONE")) {
				formulapagobancoLogic.getTodosFormulas(finalQueryGlobalFormulaPagoBanco,new Pagination());
				formulapagobancosForeignKey=formulapagobancoLogic.getFormulas();
			}

			tarjetacreditoReturnGeneral.setformulapagobancosForeignKey(formulapagobancosForeignKey);


			List<CuentaContable> cuentacontablediferenciasForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontablediferenciaLogic=new CuentaContableLogic();
			cuentacontablediferenciaLogic.setConnexion(this.connexion);
			cuentacontablediferenciaLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContableDiferencia.equals("NONE")) {
				cuentacontablediferenciaLogic.getTodosCuentaContables(finalQueryGlobalCuentaContableDiferencia,new Pagination());
				cuentacontablediferenciasForeignKey=cuentacontablediferenciaLogic.getCuentaContables();
			}

			tarjetacreditoReturnGeneral.setcuentacontablediferenciasForeignKey(cuentacontablediferenciasForeignKey);


			List<Formula> formularetencionsForeignKey=new ArrayList<Formula>();
			FormulaLogic formularetencionLogic=new FormulaLogic();
			formularetencionLogic.setConnexion(this.connexion);
			formularetencionLogic.getFormulaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalFormulaRetencion.equals("NONE")) {
				formularetencionLogic.getTodosFormulas(finalQueryGlobalFormulaRetencion,new Pagination());
				formularetencionsForeignKey=formularetencionLogic.getFormulas();
			}

			tarjetacreditoReturnGeneral.setformularetencionsForeignKey(formularetencionsForeignKey);


			List<Formula> formulacomisionsForeignKey=new ArrayList<Formula>();
			FormulaLogic formulacomisionLogic=new FormulaLogic();
			formulacomisionLogic.setConnexion(this.connexion);
			formulacomisionLogic.getFormulaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalFormulaComision.equals("NONE")) {
				formulacomisionLogic.getTodosFormulas(finalQueryGlobalFormulaComision,new Pagination());
				formulacomisionsForeignKey=formulacomisionLogic.getFormulas();
			}

			tarjetacreditoReturnGeneral.setformulacomisionsForeignKey(formulacomisionsForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return tarjetacreditoReturnGeneral;
	}
	
	public void cargarRelacionesLoteForeignKeyTarjetaCreditoWithConnection() throws Exception {
		ArrayList<Classe> classes=new ArrayList<Classe>();		
		
		
			TarjetaCreditoConexionLogic tarjetacreditoconexionLogic=new TarjetaCreditoConexionLogic();
			TarjetaCreditoDescuentoLogic tarjetacreditodescuentoLogic=new TarjetaCreditoDescuentoLogic();
			FormaPagoPuntoVentaLogic formapagopuntoventaLogic=new FormaPagoPuntoVentaLogic();
		
		try {
			
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TarjetaCredito.class.getSimpleName()+"-cargarRelacionesLoteForeignKeyTarjetaCreditoWithConnection");connexion.begin();
			
			
			classes.add(new Classe(TarjetaCreditoConexion.class));
			classes.add(new Classe(TarjetaCreditoDescuento.class));
			classes.add(new Classe(FormaPagoPuntoVenta.class));
											
			

			tarjetacreditoconexionLogic.setConnexion(this.getConnexion());
			tarjetacreditoconexionLogic.setDatosCliente(this.datosCliente);
			tarjetacreditoconexionLogic.setIsConRefrescarForeignKeys(true);

			tarjetacreditodescuentoLogic.setConnexion(this.getConnexion());
			tarjetacreditodescuentoLogic.setDatosCliente(this.datosCliente);
			tarjetacreditodescuentoLogic.setIsConRefrescarForeignKeys(true);

			formapagopuntoventaLogic.setConnexion(this.getConnexion());
			formapagopuntoventaLogic.setDatosCliente(this.datosCliente);
			formapagopuntoventaLogic.setIsConRefrescarForeignKeys(true);
			
			this.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
			
			for(TarjetaCredito tarjetacredito:this.tarjetacreditos) {
				

				classes=new ArrayList<Classe>();
				classes=TarjetaCreditoConexionConstantesFunciones.getClassesForeignKeysOfTarjetaCreditoConexion(new ArrayList<Classe>(),DeepLoadType.NONE);

				tarjetacreditoconexionLogic.setTarjetaCreditoConexions(tarjetacredito.tarjetacreditoconexions);
				tarjetacreditoconexionLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=TarjetaCreditoDescuentoConstantesFunciones.getClassesForeignKeysOfTarjetaCreditoDescuento(new ArrayList<Classe>(),DeepLoadType.NONE);

				tarjetacreditodescuentoLogic.setTarjetaCreditoDescuentos(tarjetacredito.tarjetacreditodescuentos);
				tarjetacreditodescuentoLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=FormaPagoPuntoVentaConstantesFunciones.getClassesForeignKeysOfFormaPagoPuntoVenta(new ArrayList<Classe>(),DeepLoadType.NONE);

				formapagopuntoventaLogic.setFormaPagoPuntoVentas(tarjetacredito.formapagopuntoventas);
				formapagopuntoventaLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
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
	
	public void deepLoad(TarjetaCredito tarjetacredito,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			TarjetaCreditoLogicAdditional.updateTarjetaCreditoToGet(tarjetacredito,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		tarjetacredito.setEmpresa(tarjetacreditoDataAccess.getEmpresa(connexion,tarjetacredito));
		tarjetacredito.setSucursal(tarjetacreditoDataAccess.getSucursal(connexion,tarjetacredito));
		tarjetacredito.setBanco(tarjetacreditoDataAccess.getBanco(connexion,tarjetacredito));
		tarjetacredito.setTipoRetencion(tarjetacreditoDataAccess.getTipoRetencion(connexion,tarjetacredito));
		tarjetacredito.setCuentaContable(tarjetacreditoDataAccess.getCuentaContable(connexion,tarjetacredito));
		tarjetacredito.setTipoRetencionIva(tarjetacreditoDataAccess.getTipoRetencionIva(connexion,tarjetacredito));
		tarjetacredito.setCuentaContableComision(tarjetacreditoDataAccess.getCuentaContableComision(connexion,tarjetacredito));
		tarjetacredito.setFormulaPagoBanco(tarjetacreditoDataAccess.getFormulaPagoBanco(connexion,tarjetacredito));
		tarjetacredito.setCuentaContableDiferencia(tarjetacreditoDataAccess.getCuentaContableDiferencia(connexion,tarjetacredito));
		tarjetacredito.setFormulaRetencion(tarjetacreditoDataAccess.getFormulaRetencion(connexion,tarjetacredito));
		tarjetacredito.setFormulaComision(tarjetacreditoDataAccess.getFormulaComision(connexion,tarjetacredito));
		tarjetacredito.setTarjetaCreditoConexions(tarjetacreditoDataAccess.getTarjetaCreditoConexions(connexion,tarjetacredito));
		tarjetacredito.setTarjetaCreditoDescuentos(tarjetacreditoDataAccess.getTarjetaCreditoDescuentos(connexion,tarjetacredito));
		tarjetacredito.setFormaPagoPuntoVentas(tarjetacreditoDataAccess.getFormaPagoPuntoVentas(connexion,tarjetacredito));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				tarjetacredito.setEmpresa(tarjetacreditoDataAccess.getEmpresa(connexion,tarjetacredito));
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				tarjetacredito.setSucursal(tarjetacreditoDataAccess.getSucursal(connexion,tarjetacredito));
				continue;
			}

			if(clas.clas.equals(Banco.class)) {
				tarjetacredito.setBanco(tarjetacreditoDataAccess.getBanco(connexion,tarjetacredito));
				continue;
			}

			if(clas.clas.equals(TipoRetencion.class)) {
				tarjetacredito.setTipoRetencion(tarjetacreditoDataAccess.getTipoRetencion(connexion,tarjetacredito));
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				tarjetacredito.setCuentaContable(tarjetacreditoDataAccess.getCuentaContable(connexion,tarjetacredito));
				continue;
			}

			if(clas.clas.equals(TipoRetencionIva.class)) {
				tarjetacredito.setTipoRetencionIva(tarjetacreditoDataAccess.getTipoRetencionIva(connexion,tarjetacredito));
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				tarjetacredito.setCuentaContableComision(tarjetacreditoDataAccess.getCuentaContableComision(connexion,tarjetacredito));
				continue;
			}

			if(clas.clas.equals(Formula.class)) {
				tarjetacredito.setFormulaPagoBanco(tarjetacreditoDataAccess.getFormulaPagoBanco(connexion,tarjetacredito));
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				tarjetacredito.setCuentaContableDiferencia(tarjetacreditoDataAccess.getCuentaContableDiferencia(connexion,tarjetacredito));
				continue;
			}

			if(clas.clas.equals(Formula.class)) {
				tarjetacredito.setFormulaRetencion(tarjetacreditoDataAccess.getFormulaRetencion(connexion,tarjetacredito));
				continue;
			}

			if(clas.clas.equals(Formula.class)) {
				tarjetacredito.setFormulaComision(tarjetacreditoDataAccess.getFormulaComision(connexion,tarjetacredito));
				continue;
			}

			if(clas.clas.equals(TarjetaCreditoConexion.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tarjetacredito.setTarjetaCreditoConexions(tarjetacreditoDataAccess.getTarjetaCreditoConexions(connexion,tarjetacredito));

				if(this.isConDeep) {
					TarjetaCreditoConexionLogic tarjetacreditoconexionLogic= new TarjetaCreditoConexionLogic(this.connexion);
					tarjetacreditoconexionLogic.setTarjetaCreditoConexions(tarjetacredito.getTarjetaCreditoConexions());
					ArrayList<Classe> classesLocal=TarjetaCreditoConexionConstantesFunciones.getClassesForeignKeysOfTarjetaCreditoConexion(new ArrayList<Classe>(),DeepLoadType.NONE);
					tarjetacreditoconexionLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					TarjetaCreditoConexionConstantesFunciones.refrescarForeignKeysDescripcionesTarjetaCreditoConexion(tarjetacreditoconexionLogic.getTarjetaCreditoConexions());
					tarjetacredito.setTarjetaCreditoConexions(tarjetacreditoconexionLogic.getTarjetaCreditoConexions());
				}

				continue;
			}

			if(clas.clas.equals(TarjetaCreditoDescuento.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tarjetacredito.setTarjetaCreditoDescuentos(tarjetacreditoDataAccess.getTarjetaCreditoDescuentos(connexion,tarjetacredito));

				if(this.isConDeep) {
					TarjetaCreditoDescuentoLogic tarjetacreditodescuentoLogic= new TarjetaCreditoDescuentoLogic(this.connexion);
					tarjetacreditodescuentoLogic.setTarjetaCreditoDescuentos(tarjetacredito.getTarjetaCreditoDescuentos());
					ArrayList<Classe> classesLocal=TarjetaCreditoDescuentoConstantesFunciones.getClassesForeignKeysOfTarjetaCreditoDescuento(new ArrayList<Classe>(),DeepLoadType.NONE);
					tarjetacreditodescuentoLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					TarjetaCreditoDescuentoConstantesFunciones.refrescarForeignKeysDescripcionesTarjetaCreditoDescuento(tarjetacreditodescuentoLogic.getTarjetaCreditoDescuentos());
					tarjetacredito.setTarjetaCreditoDescuentos(tarjetacreditodescuentoLogic.getTarjetaCreditoDescuentos());
				}

				continue;
			}

			if(clas.clas.equals(FormaPagoPuntoVenta.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tarjetacredito.setFormaPagoPuntoVentas(tarjetacreditoDataAccess.getFormaPagoPuntoVentas(connexion,tarjetacredito));

				if(this.isConDeep) {
					FormaPagoPuntoVentaLogic formapagopuntoventaLogic= new FormaPagoPuntoVentaLogic(this.connexion);
					formapagopuntoventaLogic.setFormaPagoPuntoVentas(tarjetacredito.getFormaPagoPuntoVentas());
					ArrayList<Classe> classesLocal=FormaPagoPuntoVentaConstantesFunciones.getClassesForeignKeysOfFormaPagoPuntoVenta(new ArrayList<Classe>(),DeepLoadType.NONE);
					formapagopuntoventaLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					FormaPagoPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesFormaPagoPuntoVenta(formapagopuntoventaLogic.getFormaPagoPuntoVentas());
					tarjetacredito.setFormaPagoPuntoVentas(formapagopuntoventaLogic.getFormaPagoPuntoVentas());
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
			tarjetacredito.setEmpresa(tarjetacreditoDataAccess.getEmpresa(connexion,tarjetacredito));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			tarjetacredito.setSucursal(tarjetacreditoDataAccess.getSucursal(connexion,tarjetacredito));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Banco.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			tarjetacredito.setBanco(tarjetacreditoDataAccess.getBanco(connexion,tarjetacredito));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoRetencion.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			tarjetacredito.setTipoRetencion(tarjetacreditoDataAccess.getTipoRetencion(connexion,tarjetacredito));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			tarjetacredito.setCuentaContable(tarjetacreditoDataAccess.getCuentaContable(connexion,tarjetacredito));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoRetencionIva.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			tarjetacredito.setTipoRetencionIva(tarjetacreditoDataAccess.getTipoRetencionIva(connexion,tarjetacredito));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			tarjetacredito.setCuentaContableComision(tarjetacreditoDataAccess.getCuentaContableComision(connexion,tarjetacredito));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Formula.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			tarjetacredito.setFormulaPagoBanco(tarjetacreditoDataAccess.getFormulaPagoBanco(connexion,tarjetacredito));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			tarjetacredito.setCuentaContableDiferencia(tarjetacreditoDataAccess.getCuentaContableDiferencia(connexion,tarjetacredito));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Formula.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			tarjetacredito.setFormulaRetencion(tarjetacreditoDataAccess.getFormulaRetencion(connexion,tarjetacredito));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Formula.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			tarjetacredito.setFormulaComision(tarjetacreditoDataAccess.getFormulaComision(connexion,tarjetacredito));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TarjetaCreditoConexion.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(TarjetaCreditoConexion.class));
			tarjetacredito.setTarjetaCreditoConexions(tarjetacreditoDataAccess.getTarjetaCreditoConexions(connexion,tarjetacredito));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TarjetaCreditoDescuento.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(TarjetaCreditoDescuento.class));
			tarjetacredito.setTarjetaCreditoDescuentos(tarjetacreditoDataAccess.getTarjetaCreditoDescuentos(connexion,tarjetacredito));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(FormaPagoPuntoVenta.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(FormaPagoPuntoVenta.class));
			tarjetacredito.setFormaPagoPuntoVentas(tarjetacreditoDataAccess.getFormaPagoPuntoVentas(connexion,tarjetacredito));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		tarjetacredito.setEmpresa(tarjetacreditoDataAccess.getEmpresa(connexion,tarjetacredito));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(tarjetacredito.getEmpresa(),isDeep,deepLoadType,clases);
				
		tarjetacredito.setSucursal(tarjetacreditoDataAccess.getSucursal(connexion,tarjetacredito));
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(tarjetacredito.getSucursal(),isDeep,deepLoadType,clases);
				
		tarjetacredito.setBanco(tarjetacreditoDataAccess.getBanco(connexion,tarjetacredito));
		BancoLogic bancoLogic= new BancoLogic(connexion);
		bancoLogic.deepLoad(tarjetacredito.getBanco(),isDeep,deepLoadType,clases);
				
		tarjetacredito.setTipoRetencion(tarjetacreditoDataAccess.getTipoRetencion(connexion,tarjetacredito));
		TipoRetencionLogic tiporetencionLogic= new TipoRetencionLogic(connexion);
		tiporetencionLogic.deepLoad(tarjetacredito.getTipoRetencion(),isDeep,deepLoadType,clases);
				
		tarjetacredito.setCuentaContable(tarjetacreditoDataAccess.getCuentaContable(connexion,tarjetacredito));
		CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
		cuentacontableLogic.deepLoad(tarjetacredito.getCuentaContable(),isDeep,deepLoadType,clases);
				
		tarjetacredito.setTipoRetencionIva(tarjetacreditoDataAccess.getTipoRetencionIva(connexion,tarjetacredito));
		TipoRetencionIvaLogic tiporetencionivaLogic= new TipoRetencionIvaLogic(connexion);
		tiporetencionivaLogic.deepLoad(tarjetacredito.getTipoRetencionIva(),isDeep,deepLoadType,clases);
				
		tarjetacredito.setCuentaContableComision(tarjetacreditoDataAccess.getCuentaContableComision(connexion,tarjetacredito));
		CuentaContableLogic cuentacontablecomisionLogic= new CuentaContableLogic(connexion);
		cuentacontablecomisionLogic.deepLoad(tarjetacredito.getCuentaContableComision(),isDeep,deepLoadType,clases);
				
		tarjetacredito.setFormulaPagoBanco(tarjetacreditoDataAccess.getFormulaPagoBanco(connexion,tarjetacredito));
		FormulaLogic formulapagobancoLogic= new FormulaLogic(connexion);
		formulapagobancoLogic.deepLoad(tarjetacredito.getFormulaPagoBanco(),isDeep,deepLoadType,clases);
				
		tarjetacredito.setCuentaContableDiferencia(tarjetacreditoDataAccess.getCuentaContableDiferencia(connexion,tarjetacredito));
		CuentaContableLogic cuentacontablediferenciaLogic= new CuentaContableLogic(connexion);
		cuentacontablediferenciaLogic.deepLoad(tarjetacredito.getCuentaContableDiferencia(),isDeep,deepLoadType,clases);
				
		tarjetacredito.setFormulaRetencion(tarjetacreditoDataAccess.getFormulaRetencion(connexion,tarjetacredito));
		FormulaLogic formularetencionLogic= new FormulaLogic(connexion);
		formularetencionLogic.deepLoad(tarjetacredito.getFormulaRetencion(),isDeep,deepLoadType,clases);
				
		tarjetacredito.setFormulaComision(tarjetacreditoDataAccess.getFormulaComision(connexion,tarjetacredito));
		FormulaLogic formulacomisionLogic= new FormulaLogic(connexion);
		formulacomisionLogic.deepLoad(tarjetacredito.getFormulaComision(),isDeep,deepLoadType,clases);
				

		tarjetacredito.setTarjetaCreditoConexions(tarjetacreditoDataAccess.getTarjetaCreditoConexions(connexion,tarjetacredito));

		for(TarjetaCreditoConexion tarjetacreditoconexion:tarjetacredito.getTarjetaCreditoConexions()) {
			TarjetaCreditoConexionLogic tarjetacreditoconexionLogic= new TarjetaCreditoConexionLogic(connexion);
			tarjetacreditoconexionLogic.deepLoad(tarjetacreditoconexion,isDeep,deepLoadType,clases);
		}

		tarjetacredito.setTarjetaCreditoDescuentos(tarjetacreditoDataAccess.getTarjetaCreditoDescuentos(connexion,tarjetacredito));

		for(TarjetaCreditoDescuento tarjetacreditodescuento:tarjetacredito.getTarjetaCreditoDescuentos()) {
			TarjetaCreditoDescuentoLogic tarjetacreditodescuentoLogic= new TarjetaCreditoDescuentoLogic(connexion);
			tarjetacreditodescuentoLogic.deepLoad(tarjetacreditodescuento,isDeep,deepLoadType,clases);
		}

		tarjetacredito.setFormaPagoPuntoVentas(tarjetacreditoDataAccess.getFormaPagoPuntoVentas(connexion,tarjetacredito));

		for(FormaPagoPuntoVenta formapagopuntoventa:tarjetacredito.getFormaPagoPuntoVentas()) {
			FormaPagoPuntoVentaLogic formapagopuntoventaLogic= new FormaPagoPuntoVentaLogic(connexion);
			formapagopuntoventaLogic.deepLoad(formapagopuntoventa,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				tarjetacredito.setEmpresa(tarjetacreditoDataAccess.getEmpresa(connexion,tarjetacredito));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(tarjetacredito.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				tarjetacredito.setSucursal(tarjetacreditoDataAccess.getSucursal(connexion,tarjetacredito));
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepLoad(tarjetacredito.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Banco.class)) {
				tarjetacredito.setBanco(tarjetacreditoDataAccess.getBanco(connexion,tarjetacredito));
				BancoLogic bancoLogic= new BancoLogic(connexion);
				bancoLogic.deepLoad(tarjetacredito.getBanco(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoRetencion.class)) {
				tarjetacredito.setTipoRetencion(tarjetacreditoDataAccess.getTipoRetencion(connexion,tarjetacredito));
				TipoRetencionLogic tiporetencionLogic= new TipoRetencionLogic(connexion);
				tiporetencionLogic.deepLoad(tarjetacredito.getTipoRetencion(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				tarjetacredito.setCuentaContable(tarjetacreditoDataAccess.getCuentaContable(connexion,tarjetacredito));
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepLoad(tarjetacredito.getCuentaContable(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoRetencionIva.class)) {
				tarjetacredito.setTipoRetencionIva(tarjetacreditoDataAccess.getTipoRetencionIva(connexion,tarjetacredito));
				TipoRetencionIvaLogic tiporetencionivaLogic= new TipoRetencionIvaLogic(connexion);
				tiporetencionivaLogic.deepLoad(tarjetacredito.getTipoRetencionIva(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				tarjetacredito.setCuentaContableComision(tarjetacreditoDataAccess.getCuentaContableComision(connexion,tarjetacredito));
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepLoad(tarjetacredito.getCuentaContableComision(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Formula.class)) {
				tarjetacredito.setFormulaPagoBanco(tarjetacreditoDataAccess.getFormulaPagoBanco(connexion,tarjetacredito));
				FormulaLogic formulaLogic= new FormulaLogic(connexion);
				formulaLogic.deepLoad(tarjetacredito.getFormulaPagoBanco(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				tarjetacredito.setCuentaContableDiferencia(tarjetacreditoDataAccess.getCuentaContableDiferencia(connexion,tarjetacredito));
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepLoad(tarjetacredito.getCuentaContableDiferencia(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Formula.class)) {
				tarjetacredito.setFormulaRetencion(tarjetacreditoDataAccess.getFormulaRetencion(connexion,tarjetacredito));
				FormulaLogic formulaLogic= new FormulaLogic(connexion);
				formulaLogic.deepLoad(tarjetacredito.getFormulaRetencion(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Formula.class)) {
				tarjetacredito.setFormulaComision(tarjetacreditoDataAccess.getFormulaComision(connexion,tarjetacredito));
				FormulaLogic formulaLogic= new FormulaLogic(connexion);
				formulaLogic.deepLoad(tarjetacredito.getFormulaComision(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TarjetaCreditoConexion.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tarjetacredito.setTarjetaCreditoConexions(tarjetacreditoDataAccess.getTarjetaCreditoConexions(connexion,tarjetacredito));

				for(TarjetaCreditoConexion tarjetacreditoconexion:tarjetacredito.getTarjetaCreditoConexions()) {
					TarjetaCreditoConexionLogic tarjetacreditoconexionLogic= new TarjetaCreditoConexionLogic(connexion);
					tarjetacreditoconexionLogic.deepLoad(tarjetacreditoconexion,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(TarjetaCreditoDescuento.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tarjetacredito.setTarjetaCreditoDescuentos(tarjetacreditoDataAccess.getTarjetaCreditoDescuentos(connexion,tarjetacredito));

				for(TarjetaCreditoDescuento tarjetacreditodescuento:tarjetacredito.getTarjetaCreditoDescuentos()) {
					TarjetaCreditoDescuentoLogic tarjetacreditodescuentoLogic= new TarjetaCreditoDescuentoLogic(connexion);
					tarjetacreditodescuentoLogic.deepLoad(tarjetacreditodescuento,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(FormaPagoPuntoVenta.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tarjetacredito.setFormaPagoPuntoVentas(tarjetacreditoDataAccess.getFormaPagoPuntoVentas(connexion,tarjetacredito));

				for(FormaPagoPuntoVenta formapagopuntoventa:tarjetacredito.getFormaPagoPuntoVentas()) {
					FormaPagoPuntoVentaLogic formapagopuntoventaLogic= new FormaPagoPuntoVentaLogic(connexion);
					formapagopuntoventaLogic.deepLoad(formapagopuntoventa,isDeep,deepLoadType,clases);
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
			tarjetacredito.setEmpresa(tarjetacreditoDataAccess.getEmpresa(connexion,tarjetacredito));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(tarjetacredito.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			tarjetacredito.setSucursal(tarjetacreditoDataAccess.getSucursal(connexion,tarjetacredito));
			SucursalLogic sucursalLogic= new SucursalLogic(connexion);
			sucursalLogic.deepLoad(tarjetacredito.getSucursal(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Banco.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			tarjetacredito.setBanco(tarjetacreditoDataAccess.getBanco(connexion,tarjetacredito));
			BancoLogic bancoLogic= new BancoLogic(connexion);
			bancoLogic.deepLoad(tarjetacredito.getBanco(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoRetencion.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			tarjetacredito.setTipoRetencion(tarjetacreditoDataAccess.getTipoRetencion(connexion,tarjetacredito));
			TipoRetencionLogic tiporetencionLogic= new TipoRetencionLogic(connexion);
			tiporetencionLogic.deepLoad(tarjetacredito.getTipoRetencion(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			tarjetacredito.setCuentaContable(tarjetacreditoDataAccess.getCuentaContable(connexion,tarjetacredito));
			CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
			cuentacontableLogic.deepLoad(tarjetacredito.getCuentaContable(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoRetencionIva.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			tarjetacredito.setTipoRetencionIva(tarjetacreditoDataAccess.getTipoRetencionIva(connexion,tarjetacredito));
			TipoRetencionIvaLogic tiporetencionivaLogic= new TipoRetencionIvaLogic(connexion);
			tiporetencionivaLogic.deepLoad(tarjetacredito.getTipoRetencionIva(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			tarjetacredito.setCuentaContableComision(tarjetacreditoDataAccess.getCuentaContableComision(connexion,tarjetacredito));
			CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
			cuentacontableLogic.deepLoad(tarjetacredito.getCuentaContableComision(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Formula.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			tarjetacredito.setFormulaPagoBanco(tarjetacreditoDataAccess.getFormulaPagoBanco(connexion,tarjetacredito));
			FormulaLogic formulaLogic= new FormulaLogic(connexion);
			formulaLogic.deepLoad(tarjetacredito.getFormulaPagoBanco(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			tarjetacredito.setCuentaContableDiferencia(tarjetacreditoDataAccess.getCuentaContableDiferencia(connexion,tarjetacredito));
			CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
			cuentacontableLogic.deepLoad(tarjetacredito.getCuentaContableDiferencia(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Formula.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			tarjetacredito.setFormulaRetencion(tarjetacreditoDataAccess.getFormulaRetencion(connexion,tarjetacredito));
			FormulaLogic formulaLogic= new FormulaLogic(connexion);
			formulaLogic.deepLoad(tarjetacredito.getFormulaRetencion(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Formula.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			tarjetacredito.setFormulaComision(tarjetacreditoDataAccess.getFormulaComision(connexion,tarjetacredito));
			FormulaLogic formulaLogic= new FormulaLogic(connexion);
			formulaLogic.deepLoad(tarjetacredito.getFormulaComision(),isDeep,deepLoadType,clases);
				
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TarjetaCreditoConexion.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(TarjetaCreditoConexion.class));
			tarjetacredito.setTarjetaCreditoConexions(tarjetacreditoDataAccess.getTarjetaCreditoConexions(connexion,tarjetacredito));

			for(TarjetaCreditoConexion tarjetacreditoconexion:tarjetacredito.getTarjetaCreditoConexions()) {
				TarjetaCreditoConexionLogic tarjetacreditoconexionLogic= new TarjetaCreditoConexionLogic(connexion);
				tarjetacreditoconexionLogic.deepLoad(tarjetacreditoconexion,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TarjetaCreditoDescuento.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(TarjetaCreditoDescuento.class));
			tarjetacredito.setTarjetaCreditoDescuentos(tarjetacreditoDataAccess.getTarjetaCreditoDescuentos(connexion,tarjetacredito));

			for(TarjetaCreditoDescuento tarjetacreditodescuento:tarjetacredito.getTarjetaCreditoDescuentos()) {
				TarjetaCreditoDescuentoLogic tarjetacreditodescuentoLogic= new TarjetaCreditoDescuentoLogic(connexion);
				tarjetacreditodescuentoLogic.deepLoad(tarjetacreditodescuento,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(FormaPagoPuntoVenta.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(FormaPagoPuntoVenta.class));
			tarjetacredito.setFormaPagoPuntoVentas(tarjetacreditoDataAccess.getFormaPagoPuntoVentas(connexion,tarjetacredito));

			for(FormaPagoPuntoVenta formapagopuntoventa:tarjetacredito.getFormaPagoPuntoVentas()) {
				FormaPagoPuntoVentaLogic formapagopuntoventaLogic= new FormaPagoPuntoVentaLogic(connexion);
				formapagopuntoventaLogic.deepLoad(formapagopuntoventa,isDeep,deepLoadType,clases);
			}
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(TarjetaCredito tarjetacredito,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			TarjetaCreditoLogicAdditional.updateTarjetaCreditoToSave(tarjetacredito,this.arrDatoGeneral);
			
TarjetaCreditoDataAccess.save(tarjetacredito, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(tarjetacredito.getEmpresa(),connexion);

		SucursalDataAccess.save(tarjetacredito.getSucursal(),connexion);

		BancoDataAccess.save(tarjetacredito.getBanco(),connexion);

		TipoRetencionDataAccess.save(tarjetacredito.getTipoRetencion(),connexion);

		CuentaContableDataAccess.save(tarjetacredito.getCuentaContable(),connexion);

		TipoRetencionIvaDataAccess.save(tarjetacredito.getTipoRetencionIva(),connexion);

		CuentaContableDataAccess.save(tarjetacredito.getCuentaContableComision(),connexion);

		FormulaDataAccess.save(tarjetacredito.getFormulaPagoBanco(),connexion);

		CuentaContableDataAccess.save(tarjetacredito.getCuentaContableDiferencia(),connexion);

		FormulaDataAccess.save(tarjetacredito.getFormulaRetencion(),connexion);

		FormulaDataAccess.save(tarjetacredito.getFormulaComision(),connexion);

		for(TarjetaCreditoConexion tarjetacreditoconexion:tarjetacredito.getTarjetaCreditoConexions()) {
			tarjetacreditoconexion.setid_tarjeta_credito(tarjetacredito.getId());
			TarjetaCreditoConexionDataAccess.save(tarjetacreditoconexion,connexion);
		}

		for(TarjetaCreditoDescuento tarjetacreditodescuento:tarjetacredito.getTarjetaCreditoDescuentos()) {
			tarjetacreditodescuento.setid_tarjeta_credito(tarjetacredito.getId());
			TarjetaCreditoDescuentoDataAccess.save(tarjetacreditodescuento,connexion);
		}

		for(FormaPagoPuntoVenta formapagopuntoventa:tarjetacredito.getFormaPagoPuntoVentas()) {
			formapagopuntoventa.setid_tarjeta_credito(tarjetacredito.getId());
			FormaPagoPuntoVentaDataAccess.save(formapagopuntoventa,connexion);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(tarjetacredito.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(tarjetacredito.getSucursal(),connexion);
				continue;
			}

			if(clas.clas.equals(Banco.class)) {
				BancoDataAccess.save(tarjetacredito.getBanco(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoRetencion.class)) {
				TipoRetencionDataAccess.save(tarjetacredito.getTipoRetencion(),connexion);
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(tarjetacredito.getCuentaContable(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoRetencionIva.class)) {
				TipoRetencionIvaDataAccess.save(tarjetacredito.getTipoRetencionIva(),connexion);
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(tarjetacredito.getCuentaContableComision(),connexion);
				continue;
			}

			if(clas.clas.equals(Formula.class)) {
				FormulaDataAccess.save(tarjetacredito.getFormulaPagoBanco(),connexion);
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(tarjetacredito.getCuentaContableDiferencia(),connexion);
				continue;
			}

			if(clas.clas.equals(Formula.class)) {
				FormulaDataAccess.save(tarjetacredito.getFormulaRetencion(),connexion);
				continue;
			}

			if(clas.clas.equals(Formula.class)) {
				FormulaDataAccess.save(tarjetacredito.getFormulaComision(),connexion);
				continue;
			}


			if(clas.clas.equals(TarjetaCreditoConexion.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(TarjetaCreditoConexion tarjetacreditoconexion:tarjetacredito.getTarjetaCreditoConexions()) {
					tarjetacreditoconexion.setid_tarjeta_credito(tarjetacredito.getId());
					TarjetaCreditoConexionDataAccess.save(tarjetacreditoconexion,connexion);
				}
				continue;
			}

			if(clas.clas.equals(TarjetaCreditoDescuento.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(TarjetaCreditoDescuento tarjetacreditodescuento:tarjetacredito.getTarjetaCreditoDescuentos()) {
					tarjetacreditodescuento.setid_tarjeta_credito(tarjetacredito.getId());
					TarjetaCreditoDescuentoDataAccess.save(tarjetacreditodescuento,connexion);
				}
				continue;
			}

			if(clas.clas.equals(FormaPagoPuntoVenta.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(FormaPagoPuntoVenta formapagopuntoventa:tarjetacredito.getFormaPagoPuntoVentas()) {
					formapagopuntoventa.setid_tarjeta_credito(tarjetacredito.getId());
					FormaPagoPuntoVentaDataAccess.save(formapagopuntoventa,connexion);
				}
				continue;
			}
		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(tarjetacredito.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(tarjetacredito.getEmpresa(),isDeep,deepLoadType,clases);
				

		SucursalDataAccess.save(tarjetacredito.getSucursal(),connexion);
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(tarjetacredito.getSucursal(),isDeep,deepLoadType,clases);
				

		BancoDataAccess.save(tarjetacredito.getBanco(),connexion);
		BancoLogic bancoLogic= new BancoLogic(connexion);
		bancoLogic.deepLoad(tarjetacredito.getBanco(),isDeep,deepLoadType,clases);
				

		TipoRetencionDataAccess.save(tarjetacredito.getTipoRetencion(),connexion);
		TipoRetencionLogic tiporetencionLogic= new TipoRetencionLogic(connexion);
		tiporetencionLogic.deepLoad(tarjetacredito.getTipoRetencion(),isDeep,deepLoadType,clases);
				

		CuentaContableDataAccess.save(tarjetacredito.getCuentaContable(),connexion);
		CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
		cuentacontableLogic.deepLoad(tarjetacredito.getCuentaContable(),isDeep,deepLoadType,clases);
				

		TipoRetencionIvaDataAccess.save(tarjetacredito.getTipoRetencionIva(),connexion);
		TipoRetencionIvaLogic tiporetencionivaLogic= new TipoRetencionIvaLogic(connexion);
		tiporetencionivaLogic.deepLoad(tarjetacredito.getTipoRetencionIva(),isDeep,deepLoadType,clases);
				

		CuentaContableDataAccess.save(tarjetacredito.getCuentaContableComision(),connexion);
		CuentaContableLogic cuentacontablecomisionLogic= new CuentaContableLogic(connexion);
		cuentacontablecomisionLogic.deepLoad(tarjetacredito.getCuentaContableComision(),isDeep,deepLoadType,clases);
				

		FormulaDataAccess.save(tarjetacredito.getFormulaPagoBanco(),connexion);
		FormulaLogic formulapagobancoLogic= new FormulaLogic(connexion);
		formulapagobancoLogic.deepLoad(tarjetacredito.getFormulaPagoBanco(),isDeep,deepLoadType,clases);
				

		CuentaContableDataAccess.save(tarjetacredito.getCuentaContableDiferencia(),connexion);
		CuentaContableLogic cuentacontablediferenciaLogic= new CuentaContableLogic(connexion);
		cuentacontablediferenciaLogic.deepLoad(tarjetacredito.getCuentaContableDiferencia(),isDeep,deepLoadType,clases);
				

		FormulaDataAccess.save(tarjetacredito.getFormulaRetencion(),connexion);
		FormulaLogic formularetencionLogic= new FormulaLogic(connexion);
		formularetencionLogic.deepLoad(tarjetacredito.getFormulaRetencion(),isDeep,deepLoadType,clases);
				

		FormulaDataAccess.save(tarjetacredito.getFormulaComision(),connexion);
		FormulaLogic formulacomisionLogic= new FormulaLogic(connexion);
		formulacomisionLogic.deepLoad(tarjetacredito.getFormulaComision(),isDeep,deepLoadType,clases);
				

		for(TarjetaCreditoConexion tarjetacreditoconexion:tarjetacredito.getTarjetaCreditoConexions()) {
			TarjetaCreditoConexionLogic tarjetacreditoconexionLogic= new TarjetaCreditoConexionLogic(connexion);
			tarjetacreditoconexion.setid_tarjeta_credito(tarjetacredito.getId());
			TarjetaCreditoConexionDataAccess.save(tarjetacreditoconexion,connexion);
			tarjetacreditoconexionLogic.deepSave(tarjetacreditoconexion,isDeep,deepLoadType,clases);
		}

		for(TarjetaCreditoDescuento tarjetacreditodescuento:tarjetacredito.getTarjetaCreditoDescuentos()) {
			TarjetaCreditoDescuentoLogic tarjetacreditodescuentoLogic= new TarjetaCreditoDescuentoLogic(connexion);
			tarjetacreditodescuento.setid_tarjeta_credito(tarjetacredito.getId());
			TarjetaCreditoDescuentoDataAccess.save(tarjetacreditodescuento,connexion);
			tarjetacreditodescuentoLogic.deepSave(tarjetacreditodescuento,isDeep,deepLoadType,clases);
		}

		for(FormaPagoPuntoVenta formapagopuntoventa:tarjetacredito.getFormaPagoPuntoVentas()) {
			FormaPagoPuntoVentaLogic formapagopuntoventaLogic= new FormaPagoPuntoVentaLogic(connexion);
			formapagopuntoventa.setid_tarjeta_credito(tarjetacredito.getId());
			FormaPagoPuntoVentaDataAccess.save(formapagopuntoventa,connexion);
			formapagopuntoventaLogic.deepSave(formapagopuntoventa,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(tarjetacredito.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(tarjetacredito.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(tarjetacredito.getSucursal(),connexion);
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepSave(tarjetacredito.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Banco.class)) {
				BancoDataAccess.save(tarjetacredito.getBanco(),connexion);
				BancoLogic bancoLogic= new BancoLogic(connexion);
				bancoLogic.deepSave(tarjetacredito.getBanco(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoRetencion.class)) {
				TipoRetencionDataAccess.save(tarjetacredito.getTipoRetencion(),connexion);
				TipoRetencionLogic tiporetencionLogic= new TipoRetencionLogic(connexion);
				tiporetencionLogic.deepSave(tarjetacredito.getTipoRetencion(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(tarjetacredito.getCuentaContable(),connexion);
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepSave(tarjetacredito.getCuentaContable(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoRetencionIva.class)) {
				TipoRetencionIvaDataAccess.save(tarjetacredito.getTipoRetencionIva(),connexion);
				TipoRetencionIvaLogic tiporetencionivaLogic= new TipoRetencionIvaLogic(connexion);
				tiporetencionivaLogic.deepSave(tarjetacredito.getTipoRetencionIva(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(tarjetacredito.getCuentaContableComision(),connexion);
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepSave(tarjetacredito.getCuentaContableComision(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Formula.class)) {
				FormulaDataAccess.save(tarjetacredito.getFormulaPagoBanco(),connexion);
				FormulaLogic formulaLogic= new FormulaLogic(connexion);
				formulaLogic.deepSave(tarjetacredito.getFormulaPagoBanco(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(tarjetacredito.getCuentaContableDiferencia(),connexion);
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepSave(tarjetacredito.getCuentaContableDiferencia(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Formula.class)) {
				FormulaDataAccess.save(tarjetacredito.getFormulaRetencion(),connexion);
				FormulaLogic formulaLogic= new FormulaLogic(connexion);
				formulaLogic.deepSave(tarjetacredito.getFormulaRetencion(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Formula.class)) {
				FormulaDataAccess.save(tarjetacredito.getFormulaComision(),connexion);
				FormulaLogic formulaLogic= new FormulaLogic(connexion);
				formulaLogic.deepSave(tarjetacredito.getFormulaComision(),isDeep,deepLoadType,clases);				
				continue;
			}


			if(clas.clas.equals(TarjetaCreditoConexion.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(TarjetaCreditoConexion tarjetacreditoconexion:tarjetacredito.getTarjetaCreditoConexions()) {
					TarjetaCreditoConexionLogic tarjetacreditoconexionLogic= new TarjetaCreditoConexionLogic(connexion);
					tarjetacreditoconexion.setid_tarjeta_credito(tarjetacredito.getId());
					TarjetaCreditoConexionDataAccess.save(tarjetacreditoconexion,connexion);
					tarjetacreditoconexionLogic.deepSave(tarjetacreditoconexion,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(TarjetaCreditoDescuento.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(TarjetaCreditoDescuento tarjetacreditodescuento:tarjetacredito.getTarjetaCreditoDescuentos()) {
					TarjetaCreditoDescuentoLogic tarjetacreditodescuentoLogic= new TarjetaCreditoDescuentoLogic(connexion);
					tarjetacreditodescuento.setid_tarjeta_credito(tarjetacredito.getId());
					TarjetaCreditoDescuentoDataAccess.save(tarjetacreditodescuento,connexion);
					tarjetacreditodescuentoLogic.deepSave(tarjetacreditodescuento,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(FormaPagoPuntoVenta.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(FormaPagoPuntoVenta formapagopuntoventa:tarjetacredito.getFormaPagoPuntoVentas()) {
					FormaPagoPuntoVentaLogic formapagopuntoventaLogic= new FormaPagoPuntoVentaLogic(connexion);
					formapagopuntoventa.setid_tarjeta_credito(tarjetacredito.getId());
					FormaPagoPuntoVentaDataAccess.save(formapagopuntoventa,connexion);
					formapagopuntoventaLogic.deepSave(formapagopuntoventa,isDeep,deepLoadType,clases);
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
			this.getNewConnexionToDeep(TarjetaCredito.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(tarjetacredito,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				TarjetaCreditoConstantesFunciones.refrescarForeignKeysDescripcionesTarjetaCredito(tarjetacredito);
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
			this.deepLoad(this.tarjetacredito,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				TarjetaCreditoConstantesFunciones.refrescarForeignKeysDescripcionesTarjetaCredito(this.tarjetacredito);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(TarjetaCredito.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(tarjetacreditos!=null) {
				for(TarjetaCredito tarjetacredito:tarjetacreditos) {
					this.deepLoad(tarjetacredito,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					TarjetaCreditoConstantesFunciones.refrescarForeignKeysDescripcionesTarjetaCredito(tarjetacreditos);
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
			if(tarjetacreditos!=null) {
				for(TarjetaCredito tarjetacredito:tarjetacreditos) {
					this.deepLoad(tarjetacredito,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					TarjetaCreditoConstantesFunciones.refrescarForeignKeysDescripcionesTarjetaCredito(tarjetacreditos);
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
			this.getNewConnexionToDeep(TarjetaCredito.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(tarjetacredito,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(TarjetaCredito.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(tarjetacreditos!=null) {
				for(TarjetaCredito tarjetacredito:tarjetacreditos) {
					this.deepSave(tarjetacredito,isDeep,deepLoadType,clases);
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
			if(tarjetacreditos!=null) {
				for(TarjetaCredito tarjetacredito:tarjetacreditos) {
					this.deepSave(tarjetacredito,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getTarjetaCreditosFK_IdBancoWithConnection(String sFinalQuery,Pagination pagination,Long id_banco)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TarjetaCredito.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidBanco= new ParameterSelectionGeneral();
			parameterSelectionGeneralidBanco.setParameterSelectionGeneralEqual(ParameterType.LONG,id_banco,TarjetaCreditoConstantesFunciones.IDBANCO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidBanco);

			TarjetaCreditoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdBanco","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tarjetacreditos=tarjetacreditoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TarjetaCreditoConstantesFunciones.refrescarForeignKeysDescripcionesTarjetaCredito(this.tarjetacreditos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTarjetaCreditosFK_IdBanco(String sFinalQuery,Pagination pagination,Long id_banco)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidBanco= new ParameterSelectionGeneral();
			parameterSelectionGeneralidBanco.setParameterSelectionGeneralEqual(ParameterType.LONG,id_banco,TarjetaCreditoConstantesFunciones.IDBANCO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidBanco);

			TarjetaCreditoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdBanco","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tarjetacreditos=tarjetacreditoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TarjetaCreditoConstantesFunciones.refrescarForeignKeysDescripcionesTarjetaCredito(this.tarjetacreditos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getTarjetaCreditosFK_IdCuentaContableWithConnection(String sFinalQuery,Pagination pagination,Long id_cuenta_contable)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TarjetaCredito.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContable= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContable.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable,TarjetaCreditoConstantesFunciones.IDCUENTACONTABLE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContable);

			TarjetaCreditoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContable","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tarjetacreditos=tarjetacreditoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TarjetaCreditoConstantesFunciones.refrescarForeignKeysDescripcionesTarjetaCredito(this.tarjetacreditos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTarjetaCreditosFK_IdCuentaContable(String sFinalQuery,Pagination pagination,Long id_cuenta_contable)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContable= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContable.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable,TarjetaCreditoConstantesFunciones.IDCUENTACONTABLE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContable);

			TarjetaCreditoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContable","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tarjetacreditos=tarjetacreditoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TarjetaCreditoConstantesFunciones.refrescarForeignKeysDescripcionesTarjetaCredito(this.tarjetacreditos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getTarjetaCreditosFK_IdCuentaContableComisionWithConnection(String sFinalQuery,Pagination pagination,Long id_cuenta_contable_comision)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TarjetaCredito.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContableComision= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContableComision.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable_comision,TarjetaCreditoConstantesFunciones.IDCUENTACONTABLECOMISION,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContableComision);

			TarjetaCreditoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContableComision","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tarjetacreditos=tarjetacreditoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TarjetaCreditoConstantesFunciones.refrescarForeignKeysDescripcionesTarjetaCredito(this.tarjetacreditos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTarjetaCreditosFK_IdCuentaContableComision(String sFinalQuery,Pagination pagination,Long id_cuenta_contable_comision)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContableComision= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContableComision.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable_comision,TarjetaCreditoConstantesFunciones.IDCUENTACONTABLECOMISION,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContableComision);

			TarjetaCreditoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContableComision","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tarjetacreditos=tarjetacreditoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TarjetaCreditoConstantesFunciones.refrescarForeignKeysDescripcionesTarjetaCredito(this.tarjetacreditos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getTarjetaCreditosFK_IdCuentaContableDiferenciaWithConnection(String sFinalQuery,Pagination pagination,Long id_cuenta_contable_diferencia)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TarjetaCredito.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContableDiferencia= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContableDiferencia.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable_diferencia,TarjetaCreditoConstantesFunciones.IDCUENTACONTABLEDIFERENCIA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContableDiferencia);

			TarjetaCreditoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContableDiferencia","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tarjetacreditos=tarjetacreditoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TarjetaCreditoConstantesFunciones.refrescarForeignKeysDescripcionesTarjetaCredito(this.tarjetacreditos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTarjetaCreditosFK_IdCuentaContableDiferencia(String sFinalQuery,Pagination pagination,Long id_cuenta_contable_diferencia)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContableDiferencia= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContableDiferencia.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable_diferencia,TarjetaCreditoConstantesFunciones.IDCUENTACONTABLEDIFERENCIA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContableDiferencia);

			TarjetaCreditoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContableDiferencia","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tarjetacreditos=tarjetacreditoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TarjetaCreditoConstantesFunciones.refrescarForeignKeysDescripcionesTarjetaCredito(this.tarjetacreditos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getTarjetaCreditosFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TarjetaCredito.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,TarjetaCreditoConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			TarjetaCreditoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tarjetacreditos=tarjetacreditoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TarjetaCreditoConstantesFunciones.refrescarForeignKeysDescripcionesTarjetaCredito(this.tarjetacreditos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTarjetaCreditosFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,TarjetaCreditoConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			TarjetaCreditoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tarjetacreditos=tarjetacreditoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TarjetaCreditoConstantesFunciones.refrescarForeignKeysDescripcionesTarjetaCredito(this.tarjetacreditos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getTarjetaCreditosFK_IdFormulaComisionWithConnection(String sFinalQuery,Pagination pagination,Long id_formula_comision)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TarjetaCredito.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidFormulaComision= new ParameterSelectionGeneral();
			parameterSelectionGeneralidFormulaComision.setParameterSelectionGeneralEqual(ParameterType.LONG,id_formula_comision,TarjetaCreditoConstantesFunciones.IDFORMULACOMISION,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidFormulaComision);

			TarjetaCreditoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdFormulaComision","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tarjetacreditos=tarjetacreditoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TarjetaCreditoConstantesFunciones.refrescarForeignKeysDescripcionesTarjetaCredito(this.tarjetacreditos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTarjetaCreditosFK_IdFormulaComision(String sFinalQuery,Pagination pagination,Long id_formula_comision)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidFormulaComision= new ParameterSelectionGeneral();
			parameterSelectionGeneralidFormulaComision.setParameterSelectionGeneralEqual(ParameterType.LONG,id_formula_comision,TarjetaCreditoConstantesFunciones.IDFORMULACOMISION,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidFormulaComision);

			TarjetaCreditoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdFormulaComision","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tarjetacreditos=tarjetacreditoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TarjetaCreditoConstantesFunciones.refrescarForeignKeysDescripcionesTarjetaCredito(this.tarjetacreditos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getTarjetaCreditosFK_IdFormulaPagoBancoWithConnection(String sFinalQuery,Pagination pagination,Long id_formula_pago_banco)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TarjetaCredito.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidFormulaPagoBanco= new ParameterSelectionGeneral();
			parameterSelectionGeneralidFormulaPagoBanco.setParameterSelectionGeneralEqual(ParameterType.LONG,id_formula_pago_banco,TarjetaCreditoConstantesFunciones.IDFORMULAPAGOBANCO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidFormulaPagoBanco);

			TarjetaCreditoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdFormulaPagoBanco","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tarjetacreditos=tarjetacreditoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TarjetaCreditoConstantesFunciones.refrescarForeignKeysDescripcionesTarjetaCredito(this.tarjetacreditos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTarjetaCreditosFK_IdFormulaPagoBanco(String sFinalQuery,Pagination pagination,Long id_formula_pago_banco)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidFormulaPagoBanco= new ParameterSelectionGeneral();
			parameterSelectionGeneralidFormulaPagoBanco.setParameterSelectionGeneralEqual(ParameterType.LONG,id_formula_pago_banco,TarjetaCreditoConstantesFunciones.IDFORMULAPAGOBANCO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidFormulaPagoBanco);

			TarjetaCreditoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdFormulaPagoBanco","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tarjetacreditos=tarjetacreditoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TarjetaCreditoConstantesFunciones.refrescarForeignKeysDescripcionesTarjetaCredito(this.tarjetacreditos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getTarjetaCreditosFK_IdFormulaRetencionWithConnection(String sFinalQuery,Pagination pagination,Long id_formula_retencion)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TarjetaCredito.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidFormulaRetencion= new ParameterSelectionGeneral();
			parameterSelectionGeneralidFormulaRetencion.setParameterSelectionGeneralEqual(ParameterType.LONG,id_formula_retencion,TarjetaCreditoConstantesFunciones.IDFORMULARETENCION,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidFormulaRetencion);

			TarjetaCreditoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdFormulaRetencion","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tarjetacreditos=tarjetacreditoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TarjetaCreditoConstantesFunciones.refrescarForeignKeysDescripcionesTarjetaCredito(this.tarjetacreditos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTarjetaCreditosFK_IdFormulaRetencion(String sFinalQuery,Pagination pagination,Long id_formula_retencion)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidFormulaRetencion= new ParameterSelectionGeneral();
			parameterSelectionGeneralidFormulaRetencion.setParameterSelectionGeneralEqual(ParameterType.LONG,id_formula_retencion,TarjetaCreditoConstantesFunciones.IDFORMULARETENCION,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidFormulaRetencion);

			TarjetaCreditoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdFormulaRetencion","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tarjetacreditos=tarjetacreditoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TarjetaCreditoConstantesFunciones.refrescarForeignKeysDescripcionesTarjetaCredito(this.tarjetacreditos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getTarjetaCreditosFK_IdSucursalWithConnection(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TarjetaCredito.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,TarjetaCreditoConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			TarjetaCreditoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tarjetacreditos=tarjetacreditoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TarjetaCreditoConstantesFunciones.refrescarForeignKeysDescripcionesTarjetaCredito(this.tarjetacreditos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTarjetaCreditosFK_IdSucursal(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,TarjetaCreditoConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			TarjetaCreditoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tarjetacreditos=tarjetacreditoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TarjetaCreditoConstantesFunciones.refrescarForeignKeysDescripcionesTarjetaCredito(this.tarjetacreditos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getTarjetaCreditosFK_IdTipoRetencionWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_retencion)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TarjetaCredito.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoRetencion= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoRetencion.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_retencion,TarjetaCreditoConstantesFunciones.IDTIPORETENCION,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoRetencion);

			TarjetaCreditoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoRetencion","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tarjetacreditos=tarjetacreditoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TarjetaCreditoConstantesFunciones.refrescarForeignKeysDescripcionesTarjetaCredito(this.tarjetacreditos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTarjetaCreditosFK_IdTipoRetencion(String sFinalQuery,Pagination pagination,Long id_tipo_retencion)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoRetencion= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoRetencion.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_retencion,TarjetaCreditoConstantesFunciones.IDTIPORETENCION,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoRetencion);

			TarjetaCreditoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoRetencion","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tarjetacreditos=tarjetacreditoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TarjetaCreditoConstantesFunciones.refrescarForeignKeysDescripcionesTarjetaCredito(this.tarjetacreditos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getTarjetaCreditosFK_IdTipoRetencionIvaWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_retencion_iva)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TarjetaCredito.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoRetencionIva= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoRetencionIva.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_retencion_iva,TarjetaCreditoConstantesFunciones.IDTIPORETENCIONIVA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoRetencionIva);

			TarjetaCreditoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoRetencionIva","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tarjetacreditos=tarjetacreditoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TarjetaCreditoConstantesFunciones.refrescarForeignKeysDescripcionesTarjetaCredito(this.tarjetacreditos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTarjetaCreditosFK_IdTipoRetencionIva(String sFinalQuery,Pagination pagination,Long id_tipo_retencion_iva)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoRetencionIva= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoRetencionIva.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_retencion_iva,TarjetaCreditoConstantesFunciones.IDTIPORETENCIONIVA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoRetencionIva);

			TarjetaCreditoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoRetencionIva","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tarjetacreditos=tarjetacreditoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TarjetaCreditoConstantesFunciones.refrescarForeignKeysDescripcionesTarjetaCredito(this.tarjetacreditos);
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
			if(TarjetaCreditoConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,TarjetaCreditoDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,TarjetaCredito tarjetacredito,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(TarjetaCreditoConstantesFunciones.ISCONAUDITORIA) {
				if(tarjetacredito.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TarjetaCreditoDataAccess.TABLENAME, tarjetacredito.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(TarjetaCreditoConstantesFunciones.ISCONAUDITORIADETALLE) {
						////TarjetaCreditoLogic.registrarAuditoriaDetallesTarjetaCredito(connexion,tarjetacredito,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(tarjetacredito.getIsDeleted()) {
					/*if(!tarjetacredito.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,TarjetaCreditoDataAccess.TABLENAME, tarjetacredito.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////TarjetaCreditoLogic.registrarAuditoriaDetallesTarjetaCredito(connexion,tarjetacredito,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TarjetaCreditoDataAccess.TABLENAME, tarjetacredito.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(tarjetacredito.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TarjetaCreditoDataAccess.TABLENAME, tarjetacredito.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(TarjetaCreditoConstantesFunciones.ISCONAUDITORIADETALLE) {
						////TarjetaCreditoLogic.registrarAuditoriaDetallesTarjetaCredito(connexion,tarjetacredito,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesTarjetaCredito(Connexion connexion,TarjetaCredito tarjetacredito)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(tarjetacredito.getIsNew()||!tarjetacredito.getid_empresa().equals(tarjetacredito.getTarjetaCreditoOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tarjetacredito.getTarjetaCreditoOriginal().getid_empresa()!=null)
				{
					strValorActual=tarjetacredito.getTarjetaCreditoOriginal().getid_empresa().toString();
				}
				if(tarjetacredito.getid_empresa()!=null)
				{
					strValorNuevo=tarjetacredito.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TarjetaCreditoConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(tarjetacredito.getIsNew()||!tarjetacredito.getid_sucursal().equals(tarjetacredito.getTarjetaCreditoOriginal().getid_sucursal()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tarjetacredito.getTarjetaCreditoOriginal().getid_sucursal()!=null)
				{
					strValorActual=tarjetacredito.getTarjetaCreditoOriginal().getid_sucursal().toString();
				}
				if(tarjetacredito.getid_sucursal()!=null)
				{
					strValorNuevo=tarjetacredito.getid_sucursal().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TarjetaCreditoConstantesFunciones.IDSUCURSAL,strValorActual,strValorNuevo);
			}	
			
			if(tarjetacredito.getIsNew()||!tarjetacredito.getid_banco().equals(tarjetacredito.getTarjetaCreditoOriginal().getid_banco()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tarjetacredito.getTarjetaCreditoOriginal().getid_banco()!=null)
				{
					strValorActual=tarjetacredito.getTarjetaCreditoOriginal().getid_banco().toString();
				}
				if(tarjetacredito.getid_banco()!=null)
				{
					strValorNuevo=tarjetacredito.getid_banco().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TarjetaCreditoConstantesFunciones.IDBANCO,strValorActual,strValorNuevo);
			}	
			
			if(tarjetacredito.getIsNew()||!tarjetacredito.getcodigo().equals(tarjetacredito.getTarjetaCreditoOriginal().getcodigo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tarjetacredito.getTarjetaCreditoOriginal().getcodigo()!=null)
				{
					strValorActual=tarjetacredito.getTarjetaCreditoOriginal().getcodigo();
				}
				if(tarjetacredito.getcodigo()!=null)
				{
					strValorNuevo=tarjetacredito.getcodigo() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TarjetaCreditoConstantesFunciones.CODIGO,strValorActual,strValorNuevo);
			}	
			
			if(tarjetacredito.getIsNew()||!tarjetacredito.getnombre().equals(tarjetacredito.getTarjetaCreditoOriginal().getnombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tarjetacredito.getTarjetaCreditoOriginal().getnombre()!=null)
				{
					strValorActual=tarjetacredito.getTarjetaCreditoOriginal().getnombre();
				}
				if(tarjetacredito.getnombre()!=null)
				{
					strValorNuevo=tarjetacredito.getnombre() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TarjetaCreditoConstantesFunciones.NOMBRE,strValorActual,strValorNuevo);
			}	
			
			if(tarjetacredito.getIsNew()||!tarjetacredito.getnombre_corto().equals(tarjetacredito.getTarjetaCreditoOriginal().getnombre_corto()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tarjetacredito.getTarjetaCreditoOriginal().getnombre_corto()!=null)
				{
					strValorActual=tarjetacredito.getTarjetaCreditoOriginal().getnombre_corto();
				}
				if(tarjetacredito.getnombre_corto()!=null)
				{
					strValorNuevo=tarjetacredito.getnombre_corto() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TarjetaCreditoConstantesFunciones.NOMBRECORTO,strValorActual,strValorNuevo);
			}	
			
			if(tarjetacredito.getIsNew()||!tarjetacredito.getdigito_valido().equals(tarjetacredito.getTarjetaCreditoOriginal().getdigito_valido()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tarjetacredito.getTarjetaCreditoOriginal().getdigito_valido()!=null)
				{
					strValorActual=tarjetacredito.getTarjetaCreditoOriginal().getdigito_valido().toString();
				}
				if(tarjetacredito.getdigito_valido()!=null)
				{
					strValorNuevo=tarjetacredito.getdigito_valido().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TarjetaCreditoConstantesFunciones.DIGITOVALIDO,strValorActual,strValorNuevo);
			}	
			
			if(tarjetacredito.getIsNew()||!tarjetacredito.getdigito_tarjeta().equals(tarjetacredito.getTarjetaCreditoOriginal().getdigito_tarjeta()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tarjetacredito.getTarjetaCreditoOriginal().getdigito_tarjeta()!=null)
				{
					strValorActual=tarjetacredito.getTarjetaCreditoOriginal().getdigito_tarjeta().toString();
				}
				if(tarjetacredito.getdigito_tarjeta()!=null)
				{
					strValorNuevo=tarjetacredito.getdigito_tarjeta().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TarjetaCreditoConstantesFunciones.DIGITOTARJETA,strValorActual,strValorNuevo);
			}	
			
			if(tarjetacredito.getIsNew()||!tarjetacredito.getcomision().equals(tarjetacredito.getTarjetaCreditoOriginal().getcomision()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tarjetacredito.getTarjetaCreditoOriginal().getcomision()!=null)
				{
					strValorActual=tarjetacredito.getTarjetaCreditoOriginal().getcomision().toString();
				}
				if(tarjetacredito.getcomision()!=null)
				{
					strValorNuevo=tarjetacredito.getcomision().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TarjetaCreditoConstantesFunciones.COMISION,strValorActual,strValorNuevo);
			}	
			
			if(tarjetacredito.getIsNew()||!tarjetacredito.getinteres().equals(tarjetacredito.getTarjetaCreditoOriginal().getinteres()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tarjetacredito.getTarjetaCreditoOriginal().getinteres()!=null)
				{
					strValorActual=tarjetacredito.getTarjetaCreditoOriginal().getinteres().toString();
				}
				if(tarjetacredito.getinteres()!=null)
				{
					strValorNuevo=tarjetacredito.getinteres().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TarjetaCreditoConstantesFunciones.INTERES,strValorActual,strValorNuevo);
			}	
			
			if(tarjetacredito.getIsNew()||!tarjetacredito.getmonto_minimo().equals(tarjetacredito.getTarjetaCreditoOriginal().getmonto_minimo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tarjetacredito.getTarjetaCreditoOriginal().getmonto_minimo()!=null)
				{
					strValorActual=tarjetacredito.getTarjetaCreditoOriginal().getmonto_minimo().toString();
				}
				if(tarjetacredito.getmonto_minimo()!=null)
				{
					strValorNuevo=tarjetacredito.getmonto_minimo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TarjetaCreditoConstantesFunciones.MONTOMINIMO,strValorActual,strValorNuevo);
			}	
			
			if(tarjetacredito.getIsNew()||!tarjetacredito.getporcentaje_retencion().equals(tarjetacredito.getTarjetaCreditoOriginal().getporcentaje_retencion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tarjetacredito.getTarjetaCreditoOriginal().getporcentaje_retencion()!=null)
				{
					strValorActual=tarjetacredito.getTarjetaCreditoOriginal().getporcentaje_retencion().toString();
				}
				if(tarjetacredito.getporcentaje_retencion()!=null)
				{
					strValorNuevo=tarjetacredito.getporcentaje_retencion().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TarjetaCreditoConstantesFunciones.PORCENTAJERETENCION,strValorActual,strValorNuevo);
			}	
			
			if(tarjetacredito.getIsNew()||!tarjetacredito.getcomision_retencion().equals(tarjetacredito.getTarjetaCreditoOriginal().getcomision_retencion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tarjetacredito.getTarjetaCreditoOriginal().getcomision_retencion()!=null)
				{
					strValorActual=tarjetacredito.getTarjetaCreditoOriginal().getcomision_retencion().toString();
				}
				if(tarjetacredito.getcomision_retencion()!=null)
				{
					strValorNuevo=tarjetacredito.getcomision_retencion().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TarjetaCreditoConstantesFunciones.COMISIONRETENCION,strValorActual,strValorNuevo);
			}	
			
			if(tarjetacredito.getIsNew()||!tarjetacredito.getes_retencion_redondeo().equals(tarjetacredito.getTarjetaCreditoOriginal().getes_retencion_redondeo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tarjetacredito.getTarjetaCreditoOriginal().getes_retencion_redondeo()!=null)
				{
					strValorActual=tarjetacredito.getTarjetaCreditoOriginal().getes_retencion_redondeo().toString();
				}
				if(tarjetacredito.getes_retencion_redondeo()!=null)
				{
					strValorNuevo=tarjetacredito.getes_retencion_redondeo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TarjetaCreditoConstantesFunciones.ESRETENCIONREDONDEO,strValorActual,strValorNuevo);
			}	
			
			if(tarjetacredito.getIsNew()||!tarjetacredito.getes_pago_banco_redondeo().equals(tarjetacredito.getTarjetaCreditoOriginal().getes_pago_banco_redondeo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tarjetacredito.getTarjetaCreditoOriginal().getes_pago_banco_redondeo()!=null)
				{
					strValorActual=tarjetacredito.getTarjetaCreditoOriginal().getes_pago_banco_redondeo().toString();
				}
				if(tarjetacredito.getes_pago_banco_redondeo()!=null)
				{
					strValorNuevo=tarjetacredito.getes_pago_banco_redondeo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TarjetaCreditoConstantesFunciones.ESPAGOBANCOREDONDEO,strValorActual,strValorNuevo);
			}	
			
			if(tarjetacredito.getIsNew()||!tarjetacredito.getes_comision_redondeo().equals(tarjetacredito.getTarjetaCreditoOriginal().getes_comision_redondeo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tarjetacredito.getTarjetaCreditoOriginal().getes_comision_redondeo()!=null)
				{
					strValorActual=tarjetacredito.getTarjetaCreditoOriginal().getes_comision_redondeo().toString();
				}
				if(tarjetacredito.getes_comision_redondeo()!=null)
				{
					strValorNuevo=tarjetacredito.getes_comision_redondeo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TarjetaCreditoConstantesFunciones.ESCOMISIONREDONDEO,strValorActual,strValorNuevo);
			}	
			
			if(tarjetacredito.getIsNew()||!tarjetacredito.getid_tipo_retencion().equals(tarjetacredito.getTarjetaCreditoOriginal().getid_tipo_retencion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tarjetacredito.getTarjetaCreditoOriginal().getid_tipo_retencion()!=null)
				{
					strValorActual=tarjetacredito.getTarjetaCreditoOriginal().getid_tipo_retencion().toString();
				}
				if(tarjetacredito.getid_tipo_retencion()!=null)
				{
					strValorNuevo=tarjetacredito.getid_tipo_retencion().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TarjetaCreditoConstantesFunciones.IDTIPORETENCION,strValorActual,strValorNuevo);
			}	
			
			if(tarjetacredito.getIsNew()||!tarjetacredito.getid_cuenta_contable().equals(tarjetacredito.getTarjetaCreditoOriginal().getid_cuenta_contable()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tarjetacredito.getTarjetaCreditoOriginal().getid_cuenta_contable()!=null)
				{
					strValorActual=tarjetacredito.getTarjetaCreditoOriginal().getid_cuenta_contable().toString();
				}
				if(tarjetacredito.getid_cuenta_contable()!=null)
				{
					strValorNuevo=tarjetacredito.getid_cuenta_contable().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TarjetaCreditoConstantesFunciones.IDCUENTACONTABLE,strValorActual,strValorNuevo);
			}	
			
			if(tarjetacredito.getIsNew()||!tarjetacredito.getid_tipo_retencion_iva().equals(tarjetacredito.getTarjetaCreditoOriginal().getid_tipo_retencion_iva()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tarjetacredito.getTarjetaCreditoOriginal().getid_tipo_retencion_iva()!=null)
				{
					strValorActual=tarjetacredito.getTarjetaCreditoOriginal().getid_tipo_retencion_iva().toString();
				}
				if(tarjetacredito.getid_tipo_retencion_iva()!=null)
				{
					strValorNuevo=tarjetacredito.getid_tipo_retencion_iva().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TarjetaCreditoConstantesFunciones.IDTIPORETENCIONIVA,strValorActual,strValorNuevo);
			}	
			
			if(tarjetacredito.getIsNew()||!tarjetacredito.getid_cuenta_contable_comision().equals(tarjetacredito.getTarjetaCreditoOriginal().getid_cuenta_contable_comision()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tarjetacredito.getTarjetaCreditoOriginal().getid_cuenta_contable_comision()!=null)
				{
					strValorActual=tarjetacredito.getTarjetaCreditoOriginal().getid_cuenta_contable_comision().toString();
				}
				if(tarjetacredito.getid_cuenta_contable_comision()!=null)
				{
					strValorNuevo=tarjetacredito.getid_cuenta_contable_comision().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TarjetaCreditoConstantesFunciones.IDCUENTACONTABLECOMISION,strValorActual,strValorNuevo);
			}	
			
			if(tarjetacredito.getIsNew()||!tarjetacredito.getid_formula_pago_banco().equals(tarjetacredito.getTarjetaCreditoOriginal().getid_formula_pago_banco()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tarjetacredito.getTarjetaCreditoOriginal().getid_formula_pago_banco()!=null)
				{
					strValorActual=tarjetacredito.getTarjetaCreditoOriginal().getid_formula_pago_banco().toString();
				}
				if(tarjetacredito.getid_formula_pago_banco()!=null)
				{
					strValorNuevo=tarjetacredito.getid_formula_pago_banco().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TarjetaCreditoConstantesFunciones.IDFORMULAPAGOBANCO,strValorActual,strValorNuevo);
			}	
			
			if(tarjetacredito.getIsNew()||!tarjetacredito.getid_cuenta_contable_diferencia().equals(tarjetacredito.getTarjetaCreditoOriginal().getid_cuenta_contable_diferencia()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tarjetacredito.getTarjetaCreditoOriginal().getid_cuenta_contable_diferencia()!=null)
				{
					strValorActual=tarjetacredito.getTarjetaCreditoOriginal().getid_cuenta_contable_diferencia().toString();
				}
				if(tarjetacredito.getid_cuenta_contable_diferencia()!=null)
				{
					strValorNuevo=tarjetacredito.getid_cuenta_contable_diferencia().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TarjetaCreditoConstantesFunciones.IDCUENTACONTABLEDIFERENCIA,strValorActual,strValorNuevo);
			}	
			
			if(tarjetacredito.getIsNew()||!tarjetacredito.getid_formula_retencion().equals(tarjetacredito.getTarjetaCreditoOriginal().getid_formula_retencion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tarjetacredito.getTarjetaCreditoOriginal().getid_formula_retencion()!=null)
				{
					strValorActual=tarjetacredito.getTarjetaCreditoOriginal().getid_formula_retencion().toString();
				}
				if(tarjetacredito.getid_formula_retencion()!=null)
				{
					strValorNuevo=tarjetacredito.getid_formula_retencion().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TarjetaCreditoConstantesFunciones.IDFORMULARETENCION,strValorActual,strValorNuevo);
			}	
			
			if(tarjetacredito.getIsNew()||!tarjetacredito.getid_formula_comision().equals(tarjetacredito.getTarjetaCreditoOriginal().getid_formula_comision()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tarjetacredito.getTarjetaCreditoOriginal().getid_formula_comision()!=null)
				{
					strValorActual=tarjetacredito.getTarjetaCreditoOriginal().getid_formula_comision().toString();
				}
				if(tarjetacredito.getid_formula_comision()!=null)
				{
					strValorNuevo=tarjetacredito.getid_formula_comision().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TarjetaCreditoConstantesFunciones.IDFORMULACOMISION,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveTarjetaCreditoRelacionesWithConnection(TarjetaCredito tarjetacredito,List<TarjetaCreditoConexion> tarjetacreditoconexions,List<TarjetaCreditoDescuento> tarjetacreditodescuentos,List<FormaPagoPuntoVenta> formapagopuntoventas) throws Exception {

		if(!tarjetacredito.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveTarjetaCreditoRelacionesBase(tarjetacredito,tarjetacreditoconexions,tarjetacreditodescuentos,formapagopuntoventas,true);
		}
	}

	public void saveTarjetaCreditoRelaciones(TarjetaCredito tarjetacredito,List<TarjetaCreditoConexion> tarjetacreditoconexions,List<TarjetaCreditoDescuento> tarjetacreditodescuentos,List<FormaPagoPuntoVenta> formapagopuntoventas)throws Exception {

		if(!tarjetacredito.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveTarjetaCreditoRelacionesBase(tarjetacredito,tarjetacreditoconexions,tarjetacreditodescuentos,formapagopuntoventas,false);
		}
	}

	public void saveTarjetaCreditoRelacionesBase(TarjetaCredito tarjetacredito,List<TarjetaCreditoConexion> tarjetacreditoconexions,List<TarjetaCreditoDescuento> tarjetacreditodescuentos,List<FormaPagoPuntoVenta> formapagopuntoventas,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("TarjetaCredito-saveRelacionesWithConnection");}
	
			tarjetacredito.setTarjetaCreditoConexions(tarjetacreditoconexions);
			tarjetacredito.setTarjetaCreditoDescuentos(tarjetacreditodescuentos);
			tarjetacredito.setFormaPagoPuntoVentas(formapagopuntoventas);

			this.setTarjetaCredito(tarjetacredito);

			if(TarjetaCreditoLogicAdditional.validarSaveRelaciones(tarjetacredito,this)) {

				TarjetaCreditoLogicAdditional.updateRelacionesToSave(tarjetacredito,this);

				if((tarjetacredito.getIsNew()||tarjetacredito.getIsChanged())&&!tarjetacredito.getIsDeleted()) {
					this.saveTarjetaCredito();
					this.saveTarjetaCreditoRelacionesDetalles(tarjetacreditoconexions,tarjetacreditodescuentos,formapagopuntoventas);

				} else if(tarjetacredito.getIsDeleted()) {
					this.saveTarjetaCreditoRelacionesDetalles(tarjetacreditoconexions,tarjetacreditodescuentos,formapagopuntoventas);
					this.saveTarjetaCredito();
				}

				TarjetaCreditoLogicAdditional.updateRelacionesToSaveAfter(tarjetacredito,this);

			} else {
				throw new Exception("LOS DATOS SON INVALIDOS");
			}

			if(conConexion) {connexion.commit();}

		} catch(Exception e) {
			
			TarjetaCreditoConexionConstantesFunciones.InicializarGeneralEntityAuxiliaresTarjetaCreditoConexions(tarjetacreditoconexions,true,true);
			TarjetaCreditoDescuentoConstantesFunciones.InicializarGeneralEntityAuxiliaresTarjetaCreditoDescuentos(tarjetacreditodescuentos,true,true);
			FormaPagoPuntoVentaConstantesFunciones.InicializarGeneralEntityAuxiliaresFormaPagoPuntoVentas(formapagopuntoventas,true,true);

			if(conConexion){connexion.rollback();}
			Funciones.manageException(logger,e);
			throw e;

		} finally {
			if(conConexion){this.closeNewConnexionToDeep();}
		}
	}
	
	
	private void saveTarjetaCreditoRelacionesDetalles(List<TarjetaCreditoConexion> tarjetacreditoconexions,List<TarjetaCreditoDescuento> tarjetacreditodescuentos,List<FormaPagoPuntoVenta> formapagopuntoventas)throws Exception {
		try {
	

			Long idTarjetaCreditoActual=this.getTarjetaCredito().getId();

			TarjetaCreditoConexionLogic tarjetacreditoconexionLogic_Desde_TarjetaCredito=new TarjetaCreditoConexionLogic();
			tarjetacreditoconexionLogic_Desde_TarjetaCredito.setTarjetaCreditoConexions(tarjetacreditoconexions);

			tarjetacreditoconexionLogic_Desde_TarjetaCredito.setConnexion(this.getConnexion());
			tarjetacreditoconexionLogic_Desde_TarjetaCredito.setDatosCliente(this.datosCliente);

			for(TarjetaCreditoConexion tarjetacreditoconexion_Desde_TarjetaCredito:tarjetacreditoconexionLogic_Desde_TarjetaCredito.getTarjetaCreditoConexions()) {
				tarjetacreditoconexion_Desde_TarjetaCredito.setid_tarjeta_credito(idTarjetaCreditoActual);
			}

			tarjetacreditoconexionLogic_Desde_TarjetaCredito.saveTarjetaCreditoConexions();

			TarjetaCreditoDescuentoLogic tarjetacreditodescuentoLogic_Desde_TarjetaCredito=new TarjetaCreditoDescuentoLogic();
			tarjetacreditodescuentoLogic_Desde_TarjetaCredito.setTarjetaCreditoDescuentos(tarjetacreditodescuentos);

			tarjetacreditodescuentoLogic_Desde_TarjetaCredito.setConnexion(this.getConnexion());
			tarjetacreditodescuentoLogic_Desde_TarjetaCredito.setDatosCliente(this.datosCliente);

			for(TarjetaCreditoDescuento tarjetacreditodescuento_Desde_TarjetaCredito:tarjetacreditodescuentoLogic_Desde_TarjetaCredito.getTarjetaCreditoDescuentos()) {
				tarjetacreditodescuento_Desde_TarjetaCredito.setid_tarjeta_credito(idTarjetaCreditoActual);
			}

			tarjetacreditodescuentoLogic_Desde_TarjetaCredito.saveTarjetaCreditoDescuentos();

			FormaPagoPuntoVentaLogic formapagopuntoventaLogic_Desde_TarjetaCredito=new FormaPagoPuntoVentaLogic();
			formapagopuntoventaLogic_Desde_TarjetaCredito.setFormaPagoPuntoVentas(formapagopuntoventas);

			formapagopuntoventaLogic_Desde_TarjetaCredito.setConnexion(this.getConnexion());
			formapagopuntoventaLogic_Desde_TarjetaCredito.setDatosCliente(this.datosCliente);

			for(FormaPagoPuntoVenta formapagopuntoventa_Desde_TarjetaCredito:formapagopuntoventaLogic_Desde_TarjetaCredito.getFormaPagoPuntoVentas()) {
				formapagopuntoventa_Desde_TarjetaCredito.setid_tarjeta_credito(idTarjetaCreditoActual);
			}

			formapagopuntoventaLogic_Desde_TarjetaCredito.saveFormaPagoPuntoVentas();

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfTarjetaCredito(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=TarjetaCreditoConstantesFunciones.getClassesForeignKeysOfTarjetaCredito(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTarjetaCredito(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=TarjetaCreditoConstantesFunciones.getClassesRelationshipsOfTarjetaCredito(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

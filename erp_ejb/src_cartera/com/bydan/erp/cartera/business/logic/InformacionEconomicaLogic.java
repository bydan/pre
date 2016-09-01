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
import com.bydan.erp.cartera.util.InformacionEconomicaConstantesFunciones;
import com.bydan.erp.cartera.util.InformacionEconomicaParameterReturnGeneral;
//import com.bydan.erp.cartera.util.InformacionEconomicaParameterGeneral;
import com.bydan.erp.cartera.business.entity.InformacionEconomica;
import com.bydan.erp.cartera.business.logic.InformacionEconomicaLogicAdditional;
import com.bydan.erp.cartera.business.dataaccess.*;
import com.bydan.erp.cartera.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;
















@SuppressWarnings("unused")
public class InformacionEconomicaLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(InformacionEconomicaLogic.class);
	
	protected InformacionEconomicaDataAccess informacioneconomicaDataAccess; 	
	protected InformacionEconomica informacioneconomica;
	protected List<InformacionEconomica> informacioneconomicas;
	protected Object informacioneconomicaObject;	
	protected List<Object> informacioneconomicasObject;
	
	public static ClassValidator<InformacionEconomica> informacioneconomicaValidator = new ClassValidator<InformacionEconomica>(InformacionEconomica.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected InformacionEconomicaLogicAdditional informacioneconomicaLogicAdditional=null;
	
	public InformacionEconomicaLogicAdditional getInformacionEconomicaLogicAdditional() {
		return this.informacioneconomicaLogicAdditional;
	}
	
	public void setInformacionEconomicaLogicAdditional(InformacionEconomicaLogicAdditional informacioneconomicaLogicAdditional) {
		try {
			this.informacioneconomicaLogicAdditional=informacioneconomicaLogicAdditional;
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
	
	
	
	
	public  InformacionEconomicaLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.informacioneconomicaDataAccess = new InformacionEconomicaDataAccess();
			
			this.informacioneconomicas= new ArrayList<InformacionEconomica>();
			this.informacioneconomica= new InformacionEconomica();
			
			this.informacioneconomicaObject=new Object();
			this.informacioneconomicasObject=new ArrayList<Object>();
				
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
			
			this.informacioneconomicaDataAccess.setConnexionType(this.connexionType);
			this.informacioneconomicaDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  InformacionEconomicaLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.informacioneconomicaDataAccess = new InformacionEconomicaDataAccess();
			this.informacioneconomicas= new ArrayList<InformacionEconomica>();
			this.informacioneconomica= new InformacionEconomica();
			this.informacioneconomicaObject=new Object();
			this.informacioneconomicasObject=new ArrayList<Object>();
			
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
			
			this.informacioneconomicaDataAccess.setConnexionType(this.connexionType);
			this.informacioneconomicaDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public InformacionEconomica getInformacionEconomica() throws Exception {	
		InformacionEconomicaLogicAdditional.checkInformacionEconomicaToGet(informacioneconomica,this.datosCliente,this.arrDatoGeneral);
		InformacionEconomicaLogicAdditional.updateInformacionEconomicaToGet(informacioneconomica,this.arrDatoGeneral);
		
		return informacioneconomica;
	}
		
	public void setInformacionEconomica(InformacionEconomica newInformacionEconomica) {
		this.informacioneconomica = newInformacionEconomica;
	}
	
	public InformacionEconomicaDataAccess getInformacionEconomicaDataAccess() {
		return informacioneconomicaDataAccess;
	}
	
	public void setInformacionEconomicaDataAccess(InformacionEconomicaDataAccess newinformacioneconomicaDataAccess) {
		this.informacioneconomicaDataAccess = newinformacioneconomicaDataAccess;
	}
	
	public List<InformacionEconomica> getInformacionEconomicas() throws Exception {		
		this.quitarInformacionEconomicasNulos();
		
		InformacionEconomicaLogicAdditional.checkInformacionEconomicaToGets(informacioneconomicas,this.datosCliente,this.arrDatoGeneral);
		
		for (InformacionEconomica informacioneconomicaLocal: informacioneconomicas ) {
			InformacionEconomicaLogicAdditional.updateInformacionEconomicaToGet(informacioneconomicaLocal,this.arrDatoGeneral);
		}
		
		return informacioneconomicas;
	}
	
	public void setInformacionEconomicas(List<InformacionEconomica> newInformacionEconomicas) {
		this.informacioneconomicas = newInformacionEconomicas;
	}
	
	public Object getInformacionEconomicaObject() {	
		this.informacioneconomicaObject=this.informacioneconomicaDataAccess.getEntityObject();
		return this.informacioneconomicaObject;
	}
		
	public void setInformacionEconomicaObject(Object newInformacionEconomicaObject) {
		this.informacioneconomicaObject = newInformacionEconomicaObject;
	}
	
	public List<Object> getInformacionEconomicasObject() {		
		this.informacioneconomicasObject=this.informacioneconomicaDataAccess.getEntitiesObject();
		return this.informacioneconomicasObject;
	}
		
	public void setInformacionEconomicasObject(List<Object> newInformacionEconomicasObject) {
		this.informacioneconomicasObject = newInformacionEconomicasObject;
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
		
		if(this.informacioneconomicaDataAccess!=null) {
			this.informacioneconomicaDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,InformacionEconomica.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			informacioneconomicaDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			informacioneconomicaDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		informacioneconomica = new  InformacionEconomica();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,InformacionEconomica.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			informacioneconomica=informacioneconomicaDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.informacioneconomica,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				InformacionEconomicaConstantesFunciones.refrescarForeignKeysDescripcionesInformacionEconomica(this.informacioneconomica);
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
		informacioneconomica = new  InformacionEconomica();
		  		  
        try {
			
			informacioneconomica=informacioneconomicaDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.informacioneconomica,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				InformacionEconomicaConstantesFunciones.refrescarForeignKeysDescripcionesInformacionEconomica(this.informacioneconomica);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		informacioneconomica = new  InformacionEconomica();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,InformacionEconomica.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			informacioneconomica=informacioneconomicaDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.informacioneconomica,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				InformacionEconomicaConstantesFunciones.refrescarForeignKeysDescripcionesInformacionEconomica(this.informacioneconomica);
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
		informacioneconomica = new  InformacionEconomica();
		  		  
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
		informacioneconomica = new  InformacionEconomica();
		  		  
        try {
			
			informacioneconomica=informacioneconomicaDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.informacioneconomica,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				InformacionEconomicaConstantesFunciones.refrescarForeignKeysDescripcionesInformacionEconomica(this.informacioneconomica);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		informacioneconomica = new  InformacionEconomica();
		  		  
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
		informacioneconomica = new  InformacionEconomica();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,InformacionEconomica.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =informacioneconomicaDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		informacioneconomica = new  InformacionEconomica();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=informacioneconomicaDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		informacioneconomica = new  InformacionEconomica();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,InformacionEconomica.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =informacioneconomicaDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		informacioneconomica = new  InformacionEconomica();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=informacioneconomicaDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		informacioneconomica = new  InformacionEconomica();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,InformacionEconomica.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =informacioneconomicaDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		informacioneconomica = new  InformacionEconomica();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=informacioneconomicaDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		informacioneconomicas = new  ArrayList<InformacionEconomica>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,InformacionEconomica.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			InformacionEconomicaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			informacioneconomicas=informacioneconomicaDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarInformacionEconomica(informacioneconomicas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				InformacionEconomicaConstantesFunciones.refrescarForeignKeysDescripcionesInformacionEconomica(this.informacioneconomicas);
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
		informacioneconomicas = new  ArrayList<InformacionEconomica>();
		  		  
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
		informacioneconomicas = new  ArrayList<InformacionEconomica>();
		  		  
        try {			
			InformacionEconomicaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			informacioneconomicas=informacioneconomicaDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarInformacionEconomica(informacioneconomicas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				InformacionEconomicaConstantesFunciones.refrescarForeignKeysDescripcionesInformacionEconomica(this.informacioneconomicas);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		informacioneconomicas = new  ArrayList<InformacionEconomica>();
		  		  
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
		informacioneconomicas = new  ArrayList<InformacionEconomica>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,InformacionEconomica.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			InformacionEconomicaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			informacioneconomicas=informacioneconomicaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarInformacionEconomica(informacioneconomicas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				InformacionEconomicaConstantesFunciones.refrescarForeignKeysDescripcionesInformacionEconomica(this.informacioneconomicas);
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
		informacioneconomicas = new  ArrayList<InformacionEconomica>();
		  		  
        try {
			InformacionEconomicaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			informacioneconomicas=informacioneconomicaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarInformacionEconomica(informacioneconomicas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				InformacionEconomicaConstantesFunciones.refrescarForeignKeysDescripcionesInformacionEconomica(this.informacioneconomicas);
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
		informacioneconomicas = new  ArrayList<InformacionEconomica>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,InformacionEconomica.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			InformacionEconomicaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			informacioneconomicas=informacioneconomicaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarInformacionEconomica(informacioneconomicas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				InformacionEconomicaConstantesFunciones.refrescarForeignKeysDescripcionesInformacionEconomica(this.informacioneconomicas);
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
		informacioneconomicas = new  ArrayList<InformacionEconomica>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			InformacionEconomicaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			informacioneconomicas=informacioneconomicaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarInformacionEconomica(informacioneconomicas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				InformacionEconomicaConstantesFunciones.refrescarForeignKeysDescripcionesInformacionEconomica(this.informacioneconomicas);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		informacioneconomica = new  InformacionEconomica();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,InformacionEconomica.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			InformacionEconomicaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			informacioneconomica=informacioneconomicaDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarInformacionEconomica(informacioneconomica);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				InformacionEconomicaConstantesFunciones.refrescarForeignKeysDescripcionesInformacionEconomica(this.informacioneconomica);
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
		informacioneconomica = new  InformacionEconomica();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			InformacionEconomicaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			informacioneconomica=informacioneconomicaDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarInformacionEconomica(informacioneconomica);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				InformacionEconomicaConstantesFunciones.refrescarForeignKeysDescripcionesInformacionEconomica(this.informacioneconomica);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		informacioneconomicas = new  ArrayList<InformacionEconomica>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,InformacionEconomica.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			InformacionEconomicaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			informacioneconomicas=informacioneconomicaDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarInformacionEconomica(informacioneconomicas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				InformacionEconomicaConstantesFunciones.refrescarForeignKeysDescripcionesInformacionEconomica(this.informacioneconomicas);
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
		informacioneconomicas = new  ArrayList<InformacionEconomica>();
		  		  
        try {
			InformacionEconomicaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			informacioneconomicas=informacioneconomicaDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarInformacionEconomica(informacioneconomicas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				InformacionEconomicaConstantesFunciones.refrescarForeignKeysDescripcionesInformacionEconomica(this.informacioneconomicas);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosInformacionEconomicasWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		informacioneconomicas = new  ArrayList<InformacionEconomica>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,InformacionEconomica.class.getSimpleName()+"-getTodosInformacionEconomicasWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			InformacionEconomicaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			informacioneconomicas=informacioneconomicaDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarInformacionEconomica(informacioneconomicas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				InformacionEconomicaConstantesFunciones.refrescarForeignKeysDescripcionesInformacionEconomica(this.informacioneconomicas);
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
	
	public  void  getTodosInformacionEconomicas(String sFinalQuery,Pagination pagination)throws Exception {
		informacioneconomicas = new  ArrayList<InformacionEconomica>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			InformacionEconomicaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			informacioneconomicas=informacioneconomicaDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarInformacionEconomica(informacioneconomicas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				InformacionEconomicaConstantesFunciones.refrescarForeignKeysDescripcionesInformacionEconomica(this.informacioneconomicas);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarInformacionEconomica(InformacionEconomica informacioneconomica) throws Exception {
		Boolean estaValidado=false;
		
		if(informacioneconomica.getIsNew() || informacioneconomica.getIsChanged()) { 
			this.invalidValues = informacioneconomicaValidator.getInvalidValues(informacioneconomica);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(informacioneconomica);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarInformacionEconomica(List<InformacionEconomica> InformacionEconomicas) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(InformacionEconomica informacioneconomicaLocal:informacioneconomicas) {				
			estaValidadoObjeto=this.validarGuardarInformacionEconomica(informacioneconomicaLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarInformacionEconomica(List<InformacionEconomica> InformacionEconomicas) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarInformacionEconomica(informacioneconomicas)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarInformacionEconomica(InformacionEconomica InformacionEconomica) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarInformacionEconomica(informacioneconomica)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(InformacionEconomica informacioneconomica) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+informacioneconomica.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=InformacionEconomicaConstantesFunciones.getInformacionEconomicaLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"informacioneconomica","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(InformacionEconomicaConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(InformacionEconomicaConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveInformacionEconomicaWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,InformacionEconomica.class.getSimpleName()+"-saveInformacionEconomicaWithConnection");connexion.begin();			
			
			InformacionEconomicaLogicAdditional.checkInformacionEconomicaToSave(this.informacioneconomica,this.datosCliente,connexion,this.arrDatoGeneral);
			
			InformacionEconomicaLogicAdditional.updateInformacionEconomicaToSave(this.informacioneconomica,this.arrDatoGeneral);
			
			InformacionEconomicaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.informacioneconomica,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowInformacionEconomica();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarInformacionEconomica(this.informacioneconomica)) {
				InformacionEconomicaDataAccess.save(this.informacioneconomica, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.informacioneconomica,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			InformacionEconomicaLogicAdditional.checkInformacionEconomicaToSaveAfter(this.informacioneconomica,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowInformacionEconomica();
			
			connexion.commit();			
			
			if(this.informacioneconomica.getIsDeleted()) {
				this.informacioneconomica=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveInformacionEconomica()throws Exception {	
		try {	
			
			InformacionEconomicaLogicAdditional.checkInformacionEconomicaToSave(this.informacioneconomica,this.datosCliente,connexion,this.arrDatoGeneral);
			
			InformacionEconomicaLogicAdditional.updateInformacionEconomicaToSave(this.informacioneconomica,this.arrDatoGeneral);
			
			InformacionEconomicaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.informacioneconomica,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarInformacionEconomica(this.informacioneconomica)) {			
				InformacionEconomicaDataAccess.save(this.informacioneconomica, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.informacioneconomica,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			InformacionEconomicaLogicAdditional.checkInformacionEconomicaToSaveAfter(this.informacioneconomica,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.informacioneconomica.getIsDeleted()) {
				this.informacioneconomica=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveInformacionEconomicasWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,InformacionEconomica.class.getSimpleName()+"-saveInformacionEconomicasWithConnection");connexion.begin();			
			
			InformacionEconomicaLogicAdditional.checkInformacionEconomicaToSaves(informacioneconomicas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowInformacionEconomicas();
			
			Boolean validadoTodosInformacionEconomica=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(InformacionEconomica informacioneconomicaLocal:informacioneconomicas) {		
				if(informacioneconomicaLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				InformacionEconomicaLogicAdditional.updateInformacionEconomicaToSave(informacioneconomicaLocal,this.arrDatoGeneral);
	        	
				InformacionEconomicaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),informacioneconomicaLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarInformacionEconomica(informacioneconomicaLocal)) {
					InformacionEconomicaDataAccess.save(informacioneconomicaLocal, connexion);				
				} else {
					validadoTodosInformacionEconomica=false;
				}
			}
			
			if(!validadoTodosInformacionEconomica) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			InformacionEconomicaLogicAdditional.checkInformacionEconomicaToSavesAfter(informacioneconomicas,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowInformacionEconomicas();
			
			connexion.commit();		
			
			this.quitarInformacionEconomicasEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveInformacionEconomicas()throws Exception {				
		 try {	
			InformacionEconomicaLogicAdditional.checkInformacionEconomicaToSaves(informacioneconomicas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosInformacionEconomica=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(InformacionEconomica informacioneconomicaLocal:informacioneconomicas) {				
				if(informacioneconomicaLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				InformacionEconomicaLogicAdditional.updateInformacionEconomicaToSave(informacioneconomicaLocal,this.arrDatoGeneral);
	        	
				InformacionEconomicaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),informacioneconomicaLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarInformacionEconomica(informacioneconomicaLocal)) {				
					InformacionEconomicaDataAccess.save(informacioneconomicaLocal, connexion);				
				} else {
					validadoTodosInformacionEconomica=false;
				}
			}
			
			if(!validadoTodosInformacionEconomica) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			InformacionEconomicaLogicAdditional.checkInformacionEconomicaToSavesAfter(informacioneconomicas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarInformacionEconomicasEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public InformacionEconomicaParameterReturnGeneral procesarAccionInformacionEconomicas(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<InformacionEconomica> informacioneconomicas,InformacionEconomicaParameterReturnGeneral informacioneconomicaParameterGeneral)throws Exception {
		 try {	
			InformacionEconomicaParameterReturnGeneral informacioneconomicaReturnGeneral=new InformacionEconomicaParameterReturnGeneral();
	
			InformacionEconomicaLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,informacioneconomicas,informacioneconomicaParameterGeneral,informacioneconomicaReturnGeneral);
			
			return informacioneconomicaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public InformacionEconomicaParameterReturnGeneral procesarAccionInformacionEconomicasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<InformacionEconomica> informacioneconomicas,InformacionEconomicaParameterReturnGeneral informacioneconomicaParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,InformacionEconomica.class.getSimpleName()+"-procesarAccionInformacionEconomicasWithConnection");connexion.begin();			
			
			InformacionEconomicaParameterReturnGeneral informacioneconomicaReturnGeneral=new InformacionEconomicaParameterReturnGeneral();
	
			InformacionEconomicaLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,informacioneconomicas,informacioneconomicaParameterGeneral,informacioneconomicaReturnGeneral);
			
			this.connexion.commit();
			
			return informacioneconomicaReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public InformacionEconomicaParameterReturnGeneral procesarEventosInformacionEconomicas(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<InformacionEconomica> informacioneconomicas,InformacionEconomica informacioneconomica,InformacionEconomicaParameterReturnGeneral informacioneconomicaParameterGeneral,Boolean isEsNuevoInformacionEconomica,ArrayList<Classe> clases)throws Exception {
		 try {	
			InformacionEconomicaParameterReturnGeneral informacioneconomicaReturnGeneral=new InformacionEconomicaParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				informacioneconomicaReturnGeneral.setConRecargarPropiedades(true);
			}
			
			InformacionEconomicaLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,informacioneconomicas,informacioneconomica,informacioneconomicaParameterGeneral,informacioneconomicaReturnGeneral,isEsNuevoInformacionEconomica,clases);
			
			return informacioneconomicaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public InformacionEconomicaParameterReturnGeneral procesarEventosInformacionEconomicasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<InformacionEconomica> informacioneconomicas,InformacionEconomica informacioneconomica,InformacionEconomicaParameterReturnGeneral informacioneconomicaParameterGeneral,Boolean isEsNuevoInformacionEconomica,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,InformacionEconomica.class.getSimpleName()+"-procesarEventosInformacionEconomicasWithConnection");connexion.begin();			
			
			InformacionEconomicaParameterReturnGeneral informacioneconomicaReturnGeneral=new InformacionEconomicaParameterReturnGeneral();
	
			informacioneconomicaReturnGeneral.setInformacionEconomica(informacioneconomica);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				informacioneconomicaReturnGeneral.setConRecargarPropiedades(true);
			}
			
			InformacionEconomicaLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,informacioneconomicas,informacioneconomica,informacioneconomicaParameterGeneral,informacioneconomicaReturnGeneral,isEsNuevoInformacionEconomica,clases);
			
			this.connexion.commit();
			
			return informacioneconomicaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public InformacionEconomicaParameterReturnGeneral procesarImportacionInformacionEconomicasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,InformacionEconomicaParameterReturnGeneral informacioneconomicaParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,InformacionEconomica.class.getSimpleName()+"-procesarImportacionInformacionEconomicasWithConnection");connexion.begin();			
			
			InformacionEconomicaParameterReturnGeneral informacioneconomicaReturnGeneral=new InformacionEconomicaParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.informacioneconomicas=new ArrayList<InformacionEconomica>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.informacioneconomica=new InformacionEconomica();
				
				
				if(conColumnasBase) {this.informacioneconomica.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.informacioneconomica.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.informacioneconomica.setcodigoactualizacion(arrColumnas[iColumn++]);
				this.informacioneconomica.setcodigodestinofinanciero(arrColumnas[iColumn++]);
				this.informacioneconomica.setorigenrecursos(arrColumnas[iColumn++]);
				this.informacioneconomica.setcuasavinculacion(arrColumnas[iColumn++]);
				this.informacioneconomica.setsectorizacion(arrColumnas[iColumn++]);
				this.informacioneconomica.setesactivo(Boolean.parseBoolean(arrColumnas[iColumn++]));
				
				this.informacioneconomicas.add(this.informacioneconomica);
			}
			
			this.saveInformacionEconomicas();
			
			this.connexion.commit();
			
			informacioneconomicaReturnGeneral.setConRetornoEstaProcesado(true);
			informacioneconomicaReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return informacioneconomicaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarInformacionEconomicasEliminados() throws Exception {				
		
		List<InformacionEconomica> informacioneconomicasAux= new ArrayList<InformacionEconomica>();
		
		for(InformacionEconomica informacioneconomica:informacioneconomicas) {
			if(!informacioneconomica.getIsDeleted()) {
				informacioneconomicasAux.add(informacioneconomica);
			}
		}
		
		informacioneconomicas=informacioneconomicasAux;
	}
	
	public void quitarInformacionEconomicasNulos() throws Exception {				
		
		List<InformacionEconomica> informacioneconomicasAux= new ArrayList<InformacionEconomica>();
		
		for(InformacionEconomica informacioneconomica : this.informacioneconomicas) {
			if(informacioneconomica==null) {
				informacioneconomicasAux.add(informacioneconomica);
			}
		}
		
		//this.informacioneconomicas=informacioneconomicasAux;
		
		this.informacioneconomicas.removeAll(informacioneconomicasAux);
	}
	
	public void getSetVersionRowInformacionEconomicaWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(informacioneconomica.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((informacioneconomica.getIsDeleted() || (informacioneconomica.getIsChanged()&&!informacioneconomica.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=informacioneconomicaDataAccess.getSetVersionRowInformacionEconomica(connexion,informacioneconomica.getId());
				
				if(!informacioneconomica.getVersionRow().equals(timestamp)) {	
					informacioneconomica.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				informacioneconomica.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowInformacionEconomica()throws Exception {	
		
		if(informacioneconomica.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((informacioneconomica.getIsDeleted() || (informacioneconomica.getIsChanged()&&!informacioneconomica.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=informacioneconomicaDataAccess.getSetVersionRowInformacionEconomica(connexion,informacioneconomica.getId());
			
			try {							
				if(!informacioneconomica.getVersionRow().equals(timestamp)) {	
					informacioneconomica.setVersionRow(timestamp);
				}
				
				informacioneconomica.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowInformacionEconomicasWithConnection()throws Exception {	
		if(informacioneconomicas!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(InformacionEconomica informacioneconomicaAux:informacioneconomicas) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(informacioneconomicaAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(informacioneconomicaAux.getIsDeleted() || (informacioneconomicaAux.getIsChanged()&&!informacioneconomicaAux.getIsNew())) {
						
						timestamp=informacioneconomicaDataAccess.getSetVersionRowInformacionEconomica(connexion,informacioneconomicaAux.getId());
						
						if(!informacioneconomica.getVersionRow().equals(timestamp)) {	
							informacioneconomicaAux.setVersionRow(timestamp);
						}
								
						informacioneconomicaAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowInformacionEconomicas()throws Exception {	
		if(informacioneconomicas!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(InformacionEconomica informacioneconomicaAux:informacioneconomicas) {
					if(informacioneconomicaAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(informacioneconomicaAux.getIsDeleted() || (informacioneconomicaAux.getIsChanged()&&!informacioneconomicaAux.getIsNew())) {
						
						timestamp=informacioneconomicaDataAccess.getSetVersionRowInformacionEconomica(connexion,informacioneconomicaAux.getId());
						
						if(!informacioneconomicaAux.getVersionRow().equals(timestamp)) {	
							informacioneconomicaAux.setVersionRow(timestamp);
						}
						
													
						informacioneconomicaAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public InformacionEconomicaParameterReturnGeneral cargarCombosLoteForeignKeyInformacionEconomicaWithConnection(String finalQueryGlobalCliente,String finalQueryGlobalTipoVinculacion) throws Exception {
		InformacionEconomicaParameterReturnGeneral  informacioneconomicaReturnGeneral =new InformacionEconomicaParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,InformacionEconomica.class.getSimpleName()+"-cargarCombosLoteForeignKeyInformacionEconomicaWithConnection");connexion.begin();
			
			informacioneconomicaReturnGeneral =new InformacionEconomicaParameterReturnGeneral();
			
			

			List<Cliente> clientesForeignKey=new ArrayList<Cliente>();
			ClienteLogic clienteLogic=new ClienteLogic();
			clienteLogic.setConnexion(this.connexion);
			clienteLogic.getClienteDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCliente.equals("NONE")) {
				clienteLogic.getTodosClientes(finalQueryGlobalCliente,new Pagination());
				clientesForeignKey=clienteLogic.getClientes();
			}

			informacioneconomicaReturnGeneral.setclientesForeignKey(clientesForeignKey);


			List<TipoVinculacion> tipovinculacionsForeignKey=new ArrayList<TipoVinculacion>();
			TipoVinculacionLogic tipovinculacionLogic=new TipoVinculacionLogic();
			tipovinculacionLogic.setConnexion(this.connexion);
			tipovinculacionLogic.getTipoVinculacionDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoVinculacion.equals("NONE")) {
				tipovinculacionLogic.getTodosTipoVinculacions(finalQueryGlobalTipoVinculacion,new Pagination());
				tipovinculacionsForeignKey=tipovinculacionLogic.getTipoVinculacions();
			}

			informacioneconomicaReturnGeneral.settipovinculacionsForeignKey(tipovinculacionsForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return informacioneconomicaReturnGeneral;
	}
	
	public InformacionEconomicaParameterReturnGeneral cargarCombosLoteForeignKeyInformacionEconomica(String finalQueryGlobalCliente,String finalQueryGlobalTipoVinculacion) throws Exception {
		InformacionEconomicaParameterReturnGeneral  informacioneconomicaReturnGeneral =new InformacionEconomicaParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			informacioneconomicaReturnGeneral =new InformacionEconomicaParameterReturnGeneral();
			
			

			List<Cliente> clientesForeignKey=new ArrayList<Cliente>();
			ClienteLogic clienteLogic=new ClienteLogic();
			clienteLogic.setConnexion(this.connexion);
			clienteLogic.getClienteDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCliente.equals("NONE")) {
				clienteLogic.getTodosClientes(finalQueryGlobalCliente,new Pagination());
				clientesForeignKey=clienteLogic.getClientes();
			}

			informacioneconomicaReturnGeneral.setclientesForeignKey(clientesForeignKey);


			List<TipoVinculacion> tipovinculacionsForeignKey=new ArrayList<TipoVinculacion>();
			TipoVinculacionLogic tipovinculacionLogic=new TipoVinculacionLogic();
			tipovinculacionLogic.setConnexion(this.connexion);
			tipovinculacionLogic.getTipoVinculacionDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoVinculacion.equals("NONE")) {
				tipovinculacionLogic.getTodosTipoVinculacions(finalQueryGlobalTipoVinculacion,new Pagination());
				tipovinculacionsForeignKey=tipovinculacionLogic.getTipoVinculacions();
			}

			informacioneconomicaReturnGeneral.settipovinculacionsForeignKey(tipovinculacionsForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return informacioneconomicaReturnGeneral;
	}
	
	
	public void deepLoad(InformacionEconomica informacioneconomica,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			InformacionEconomicaLogicAdditional.updateInformacionEconomicaToGet(informacioneconomica,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		informacioneconomica.setCliente(informacioneconomicaDataAccess.getCliente(connexion,informacioneconomica));
		informacioneconomica.setTipoVinculacion(informacioneconomicaDataAccess.getTipoVinculacion(connexion,informacioneconomica));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Cliente.class)) {
				informacioneconomica.setCliente(informacioneconomicaDataAccess.getCliente(connexion,informacioneconomica));
				continue;
			}

			if(clas.clas.equals(TipoVinculacion.class)) {
				informacioneconomica.setTipoVinculacion(informacioneconomicaDataAccess.getTipoVinculacion(connexion,informacioneconomica));
				continue;
			}
		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Cliente.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			informacioneconomica.setCliente(informacioneconomicaDataAccess.getCliente(connexion,informacioneconomica));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoVinculacion.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			informacioneconomica.setTipoVinculacion(informacioneconomicaDataAccess.getTipoVinculacion(connexion,informacioneconomica));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		informacioneconomica.setCliente(informacioneconomicaDataAccess.getCliente(connexion,informacioneconomica));
		ClienteLogic clienteLogic= new ClienteLogic(connexion);
		clienteLogic.deepLoad(informacioneconomica.getCliente(),isDeep,deepLoadType,clases);
				
		informacioneconomica.setTipoVinculacion(informacioneconomicaDataAccess.getTipoVinculacion(connexion,informacioneconomica));
		TipoVinculacionLogic tipovinculacionLogic= new TipoVinculacionLogic(connexion);
		tipovinculacionLogic.deepLoad(informacioneconomica.getTipoVinculacion(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Cliente.class)) {
				informacioneconomica.setCliente(informacioneconomicaDataAccess.getCliente(connexion,informacioneconomica));
				ClienteLogic clienteLogic= new ClienteLogic(connexion);
				clienteLogic.deepLoad(informacioneconomica.getCliente(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoVinculacion.class)) {
				informacioneconomica.setTipoVinculacion(informacioneconomicaDataAccess.getTipoVinculacion(connexion,informacioneconomica));
				TipoVinculacionLogic tipovinculacionLogic= new TipoVinculacionLogic(connexion);
				tipovinculacionLogic.deepLoad(informacioneconomica.getTipoVinculacion(),isDeep,deepLoadType,clases);				
				continue;
			}

		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {


		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Cliente.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			informacioneconomica.setCliente(informacioneconomicaDataAccess.getCliente(connexion,informacioneconomica));
			ClienteLogic clienteLogic= new ClienteLogic(connexion);
			clienteLogic.deepLoad(informacioneconomica.getCliente(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoVinculacion.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			informacioneconomica.setTipoVinculacion(informacioneconomicaDataAccess.getTipoVinculacion(connexion,informacioneconomica));
			TipoVinculacionLogic tipovinculacionLogic= new TipoVinculacionLogic(connexion);
			tipovinculacionLogic.deepLoad(informacioneconomica.getTipoVinculacion(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(InformacionEconomica informacioneconomica,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			InformacionEconomicaLogicAdditional.updateInformacionEconomicaToSave(informacioneconomica,this.arrDatoGeneral);
			
InformacionEconomicaDataAccess.save(informacioneconomica, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		ClienteDataAccess.save(informacioneconomica.getCliente(),connexion);

		TipoVinculacionDataAccess.save(informacioneconomica.getTipoVinculacion(),connexion);
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Cliente.class)) {
				ClienteDataAccess.save(informacioneconomica.getCliente(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoVinculacion.class)) {
				TipoVinculacionDataAccess.save(informacioneconomica.getTipoVinculacion(),connexion);
				continue;
			}

		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		ClienteDataAccess.save(informacioneconomica.getCliente(),connexion);
		ClienteLogic clienteLogic= new ClienteLogic(connexion);
		clienteLogic.deepLoad(informacioneconomica.getCliente(),isDeep,deepLoadType,clases);
				

		TipoVinculacionDataAccess.save(informacioneconomica.getTipoVinculacion(),connexion);
		TipoVinculacionLogic tipovinculacionLogic= new TipoVinculacionLogic(connexion);
		tipovinculacionLogic.deepLoad(informacioneconomica.getTipoVinculacion(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Cliente.class)) {
				ClienteDataAccess.save(informacioneconomica.getCliente(),connexion);
				ClienteLogic clienteLogic= new ClienteLogic(connexion);
				clienteLogic.deepSave(informacioneconomica.getCliente(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoVinculacion.class)) {
				TipoVinculacionDataAccess.save(informacioneconomica.getTipoVinculacion(),connexion);
				TipoVinculacionLogic tipovinculacionLogic= new TipoVinculacionLogic(connexion);
				tipovinculacionLogic.deepSave(informacioneconomica.getTipoVinculacion(),isDeep,deepLoadType,clases);				
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
			this.getNewConnexionToDeep(InformacionEconomica.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(informacioneconomica,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				InformacionEconomicaConstantesFunciones.refrescarForeignKeysDescripcionesInformacionEconomica(informacioneconomica);
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
			this.deepLoad(this.informacioneconomica,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				InformacionEconomicaConstantesFunciones.refrescarForeignKeysDescripcionesInformacionEconomica(this.informacioneconomica);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(InformacionEconomica.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(informacioneconomicas!=null) {
				for(InformacionEconomica informacioneconomica:informacioneconomicas) {
					this.deepLoad(informacioneconomica,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					InformacionEconomicaConstantesFunciones.refrescarForeignKeysDescripcionesInformacionEconomica(informacioneconomicas);
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
			if(informacioneconomicas!=null) {
				for(InformacionEconomica informacioneconomica:informacioneconomicas) {
					this.deepLoad(informacioneconomica,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					InformacionEconomicaConstantesFunciones.refrescarForeignKeysDescripcionesInformacionEconomica(informacioneconomicas);
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
			this.getNewConnexionToDeep(InformacionEconomica.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(informacioneconomica,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(InformacionEconomica.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(informacioneconomicas!=null) {
				for(InformacionEconomica informacioneconomica:informacioneconomicas) {
					this.deepSave(informacioneconomica,isDeep,deepLoadType,clases);
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
			if(informacioneconomicas!=null) {
				for(InformacionEconomica informacioneconomica:informacioneconomicas) {
					this.deepSave(informacioneconomica,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getInformacionEconomicasFK_IdClienteWithConnection(String sFinalQuery,Pagination pagination,Long idcliente)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,InformacionEconomica.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCliente= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCliente.setParameterSelectionGeneralEqual(ParameterType.LONG,idcliente,InformacionEconomicaConstantesFunciones.IDCLIENTE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCliente);

			InformacionEconomicaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCliente","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			informacioneconomicas=informacioneconomicaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				InformacionEconomicaConstantesFunciones.refrescarForeignKeysDescripcionesInformacionEconomica(this.informacioneconomicas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getInformacionEconomicasFK_IdCliente(String sFinalQuery,Pagination pagination,Long idcliente)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCliente= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCliente.setParameterSelectionGeneralEqual(ParameterType.LONG,idcliente,InformacionEconomicaConstantesFunciones.IDCLIENTE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCliente);

			InformacionEconomicaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCliente","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			informacioneconomicas=informacioneconomicaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				InformacionEconomicaConstantesFunciones.refrescarForeignKeysDescripcionesInformacionEconomica(this.informacioneconomicas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getInformacionEconomicasFK_IdValorClienteVinculacionWithConnection(String sFinalQuery,Pagination pagination,Long idvalorclientevinculacion)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,InformacionEconomica.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoVinculacion= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoVinculacion.setParameterSelectionGeneralEqual(ParameterType.LONG,idvalorclientevinculacion,InformacionEconomicaConstantesFunciones.IDTIPOVINCULACION,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoVinculacion);

			InformacionEconomicaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdValorClienteVinculacion","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			informacioneconomicas=informacioneconomicaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				InformacionEconomicaConstantesFunciones.refrescarForeignKeysDescripcionesInformacionEconomica(this.informacioneconomicas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getInformacionEconomicasFK_IdValorClienteVinculacion(String sFinalQuery,Pagination pagination,Long idvalorclientevinculacion)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoVinculacion= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoVinculacion.setParameterSelectionGeneralEqual(ParameterType.LONG,idvalorclientevinculacion,InformacionEconomicaConstantesFunciones.IDTIPOVINCULACION,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoVinculacion);

			InformacionEconomicaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdValorClienteVinculacion","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			informacioneconomicas=informacioneconomicaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				InformacionEconomicaConstantesFunciones.refrescarForeignKeysDescripcionesInformacionEconomica(this.informacioneconomicas);
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
			if(InformacionEconomicaConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,InformacionEconomicaDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,InformacionEconomica informacioneconomica,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(InformacionEconomicaConstantesFunciones.ISCONAUDITORIA) {
				if(informacioneconomica.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,InformacionEconomicaDataAccess.TABLENAME, informacioneconomica.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(InformacionEconomicaConstantesFunciones.ISCONAUDITORIADETALLE) {
						////InformacionEconomicaLogic.registrarAuditoriaDetallesInformacionEconomica(connexion,informacioneconomica,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(informacioneconomica.getIsDeleted()) {
					/*if(!informacioneconomica.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,InformacionEconomicaDataAccess.TABLENAME, informacioneconomica.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////InformacionEconomicaLogic.registrarAuditoriaDetallesInformacionEconomica(connexion,informacioneconomica,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,InformacionEconomicaDataAccess.TABLENAME, informacioneconomica.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(informacioneconomica.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,InformacionEconomicaDataAccess.TABLENAME, informacioneconomica.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(InformacionEconomicaConstantesFunciones.ISCONAUDITORIADETALLE) {
						////InformacionEconomicaLogic.registrarAuditoriaDetallesInformacionEconomica(connexion,informacioneconomica,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesInformacionEconomica(Connexion connexion,InformacionEconomica informacioneconomica)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(informacioneconomica.getIsNew()||!informacioneconomica.getidcliente().equals(informacioneconomica.getInformacionEconomicaOriginal().getidcliente()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(informacioneconomica.getInformacionEconomicaOriginal().getidcliente()!=null)
				{
					strValorActual=informacioneconomica.getInformacionEconomicaOriginal().getidcliente().toString();
				}
				if(informacioneconomica.getidcliente()!=null)
				{
					strValorNuevo=informacioneconomica.getidcliente().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),InformacionEconomicaConstantesFunciones.IDCLIENTE,strValorActual,strValorNuevo);
			}	
			
			if(informacioneconomica.getIsNew()||!informacioneconomica.getidvalorclientevinculacion().equals(informacioneconomica.getInformacionEconomicaOriginal().getidvalorclientevinculacion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(informacioneconomica.getInformacionEconomicaOriginal().getidvalorclientevinculacion()!=null)
				{
					strValorActual=informacioneconomica.getInformacionEconomicaOriginal().getidvalorclientevinculacion().toString();
				}
				if(informacioneconomica.getidvalorclientevinculacion()!=null)
				{
					strValorNuevo=informacioneconomica.getidvalorclientevinculacion().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),InformacionEconomicaConstantesFunciones.IDTIPOVINCULACION,strValorActual,strValorNuevo);
			}	
			
			if(informacioneconomica.getIsNew()||!informacioneconomica.getcodigoactualizacion().equals(informacioneconomica.getInformacionEconomicaOriginal().getcodigoactualizacion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(informacioneconomica.getInformacionEconomicaOriginal().getcodigoactualizacion()!=null)
				{
					strValorActual=informacioneconomica.getInformacionEconomicaOriginal().getcodigoactualizacion();
				}
				if(informacioneconomica.getcodigoactualizacion()!=null)
				{
					strValorNuevo=informacioneconomica.getcodigoactualizacion() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),InformacionEconomicaConstantesFunciones.CODIGOACTUALIZACION,strValorActual,strValorNuevo);
			}	
			
			if(informacioneconomica.getIsNew()||!informacioneconomica.getcodigodestinofinanciero().equals(informacioneconomica.getInformacionEconomicaOriginal().getcodigodestinofinanciero()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(informacioneconomica.getInformacionEconomicaOriginal().getcodigodestinofinanciero()!=null)
				{
					strValorActual=informacioneconomica.getInformacionEconomicaOriginal().getcodigodestinofinanciero();
				}
				if(informacioneconomica.getcodigodestinofinanciero()!=null)
				{
					strValorNuevo=informacioneconomica.getcodigodestinofinanciero() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),InformacionEconomicaConstantesFunciones.CODIGODESTINOFINANCIERO,strValorActual,strValorNuevo);
			}	
			
			if(informacioneconomica.getIsNew()||!informacioneconomica.getorigenrecursos().equals(informacioneconomica.getInformacionEconomicaOriginal().getorigenrecursos()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(informacioneconomica.getInformacionEconomicaOriginal().getorigenrecursos()!=null)
				{
					strValorActual=informacioneconomica.getInformacionEconomicaOriginal().getorigenrecursos();
				}
				if(informacioneconomica.getorigenrecursos()!=null)
				{
					strValorNuevo=informacioneconomica.getorigenrecursos() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),InformacionEconomicaConstantesFunciones.ORIGENRECURSOS,strValorActual,strValorNuevo);
			}	
			
			if(informacioneconomica.getIsNew()||!informacioneconomica.getcuasavinculacion().equals(informacioneconomica.getInformacionEconomicaOriginal().getcuasavinculacion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(informacioneconomica.getInformacionEconomicaOriginal().getcuasavinculacion()!=null)
				{
					strValorActual=informacioneconomica.getInformacionEconomicaOriginal().getcuasavinculacion();
				}
				if(informacioneconomica.getcuasavinculacion()!=null)
				{
					strValorNuevo=informacioneconomica.getcuasavinculacion() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),InformacionEconomicaConstantesFunciones.CUASAVINCULACION,strValorActual,strValorNuevo);
			}	
			
			if(informacioneconomica.getIsNew()||!informacioneconomica.getsectorizacion().equals(informacioneconomica.getInformacionEconomicaOriginal().getsectorizacion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(informacioneconomica.getInformacionEconomicaOriginal().getsectorizacion()!=null)
				{
					strValorActual=informacioneconomica.getInformacionEconomicaOriginal().getsectorizacion();
				}
				if(informacioneconomica.getsectorizacion()!=null)
				{
					strValorNuevo=informacioneconomica.getsectorizacion() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),InformacionEconomicaConstantesFunciones.SECTORIZACION,strValorActual,strValorNuevo);
			}	
			
			if(informacioneconomica.getIsNew()||!informacioneconomica.getesactivo().equals(informacioneconomica.getInformacionEconomicaOriginal().getesactivo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(informacioneconomica.getInformacionEconomicaOriginal().getesactivo()!=null)
				{
					strValorActual=informacioneconomica.getInformacionEconomicaOriginal().getesactivo().toString();
				}
				if(informacioneconomica.getesactivo()!=null)
				{
					strValorNuevo=informacioneconomica.getesactivo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),InformacionEconomicaConstantesFunciones.ESACTIVO,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveInformacionEconomicaRelacionesWithConnection(InformacionEconomica informacioneconomica) throws Exception {

		if(!informacioneconomica.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveInformacionEconomicaRelacionesBase(informacioneconomica,true);
		}
	}

	public void saveInformacionEconomicaRelaciones(InformacionEconomica informacioneconomica)throws Exception {

		if(!informacioneconomica.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveInformacionEconomicaRelacionesBase(informacioneconomica,false);
		}
	}

	public void saveInformacionEconomicaRelacionesBase(InformacionEconomica informacioneconomica,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("InformacionEconomica-saveRelacionesWithConnection");}
	

			this.setInformacionEconomica(informacioneconomica);

			if(InformacionEconomicaLogicAdditional.validarSaveRelaciones(informacioneconomica,this)) {

				InformacionEconomicaLogicAdditional.updateRelacionesToSave(informacioneconomica,this);

				if((informacioneconomica.getIsNew()||informacioneconomica.getIsChanged())&&!informacioneconomica.getIsDeleted()) {
					this.saveInformacionEconomica();
					this.saveInformacionEconomicaRelacionesDetalles();

				} else if(informacioneconomica.getIsDeleted()) {
					this.saveInformacionEconomicaRelacionesDetalles();
					this.saveInformacionEconomica();
				}

				InformacionEconomicaLogicAdditional.updateRelacionesToSaveAfter(informacioneconomica,this);

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
	
	
	private void saveInformacionEconomicaRelacionesDetalles()throws Exception {
		try {
	

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfInformacionEconomica(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=InformacionEconomicaConstantesFunciones.getClassesForeignKeysOfInformacionEconomica(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfInformacionEconomica(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=InformacionEconomicaConstantesFunciones.getClassesRelationshipsOfInformacionEconomica(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

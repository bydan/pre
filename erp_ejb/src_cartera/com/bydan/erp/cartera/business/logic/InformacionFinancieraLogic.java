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
import com.bydan.erp.cartera.util.InformacionFinancieraConstantesFunciones;
import com.bydan.erp.cartera.util.InformacionFinancieraParameterReturnGeneral;
//import com.bydan.erp.cartera.util.InformacionFinancieraParameterGeneral;
import com.bydan.erp.cartera.business.entity.InformacionFinanciera;
import com.bydan.erp.cartera.business.logic.InformacionFinancieraLogicAdditional;
import com.bydan.erp.cartera.business.dataaccess.*;
import com.bydan.erp.cartera.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;


import com.bydan.erp.seguridad.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;








@SuppressWarnings("unused")
public class InformacionFinancieraLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(InformacionFinancieraLogic.class);
	
	protected InformacionFinancieraDataAccess informacionfinancieraDataAccess; 	
	protected InformacionFinanciera informacionfinanciera;
	protected List<InformacionFinanciera> informacionfinancieras;
	protected Object informacionfinancieraObject;	
	protected List<Object> informacionfinancierasObject;
	
	public static ClassValidator<InformacionFinanciera> informacionfinancieraValidator = new ClassValidator<InformacionFinanciera>(InformacionFinanciera.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected InformacionFinancieraLogicAdditional informacionfinancieraLogicAdditional=null;
	
	public InformacionFinancieraLogicAdditional getInformacionFinancieraLogicAdditional() {
		return this.informacionfinancieraLogicAdditional;
	}
	
	public void setInformacionFinancieraLogicAdditional(InformacionFinancieraLogicAdditional informacionfinancieraLogicAdditional) {
		try {
			this.informacionfinancieraLogicAdditional=informacionfinancieraLogicAdditional;
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
	
	
	
	
	public  InformacionFinancieraLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.informacionfinancieraDataAccess = new InformacionFinancieraDataAccess();
			
			this.informacionfinancieras= new ArrayList<InformacionFinanciera>();
			this.informacionfinanciera= new InformacionFinanciera();
			
			this.informacionfinancieraObject=new Object();
			this.informacionfinancierasObject=new ArrayList<Object>();
				
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
			
			this.informacionfinancieraDataAccess.setConnexionType(this.connexionType);
			this.informacionfinancieraDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  InformacionFinancieraLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.informacionfinancieraDataAccess = new InformacionFinancieraDataAccess();
			this.informacionfinancieras= new ArrayList<InformacionFinanciera>();
			this.informacionfinanciera= new InformacionFinanciera();
			this.informacionfinancieraObject=new Object();
			this.informacionfinancierasObject=new ArrayList<Object>();
			
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
			
			this.informacionfinancieraDataAccess.setConnexionType(this.connexionType);
			this.informacionfinancieraDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public InformacionFinanciera getInformacionFinanciera() throws Exception {	
		InformacionFinancieraLogicAdditional.checkInformacionFinancieraToGet(informacionfinanciera,this.datosCliente,this.arrDatoGeneral);
		InformacionFinancieraLogicAdditional.updateInformacionFinancieraToGet(informacionfinanciera,this.arrDatoGeneral);
		
		return informacionfinanciera;
	}
		
	public void setInformacionFinanciera(InformacionFinanciera newInformacionFinanciera) {
		this.informacionfinanciera = newInformacionFinanciera;
	}
	
	public InformacionFinancieraDataAccess getInformacionFinancieraDataAccess() {
		return informacionfinancieraDataAccess;
	}
	
	public void setInformacionFinancieraDataAccess(InformacionFinancieraDataAccess newinformacionfinancieraDataAccess) {
		this.informacionfinancieraDataAccess = newinformacionfinancieraDataAccess;
	}
	
	public List<InformacionFinanciera> getInformacionFinancieras() throws Exception {		
		this.quitarInformacionFinancierasNulos();
		
		InformacionFinancieraLogicAdditional.checkInformacionFinancieraToGets(informacionfinancieras,this.datosCliente,this.arrDatoGeneral);
		
		for (InformacionFinanciera informacionfinancieraLocal: informacionfinancieras ) {
			InformacionFinancieraLogicAdditional.updateInformacionFinancieraToGet(informacionfinancieraLocal,this.arrDatoGeneral);
		}
		
		return informacionfinancieras;
	}
	
	public void setInformacionFinancieras(List<InformacionFinanciera> newInformacionFinancieras) {
		this.informacionfinancieras = newInformacionFinancieras;
	}
	
	public Object getInformacionFinancieraObject() {	
		this.informacionfinancieraObject=this.informacionfinancieraDataAccess.getEntityObject();
		return this.informacionfinancieraObject;
	}
		
	public void setInformacionFinancieraObject(Object newInformacionFinancieraObject) {
		this.informacionfinancieraObject = newInformacionFinancieraObject;
	}
	
	public List<Object> getInformacionFinancierasObject() {		
		this.informacionfinancierasObject=this.informacionfinancieraDataAccess.getEntitiesObject();
		return this.informacionfinancierasObject;
	}
		
	public void setInformacionFinancierasObject(List<Object> newInformacionFinancierasObject) {
		this.informacionfinancierasObject = newInformacionFinancierasObject;
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
		
		if(this.informacionfinancieraDataAccess!=null) {
			this.informacionfinancieraDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,InformacionFinanciera.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			informacionfinancieraDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			informacionfinancieraDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		informacionfinanciera = new  InformacionFinanciera();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,InformacionFinanciera.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			informacionfinanciera=informacionfinancieraDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.informacionfinanciera,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				InformacionFinancieraConstantesFunciones.refrescarForeignKeysDescripcionesInformacionFinanciera(this.informacionfinanciera);
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
		informacionfinanciera = new  InformacionFinanciera();
		  		  
        try {
			
			informacionfinanciera=informacionfinancieraDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.informacionfinanciera,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				InformacionFinancieraConstantesFunciones.refrescarForeignKeysDescripcionesInformacionFinanciera(this.informacionfinanciera);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		informacionfinanciera = new  InformacionFinanciera();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,InformacionFinanciera.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			informacionfinanciera=informacionfinancieraDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.informacionfinanciera,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				InformacionFinancieraConstantesFunciones.refrescarForeignKeysDescripcionesInformacionFinanciera(this.informacionfinanciera);
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
		informacionfinanciera = new  InformacionFinanciera();
		  		  
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
		informacionfinanciera = new  InformacionFinanciera();
		  		  
        try {
			
			informacionfinanciera=informacionfinancieraDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.informacionfinanciera,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				InformacionFinancieraConstantesFunciones.refrescarForeignKeysDescripcionesInformacionFinanciera(this.informacionfinanciera);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		informacionfinanciera = new  InformacionFinanciera();
		  		  
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
		informacionfinanciera = new  InformacionFinanciera();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,InformacionFinanciera.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =informacionfinancieraDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		informacionfinanciera = new  InformacionFinanciera();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=informacionfinancieraDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		informacionfinanciera = new  InformacionFinanciera();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,InformacionFinanciera.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =informacionfinancieraDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		informacionfinanciera = new  InformacionFinanciera();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=informacionfinancieraDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		informacionfinanciera = new  InformacionFinanciera();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,InformacionFinanciera.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =informacionfinancieraDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		informacionfinanciera = new  InformacionFinanciera();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=informacionfinancieraDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		informacionfinancieras = new  ArrayList<InformacionFinanciera>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,InformacionFinanciera.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			InformacionFinancieraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			informacionfinancieras=informacionfinancieraDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarInformacionFinanciera(informacionfinancieras);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				InformacionFinancieraConstantesFunciones.refrescarForeignKeysDescripcionesInformacionFinanciera(this.informacionfinancieras);
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
		informacionfinancieras = new  ArrayList<InformacionFinanciera>();
		  		  
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
		informacionfinancieras = new  ArrayList<InformacionFinanciera>();
		  		  
        try {			
			InformacionFinancieraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			informacionfinancieras=informacionfinancieraDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarInformacionFinanciera(informacionfinancieras);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				InformacionFinancieraConstantesFunciones.refrescarForeignKeysDescripcionesInformacionFinanciera(this.informacionfinancieras);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		informacionfinancieras = new  ArrayList<InformacionFinanciera>();
		  		  
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
		informacionfinancieras = new  ArrayList<InformacionFinanciera>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,InformacionFinanciera.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			InformacionFinancieraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			informacionfinancieras=informacionfinancieraDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarInformacionFinanciera(informacionfinancieras);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				InformacionFinancieraConstantesFunciones.refrescarForeignKeysDescripcionesInformacionFinanciera(this.informacionfinancieras);
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
		informacionfinancieras = new  ArrayList<InformacionFinanciera>();
		  		  
        try {
			InformacionFinancieraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			informacionfinancieras=informacionfinancieraDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarInformacionFinanciera(informacionfinancieras);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				InformacionFinancieraConstantesFunciones.refrescarForeignKeysDescripcionesInformacionFinanciera(this.informacionfinancieras);
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
		informacionfinancieras = new  ArrayList<InformacionFinanciera>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,InformacionFinanciera.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			InformacionFinancieraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			informacionfinancieras=informacionfinancieraDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarInformacionFinanciera(informacionfinancieras);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				InformacionFinancieraConstantesFunciones.refrescarForeignKeysDescripcionesInformacionFinanciera(this.informacionfinancieras);
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
		informacionfinancieras = new  ArrayList<InformacionFinanciera>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			InformacionFinancieraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			informacionfinancieras=informacionfinancieraDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarInformacionFinanciera(informacionfinancieras);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				InformacionFinancieraConstantesFunciones.refrescarForeignKeysDescripcionesInformacionFinanciera(this.informacionfinancieras);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		informacionfinanciera = new  InformacionFinanciera();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,InformacionFinanciera.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			InformacionFinancieraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			informacionfinanciera=informacionfinancieraDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarInformacionFinanciera(informacionfinanciera);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				InformacionFinancieraConstantesFunciones.refrescarForeignKeysDescripcionesInformacionFinanciera(this.informacionfinanciera);
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
		informacionfinanciera = new  InformacionFinanciera();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			InformacionFinancieraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			informacionfinanciera=informacionfinancieraDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarInformacionFinanciera(informacionfinanciera);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				InformacionFinancieraConstantesFunciones.refrescarForeignKeysDescripcionesInformacionFinanciera(this.informacionfinanciera);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		informacionfinancieras = new  ArrayList<InformacionFinanciera>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,InformacionFinanciera.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			InformacionFinancieraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			informacionfinancieras=informacionfinancieraDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarInformacionFinanciera(informacionfinancieras);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				InformacionFinancieraConstantesFunciones.refrescarForeignKeysDescripcionesInformacionFinanciera(this.informacionfinancieras);
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
		informacionfinancieras = new  ArrayList<InformacionFinanciera>();
		  		  
        try {
			InformacionFinancieraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			informacionfinancieras=informacionfinancieraDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarInformacionFinanciera(informacionfinancieras);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				InformacionFinancieraConstantesFunciones.refrescarForeignKeysDescripcionesInformacionFinanciera(this.informacionfinancieras);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosInformacionFinancierasWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		informacionfinancieras = new  ArrayList<InformacionFinanciera>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,InformacionFinanciera.class.getSimpleName()+"-getTodosInformacionFinancierasWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			InformacionFinancieraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			informacionfinancieras=informacionfinancieraDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarInformacionFinanciera(informacionfinancieras);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				InformacionFinancieraConstantesFunciones.refrescarForeignKeysDescripcionesInformacionFinanciera(this.informacionfinancieras);
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
	
	public  void  getTodosInformacionFinancieras(String sFinalQuery,Pagination pagination)throws Exception {
		informacionfinancieras = new  ArrayList<InformacionFinanciera>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			InformacionFinancieraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			informacionfinancieras=informacionfinancieraDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarInformacionFinanciera(informacionfinancieras);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				InformacionFinancieraConstantesFunciones.refrescarForeignKeysDescripcionesInformacionFinanciera(this.informacionfinancieras);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarInformacionFinanciera(InformacionFinanciera informacionfinanciera) throws Exception {
		Boolean estaValidado=false;
		
		if(informacionfinanciera.getIsNew() || informacionfinanciera.getIsChanged()) { 
			this.invalidValues = informacionfinancieraValidator.getInvalidValues(informacionfinanciera);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(informacionfinanciera);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarInformacionFinanciera(List<InformacionFinanciera> InformacionFinancieras) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(InformacionFinanciera informacionfinancieraLocal:informacionfinancieras) {				
			estaValidadoObjeto=this.validarGuardarInformacionFinanciera(informacionfinancieraLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarInformacionFinanciera(List<InformacionFinanciera> InformacionFinancieras) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarInformacionFinanciera(informacionfinancieras)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarInformacionFinanciera(InformacionFinanciera InformacionFinanciera) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarInformacionFinanciera(informacionfinanciera)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(InformacionFinanciera informacionfinanciera) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+informacionfinanciera.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=InformacionFinancieraConstantesFunciones.getInformacionFinancieraLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"informacionfinanciera","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(InformacionFinancieraConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(InformacionFinancieraConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveInformacionFinancieraWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,InformacionFinanciera.class.getSimpleName()+"-saveInformacionFinancieraWithConnection");connexion.begin();			
			
			InformacionFinancieraLogicAdditional.checkInformacionFinancieraToSave(this.informacionfinanciera,this.datosCliente,connexion,this.arrDatoGeneral);
			
			InformacionFinancieraLogicAdditional.updateInformacionFinancieraToSave(this.informacionfinanciera,this.arrDatoGeneral);
			
			InformacionFinancieraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.informacionfinanciera,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowInformacionFinanciera();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarInformacionFinanciera(this.informacionfinanciera)) {
				InformacionFinancieraDataAccess.save(this.informacionfinanciera, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.informacionfinanciera,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			InformacionFinancieraLogicAdditional.checkInformacionFinancieraToSaveAfter(this.informacionfinanciera,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowInformacionFinanciera();
			
			connexion.commit();			
			
			if(this.informacionfinanciera.getIsDeleted()) {
				this.informacionfinanciera=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveInformacionFinanciera()throws Exception {	
		try {	
			
			InformacionFinancieraLogicAdditional.checkInformacionFinancieraToSave(this.informacionfinanciera,this.datosCliente,connexion,this.arrDatoGeneral);
			
			InformacionFinancieraLogicAdditional.updateInformacionFinancieraToSave(this.informacionfinanciera,this.arrDatoGeneral);
			
			InformacionFinancieraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.informacionfinanciera,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarInformacionFinanciera(this.informacionfinanciera)) {			
				InformacionFinancieraDataAccess.save(this.informacionfinanciera, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.informacionfinanciera,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			InformacionFinancieraLogicAdditional.checkInformacionFinancieraToSaveAfter(this.informacionfinanciera,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.informacionfinanciera.getIsDeleted()) {
				this.informacionfinanciera=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveInformacionFinancierasWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,InformacionFinanciera.class.getSimpleName()+"-saveInformacionFinancierasWithConnection");connexion.begin();			
			
			InformacionFinancieraLogicAdditional.checkInformacionFinancieraToSaves(informacionfinancieras,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowInformacionFinancieras();
			
			Boolean validadoTodosInformacionFinanciera=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(InformacionFinanciera informacionfinancieraLocal:informacionfinancieras) {		
				if(informacionfinancieraLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				InformacionFinancieraLogicAdditional.updateInformacionFinancieraToSave(informacionfinancieraLocal,this.arrDatoGeneral);
	        	
				InformacionFinancieraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),informacionfinancieraLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarInformacionFinanciera(informacionfinancieraLocal)) {
					InformacionFinancieraDataAccess.save(informacionfinancieraLocal, connexion);				
				} else {
					validadoTodosInformacionFinanciera=false;
				}
			}
			
			if(!validadoTodosInformacionFinanciera) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			InformacionFinancieraLogicAdditional.checkInformacionFinancieraToSavesAfter(informacionfinancieras,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowInformacionFinancieras();
			
			connexion.commit();		
			
			this.quitarInformacionFinancierasEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveInformacionFinancieras()throws Exception {				
		 try {	
			InformacionFinancieraLogicAdditional.checkInformacionFinancieraToSaves(informacionfinancieras,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosInformacionFinanciera=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(InformacionFinanciera informacionfinancieraLocal:informacionfinancieras) {				
				if(informacionfinancieraLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				InformacionFinancieraLogicAdditional.updateInformacionFinancieraToSave(informacionfinancieraLocal,this.arrDatoGeneral);
	        	
				InformacionFinancieraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),informacionfinancieraLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarInformacionFinanciera(informacionfinancieraLocal)) {				
					InformacionFinancieraDataAccess.save(informacionfinancieraLocal, connexion);				
				} else {
					validadoTodosInformacionFinanciera=false;
				}
			}
			
			if(!validadoTodosInformacionFinanciera) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			InformacionFinancieraLogicAdditional.checkInformacionFinancieraToSavesAfter(informacionfinancieras,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarInformacionFinancierasEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public InformacionFinancieraParameterReturnGeneral procesarAccionInformacionFinancieras(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<InformacionFinanciera> informacionfinancieras,InformacionFinancieraParameterReturnGeneral informacionfinancieraParameterGeneral)throws Exception {
		 try {	
			InformacionFinancieraParameterReturnGeneral informacionfinancieraReturnGeneral=new InformacionFinancieraParameterReturnGeneral();
	
			InformacionFinancieraLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,informacionfinancieras,informacionfinancieraParameterGeneral,informacionfinancieraReturnGeneral);
			
			return informacionfinancieraReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public InformacionFinancieraParameterReturnGeneral procesarAccionInformacionFinancierasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<InformacionFinanciera> informacionfinancieras,InformacionFinancieraParameterReturnGeneral informacionfinancieraParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,InformacionFinanciera.class.getSimpleName()+"-procesarAccionInformacionFinancierasWithConnection");connexion.begin();			
			
			InformacionFinancieraParameterReturnGeneral informacionfinancieraReturnGeneral=new InformacionFinancieraParameterReturnGeneral();
	
			InformacionFinancieraLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,informacionfinancieras,informacionfinancieraParameterGeneral,informacionfinancieraReturnGeneral);
			
			this.connexion.commit();
			
			return informacionfinancieraReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public InformacionFinancieraParameterReturnGeneral procesarEventosInformacionFinancieras(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<InformacionFinanciera> informacionfinancieras,InformacionFinanciera informacionfinanciera,InformacionFinancieraParameterReturnGeneral informacionfinancieraParameterGeneral,Boolean isEsNuevoInformacionFinanciera,ArrayList<Classe> clases)throws Exception {
		 try {	
			InformacionFinancieraParameterReturnGeneral informacionfinancieraReturnGeneral=new InformacionFinancieraParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				informacionfinancieraReturnGeneral.setConRecargarPropiedades(true);
			}
			
			InformacionFinancieraLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,informacionfinancieras,informacionfinanciera,informacionfinancieraParameterGeneral,informacionfinancieraReturnGeneral,isEsNuevoInformacionFinanciera,clases);
			
			return informacionfinancieraReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public InformacionFinancieraParameterReturnGeneral procesarEventosInformacionFinancierasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<InformacionFinanciera> informacionfinancieras,InformacionFinanciera informacionfinanciera,InformacionFinancieraParameterReturnGeneral informacionfinancieraParameterGeneral,Boolean isEsNuevoInformacionFinanciera,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,InformacionFinanciera.class.getSimpleName()+"-procesarEventosInformacionFinancierasWithConnection");connexion.begin();			
			
			InformacionFinancieraParameterReturnGeneral informacionfinancieraReturnGeneral=new InformacionFinancieraParameterReturnGeneral();
	
			informacionfinancieraReturnGeneral.setInformacionFinanciera(informacionfinanciera);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				informacionfinancieraReturnGeneral.setConRecargarPropiedades(true);
			}
			
			InformacionFinancieraLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,informacionfinancieras,informacionfinanciera,informacionfinancieraParameterGeneral,informacionfinancieraReturnGeneral,isEsNuevoInformacionFinanciera,clases);
			
			this.connexion.commit();
			
			return informacionfinancieraReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public InformacionFinancieraParameterReturnGeneral procesarImportacionInformacionFinancierasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,InformacionFinancieraParameterReturnGeneral informacionfinancieraParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,InformacionFinanciera.class.getSimpleName()+"-procesarImportacionInformacionFinancierasWithConnection");connexion.begin();			
			
			InformacionFinancieraParameterReturnGeneral informacionfinancieraReturnGeneral=new InformacionFinancieraParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.informacionfinancieras=new ArrayList<InformacionFinanciera>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.informacionfinanciera=new InformacionFinanciera();
				
				
				if(conColumnasBase) {this.informacionfinanciera.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.informacionfinanciera.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.informacionfinanciera.setvalor(Double.parseDouble(arrColumnas[iColumn++]));
			this.informacionfinanciera.setdescripcion(arrColumnas[iColumn++]);
				this.informacionfinanciera.setesactivo(Boolean.parseBoolean(arrColumnas[iColumn++]));
				
				this.informacionfinancieras.add(this.informacionfinanciera);
			}
			
			this.saveInformacionFinancieras();
			
			this.connexion.commit();
			
			informacionfinancieraReturnGeneral.setConRetornoEstaProcesado(true);
			informacionfinancieraReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return informacionfinancieraReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarInformacionFinancierasEliminados() throws Exception {				
		
		List<InformacionFinanciera> informacionfinancierasAux= new ArrayList<InformacionFinanciera>();
		
		for(InformacionFinanciera informacionfinanciera:informacionfinancieras) {
			if(!informacionfinanciera.getIsDeleted()) {
				informacionfinancierasAux.add(informacionfinanciera);
			}
		}
		
		informacionfinancieras=informacionfinancierasAux;
	}
	
	public void quitarInformacionFinancierasNulos() throws Exception {				
		
		List<InformacionFinanciera> informacionfinancierasAux= new ArrayList<InformacionFinanciera>();
		
		for(InformacionFinanciera informacionfinanciera : this.informacionfinancieras) {
			if(informacionfinanciera==null) {
				informacionfinancierasAux.add(informacionfinanciera);
			}
		}
		
		//this.informacionfinancieras=informacionfinancierasAux;
		
		this.informacionfinancieras.removeAll(informacionfinancierasAux);
	}
	
	public void getSetVersionRowInformacionFinancieraWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(informacionfinanciera.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((informacionfinanciera.getIsDeleted() || (informacionfinanciera.getIsChanged()&&!informacionfinanciera.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=informacionfinancieraDataAccess.getSetVersionRowInformacionFinanciera(connexion,informacionfinanciera.getId());
				
				if(!informacionfinanciera.getVersionRow().equals(timestamp)) {	
					informacionfinanciera.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				informacionfinanciera.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowInformacionFinanciera()throws Exception {	
		
		if(informacionfinanciera.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((informacionfinanciera.getIsDeleted() || (informacionfinanciera.getIsChanged()&&!informacionfinanciera.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=informacionfinancieraDataAccess.getSetVersionRowInformacionFinanciera(connexion,informacionfinanciera.getId());
			
			try {							
				if(!informacionfinanciera.getVersionRow().equals(timestamp)) {	
					informacionfinanciera.setVersionRow(timestamp);
				}
				
				informacionfinanciera.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowInformacionFinancierasWithConnection()throws Exception {	
		if(informacionfinancieras!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(InformacionFinanciera informacionfinancieraAux:informacionfinancieras) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(informacionfinancieraAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(informacionfinancieraAux.getIsDeleted() || (informacionfinancieraAux.getIsChanged()&&!informacionfinancieraAux.getIsNew())) {
						
						timestamp=informacionfinancieraDataAccess.getSetVersionRowInformacionFinanciera(connexion,informacionfinancieraAux.getId());
						
						if(!informacionfinanciera.getVersionRow().equals(timestamp)) {	
							informacionfinancieraAux.setVersionRow(timestamp);
						}
								
						informacionfinancieraAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowInformacionFinancieras()throws Exception {	
		if(informacionfinancieras!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(InformacionFinanciera informacionfinancieraAux:informacionfinancieras) {
					if(informacionfinancieraAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(informacionfinancieraAux.getIsDeleted() || (informacionfinancieraAux.getIsChanged()&&!informacionfinancieraAux.getIsNew())) {
						
						timestamp=informacionfinancieraDataAccess.getSetVersionRowInformacionFinanciera(connexion,informacionfinancieraAux.getId());
						
						if(!informacionfinancieraAux.getVersionRow().equals(timestamp)) {	
							informacionfinancieraAux.setVersionRow(timestamp);
						}
						
													
						informacionfinancieraAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public InformacionFinancieraParameterReturnGeneral cargarCombosLoteForeignKeyInformacionFinancieraWithConnection(String finalQueryGlobalEmpresa,String finalQueryGlobalCliente,String finalQueryGlobalTipoMoviFinan) throws Exception {
		InformacionFinancieraParameterReturnGeneral  informacionfinancieraReturnGeneral =new InformacionFinancieraParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,InformacionFinanciera.class.getSimpleName()+"-cargarCombosLoteForeignKeyInformacionFinancieraWithConnection");connexion.begin();
			
			informacionfinancieraReturnGeneral =new InformacionFinancieraParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			informacionfinancieraReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Cliente> clientesForeignKey=new ArrayList<Cliente>();
			ClienteLogic clienteLogic=new ClienteLogic();
			clienteLogic.setConnexion(this.connexion);
			clienteLogic.getClienteDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCliente.equals("NONE")) {
				clienteLogic.getTodosClientes(finalQueryGlobalCliente,new Pagination());
				clientesForeignKey=clienteLogic.getClientes();
			}

			informacionfinancieraReturnGeneral.setclientesForeignKey(clientesForeignKey);


			List<TipoMoviFinan> tipomovifinansForeignKey=new ArrayList<TipoMoviFinan>();
			TipoMoviFinanLogic tipomovifinanLogic=new TipoMoviFinanLogic();
			tipomovifinanLogic.setConnexion(this.connexion);
			tipomovifinanLogic.getTipoMoviFinanDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoMoviFinan.equals("NONE")) {
				tipomovifinanLogic.getTodosTipoMoviFinans(finalQueryGlobalTipoMoviFinan,new Pagination());
				tipomovifinansForeignKey=tipomovifinanLogic.getTipoMoviFinans();
			}

			informacionfinancieraReturnGeneral.settipomovifinansForeignKey(tipomovifinansForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return informacionfinancieraReturnGeneral;
	}
	
	public InformacionFinancieraParameterReturnGeneral cargarCombosLoteForeignKeyInformacionFinanciera(String finalQueryGlobalEmpresa,String finalQueryGlobalCliente,String finalQueryGlobalTipoMoviFinan) throws Exception {
		InformacionFinancieraParameterReturnGeneral  informacionfinancieraReturnGeneral =new InformacionFinancieraParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			informacionfinancieraReturnGeneral =new InformacionFinancieraParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			informacionfinancieraReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Cliente> clientesForeignKey=new ArrayList<Cliente>();
			ClienteLogic clienteLogic=new ClienteLogic();
			clienteLogic.setConnexion(this.connexion);
			clienteLogic.getClienteDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCliente.equals("NONE")) {
				clienteLogic.getTodosClientes(finalQueryGlobalCliente,new Pagination());
				clientesForeignKey=clienteLogic.getClientes();
			}

			informacionfinancieraReturnGeneral.setclientesForeignKey(clientesForeignKey);


			List<TipoMoviFinan> tipomovifinansForeignKey=new ArrayList<TipoMoviFinan>();
			TipoMoviFinanLogic tipomovifinanLogic=new TipoMoviFinanLogic();
			tipomovifinanLogic.setConnexion(this.connexion);
			tipomovifinanLogic.getTipoMoviFinanDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoMoviFinan.equals("NONE")) {
				tipomovifinanLogic.getTodosTipoMoviFinans(finalQueryGlobalTipoMoviFinan,new Pagination());
				tipomovifinansForeignKey=tipomovifinanLogic.getTipoMoviFinans();
			}

			informacionfinancieraReturnGeneral.settipomovifinansForeignKey(tipomovifinansForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return informacionfinancieraReturnGeneral;
	}
	
	
	public void deepLoad(InformacionFinanciera informacionfinanciera,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			InformacionFinancieraLogicAdditional.updateInformacionFinancieraToGet(informacionfinanciera,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		informacionfinanciera.setEmpresa(informacionfinancieraDataAccess.getEmpresa(connexion,informacionfinanciera));
		informacionfinanciera.setCliente(informacionfinancieraDataAccess.getCliente(connexion,informacionfinanciera));
		informacionfinanciera.setTipoMoviFinan(informacionfinancieraDataAccess.getTipoMoviFinan(connexion,informacionfinanciera));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				informacionfinanciera.setEmpresa(informacionfinancieraDataAccess.getEmpresa(connexion,informacionfinanciera));
				continue;
			}

			if(clas.clas.equals(Cliente.class)) {
				informacionfinanciera.setCliente(informacionfinancieraDataAccess.getCliente(connexion,informacionfinanciera));
				continue;
			}

			if(clas.clas.equals(TipoMoviFinan.class)) {
				informacionfinanciera.setTipoMoviFinan(informacionfinancieraDataAccess.getTipoMoviFinan(connexion,informacionfinanciera));
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
			informacionfinanciera.setEmpresa(informacionfinancieraDataAccess.getEmpresa(connexion,informacionfinanciera));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Cliente.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			informacionfinanciera.setCliente(informacionfinancieraDataAccess.getCliente(connexion,informacionfinanciera));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoMoviFinan.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			informacionfinanciera.setTipoMoviFinan(informacionfinancieraDataAccess.getTipoMoviFinan(connexion,informacionfinanciera));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		informacionfinanciera.setEmpresa(informacionfinancieraDataAccess.getEmpresa(connexion,informacionfinanciera));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(informacionfinanciera.getEmpresa(),isDeep,deepLoadType,clases);
				
		informacionfinanciera.setCliente(informacionfinancieraDataAccess.getCliente(connexion,informacionfinanciera));
		ClienteLogic clienteLogic= new ClienteLogic(connexion);
		clienteLogic.deepLoad(informacionfinanciera.getCliente(),isDeep,deepLoadType,clases);
				
		informacionfinanciera.setTipoMoviFinan(informacionfinancieraDataAccess.getTipoMoviFinan(connexion,informacionfinanciera));
		TipoMoviFinanLogic tipomovifinanLogic= new TipoMoviFinanLogic(connexion);
		tipomovifinanLogic.deepLoad(informacionfinanciera.getTipoMoviFinan(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				informacionfinanciera.setEmpresa(informacionfinancieraDataAccess.getEmpresa(connexion,informacionfinanciera));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(informacionfinanciera.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Cliente.class)) {
				informacionfinanciera.setCliente(informacionfinancieraDataAccess.getCliente(connexion,informacionfinanciera));
				ClienteLogic clienteLogic= new ClienteLogic(connexion);
				clienteLogic.deepLoad(informacionfinanciera.getCliente(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoMoviFinan.class)) {
				informacionfinanciera.setTipoMoviFinan(informacionfinancieraDataAccess.getTipoMoviFinan(connexion,informacionfinanciera));
				TipoMoviFinanLogic tipomovifinanLogic= new TipoMoviFinanLogic(connexion);
				tipomovifinanLogic.deepLoad(informacionfinanciera.getTipoMoviFinan(),isDeep,deepLoadType,clases);				
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
			informacionfinanciera.setEmpresa(informacionfinancieraDataAccess.getEmpresa(connexion,informacionfinanciera));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(informacionfinanciera.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Cliente.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			informacionfinanciera.setCliente(informacionfinancieraDataAccess.getCliente(connexion,informacionfinanciera));
			ClienteLogic clienteLogic= new ClienteLogic(connexion);
			clienteLogic.deepLoad(informacionfinanciera.getCliente(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoMoviFinan.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			informacionfinanciera.setTipoMoviFinan(informacionfinancieraDataAccess.getTipoMoviFinan(connexion,informacionfinanciera));
			TipoMoviFinanLogic tipomovifinanLogic= new TipoMoviFinanLogic(connexion);
			tipomovifinanLogic.deepLoad(informacionfinanciera.getTipoMoviFinan(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(InformacionFinanciera informacionfinanciera,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			InformacionFinancieraLogicAdditional.updateInformacionFinancieraToSave(informacionfinanciera,this.arrDatoGeneral);
			
InformacionFinancieraDataAccess.save(informacionfinanciera, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(informacionfinanciera.getEmpresa(),connexion);

		ClienteDataAccess.save(informacionfinanciera.getCliente(),connexion);

		TipoMoviFinanDataAccess.save(informacionfinanciera.getTipoMoviFinan(),connexion);
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(informacionfinanciera.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(Cliente.class)) {
				ClienteDataAccess.save(informacionfinanciera.getCliente(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoMoviFinan.class)) {
				TipoMoviFinanDataAccess.save(informacionfinanciera.getTipoMoviFinan(),connexion);
				continue;
			}

		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(informacionfinanciera.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(informacionfinanciera.getEmpresa(),isDeep,deepLoadType,clases);
				

		ClienteDataAccess.save(informacionfinanciera.getCliente(),connexion);
		ClienteLogic clienteLogic= new ClienteLogic(connexion);
		clienteLogic.deepLoad(informacionfinanciera.getCliente(),isDeep,deepLoadType,clases);
				

		TipoMoviFinanDataAccess.save(informacionfinanciera.getTipoMoviFinan(),connexion);
		TipoMoviFinanLogic tipomovifinanLogic= new TipoMoviFinanLogic(connexion);
		tipomovifinanLogic.deepLoad(informacionfinanciera.getTipoMoviFinan(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(informacionfinanciera.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(informacionfinanciera.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Cliente.class)) {
				ClienteDataAccess.save(informacionfinanciera.getCliente(),connexion);
				ClienteLogic clienteLogic= new ClienteLogic(connexion);
				clienteLogic.deepSave(informacionfinanciera.getCliente(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoMoviFinan.class)) {
				TipoMoviFinanDataAccess.save(informacionfinanciera.getTipoMoviFinan(),connexion);
				TipoMoviFinanLogic tipomovifinanLogic= new TipoMoviFinanLogic(connexion);
				tipomovifinanLogic.deepSave(informacionfinanciera.getTipoMoviFinan(),isDeep,deepLoadType,clases);				
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
			this.getNewConnexionToDeep(InformacionFinanciera.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(informacionfinanciera,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				InformacionFinancieraConstantesFunciones.refrescarForeignKeysDescripcionesInformacionFinanciera(informacionfinanciera);
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
			this.deepLoad(this.informacionfinanciera,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				InformacionFinancieraConstantesFunciones.refrescarForeignKeysDescripcionesInformacionFinanciera(this.informacionfinanciera);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(InformacionFinanciera.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(informacionfinancieras!=null) {
				for(InformacionFinanciera informacionfinanciera:informacionfinancieras) {
					this.deepLoad(informacionfinanciera,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					InformacionFinancieraConstantesFunciones.refrescarForeignKeysDescripcionesInformacionFinanciera(informacionfinancieras);
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
			if(informacionfinancieras!=null) {
				for(InformacionFinanciera informacionfinanciera:informacionfinancieras) {
					this.deepLoad(informacionfinanciera,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					InformacionFinancieraConstantesFunciones.refrescarForeignKeysDescripcionesInformacionFinanciera(informacionfinancieras);
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
			this.getNewConnexionToDeep(InformacionFinanciera.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(informacionfinanciera,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(InformacionFinanciera.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(informacionfinancieras!=null) {
				for(InformacionFinanciera informacionfinanciera:informacionfinancieras) {
					this.deepSave(informacionfinanciera,isDeep,deepLoadType,clases);
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
			if(informacionfinancieras!=null) {
				for(InformacionFinanciera informacionfinanciera:informacionfinancieras) {
					this.deepSave(informacionfinanciera,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getInformacionFinancierasFK_IdClienteWithConnection(String sFinalQuery,Pagination pagination,Long idcliente)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,InformacionFinanciera.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCliente= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCliente.setParameterSelectionGeneralEqual(ParameterType.LONG,idcliente,InformacionFinancieraConstantesFunciones.IDCLIENTE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCliente);

			InformacionFinancieraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCliente","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			informacionfinancieras=informacionfinancieraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				InformacionFinancieraConstantesFunciones.refrescarForeignKeysDescripcionesInformacionFinanciera(this.informacionfinancieras);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getInformacionFinancierasFK_IdCliente(String sFinalQuery,Pagination pagination,Long idcliente)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCliente= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCliente.setParameterSelectionGeneralEqual(ParameterType.LONG,idcliente,InformacionFinancieraConstantesFunciones.IDCLIENTE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCliente);

			InformacionFinancieraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCliente","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			informacionfinancieras=informacionfinancieraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				InformacionFinancieraConstantesFunciones.refrescarForeignKeysDescripcionesInformacionFinanciera(this.informacionfinancieras);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getInformacionFinancierasFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,InformacionFinanciera.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,InformacionFinancieraConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			InformacionFinancieraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			informacionfinancieras=informacionfinancieraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				InformacionFinancieraConstantesFunciones.refrescarForeignKeysDescripcionesInformacionFinanciera(this.informacionfinancieras);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getInformacionFinancierasFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,InformacionFinancieraConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			InformacionFinancieraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			informacionfinancieras=informacionfinancieraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				InformacionFinancieraConstantesFunciones.refrescarForeignKeysDescripcionesInformacionFinanciera(this.informacionfinancieras);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getInformacionFinancierasFK_IdValorClienteMovimientoWithConnection(String sFinalQuery,Pagination pagination,Long idvalorclientemovimiento)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,InformacionFinanciera.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoMoviFinan= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoMoviFinan.setParameterSelectionGeneralEqual(ParameterType.LONG,idvalorclientemovimiento,InformacionFinancieraConstantesFunciones.IDTIPOMOVIFINAN,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoMoviFinan);

			InformacionFinancieraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdValorClienteMovimiento","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			informacionfinancieras=informacionfinancieraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				InformacionFinancieraConstantesFunciones.refrescarForeignKeysDescripcionesInformacionFinanciera(this.informacionfinancieras);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getInformacionFinancierasFK_IdValorClienteMovimiento(String sFinalQuery,Pagination pagination,Long idvalorclientemovimiento)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoMoviFinan= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoMoviFinan.setParameterSelectionGeneralEqual(ParameterType.LONG,idvalorclientemovimiento,InformacionFinancieraConstantesFunciones.IDTIPOMOVIFINAN,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoMoviFinan);

			InformacionFinancieraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdValorClienteMovimiento","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			informacionfinancieras=informacionfinancieraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				InformacionFinancieraConstantesFunciones.refrescarForeignKeysDescripcionesInformacionFinanciera(this.informacionfinancieras);
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
			if(InformacionFinancieraConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,InformacionFinancieraDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,InformacionFinanciera informacionfinanciera,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(InformacionFinancieraConstantesFunciones.ISCONAUDITORIA) {
				if(informacionfinanciera.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,InformacionFinancieraDataAccess.TABLENAME, informacionfinanciera.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(InformacionFinancieraConstantesFunciones.ISCONAUDITORIADETALLE) {
						////InformacionFinancieraLogic.registrarAuditoriaDetallesInformacionFinanciera(connexion,informacionfinanciera,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(informacionfinanciera.getIsDeleted()) {
					/*if(!informacionfinanciera.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,InformacionFinancieraDataAccess.TABLENAME, informacionfinanciera.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////InformacionFinancieraLogic.registrarAuditoriaDetallesInformacionFinanciera(connexion,informacionfinanciera,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,InformacionFinancieraDataAccess.TABLENAME, informacionfinanciera.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(informacionfinanciera.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,InformacionFinancieraDataAccess.TABLENAME, informacionfinanciera.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(InformacionFinancieraConstantesFunciones.ISCONAUDITORIADETALLE) {
						////InformacionFinancieraLogic.registrarAuditoriaDetallesInformacionFinanciera(connexion,informacionfinanciera,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesInformacionFinanciera(Connexion connexion,InformacionFinanciera informacionfinanciera)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(informacionfinanciera.getIsNew()||!informacionfinanciera.getid_empresa().equals(informacionfinanciera.getInformacionFinancieraOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(informacionfinanciera.getInformacionFinancieraOriginal().getid_empresa()!=null)
				{
					strValorActual=informacionfinanciera.getInformacionFinancieraOriginal().getid_empresa().toString();
				}
				if(informacionfinanciera.getid_empresa()!=null)
				{
					strValorNuevo=informacionfinanciera.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),InformacionFinancieraConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(informacionfinanciera.getIsNew()||!informacionfinanciera.getidcliente().equals(informacionfinanciera.getInformacionFinancieraOriginal().getidcliente()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(informacionfinanciera.getInformacionFinancieraOriginal().getidcliente()!=null)
				{
					strValorActual=informacionfinanciera.getInformacionFinancieraOriginal().getidcliente().toString();
				}
				if(informacionfinanciera.getidcliente()!=null)
				{
					strValorNuevo=informacionfinanciera.getidcliente().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),InformacionFinancieraConstantesFunciones.IDCLIENTE,strValorActual,strValorNuevo);
			}	
			
			if(informacionfinanciera.getIsNew()||!informacionfinanciera.getidvalorclientemovimiento().equals(informacionfinanciera.getInformacionFinancieraOriginal().getidvalorclientemovimiento()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(informacionfinanciera.getInformacionFinancieraOriginal().getidvalorclientemovimiento()!=null)
				{
					strValorActual=informacionfinanciera.getInformacionFinancieraOriginal().getidvalorclientemovimiento().toString();
				}
				if(informacionfinanciera.getidvalorclientemovimiento()!=null)
				{
					strValorNuevo=informacionfinanciera.getidvalorclientemovimiento().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),InformacionFinancieraConstantesFunciones.IDTIPOMOVIFINAN,strValorActual,strValorNuevo);
			}	
			
			if(informacionfinanciera.getIsNew()||!informacionfinanciera.getvalor().equals(informacionfinanciera.getInformacionFinancieraOriginal().getvalor()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(informacionfinanciera.getInformacionFinancieraOriginal().getvalor()!=null)
				{
					strValorActual=informacionfinanciera.getInformacionFinancieraOriginal().getvalor().toString();
				}
				if(informacionfinanciera.getvalor()!=null)
				{
					strValorNuevo=informacionfinanciera.getvalor().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),InformacionFinancieraConstantesFunciones.VALOR,strValorActual,strValorNuevo);
			}	
			
			if(informacionfinanciera.getIsNew()||!informacionfinanciera.getdescripcion().equals(informacionfinanciera.getInformacionFinancieraOriginal().getdescripcion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(informacionfinanciera.getInformacionFinancieraOriginal().getdescripcion()!=null)
				{
					strValorActual=informacionfinanciera.getInformacionFinancieraOriginal().getdescripcion();
				}
				if(informacionfinanciera.getdescripcion()!=null)
				{
					strValorNuevo=informacionfinanciera.getdescripcion() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),InformacionFinancieraConstantesFunciones.DESCRIPCION,strValorActual,strValorNuevo);
			}	
			
			if(informacionfinanciera.getIsNew()||!informacionfinanciera.getesactivo().equals(informacionfinanciera.getInformacionFinancieraOriginal().getesactivo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(informacionfinanciera.getInformacionFinancieraOriginal().getesactivo()!=null)
				{
					strValorActual=informacionfinanciera.getInformacionFinancieraOriginal().getesactivo().toString();
				}
				if(informacionfinanciera.getesactivo()!=null)
				{
					strValorNuevo=informacionfinanciera.getesactivo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),InformacionFinancieraConstantesFunciones.ESACTIVO,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveInformacionFinancieraRelacionesWithConnection(InformacionFinanciera informacionfinanciera) throws Exception {

		if(!informacionfinanciera.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveInformacionFinancieraRelacionesBase(informacionfinanciera,true);
		}
	}

	public void saveInformacionFinancieraRelaciones(InformacionFinanciera informacionfinanciera)throws Exception {

		if(!informacionfinanciera.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveInformacionFinancieraRelacionesBase(informacionfinanciera,false);
		}
	}

	public void saveInformacionFinancieraRelacionesBase(InformacionFinanciera informacionfinanciera,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("InformacionFinanciera-saveRelacionesWithConnection");}
	

			this.setInformacionFinanciera(informacionfinanciera);

			if(InformacionFinancieraLogicAdditional.validarSaveRelaciones(informacionfinanciera,this)) {

				InformacionFinancieraLogicAdditional.updateRelacionesToSave(informacionfinanciera,this);

				if((informacionfinanciera.getIsNew()||informacionfinanciera.getIsChanged())&&!informacionfinanciera.getIsDeleted()) {
					this.saveInformacionFinanciera();
					this.saveInformacionFinancieraRelacionesDetalles();

				} else if(informacionfinanciera.getIsDeleted()) {
					this.saveInformacionFinancieraRelacionesDetalles();
					this.saveInformacionFinanciera();
				}

				InformacionFinancieraLogicAdditional.updateRelacionesToSaveAfter(informacionfinanciera,this);

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
	
	
	private void saveInformacionFinancieraRelacionesDetalles()throws Exception {
		try {
	

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfInformacionFinanciera(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=InformacionFinancieraConstantesFunciones.getClassesForeignKeysOfInformacionFinanciera(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfInformacionFinanciera(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=InformacionFinancieraConstantesFunciones.getClassesRelationshipsOfInformacionFinanciera(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

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
import com.bydan.erp.cartera.util.ReferenciaBancariaConstantesFunciones;
import com.bydan.erp.cartera.util.ReferenciaBancariaParameterReturnGeneral;
//import com.bydan.erp.cartera.util.ReferenciaBancariaParameterGeneral;
import com.bydan.erp.cartera.business.entity.ReferenciaBancaria;
import com.bydan.erp.cartera.business.logic.ReferenciaBancariaLogicAdditional;
import com.bydan.erp.cartera.business.dataaccess.*;
import com.bydan.erp.cartera.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;
import com.bydan.erp.tesoreria.business.logic.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.tesoreria.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.tesoreria.business.dataaccess.*;








@SuppressWarnings("unused")
public class ReferenciaBancariaLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(ReferenciaBancariaLogic.class);
	
	protected ReferenciaBancariaDataAccess referenciabancariaDataAccess; 	
	protected ReferenciaBancaria referenciabancaria;
	protected List<ReferenciaBancaria> referenciabancarias;
	protected Object referenciabancariaObject;	
	protected List<Object> referenciabancariasObject;
	
	public static ClassValidator<ReferenciaBancaria> referenciabancariaValidator = new ClassValidator<ReferenciaBancaria>(ReferenciaBancaria.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected ReferenciaBancariaLogicAdditional referenciabancariaLogicAdditional=null;
	
	public ReferenciaBancariaLogicAdditional getReferenciaBancariaLogicAdditional() {
		return this.referenciabancariaLogicAdditional;
	}
	
	public void setReferenciaBancariaLogicAdditional(ReferenciaBancariaLogicAdditional referenciabancariaLogicAdditional) {
		try {
			this.referenciabancariaLogicAdditional=referenciabancariaLogicAdditional;
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
	
	
	
	
	public  ReferenciaBancariaLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.referenciabancariaDataAccess = new ReferenciaBancariaDataAccess();
			
			this.referenciabancarias= new ArrayList<ReferenciaBancaria>();
			this.referenciabancaria= new ReferenciaBancaria();
			
			this.referenciabancariaObject=new Object();
			this.referenciabancariasObject=new ArrayList<Object>();
				
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
			
			this.referenciabancariaDataAccess.setConnexionType(this.connexionType);
			this.referenciabancariaDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  ReferenciaBancariaLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.referenciabancariaDataAccess = new ReferenciaBancariaDataAccess();
			this.referenciabancarias= new ArrayList<ReferenciaBancaria>();
			this.referenciabancaria= new ReferenciaBancaria();
			this.referenciabancariaObject=new Object();
			this.referenciabancariasObject=new ArrayList<Object>();
			
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
			
			this.referenciabancariaDataAccess.setConnexionType(this.connexionType);
			this.referenciabancariaDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public ReferenciaBancaria getReferenciaBancaria() throws Exception {	
		ReferenciaBancariaLogicAdditional.checkReferenciaBancariaToGet(referenciabancaria,this.datosCliente,this.arrDatoGeneral);
		ReferenciaBancariaLogicAdditional.updateReferenciaBancariaToGet(referenciabancaria,this.arrDatoGeneral);
		
		return referenciabancaria;
	}
		
	public void setReferenciaBancaria(ReferenciaBancaria newReferenciaBancaria) {
		this.referenciabancaria = newReferenciaBancaria;
	}
	
	public ReferenciaBancariaDataAccess getReferenciaBancariaDataAccess() {
		return referenciabancariaDataAccess;
	}
	
	public void setReferenciaBancariaDataAccess(ReferenciaBancariaDataAccess newreferenciabancariaDataAccess) {
		this.referenciabancariaDataAccess = newreferenciabancariaDataAccess;
	}
	
	public List<ReferenciaBancaria> getReferenciaBancarias() throws Exception {		
		this.quitarReferenciaBancariasNulos();
		
		ReferenciaBancariaLogicAdditional.checkReferenciaBancariaToGets(referenciabancarias,this.datosCliente,this.arrDatoGeneral);
		
		for (ReferenciaBancaria referenciabancariaLocal: referenciabancarias ) {
			ReferenciaBancariaLogicAdditional.updateReferenciaBancariaToGet(referenciabancariaLocal,this.arrDatoGeneral);
		}
		
		return referenciabancarias;
	}
	
	public void setReferenciaBancarias(List<ReferenciaBancaria> newReferenciaBancarias) {
		this.referenciabancarias = newReferenciaBancarias;
	}
	
	public Object getReferenciaBancariaObject() {	
		this.referenciabancariaObject=this.referenciabancariaDataAccess.getEntityObject();
		return this.referenciabancariaObject;
	}
		
	public void setReferenciaBancariaObject(Object newReferenciaBancariaObject) {
		this.referenciabancariaObject = newReferenciaBancariaObject;
	}
	
	public List<Object> getReferenciaBancariasObject() {		
		this.referenciabancariasObject=this.referenciabancariaDataAccess.getEntitiesObject();
		return this.referenciabancariasObject;
	}
		
	public void setReferenciaBancariasObject(List<Object> newReferenciaBancariasObject) {
		this.referenciabancariasObject = newReferenciaBancariasObject;
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
		
		if(this.referenciabancariaDataAccess!=null) {
			this.referenciabancariaDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ReferenciaBancaria.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			referenciabancariaDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			referenciabancariaDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		referenciabancaria = new  ReferenciaBancaria();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ReferenciaBancaria.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			referenciabancaria=referenciabancariaDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.referenciabancaria,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ReferenciaBancariaConstantesFunciones.refrescarForeignKeysDescripcionesReferenciaBancaria(this.referenciabancaria);
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
		referenciabancaria = new  ReferenciaBancaria();
		  		  
        try {
			
			referenciabancaria=referenciabancariaDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.referenciabancaria,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ReferenciaBancariaConstantesFunciones.refrescarForeignKeysDescripcionesReferenciaBancaria(this.referenciabancaria);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		referenciabancaria = new  ReferenciaBancaria();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ReferenciaBancaria.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			referenciabancaria=referenciabancariaDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.referenciabancaria,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ReferenciaBancariaConstantesFunciones.refrescarForeignKeysDescripcionesReferenciaBancaria(this.referenciabancaria);
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
		referenciabancaria = new  ReferenciaBancaria();
		  		  
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
		referenciabancaria = new  ReferenciaBancaria();
		  		  
        try {
			
			referenciabancaria=referenciabancariaDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.referenciabancaria,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ReferenciaBancariaConstantesFunciones.refrescarForeignKeysDescripcionesReferenciaBancaria(this.referenciabancaria);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		referenciabancaria = new  ReferenciaBancaria();
		  		  
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
		referenciabancaria = new  ReferenciaBancaria();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ReferenciaBancaria.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =referenciabancariaDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		referenciabancaria = new  ReferenciaBancaria();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=referenciabancariaDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		referenciabancaria = new  ReferenciaBancaria();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ReferenciaBancaria.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =referenciabancariaDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		referenciabancaria = new  ReferenciaBancaria();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=referenciabancariaDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		referenciabancaria = new  ReferenciaBancaria();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ReferenciaBancaria.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =referenciabancariaDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		referenciabancaria = new  ReferenciaBancaria();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=referenciabancariaDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		referenciabancarias = new  ArrayList<ReferenciaBancaria>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ReferenciaBancaria.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			ReferenciaBancariaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			referenciabancarias=referenciabancariaDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarReferenciaBancaria(referenciabancarias);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ReferenciaBancariaConstantesFunciones.refrescarForeignKeysDescripcionesReferenciaBancaria(this.referenciabancarias);
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
		referenciabancarias = new  ArrayList<ReferenciaBancaria>();
		  		  
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
		referenciabancarias = new  ArrayList<ReferenciaBancaria>();
		  		  
        try {			
			ReferenciaBancariaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			referenciabancarias=referenciabancariaDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarReferenciaBancaria(referenciabancarias);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ReferenciaBancariaConstantesFunciones.refrescarForeignKeysDescripcionesReferenciaBancaria(this.referenciabancarias);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		referenciabancarias = new  ArrayList<ReferenciaBancaria>();
		  		  
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
		referenciabancarias = new  ArrayList<ReferenciaBancaria>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ReferenciaBancaria.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			ReferenciaBancariaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			referenciabancarias=referenciabancariaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarReferenciaBancaria(referenciabancarias);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ReferenciaBancariaConstantesFunciones.refrescarForeignKeysDescripcionesReferenciaBancaria(this.referenciabancarias);
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
		referenciabancarias = new  ArrayList<ReferenciaBancaria>();
		  		  
        try {
			ReferenciaBancariaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			referenciabancarias=referenciabancariaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarReferenciaBancaria(referenciabancarias);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ReferenciaBancariaConstantesFunciones.refrescarForeignKeysDescripcionesReferenciaBancaria(this.referenciabancarias);
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
		referenciabancarias = new  ArrayList<ReferenciaBancaria>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ReferenciaBancaria.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ReferenciaBancariaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			referenciabancarias=referenciabancariaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarReferenciaBancaria(referenciabancarias);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ReferenciaBancariaConstantesFunciones.refrescarForeignKeysDescripcionesReferenciaBancaria(this.referenciabancarias);
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
		referenciabancarias = new  ArrayList<ReferenciaBancaria>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ReferenciaBancariaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			referenciabancarias=referenciabancariaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarReferenciaBancaria(referenciabancarias);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ReferenciaBancariaConstantesFunciones.refrescarForeignKeysDescripcionesReferenciaBancaria(this.referenciabancarias);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		referenciabancaria = new  ReferenciaBancaria();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ReferenciaBancaria.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ReferenciaBancariaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			referenciabancaria=referenciabancariaDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarReferenciaBancaria(referenciabancaria);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ReferenciaBancariaConstantesFunciones.refrescarForeignKeysDescripcionesReferenciaBancaria(this.referenciabancaria);
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
		referenciabancaria = new  ReferenciaBancaria();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ReferenciaBancariaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			referenciabancaria=referenciabancariaDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarReferenciaBancaria(referenciabancaria);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ReferenciaBancariaConstantesFunciones.refrescarForeignKeysDescripcionesReferenciaBancaria(this.referenciabancaria);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		referenciabancarias = new  ArrayList<ReferenciaBancaria>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ReferenciaBancaria.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			ReferenciaBancariaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			referenciabancarias=referenciabancariaDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarReferenciaBancaria(referenciabancarias);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ReferenciaBancariaConstantesFunciones.refrescarForeignKeysDescripcionesReferenciaBancaria(this.referenciabancarias);
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
		referenciabancarias = new  ArrayList<ReferenciaBancaria>();
		  		  
        try {
			ReferenciaBancariaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			referenciabancarias=referenciabancariaDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarReferenciaBancaria(referenciabancarias);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ReferenciaBancariaConstantesFunciones.refrescarForeignKeysDescripcionesReferenciaBancaria(this.referenciabancarias);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosReferenciaBancariasWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		referenciabancarias = new  ArrayList<ReferenciaBancaria>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ReferenciaBancaria.class.getSimpleName()+"-getTodosReferenciaBancariasWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ReferenciaBancariaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			referenciabancarias=referenciabancariaDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarReferenciaBancaria(referenciabancarias);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ReferenciaBancariaConstantesFunciones.refrescarForeignKeysDescripcionesReferenciaBancaria(this.referenciabancarias);
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
	
	public  void  getTodosReferenciaBancarias(String sFinalQuery,Pagination pagination)throws Exception {
		referenciabancarias = new  ArrayList<ReferenciaBancaria>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ReferenciaBancariaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			referenciabancarias=referenciabancariaDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarReferenciaBancaria(referenciabancarias);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ReferenciaBancariaConstantesFunciones.refrescarForeignKeysDescripcionesReferenciaBancaria(this.referenciabancarias);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarReferenciaBancaria(ReferenciaBancaria referenciabancaria) throws Exception {
		Boolean estaValidado=false;
		
		if(referenciabancaria.getIsNew() || referenciabancaria.getIsChanged()) { 
			this.invalidValues = referenciabancariaValidator.getInvalidValues(referenciabancaria);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(referenciabancaria);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarReferenciaBancaria(List<ReferenciaBancaria> ReferenciaBancarias) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(ReferenciaBancaria referenciabancariaLocal:referenciabancarias) {				
			estaValidadoObjeto=this.validarGuardarReferenciaBancaria(referenciabancariaLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarReferenciaBancaria(List<ReferenciaBancaria> ReferenciaBancarias) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarReferenciaBancaria(referenciabancarias)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarReferenciaBancaria(ReferenciaBancaria ReferenciaBancaria) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarReferenciaBancaria(referenciabancaria)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(ReferenciaBancaria referenciabancaria) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+referenciabancaria.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=ReferenciaBancariaConstantesFunciones.getReferenciaBancariaLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"referenciabancaria","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(ReferenciaBancariaConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(ReferenciaBancariaConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveReferenciaBancariaWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ReferenciaBancaria.class.getSimpleName()+"-saveReferenciaBancariaWithConnection");connexion.begin();			
			
			ReferenciaBancariaLogicAdditional.checkReferenciaBancariaToSave(this.referenciabancaria,this.datosCliente,connexion,this.arrDatoGeneral);
			
			ReferenciaBancariaLogicAdditional.updateReferenciaBancariaToSave(this.referenciabancaria,this.arrDatoGeneral);
			
			ReferenciaBancariaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.referenciabancaria,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowReferenciaBancaria();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarReferenciaBancaria(this.referenciabancaria)) {
				ReferenciaBancariaDataAccess.save(this.referenciabancaria, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.referenciabancaria,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			ReferenciaBancariaLogicAdditional.checkReferenciaBancariaToSaveAfter(this.referenciabancaria,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowReferenciaBancaria();
			
			connexion.commit();			
			
			if(this.referenciabancaria.getIsDeleted()) {
				this.referenciabancaria=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveReferenciaBancaria()throws Exception {	
		try {	
			
			ReferenciaBancariaLogicAdditional.checkReferenciaBancariaToSave(this.referenciabancaria,this.datosCliente,connexion,this.arrDatoGeneral);
			
			ReferenciaBancariaLogicAdditional.updateReferenciaBancariaToSave(this.referenciabancaria,this.arrDatoGeneral);
			
			ReferenciaBancariaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.referenciabancaria,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarReferenciaBancaria(this.referenciabancaria)) {			
				ReferenciaBancariaDataAccess.save(this.referenciabancaria, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.referenciabancaria,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			ReferenciaBancariaLogicAdditional.checkReferenciaBancariaToSaveAfter(this.referenciabancaria,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.referenciabancaria.getIsDeleted()) {
				this.referenciabancaria=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveReferenciaBancariasWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ReferenciaBancaria.class.getSimpleName()+"-saveReferenciaBancariasWithConnection");connexion.begin();			
			
			ReferenciaBancariaLogicAdditional.checkReferenciaBancariaToSaves(referenciabancarias,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowReferenciaBancarias();
			
			Boolean validadoTodosReferenciaBancaria=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(ReferenciaBancaria referenciabancariaLocal:referenciabancarias) {		
				if(referenciabancariaLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				ReferenciaBancariaLogicAdditional.updateReferenciaBancariaToSave(referenciabancariaLocal,this.arrDatoGeneral);
	        	
				ReferenciaBancariaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),referenciabancariaLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarReferenciaBancaria(referenciabancariaLocal)) {
					ReferenciaBancariaDataAccess.save(referenciabancariaLocal, connexion);				
				} else {
					validadoTodosReferenciaBancaria=false;
				}
			}
			
			if(!validadoTodosReferenciaBancaria) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			ReferenciaBancariaLogicAdditional.checkReferenciaBancariaToSavesAfter(referenciabancarias,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowReferenciaBancarias();
			
			connexion.commit();		
			
			this.quitarReferenciaBancariasEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveReferenciaBancarias()throws Exception {				
		 try {	
			ReferenciaBancariaLogicAdditional.checkReferenciaBancariaToSaves(referenciabancarias,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosReferenciaBancaria=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(ReferenciaBancaria referenciabancariaLocal:referenciabancarias) {				
				if(referenciabancariaLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				ReferenciaBancariaLogicAdditional.updateReferenciaBancariaToSave(referenciabancariaLocal,this.arrDatoGeneral);
	        	
				ReferenciaBancariaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),referenciabancariaLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarReferenciaBancaria(referenciabancariaLocal)) {				
					ReferenciaBancariaDataAccess.save(referenciabancariaLocal, connexion);				
				} else {
					validadoTodosReferenciaBancaria=false;
				}
			}
			
			if(!validadoTodosReferenciaBancaria) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			ReferenciaBancariaLogicAdditional.checkReferenciaBancariaToSavesAfter(referenciabancarias,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarReferenciaBancariasEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public ReferenciaBancariaParameterReturnGeneral procesarAccionReferenciaBancarias(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<ReferenciaBancaria> referenciabancarias,ReferenciaBancariaParameterReturnGeneral referenciabancariaParameterGeneral)throws Exception {
		 try {	
			ReferenciaBancariaParameterReturnGeneral referenciabancariaReturnGeneral=new ReferenciaBancariaParameterReturnGeneral();
	
			ReferenciaBancariaLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,referenciabancarias,referenciabancariaParameterGeneral,referenciabancariaReturnGeneral);
			
			return referenciabancariaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public ReferenciaBancariaParameterReturnGeneral procesarAccionReferenciaBancariasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<ReferenciaBancaria> referenciabancarias,ReferenciaBancariaParameterReturnGeneral referenciabancariaParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ReferenciaBancaria.class.getSimpleName()+"-procesarAccionReferenciaBancariasWithConnection");connexion.begin();			
			
			ReferenciaBancariaParameterReturnGeneral referenciabancariaReturnGeneral=new ReferenciaBancariaParameterReturnGeneral();
	
			ReferenciaBancariaLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,referenciabancarias,referenciabancariaParameterGeneral,referenciabancariaReturnGeneral);
			
			this.connexion.commit();
			
			return referenciabancariaReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public ReferenciaBancariaParameterReturnGeneral procesarEventosReferenciaBancarias(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<ReferenciaBancaria> referenciabancarias,ReferenciaBancaria referenciabancaria,ReferenciaBancariaParameterReturnGeneral referenciabancariaParameterGeneral,Boolean isEsNuevoReferenciaBancaria,ArrayList<Classe> clases)throws Exception {
		 try {	
			ReferenciaBancariaParameterReturnGeneral referenciabancariaReturnGeneral=new ReferenciaBancariaParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				referenciabancariaReturnGeneral.setConRecargarPropiedades(true);
			}
			
			ReferenciaBancariaLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,referenciabancarias,referenciabancaria,referenciabancariaParameterGeneral,referenciabancariaReturnGeneral,isEsNuevoReferenciaBancaria,clases);
			
			return referenciabancariaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public ReferenciaBancariaParameterReturnGeneral procesarEventosReferenciaBancariasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<ReferenciaBancaria> referenciabancarias,ReferenciaBancaria referenciabancaria,ReferenciaBancariaParameterReturnGeneral referenciabancariaParameterGeneral,Boolean isEsNuevoReferenciaBancaria,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ReferenciaBancaria.class.getSimpleName()+"-procesarEventosReferenciaBancariasWithConnection");connexion.begin();			
			
			ReferenciaBancariaParameterReturnGeneral referenciabancariaReturnGeneral=new ReferenciaBancariaParameterReturnGeneral();
	
			referenciabancariaReturnGeneral.setReferenciaBancaria(referenciabancaria);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				referenciabancariaReturnGeneral.setConRecargarPropiedades(true);
			}
			
			ReferenciaBancariaLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,referenciabancarias,referenciabancaria,referenciabancariaParameterGeneral,referenciabancariaReturnGeneral,isEsNuevoReferenciaBancaria,clases);
			
			this.connexion.commit();
			
			return referenciabancariaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public ReferenciaBancariaParameterReturnGeneral procesarImportacionReferenciaBancariasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,ReferenciaBancariaParameterReturnGeneral referenciabancariaParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ReferenciaBancaria.class.getSimpleName()+"-procesarImportacionReferenciaBancariasWithConnection");connexion.begin();			
			
			ReferenciaBancariaParameterReturnGeneral referenciabancariaReturnGeneral=new ReferenciaBancariaParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.referenciabancarias=new ArrayList<ReferenciaBancaria>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.referenciabancaria=new ReferenciaBancaria();
				
				
				if(conColumnasBase) {this.referenciabancaria.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.referenciabancaria.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.referenciabancaria.setnumero_cuenta_tarjeta(arrColumnas[iColumn++]);
				this.referenciabancaria.setfecha_emision(Funciones.ConvertToDate(arrColumnas[iColumn++]));
				this.referenciabancaria.setfecha_vencimiento(Funciones.ConvertToDate(arrColumnas[iColumn++]));
				this.referenciabancaria.setcupo(Double.parseDouble(arrColumnas[iColumn++]));
				this.referenciabancaria.settiene_credito(Boolean.parseBoolean(arrColumnas[iColumn++]));
				this.referenciabancaria.setnumero_creditos(Integer.parseInt(arrColumnas[iColumn++]));
				this.referenciabancaria.settiene_protestos(Boolean.parseBoolean(arrColumnas[iColumn++]));
				this.referenciabancaria.setnumero_protestos(Integer.parseInt(arrColumnas[iColumn++]));
				this.referenciabancaria.setsaldos_promedios(arrColumnas[iColumn++]);
				this.referenciabancaria.setpropietario_cuenta(arrColumnas[iColumn++]);
				this.referenciabancaria.setesactivo(Boolean.parseBoolean(arrColumnas[iColumn++]));
				
				this.referenciabancarias.add(this.referenciabancaria);
			}
			
			this.saveReferenciaBancarias();
			
			this.connexion.commit();
			
			referenciabancariaReturnGeneral.setConRetornoEstaProcesado(true);
			referenciabancariaReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return referenciabancariaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarReferenciaBancariasEliminados() throws Exception {				
		
		List<ReferenciaBancaria> referenciabancariasAux= new ArrayList<ReferenciaBancaria>();
		
		for(ReferenciaBancaria referenciabancaria:referenciabancarias) {
			if(!referenciabancaria.getIsDeleted()) {
				referenciabancariasAux.add(referenciabancaria);
			}
		}
		
		referenciabancarias=referenciabancariasAux;
	}
	
	public void quitarReferenciaBancariasNulos() throws Exception {				
		
		List<ReferenciaBancaria> referenciabancariasAux= new ArrayList<ReferenciaBancaria>();
		
		for(ReferenciaBancaria referenciabancaria : this.referenciabancarias) {
			if(referenciabancaria==null) {
				referenciabancariasAux.add(referenciabancaria);
			}
		}
		
		//this.referenciabancarias=referenciabancariasAux;
		
		this.referenciabancarias.removeAll(referenciabancariasAux);
	}
	
	public void getSetVersionRowReferenciaBancariaWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(referenciabancaria.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((referenciabancaria.getIsDeleted() || (referenciabancaria.getIsChanged()&&!referenciabancaria.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=referenciabancariaDataAccess.getSetVersionRowReferenciaBancaria(connexion,referenciabancaria.getId());
				
				if(!referenciabancaria.getVersionRow().equals(timestamp)) {	
					referenciabancaria.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				referenciabancaria.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowReferenciaBancaria()throws Exception {	
		
		if(referenciabancaria.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((referenciabancaria.getIsDeleted() || (referenciabancaria.getIsChanged()&&!referenciabancaria.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=referenciabancariaDataAccess.getSetVersionRowReferenciaBancaria(connexion,referenciabancaria.getId());
			
			try {							
				if(!referenciabancaria.getVersionRow().equals(timestamp)) {	
					referenciabancaria.setVersionRow(timestamp);
				}
				
				referenciabancaria.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowReferenciaBancariasWithConnection()throws Exception {	
		if(referenciabancarias!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(ReferenciaBancaria referenciabancariaAux:referenciabancarias) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(referenciabancariaAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(referenciabancariaAux.getIsDeleted() || (referenciabancariaAux.getIsChanged()&&!referenciabancariaAux.getIsNew())) {
						
						timestamp=referenciabancariaDataAccess.getSetVersionRowReferenciaBancaria(connexion,referenciabancariaAux.getId());
						
						if(!referenciabancaria.getVersionRow().equals(timestamp)) {	
							referenciabancariaAux.setVersionRow(timestamp);
						}
								
						referenciabancariaAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowReferenciaBancarias()throws Exception {	
		if(referenciabancarias!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(ReferenciaBancaria referenciabancariaAux:referenciabancarias) {
					if(referenciabancariaAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(referenciabancariaAux.getIsDeleted() || (referenciabancariaAux.getIsChanged()&&!referenciabancariaAux.getIsNew())) {
						
						timestamp=referenciabancariaDataAccess.getSetVersionRowReferenciaBancaria(connexion,referenciabancariaAux.getId());
						
						if(!referenciabancariaAux.getVersionRow().equals(timestamp)) {	
							referenciabancariaAux.setVersionRow(timestamp);
						}
						
													
						referenciabancariaAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public ReferenciaBancariaParameterReturnGeneral cargarCombosLoteForeignKeyReferenciaBancariaWithConnection(String finalQueryGlobalEmpresa,String finalQueryGlobalCliente,String finalQueryGlobalBanco,String finalQueryGlobalTipoProduBanco,String finalQueryGlobalTipoCuentaBanco,String finalQueryGlobalTipoValoracion) throws Exception {
		ReferenciaBancariaParameterReturnGeneral  referenciabancariaReturnGeneral =new ReferenciaBancariaParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ReferenciaBancaria.class.getSimpleName()+"-cargarCombosLoteForeignKeyReferenciaBancariaWithConnection");connexion.begin();
			
			referenciabancariaReturnGeneral =new ReferenciaBancariaParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			referenciabancariaReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Cliente> clientesForeignKey=new ArrayList<Cliente>();
			ClienteLogic clienteLogic=new ClienteLogic();
			clienteLogic.setConnexion(this.connexion);
			clienteLogic.getClienteDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCliente.equals("NONE")) {
				clienteLogic.getTodosClientes(finalQueryGlobalCliente,new Pagination());
				clientesForeignKey=clienteLogic.getClientes();
			}

			referenciabancariaReturnGeneral.setclientesForeignKey(clientesForeignKey);


			List<Banco> bancosForeignKey=new ArrayList<Banco>();
			BancoLogic bancoLogic=new BancoLogic();
			bancoLogic.setConnexion(this.connexion);
			bancoLogic.getBancoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalBanco.equals("NONE")) {
				bancoLogic.getTodosBancos(finalQueryGlobalBanco,new Pagination());
				bancosForeignKey=bancoLogic.getBancos();
			}

			referenciabancariaReturnGeneral.setbancosForeignKey(bancosForeignKey);


			List<TipoProduBanco> tipoprodubancosForeignKey=new ArrayList<TipoProduBanco>();
			TipoProduBancoLogic tipoprodubancoLogic=new TipoProduBancoLogic();
			tipoprodubancoLogic.setConnexion(this.connexion);
			tipoprodubancoLogic.getTipoProduBancoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoProduBanco.equals("NONE")) {
				tipoprodubancoLogic.getTodosTipoProduBancos(finalQueryGlobalTipoProduBanco,new Pagination());
				tipoprodubancosForeignKey=tipoprodubancoLogic.getTipoProduBancos();
			}

			referenciabancariaReturnGeneral.settipoprodubancosForeignKey(tipoprodubancosForeignKey);


			List<TipoCuentaBanco> tipocuentabancosForeignKey=new ArrayList<TipoCuentaBanco>();
			TipoCuentaBancoLogic tipocuentabancoLogic=new TipoCuentaBancoLogic();
			tipocuentabancoLogic.setConnexion(this.connexion);
			tipocuentabancoLogic.getTipoCuentaBancoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoCuentaBanco.equals("NONE")) {
				tipocuentabancoLogic.getTodosTipoCuentaBancos(finalQueryGlobalTipoCuentaBanco,new Pagination());
				tipocuentabancosForeignKey=tipocuentabancoLogic.getTipoCuentaBancos();
			}

			referenciabancariaReturnGeneral.settipocuentabancosForeignKey(tipocuentabancosForeignKey);


			List<TipoValoracion> tipovaloracionsForeignKey=new ArrayList<TipoValoracion>();
			TipoValoracionLogic tipovaloracionLogic=new TipoValoracionLogic();
			tipovaloracionLogic.setConnexion(this.connexion);
			tipovaloracionLogic.getTipoValoracionDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoValoracion.equals("NONE")) {
				tipovaloracionLogic.getTodosTipoValoracions(finalQueryGlobalTipoValoracion,new Pagination());
				tipovaloracionsForeignKey=tipovaloracionLogic.getTipoValoracions();
			}

			referenciabancariaReturnGeneral.settipovaloracionsForeignKey(tipovaloracionsForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return referenciabancariaReturnGeneral;
	}
	
	public ReferenciaBancariaParameterReturnGeneral cargarCombosLoteForeignKeyReferenciaBancaria(String finalQueryGlobalEmpresa,String finalQueryGlobalCliente,String finalQueryGlobalBanco,String finalQueryGlobalTipoProduBanco,String finalQueryGlobalTipoCuentaBanco,String finalQueryGlobalTipoValoracion) throws Exception {
		ReferenciaBancariaParameterReturnGeneral  referenciabancariaReturnGeneral =new ReferenciaBancariaParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			referenciabancariaReturnGeneral =new ReferenciaBancariaParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			referenciabancariaReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Cliente> clientesForeignKey=new ArrayList<Cliente>();
			ClienteLogic clienteLogic=new ClienteLogic();
			clienteLogic.setConnexion(this.connexion);
			clienteLogic.getClienteDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCliente.equals("NONE")) {
				clienteLogic.getTodosClientes(finalQueryGlobalCliente,new Pagination());
				clientesForeignKey=clienteLogic.getClientes();
			}

			referenciabancariaReturnGeneral.setclientesForeignKey(clientesForeignKey);


			List<Banco> bancosForeignKey=new ArrayList<Banco>();
			BancoLogic bancoLogic=new BancoLogic();
			bancoLogic.setConnexion(this.connexion);
			bancoLogic.getBancoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalBanco.equals("NONE")) {
				bancoLogic.getTodosBancos(finalQueryGlobalBanco,new Pagination());
				bancosForeignKey=bancoLogic.getBancos();
			}

			referenciabancariaReturnGeneral.setbancosForeignKey(bancosForeignKey);


			List<TipoProduBanco> tipoprodubancosForeignKey=new ArrayList<TipoProduBanco>();
			TipoProduBancoLogic tipoprodubancoLogic=new TipoProduBancoLogic();
			tipoprodubancoLogic.setConnexion(this.connexion);
			tipoprodubancoLogic.getTipoProduBancoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoProduBanco.equals("NONE")) {
				tipoprodubancoLogic.getTodosTipoProduBancos(finalQueryGlobalTipoProduBanco,new Pagination());
				tipoprodubancosForeignKey=tipoprodubancoLogic.getTipoProduBancos();
			}

			referenciabancariaReturnGeneral.settipoprodubancosForeignKey(tipoprodubancosForeignKey);


			List<TipoCuentaBanco> tipocuentabancosForeignKey=new ArrayList<TipoCuentaBanco>();
			TipoCuentaBancoLogic tipocuentabancoLogic=new TipoCuentaBancoLogic();
			tipocuentabancoLogic.setConnexion(this.connexion);
			tipocuentabancoLogic.getTipoCuentaBancoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoCuentaBanco.equals("NONE")) {
				tipocuentabancoLogic.getTodosTipoCuentaBancos(finalQueryGlobalTipoCuentaBanco,new Pagination());
				tipocuentabancosForeignKey=tipocuentabancoLogic.getTipoCuentaBancos();
			}

			referenciabancariaReturnGeneral.settipocuentabancosForeignKey(tipocuentabancosForeignKey);


			List<TipoValoracion> tipovaloracionsForeignKey=new ArrayList<TipoValoracion>();
			TipoValoracionLogic tipovaloracionLogic=new TipoValoracionLogic();
			tipovaloracionLogic.setConnexion(this.connexion);
			tipovaloracionLogic.getTipoValoracionDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoValoracion.equals("NONE")) {
				tipovaloracionLogic.getTodosTipoValoracions(finalQueryGlobalTipoValoracion,new Pagination());
				tipovaloracionsForeignKey=tipovaloracionLogic.getTipoValoracions();
			}

			referenciabancariaReturnGeneral.settipovaloracionsForeignKey(tipovaloracionsForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return referenciabancariaReturnGeneral;
	}
	
	
	public void deepLoad(ReferenciaBancaria referenciabancaria,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			ReferenciaBancariaLogicAdditional.updateReferenciaBancariaToGet(referenciabancaria,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		referenciabancaria.setEmpresa(referenciabancariaDataAccess.getEmpresa(connexion,referenciabancaria));
		referenciabancaria.setCliente(referenciabancariaDataAccess.getCliente(connexion,referenciabancaria));
		referenciabancaria.setBanco(referenciabancariaDataAccess.getBanco(connexion,referenciabancaria));
		referenciabancaria.setTipoProduBanco(referenciabancariaDataAccess.getTipoProduBanco(connexion,referenciabancaria));
		referenciabancaria.setTipoCuentaBanco(referenciabancariaDataAccess.getTipoCuentaBanco(connexion,referenciabancaria));
		referenciabancaria.setTipoValoracion(referenciabancariaDataAccess.getTipoValoracion(connexion,referenciabancaria));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				referenciabancaria.setEmpresa(referenciabancariaDataAccess.getEmpresa(connexion,referenciabancaria));
				continue;
			}

			if(clas.clas.equals(Cliente.class)) {
				referenciabancaria.setCliente(referenciabancariaDataAccess.getCliente(connexion,referenciabancaria));
				continue;
			}

			if(clas.clas.equals(Banco.class)) {
				referenciabancaria.setBanco(referenciabancariaDataAccess.getBanco(connexion,referenciabancaria));
				continue;
			}

			if(clas.clas.equals(TipoProduBanco.class)) {
				referenciabancaria.setTipoProduBanco(referenciabancariaDataAccess.getTipoProduBanco(connexion,referenciabancaria));
				continue;
			}

			if(clas.clas.equals(TipoCuentaBanco.class)) {
				referenciabancaria.setTipoCuentaBanco(referenciabancariaDataAccess.getTipoCuentaBanco(connexion,referenciabancaria));
				continue;
			}

			if(clas.clas.equals(TipoValoracion.class)) {
				referenciabancaria.setTipoValoracion(referenciabancariaDataAccess.getTipoValoracion(connexion,referenciabancaria));
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
			referenciabancaria.setEmpresa(referenciabancariaDataAccess.getEmpresa(connexion,referenciabancaria));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Cliente.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			referenciabancaria.setCliente(referenciabancariaDataAccess.getCliente(connexion,referenciabancaria));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Banco.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			referenciabancaria.setBanco(referenciabancariaDataAccess.getBanco(connexion,referenciabancaria));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoProduBanco.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			referenciabancaria.setTipoProduBanco(referenciabancariaDataAccess.getTipoProduBanco(connexion,referenciabancaria));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoCuentaBanco.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			referenciabancaria.setTipoCuentaBanco(referenciabancariaDataAccess.getTipoCuentaBanco(connexion,referenciabancaria));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoValoracion.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			referenciabancaria.setTipoValoracion(referenciabancariaDataAccess.getTipoValoracion(connexion,referenciabancaria));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		referenciabancaria.setEmpresa(referenciabancariaDataAccess.getEmpresa(connexion,referenciabancaria));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(referenciabancaria.getEmpresa(),isDeep,deepLoadType,clases);
				
		referenciabancaria.setCliente(referenciabancariaDataAccess.getCliente(connexion,referenciabancaria));
		ClienteLogic clienteLogic= new ClienteLogic(connexion);
		clienteLogic.deepLoad(referenciabancaria.getCliente(),isDeep,deepLoadType,clases);
				
		referenciabancaria.setBanco(referenciabancariaDataAccess.getBanco(connexion,referenciabancaria));
		BancoLogic bancoLogic= new BancoLogic(connexion);
		bancoLogic.deepLoad(referenciabancaria.getBanco(),isDeep,deepLoadType,clases);
				
		referenciabancaria.setTipoProduBanco(referenciabancariaDataAccess.getTipoProduBanco(connexion,referenciabancaria));
		TipoProduBancoLogic tipoprodubancoLogic= new TipoProduBancoLogic(connexion);
		tipoprodubancoLogic.deepLoad(referenciabancaria.getTipoProduBanco(),isDeep,deepLoadType,clases);
				
		referenciabancaria.setTipoCuentaBanco(referenciabancariaDataAccess.getTipoCuentaBanco(connexion,referenciabancaria));
		TipoCuentaBancoLogic tipocuentabancoLogic= new TipoCuentaBancoLogic(connexion);
		tipocuentabancoLogic.deepLoad(referenciabancaria.getTipoCuentaBanco(),isDeep,deepLoadType,clases);
				
		referenciabancaria.setTipoValoracion(referenciabancariaDataAccess.getTipoValoracion(connexion,referenciabancaria));
		TipoValoracionLogic tipovaloracionLogic= new TipoValoracionLogic(connexion);
		tipovaloracionLogic.deepLoad(referenciabancaria.getTipoValoracion(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				referenciabancaria.setEmpresa(referenciabancariaDataAccess.getEmpresa(connexion,referenciabancaria));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(referenciabancaria.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Cliente.class)) {
				referenciabancaria.setCliente(referenciabancariaDataAccess.getCliente(connexion,referenciabancaria));
				ClienteLogic clienteLogic= new ClienteLogic(connexion);
				clienteLogic.deepLoad(referenciabancaria.getCliente(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Banco.class)) {
				referenciabancaria.setBanco(referenciabancariaDataAccess.getBanco(connexion,referenciabancaria));
				BancoLogic bancoLogic= new BancoLogic(connexion);
				bancoLogic.deepLoad(referenciabancaria.getBanco(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoProduBanco.class)) {
				referenciabancaria.setTipoProduBanco(referenciabancariaDataAccess.getTipoProduBanco(connexion,referenciabancaria));
				TipoProduBancoLogic tipoprodubancoLogic= new TipoProduBancoLogic(connexion);
				tipoprodubancoLogic.deepLoad(referenciabancaria.getTipoProduBanco(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoCuentaBanco.class)) {
				referenciabancaria.setTipoCuentaBanco(referenciabancariaDataAccess.getTipoCuentaBanco(connexion,referenciabancaria));
				TipoCuentaBancoLogic tipocuentabancoLogic= new TipoCuentaBancoLogic(connexion);
				tipocuentabancoLogic.deepLoad(referenciabancaria.getTipoCuentaBanco(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoValoracion.class)) {
				referenciabancaria.setTipoValoracion(referenciabancariaDataAccess.getTipoValoracion(connexion,referenciabancaria));
				TipoValoracionLogic tipovaloracionLogic= new TipoValoracionLogic(connexion);
				tipovaloracionLogic.deepLoad(referenciabancaria.getTipoValoracion(),isDeep,deepLoadType,clases);				
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
			referenciabancaria.setEmpresa(referenciabancariaDataAccess.getEmpresa(connexion,referenciabancaria));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(referenciabancaria.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Cliente.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			referenciabancaria.setCliente(referenciabancariaDataAccess.getCliente(connexion,referenciabancaria));
			ClienteLogic clienteLogic= new ClienteLogic(connexion);
			clienteLogic.deepLoad(referenciabancaria.getCliente(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Banco.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			referenciabancaria.setBanco(referenciabancariaDataAccess.getBanco(connexion,referenciabancaria));
			BancoLogic bancoLogic= new BancoLogic(connexion);
			bancoLogic.deepLoad(referenciabancaria.getBanco(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoProduBanco.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			referenciabancaria.setTipoProduBanco(referenciabancariaDataAccess.getTipoProduBanco(connexion,referenciabancaria));
			TipoProduBancoLogic tipoprodubancoLogic= new TipoProduBancoLogic(connexion);
			tipoprodubancoLogic.deepLoad(referenciabancaria.getTipoProduBanco(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoCuentaBanco.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			referenciabancaria.setTipoCuentaBanco(referenciabancariaDataAccess.getTipoCuentaBanco(connexion,referenciabancaria));
			TipoCuentaBancoLogic tipocuentabancoLogic= new TipoCuentaBancoLogic(connexion);
			tipocuentabancoLogic.deepLoad(referenciabancaria.getTipoCuentaBanco(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoValoracion.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			referenciabancaria.setTipoValoracion(referenciabancariaDataAccess.getTipoValoracion(connexion,referenciabancaria));
			TipoValoracionLogic tipovaloracionLogic= new TipoValoracionLogic(connexion);
			tipovaloracionLogic.deepLoad(referenciabancaria.getTipoValoracion(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(ReferenciaBancaria referenciabancaria,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			ReferenciaBancariaLogicAdditional.updateReferenciaBancariaToSave(referenciabancaria,this.arrDatoGeneral);
			
ReferenciaBancariaDataAccess.save(referenciabancaria, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(referenciabancaria.getEmpresa(),connexion);

		ClienteDataAccess.save(referenciabancaria.getCliente(),connexion);

		BancoDataAccess.save(referenciabancaria.getBanco(),connexion);

		TipoProduBancoDataAccess.save(referenciabancaria.getTipoProduBanco(),connexion);

		TipoCuentaBancoDataAccess.save(referenciabancaria.getTipoCuentaBanco(),connexion);

		TipoValoracionDataAccess.save(referenciabancaria.getTipoValoracion(),connexion);
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(referenciabancaria.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(Cliente.class)) {
				ClienteDataAccess.save(referenciabancaria.getCliente(),connexion);
				continue;
			}

			if(clas.clas.equals(Banco.class)) {
				BancoDataAccess.save(referenciabancaria.getBanco(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoProduBanco.class)) {
				TipoProduBancoDataAccess.save(referenciabancaria.getTipoProduBanco(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoCuentaBanco.class)) {
				TipoCuentaBancoDataAccess.save(referenciabancaria.getTipoCuentaBanco(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoValoracion.class)) {
				TipoValoracionDataAccess.save(referenciabancaria.getTipoValoracion(),connexion);
				continue;
			}

		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(referenciabancaria.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(referenciabancaria.getEmpresa(),isDeep,deepLoadType,clases);
				

		ClienteDataAccess.save(referenciabancaria.getCliente(),connexion);
		ClienteLogic clienteLogic= new ClienteLogic(connexion);
		clienteLogic.deepLoad(referenciabancaria.getCliente(),isDeep,deepLoadType,clases);
				

		BancoDataAccess.save(referenciabancaria.getBanco(),connexion);
		BancoLogic bancoLogic= new BancoLogic(connexion);
		bancoLogic.deepLoad(referenciabancaria.getBanco(),isDeep,deepLoadType,clases);
				

		TipoProduBancoDataAccess.save(referenciabancaria.getTipoProduBanco(),connexion);
		TipoProduBancoLogic tipoprodubancoLogic= new TipoProduBancoLogic(connexion);
		tipoprodubancoLogic.deepLoad(referenciabancaria.getTipoProduBanco(),isDeep,deepLoadType,clases);
				

		TipoCuentaBancoDataAccess.save(referenciabancaria.getTipoCuentaBanco(),connexion);
		TipoCuentaBancoLogic tipocuentabancoLogic= new TipoCuentaBancoLogic(connexion);
		tipocuentabancoLogic.deepLoad(referenciabancaria.getTipoCuentaBanco(),isDeep,deepLoadType,clases);
				

		TipoValoracionDataAccess.save(referenciabancaria.getTipoValoracion(),connexion);
		TipoValoracionLogic tipovaloracionLogic= new TipoValoracionLogic(connexion);
		tipovaloracionLogic.deepLoad(referenciabancaria.getTipoValoracion(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(referenciabancaria.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(referenciabancaria.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Cliente.class)) {
				ClienteDataAccess.save(referenciabancaria.getCliente(),connexion);
				ClienteLogic clienteLogic= new ClienteLogic(connexion);
				clienteLogic.deepSave(referenciabancaria.getCliente(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Banco.class)) {
				BancoDataAccess.save(referenciabancaria.getBanco(),connexion);
				BancoLogic bancoLogic= new BancoLogic(connexion);
				bancoLogic.deepSave(referenciabancaria.getBanco(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoProduBanco.class)) {
				TipoProduBancoDataAccess.save(referenciabancaria.getTipoProduBanco(),connexion);
				TipoProduBancoLogic tipoprodubancoLogic= new TipoProduBancoLogic(connexion);
				tipoprodubancoLogic.deepSave(referenciabancaria.getTipoProduBanco(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoCuentaBanco.class)) {
				TipoCuentaBancoDataAccess.save(referenciabancaria.getTipoCuentaBanco(),connexion);
				TipoCuentaBancoLogic tipocuentabancoLogic= new TipoCuentaBancoLogic(connexion);
				tipocuentabancoLogic.deepSave(referenciabancaria.getTipoCuentaBanco(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoValoracion.class)) {
				TipoValoracionDataAccess.save(referenciabancaria.getTipoValoracion(),connexion);
				TipoValoracionLogic tipovaloracionLogic= new TipoValoracionLogic(connexion);
				tipovaloracionLogic.deepSave(referenciabancaria.getTipoValoracion(),isDeep,deepLoadType,clases);				
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
			this.getNewConnexionToDeep(ReferenciaBancaria.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(referenciabancaria,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				ReferenciaBancariaConstantesFunciones.refrescarForeignKeysDescripcionesReferenciaBancaria(referenciabancaria);
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
			this.deepLoad(this.referenciabancaria,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				ReferenciaBancariaConstantesFunciones.refrescarForeignKeysDescripcionesReferenciaBancaria(this.referenciabancaria);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(ReferenciaBancaria.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(referenciabancarias!=null) {
				for(ReferenciaBancaria referenciabancaria:referenciabancarias) {
					this.deepLoad(referenciabancaria,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					ReferenciaBancariaConstantesFunciones.refrescarForeignKeysDescripcionesReferenciaBancaria(referenciabancarias);
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
			if(referenciabancarias!=null) {
				for(ReferenciaBancaria referenciabancaria:referenciabancarias) {
					this.deepLoad(referenciabancaria,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					ReferenciaBancariaConstantesFunciones.refrescarForeignKeysDescripcionesReferenciaBancaria(referenciabancarias);
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
			this.getNewConnexionToDeep(ReferenciaBancaria.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(referenciabancaria,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(ReferenciaBancaria.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(referenciabancarias!=null) {
				for(ReferenciaBancaria referenciabancaria:referenciabancarias) {
					this.deepSave(referenciabancaria,isDeep,deepLoadType,clases);
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
			if(referenciabancarias!=null) {
				for(ReferenciaBancaria referenciabancaria:referenciabancarias) {
					this.deepSave(referenciabancaria,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getReferenciaBancariasFK_IdClienteWithConnection(String sFinalQuery,Pagination pagination,Long idcliente)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ReferenciaBancaria.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCliente= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCliente.setParameterSelectionGeneralEqual(ParameterType.LONG,idcliente,ReferenciaBancariaConstantesFunciones.IDCLIENTE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCliente);

			ReferenciaBancariaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCliente","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			referenciabancarias=referenciabancariaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ReferenciaBancariaConstantesFunciones.refrescarForeignKeysDescripcionesReferenciaBancaria(this.referenciabancarias);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getReferenciaBancariasFK_IdCliente(String sFinalQuery,Pagination pagination,Long idcliente)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCliente= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCliente.setParameterSelectionGeneralEqual(ParameterType.LONG,idcliente,ReferenciaBancariaConstantesFunciones.IDCLIENTE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCliente);

			ReferenciaBancariaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCliente","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			referenciabancarias=referenciabancariaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ReferenciaBancariaConstantesFunciones.refrescarForeignKeysDescripcionesReferenciaBancaria(this.referenciabancarias);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getReferenciaBancariasFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ReferenciaBancaria.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,ReferenciaBancariaConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			ReferenciaBancariaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			referenciabancarias=referenciabancariaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ReferenciaBancariaConstantesFunciones.refrescarForeignKeysDescripcionesReferenciaBancaria(this.referenciabancarias);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getReferenciaBancariasFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,ReferenciaBancariaConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			ReferenciaBancariaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			referenciabancarias=referenciabancariaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ReferenciaBancariaConstantesFunciones.refrescarForeignKeysDescripcionesReferenciaBancaria(this.referenciabancarias);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getReferenciaBancariasFK_IdTipoBancoWithConnection(String sFinalQuery,Pagination pagination,Long idvalorclientebanco)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ReferenciaBancaria.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidBanco= new ParameterSelectionGeneral();
			parameterSelectionGeneralidBanco.setParameterSelectionGeneralEqual(ParameterType.LONG,idvalorclientebanco,ReferenciaBancariaConstantesFunciones.IDBANCO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidBanco);

			ReferenciaBancariaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoBanco","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			referenciabancarias=referenciabancariaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ReferenciaBancariaConstantesFunciones.refrescarForeignKeysDescripcionesReferenciaBancaria(this.referenciabancarias);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getReferenciaBancariasFK_IdTipoBanco(String sFinalQuery,Pagination pagination,Long idvalorclientebanco)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidBanco= new ParameterSelectionGeneral();
			parameterSelectionGeneralidBanco.setParameterSelectionGeneralEqual(ParameterType.LONG,idvalorclientebanco,ReferenciaBancariaConstantesFunciones.IDBANCO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidBanco);

			ReferenciaBancariaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoBanco","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			referenciabancarias=referenciabancariaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ReferenciaBancariaConstantesFunciones.refrescarForeignKeysDescripcionesReferenciaBancaria(this.referenciabancarias);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getReferenciaBancariasFK_IdTipoCuentaBancoWithConnection(String sFinalQuery,Pagination pagination,Long idvalorclientecuentabanco)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ReferenciaBancaria.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoCuentaBanco= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoCuentaBanco.setParameterSelectionGeneralEqual(ParameterType.LONG,idvalorclientecuentabanco,ReferenciaBancariaConstantesFunciones.IDTIPOCUENTABANCO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoCuentaBanco);

			ReferenciaBancariaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoCuentaBanco","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			referenciabancarias=referenciabancariaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ReferenciaBancariaConstantesFunciones.refrescarForeignKeysDescripcionesReferenciaBancaria(this.referenciabancarias);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getReferenciaBancariasFK_IdTipoCuentaBanco(String sFinalQuery,Pagination pagination,Long idvalorclientecuentabanco)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoCuentaBanco= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoCuentaBanco.setParameterSelectionGeneralEqual(ParameterType.LONG,idvalorclientecuentabanco,ReferenciaBancariaConstantesFunciones.IDTIPOCUENTABANCO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoCuentaBanco);

			ReferenciaBancariaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoCuentaBanco","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			referenciabancarias=referenciabancariaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ReferenciaBancariaConstantesFunciones.refrescarForeignKeysDescripcionesReferenciaBancaria(this.referenciabancarias);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getReferenciaBancariasFK_IdTipoProductoBancoWithConnection(String sFinalQuery,Pagination pagination,Long idvalorclienteproductobanco)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ReferenciaBancaria.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoProduBanco= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoProduBanco.setParameterSelectionGeneralEqual(ParameterType.LONG,idvalorclienteproductobanco,ReferenciaBancariaConstantesFunciones.IDTIPOPRODUBANCO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoProduBanco);

			ReferenciaBancariaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoProductoBanco","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			referenciabancarias=referenciabancariaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ReferenciaBancariaConstantesFunciones.refrescarForeignKeysDescripcionesReferenciaBancaria(this.referenciabancarias);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getReferenciaBancariasFK_IdTipoProductoBanco(String sFinalQuery,Pagination pagination,Long idvalorclienteproductobanco)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoProduBanco= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoProduBanco.setParameterSelectionGeneralEqual(ParameterType.LONG,idvalorclienteproductobanco,ReferenciaBancariaConstantesFunciones.IDTIPOPRODUBANCO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoProduBanco);

			ReferenciaBancariaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoProductoBanco","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			referenciabancarias=referenciabancariaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ReferenciaBancariaConstantesFunciones.refrescarForeignKeysDescripcionesReferenciaBancaria(this.referenciabancarias);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getReferenciaBancariasFK_IdTipoValoracionWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_valoracion)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ReferenciaBancaria.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoValoracion= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoValoracion.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_valoracion,ReferenciaBancariaConstantesFunciones.IDTIPOVALORACION,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoValoracion);

			ReferenciaBancariaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoValoracion","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			referenciabancarias=referenciabancariaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ReferenciaBancariaConstantesFunciones.refrescarForeignKeysDescripcionesReferenciaBancaria(this.referenciabancarias);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getReferenciaBancariasFK_IdTipoValoracion(String sFinalQuery,Pagination pagination,Long id_tipo_valoracion)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoValoracion= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoValoracion.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_valoracion,ReferenciaBancariaConstantesFunciones.IDTIPOVALORACION,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoValoracion);

			ReferenciaBancariaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoValoracion","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			referenciabancarias=referenciabancariaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ReferenciaBancariaConstantesFunciones.refrescarForeignKeysDescripcionesReferenciaBancaria(this.referenciabancarias);
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
			if(ReferenciaBancariaConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,ReferenciaBancariaDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,ReferenciaBancaria referenciabancaria,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(ReferenciaBancariaConstantesFunciones.ISCONAUDITORIA) {
				if(referenciabancaria.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,ReferenciaBancariaDataAccess.TABLENAME, referenciabancaria.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(ReferenciaBancariaConstantesFunciones.ISCONAUDITORIADETALLE) {
						////ReferenciaBancariaLogic.registrarAuditoriaDetallesReferenciaBancaria(connexion,referenciabancaria,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(referenciabancaria.getIsDeleted()) {
					/*if(!referenciabancaria.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,ReferenciaBancariaDataAccess.TABLENAME, referenciabancaria.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////ReferenciaBancariaLogic.registrarAuditoriaDetallesReferenciaBancaria(connexion,referenciabancaria,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,ReferenciaBancariaDataAccess.TABLENAME, referenciabancaria.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(referenciabancaria.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,ReferenciaBancariaDataAccess.TABLENAME, referenciabancaria.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(ReferenciaBancariaConstantesFunciones.ISCONAUDITORIADETALLE) {
						////ReferenciaBancariaLogic.registrarAuditoriaDetallesReferenciaBancaria(connexion,referenciabancaria,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesReferenciaBancaria(Connexion connexion,ReferenciaBancaria referenciabancaria)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(referenciabancaria.getIsNew()||!referenciabancaria.getid_empresa().equals(referenciabancaria.getReferenciaBancariaOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(referenciabancaria.getReferenciaBancariaOriginal().getid_empresa()!=null)
				{
					strValorActual=referenciabancaria.getReferenciaBancariaOriginal().getid_empresa().toString();
				}
				if(referenciabancaria.getid_empresa()!=null)
				{
					strValorNuevo=referenciabancaria.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ReferenciaBancariaConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(referenciabancaria.getIsNew()||!referenciabancaria.getidcliente().equals(referenciabancaria.getReferenciaBancariaOriginal().getidcliente()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(referenciabancaria.getReferenciaBancariaOriginal().getidcliente()!=null)
				{
					strValorActual=referenciabancaria.getReferenciaBancariaOriginal().getidcliente().toString();
				}
				if(referenciabancaria.getidcliente()!=null)
				{
					strValorNuevo=referenciabancaria.getidcliente().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ReferenciaBancariaConstantesFunciones.IDCLIENTE,strValorActual,strValorNuevo);
			}	
			
			if(referenciabancaria.getIsNew()||!referenciabancaria.getidvalorclientebanco().equals(referenciabancaria.getReferenciaBancariaOriginal().getidvalorclientebanco()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(referenciabancaria.getReferenciaBancariaOriginal().getidvalorclientebanco()!=null)
				{
					strValorActual=referenciabancaria.getReferenciaBancariaOriginal().getidvalorclientebanco().toString();
				}
				if(referenciabancaria.getidvalorclientebanco()!=null)
				{
					strValorNuevo=referenciabancaria.getidvalorclientebanco().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ReferenciaBancariaConstantesFunciones.IDBANCO,strValorActual,strValorNuevo);
			}	
			
			if(referenciabancaria.getIsNew()||!referenciabancaria.getidvalorclienteproductobanco().equals(referenciabancaria.getReferenciaBancariaOriginal().getidvalorclienteproductobanco()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(referenciabancaria.getReferenciaBancariaOriginal().getidvalorclienteproductobanco()!=null)
				{
					strValorActual=referenciabancaria.getReferenciaBancariaOriginal().getidvalorclienteproductobanco().toString();
				}
				if(referenciabancaria.getidvalorclienteproductobanco()!=null)
				{
					strValorNuevo=referenciabancaria.getidvalorclienteproductobanco().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ReferenciaBancariaConstantesFunciones.IDTIPOPRODUBANCO,strValorActual,strValorNuevo);
			}	
			
			if(referenciabancaria.getIsNew()||!referenciabancaria.getidvalorclientecuentabanco().equals(referenciabancaria.getReferenciaBancariaOriginal().getidvalorclientecuentabanco()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(referenciabancaria.getReferenciaBancariaOriginal().getidvalorclientecuentabanco()!=null)
				{
					strValorActual=referenciabancaria.getReferenciaBancariaOriginal().getidvalorclientecuentabanco().toString();
				}
				if(referenciabancaria.getidvalorclientecuentabanco()!=null)
				{
					strValorNuevo=referenciabancaria.getidvalorclientecuentabanco().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ReferenciaBancariaConstantesFunciones.IDTIPOCUENTABANCO,strValorActual,strValorNuevo);
			}	
			
			if(referenciabancaria.getIsNew()||!referenciabancaria.getnumero_cuenta_tarjeta().equals(referenciabancaria.getReferenciaBancariaOriginal().getnumero_cuenta_tarjeta()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(referenciabancaria.getReferenciaBancariaOriginal().getnumero_cuenta_tarjeta()!=null)
				{
					strValorActual=referenciabancaria.getReferenciaBancariaOriginal().getnumero_cuenta_tarjeta();
				}
				if(referenciabancaria.getnumero_cuenta_tarjeta()!=null)
				{
					strValorNuevo=referenciabancaria.getnumero_cuenta_tarjeta() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ReferenciaBancariaConstantesFunciones.NUMEROCUENTATARJETA,strValorActual,strValorNuevo);
			}	
			
			if(referenciabancaria.getIsNew()||!referenciabancaria.getfecha_emision().equals(referenciabancaria.getReferenciaBancariaOriginal().getfecha_emision()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(referenciabancaria.getReferenciaBancariaOriginal().getfecha_emision()!=null)
				{
					strValorActual=referenciabancaria.getReferenciaBancariaOriginal().getfecha_emision().toString();
				}
				if(referenciabancaria.getfecha_emision()!=null)
				{
					strValorNuevo=referenciabancaria.getfecha_emision().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ReferenciaBancariaConstantesFunciones.FECHAEMISION,strValorActual,strValorNuevo);
			}	
			
			if(referenciabancaria.getIsNew()||!referenciabancaria.getfecha_vencimiento().equals(referenciabancaria.getReferenciaBancariaOriginal().getfecha_vencimiento()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(referenciabancaria.getReferenciaBancariaOriginal().getfecha_vencimiento()!=null)
				{
					strValorActual=referenciabancaria.getReferenciaBancariaOriginal().getfecha_vencimiento().toString();
				}
				if(referenciabancaria.getfecha_vencimiento()!=null)
				{
					strValorNuevo=referenciabancaria.getfecha_vencimiento().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ReferenciaBancariaConstantesFunciones.FECHAVENCIMIENTO,strValorActual,strValorNuevo);
			}	
			
			if(referenciabancaria.getIsNew()||!referenciabancaria.getcupo().equals(referenciabancaria.getReferenciaBancariaOriginal().getcupo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(referenciabancaria.getReferenciaBancariaOriginal().getcupo()!=null)
				{
					strValorActual=referenciabancaria.getReferenciaBancariaOriginal().getcupo().toString();
				}
				if(referenciabancaria.getcupo()!=null)
				{
					strValorNuevo=referenciabancaria.getcupo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ReferenciaBancariaConstantesFunciones.CUPO,strValorActual,strValorNuevo);
			}	
			
			if(referenciabancaria.getIsNew()||!referenciabancaria.gettiene_credito().equals(referenciabancaria.getReferenciaBancariaOriginal().gettiene_credito()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(referenciabancaria.getReferenciaBancariaOriginal().gettiene_credito()!=null)
				{
					strValorActual=referenciabancaria.getReferenciaBancariaOriginal().gettiene_credito().toString();
				}
				if(referenciabancaria.gettiene_credito()!=null)
				{
					strValorNuevo=referenciabancaria.gettiene_credito().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ReferenciaBancariaConstantesFunciones.TIENECREDITO,strValorActual,strValorNuevo);
			}	
			
			if(referenciabancaria.getIsNew()||!referenciabancaria.getnumero_creditos().equals(referenciabancaria.getReferenciaBancariaOriginal().getnumero_creditos()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(referenciabancaria.getReferenciaBancariaOriginal().getnumero_creditos()!=null)
				{
					strValorActual=referenciabancaria.getReferenciaBancariaOriginal().getnumero_creditos().toString();
				}
				if(referenciabancaria.getnumero_creditos()!=null)
				{
					strValorNuevo=referenciabancaria.getnumero_creditos().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ReferenciaBancariaConstantesFunciones.NUMEROCREDITOS,strValorActual,strValorNuevo);
			}	
			
			if(referenciabancaria.getIsNew()||!referenciabancaria.gettiene_protestos().equals(referenciabancaria.getReferenciaBancariaOriginal().gettiene_protestos()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(referenciabancaria.getReferenciaBancariaOriginal().gettiene_protestos()!=null)
				{
					strValorActual=referenciabancaria.getReferenciaBancariaOriginal().gettiene_protestos().toString();
				}
				if(referenciabancaria.gettiene_protestos()!=null)
				{
					strValorNuevo=referenciabancaria.gettiene_protestos().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ReferenciaBancariaConstantesFunciones.TIENEPROTESTOS,strValorActual,strValorNuevo);
			}	
			
			if(referenciabancaria.getIsNew()||!referenciabancaria.getnumero_protestos().equals(referenciabancaria.getReferenciaBancariaOriginal().getnumero_protestos()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(referenciabancaria.getReferenciaBancariaOriginal().getnumero_protestos()!=null)
				{
					strValorActual=referenciabancaria.getReferenciaBancariaOriginal().getnumero_protestos().toString();
				}
				if(referenciabancaria.getnumero_protestos()!=null)
				{
					strValorNuevo=referenciabancaria.getnumero_protestos().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ReferenciaBancariaConstantesFunciones.NUMEROPROTESTOS,strValorActual,strValorNuevo);
			}	
			
			if(referenciabancaria.getIsNew()||!referenciabancaria.getsaldos_promedios().equals(referenciabancaria.getReferenciaBancariaOriginal().getsaldos_promedios()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(referenciabancaria.getReferenciaBancariaOriginal().getsaldos_promedios()!=null)
				{
					strValorActual=referenciabancaria.getReferenciaBancariaOriginal().getsaldos_promedios();
				}
				if(referenciabancaria.getsaldos_promedios()!=null)
				{
					strValorNuevo=referenciabancaria.getsaldos_promedios() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ReferenciaBancariaConstantesFunciones.SALDOSPROMEDIOS,strValorActual,strValorNuevo);
			}	
			
			if(referenciabancaria.getIsNew()||!referenciabancaria.getpropietario_cuenta().equals(referenciabancaria.getReferenciaBancariaOriginal().getpropietario_cuenta()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(referenciabancaria.getReferenciaBancariaOriginal().getpropietario_cuenta()!=null)
				{
					strValorActual=referenciabancaria.getReferenciaBancariaOriginal().getpropietario_cuenta();
				}
				if(referenciabancaria.getpropietario_cuenta()!=null)
				{
					strValorNuevo=referenciabancaria.getpropietario_cuenta() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ReferenciaBancariaConstantesFunciones.PROPIETARIOCUENTA,strValorActual,strValorNuevo);
			}	
			
			if(referenciabancaria.getIsNew()||!referenciabancaria.getid_tipo_valoracion().equals(referenciabancaria.getReferenciaBancariaOriginal().getid_tipo_valoracion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(referenciabancaria.getReferenciaBancariaOriginal().getid_tipo_valoracion()!=null)
				{
					strValorActual=referenciabancaria.getReferenciaBancariaOriginal().getid_tipo_valoracion().toString();
				}
				if(referenciabancaria.getid_tipo_valoracion()!=null)
				{
					strValorNuevo=referenciabancaria.getid_tipo_valoracion().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ReferenciaBancariaConstantesFunciones.IDTIPOVALORACION,strValorActual,strValorNuevo);
			}	
			
			if(referenciabancaria.getIsNew()||!referenciabancaria.getesactivo().equals(referenciabancaria.getReferenciaBancariaOriginal().getesactivo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(referenciabancaria.getReferenciaBancariaOriginal().getesactivo()!=null)
				{
					strValorActual=referenciabancaria.getReferenciaBancariaOriginal().getesactivo().toString();
				}
				if(referenciabancaria.getesactivo()!=null)
				{
					strValorNuevo=referenciabancaria.getesactivo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ReferenciaBancariaConstantesFunciones.ESACTIVO,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveReferenciaBancariaRelacionesWithConnection(ReferenciaBancaria referenciabancaria) throws Exception {

		if(!referenciabancaria.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveReferenciaBancariaRelacionesBase(referenciabancaria,true);
		}
	}

	public void saveReferenciaBancariaRelaciones(ReferenciaBancaria referenciabancaria)throws Exception {

		if(!referenciabancaria.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveReferenciaBancariaRelacionesBase(referenciabancaria,false);
		}
	}

	public void saveReferenciaBancariaRelacionesBase(ReferenciaBancaria referenciabancaria,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("ReferenciaBancaria-saveRelacionesWithConnection");}
	

			this.setReferenciaBancaria(referenciabancaria);

			if(ReferenciaBancariaLogicAdditional.validarSaveRelaciones(referenciabancaria,this)) {

				ReferenciaBancariaLogicAdditional.updateRelacionesToSave(referenciabancaria,this);

				if((referenciabancaria.getIsNew()||referenciabancaria.getIsChanged())&&!referenciabancaria.getIsDeleted()) {
					this.saveReferenciaBancaria();
					this.saveReferenciaBancariaRelacionesDetalles();

				} else if(referenciabancaria.getIsDeleted()) {
					this.saveReferenciaBancariaRelacionesDetalles();
					this.saveReferenciaBancaria();
				}

				ReferenciaBancariaLogicAdditional.updateRelacionesToSaveAfter(referenciabancaria,this);

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
	
	
	private void saveReferenciaBancariaRelacionesDetalles()throws Exception {
		try {
	

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfReferenciaBancaria(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=ReferenciaBancariaConstantesFunciones.getClassesForeignKeysOfReferenciaBancaria(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfReferenciaBancaria(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=ReferenciaBancariaConstantesFunciones.getClassesRelationshipsOfReferenciaBancaria(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

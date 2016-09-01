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
import com.bydan.erp.cartera.util.ReferenciaPersonalConstantesFunciones;
import com.bydan.erp.cartera.util.ReferenciaPersonalParameterReturnGeneral;
//import com.bydan.erp.cartera.util.ReferenciaPersonalParameterGeneral;
import com.bydan.erp.cartera.business.entity.ReferenciaPersonal;
import com.bydan.erp.cartera.business.logic.ReferenciaPersonalLogicAdditional;
import com.bydan.erp.cartera.business.dataaccess.*;
import com.bydan.erp.cartera.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;


import com.bydan.erp.seguridad.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;








@SuppressWarnings("unused")
public class ReferenciaPersonalLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(ReferenciaPersonalLogic.class);
	
	protected ReferenciaPersonalDataAccess referenciapersonalDataAccess; 	
	protected ReferenciaPersonal referenciapersonal;
	protected List<ReferenciaPersonal> referenciapersonals;
	protected Object referenciapersonalObject;	
	protected List<Object> referenciapersonalsObject;
	
	public static ClassValidator<ReferenciaPersonal> referenciapersonalValidator = new ClassValidator<ReferenciaPersonal>(ReferenciaPersonal.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected ReferenciaPersonalLogicAdditional referenciapersonalLogicAdditional=null;
	
	public ReferenciaPersonalLogicAdditional getReferenciaPersonalLogicAdditional() {
		return this.referenciapersonalLogicAdditional;
	}
	
	public void setReferenciaPersonalLogicAdditional(ReferenciaPersonalLogicAdditional referenciapersonalLogicAdditional) {
		try {
			this.referenciapersonalLogicAdditional=referenciapersonalLogicAdditional;
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
	
	
	
	
	public  ReferenciaPersonalLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.referenciapersonalDataAccess = new ReferenciaPersonalDataAccess();
			
			this.referenciapersonals= new ArrayList<ReferenciaPersonal>();
			this.referenciapersonal= new ReferenciaPersonal();
			
			this.referenciapersonalObject=new Object();
			this.referenciapersonalsObject=new ArrayList<Object>();
				
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
			
			this.referenciapersonalDataAccess.setConnexionType(this.connexionType);
			this.referenciapersonalDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  ReferenciaPersonalLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.referenciapersonalDataAccess = new ReferenciaPersonalDataAccess();
			this.referenciapersonals= new ArrayList<ReferenciaPersonal>();
			this.referenciapersonal= new ReferenciaPersonal();
			this.referenciapersonalObject=new Object();
			this.referenciapersonalsObject=new ArrayList<Object>();
			
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
			
			this.referenciapersonalDataAccess.setConnexionType(this.connexionType);
			this.referenciapersonalDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public ReferenciaPersonal getReferenciaPersonal() throws Exception {	
		ReferenciaPersonalLogicAdditional.checkReferenciaPersonalToGet(referenciapersonal,this.datosCliente,this.arrDatoGeneral);
		ReferenciaPersonalLogicAdditional.updateReferenciaPersonalToGet(referenciapersonal,this.arrDatoGeneral);
		
		return referenciapersonal;
	}
		
	public void setReferenciaPersonal(ReferenciaPersonal newReferenciaPersonal) {
		this.referenciapersonal = newReferenciaPersonal;
	}
	
	public ReferenciaPersonalDataAccess getReferenciaPersonalDataAccess() {
		return referenciapersonalDataAccess;
	}
	
	public void setReferenciaPersonalDataAccess(ReferenciaPersonalDataAccess newreferenciapersonalDataAccess) {
		this.referenciapersonalDataAccess = newreferenciapersonalDataAccess;
	}
	
	public List<ReferenciaPersonal> getReferenciaPersonals() throws Exception {		
		this.quitarReferenciaPersonalsNulos();
		
		ReferenciaPersonalLogicAdditional.checkReferenciaPersonalToGets(referenciapersonals,this.datosCliente,this.arrDatoGeneral);
		
		for (ReferenciaPersonal referenciapersonalLocal: referenciapersonals ) {
			ReferenciaPersonalLogicAdditional.updateReferenciaPersonalToGet(referenciapersonalLocal,this.arrDatoGeneral);
		}
		
		return referenciapersonals;
	}
	
	public void setReferenciaPersonals(List<ReferenciaPersonal> newReferenciaPersonals) {
		this.referenciapersonals = newReferenciaPersonals;
	}
	
	public Object getReferenciaPersonalObject() {	
		this.referenciapersonalObject=this.referenciapersonalDataAccess.getEntityObject();
		return this.referenciapersonalObject;
	}
		
	public void setReferenciaPersonalObject(Object newReferenciaPersonalObject) {
		this.referenciapersonalObject = newReferenciaPersonalObject;
	}
	
	public List<Object> getReferenciaPersonalsObject() {		
		this.referenciapersonalsObject=this.referenciapersonalDataAccess.getEntitiesObject();
		return this.referenciapersonalsObject;
	}
		
	public void setReferenciaPersonalsObject(List<Object> newReferenciaPersonalsObject) {
		this.referenciapersonalsObject = newReferenciaPersonalsObject;
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
		
		if(this.referenciapersonalDataAccess!=null) {
			this.referenciapersonalDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ReferenciaPersonal.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			referenciapersonalDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			referenciapersonalDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		referenciapersonal = new  ReferenciaPersonal();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ReferenciaPersonal.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			referenciapersonal=referenciapersonalDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.referenciapersonal,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ReferenciaPersonalConstantesFunciones.refrescarForeignKeysDescripcionesReferenciaPersonal(this.referenciapersonal);
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
		referenciapersonal = new  ReferenciaPersonal();
		  		  
        try {
			
			referenciapersonal=referenciapersonalDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.referenciapersonal,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ReferenciaPersonalConstantesFunciones.refrescarForeignKeysDescripcionesReferenciaPersonal(this.referenciapersonal);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		referenciapersonal = new  ReferenciaPersonal();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ReferenciaPersonal.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			referenciapersonal=referenciapersonalDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.referenciapersonal,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ReferenciaPersonalConstantesFunciones.refrescarForeignKeysDescripcionesReferenciaPersonal(this.referenciapersonal);
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
		referenciapersonal = new  ReferenciaPersonal();
		  		  
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
		referenciapersonal = new  ReferenciaPersonal();
		  		  
        try {
			
			referenciapersonal=referenciapersonalDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.referenciapersonal,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ReferenciaPersonalConstantesFunciones.refrescarForeignKeysDescripcionesReferenciaPersonal(this.referenciapersonal);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		referenciapersonal = new  ReferenciaPersonal();
		  		  
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
		referenciapersonal = new  ReferenciaPersonal();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ReferenciaPersonal.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =referenciapersonalDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		referenciapersonal = new  ReferenciaPersonal();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=referenciapersonalDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		referenciapersonal = new  ReferenciaPersonal();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ReferenciaPersonal.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =referenciapersonalDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		referenciapersonal = new  ReferenciaPersonal();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=referenciapersonalDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		referenciapersonal = new  ReferenciaPersonal();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ReferenciaPersonal.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =referenciapersonalDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		referenciapersonal = new  ReferenciaPersonal();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=referenciapersonalDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		referenciapersonals = new  ArrayList<ReferenciaPersonal>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ReferenciaPersonal.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			ReferenciaPersonalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			referenciapersonals=referenciapersonalDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarReferenciaPersonal(referenciapersonals);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ReferenciaPersonalConstantesFunciones.refrescarForeignKeysDescripcionesReferenciaPersonal(this.referenciapersonals);
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
		referenciapersonals = new  ArrayList<ReferenciaPersonal>();
		  		  
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
		referenciapersonals = new  ArrayList<ReferenciaPersonal>();
		  		  
        try {			
			ReferenciaPersonalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			referenciapersonals=referenciapersonalDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarReferenciaPersonal(referenciapersonals);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ReferenciaPersonalConstantesFunciones.refrescarForeignKeysDescripcionesReferenciaPersonal(this.referenciapersonals);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		referenciapersonals = new  ArrayList<ReferenciaPersonal>();
		  		  
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
		referenciapersonals = new  ArrayList<ReferenciaPersonal>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ReferenciaPersonal.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			ReferenciaPersonalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			referenciapersonals=referenciapersonalDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarReferenciaPersonal(referenciapersonals);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ReferenciaPersonalConstantesFunciones.refrescarForeignKeysDescripcionesReferenciaPersonal(this.referenciapersonals);
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
		referenciapersonals = new  ArrayList<ReferenciaPersonal>();
		  		  
        try {
			ReferenciaPersonalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			referenciapersonals=referenciapersonalDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarReferenciaPersonal(referenciapersonals);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ReferenciaPersonalConstantesFunciones.refrescarForeignKeysDescripcionesReferenciaPersonal(this.referenciapersonals);
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
		referenciapersonals = new  ArrayList<ReferenciaPersonal>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ReferenciaPersonal.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ReferenciaPersonalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			referenciapersonals=referenciapersonalDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarReferenciaPersonal(referenciapersonals);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ReferenciaPersonalConstantesFunciones.refrescarForeignKeysDescripcionesReferenciaPersonal(this.referenciapersonals);
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
		referenciapersonals = new  ArrayList<ReferenciaPersonal>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ReferenciaPersonalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			referenciapersonals=referenciapersonalDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarReferenciaPersonal(referenciapersonals);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ReferenciaPersonalConstantesFunciones.refrescarForeignKeysDescripcionesReferenciaPersonal(this.referenciapersonals);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		referenciapersonal = new  ReferenciaPersonal();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ReferenciaPersonal.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ReferenciaPersonalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			referenciapersonal=referenciapersonalDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarReferenciaPersonal(referenciapersonal);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ReferenciaPersonalConstantesFunciones.refrescarForeignKeysDescripcionesReferenciaPersonal(this.referenciapersonal);
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
		referenciapersonal = new  ReferenciaPersonal();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ReferenciaPersonalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			referenciapersonal=referenciapersonalDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarReferenciaPersonal(referenciapersonal);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ReferenciaPersonalConstantesFunciones.refrescarForeignKeysDescripcionesReferenciaPersonal(this.referenciapersonal);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		referenciapersonals = new  ArrayList<ReferenciaPersonal>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ReferenciaPersonal.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			ReferenciaPersonalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			referenciapersonals=referenciapersonalDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarReferenciaPersonal(referenciapersonals);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ReferenciaPersonalConstantesFunciones.refrescarForeignKeysDescripcionesReferenciaPersonal(this.referenciapersonals);
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
		referenciapersonals = new  ArrayList<ReferenciaPersonal>();
		  		  
        try {
			ReferenciaPersonalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			referenciapersonals=referenciapersonalDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarReferenciaPersonal(referenciapersonals);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ReferenciaPersonalConstantesFunciones.refrescarForeignKeysDescripcionesReferenciaPersonal(this.referenciapersonals);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosReferenciaPersonalsWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		referenciapersonals = new  ArrayList<ReferenciaPersonal>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ReferenciaPersonal.class.getSimpleName()+"-getTodosReferenciaPersonalsWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ReferenciaPersonalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			referenciapersonals=referenciapersonalDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarReferenciaPersonal(referenciapersonals);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ReferenciaPersonalConstantesFunciones.refrescarForeignKeysDescripcionesReferenciaPersonal(this.referenciapersonals);
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
	
	public  void  getTodosReferenciaPersonals(String sFinalQuery,Pagination pagination)throws Exception {
		referenciapersonals = new  ArrayList<ReferenciaPersonal>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ReferenciaPersonalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			referenciapersonals=referenciapersonalDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarReferenciaPersonal(referenciapersonals);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ReferenciaPersonalConstantesFunciones.refrescarForeignKeysDescripcionesReferenciaPersonal(this.referenciapersonals);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarReferenciaPersonal(ReferenciaPersonal referenciapersonal) throws Exception {
		Boolean estaValidado=false;
		
		if(referenciapersonal.getIsNew() || referenciapersonal.getIsChanged()) { 
			this.invalidValues = referenciapersonalValidator.getInvalidValues(referenciapersonal);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(referenciapersonal);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarReferenciaPersonal(List<ReferenciaPersonal> ReferenciaPersonals) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(ReferenciaPersonal referenciapersonalLocal:referenciapersonals) {				
			estaValidadoObjeto=this.validarGuardarReferenciaPersonal(referenciapersonalLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarReferenciaPersonal(List<ReferenciaPersonal> ReferenciaPersonals) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarReferenciaPersonal(referenciapersonals)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarReferenciaPersonal(ReferenciaPersonal ReferenciaPersonal) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarReferenciaPersonal(referenciapersonal)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(ReferenciaPersonal referenciapersonal) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+referenciapersonal.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=ReferenciaPersonalConstantesFunciones.getReferenciaPersonalLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"referenciapersonal","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(ReferenciaPersonalConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(ReferenciaPersonalConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveReferenciaPersonalWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ReferenciaPersonal.class.getSimpleName()+"-saveReferenciaPersonalWithConnection");connexion.begin();			
			
			ReferenciaPersonalLogicAdditional.checkReferenciaPersonalToSave(this.referenciapersonal,this.datosCliente,connexion,this.arrDatoGeneral);
			
			ReferenciaPersonalLogicAdditional.updateReferenciaPersonalToSave(this.referenciapersonal,this.arrDatoGeneral);
			
			ReferenciaPersonalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.referenciapersonal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowReferenciaPersonal();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarReferenciaPersonal(this.referenciapersonal)) {
				ReferenciaPersonalDataAccess.save(this.referenciapersonal, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.referenciapersonal,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			ReferenciaPersonalLogicAdditional.checkReferenciaPersonalToSaveAfter(this.referenciapersonal,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowReferenciaPersonal();
			
			connexion.commit();			
			
			if(this.referenciapersonal.getIsDeleted()) {
				this.referenciapersonal=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveReferenciaPersonal()throws Exception {	
		try {	
			
			ReferenciaPersonalLogicAdditional.checkReferenciaPersonalToSave(this.referenciapersonal,this.datosCliente,connexion,this.arrDatoGeneral);
			
			ReferenciaPersonalLogicAdditional.updateReferenciaPersonalToSave(this.referenciapersonal,this.arrDatoGeneral);
			
			ReferenciaPersonalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.referenciapersonal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarReferenciaPersonal(this.referenciapersonal)) {			
				ReferenciaPersonalDataAccess.save(this.referenciapersonal, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.referenciapersonal,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			ReferenciaPersonalLogicAdditional.checkReferenciaPersonalToSaveAfter(this.referenciapersonal,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.referenciapersonal.getIsDeleted()) {
				this.referenciapersonal=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveReferenciaPersonalsWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ReferenciaPersonal.class.getSimpleName()+"-saveReferenciaPersonalsWithConnection");connexion.begin();			
			
			ReferenciaPersonalLogicAdditional.checkReferenciaPersonalToSaves(referenciapersonals,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowReferenciaPersonals();
			
			Boolean validadoTodosReferenciaPersonal=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(ReferenciaPersonal referenciapersonalLocal:referenciapersonals) {		
				if(referenciapersonalLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				ReferenciaPersonalLogicAdditional.updateReferenciaPersonalToSave(referenciapersonalLocal,this.arrDatoGeneral);
	        	
				ReferenciaPersonalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),referenciapersonalLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarReferenciaPersonal(referenciapersonalLocal)) {
					ReferenciaPersonalDataAccess.save(referenciapersonalLocal, connexion);				
				} else {
					validadoTodosReferenciaPersonal=false;
				}
			}
			
			if(!validadoTodosReferenciaPersonal) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			ReferenciaPersonalLogicAdditional.checkReferenciaPersonalToSavesAfter(referenciapersonals,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowReferenciaPersonals();
			
			connexion.commit();		
			
			this.quitarReferenciaPersonalsEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveReferenciaPersonals()throws Exception {				
		 try {	
			ReferenciaPersonalLogicAdditional.checkReferenciaPersonalToSaves(referenciapersonals,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosReferenciaPersonal=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(ReferenciaPersonal referenciapersonalLocal:referenciapersonals) {				
				if(referenciapersonalLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				ReferenciaPersonalLogicAdditional.updateReferenciaPersonalToSave(referenciapersonalLocal,this.arrDatoGeneral);
	        	
				ReferenciaPersonalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),referenciapersonalLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarReferenciaPersonal(referenciapersonalLocal)) {				
					ReferenciaPersonalDataAccess.save(referenciapersonalLocal, connexion);				
				} else {
					validadoTodosReferenciaPersonal=false;
				}
			}
			
			if(!validadoTodosReferenciaPersonal) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			ReferenciaPersonalLogicAdditional.checkReferenciaPersonalToSavesAfter(referenciapersonals,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarReferenciaPersonalsEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public ReferenciaPersonalParameterReturnGeneral procesarAccionReferenciaPersonals(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<ReferenciaPersonal> referenciapersonals,ReferenciaPersonalParameterReturnGeneral referenciapersonalParameterGeneral)throws Exception {
		 try {	
			ReferenciaPersonalParameterReturnGeneral referenciapersonalReturnGeneral=new ReferenciaPersonalParameterReturnGeneral();
	
			ReferenciaPersonalLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,referenciapersonals,referenciapersonalParameterGeneral,referenciapersonalReturnGeneral);
			
			return referenciapersonalReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public ReferenciaPersonalParameterReturnGeneral procesarAccionReferenciaPersonalsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<ReferenciaPersonal> referenciapersonals,ReferenciaPersonalParameterReturnGeneral referenciapersonalParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ReferenciaPersonal.class.getSimpleName()+"-procesarAccionReferenciaPersonalsWithConnection");connexion.begin();			
			
			ReferenciaPersonalParameterReturnGeneral referenciapersonalReturnGeneral=new ReferenciaPersonalParameterReturnGeneral();
	
			ReferenciaPersonalLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,referenciapersonals,referenciapersonalParameterGeneral,referenciapersonalReturnGeneral);
			
			this.connexion.commit();
			
			return referenciapersonalReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public ReferenciaPersonalParameterReturnGeneral procesarEventosReferenciaPersonals(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<ReferenciaPersonal> referenciapersonals,ReferenciaPersonal referenciapersonal,ReferenciaPersonalParameterReturnGeneral referenciapersonalParameterGeneral,Boolean isEsNuevoReferenciaPersonal,ArrayList<Classe> clases)throws Exception {
		 try {	
			ReferenciaPersonalParameterReturnGeneral referenciapersonalReturnGeneral=new ReferenciaPersonalParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				referenciapersonalReturnGeneral.setConRecargarPropiedades(true);
			}
			
			ReferenciaPersonalLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,referenciapersonals,referenciapersonal,referenciapersonalParameterGeneral,referenciapersonalReturnGeneral,isEsNuevoReferenciaPersonal,clases);
			
			return referenciapersonalReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public ReferenciaPersonalParameterReturnGeneral procesarEventosReferenciaPersonalsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<ReferenciaPersonal> referenciapersonals,ReferenciaPersonal referenciapersonal,ReferenciaPersonalParameterReturnGeneral referenciapersonalParameterGeneral,Boolean isEsNuevoReferenciaPersonal,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ReferenciaPersonal.class.getSimpleName()+"-procesarEventosReferenciaPersonalsWithConnection");connexion.begin();			
			
			ReferenciaPersonalParameterReturnGeneral referenciapersonalReturnGeneral=new ReferenciaPersonalParameterReturnGeneral();
	
			referenciapersonalReturnGeneral.setReferenciaPersonal(referenciapersonal);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				referenciapersonalReturnGeneral.setConRecargarPropiedades(true);
			}
			
			ReferenciaPersonalLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,referenciapersonals,referenciapersonal,referenciapersonalParameterGeneral,referenciapersonalReturnGeneral,isEsNuevoReferenciaPersonal,clases);
			
			this.connexion.commit();
			
			return referenciapersonalReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public ReferenciaPersonalParameterReturnGeneral procesarImportacionReferenciaPersonalsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,ReferenciaPersonalParameterReturnGeneral referenciapersonalParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ReferenciaPersonal.class.getSimpleName()+"-procesarImportacionReferenciaPersonalsWithConnection");connexion.begin();			
			
			ReferenciaPersonalParameterReturnGeneral referenciapersonalReturnGeneral=new ReferenciaPersonalParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.referenciapersonals=new ArrayList<ReferenciaPersonal>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.referenciapersonal=new ReferenciaPersonal();
				
				
				if(conColumnasBase) {this.referenciapersonal.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.referenciapersonal.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

			this.referenciapersonal.setnombre(arrColumnas[iColumn++]);
				this.referenciapersonal.setidentificacion(arrColumnas[iColumn++]);
				this.referenciapersonal.setfecha_nacimiento(Funciones.ConvertToDate(arrColumnas[iColumn++]));
			this.referenciapersonal.setdireccion(arrColumnas[iColumn++]);
			this.referenciapersonal.settelefono(arrColumnas[iColumn++]);
			this.referenciapersonal.settelefonomovil(arrColumnas[iColumn++]);
				this.referenciapersonal.settelefonocodigoarea(arrColumnas[iColumn++]);
				this.referenciapersonal.setpreferencia(arrColumnas[iColumn++]);
			this.referenciapersonal.setemail(arrColumnas[iColumn++]);
			this.referenciapersonal.setobservacion(arrColumnas[iColumn++]);
				this.referenciapersonal.setesta_trabajando(Boolean.parseBoolean(arrColumnas[iColumn++]));
				this.referenciapersonal.setempresa_trabajo(arrColumnas[iColumn++]);
			this.referenciapersonal.setdireccion_trabajo(arrColumnas[iColumn++]);
			this.referenciapersonal.settelefono_trabajo(arrColumnas[iColumn++]);
				this.referenciapersonal.setesactivo(Boolean.parseBoolean(arrColumnas[iColumn++]));
				
				this.referenciapersonals.add(this.referenciapersonal);
			}
			
			this.saveReferenciaPersonals();
			
			this.connexion.commit();
			
			referenciapersonalReturnGeneral.setConRetornoEstaProcesado(true);
			referenciapersonalReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return referenciapersonalReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarReferenciaPersonalsEliminados() throws Exception {				
		
		List<ReferenciaPersonal> referenciapersonalsAux= new ArrayList<ReferenciaPersonal>();
		
		for(ReferenciaPersonal referenciapersonal:referenciapersonals) {
			if(!referenciapersonal.getIsDeleted()) {
				referenciapersonalsAux.add(referenciapersonal);
			}
		}
		
		referenciapersonals=referenciapersonalsAux;
	}
	
	public void quitarReferenciaPersonalsNulos() throws Exception {				
		
		List<ReferenciaPersonal> referenciapersonalsAux= new ArrayList<ReferenciaPersonal>();
		
		for(ReferenciaPersonal referenciapersonal : this.referenciapersonals) {
			if(referenciapersonal==null) {
				referenciapersonalsAux.add(referenciapersonal);
			}
		}
		
		//this.referenciapersonals=referenciapersonalsAux;
		
		this.referenciapersonals.removeAll(referenciapersonalsAux);
	}
	
	public void getSetVersionRowReferenciaPersonalWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(referenciapersonal.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((referenciapersonal.getIsDeleted() || (referenciapersonal.getIsChanged()&&!referenciapersonal.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=referenciapersonalDataAccess.getSetVersionRowReferenciaPersonal(connexion,referenciapersonal.getId());
				
				if(!referenciapersonal.getVersionRow().equals(timestamp)) {	
					referenciapersonal.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				referenciapersonal.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowReferenciaPersonal()throws Exception {	
		
		if(referenciapersonal.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((referenciapersonal.getIsDeleted() || (referenciapersonal.getIsChanged()&&!referenciapersonal.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=referenciapersonalDataAccess.getSetVersionRowReferenciaPersonal(connexion,referenciapersonal.getId());
			
			try {							
				if(!referenciapersonal.getVersionRow().equals(timestamp)) {	
					referenciapersonal.setVersionRow(timestamp);
				}
				
				referenciapersonal.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowReferenciaPersonalsWithConnection()throws Exception {	
		if(referenciapersonals!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(ReferenciaPersonal referenciapersonalAux:referenciapersonals) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(referenciapersonalAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(referenciapersonalAux.getIsDeleted() || (referenciapersonalAux.getIsChanged()&&!referenciapersonalAux.getIsNew())) {
						
						timestamp=referenciapersonalDataAccess.getSetVersionRowReferenciaPersonal(connexion,referenciapersonalAux.getId());
						
						if(!referenciapersonal.getVersionRow().equals(timestamp)) {	
							referenciapersonalAux.setVersionRow(timestamp);
						}
								
						referenciapersonalAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowReferenciaPersonals()throws Exception {	
		if(referenciapersonals!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(ReferenciaPersonal referenciapersonalAux:referenciapersonals) {
					if(referenciapersonalAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(referenciapersonalAux.getIsDeleted() || (referenciapersonalAux.getIsChanged()&&!referenciapersonalAux.getIsNew())) {
						
						timestamp=referenciapersonalDataAccess.getSetVersionRowReferenciaPersonal(connexion,referenciapersonalAux.getId());
						
						if(!referenciapersonalAux.getVersionRow().equals(timestamp)) {	
							referenciapersonalAux.setVersionRow(timestamp);
						}
						
													
						referenciapersonalAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public ReferenciaPersonalParameterReturnGeneral cargarCombosLoteForeignKeyReferenciaPersonalWithConnection(String finalQueryGlobalEmpresa,String finalQueryGlobalCliente,String finalQueryGlobalTipoRefePerso,String finalQueryGlobalPais,String finalQueryGlobalCiudad) throws Exception {
		ReferenciaPersonalParameterReturnGeneral  referenciapersonalReturnGeneral =new ReferenciaPersonalParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ReferenciaPersonal.class.getSimpleName()+"-cargarCombosLoteForeignKeyReferenciaPersonalWithConnection");connexion.begin();
			
			referenciapersonalReturnGeneral =new ReferenciaPersonalParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			referenciapersonalReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Cliente> clientesForeignKey=new ArrayList<Cliente>();
			ClienteLogic clienteLogic=new ClienteLogic();
			clienteLogic.setConnexion(this.connexion);
			clienteLogic.getClienteDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCliente.equals("NONE")) {
				clienteLogic.getTodosClientes(finalQueryGlobalCliente,new Pagination());
				clientesForeignKey=clienteLogic.getClientes();
			}

			referenciapersonalReturnGeneral.setclientesForeignKey(clientesForeignKey);


			List<TipoRefePerso> tiporefepersosForeignKey=new ArrayList<TipoRefePerso>();
			TipoRefePersoLogic tiporefepersoLogic=new TipoRefePersoLogic();
			tiporefepersoLogic.setConnexion(this.connexion);
			tiporefepersoLogic.getTipoRefePersoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoRefePerso.equals("NONE")) {
				tiporefepersoLogic.getTodosTipoRefePersos(finalQueryGlobalTipoRefePerso,new Pagination());
				tiporefepersosForeignKey=tiporefepersoLogic.getTipoRefePersos();
			}

			referenciapersonalReturnGeneral.settiporefepersosForeignKey(tiporefepersosForeignKey);


			List<Pais> paissForeignKey=new ArrayList<Pais>();
			PaisLogic paisLogic=new PaisLogic();
			paisLogic.setConnexion(this.connexion);
			paisLogic.getPaisDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPais.equals("NONE")) {
				paisLogic.getTodosPaiss(finalQueryGlobalPais,new Pagination());
				paissForeignKey=paisLogic.getPaiss();
			}

			referenciapersonalReturnGeneral.setpaissForeignKey(paissForeignKey);


			List<Ciudad> ciudadsForeignKey=new ArrayList<Ciudad>();
			CiudadLogic ciudadLogic=new CiudadLogic();
			ciudadLogic.setConnexion(this.connexion);
			ciudadLogic.getCiudadDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCiudad.equals("NONE")) {
				ciudadLogic.getTodosCiudads(finalQueryGlobalCiudad,new Pagination());
				ciudadsForeignKey=ciudadLogic.getCiudads();
			}

			referenciapersonalReturnGeneral.setciudadsForeignKey(ciudadsForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return referenciapersonalReturnGeneral;
	}
	
	public ReferenciaPersonalParameterReturnGeneral cargarCombosLoteForeignKeyReferenciaPersonal(String finalQueryGlobalEmpresa,String finalQueryGlobalCliente,String finalQueryGlobalTipoRefePerso,String finalQueryGlobalPais,String finalQueryGlobalCiudad) throws Exception {
		ReferenciaPersonalParameterReturnGeneral  referenciapersonalReturnGeneral =new ReferenciaPersonalParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			referenciapersonalReturnGeneral =new ReferenciaPersonalParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			referenciapersonalReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Cliente> clientesForeignKey=new ArrayList<Cliente>();
			ClienteLogic clienteLogic=new ClienteLogic();
			clienteLogic.setConnexion(this.connexion);
			clienteLogic.getClienteDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCliente.equals("NONE")) {
				clienteLogic.getTodosClientes(finalQueryGlobalCliente,new Pagination());
				clientesForeignKey=clienteLogic.getClientes();
			}

			referenciapersonalReturnGeneral.setclientesForeignKey(clientesForeignKey);


			List<TipoRefePerso> tiporefepersosForeignKey=new ArrayList<TipoRefePerso>();
			TipoRefePersoLogic tiporefepersoLogic=new TipoRefePersoLogic();
			tiporefepersoLogic.setConnexion(this.connexion);
			tiporefepersoLogic.getTipoRefePersoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoRefePerso.equals("NONE")) {
				tiporefepersoLogic.getTodosTipoRefePersos(finalQueryGlobalTipoRefePerso,new Pagination());
				tiporefepersosForeignKey=tiporefepersoLogic.getTipoRefePersos();
			}

			referenciapersonalReturnGeneral.settiporefepersosForeignKey(tiporefepersosForeignKey);


			List<Pais> paissForeignKey=new ArrayList<Pais>();
			PaisLogic paisLogic=new PaisLogic();
			paisLogic.setConnexion(this.connexion);
			paisLogic.getPaisDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPais.equals("NONE")) {
				paisLogic.getTodosPaiss(finalQueryGlobalPais,new Pagination());
				paissForeignKey=paisLogic.getPaiss();
			}

			referenciapersonalReturnGeneral.setpaissForeignKey(paissForeignKey);


			List<Ciudad> ciudadsForeignKey=new ArrayList<Ciudad>();
			CiudadLogic ciudadLogic=new CiudadLogic();
			ciudadLogic.setConnexion(this.connexion);
			ciudadLogic.getCiudadDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCiudad.equals("NONE")) {
				ciudadLogic.getTodosCiudads(finalQueryGlobalCiudad,new Pagination());
				ciudadsForeignKey=ciudadLogic.getCiudads();
			}

			referenciapersonalReturnGeneral.setciudadsForeignKey(ciudadsForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return referenciapersonalReturnGeneral;
	}
	
	
	public void deepLoad(ReferenciaPersonal referenciapersonal,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			ReferenciaPersonalLogicAdditional.updateReferenciaPersonalToGet(referenciapersonal,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		referenciapersonal.setEmpresa(referenciapersonalDataAccess.getEmpresa(connexion,referenciapersonal));
		referenciapersonal.setCliente(referenciapersonalDataAccess.getCliente(connexion,referenciapersonal));
		referenciapersonal.setTipoRefePerso(referenciapersonalDataAccess.getTipoRefePerso(connexion,referenciapersonal));
		referenciapersonal.setPais(referenciapersonalDataAccess.getPais(connexion,referenciapersonal));
		referenciapersonal.setCiudad(referenciapersonalDataAccess.getCiudad(connexion,referenciapersonal));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				referenciapersonal.setEmpresa(referenciapersonalDataAccess.getEmpresa(connexion,referenciapersonal));
				continue;
			}

			if(clas.clas.equals(Cliente.class)) {
				referenciapersonal.setCliente(referenciapersonalDataAccess.getCliente(connexion,referenciapersonal));
				continue;
			}

			if(clas.clas.equals(TipoRefePerso.class)) {
				referenciapersonal.setTipoRefePerso(referenciapersonalDataAccess.getTipoRefePerso(connexion,referenciapersonal));
				continue;
			}

			if(clas.clas.equals(Pais.class)) {
				referenciapersonal.setPais(referenciapersonalDataAccess.getPais(connexion,referenciapersonal));
				continue;
			}

			if(clas.clas.equals(Ciudad.class)) {
				referenciapersonal.setCiudad(referenciapersonalDataAccess.getCiudad(connexion,referenciapersonal));
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
			referenciapersonal.setEmpresa(referenciapersonalDataAccess.getEmpresa(connexion,referenciapersonal));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Cliente.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			referenciapersonal.setCliente(referenciapersonalDataAccess.getCliente(connexion,referenciapersonal));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoRefePerso.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			referenciapersonal.setTipoRefePerso(referenciapersonalDataAccess.getTipoRefePerso(connexion,referenciapersonal));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Pais.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			referenciapersonal.setPais(referenciapersonalDataAccess.getPais(connexion,referenciapersonal));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Ciudad.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			referenciapersonal.setCiudad(referenciapersonalDataAccess.getCiudad(connexion,referenciapersonal));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		referenciapersonal.setEmpresa(referenciapersonalDataAccess.getEmpresa(connexion,referenciapersonal));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(referenciapersonal.getEmpresa(),isDeep,deepLoadType,clases);
				
		referenciapersonal.setCliente(referenciapersonalDataAccess.getCliente(connexion,referenciapersonal));
		ClienteLogic clienteLogic= new ClienteLogic(connexion);
		clienteLogic.deepLoad(referenciapersonal.getCliente(),isDeep,deepLoadType,clases);
				
		referenciapersonal.setTipoRefePerso(referenciapersonalDataAccess.getTipoRefePerso(connexion,referenciapersonal));
		TipoRefePersoLogic tiporefepersoLogic= new TipoRefePersoLogic(connexion);
		tiporefepersoLogic.deepLoad(referenciapersonal.getTipoRefePerso(),isDeep,deepLoadType,clases);
				
		referenciapersonal.setPais(referenciapersonalDataAccess.getPais(connexion,referenciapersonal));
		PaisLogic paisLogic= new PaisLogic(connexion);
		paisLogic.deepLoad(referenciapersonal.getPais(),isDeep,deepLoadType,clases);
				
		referenciapersonal.setCiudad(referenciapersonalDataAccess.getCiudad(connexion,referenciapersonal));
		CiudadLogic ciudadLogic= new CiudadLogic(connexion);
		ciudadLogic.deepLoad(referenciapersonal.getCiudad(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				referenciapersonal.setEmpresa(referenciapersonalDataAccess.getEmpresa(connexion,referenciapersonal));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(referenciapersonal.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Cliente.class)) {
				referenciapersonal.setCliente(referenciapersonalDataAccess.getCliente(connexion,referenciapersonal));
				ClienteLogic clienteLogic= new ClienteLogic(connexion);
				clienteLogic.deepLoad(referenciapersonal.getCliente(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoRefePerso.class)) {
				referenciapersonal.setTipoRefePerso(referenciapersonalDataAccess.getTipoRefePerso(connexion,referenciapersonal));
				TipoRefePersoLogic tiporefepersoLogic= new TipoRefePersoLogic(connexion);
				tiporefepersoLogic.deepLoad(referenciapersonal.getTipoRefePerso(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Pais.class)) {
				referenciapersonal.setPais(referenciapersonalDataAccess.getPais(connexion,referenciapersonal));
				PaisLogic paisLogic= new PaisLogic(connexion);
				paisLogic.deepLoad(referenciapersonal.getPais(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Ciudad.class)) {
				referenciapersonal.setCiudad(referenciapersonalDataAccess.getCiudad(connexion,referenciapersonal));
				CiudadLogic ciudadLogic= new CiudadLogic(connexion);
				ciudadLogic.deepLoad(referenciapersonal.getCiudad(),isDeep,deepLoadType,clases);				
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
			referenciapersonal.setEmpresa(referenciapersonalDataAccess.getEmpresa(connexion,referenciapersonal));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(referenciapersonal.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Cliente.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			referenciapersonal.setCliente(referenciapersonalDataAccess.getCliente(connexion,referenciapersonal));
			ClienteLogic clienteLogic= new ClienteLogic(connexion);
			clienteLogic.deepLoad(referenciapersonal.getCliente(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoRefePerso.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			referenciapersonal.setTipoRefePerso(referenciapersonalDataAccess.getTipoRefePerso(connexion,referenciapersonal));
			TipoRefePersoLogic tiporefepersoLogic= new TipoRefePersoLogic(connexion);
			tiporefepersoLogic.deepLoad(referenciapersonal.getTipoRefePerso(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Pais.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			referenciapersonal.setPais(referenciapersonalDataAccess.getPais(connexion,referenciapersonal));
			PaisLogic paisLogic= new PaisLogic(connexion);
			paisLogic.deepLoad(referenciapersonal.getPais(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Ciudad.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			referenciapersonal.setCiudad(referenciapersonalDataAccess.getCiudad(connexion,referenciapersonal));
			CiudadLogic ciudadLogic= new CiudadLogic(connexion);
			ciudadLogic.deepLoad(referenciapersonal.getCiudad(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(ReferenciaPersonal referenciapersonal,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			ReferenciaPersonalLogicAdditional.updateReferenciaPersonalToSave(referenciapersonal,this.arrDatoGeneral);
			
ReferenciaPersonalDataAccess.save(referenciapersonal, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(referenciapersonal.getEmpresa(),connexion);

		ClienteDataAccess.save(referenciapersonal.getCliente(),connexion);

		TipoRefePersoDataAccess.save(referenciapersonal.getTipoRefePerso(),connexion);

		PaisDataAccess.save(referenciapersonal.getPais(),connexion);

		CiudadDataAccess.save(referenciapersonal.getCiudad(),connexion);
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(referenciapersonal.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(Cliente.class)) {
				ClienteDataAccess.save(referenciapersonal.getCliente(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoRefePerso.class)) {
				TipoRefePersoDataAccess.save(referenciapersonal.getTipoRefePerso(),connexion);
				continue;
			}

			if(clas.clas.equals(Pais.class)) {
				PaisDataAccess.save(referenciapersonal.getPais(),connexion);
				continue;
			}

			if(clas.clas.equals(Ciudad.class)) {
				CiudadDataAccess.save(referenciapersonal.getCiudad(),connexion);
				continue;
			}

		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(referenciapersonal.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(referenciapersonal.getEmpresa(),isDeep,deepLoadType,clases);
				

		ClienteDataAccess.save(referenciapersonal.getCliente(),connexion);
		ClienteLogic clienteLogic= new ClienteLogic(connexion);
		clienteLogic.deepLoad(referenciapersonal.getCliente(),isDeep,deepLoadType,clases);
				

		TipoRefePersoDataAccess.save(referenciapersonal.getTipoRefePerso(),connexion);
		TipoRefePersoLogic tiporefepersoLogic= new TipoRefePersoLogic(connexion);
		tiporefepersoLogic.deepLoad(referenciapersonal.getTipoRefePerso(),isDeep,deepLoadType,clases);
				

		PaisDataAccess.save(referenciapersonal.getPais(),connexion);
		PaisLogic paisLogic= new PaisLogic(connexion);
		paisLogic.deepLoad(referenciapersonal.getPais(),isDeep,deepLoadType,clases);
				

		CiudadDataAccess.save(referenciapersonal.getCiudad(),connexion);
		CiudadLogic ciudadLogic= new CiudadLogic(connexion);
		ciudadLogic.deepLoad(referenciapersonal.getCiudad(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(referenciapersonal.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(referenciapersonal.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Cliente.class)) {
				ClienteDataAccess.save(referenciapersonal.getCliente(),connexion);
				ClienteLogic clienteLogic= new ClienteLogic(connexion);
				clienteLogic.deepSave(referenciapersonal.getCliente(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoRefePerso.class)) {
				TipoRefePersoDataAccess.save(referenciapersonal.getTipoRefePerso(),connexion);
				TipoRefePersoLogic tiporefepersoLogic= new TipoRefePersoLogic(connexion);
				tiporefepersoLogic.deepSave(referenciapersonal.getTipoRefePerso(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Pais.class)) {
				PaisDataAccess.save(referenciapersonal.getPais(),connexion);
				PaisLogic paisLogic= new PaisLogic(connexion);
				paisLogic.deepSave(referenciapersonal.getPais(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Ciudad.class)) {
				CiudadDataAccess.save(referenciapersonal.getCiudad(),connexion);
				CiudadLogic ciudadLogic= new CiudadLogic(connexion);
				ciudadLogic.deepSave(referenciapersonal.getCiudad(),isDeep,deepLoadType,clases);				
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
			this.getNewConnexionToDeep(ReferenciaPersonal.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(referenciapersonal,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				ReferenciaPersonalConstantesFunciones.refrescarForeignKeysDescripcionesReferenciaPersonal(referenciapersonal);
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
			this.deepLoad(this.referenciapersonal,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				ReferenciaPersonalConstantesFunciones.refrescarForeignKeysDescripcionesReferenciaPersonal(this.referenciapersonal);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(ReferenciaPersonal.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(referenciapersonals!=null) {
				for(ReferenciaPersonal referenciapersonal:referenciapersonals) {
					this.deepLoad(referenciapersonal,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					ReferenciaPersonalConstantesFunciones.refrescarForeignKeysDescripcionesReferenciaPersonal(referenciapersonals);
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
			if(referenciapersonals!=null) {
				for(ReferenciaPersonal referenciapersonal:referenciapersonals) {
					this.deepLoad(referenciapersonal,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					ReferenciaPersonalConstantesFunciones.refrescarForeignKeysDescripcionesReferenciaPersonal(referenciapersonals);
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
			this.getNewConnexionToDeep(ReferenciaPersonal.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(referenciapersonal,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(ReferenciaPersonal.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(referenciapersonals!=null) {
				for(ReferenciaPersonal referenciapersonal:referenciapersonals) {
					this.deepSave(referenciapersonal,isDeep,deepLoadType,clases);
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
			if(referenciapersonals!=null) {
				for(ReferenciaPersonal referenciapersonal:referenciapersonals) {
					this.deepSave(referenciapersonal,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getReferenciaPersonalsFK_IdCiudadWithConnection(String sFinalQuery,Pagination pagination,Long idciudad)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ReferenciaPersonal.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCiudad= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCiudad.setParameterSelectionGeneralEqual(ParameterType.LONG,idciudad,ReferenciaPersonalConstantesFunciones.IDCIUDAD,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCiudad);

			ReferenciaPersonalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCiudad","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			referenciapersonals=referenciapersonalDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ReferenciaPersonalConstantesFunciones.refrescarForeignKeysDescripcionesReferenciaPersonal(this.referenciapersonals);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getReferenciaPersonalsFK_IdCiudad(String sFinalQuery,Pagination pagination,Long idciudad)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCiudad= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCiudad.setParameterSelectionGeneralEqual(ParameterType.LONG,idciudad,ReferenciaPersonalConstantesFunciones.IDCIUDAD,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCiudad);

			ReferenciaPersonalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCiudad","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			referenciapersonals=referenciapersonalDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ReferenciaPersonalConstantesFunciones.refrescarForeignKeysDescripcionesReferenciaPersonal(this.referenciapersonals);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getReferenciaPersonalsFK_IdClienteWithConnection(String sFinalQuery,Pagination pagination,Long idcliente)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ReferenciaPersonal.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCliente= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCliente.setParameterSelectionGeneralEqual(ParameterType.LONG,idcliente,ReferenciaPersonalConstantesFunciones.IDCLIENTE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCliente);

			ReferenciaPersonalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCliente","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			referenciapersonals=referenciapersonalDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ReferenciaPersonalConstantesFunciones.refrescarForeignKeysDescripcionesReferenciaPersonal(this.referenciapersonals);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getReferenciaPersonalsFK_IdCliente(String sFinalQuery,Pagination pagination,Long idcliente)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCliente= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCliente.setParameterSelectionGeneralEqual(ParameterType.LONG,idcliente,ReferenciaPersonalConstantesFunciones.IDCLIENTE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCliente);

			ReferenciaPersonalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCliente","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			referenciapersonals=referenciapersonalDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ReferenciaPersonalConstantesFunciones.refrescarForeignKeysDescripcionesReferenciaPersonal(this.referenciapersonals);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getReferenciaPersonalsFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ReferenciaPersonal.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,ReferenciaPersonalConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			ReferenciaPersonalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			referenciapersonals=referenciapersonalDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ReferenciaPersonalConstantesFunciones.refrescarForeignKeysDescripcionesReferenciaPersonal(this.referenciapersonals);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getReferenciaPersonalsFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,ReferenciaPersonalConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			ReferenciaPersonalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			referenciapersonals=referenciapersonalDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ReferenciaPersonalConstantesFunciones.refrescarForeignKeysDescripcionesReferenciaPersonal(this.referenciapersonals);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getReferenciaPersonalsFK_IdPaisWithConnection(String sFinalQuery,Pagination pagination,Long id_pais)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ReferenciaPersonal.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPais= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPais.setParameterSelectionGeneralEqual(ParameterType.LONG,id_pais,ReferenciaPersonalConstantesFunciones.IDPAIS,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPais);

			ReferenciaPersonalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPais","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			referenciapersonals=referenciapersonalDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ReferenciaPersonalConstantesFunciones.refrescarForeignKeysDescripcionesReferenciaPersonal(this.referenciapersonals);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getReferenciaPersonalsFK_IdPais(String sFinalQuery,Pagination pagination,Long id_pais)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPais= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPais.setParameterSelectionGeneralEqual(ParameterType.LONG,id_pais,ReferenciaPersonalConstantesFunciones.IDPAIS,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPais);

			ReferenciaPersonalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPais","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			referenciapersonals=referenciapersonalDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ReferenciaPersonalConstantesFunciones.refrescarForeignKeysDescripcionesReferenciaPersonal(this.referenciapersonals);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getReferenciaPersonalsFK_IdTipoReferenciaPersonalWithConnection(String sFinalQuery,Pagination pagination,Long idvalorclientereferenciapersonal)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ReferenciaPersonal.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoRefePerso= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoRefePerso.setParameterSelectionGeneralEqual(ParameterType.LONG,idvalorclientereferenciapersonal,ReferenciaPersonalConstantesFunciones.IDTIPOREFEPERSO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoRefePerso);

			ReferenciaPersonalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoReferenciaPersonal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			referenciapersonals=referenciapersonalDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ReferenciaPersonalConstantesFunciones.refrescarForeignKeysDescripcionesReferenciaPersonal(this.referenciapersonals);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getReferenciaPersonalsFK_IdTipoReferenciaPersonal(String sFinalQuery,Pagination pagination,Long idvalorclientereferenciapersonal)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoRefePerso= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoRefePerso.setParameterSelectionGeneralEqual(ParameterType.LONG,idvalorclientereferenciapersonal,ReferenciaPersonalConstantesFunciones.IDTIPOREFEPERSO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoRefePerso);

			ReferenciaPersonalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoReferenciaPersonal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			referenciapersonals=referenciapersonalDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ReferenciaPersonalConstantesFunciones.refrescarForeignKeysDescripcionesReferenciaPersonal(this.referenciapersonals);
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
			if(ReferenciaPersonalConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,ReferenciaPersonalDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,ReferenciaPersonal referenciapersonal,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(ReferenciaPersonalConstantesFunciones.ISCONAUDITORIA) {
				if(referenciapersonal.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,ReferenciaPersonalDataAccess.TABLENAME, referenciapersonal.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(ReferenciaPersonalConstantesFunciones.ISCONAUDITORIADETALLE) {
						////ReferenciaPersonalLogic.registrarAuditoriaDetallesReferenciaPersonal(connexion,referenciapersonal,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(referenciapersonal.getIsDeleted()) {
					/*if(!referenciapersonal.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,ReferenciaPersonalDataAccess.TABLENAME, referenciapersonal.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////ReferenciaPersonalLogic.registrarAuditoriaDetallesReferenciaPersonal(connexion,referenciapersonal,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,ReferenciaPersonalDataAccess.TABLENAME, referenciapersonal.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(referenciapersonal.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,ReferenciaPersonalDataAccess.TABLENAME, referenciapersonal.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(ReferenciaPersonalConstantesFunciones.ISCONAUDITORIADETALLE) {
						////ReferenciaPersonalLogic.registrarAuditoriaDetallesReferenciaPersonal(connexion,referenciapersonal,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesReferenciaPersonal(Connexion connexion,ReferenciaPersonal referenciapersonal)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(referenciapersonal.getIsNew()||!referenciapersonal.getid_empresa().equals(referenciapersonal.getReferenciaPersonalOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(referenciapersonal.getReferenciaPersonalOriginal().getid_empresa()!=null)
				{
					strValorActual=referenciapersonal.getReferenciaPersonalOriginal().getid_empresa().toString();
				}
				if(referenciapersonal.getid_empresa()!=null)
				{
					strValorNuevo=referenciapersonal.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ReferenciaPersonalConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(referenciapersonal.getIsNew()||!referenciapersonal.getidcliente().equals(referenciapersonal.getReferenciaPersonalOriginal().getidcliente()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(referenciapersonal.getReferenciaPersonalOriginal().getidcliente()!=null)
				{
					strValorActual=referenciapersonal.getReferenciaPersonalOriginal().getidcliente().toString();
				}
				if(referenciapersonal.getidcliente()!=null)
				{
					strValorNuevo=referenciapersonal.getidcliente().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ReferenciaPersonalConstantesFunciones.IDCLIENTE,strValorActual,strValorNuevo);
			}	
			
			if(referenciapersonal.getIsNew()||!referenciapersonal.getidvalorclientereferenciapersonal().equals(referenciapersonal.getReferenciaPersonalOriginal().getidvalorclientereferenciapersonal()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(referenciapersonal.getReferenciaPersonalOriginal().getidvalorclientereferenciapersonal()!=null)
				{
					strValorActual=referenciapersonal.getReferenciaPersonalOriginal().getidvalorclientereferenciapersonal().toString();
				}
				if(referenciapersonal.getidvalorclientereferenciapersonal()!=null)
				{
					strValorNuevo=referenciapersonal.getidvalorclientereferenciapersonal().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ReferenciaPersonalConstantesFunciones.IDTIPOREFEPERSO,strValorActual,strValorNuevo);
			}	
			
			if(referenciapersonal.getIsNew()||!referenciapersonal.getid_pais().equals(referenciapersonal.getReferenciaPersonalOriginal().getid_pais()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(referenciapersonal.getReferenciaPersonalOriginal().getid_pais()!=null)
				{
					strValorActual=referenciapersonal.getReferenciaPersonalOriginal().getid_pais().toString();
				}
				if(referenciapersonal.getid_pais()!=null)
				{
					strValorNuevo=referenciapersonal.getid_pais().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ReferenciaPersonalConstantesFunciones.IDPAIS,strValorActual,strValorNuevo);
			}	
			
			if(referenciapersonal.getIsNew()||!referenciapersonal.getidciudad().equals(referenciapersonal.getReferenciaPersonalOriginal().getidciudad()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(referenciapersonal.getReferenciaPersonalOriginal().getidciudad()!=null)
				{
					strValorActual=referenciapersonal.getReferenciaPersonalOriginal().getidciudad().toString();
				}
				if(referenciapersonal.getidciudad()!=null)
				{
					strValorNuevo=referenciapersonal.getidciudad().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ReferenciaPersonalConstantesFunciones.IDCIUDAD,strValorActual,strValorNuevo);
			}	
			
			if(referenciapersonal.getIsNew()||!referenciapersonal.getnombre().equals(referenciapersonal.getReferenciaPersonalOriginal().getnombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(referenciapersonal.getReferenciaPersonalOriginal().getnombre()!=null)
				{
					strValorActual=referenciapersonal.getReferenciaPersonalOriginal().getnombre();
				}
				if(referenciapersonal.getnombre()!=null)
				{
					strValorNuevo=referenciapersonal.getnombre() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ReferenciaPersonalConstantesFunciones.NOMBRE,strValorActual,strValorNuevo);
			}	
			
			if(referenciapersonal.getIsNew()||!referenciapersonal.getidentificacion().equals(referenciapersonal.getReferenciaPersonalOriginal().getidentificacion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(referenciapersonal.getReferenciaPersonalOriginal().getidentificacion()!=null)
				{
					strValorActual=referenciapersonal.getReferenciaPersonalOriginal().getidentificacion();
				}
				if(referenciapersonal.getidentificacion()!=null)
				{
					strValorNuevo=referenciapersonal.getidentificacion() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ReferenciaPersonalConstantesFunciones.IDENTIFICACION,strValorActual,strValorNuevo);
			}	
			
			if(referenciapersonal.getIsNew()||!referenciapersonal.getfecha_nacimiento().equals(referenciapersonal.getReferenciaPersonalOriginal().getfecha_nacimiento()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(referenciapersonal.getReferenciaPersonalOriginal().getfecha_nacimiento()!=null)
				{
					strValorActual=referenciapersonal.getReferenciaPersonalOriginal().getfecha_nacimiento().toString();
				}
				if(referenciapersonal.getfecha_nacimiento()!=null)
				{
					strValorNuevo=referenciapersonal.getfecha_nacimiento().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ReferenciaPersonalConstantesFunciones.FECHANACIMIENTO,strValorActual,strValorNuevo);
			}	
			
			if(referenciapersonal.getIsNew()||!referenciapersonal.getdireccion().equals(referenciapersonal.getReferenciaPersonalOriginal().getdireccion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(referenciapersonal.getReferenciaPersonalOriginal().getdireccion()!=null)
				{
					strValorActual=referenciapersonal.getReferenciaPersonalOriginal().getdireccion();
				}
				if(referenciapersonal.getdireccion()!=null)
				{
					strValorNuevo=referenciapersonal.getdireccion() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ReferenciaPersonalConstantesFunciones.DIRECCION,strValorActual,strValorNuevo);
			}	
			
			if(referenciapersonal.getIsNew()||!referenciapersonal.gettelefono().equals(referenciapersonal.getReferenciaPersonalOriginal().gettelefono()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(referenciapersonal.getReferenciaPersonalOriginal().gettelefono()!=null)
				{
					strValorActual=referenciapersonal.getReferenciaPersonalOriginal().gettelefono();
				}
				if(referenciapersonal.gettelefono()!=null)
				{
					strValorNuevo=referenciapersonal.gettelefono() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ReferenciaPersonalConstantesFunciones.TELEFONO,strValorActual,strValorNuevo);
			}	
			
			if(referenciapersonal.getIsNew()||!referenciapersonal.gettelefonomovil().equals(referenciapersonal.getReferenciaPersonalOriginal().gettelefonomovil()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(referenciapersonal.getReferenciaPersonalOriginal().gettelefonomovil()!=null)
				{
					strValorActual=referenciapersonal.getReferenciaPersonalOriginal().gettelefonomovil();
				}
				if(referenciapersonal.gettelefonomovil()!=null)
				{
					strValorNuevo=referenciapersonal.gettelefonomovil() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ReferenciaPersonalConstantesFunciones.TELEFONOMOVIL,strValorActual,strValorNuevo);
			}	
			
			if(referenciapersonal.getIsNew()||!referenciapersonal.gettelefonocodigoarea().equals(referenciapersonal.getReferenciaPersonalOriginal().gettelefonocodigoarea()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(referenciapersonal.getReferenciaPersonalOriginal().gettelefonocodigoarea()!=null)
				{
					strValorActual=referenciapersonal.getReferenciaPersonalOriginal().gettelefonocodigoarea();
				}
				if(referenciapersonal.gettelefonocodigoarea()!=null)
				{
					strValorNuevo=referenciapersonal.gettelefonocodigoarea() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ReferenciaPersonalConstantesFunciones.TELEFONOCODIGOAREA,strValorActual,strValorNuevo);
			}	
			
			if(referenciapersonal.getIsNew()||!referenciapersonal.getpreferencia().equals(referenciapersonal.getReferenciaPersonalOriginal().getpreferencia()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(referenciapersonal.getReferenciaPersonalOriginal().getpreferencia()!=null)
				{
					strValorActual=referenciapersonal.getReferenciaPersonalOriginal().getpreferencia();
				}
				if(referenciapersonal.getpreferencia()!=null)
				{
					strValorNuevo=referenciapersonal.getpreferencia() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ReferenciaPersonalConstantesFunciones.PREFERENCIA,strValorActual,strValorNuevo);
			}	
			
			if(referenciapersonal.getIsNew()||!referenciapersonal.getemail().equals(referenciapersonal.getReferenciaPersonalOriginal().getemail()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(referenciapersonal.getReferenciaPersonalOriginal().getemail()!=null)
				{
					strValorActual=referenciapersonal.getReferenciaPersonalOriginal().getemail();
				}
				if(referenciapersonal.getemail()!=null)
				{
					strValorNuevo=referenciapersonal.getemail() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ReferenciaPersonalConstantesFunciones.EMAIL,strValorActual,strValorNuevo);
			}	
			
			if(referenciapersonal.getIsNew()||!referenciapersonal.getobservacion().equals(referenciapersonal.getReferenciaPersonalOriginal().getobservacion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(referenciapersonal.getReferenciaPersonalOriginal().getobservacion()!=null)
				{
					strValorActual=referenciapersonal.getReferenciaPersonalOriginal().getobservacion();
				}
				if(referenciapersonal.getobservacion()!=null)
				{
					strValorNuevo=referenciapersonal.getobservacion() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ReferenciaPersonalConstantesFunciones.OBSERVACION,strValorActual,strValorNuevo);
			}	
			
			if(referenciapersonal.getIsNew()||!referenciapersonal.getesta_trabajando().equals(referenciapersonal.getReferenciaPersonalOriginal().getesta_trabajando()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(referenciapersonal.getReferenciaPersonalOriginal().getesta_trabajando()!=null)
				{
					strValorActual=referenciapersonal.getReferenciaPersonalOriginal().getesta_trabajando().toString();
				}
				if(referenciapersonal.getesta_trabajando()!=null)
				{
					strValorNuevo=referenciapersonal.getesta_trabajando().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ReferenciaPersonalConstantesFunciones.ESTATRABAJANDO,strValorActual,strValorNuevo);
			}	
			
			if(referenciapersonal.getIsNew()||!referenciapersonal.getempresa_trabajo().equals(referenciapersonal.getReferenciaPersonalOriginal().getempresa_trabajo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(referenciapersonal.getReferenciaPersonalOriginal().getempresa_trabajo()!=null)
				{
					strValorActual=referenciapersonal.getReferenciaPersonalOriginal().getempresa_trabajo();
				}
				if(referenciapersonal.getempresa_trabajo()!=null)
				{
					strValorNuevo=referenciapersonal.getempresa_trabajo() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ReferenciaPersonalConstantesFunciones.EMPRESATRABAJO,strValorActual,strValorNuevo);
			}	
			
			if(referenciapersonal.getIsNew()||!referenciapersonal.getdireccion_trabajo().equals(referenciapersonal.getReferenciaPersonalOriginal().getdireccion_trabajo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(referenciapersonal.getReferenciaPersonalOriginal().getdireccion_trabajo()!=null)
				{
					strValorActual=referenciapersonal.getReferenciaPersonalOriginal().getdireccion_trabajo();
				}
				if(referenciapersonal.getdireccion_trabajo()!=null)
				{
					strValorNuevo=referenciapersonal.getdireccion_trabajo() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ReferenciaPersonalConstantesFunciones.DIRECCIONTRABAJO,strValorActual,strValorNuevo);
			}	
			
			if(referenciapersonal.getIsNew()||!referenciapersonal.gettelefono_trabajo().equals(referenciapersonal.getReferenciaPersonalOriginal().gettelefono_trabajo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(referenciapersonal.getReferenciaPersonalOriginal().gettelefono_trabajo()!=null)
				{
					strValorActual=referenciapersonal.getReferenciaPersonalOriginal().gettelefono_trabajo();
				}
				if(referenciapersonal.gettelefono_trabajo()!=null)
				{
					strValorNuevo=referenciapersonal.gettelefono_trabajo() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ReferenciaPersonalConstantesFunciones.TELEFONOTRABAJO,strValorActual,strValorNuevo);
			}	
			
			if(referenciapersonal.getIsNew()||!referenciapersonal.getesactivo().equals(referenciapersonal.getReferenciaPersonalOriginal().getesactivo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(referenciapersonal.getReferenciaPersonalOriginal().getesactivo()!=null)
				{
					strValorActual=referenciapersonal.getReferenciaPersonalOriginal().getesactivo().toString();
				}
				if(referenciapersonal.getesactivo()!=null)
				{
					strValorNuevo=referenciapersonal.getesactivo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ReferenciaPersonalConstantesFunciones.ESACTIVO,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveReferenciaPersonalRelacionesWithConnection(ReferenciaPersonal referenciapersonal) throws Exception {

		if(!referenciapersonal.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveReferenciaPersonalRelacionesBase(referenciapersonal,true);
		}
	}

	public void saveReferenciaPersonalRelaciones(ReferenciaPersonal referenciapersonal)throws Exception {

		if(!referenciapersonal.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveReferenciaPersonalRelacionesBase(referenciapersonal,false);
		}
	}

	public void saveReferenciaPersonalRelacionesBase(ReferenciaPersonal referenciapersonal,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("ReferenciaPersonal-saveRelacionesWithConnection");}
	

			this.setReferenciaPersonal(referenciapersonal);

			if(ReferenciaPersonalLogicAdditional.validarSaveRelaciones(referenciapersonal,this)) {

				ReferenciaPersonalLogicAdditional.updateRelacionesToSave(referenciapersonal,this);

				if((referenciapersonal.getIsNew()||referenciapersonal.getIsChanged())&&!referenciapersonal.getIsDeleted()) {
					this.saveReferenciaPersonal();
					this.saveReferenciaPersonalRelacionesDetalles();

				} else if(referenciapersonal.getIsDeleted()) {
					this.saveReferenciaPersonalRelacionesDetalles();
					this.saveReferenciaPersonal();
				}

				ReferenciaPersonalLogicAdditional.updateRelacionesToSaveAfter(referenciapersonal,this);

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
	
	
	private void saveReferenciaPersonalRelacionesDetalles()throws Exception {
		try {
	

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfReferenciaPersonal(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=ReferenciaPersonalConstantesFunciones.getClassesForeignKeysOfReferenciaPersonal(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfReferenciaPersonal(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=ReferenciaPersonalConstantesFunciones.getClassesRelationshipsOfReferenciaPersonal(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

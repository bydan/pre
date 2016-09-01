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
package com.bydan.erp.contabilidad.business.logic;

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
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.contabilidad.util.SecuencialConstantesFunciones;
import com.bydan.erp.contabilidad.util.SecuencialParameterReturnGeneral;
//import com.bydan.erp.contabilidad.util.SecuencialParameterGeneral;
import com.bydan.erp.contabilidad.business.entity.Secuencial;
import com.bydan.erp.contabilidad.business.logic.SecuencialLogicAdditional;
import com.bydan.erp.contabilidad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;


import com.bydan.erp.seguridad.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;








@SuppressWarnings("unused")
public class SecuencialLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(SecuencialLogic.class);
	
	protected SecuencialDataAccess secuencialDataAccess; 	
	protected Secuencial secuencial;
	protected List<Secuencial> secuencials;
	protected Object secuencialObject;	
	protected List<Object> secuencialsObject;
	
	public static ClassValidator<Secuencial> secuencialValidator = new ClassValidator<Secuencial>(Secuencial.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected SecuencialLogicAdditional secuencialLogicAdditional=null;
	
	public SecuencialLogicAdditional getSecuencialLogicAdditional() {
		return this.secuencialLogicAdditional;
	}
	
	public void setSecuencialLogicAdditional(SecuencialLogicAdditional secuencialLogicAdditional) {
		try {
			this.secuencialLogicAdditional=secuencialLogicAdditional;
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
	
	
	
	
	public  SecuencialLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.secuencialDataAccess = new SecuencialDataAccess();
			
			this.secuencials= new ArrayList<Secuencial>();
			this.secuencial= new Secuencial();
			
			this.secuencialObject=new Object();
			this.secuencialsObject=new ArrayList<Object>();
				
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
			
			this.secuencialDataAccess.setConnexionType(this.connexionType);
			this.secuencialDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  SecuencialLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.secuencialDataAccess = new SecuencialDataAccess();
			this.secuencials= new ArrayList<Secuencial>();
			this.secuencial= new Secuencial();
			this.secuencialObject=new Object();
			this.secuencialsObject=new ArrayList<Object>();
			
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
			
			this.secuencialDataAccess.setConnexionType(this.connexionType);
			this.secuencialDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public Secuencial getSecuencial() throws Exception {	
		SecuencialLogicAdditional.checkSecuencialToGet(secuencial,this.datosCliente,this.arrDatoGeneral);
		SecuencialLogicAdditional.updateSecuencialToGet(secuencial,this.arrDatoGeneral);
		
		return secuencial;
	}
		
	public void setSecuencial(Secuencial newSecuencial) {
		this.secuencial = newSecuencial;
	}
	
	public SecuencialDataAccess getSecuencialDataAccess() {
		return secuencialDataAccess;
	}
	
	public void setSecuencialDataAccess(SecuencialDataAccess newsecuencialDataAccess) {
		this.secuencialDataAccess = newsecuencialDataAccess;
	}
	
	public List<Secuencial> getSecuencials() throws Exception {		
		this.quitarSecuencialsNulos();
		
		SecuencialLogicAdditional.checkSecuencialToGets(secuencials,this.datosCliente,this.arrDatoGeneral);
		
		for (Secuencial secuencialLocal: secuencials ) {
			SecuencialLogicAdditional.updateSecuencialToGet(secuencialLocal,this.arrDatoGeneral);
		}
		
		return secuencials;
	}
	
	public void setSecuencials(List<Secuencial> newSecuencials) {
		this.secuencials = newSecuencials;
	}
	
	public Object getSecuencialObject() {	
		this.secuencialObject=this.secuencialDataAccess.getEntityObject();
		return this.secuencialObject;
	}
		
	public void setSecuencialObject(Object newSecuencialObject) {
		this.secuencialObject = newSecuencialObject;
	}
	
	public List<Object> getSecuencialsObject() {		
		this.secuencialsObject=this.secuencialDataAccess.getEntitiesObject();
		return this.secuencialsObject;
	}
		
	public void setSecuencialsObject(List<Object> newSecuencialsObject) {
		this.secuencialsObject = newSecuencialsObject;
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
		
		if(this.secuencialDataAccess!=null) {
			this.secuencialDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Secuencial.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			secuencialDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			secuencialDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		secuencial = new  Secuencial();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Secuencial.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			secuencial=secuencialDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.secuencial,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				SecuencialConstantesFunciones.refrescarForeignKeysDescripcionesSecuencial(this.secuencial);
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
		secuencial = new  Secuencial();
		  		  
        try {
			
			secuencial=secuencialDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.secuencial,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				SecuencialConstantesFunciones.refrescarForeignKeysDescripcionesSecuencial(this.secuencial);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		secuencial = new  Secuencial();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Secuencial.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			secuencial=secuencialDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.secuencial,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				SecuencialConstantesFunciones.refrescarForeignKeysDescripcionesSecuencial(this.secuencial);
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
		secuencial = new  Secuencial();
		  		  
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
		secuencial = new  Secuencial();
		  		  
        try {
			
			secuencial=secuencialDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.secuencial,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				SecuencialConstantesFunciones.refrescarForeignKeysDescripcionesSecuencial(this.secuencial);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		secuencial = new  Secuencial();
		  		  
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
		secuencial = new  Secuencial();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Secuencial.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =secuencialDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		secuencial = new  Secuencial();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=secuencialDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		secuencial = new  Secuencial();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Secuencial.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =secuencialDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		secuencial = new  Secuencial();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=secuencialDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		secuencial = new  Secuencial();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Secuencial.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =secuencialDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		secuencial = new  Secuencial();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=secuencialDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		secuencials = new  ArrayList<Secuencial>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Secuencial.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			SecuencialLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			secuencials=secuencialDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarSecuencial(secuencials);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				SecuencialConstantesFunciones.refrescarForeignKeysDescripcionesSecuencial(this.secuencials);
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
		secuencials = new  ArrayList<Secuencial>();
		  		  
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
		secuencials = new  ArrayList<Secuencial>();
		  		  
        try {			
			SecuencialLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			secuencials=secuencialDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarSecuencial(secuencials);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				SecuencialConstantesFunciones.refrescarForeignKeysDescripcionesSecuencial(this.secuencials);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		secuencials = new  ArrayList<Secuencial>();
		  		  
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
		secuencials = new  ArrayList<Secuencial>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Secuencial.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			SecuencialLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			secuencials=secuencialDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarSecuencial(secuencials);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				SecuencialConstantesFunciones.refrescarForeignKeysDescripcionesSecuencial(this.secuencials);
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
		secuencials = new  ArrayList<Secuencial>();
		  		  
        try {
			SecuencialLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			secuencials=secuencialDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarSecuencial(secuencials);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				SecuencialConstantesFunciones.refrescarForeignKeysDescripcionesSecuencial(this.secuencials);
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
		secuencials = new  ArrayList<Secuencial>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Secuencial.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			SecuencialLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			secuencials=secuencialDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarSecuencial(secuencials);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				SecuencialConstantesFunciones.refrescarForeignKeysDescripcionesSecuencial(this.secuencials);
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
		secuencials = new  ArrayList<Secuencial>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			SecuencialLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			secuencials=secuencialDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarSecuencial(secuencials);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				SecuencialConstantesFunciones.refrescarForeignKeysDescripcionesSecuencial(this.secuencials);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		secuencial = new  Secuencial();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Secuencial.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			SecuencialLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			secuencial=secuencialDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarSecuencial(secuencial);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				SecuencialConstantesFunciones.refrescarForeignKeysDescripcionesSecuencial(this.secuencial);
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
		secuencial = new  Secuencial();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			SecuencialLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			secuencial=secuencialDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarSecuencial(secuencial);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				SecuencialConstantesFunciones.refrescarForeignKeysDescripcionesSecuencial(this.secuencial);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		secuencials = new  ArrayList<Secuencial>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Secuencial.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			SecuencialLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			secuencials=secuencialDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarSecuencial(secuencials);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				SecuencialConstantesFunciones.refrescarForeignKeysDescripcionesSecuencial(this.secuencials);
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
		secuencials = new  ArrayList<Secuencial>();
		  		  
        try {
			SecuencialLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			secuencials=secuencialDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarSecuencial(secuencials);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				SecuencialConstantesFunciones.refrescarForeignKeysDescripcionesSecuencial(this.secuencials);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosSecuencialsWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		secuencials = new  ArrayList<Secuencial>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Secuencial.class.getSimpleName()+"-getTodosSecuencialsWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			SecuencialLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			secuencials=secuencialDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarSecuencial(secuencials);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				SecuencialConstantesFunciones.refrescarForeignKeysDescripcionesSecuencial(this.secuencials);
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
	
	public  void  getTodosSecuencials(String sFinalQuery,Pagination pagination)throws Exception {
		secuencials = new  ArrayList<Secuencial>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			SecuencialLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			secuencials=secuencialDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarSecuencial(secuencials);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				SecuencialConstantesFunciones.refrescarForeignKeysDescripcionesSecuencial(this.secuencials);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarSecuencial(Secuencial secuencial) throws Exception {
		Boolean estaValidado=false;
		
		if(secuencial.getIsNew() || secuencial.getIsChanged()) { 
			this.invalidValues = secuencialValidator.getInvalidValues(secuencial);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(secuencial);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarSecuencial(List<Secuencial> Secuencials) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(Secuencial secuencialLocal:secuencials) {				
			estaValidadoObjeto=this.validarGuardarSecuencial(secuencialLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarSecuencial(List<Secuencial> Secuencials) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarSecuencial(secuencials)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarSecuencial(Secuencial Secuencial) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarSecuencial(secuencial)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(Secuencial secuencial) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+secuencial.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=SecuencialConstantesFunciones.getSecuencialLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"secuencial","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(SecuencialConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(SecuencialConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveSecuencialWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Secuencial.class.getSimpleName()+"-saveSecuencialWithConnection");connexion.begin();			
			
			SecuencialLogicAdditional.checkSecuencialToSave(this.secuencial,this.datosCliente,connexion,this.arrDatoGeneral);
			
			SecuencialLogicAdditional.updateSecuencialToSave(this.secuencial,this.arrDatoGeneral);
			
			SecuencialLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.secuencial,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowSecuencial();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarSecuencial(this.secuencial)) {
				SecuencialDataAccess.save(this.secuencial, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.secuencial,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			SecuencialLogicAdditional.checkSecuencialToSaveAfter(this.secuencial,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowSecuencial();
			
			connexion.commit();			
			
			if(this.secuencial.getIsDeleted()) {
				this.secuencial=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveSecuencial()throws Exception {	
		try {	
			
			SecuencialLogicAdditional.checkSecuencialToSave(this.secuencial,this.datosCliente,connexion,this.arrDatoGeneral);
			
			SecuencialLogicAdditional.updateSecuencialToSave(this.secuencial,this.arrDatoGeneral);
			
			SecuencialLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.secuencial,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarSecuencial(this.secuencial)) {			
				SecuencialDataAccess.save(this.secuencial, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.secuencial,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			SecuencialLogicAdditional.checkSecuencialToSaveAfter(this.secuencial,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.secuencial.getIsDeleted()) {
				this.secuencial=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveSecuencialsWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Secuencial.class.getSimpleName()+"-saveSecuencialsWithConnection");connexion.begin();			
			
			SecuencialLogicAdditional.checkSecuencialToSaves(secuencials,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowSecuencials();
			
			Boolean validadoTodosSecuencial=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(Secuencial secuencialLocal:secuencials) {		
				if(secuencialLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				SecuencialLogicAdditional.updateSecuencialToSave(secuencialLocal,this.arrDatoGeneral);
	        	
				SecuencialLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),secuencialLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarSecuencial(secuencialLocal)) {
					SecuencialDataAccess.save(secuencialLocal, connexion);				
				} else {
					validadoTodosSecuencial=false;
				}
			}
			
			if(!validadoTodosSecuencial) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			SecuencialLogicAdditional.checkSecuencialToSavesAfter(secuencials,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowSecuencials();
			
			connexion.commit();		
			
			this.quitarSecuencialsEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveSecuencials()throws Exception {				
		 try {	
			SecuencialLogicAdditional.checkSecuencialToSaves(secuencials,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosSecuencial=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(Secuencial secuencialLocal:secuencials) {				
				if(secuencialLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				SecuencialLogicAdditional.updateSecuencialToSave(secuencialLocal,this.arrDatoGeneral);
	        	
				SecuencialLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),secuencialLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarSecuencial(secuencialLocal)) {				
					SecuencialDataAccess.save(secuencialLocal, connexion);				
				} else {
					validadoTodosSecuencial=false;
				}
			}
			
			if(!validadoTodosSecuencial) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			SecuencialLogicAdditional.checkSecuencialToSavesAfter(secuencials,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarSecuencialsEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public SecuencialParameterReturnGeneral procesarAccionSecuencials(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<Secuencial> secuencials,SecuencialParameterReturnGeneral secuencialParameterGeneral)throws Exception {
		 try {	
			SecuencialParameterReturnGeneral secuencialReturnGeneral=new SecuencialParameterReturnGeneral();
	
			SecuencialLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,secuencials,secuencialParameterGeneral,secuencialReturnGeneral);
			
			return secuencialReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public SecuencialParameterReturnGeneral procesarAccionSecuencialsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<Secuencial> secuencials,SecuencialParameterReturnGeneral secuencialParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Secuencial.class.getSimpleName()+"-procesarAccionSecuencialsWithConnection");connexion.begin();			
			
			SecuencialParameterReturnGeneral secuencialReturnGeneral=new SecuencialParameterReturnGeneral();
	
			SecuencialLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,secuencials,secuencialParameterGeneral,secuencialReturnGeneral);
			
			this.connexion.commit();
			
			return secuencialReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public SecuencialParameterReturnGeneral procesarEventosSecuencials(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<Secuencial> secuencials,Secuencial secuencial,SecuencialParameterReturnGeneral secuencialParameterGeneral,Boolean isEsNuevoSecuencial,ArrayList<Classe> clases)throws Exception {
		 try {	
			SecuencialParameterReturnGeneral secuencialReturnGeneral=new SecuencialParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				secuencialReturnGeneral.setConRecargarPropiedades(true);
			}
			
			SecuencialLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,secuencials,secuencial,secuencialParameterGeneral,secuencialReturnGeneral,isEsNuevoSecuencial,clases);
			
			return secuencialReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public SecuencialParameterReturnGeneral procesarEventosSecuencialsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<Secuencial> secuencials,Secuencial secuencial,SecuencialParameterReturnGeneral secuencialParameterGeneral,Boolean isEsNuevoSecuencial,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Secuencial.class.getSimpleName()+"-procesarEventosSecuencialsWithConnection");connexion.begin();			
			
			SecuencialParameterReturnGeneral secuencialReturnGeneral=new SecuencialParameterReturnGeneral();
	
			secuencialReturnGeneral.setSecuencial(secuencial);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				secuencialReturnGeneral.setConRecargarPropiedades(true);
			}
			
			SecuencialLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,secuencials,secuencial,secuencialParameterGeneral,secuencialReturnGeneral,isEsNuevoSecuencial,clases);
			
			this.connexion.commit();
			
			return secuencialReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public SecuencialParameterReturnGeneral procesarImportacionSecuencialsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,SecuencialParameterReturnGeneral secuencialParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Secuencial.class.getSimpleName()+"-procesarImportacionSecuencialsWithConnection");connexion.begin();			
			
			SecuencialParameterReturnGeneral secuencialReturnGeneral=new SecuencialParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.secuencials=new ArrayList<Secuencial>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.secuencial=new Secuencial();
				
				
				if(conColumnasBase) {this.secuencial.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.secuencial.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.secuencial.setnumero_asiento(Long.parseLong(arrColumnas[iColumn++]));
				this.secuencial.setnumero_ingreso(Long.parseLong(arrColumnas[iColumn++]));
				this.secuencial.setnumero_egreso(Long.parseLong(arrColumnas[iColumn++]));
				this.secuencial.setnumero_diario(Long.parseLong(arrColumnas[iColumn++]));
				this.secuencial.setnumero_retencion_iva(Long.parseLong(arrColumnas[iColumn++]));
				this.secuencial.setnumero_retencion_fuente(Long.parseLong(arrColumnas[iColumn++]));
				this.secuencial.setnumero_asiento_formato(arrColumnas[iColumn++]);
				this.secuencial.setnumero_ingreso_formato(arrColumnas[iColumn++]);
				this.secuencial.setnumero_egreso_formato(arrColumnas[iColumn++]);
				this.secuencial.setnumero_diario_formato(arrColumnas[iColumn++]);
				this.secuencial.setnumero_retencion_fuente_formato(arrColumnas[iColumn++]);
				this.secuencial.setnumero_retencion_iva_formato(arrColumnas[iColumn++]);
				
				this.secuencials.add(this.secuencial);
			}
			
			this.saveSecuencials();
			
			this.connexion.commit();
			
			secuencialReturnGeneral.setConRetornoEstaProcesado(true);
			secuencialReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return secuencialReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarSecuencialsEliminados() throws Exception {				
		
		List<Secuencial> secuencialsAux= new ArrayList<Secuencial>();
		
		for(Secuencial secuencial:secuencials) {
			if(!secuencial.getIsDeleted()) {
				secuencialsAux.add(secuencial);
			}
		}
		
		secuencials=secuencialsAux;
	}
	
	public void quitarSecuencialsNulos() throws Exception {				
		
		List<Secuencial> secuencialsAux= new ArrayList<Secuencial>();
		
		for(Secuencial secuencial : this.secuencials) {
			if(secuencial==null) {
				secuencialsAux.add(secuencial);
			}
		}
		
		//this.secuencials=secuencialsAux;
		
		this.secuencials.removeAll(secuencialsAux);
	}
	
	public void getSetVersionRowSecuencialWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(secuencial.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((secuencial.getIsDeleted() || (secuencial.getIsChanged()&&!secuencial.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=secuencialDataAccess.getSetVersionRowSecuencial(connexion,secuencial.getId());
				
				if(!secuencial.getVersionRow().equals(timestamp)) {	
					secuencial.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				secuencial.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowSecuencial()throws Exception {	
		
		if(secuencial.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((secuencial.getIsDeleted() || (secuencial.getIsChanged()&&!secuencial.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=secuencialDataAccess.getSetVersionRowSecuencial(connexion,secuencial.getId());
			
			try {							
				if(!secuencial.getVersionRow().equals(timestamp)) {	
					secuencial.setVersionRow(timestamp);
				}
				
				secuencial.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowSecuencialsWithConnection()throws Exception {	
		if(secuencials!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(Secuencial secuencialAux:secuencials) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(secuencialAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(secuencialAux.getIsDeleted() || (secuencialAux.getIsChanged()&&!secuencialAux.getIsNew())) {
						
						timestamp=secuencialDataAccess.getSetVersionRowSecuencial(connexion,secuencialAux.getId());
						
						if(!secuencial.getVersionRow().equals(timestamp)) {	
							secuencialAux.setVersionRow(timestamp);
						}
								
						secuencialAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowSecuencials()throws Exception {	
		if(secuencials!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(Secuencial secuencialAux:secuencials) {
					if(secuencialAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(secuencialAux.getIsDeleted() || (secuencialAux.getIsChanged()&&!secuencialAux.getIsNew())) {
						
						timestamp=secuencialDataAccess.getSetVersionRowSecuencial(connexion,secuencialAux.getId());
						
						if(!secuencialAux.getVersionRow().equals(timestamp)) {	
							secuencialAux.setVersionRow(timestamp);
						}
						
													
						secuencialAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public SecuencialParameterReturnGeneral cargarCombosLoteForeignKeySecuencialWithConnection(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalEjercicio,String finalQueryGlobalPeriodo,String finalQueryGlobalAnio,String finalQueryGlobalMes,String finalQueryGlobalModulo,String finalQueryGlobalTipoMovimientoModulo,String finalQueryGlobalTipoDocumento,String finalQueryGlobalTipoMovimiento) throws Exception {
		SecuencialParameterReturnGeneral  secuencialReturnGeneral =new SecuencialParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Secuencial.class.getSimpleName()+"-cargarCombosLoteForeignKeySecuencialWithConnection");connexion.begin();
			
			secuencialReturnGeneral =new SecuencialParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			secuencialReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			secuencialReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Ejercicio> ejerciciosForeignKey=new ArrayList<Ejercicio>();
			EjercicioLogic ejercicioLogic=new EjercicioLogic();
			ejercicioLogic.setConnexion(this.connexion);
			//ejercicioLogic.getEjercicioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEjercicio.equals("NONE")) {
				ejercicioLogic.getTodosEjercicios(finalQueryGlobalEjercicio,new Pagination());
				ejerciciosForeignKey=ejercicioLogic.getEjercicios();
			}

			secuencialReturnGeneral.setejerciciosForeignKey(ejerciciosForeignKey);


			List<Periodo> periodosForeignKey=new ArrayList<Periodo>();
			PeriodoLogic periodoLogic=new PeriodoLogic();
			periodoLogic.setConnexion(this.connexion);
			//periodoLogic.getPeriodoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPeriodo.equals("NONE")) {
				periodoLogic.getTodosPeriodos(finalQueryGlobalPeriodo,new Pagination());
				periodosForeignKey=periodoLogic.getPeriodos();
			}

			secuencialReturnGeneral.setperiodosForeignKey(periodosForeignKey);


			List<Anio> aniosForeignKey=new ArrayList<Anio>();
			AnioLogic anioLogic=new AnioLogic();
			anioLogic.setConnexion(this.connexion);
			anioLogic.getAnioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalAnio.equals("NONE")) {
				anioLogic.getTodosAnios(finalQueryGlobalAnio,new Pagination());
				aniosForeignKey=anioLogic.getAnios();
			}

			secuencialReturnGeneral.setaniosForeignKey(aniosForeignKey);


			List<Mes> messForeignKey=new ArrayList<Mes>();
			MesLogic mesLogic=new MesLogic();
			mesLogic.setConnexion(this.connexion);
			mesLogic.getMesDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalMes.equals("NONE")) {
				mesLogic.getTodosMess(finalQueryGlobalMes,new Pagination());
				messForeignKey=mesLogic.getMess();
			}

			secuencialReturnGeneral.setmessForeignKey(messForeignKey);


			List<Modulo> modulosForeignKey=new ArrayList<Modulo>();
			ModuloLogic moduloLogic=new ModuloLogic();
			moduloLogic.setConnexion(this.connexion);
			moduloLogic.getModuloDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalModulo.equals("NONE")) {
				moduloLogic.getTodosModulos(finalQueryGlobalModulo,new Pagination());
				modulosForeignKey=moduloLogic.getModulos();
			}

			secuencialReturnGeneral.setmodulosForeignKey(modulosForeignKey);


			List<TipoMovimientoModulo> tipomovimientomodulosForeignKey=new ArrayList<TipoMovimientoModulo>();
			TipoMovimientoModuloLogic tipomovimientomoduloLogic=new TipoMovimientoModuloLogic();
			tipomovimientomoduloLogic.setConnexion(this.connexion);
			tipomovimientomoduloLogic.getTipoMovimientoModuloDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoMovimientoModulo.equals("NONE")) {
				tipomovimientomoduloLogic.getTodosTipoMovimientoModulos(finalQueryGlobalTipoMovimientoModulo,new Pagination());
				tipomovimientomodulosForeignKey=tipomovimientomoduloLogic.getTipoMovimientoModulos();
			}

			secuencialReturnGeneral.settipomovimientomodulosForeignKey(tipomovimientomodulosForeignKey);


			List<TipoDocumento> tipodocumentosForeignKey=new ArrayList<TipoDocumento>();
			TipoDocumentoLogic tipodocumentoLogic=new TipoDocumentoLogic();
			tipodocumentoLogic.setConnexion(this.connexion);
			tipodocumentoLogic.getTipoDocumentoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoDocumento.equals("NONE")) {
				tipodocumentoLogic.getTodosTipoDocumentos(finalQueryGlobalTipoDocumento,new Pagination());
				tipodocumentosForeignKey=tipodocumentoLogic.getTipoDocumentos();
			}

			secuencialReturnGeneral.settipodocumentosForeignKey(tipodocumentosForeignKey);


			List<TipoMovimiento> tipomovimientosForeignKey=new ArrayList<TipoMovimiento>();
			TipoMovimientoLogic tipomovimientoLogic=new TipoMovimientoLogic();
			tipomovimientoLogic.setConnexion(this.connexion);
			tipomovimientoLogic.getTipoMovimientoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoMovimiento.equals("NONE")) {
				tipomovimientoLogic.getTodosTipoMovimientos(finalQueryGlobalTipoMovimiento,new Pagination());
				tipomovimientosForeignKey=tipomovimientoLogic.getTipoMovimientos();
			}

			secuencialReturnGeneral.settipomovimientosForeignKey(tipomovimientosForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return secuencialReturnGeneral;
	}
	
	public SecuencialParameterReturnGeneral cargarCombosLoteForeignKeySecuencial(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalEjercicio,String finalQueryGlobalPeriodo,String finalQueryGlobalAnio,String finalQueryGlobalMes,String finalQueryGlobalModulo,String finalQueryGlobalTipoMovimientoModulo,String finalQueryGlobalTipoDocumento,String finalQueryGlobalTipoMovimiento) throws Exception {
		SecuencialParameterReturnGeneral  secuencialReturnGeneral =new SecuencialParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			secuencialReturnGeneral =new SecuencialParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			secuencialReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			secuencialReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Ejercicio> ejerciciosForeignKey=new ArrayList<Ejercicio>();
			EjercicioLogic ejercicioLogic=new EjercicioLogic();
			ejercicioLogic.setConnexion(this.connexion);
			//ejercicioLogic.getEjercicioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEjercicio.equals("NONE")) {
				ejercicioLogic.getTodosEjercicios(finalQueryGlobalEjercicio,new Pagination());
				ejerciciosForeignKey=ejercicioLogic.getEjercicios();
			}

			secuencialReturnGeneral.setejerciciosForeignKey(ejerciciosForeignKey);


			List<Periodo> periodosForeignKey=new ArrayList<Periodo>();
			PeriodoLogic periodoLogic=new PeriodoLogic();
			periodoLogic.setConnexion(this.connexion);
			//periodoLogic.getPeriodoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPeriodo.equals("NONE")) {
				periodoLogic.getTodosPeriodos(finalQueryGlobalPeriodo,new Pagination());
				periodosForeignKey=periodoLogic.getPeriodos();
			}

			secuencialReturnGeneral.setperiodosForeignKey(periodosForeignKey);


			List<Anio> aniosForeignKey=new ArrayList<Anio>();
			AnioLogic anioLogic=new AnioLogic();
			anioLogic.setConnexion(this.connexion);
			anioLogic.getAnioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalAnio.equals("NONE")) {
				anioLogic.getTodosAnios(finalQueryGlobalAnio,new Pagination());
				aniosForeignKey=anioLogic.getAnios();
			}

			secuencialReturnGeneral.setaniosForeignKey(aniosForeignKey);


			List<Mes> messForeignKey=new ArrayList<Mes>();
			MesLogic mesLogic=new MesLogic();
			mesLogic.setConnexion(this.connexion);
			mesLogic.getMesDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalMes.equals("NONE")) {
				mesLogic.getTodosMess(finalQueryGlobalMes,new Pagination());
				messForeignKey=mesLogic.getMess();
			}

			secuencialReturnGeneral.setmessForeignKey(messForeignKey);


			List<Modulo> modulosForeignKey=new ArrayList<Modulo>();
			ModuloLogic moduloLogic=new ModuloLogic();
			moduloLogic.setConnexion(this.connexion);
			moduloLogic.getModuloDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalModulo.equals("NONE")) {
				moduloLogic.getTodosModulos(finalQueryGlobalModulo,new Pagination());
				modulosForeignKey=moduloLogic.getModulos();
			}

			secuencialReturnGeneral.setmodulosForeignKey(modulosForeignKey);


			List<TipoMovimientoModulo> tipomovimientomodulosForeignKey=new ArrayList<TipoMovimientoModulo>();
			TipoMovimientoModuloLogic tipomovimientomoduloLogic=new TipoMovimientoModuloLogic();
			tipomovimientomoduloLogic.setConnexion(this.connexion);
			tipomovimientomoduloLogic.getTipoMovimientoModuloDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoMovimientoModulo.equals("NONE")) {
				tipomovimientomoduloLogic.getTodosTipoMovimientoModulos(finalQueryGlobalTipoMovimientoModulo,new Pagination());
				tipomovimientomodulosForeignKey=tipomovimientomoduloLogic.getTipoMovimientoModulos();
			}

			secuencialReturnGeneral.settipomovimientomodulosForeignKey(tipomovimientomodulosForeignKey);


			List<TipoDocumento> tipodocumentosForeignKey=new ArrayList<TipoDocumento>();
			TipoDocumentoLogic tipodocumentoLogic=new TipoDocumentoLogic();
			tipodocumentoLogic.setConnexion(this.connexion);
			tipodocumentoLogic.getTipoDocumentoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoDocumento.equals("NONE")) {
				tipodocumentoLogic.getTodosTipoDocumentos(finalQueryGlobalTipoDocumento,new Pagination());
				tipodocumentosForeignKey=tipodocumentoLogic.getTipoDocumentos();
			}

			secuencialReturnGeneral.settipodocumentosForeignKey(tipodocumentosForeignKey);


			List<TipoMovimiento> tipomovimientosForeignKey=new ArrayList<TipoMovimiento>();
			TipoMovimientoLogic tipomovimientoLogic=new TipoMovimientoLogic();
			tipomovimientoLogic.setConnexion(this.connexion);
			tipomovimientoLogic.getTipoMovimientoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoMovimiento.equals("NONE")) {
				tipomovimientoLogic.getTodosTipoMovimientos(finalQueryGlobalTipoMovimiento,new Pagination());
				tipomovimientosForeignKey=tipomovimientoLogic.getTipoMovimientos();
			}

			secuencialReturnGeneral.settipomovimientosForeignKey(tipomovimientosForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return secuencialReturnGeneral;
	}
	
	
	public void deepLoad(Secuencial secuencial,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			SecuencialLogicAdditional.updateSecuencialToGet(secuencial,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		secuencial.setEmpresa(secuencialDataAccess.getEmpresa(connexion,secuencial));
		secuencial.setSucursal(secuencialDataAccess.getSucursal(connexion,secuencial));
		secuencial.setEjercicio(secuencialDataAccess.getEjercicio(connexion,secuencial));
		secuencial.setPeriodo(secuencialDataAccess.getPeriodo(connexion,secuencial));
		secuencial.setAnio(secuencialDataAccess.getAnio(connexion,secuencial));
		secuencial.setMes(secuencialDataAccess.getMes(connexion,secuencial));
		secuencial.setModulo(secuencialDataAccess.getModulo(connexion,secuencial));
		secuencial.setTipoMovimientoModulo(secuencialDataAccess.getTipoMovimientoModulo(connexion,secuencial));
		secuencial.setTipoDocumento(secuencialDataAccess.getTipoDocumento(connexion,secuencial));
		secuencial.setTipoMovimiento(secuencialDataAccess.getTipoMovimiento(connexion,secuencial));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				secuencial.setEmpresa(secuencialDataAccess.getEmpresa(connexion,secuencial));
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				secuencial.setSucursal(secuencialDataAccess.getSucursal(connexion,secuencial));
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				secuencial.setEjercicio(secuencialDataAccess.getEjercicio(connexion,secuencial));
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				secuencial.setPeriodo(secuencialDataAccess.getPeriodo(connexion,secuencial));
				continue;
			}

			if(clas.clas.equals(Anio.class)) {
				secuencial.setAnio(secuencialDataAccess.getAnio(connexion,secuencial));
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				secuencial.setMes(secuencialDataAccess.getMes(connexion,secuencial));
				continue;
			}

			if(clas.clas.equals(Modulo.class)) {
				secuencial.setModulo(secuencialDataAccess.getModulo(connexion,secuencial));
				continue;
			}

			if(clas.clas.equals(TipoMovimientoModulo.class)) {
				secuencial.setTipoMovimientoModulo(secuencialDataAccess.getTipoMovimientoModulo(connexion,secuencial));
				continue;
			}

			if(clas.clas.equals(TipoDocumento.class)) {
				secuencial.setTipoDocumento(secuencialDataAccess.getTipoDocumento(connexion,secuencial));
				continue;
			}

			if(clas.clas.equals(TipoMovimiento.class)) {
				secuencial.setTipoMovimiento(secuencialDataAccess.getTipoMovimiento(connexion,secuencial));
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
			secuencial.setEmpresa(secuencialDataAccess.getEmpresa(connexion,secuencial));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			secuencial.setSucursal(secuencialDataAccess.getSucursal(connexion,secuencial));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Ejercicio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			secuencial.setEjercicio(secuencialDataAccess.getEjercicio(connexion,secuencial));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Periodo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			secuencial.setPeriodo(secuencialDataAccess.getPeriodo(connexion,secuencial));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Anio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			secuencial.setAnio(secuencialDataAccess.getAnio(connexion,secuencial));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Mes.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			secuencial.setMes(secuencialDataAccess.getMes(connexion,secuencial));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Modulo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			secuencial.setModulo(secuencialDataAccess.getModulo(connexion,secuencial));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoMovimientoModulo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			secuencial.setTipoMovimientoModulo(secuencialDataAccess.getTipoMovimientoModulo(connexion,secuencial));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoDocumento.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			secuencial.setTipoDocumento(secuencialDataAccess.getTipoDocumento(connexion,secuencial));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoMovimiento.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			secuencial.setTipoMovimiento(secuencialDataAccess.getTipoMovimiento(connexion,secuencial));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		secuencial.setEmpresa(secuencialDataAccess.getEmpresa(connexion,secuencial));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(secuencial.getEmpresa(),isDeep,deepLoadType,clases);
				
		secuencial.setSucursal(secuencialDataAccess.getSucursal(connexion,secuencial));
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(secuencial.getSucursal(),isDeep,deepLoadType,clases);
				
		secuencial.setEjercicio(secuencialDataAccess.getEjercicio(connexion,secuencial));
		EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
		ejercicioLogic.deepLoad(secuencial.getEjercicio(),isDeep,deepLoadType,clases);
				
		secuencial.setPeriodo(secuencialDataAccess.getPeriodo(connexion,secuencial));
		PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
		periodoLogic.deepLoad(secuencial.getPeriodo(),isDeep,deepLoadType,clases);
				
		secuencial.setAnio(secuencialDataAccess.getAnio(connexion,secuencial));
		AnioLogic anioLogic= new AnioLogic(connexion);
		anioLogic.deepLoad(secuencial.getAnio(),isDeep,deepLoadType,clases);
				
		secuencial.setMes(secuencialDataAccess.getMes(connexion,secuencial));
		MesLogic mesLogic= new MesLogic(connexion);
		mesLogic.deepLoad(secuencial.getMes(),isDeep,deepLoadType,clases);
				
		secuencial.setModulo(secuencialDataAccess.getModulo(connexion,secuencial));
		ModuloLogic moduloLogic= new ModuloLogic(connexion);
		moduloLogic.deepLoad(secuencial.getModulo(),isDeep,deepLoadType,clases);
				
		secuencial.setTipoMovimientoModulo(secuencialDataAccess.getTipoMovimientoModulo(connexion,secuencial));
		TipoMovimientoModuloLogic tipomovimientomoduloLogic= new TipoMovimientoModuloLogic(connexion);
		tipomovimientomoduloLogic.deepLoad(secuencial.getTipoMovimientoModulo(),isDeep,deepLoadType,clases);
				
		secuencial.setTipoDocumento(secuencialDataAccess.getTipoDocumento(connexion,secuencial));
		TipoDocumentoLogic tipodocumentoLogic= new TipoDocumentoLogic(connexion);
		tipodocumentoLogic.deepLoad(secuencial.getTipoDocumento(),isDeep,deepLoadType,clases);
				
		secuencial.setTipoMovimiento(secuencialDataAccess.getTipoMovimiento(connexion,secuencial));
		TipoMovimientoLogic tipomovimientoLogic= new TipoMovimientoLogic(connexion);
		tipomovimientoLogic.deepLoad(secuencial.getTipoMovimiento(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				secuencial.setEmpresa(secuencialDataAccess.getEmpresa(connexion,secuencial));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(secuencial.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				secuencial.setSucursal(secuencialDataAccess.getSucursal(connexion,secuencial));
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepLoad(secuencial.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				secuencial.setEjercicio(secuencialDataAccess.getEjercicio(connexion,secuencial));
				EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
				ejercicioLogic.deepLoad(secuencial.getEjercicio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				secuencial.setPeriodo(secuencialDataAccess.getPeriodo(connexion,secuencial));
				PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
				periodoLogic.deepLoad(secuencial.getPeriodo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Anio.class)) {
				secuencial.setAnio(secuencialDataAccess.getAnio(connexion,secuencial));
				AnioLogic anioLogic= new AnioLogic(connexion);
				anioLogic.deepLoad(secuencial.getAnio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				secuencial.setMes(secuencialDataAccess.getMes(connexion,secuencial));
				MesLogic mesLogic= new MesLogic(connexion);
				mesLogic.deepLoad(secuencial.getMes(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Modulo.class)) {
				secuencial.setModulo(secuencialDataAccess.getModulo(connexion,secuencial));
				ModuloLogic moduloLogic= new ModuloLogic(connexion);
				moduloLogic.deepLoad(secuencial.getModulo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoMovimientoModulo.class)) {
				secuencial.setTipoMovimientoModulo(secuencialDataAccess.getTipoMovimientoModulo(connexion,secuencial));
				TipoMovimientoModuloLogic tipomovimientomoduloLogic= new TipoMovimientoModuloLogic(connexion);
				tipomovimientomoduloLogic.deepLoad(secuencial.getTipoMovimientoModulo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoDocumento.class)) {
				secuencial.setTipoDocumento(secuencialDataAccess.getTipoDocumento(connexion,secuencial));
				TipoDocumentoLogic tipodocumentoLogic= new TipoDocumentoLogic(connexion);
				tipodocumentoLogic.deepLoad(secuencial.getTipoDocumento(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoMovimiento.class)) {
				secuencial.setTipoMovimiento(secuencialDataAccess.getTipoMovimiento(connexion,secuencial));
				TipoMovimientoLogic tipomovimientoLogic= new TipoMovimientoLogic(connexion);
				tipomovimientoLogic.deepLoad(secuencial.getTipoMovimiento(),isDeep,deepLoadType,clases);				
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
			secuencial.setEmpresa(secuencialDataAccess.getEmpresa(connexion,secuencial));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(secuencial.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			secuencial.setSucursal(secuencialDataAccess.getSucursal(connexion,secuencial));
			SucursalLogic sucursalLogic= new SucursalLogic(connexion);
			sucursalLogic.deepLoad(secuencial.getSucursal(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Ejercicio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			secuencial.setEjercicio(secuencialDataAccess.getEjercicio(connexion,secuencial));
			EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
			ejercicioLogic.deepLoad(secuencial.getEjercicio(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Periodo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			secuencial.setPeriodo(secuencialDataAccess.getPeriodo(connexion,secuencial));
			PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
			periodoLogic.deepLoad(secuencial.getPeriodo(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Anio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			secuencial.setAnio(secuencialDataAccess.getAnio(connexion,secuencial));
			AnioLogic anioLogic= new AnioLogic(connexion);
			anioLogic.deepLoad(secuencial.getAnio(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Mes.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			secuencial.setMes(secuencialDataAccess.getMes(connexion,secuencial));
			MesLogic mesLogic= new MesLogic(connexion);
			mesLogic.deepLoad(secuencial.getMes(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Modulo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			secuencial.setModulo(secuencialDataAccess.getModulo(connexion,secuencial));
			ModuloLogic moduloLogic= new ModuloLogic(connexion);
			moduloLogic.deepLoad(secuencial.getModulo(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoMovimientoModulo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			secuencial.setTipoMovimientoModulo(secuencialDataAccess.getTipoMovimientoModulo(connexion,secuencial));
			TipoMovimientoModuloLogic tipomovimientomoduloLogic= new TipoMovimientoModuloLogic(connexion);
			tipomovimientomoduloLogic.deepLoad(secuencial.getTipoMovimientoModulo(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoDocumento.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			secuencial.setTipoDocumento(secuencialDataAccess.getTipoDocumento(connexion,secuencial));
			TipoDocumentoLogic tipodocumentoLogic= new TipoDocumentoLogic(connexion);
			tipodocumentoLogic.deepLoad(secuencial.getTipoDocumento(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoMovimiento.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			secuencial.setTipoMovimiento(secuencialDataAccess.getTipoMovimiento(connexion,secuencial));
			TipoMovimientoLogic tipomovimientoLogic= new TipoMovimientoLogic(connexion);
			tipomovimientoLogic.deepLoad(secuencial.getTipoMovimiento(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(Secuencial secuencial,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			SecuencialLogicAdditional.updateSecuencialToSave(secuencial,this.arrDatoGeneral);
			
SecuencialDataAccess.save(secuencial, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(secuencial.getEmpresa(),connexion);

		SucursalDataAccess.save(secuencial.getSucursal(),connexion);

		EjercicioDataAccess.save(secuencial.getEjercicio(),connexion);

		PeriodoDataAccess.save(secuencial.getPeriodo(),connexion);

		AnioDataAccess.save(secuencial.getAnio(),connexion);

		MesDataAccess.save(secuencial.getMes(),connexion);

		ModuloDataAccess.save(secuencial.getModulo(),connexion);

		TipoMovimientoModuloDataAccess.save(secuencial.getTipoMovimientoModulo(),connexion);

		TipoDocumentoDataAccess.save(secuencial.getTipoDocumento(),connexion);

		TipoMovimientoDataAccess.save(secuencial.getTipoMovimiento(),connexion);
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(secuencial.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(secuencial.getSucursal(),connexion);
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				EjercicioDataAccess.save(secuencial.getEjercicio(),connexion);
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				PeriodoDataAccess.save(secuencial.getPeriodo(),connexion);
				continue;
			}

			if(clas.clas.equals(Anio.class)) {
				AnioDataAccess.save(secuencial.getAnio(),connexion);
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				MesDataAccess.save(secuencial.getMes(),connexion);
				continue;
			}

			if(clas.clas.equals(Modulo.class)) {
				ModuloDataAccess.save(secuencial.getModulo(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoMovimientoModulo.class)) {
				TipoMovimientoModuloDataAccess.save(secuencial.getTipoMovimientoModulo(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoDocumento.class)) {
				TipoDocumentoDataAccess.save(secuencial.getTipoDocumento(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoMovimiento.class)) {
				TipoMovimientoDataAccess.save(secuencial.getTipoMovimiento(),connexion);
				continue;
			}

		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(secuencial.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(secuencial.getEmpresa(),isDeep,deepLoadType,clases);
				

		SucursalDataAccess.save(secuencial.getSucursal(),connexion);
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(secuencial.getSucursal(),isDeep,deepLoadType,clases);
				

		EjercicioDataAccess.save(secuencial.getEjercicio(),connexion);
		EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
		ejercicioLogic.deepLoad(secuencial.getEjercicio(),isDeep,deepLoadType,clases);
				

		PeriodoDataAccess.save(secuencial.getPeriodo(),connexion);
		PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
		periodoLogic.deepLoad(secuencial.getPeriodo(),isDeep,deepLoadType,clases);
				

		AnioDataAccess.save(secuencial.getAnio(),connexion);
		AnioLogic anioLogic= new AnioLogic(connexion);
		anioLogic.deepLoad(secuencial.getAnio(),isDeep,deepLoadType,clases);
				

		MesDataAccess.save(secuencial.getMes(),connexion);
		MesLogic mesLogic= new MesLogic(connexion);
		mesLogic.deepLoad(secuencial.getMes(),isDeep,deepLoadType,clases);
				

		ModuloDataAccess.save(secuencial.getModulo(),connexion);
		ModuloLogic moduloLogic= new ModuloLogic(connexion);
		moduloLogic.deepLoad(secuencial.getModulo(),isDeep,deepLoadType,clases);
				

		TipoMovimientoModuloDataAccess.save(secuencial.getTipoMovimientoModulo(),connexion);
		TipoMovimientoModuloLogic tipomovimientomoduloLogic= new TipoMovimientoModuloLogic(connexion);
		tipomovimientomoduloLogic.deepLoad(secuencial.getTipoMovimientoModulo(),isDeep,deepLoadType,clases);
				

		TipoDocumentoDataAccess.save(secuencial.getTipoDocumento(),connexion);
		TipoDocumentoLogic tipodocumentoLogic= new TipoDocumentoLogic(connexion);
		tipodocumentoLogic.deepLoad(secuencial.getTipoDocumento(),isDeep,deepLoadType,clases);
				

		TipoMovimientoDataAccess.save(secuencial.getTipoMovimiento(),connexion);
		TipoMovimientoLogic tipomovimientoLogic= new TipoMovimientoLogic(connexion);
		tipomovimientoLogic.deepLoad(secuencial.getTipoMovimiento(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(secuencial.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(secuencial.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(secuencial.getSucursal(),connexion);
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepSave(secuencial.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				EjercicioDataAccess.save(secuencial.getEjercicio(),connexion);
				EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
				ejercicioLogic.deepSave(secuencial.getEjercicio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				PeriodoDataAccess.save(secuencial.getPeriodo(),connexion);
				PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
				periodoLogic.deepSave(secuencial.getPeriodo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Anio.class)) {
				AnioDataAccess.save(secuencial.getAnio(),connexion);
				AnioLogic anioLogic= new AnioLogic(connexion);
				anioLogic.deepSave(secuencial.getAnio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				MesDataAccess.save(secuencial.getMes(),connexion);
				MesLogic mesLogic= new MesLogic(connexion);
				mesLogic.deepSave(secuencial.getMes(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Modulo.class)) {
				ModuloDataAccess.save(secuencial.getModulo(),connexion);
				ModuloLogic moduloLogic= new ModuloLogic(connexion);
				moduloLogic.deepSave(secuencial.getModulo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoMovimientoModulo.class)) {
				TipoMovimientoModuloDataAccess.save(secuencial.getTipoMovimientoModulo(),connexion);
				TipoMovimientoModuloLogic tipomovimientomoduloLogic= new TipoMovimientoModuloLogic(connexion);
				tipomovimientomoduloLogic.deepSave(secuencial.getTipoMovimientoModulo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoDocumento.class)) {
				TipoDocumentoDataAccess.save(secuencial.getTipoDocumento(),connexion);
				TipoDocumentoLogic tipodocumentoLogic= new TipoDocumentoLogic(connexion);
				tipodocumentoLogic.deepSave(secuencial.getTipoDocumento(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoMovimiento.class)) {
				TipoMovimientoDataAccess.save(secuencial.getTipoMovimiento(),connexion);
				TipoMovimientoLogic tipomovimientoLogic= new TipoMovimientoLogic(connexion);
				tipomovimientoLogic.deepSave(secuencial.getTipoMovimiento(),isDeep,deepLoadType,clases);				
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
			this.getNewConnexionToDeep(Secuencial.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(secuencial,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				SecuencialConstantesFunciones.refrescarForeignKeysDescripcionesSecuencial(secuencial);
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
			this.deepLoad(this.secuencial,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				SecuencialConstantesFunciones.refrescarForeignKeysDescripcionesSecuencial(this.secuencial);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(Secuencial.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(secuencials!=null) {
				for(Secuencial secuencial:secuencials) {
					this.deepLoad(secuencial,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					SecuencialConstantesFunciones.refrescarForeignKeysDescripcionesSecuencial(secuencials);
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
			if(secuencials!=null) {
				for(Secuencial secuencial:secuencials) {
					this.deepLoad(secuencial,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					SecuencialConstantesFunciones.refrescarForeignKeysDescripcionesSecuencial(secuencials);
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
			this.getNewConnexionToDeep(Secuencial.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(secuencial,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(Secuencial.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(secuencials!=null) {
				for(Secuencial secuencial:secuencials) {
					this.deepSave(secuencial,isDeep,deepLoadType,clases);
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
			if(secuencials!=null) {
				for(Secuencial secuencial:secuencials) {
					this.deepSave(secuencial,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getSecuencialsBusquedaPorEjercicioPorModuloPorMovimientoWithConnection(String sFinalQuery,Pagination pagination,Long id_modulo,Long id_ejercicio,Long id_tipo_movimiento_modulo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Secuencial.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidModulo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidModulo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_modulo,SecuencialConstantesFunciones.IDMODULO,ParameterTypeOperator.AND);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidModulo);

			ParameterSelectionGeneral parameterSelectionGeneralidEjercicio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEjercicio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_ejercicio,SecuencialConstantesFunciones.IDEJERCICIO,ParameterTypeOperator.AND);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEjercicio);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoMovimientoModulo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoMovimientoModulo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_movimiento_modulo,SecuencialConstantesFunciones.IDTIPOMOVIMIENTOMODULO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoMovimientoModulo);

			SecuencialLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorEjercicioPorModuloPorMovimiento","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			secuencials=secuencialDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				SecuencialConstantesFunciones.refrescarForeignKeysDescripcionesSecuencial(this.secuencials);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getSecuencialsBusquedaPorEjercicioPorModuloPorMovimiento(String sFinalQuery,Pagination pagination,Long id_modulo,Long id_ejercicio,Long id_tipo_movimiento_modulo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidModulo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidModulo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_modulo,SecuencialConstantesFunciones.IDMODULO,ParameterTypeOperator.AND);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidModulo);

			ParameterSelectionGeneral parameterSelectionGeneralidEjercicio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEjercicio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_ejercicio,SecuencialConstantesFunciones.IDEJERCICIO,ParameterTypeOperator.AND);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEjercicio);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoMovimientoModulo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoMovimientoModulo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_movimiento_modulo,SecuencialConstantesFunciones.IDTIPOMOVIMIENTOMODULO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoMovimientoModulo);

			SecuencialLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorEjercicioPorModuloPorMovimiento","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			secuencials=secuencialDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				SecuencialConstantesFunciones.refrescarForeignKeysDescripcionesSecuencial(this.secuencials);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getSecuencialsFK_IdAnioWithConnection(String sFinalQuery,Pagination pagination,Long id_anio)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Secuencial.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidAnio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidAnio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_anio,SecuencialConstantesFunciones.IDANIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidAnio);

			SecuencialLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdAnio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			secuencials=secuencialDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				SecuencialConstantesFunciones.refrescarForeignKeysDescripcionesSecuencial(this.secuencials);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getSecuencialsFK_IdAnio(String sFinalQuery,Pagination pagination,Long id_anio)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidAnio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidAnio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_anio,SecuencialConstantesFunciones.IDANIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidAnio);

			SecuencialLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdAnio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			secuencials=secuencialDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				SecuencialConstantesFunciones.refrescarForeignKeysDescripcionesSecuencial(this.secuencials);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getSecuencialsFK_IdEjercicioWithConnection(String sFinalQuery,Pagination pagination,Long id_ejercicio)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Secuencial.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEjercicio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEjercicio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_ejercicio,SecuencialConstantesFunciones.IDEJERCICIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEjercicio);

			SecuencialLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEjercicio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			secuencials=secuencialDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				SecuencialConstantesFunciones.refrescarForeignKeysDescripcionesSecuencial(this.secuencials);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getSecuencialsFK_IdEjercicio(String sFinalQuery,Pagination pagination,Long id_ejercicio)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEjercicio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEjercicio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_ejercicio,SecuencialConstantesFunciones.IDEJERCICIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEjercicio);

			SecuencialLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEjercicio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			secuencials=secuencialDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				SecuencialConstantesFunciones.refrescarForeignKeysDescripcionesSecuencial(this.secuencials);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getSecuencialsFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Secuencial.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,SecuencialConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			SecuencialLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			secuencials=secuencialDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				SecuencialConstantesFunciones.refrescarForeignKeysDescripcionesSecuencial(this.secuencials);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getSecuencialsFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,SecuencialConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			SecuencialLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			secuencials=secuencialDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				SecuencialConstantesFunciones.refrescarForeignKeysDescripcionesSecuencial(this.secuencials);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getSecuencialsFK_IdMesWithConnection(String sFinalQuery,Pagination pagination,Long id_mes)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Secuencial.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidMes= new ParameterSelectionGeneral();
			parameterSelectionGeneralidMes.setParameterSelectionGeneralEqual(ParameterType.LONG,id_mes,SecuencialConstantesFunciones.IDMES,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidMes);

			SecuencialLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdMes","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			secuencials=secuencialDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				SecuencialConstantesFunciones.refrescarForeignKeysDescripcionesSecuencial(this.secuencials);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getSecuencialsFK_IdMes(String sFinalQuery,Pagination pagination,Long id_mes)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidMes= new ParameterSelectionGeneral();
			parameterSelectionGeneralidMes.setParameterSelectionGeneralEqual(ParameterType.LONG,id_mes,SecuencialConstantesFunciones.IDMES,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidMes);

			SecuencialLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdMes","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			secuencials=secuencialDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				SecuencialConstantesFunciones.refrescarForeignKeysDescripcionesSecuencial(this.secuencials);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getSecuencialsFK_IdModuloWithConnection(String sFinalQuery,Pagination pagination,Long id_modulo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Secuencial.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidModulo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidModulo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_modulo,SecuencialConstantesFunciones.IDMODULO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidModulo);

			SecuencialLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdModulo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			secuencials=secuencialDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				SecuencialConstantesFunciones.refrescarForeignKeysDescripcionesSecuencial(this.secuencials);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getSecuencialsFK_IdModulo(String sFinalQuery,Pagination pagination,Long id_modulo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidModulo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidModulo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_modulo,SecuencialConstantesFunciones.IDMODULO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidModulo);

			SecuencialLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdModulo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			secuencials=secuencialDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				SecuencialConstantesFunciones.refrescarForeignKeysDescripcionesSecuencial(this.secuencials);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getSecuencialsFK_IdPeriodoWithConnection(String sFinalQuery,Pagination pagination,Long id_periodo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Secuencial.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPeriodo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPeriodo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_periodo,SecuencialConstantesFunciones.IDPERIODO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPeriodo);

			SecuencialLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPeriodo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			secuencials=secuencialDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				SecuencialConstantesFunciones.refrescarForeignKeysDescripcionesSecuencial(this.secuencials);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getSecuencialsFK_IdPeriodo(String sFinalQuery,Pagination pagination,Long id_periodo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPeriodo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPeriodo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_periodo,SecuencialConstantesFunciones.IDPERIODO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPeriodo);

			SecuencialLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPeriodo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			secuencials=secuencialDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				SecuencialConstantesFunciones.refrescarForeignKeysDescripcionesSecuencial(this.secuencials);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getSecuencialsFK_IdSucursalWithConnection(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Secuencial.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,SecuencialConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			SecuencialLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			secuencials=secuencialDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				SecuencialConstantesFunciones.refrescarForeignKeysDescripcionesSecuencial(this.secuencials);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getSecuencialsFK_IdSucursal(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,SecuencialConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			SecuencialLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			secuencials=secuencialDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				SecuencialConstantesFunciones.refrescarForeignKeysDescripcionesSecuencial(this.secuencials);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getSecuencialsFK_IdTipoDocumentoWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_documento)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Secuencial.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoDocumento= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoDocumento.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_documento,SecuencialConstantesFunciones.IDTIPODOCUMENTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoDocumento);

			SecuencialLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoDocumento","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			secuencials=secuencialDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				SecuencialConstantesFunciones.refrescarForeignKeysDescripcionesSecuencial(this.secuencials);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getSecuencialsFK_IdTipoDocumento(String sFinalQuery,Pagination pagination,Long id_tipo_documento)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoDocumento= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoDocumento.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_documento,SecuencialConstantesFunciones.IDTIPODOCUMENTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoDocumento);

			SecuencialLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoDocumento","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			secuencials=secuencialDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				SecuencialConstantesFunciones.refrescarForeignKeysDescripcionesSecuencial(this.secuencials);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getSecuencialsFK_IdTipoMovimientoWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_movimiento)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Secuencial.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoMovimiento= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoMovimiento.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_movimiento,SecuencialConstantesFunciones.IDTIPOMOVIMIENTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoMovimiento);

			SecuencialLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoMovimiento","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			secuencials=secuencialDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				SecuencialConstantesFunciones.refrescarForeignKeysDescripcionesSecuencial(this.secuencials);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getSecuencialsFK_IdTipoMovimiento(String sFinalQuery,Pagination pagination,Long id_tipo_movimiento)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoMovimiento= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoMovimiento.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_movimiento,SecuencialConstantesFunciones.IDTIPOMOVIMIENTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoMovimiento);

			SecuencialLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoMovimiento","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			secuencials=secuencialDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				SecuencialConstantesFunciones.refrescarForeignKeysDescripcionesSecuencial(this.secuencials);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getSecuencialsFK_IdTipoMovimientoModuloWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_movimiento_modulo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Secuencial.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoMovimientoModulo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoMovimientoModulo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_movimiento_modulo,SecuencialConstantesFunciones.IDTIPOMOVIMIENTOMODULO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoMovimientoModulo);

			SecuencialLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoMovimientoModulo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			secuencials=secuencialDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				SecuencialConstantesFunciones.refrescarForeignKeysDescripcionesSecuencial(this.secuencials);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getSecuencialsFK_IdTipoMovimientoModulo(String sFinalQuery,Pagination pagination,Long id_tipo_movimiento_modulo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoMovimientoModulo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoMovimientoModulo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_movimiento_modulo,SecuencialConstantesFunciones.IDTIPOMOVIMIENTOMODULO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoMovimientoModulo);

			SecuencialLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoMovimientoModulo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			secuencials=secuencialDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				SecuencialConstantesFunciones.refrescarForeignKeysDescripcionesSecuencial(this.secuencials);
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
			if(SecuencialConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,SecuencialDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,Secuencial secuencial,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(SecuencialConstantesFunciones.ISCONAUDITORIA) {
				if(secuencial.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,SecuencialDataAccess.TABLENAME, secuencial.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(SecuencialConstantesFunciones.ISCONAUDITORIADETALLE) {
						////SecuencialLogic.registrarAuditoriaDetallesSecuencial(connexion,secuencial,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(secuencial.getIsDeleted()) {
					/*if(!secuencial.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,SecuencialDataAccess.TABLENAME, secuencial.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////SecuencialLogic.registrarAuditoriaDetallesSecuencial(connexion,secuencial,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,SecuencialDataAccess.TABLENAME, secuencial.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(secuencial.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,SecuencialDataAccess.TABLENAME, secuencial.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(SecuencialConstantesFunciones.ISCONAUDITORIADETALLE) {
						////SecuencialLogic.registrarAuditoriaDetallesSecuencial(connexion,secuencial,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesSecuencial(Connexion connexion,Secuencial secuencial)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(secuencial.getIsNew()||!secuencial.getid_empresa().equals(secuencial.getSecuencialOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(secuencial.getSecuencialOriginal().getid_empresa()!=null)
				{
					strValorActual=secuencial.getSecuencialOriginal().getid_empresa().toString();
				}
				if(secuencial.getid_empresa()!=null)
				{
					strValorNuevo=secuencial.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),SecuencialConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(secuencial.getIsNew()||!secuencial.getid_sucursal().equals(secuencial.getSecuencialOriginal().getid_sucursal()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(secuencial.getSecuencialOriginal().getid_sucursal()!=null)
				{
					strValorActual=secuencial.getSecuencialOriginal().getid_sucursal().toString();
				}
				if(secuencial.getid_sucursal()!=null)
				{
					strValorNuevo=secuencial.getid_sucursal().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),SecuencialConstantesFunciones.IDSUCURSAL,strValorActual,strValorNuevo);
			}	
			
			if(secuencial.getIsNew()||!secuencial.getid_ejercicio().equals(secuencial.getSecuencialOriginal().getid_ejercicio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(secuencial.getSecuencialOriginal().getid_ejercicio()!=null)
				{
					strValorActual=secuencial.getSecuencialOriginal().getid_ejercicio().toString();
				}
				if(secuencial.getid_ejercicio()!=null)
				{
					strValorNuevo=secuencial.getid_ejercicio().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),SecuencialConstantesFunciones.IDEJERCICIO,strValorActual,strValorNuevo);
			}	
			
			if(secuencial.getIsNew()||!secuencial.getid_periodo().equals(secuencial.getSecuencialOriginal().getid_periodo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(secuencial.getSecuencialOriginal().getid_periodo()!=null)
				{
					strValorActual=secuencial.getSecuencialOriginal().getid_periodo().toString();
				}
				if(secuencial.getid_periodo()!=null)
				{
					strValorNuevo=secuencial.getid_periodo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),SecuencialConstantesFunciones.IDPERIODO,strValorActual,strValorNuevo);
			}	
			
			if(secuencial.getIsNew()||!secuencial.getid_anio().equals(secuencial.getSecuencialOriginal().getid_anio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(secuencial.getSecuencialOriginal().getid_anio()!=null)
				{
					strValorActual=secuencial.getSecuencialOriginal().getid_anio().toString();
				}
				if(secuencial.getid_anio()!=null)
				{
					strValorNuevo=secuencial.getid_anio().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),SecuencialConstantesFunciones.IDANIO,strValorActual,strValorNuevo);
			}	
			
			if(secuencial.getIsNew()||!secuencial.getid_mes().equals(secuencial.getSecuencialOriginal().getid_mes()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(secuencial.getSecuencialOriginal().getid_mes()!=null)
				{
					strValorActual=secuencial.getSecuencialOriginal().getid_mes().toString();
				}
				if(secuencial.getid_mes()!=null)
				{
					strValorNuevo=secuencial.getid_mes().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),SecuencialConstantesFunciones.IDMES,strValorActual,strValorNuevo);
			}	
			
			if(secuencial.getIsNew()||!secuencial.getid_modulo().equals(secuencial.getSecuencialOriginal().getid_modulo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(secuencial.getSecuencialOriginal().getid_modulo()!=null)
				{
					strValorActual=secuencial.getSecuencialOriginal().getid_modulo().toString();
				}
				if(secuencial.getid_modulo()!=null)
				{
					strValorNuevo=secuencial.getid_modulo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),SecuencialConstantesFunciones.IDMODULO,strValorActual,strValorNuevo);
			}	
			
			if(secuencial.getIsNew()||!secuencial.getid_tipo_movimiento_modulo().equals(secuencial.getSecuencialOriginal().getid_tipo_movimiento_modulo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(secuencial.getSecuencialOriginal().getid_tipo_movimiento_modulo()!=null)
				{
					strValorActual=secuencial.getSecuencialOriginal().getid_tipo_movimiento_modulo().toString();
				}
				if(secuencial.getid_tipo_movimiento_modulo()!=null)
				{
					strValorNuevo=secuencial.getid_tipo_movimiento_modulo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),SecuencialConstantesFunciones.IDTIPOMOVIMIENTOMODULO,strValorActual,strValorNuevo);
			}	
			
			if(secuencial.getIsNew()||!secuencial.getid_tipo_documento().equals(secuencial.getSecuencialOriginal().getid_tipo_documento()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(secuencial.getSecuencialOriginal().getid_tipo_documento()!=null)
				{
					strValorActual=secuencial.getSecuencialOriginal().getid_tipo_documento().toString();
				}
				if(secuencial.getid_tipo_documento()!=null)
				{
					strValorNuevo=secuencial.getid_tipo_documento().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),SecuencialConstantesFunciones.IDTIPODOCUMENTO,strValorActual,strValorNuevo);
			}	
			
			if(secuencial.getIsNew()||!secuencial.getid_tipo_movimiento().equals(secuencial.getSecuencialOriginal().getid_tipo_movimiento()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(secuencial.getSecuencialOriginal().getid_tipo_movimiento()!=null)
				{
					strValorActual=secuencial.getSecuencialOriginal().getid_tipo_movimiento().toString();
				}
				if(secuencial.getid_tipo_movimiento()!=null)
				{
					strValorNuevo=secuencial.getid_tipo_movimiento().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),SecuencialConstantesFunciones.IDTIPOMOVIMIENTO,strValorActual,strValorNuevo);
			}	
			
			if(secuencial.getIsNew()||!secuencial.getnumero_asiento().equals(secuencial.getSecuencialOriginal().getnumero_asiento()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(secuencial.getSecuencialOriginal().getnumero_asiento()!=null)
				{
					strValorActual=secuencial.getSecuencialOriginal().getnumero_asiento().toString();
				}
				if(secuencial.getnumero_asiento()!=null)
				{
					strValorNuevo=secuencial.getnumero_asiento().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),SecuencialConstantesFunciones.NUMEROASIENTO,strValorActual,strValorNuevo);
			}	
			
			if(secuencial.getIsNew()||!secuencial.getnumero_ingreso().equals(secuencial.getSecuencialOriginal().getnumero_ingreso()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(secuencial.getSecuencialOriginal().getnumero_ingreso()!=null)
				{
					strValorActual=secuencial.getSecuencialOriginal().getnumero_ingreso().toString();
				}
				if(secuencial.getnumero_ingreso()!=null)
				{
					strValorNuevo=secuencial.getnumero_ingreso().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),SecuencialConstantesFunciones.NUMEROINGRESO,strValorActual,strValorNuevo);
			}	
			
			if(secuencial.getIsNew()||!secuencial.getnumero_egreso().equals(secuencial.getSecuencialOriginal().getnumero_egreso()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(secuencial.getSecuencialOriginal().getnumero_egreso()!=null)
				{
					strValorActual=secuencial.getSecuencialOriginal().getnumero_egreso().toString();
				}
				if(secuencial.getnumero_egreso()!=null)
				{
					strValorNuevo=secuencial.getnumero_egreso().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),SecuencialConstantesFunciones.NUMEROEGRESO,strValorActual,strValorNuevo);
			}	
			
			if(secuencial.getIsNew()||!secuencial.getnumero_diario().equals(secuencial.getSecuencialOriginal().getnumero_diario()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(secuencial.getSecuencialOriginal().getnumero_diario()!=null)
				{
					strValorActual=secuencial.getSecuencialOriginal().getnumero_diario().toString();
				}
				if(secuencial.getnumero_diario()!=null)
				{
					strValorNuevo=secuencial.getnumero_diario().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),SecuencialConstantesFunciones.NUMERODIARIO,strValorActual,strValorNuevo);
			}	
			
			if(secuencial.getIsNew()||!secuencial.getnumero_retencion_iva().equals(secuencial.getSecuencialOriginal().getnumero_retencion_iva()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(secuencial.getSecuencialOriginal().getnumero_retencion_iva()!=null)
				{
					strValorActual=secuencial.getSecuencialOriginal().getnumero_retencion_iva().toString();
				}
				if(secuencial.getnumero_retencion_iva()!=null)
				{
					strValorNuevo=secuencial.getnumero_retencion_iva().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),SecuencialConstantesFunciones.NUMERORETENCIONIVA,strValorActual,strValorNuevo);
			}	
			
			if(secuencial.getIsNew()||!secuencial.getnumero_retencion_fuente().equals(secuencial.getSecuencialOriginal().getnumero_retencion_fuente()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(secuencial.getSecuencialOriginal().getnumero_retencion_fuente()!=null)
				{
					strValorActual=secuencial.getSecuencialOriginal().getnumero_retencion_fuente().toString();
				}
				if(secuencial.getnumero_retencion_fuente()!=null)
				{
					strValorNuevo=secuencial.getnumero_retencion_fuente().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),SecuencialConstantesFunciones.NUMERORETENCIONFUENTE,strValorActual,strValorNuevo);
			}	
			
			if(secuencial.getIsNew()||!secuencial.getnumero_asiento_formato().equals(secuencial.getSecuencialOriginal().getnumero_asiento_formato()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(secuencial.getSecuencialOriginal().getnumero_asiento_formato()!=null)
				{
					strValorActual=secuencial.getSecuencialOriginal().getnumero_asiento_formato();
				}
				if(secuencial.getnumero_asiento_formato()!=null)
				{
					strValorNuevo=secuencial.getnumero_asiento_formato() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),SecuencialConstantesFunciones.NUMEROASIENTOFORMATO,strValorActual,strValorNuevo);
			}	
			
			if(secuencial.getIsNew()||!secuencial.getnumero_ingreso_formato().equals(secuencial.getSecuencialOriginal().getnumero_ingreso_formato()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(secuencial.getSecuencialOriginal().getnumero_ingreso_formato()!=null)
				{
					strValorActual=secuencial.getSecuencialOriginal().getnumero_ingreso_formato();
				}
				if(secuencial.getnumero_ingreso_formato()!=null)
				{
					strValorNuevo=secuencial.getnumero_ingreso_formato() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),SecuencialConstantesFunciones.NUMEROINGRESOFORMATO,strValorActual,strValorNuevo);
			}	
			
			if(secuencial.getIsNew()||!secuencial.getnumero_egreso_formato().equals(secuencial.getSecuencialOriginal().getnumero_egreso_formato()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(secuencial.getSecuencialOriginal().getnumero_egreso_formato()!=null)
				{
					strValorActual=secuencial.getSecuencialOriginal().getnumero_egreso_formato();
				}
				if(secuencial.getnumero_egreso_formato()!=null)
				{
					strValorNuevo=secuencial.getnumero_egreso_formato() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),SecuencialConstantesFunciones.NUMEROEGRESOFORMATO,strValorActual,strValorNuevo);
			}	
			
			if(secuencial.getIsNew()||!secuencial.getnumero_diario_formato().equals(secuencial.getSecuencialOriginal().getnumero_diario_formato()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(secuencial.getSecuencialOriginal().getnumero_diario_formato()!=null)
				{
					strValorActual=secuencial.getSecuencialOriginal().getnumero_diario_formato();
				}
				if(secuencial.getnumero_diario_formato()!=null)
				{
					strValorNuevo=secuencial.getnumero_diario_formato() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),SecuencialConstantesFunciones.NUMERODIARIOFORMATO,strValorActual,strValorNuevo);
			}	
			
			if(secuencial.getIsNew()||!secuencial.getnumero_retencion_fuente_formato().equals(secuencial.getSecuencialOriginal().getnumero_retencion_fuente_formato()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(secuencial.getSecuencialOriginal().getnumero_retencion_fuente_formato()!=null)
				{
					strValorActual=secuencial.getSecuencialOriginal().getnumero_retencion_fuente_formato();
				}
				if(secuencial.getnumero_retencion_fuente_formato()!=null)
				{
					strValorNuevo=secuencial.getnumero_retencion_fuente_formato() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),SecuencialConstantesFunciones.NUMERORETENCIONFUENTEFORMATO,strValorActual,strValorNuevo);
			}	
			
			if(secuencial.getIsNew()||!secuencial.getnumero_retencion_iva_formato().equals(secuencial.getSecuencialOriginal().getnumero_retencion_iva_formato()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(secuencial.getSecuencialOriginal().getnumero_retencion_iva_formato()!=null)
				{
					strValorActual=secuencial.getSecuencialOriginal().getnumero_retencion_iva_formato();
				}
				if(secuencial.getnumero_retencion_iva_formato()!=null)
				{
					strValorNuevo=secuencial.getnumero_retencion_iva_formato() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),SecuencialConstantesFunciones.NUMERORETENCIONIVAFORMATO,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveSecuencialRelacionesWithConnection(Secuencial secuencial) throws Exception {

		if(!secuencial.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveSecuencialRelacionesBase(secuencial,true);
		}
	}

	public void saveSecuencialRelaciones(Secuencial secuencial)throws Exception {

		if(!secuencial.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveSecuencialRelacionesBase(secuencial,false);
		}
	}

	public void saveSecuencialRelacionesBase(Secuencial secuencial,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("Secuencial-saveRelacionesWithConnection");}
	

			this.setSecuencial(secuencial);

			if(SecuencialLogicAdditional.validarSaveRelaciones(secuencial,this)) {

				SecuencialLogicAdditional.updateRelacionesToSave(secuencial,this);

				if((secuencial.getIsNew()||secuencial.getIsChanged())&&!secuencial.getIsDeleted()) {
					this.saveSecuencial();
					this.saveSecuencialRelacionesDetalles();

				} else if(secuencial.getIsDeleted()) {
					this.saveSecuencialRelacionesDetalles();
					this.saveSecuencial();
				}

				SecuencialLogicAdditional.updateRelacionesToSaveAfter(secuencial,this);

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
	
	
	private void saveSecuencialRelacionesDetalles()throws Exception {
		try {
	

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfSecuencial(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=SecuencialConstantesFunciones.getClassesForeignKeysOfSecuencial(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfSecuencial(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=SecuencialConstantesFunciones.getClassesRelationshipsOfSecuencial(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

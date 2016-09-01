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
import com.bydan.erp.nomina.util.SolicitudReemplazoConstantesFunciones;
import com.bydan.erp.nomina.util.SolicitudReemplazoParameterReturnGeneral;
//import com.bydan.erp.nomina.util.SolicitudReemplazoParameterGeneral;
import com.bydan.erp.nomina.business.entity.SolicitudReemplazo;
import com.bydan.erp.nomina.business.logic.SolicitudReemplazoLogicAdditional;
import com.bydan.erp.nomina.business.dataaccess.*;
import com.bydan.erp.nomina.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;


import com.bydan.erp.seguridad.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;








@SuppressWarnings("unused")
public class SolicitudReemplazoLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(SolicitudReemplazoLogic.class);
	
	protected SolicitudReemplazoDataAccess solicitudreemplazoDataAccess; 	
	protected SolicitudReemplazo solicitudreemplazo;
	protected List<SolicitudReemplazo> solicitudreemplazos;
	protected Object solicitudreemplazoObject;	
	protected List<Object> solicitudreemplazosObject;
	
	public static ClassValidator<SolicitudReemplazo> solicitudreemplazoValidator = new ClassValidator<SolicitudReemplazo>(SolicitudReemplazo.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected SolicitudReemplazoLogicAdditional solicitudreemplazoLogicAdditional=null;
	
	public SolicitudReemplazoLogicAdditional getSolicitudReemplazoLogicAdditional() {
		return this.solicitudreemplazoLogicAdditional;
	}
	
	public void setSolicitudReemplazoLogicAdditional(SolicitudReemplazoLogicAdditional solicitudreemplazoLogicAdditional) {
		try {
			this.solicitudreemplazoLogicAdditional=solicitudreemplazoLogicAdditional;
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
	
	
	
	
	public  SolicitudReemplazoLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.solicitudreemplazoDataAccess = new SolicitudReemplazoDataAccess();
			
			this.solicitudreemplazos= new ArrayList<SolicitudReemplazo>();
			this.solicitudreemplazo= new SolicitudReemplazo();
			
			this.solicitudreemplazoObject=new Object();
			this.solicitudreemplazosObject=new ArrayList<Object>();
				
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
			
			this.solicitudreemplazoDataAccess.setConnexionType(this.connexionType);
			this.solicitudreemplazoDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  SolicitudReemplazoLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.solicitudreemplazoDataAccess = new SolicitudReemplazoDataAccess();
			this.solicitudreemplazos= new ArrayList<SolicitudReemplazo>();
			this.solicitudreemplazo= new SolicitudReemplazo();
			this.solicitudreemplazoObject=new Object();
			this.solicitudreemplazosObject=new ArrayList<Object>();
			
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
			
			this.solicitudreemplazoDataAccess.setConnexionType(this.connexionType);
			this.solicitudreemplazoDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public SolicitudReemplazo getSolicitudReemplazo() throws Exception {	
		SolicitudReemplazoLogicAdditional.checkSolicitudReemplazoToGet(solicitudreemplazo,this.datosCliente,this.arrDatoGeneral);
		SolicitudReemplazoLogicAdditional.updateSolicitudReemplazoToGet(solicitudreemplazo,this.arrDatoGeneral);
		
		return solicitudreemplazo;
	}
		
	public void setSolicitudReemplazo(SolicitudReemplazo newSolicitudReemplazo) {
		this.solicitudreemplazo = newSolicitudReemplazo;
	}
	
	public SolicitudReemplazoDataAccess getSolicitudReemplazoDataAccess() {
		return solicitudreemplazoDataAccess;
	}
	
	public void setSolicitudReemplazoDataAccess(SolicitudReemplazoDataAccess newsolicitudreemplazoDataAccess) {
		this.solicitudreemplazoDataAccess = newsolicitudreemplazoDataAccess;
	}
	
	public List<SolicitudReemplazo> getSolicitudReemplazos() throws Exception {		
		this.quitarSolicitudReemplazosNulos();
		
		SolicitudReemplazoLogicAdditional.checkSolicitudReemplazoToGets(solicitudreemplazos,this.datosCliente,this.arrDatoGeneral);
		
		for (SolicitudReemplazo solicitudreemplazoLocal: solicitudreemplazos ) {
			SolicitudReemplazoLogicAdditional.updateSolicitudReemplazoToGet(solicitudreemplazoLocal,this.arrDatoGeneral);
		}
		
		return solicitudreemplazos;
	}
	
	public void setSolicitudReemplazos(List<SolicitudReemplazo> newSolicitudReemplazos) {
		this.solicitudreemplazos = newSolicitudReemplazos;
	}
	
	public Object getSolicitudReemplazoObject() {	
		this.solicitudreemplazoObject=this.solicitudreemplazoDataAccess.getEntityObject();
		return this.solicitudreemplazoObject;
	}
		
	public void setSolicitudReemplazoObject(Object newSolicitudReemplazoObject) {
		this.solicitudreemplazoObject = newSolicitudReemplazoObject;
	}
	
	public List<Object> getSolicitudReemplazosObject() {		
		this.solicitudreemplazosObject=this.solicitudreemplazoDataAccess.getEntitiesObject();
		return this.solicitudreemplazosObject;
	}
		
	public void setSolicitudReemplazosObject(List<Object> newSolicitudReemplazosObject) {
		this.solicitudreemplazosObject = newSolicitudReemplazosObject;
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
		
		if(this.solicitudreemplazoDataAccess!=null) {
			this.solicitudreemplazoDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SolicitudReemplazo.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			solicitudreemplazoDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			solicitudreemplazoDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		solicitudreemplazo = new  SolicitudReemplazo();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SolicitudReemplazo.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			solicitudreemplazo=solicitudreemplazoDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.solicitudreemplazo,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				SolicitudReemplazoConstantesFunciones.refrescarForeignKeysDescripcionesSolicitudReemplazo(this.solicitudreemplazo);
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
		solicitudreemplazo = new  SolicitudReemplazo();
		  		  
        try {
			
			solicitudreemplazo=solicitudreemplazoDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.solicitudreemplazo,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				SolicitudReemplazoConstantesFunciones.refrescarForeignKeysDescripcionesSolicitudReemplazo(this.solicitudreemplazo);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		solicitudreemplazo = new  SolicitudReemplazo();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SolicitudReemplazo.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			solicitudreemplazo=solicitudreemplazoDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.solicitudreemplazo,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				SolicitudReemplazoConstantesFunciones.refrescarForeignKeysDescripcionesSolicitudReemplazo(this.solicitudreemplazo);
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
		solicitudreemplazo = new  SolicitudReemplazo();
		  		  
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
		solicitudreemplazo = new  SolicitudReemplazo();
		  		  
        try {
			
			solicitudreemplazo=solicitudreemplazoDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.solicitudreemplazo,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				SolicitudReemplazoConstantesFunciones.refrescarForeignKeysDescripcionesSolicitudReemplazo(this.solicitudreemplazo);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		solicitudreemplazo = new  SolicitudReemplazo();
		  		  
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
		solicitudreemplazo = new  SolicitudReemplazo();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SolicitudReemplazo.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =solicitudreemplazoDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		solicitudreemplazo = new  SolicitudReemplazo();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=solicitudreemplazoDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		solicitudreemplazo = new  SolicitudReemplazo();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SolicitudReemplazo.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =solicitudreemplazoDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		solicitudreemplazo = new  SolicitudReemplazo();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=solicitudreemplazoDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		solicitudreemplazo = new  SolicitudReemplazo();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SolicitudReemplazo.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =solicitudreemplazoDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		solicitudreemplazo = new  SolicitudReemplazo();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=solicitudreemplazoDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		solicitudreemplazos = new  ArrayList<SolicitudReemplazo>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SolicitudReemplazo.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			SolicitudReemplazoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			solicitudreemplazos=solicitudreemplazoDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarSolicitudReemplazo(solicitudreemplazos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				SolicitudReemplazoConstantesFunciones.refrescarForeignKeysDescripcionesSolicitudReemplazo(this.solicitudreemplazos);
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
		solicitudreemplazos = new  ArrayList<SolicitudReemplazo>();
		  		  
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
		solicitudreemplazos = new  ArrayList<SolicitudReemplazo>();
		  		  
        try {			
			SolicitudReemplazoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			solicitudreemplazos=solicitudreemplazoDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarSolicitudReemplazo(solicitudreemplazos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				SolicitudReemplazoConstantesFunciones.refrescarForeignKeysDescripcionesSolicitudReemplazo(this.solicitudreemplazos);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		solicitudreemplazos = new  ArrayList<SolicitudReemplazo>();
		  		  
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
		solicitudreemplazos = new  ArrayList<SolicitudReemplazo>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SolicitudReemplazo.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			SolicitudReemplazoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			solicitudreemplazos=solicitudreemplazoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarSolicitudReemplazo(solicitudreemplazos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				SolicitudReemplazoConstantesFunciones.refrescarForeignKeysDescripcionesSolicitudReemplazo(this.solicitudreemplazos);
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
		solicitudreemplazos = new  ArrayList<SolicitudReemplazo>();
		  		  
        try {
			SolicitudReemplazoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			solicitudreemplazos=solicitudreemplazoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarSolicitudReemplazo(solicitudreemplazos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				SolicitudReemplazoConstantesFunciones.refrescarForeignKeysDescripcionesSolicitudReemplazo(this.solicitudreemplazos);
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
		solicitudreemplazos = new  ArrayList<SolicitudReemplazo>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SolicitudReemplazo.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			SolicitudReemplazoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			solicitudreemplazos=solicitudreemplazoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarSolicitudReemplazo(solicitudreemplazos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				SolicitudReemplazoConstantesFunciones.refrescarForeignKeysDescripcionesSolicitudReemplazo(this.solicitudreemplazos);
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
		solicitudreemplazos = new  ArrayList<SolicitudReemplazo>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			SolicitudReemplazoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			solicitudreemplazos=solicitudreemplazoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarSolicitudReemplazo(solicitudreemplazos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				SolicitudReemplazoConstantesFunciones.refrescarForeignKeysDescripcionesSolicitudReemplazo(this.solicitudreemplazos);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		solicitudreemplazo = new  SolicitudReemplazo();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SolicitudReemplazo.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			SolicitudReemplazoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			solicitudreemplazo=solicitudreemplazoDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarSolicitudReemplazo(solicitudreemplazo);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				SolicitudReemplazoConstantesFunciones.refrescarForeignKeysDescripcionesSolicitudReemplazo(this.solicitudreemplazo);
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
		solicitudreemplazo = new  SolicitudReemplazo();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			SolicitudReemplazoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			solicitudreemplazo=solicitudreemplazoDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarSolicitudReemplazo(solicitudreemplazo);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				SolicitudReemplazoConstantesFunciones.refrescarForeignKeysDescripcionesSolicitudReemplazo(this.solicitudreemplazo);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		solicitudreemplazos = new  ArrayList<SolicitudReemplazo>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SolicitudReemplazo.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			SolicitudReemplazoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			solicitudreemplazos=solicitudreemplazoDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarSolicitudReemplazo(solicitudreemplazos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				SolicitudReemplazoConstantesFunciones.refrescarForeignKeysDescripcionesSolicitudReemplazo(this.solicitudreemplazos);
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
		solicitudreemplazos = new  ArrayList<SolicitudReemplazo>();
		  		  
        try {
			SolicitudReemplazoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			solicitudreemplazos=solicitudreemplazoDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarSolicitudReemplazo(solicitudreemplazos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				SolicitudReemplazoConstantesFunciones.refrescarForeignKeysDescripcionesSolicitudReemplazo(this.solicitudreemplazos);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosSolicitudReemplazosWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		solicitudreemplazos = new  ArrayList<SolicitudReemplazo>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SolicitudReemplazo.class.getSimpleName()+"-getTodosSolicitudReemplazosWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			SolicitudReemplazoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			solicitudreemplazos=solicitudreemplazoDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarSolicitudReemplazo(solicitudreemplazos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				SolicitudReemplazoConstantesFunciones.refrescarForeignKeysDescripcionesSolicitudReemplazo(this.solicitudreemplazos);
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
	
	public  void  getTodosSolicitudReemplazos(String sFinalQuery,Pagination pagination)throws Exception {
		solicitudreemplazos = new  ArrayList<SolicitudReemplazo>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			SolicitudReemplazoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			solicitudreemplazos=solicitudreemplazoDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarSolicitudReemplazo(solicitudreemplazos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				SolicitudReemplazoConstantesFunciones.refrescarForeignKeysDescripcionesSolicitudReemplazo(this.solicitudreemplazos);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarSolicitudReemplazo(SolicitudReemplazo solicitudreemplazo) throws Exception {
		Boolean estaValidado=false;
		
		if(solicitudreemplazo.getIsNew() || solicitudreemplazo.getIsChanged()) { 
			this.invalidValues = solicitudreemplazoValidator.getInvalidValues(solicitudreemplazo);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(solicitudreemplazo);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarSolicitudReemplazo(List<SolicitudReemplazo> SolicitudReemplazos) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(SolicitudReemplazo solicitudreemplazoLocal:solicitudreemplazos) {				
			estaValidadoObjeto=this.validarGuardarSolicitudReemplazo(solicitudreemplazoLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarSolicitudReemplazo(List<SolicitudReemplazo> SolicitudReemplazos) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarSolicitudReemplazo(solicitudreemplazos)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarSolicitudReemplazo(SolicitudReemplazo SolicitudReemplazo) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarSolicitudReemplazo(solicitudreemplazo)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(SolicitudReemplazo solicitudreemplazo) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+solicitudreemplazo.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=SolicitudReemplazoConstantesFunciones.getSolicitudReemplazoLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"solicitudreemplazo","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(SolicitudReemplazoConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(SolicitudReemplazoConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveSolicitudReemplazoWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SolicitudReemplazo.class.getSimpleName()+"-saveSolicitudReemplazoWithConnection");connexion.begin();			
			
			SolicitudReemplazoLogicAdditional.checkSolicitudReemplazoToSave(this.solicitudreemplazo,this.datosCliente,connexion,this.arrDatoGeneral);
			
			SolicitudReemplazoLogicAdditional.updateSolicitudReemplazoToSave(this.solicitudreemplazo,this.arrDatoGeneral);
			
			SolicitudReemplazoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.solicitudreemplazo,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowSolicitudReemplazo();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarSolicitudReemplazo(this.solicitudreemplazo)) {
				SolicitudReemplazoDataAccess.save(this.solicitudreemplazo, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.solicitudreemplazo,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			SolicitudReemplazoLogicAdditional.checkSolicitudReemplazoToSaveAfter(this.solicitudreemplazo,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowSolicitudReemplazo();
			
			connexion.commit();			
			
			if(this.solicitudreemplazo.getIsDeleted()) {
				this.solicitudreemplazo=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveSolicitudReemplazo()throws Exception {	
		try {	
			
			SolicitudReemplazoLogicAdditional.checkSolicitudReemplazoToSave(this.solicitudreemplazo,this.datosCliente,connexion,this.arrDatoGeneral);
			
			SolicitudReemplazoLogicAdditional.updateSolicitudReemplazoToSave(this.solicitudreemplazo,this.arrDatoGeneral);
			
			SolicitudReemplazoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.solicitudreemplazo,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarSolicitudReemplazo(this.solicitudreemplazo)) {			
				SolicitudReemplazoDataAccess.save(this.solicitudreemplazo, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.solicitudreemplazo,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			SolicitudReemplazoLogicAdditional.checkSolicitudReemplazoToSaveAfter(this.solicitudreemplazo,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.solicitudreemplazo.getIsDeleted()) {
				this.solicitudreemplazo=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveSolicitudReemplazosWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SolicitudReemplazo.class.getSimpleName()+"-saveSolicitudReemplazosWithConnection");connexion.begin();			
			
			SolicitudReemplazoLogicAdditional.checkSolicitudReemplazoToSaves(solicitudreemplazos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowSolicitudReemplazos();
			
			Boolean validadoTodosSolicitudReemplazo=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(SolicitudReemplazo solicitudreemplazoLocal:solicitudreemplazos) {		
				if(solicitudreemplazoLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				SolicitudReemplazoLogicAdditional.updateSolicitudReemplazoToSave(solicitudreemplazoLocal,this.arrDatoGeneral);
	        	
				SolicitudReemplazoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),solicitudreemplazoLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarSolicitudReemplazo(solicitudreemplazoLocal)) {
					SolicitudReemplazoDataAccess.save(solicitudreemplazoLocal, connexion);				
				} else {
					validadoTodosSolicitudReemplazo=false;
				}
			}
			
			if(!validadoTodosSolicitudReemplazo) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			SolicitudReemplazoLogicAdditional.checkSolicitudReemplazoToSavesAfter(solicitudreemplazos,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowSolicitudReemplazos();
			
			connexion.commit();		
			
			this.quitarSolicitudReemplazosEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveSolicitudReemplazos()throws Exception {				
		 try {	
			SolicitudReemplazoLogicAdditional.checkSolicitudReemplazoToSaves(solicitudreemplazos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosSolicitudReemplazo=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(SolicitudReemplazo solicitudreemplazoLocal:solicitudreemplazos) {				
				if(solicitudreemplazoLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				SolicitudReemplazoLogicAdditional.updateSolicitudReemplazoToSave(solicitudreemplazoLocal,this.arrDatoGeneral);
	        	
				SolicitudReemplazoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),solicitudreemplazoLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarSolicitudReemplazo(solicitudreemplazoLocal)) {				
					SolicitudReemplazoDataAccess.save(solicitudreemplazoLocal, connexion);				
				} else {
					validadoTodosSolicitudReemplazo=false;
				}
			}
			
			if(!validadoTodosSolicitudReemplazo) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			SolicitudReemplazoLogicAdditional.checkSolicitudReemplazoToSavesAfter(solicitudreemplazos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarSolicitudReemplazosEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public SolicitudReemplazoParameterReturnGeneral procesarAccionSolicitudReemplazos(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<SolicitudReemplazo> solicitudreemplazos,SolicitudReemplazoParameterReturnGeneral solicitudreemplazoParameterGeneral)throws Exception {
		 try {	
			SolicitudReemplazoParameterReturnGeneral solicitudreemplazoReturnGeneral=new SolicitudReemplazoParameterReturnGeneral();
	
			SolicitudReemplazoLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,solicitudreemplazos,solicitudreemplazoParameterGeneral,solicitudreemplazoReturnGeneral);
			
			return solicitudreemplazoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public SolicitudReemplazoParameterReturnGeneral procesarAccionSolicitudReemplazosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<SolicitudReemplazo> solicitudreemplazos,SolicitudReemplazoParameterReturnGeneral solicitudreemplazoParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SolicitudReemplazo.class.getSimpleName()+"-procesarAccionSolicitudReemplazosWithConnection");connexion.begin();			
			
			SolicitudReemplazoParameterReturnGeneral solicitudreemplazoReturnGeneral=new SolicitudReemplazoParameterReturnGeneral();
	
			SolicitudReemplazoLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,solicitudreemplazos,solicitudreemplazoParameterGeneral,solicitudreemplazoReturnGeneral);
			
			this.connexion.commit();
			
			return solicitudreemplazoReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public SolicitudReemplazoParameterReturnGeneral procesarEventosSolicitudReemplazos(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<SolicitudReemplazo> solicitudreemplazos,SolicitudReemplazo solicitudreemplazo,SolicitudReemplazoParameterReturnGeneral solicitudreemplazoParameterGeneral,Boolean isEsNuevoSolicitudReemplazo,ArrayList<Classe> clases)throws Exception {
		 try {	
			SolicitudReemplazoParameterReturnGeneral solicitudreemplazoReturnGeneral=new SolicitudReemplazoParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				solicitudreemplazoReturnGeneral.setConRecargarPropiedades(true);
			}
			
			SolicitudReemplazoLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,solicitudreemplazos,solicitudreemplazo,solicitudreemplazoParameterGeneral,solicitudreemplazoReturnGeneral,isEsNuevoSolicitudReemplazo,clases);
			
			return solicitudreemplazoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public SolicitudReemplazoParameterReturnGeneral procesarEventosSolicitudReemplazosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<SolicitudReemplazo> solicitudreemplazos,SolicitudReemplazo solicitudreemplazo,SolicitudReemplazoParameterReturnGeneral solicitudreemplazoParameterGeneral,Boolean isEsNuevoSolicitudReemplazo,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SolicitudReemplazo.class.getSimpleName()+"-procesarEventosSolicitudReemplazosWithConnection");connexion.begin();			
			
			SolicitudReemplazoParameterReturnGeneral solicitudreemplazoReturnGeneral=new SolicitudReemplazoParameterReturnGeneral();
	
			solicitudreemplazoReturnGeneral.setSolicitudReemplazo(solicitudreemplazo);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				solicitudreemplazoReturnGeneral.setConRecargarPropiedades(true);
			}
			
			SolicitudReemplazoLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,solicitudreemplazos,solicitudreemplazo,solicitudreemplazoParameterGeneral,solicitudreemplazoReturnGeneral,isEsNuevoSolicitudReemplazo,clases);
			
			this.connexion.commit();
			
			return solicitudreemplazoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public SolicitudReemplazoParameterReturnGeneral procesarImportacionSolicitudReemplazosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,SolicitudReemplazoParameterReturnGeneral solicitudreemplazoParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SolicitudReemplazo.class.getSimpleName()+"-procesarImportacionSolicitudReemplazosWithConnection");connexion.begin();			
			
			SolicitudReemplazoParameterReturnGeneral solicitudreemplazoReturnGeneral=new SolicitudReemplazoParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.solicitudreemplazos=new ArrayList<SolicitudReemplazo>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.solicitudreemplazo=new SolicitudReemplazo();
				
				
				if(conColumnasBase) {this.solicitudreemplazo.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.solicitudreemplazo.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.solicitudreemplazo.setsecuencial(arrColumnas[iColumn++]);
				this.solicitudreemplazo.setfecha_solicita(Funciones.ConvertToDate(arrColumnas[iColumn++]));
				this.solicitudreemplazo.setfecha_ejecuta(Funciones.ConvertToDate(arrColumnas[iColumn++]));
				this.solicitudreemplazo.setnumero_horas(Integer.parseInt(arrColumnas[iColumn++]));
				this.solicitudreemplazo.setcosto_unitario(Double.parseDouble(arrColumnas[iColumn++]));
				this.solicitudreemplazo.setcosto_total(Double.parseDouble(arrColumnas[iColumn++]));
			this.solicitudreemplazo.setdescripcion(arrColumnas[iColumn++]);
				
				this.solicitudreemplazos.add(this.solicitudreemplazo);
			}
			
			this.saveSolicitudReemplazos();
			
			this.connexion.commit();
			
			solicitudreemplazoReturnGeneral.setConRetornoEstaProcesado(true);
			solicitudreemplazoReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return solicitudreemplazoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarSolicitudReemplazosEliminados() throws Exception {				
		
		List<SolicitudReemplazo> solicitudreemplazosAux= new ArrayList<SolicitudReemplazo>();
		
		for(SolicitudReemplazo solicitudreemplazo:solicitudreemplazos) {
			if(!solicitudreemplazo.getIsDeleted()) {
				solicitudreemplazosAux.add(solicitudreemplazo);
			}
		}
		
		solicitudreemplazos=solicitudreemplazosAux;
	}
	
	public void quitarSolicitudReemplazosNulos() throws Exception {				
		
		List<SolicitudReemplazo> solicitudreemplazosAux= new ArrayList<SolicitudReemplazo>();
		
		for(SolicitudReemplazo solicitudreemplazo : this.solicitudreemplazos) {
			if(solicitudreemplazo==null) {
				solicitudreemplazosAux.add(solicitudreemplazo);
			}
		}
		
		//this.solicitudreemplazos=solicitudreemplazosAux;
		
		this.solicitudreemplazos.removeAll(solicitudreemplazosAux);
	}
	
	public void getSetVersionRowSolicitudReemplazoWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(solicitudreemplazo.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((solicitudreemplazo.getIsDeleted() || (solicitudreemplazo.getIsChanged()&&!solicitudreemplazo.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=solicitudreemplazoDataAccess.getSetVersionRowSolicitudReemplazo(connexion,solicitudreemplazo.getId());
				
				if(!solicitudreemplazo.getVersionRow().equals(timestamp)) {	
					solicitudreemplazo.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				solicitudreemplazo.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowSolicitudReemplazo()throws Exception {	
		
		if(solicitudreemplazo.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((solicitudreemplazo.getIsDeleted() || (solicitudreemplazo.getIsChanged()&&!solicitudreemplazo.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=solicitudreemplazoDataAccess.getSetVersionRowSolicitudReemplazo(connexion,solicitudreemplazo.getId());
			
			try {							
				if(!solicitudreemplazo.getVersionRow().equals(timestamp)) {	
					solicitudreemplazo.setVersionRow(timestamp);
				}
				
				solicitudreemplazo.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowSolicitudReemplazosWithConnection()throws Exception {	
		if(solicitudreemplazos!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(SolicitudReemplazo solicitudreemplazoAux:solicitudreemplazos) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(solicitudreemplazoAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(solicitudreemplazoAux.getIsDeleted() || (solicitudreemplazoAux.getIsChanged()&&!solicitudreemplazoAux.getIsNew())) {
						
						timestamp=solicitudreemplazoDataAccess.getSetVersionRowSolicitudReemplazo(connexion,solicitudreemplazoAux.getId());
						
						if(!solicitudreemplazo.getVersionRow().equals(timestamp)) {	
							solicitudreemplazoAux.setVersionRow(timestamp);
						}
								
						solicitudreemplazoAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowSolicitudReemplazos()throws Exception {	
		if(solicitudreemplazos!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(SolicitudReemplazo solicitudreemplazoAux:solicitudreemplazos) {
					if(solicitudreemplazoAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(solicitudreemplazoAux.getIsDeleted() || (solicitudreemplazoAux.getIsChanged()&&!solicitudreemplazoAux.getIsNew())) {
						
						timestamp=solicitudreemplazoDataAccess.getSetVersionRowSolicitudReemplazo(connexion,solicitudreemplazoAux.getId());
						
						if(!solicitudreemplazoAux.getVersionRow().equals(timestamp)) {	
							solicitudreemplazoAux.setVersionRow(timestamp);
						}
						
													
						solicitudreemplazoAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public SolicitudReemplazoParameterReturnGeneral cargarCombosLoteForeignKeySolicitudReemplazoWithConnection(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalEmpleadoJefe,String finalQueryGlobalEmpleado,String finalQueryGlobalEmpleadoReemplazo,String finalQueryGlobalEstructura,String finalQueryGlobalEstadoSolicitudNomi) throws Exception {
		SolicitudReemplazoParameterReturnGeneral  solicitudreemplazoReturnGeneral =new SolicitudReemplazoParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SolicitudReemplazo.class.getSimpleName()+"-cargarCombosLoteForeignKeySolicitudReemplazoWithConnection");connexion.begin();
			
			solicitudreemplazoReturnGeneral =new SolicitudReemplazoParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			solicitudreemplazoReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			solicitudreemplazoReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Empleado> empleadojefesForeignKey=new ArrayList<Empleado>();
			EmpleadoLogic empleadojefeLogic=new EmpleadoLogic();
			empleadojefeLogic.setConnexion(this.connexion);
			empleadojefeLogic.getEmpleadoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpleadoJefe.equals("NONE")) {
				empleadojefeLogic.getTodosEmpleados(finalQueryGlobalEmpleadoJefe,new Pagination());
				empleadojefesForeignKey=empleadojefeLogic.getEmpleados();
			}

			solicitudreemplazoReturnGeneral.setempleadojefesForeignKey(empleadojefesForeignKey);


			List<Empleado> empleadosForeignKey=new ArrayList<Empleado>();
			EmpleadoLogic empleadoLogic=new EmpleadoLogic();
			empleadoLogic.setConnexion(this.connexion);
			empleadoLogic.getEmpleadoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpleado.equals("NONE")) {
				empleadoLogic.getTodosEmpleados(finalQueryGlobalEmpleado,new Pagination());
				empleadosForeignKey=empleadoLogic.getEmpleados();
			}

			solicitudreemplazoReturnGeneral.setempleadosForeignKey(empleadosForeignKey);


			List<Empleado> empleadoreemplazosForeignKey=new ArrayList<Empleado>();
			EmpleadoLogic empleadoreemplazoLogic=new EmpleadoLogic();
			empleadoreemplazoLogic.setConnexion(this.connexion);
			empleadoreemplazoLogic.getEmpleadoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpleadoReemplazo.equals("NONE")) {
				empleadoreemplazoLogic.getTodosEmpleados(finalQueryGlobalEmpleadoReemplazo,new Pagination());
				empleadoreemplazosForeignKey=empleadoreemplazoLogic.getEmpleados();
			}

			solicitudreemplazoReturnGeneral.setempleadoreemplazosForeignKey(empleadoreemplazosForeignKey);


			List<Estructura> estructurasForeignKey=new ArrayList<Estructura>();
			EstructuraLogic estructuraLogic=new EstructuraLogic();
			estructuraLogic.setConnexion(this.connexion);
			estructuraLogic.getEstructuraDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEstructura.equals("NONE")) {
				estructuraLogic.getTodosEstructuras(finalQueryGlobalEstructura,new Pagination());
				estructurasForeignKey=estructuraLogic.getEstructuras();
			}

			solicitudreemplazoReturnGeneral.setestructurasForeignKey(estructurasForeignKey);


			List<EstadoSolicitudNomi> estadosolicitudnomisForeignKey=new ArrayList<EstadoSolicitudNomi>();
			EstadoSolicitudNomiLogic estadosolicitudnomiLogic=new EstadoSolicitudNomiLogic();
			estadosolicitudnomiLogic.setConnexion(this.connexion);
			estadosolicitudnomiLogic.getEstadoSolicitudNomiDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEstadoSolicitudNomi.equals("NONE")) {
				estadosolicitudnomiLogic.getTodosEstadoSolicitudNomis(finalQueryGlobalEstadoSolicitudNomi,new Pagination());
				estadosolicitudnomisForeignKey=estadosolicitudnomiLogic.getEstadoSolicitudNomis();
			}

			solicitudreemplazoReturnGeneral.setestadosolicitudnomisForeignKey(estadosolicitudnomisForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return solicitudreemplazoReturnGeneral;
	}
	
	public SolicitudReemplazoParameterReturnGeneral cargarCombosLoteForeignKeySolicitudReemplazo(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalEmpleadoJefe,String finalQueryGlobalEmpleado,String finalQueryGlobalEmpleadoReemplazo,String finalQueryGlobalEstructura,String finalQueryGlobalEstadoSolicitudNomi) throws Exception {
		SolicitudReemplazoParameterReturnGeneral  solicitudreemplazoReturnGeneral =new SolicitudReemplazoParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			solicitudreemplazoReturnGeneral =new SolicitudReemplazoParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			solicitudreemplazoReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			solicitudreemplazoReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Empleado> empleadojefesForeignKey=new ArrayList<Empleado>();
			EmpleadoLogic empleadojefeLogic=new EmpleadoLogic();
			empleadojefeLogic.setConnexion(this.connexion);
			empleadojefeLogic.getEmpleadoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpleadoJefe.equals("NONE")) {
				empleadojefeLogic.getTodosEmpleados(finalQueryGlobalEmpleadoJefe,new Pagination());
				empleadojefesForeignKey=empleadojefeLogic.getEmpleados();
			}

			solicitudreemplazoReturnGeneral.setempleadojefesForeignKey(empleadojefesForeignKey);


			List<Empleado> empleadosForeignKey=new ArrayList<Empleado>();
			EmpleadoLogic empleadoLogic=new EmpleadoLogic();
			empleadoLogic.setConnexion(this.connexion);
			empleadoLogic.getEmpleadoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpleado.equals("NONE")) {
				empleadoLogic.getTodosEmpleados(finalQueryGlobalEmpleado,new Pagination());
				empleadosForeignKey=empleadoLogic.getEmpleados();
			}

			solicitudreemplazoReturnGeneral.setempleadosForeignKey(empleadosForeignKey);


			List<Empleado> empleadoreemplazosForeignKey=new ArrayList<Empleado>();
			EmpleadoLogic empleadoreemplazoLogic=new EmpleadoLogic();
			empleadoreemplazoLogic.setConnexion(this.connexion);
			empleadoreemplazoLogic.getEmpleadoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpleadoReemplazo.equals("NONE")) {
				empleadoreemplazoLogic.getTodosEmpleados(finalQueryGlobalEmpleadoReemplazo,new Pagination());
				empleadoreemplazosForeignKey=empleadoreemplazoLogic.getEmpleados();
			}

			solicitudreemplazoReturnGeneral.setempleadoreemplazosForeignKey(empleadoreemplazosForeignKey);


			List<Estructura> estructurasForeignKey=new ArrayList<Estructura>();
			EstructuraLogic estructuraLogic=new EstructuraLogic();
			estructuraLogic.setConnexion(this.connexion);
			estructuraLogic.getEstructuraDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEstructura.equals("NONE")) {
				estructuraLogic.getTodosEstructuras(finalQueryGlobalEstructura,new Pagination());
				estructurasForeignKey=estructuraLogic.getEstructuras();
			}

			solicitudreemplazoReturnGeneral.setestructurasForeignKey(estructurasForeignKey);


			List<EstadoSolicitudNomi> estadosolicitudnomisForeignKey=new ArrayList<EstadoSolicitudNomi>();
			EstadoSolicitudNomiLogic estadosolicitudnomiLogic=new EstadoSolicitudNomiLogic();
			estadosolicitudnomiLogic.setConnexion(this.connexion);
			estadosolicitudnomiLogic.getEstadoSolicitudNomiDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEstadoSolicitudNomi.equals("NONE")) {
				estadosolicitudnomiLogic.getTodosEstadoSolicitudNomis(finalQueryGlobalEstadoSolicitudNomi,new Pagination());
				estadosolicitudnomisForeignKey=estadosolicitudnomiLogic.getEstadoSolicitudNomis();
			}

			solicitudreemplazoReturnGeneral.setestadosolicitudnomisForeignKey(estadosolicitudnomisForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return solicitudreemplazoReturnGeneral;
	}
	
	
	public void deepLoad(SolicitudReemplazo solicitudreemplazo,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			SolicitudReemplazoLogicAdditional.updateSolicitudReemplazoToGet(solicitudreemplazo,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		solicitudreemplazo.setEmpresa(solicitudreemplazoDataAccess.getEmpresa(connexion,solicitudreemplazo));
		solicitudreemplazo.setSucursal(solicitudreemplazoDataAccess.getSucursal(connexion,solicitudreemplazo));
		solicitudreemplazo.setEmpleadoJefe(solicitudreemplazoDataAccess.getEmpleadoJefe(connexion,solicitudreemplazo));
		solicitudreemplazo.setEmpleado(solicitudreemplazoDataAccess.getEmpleado(connexion,solicitudreemplazo));
		solicitudreemplazo.setEmpleadoReemplazo(solicitudreemplazoDataAccess.getEmpleadoReemplazo(connexion,solicitudreemplazo));
		solicitudreemplazo.setEstructura(solicitudreemplazoDataAccess.getEstructura(connexion,solicitudreemplazo));
		solicitudreemplazo.setEstadoSolicitudNomi(solicitudreemplazoDataAccess.getEstadoSolicitudNomi(connexion,solicitudreemplazo));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				solicitudreemplazo.setEmpresa(solicitudreemplazoDataAccess.getEmpresa(connexion,solicitudreemplazo));
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				solicitudreemplazo.setSucursal(solicitudreemplazoDataAccess.getSucursal(connexion,solicitudreemplazo));
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				solicitudreemplazo.setEmpleadoJefe(solicitudreemplazoDataAccess.getEmpleadoJefe(connexion,solicitudreemplazo));
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				solicitudreemplazo.setEmpleado(solicitudreemplazoDataAccess.getEmpleado(connexion,solicitudreemplazo));
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				solicitudreemplazo.setEmpleadoReemplazo(solicitudreemplazoDataAccess.getEmpleadoReemplazo(connexion,solicitudreemplazo));
				continue;
			}

			if(clas.clas.equals(Estructura.class)) {
				solicitudreemplazo.setEstructura(solicitudreemplazoDataAccess.getEstructura(connexion,solicitudreemplazo));
				continue;
			}

			if(clas.clas.equals(EstadoSolicitudNomi.class)) {
				solicitudreemplazo.setEstadoSolicitudNomi(solicitudreemplazoDataAccess.getEstadoSolicitudNomi(connexion,solicitudreemplazo));
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
			solicitudreemplazo.setEmpresa(solicitudreemplazoDataAccess.getEmpresa(connexion,solicitudreemplazo));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			solicitudreemplazo.setSucursal(solicitudreemplazoDataAccess.getSucursal(connexion,solicitudreemplazo));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Empleado.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			solicitudreemplazo.setEmpleadoJefe(solicitudreemplazoDataAccess.getEmpleadoJefe(connexion,solicitudreemplazo));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Empleado.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			solicitudreemplazo.setEmpleado(solicitudreemplazoDataAccess.getEmpleado(connexion,solicitudreemplazo));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Empleado.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			solicitudreemplazo.setEmpleadoReemplazo(solicitudreemplazoDataAccess.getEmpleadoReemplazo(connexion,solicitudreemplazo));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Estructura.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			solicitudreemplazo.setEstructura(solicitudreemplazoDataAccess.getEstructura(connexion,solicitudreemplazo));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(EstadoSolicitudNomi.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			solicitudreemplazo.setEstadoSolicitudNomi(solicitudreemplazoDataAccess.getEstadoSolicitudNomi(connexion,solicitudreemplazo));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		solicitudreemplazo.setEmpresa(solicitudreemplazoDataAccess.getEmpresa(connexion,solicitudreemplazo));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(solicitudreemplazo.getEmpresa(),isDeep,deepLoadType,clases);
				
		solicitudreemplazo.setSucursal(solicitudreemplazoDataAccess.getSucursal(connexion,solicitudreemplazo));
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(solicitudreemplazo.getSucursal(),isDeep,deepLoadType,clases);
				
		solicitudreemplazo.setEmpleadoJefe(solicitudreemplazoDataAccess.getEmpleadoJefe(connexion,solicitudreemplazo));
		EmpleadoLogic empleadojefeLogic= new EmpleadoLogic(connexion);
		empleadojefeLogic.deepLoad(solicitudreemplazo.getEmpleadoJefe(),isDeep,deepLoadType,clases);
				
		solicitudreemplazo.setEmpleado(solicitudreemplazoDataAccess.getEmpleado(connexion,solicitudreemplazo));
		EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
		empleadoLogic.deepLoad(solicitudreemplazo.getEmpleado(),isDeep,deepLoadType,clases);
				
		solicitudreemplazo.setEmpleadoReemplazo(solicitudreemplazoDataAccess.getEmpleadoReemplazo(connexion,solicitudreemplazo));
		EmpleadoLogic empleadoreemplazoLogic= new EmpleadoLogic(connexion);
		empleadoreemplazoLogic.deepLoad(solicitudreemplazo.getEmpleadoReemplazo(),isDeep,deepLoadType,clases);
				
		solicitudreemplazo.setEstructura(solicitudreemplazoDataAccess.getEstructura(connexion,solicitudreemplazo));
		EstructuraLogic estructuraLogic= new EstructuraLogic(connexion);
		estructuraLogic.deepLoad(solicitudreemplazo.getEstructura(),isDeep,deepLoadType,clases);
				
		solicitudreemplazo.setEstadoSolicitudNomi(solicitudreemplazoDataAccess.getEstadoSolicitudNomi(connexion,solicitudreemplazo));
		EstadoSolicitudNomiLogic estadosolicitudnomiLogic= new EstadoSolicitudNomiLogic(connexion);
		estadosolicitudnomiLogic.deepLoad(solicitudreemplazo.getEstadoSolicitudNomi(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				solicitudreemplazo.setEmpresa(solicitudreemplazoDataAccess.getEmpresa(connexion,solicitudreemplazo));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(solicitudreemplazo.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				solicitudreemplazo.setSucursal(solicitudreemplazoDataAccess.getSucursal(connexion,solicitudreemplazo));
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepLoad(solicitudreemplazo.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				solicitudreemplazo.setEmpleadoJefe(solicitudreemplazoDataAccess.getEmpleadoJefe(connexion,solicitudreemplazo));
				EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
				empleadoLogic.deepLoad(solicitudreemplazo.getEmpleadoJefe(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				solicitudreemplazo.setEmpleado(solicitudreemplazoDataAccess.getEmpleado(connexion,solicitudreemplazo));
				EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
				empleadoLogic.deepLoad(solicitudreemplazo.getEmpleado(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				solicitudreemplazo.setEmpleadoReemplazo(solicitudreemplazoDataAccess.getEmpleadoReemplazo(connexion,solicitudreemplazo));
				EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
				empleadoLogic.deepLoad(solicitudreemplazo.getEmpleadoReemplazo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Estructura.class)) {
				solicitudreemplazo.setEstructura(solicitudreemplazoDataAccess.getEstructura(connexion,solicitudreemplazo));
				EstructuraLogic estructuraLogic= new EstructuraLogic(connexion);
				estructuraLogic.deepLoad(solicitudreemplazo.getEstructura(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(EstadoSolicitudNomi.class)) {
				solicitudreemplazo.setEstadoSolicitudNomi(solicitudreemplazoDataAccess.getEstadoSolicitudNomi(connexion,solicitudreemplazo));
				EstadoSolicitudNomiLogic estadosolicitudnomiLogic= new EstadoSolicitudNomiLogic(connexion);
				estadosolicitudnomiLogic.deepLoad(solicitudreemplazo.getEstadoSolicitudNomi(),isDeep,deepLoadType,clases);				
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
			solicitudreemplazo.setEmpresa(solicitudreemplazoDataAccess.getEmpresa(connexion,solicitudreemplazo));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(solicitudreemplazo.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			solicitudreemplazo.setSucursal(solicitudreemplazoDataAccess.getSucursal(connexion,solicitudreemplazo));
			SucursalLogic sucursalLogic= new SucursalLogic(connexion);
			sucursalLogic.deepLoad(solicitudreemplazo.getSucursal(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Empleado.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			solicitudreemplazo.setEmpleadoJefe(solicitudreemplazoDataAccess.getEmpleadoJefe(connexion,solicitudreemplazo));
			EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
			empleadoLogic.deepLoad(solicitudreemplazo.getEmpleadoJefe(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Empleado.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			solicitudreemplazo.setEmpleado(solicitudreemplazoDataAccess.getEmpleado(connexion,solicitudreemplazo));
			EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
			empleadoLogic.deepLoad(solicitudreemplazo.getEmpleado(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Empleado.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			solicitudreemplazo.setEmpleadoReemplazo(solicitudreemplazoDataAccess.getEmpleadoReemplazo(connexion,solicitudreemplazo));
			EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
			empleadoLogic.deepLoad(solicitudreemplazo.getEmpleadoReemplazo(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Estructura.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			solicitudreemplazo.setEstructura(solicitudreemplazoDataAccess.getEstructura(connexion,solicitudreemplazo));
			EstructuraLogic estructuraLogic= new EstructuraLogic(connexion);
			estructuraLogic.deepLoad(solicitudreemplazo.getEstructura(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(EstadoSolicitudNomi.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			solicitudreemplazo.setEstadoSolicitudNomi(solicitudreemplazoDataAccess.getEstadoSolicitudNomi(connexion,solicitudreemplazo));
			EstadoSolicitudNomiLogic estadosolicitudnomiLogic= new EstadoSolicitudNomiLogic(connexion);
			estadosolicitudnomiLogic.deepLoad(solicitudreemplazo.getEstadoSolicitudNomi(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(SolicitudReemplazo solicitudreemplazo,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			SolicitudReemplazoLogicAdditional.updateSolicitudReemplazoToSave(solicitudreemplazo,this.arrDatoGeneral);
			
SolicitudReemplazoDataAccess.save(solicitudreemplazo, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(solicitudreemplazo.getEmpresa(),connexion);

		SucursalDataAccess.save(solicitudreemplazo.getSucursal(),connexion);

		EmpleadoDataAccess.save(solicitudreemplazo.getEmpleadoJefe(),connexion);

		EmpleadoDataAccess.save(solicitudreemplazo.getEmpleado(),connexion);

		EmpleadoDataAccess.save(solicitudreemplazo.getEmpleadoReemplazo(),connexion);

		EstructuraDataAccess.save(solicitudreemplazo.getEstructura(),connexion);

		EstadoSolicitudNomiDataAccess.save(solicitudreemplazo.getEstadoSolicitudNomi(),connexion);
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(solicitudreemplazo.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(solicitudreemplazo.getSucursal(),connexion);
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				EmpleadoDataAccess.save(solicitudreemplazo.getEmpleadoJefe(),connexion);
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				EmpleadoDataAccess.save(solicitudreemplazo.getEmpleado(),connexion);
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				EmpleadoDataAccess.save(solicitudreemplazo.getEmpleadoReemplazo(),connexion);
				continue;
			}

			if(clas.clas.equals(Estructura.class)) {
				EstructuraDataAccess.save(solicitudreemplazo.getEstructura(),connexion);
				continue;
			}

			if(clas.clas.equals(EstadoSolicitudNomi.class)) {
				EstadoSolicitudNomiDataAccess.save(solicitudreemplazo.getEstadoSolicitudNomi(),connexion);
				continue;
			}

		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(solicitudreemplazo.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(solicitudreemplazo.getEmpresa(),isDeep,deepLoadType,clases);
				

		SucursalDataAccess.save(solicitudreemplazo.getSucursal(),connexion);
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(solicitudreemplazo.getSucursal(),isDeep,deepLoadType,clases);
				

		EmpleadoDataAccess.save(solicitudreemplazo.getEmpleadoJefe(),connexion);
		EmpleadoLogic empleadojefeLogic= new EmpleadoLogic(connexion);
		empleadojefeLogic.deepLoad(solicitudreemplazo.getEmpleadoJefe(),isDeep,deepLoadType,clases);
				

		EmpleadoDataAccess.save(solicitudreemplazo.getEmpleado(),connexion);
		EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
		empleadoLogic.deepLoad(solicitudreemplazo.getEmpleado(),isDeep,deepLoadType,clases);
				

		EmpleadoDataAccess.save(solicitudreemplazo.getEmpleadoReemplazo(),connexion);
		EmpleadoLogic empleadoreemplazoLogic= new EmpleadoLogic(connexion);
		empleadoreemplazoLogic.deepLoad(solicitudreemplazo.getEmpleadoReemplazo(),isDeep,deepLoadType,clases);
				

		EstructuraDataAccess.save(solicitudreemplazo.getEstructura(),connexion);
		EstructuraLogic estructuraLogic= new EstructuraLogic(connexion);
		estructuraLogic.deepLoad(solicitudreemplazo.getEstructura(),isDeep,deepLoadType,clases);
				

		EstadoSolicitudNomiDataAccess.save(solicitudreemplazo.getEstadoSolicitudNomi(),connexion);
		EstadoSolicitudNomiLogic estadosolicitudnomiLogic= new EstadoSolicitudNomiLogic(connexion);
		estadosolicitudnomiLogic.deepLoad(solicitudreemplazo.getEstadoSolicitudNomi(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(solicitudreemplazo.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(solicitudreemplazo.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(solicitudreemplazo.getSucursal(),connexion);
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepSave(solicitudreemplazo.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				EmpleadoDataAccess.save(solicitudreemplazo.getEmpleadoJefe(),connexion);
				EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
				empleadoLogic.deepSave(solicitudreemplazo.getEmpleadoJefe(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				EmpleadoDataAccess.save(solicitudreemplazo.getEmpleado(),connexion);
				EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
				empleadoLogic.deepSave(solicitudreemplazo.getEmpleado(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				EmpleadoDataAccess.save(solicitudreemplazo.getEmpleadoReemplazo(),connexion);
				EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
				empleadoLogic.deepSave(solicitudreemplazo.getEmpleadoReemplazo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Estructura.class)) {
				EstructuraDataAccess.save(solicitudreemplazo.getEstructura(),connexion);
				EstructuraLogic estructuraLogic= new EstructuraLogic(connexion);
				estructuraLogic.deepSave(solicitudreemplazo.getEstructura(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(EstadoSolicitudNomi.class)) {
				EstadoSolicitudNomiDataAccess.save(solicitudreemplazo.getEstadoSolicitudNomi(),connexion);
				EstadoSolicitudNomiLogic estadosolicitudnomiLogic= new EstadoSolicitudNomiLogic(connexion);
				estadosolicitudnomiLogic.deepSave(solicitudreemplazo.getEstadoSolicitudNomi(),isDeep,deepLoadType,clases);				
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
			this.getNewConnexionToDeep(SolicitudReemplazo.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(solicitudreemplazo,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				SolicitudReemplazoConstantesFunciones.refrescarForeignKeysDescripcionesSolicitudReemplazo(solicitudreemplazo);
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
			this.deepLoad(this.solicitudreemplazo,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				SolicitudReemplazoConstantesFunciones.refrescarForeignKeysDescripcionesSolicitudReemplazo(this.solicitudreemplazo);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(SolicitudReemplazo.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(solicitudreemplazos!=null) {
				for(SolicitudReemplazo solicitudreemplazo:solicitudreemplazos) {
					this.deepLoad(solicitudreemplazo,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					SolicitudReemplazoConstantesFunciones.refrescarForeignKeysDescripcionesSolicitudReemplazo(solicitudreemplazos);
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
			if(solicitudreemplazos!=null) {
				for(SolicitudReemplazo solicitudreemplazo:solicitudreemplazos) {
					this.deepLoad(solicitudreemplazo,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					SolicitudReemplazoConstantesFunciones.refrescarForeignKeysDescripcionesSolicitudReemplazo(solicitudreemplazos);
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
			this.getNewConnexionToDeep(SolicitudReemplazo.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(solicitudreemplazo,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(SolicitudReemplazo.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(solicitudreemplazos!=null) {
				for(SolicitudReemplazo solicitudreemplazo:solicitudreemplazos) {
					this.deepSave(solicitudreemplazo,isDeep,deepLoadType,clases);
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
			if(solicitudreemplazos!=null) {
				for(SolicitudReemplazo solicitudreemplazo:solicitudreemplazos) {
					this.deepSave(solicitudreemplazo,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getSolicitudReemplazosFK_IdEmpleadoWithConnection(String sFinalQuery,Pagination pagination,Long id_empleado)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SolicitudReemplazo.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpleado= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpleado.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empleado,SolicitudReemplazoConstantesFunciones.IDEMPLEADO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpleado);

			SolicitudReemplazoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpleado","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			solicitudreemplazos=solicitudreemplazoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				SolicitudReemplazoConstantesFunciones.refrescarForeignKeysDescripcionesSolicitudReemplazo(this.solicitudreemplazos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getSolicitudReemplazosFK_IdEmpleado(String sFinalQuery,Pagination pagination,Long id_empleado)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpleado= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpleado.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empleado,SolicitudReemplazoConstantesFunciones.IDEMPLEADO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpleado);

			SolicitudReemplazoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpleado","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			solicitudreemplazos=solicitudreemplazoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				SolicitudReemplazoConstantesFunciones.refrescarForeignKeysDescripcionesSolicitudReemplazo(this.solicitudreemplazos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getSolicitudReemplazosFK_IdEmpleadoJefeWithConnection(String sFinalQuery,Pagination pagination,Long id_empleado_jefe)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SolicitudReemplazo.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpleadoJefe= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpleadoJefe.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empleado_jefe,SolicitudReemplazoConstantesFunciones.IDEMPLEADOJEFE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpleadoJefe);

			SolicitudReemplazoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpleadoJefe","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			solicitudreemplazos=solicitudreemplazoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				SolicitudReemplazoConstantesFunciones.refrescarForeignKeysDescripcionesSolicitudReemplazo(this.solicitudreemplazos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getSolicitudReemplazosFK_IdEmpleadoJefe(String sFinalQuery,Pagination pagination,Long id_empleado_jefe)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpleadoJefe= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpleadoJefe.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empleado_jefe,SolicitudReemplazoConstantesFunciones.IDEMPLEADOJEFE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpleadoJefe);

			SolicitudReemplazoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpleadoJefe","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			solicitudreemplazos=solicitudreemplazoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				SolicitudReemplazoConstantesFunciones.refrescarForeignKeysDescripcionesSolicitudReemplazo(this.solicitudreemplazos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getSolicitudReemplazosFK_IdEmpleadoReemplazoWithConnection(String sFinalQuery,Pagination pagination,Long id_empleado_reemplazo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SolicitudReemplazo.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpleadoReemplazo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpleadoReemplazo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empleado_reemplazo,SolicitudReemplazoConstantesFunciones.IDEMPLEADOREEMPLAZO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpleadoReemplazo);

			SolicitudReemplazoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpleadoReemplazo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			solicitudreemplazos=solicitudreemplazoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				SolicitudReemplazoConstantesFunciones.refrescarForeignKeysDescripcionesSolicitudReemplazo(this.solicitudreemplazos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getSolicitudReemplazosFK_IdEmpleadoReemplazo(String sFinalQuery,Pagination pagination,Long id_empleado_reemplazo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpleadoReemplazo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpleadoReemplazo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empleado_reemplazo,SolicitudReemplazoConstantesFunciones.IDEMPLEADOREEMPLAZO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpleadoReemplazo);

			SolicitudReemplazoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpleadoReemplazo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			solicitudreemplazos=solicitudreemplazoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				SolicitudReemplazoConstantesFunciones.refrescarForeignKeysDescripcionesSolicitudReemplazo(this.solicitudreemplazos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getSolicitudReemplazosFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SolicitudReemplazo.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,SolicitudReemplazoConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			SolicitudReemplazoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			solicitudreemplazos=solicitudreemplazoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				SolicitudReemplazoConstantesFunciones.refrescarForeignKeysDescripcionesSolicitudReemplazo(this.solicitudreemplazos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getSolicitudReemplazosFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,SolicitudReemplazoConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			SolicitudReemplazoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			solicitudreemplazos=solicitudreemplazoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				SolicitudReemplazoConstantesFunciones.refrescarForeignKeysDescripcionesSolicitudReemplazo(this.solicitudreemplazos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getSolicitudReemplazosFK_IdEstadoSolicitudNomiWithConnection(String sFinalQuery,Pagination pagination,Long id_estado_solicitud_nomi)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SolicitudReemplazo.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEstadoSolicitudNomi= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEstadoSolicitudNomi.setParameterSelectionGeneralEqual(ParameterType.LONG,id_estado_solicitud_nomi,SolicitudReemplazoConstantesFunciones.IDESTADOSOLICITUDNOMI,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEstadoSolicitudNomi);

			SolicitudReemplazoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEstadoSolicitudNomi","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			solicitudreemplazos=solicitudreemplazoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				SolicitudReemplazoConstantesFunciones.refrescarForeignKeysDescripcionesSolicitudReemplazo(this.solicitudreemplazos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getSolicitudReemplazosFK_IdEstadoSolicitudNomi(String sFinalQuery,Pagination pagination,Long id_estado_solicitud_nomi)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEstadoSolicitudNomi= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEstadoSolicitudNomi.setParameterSelectionGeneralEqual(ParameterType.LONG,id_estado_solicitud_nomi,SolicitudReemplazoConstantesFunciones.IDESTADOSOLICITUDNOMI,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEstadoSolicitudNomi);

			SolicitudReemplazoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEstadoSolicitudNomi","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			solicitudreemplazos=solicitudreemplazoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				SolicitudReemplazoConstantesFunciones.refrescarForeignKeysDescripcionesSolicitudReemplazo(this.solicitudreemplazos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getSolicitudReemplazosFK_IdEstructuraWithConnection(String sFinalQuery,Pagination pagination,Long id_estructura)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SolicitudReemplazo.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEstructura= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEstructura.setParameterSelectionGeneralEqual(ParameterType.LONG,id_estructura,SolicitudReemplazoConstantesFunciones.IDESTRUCTURA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEstructura);

			SolicitudReemplazoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEstructura","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			solicitudreemplazos=solicitudreemplazoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				SolicitudReemplazoConstantesFunciones.refrescarForeignKeysDescripcionesSolicitudReemplazo(this.solicitudreemplazos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getSolicitudReemplazosFK_IdEstructura(String sFinalQuery,Pagination pagination,Long id_estructura)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEstructura= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEstructura.setParameterSelectionGeneralEqual(ParameterType.LONG,id_estructura,SolicitudReemplazoConstantesFunciones.IDESTRUCTURA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEstructura);

			SolicitudReemplazoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEstructura","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			solicitudreemplazos=solicitudreemplazoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				SolicitudReemplazoConstantesFunciones.refrescarForeignKeysDescripcionesSolicitudReemplazo(this.solicitudreemplazos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getSolicitudReemplazosFK_IdSucursalWithConnection(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SolicitudReemplazo.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,SolicitudReemplazoConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			SolicitudReemplazoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			solicitudreemplazos=solicitudreemplazoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				SolicitudReemplazoConstantesFunciones.refrescarForeignKeysDescripcionesSolicitudReemplazo(this.solicitudreemplazos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getSolicitudReemplazosFK_IdSucursal(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,SolicitudReemplazoConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			SolicitudReemplazoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			solicitudreemplazos=solicitudreemplazoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				SolicitudReemplazoConstantesFunciones.refrescarForeignKeysDescripcionesSolicitudReemplazo(this.solicitudreemplazos);
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
			if(SolicitudReemplazoConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,SolicitudReemplazoDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,SolicitudReemplazo solicitudreemplazo,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(SolicitudReemplazoConstantesFunciones.ISCONAUDITORIA) {
				if(solicitudreemplazo.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,SolicitudReemplazoDataAccess.TABLENAME, solicitudreemplazo.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(SolicitudReemplazoConstantesFunciones.ISCONAUDITORIADETALLE) {
						////SolicitudReemplazoLogic.registrarAuditoriaDetallesSolicitudReemplazo(connexion,solicitudreemplazo,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(solicitudreemplazo.getIsDeleted()) {
					/*if(!solicitudreemplazo.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,SolicitudReemplazoDataAccess.TABLENAME, solicitudreemplazo.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////SolicitudReemplazoLogic.registrarAuditoriaDetallesSolicitudReemplazo(connexion,solicitudreemplazo,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,SolicitudReemplazoDataAccess.TABLENAME, solicitudreemplazo.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(solicitudreemplazo.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,SolicitudReemplazoDataAccess.TABLENAME, solicitudreemplazo.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(SolicitudReemplazoConstantesFunciones.ISCONAUDITORIADETALLE) {
						////SolicitudReemplazoLogic.registrarAuditoriaDetallesSolicitudReemplazo(connexion,solicitudreemplazo,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesSolicitudReemplazo(Connexion connexion,SolicitudReemplazo solicitudreemplazo)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(solicitudreemplazo.getIsNew()||!solicitudreemplazo.getid_empresa().equals(solicitudreemplazo.getSolicitudReemplazoOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(solicitudreemplazo.getSolicitudReemplazoOriginal().getid_empresa()!=null)
				{
					strValorActual=solicitudreemplazo.getSolicitudReemplazoOriginal().getid_empresa().toString();
				}
				if(solicitudreemplazo.getid_empresa()!=null)
				{
					strValorNuevo=solicitudreemplazo.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),SolicitudReemplazoConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(solicitudreemplazo.getIsNew()||!solicitudreemplazo.getid_sucursal().equals(solicitudreemplazo.getSolicitudReemplazoOriginal().getid_sucursal()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(solicitudreemplazo.getSolicitudReemplazoOriginal().getid_sucursal()!=null)
				{
					strValorActual=solicitudreemplazo.getSolicitudReemplazoOriginal().getid_sucursal().toString();
				}
				if(solicitudreemplazo.getid_sucursal()!=null)
				{
					strValorNuevo=solicitudreemplazo.getid_sucursal().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),SolicitudReemplazoConstantesFunciones.IDSUCURSAL,strValorActual,strValorNuevo);
			}	
			
			if(solicitudreemplazo.getIsNew()||!solicitudreemplazo.getid_empleado_jefe().equals(solicitudreemplazo.getSolicitudReemplazoOriginal().getid_empleado_jefe()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(solicitudreemplazo.getSolicitudReemplazoOriginal().getid_empleado_jefe()!=null)
				{
					strValorActual=solicitudreemplazo.getSolicitudReemplazoOriginal().getid_empleado_jefe().toString();
				}
				if(solicitudreemplazo.getid_empleado_jefe()!=null)
				{
					strValorNuevo=solicitudreemplazo.getid_empleado_jefe().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),SolicitudReemplazoConstantesFunciones.IDEMPLEADOJEFE,strValorActual,strValorNuevo);
			}	
			
			if(solicitudreemplazo.getIsNew()||!solicitudreemplazo.getid_empleado().equals(solicitudreemplazo.getSolicitudReemplazoOriginal().getid_empleado()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(solicitudreemplazo.getSolicitudReemplazoOriginal().getid_empleado()!=null)
				{
					strValorActual=solicitudreemplazo.getSolicitudReemplazoOriginal().getid_empleado().toString();
				}
				if(solicitudreemplazo.getid_empleado()!=null)
				{
					strValorNuevo=solicitudreemplazo.getid_empleado().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),SolicitudReemplazoConstantesFunciones.IDEMPLEADO,strValorActual,strValorNuevo);
			}	
			
			if(solicitudreemplazo.getIsNew()||!solicitudreemplazo.getid_empleado_reemplazo().equals(solicitudreemplazo.getSolicitudReemplazoOriginal().getid_empleado_reemplazo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(solicitudreemplazo.getSolicitudReemplazoOriginal().getid_empleado_reemplazo()!=null)
				{
					strValorActual=solicitudreemplazo.getSolicitudReemplazoOriginal().getid_empleado_reemplazo().toString();
				}
				if(solicitudreemplazo.getid_empleado_reemplazo()!=null)
				{
					strValorNuevo=solicitudreemplazo.getid_empleado_reemplazo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),SolicitudReemplazoConstantesFunciones.IDEMPLEADOREEMPLAZO,strValorActual,strValorNuevo);
			}	
			
			if(solicitudreemplazo.getIsNew()||!solicitudreemplazo.getid_estructura().equals(solicitudreemplazo.getSolicitudReemplazoOriginal().getid_estructura()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(solicitudreemplazo.getSolicitudReemplazoOriginal().getid_estructura()!=null)
				{
					strValorActual=solicitudreemplazo.getSolicitudReemplazoOriginal().getid_estructura().toString();
				}
				if(solicitudreemplazo.getid_estructura()!=null)
				{
					strValorNuevo=solicitudreemplazo.getid_estructura().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),SolicitudReemplazoConstantesFunciones.IDESTRUCTURA,strValorActual,strValorNuevo);
			}	
			
			if(solicitudreemplazo.getIsNew()||!solicitudreemplazo.getid_estado_solicitud_nomi().equals(solicitudreemplazo.getSolicitudReemplazoOriginal().getid_estado_solicitud_nomi()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(solicitudreemplazo.getSolicitudReemplazoOriginal().getid_estado_solicitud_nomi()!=null)
				{
					strValorActual=solicitudreemplazo.getSolicitudReemplazoOriginal().getid_estado_solicitud_nomi().toString();
				}
				if(solicitudreemplazo.getid_estado_solicitud_nomi()!=null)
				{
					strValorNuevo=solicitudreemplazo.getid_estado_solicitud_nomi().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),SolicitudReemplazoConstantesFunciones.IDESTADOSOLICITUDNOMI,strValorActual,strValorNuevo);
			}	
			
			if(solicitudreemplazo.getIsNew()||!solicitudreemplazo.getsecuencial().equals(solicitudreemplazo.getSolicitudReemplazoOriginal().getsecuencial()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(solicitudreemplazo.getSolicitudReemplazoOriginal().getsecuencial()!=null)
				{
					strValorActual=solicitudreemplazo.getSolicitudReemplazoOriginal().getsecuencial();
				}
				if(solicitudreemplazo.getsecuencial()!=null)
				{
					strValorNuevo=solicitudreemplazo.getsecuencial() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),SolicitudReemplazoConstantesFunciones.SECUENCIAL,strValorActual,strValorNuevo);
			}	
			
			if(solicitudreemplazo.getIsNew()||!solicitudreemplazo.getfecha_solicita().equals(solicitudreemplazo.getSolicitudReemplazoOriginal().getfecha_solicita()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(solicitudreemplazo.getSolicitudReemplazoOriginal().getfecha_solicita()!=null)
				{
					strValorActual=solicitudreemplazo.getSolicitudReemplazoOriginal().getfecha_solicita().toString();
				}
				if(solicitudreemplazo.getfecha_solicita()!=null)
				{
					strValorNuevo=solicitudreemplazo.getfecha_solicita().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),SolicitudReemplazoConstantesFunciones.FECHASOLICITA,strValorActual,strValorNuevo);
			}	
			
			if(solicitudreemplazo.getIsNew()||!solicitudreemplazo.getfecha_ejecuta().equals(solicitudreemplazo.getSolicitudReemplazoOriginal().getfecha_ejecuta()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(solicitudreemplazo.getSolicitudReemplazoOriginal().getfecha_ejecuta()!=null)
				{
					strValorActual=solicitudreemplazo.getSolicitudReemplazoOriginal().getfecha_ejecuta().toString();
				}
				if(solicitudreemplazo.getfecha_ejecuta()!=null)
				{
					strValorNuevo=solicitudreemplazo.getfecha_ejecuta().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),SolicitudReemplazoConstantesFunciones.FECHAEJECUTA,strValorActual,strValorNuevo);
			}	
			
			if(solicitudreemplazo.getIsNew()||!solicitudreemplazo.getnumero_horas().equals(solicitudreemplazo.getSolicitudReemplazoOriginal().getnumero_horas()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(solicitudreemplazo.getSolicitudReemplazoOriginal().getnumero_horas()!=null)
				{
					strValorActual=solicitudreemplazo.getSolicitudReemplazoOriginal().getnumero_horas().toString();
				}
				if(solicitudreemplazo.getnumero_horas()!=null)
				{
					strValorNuevo=solicitudreemplazo.getnumero_horas().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),SolicitudReemplazoConstantesFunciones.NUMEROHORAS,strValorActual,strValorNuevo);
			}	
			
			if(solicitudreemplazo.getIsNew()||!solicitudreemplazo.getcosto_unitario().equals(solicitudreemplazo.getSolicitudReemplazoOriginal().getcosto_unitario()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(solicitudreemplazo.getSolicitudReemplazoOriginal().getcosto_unitario()!=null)
				{
					strValorActual=solicitudreemplazo.getSolicitudReemplazoOriginal().getcosto_unitario().toString();
				}
				if(solicitudreemplazo.getcosto_unitario()!=null)
				{
					strValorNuevo=solicitudreemplazo.getcosto_unitario().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),SolicitudReemplazoConstantesFunciones.COSTOUNITARIO,strValorActual,strValorNuevo);
			}	
			
			if(solicitudreemplazo.getIsNew()||!solicitudreemplazo.getcosto_total().equals(solicitudreemplazo.getSolicitudReemplazoOriginal().getcosto_total()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(solicitudreemplazo.getSolicitudReemplazoOriginal().getcosto_total()!=null)
				{
					strValorActual=solicitudreemplazo.getSolicitudReemplazoOriginal().getcosto_total().toString();
				}
				if(solicitudreemplazo.getcosto_total()!=null)
				{
					strValorNuevo=solicitudreemplazo.getcosto_total().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),SolicitudReemplazoConstantesFunciones.COSTOTOTAL,strValorActual,strValorNuevo);
			}	
			
			if(solicitudreemplazo.getIsNew()||!solicitudreemplazo.getdescripcion().equals(solicitudreemplazo.getSolicitudReemplazoOriginal().getdescripcion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(solicitudreemplazo.getSolicitudReemplazoOriginal().getdescripcion()!=null)
				{
					strValorActual=solicitudreemplazo.getSolicitudReemplazoOriginal().getdescripcion();
				}
				if(solicitudreemplazo.getdescripcion()!=null)
				{
					strValorNuevo=solicitudreemplazo.getdescripcion() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),SolicitudReemplazoConstantesFunciones.DESCRIPCION,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveSolicitudReemplazoRelacionesWithConnection(SolicitudReemplazo solicitudreemplazo) throws Exception {

		if(!solicitudreemplazo.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveSolicitudReemplazoRelacionesBase(solicitudreemplazo,true);
		}
	}

	public void saveSolicitudReemplazoRelaciones(SolicitudReemplazo solicitudreemplazo)throws Exception {

		if(!solicitudreemplazo.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveSolicitudReemplazoRelacionesBase(solicitudreemplazo,false);
		}
	}

	public void saveSolicitudReemplazoRelacionesBase(SolicitudReemplazo solicitudreemplazo,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("SolicitudReemplazo-saveRelacionesWithConnection");}
	

			this.setSolicitudReemplazo(solicitudreemplazo);

			if(SolicitudReemplazoLogicAdditional.validarSaveRelaciones(solicitudreemplazo,this)) {

				SolicitudReemplazoLogicAdditional.updateRelacionesToSave(solicitudreemplazo,this);

				if((solicitudreemplazo.getIsNew()||solicitudreemplazo.getIsChanged())&&!solicitudreemplazo.getIsDeleted()) {
					this.saveSolicitudReemplazo();
					this.saveSolicitudReemplazoRelacionesDetalles();

				} else if(solicitudreemplazo.getIsDeleted()) {
					this.saveSolicitudReemplazoRelacionesDetalles();
					this.saveSolicitudReemplazo();
				}

				SolicitudReemplazoLogicAdditional.updateRelacionesToSaveAfter(solicitudreemplazo,this);

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
	
	
	private void saveSolicitudReemplazoRelacionesDetalles()throws Exception {
		try {
	

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfSolicitudReemplazo(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=SolicitudReemplazoConstantesFunciones.getClassesForeignKeysOfSolicitudReemplazo(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfSolicitudReemplazo(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=SolicitudReemplazoConstantesFunciones.getClassesRelationshipsOfSolicitudReemplazo(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

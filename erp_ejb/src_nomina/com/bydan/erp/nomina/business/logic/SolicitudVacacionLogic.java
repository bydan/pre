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
import com.bydan.erp.nomina.util.SolicitudVacacionConstantesFunciones;
import com.bydan.erp.nomina.util.SolicitudVacacionParameterReturnGeneral;
//import com.bydan.erp.nomina.util.SolicitudVacacionParameterGeneral;
import com.bydan.erp.nomina.business.entity.SolicitudVacacion;
import com.bydan.erp.nomina.business.logic.SolicitudVacacionLogicAdditional;
import com.bydan.erp.nomina.business.dataaccess.*;
import com.bydan.erp.nomina.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;
import com.bydan.erp.contabilidad.business.logic.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;








@SuppressWarnings("unused")
public class SolicitudVacacionLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(SolicitudVacacionLogic.class);
	
	protected SolicitudVacacionDataAccess solicitudvacacionDataAccess; 	
	protected SolicitudVacacion solicitudvacacion;
	protected List<SolicitudVacacion> solicitudvacacions;
	protected Object solicitudvacacionObject;	
	protected List<Object> solicitudvacacionsObject;
	
	public static ClassValidator<SolicitudVacacion> solicitudvacacionValidator = new ClassValidator<SolicitudVacacion>(SolicitudVacacion.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected SolicitudVacacionLogicAdditional solicitudvacacionLogicAdditional=null;
	
	public SolicitudVacacionLogicAdditional getSolicitudVacacionLogicAdditional() {
		return this.solicitudvacacionLogicAdditional;
	}
	
	public void setSolicitudVacacionLogicAdditional(SolicitudVacacionLogicAdditional solicitudvacacionLogicAdditional) {
		try {
			this.solicitudvacacionLogicAdditional=solicitudvacacionLogicAdditional;
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
	
	
	
	
	public  SolicitudVacacionLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.solicitudvacacionDataAccess = new SolicitudVacacionDataAccess();
			
			this.solicitudvacacions= new ArrayList<SolicitudVacacion>();
			this.solicitudvacacion= new SolicitudVacacion();
			
			this.solicitudvacacionObject=new Object();
			this.solicitudvacacionsObject=new ArrayList<Object>();
				
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
			
			this.solicitudvacacionDataAccess.setConnexionType(this.connexionType);
			this.solicitudvacacionDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  SolicitudVacacionLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.solicitudvacacionDataAccess = new SolicitudVacacionDataAccess();
			this.solicitudvacacions= new ArrayList<SolicitudVacacion>();
			this.solicitudvacacion= new SolicitudVacacion();
			this.solicitudvacacionObject=new Object();
			this.solicitudvacacionsObject=new ArrayList<Object>();
			
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
			
			this.solicitudvacacionDataAccess.setConnexionType(this.connexionType);
			this.solicitudvacacionDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public SolicitudVacacion getSolicitudVacacion() throws Exception {	
		SolicitudVacacionLogicAdditional.checkSolicitudVacacionToGet(solicitudvacacion,this.datosCliente,this.arrDatoGeneral);
		SolicitudVacacionLogicAdditional.updateSolicitudVacacionToGet(solicitudvacacion,this.arrDatoGeneral);
		
		return solicitudvacacion;
	}
		
	public void setSolicitudVacacion(SolicitudVacacion newSolicitudVacacion) {
		this.solicitudvacacion = newSolicitudVacacion;
	}
	
	public SolicitudVacacionDataAccess getSolicitudVacacionDataAccess() {
		return solicitudvacacionDataAccess;
	}
	
	public void setSolicitudVacacionDataAccess(SolicitudVacacionDataAccess newsolicitudvacacionDataAccess) {
		this.solicitudvacacionDataAccess = newsolicitudvacacionDataAccess;
	}
	
	public List<SolicitudVacacion> getSolicitudVacacions() throws Exception {		
		this.quitarSolicitudVacacionsNulos();
		
		SolicitudVacacionLogicAdditional.checkSolicitudVacacionToGets(solicitudvacacions,this.datosCliente,this.arrDatoGeneral);
		
		for (SolicitudVacacion solicitudvacacionLocal: solicitudvacacions ) {
			SolicitudVacacionLogicAdditional.updateSolicitudVacacionToGet(solicitudvacacionLocal,this.arrDatoGeneral);
		}
		
		return solicitudvacacions;
	}
	
	public void setSolicitudVacacions(List<SolicitudVacacion> newSolicitudVacacions) {
		this.solicitudvacacions = newSolicitudVacacions;
	}
	
	public Object getSolicitudVacacionObject() {	
		this.solicitudvacacionObject=this.solicitudvacacionDataAccess.getEntityObject();
		return this.solicitudvacacionObject;
	}
		
	public void setSolicitudVacacionObject(Object newSolicitudVacacionObject) {
		this.solicitudvacacionObject = newSolicitudVacacionObject;
	}
	
	public List<Object> getSolicitudVacacionsObject() {		
		this.solicitudvacacionsObject=this.solicitudvacacionDataAccess.getEntitiesObject();
		return this.solicitudvacacionsObject;
	}
		
	public void setSolicitudVacacionsObject(List<Object> newSolicitudVacacionsObject) {
		this.solicitudvacacionsObject = newSolicitudVacacionsObject;
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
		
		if(this.solicitudvacacionDataAccess!=null) {
			this.solicitudvacacionDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SolicitudVacacion.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			solicitudvacacionDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			solicitudvacacionDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		solicitudvacacion = new  SolicitudVacacion();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SolicitudVacacion.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			solicitudvacacion=solicitudvacacionDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.solicitudvacacion,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				SolicitudVacacionConstantesFunciones.refrescarForeignKeysDescripcionesSolicitudVacacion(this.solicitudvacacion);
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
		solicitudvacacion = new  SolicitudVacacion();
		  		  
        try {
			
			solicitudvacacion=solicitudvacacionDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.solicitudvacacion,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				SolicitudVacacionConstantesFunciones.refrescarForeignKeysDescripcionesSolicitudVacacion(this.solicitudvacacion);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		solicitudvacacion = new  SolicitudVacacion();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SolicitudVacacion.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			solicitudvacacion=solicitudvacacionDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.solicitudvacacion,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				SolicitudVacacionConstantesFunciones.refrescarForeignKeysDescripcionesSolicitudVacacion(this.solicitudvacacion);
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
		solicitudvacacion = new  SolicitudVacacion();
		  		  
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
		solicitudvacacion = new  SolicitudVacacion();
		  		  
        try {
			
			solicitudvacacion=solicitudvacacionDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.solicitudvacacion,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				SolicitudVacacionConstantesFunciones.refrescarForeignKeysDescripcionesSolicitudVacacion(this.solicitudvacacion);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		solicitudvacacion = new  SolicitudVacacion();
		  		  
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
		solicitudvacacion = new  SolicitudVacacion();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SolicitudVacacion.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =solicitudvacacionDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		solicitudvacacion = new  SolicitudVacacion();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=solicitudvacacionDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		solicitudvacacion = new  SolicitudVacacion();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SolicitudVacacion.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =solicitudvacacionDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		solicitudvacacion = new  SolicitudVacacion();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=solicitudvacacionDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		solicitudvacacion = new  SolicitudVacacion();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SolicitudVacacion.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =solicitudvacacionDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		solicitudvacacion = new  SolicitudVacacion();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=solicitudvacacionDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		solicitudvacacions = new  ArrayList<SolicitudVacacion>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SolicitudVacacion.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			SolicitudVacacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			solicitudvacacions=solicitudvacacionDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarSolicitudVacacion(solicitudvacacions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				SolicitudVacacionConstantesFunciones.refrescarForeignKeysDescripcionesSolicitudVacacion(this.solicitudvacacions);
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
		solicitudvacacions = new  ArrayList<SolicitudVacacion>();
		  		  
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
		solicitudvacacions = new  ArrayList<SolicitudVacacion>();
		  		  
        try {			
			SolicitudVacacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			solicitudvacacions=solicitudvacacionDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarSolicitudVacacion(solicitudvacacions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				SolicitudVacacionConstantesFunciones.refrescarForeignKeysDescripcionesSolicitudVacacion(this.solicitudvacacions);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		solicitudvacacions = new  ArrayList<SolicitudVacacion>();
		  		  
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
		solicitudvacacions = new  ArrayList<SolicitudVacacion>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SolicitudVacacion.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			SolicitudVacacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			solicitudvacacions=solicitudvacacionDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarSolicitudVacacion(solicitudvacacions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				SolicitudVacacionConstantesFunciones.refrescarForeignKeysDescripcionesSolicitudVacacion(this.solicitudvacacions);
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
		solicitudvacacions = new  ArrayList<SolicitudVacacion>();
		  		  
        try {
			SolicitudVacacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			solicitudvacacions=solicitudvacacionDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarSolicitudVacacion(solicitudvacacions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				SolicitudVacacionConstantesFunciones.refrescarForeignKeysDescripcionesSolicitudVacacion(this.solicitudvacacions);
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
		solicitudvacacions = new  ArrayList<SolicitudVacacion>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SolicitudVacacion.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			SolicitudVacacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			solicitudvacacions=solicitudvacacionDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarSolicitudVacacion(solicitudvacacions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				SolicitudVacacionConstantesFunciones.refrescarForeignKeysDescripcionesSolicitudVacacion(this.solicitudvacacions);
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
		solicitudvacacions = new  ArrayList<SolicitudVacacion>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			SolicitudVacacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			solicitudvacacions=solicitudvacacionDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarSolicitudVacacion(solicitudvacacions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				SolicitudVacacionConstantesFunciones.refrescarForeignKeysDescripcionesSolicitudVacacion(this.solicitudvacacions);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		solicitudvacacion = new  SolicitudVacacion();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SolicitudVacacion.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			SolicitudVacacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			solicitudvacacion=solicitudvacacionDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarSolicitudVacacion(solicitudvacacion);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				SolicitudVacacionConstantesFunciones.refrescarForeignKeysDescripcionesSolicitudVacacion(this.solicitudvacacion);
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
		solicitudvacacion = new  SolicitudVacacion();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			SolicitudVacacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			solicitudvacacion=solicitudvacacionDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarSolicitudVacacion(solicitudvacacion);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				SolicitudVacacionConstantesFunciones.refrescarForeignKeysDescripcionesSolicitudVacacion(this.solicitudvacacion);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		solicitudvacacions = new  ArrayList<SolicitudVacacion>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SolicitudVacacion.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			SolicitudVacacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			solicitudvacacions=solicitudvacacionDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarSolicitudVacacion(solicitudvacacions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				SolicitudVacacionConstantesFunciones.refrescarForeignKeysDescripcionesSolicitudVacacion(this.solicitudvacacions);
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
		solicitudvacacions = new  ArrayList<SolicitudVacacion>();
		  		  
        try {
			SolicitudVacacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			solicitudvacacions=solicitudvacacionDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarSolicitudVacacion(solicitudvacacions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				SolicitudVacacionConstantesFunciones.refrescarForeignKeysDescripcionesSolicitudVacacion(this.solicitudvacacions);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosSolicitudVacacionsWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		solicitudvacacions = new  ArrayList<SolicitudVacacion>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SolicitudVacacion.class.getSimpleName()+"-getTodosSolicitudVacacionsWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			SolicitudVacacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			solicitudvacacions=solicitudvacacionDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarSolicitudVacacion(solicitudvacacions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				SolicitudVacacionConstantesFunciones.refrescarForeignKeysDescripcionesSolicitudVacacion(this.solicitudvacacions);
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
	
	public  void  getTodosSolicitudVacacions(String sFinalQuery,Pagination pagination)throws Exception {
		solicitudvacacions = new  ArrayList<SolicitudVacacion>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			SolicitudVacacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			solicitudvacacions=solicitudvacacionDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarSolicitudVacacion(solicitudvacacions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				SolicitudVacacionConstantesFunciones.refrescarForeignKeysDescripcionesSolicitudVacacion(this.solicitudvacacions);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarSolicitudVacacion(SolicitudVacacion solicitudvacacion) throws Exception {
		Boolean estaValidado=false;
		
		if(solicitudvacacion.getIsNew() || solicitudvacacion.getIsChanged()) { 
			this.invalidValues = solicitudvacacionValidator.getInvalidValues(solicitudvacacion);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(solicitudvacacion);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarSolicitudVacacion(List<SolicitudVacacion> SolicitudVacacions) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(SolicitudVacacion solicitudvacacionLocal:solicitudvacacions) {				
			estaValidadoObjeto=this.validarGuardarSolicitudVacacion(solicitudvacacionLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarSolicitudVacacion(List<SolicitudVacacion> SolicitudVacacions) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarSolicitudVacacion(solicitudvacacions)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarSolicitudVacacion(SolicitudVacacion SolicitudVacacion) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarSolicitudVacacion(solicitudvacacion)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(SolicitudVacacion solicitudvacacion) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+solicitudvacacion.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=SolicitudVacacionConstantesFunciones.getSolicitudVacacionLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"solicitudvacacion","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(SolicitudVacacionConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(SolicitudVacacionConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveSolicitudVacacionWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SolicitudVacacion.class.getSimpleName()+"-saveSolicitudVacacionWithConnection");connexion.begin();			
			
			SolicitudVacacionLogicAdditional.checkSolicitudVacacionToSave(this.solicitudvacacion,this.datosCliente,connexion,this.arrDatoGeneral);
			
			SolicitudVacacionLogicAdditional.updateSolicitudVacacionToSave(this.solicitudvacacion,this.arrDatoGeneral);
			
			SolicitudVacacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.solicitudvacacion,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowSolicitudVacacion();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarSolicitudVacacion(this.solicitudvacacion)) {
				SolicitudVacacionDataAccess.save(this.solicitudvacacion, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.solicitudvacacion,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			SolicitudVacacionLogicAdditional.checkSolicitudVacacionToSaveAfter(this.solicitudvacacion,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowSolicitudVacacion();
			
			connexion.commit();			
			
			if(this.solicitudvacacion.getIsDeleted()) {
				this.solicitudvacacion=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveSolicitudVacacion()throws Exception {	
		try {	
			
			SolicitudVacacionLogicAdditional.checkSolicitudVacacionToSave(this.solicitudvacacion,this.datosCliente,connexion,this.arrDatoGeneral);
			
			SolicitudVacacionLogicAdditional.updateSolicitudVacacionToSave(this.solicitudvacacion,this.arrDatoGeneral);
			
			SolicitudVacacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.solicitudvacacion,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarSolicitudVacacion(this.solicitudvacacion)) {			
				SolicitudVacacionDataAccess.save(this.solicitudvacacion, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.solicitudvacacion,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			SolicitudVacacionLogicAdditional.checkSolicitudVacacionToSaveAfter(this.solicitudvacacion,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.solicitudvacacion.getIsDeleted()) {
				this.solicitudvacacion=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveSolicitudVacacionsWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SolicitudVacacion.class.getSimpleName()+"-saveSolicitudVacacionsWithConnection");connexion.begin();			
			
			SolicitudVacacionLogicAdditional.checkSolicitudVacacionToSaves(solicitudvacacions,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowSolicitudVacacions();
			
			Boolean validadoTodosSolicitudVacacion=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(SolicitudVacacion solicitudvacacionLocal:solicitudvacacions) {		
				if(solicitudvacacionLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				SolicitudVacacionLogicAdditional.updateSolicitudVacacionToSave(solicitudvacacionLocal,this.arrDatoGeneral);
	        	
				SolicitudVacacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),solicitudvacacionLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarSolicitudVacacion(solicitudvacacionLocal)) {
					SolicitudVacacionDataAccess.save(solicitudvacacionLocal, connexion);				
				} else {
					validadoTodosSolicitudVacacion=false;
				}
			}
			
			if(!validadoTodosSolicitudVacacion) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			SolicitudVacacionLogicAdditional.checkSolicitudVacacionToSavesAfter(solicitudvacacions,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowSolicitudVacacions();
			
			connexion.commit();		
			
			this.quitarSolicitudVacacionsEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveSolicitudVacacions()throws Exception {				
		 try {	
			SolicitudVacacionLogicAdditional.checkSolicitudVacacionToSaves(solicitudvacacions,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosSolicitudVacacion=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(SolicitudVacacion solicitudvacacionLocal:solicitudvacacions) {				
				if(solicitudvacacionLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				SolicitudVacacionLogicAdditional.updateSolicitudVacacionToSave(solicitudvacacionLocal,this.arrDatoGeneral);
	        	
				SolicitudVacacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),solicitudvacacionLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarSolicitudVacacion(solicitudvacacionLocal)) {				
					SolicitudVacacionDataAccess.save(solicitudvacacionLocal, connexion);				
				} else {
					validadoTodosSolicitudVacacion=false;
				}
			}
			
			if(!validadoTodosSolicitudVacacion) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			SolicitudVacacionLogicAdditional.checkSolicitudVacacionToSavesAfter(solicitudvacacions,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarSolicitudVacacionsEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public SolicitudVacacionParameterReturnGeneral procesarAccionSolicitudVacacions(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<SolicitudVacacion> solicitudvacacions,SolicitudVacacionParameterReturnGeneral solicitudvacacionParameterGeneral)throws Exception {
		 try {	
			SolicitudVacacionParameterReturnGeneral solicitudvacacionReturnGeneral=new SolicitudVacacionParameterReturnGeneral();
	
			SolicitudVacacionLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,solicitudvacacions,solicitudvacacionParameterGeneral,solicitudvacacionReturnGeneral);
			
			return solicitudvacacionReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public SolicitudVacacionParameterReturnGeneral procesarAccionSolicitudVacacionsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<SolicitudVacacion> solicitudvacacions,SolicitudVacacionParameterReturnGeneral solicitudvacacionParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SolicitudVacacion.class.getSimpleName()+"-procesarAccionSolicitudVacacionsWithConnection");connexion.begin();			
			
			SolicitudVacacionParameterReturnGeneral solicitudvacacionReturnGeneral=new SolicitudVacacionParameterReturnGeneral();
	
			SolicitudVacacionLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,solicitudvacacions,solicitudvacacionParameterGeneral,solicitudvacacionReturnGeneral);
			
			this.connexion.commit();
			
			return solicitudvacacionReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public SolicitudVacacionParameterReturnGeneral procesarEventosSolicitudVacacions(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<SolicitudVacacion> solicitudvacacions,SolicitudVacacion solicitudvacacion,SolicitudVacacionParameterReturnGeneral solicitudvacacionParameterGeneral,Boolean isEsNuevoSolicitudVacacion,ArrayList<Classe> clases)throws Exception {
		 try {	
			SolicitudVacacionParameterReturnGeneral solicitudvacacionReturnGeneral=new SolicitudVacacionParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				solicitudvacacionReturnGeneral.setConRecargarPropiedades(true);
			}
			
			SolicitudVacacionLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,solicitudvacacions,solicitudvacacion,solicitudvacacionParameterGeneral,solicitudvacacionReturnGeneral,isEsNuevoSolicitudVacacion,clases);
			
			return solicitudvacacionReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public SolicitudVacacionParameterReturnGeneral procesarEventosSolicitudVacacionsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<SolicitudVacacion> solicitudvacacions,SolicitudVacacion solicitudvacacion,SolicitudVacacionParameterReturnGeneral solicitudvacacionParameterGeneral,Boolean isEsNuevoSolicitudVacacion,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SolicitudVacacion.class.getSimpleName()+"-procesarEventosSolicitudVacacionsWithConnection");connexion.begin();			
			
			SolicitudVacacionParameterReturnGeneral solicitudvacacionReturnGeneral=new SolicitudVacacionParameterReturnGeneral();
	
			solicitudvacacionReturnGeneral.setSolicitudVacacion(solicitudvacacion);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				solicitudvacacionReturnGeneral.setConRecargarPropiedades(true);
			}
			
			SolicitudVacacionLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,solicitudvacacions,solicitudvacacion,solicitudvacacionParameterGeneral,solicitudvacacionReturnGeneral,isEsNuevoSolicitudVacacion,clases);
			
			this.connexion.commit();
			
			return solicitudvacacionReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public SolicitudVacacionParameterReturnGeneral procesarImportacionSolicitudVacacionsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,SolicitudVacacionParameterReturnGeneral solicitudvacacionParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SolicitudVacacion.class.getSimpleName()+"-procesarImportacionSolicitudVacacionsWithConnection");connexion.begin();			
			
			SolicitudVacacionParameterReturnGeneral solicitudvacacionReturnGeneral=new SolicitudVacacionParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.solicitudvacacions=new ArrayList<SolicitudVacacion>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.solicitudvacacion=new SolicitudVacacion();
				
				
				if(conColumnasBase) {this.solicitudvacacion.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.solicitudvacacion.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.solicitudvacacion.setsecuencial(arrColumnas[iColumn++]);
				this.solicitudvacacion.setfecha_solicita(Funciones.ConvertToDate(arrColumnas[iColumn++]));
				this.solicitudvacacion.setfecha_ejecuta(Funciones.ConvertToDate(arrColumnas[iColumn++]));
				this.solicitudvacacion.setnumero_horas(Integer.parseInt(arrColumnas[iColumn++]));
				this.solicitudvacacion.setcosto_unitario(Double.parseDouble(arrColumnas[iColumn++]));
				this.solicitudvacacion.setcosto_total(Double.parseDouble(arrColumnas[iColumn++]));
			this.solicitudvacacion.setdescripcion(arrColumnas[iColumn++]);
				
				this.solicitudvacacions.add(this.solicitudvacacion);
			}
			
			this.saveSolicitudVacacions();
			
			this.connexion.commit();
			
			solicitudvacacionReturnGeneral.setConRetornoEstaProcesado(true);
			solicitudvacacionReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return solicitudvacacionReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarSolicitudVacacionsEliminados() throws Exception {				
		
		List<SolicitudVacacion> solicitudvacacionsAux= new ArrayList<SolicitudVacacion>();
		
		for(SolicitudVacacion solicitudvacacion:solicitudvacacions) {
			if(!solicitudvacacion.getIsDeleted()) {
				solicitudvacacionsAux.add(solicitudvacacion);
			}
		}
		
		solicitudvacacions=solicitudvacacionsAux;
	}
	
	public void quitarSolicitudVacacionsNulos() throws Exception {				
		
		List<SolicitudVacacion> solicitudvacacionsAux= new ArrayList<SolicitudVacacion>();
		
		for(SolicitudVacacion solicitudvacacion : this.solicitudvacacions) {
			if(solicitudvacacion==null) {
				solicitudvacacionsAux.add(solicitudvacacion);
			}
		}
		
		//this.solicitudvacacions=solicitudvacacionsAux;
		
		this.solicitudvacacions.removeAll(solicitudvacacionsAux);
	}
	
	public void getSetVersionRowSolicitudVacacionWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(solicitudvacacion.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((solicitudvacacion.getIsDeleted() || (solicitudvacacion.getIsChanged()&&!solicitudvacacion.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=solicitudvacacionDataAccess.getSetVersionRowSolicitudVacacion(connexion,solicitudvacacion.getId());
				
				if(!solicitudvacacion.getVersionRow().equals(timestamp)) {	
					solicitudvacacion.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				solicitudvacacion.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowSolicitudVacacion()throws Exception {	
		
		if(solicitudvacacion.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((solicitudvacacion.getIsDeleted() || (solicitudvacacion.getIsChanged()&&!solicitudvacacion.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=solicitudvacacionDataAccess.getSetVersionRowSolicitudVacacion(connexion,solicitudvacacion.getId());
			
			try {							
				if(!solicitudvacacion.getVersionRow().equals(timestamp)) {	
					solicitudvacacion.setVersionRow(timestamp);
				}
				
				solicitudvacacion.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowSolicitudVacacionsWithConnection()throws Exception {	
		if(solicitudvacacions!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(SolicitudVacacion solicitudvacacionAux:solicitudvacacions) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(solicitudvacacionAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(solicitudvacacionAux.getIsDeleted() || (solicitudvacacionAux.getIsChanged()&&!solicitudvacacionAux.getIsNew())) {
						
						timestamp=solicitudvacacionDataAccess.getSetVersionRowSolicitudVacacion(connexion,solicitudvacacionAux.getId());
						
						if(!solicitudvacacion.getVersionRow().equals(timestamp)) {	
							solicitudvacacionAux.setVersionRow(timestamp);
						}
								
						solicitudvacacionAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowSolicitudVacacions()throws Exception {	
		if(solicitudvacacions!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(SolicitudVacacion solicitudvacacionAux:solicitudvacacions) {
					if(solicitudvacacionAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(solicitudvacacionAux.getIsDeleted() || (solicitudvacacionAux.getIsChanged()&&!solicitudvacacionAux.getIsNew())) {
						
						timestamp=solicitudvacacionDataAccess.getSetVersionRowSolicitudVacacion(connexion,solicitudvacacionAux.getId());
						
						if(!solicitudvacacionAux.getVersionRow().equals(timestamp)) {	
							solicitudvacacionAux.setVersionRow(timestamp);
						}
						
													
						solicitudvacacionAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public SolicitudVacacionParameterReturnGeneral cargarCombosLoteForeignKeySolicitudVacacionWithConnection(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalEmpleadoJefe,String finalQueryGlobalEmpleado,String finalQueryGlobalEstructura,String finalQueryGlobalEstadoSolicitudNomi,String finalQueryGlobalFormato) throws Exception {
		SolicitudVacacionParameterReturnGeneral  solicitudvacacionReturnGeneral =new SolicitudVacacionParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SolicitudVacacion.class.getSimpleName()+"-cargarCombosLoteForeignKeySolicitudVacacionWithConnection");connexion.begin();
			
			solicitudvacacionReturnGeneral =new SolicitudVacacionParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			solicitudvacacionReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			solicitudvacacionReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Empleado> empleadojefesForeignKey=new ArrayList<Empleado>();
			EmpleadoLogic empleadojefeLogic=new EmpleadoLogic();
			empleadojefeLogic.setConnexion(this.connexion);
			empleadojefeLogic.getEmpleadoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpleadoJefe.equals("NONE")) {
				empleadojefeLogic.getTodosEmpleados(finalQueryGlobalEmpleadoJefe,new Pagination());
				empleadojefesForeignKey=empleadojefeLogic.getEmpleados();
			}

			solicitudvacacionReturnGeneral.setempleadojefesForeignKey(empleadojefesForeignKey);


			List<Empleado> empleadosForeignKey=new ArrayList<Empleado>();
			EmpleadoLogic empleadoLogic=new EmpleadoLogic();
			empleadoLogic.setConnexion(this.connexion);
			empleadoLogic.getEmpleadoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpleado.equals("NONE")) {
				empleadoLogic.getTodosEmpleados(finalQueryGlobalEmpleado,new Pagination());
				empleadosForeignKey=empleadoLogic.getEmpleados();
			}

			solicitudvacacionReturnGeneral.setempleadosForeignKey(empleadosForeignKey);


			List<Estructura> estructurasForeignKey=new ArrayList<Estructura>();
			EstructuraLogic estructuraLogic=new EstructuraLogic();
			estructuraLogic.setConnexion(this.connexion);
			estructuraLogic.getEstructuraDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEstructura.equals("NONE")) {
				estructuraLogic.getTodosEstructuras(finalQueryGlobalEstructura,new Pagination());
				estructurasForeignKey=estructuraLogic.getEstructuras();
			}

			solicitudvacacionReturnGeneral.setestructurasForeignKey(estructurasForeignKey);


			List<EstadoSolicitudNomi> estadosolicitudnomisForeignKey=new ArrayList<EstadoSolicitudNomi>();
			EstadoSolicitudNomiLogic estadosolicitudnomiLogic=new EstadoSolicitudNomiLogic();
			estadosolicitudnomiLogic.setConnexion(this.connexion);
			estadosolicitudnomiLogic.getEstadoSolicitudNomiDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEstadoSolicitudNomi.equals("NONE")) {
				estadosolicitudnomiLogic.getTodosEstadoSolicitudNomis(finalQueryGlobalEstadoSolicitudNomi,new Pagination());
				estadosolicitudnomisForeignKey=estadosolicitudnomiLogic.getEstadoSolicitudNomis();
			}

			solicitudvacacionReturnGeneral.setestadosolicitudnomisForeignKey(estadosolicitudnomisForeignKey);


			List<Formato> formatosForeignKey=new ArrayList<Formato>();
			FormatoLogic formatoLogic=new FormatoLogic();
			formatoLogic.setConnexion(this.connexion);
			formatoLogic.getFormatoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalFormato.equals("NONE")) {
				formatoLogic.getTodosFormatos(finalQueryGlobalFormato,new Pagination());
				formatosForeignKey=formatoLogic.getFormatos();
			}

			solicitudvacacionReturnGeneral.setformatosForeignKey(formatosForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return solicitudvacacionReturnGeneral;
	}
	
	public SolicitudVacacionParameterReturnGeneral cargarCombosLoteForeignKeySolicitudVacacion(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalEmpleadoJefe,String finalQueryGlobalEmpleado,String finalQueryGlobalEstructura,String finalQueryGlobalEstadoSolicitudNomi,String finalQueryGlobalFormato) throws Exception {
		SolicitudVacacionParameterReturnGeneral  solicitudvacacionReturnGeneral =new SolicitudVacacionParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			solicitudvacacionReturnGeneral =new SolicitudVacacionParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			solicitudvacacionReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			solicitudvacacionReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Empleado> empleadojefesForeignKey=new ArrayList<Empleado>();
			EmpleadoLogic empleadojefeLogic=new EmpleadoLogic();
			empleadojefeLogic.setConnexion(this.connexion);
			empleadojefeLogic.getEmpleadoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpleadoJefe.equals("NONE")) {
				empleadojefeLogic.getTodosEmpleados(finalQueryGlobalEmpleadoJefe,new Pagination());
				empleadojefesForeignKey=empleadojefeLogic.getEmpleados();
			}

			solicitudvacacionReturnGeneral.setempleadojefesForeignKey(empleadojefesForeignKey);


			List<Empleado> empleadosForeignKey=new ArrayList<Empleado>();
			EmpleadoLogic empleadoLogic=new EmpleadoLogic();
			empleadoLogic.setConnexion(this.connexion);
			empleadoLogic.getEmpleadoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpleado.equals("NONE")) {
				empleadoLogic.getTodosEmpleados(finalQueryGlobalEmpleado,new Pagination());
				empleadosForeignKey=empleadoLogic.getEmpleados();
			}

			solicitudvacacionReturnGeneral.setempleadosForeignKey(empleadosForeignKey);


			List<Estructura> estructurasForeignKey=new ArrayList<Estructura>();
			EstructuraLogic estructuraLogic=new EstructuraLogic();
			estructuraLogic.setConnexion(this.connexion);
			estructuraLogic.getEstructuraDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEstructura.equals("NONE")) {
				estructuraLogic.getTodosEstructuras(finalQueryGlobalEstructura,new Pagination());
				estructurasForeignKey=estructuraLogic.getEstructuras();
			}

			solicitudvacacionReturnGeneral.setestructurasForeignKey(estructurasForeignKey);


			List<EstadoSolicitudNomi> estadosolicitudnomisForeignKey=new ArrayList<EstadoSolicitudNomi>();
			EstadoSolicitudNomiLogic estadosolicitudnomiLogic=new EstadoSolicitudNomiLogic();
			estadosolicitudnomiLogic.setConnexion(this.connexion);
			estadosolicitudnomiLogic.getEstadoSolicitudNomiDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEstadoSolicitudNomi.equals("NONE")) {
				estadosolicitudnomiLogic.getTodosEstadoSolicitudNomis(finalQueryGlobalEstadoSolicitudNomi,new Pagination());
				estadosolicitudnomisForeignKey=estadosolicitudnomiLogic.getEstadoSolicitudNomis();
			}

			solicitudvacacionReturnGeneral.setestadosolicitudnomisForeignKey(estadosolicitudnomisForeignKey);


			List<Formato> formatosForeignKey=new ArrayList<Formato>();
			FormatoLogic formatoLogic=new FormatoLogic();
			formatoLogic.setConnexion(this.connexion);
			formatoLogic.getFormatoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalFormato.equals("NONE")) {
				formatoLogic.getTodosFormatos(finalQueryGlobalFormato,new Pagination());
				formatosForeignKey=formatoLogic.getFormatos();
			}

			solicitudvacacionReturnGeneral.setformatosForeignKey(formatosForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return solicitudvacacionReturnGeneral;
	}
	
	
	public void deepLoad(SolicitudVacacion solicitudvacacion,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			SolicitudVacacionLogicAdditional.updateSolicitudVacacionToGet(solicitudvacacion,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		solicitudvacacion.setEmpresa(solicitudvacacionDataAccess.getEmpresa(connexion,solicitudvacacion));
		solicitudvacacion.setSucursal(solicitudvacacionDataAccess.getSucursal(connexion,solicitudvacacion));
		solicitudvacacion.setEmpleadoJefe(solicitudvacacionDataAccess.getEmpleadoJefe(connexion,solicitudvacacion));
		solicitudvacacion.setEmpleado(solicitudvacacionDataAccess.getEmpleado(connexion,solicitudvacacion));
		solicitudvacacion.setEstructura(solicitudvacacionDataAccess.getEstructura(connexion,solicitudvacacion));
		solicitudvacacion.setEstadoSolicitudNomi(solicitudvacacionDataAccess.getEstadoSolicitudNomi(connexion,solicitudvacacion));
		solicitudvacacion.setFormato(solicitudvacacionDataAccess.getFormato(connexion,solicitudvacacion));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				solicitudvacacion.setEmpresa(solicitudvacacionDataAccess.getEmpresa(connexion,solicitudvacacion));
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				solicitudvacacion.setSucursal(solicitudvacacionDataAccess.getSucursal(connexion,solicitudvacacion));
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				solicitudvacacion.setEmpleadoJefe(solicitudvacacionDataAccess.getEmpleadoJefe(connexion,solicitudvacacion));
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				solicitudvacacion.setEmpleado(solicitudvacacionDataAccess.getEmpleado(connexion,solicitudvacacion));
				continue;
			}

			if(clas.clas.equals(Estructura.class)) {
				solicitudvacacion.setEstructura(solicitudvacacionDataAccess.getEstructura(connexion,solicitudvacacion));
				continue;
			}

			if(clas.clas.equals(EstadoSolicitudNomi.class)) {
				solicitudvacacion.setEstadoSolicitudNomi(solicitudvacacionDataAccess.getEstadoSolicitudNomi(connexion,solicitudvacacion));
				continue;
			}

			if(clas.clas.equals(Formato.class)) {
				solicitudvacacion.setFormato(solicitudvacacionDataAccess.getFormato(connexion,solicitudvacacion));
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
			solicitudvacacion.setEmpresa(solicitudvacacionDataAccess.getEmpresa(connexion,solicitudvacacion));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			solicitudvacacion.setSucursal(solicitudvacacionDataAccess.getSucursal(connexion,solicitudvacacion));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Empleado.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			solicitudvacacion.setEmpleadoJefe(solicitudvacacionDataAccess.getEmpleadoJefe(connexion,solicitudvacacion));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Empleado.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			solicitudvacacion.setEmpleado(solicitudvacacionDataAccess.getEmpleado(connexion,solicitudvacacion));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Estructura.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			solicitudvacacion.setEstructura(solicitudvacacionDataAccess.getEstructura(connexion,solicitudvacacion));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(EstadoSolicitudNomi.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			solicitudvacacion.setEstadoSolicitudNomi(solicitudvacacionDataAccess.getEstadoSolicitudNomi(connexion,solicitudvacacion));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Formato.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			solicitudvacacion.setFormato(solicitudvacacionDataAccess.getFormato(connexion,solicitudvacacion));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		solicitudvacacion.setEmpresa(solicitudvacacionDataAccess.getEmpresa(connexion,solicitudvacacion));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(solicitudvacacion.getEmpresa(),isDeep,deepLoadType,clases);
				
		solicitudvacacion.setSucursal(solicitudvacacionDataAccess.getSucursal(connexion,solicitudvacacion));
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(solicitudvacacion.getSucursal(),isDeep,deepLoadType,clases);
				
		solicitudvacacion.setEmpleadoJefe(solicitudvacacionDataAccess.getEmpleadoJefe(connexion,solicitudvacacion));
		EmpleadoLogic empleadojefeLogic= new EmpleadoLogic(connexion);
		empleadojefeLogic.deepLoad(solicitudvacacion.getEmpleadoJefe(),isDeep,deepLoadType,clases);
				
		solicitudvacacion.setEmpleado(solicitudvacacionDataAccess.getEmpleado(connexion,solicitudvacacion));
		EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
		empleadoLogic.deepLoad(solicitudvacacion.getEmpleado(),isDeep,deepLoadType,clases);
				
		solicitudvacacion.setEstructura(solicitudvacacionDataAccess.getEstructura(connexion,solicitudvacacion));
		EstructuraLogic estructuraLogic= new EstructuraLogic(connexion);
		estructuraLogic.deepLoad(solicitudvacacion.getEstructura(),isDeep,deepLoadType,clases);
				
		solicitudvacacion.setEstadoSolicitudNomi(solicitudvacacionDataAccess.getEstadoSolicitudNomi(connexion,solicitudvacacion));
		EstadoSolicitudNomiLogic estadosolicitudnomiLogic= new EstadoSolicitudNomiLogic(connexion);
		estadosolicitudnomiLogic.deepLoad(solicitudvacacion.getEstadoSolicitudNomi(),isDeep,deepLoadType,clases);
				
		solicitudvacacion.setFormato(solicitudvacacionDataAccess.getFormato(connexion,solicitudvacacion));
		FormatoLogic formatoLogic= new FormatoLogic(connexion);
		formatoLogic.deepLoad(solicitudvacacion.getFormato(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				solicitudvacacion.setEmpresa(solicitudvacacionDataAccess.getEmpresa(connexion,solicitudvacacion));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(solicitudvacacion.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				solicitudvacacion.setSucursal(solicitudvacacionDataAccess.getSucursal(connexion,solicitudvacacion));
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepLoad(solicitudvacacion.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				solicitudvacacion.setEmpleadoJefe(solicitudvacacionDataAccess.getEmpleadoJefe(connexion,solicitudvacacion));
				EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
				empleadoLogic.deepLoad(solicitudvacacion.getEmpleadoJefe(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				solicitudvacacion.setEmpleado(solicitudvacacionDataAccess.getEmpleado(connexion,solicitudvacacion));
				EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
				empleadoLogic.deepLoad(solicitudvacacion.getEmpleado(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Estructura.class)) {
				solicitudvacacion.setEstructura(solicitudvacacionDataAccess.getEstructura(connexion,solicitudvacacion));
				EstructuraLogic estructuraLogic= new EstructuraLogic(connexion);
				estructuraLogic.deepLoad(solicitudvacacion.getEstructura(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(EstadoSolicitudNomi.class)) {
				solicitudvacacion.setEstadoSolicitudNomi(solicitudvacacionDataAccess.getEstadoSolicitudNomi(connexion,solicitudvacacion));
				EstadoSolicitudNomiLogic estadosolicitudnomiLogic= new EstadoSolicitudNomiLogic(connexion);
				estadosolicitudnomiLogic.deepLoad(solicitudvacacion.getEstadoSolicitudNomi(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Formato.class)) {
				solicitudvacacion.setFormato(solicitudvacacionDataAccess.getFormato(connexion,solicitudvacacion));
				FormatoLogic formatoLogic= new FormatoLogic(connexion);
				formatoLogic.deepLoad(solicitudvacacion.getFormato(),isDeep,deepLoadType,clases);				
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
			solicitudvacacion.setEmpresa(solicitudvacacionDataAccess.getEmpresa(connexion,solicitudvacacion));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(solicitudvacacion.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			solicitudvacacion.setSucursal(solicitudvacacionDataAccess.getSucursal(connexion,solicitudvacacion));
			SucursalLogic sucursalLogic= new SucursalLogic(connexion);
			sucursalLogic.deepLoad(solicitudvacacion.getSucursal(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Empleado.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			solicitudvacacion.setEmpleadoJefe(solicitudvacacionDataAccess.getEmpleadoJefe(connexion,solicitudvacacion));
			EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
			empleadoLogic.deepLoad(solicitudvacacion.getEmpleadoJefe(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Empleado.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			solicitudvacacion.setEmpleado(solicitudvacacionDataAccess.getEmpleado(connexion,solicitudvacacion));
			EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
			empleadoLogic.deepLoad(solicitudvacacion.getEmpleado(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Estructura.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			solicitudvacacion.setEstructura(solicitudvacacionDataAccess.getEstructura(connexion,solicitudvacacion));
			EstructuraLogic estructuraLogic= new EstructuraLogic(connexion);
			estructuraLogic.deepLoad(solicitudvacacion.getEstructura(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(EstadoSolicitudNomi.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			solicitudvacacion.setEstadoSolicitudNomi(solicitudvacacionDataAccess.getEstadoSolicitudNomi(connexion,solicitudvacacion));
			EstadoSolicitudNomiLogic estadosolicitudnomiLogic= new EstadoSolicitudNomiLogic(connexion);
			estadosolicitudnomiLogic.deepLoad(solicitudvacacion.getEstadoSolicitudNomi(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Formato.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			solicitudvacacion.setFormato(solicitudvacacionDataAccess.getFormato(connexion,solicitudvacacion));
			FormatoLogic formatoLogic= new FormatoLogic(connexion);
			formatoLogic.deepLoad(solicitudvacacion.getFormato(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(SolicitudVacacion solicitudvacacion,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			SolicitudVacacionLogicAdditional.updateSolicitudVacacionToSave(solicitudvacacion,this.arrDatoGeneral);
			
SolicitudVacacionDataAccess.save(solicitudvacacion, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(solicitudvacacion.getEmpresa(),connexion);

		SucursalDataAccess.save(solicitudvacacion.getSucursal(),connexion);

		EmpleadoDataAccess.save(solicitudvacacion.getEmpleadoJefe(),connexion);

		EmpleadoDataAccess.save(solicitudvacacion.getEmpleado(),connexion);

		EstructuraDataAccess.save(solicitudvacacion.getEstructura(),connexion);

		EstadoSolicitudNomiDataAccess.save(solicitudvacacion.getEstadoSolicitudNomi(),connexion);

		FormatoDataAccess.save(solicitudvacacion.getFormato(),connexion);
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(solicitudvacacion.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(solicitudvacacion.getSucursal(),connexion);
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				EmpleadoDataAccess.save(solicitudvacacion.getEmpleadoJefe(),connexion);
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				EmpleadoDataAccess.save(solicitudvacacion.getEmpleado(),connexion);
				continue;
			}

			if(clas.clas.equals(Estructura.class)) {
				EstructuraDataAccess.save(solicitudvacacion.getEstructura(),connexion);
				continue;
			}

			if(clas.clas.equals(EstadoSolicitudNomi.class)) {
				EstadoSolicitudNomiDataAccess.save(solicitudvacacion.getEstadoSolicitudNomi(),connexion);
				continue;
			}

			if(clas.clas.equals(Formato.class)) {
				FormatoDataAccess.save(solicitudvacacion.getFormato(),connexion);
				continue;
			}

		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(solicitudvacacion.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(solicitudvacacion.getEmpresa(),isDeep,deepLoadType,clases);
				

		SucursalDataAccess.save(solicitudvacacion.getSucursal(),connexion);
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(solicitudvacacion.getSucursal(),isDeep,deepLoadType,clases);
				

		EmpleadoDataAccess.save(solicitudvacacion.getEmpleadoJefe(),connexion);
		EmpleadoLogic empleadojefeLogic= new EmpleadoLogic(connexion);
		empleadojefeLogic.deepLoad(solicitudvacacion.getEmpleadoJefe(),isDeep,deepLoadType,clases);
				

		EmpleadoDataAccess.save(solicitudvacacion.getEmpleado(),connexion);
		EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
		empleadoLogic.deepLoad(solicitudvacacion.getEmpleado(),isDeep,deepLoadType,clases);
				

		EstructuraDataAccess.save(solicitudvacacion.getEstructura(),connexion);
		EstructuraLogic estructuraLogic= new EstructuraLogic(connexion);
		estructuraLogic.deepLoad(solicitudvacacion.getEstructura(),isDeep,deepLoadType,clases);
				

		EstadoSolicitudNomiDataAccess.save(solicitudvacacion.getEstadoSolicitudNomi(),connexion);
		EstadoSolicitudNomiLogic estadosolicitudnomiLogic= new EstadoSolicitudNomiLogic(connexion);
		estadosolicitudnomiLogic.deepLoad(solicitudvacacion.getEstadoSolicitudNomi(),isDeep,deepLoadType,clases);
				

		FormatoDataAccess.save(solicitudvacacion.getFormato(),connexion);
		FormatoLogic formatoLogic= new FormatoLogic(connexion);
		formatoLogic.deepLoad(solicitudvacacion.getFormato(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(solicitudvacacion.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(solicitudvacacion.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(solicitudvacacion.getSucursal(),connexion);
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepSave(solicitudvacacion.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				EmpleadoDataAccess.save(solicitudvacacion.getEmpleadoJefe(),connexion);
				EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
				empleadoLogic.deepSave(solicitudvacacion.getEmpleadoJefe(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				EmpleadoDataAccess.save(solicitudvacacion.getEmpleado(),connexion);
				EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
				empleadoLogic.deepSave(solicitudvacacion.getEmpleado(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Estructura.class)) {
				EstructuraDataAccess.save(solicitudvacacion.getEstructura(),connexion);
				EstructuraLogic estructuraLogic= new EstructuraLogic(connexion);
				estructuraLogic.deepSave(solicitudvacacion.getEstructura(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(EstadoSolicitudNomi.class)) {
				EstadoSolicitudNomiDataAccess.save(solicitudvacacion.getEstadoSolicitudNomi(),connexion);
				EstadoSolicitudNomiLogic estadosolicitudnomiLogic= new EstadoSolicitudNomiLogic(connexion);
				estadosolicitudnomiLogic.deepSave(solicitudvacacion.getEstadoSolicitudNomi(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Formato.class)) {
				FormatoDataAccess.save(solicitudvacacion.getFormato(),connexion);
				FormatoLogic formatoLogic= new FormatoLogic(connexion);
				formatoLogic.deepSave(solicitudvacacion.getFormato(),isDeep,deepLoadType,clases);				
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
			this.getNewConnexionToDeep(SolicitudVacacion.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(solicitudvacacion,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				SolicitudVacacionConstantesFunciones.refrescarForeignKeysDescripcionesSolicitudVacacion(solicitudvacacion);
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
			this.deepLoad(this.solicitudvacacion,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				SolicitudVacacionConstantesFunciones.refrescarForeignKeysDescripcionesSolicitudVacacion(this.solicitudvacacion);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(SolicitudVacacion.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(solicitudvacacions!=null) {
				for(SolicitudVacacion solicitudvacacion:solicitudvacacions) {
					this.deepLoad(solicitudvacacion,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					SolicitudVacacionConstantesFunciones.refrescarForeignKeysDescripcionesSolicitudVacacion(solicitudvacacions);
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
			if(solicitudvacacions!=null) {
				for(SolicitudVacacion solicitudvacacion:solicitudvacacions) {
					this.deepLoad(solicitudvacacion,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					SolicitudVacacionConstantesFunciones.refrescarForeignKeysDescripcionesSolicitudVacacion(solicitudvacacions);
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
			this.getNewConnexionToDeep(SolicitudVacacion.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(solicitudvacacion,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(SolicitudVacacion.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(solicitudvacacions!=null) {
				for(SolicitudVacacion solicitudvacacion:solicitudvacacions) {
					this.deepSave(solicitudvacacion,isDeep,deepLoadType,clases);
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
			if(solicitudvacacions!=null) {
				for(SolicitudVacacion solicitudvacacion:solicitudvacacions) {
					this.deepSave(solicitudvacacion,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getSolicitudVacacionsFK_IdEmpleadoWithConnection(String sFinalQuery,Pagination pagination,Long id_empleado)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SolicitudVacacion.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpleado= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpleado.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empleado,SolicitudVacacionConstantesFunciones.IDEMPLEADO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpleado);

			SolicitudVacacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpleado","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			solicitudvacacions=solicitudvacacionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				SolicitudVacacionConstantesFunciones.refrescarForeignKeysDescripcionesSolicitudVacacion(this.solicitudvacacions);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getSolicitudVacacionsFK_IdEmpleado(String sFinalQuery,Pagination pagination,Long id_empleado)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpleado= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpleado.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empleado,SolicitudVacacionConstantesFunciones.IDEMPLEADO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpleado);

			SolicitudVacacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpleado","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			solicitudvacacions=solicitudvacacionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				SolicitudVacacionConstantesFunciones.refrescarForeignKeysDescripcionesSolicitudVacacion(this.solicitudvacacions);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getSolicitudVacacionsFK_IdEmpleadoJefeWithConnection(String sFinalQuery,Pagination pagination,Long id_empleado_jefe)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SolicitudVacacion.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpleadoJefe= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpleadoJefe.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empleado_jefe,SolicitudVacacionConstantesFunciones.IDEMPLEADOJEFE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpleadoJefe);

			SolicitudVacacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpleadoJefe","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			solicitudvacacions=solicitudvacacionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				SolicitudVacacionConstantesFunciones.refrescarForeignKeysDescripcionesSolicitudVacacion(this.solicitudvacacions);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getSolicitudVacacionsFK_IdEmpleadoJefe(String sFinalQuery,Pagination pagination,Long id_empleado_jefe)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpleadoJefe= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpleadoJefe.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empleado_jefe,SolicitudVacacionConstantesFunciones.IDEMPLEADOJEFE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpleadoJefe);

			SolicitudVacacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpleadoJefe","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			solicitudvacacions=solicitudvacacionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				SolicitudVacacionConstantesFunciones.refrescarForeignKeysDescripcionesSolicitudVacacion(this.solicitudvacacions);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getSolicitudVacacionsFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SolicitudVacacion.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,SolicitudVacacionConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			SolicitudVacacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			solicitudvacacions=solicitudvacacionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				SolicitudVacacionConstantesFunciones.refrescarForeignKeysDescripcionesSolicitudVacacion(this.solicitudvacacions);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getSolicitudVacacionsFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,SolicitudVacacionConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			SolicitudVacacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			solicitudvacacions=solicitudvacacionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				SolicitudVacacionConstantesFunciones.refrescarForeignKeysDescripcionesSolicitudVacacion(this.solicitudvacacions);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getSolicitudVacacionsFK_IdEstadoSolicitudNomiWithConnection(String sFinalQuery,Pagination pagination,Long id_estado_solicitud_nomi)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SolicitudVacacion.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEstadoSolicitudNomi= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEstadoSolicitudNomi.setParameterSelectionGeneralEqual(ParameterType.LONG,id_estado_solicitud_nomi,SolicitudVacacionConstantesFunciones.IDESTADOSOLICITUDNOMI,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEstadoSolicitudNomi);

			SolicitudVacacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEstadoSolicitudNomi","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			solicitudvacacions=solicitudvacacionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				SolicitudVacacionConstantesFunciones.refrescarForeignKeysDescripcionesSolicitudVacacion(this.solicitudvacacions);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getSolicitudVacacionsFK_IdEstadoSolicitudNomi(String sFinalQuery,Pagination pagination,Long id_estado_solicitud_nomi)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEstadoSolicitudNomi= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEstadoSolicitudNomi.setParameterSelectionGeneralEqual(ParameterType.LONG,id_estado_solicitud_nomi,SolicitudVacacionConstantesFunciones.IDESTADOSOLICITUDNOMI,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEstadoSolicitudNomi);

			SolicitudVacacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEstadoSolicitudNomi","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			solicitudvacacions=solicitudvacacionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				SolicitudVacacionConstantesFunciones.refrescarForeignKeysDescripcionesSolicitudVacacion(this.solicitudvacacions);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getSolicitudVacacionsFK_IdEstructuraWithConnection(String sFinalQuery,Pagination pagination,Long id_estructura)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SolicitudVacacion.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEstructura= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEstructura.setParameterSelectionGeneralEqual(ParameterType.LONG,id_estructura,SolicitudVacacionConstantesFunciones.IDESTRUCTURA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEstructura);

			SolicitudVacacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEstructura","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			solicitudvacacions=solicitudvacacionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				SolicitudVacacionConstantesFunciones.refrescarForeignKeysDescripcionesSolicitudVacacion(this.solicitudvacacions);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getSolicitudVacacionsFK_IdEstructura(String sFinalQuery,Pagination pagination,Long id_estructura)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEstructura= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEstructura.setParameterSelectionGeneralEqual(ParameterType.LONG,id_estructura,SolicitudVacacionConstantesFunciones.IDESTRUCTURA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEstructura);

			SolicitudVacacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEstructura","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			solicitudvacacions=solicitudvacacionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				SolicitudVacacionConstantesFunciones.refrescarForeignKeysDescripcionesSolicitudVacacion(this.solicitudvacacions);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getSolicitudVacacionsFK_IdFormatoWithConnection(String sFinalQuery,Pagination pagination,Long id_formato)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SolicitudVacacion.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidFormato= new ParameterSelectionGeneral();
			parameterSelectionGeneralidFormato.setParameterSelectionGeneralEqual(ParameterType.LONG,id_formato,SolicitudVacacionConstantesFunciones.IDFORMATO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidFormato);

			SolicitudVacacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdFormato","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			solicitudvacacions=solicitudvacacionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				SolicitudVacacionConstantesFunciones.refrescarForeignKeysDescripcionesSolicitudVacacion(this.solicitudvacacions);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getSolicitudVacacionsFK_IdFormato(String sFinalQuery,Pagination pagination,Long id_formato)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidFormato= new ParameterSelectionGeneral();
			parameterSelectionGeneralidFormato.setParameterSelectionGeneralEqual(ParameterType.LONG,id_formato,SolicitudVacacionConstantesFunciones.IDFORMATO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidFormato);

			SolicitudVacacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdFormato","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			solicitudvacacions=solicitudvacacionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				SolicitudVacacionConstantesFunciones.refrescarForeignKeysDescripcionesSolicitudVacacion(this.solicitudvacacions);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getSolicitudVacacionsFK_IdSucursalWithConnection(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SolicitudVacacion.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,SolicitudVacacionConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			SolicitudVacacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			solicitudvacacions=solicitudvacacionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				SolicitudVacacionConstantesFunciones.refrescarForeignKeysDescripcionesSolicitudVacacion(this.solicitudvacacions);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getSolicitudVacacionsFK_IdSucursal(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,SolicitudVacacionConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			SolicitudVacacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			solicitudvacacions=solicitudvacacionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				SolicitudVacacionConstantesFunciones.refrescarForeignKeysDescripcionesSolicitudVacacion(this.solicitudvacacions);
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
			if(SolicitudVacacionConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,SolicitudVacacionDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,SolicitudVacacion solicitudvacacion,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(SolicitudVacacionConstantesFunciones.ISCONAUDITORIA) {
				if(solicitudvacacion.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,SolicitudVacacionDataAccess.TABLENAME, solicitudvacacion.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(SolicitudVacacionConstantesFunciones.ISCONAUDITORIADETALLE) {
						////SolicitudVacacionLogic.registrarAuditoriaDetallesSolicitudVacacion(connexion,solicitudvacacion,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(solicitudvacacion.getIsDeleted()) {
					/*if(!solicitudvacacion.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,SolicitudVacacionDataAccess.TABLENAME, solicitudvacacion.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////SolicitudVacacionLogic.registrarAuditoriaDetallesSolicitudVacacion(connexion,solicitudvacacion,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,SolicitudVacacionDataAccess.TABLENAME, solicitudvacacion.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(solicitudvacacion.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,SolicitudVacacionDataAccess.TABLENAME, solicitudvacacion.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(SolicitudVacacionConstantesFunciones.ISCONAUDITORIADETALLE) {
						////SolicitudVacacionLogic.registrarAuditoriaDetallesSolicitudVacacion(connexion,solicitudvacacion,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesSolicitudVacacion(Connexion connexion,SolicitudVacacion solicitudvacacion)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(solicitudvacacion.getIsNew()||!solicitudvacacion.getid_empresa().equals(solicitudvacacion.getSolicitudVacacionOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(solicitudvacacion.getSolicitudVacacionOriginal().getid_empresa()!=null)
				{
					strValorActual=solicitudvacacion.getSolicitudVacacionOriginal().getid_empresa().toString();
				}
				if(solicitudvacacion.getid_empresa()!=null)
				{
					strValorNuevo=solicitudvacacion.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),SolicitudVacacionConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(solicitudvacacion.getIsNew()||!solicitudvacacion.getid_sucursal().equals(solicitudvacacion.getSolicitudVacacionOriginal().getid_sucursal()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(solicitudvacacion.getSolicitudVacacionOriginal().getid_sucursal()!=null)
				{
					strValorActual=solicitudvacacion.getSolicitudVacacionOriginal().getid_sucursal().toString();
				}
				if(solicitudvacacion.getid_sucursal()!=null)
				{
					strValorNuevo=solicitudvacacion.getid_sucursal().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),SolicitudVacacionConstantesFunciones.IDSUCURSAL,strValorActual,strValorNuevo);
			}	
			
			if(solicitudvacacion.getIsNew()||!solicitudvacacion.getid_empleado_jefe().equals(solicitudvacacion.getSolicitudVacacionOriginal().getid_empleado_jefe()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(solicitudvacacion.getSolicitudVacacionOriginal().getid_empleado_jefe()!=null)
				{
					strValorActual=solicitudvacacion.getSolicitudVacacionOriginal().getid_empleado_jefe().toString();
				}
				if(solicitudvacacion.getid_empleado_jefe()!=null)
				{
					strValorNuevo=solicitudvacacion.getid_empleado_jefe().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),SolicitudVacacionConstantesFunciones.IDEMPLEADOJEFE,strValorActual,strValorNuevo);
			}	
			
			if(solicitudvacacion.getIsNew()||!solicitudvacacion.getid_empleado().equals(solicitudvacacion.getSolicitudVacacionOriginal().getid_empleado()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(solicitudvacacion.getSolicitudVacacionOriginal().getid_empleado()!=null)
				{
					strValorActual=solicitudvacacion.getSolicitudVacacionOriginal().getid_empleado().toString();
				}
				if(solicitudvacacion.getid_empleado()!=null)
				{
					strValorNuevo=solicitudvacacion.getid_empleado().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),SolicitudVacacionConstantesFunciones.IDEMPLEADO,strValorActual,strValorNuevo);
			}	
			
			if(solicitudvacacion.getIsNew()||!solicitudvacacion.getid_estructura().equals(solicitudvacacion.getSolicitudVacacionOriginal().getid_estructura()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(solicitudvacacion.getSolicitudVacacionOriginal().getid_estructura()!=null)
				{
					strValorActual=solicitudvacacion.getSolicitudVacacionOriginal().getid_estructura().toString();
				}
				if(solicitudvacacion.getid_estructura()!=null)
				{
					strValorNuevo=solicitudvacacion.getid_estructura().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),SolicitudVacacionConstantesFunciones.IDESTRUCTURA,strValorActual,strValorNuevo);
			}	
			
			if(solicitudvacacion.getIsNew()||!solicitudvacacion.getid_estado_solicitud_nomi().equals(solicitudvacacion.getSolicitudVacacionOriginal().getid_estado_solicitud_nomi()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(solicitudvacacion.getSolicitudVacacionOriginal().getid_estado_solicitud_nomi()!=null)
				{
					strValorActual=solicitudvacacion.getSolicitudVacacionOriginal().getid_estado_solicitud_nomi().toString();
				}
				if(solicitudvacacion.getid_estado_solicitud_nomi()!=null)
				{
					strValorNuevo=solicitudvacacion.getid_estado_solicitud_nomi().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),SolicitudVacacionConstantesFunciones.IDESTADOSOLICITUDNOMI,strValorActual,strValorNuevo);
			}	
			
			if(solicitudvacacion.getIsNew()||!solicitudvacacion.getid_formato().equals(solicitudvacacion.getSolicitudVacacionOriginal().getid_formato()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(solicitudvacacion.getSolicitudVacacionOriginal().getid_formato()!=null)
				{
					strValorActual=solicitudvacacion.getSolicitudVacacionOriginal().getid_formato().toString();
				}
				if(solicitudvacacion.getid_formato()!=null)
				{
					strValorNuevo=solicitudvacacion.getid_formato().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),SolicitudVacacionConstantesFunciones.IDFORMATO,strValorActual,strValorNuevo);
			}	
			
			if(solicitudvacacion.getIsNew()||!solicitudvacacion.getsecuencial().equals(solicitudvacacion.getSolicitudVacacionOriginal().getsecuencial()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(solicitudvacacion.getSolicitudVacacionOriginal().getsecuencial()!=null)
				{
					strValorActual=solicitudvacacion.getSolicitudVacacionOriginal().getsecuencial();
				}
				if(solicitudvacacion.getsecuencial()!=null)
				{
					strValorNuevo=solicitudvacacion.getsecuencial() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),SolicitudVacacionConstantesFunciones.SECUENCIAL,strValorActual,strValorNuevo);
			}	
			
			if(solicitudvacacion.getIsNew()||!solicitudvacacion.getfecha_solicita().equals(solicitudvacacion.getSolicitudVacacionOriginal().getfecha_solicita()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(solicitudvacacion.getSolicitudVacacionOriginal().getfecha_solicita()!=null)
				{
					strValorActual=solicitudvacacion.getSolicitudVacacionOriginal().getfecha_solicita().toString();
				}
				if(solicitudvacacion.getfecha_solicita()!=null)
				{
					strValorNuevo=solicitudvacacion.getfecha_solicita().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),SolicitudVacacionConstantesFunciones.FECHASOLICITA,strValorActual,strValorNuevo);
			}	
			
			if(solicitudvacacion.getIsNew()||!solicitudvacacion.getfecha_ejecuta().equals(solicitudvacacion.getSolicitudVacacionOriginal().getfecha_ejecuta()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(solicitudvacacion.getSolicitudVacacionOriginal().getfecha_ejecuta()!=null)
				{
					strValorActual=solicitudvacacion.getSolicitudVacacionOriginal().getfecha_ejecuta().toString();
				}
				if(solicitudvacacion.getfecha_ejecuta()!=null)
				{
					strValorNuevo=solicitudvacacion.getfecha_ejecuta().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),SolicitudVacacionConstantesFunciones.FECHAEJECUTA,strValorActual,strValorNuevo);
			}	
			
			if(solicitudvacacion.getIsNew()||!solicitudvacacion.getnumero_horas().equals(solicitudvacacion.getSolicitudVacacionOriginal().getnumero_horas()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(solicitudvacacion.getSolicitudVacacionOriginal().getnumero_horas()!=null)
				{
					strValorActual=solicitudvacacion.getSolicitudVacacionOriginal().getnumero_horas().toString();
				}
				if(solicitudvacacion.getnumero_horas()!=null)
				{
					strValorNuevo=solicitudvacacion.getnumero_horas().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),SolicitudVacacionConstantesFunciones.NUMEROHORAS,strValorActual,strValorNuevo);
			}	
			
			if(solicitudvacacion.getIsNew()||!solicitudvacacion.getcosto_unitario().equals(solicitudvacacion.getSolicitudVacacionOriginal().getcosto_unitario()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(solicitudvacacion.getSolicitudVacacionOriginal().getcosto_unitario()!=null)
				{
					strValorActual=solicitudvacacion.getSolicitudVacacionOriginal().getcosto_unitario().toString();
				}
				if(solicitudvacacion.getcosto_unitario()!=null)
				{
					strValorNuevo=solicitudvacacion.getcosto_unitario().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),SolicitudVacacionConstantesFunciones.COSTOUNITARIO,strValorActual,strValorNuevo);
			}	
			
			if(solicitudvacacion.getIsNew()||!solicitudvacacion.getcosto_total().equals(solicitudvacacion.getSolicitudVacacionOriginal().getcosto_total()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(solicitudvacacion.getSolicitudVacacionOriginal().getcosto_total()!=null)
				{
					strValorActual=solicitudvacacion.getSolicitudVacacionOriginal().getcosto_total().toString();
				}
				if(solicitudvacacion.getcosto_total()!=null)
				{
					strValorNuevo=solicitudvacacion.getcosto_total().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),SolicitudVacacionConstantesFunciones.COSTOTOTAL,strValorActual,strValorNuevo);
			}	
			
			if(solicitudvacacion.getIsNew()||!solicitudvacacion.getdescripcion().equals(solicitudvacacion.getSolicitudVacacionOriginal().getdescripcion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(solicitudvacacion.getSolicitudVacacionOriginal().getdescripcion()!=null)
				{
					strValorActual=solicitudvacacion.getSolicitudVacacionOriginal().getdescripcion();
				}
				if(solicitudvacacion.getdescripcion()!=null)
				{
					strValorNuevo=solicitudvacacion.getdescripcion() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),SolicitudVacacionConstantesFunciones.DESCRIPCION,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveSolicitudVacacionRelacionesWithConnection(SolicitudVacacion solicitudvacacion) throws Exception {

		if(!solicitudvacacion.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveSolicitudVacacionRelacionesBase(solicitudvacacion,true);
		}
	}

	public void saveSolicitudVacacionRelaciones(SolicitudVacacion solicitudvacacion)throws Exception {

		if(!solicitudvacacion.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveSolicitudVacacionRelacionesBase(solicitudvacacion,false);
		}
	}

	public void saveSolicitudVacacionRelacionesBase(SolicitudVacacion solicitudvacacion,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("SolicitudVacacion-saveRelacionesWithConnection");}
	

			this.setSolicitudVacacion(solicitudvacacion);

			if(SolicitudVacacionLogicAdditional.validarSaveRelaciones(solicitudvacacion,this)) {

				SolicitudVacacionLogicAdditional.updateRelacionesToSave(solicitudvacacion,this);

				if((solicitudvacacion.getIsNew()||solicitudvacacion.getIsChanged())&&!solicitudvacacion.getIsDeleted()) {
					this.saveSolicitudVacacion();
					this.saveSolicitudVacacionRelacionesDetalles();

				} else if(solicitudvacacion.getIsDeleted()) {
					this.saveSolicitudVacacionRelacionesDetalles();
					this.saveSolicitudVacacion();
				}

				SolicitudVacacionLogicAdditional.updateRelacionesToSaveAfter(solicitudvacacion,this);

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
	
	
	private void saveSolicitudVacacionRelacionesDetalles()throws Exception {
		try {
	

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfSolicitudVacacion(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=SolicitudVacacionConstantesFunciones.getClassesForeignKeysOfSolicitudVacacion(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfSolicitudVacacion(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=SolicitudVacacionConstantesFunciones.getClassesRelationshipsOfSolicitudVacacion(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

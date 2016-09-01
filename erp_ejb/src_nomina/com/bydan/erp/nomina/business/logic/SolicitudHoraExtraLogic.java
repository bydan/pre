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
import com.bydan.erp.nomina.util.SolicitudHoraExtraConstantesFunciones;
import com.bydan.erp.nomina.util.SolicitudHoraExtraParameterReturnGeneral;
//import com.bydan.erp.nomina.util.SolicitudHoraExtraParameterGeneral;
import com.bydan.erp.nomina.business.entity.SolicitudHoraExtra;
import com.bydan.erp.nomina.business.logic.SolicitudHoraExtraLogicAdditional;
import com.bydan.erp.nomina.business.dataaccess.*;
import com.bydan.erp.nomina.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;


import com.bydan.erp.seguridad.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;








@SuppressWarnings("unused")
public class SolicitudHoraExtraLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(SolicitudHoraExtraLogic.class);
	
	protected SolicitudHoraExtraDataAccess solicitudhoraextraDataAccess; 	
	protected SolicitudHoraExtra solicitudhoraextra;
	protected List<SolicitudHoraExtra> solicitudhoraextras;
	protected Object solicitudhoraextraObject;	
	protected List<Object> solicitudhoraextrasObject;
	
	public static ClassValidator<SolicitudHoraExtra> solicitudhoraextraValidator = new ClassValidator<SolicitudHoraExtra>(SolicitudHoraExtra.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected SolicitudHoraExtraLogicAdditional solicitudhoraextraLogicAdditional=null;
	
	public SolicitudHoraExtraLogicAdditional getSolicitudHoraExtraLogicAdditional() {
		return this.solicitudhoraextraLogicAdditional;
	}
	
	public void setSolicitudHoraExtraLogicAdditional(SolicitudHoraExtraLogicAdditional solicitudhoraextraLogicAdditional) {
		try {
			this.solicitudhoraextraLogicAdditional=solicitudhoraextraLogicAdditional;
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
	
	
	
	
	public  SolicitudHoraExtraLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.solicitudhoraextraDataAccess = new SolicitudHoraExtraDataAccess();
			
			this.solicitudhoraextras= new ArrayList<SolicitudHoraExtra>();
			this.solicitudhoraextra= new SolicitudHoraExtra();
			
			this.solicitudhoraextraObject=new Object();
			this.solicitudhoraextrasObject=new ArrayList<Object>();
				
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
			
			this.solicitudhoraextraDataAccess.setConnexionType(this.connexionType);
			this.solicitudhoraextraDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  SolicitudHoraExtraLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.solicitudhoraextraDataAccess = new SolicitudHoraExtraDataAccess();
			this.solicitudhoraextras= new ArrayList<SolicitudHoraExtra>();
			this.solicitudhoraextra= new SolicitudHoraExtra();
			this.solicitudhoraextraObject=new Object();
			this.solicitudhoraextrasObject=new ArrayList<Object>();
			
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
			
			this.solicitudhoraextraDataAccess.setConnexionType(this.connexionType);
			this.solicitudhoraextraDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public SolicitudHoraExtra getSolicitudHoraExtra() throws Exception {	
		SolicitudHoraExtraLogicAdditional.checkSolicitudHoraExtraToGet(solicitudhoraextra,this.datosCliente,this.arrDatoGeneral);
		SolicitudHoraExtraLogicAdditional.updateSolicitudHoraExtraToGet(solicitudhoraextra,this.arrDatoGeneral);
		
		return solicitudhoraextra;
	}
		
	public void setSolicitudHoraExtra(SolicitudHoraExtra newSolicitudHoraExtra) {
		this.solicitudhoraextra = newSolicitudHoraExtra;
	}
	
	public SolicitudHoraExtraDataAccess getSolicitudHoraExtraDataAccess() {
		return solicitudhoraextraDataAccess;
	}
	
	public void setSolicitudHoraExtraDataAccess(SolicitudHoraExtraDataAccess newsolicitudhoraextraDataAccess) {
		this.solicitudhoraextraDataAccess = newsolicitudhoraextraDataAccess;
	}
	
	public List<SolicitudHoraExtra> getSolicitudHoraExtras() throws Exception {		
		this.quitarSolicitudHoraExtrasNulos();
		
		SolicitudHoraExtraLogicAdditional.checkSolicitudHoraExtraToGets(solicitudhoraextras,this.datosCliente,this.arrDatoGeneral);
		
		for (SolicitudHoraExtra solicitudhoraextraLocal: solicitudhoraextras ) {
			SolicitudHoraExtraLogicAdditional.updateSolicitudHoraExtraToGet(solicitudhoraextraLocal,this.arrDatoGeneral);
		}
		
		return solicitudhoraextras;
	}
	
	public void setSolicitudHoraExtras(List<SolicitudHoraExtra> newSolicitudHoraExtras) {
		this.solicitudhoraextras = newSolicitudHoraExtras;
	}
	
	public Object getSolicitudHoraExtraObject() {	
		this.solicitudhoraextraObject=this.solicitudhoraextraDataAccess.getEntityObject();
		return this.solicitudhoraextraObject;
	}
		
	public void setSolicitudHoraExtraObject(Object newSolicitudHoraExtraObject) {
		this.solicitudhoraextraObject = newSolicitudHoraExtraObject;
	}
	
	public List<Object> getSolicitudHoraExtrasObject() {		
		this.solicitudhoraextrasObject=this.solicitudhoraextraDataAccess.getEntitiesObject();
		return this.solicitudhoraextrasObject;
	}
		
	public void setSolicitudHoraExtrasObject(List<Object> newSolicitudHoraExtrasObject) {
		this.solicitudhoraextrasObject = newSolicitudHoraExtrasObject;
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
		
		if(this.solicitudhoraextraDataAccess!=null) {
			this.solicitudhoraextraDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SolicitudHoraExtra.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			solicitudhoraextraDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			solicitudhoraextraDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		solicitudhoraextra = new  SolicitudHoraExtra();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SolicitudHoraExtra.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			solicitudhoraextra=solicitudhoraextraDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.solicitudhoraextra,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				SolicitudHoraExtraConstantesFunciones.refrescarForeignKeysDescripcionesSolicitudHoraExtra(this.solicitudhoraextra);
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
		solicitudhoraextra = new  SolicitudHoraExtra();
		  		  
        try {
			
			solicitudhoraextra=solicitudhoraextraDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.solicitudhoraextra,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				SolicitudHoraExtraConstantesFunciones.refrescarForeignKeysDescripcionesSolicitudHoraExtra(this.solicitudhoraextra);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		solicitudhoraextra = new  SolicitudHoraExtra();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SolicitudHoraExtra.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			solicitudhoraextra=solicitudhoraextraDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.solicitudhoraextra,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				SolicitudHoraExtraConstantesFunciones.refrescarForeignKeysDescripcionesSolicitudHoraExtra(this.solicitudhoraextra);
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
		solicitudhoraextra = new  SolicitudHoraExtra();
		  		  
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
		solicitudhoraextra = new  SolicitudHoraExtra();
		  		  
        try {
			
			solicitudhoraextra=solicitudhoraextraDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.solicitudhoraextra,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				SolicitudHoraExtraConstantesFunciones.refrescarForeignKeysDescripcionesSolicitudHoraExtra(this.solicitudhoraextra);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		solicitudhoraextra = new  SolicitudHoraExtra();
		  		  
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
		solicitudhoraextra = new  SolicitudHoraExtra();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SolicitudHoraExtra.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =solicitudhoraextraDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		solicitudhoraextra = new  SolicitudHoraExtra();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=solicitudhoraextraDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		solicitudhoraextra = new  SolicitudHoraExtra();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SolicitudHoraExtra.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =solicitudhoraextraDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		solicitudhoraextra = new  SolicitudHoraExtra();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=solicitudhoraextraDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		solicitudhoraextra = new  SolicitudHoraExtra();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SolicitudHoraExtra.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =solicitudhoraextraDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		solicitudhoraextra = new  SolicitudHoraExtra();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=solicitudhoraextraDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		solicitudhoraextras = new  ArrayList<SolicitudHoraExtra>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SolicitudHoraExtra.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			SolicitudHoraExtraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			solicitudhoraextras=solicitudhoraextraDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarSolicitudHoraExtra(solicitudhoraextras);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				SolicitudHoraExtraConstantesFunciones.refrescarForeignKeysDescripcionesSolicitudHoraExtra(this.solicitudhoraextras);
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
		solicitudhoraextras = new  ArrayList<SolicitudHoraExtra>();
		  		  
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
		solicitudhoraextras = new  ArrayList<SolicitudHoraExtra>();
		  		  
        try {			
			SolicitudHoraExtraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			solicitudhoraextras=solicitudhoraextraDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarSolicitudHoraExtra(solicitudhoraextras);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				SolicitudHoraExtraConstantesFunciones.refrescarForeignKeysDescripcionesSolicitudHoraExtra(this.solicitudhoraextras);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		solicitudhoraextras = new  ArrayList<SolicitudHoraExtra>();
		  		  
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
		solicitudhoraextras = new  ArrayList<SolicitudHoraExtra>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SolicitudHoraExtra.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			SolicitudHoraExtraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			solicitudhoraextras=solicitudhoraextraDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarSolicitudHoraExtra(solicitudhoraextras);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				SolicitudHoraExtraConstantesFunciones.refrescarForeignKeysDescripcionesSolicitudHoraExtra(this.solicitudhoraextras);
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
		solicitudhoraextras = new  ArrayList<SolicitudHoraExtra>();
		  		  
        try {
			SolicitudHoraExtraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			solicitudhoraextras=solicitudhoraextraDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarSolicitudHoraExtra(solicitudhoraextras);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				SolicitudHoraExtraConstantesFunciones.refrescarForeignKeysDescripcionesSolicitudHoraExtra(this.solicitudhoraextras);
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
		solicitudhoraextras = new  ArrayList<SolicitudHoraExtra>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SolicitudHoraExtra.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			SolicitudHoraExtraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			solicitudhoraextras=solicitudhoraextraDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarSolicitudHoraExtra(solicitudhoraextras);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				SolicitudHoraExtraConstantesFunciones.refrescarForeignKeysDescripcionesSolicitudHoraExtra(this.solicitudhoraextras);
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
		solicitudhoraextras = new  ArrayList<SolicitudHoraExtra>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			SolicitudHoraExtraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			solicitudhoraextras=solicitudhoraextraDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarSolicitudHoraExtra(solicitudhoraextras);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				SolicitudHoraExtraConstantesFunciones.refrescarForeignKeysDescripcionesSolicitudHoraExtra(this.solicitudhoraextras);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		solicitudhoraextra = new  SolicitudHoraExtra();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SolicitudHoraExtra.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			SolicitudHoraExtraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			solicitudhoraextra=solicitudhoraextraDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarSolicitudHoraExtra(solicitudhoraextra);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				SolicitudHoraExtraConstantesFunciones.refrescarForeignKeysDescripcionesSolicitudHoraExtra(this.solicitudhoraextra);
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
		solicitudhoraextra = new  SolicitudHoraExtra();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			SolicitudHoraExtraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			solicitudhoraextra=solicitudhoraextraDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarSolicitudHoraExtra(solicitudhoraextra);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				SolicitudHoraExtraConstantesFunciones.refrescarForeignKeysDescripcionesSolicitudHoraExtra(this.solicitudhoraextra);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		solicitudhoraextras = new  ArrayList<SolicitudHoraExtra>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SolicitudHoraExtra.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			SolicitudHoraExtraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			solicitudhoraextras=solicitudhoraextraDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarSolicitudHoraExtra(solicitudhoraextras);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				SolicitudHoraExtraConstantesFunciones.refrescarForeignKeysDescripcionesSolicitudHoraExtra(this.solicitudhoraextras);
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
		solicitudhoraextras = new  ArrayList<SolicitudHoraExtra>();
		  		  
        try {
			SolicitudHoraExtraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			solicitudhoraextras=solicitudhoraextraDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarSolicitudHoraExtra(solicitudhoraextras);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				SolicitudHoraExtraConstantesFunciones.refrescarForeignKeysDescripcionesSolicitudHoraExtra(this.solicitudhoraextras);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosSolicitudHoraExtrasWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		solicitudhoraextras = new  ArrayList<SolicitudHoraExtra>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SolicitudHoraExtra.class.getSimpleName()+"-getTodosSolicitudHoraExtrasWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			SolicitudHoraExtraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			solicitudhoraextras=solicitudhoraextraDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarSolicitudHoraExtra(solicitudhoraextras);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				SolicitudHoraExtraConstantesFunciones.refrescarForeignKeysDescripcionesSolicitudHoraExtra(this.solicitudhoraextras);
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
	
	public  void  getTodosSolicitudHoraExtras(String sFinalQuery,Pagination pagination)throws Exception {
		solicitudhoraextras = new  ArrayList<SolicitudHoraExtra>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			SolicitudHoraExtraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			solicitudhoraextras=solicitudhoraextraDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarSolicitudHoraExtra(solicitudhoraextras);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				SolicitudHoraExtraConstantesFunciones.refrescarForeignKeysDescripcionesSolicitudHoraExtra(this.solicitudhoraextras);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarSolicitudHoraExtra(SolicitudHoraExtra solicitudhoraextra) throws Exception {
		Boolean estaValidado=false;
		
		if(solicitudhoraextra.getIsNew() || solicitudhoraextra.getIsChanged()) { 
			this.invalidValues = solicitudhoraextraValidator.getInvalidValues(solicitudhoraextra);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(solicitudhoraextra);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarSolicitudHoraExtra(List<SolicitudHoraExtra> SolicitudHoraExtras) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(SolicitudHoraExtra solicitudhoraextraLocal:solicitudhoraextras) {				
			estaValidadoObjeto=this.validarGuardarSolicitudHoraExtra(solicitudhoraextraLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarSolicitudHoraExtra(List<SolicitudHoraExtra> SolicitudHoraExtras) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarSolicitudHoraExtra(solicitudhoraextras)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarSolicitudHoraExtra(SolicitudHoraExtra SolicitudHoraExtra) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarSolicitudHoraExtra(solicitudhoraextra)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(SolicitudHoraExtra solicitudhoraextra) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+solicitudhoraextra.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=SolicitudHoraExtraConstantesFunciones.getSolicitudHoraExtraLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"solicitudhoraextra","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(SolicitudHoraExtraConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(SolicitudHoraExtraConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveSolicitudHoraExtraWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SolicitudHoraExtra.class.getSimpleName()+"-saveSolicitudHoraExtraWithConnection");connexion.begin();			
			
			SolicitudHoraExtraLogicAdditional.checkSolicitudHoraExtraToSave(this.solicitudhoraextra,this.datosCliente,connexion,this.arrDatoGeneral);
			
			SolicitudHoraExtraLogicAdditional.updateSolicitudHoraExtraToSave(this.solicitudhoraextra,this.arrDatoGeneral);
			
			SolicitudHoraExtraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.solicitudhoraextra,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowSolicitudHoraExtra();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarSolicitudHoraExtra(this.solicitudhoraextra)) {
				SolicitudHoraExtraDataAccess.save(this.solicitudhoraextra, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.solicitudhoraextra,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			SolicitudHoraExtraLogicAdditional.checkSolicitudHoraExtraToSaveAfter(this.solicitudhoraextra,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowSolicitudHoraExtra();
			
			connexion.commit();			
			
			if(this.solicitudhoraextra.getIsDeleted()) {
				this.solicitudhoraextra=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveSolicitudHoraExtra()throws Exception {	
		try {	
			
			SolicitudHoraExtraLogicAdditional.checkSolicitudHoraExtraToSave(this.solicitudhoraextra,this.datosCliente,connexion,this.arrDatoGeneral);
			
			SolicitudHoraExtraLogicAdditional.updateSolicitudHoraExtraToSave(this.solicitudhoraextra,this.arrDatoGeneral);
			
			SolicitudHoraExtraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.solicitudhoraextra,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarSolicitudHoraExtra(this.solicitudhoraextra)) {			
				SolicitudHoraExtraDataAccess.save(this.solicitudhoraextra, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.solicitudhoraextra,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			SolicitudHoraExtraLogicAdditional.checkSolicitudHoraExtraToSaveAfter(this.solicitudhoraextra,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.solicitudhoraextra.getIsDeleted()) {
				this.solicitudhoraextra=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveSolicitudHoraExtrasWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SolicitudHoraExtra.class.getSimpleName()+"-saveSolicitudHoraExtrasWithConnection");connexion.begin();			
			
			SolicitudHoraExtraLogicAdditional.checkSolicitudHoraExtraToSaves(solicitudhoraextras,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowSolicitudHoraExtras();
			
			Boolean validadoTodosSolicitudHoraExtra=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(SolicitudHoraExtra solicitudhoraextraLocal:solicitudhoraextras) {		
				if(solicitudhoraextraLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				SolicitudHoraExtraLogicAdditional.updateSolicitudHoraExtraToSave(solicitudhoraextraLocal,this.arrDatoGeneral);
	        	
				SolicitudHoraExtraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),solicitudhoraextraLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarSolicitudHoraExtra(solicitudhoraextraLocal)) {
					SolicitudHoraExtraDataAccess.save(solicitudhoraextraLocal, connexion);				
				} else {
					validadoTodosSolicitudHoraExtra=false;
				}
			}
			
			if(!validadoTodosSolicitudHoraExtra) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			SolicitudHoraExtraLogicAdditional.checkSolicitudHoraExtraToSavesAfter(solicitudhoraextras,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowSolicitudHoraExtras();
			
			connexion.commit();		
			
			this.quitarSolicitudHoraExtrasEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveSolicitudHoraExtras()throws Exception {				
		 try {	
			SolicitudHoraExtraLogicAdditional.checkSolicitudHoraExtraToSaves(solicitudhoraextras,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosSolicitudHoraExtra=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(SolicitudHoraExtra solicitudhoraextraLocal:solicitudhoraextras) {				
				if(solicitudhoraextraLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				SolicitudHoraExtraLogicAdditional.updateSolicitudHoraExtraToSave(solicitudhoraextraLocal,this.arrDatoGeneral);
	        	
				SolicitudHoraExtraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),solicitudhoraextraLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarSolicitudHoraExtra(solicitudhoraextraLocal)) {				
					SolicitudHoraExtraDataAccess.save(solicitudhoraextraLocal, connexion);				
				} else {
					validadoTodosSolicitudHoraExtra=false;
				}
			}
			
			if(!validadoTodosSolicitudHoraExtra) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			SolicitudHoraExtraLogicAdditional.checkSolicitudHoraExtraToSavesAfter(solicitudhoraextras,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarSolicitudHoraExtrasEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public SolicitudHoraExtraParameterReturnGeneral procesarAccionSolicitudHoraExtras(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<SolicitudHoraExtra> solicitudhoraextras,SolicitudHoraExtraParameterReturnGeneral solicitudhoraextraParameterGeneral)throws Exception {
		 try {	
			SolicitudHoraExtraParameterReturnGeneral solicitudhoraextraReturnGeneral=new SolicitudHoraExtraParameterReturnGeneral();
	
			SolicitudHoraExtraLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,solicitudhoraextras,solicitudhoraextraParameterGeneral,solicitudhoraextraReturnGeneral);
			
			return solicitudhoraextraReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public SolicitudHoraExtraParameterReturnGeneral procesarAccionSolicitudHoraExtrasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<SolicitudHoraExtra> solicitudhoraextras,SolicitudHoraExtraParameterReturnGeneral solicitudhoraextraParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SolicitudHoraExtra.class.getSimpleName()+"-procesarAccionSolicitudHoraExtrasWithConnection");connexion.begin();			
			
			SolicitudHoraExtraParameterReturnGeneral solicitudhoraextraReturnGeneral=new SolicitudHoraExtraParameterReturnGeneral();
	
			SolicitudHoraExtraLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,solicitudhoraextras,solicitudhoraextraParameterGeneral,solicitudhoraextraReturnGeneral);
			
			this.connexion.commit();
			
			return solicitudhoraextraReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public SolicitudHoraExtraParameterReturnGeneral procesarEventosSolicitudHoraExtras(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<SolicitudHoraExtra> solicitudhoraextras,SolicitudHoraExtra solicitudhoraextra,SolicitudHoraExtraParameterReturnGeneral solicitudhoraextraParameterGeneral,Boolean isEsNuevoSolicitudHoraExtra,ArrayList<Classe> clases)throws Exception {
		 try {	
			SolicitudHoraExtraParameterReturnGeneral solicitudhoraextraReturnGeneral=new SolicitudHoraExtraParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				solicitudhoraextraReturnGeneral.setConRecargarPropiedades(true);
			}
			
			SolicitudHoraExtraLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,solicitudhoraextras,solicitudhoraextra,solicitudhoraextraParameterGeneral,solicitudhoraextraReturnGeneral,isEsNuevoSolicitudHoraExtra,clases);
			
			return solicitudhoraextraReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public SolicitudHoraExtraParameterReturnGeneral procesarEventosSolicitudHoraExtrasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<SolicitudHoraExtra> solicitudhoraextras,SolicitudHoraExtra solicitudhoraextra,SolicitudHoraExtraParameterReturnGeneral solicitudhoraextraParameterGeneral,Boolean isEsNuevoSolicitudHoraExtra,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SolicitudHoraExtra.class.getSimpleName()+"-procesarEventosSolicitudHoraExtrasWithConnection");connexion.begin();			
			
			SolicitudHoraExtraParameterReturnGeneral solicitudhoraextraReturnGeneral=new SolicitudHoraExtraParameterReturnGeneral();
	
			solicitudhoraextraReturnGeneral.setSolicitudHoraExtra(solicitudhoraextra);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				solicitudhoraextraReturnGeneral.setConRecargarPropiedades(true);
			}
			
			SolicitudHoraExtraLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,solicitudhoraextras,solicitudhoraextra,solicitudhoraextraParameterGeneral,solicitudhoraextraReturnGeneral,isEsNuevoSolicitudHoraExtra,clases);
			
			this.connexion.commit();
			
			return solicitudhoraextraReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public SolicitudHoraExtraParameterReturnGeneral procesarImportacionSolicitudHoraExtrasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,SolicitudHoraExtraParameterReturnGeneral solicitudhoraextraParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SolicitudHoraExtra.class.getSimpleName()+"-procesarImportacionSolicitudHoraExtrasWithConnection");connexion.begin();			
			
			SolicitudHoraExtraParameterReturnGeneral solicitudhoraextraReturnGeneral=new SolicitudHoraExtraParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.solicitudhoraextras=new ArrayList<SolicitudHoraExtra>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.solicitudhoraextra=new SolicitudHoraExtra();
				
				
				if(conColumnasBase) {this.solicitudhoraextra.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.solicitudhoraextra.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.solicitudhoraextra.setsecuencial(arrColumnas[iColumn++]);
				this.solicitudhoraextra.setfecha_solicita(Funciones.ConvertToDate(arrColumnas[iColumn++]));
				this.solicitudhoraextra.setfecha_ejecuta(Funciones.ConvertToDate(arrColumnas[iColumn++]));
				this.solicitudhoraextra.setnumero_horas(Integer.parseInt(arrColumnas[iColumn++]));
				this.solicitudhoraextra.setcosto_unitario(Double.parseDouble(arrColumnas[iColumn++]));
				this.solicitudhoraextra.setcosto_total(Double.parseDouble(arrColumnas[iColumn++]));
			this.solicitudhoraextra.setdescripcion(arrColumnas[iColumn++]);
				
				this.solicitudhoraextras.add(this.solicitudhoraextra);
			}
			
			this.saveSolicitudHoraExtras();
			
			this.connexion.commit();
			
			solicitudhoraextraReturnGeneral.setConRetornoEstaProcesado(true);
			solicitudhoraextraReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return solicitudhoraextraReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarSolicitudHoraExtrasEliminados() throws Exception {				
		
		List<SolicitudHoraExtra> solicitudhoraextrasAux= new ArrayList<SolicitudHoraExtra>();
		
		for(SolicitudHoraExtra solicitudhoraextra:solicitudhoraextras) {
			if(!solicitudhoraextra.getIsDeleted()) {
				solicitudhoraextrasAux.add(solicitudhoraextra);
			}
		}
		
		solicitudhoraextras=solicitudhoraextrasAux;
	}
	
	public void quitarSolicitudHoraExtrasNulos() throws Exception {				
		
		List<SolicitudHoraExtra> solicitudhoraextrasAux= new ArrayList<SolicitudHoraExtra>();
		
		for(SolicitudHoraExtra solicitudhoraextra : this.solicitudhoraextras) {
			if(solicitudhoraextra==null) {
				solicitudhoraextrasAux.add(solicitudhoraextra);
			}
		}
		
		//this.solicitudhoraextras=solicitudhoraextrasAux;
		
		this.solicitudhoraextras.removeAll(solicitudhoraextrasAux);
	}
	
	public void getSetVersionRowSolicitudHoraExtraWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(solicitudhoraextra.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((solicitudhoraextra.getIsDeleted() || (solicitudhoraextra.getIsChanged()&&!solicitudhoraextra.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=solicitudhoraextraDataAccess.getSetVersionRowSolicitudHoraExtra(connexion,solicitudhoraextra.getId());
				
				if(!solicitudhoraextra.getVersionRow().equals(timestamp)) {	
					solicitudhoraextra.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				solicitudhoraextra.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowSolicitudHoraExtra()throws Exception {	
		
		if(solicitudhoraextra.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((solicitudhoraextra.getIsDeleted() || (solicitudhoraextra.getIsChanged()&&!solicitudhoraextra.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=solicitudhoraextraDataAccess.getSetVersionRowSolicitudHoraExtra(connexion,solicitudhoraextra.getId());
			
			try {							
				if(!solicitudhoraextra.getVersionRow().equals(timestamp)) {	
					solicitudhoraextra.setVersionRow(timestamp);
				}
				
				solicitudhoraextra.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowSolicitudHoraExtrasWithConnection()throws Exception {	
		if(solicitudhoraextras!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(SolicitudHoraExtra solicitudhoraextraAux:solicitudhoraextras) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(solicitudhoraextraAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(solicitudhoraextraAux.getIsDeleted() || (solicitudhoraextraAux.getIsChanged()&&!solicitudhoraextraAux.getIsNew())) {
						
						timestamp=solicitudhoraextraDataAccess.getSetVersionRowSolicitudHoraExtra(connexion,solicitudhoraextraAux.getId());
						
						if(!solicitudhoraextra.getVersionRow().equals(timestamp)) {	
							solicitudhoraextraAux.setVersionRow(timestamp);
						}
								
						solicitudhoraextraAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowSolicitudHoraExtras()throws Exception {	
		if(solicitudhoraextras!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(SolicitudHoraExtra solicitudhoraextraAux:solicitudhoraextras) {
					if(solicitudhoraextraAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(solicitudhoraextraAux.getIsDeleted() || (solicitudhoraextraAux.getIsChanged()&&!solicitudhoraextraAux.getIsNew())) {
						
						timestamp=solicitudhoraextraDataAccess.getSetVersionRowSolicitudHoraExtra(connexion,solicitudhoraextraAux.getId());
						
						if(!solicitudhoraextraAux.getVersionRow().equals(timestamp)) {	
							solicitudhoraextraAux.setVersionRow(timestamp);
						}
						
													
						solicitudhoraextraAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public SolicitudHoraExtraParameterReturnGeneral cargarCombosLoteForeignKeySolicitudHoraExtraWithConnection(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalEmpleado,String finalQueryGlobalEstructura,String finalQueryGlobalEmpleadoJefe,String finalQueryGlobalEstadoSolicitudNomi,String finalQueryGlobalEmpleadoReemplazo) throws Exception {
		SolicitudHoraExtraParameterReturnGeneral  solicitudhoraextraReturnGeneral =new SolicitudHoraExtraParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SolicitudHoraExtra.class.getSimpleName()+"-cargarCombosLoteForeignKeySolicitudHoraExtraWithConnection");connexion.begin();
			
			solicitudhoraextraReturnGeneral =new SolicitudHoraExtraParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			solicitudhoraextraReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			solicitudhoraextraReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Empleado> empleadosForeignKey=new ArrayList<Empleado>();
			EmpleadoLogic empleadoLogic=new EmpleadoLogic();
			empleadoLogic.setConnexion(this.connexion);
			empleadoLogic.getEmpleadoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpleado.equals("NONE")) {
				empleadoLogic.getTodosEmpleados(finalQueryGlobalEmpleado,new Pagination());
				empleadosForeignKey=empleadoLogic.getEmpleados();
			}

			solicitudhoraextraReturnGeneral.setempleadosForeignKey(empleadosForeignKey);


			List<Estructura> estructurasForeignKey=new ArrayList<Estructura>();
			EstructuraLogic estructuraLogic=new EstructuraLogic();
			estructuraLogic.setConnexion(this.connexion);
			estructuraLogic.getEstructuraDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEstructura.equals("NONE")) {
				estructuraLogic.getTodosEstructuras(finalQueryGlobalEstructura,new Pagination());
				estructurasForeignKey=estructuraLogic.getEstructuras();
			}

			solicitudhoraextraReturnGeneral.setestructurasForeignKey(estructurasForeignKey);


			List<Empleado> empleadojefesForeignKey=new ArrayList<Empleado>();
			EmpleadoLogic empleadojefeLogic=new EmpleadoLogic();
			empleadojefeLogic.setConnexion(this.connexion);
			empleadojefeLogic.getEmpleadoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpleadoJefe.equals("NONE")) {
				empleadojefeLogic.getTodosEmpleados(finalQueryGlobalEmpleadoJefe,new Pagination());
				empleadojefesForeignKey=empleadojefeLogic.getEmpleados();
			}

			solicitudhoraextraReturnGeneral.setempleadojefesForeignKey(empleadojefesForeignKey);


			List<EstadoSolicitudNomi> estadosolicitudnomisForeignKey=new ArrayList<EstadoSolicitudNomi>();
			EstadoSolicitudNomiLogic estadosolicitudnomiLogic=new EstadoSolicitudNomiLogic();
			estadosolicitudnomiLogic.setConnexion(this.connexion);
			estadosolicitudnomiLogic.getEstadoSolicitudNomiDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEstadoSolicitudNomi.equals("NONE")) {
				estadosolicitudnomiLogic.getTodosEstadoSolicitudNomis(finalQueryGlobalEstadoSolicitudNomi,new Pagination());
				estadosolicitudnomisForeignKey=estadosolicitudnomiLogic.getEstadoSolicitudNomis();
			}

			solicitudhoraextraReturnGeneral.setestadosolicitudnomisForeignKey(estadosolicitudnomisForeignKey);


			List<Empleado> empleadoreemplazosForeignKey=new ArrayList<Empleado>();
			EmpleadoLogic empleadoreemplazoLogic=new EmpleadoLogic();
			empleadoreemplazoLogic.setConnexion(this.connexion);
			empleadoreemplazoLogic.getEmpleadoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpleadoReemplazo.equals("NONE")) {
				empleadoreemplazoLogic.getTodosEmpleados(finalQueryGlobalEmpleadoReemplazo,new Pagination());
				empleadoreemplazosForeignKey=empleadoreemplazoLogic.getEmpleados();
			}

			solicitudhoraextraReturnGeneral.setempleadoreemplazosForeignKey(empleadoreemplazosForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return solicitudhoraextraReturnGeneral;
	}
	
	public SolicitudHoraExtraParameterReturnGeneral cargarCombosLoteForeignKeySolicitudHoraExtra(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalEmpleado,String finalQueryGlobalEstructura,String finalQueryGlobalEmpleadoJefe,String finalQueryGlobalEstadoSolicitudNomi,String finalQueryGlobalEmpleadoReemplazo) throws Exception {
		SolicitudHoraExtraParameterReturnGeneral  solicitudhoraextraReturnGeneral =new SolicitudHoraExtraParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			solicitudhoraextraReturnGeneral =new SolicitudHoraExtraParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			solicitudhoraextraReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			solicitudhoraextraReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Empleado> empleadosForeignKey=new ArrayList<Empleado>();
			EmpleadoLogic empleadoLogic=new EmpleadoLogic();
			empleadoLogic.setConnexion(this.connexion);
			empleadoLogic.getEmpleadoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpleado.equals("NONE")) {
				empleadoLogic.getTodosEmpleados(finalQueryGlobalEmpleado,new Pagination());
				empleadosForeignKey=empleadoLogic.getEmpleados();
			}

			solicitudhoraextraReturnGeneral.setempleadosForeignKey(empleadosForeignKey);


			List<Estructura> estructurasForeignKey=new ArrayList<Estructura>();
			EstructuraLogic estructuraLogic=new EstructuraLogic();
			estructuraLogic.setConnexion(this.connexion);
			estructuraLogic.getEstructuraDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEstructura.equals("NONE")) {
				estructuraLogic.getTodosEstructuras(finalQueryGlobalEstructura,new Pagination());
				estructurasForeignKey=estructuraLogic.getEstructuras();
			}

			solicitudhoraextraReturnGeneral.setestructurasForeignKey(estructurasForeignKey);


			List<Empleado> empleadojefesForeignKey=new ArrayList<Empleado>();
			EmpleadoLogic empleadojefeLogic=new EmpleadoLogic();
			empleadojefeLogic.setConnexion(this.connexion);
			empleadojefeLogic.getEmpleadoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpleadoJefe.equals("NONE")) {
				empleadojefeLogic.getTodosEmpleados(finalQueryGlobalEmpleadoJefe,new Pagination());
				empleadojefesForeignKey=empleadojefeLogic.getEmpleados();
			}

			solicitudhoraextraReturnGeneral.setempleadojefesForeignKey(empleadojefesForeignKey);


			List<EstadoSolicitudNomi> estadosolicitudnomisForeignKey=new ArrayList<EstadoSolicitudNomi>();
			EstadoSolicitudNomiLogic estadosolicitudnomiLogic=new EstadoSolicitudNomiLogic();
			estadosolicitudnomiLogic.setConnexion(this.connexion);
			estadosolicitudnomiLogic.getEstadoSolicitudNomiDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEstadoSolicitudNomi.equals("NONE")) {
				estadosolicitudnomiLogic.getTodosEstadoSolicitudNomis(finalQueryGlobalEstadoSolicitudNomi,new Pagination());
				estadosolicitudnomisForeignKey=estadosolicitudnomiLogic.getEstadoSolicitudNomis();
			}

			solicitudhoraextraReturnGeneral.setestadosolicitudnomisForeignKey(estadosolicitudnomisForeignKey);


			List<Empleado> empleadoreemplazosForeignKey=new ArrayList<Empleado>();
			EmpleadoLogic empleadoreemplazoLogic=new EmpleadoLogic();
			empleadoreemplazoLogic.setConnexion(this.connexion);
			empleadoreemplazoLogic.getEmpleadoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpleadoReemplazo.equals("NONE")) {
				empleadoreemplazoLogic.getTodosEmpleados(finalQueryGlobalEmpleadoReemplazo,new Pagination());
				empleadoreemplazosForeignKey=empleadoreemplazoLogic.getEmpleados();
			}

			solicitudhoraextraReturnGeneral.setempleadoreemplazosForeignKey(empleadoreemplazosForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return solicitudhoraextraReturnGeneral;
	}
	
	
	public void deepLoad(SolicitudHoraExtra solicitudhoraextra,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			SolicitudHoraExtraLogicAdditional.updateSolicitudHoraExtraToGet(solicitudhoraextra,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		solicitudhoraextra.setEmpresa(solicitudhoraextraDataAccess.getEmpresa(connexion,solicitudhoraextra));
		solicitudhoraextra.setSucursal(solicitudhoraextraDataAccess.getSucursal(connexion,solicitudhoraextra));
		solicitudhoraextra.setEmpleado(solicitudhoraextraDataAccess.getEmpleado(connexion,solicitudhoraextra));
		solicitudhoraextra.setEstructura(solicitudhoraextraDataAccess.getEstructura(connexion,solicitudhoraextra));
		solicitudhoraextra.setEmpleadoJefe(solicitudhoraextraDataAccess.getEmpleadoJefe(connexion,solicitudhoraextra));
		solicitudhoraextra.setEstadoSolicitudNomi(solicitudhoraextraDataAccess.getEstadoSolicitudNomi(connexion,solicitudhoraextra));
		solicitudhoraextra.setEmpleadoReemplazo(solicitudhoraextraDataAccess.getEmpleadoReemplazo(connexion,solicitudhoraextra));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				solicitudhoraextra.setEmpresa(solicitudhoraextraDataAccess.getEmpresa(connexion,solicitudhoraextra));
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				solicitudhoraextra.setSucursal(solicitudhoraextraDataAccess.getSucursal(connexion,solicitudhoraextra));
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				solicitudhoraextra.setEmpleado(solicitudhoraextraDataAccess.getEmpleado(connexion,solicitudhoraextra));
				continue;
			}

			if(clas.clas.equals(Estructura.class)) {
				solicitudhoraextra.setEstructura(solicitudhoraextraDataAccess.getEstructura(connexion,solicitudhoraextra));
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				solicitudhoraextra.setEmpleadoJefe(solicitudhoraextraDataAccess.getEmpleadoJefe(connexion,solicitudhoraextra));
				continue;
			}

			if(clas.clas.equals(EstadoSolicitudNomi.class)) {
				solicitudhoraextra.setEstadoSolicitudNomi(solicitudhoraextraDataAccess.getEstadoSolicitudNomi(connexion,solicitudhoraextra));
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				solicitudhoraextra.setEmpleadoReemplazo(solicitudhoraextraDataAccess.getEmpleadoReemplazo(connexion,solicitudhoraextra));
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
			solicitudhoraextra.setEmpresa(solicitudhoraextraDataAccess.getEmpresa(connexion,solicitudhoraextra));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			solicitudhoraextra.setSucursal(solicitudhoraextraDataAccess.getSucursal(connexion,solicitudhoraextra));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Empleado.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			solicitudhoraextra.setEmpleado(solicitudhoraextraDataAccess.getEmpleado(connexion,solicitudhoraextra));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Estructura.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			solicitudhoraextra.setEstructura(solicitudhoraextraDataAccess.getEstructura(connexion,solicitudhoraextra));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Empleado.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			solicitudhoraextra.setEmpleadoJefe(solicitudhoraextraDataAccess.getEmpleadoJefe(connexion,solicitudhoraextra));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(EstadoSolicitudNomi.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			solicitudhoraextra.setEstadoSolicitudNomi(solicitudhoraextraDataAccess.getEstadoSolicitudNomi(connexion,solicitudhoraextra));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Empleado.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			solicitudhoraextra.setEmpleadoReemplazo(solicitudhoraextraDataAccess.getEmpleadoReemplazo(connexion,solicitudhoraextra));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		solicitudhoraextra.setEmpresa(solicitudhoraextraDataAccess.getEmpresa(connexion,solicitudhoraextra));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(solicitudhoraextra.getEmpresa(),isDeep,deepLoadType,clases);
				
		solicitudhoraextra.setSucursal(solicitudhoraextraDataAccess.getSucursal(connexion,solicitudhoraextra));
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(solicitudhoraextra.getSucursal(),isDeep,deepLoadType,clases);
				
		solicitudhoraextra.setEmpleado(solicitudhoraextraDataAccess.getEmpleado(connexion,solicitudhoraextra));
		EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
		empleadoLogic.deepLoad(solicitudhoraextra.getEmpleado(),isDeep,deepLoadType,clases);
				
		solicitudhoraextra.setEstructura(solicitudhoraextraDataAccess.getEstructura(connexion,solicitudhoraextra));
		EstructuraLogic estructuraLogic= new EstructuraLogic(connexion);
		estructuraLogic.deepLoad(solicitudhoraextra.getEstructura(),isDeep,deepLoadType,clases);
				
		solicitudhoraextra.setEmpleadoJefe(solicitudhoraextraDataAccess.getEmpleadoJefe(connexion,solicitudhoraextra));
		EmpleadoLogic empleadojefeLogic= new EmpleadoLogic(connexion);
		empleadojefeLogic.deepLoad(solicitudhoraextra.getEmpleadoJefe(),isDeep,deepLoadType,clases);
				
		solicitudhoraextra.setEstadoSolicitudNomi(solicitudhoraextraDataAccess.getEstadoSolicitudNomi(connexion,solicitudhoraextra));
		EstadoSolicitudNomiLogic estadosolicitudnomiLogic= new EstadoSolicitudNomiLogic(connexion);
		estadosolicitudnomiLogic.deepLoad(solicitudhoraextra.getEstadoSolicitudNomi(),isDeep,deepLoadType,clases);
				
		solicitudhoraextra.setEmpleadoReemplazo(solicitudhoraextraDataAccess.getEmpleadoReemplazo(connexion,solicitudhoraextra));
		EmpleadoLogic empleadoreemplazoLogic= new EmpleadoLogic(connexion);
		empleadoreemplazoLogic.deepLoad(solicitudhoraextra.getEmpleadoReemplazo(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				solicitudhoraextra.setEmpresa(solicitudhoraextraDataAccess.getEmpresa(connexion,solicitudhoraextra));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(solicitudhoraextra.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				solicitudhoraextra.setSucursal(solicitudhoraextraDataAccess.getSucursal(connexion,solicitudhoraextra));
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepLoad(solicitudhoraextra.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				solicitudhoraextra.setEmpleado(solicitudhoraextraDataAccess.getEmpleado(connexion,solicitudhoraextra));
				EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
				empleadoLogic.deepLoad(solicitudhoraextra.getEmpleado(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Estructura.class)) {
				solicitudhoraextra.setEstructura(solicitudhoraextraDataAccess.getEstructura(connexion,solicitudhoraextra));
				EstructuraLogic estructuraLogic= new EstructuraLogic(connexion);
				estructuraLogic.deepLoad(solicitudhoraextra.getEstructura(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				solicitudhoraextra.setEmpleadoJefe(solicitudhoraextraDataAccess.getEmpleadoJefe(connexion,solicitudhoraextra));
				EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
				empleadoLogic.deepLoad(solicitudhoraextra.getEmpleadoJefe(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(EstadoSolicitudNomi.class)) {
				solicitudhoraextra.setEstadoSolicitudNomi(solicitudhoraextraDataAccess.getEstadoSolicitudNomi(connexion,solicitudhoraextra));
				EstadoSolicitudNomiLogic estadosolicitudnomiLogic= new EstadoSolicitudNomiLogic(connexion);
				estadosolicitudnomiLogic.deepLoad(solicitudhoraextra.getEstadoSolicitudNomi(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				solicitudhoraextra.setEmpleadoReemplazo(solicitudhoraextraDataAccess.getEmpleadoReemplazo(connexion,solicitudhoraextra));
				EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
				empleadoLogic.deepLoad(solicitudhoraextra.getEmpleadoReemplazo(),isDeep,deepLoadType,clases);				
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
			solicitudhoraextra.setEmpresa(solicitudhoraextraDataAccess.getEmpresa(connexion,solicitudhoraextra));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(solicitudhoraextra.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			solicitudhoraextra.setSucursal(solicitudhoraextraDataAccess.getSucursal(connexion,solicitudhoraextra));
			SucursalLogic sucursalLogic= new SucursalLogic(connexion);
			sucursalLogic.deepLoad(solicitudhoraextra.getSucursal(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Empleado.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			solicitudhoraextra.setEmpleado(solicitudhoraextraDataAccess.getEmpleado(connexion,solicitudhoraextra));
			EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
			empleadoLogic.deepLoad(solicitudhoraextra.getEmpleado(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Estructura.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			solicitudhoraextra.setEstructura(solicitudhoraextraDataAccess.getEstructura(connexion,solicitudhoraextra));
			EstructuraLogic estructuraLogic= new EstructuraLogic(connexion);
			estructuraLogic.deepLoad(solicitudhoraextra.getEstructura(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Empleado.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			solicitudhoraextra.setEmpleadoJefe(solicitudhoraextraDataAccess.getEmpleadoJefe(connexion,solicitudhoraextra));
			EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
			empleadoLogic.deepLoad(solicitudhoraextra.getEmpleadoJefe(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(EstadoSolicitudNomi.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			solicitudhoraextra.setEstadoSolicitudNomi(solicitudhoraextraDataAccess.getEstadoSolicitudNomi(connexion,solicitudhoraextra));
			EstadoSolicitudNomiLogic estadosolicitudnomiLogic= new EstadoSolicitudNomiLogic(connexion);
			estadosolicitudnomiLogic.deepLoad(solicitudhoraextra.getEstadoSolicitudNomi(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Empleado.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			solicitudhoraextra.setEmpleadoReemplazo(solicitudhoraextraDataAccess.getEmpleadoReemplazo(connexion,solicitudhoraextra));
			EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
			empleadoLogic.deepLoad(solicitudhoraextra.getEmpleadoReemplazo(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(SolicitudHoraExtra solicitudhoraextra,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			SolicitudHoraExtraLogicAdditional.updateSolicitudHoraExtraToSave(solicitudhoraextra,this.arrDatoGeneral);
			
SolicitudHoraExtraDataAccess.save(solicitudhoraextra, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(solicitudhoraextra.getEmpresa(),connexion);

		SucursalDataAccess.save(solicitudhoraextra.getSucursal(),connexion);

		EmpleadoDataAccess.save(solicitudhoraextra.getEmpleado(),connexion);

		EstructuraDataAccess.save(solicitudhoraextra.getEstructura(),connexion);

		EmpleadoDataAccess.save(solicitudhoraextra.getEmpleadoJefe(),connexion);

		EstadoSolicitudNomiDataAccess.save(solicitudhoraextra.getEstadoSolicitudNomi(),connexion);

		EmpleadoDataAccess.save(solicitudhoraextra.getEmpleadoReemplazo(),connexion);
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(solicitudhoraextra.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(solicitudhoraextra.getSucursal(),connexion);
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				EmpleadoDataAccess.save(solicitudhoraextra.getEmpleado(),connexion);
				continue;
			}

			if(clas.clas.equals(Estructura.class)) {
				EstructuraDataAccess.save(solicitudhoraextra.getEstructura(),connexion);
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				EmpleadoDataAccess.save(solicitudhoraextra.getEmpleadoJefe(),connexion);
				continue;
			}

			if(clas.clas.equals(EstadoSolicitudNomi.class)) {
				EstadoSolicitudNomiDataAccess.save(solicitudhoraextra.getEstadoSolicitudNomi(),connexion);
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				EmpleadoDataAccess.save(solicitudhoraextra.getEmpleadoReemplazo(),connexion);
				continue;
			}

		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(solicitudhoraextra.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(solicitudhoraextra.getEmpresa(),isDeep,deepLoadType,clases);
				

		SucursalDataAccess.save(solicitudhoraextra.getSucursal(),connexion);
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(solicitudhoraextra.getSucursal(),isDeep,deepLoadType,clases);
				

		EmpleadoDataAccess.save(solicitudhoraextra.getEmpleado(),connexion);
		EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
		empleadoLogic.deepLoad(solicitudhoraextra.getEmpleado(),isDeep,deepLoadType,clases);
				

		EstructuraDataAccess.save(solicitudhoraextra.getEstructura(),connexion);
		EstructuraLogic estructuraLogic= new EstructuraLogic(connexion);
		estructuraLogic.deepLoad(solicitudhoraextra.getEstructura(),isDeep,deepLoadType,clases);
				

		EmpleadoDataAccess.save(solicitudhoraextra.getEmpleadoJefe(),connexion);
		EmpleadoLogic empleadojefeLogic= new EmpleadoLogic(connexion);
		empleadojefeLogic.deepLoad(solicitudhoraextra.getEmpleadoJefe(),isDeep,deepLoadType,clases);
				

		EstadoSolicitudNomiDataAccess.save(solicitudhoraextra.getEstadoSolicitudNomi(),connexion);
		EstadoSolicitudNomiLogic estadosolicitudnomiLogic= new EstadoSolicitudNomiLogic(connexion);
		estadosolicitudnomiLogic.deepLoad(solicitudhoraextra.getEstadoSolicitudNomi(),isDeep,deepLoadType,clases);
				

		EmpleadoDataAccess.save(solicitudhoraextra.getEmpleadoReemplazo(),connexion);
		EmpleadoLogic empleadoreemplazoLogic= new EmpleadoLogic(connexion);
		empleadoreemplazoLogic.deepLoad(solicitudhoraextra.getEmpleadoReemplazo(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(solicitudhoraextra.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(solicitudhoraextra.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(solicitudhoraextra.getSucursal(),connexion);
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepSave(solicitudhoraextra.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				EmpleadoDataAccess.save(solicitudhoraextra.getEmpleado(),connexion);
				EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
				empleadoLogic.deepSave(solicitudhoraextra.getEmpleado(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Estructura.class)) {
				EstructuraDataAccess.save(solicitudhoraextra.getEstructura(),connexion);
				EstructuraLogic estructuraLogic= new EstructuraLogic(connexion);
				estructuraLogic.deepSave(solicitudhoraextra.getEstructura(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				EmpleadoDataAccess.save(solicitudhoraextra.getEmpleadoJefe(),connexion);
				EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
				empleadoLogic.deepSave(solicitudhoraextra.getEmpleadoJefe(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(EstadoSolicitudNomi.class)) {
				EstadoSolicitudNomiDataAccess.save(solicitudhoraextra.getEstadoSolicitudNomi(),connexion);
				EstadoSolicitudNomiLogic estadosolicitudnomiLogic= new EstadoSolicitudNomiLogic(connexion);
				estadosolicitudnomiLogic.deepSave(solicitudhoraextra.getEstadoSolicitudNomi(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				EmpleadoDataAccess.save(solicitudhoraextra.getEmpleadoReemplazo(),connexion);
				EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
				empleadoLogic.deepSave(solicitudhoraextra.getEmpleadoReemplazo(),isDeep,deepLoadType,clases);				
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
			this.getNewConnexionToDeep(SolicitudHoraExtra.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(solicitudhoraextra,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				SolicitudHoraExtraConstantesFunciones.refrescarForeignKeysDescripcionesSolicitudHoraExtra(solicitudhoraextra);
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
			this.deepLoad(this.solicitudhoraextra,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				SolicitudHoraExtraConstantesFunciones.refrescarForeignKeysDescripcionesSolicitudHoraExtra(this.solicitudhoraextra);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(SolicitudHoraExtra.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(solicitudhoraextras!=null) {
				for(SolicitudHoraExtra solicitudhoraextra:solicitudhoraextras) {
					this.deepLoad(solicitudhoraextra,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					SolicitudHoraExtraConstantesFunciones.refrescarForeignKeysDescripcionesSolicitudHoraExtra(solicitudhoraextras);
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
			if(solicitudhoraextras!=null) {
				for(SolicitudHoraExtra solicitudhoraextra:solicitudhoraextras) {
					this.deepLoad(solicitudhoraextra,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					SolicitudHoraExtraConstantesFunciones.refrescarForeignKeysDescripcionesSolicitudHoraExtra(solicitudhoraextras);
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
			this.getNewConnexionToDeep(SolicitudHoraExtra.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(solicitudhoraextra,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(SolicitudHoraExtra.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(solicitudhoraextras!=null) {
				for(SolicitudHoraExtra solicitudhoraextra:solicitudhoraextras) {
					this.deepSave(solicitudhoraextra,isDeep,deepLoadType,clases);
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
			if(solicitudhoraextras!=null) {
				for(SolicitudHoraExtra solicitudhoraextra:solicitudhoraextras) {
					this.deepSave(solicitudhoraextra,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getSolicitudHoraExtrasFK_IdEmpleadoWithConnection(String sFinalQuery,Pagination pagination,Long id_empleado)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SolicitudHoraExtra.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpleado= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpleado.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empleado,SolicitudHoraExtraConstantesFunciones.IDEMPLEADO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpleado);

			SolicitudHoraExtraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpleado","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			solicitudhoraextras=solicitudhoraextraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				SolicitudHoraExtraConstantesFunciones.refrescarForeignKeysDescripcionesSolicitudHoraExtra(this.solicitudhoraextras);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getSolicitudHoraExtrasFK_IdEmpleado(String sFinalQuery,Pagination pagination,Long id_empleado)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpleado= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpleado.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empleado,SolicitudHoraExtraConstantesFunciones.IDEMPLEADO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpleado);

			SolicitudHoraExtraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpleado","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			solicitudhoraextras=solicitudhoraextraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				SolicitudHoraExtraConstantesFunciones.refrescarForeignKeysDescripcionesSolicitudHoraExtra(this.solicitudhoraextras);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getSolicitudHoraExtrasFK_IdEmpleadoJefeWithConnection(String sFinalQuery,Pagination pagination,Long id_empleado_jefe)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SolicitudHoraExtra.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpleadoJefe= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpleadoJefe.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empleado_jefe,SolicitudHoraExtraConstantesFunciones.IDEMPLEADOJEFE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpleadoJefe);

			SolicitudHoraExtraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpleadoJefe","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			solicitudhoraextras=solicitudhoraextraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				SolicitudHoraExtraConstantesFunciones.refrescarForeignKeysDescripcionesSolicitudHoraExtra(this.solicitudhoraextras);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getSolicitudHoraExtrasFK_IdEmpleadoJefe(String sFinalQuery,Pagination pagination,Long id_empleado_jefe)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpleadoJefe= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpleadoJefe.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empleado_jefe,SolicitudHoraExtraConstantesFunciones.IDEMPLEADOJEFE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpleadoJefe);

			SolicitudHoraExtraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpleadoJefe","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			solicitudhoraextras=solicitudhoraextraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				SolicitudHoraExtraConstantesFunciones.refrescarForeignKeysDescripcionesSolicitudHoraExtra(this.solicitudhoraextras);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getSolicitudHoraExtrasFK_IdEmpleadoReemplazoWithConnection(String sFinalQuery,Pagination pagination,Long id_empleado_reemplazo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SolicitudHoraExtra.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpleadoReemplazo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpleadoReemplazo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empleado_reemplazo,SolicitudHoraExtraConstantesFunciones.IDEMPLEADOREEMPLAZO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpleadoReemplazo);

			SolicitudHoraExtraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpleadoReemplazo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			solicitudhoraextras=solicitudhoraextraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				SolicitudHoraExtraConstantesFunciones.refrescarForeignKeysDescripcionesSolicitudHoraExtra(this.solicitudhoraextras);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getSolicitudHoraExtrasFK_IdEmpleadoReemplazo(String sFinalQuery,Pagination pagination,Long id_empleado_reemplazo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpleadoReemplazo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpleadoReemplazo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empleado_reemplazo,SolicitudHoraExtraConstantesFunciones.IDEMPLEADOREEMPLAZO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpleadoReemplazo);

			SolicitudHoraExtraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpleadoReemplazo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			solicitudhoraextras=solicitudhoraextraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				SolicitudHoraExtraConstantesFunciones.refrescarForeignKeysDescripcionesSolicitudHoraExtra(this.solicitudhoraextras);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getSolicitudHoraExtrasFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SolicitudHoraExtra.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,SolicitudHoraExtraConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			SolicitudHoraExtraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			solicitudhoraextras=solicitudhoraextraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				SolicitudHoraExtraConstantesFunciones.refrescarForeignKeysDescripcionesSolicitudHoraExtra(this.solicitudhoraextras);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getSolicitudHoraExtrasFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,SolicitudHoraExtraConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			SolicitudHoraExtraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			solicitudhoraextras=solicitudhoraextraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				SolicitudHoraExtraConstantesFunciones.refrescarForeignKeysDescripcionesSolicitudHoraExtra(this.solicitudhoraextras);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getSolicitudHoraExtrasFK_IdEstadoSolicitudNomiWithConnection(String sFinalQuery,Pagination pagination,Long id_estado_solicitud_nomi)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SolicitudHoraExtra.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEstadoSolicitudNomi= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEstadoSolicitudNomi.setParameterSelectionGeneralEqual(ParameterType.LONG,id_estado_solicitud_nomi,SolicitudHoraExtraConstantesFunciones.IDESTADOSOLICITUDNOMI,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEstadoSolicitudNomi);

			SolicitudHoraExtraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEstadoSolicitudNomi","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			solicitudhoraextras=solicitudhoraextraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				SolicitudHoraExtraConstantesFunciones.refrescarForeignKeysDescripcionesSolicitudHoraExtra(this.solicitudhoraextras);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getSolicitudHoraExtrasFK_IdEstadoSolicitudNomi(String sFinalQuery,Pagination pagination,Long id_estado_solicitud_nomi)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEstadoSolicitudNomi= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEstadoSolicitudNomi.setParameterSelectionGeneralEqual(ParameterType.LONG,id_estado_solicitud_nomi,SolicitudHoraExtraConstantesFunciones.IDESTADOSOLICITUDNOMI,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEstadoSolicitudNomi);

			SolicitudHoraExtraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEstadoSolicitudNomi","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			solicitudhoraextras=solicitudhoraextraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				SolicitudHoraExtraConstantesFunciones.refrescarForeignKeysDescripcionesSolicitudHoraExtra(this.solicitudhoraextras);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getSolicitudHoraExtrasFK_IdEstructuraWithConnection(String sFinalQuery,Pagination pagination,Long id_estructura)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SolicitudHoraExtra.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEstructura= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEstructura.setParameterSelectionGeneralEqual(ParameterType.LONG,id_estructura,SolicitudHoraExtraConstantesFunciones.IDESTRUCTURA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEstructura);

			SolicitudHoraExtraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEstructura","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			solicitudhoraextras=solicitudhoraextraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				SolicitudHoraExtraConstantesFunciones.refrescarForeignKeysDescripcionesSolicitudHoraExtra(this.solicitudhoraextras);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getSolicitudHoraExtrasFK_IdEstructura(String sFinalQuery,Pagination pagination,Long id_estructura)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEstructura= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEstructura.setParameterSelectionGeneralEqual(ParameterType.LONG,id_estructura,SolicitudHoraExtraConstantesFunciones.IDESTRUCTURA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEstructura);

			SolicitudHoraExtraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEstructura","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			solicitudhoraextras=solicitudhoraextraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				SolicitudHoraExtraConstantesFunciones.refrescarForeignKeysDescripcionesSolicitudHoraExtra(this.solicitudhoraextras);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getSolicitudHoraExtrasFK_IdSucursalWithConnection(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SolicitudHoraExtra.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,SolicitudHoraExtraConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			SolicitudHoraExtraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			solicitudhoraextras=solicitudhoraextraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				SolicitudHoraExtraConstantesFunciones.refrescarForeignKeysDescripcionesSolicitudHoraExtra(this.solicitudhoraextras);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getSolicitudHoraExtrasFK_IdSucursal(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,SolicitudHoraExtraConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			SolicitudHoraExtraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			solicitudhoraextras=solicitudhoraextraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				SolicitudHoraExtraConstantesFunciones.refrescarForeignKeysDescripcionesSolicitudHoraExtra(this.solicitudhoraextras);
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
			if(SolicitudHoraExtraConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,SolicitudHoraExtraDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,SolicitudHoraExtra solicitudhoraextra,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(SolicitudHoraExtraConstantesFunciones.ISCONAUDITORIA) {
				if(solicitudhoraextra.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,SolicitudHoraExtraDataAccess.TABLENAME, solicitudhoraextra.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(SolicitudHoraExtraConstantesFunciones.ISCONAUDITORIADETALLE) {
						////SolicitudHoraExtraLogic.registrarAuditoriaDetallesSolicitudHoraExtra(connexion,solicitudhoraextra,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(solicitudhoraextra.getIsDeleted()) {
					/*if(!solicitudhoraextra.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,SolicitudHoraExtraDataAccess.TABLENAME, solicitudhoraextra.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////SolicitudHoraExtraLogic.registrarAuditoriaDetallesSolicitudHoraExtra(connexion,solicitudhoraextra,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,SolicitudHoraExtraDataAccess.TABLENAME, solicitudhoraextra.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(solicitudhoraextra.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,SolicitudHoraExtraDataAccess.TABLENAME, solicitudhoraextra.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(SolicitudHoraExtraConstantesFunciones.ISCONAUDITORIADETALLE) {
						////SolicitudHoraExtraLogic.registrarAuditoriaDetallesSolicitudHoraExtra(connexion,solicitudhoraextra,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesSolicitudHoraExtra(Connexion connexion,SolicitudHoraExtra solicitudhoraextra)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(solicitudhoraextra.getIsNew()||!solicitudhoraextra.getid_empresa().equals(solicitudhoraextra.getSolicitudHoraExtraOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(solicitudhoraextra.getSolicitudHoraExtraOriginal().getid_empresa()!=null)
				{
					strValorActual=solicitudhoraextra.getSolicitudHoraExtraOriginal().getid_empresa().toString();
				}
				if(solicitudhoraextra.getid_empresa()!=null)
				{
					strValorNuevo=solicitudhoraextra.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),SolicitudHoraExtraConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(solicitudhoraextra.getIsNew()||!solicitudhoraextra.getid_sucursal().equals(solicitudhoraextra.getSolicitudHoraExtraOriginal().getid_sucursal()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(solicitudhoraextra.getSolicitudHoraExtraOriginal().getid_sucursal()!=null)
				{
					strValorActual=solicitudhoraextra.getSolicitudHoraExtraOriginal().getid_sucursal().toString();
				}
				if(solicitudhoraextra.getid_sucursal()!=null)
				{
					strValorNuevo=solicitudhoraextra.getid_sucursal().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),SolicitudHoraExtraConstantesFunciones.IDSUCURSAL,strValorActual,strValorNuevo);
			}	
			
			if(solicitudhoraextra.getIsNew()||!solicitudhoraextra.getid_empleado().equals(solicitudhoraextra.getSolicitudHoraExtraOriginal().getid_empleado()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(solicitudhoraextra.getSolicitudHoraExtraOriginal().getid_empleado()!=null)
				{
					strValorActual=solicitudhoraextra.getSolicitudHoraExtraOriginal().getid_empleado().toString();
				}
				if(solicitudhoraextra.getid_empleado()!=null)
				{
					strValorNuevo=solicitudhoraextra.getid_empleado().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),SolicitudHoraExtraConstantesFunciones.IDEMPLEADO,strValorActual,strValorNuevo);
			}	
			
			if(solicitudhoraextra.getIsNew()||!solicitudhoraextra.getid_estructura().equals(solicitudhoraextra.getSolicitudHoraExtraOriginal().getid_estructura()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(solicitudhoraextra.getSolicitudHoraExtraOriginal().getid_estructura()!=null)
				{
					strValorActual=solicitudhoraextra.getSolicitudHoraExtraOriginal().getid_estructura().toString();
				}
				if(solicitudhoraextra.getid_estructura()!=null)
				{
					strValorNuevo=solicitudhoraextra.getid_estructura().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),SolicitudHoraExtraConstantesFunciones.IDESTRUCTURA,strValorActual,strValorNuevo);
			}	
			
			if(solicitudhoraextra.getIsNew()||!solicitudhoraextra.getid_empleado_jefe().equals(solicitudhoraextra.getSolicitudHoraExtraOriginal().getid_empleado_jefe()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(solicitudhoraextra.getSolicitudHoraExtraOriginal().getid_empleado_jefe()!=null)
				{
					strValorActual=solicitudhoraextra.getSolicitudHoraExtraOriginal().getid_empleado_jefe().toString();
				}
				if(solicitudhoraextra.getid_empleado_jefe()!=null)
				{
					strValorNuevo=solicitudhoraextra.getid_empleado_jefe().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),SolicitudHoraExtraConstantesFunciones.IDEMPLEADOJEFE,strValorActual,strValorNuevo);
			}	
			
			if(solicitudhoraextra.getIsNew()||!solicitudhoraextra.getid_estado_solicitud_nomi().equals(solicitudhoraextra.getSolicitudHoraExtraOriginal().getid_estado_solicitud_nomi()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(solicitudhoraextra.getSolicitudHoraExtraOriginal().getid_estado_solicitud_nomi()!=null)
				{
					strValorActual=solicitudhoraextra.getSolicitudHoraExtraOriginal().getid_estado_solicitud_nomi().toString();
				}
				if(solicitudhoraextra.getid_estado_solicitud_nomi()!=null)
				{
					strValorNuevo=solicitudhoraextra.getid_estado_solicitud_nomi().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),SolicitudHoraExtraConstantesFunciones.IDESTADOSOLICITUDNOMI,strValorActual,strValorNuevo);
			}	
			
			if(solicitudhoraextra.getIsNew()||!solicitudhoraextra.getid_empleado_reemplazo().equals(solicitudhoraextra.getSolicitudHoraExtraOriginal().getid_empleado_reemplazo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(solicitudhoraextra.getSolicitudHoraExtraOriginal().getid_empleado_reemplazo()!=null)
				{
					strValorActual=solicitudhoraextra.getSolicitudHoraExtraOriginal().getid_empleado_reemplazo().toString();
				}
				if(solicitudhoraextra.getid_empleado_reemplazo()!=null)
				{
					strValorNuevo=solicitudhoraextra.getid_empleado_reemplazo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),SolicitudHoraExtraConstantesFunciones.IDEMPLEADOREEMPLAZO,strValorActual,strValorNuevo);
			}	
			
			if(solicitudhoraextra.getIsNew()||!solicitudhoraextra.getsecuencial().equals(solicitudhoraextra.getSolicitudHoraExtraOriginal().getsecuencial()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(solicitudhoraextra.getSolicitudHoraExtraOriginal().getsecuencial()!=null)
				{
					strValorActual=solicitudhoraextra.getSolicitudHoraExtraOriginal().getsecuencial();
				}
				if(solicitudhoraextra.getsecuencial()!=null)
				{
					strValorNuevo=solicitudhoraextra.getsecuencial() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),SolicitudHoraExtraConstantesFunciones.SECUENCIAL,strValorActual,strValorNuevo);
			}	
			
			if(solicitudhoraextra.getIsNew()||!solicitudhoraextra.getfecha_solicita().equals(solicitudhoraextra.getSolicitudHoraExtraOriginal().getfecha_solicita()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(solicitudhoraextra.getSolicitudHoraExtraOriginal().getfecha_solicita()!=null)
				{
					strValorActual=solicitudhoraextra.getSolicitudHoraExtraOriginal().getfecha_solicita().toString();
				}
				if(solicitudhoraextra.getfecha_solicita()!=null)
				{
					strValorNuevo=solicitudhoraextra.getfecha_solicita().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),SolicitudHoraExtraConstantesFunciones.FECHASOLICITA,strValorActual,strValorNuevo);
			}	
			
			if(solicitudhoraextra.getIsNew()||!solicitudhoraextra.getfecha_ejecuta().equals(solicitudhoraextra.getSolicitudHoraExtraOriginal().getfecha_ejecuta()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(solicitudhoraextra.getSolicitudHoraExtraOriginal().getfecha_ejecuta()!=null)
				{
					strValorActual=solicitudhoraextra.getSolicitudHoraExtraOriginal().getfecha_ejecuta().toString();
				}
				if(solicitudhoraextra.getfecha_ejecuta()!=null)
				{
					strValorNuevo=solicitudhoraextra.getfecha_ejecuta().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),SolicitudHoraExtraConstantesFunciones.FECHAEJECUTA,strValorActual,strValorNuevo);
			}	
			
			if(solicitudhoraextra.getIsNew()||!solicitudhoraextra.getnumero_horas().equals(solicitudhoraextra.getSolicitudHoraExtraOriginal().getnumero_horas()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(solicitudhoraextra.getSolicitudHoraExtraOriginal().getnumero_horas()!=null)
				{
					strValorActual=solicitudhoraextra.getSolicitudHoraExtraOriginal().getnumero_horas().toString();
				}
				if(solicitudhoraextra.getnumero_horas()!=null)
				{
					strValorNuevo=solicitudhoraextra.getnumero_horas().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),SolicitudHoraExtraConstantesFunciones.NUMEROHORAS,strValorActual,strValorNuevo);
			}	
			
			if(solicitudhoraextra.getIsNew()||!solicitudhoraextra.getcosto_unitario().equals(solicitudhoraextra.getSolicitudHoraExtraOriginal().getcosto_unitario()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(solicitudhoraextra.getSolicitudHoraExtraOriginal().getcosto_unitario()!=null)
				{
					strValorActual=solicitudhoraextra.getSolicitudHoraExtraOriginal().getcosto_unitario().toString();
				}
				if(solicitudhoraextra.getcosto_unitario()!=null)
				{
					strValorNuevo=solicitudhoraextra.getcosto_unitario().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),SolicitudHoraExtraConstantesFunciones.COSTOUNITARIO,strValorActual,strValorNuevo);
			}	
			
			if(solicitudhoraextra.getIsNew()||!solicitudhoraextra.getcosto_total().equals(solicitudhoraextra.getSolicitudHoraExtraOriginal().getcosto_total()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(solicitudhoraextra.getSolicitudHoraExtraOriginal().getcosto_total()!=null)
				{
					strValorActual=solicitudhoraextra.getSolicitudHoraExtraOriginal().getcosto_total().toString();
				}
				if(solicitudhoraextra.getcosto_total()!=null)
				{
					strValorNuevo=solicitudhoraextra.getcosto_total().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),SolicitudHoraExtraConstantesFunciones.COSTOTOTAL,strValorActual,strValorNuevo);
			}	
			
			if(solicitudhoraextra.getIsNew()||!solicitudhoraextra.getdescripcion().equals(solicitudhoraextra.getSolicitudHoraExtraOriginal().getdescripcion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(solicitudhoraextra.getSolicitudHoraExtraOriginal().getdescripcion()!=null)
				{
					strValorActual=solicitudhoraextra.getSolicitudHoraExtraOriginal().getdescripcion();
				}
				if(solicitudhoraextra.getdescripcion()!=null)
				{
					strValorNuevo=solicitudhoraextra.getdescripcion() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),SolicitudHoraExtraConstantesFunciones.DESCRIPCION,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveSolicitudHoraExtraRelacionesWithConnection(SolicitudHoraExtra solicitudhoraextra) throws Exception {

		if(!solicitudhoraextra.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveSolicitudHoraExtraRelacionesBase(solicitudhoraextra,true);
		}
	}

	public void saveSolicitudHoraExtraRelaciones(SolicitudHoraExtra solicitudhoraextra)throws Exception {

		if(!solicitudhoraextra.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveSolicitudHoraExtraRelacionesBase(solicitudhoraextra,false);
		}
	}

	public void saveSolicitudHoraExtraRelacionesBase(SolicitudHoraExtra solicitudhoraextra,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("SolicitudHoraExtra-saveRelacionesWithConnection");}
	

			this.setSolicitudHoraExtra(solicitudhoraextra);

			if(SolicitudHoraExtraLogicAdditional.validarSaveRelaciones(solicitudhoraextra,this)) {

				SolicitudHoraExtraLogicAdditional.updateRelacionesToSave(solicitudhoraextra,this);

				if((solicitudhoraextra.getIsNew()||solicitudhoraextra.getIsChanged())&&!solicitudhoraextra.getIsDeleted()) {
					this.saveSolicitudHoraExtra();
					this.saveSolicitudHoraExtraRelacionesDetalles();

				} else if(solicitudhoraextra.getIsDeleted()) {
					this.saveSolicitudHoraExtraRelacionesDetalles();
					this.saveSolicitudHoraExtra();
				}

				SolicitudHoraExtraLogicAdditional.updateRelacionesToSaveAfter(solicitudhoraextra,this);

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
	
	
	private void saveSolicitudHoraExtraRelacionesDetalles()throws Exception {
		try {
	

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfSolicitudHoraExtra(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=SolicitudHoraExtraConstantesFunciones.getClassesForeignKeysOfSolicitudHoraExtra(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfSolicitudHoraExtra(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=SolicitudHoraExtraConstantesFunciones.getClassesRelationshipsOfSolicitudHoraExtra(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

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
import com.bydan.erp.nomina.util.DetalleCursoConstantesFunciones;
import com.bydan.erp.nomina.util.DetalleCursoParameterReturnGeneral;
//import com.bydan.erp.nomina.util.DetalleCursoParameterGeneral;
import com.bydan.erp.nomina.business.entity.DetalleCurso;
import com.bydan.erp.nomina.business.logic.DetalleCursoLogicAdditional;
import com.bydan.erp.nomina.business.dataaccess.*;
import com.bydan.erp.nomina.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;
















@SuppressWarnings("unused")
public class DetalleCursoLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(DetalleCursoLogic.class);
	
	protected DetalleCursoDataAccess detallecursoDataAccess; 	
	protected DetalleCurso detallecurso;
	protected List<DetalleCurso> detallecursos;
	protected Object detallecursoObject;	
	protected List<Object> detallecursosObject;
	
	public static ClassValidator<DetalleCurso> detallecursoValidator = new ClassValidator<DetalleCurso>(DetalleCurso.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected DetalleCursoLogicAdditional detallecursoLogicAdditional=null;
	
	public DetalleCursoLogicAdditional getDetalleCursoLogicAdditional() {
		return this.detallecursoLogicAdditional;
	}
	
	public void setDetalleCursoLogicAdditional(DetalleCursoLogicAdditional detallecursoLogicAdditional) {
		try {
			this.detallecursoLogicAdditional=detallecursoLogicAdditional;
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
	
	
	
	
	public  DetalleCursoLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.detallecursoDataAccess = new DetalleCursoDataAccess();
			
			this.detallecursos= new ArrayList<DetalleCurso>();
			this.detallecurso= new DetalleCurso();
			
			this.detallecursoObject=new Object();
			this.detallecursosObject=new ArrayList<Object>();
				
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
			
			this.detallecursoDataAccess.setConnexionType(this.connexionType);
			this.detallecursoDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  DetalleCursoLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.detallecursoDataAccess = new DetalleCursoDataAccess();
			this.detallecursos= new ArrayList<DetalleCurso>();
			this.detallecurso= new DetalleCurso();
			this.detallecursoObject=new Object();
			this.detallecursosObject=new ArrayList<Object>();
			
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
			
			this.detallecursoDataAccess.setConnexionType(this.connexionType);
			this.detallecursoDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public DetalleCurso getDetalleCurso() throws Exception {	
		DetalleCursoLogicAdditional.checkDetalleCursoToGet(detallecurso,this.datosCliente,this.arrDatoGeneral);
		DetalleCursoLogicAdditional.updateDetalleCursoToGet(detallecurso,this.arrDatoGeneral);
		
		return detallecurso;
	}
		
	public void setDetalleCurso(DetalleCurso newDetalleCurso) {
		this.detallecurso = newDetalleCurso;
	}
	
	public DetalleCursoDataAccess getDetalleCursoDataAccess() {
		return detallecursoDataAccess;
	}
	
	public void setDetalleCursoDataAccess(DetalleCursoDataAccess newdetallecursoDataAccess) {
		this.detallecursoDataAccess = newdetallecursoDataAccess;
	}
	
	public List<DetalleCurso> getDetalleCursos() throws Exception {		
		this.quitarDetalleCursosNulos();
		
		DetalleCursoLogicAdditional.checkDetalleCursoToGets(detallecursos,this.datosCliente,this.arrDatoGeneral);
		
		for (DetalleCurso detallecursoLocal: detallecursos ) {
			DetalleCursoLogicAdditional.updateDetalleCursoToGet(detallecursoLocal,this.arrDatoGeneral);
		}
		
		return detallecursos;
	}
	
	public void setDetalleCursos(List<DetalleCurso> newDetalleCursos) {
		this.detallecursos = newDetalleCursos;
	}
	
	public Object getDetalleCursoObject() {	
		this.detallecursoObject=this.detallecursoDataAccess.getEntityObject();
		return this.detallecursoObject;
	}
		
	public void setDetalleCursoObject(Object newDetalleCursoObject) {
		this.detallecursoObject = newDetalleCursoObject;
	}
	
	public List<Object> getDetalleCursosObject() {		
		this.detallecursosObject=this.detallecursoDataAccess.getEntitiesObject();
		return this.detallecursosObject;
	}
		
	public void setDetalleCursosObject(List<Object> newDetalleCursosObject) {
		this.detallecursosObject = newDetalleCursosObject;
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
		
		if(this.detallecursoDataAccess!=null) {
			this.detallecursoDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleCurso.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			detallecursoDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			detallecursoDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		detallecurso = new  DetalleCurso();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleCurso.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			detallecurso=detallecursoDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.detallecurso,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				DetalleCursoConstantesFunciones.refrescarForeignKeysDescripcionesDetalleCurso(this.detallecurso);
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
		detallecurso = new  DetalleCurso();
		  		  
        try {
			
			detallecurso=detallecursoDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.detallecurso,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				DetalleCursoConstantesFunciones.refrescarForeignKeysDescripcionesDetalleCurso(this.detallecurso);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		detallecurso = new  DetalleCurso();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleCurso.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			detallecurso=detallecursoDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.detallecurso,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				DetalleCursoConstantesFunciones.refrescarForeignKeysDescripcionesDetalleCurso(this.detallecurso);
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
		detallecurso = new  DetalleCurso();
		  		  
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
		detallecurso = new  DetalleCurso();
		  		  
        try {
			
			detallecurso=detallecursoDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.detallecurso,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				DetalleCursoConstantesFunciones.refrescarForeignKeysDescripcionesDetalleCurso(this.detallecurso);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		detallecurso = new  DetalleCurso();
		  		  
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
		detallecurso = new  DetalleCurso();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleCurso.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =detallecursoDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		detallecurso = new  DetalleCurso();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=detallecursoDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		detallecurso = new  DetalleCurso();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleCurso.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =detallecursoDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		detallecurso = new  DetalleCurso();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=detallecursoDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		detallecurso = new  DetalleCurso();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleCurso.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =detallecursoDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		detallecurso = new  DetalleCurso();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=detallecursoDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		detallecursos = new  ArrayList<DetalleCurso>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleCurso.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			DetalleCursoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detallecursos=detallecursoDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarDetalleCurso(detallecursos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleCursoConstantesFunciones.refrescarForeignKeysDescripcionesDetalleCurso(this.detallecursos);
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
		detallecursos = new  ArrayList<DetalleCurso>();
		  		  
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
		detallecursos = new  ArrayList<DetalleCurso>();
		  		  
        try {			
			DetalleCursoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detallecursos=detallecursoDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarDetalleCurso(detallecursos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleCursoConstantesFunciones.refrescarForeignKeysDescripcionesDetalleCurso(this.detallecursos);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		detallecursos = new  ArrayList<DetalleCurso>();
		  		  
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
		detallecursos = new  ArrayList<DetalleCurso>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleCurso.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			DetalleCursoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detallecursos=detallecursoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarDetalleCurso(detallecursos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleCursoConstantesFunciones.refrescarForeignKeysDescripcionesDetalleCurso(this.detallecursos);
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
		detallecursos = new  ArrayList<DetalleCurso>();
		  		  
        try {
			DetalleCursoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detallecursos=detallecursoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarDetalleCurso(detallecursos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleCursoConstantesFunciones.refrescarForeignKeysDescripcionesDetalleCurso(this.detallecursos);
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
		detallecursos = new  ArrayList<DetalleCurso>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleCurso.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DetalleCursoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detallecursos=detallecursoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarDetalleCurso(detallecursos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleCursoConstantesFunciones.refrescarForeignKeysDescripcionesDetalleCurso(this.detallecursos);
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
		detallecursos = new  ArrayList<DetalleCurso>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DetalleCursoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detallecursos=detallecursoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarDetalleCurso(detallecursos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleCursoConstantesFunciones.refrescarForeignKeysDescripcionesDetalleCurso(this.detallecursos);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		detallecurso = new  DetalleCurso();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleCurso.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DetalleCursoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detallecurso=detallecursoDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarDetalleCurso(detallecurso);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleCursoConstantesFunciones.refrescarForeignKeysDescripcionesDetalleCurso(this.detallecurso);
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
		detallecurso = new  DetalleCurso();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DetalleCursoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detallecurso=detallecursoDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarDetalleCurso(detallecurso);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleCursoConstantesFunciones.refrescarForeignKeysDescripcionesDetalleCurso(this.detallecurso);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		detallecursos = new  ArrayList<DetalleCurso>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleCurso.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			DetalleCursoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detallecursos=detallecursoDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarDetalleCurso(detallecursos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleCursoConstantesFunciones.refrescarForeignKeysDescripcionesDetalleCurso(this.detallecursos);
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
		detallecursos = new  ArrayList<DetalleCurso>();
		  		  
        try {
			DetalleCursoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detallecursos=detallecursoDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarDetalleCurso(detallecursos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleCursoConstantesFunciones.refrescarForeignKeysDescripcionesDetalleCurso(this.detallecursos);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosDetalleCursosWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		detallecursos = new  ArrayList<DetalleCurso>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleCurso.class.getSimpleName()+"-getTodosDetalleCursosWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DetalleCursoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detallecursos=detallecursoDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarDetalleCurso(detallecursos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleCursoConstantesFunciones.refrescarForeignKeysDescripcionesDetalleCurso(this.detallecursos);
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
	
	public  void  getTodosDetalleCursos(String sFinalQuery,Pagination pagination)throws Exception {
		detallecursos = new  ArrayList<DetalleCurso>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DetalleCursoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detallecursos=detallecursoDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarDetalleCurso(detallecursos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleCursoConstantesFunciones.refrescarForeignKeysDescripcionesDetalleCurso(this.detallecursos);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarDetalleCurso(DetalleCurso detallecurso) throws Exception {
		Boolean estaValidado=false;
		
		if(detallecurso.getIsNew() || detallecurso.getIsChanged()) { 
			this.invalidValues = detallecursoValidator.getInvalidValues(detallecurso);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(detallecurso);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarDetalleCurso(List<DetalleCurso> DetalleCursos) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(DetalleCurso detallecursoLocal:detallecursos) {				
			estaValidadoObjeto=this.validarGuardarDetalleCurso(detallecursoLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarDetalleCurso(List<DetalleCurso> DetalleCursos) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarDetalleCurso(detallecursos)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarDetalleCurso(DetalleCurso DetalleCurso) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarDetalleCurso(detallecurso)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(DetalleCurso detallecurso) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+detallecurso.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=DetalleCursoConstantesFunciones.getDetalleCursoLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"detallecurso","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(DetalleCursoConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(DetalleCursoConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveDetalleCursoWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleCurso.class.getSimpleName()+"-saveDetalleCursoWithConnection");connexion.begin();			
			
			DetalleCursoLogicAdditional.checkDetalleCursoToSave(this.detallecurso,this.datosCliente,connexion,this.arrDatoGeneral);
			
			DetalleCursoLogicAdditional.updateDetalleCursoToSave(this.detallecurso,this.arrDatoGeneral);
			
			DetalleCursoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.detallecurso,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowDetalleCurso();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarDetalleCurso(this.detallecurso)) {
				DetalleCursoDataAccess.save(this.detallecurso, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.detallecurso,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			DetalleCursoLogicAdditional.checkDetalleCursoToSaveAfter(this.detallecurso,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowDetalleCurso();
			
			connexion.commit();			
			
			if(this.detallecurso.getIsDeleted()) {
				this.detallecurso=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveDetalleCurso()throws Exception {	
		try {	
			
			DetalleCursoLogicAdditional.checkDetalleCursoToSave(this.detallecurso,this.datosCliente,connexion,this.arrDatoGeneral);
			
			DetalleCursoLogicAdditional.updateDetalleCursoToSave(this.detallecurso,this.arrDatoGeneral);
			
			DetalleCursoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.detallecurso,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarDetalleCurso(this.detallecurso)) {			
				DetalleCursoDataAccess.save(this.detallecurso, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.detallecurso,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			DetalleCursoLogicAdditional.checkDetalleCursoToSaveAfter(this.detallecurso,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.detallecurso.getIsDeleted()) {
				this.detallecurso=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveDetalleCursosWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleCurso.class.getSimpleName()+"-saveDetalleCursosWithConnection");connexion.begin();			
			
			DetalleCursoLogicAdditional.checkDetalleCursoToSaves(detallecursos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowDetalleCursos();
			
			Boolean validadoTodosDetalleCurso=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(DetalleCurso detallecursoLocal:detallecursos) {		
				if(detallecursoLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				DetalleCursoLogicAdditional.updateDetalleCursoToSave(detallecursoLocal,this.arrDatoGeneral);
	        	
				DetalleCursoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),detallecursoLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarDetalleCurso(detallecursoLocal)) {
					DetalleCursoDataAccess.save(detallecursoLocal, connexion);				
				} else {
					validadoTodosDetalleCurso=false;
				}
			}
			
			if(!validadoTodosDetalleCurso) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			DetalleCursoLogicAdditional.checkDetalleCursoToSavesAfter(detallecursos,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowDetalleCursos();
			
			connexion.commit();		
			
			this.quitarDetalleCursosEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveDetalleCursos()throws Exception {				
		 try {	
			DetalleCursoLogicAdditional.checkDetalleCursoToSaves(detallecursos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosDetalleCurso=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(DetalleCurso detallecursoLocal:detallecursos) {				
				if(detallecursoLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				DetalleCursoLogicAdditional.updateDetalleCursoToSave(detallecursoLocal,this.arrDatoGeneral);
	        	
				DetalleCursoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),detallecursoLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarDetalleCurso(detallecursoLocal)) {				
					DetalleCursoDataAccess.save(detallecursoLocal, connexion);				
				} else {
					validadoTodosDetalleCurso=false;
				}
			}
			
			if(!validadoTodosDetalleCurso) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			DetalleCursoLogicAdditional.checkDetalleCursoToSavesAfter(detallecursos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarDetalleCursosEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public DetalleCursoParameterReturnGeneral procesarAccionDetalleCursos(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<DetalleCurso> detallecursos,DetalleCursoParameterReturnGeneral detallecursoParameterGeneral)throws Exception {
		 try {	
			DetalleCursoParameterReturnGeneral detallecursoReturnGeneral=new DetalleCursoParameterReturnGeneral();
	
			DetalleCursoLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,detallecursos,detallecursoParameterGeneral,detallecursoReturnGeneral);
			
			return detallecursoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public DetalleCursoParameterReturnGeneral procesarAccionDetalleCursosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<DetalleCurso> detallecursos,DetalleCursoParameterReturnGeneral detallecursoParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleCurso.class.getSimpleName()+"-procesarAccionDetalleCursosWithConnection");connexion.begin();			
			
			DetalleCursoParameterReturnGeneral detallecursoReturnGeneral=new DetalleCursoParameterReturnGeneral();
	
			DetalleCursoLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,detallecursos,detallecursoParameterGeneral,detallecursoReturnGeneral);
			
			this.connexion.commit();
			
			return detallecursoReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public DetalleCursoParameterReturnGeneral procesarEventosDetalleCursos(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<DetalleCurso> detallecursos,DetalleCurso detallecurso,DetalleCursoParameterReturnGeneral detallecursoParameterGeneral,Boolean isEsNuevoDetalleCurso,ArrayList<Classe> clases)throws Exception {
		 try {	
			DetalleCursoParameterReturnGeneral detallecursoReturnGeneral=new DetalleCursoParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				detallecursoReturnGeneral.setConRecargarPropiedades(true);
			}
			
			DetalleCursoLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,detallecursos,detallecurso,detallecursoParameterGeneral,detallecursoReturnGeneral,isEsNuevoDetalleCurso,clases);
			
			return detallecursoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public DetalleCursoParameterReturnGeneral procesarEventosDetalleCursosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<DetalleCurso> detallecursos,DetalleCurso detallecurso,DetalleCursoParameterReturnGeneral detallecursoParameterGeneral,Boolean isEsNuevoDetalleCurso,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleCurso.class.getSimpleName()+"-procesarEventosDetalleCursosWithConnection");connexion.begin();			
			
			DetalleCursoParameterReturnGeneral detallecursoReturnGeneral=new DetalleCursoParameterReturnGeneral();
	
			detallecursoReturnGeneral.setDetalleCurso(detallecurso);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				detallecursoReturnGeneral.setConRecargarPropiedades(true);
			}
			
			DetalleCursoLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,detallecursos,detallecurso,detallecursoParameterGeneral,detallecursoReturnGeneral,isEsNuevoDetalleCurso,clases);
			
			this.connexion.commit();
			
			return detallecursoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public DetalleCursoParameterReturnGeneral procesarImportacionDetalleCursosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,DetalleCursoParameterReturnGeneral detallecursoParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleCurso.class.getSimpleName()+"-procesarImportacionDetalleCursosWithConnection");connexion.begin();			
			
			DetalleCursoParameterReturnGeneral detallecursoReturnGeneral=new DetalleCursoParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.detallecursos=new ArrayList<DetalleCurso>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.detallecurso=new DetalleCurso();
				
				
				if(conColumnasBase) {this.detallecurso.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.detallecurso.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.detallecurso.setnombre(arrColumnas[iColumn++]);
				this.detallecurso.setdescripcion(arrColumnas[iColumn++]);
				
				this.detallecursos.add(this.detallecurso);
			}
			
			this.saveDetalleCursos();
			
			this.connexion.commit();
			
			detallecursoReturnGeneral.setConRetornoEstaProcesado(true);
			detallecursoReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return detallecursoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarDetalleCursosEliminados() throws Exception {				
		
		List<DetalleCurso> detallecursosAux= new ArrayList<DetalleCurso>();
		
		for(DetalleCurso detallecurso:detallecursos) {
			if(!detallecurso.getIsDeleted()) {
				detallecursosAux.add(detallecurso);
			}
		}
		
		detallecursos=detallecursosAux;
	}
	
	public void quitarDetalleCursosNulos() throws Exception {				
		
		List<DetalleCurso> detallecursosAux= new ArrayList<DetalleCurso>();
		
		for(DetalleCurso detallecurso : this.detallecursos) {
			if(detallecurso==null) {
				detallecursosAux.add(detallecurso);
			}
		}
		
		//this.detallecursos=detallecursosAux;
		
		this.detallecursos.removeAll(detallecursosAux);
	}
	
	public void getSetVersionRowDetalleCursoWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(detallecurso.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((detallecurso.getIsDeleted() || (detallecurso.getIsChanged()&&!detallecurso.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=detallecursoDataAccess.getSetVersionRowDetalleCurso(connexion,detallecurso.getId());
				
				if(!detallecurso.getVersionRow().equals(timestamp)) {	
					detallecurso.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				detallecurso.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowDetalleCurso()throws Exception {	
		
		if(detallecurso.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((detallecurso.getIsDeleted() || (detallecurso.getIsChanged()&&!detallecurso.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=detallecursoDataAccess.getSetVersionRowDetalleCurso(connexion,detallecurso.getId());
			
			try {							
				if(!detallecurso.getVersionRow().equals(timestamp)) {	
					detallecurso.setVersionRow(timestamp);
				}
				
				detallecurso.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowDetalleCursosWithConnection()throws Exception {	
		if(detallecursos!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(DetalleCurso detallecursoAux:detallecursos) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(detallecursoAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(detallecursoAux.getIsDeleted() || (detallecursoAux.getIsChanged()&&!detallecursoAux.getIsNew())) {
						
						timestamp=detallecursoDataAccess.getSetVersionRowDetalleCurso(connexion,detallecursoAux.getId());
						
						if(!detallecurso.getVersionRow().equals(timestamp)) {	
							detallecursoAux.setVersionRow(timestamp);
						}
								
						detallecursoAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowDetalleCursos()throws Exception {	
		if(detallecursos!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(DetalleCurso detallecursoAux:detallecursos) {
					if(detallecursoAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(detallecursoAux.getIsDeleted() || (detallecursoAux.getIsChanged()&&!detallecursoAux.getIsNew())) {
						
						timestamp=detallecursoDataAccess.getSetVersionRowDetalleCurso(connexion,detallecursoAux.getId());
						
						if(!detallecursoAux.getVersionRow().equals(timestamp)) {	
							detallecursoAux.setVersionRow(timestamp);
						}
						
													
						detallecursoAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public DetalleCursoParameterReturnGeneral cargarCombosLoteForeignKeyDetalleCursoWithConnection(String finalQueryGlobalCurso) throws Exception {
		DetalleCursoParameterReturnGeneral  detallecursoReturnGeneral =new DetalleCursoParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleCurso.class.getSimpleName()+"-cargarCombosLoteForeignKeyDetalleCursoWithConnection");connexion.begin();
			
			detallecursoReturnGeneral =new DetalleCursoParameterReturnGeneral();
			
			

			List<Curso> cursosForeignKey=new ArrayList<Curso>();
			CursoLogic cursoLogic=new CursoLogic();
			cursoLogic.setConnexion(this.connexion);
			cursoLogic.getCursoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCurso.equals("NONE")) {
				cursoLogic.getTodosCursos(finalQueryGlobalCurso,new Pagination());
				cursosForeignKey=cursoLogic.getCursos();
			}

			detallecursoReturnGeneral.setcursosForeignKey(cursosForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return detallecursoReturnGeneral;
	}
	
	public DetalleCursoParameterReturnGeneral cargarCombosLoteForeignKeyDetalleCurso(String finalQueryGlobalCurso) throws Exception {
		DetalleCursoParameterReturnGeneral  detallecursoReturnGeneral =new DetalleCursoParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			detallecursoReturnGeneral =new DetalleCursoParameterReturnGeneral();
			
			

			List<Curso> cursosForeignKey=new ArrayList<Curso>();
			CursoLogic cursoLogic=new CursoLogic();
			cursoLogic.setConnexion(this.connexion);
			cursoLogic.getCursoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCurso.equals("NONE")) {
				cursoLogic.getTodosCursos(finalQueryGlobalCurso,new Pagination());
				cursosForeignKey=cursoLogic.getCursos();
			}

			detallecursoReturnGeneral.setcursosForeignKey(cursosForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return detallecursoReturnGeneral;
	}
	
	
	public void deepLoad(DetalleCurso detallecurso,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			DetalleCursoLogicAdditional.updateDetalleCursoToGet(detallecurso,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		detallecurso.setCurso(detallecursoDataAccess.getCurso(connexion,detallecurso));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Curso.class)) {
				detallecurso.setCurso(detallecursoDataAccess.getCurso(connexion,detallecurso));
				continue;
			}
		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Curso.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallecurso.setCurso(detallecursoDataAccess.getCurso(connexion,detallecurso));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		detallecurso.setCurso(detallecursoDataAccess.getCurso(connexion,detallecurso));
		CursoLogic cursoLogic= new CursoLogic(connexion);
		cursoLogic.deepLoad(detallecurso.getCurso(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Curso.class)) {
				detallecurso.setCurso(detallecursoDataAccess.getCurso(connexion,detallecurso));
				CursoLogic cursoLogic= new CursoLogic(connexion);
				cursoLogic.deepLoad(detallecurso.getCurso(),isDeep,deepLoadType,clases);				
				continue;
			}

		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {


		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Curso.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallecurso.setCurso(detallecursoDataAccess.getCurso(connexion,detallecurso));
			CursoLogic cursoLogic= new CursoLogic(connexion);
			cursoLogic.deepLoad(detallecurso.getCurso(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(DetalleCurso detallecurso,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			DetalleCursoLogicAdditional.updateDetalleCursoToSave(detallecurso,this.arrDatoGeneral);
			
DetalleCursoDataAccess.save(detallecurso, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		CursoDataAccess.save(detallecurso.getCurso(),connexion);
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Curso.class)) {
				CursoDataAccess.save(detallecurso.getCurso(),connexion);
				continue;
			}

		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		CursoDataAccess.save(detallecurso.getCurso(),connexion);
		CursoLogic cursoLogic= new CursoLogic(connexion);
		cursoLogic.deepLoad(detallecurso.getCurso(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Curso.class)) {
				CursoDataAccess.save(detallecurso.getCurso(),connexion);
				CursoLogic cursoLogic= new CursoLogic(connexion);
				cursoLogic.deepSave(detallecurso.getCurso(),isDeep,deepLoadType,clases);				
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
			this.getNewConnexionToDeep(DetalleCurso.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(detallecurso,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				DetalleCursoConstantesFunciones.refrescarForeignKeysDescripcionesDetalleCurso(detallecurso);
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
			this.deepLoad(this.detallecurso,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				DetalleCursoConstantesFunciones.refrescarForeignKeysDescripcionesDetalleCurso(this.detallecurso);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(DetalleCurso.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(detallecursos!=null) {
				for(DetalleCurso detallecurso:detallecursos) {
					this.deepLoad(detallecurso,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					DetalleCursoConstantesFunciones.refrescarForeignKeysDescripcionesDetalleCurso(detallecursos);
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
			if(detallecursos!=null) {
				for(DetalleCurso detallecurso:detallecursos) {
					this.deepLoad(detallecurso,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					DetalleCursoConstantesFunciones.refrescarForeignKeysDescripcionesDetalleCurso(detallecursos);
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
			this.getNewConnexionToDeep(DetalleCurso.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(detallecurso,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(DetalleCurso.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(detallecursos!=null) {
				for(DetalleCurso detallecurso:detallecursos) {
					this.deepSave(detallecurso,isDeep,deepLoadType,clases);
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
			if(detallecursos!=null) {
				for(DetalleCurso detallecurso:detallecursos) {
					this.deepSave(detallecurso,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getDetalleCursosFK_IdCursoWithConnection(String sFinalQuery,Pagination pagination,Long id_curso)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleCurso.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCurso= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCurso.setParameterSelectionGeneralEqual(ParameterType.LONG,id_curso,DetalleCursoConstantesFunciones.IDCURSO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCurso);

			DetalleCursoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCurso","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallecursos=detallecursoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleCursoConstantesFunciones.refrescarForeignKeysDescripcionesDetalleCurso(this.detallecursos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleCursosFK_IdCurso(String sFinalQuery,Pagination pagination,Long id_curso)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCurso= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCurso.setParameterSelectionGeneralEqual(ParameterType.LONG,id_curso,DetalleCursoConstantesFunciones.IDCURSO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCurso);

			DetalleCursoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCurso","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallecursos=detallecursoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleCursoConstantesFunciones.refrescarForeignKeysDescripcionesDetalleCurso(this.detallecursos);
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
			if(DetalleCursoConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,DetalleCursoDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,DetalleCurso detallecurso,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(DetalleCursoConstantesFunciones.ISCONAUDITORIA) {
				if(detallecurso.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,DetalleCursoDataAccess.TABLENAME, detallecurso.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(DetalleCursoConstantesFunciones.ISCONAUDITORIADETALLE) {
						////DetalleCursoLogic.registrarAuditoriaDetallesDetalleCurso(connexion,detallecurso,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(detallecurso.getIsDeleted()) {
					/*if(!detallecurso.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,DetalleCursoDataAccess.TABLENAME, detallecurso.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////DetalleCursoLogic.registrarAuditoriaDetallesDetalleCurso(connexion,detallecurso,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,DetalleCursoDataAccess.TABLENAME, detallecurso.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(detallecurso.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,DetalleCursoDataAccess.TABLENAME, detallecurso.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(DetalleCursoConstantesFunciones.ISCONAUDITORIADETALLE) {
						////DetalleCursoLogic.registrarAuditoriaDetallesDetalleCurso(connexion,detallecurso,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesDetalleCurso(Connexion connexion,DetalleCurso detallecurso)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(detallecurso.getIsNew()||!detallecurso.getid_curso().equals(detallecurso.getDetalleCursoOriginal().getid_curso()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallecurso.getDetalleCursoOriginal().getid_curso()!=null)
				{
					strValorActual=detallecurso.getDetalleCursoOriginal().getid_curso().toString();
				}
				if(detallecurso.getid_curso()!=null)
				{
					strValorNuevo=detallecurso.getid_curso().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleCursoConstantesFunciones.IDCURSO,strValorActual,strValorNuevo);
			}	
			
			if(detallecurso.getIsNew()||!detallecurso.getnombre().equals(detallecurso.getDetalleCursoOriginal().getnombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallecurso.getDetalleCursoOriginal().getnombre()!=null)
				{
					strValorActual=detallecurso.getDetalleCursoOriginal().getnombre();
				}
				if(detallecurso.getnombre()!=null)
				{
					strValorNuevo=detallecurso.getnombre() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleCursoConstantesFunciones.NOMBRE,strValorActual,strValorNuevo);
			}	
			
			if(detallecurso.getIsNew()||!detallecurso.getdescripcion().equals(detallecurso.getDetalleCursoOriginal().getdescripcion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallecurso.getDetalleCursoOriginal().getdescripcion()!=null)
				{
					strValorActual=detallecurso.getDetalleCursoOriginal().getdescripcion();
				}
				if(detallecurso.getdescripcion()!=null)
				{
					strValorNuevo=detallecurso.getdescripcion() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleCursoConstantesFunciones.DESCRIPCION,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveDetalleCursoRelacionesWithConnection(DetalleCurso detallecurso) throws Exception {

		if(!detallecurso.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveDetalleCursoRelacionesBase(detallecurso,true);
		}
	}

	public void saveDetalleCursoRelaciones(DetalleCurso detallecurso)throws Exception {

		if(!detallecurso.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveDetalleCursoRelacionesBase(detallecurso,false);
		}
	}

	public void saveDetalleCursoRelacionesBase(DetalleCurso detallecurso,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("DetalleCurso-saveRelacionesWithConnection");}
	

			this.setDetalleCurso(detallecurso);

			if(DetalleCursoLogicAdditional.validarSaveRelaciones(detallecurso,this)) {

				DetalleCursoLogicAdditional.updateRelacionesToSave(detallecurso,this);

				if((detallecurso.getIsNew()||detallecurso.getIsChanged())&&!detallecurso.getIsDeleted()) {
					this.saveDetalleCurso();
					this.saveDetalleCursoRelacionesDetalles();

				} else if(detallecurso.getIsDeleted()) {
					this.saveDetalleCursoRelacionesDetalles();
					this.saveDetalleCurso();
				}

				DetalleCursoLogicAdditional.updateRelacionesToSaveAfter(detallecurso,this);

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
	
	
	private void saveDetalleCursoRelacionesDetalles()throws Exception {
		try {
	

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfDetalleCurso(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=DetalleCursoConstantesFunciones.getClassesForeignKeysOfDetalleCurso(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfDetalleCurso(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=DetalleCursoConstantesFunciones.getClassesRelationshipsOfDetalleCurso(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

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
package com.bydan.erp.tesoreria.business.logic;

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
import com.bydan.erp.tesoreria.util.*;
import com.bydan.erp.tesoreria.util.EstadoPagoAutoConstantesFunciones;
import com.bydan.erp.tesoreria.util.EstadoPagoAutoParameterReturnGeneral;
//import com.bydan.erp.tesoreria.util.EstadoPagoAutoParameterGeneral;
import com.bydan.erp.tesoreria.business.entity.EstadoPagoAuto;
//import com.bydan.erp.tesoreria.business.logic.EstadoPagoAutoLogicAdditional;
import com.bydan.erp.tesoreria.business.dataaccess.*;
import com.bydan.erp.tesoreria.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;
















@SuppressWarnings("unused")
public class EstadoPagoAutoLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(EstadoPagoAutoLogic.class);
	
	protected EstadoPagoAutoDataAccess estadopagoautoDataAccess; 	
	protected EstadoPagoAuto estadopagoauto;
	protected List<EstadoPagoAuto> estadopagoautos;
	protected Object estadopagoautoObject;	
	protected List<Object> estadopagoautosObject;
	
	public static ClassValidator<EstadoPagoAuto> estadopagoautoValidator = new ClassValidator<EstadoPagoAuto>(EstadoPagoAuto.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
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
	
	
	
	
	public  EstadoPagoAutoLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.estadopagoautoDataAccess = new EstadoPagoAutoDataAccess();
			
			this.estadopagoautos= new ArrayList<EstadoPagoAuto>();
			this.estadopagoauto= new EstadoPagoAuto();
			
			this.estadopagoautoObject=new Object();
			this.estadopagoautosObject=new ArrayList<Object>();
				
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
			
			this.estadopagoautoDataAccess.setConnexionType(this.connexionType);
			this.estadopagoautoDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  EstadoPagoAutoLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.estadopagoautoDataAccess = new EstadoPagoAutoDataAccess();
			this.estadopagoautos= new ArrayList<EstadoPagoAuto>();
			this.estadopagoauto= new EstadoPagoAuto();
			this.estadopagoautoObject=new Object();
			this.estadopagoautosObject=new ArrayList<Object>();
			
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
			
			this.estadopagoautoDataAccess.setConnexionType(this.connexionType);
			this.estadopagoautoDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public EstadoPagoAuto getEstadoPagoAuto() throws Exception {	
		//EstadoPagoAutoLogicAdditional.checkEstadoPagoAutoToGet(estadopagoauto,this.datosCliente,this.arrDatoGeneral);
		//EstadoPagoAutoLogicAdditional.updateEstadoPagoAutoToGet(estadopagoauto,this.arrDatoGeneral);
		
		return estadopagoauto;
	}
		
	public void setEstadoPagoAuto(EstadoPagoAuto newEstadoPagoAuto) {
		this.estadopagoauto = newEstadoPagoAuto;
	}
	
	public EstadoPagoAutoDataAccess getEstadoPagoAutoDataAccess() {
		return estadopagoautoDataAccess;
	}
	
	public void setEstadoPagoAutoDataAccess(EstadoPagoAutoDataAccess newestadopagoautoDataAccess) {
		this.estadopagoautoDataAccess = newestadopagoautoDataAccess;
	}
	
	public List<EstadoPagoAuto> getEstadoPagoAutos() throws Exception {		
		this.quitarEstadoPagoAutosNulos();
		
		//EstadoPagoAutoLogicAdditional.checkEstadoPagoAutoToGets(estadopagoautos,this.datosCliente,this.arrDatoGeneral);
		
		for (EstadoPagoAuto estadopagoautoLocal: estadopagoautos ) {
			//EstadoPagoAutoLogicAdditional.updateEstadoPagoAutoToGet(estadopagoautoLocal,this.arrDatoGeneral);
		}
		
		return estadopagoautos;
	}
	
	public void setEstadoPagoAutos(List<EstadoPagoAuto> newEstadoPagoAutos) {
		this.estadopagoautos = newEstadoPagoAutos;
	}
	
	public Object getEstadoPagoAutoObject() {	
		this.estadopagoautoObject=this.estadopagoautoDataAccess.getEntityObject();
		return this.estadopagoautoObject;
	}
		
	public void setEstadoPagoAutoObject(Object newEstadoPagoAutoObject) {
		this.estadopagoautoObject = newEstadoPagoAutoObject;
	}
	
	public List<Object> getEstadoPagoAutosObject() {		
		this.estadopagoautosObject=this.estadopagoautoDataAccess.getEntitiesObject();
		return this.estadopagoautosObject;
	}
		
	public void setEstadoPagoAutosObject(List<Object> newEstadoPagoAutosObject) {
		this.estadopagoautosObject = newEstadoPagoAutosObject;
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
		
		if(this.estadopagoautoDataAccess!=null) {
			this.estadopagoautoDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoPagoAuto.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			estadopagoautoDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			estadopagoautoDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		estadopagoauto = new  EstadoPagoAuto();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoPagoAuto.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			estadopagoauto=estadopagoautoDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.estadopagoauto,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				EstadoPagoAutoConstantesFunciones.refrescarForeignKeysDescripcionesEstadoPagoAuto(this.estadopagoauto);
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
		estadopagoauto = new  EstadoPagoAuto();
		  		  
        try {
			
			estadopagoauto=estadopagoautoDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.estadopagoauto,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				EstadoPagoAutoConstantesFunciones.refrescarForeignKeysDescripcionesEstadoPagoAuto(this.estadopagoauto);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		estadopagoauto = new  EstadoPagoAuto();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoPagoAuto.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			estadopagoauto=estadopagoautoDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.estadopagoauto,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				EstadoPagoAutoConstantesFunciones.refrescarForeignKeysDescripcionesEstadoPagoAuto(this.estadopagoauto);
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
		estadopagoauto = new  EstadoPagoAuto();
		  		  
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
		estadopagoauto = new  EstadoPagoAuto();
		  		  
        try {
			
			estadopagoauto=estadopagoautoDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.estadopagoauto,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				EstadoPagoAutoConstantesFunciones.refrescarForeignKeysDescripcionesEstadoPagoAuto(this.estadopagoauto);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		estadopagoauto = new  EstadoPagoAuto();
		  		  
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
		estadopagoauto = new  EstadoPagoAuto();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoPagoAuto.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =estadopagoautoDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		estadopagoauto = new  EstadoPagoAuto();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=estadopagoautoDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		estadopagoauto = new  EstadoPagoAuto();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoPagoAuto.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =estadopagoautoDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		estadopagoauto = new  EstadoPagoAuto();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=estadopagoautoDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		estadopagoauto = new  EstadoPagoAuto();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoPagoAuto.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =estadopagoautoDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		estadopagoauto = new  EstadoPagoAuto();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=estadopagoautoDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		estadopagoautos = new  ArrayList<EstadoPagoAuto>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoPagoAuto.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			EstadoPagoAutoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadopagoautos=estadopagoautoDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarEstadoPagoAuto(estadopagoautos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoPagoAutoConstantesFunciones.refrescarForeignKeysDescripcionesEstadoPagoAuto(this.estadopagoautos);
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
		estadopagoautos = new  ArrayList<EstadoPagoAuto>();
		  		  
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
		estadopagoautos = new  ArrayList<EstadoPagoAuto>();
		  		  
        try {			
			EstadoPagoAutoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadopagoautos=estadopagoautoDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarEstadoPagoAuto(estadopagoautos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoPagoAutoConstantesFunciones.refrescarForeignKeysDescripcionesEstadoPagoAuto(this.estadopagoautos);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		estadopagoautos = new  ArrayList<EstadoPagoAuto>();
		  		  
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
		estadopagoautos = new  ArrayList<EstadoPagoAuto>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoPagoAuto.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			EstadoPagoAutoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadopagoautos=estadopagoautoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarEstadoPagoAuto(estadopagoautos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoPagoAutoConstantesFunciones.refrescarForeignKeysDescripcionesEstadoPagoAuto(this.estadopagoautos);
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
		estadopagoautos = new  ArrayList<EstadoPagoAuto>();
		  		  
        try {
			EstadoPagoAutoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadopagoautos=estadopagoautoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarEstadoPagoAuto(estadopagoautos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoPagoAutoConstantesFunciones.refrescarForeignKeysDescripcionesEstadoPagoAuto(this.estadopagoautos);
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
		estadopagoautos = new  ArrayList<EstadoPagoAuto>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoPagoAuto.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EstadoPagoAutoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadopagoautos=estadopagoautoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarEstadoPagoAuto(estadopagoautos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoPagoAutoConstantesFunciones.refrescarForeignKeysDescripcionesEstadoPagoAuto(this.estadopagoautos);
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
		estadopagoautos = new  ArrayList<EstadoPagoAuto>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EstadoPagoAutoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadopagoautos=estadopagoautoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarEstadoPagoAuto(estadopagoautos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoPagoAutoConstantesFunciones.refrescarForeignKeysDescripcionesEstadoPagoAuto(this.estadopagoautos);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		estadopagoauto = new  EstadoPagoAuto();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoPagoAuto.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EstadoPagoAutoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadopagoauto=estadopagoautoDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarEstadoPagoAuto(estadopagoauto);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoPagoAutoConstantesFunciones.refrescarForeignKeysDescripcionesEstadoPagoAuto(this.estadopagoauto);
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
		estadopagoauto = new  EstadoPagoAuto();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EstadoPagoAutoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadopagoauto=estadopagoautoDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarEstadoPagoAuto(estadopagoauto);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoPagoAutoConstantesFunciones.refrescarForeignKeysDescripcionesEstadoPagoAuto(this.estadopagoauto);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	
	
	public void getTodosEstadoPagoAutosWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		estadopagoautos = new  ArrayList<EstadoPagoAuto>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoPagoAuto.class.getSimpleName()+"-getTodosEstadoPagoAutosWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EstadoPagoAutoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadopagoautos=estadopagoautoDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarEstadoPagoAuto(estadopagoautos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoPagoAutoConstantesFunciones.refrescarForeignKeysDescripcionesEstadoPagoAuto(this.estadopagoautos);
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
	
	public  void  getTodosEstadoPagoAutos(String sFinalQuery,Pagination pagination)throws Exception {
		estadopagoautos = new  ArrayList<EstadoPagoAuto>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EstadoPagoAutoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadopagoautos=estadopagoautoDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarEstadoPagoAuto(estadopagoautos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoPagoAutoConstantesFunciones.refrescarForeignKeysDescripcionesEstadoPagoAuto(this.estadopagoautos);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarEstadoPagoAuto(EstadoPagoAuto estadopagoauto) throws Exception {
		Boolean estaValidado=false;
		
		if(estadopagoauto.getIsNew() || estadopagoauto.getIsChanged()) { 
			this.invalidValues = estadopagoautoValidator.getInvalidValues(estadopagoauto);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(estadopagoauto);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarEstadoPagoAuto(List<EstadoPagoAuto> EstadoPagoAutos) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(EstadoPagoAuto estadopagoautoLocal:estadopagoautos) {				
			estaValidadoObjeto=this.validarGuardarEstadoPagoAuto(estadopagoautoLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarEstadoPagoAuto(List<EstadoPagoAuto> EstadoPagoAutos) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarEstadoPagoAuto(estadopagoautos)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarEstadoPagoAuto(EstadoPagoAuto EstadoPagoAuto) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarEstadoPagoAuto(estadopagoauto)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(EstadoPagoAuto estadopagoauto) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+estadopagoauto.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=EstadoPagoAutoConstantesFunciones.getEstadoPagoAutoLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"estadopagoauto","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(EstadoPagoAutoConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(EstadoPagoAutoConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveEstadoPagoAutoWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoPagoAuto.class.getSimpleName()+"-saveEstadoPagoAutoWithConnection");connexion.begin();			
			
			//EstadoPagoAutoLogicAdditional.checkEstadoPagoAutoToSave(this.estadopagoauto,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//EstadoPagoAutoLogicAdditional.updateEstadoPagoAutoToSave(this.estadopagoauto,this.arrDatoGeneral);
			
			EstadoPagoAutoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.estadopagoauto,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowEstadoPagoAuto();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarEstadoPagoAuto(this.estadopagoauto)) {
				EstadoPagoAutoDataAccess.save(this.estadopagoauto, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.estadopagoauto,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			//EstadoPagoAutoLogicAdditional.checkEstadoPagoAutoToSaveAfter(this.estadopagoauto,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowEstadoPagoAuto();
			
			connexion.commit();			
			
			if(this.estadopagoauto.getIsDeleted()) {
				this.estadopagoauto=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveEstadoPagoAuto()throws Exception {	
		try {	
			
			//EstadoPagoAutoLogicAdditional.checkEstadoPagoAutoToSave(this.estadopagoauto,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//EstadoPagoAutoLogicAdditional.updateEstadoPagoAutoToSave(this.estadopagoauto,this.arrDatoGeneral);
			
			EstadoPagoAutoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.estadopagoauto,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarEstadoPagoAuto(this.estadopagoauto)) {			
				EstadoPagoAutoDataAccess.save(this.estadopagoauto, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.estadopagoauto,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			//EstadoPagoAutoLogicAdditional.checkEstadoPagoAutoToSaveAfter(this.estadopagoauto,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.estadopagoauto.getIsDeleted()) {
				this.estadopagoauto=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveEstadoPagoAutosWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoPagoAuto.class.getSimpleName()+"-saveEstadoPagoAutosWithConnection");connexion.begin();			
			
			//EstadoPagoAutoLogicAdditional.checkEstadoPagoAutoToSaves(estadopagoautos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowEstadoPagoAutos();
			
			Boolean validadoTodosEstadoPagoAuto=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(EstadoPagoAuto estadopagoautoLocal:estadopagoautos) {		
				if(estadopagoautoLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				//EstadoPagoAutoLogicAdditional.updateEstadoPagoAutoToSave(estadopagoautoLocal,this.arrDatoGeneral);
	        	
				EstadoPagoAutoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),estadopagoautoLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarEstadoPagoAuto(estadopagoautoLocal)) {
					EstadoPagoAutoDataAccess.save(estadopagoautoLocal, connexion);				
				} else {
					validadoTodosEstadoPagoAuto=false;
				}
			}
			
			if(!validadoTodosEstadoPagoAuto) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			//EstadoPagoAutoLogicAdditional.checkEstadoPagoAutoToSavesAfter(estadopagoautos,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowEstadoPagoAutos();
			
			connexion.commit();		
			
			this.quitarEstadoPagoAutosEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveEstadoPagoAutos()throws Exception {				
		 try {	
			//EstadoPagoAutoLogicAdditional.checkEstadoPagoAutoToSaves(estadopagoautos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosEstadoPagoAuto=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(EstadoPagoAuto estadopagoautoLocal:estadopagoautos) {				
				if(estadopagoautoLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				//EstadoPagoAutoLogicAdditional.updateEstadoPagoAutoToSave(estadopagoautoLocal,this.arrDatoGeneral);
	        	
				EstadoPagoAutoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),estadopagoautoLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarEstadoPagoAuto(estadopagoautoLocal)) {				
					EstadoPagoAutoDataAccess.save(estadopagoautoLocal, connexion);				
				} else {
					validadoTodosEstadoPagoAuto=false;
				}
			}
			
			if(!validadoTodosEstadoPagoAuto) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			//EstadoPagoAutoLogicAdditional.checkEstadoPagoAutoToSavesAfter(estadopagoautos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarEstadoPagoAutosEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public EstadoPagoAutoParameterReturnGeneral procesarAccionEstadoPagoAutos(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<EstadoPagoAuto> estadopagoautos,EstadoPagoAutoParameterReturnGeneral estadopagoautoParameterGeneral)throws Exception {
		 try {	
			EstadoPagoAutoParameterReturnGeneral estadopagoautoReturnGeneral=new EstadoPagoAutoParameterReturnGeneral();
	
			
			return estadopagoautoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public EstadoPagoAutoParameterReturnGeneral procesarAccionEstadoPagoAutosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<EstadoPagoAuto> estadopagoautos,EstadoPagoAutoParameterReturnGeneral estadopagoautoParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoPagoAuto.class.getSimpleName()+"-procesarAccionEstadoPagoAutosWithConnection");connexion.begin();			
			
			EstadoPagoAutoParameterReturnGeneral estadopagoautoReturnGeneral=new EstadoPagoAutoParameterReturnGeneral();
	
			
			this.connexion.commit();
			
			return estadopagoautoReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public EstadoPagoAutoParameterReturnGeneral procesarEventosEstadoPagoAutos(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<EstadoPagoAuto> estadopagoautos,EstadoPagoAuto estadopagoauto,EstadoPagoAutoParameterReturnGeneral estadopagoautoParameterGeneral,Boolean isEsNuevoEstadoPagoAuto,ArrayList<Classe> clases)throws Exception {
		 try {	
			EstadoPagoAutoParameterReturnGeneral estadopagoautoReturnGeneral=new EstadoPagoAutoParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				estadopagoautoReturnGeneral.setConRecargarPropiedades(true);
			}
			
			
			return estadopagoautoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public EstadoPagoAutoParameterReturnGeneral procesarEventosEstadoPagoAutosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<EstadoPagoAuto> estadopagoautos,EstadoPagoAuto estadopagoauto,EstadoPagoAutoParameterReturnGeneral estadopagoautoParameterGeneral,Boolean isEsNuevoEstadoPagoAuto,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoPagoAuto.class.getSimpleName()+"-procesarEventosEstadoPagoAutosWithConnection");connexion.begin();			
			
			EstadoPagoAutoParameterReturnGeneral estadopagoautoReturnGeneral=new EstadoPagoAutoParameterReturnGeneral();
	
			estadopagoautoReturnGeneral.setEstadoPagoAuto(estadopagoauto);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				estadopagoautoReturnGeneral.setConRecargarPropiedades(true);
			}
			
			
			this.connexion.commit();
			
			return estadopagoautoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public EstadoPagoAutoParameterReturnGeneral procesarImportacionEstadoPagoAutosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,EstadoPagoAutoParameterReturnGeneral estadopagoautoParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoPagoAuto.class.getSimpleName()+"-procesarImportacionEstadoPagoAutosWithConnection");connexion.begin();			
			
			EstadoPagoAutoParameterReturnGeneral estadopagoautoReturnGeneral=new EstadoPagoAutoParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.estadopagoautos=new ArrayList<EstadoPagoAuto>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.estadopagoauto=new EstadoPagoAuto();
				
				
				if(conColumnasBase) {this.estadopagoauto.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.estadopagoauto.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.estadopagoauto.setnombre(arrColumnas[iColumn++]);
				
				this.estadopagoautos.add(this.estadopagoauto);
			}
			
			this.saveEstadoPagoAutos();
			
			this.connexion.commit();
			
			estadopagoautoReturnGeneral.setConRetornoEstaProcesado(true);
			estadopagoautoReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return estadopagoautoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarEstadoPagoAutosEliminados() throws Exception {				
		
		List<EstadoPagoAuto> estadopagoautosAux= new ArrayList<EstadoPagoAuto>();
		
		for(EstadoPagoAuto estadopagoauto:estadopagoautos) {
			if(!estadopagoauto.getIsDeleted()) {
				estadopagoautosAux.add(estadopagoauto);
			}
		}
		
		estadopagoautos=estadopagoautosAux;
	}
	
	public void quitarEstadoPagoAutosNulos() throws Exception {				
		
		List<EstadoPagoAuto> estadopagoautosAux= new ArrayList<EstadoPagoAuto>();
		
		for(EstadoPagoAuto estadopagoauto : this.estadopagoautos) {
			if(estadopagoauto==null) {
				estadopagoautosAux.add(estadopagoauto);
			}
		}
		
		//this.estadopagoautos=estadopagoautosAux;
		
		this.estadopagoautos.removeAll(estadopagoautosAux);
	}
	
	public void getSetVersionRowEstadoPagoAutoWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(estadopagoauto.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((estadopagoauto.getIsDeleted() || (estadopagoauto.getIsChanged()&&!estadopagoauto.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=estadopagoautoDataAccess.getSetVersionRowEstadoPagoAuto(connexion,estadopagoauto.getId());
				
				if(!estadopagoauto.getVersionRow().equals(timestamp)) {	
					estadopagoauto.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				estadopagoauto.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowEstadoPagoAuto()throws Exception {	
		
		if(estadopagoauto.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((estadopagoauto.getIsDeleted() || (estadopagoauto.getIsChanged()&&!estadopagoauto.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=estadopagoautoDataAccess.getSetVersionRowEstadoPagoAuto(connexion,estadopagoauto.getId());
			
			try {							
				if(!estadopagoauto.getVersionRow().equals(timestamp)) {	
					estadopagoauto.setVersionRow(timestamp);
				}
				
				estadopagoauto.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowEstadoPagoAutosWithConnection()throws Exception {	
		if(estadopagoautos!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(EstadoPagoAuto estadopagoautoAux:estadopagoautos) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(estadopagoautoAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(estadopagoautoAux.getIsDeleted() || (estadopagoautoAux.getIsChanged()&&!estadopagoautoAux.getIsNew())) {
						
						timestamp=estadopagoautoDataAccess.getSetVersionRowEstadoPagoAuto(connexion,estadopagoautoAux.getId());
						
						if(!estadopagoauto.getVersionRow().equals(timestamp)) {	
							estadopagoautoAux.setVersionRow(timestamp);
						}
								
						estadopagoautoAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowEstadoPagoAutos()throws Exception {	
		if(estadopagoautos!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(EstadoPagoAuto estadopagoautoAux:estadopagoautos) {
					if(estadopagoautoAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(estadopagoautoAux.getIsDeleted() || (estadopagoautoAux.getIsChanged()&&!estadopagoautoAux.getIsNew())) {
						
						timestamp=estadopagoautoDataAccess.getSetVersionRowEstadoPagoAuto(connexion,estadopagoautoAux.getId());
						
						if(!estadopagoautoAux.getVersionRow().equals(timestamp)) {	
							estadopagoautoAux.setVersionRow(timestamp);
						}
						
													
						estadopagoautoAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	
	public void cargarRelacionesLoteForeignKeyEstadoPagoAutoWithConnection() throws Exception {
		ArrayList<Classe> classes=new ArrayList<Classe>();		
		
		
			PagoAutoLogic pagoautoLogic=new PagoAutoLogic();
		
		try {
			
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoPagoAuto.class.getSimpleName()+"-cargarRelacionesLoteForeignKeyEstadoPagoAutoWithConnection");connexion.begin();
			
			
			classes.add(new Classe(PagoAuto.class));
											
			

			pagoautoLogic.setConnexion(this.getConnexion());
			pagoautoLogic.setDatosCliente(this.datosCliente);
			pagoautoLogic.setIsConRefrescarForeignKeys(true);
			
			this.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
			
			for(EstadoPagoAuto estadopagoauto:this.estadopagoautos) {
				

				classes=new ArrayList<Classe>();
				classes=PagoAutoConstantesFunciones.getClassesForeignKeysOfPagoAuto(new ArrayList<Classe>(),DeepLoadType.NONE);

				pagoautoLogic.setPagoAutos(estadopagoauto.pagoautos);
				pagoautoLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
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
	
	public void deepLoad(EstadoPagoAuto estadopagoauto,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			//EstadoPagoAutoLogicAdditional.updateEstadoPagoAutoToGet(estadopagoauto,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		estadopagoauto.setPagoAutos(estadopagoautoDataAccess.getPagoAutos(connexion,estadopagoauto));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(PagoAuto.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				estadopagoauto.setPagoAutos(estadopagoautoDataAccess.getPagoAutos(connexion,estadopagoauto));

				if(this.isConDeep) {
					PagoAutoLogic pagoautoLogic= new PagoAutoLogic(this.connexion);
					pagoautoLogic.setPagoAutos(estadopagoauto.getPagoAutos());
					ArrayList<Classe> classesLocal=PagoAutoConstantesFunciones.getClassesForeignKeysOfPagoAuto(new ArrayList<Classe>(),DeepLoadType.NONE);
					pagoautoLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					PagoAutoConstantesFunciones.refrescarForeignKeysDescripcionesPagoAuto(pagoautoLogic.getPagoAutos());
					estadopagoauto.setPagoAutos(pagoautoLogic.getPagoAutos());
				}

				continue;
			}
		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {


		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(PagoAuto.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(PagoAuto.class));
			estadopagoauto.setPagoAutos(estadopagoautoDataAccess.getPagoAutos(connexion,estadopagoauto));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {


		estadopagoauto.setPagoAutos(estadopagoautoDataAccess.getPagoAutos(connexion,estadopagoauto));

		for(PagoAuto pagoauto:estadopagoauto.getPagoAutos()) {
			PagoAutoLogic pagoautoLogic= new PagoAutoLogic(connexion);
			pagoautoLogic.deepLoad(pagoauto,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(PagoAuto.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				estadopagoauto.setPagoAutos(estadopagoautoDataAccess.getPagoAutos(connexion,estadopagoauto));

				for(PagoAuto pagoauto:estadopagoauto.getPagoAutos()) {
					PagoAutoLogic pagoautoLogic= new PagoAutoLogic(connexion);
					pagoautoLogic.deepLoad(pagoauto,isDeep,deepLoadType,clases);
				}
				continue;
			}

		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {


		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(PagoAuto.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(PagoAuto.class));
			estadopagoauto.setPagoAutos(estadopagoautoDataAccess.getPagoAutos(connexion,estadopagoauto));

			for(PagoAuto pagoauto:estadopagoauto.getPagoAutos()) {
				PagoAutoLogic pagoautoLogic= new PagoAutoLogic(connexion);
				pagoautoLogic.deepLoad(pagoauto,isDeep,deepLoadType,clases);
			}
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(EstadoPagoAuto estadopagoauto,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}	
	}
	
	public void deepLoadWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(EstadoPagoAuto.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(estadopagoauto,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				EstadoPagoAutoConstantesFunciones.refrescarForeignKeysDescripcionesEstadoPagoAuto(estadopagoauto);
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
			this.deepLoad(this.estadopagoauto,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				EstadoPagoAutoConstantesFunciones.refrescarForeignKeysDescripcionesEstadoPagoAuto(this.estadopagoauto);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(EstadoPagoAuto.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(estadopagoautos!=null) {
				for(EstadoPagoAuto estadopagoauto:estadopagoautos) {
					this.deepLoad(estadopagoauto,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					EstadoPagoAutoConstantesFunciones.refrescarForeignKeysDescripcionesEstadoPagoAuto(estadopagoautos);
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
			if(estadopagoautos!=null) {
				for(EstadoPagoAuto estadopagoauto:estadopagoautos) {
					this.deepLoad(estadopagoauto,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					EstadoPagoAutoConstantesFunciones.refrescarForeignKeysDescripcionesEstadoPagoAuto(estadopagoautos);
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
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,String sProcesoBusqueda,String sDetalleProcesoBusqueda,QueryWhereSelectParameters queryWhereSelectParameters,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(EstadoPagoAutoConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,EstadoPagoAutoDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,EstadoPagoAuto estadopagoauto,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(EstadoPagoAutoConstantesFunciones.ISCONAUDITORIA) {
				if(estadopagoauto.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,EstadoPagoAutoDataAccess.TABLENAME, estadopagoauto.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(EstadoPagoAutoConstantesFunciones.ISCONAUDITORIADETALLE) {
						////EstadoPagoAutoLogic.registrarAuditoriaDetallesEstadoPagoAuto(connexion,estadopagoauto,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(estadopagoauto.getIsDeleted()) {
					/*if(!estadopagoauto.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,EstadoPagoAutoDataAccess.TABLENAME, estadopagoauto.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////EstadoPagoAutoLogic.registrarAuditoriaDetallesEstadoPagoAuto(connexion,estadopagoauto,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,EstadoPagoAutoDataAccess.TABLENAME, estadopagoauto.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(estadopagoauto.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,EstadoPagoAutoDataAccess.TABLENAME, estadopagoauto.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(EstadoPagoAutoConstantesFunciones.ISCONAUDITORIADETALLE) {
						////EstadoPagoAutoLogic.registrarAuditoriaDetallesEstadoPagoAuto(connexion,estadopagoauto,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesEstadoPagoAuto(Connexion connexion,EstadoPagoAuto estadopagoauto)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(estadopagoauto.getIsNew()||!estadopagoauto.getnombre().equals(estadopagoauto.getEstadoPagoAutoOriginal().getnombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(estadopagoauto.getEstadoPagoAutoOriginal().getnombre()!=null)
				{
					strValorActual=estadopagoauto.getEstadoPagoAutoOriginal().getnombre();
				}
				if(estadopagoauto.getnombre()!=null)
				{
					strValorNuevo=estadopagoauto.getnombre() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),EstadoPagoAutoConstantesFunciones.NOMBRE,strValorActual,strValorNuevo);
			}	
	}
	
	
//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfEstadoPagoAuto(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=EstadoPagoAutoConstantesFunciones.getClassesForeignKeysOfEstadoPagoAuto(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfEstadoPagoAuto(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=EstadoPagoAutoConstantesFunciones.getClassesRelationshipsOfEstadoPagoAuto(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
}

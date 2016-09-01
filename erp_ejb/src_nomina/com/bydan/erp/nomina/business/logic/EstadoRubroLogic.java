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
import com.bydan.erp.nomina.util.EstadoRubroConstantesFunciones;
import com.bydan.erp.nomina.util.EstadoRubroParameterReturnGeneral;
//import com.bydan.erp.nomina.util.EstadoRubroParameterGeneral;
import com.bydan.erp.nomina.business.entity.EstadoRubro;
import com.bydan.erp.nomina.business.logic.EstadoRubroLogicAdditional;
import com.bydan.erp.nomina.business.dataaccess.*;
import com.bydan.erp.nomina.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;
















@SuppressWarnings("unused")
public class EstadoRubroLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(EstadoRubroLogic.class);
	
	protected EstadoRubroDataAccess estadorubroDataAccess; 	
	protected EstadoRubro estadorubro;
	protected List<EstadoRubro> estadorubros;
	protected Object estadorubroObject;	
	protected List<Object> estadorubrosObject;
	
	public static ClassValidator<EstadoRubro> estadorubroValidator = new ClassValidator<EstadoRubro>(EstadoRubro.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected EstadoRubroLogicAdditional estadorubroLogicAdditional=null;
	
	public EstadoRubroLogicAdditional getEstadoRubroLogicAdditional() {
		return this.estadorubroLogicAdditional;
	}
	
	public void setEstadoRubroLogicAdditional(EstadoRubroLogicAdditional estadorubroLogicAdditional) {
		try {
			this.estadorubroLogicAdditional=estadorubroLogicAdditional;
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
	
	
	
	
	public  EstadoRubroLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.estadorubroDataAccess = new EstadoRubroDataAccess();
			
			this.estadorubros= new ArrayList<EstadoRubro>();
			this.estadorubro= new EstadoRubro();
			
			this.estadorubroObject=new Object();
			this.estadorubrosObject=new ArrayList<Object>();
				
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
			
			this.estadorubroDataAccess.setConnexionType(this.connexionType);
			this.estadorubroDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  EstadoRubroLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.estadorubroDataAccess = new EstadoRubroDataAccess();
			this.estadorubros= new ArrayList<EstadoRubro>();
			this.estadorubro= new EstadoRubro();
			this.estadorubroObject=new Object();
			this.estadorubrosObject=new ArrayList<Object>();
			
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
			
			this.estadorubroDataAccess.setConnexionType(this.connexionType);
			this.estadorubroDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public EstadoRubro getEstadoRubro() throws Exception {	
		EstadoRubroLogicAdditional.checkEstadoRubroToGet(estadorubro,this.datosCliente,this.arrDatoGeneral);
		EstadoRubroLogicAdditional.updateEstadoRubroToGet(estadorubro,this.arrDatoGeneral);
		
		return estadorubro;
	}
		
	public void setEstadoRubro(EstadoRubro newEstadoRubro) {
		this.estadorubro = newEstadoRubro;
	}
	
	public EstadoRubroDataAccess getEstadoRubroDataAccess() {
		return estadorubroDataAccess;
	}
	
	public void setEstadoRubroDataAccess(EstadoRubroDataAccess newestadorubroDataAccess) {
		this.estadorubroDataAccess = newestadorubroDataAccess;
	}
	
	public List<EstadoRubro> getEstadoRubros() throws Exception {		
		this.quitarEstadoRubrosNulos();
		
		EstadoRubroLogicAdditional.checkEstadoRubroToGets(estadorubros,this.datosCliente,this.arrDatoGeneral);
		
		for (EstadoRubro estadorubroLocal: estadorubros ) {
			EstadoRubroLogicAdditional.updateEstadoRubroToGet(estadorubroLocal,this.arrDatoGeneral);
		}
		
		return estadorubros;
	}
	
	public void setEstadoRubros(List<EstadoRubro> newEstadoRubros) {
		this.estadorubros = newEstadoRubros;
	}
	
	public Object getEstadoRubroObject() {	
		this.estadorubroObject=this.estadorubroDataAccess.getEntityObject();
		return this.estadorubroObject;
	}
		
	public void setEstadoRubroObject(Object newEstadoRubroObject) {
		this.estadorubroObject = newEstadoRubroObject;
	}
	
	public List<Object> getEstadoRubrosObject() {		
		this.estadorubrosObject=this.estadorubroDataAccess.getEntitiesObject();
		return this.estadorubrosObject;
	}
		
	public void setEstadoRubrosObject(List<Object> newEstadoRubrosObject) {
		this.estadorubrosObject = newEstadoRubrosObject;
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
		
		if(this.estadorubroDataAccess!=null) {
			this.estadorubroDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoRubro.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			estadorubroDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			estadorubroDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		estadorubro = new  EstadoRubro();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoRubro.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			estadorubro=estadorubroDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.estadorubro,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				EstadoRubroConstantesFunciones.refrescarForeignKeysDescripcionesEstadoRubro(this.estadorubro);
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
		estadorubro = new  EstadoRubro();
		  		  
        try {
			
			estadorubro=estadorubroDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.estadorubro,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				EstadoRubroConstantesFunciones.refrescarForeignKeysDescripcionesEstadoRubro(this.estadorubro);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		estadorubro = new  EstadoRubro();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoRubro.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			estadorubro=estadorubroDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.estadorubro,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				EstadoRubroConstantesFunciones.refrescarForeignKeysDescripcionesEstadoRubro(this.estadorubro);
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
		estadorubro = new  EstadoRubro();
		  		  
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
		estadorubro = new  EstadoRubro();
		  		  
        try {
			
			estadorubro=estadorubroDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.estadorubro,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				EstadoRubroConstantesFunciones.refrescarForeignKeysDescripcionesEstadoRubro(this.estadorubro);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		estadorubro = new  EstadoRubro();
		  		  
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
		estadorubro = new  EstadoRubro();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoRubro.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =estadorubroDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		estadorubro = new  EstadoRubro();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=estadorubroDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		estadorubro = new  EstadoRubro();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoRubro.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =estadorubroDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		estadorubro = new  EstadoRubro();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=estadorubroDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		estadorubro = new  EstadoRubro();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoRubro.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =estadorubroDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		estadorubro = new  EstadoRubro();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=estadorubroDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		estadorubros = new  ArrayList<EstadoRubro>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoRubro.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			EstadoRubroLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadorubros=estadorubroDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarEstadoRubro(estadorubros);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoRubroConstantesFunciones.refrescarForeignKeysDescripcionesEstadoRubro(this.estadorubros);
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
		estadorubros = new  ArrayList<EstadoRubro>();
		  		  
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
		estadorubros = new  ArrayList<EstadoRubro>();
		  		  
        try {			
			EstadoRubroLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadorubros=estadorubroDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarEstadoRubro(estadorubros);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoRubroConstantesFunciones.refrescarForeignKeysDescripcionesEstadoRubro(this.estadorubros);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		estadorubros = new  ArrayList<EstadoRubro>();
		  		  
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
		estadorubros = new  ArrayList<EstadoRubro>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoRubro.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			EstadoRubroLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadorubros=estadorubroDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarEstadoRubro(estadorubros);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoRubroConstantesFunciones.refrescarForeignKeysDescripcionesEstadoRubro(this.estadorubros);
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
		estadorubros = new  ArrayList<EstadoRubro>();
		  		  
        try {
			EstadoRubroLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadorubros=estadorubroDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarEstadoRubro(estadorubros);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoRubroConstantesFunciones.refrescarForeignKeysDescripcionesEstadoRubro(this.estadorubros);
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
		estadorubros = new  ArrayList<EstadoRubro>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoRubro.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EstadoRubroLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadorubros=estadorubroDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarEstadoRubro(estadorubros);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoRubroConstantesFunciones.refrescarForeignKeysDescripcionesEstadoRubro(this.estadorubros);
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
		estadorubros = new  ArrayList<EstadoRubro>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EstadoRubroLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadorubros=estadorubroDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarEstadoRubro(estadorubros);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoRubroConstantesFunciones.refrescarForeignKeysDescripcionesEstadoRubro(this.estadorubros);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		estadorubro = new  EstadoRubro();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoRubro.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EstadoRubroLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadorubro=estadorubroDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarEstadoRubro(estadorubro);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoRubroConstantesFunciones.refrescarForeignKeysDescripcionesEstadoRubro(this.estadorubro);
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
		estadorubro = new  EstadoRubro();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EstadoRubroLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadorubro=estadorubroDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarEstadoRubro(estadorubro);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoRubroConstantesFunciones.refrescarForeignKeysDescripcionesEstadoRubro(this.estadorubro);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		estadorubros = new  ArrayList<EstadoRubro>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoRubro.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			EstadoRubroLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadorubros=estadorubroDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarEstadoRubro(estadorubros);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoRubroConstantesFunciones.refrescarForeignKeysDescripcionesEstadoRubro(this.estadorubros);
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
		estadorubros = new  ArrayList<EstadoRubro>();
		  		  
        try {
			EstadoRubroLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadorubros=estadorubroDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarEstadoRubro(estadorubros);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoRubroConstantesFunciones.refrescarForeignKeysDescripcionesEstadoRubro(this.estadorubros);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosEstadoRubrosWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		estadorubros = new  ArrayList<EstadoRubro>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoRubro.class.getSimpleName()+"-getTodosEstadoRubrosWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EstadoRubroLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadorubros=estadorubroDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarEstadoRubro(estadorubros);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoRubroConstantesFunciones.refrescarForeignKeysDescripcionesEstadoRubro(this.estadorubros);
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
	
	public  void  getTodosEstadoRubros(String sFinalQuery,Pagination pagination)throws Exception {
		estadorubros = new  ArrayList<EstadoRubro>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EstadoRubroLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadorubros=estadorubroDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarEstadoRubro(estadorubros);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoRubroConstantesFunciones.refrescarForeignKeysDescripcionesEstadoRubro(this.estadorubros);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarEstadoRubro(EstadoRubro estadorubro) throws Exception {
		Boolean estaValidado=false;
		
		if(estadorubro.getIsNew() || estadorubro.getIsChanged()) { 
			this.invalidValues = estadorubroValidator.getInvalidValues(estadorubro);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(estadorubro);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarEstadoRubro(List<EstadoRubro> EstadoRubros) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(EstadoRubro estadorubroLocal:estadorubros) {				
			estaValidadoObjeto=this.validarGuardarEstadoRubro(estadorubroLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarEstadoRubro(List<EstadoRubro> EstadoRubros) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarEstadoRubro(estadorubros)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarEstadoRubro(EstadoRubro EstadoRubro) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarEstadoRubro(estadorubro)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(EstadoRubro estadorubro) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+estadorubro.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=EstadoRubroConstantesFunciones.getEstadoRubroLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"estadorubro","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(EstadoRubroConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(EstadoRubroConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveEstadoRubroWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoRubro.class.getSimpleName()+"-saveEstadoRubroWithConnection");connexion.begin();			
			
			EstadoRubroLogicAdditional.checkEstadoRubroToSave(this.estadorubro,this.datosCliente,connexion,this.arrDatoGeneral);
			
			EstadoRubroLogicAdditional.updateEstadoRubroToSave(this.estadorubro,this.arrDatoGeneral);
			
			EstadoRubroLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.estadorubro,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowEstadoRubro();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarEstadoRubro(this.estadorubro)) {
				EstadoRubroDataAccess.save(this.estadorubro, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.estadorubro,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			EstadoRubroLogicAdditional.checkEstadoRubroToSaveAfter(this.estadorubro,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowEstadoRubro();
			
			connexion.commit();			
			
			if(this.estadorubro.getIsDeleted()) {
				this.estadorubro=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveEstadoRubro()throws Exception {	
		try {	
			
			EstadoRubroLogicAdditional.checkEstadoRubroToSave(this.estadorubro,this.datosCliente,connexion,this.arrDatoGeneral);
			
			EstadoRubroLogicAdditional.updateEstadoRubroToSave(this.estadorubro,this.arrDatoGeneral);
			
			EstadoRubroLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.estadorubro,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarEstadoRubro(this.estadorubro)) {			
				EstadoRubroDataAccess.save(this.estadorubro, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.estadorubro,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			EstadoRubroLogicAdditional.checkEstadoRubroToSaveAfter(this.estadorubro,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.estadorubro.getIsDeleted()) {
				this.estadorubro=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveEstadoRubrosWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoRubro.class.getSimpleName()+"-saveEstadoRubrosWithConnection");connexion.begin();			
			
			EstadoRubroLogicAdditional.checkEstadoRubroToSaves(estadorubros,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowEstadoRubros();
			
			Boolean validadoTodosEstadoRubro=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(EstadoRubro estadorubroLocal:estadorubros) {		
				if(estadorubroLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				EstadoRubroLogicAdditional.updateEstadoRubroToSave(estadorubroLocal,this.arrDatoGeneral);
	        	
				EstadoRubroLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),estadorubroLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarEstadoRubro(estadorubroLocal)) {
					EstadoRubroDataAccess.save(estadorubroLocal, connexion);				
				} else {
					validadoTodosEstadoRubro=false;
				}
			}
			
			if(!validadoTodosEstadoRubro) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			EstadoRubroLogicAdditional.checkEstadoRubroToSavesAfter(estadorubros,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowEstadoRubros();
			
			connexion.commit();		
			
			this.quitarEstadoRubrosEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveEstadoRubros()throws Exception {				
		 try {	
			EstadoRubroLogicAdditional.checkEstadoRubroToSaves(estadorubros,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosEstadoRubro=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(EstadoRubro estadorubroLocal:estadorubros) {				
				if(estadorubroLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				EstadoRubroLogicAdditional.updateEstadoRubroToSave(estadorubroLocal,this.arrDatoGeneral);
	        	
				EstadoRubroLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),estadorubroLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarEstadoRubro(estadorubroLocal)) {				
					EstadoRubroDataAccess.save(estadorubroLocal, connexion);				
				} else {
					validadoTodosEstadoRubro=false;
				}
			}
			
			if(!validadoTodosEstadoRubro) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			EstadoRubroLogicAdditional.checkEstadoRubroToSavesAfter(estadorubros,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarEstadoRubrosEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public EstadoRubroParameterReturnGeneral procesarAccionEstadoRubros(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<EstadoRubro> estadorubros,EstadoRubroParameterReturnGeneral estadorubroParameterGeneral)throws Exception {
		 try {	
			EstadoRubroParameterReturnGeneral estadorubroReturnGeneral=new EstadoRubroParameterReturnGeneral();
	
			EstadoRubroLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,estadorubros,estadorubroParameterGeneral,estadorubroReturnGeneral);
			
			return estadorubroReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public EstadoRubroParameterReturnGeneral procesarAccionEstadoRubrosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<EstadoRubro> estadorubros,EstadoRubroParameterReturnGeneral estadorubroParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoRubro.class.getSimpleName()+"-procesarAccionEstadoRubrosWithConnection");connexion.begin();			
			
			EstadoRubroParameterReturnGeneral estadorubroReturnGeneral=new EstadoRubroParameterReturnGeneral();
	
			EstadoRubroLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,estadorubros,estadorubroParameterGeneral,estadorubroReturnGeneral);
			
			this.connexion.commit();
			
			return estadorubroReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public EstadoRubroParameterReturnGeneral procesarEventosEstadoRubros(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<EstadoRubro> estadorubros,EstadoRubro estadorubro,EstadoRubroParameterReturnGeneral estadorubroParameterGeneral,Boolean isEsNuevoEstadoRubro,ArrayList<Classe> clases)throws Exception {
		 try {	
			EstadoRubroParameterReturnGeneral estadorubroReturnGeneral=new EstadoRubroParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				estadorubroReturnGeneral.setConRecargarPropiedades(true);
			}
			
			EstadoRubroLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,estadorubros,estadorubro,estadorubroParameterGeneral,estadorubroReturnGeneral,isEsNuevoEstadoRubro,clases);
			
			return estadorubroReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public EstadoRubroParameterReturnGeneral procesarEventosEstadoRubrosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<EstadoRubro> estadorubros,EstadoRubro estadorubro,EstadoRubroParameterReturnGeneral estadorubroParameterGeneral,Boolean isEsNuevoEstadoRubro,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoRubro.class.getSimpleName()+"-procesarEventosEstadoRubrosWithConnection");connexion.begin();			
			
			EstadoRubroParameterReturnGeneral estadorubroReturnGeneral=new EstadoRubroParameterReturnGeneral();
	
			estadorubroReturnGeneral.setEstadoRubro(estadorubro);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				estadorubroReturnGeneral.setConRecargarPropiedades(true);
			}
			
			EstadoRubroLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,estadorubros,estadorubro,estadorubroParameterGeneral,estadorubroReturnGeneral,isEsNuevoEstadoRubro,clases);
			
			this.connexion.commit();
			
			return estadorubroReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public EstadoRubroParameterReturnGeneral procesarImportacionEstadoRubrosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,EstadoRubroParameterReturnGeneral estadorubroParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoRubro.class.getSimpleName()+"-procesarImportacionEstadoRubrosWithConnection");connexion.begin();			
			
			EstadoRubroParameterReturnGeneral estadorubroReturnGeneral=new EstadoRubroParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.estadorubros=new ArrayList<EstadoRubro>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.estadorubro=new EstadoRubro();
				
				
				if(conColumnasBase) {this.estadorubro.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.estadorubro.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.estadorubro.setcodigo(arrColumnas[iColumn++]);
				this.estadorubro.setnombre(arrColumnas[iColumn++]);
				
				this.estadorubros.add(this.estadorubro);
			}
			
			this.saveEstadoRubros();
			
			this.connexion.commit();
			
			estadorubroReturnGeneral.setConRetornoEstaProcesado(true);
			estadorubroReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return estadorubroReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarEstadoRubrosEliminados() throws Exception {				
		
		List<EstadoRubro> estadorubrosAux= new ArrayList<EstadoRubro>();
		
		for(EstadoRubro estadorubro:estadorubros) {
			if(!estadorubro.getIsDeleted()) {
				estadorubrosAux.add(estadorubro);
			}
		}
		
		estadorubros=estadorubrosAux;
	}
	
	public void quitarEstadoRubrosNulos() throws Exception {				
		
		List<EstadoRubro> estadorubrosAux= new ArrayList<EstadoRubro>();
		
		for(EstadoRubro estadorubro : this.estadorubros) {
			if(estadorubro==null) {
				estadorubrosAux.add(estadorubro);
			}
		}
		
		//this.estadorubros=estadorubrosAux;
		
		this.estadorubros.removeAll(estadorubrosAux);
	}
	
	public void getSetVersionRowEstadoRubroWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(estadorubro.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((estadorubro.getIsDeleted() || (estadorubro.getIsChanged()&&!estadorubro.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=estadorubroDataAccess.getSetVersionRowEstadoRubro(connexion,estadorubro.getId());
				
				if(!estadorubro.getVersionRow().equals(timestamp)) {	
					estadorubro.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				estadorubro.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowEstadoRubro()throws Exception {	
		
		if(estadorubro.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((estadorubro.getIsDeleted() || (estadorubro.getIsChanged()&&!estadorubro.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=estadorubroDataAccess.getSetVersionRowEstadoRubro(connexion,estadorubro.getId());
			
			try {							
				if(!estadorubro.getVersionRow().equals(timestamp)) {	
					estadorubro.setVersionRow(timestamp);
				}
				
				estadorubro.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowEstadoRubrosWithConnection()throws Exception {	
		if(estadorubros!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(EstadoRubro estadorubroAux:estadorubros) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(estadorubroAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(estadorubroAux.getIsDeleted() || (estadorubroAux.getIsChanged()&&!estadorubroAux.getIsNew())) {
						
						timestamp=estadorubroDataAccess.getSetVersionRowEstadoRubro(connexion,estadorubroAux.getId());
						
						if(!estadorubro.getVersionRow().equals(timestamp)) {	
							estadorubroAux.setVersionRow(timestamp);
						}
								
						estadorubroAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowEstadoRubros()throws Exception {	
		if(estadorubros!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(EstadoRubro estadorubroAux:estadorubros) {
					if(estadorubroAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(estadorubroAux.getIsDeleted() || (estadorubroAux.getIsChanged()&&!estadorubroAux.getIsNew())) {
						
						timestamp=estadorubroDataAccess.getSetVersionRowEstadoRubro(connexion,estadorubroAux.getId());
						
						if(!estadorubroAux.getVersionRow().equals(timestamp)) {	
							estadorubroAux.setVersionRow(timestamp);
						}
						
													
						estadorubroAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	
	public void cargarRelacionesLoteForeignKeyEstadoRubroWithConnection() throws Exception {
		ArrayList<Classe> classes=new ArrayList<Classe>();		
		
		
			RubroEmpleadoLogic rubroempleadoLogic=new RubroEmpleadoLogic();
		
		try {
			
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoRubro.class.getSimpleName()+"-cargarRelacionesLoteForeignKeyEstadoRubroWithConnection");connexion.begin();
			
			
			classes.add(new Classe(RubroEmpleado.class));
											
			

			rubroempleadoLogic.setConnexion(this.getConnexion());
			rubroempleadoLogic.setDatosCliente(this.datosCliente);
			rubroempleadoLogic.setIsConRefrescarForeignKeys(true);
			
			this.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
			
			for(EstadoRubro estadorubro:this.estadorubros) {
				

				classes=new ArrayList<Classe>();
				classes=RubroEmpleadoConstantesFunciones.getClassesForeignKeysOfRubroEmpleado(new ArrayList<Classe>(),DeepLoadType.NONE);

				rubroempleadoLogic.setRubroEmpleados(estadorubro.rubroempleados);
				rubroempleadoLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
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
	
	public void deepLoad(EstadoRubro estadorubro,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			EstadoRubroLogicAdditional.updateEstadoRubroToGet(estadorubro,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		estadorubro.setRubroEmpleados(estadorubroDataAccess.getRubroEmpleados(connexion,estadorubro));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(RubroEmpleado.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				estadorubro.setRubroEmpleados(estadorubroDataAccess.getRubroEmpleados(connexion,estadorubro));

				if(this.isConDeep) {
					RubroEmpleadoLogic rubroempleadoLogic= new RubroEmpleadoLogic(this.connexion);
					rubroempleadoLogic.setRubroEmpleados(estadorubro.getRubroEmpleados());
					ArrayList<Classe> classesLocal=RubroEmpleadoConstantesFunciones.getClassesForeignKeysOfRubroEmpleado(new ArrayList<Classe>(),DeepLoadType.NONE);
					rubroempleadoLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					RubroEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesRubroEmpleado(rubroempleadoLogic.getRubroEmpleados());
					estadorubro.setRubroEmpleados(rubroempleadoLogic.getRubroEmpleados());
				}

				continue;
			}
		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {


		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(RubroEmpleado.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(RubroEmpleado.class));
			estadorubro.setRubroEmpleados(estadorubroDataAccess.getRubroEmpleados(connexion,estadorubro));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {


		estadorubro.setRubroEmpleados(estadorubroDataAccess.getRubroEmpleados(connexion,estadorubro));

		for(RubroEmpleado rubroempleado:estadorubro.getRubroEmpleados()) {
			RubroEmpleadoLogic rubroempleadoLogic= new RubroEmpleadoLogic(connexion);
			rubroempleadoLogic.deepLoad(rubroempleado,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(RubroEmpleado.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				estadorubro.setRubroEmpleados(estadorubroDataAccess.getRubroEmpleados(connexion,estadorubro));

				for(RubroEmpleado rubroempleado:estadorubro.getRubroEmpleados()) {
					RubroEmpleadoLogic rubroempleadoLogic= new RubroEmpleadoLogic(connexion);
					rubroempleadoLogic.deepLoad(rubroempleado,isDeep,deepLoadType,clases);
				}
				continue;
			}

		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {


		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(RubroEmpleado.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(RubroEmpleado.class));
			estadorubro.setRubroEmpleados(estadorubroDataAccess.getRubroEmpleados(connexion,estadorubro));

			for(RubroEmpleado rubroempleado:estadorubro.getRubroEmpleados()) {
				RubroEmpleadoLogic rubroempleadoLogic= new RubroEmpleadoLogic(connexion);
				rubroempleadoLogic.deepLoad(rubroempleado,isDeep,deepLoadType,clases);
			}
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(EstadoRubro estadorubro,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			EstadoRubroLogicAdditional.updateEstadoRubroToSave(estadorubro,this.arrDatoGeneral);
			
EstadoRubroDataAccess.save(estadorubro, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		for(RubroEmpleado rubroempleado:estadorubro.getRubroEmpleados()) {
			rubroempleado.setid_estado_rubro(estadorubro.getId());
			RubroEmpleadoDataAccess.save(rubroempleado,connexion);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {

			if(clas.clas.equals(RubroEmpleado.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(RubroEmpleado rubroempleado:estadorubro.getRubroEmpleados()) {
					rubroempleado.setid_estado_rubro(estadorubro.getId());
					RubroEmpleadoDataAccess.save(rubroempleado,connexion);
				}
				continue;
			}
		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		for(RubroEmpleado rubroempleado:estadorubro.getRubroEmpleados()) {
			RubroEmpleadoLogic rubroempleadoLogic= new RubroEmpleadoLogic(connexion);
			rubroempleado.setid_estado_rubro(estadorubro.getId());
			RubroEmpleadoDataAccess.save(rubroempleado,connexion);
			rubroempleadoLogic.deepSave(rubroempleado,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {

			if(clas.clas.equals(RubroEmpleado.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(RubroEmpleado rubroempleado:estadorubro.getRubroEmpleados()) {
					RubroEmpleadoLogic rubroempleadoLogic= new RubroEmpleadoLogic(connexion);
					rubroempleado.setid_estado_rubro(estadorubro.getId());
					RubroEmpleadoDataAccess.save(rubroempleado,connexion);
					rubroempleadoLogic.deepSave(rubroempleado,isDeep,deepLoadType,clases);
				}
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
			this.getNewConnexionToDeep(EstadoRubro.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(estadorubro,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				EstadoRubroConstantesFunciones.refrescarForeignKeysDescripcionesEstadoRubro(estadorubro);
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
			this.deepLoad(this.estadorubro,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				EstadoRubroConstantesFunciones.refrescarForeignKeysDescripcionesEstadoRubro(this.estadorubro);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(EstadoRubro.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(estadorubros!=null) {
				for(EstadoRubro estadorubro:estadorubros) {
					this.deepLoad(estadorubro,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					EstadoRubroConstantesFunciones.refrescarForeignKeysDescripcionesEstadoRubro(estadorubros);
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
			if(estadorubros!=null) {
				for(EstadoRubro estadorubro:estadorubros) {
					this.deepLoad(estadorubro,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					EstadoRubroConstantesFunciones.refrescarForeignKeysDescripcionesEstadoRubro(estadorubros);
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
			this.getNewConnexionToDeep(EstadoRubro.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(estadorubro,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(EstadoRubro.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(estadorubros!=null) {
				for(EstadoRubro estadorubro:estadorubros) {
					this.deepSave(estadorubro,isDeep,deepLoadType,clases);
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
			if(estadorubros!=null) {
				for(EstadoRubro estadorubro:estadorubros) {
					this.deepSave(estadorubro,isDeep,deepLoadType,clases);
				}		
			}
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
			if(EstadoRubroConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,EstadoRubroDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,EstadoRubro estadorubro,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(EstadoRubroConstantesFunciones.ISCONAUDITORIA) {
				if(estadorubro.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,EstadoRubroDataAccess.TABLENAME, estadorubro.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(EstadoRubroConstantesFunciones.ISCONAUDITORIADETALLE) {
						////EstadoRubroLogic.registrarAuditoriaDetallesEstadoRubro(connexion,estadorubro,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(estadorubro.getIsDeleted()) {
					/*if(!estadorubro.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,EstadoRubroDataAccess.TABLENAME, estadorubro.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////EstadoRubroLogic.registrarAuditoriaDetallesEstadoRubro(connexion,estadorubro,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,EstadoRubroDataAccess.TABLENAME, estadorubro.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(estadorubro.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,EstadoRubroDataAccess.TABLENAME, estadorubro.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(EstadoRubroConstantesFunciones.ISCONAUDITORIADETALLE) {
						////EstadoRubroLogic.registrarAuditoriaDetallesEstadoRubro(connexion,estadorubro,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesEstadoRubro(Connexion connexion,EstadoRubro estadorubro)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(estadorubro.getIsNew()||!estadorubro.getcodigo().equals(estadorubro.getEstadoRubroOriginal().getcodigo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(estadorubro.getEstadoRubroOriginal().getcodigo()!=null)
				{
					strValorActual=estadorubro.getEstadoRubroOriginal().getcodigo();
				}
				if(estadorubro.getcodigo()!=null)
				{
					strValorNuevo=estadorubro.getcodigo() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),EstadoRubroConstantesFunciones.CODIGO,strValorActual,strValorNuevo);
			}	
			
			if(estadorubro.getIsNew()||!estadorubro.getnombre().equals(estadorubro.getEstadoRubroOriginal().getnombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(estadorubro.getEstadoRubroOriginal().getnombre()!=null)
				{
					strValorActual=estadorubro.getEstadoRubroOriginal().getnombre();
				}
				if(estadorubro.getnombre()!=null)
				{
					strValorNuevo=estadorubro.getnombre() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),EstadoRubroConstantesFunciones.NOMBRE,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveEstadoRubroRelacionesWithConnection(EstadoRubro estadorubro,List<RubroEmpleado> rubroempleados) throws Exception {

		if(!estadorubro.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveEstadoRubroRelacionesBase(estadorubro,rubroempleados,true);
		}
	}

	public void saveEstadoRubroRelaciones(EstadoRubro estadorubro,List<RubroEmpleado> rubroempleados)throws Exception {

		if(!estadorubro.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveEstadoRubroRelacionesBase(estadorubro,rubroempleados,false);
		}
	}

	public void saveEstadoRubroRelacionesBase(EstadoRubro estadorubro,List<RubroEmpleado> rubroempleados,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("EstadoRubro-saveRelacionesWithConnection");}
	
			estadorubro.setRubroEmpleados(rubroempleados);

			this.setEstadoRubro(estadorubro);

				if((estadorubro.getIsNew()||estadorubro.getIsChanged())&&!estadorubro.getIsDeleted()) {
					this.saveEstadoRubro();
					this.saveEstadoRubroRelacionesDetalles(rubroempleados);

				} else if(estadorubro.getIsDeleted()) {
					this.saveEstadoRubroRelacionesDetalles(rubroempleados);
					this.saveEstadoRubro();
				}

			if(conConexion) {connexion.commit();}

		} catch(Exception e) {
			
			RubroEmpleadoConstantesFunciones.InicializarGeneralEntityAuxiliaresRubroEmpleados(rubroempleados,true,true);

			if(conConexion){connexion.rollback();}
			Funciones.manageException(logger,e);
			throw e;

		} finally {
			if(conConexion){this.closeNewConnexionToDeep();}
		}
	}
	
	
	private void saveEstadoRubroRelacionesDetalles(List<RubroEmpleado> rubroempleados)throws Exception {
		try {
	

			Long idEstadoRubroActual=this.getEstadoRubro().getId();

			RubroEmpleadoLogic rubroempleadoLogic_Desde_EstadoRubro=new RubroEmpleadoLogic();
			rubroempleadoLogic_Desde_EstadoRubro.setRubroEmpleados(rubroempleados);

			rubroempleadoLogic_Desde_EstadoRubro.setConnexion(this.getConnexion());
			rubroempleadoLogic_Desde_EstadoRubro.setDatosCliente(this.datosCliente);

			for(RubroEmpleado rubroempleado_Desde_EstadoRubro:rubroempleadoLogic_Desde_EstadoRubro.getRubroEmpleados()) {
				rubroempleado_Desde_EstadoRubro.setid_estado_rubro(idEstadoRubroActual);
			}

			rubroempleadoLogic_Desde_EstadoRubro.saveRubroEmpleados();

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfEstadoRubro(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=EstadoRubroConstantesFunciones.getClassesForeignKeysOfEstadoRubro(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfEstadoRubro(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=EstadoRubroConstantesFunciones.getClassesRelationshipsOfEstadoRubro(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

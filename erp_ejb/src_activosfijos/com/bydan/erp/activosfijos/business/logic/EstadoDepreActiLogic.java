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
package com.bydan.erp.activosfijos.business.logic;

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
import com.bydan.erp.activosfijos.util.*;
import com.bydan.erp.activosfijos.util.EstadoDepreActiConstantesFunciones;
import com.bydan.erp.activosfijos.util.EstadoDepreActiParameterReturnGeneral;
//import com.bydan.erp.activosfijos.util.EstadoDepreActiParameterGeneral;
import com.bydan.erp.activosfijos.business.entity.EstadoDepreActi;
import com.bydan.erp.activosfijos.business.logic.EstadoDepreActiLogicAdditional;
import com.bydan.erp.activosfijos.business.dataaccess.*;
import com.bydan.erp.activosfijos.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;
















@SuppressWarnings("unused")
public class EstadoDepreActiLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(EstadoDepreActiLogic.class);
	
	protected EstadoDepreActiDataAccess estadodepreactiDataAccess; 	
	protected EstadoDepreActi estadodepreacti;
	protected List<EstadoDepreActi> estadodepreactis;
	protected Object estadodepreactiObject;	
	protected List<Object> estadodepreactisObject;
	
	public static ClassValidator<EstadoDepreActi> estadodepreactiValidator = new ClassValidator<EstadoDepreActi>(EstadoDepreActi.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected EstadoDepreActiLogicAdditional estadodepreactiLogicAdditional=null;
	
	public EstadoDepreActiLogicAdditional getEstadoDepreActiLogicAdditional() {
		return this.estadodepreactiLogicAdditional;
	}
	
	public void setEstadoDepreActiLogicAdditional(EstadoDepreActiLogicAdditional estadodepreactiLogicAdditional) {
		try {
			this.estadodepreactiLogicAdditional=estadodepreactiLogicAdditional;
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
	
	
	
	
	public  EstadoDepreActiLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.estadodepreactiDataAccess = new EstadoDepreActiDataAccess();
			
			this.estadodepreactis= new ArrayList<EstadoDepreActi>();
			this.estadodepreacti= new EstadoDepreActi();
			
			this.estadodepreactiObject=new Object();
			this.estadodepreactisObject=new ArrayList<Object>();
				
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
			
			this.estadodepreactiDataAccess.setConnexionType(this.connexionType);
			this.estadodepreactiDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  EstadoDepreActiLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.estadodepreactiDataAccess = new EstadoDepreActiDataAccess();
			this.estadodepreactis= new ArrayList<EstadoDepreActi>();
			this.estadodepreacti= new EstadoDepreActi();
			this.estadodepreactiObject=new Object();
			this.estadodepreactisObject=new ArrayList<Object>();
			
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
			
			this.estadodepreactiDataAccess.setConnexionType(this.connexionType);
			this.estadodepreactiDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public EstadoDepreActi getEstadoDepreActi() throws Exception {	
		EstadoDepreActiLogicAdditional.checkEstadoDepreActiToGet(estadodepreacti,this.datosCliente,this.arrDatoGeneral);
		EstadoDepreActiLogicAdditional.updateEstadoDepreActiToGet(estadodepreacti,this.arrDatoGeneral);
		
		return estadodepreacti;
	}
		
	public void setEstadoDepreActi(EstadoDepreActi newEstadoDepreActi) {
		this.estadodepreacti = newEstadoDepreActi;
	}
	
	public EstadoDepreActiDataAccess getEstadoDepreActiDataAccess() {
		return estadodepreactiDataAccess;
	}
	
	public void setEstadoDepreActiDataAccess(EstadoDepreActiDataAccess newestadodepreactiDataAccess) {
		this.estadodepreactiDataAccess = newestadodepreactiDataAccess;
	}
	
	public List<EstadoDepreActi> getEstadoDepreActis() throws Exception {		
		this.quitarEstadoDepreActisNulos();
		
		EstadoDepreActiLogicAdditional.checkEstadoDepreActiToGets(estadodepreactis,this.datosCliente,this.arrDatoGeneral);
		
		for (EstadoDepreActi estadodepreactiLocal: estadodepreactis ) {
			EstadoDepreActiLogicAdditional.updateEstadoDepreActiToGet(estadodepreactiLocal,this.arrDatoGeneral);
		}
		
		return estadodepreactis;
	}
	
	public void setEstadoDepreActis(List<EstadoDepreActi> newEstadoDepreActis) {
		this.estadodepreactis = newEstadoDepreActis;
	}
	
	public Object getEstadoDepreActiObject() {	
		this.estadodepreactiObject=this.estadodepreactiDataAccess.getEntityObject();
		return this.estadodepreactiObject;
	}
		
	public void setEstadoDepreActiObject(Object newEstadoDepreActiObject) {
		this.estadodepreactiObject = newEstadoDepreActiObject;
	}
	
	public List<Object> getEstadoDepreActisObject() {		
		this.estadodepreactisObject=this.estadodepreactiDataAccess.getEntitiesObject();
		return this.estadodepreactisObject;
	}
		
	public void setEstadoDepreActisObject(List<Object> newEstadoDepreActisObject) {
		this.estadodepreactisObject = newEstadoDepreActisObject;
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
		
		if(this.estadodepreactiDataAccess!=null) {
			this.estadodepreactiDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoDepreActi.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			estadodepreactiDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			estadodepreactiDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		estadodepreacti = new  EstadoDepreActi();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoDepreActi.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			estadodepreacti=estadodepreactiDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.estadodepreacti,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				EstadoDepreActiConstantesFunciones.refrescarForeignKeysDescripcionesEstadoDepreActi(this.estadodepreacti);
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
		estadodepreacti = new  EstadoDepreActi();
		  		  
        try {
			
			estadodepreacti=estadodepreactiDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.estadodepreacti,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				EstadoDepreActiConstantesFunciones.refrescarForeignKeysDescripcionesEstadoDepreActi(this.estadodepreacti);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		estadodepreacti = new  EstadoDepreActi();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoDepreActi.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			estadodepreacti=estadodepreactiDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.estadodepreacti,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				EstadoDepreActiConstantesFunciones.refrescarForeignKeysDescripcionesEstadoDepreActi(this.estadodepreacti);
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
		estadodepreacti = new  EstadoDepreActi();
		  		  
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
		estadodepreacti = new  EstadoDepreActi();
		  		  
        try {
			
			estadodepreacti=estadodepreactiDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.estadodepreacti,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				EstadoDepreActiConstantesFunciones.refrescarForeignKeysDescripcionesEstadoDepreActi(this.estadodepreacti);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		estadodepreacti = new  EstadoDepreActi();
		  		  
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
		estadodepreacti = new  EstadoDepreActi();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoDepreActi.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =estadodepreactiDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		estadodepreacti = new  EstadoDepreActi();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=estadodepreactiDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		estadodepreacti = new  EstadoDepreActi();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoDepreActi.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =estadodepreactiDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		estadodepreacti = new  EstadoDepreActi();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=estadodepreactiDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		estadodepreacti = new  EstadoDepreActi();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoDepreActi.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =estadodepreactiDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		estadodepreacti = new  EstadoDepreActi();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=estadodepreactiDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		estadodepreactis = new  ArrayList<EstadoDepreActi>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoDepreActi.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			EstadoDepreActiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadodepreactis=estadodepreactiDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarEstadoDepreActi(estadodepreactis);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoDepreActiConstantesFunciones.refrescarForeignKeysDescripcionesEstadoDepreActi(this.estadodepreactis);
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
		estadodepreactis = new  ArrayList<EstadoDepreActi>();
		  		  
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
		estadodepreactis = new  ArrayList<EstadoDepreActi>();
		  		  
        try {			
			EstadoDepreActiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadodepreactis=estadodepreactiDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarEstadoDepreActi(estadodepreactis);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoDepreActiConstantesFunciones.refrescarForeignKeysDescripcionesEstadoDepreActi(this.estadodepreactis);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		estadodepreactis = new  ArrayList<EstadoDepreActi>();
		  		  
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
		estadodepreactis = new  ArrayList<EstadoDepreActi>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoDepreActi.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			EstadoDepreActiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadodepreactis=estadodepreactiDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarEstadoDepreActi(estadodepreactis);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoDepreActiConstantesFunciones.refrescarForeignKeysDescripcionesEstadoDepreActi(this.estadodepreactis);
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
		estadodepreactis = new  ArrayList<EstadoDepreActi>();
		  		  
        try {
			EstadoDepreActiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadodepreactis=estadodepreactiDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarEstadoDepreActi(estadodepreactis);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoDepreActiConstantesFunciones.refrescarForeignKeysDescripcionesEstadoDepreActi(this.estadodepreactis);
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
		estadodepreactis = new  ArrayList<EstadoDepreActi>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoDepreActi.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EstadoDepreActiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadodepreactis=estadodepreactiDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarEstadoDepreActi(estadodepreactis);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoDepreActiConstantesFunciones.refrescarForeignKeysDescripcionesEstadoDepreActi(this.estadodepreactis);
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
		estadodepreactis = new  ArrayList<EstadoDepreActi>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EstadoDepreActiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadodepreactis=estadodepreactiDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarEstadoDepreActi(estadodepreactis);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoDepreActiConstantesFunciones.refrescarForeignKeysDescripcionesEstadoDepreActi(this.estadodepreactis);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		estadodepreacti = new  EstadoDepreActi();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoDepreActi.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EstadoDepreActiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadodepreacti=estadodepreactiDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarEstadoDepreActi(estadodepreacti);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoDepreActiConstantesFunciones.refrescarForeignKeysDescripcionesEstadoDepreActi(this.estadodepreacti);
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
		estadodepreacti = new  EstadoDepreActi();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EstadoDepreActiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadodepreacti=estadodepreactiDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarEstadoDepreActi(estadodepreacti);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoDepreActiConstantesFunciones.refrescarForeignKeysDescripcionesEstadoDepreActi(this.estadodepreacti);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		estadodepreactis = new  ArrayList<EstadoDepreActi>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoDepreActi.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			EstadoDepreActiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadodepreactis=estadodepreactiDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarEstadoDepreActi(estadodepreactis);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoDepreActiConstantesFunciones.refrescarForeignKeysDescripcionesEstadoDepreActi(this.estadodepreactis);
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
		estadodepreactis = new  ArrayList<EstadoDepreActi>();
		  		  
        try {
			EstadoDepreActiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadodepreactis=estadodepreactiDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarEstadoDepreActi(estadodepreactis);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoDepreActiConstantesFunciones.refrescarForeignKeysDescripcionesEstadoDepreActi(this.estadodepreactis);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosEstadoDepreActisWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		estadodepreactis = new  ArrayList<EstadoDepreActi>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoDepreActi.class.getSimpleName()+"-getTodosEstadoDepreActisWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EstadoDepreActiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadodepreactis=estadodepreactiDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarEstadoDepreActi(estadodepreactis);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoDepreActiConstantesFunciones.refrescarForeignKeysDescripcionesEstadoDepreActi(this.estadodepreactis);
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
	
	public  void  getTodosEstadoDepreActis(String sFinalQuery,Pagination pagination)throws Exception {
		estadodepreactis = new  ArrayList<EstadoDepreActi>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EstadoDepreActiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadodepreactis=estadodepreactiDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarEstadoDepreActi(estadodepreactis);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoDepreActiConstantesFunciones.refrescarForeignKeysDescripcionesEstadoDepreActi(this.estadodepreactis);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarEstadoDepreActi(EstadoDepreActi estadodepreacti) throws Exception {
		Boolean estaValidado=false;
		
		if(estadodepreacti.getIsNew() || estadodepreacti.getIsChanged()) { 
			this.invalidValues = estadodepreactiValidator.getInvalidValues(estadodepreacti);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(estadodepreacti);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarEstadoDepreActi(List<EstadoDepreActi> EstadoDepreActis) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(EstadoDepreActi estadodepreactiLocal:estadodepreactis) {				
			estaValidadoObjeto=this.validarGuardarEstadoDepreActi(estadodepreactiLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarEstadoDepreActi(List<EstadoDepreActi> EstadoDepreActis) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarEstadoDepreActi(estadodepreactis)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarEstadoDepreActi(EstadoDepreActi EstadoDepreActi) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarEstadoDepreActi(estadodepreacti)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(EstadoDepreActi estadodepreacti) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+estadodepreacti.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=EstadoDepreActiConstantesFunciones.getEstadoDepreActiLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"estadodepreacti","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(EstadoDepreActiConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(EstadoDepreActiConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveEstadoDepreActiWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoDepreActi.class.getSimpleName()+"-saveEstadoDepreActiWithConnection");connexion.begin();			
			
			EstadoDepreActiLogicAdditional.checkEstadoDepreActiToSave(this.estadodepreacti,this.datosCliente,connexion,this.arrDatoGeneral);
			
			EstadoDepreActiLogicAdditional.updateEstadoDepreActiToSave(this.estadodepreacti,this.arrDatoGeneral);
			
			EstadoDepreActiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.estadodepreacti,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowEstadoDepreActi();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarEstadoDepreActi(this.estadodepreacti)) {
				EstadoDepreActiDataAccess.save(this.estadodepreacti, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.estadodepreacti,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			EstadoDepreActiLogicAdditional.checkEstadoDepreActiToSaveAfter(this.estadodepreacti,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowEstadoDepreActi();
			
			connexion.commit();			
			
			if(this.estadodepreacti.getIsDeleted()) {
				this.estadodepreacti=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveEstadoDepreActi()throws Exception {	
		try {	
			
			EstadoDepreActiLogicAdditional.checkEstadoDepreActiToSave(this.estadodepreacti,this.datosCliente,connexion,this.arrDatoGeneral);
			
			EstadoDepreActiLogicAdditional.updateEstadoDepreActiToSave(this.estadodepreacti,this.arrDatoGeneral);
			
			EstadoDepreActiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.estadodepreacti,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarEstadoDepreActi(this.estadodepreacti)) {			
				EstadoDepreActiDataAccess.save(this.estadodepreacti, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.estadodepreacti,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			EstadoDepreActiLogicAdditional.checkEstadoDepreActiToSaveAfter(this.estadodepreacti,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.estadodepreacti.getIsDeleted()) {
				this.estadodepreacti=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveEstadoDepreActisWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoDepreActi.class.getSimpleName()+"-saveEstadoDepreActisWithConnection");connexion.begin();			
			
			EstadoDepreActiLogicAdditional.checkEstadoDepreActiToSaves(estadodepreactis,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowEstadoDepreActis();
			
			Boolean validadoTodosEstadoDepreActi=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(EstadoDepreActi estadodepreactiLocal:estadodepreactis) {		
				if(estadodepreactiLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				EstadoDepreActiLogicAdditional.updateEstadoDepreActiToSave(estadodepreactiLocal,this.arrDatoGeneral);
	        	
				EstadoDepreActiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),estadodepreactiLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarEstadoDepreActi(estadodepreactiLocal)) {
					EstadoDepreActiDataAccess.save(estadodepreactiLocal, connexion);				
				} else {
					validadoTodosEstadoDepreActi=false;
				}
			}
			
			if(!validadoTodosEstadoDepreActi) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			EstadoDepreActiLogicAdditional.checkEstadoDepreActiToSavesAfter(estadodepreactis,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowEstadoDepreActis();
			
			connexion.commit();		
			
			this.quitarEstadoDepreActisEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveEstadoDepreActis()throws Exception {				
		 try {	
			EstadoDepreActiLogicAdditional.checkEstadoDepreActiToSaves(estadodepreactis,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosEstadoDepreActi=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(EstadoDepreActi estadodepreactiLocal:estadodepreactis) {				
				if(estadodepreactiLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				EstadoDepreActiLogicAdditional.updateEstadoDepreActiToSave(estadodepreactiLocal,this.arrDatoGeneral);
	        	
				EstadoDepreActiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),estadodepreactiLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarEstadoDepreActi(estadodepreactiLocal)) {				
					EstadoDepreActiDataAccess.save(estadodepreactiLocal, connexion);				
				} else {
					validadoTodosEstadoDepreActi=false;
				}
			}
			
			if(!validadoTodosEstadoDepreActi) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			EstadoDepreActiLogicAdditional.checkEstadoDepreActiToSavesAfter(estadodepreactis,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarEstadoDepreActisEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public EstadoDepreActiParameterReturnGeneral procesarAccionEstadoDepreActis(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<EstadoDepreActi> estadodepreactis,EstadoDepreActiParameterReturnGeneral estadodepreactiParameterGeneral)throws Exception {
		 try {	
			EstadoDepreActiParameterReturnGeneral estadodepreactiReturnGeneral=new EstadoDepreActiParameterReturnGeneral();
	
			EstadoDepreActiLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,estadodepreactis,estadodepreactiParameterGeneral,estadodepreactiReturnGeneral);
			
			return estadodepreactiReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public EstadoDepreActiParameterReturnGeneral procesarAccionEstadoDepreActisWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<EstadoDepreActi> estadodepreactis,EstadoDepreActiParameterReturnGeneral estadodepreactiParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoDepreActi.class.getSimpleName()+"-procesarAccionEstadoDepreActisWithConnection");connexion.begin();			
			
			EstadoDepreActiParameterReturnGeneral estadodepreactiReturnGeneral=new EstadoDepreActiParameterReturnGeneral();
	
			EstadoDepreActiLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,estadodepreactis,estadodepreactiParameterGeneral,estadodepreactiReturnGeneral);
			
			this.connexion.commit();
			
			return estadodepreactiReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public EstadoDepreActiParameterReturnGeneral procesarEventosEstadoDepreActis(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<EstadoDepreActi> estadodepreactis,EstadoDepreActi estadodepreacti,EstadoDepreActiParameterReturnGeneral estadodepreactiParameterGeneral,Boolean isEsNuevoEstadoDepreActi,ArrayList<Classe> clases)throws Exception {
		 try {	
			EstadoDepreActiParameterReturnGeneral estadodepreactiReturnGeneral=new EstadoDepreActiParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				estadodepreactiReturnGeneral.setConRecargarPropiedades(true);
			}
			
			EstadoDepreActiLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,estadodepreactis,estadodepreacti,estadodepreactiParameterGeneral,estadodepreactiReturnGeneral,isEsNuevoEstadoDepreActi,clases);
			
			return estadodepreactiReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public EstadoDepreActiParameterReturnGeneral procesarEventosEstadoDepreActisWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<EstadoDepreActi> estadodepreactis,EstadoDepreActi estadodepreacti,EstadoDepreActiParameterReturnGeneral estadodepreactiParameterGeneral,Boolean isEsNuevoEstadoDepreActi,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoDepreActi.class.getSimpleName()+"-procesarEventosEstadoDepreActisWithConnection");connexion.begin();			
			
			EstadoDepreActiParameterReturnGeneral estadodepreactiReturnGeneral=new EstadoDepreActiParameterReturnGeneral();
	
			estadodepreactiReturnGeneral.setEstadoDepreActi(estadodepreacti);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				estadodepreactiReturnGeneral.setConRecargarPropiedades(true);
			}
			
			EstadoDepreActiLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,estadodepreactis,estadodepreacti,estadodepreactiParameterGeneral,estadodepreactiReturnGeneral,isEsNuevoEstadoDepreActi,clases);
			
			this.connexion.commit();
			
			return estadodepreactiReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public EstadoDepreActiParameterReturnGeneral procesarImportacionEstadoDepreActisWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,EstadoDepreActiParameterReturnGeneral estadodepreactiParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoDepreActi.class.getSimpleName()+"-procesarImportacionEstadoDepreActisWithConnection");connexion.begin();			
			
			EstadoDepreActiParameterReturnGeneral estadodepreactiReturnGeneral=new EstadoDepreActiParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.estadodepreactis=new ArrayList<EstadoDepreActi>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.estadodepreacti=new EstadoDepreActi();
				
				
				if(conColumnasBase) {this.estadodepreacti.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.estadodepreacti.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.estadodepreacti.setcodigo(arrColumnas[iColumn++]);
				this.estadodepreacti.setnombre(arrColumnas[iColumn++]);
				
				this.estadodepreactis.add(this.estadodepreacti);
			}
			
			this.saveEstadoDepreActis();
			
			this.connexion.commit();
			
			estadodepreactiReturnGeneral.setConRetornoEstaProcesado(true);
			estadodepreactiReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return estadodepreactiReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarEstadoDepreActisEliminados() throws Exception {				
		
		List<EstadoDepreActi> estadodepreactisAux= new ArrayList<EstadoDepreActi>();
		
		for(EstadoDepreActi estadodepreacti:estadodepreactis) {
			if(!estadodepreacti.getIsDeleted()) {
				estadodepreactisAux.add(estadodepreacti);
			}
		}
		
		estadodepreactis=estadodepreactisAux;
	}
	
	public void quitarEstadoDepreActisNulos() throws Exception {				
		
		List<EstadoDepreActi> estadodepreactisAux= new ArrayList<EstadoDepreActi>();
		
		for(EstadoDepreActi estadodepreacti : this.estadodepreactis) {
			if(estadodepreacti==null) {
				estadodepreactisAux.add(estadodepreacti);
			}
		}
		
		//this.estadodepreactis=estadodepreactisAux;
		
		this.estadodepreactis.removeAll(estadodepreactisAux);
	}
	
	public void getSetVersionRowEstadoDepreActiWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(estadodepreacti.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((estadodepreacti.getIsDeleted() || (estadodepreacti.getIsChanged()&&!estadodepreacti.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=estadodepreactiDataAccess.getSetVersionRowEstadoDepreActi(connexion,estadodepreacti.getId());
				
				if(!estadodepreacti.getVersionRow().equals(timestamp)) {	
					estadodepreacti.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				estadodepreacti.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowEstadoDepreActi()throws Exception {	
		
		if(estadodepreacti.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((estadodepreacti.getIsDeleted() || (estadodepreacti.getIsChanged()&&!estadodepreacti.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=estadodepreactiDataAccess.getSetVersionRowEstadoDepreActi(connexion,estadodepreacti.getId());
			
			try {							
				if(!estadodepreacti.getVersionRow().equals(timestamp)) {	
					estadodepreacti.setVersionRow(timestamp);
				}
				
				estadodepreacti.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowEstadoDepreActisWithConnection()throws Exception {	
		if(estadodepreactis!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(EstadoDepreActi estadodepreactiAux:estadodepreactis) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(estadodepreactiAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(estadodepreactiAux.getIsDeleted() || (estadodepreactiAux.getIsChanged()&&!estadodepreactiAux.getIsNew())) {
						
						timestamp=estadodepreactiDataAccess.getSetVersionRowEstadoDepreActi(connexion,estadodepreactiAux.getId());
						
						if(!estadodepreacti.getVersionRow().equals(timestamp)) {	
							estadodepreactiAux.setVersionRow(timestamp);
						}
								
						estadodepreactiAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowEstadoDepreActis()throws Exception {	
		if(estadodepreactis!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(EstadoDepreActi estadodepreactiAux:estadodepreactis) {
					if(estadodepreactiAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(estadodepreactiAux.getIsDeleted() || (estadodepreactiAux.getIsChanged()&&!estadodepreactiAux.getIsNew())) {
						
						timestamp=estadodepreactiDataAccess.getSetVersionRowEstadoDepreActi(connexion,estadodepreactiAux.getId());
						
						if(!estadodepreactiAux.getVersionRow().equals(timestamp)) {	
							estadodepreactiAux.setVersionRow(timestamp);
						}
						
													
						estadodepreactiAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	
	public void cargarRelacionesLoteForeignKeyEstadoDepreActiWithConnection() throws Exception {
		ArrayList<Classe> classes=new ArrayList<Classe>();		
		
		
			DepreciacionActivoFijoLogic depreciacionactivofijoLogic=new DepreciacionActivoFijoLogic();
		
		try {
			
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoDepreActi.class.getSimpleName()+"-cargarRelacionesLoteForeignKeyEstadoDepreActiWithConnection");connexion.begin();
			
			
			classes.add(new Classe(DepreciacionActivoFijo.class));
											
			

			depreciacionactivofijoLogic.setConnexion(this.getConnexion());
			depreciacionactivofijoLogic.setDatosCliente(this.datosCliente);
			depreciacionactivofijoLogic.setIsConRefrescarForeignKeys(true);
			
			this.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
			
			for(EstadoDepreActi estadodepreacti:this.estadodepreactis) {
				

				classes=new ArrayList<Classe>();
				classes=DepreciacionActivoFijoConstantesFunciones.getClassesForeignKeysOfDepreciacionActivoFijo(new ArrayList<Classe>(),DeepLoadType.NONE);

				depreciacionactivofijoLogic.setDepreciacionActivoFijos(estadodepreacti.depreciacionactivofijos);
				depreciacionactivofijoLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
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
	
	public void deepLoad(EstadoDepreActi estadodepreacti,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			EstadoDepreActiLogicAdditional.updateEstadoDepreActiToGet(estadodepreacti,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		estadodepreacti.setDepreciacionActivoFijos(estadodepreactiDataAccess.getDepreciacionActivoFijos(connexion,estadodepreacti));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(DepreciacionActivoFijo.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				estadodepreacti.setDepreciacionActivoFijos(estadodepreactiDataAccess.getDepreciacionActivoFijos(connexion,estadodepreacti));

				if(this.isConDeep) {
					DepreciacionActivoFijoLogic depreciacionactivofijoLogic= new DepreciacionActivoFijoLogic(this.connexion);
					depreciacionactivofijoLogic.setDepreciacionActivoFijos(estadodepreacti.getDepreciacionActivoFijos());
					ArrayList<Classe> classesLocal=DepreciacionActivoFijoConstantesFunciones.getClassesForeignKeysOfDepreciacionActivoFijo(new ArrayList<Classe>(),DeepLoadType.NONE);
					depreciacionactivofijoLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					DepreciacionActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesDepreciacionActivoFijo(depreciacionactivofijoLogic.getDepreciacionActivoFijos());
					estadodepreacti.setDepreciacionActivoFijos(depreciacionactivofijoLogic.getDepreciacionActivoFijos());
				}

				continue;
			}
		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {


		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(DepreciacionActivoFijo.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(DepreciacionActivoFijo.class));
			estadodepreacti.setDepreciacionActivoFijos(estadodepreactiDataAccess.getDepreciacionActivoFijos(connexion,estadodepreacti));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {


		estadodepreacti.setDepreciacionActivoFijos(estadodepreactiDataAccess.getDepreciacionActivoFijos(connexion,estadodepreacti));

		for(DepreciacionActivoFijo depreciacionactivofijo:estadodepreacti.getDepreciacionActivoFijos()) {
			DepreciacionActivoFijoLogic depreciacionactivofijoLogic= new DepreciacionActivoFijoLogic(connexion);
			depreciacionactivofijoLogic.deepLoad(depreciacionactivofijo,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(DepreciacionActivoFijo.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				estadodepreacti.setDepreciacionActivoFijos(estadodepreactiDataAccess.getDepreciacionActivoFijos(connexion,estadodepreacti));

				for(DepreciacionActivoFijo depreciacionactivofijo:estadodepreacti.getDepreciacionActivoFijos()) {
					DepreciacionActivoFijoLogic depreciacionactivofijoLogic= new DepreciacionActivoFijoLogic(connexion);
					depreciacionactivofijoLogic.deepLoad(depreciacionactivofijo,isDeep,deepLoadType,clases);
				}
				continue;
			}

		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {


		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(DepreciacionActivoFijo.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(DepreciacionActivoFijo.class));
			estadodepreacti.setDepreciacionActivoFijos(estadodepreactiDataAccess.getDepreciacionActivoFijos(connexion,estadodepreacti));

			for(DepreciacionActivoFijo depreciacionactivofijo:estadodepreacti.getDepreciacionActivoFijos()) {
				DepreciacionActivoFijoLogic depreciacionactivofijoLogic= new DepreciacionActivoFijoLogic(connexion);
				depreciacionactivofijoLogic.deepLoad(depreciacionactivofijo,isDeep,deepLoadType,clases);
			}
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(EstadoDepreActi estadodepreacti,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			EstadoDepreActiLogicAdditional.updateEstadoDepreActiToSave(estadodepreacti,this.arrDatoGeneral);
			
EstadoDepreActiDataAccess.save(estadodepreacti, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		for(DepreciacionActivoFijo depreciacionactivofijo:estadodepreacti.getDepreciacionActivoFijos()) {
			depreciacionactivofijo.setid_estado_depre_acti(estadodepreacti.getId());
			DepreciacionActivoFijoDataAccess.save(depreciacionactivofijo,connexion);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {

			if(clas.clas.equals(DepreciacionActivoFijo.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(DepreciacionActivoFijo depreciacionactivofijo:estadodepreacti.getDepreciacionActivoFijos()) {
					depreciacionactivofijo.setid_estado_depre_acti(estadodepreacti.getId());
					DepreciacionActivoFijoDataAccess.save(depreciacionactivofijo,connexion);
				}
				continue;
			}
		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		for(DepreciacionActivoFijo depreciacionactivofijo:estadodepreacti.getDepreciacionActivoFijos()) {
			DepreciacionActivoFijoLogic depreciacionactivofijoLogic= new DepreciacionActivoFijoLogic(connexion);
			depreciacionactivofijo.setid_estado_depre_acti(estadodepreacti.getId());
			DepreciacionActivoFijoDataAccess.save(depreciacionactivofijo,connexion);
			depreciacionactivofijoLogic.deepSave(depreciacionactivofijo,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {

			if(clas.clas.equals(DepreciacionActivoFijo.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(DepreciacionActivoFijo depreciacionactivofijo:estadodepreacti.getDepreciacionActivoFijos()) {
					DepreciacionActivoFijoLogic depreciacionactivofijoLogic= new DepreciacionActivoFijoLogic(connexion);
					depreciacionactivofijo.setid_estado_depre_acti(estadodepreacti.getId());
					DepreciacionActivoFijoDataAccess.save(depreciacionactivofijo,connexion);
					depreciacionactivofijoLogic.deepSave(depreciacionactivofijo,isDeep,deepLoadType,clases);
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
			this.getNewConnexionToDeep(EstadoDepreActi.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(estadodepreacti,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				EstadoDepreActiConstantesFunciones.refrescarForeignKeysDescripcionesEstadoDepreActi(estadodepreacti);
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
			this.deepLoad(this.estadodepreacti,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				EstadoDepreActiConstantesFunciones.refrescarForeignKeysDescripcionesEstadoDepreActi(this.estadodepreacti);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(EstadoDepreActi.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(estadodepreactis!=null) {
				for(EstadoDepreActi estadodepreacti:estadodepreactis) {
					this.deepLoad(estadodepreacti,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					EstadoDepreActiConstantesFunciones.refrescarForeignKeysDescripcionesEstadoDepreActi(estadodepreactis);
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
			if(estadodepreactis!=null) {
				for(EstadoDepreActi estadodepreacti:estadodepreactis) {
					this.deepLoad(estadodepreacti,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					EstadoDepreActiConstantesFunciones.refrescarForeignKeysDescripcionesEstadoDepreActi(estadodepreactis);
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
			this.getNewConnexionToDeep(EstadoDepreActi.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(estadodepreacti,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(EstadoDepreActi.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(estadodepreactis!=null) {
				for(EstadoDepreActi estadodepreacti:estadodepreactis) {
					this.deepSave(estadodepreacti,isDeep,deepLoadType,clases);
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
			if(estadodepreactis!=null) {
				for(EstadoDepreActi estadodepreacti:estadodepreactis) {
					this.deepSave(estadodepreacti,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getEstadoDepreActiPorCodigoWithConnection(String codigo)throws Exception {
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoDepreActi.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			ParameterSelectionGeneral parameterSelectionGeneralCodigo= new ParameterSelectionGeneral();
			parameterSelectionGeneralCodigo.setParameterSelectionGeneralEqual(ParameterType.STRING,codigo,EstadoDepreActiConstantesFunciones.CODIGO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralCodigo);

			estadodepreacti=estadodepreactiDataAccess.getEntity(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoad(this.estadodepreacti,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());

				EstadoDepreActiConstantesFunciones.refrescarForeignKeysDescripcionesEstadoDepreActi(this.estadodepreacti);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getEstadoDepreActiPorCodigo(String codigo)throws Exception {
		try {

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			ParameterSelectionGeneral parameterSelectionGeneralCodigo= new ParameterSelectionGeneral();
			parameterSelectionGeneralCodigo.setParameterSelectionGeneralEqual(ParameterType.STRING,codigo,EstadoDepreActiConstantesFunciones.CODIGO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralCodigo);

			estadodepreacti=estadodepreactiDataAccess.getEntity(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoad(this.estadodepreacti,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());

				EstadoDepreActiConstantesFunciones.refrescarForeignKeysDescripcionesEstadoDepreActi(this.estadodepreacti);
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
			if(EstadoDepreActiConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,EstadoDepreActiDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,EstadoDepreActi estadodepreacti,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(EstadoDepreActiConstantesFunciones.ISCONAUDITORIA) {
				if(estadodepreacti.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,EstadoDepreActiDataAccess.TABLENAME, estadodepreacti.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(EstadoDepreActiConstantesFunciones.ISCONAUDITORIADETALLE) {
						////EstadoDepreActiLogic.registrarAuditoriaDetallesEstadoDepreActi(connexion,estadodepreacti,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(estadodepreacti.getIsDeleted()) {
					/*if(!estadodepreacti.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,EstadoDepreActiDataAccess.TABLENAME, estadodepreacti.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////EstadoDepreActiLogic.registrarAuditoriaDetallesEstadoDepreActi(connexion,estadodepreacti,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,EstadoDepreActiDataAccess.TABLENAME, estadodepreacti.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(estadodepreacti.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,EstadoDepreActiDataAccess.TABLENAME, estadodepreacti.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(EstadoDepreActiConstantesFunciones.ISCONAUDITORIADETALLE) {
						////EstadoDepreActiLogic.registrarAuditoriaDetallesEstadoDepreActi(connexion,estadodepreacti,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesEstadoDepreActi(Connexion connexion,EstadoDepreActi estadodepreacti)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(estadodepreacti.getIsNew()||!estadodepreacti.getcodigo().equals(estadodepreacti.getEstadoDepreActiOriginal().getcodigo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(estadodepreacti.getEstadoDepreActiOriginal().getcodigo()!=null)
				{
					strValorActual=estadodepreacti.getEstadoDepreActiOriginal().getcodigo();
				}
				if(estadodepreacti.getcodigo()!=null)
				{
					strValorNuevo=estadodepreacti.getcodigo() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),EstadoDepreActiConstantesFunciones.CODIGO,strValorActual,strValorNuevo);
			}	
			
			if(estadodepreacti.getIsNew()||!estadodepreacti.getnombre().equals(estadodepreacti.getEstadoDepreActiOriginal().getnombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(estadodepreacti.getEstadoDepreActiOriginal().getnombre()!=null)
				{
					strValorActual=estadodepreacti.getEstadoDepreActiOriginal().getnombre();
				}
				if(estadodepreacti.getnombre()!=null)
				{
					strValorNuevo=estadodepreacti.getnombre() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),EstadoDepreActiConstantesFunciones.NOMBRE,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveEstadoDepreActiRelacionesWithConnection(EstadoDepreActi estadodepreacti,List<DepreciacionActivoFijo> depreciacionactivofijos) throws Exception {

		if(!estadodepreacti.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveEstadoDepreActiRelacionesBase(estadodepreacti,depreciacionactivofijos,true);
		}
	}

	public void saveEstadoDepreActiRelaciones(EstadoDepreActi estadodepreacti,List<DepreciacionActivoFijo> depreciacionactivofijos)throws Exception {

		if(!estadodepreacti.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveEstadoDepreActiRelacionesBase(estadodepreacti,depreciacionactivofijos,false);
		}
	}

	public void saveEstadoDepreActiRelacionesBase(EstadoDepreActi estadodepreacti,List<DepreciacionActivoFijo> depreciacionactivofijos,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("EstadoDepreActi-saveRelacionesWithConnection");}
	
			estadodepreacti.setDepreciacionActivoFijos(depreciacionactivofijos);

			this.setEstadoDepreActi(estadodepreacti);

				if((estadodepreacti.getIsNew()||estadodepreacti.getIsChanged())&&!estadodepreacti.getIsDeleted()) {
					this.saveEstadoDepreActi();
					this.saveEstadoDepreActiRelacionesDetalles(depreciacionactivofijos);

				} else if(estadodepreacti.getIsDeleted()) {
					this.saveEstadoDepreActiRelacionesDetalles(depreciacionactivofijos);
					this.saveEstadoDepreActi();
				}

			if(conConexion) {connexion.commit();}

		} catch(Exception e) {
			
			DepreciacionActivoFijoConstantesFunciones.InicializarGeneralEntityAuxiliaresDepreciacionActivoFijos(depreciacionactivofijos,true,true);

			if(conConexion){connexion.rollback();}
			Funciones.manageException(logger,e);
			throw e;

		} finally {
			if(conConexion){this.closeNewConnexionToDeep();}
		}
	}
	
	
	private void saveEstadoDepreActiRelacionesDetalles(List<DepreciacionActivoFijo> depreciacionactivofijos)throws Exception {
		try {
	

			Long idEstadoDepreActiActual=this.getEstadoDepreActi().getId();

			DepreciacionActivoFijoLogic depreciacionactivofijoLogic_Desde_EstadoDepreActi=new DepreciacionActivoFijoLogic();
			depreciacionactivofijoLogic_Desde_EstadoDepreActi.setDepreciacionActivoFijos(depreciacionactivofijos);

			depreciacionactivofijoLogic_Desde_EstadoDepreActi.setConnexion(this.getConnexion());
			depreciacionactivofijoLogic_Desde_EstadoDepreActi.setDatosCliente(this.datosCliente);

			for(DepreciacionActivoFijo depreciacionactivofijo_Desde_EstadoDepreActi:depreciacionactivofijoLogic_Desde_EstadoDepreActi.getDepreciacionActivoFijos()) {
				depreciacionactivofijo_Desde_EstadoDepreActi.setid_estado_depre_acti(idEstadoDepreActiActual);
			}

			depreciacionactivofijoLogic_Desde_EstadoDepreActi.saveDepreciacionActivoFijos();

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfEstadoDepreActi(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=EstadoDepreActiConstantesFunciones.getClassesForeignKeysOfEstadoDepreActi(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfEstadoDepreActi(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=EstadoDepreActiConstantesFunciones.getClassesRelationshipsOfEstadoDepreActi(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

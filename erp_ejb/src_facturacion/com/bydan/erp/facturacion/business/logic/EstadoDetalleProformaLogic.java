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
package com.bydan.erp.facturacion.business.logic;

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
import com.bydan.erp.facturacion.util.*;
import com.bydan.erp.facturacion.util.EstadoDetalleProformaConstantesFunciones;
import com.bydan.erp.facturacion.util.EstadoDetalleProformaParameterReturnGeneral;
//import com.bydan.erp.facturacion.util.EstadoDetalleProformaParameterGeneral;
import com.bydan.erp.facturacion.business.entity.EstadoDetalleProforma;
import com.bydan.erp.facturacion.business.logic.EstadoDetalleProformaLogicAdditional;
import com.bydan.erp.facturacion.business.dataaccess.*;
import com.bydan.erp.facturacion.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;
















@SuppressWarnings("unused")
public class EstadoDetalleProformaLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(EstadoDetalleProformaLogic.class);
	
	protected EstadoDetalleProformaDataAccess estadodetalleproformaDataAccess; 	
	protected EstadoDetalleProforma estadodetalleproforma;
	protected List<EstadoDetalleProforma> estadodetalleproformas;
	protected Object estadodetalleproformaObject;	
	protected List<Object> estadodetalleproformasObject;
	
	public static ClassValidator<EstadoDetalleProforma> estadodetalleproformaValidator = new ClassValidator<EstadoDetalleProforma>(EstadoDetalleProforma.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected EstadoDetalleProformaLogicAdditional estadodetalleproformaLogicAdditional=null;
	
	public EstadoDetalleProformaLogicAdditional getEstadoDetalleProformaLogicAdditional() {
		return this.estadodetalleproformaLogicAdditional;
	}
	
	public void setEstadoDetalleProformaLogicAdditional(EstadoDetalleProformaLogicAdditional estadodetalleproformaLogicAdditional) {
		try {
			this.estadodetalleproformaLogicAdditional=estadodetalleproformaLogicAdditional;
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
	
	
	
	
	public  EstadoDetalleProformaLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.estadodetalleproformaDataAccess = new EstadoDetalleProformaDataAccess();
			
			this.estadodetalleproformas= new ArrayList<EstadoDetalleProforma>();
			this.estadodetalleproforma= new EstadoDetalleProforma();
			
			this.estadodetalleproformaObject=new Object();
			this.estadodetalleproformasObject=new ArrayList<Object>();
				
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
			
			this.estadodetalleproformaDataAccess.setConnexionType(this.connexionType);
			this.estadodetalleproformaDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  EstadoDetalleProformaLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.estadodetalleproformaDataAccess = new EstadoDetalleProformaDataAccess();
			this.estadodetalleproformas= new ArrayList<EstadoDetalleProforma>();
			this.estadodetalleproforma= new EstadoDetalleProforma();
			this.estadodetalleproformaObject=new Object();
			this.estadodetalleproformasObject=new ArrayList<Object>();
			
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
			
			this.estadodetalleproformaDataAccess.setConnexionType(this.connexionType);
			this.estadodetalleproformaDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public EstadoDetalleProforma getEstadoDetalleProforma() throws Exception {	
		EstadoDetalleProformaLogicAdditional.checkEstadoDetalleProformaToGet(estadodetalleproforma,this.datosCliente,this.arrDatoGeneral);
		EstadoDetalleProformaLogicAdditional.updateEstadoDetalleProformaToGet(estadodetalleproforma,this.arrDatoGeneral);
		
		return estadodetalleproforma;
	}
		
	public void setEstadoDetalleProforma(EstadoDetalleProforma newEstadoDetalleProforma) {
		this.estadodetalleproforma = newEstadoDetalleProforma;
	}
	
	public EstadoDetalleProformaDataAccess getEstadoDetalleProformaDataAccess() {
		return estadodetalleproformaDataAccess;
	}
	
	public void setEstadoDetalleProformaDataAccess(EstadoDetalleProformaDataAccess newestadodetalleproformaDataAccess) {
		this.estadodetalleproformaDataAccess = newestadodetalleproformaDataAccess;
	}
	
	public List<EstadoDetalleProforma> getEstadoDetalleProformas() throws Exception {		
		this.quitarEstadoDetalleProformasNulos();
		
		EstadoDetalleProformaLogicAdditional.checkEstadoDetalleProformaToGets(estadodetalleproformas,this.datosCliente,this.arrDatoGeneral);
		
		for (EstadoDetalleProforma estadodetalleproformaLocal: estadodetalleproformas ) {
			EstadoDetalleProformaLogicAdditional.updateEstadoDetalleProformaToGet(estadodetalleproformaLocal,this.arrDatoGeneral);
		}
		
		return estadodetalleproformas;
	}
	
	public void setEstadoDetalleProformas(List<EstadoDetalleProforma> newEstadoDetalleProformas) {
		this.estadodetalleproformas = newEstadoDetalleProformas;
	}
	
	public Object getEstadoDetalleProformaObject() {	
		this.estadodetalleproformaObject=this.estadodetalleproformaDataAccess.getEntityObject();
		return this.estadodetalleproformaObject;
	}
		
	public void setEstadoDetalleProformaObject(Object newEstadoDetalleProformaObject) {
		this.estadodetalleproformaObject = newEstadoDetalleProformaObject;
	}
	
	public List<Object> getEstadoDetalleProformasObject() {		
		this.estadodetalleproformasObject=this.estadodetalleproformaDataAccess.getEntitiesObject();
		return this.estadodetalleproformasObject;
	}
		
	public void setEstadoDetalleProformasObject(List<Object> newEstadoDetalleProformasObject) {
		this.estadodetalleproformasObject = newEstadoDetalleProformasObject;
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
		
		if(this.estadodetalleproformaDataAccess!=null) {
			this.estadodetalleproformaDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoDetalleProforma.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			estadodetalleproformaDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			estadodetalleproformaDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		estadodetalleproforma = new  EstadoDetalleProforma();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoDetalleProforma.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			estadodetalleproforma=estadodetalleproformaDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.estadodetalleproforma,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				EstadoDetalleProformaConstantesFunciones.refrescarForeignKeysDescripcionesEstadoDetalleProforma(this.estadodetalleproforma);
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
		estadodetalleproforma = new  EstadoDetalleProforma();
		  		  
        try {
			
			estadodetalleproforma=estadodetalleproformaDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.estadodetalleproforma,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				EstadoDetalleProformaConstantesFunciones.refrescarForeignKeysDescripcionesEstadoDetalleProforma(this.estadodetalleproforma);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		estadodetalleproforma = new  EstadoDetalleProforma();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoDetalleProforma.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			estadodetalleproforma=estadodetalleproformaDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.estadodetalleproforma,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				EstadoDetalleProformaConstantesFunciones.refrescarForeignKeysDescripcionesEstadoDetalleProforma(this.estadodetalleproforma);
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
		estadodetalleproforma = new  EstadoDetalleProforma();
		  		  
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
		estadodetalleproforma = new  EstadoDetalleProforma();
		  		  
        try {
			
			estadodetalleproforma=estadodetalleproformaDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.estadodetalleproforma,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				EstadoDetalleProformaConstantesFunciones.refrescarForeignKeysDescripcionesEstadoDetalleProforma(this.estadodetalleproforma);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		estadodetalleproforma = new  EstadoDetalleProforma();
		  		  
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
		estadodetalleproforma = new  EstadoDetalleProforma();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoDetalleProforma.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =estadodetalleproformaDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		estadodetalleproforma = new  EstadoDetalleProforma();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=estadodetalleproformaDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		estadodetalleproforma = new  EstadoDetalleProforma();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoDetalleProforma.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =estadodetalleproformaDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		estadodetalleproforma = new  EstadoDetalleProforma();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=estadodetalleproformaDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		estadodetalleproforma = new  EstadoDetalleProforma();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoDetalleProforma.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =estadodetalleproformaDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		estadodetalleproforma = new  EstadoDetalleProforma();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=estadodetalleproformaDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		estadodetalleproformas = new  ArrayList<EstadoDetalleProforma>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoDetalleProforma.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			EstadoDetalleProformaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadodetalleproformas=estadodetalleproformaDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarEstadoDetalleProforma(estadodetalleproformas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoDetalleProformaConstantesFunciones.refrescarForeignKeysDescripcionesEstadoDetalleProforma(this.estadodetalleproformas);
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
		estadodetalleproformas = new  ArrayList<EstadoDetalleProforma>();
		  		  
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
		estadodetalleproformas = new  ArrayList<EstadoDetalleProforma>();
		  		  
        try {			
			EstadoDetalleProformaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadodetalleproformas=estadodetalleproformaDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarEstadoDetalleProforma(estadodetalleproformas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoDetalleProformaConstantesFunciones.refrescarForeignKeysDescripcionesEstadoDetalleProforma(this.estadodetalleproformas);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		estadodetalleproformas = new  ArrayList<EstadoDetalleProforma>();
		  		  
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
		estadodetalleproformas = new  ArrayList<EstadoDetalleProforma>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoDetalleProforma.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			EstadoDetalleProformaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadodetalleproformas=estadodetalleproformaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarEstadoDetalleProforma(estadodetalleproformas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoDetalleProformaConstantesFunciones.refrescarForeignKeysDescripcionesEstadoDetalleProforma(this.estadodetalleproformas);
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
		estadodetalleproformas = new  ArrayList<EstadoDetalleProforma>();
		  		  
        try {
			EstadoDetalleProformaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadodetalleproformas=estadodetalleproformaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarEstadoDetalleProforma(estadodetalleproformas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoDetalleProformaConstantesFunciones.refrescarForeignKeysDescripcionesEstadoDetalleProforma(this.estadodetalleproformas);
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
		estadodetalleproformas = new  ArrayList<EstadoDetalleProforma>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoDetalleProforma.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EstadoDetalleProformaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadodetalleproformas=estadodetalleproformaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarEstadoDetalleProforma(estadodetalleproformas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoDetalleProformaConstantesFunciones.refrescarForeignKeysDescripcionesEstadoDetalleProforma(this.estadodetalleproformas);
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
		estadodetalleproformas = new  ArrayList<EstadoDetalleProforma>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EstadoDetalleProformaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadodetalleproformas=estadodetalleproformaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarEstadoDetalleProforma(estadodetalleproformas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoDetalleProformaConstantesFunciones.refrescarForeignKeysDescripcionesEstadoDetalleProforma(this.estadodetalleproformas);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		estadodetalleproforma = new  EstadoDetalleProforma();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoDetalleProforma.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EstadoDetalleProformaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadodetalleproforma=estadodetalleproformaDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarEstadoDetalleProforma(estadodetalleproforma);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoDetalleProformaConstantesFunciones.refrescarForeignKeysDescripcionesEstadoDetalleProforma(this.estadodetalleproforma);
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
		estadodetalleproforma = new  EstadoDetalleProforma();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EstadoDetalleProformaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadodetalleproforma=estadodetalleproformaDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarEstadoDetalleProforma(estadodetalleproforma);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoDetalleProformaConstantesFunciones.refrescarForeignKeysDescripcionesEstadoDetalleProforma(this.estadodetalleproforma);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		estadodetalleproformas = new  ArrayList<EstadoDetalleProforma>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoDetalleProforma.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			EstadoDetalleProformaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadodetalleproformas=estadodetalleproformaDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarEstadoDetalleProforma(estadodetalleproformas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoDetalleProformaConstantesFunciones.refrescarForeignKeysDescripcionesEstadoDetalleProforma(this.estadodetalleproformas);
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
		estadodetalleproformas = new  ArrayList<EstadoDetalleProforma>();
		  		  
        try {
			EstadoDetalleProformaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadodetalleproformas=estadodetalleproformaDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarEstadoDetalleProforma(estadodetalleproformas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoDetalleProformaConstantesFunciones.refrescarForeignKeysDescripcionesEstadoDetalleProforma(this.estadodetalleproformas);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosEstadoDetalleProformasWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		estadodetalleproformas = new  ArrayList<EstadoDetalleProforma>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoDetalleProforma.class.getSimpleName()+"-getTodosEstadoDetalleProformasWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EstadoDetalleProformaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadodetalleproformas=estadodetalleproformaDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarEstadoDetalleProforma(estadodetalleproformas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoDetalleProformaConstantesFunciones.refrescarForeignKeysDescripcionesEstadoDetalleProforma(this.estadodetalleproformas);
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
	
	public  void  getTodosEstadoDetalleProformas(String sFinalQuery,Pagination pagination)throws Exception {
		estadodetalleproformas = new  ArrayList<EstadoDetalleProforma>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EstadoDetalleProformaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadodetalleproformas=estadodetalleproformaDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarEstadoDetalleProforma(estadodetalleproformas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoDetalleProformaConstantesFunciones.refrescarForeignKeysDescripcionesEstadoDetalleProforma(this.estadodetalleproformas);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarEstadoDetalleProforma(EstadoDetalleProforma estadodetalleproforma) throws Exception {
		Boolean estaValidado=false;
		
		if(estadodetalleproforma.getIsNew() || estadodetalleproforma.getIsChanged()) { 
			this.invalidValues = estadodetalleproformaValidator.getInvalidValues(estadodetalleproforma);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(estadodetalleproforma);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarEstadoDetalleProforma(List<EstadoDetalleProforma> EstadoDetalleProformas) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(EstadoDetalleProforma estadodetalleproformaLocal:estadodetalleproformas) {				
			estaValidadoObjeto=this.validarGuardarEstadoDetalleProforma(estadodetalleproformaLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarEstadoDetalleProforma(List<EstadoDetalleProforma> EstadoDetalleProformas) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarEstadoDetalleProforma(estadodetalleproformas)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarEstadoDetalleProforma(EstadoDetalleProforma EstadoDetalleProforma) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarEstadoDetalleProforma(estadodetalleproforma)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(EstadoDetalleProforma estadodetalleproforma) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+estadodetalleproforma.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=EstadoDetalleProformaConstantesFunciones.getEstadoDetalleProformaLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"estadodetalleproforma","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(EstadoDetalleProformaConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(EstadoDetalleProformaConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveEstadoDetalleProformaWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoDetalleProforma.class.getSimpleName()+"-saveEstadoDetalleProformaWithConnection");connexion.begin();			
			
			EstadoDetalleProformaLogicAdditional.checkEstadoDetalleProformaToSave(this.estadodetalleproforma,this.datosCliente,connexion,this.arrDatoGeneral);
			
			EstadoDetalleProformaLogicAdditional.updateEstadoDetalleProformaToSave(this.estadodetalleproforma,this.arrDatoGeneral);
			
			EstadoDetalleProformaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.estadodetalleproforma,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowEstadoDetalleProforma();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarEstadoDetalleProforma(this.estadodetalleproforma)) {
				EstadoDetalleProformaDataAccess.save(this.estadodetalleproforma, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.estadodetalleproforma,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			EstadoDetalleProformaLogicAdditional.checkEstadoDetalleProformaToSaveAfter(this.estadodetalleproforma,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowEstadoDetalleProforma();
			
			connexion.commit();			
			
			if(this.estadodetalleproforma.getIsDeleted()) {
				this.estadodetalleproforma=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveEstadoDetalleProforma()throws Exception {	
		try {	
			
			EstadoDetalleProformaLogicAdditional.checkEstadoDetalleProformaToSave(this.estadodetalleproforma,this.datosCliente,connexion,this.arrDatoGeneral);
			
			EstadoDetalleProformaLogicAdditional.updateEstadoDetalleProformaToSave(this.estadodetalleproforma,this.arrDatoGeneral);
			
			EstadoDetalleProformaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.estadodetalleproforma,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarEstadoDetalleProforma(this.estadodetalleproforma)) {			
				EstadoDetalleProformaDataAccess.save(this.estadodetalleproforma, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.estadodetalleproforma,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			EstadoDetalleProformaLogicAdditional.checkEstadoDetalleProformaToSaveAfter(this.estadodetalleproforma,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.estadodetalleproforma.getIsDeleted()) {
				this.estadodetalleproforma=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveEstadoDetalleProformasWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoDetalleProforma.class.getSimpleName()+"-saveEstadoDetalleProformasWithConnection");connexion.begin();			
			
			EstadoDetalleProformaLogicAdditional.checkEstadoDetalleProformaToSaves(estadodetalleproformas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowEstadoDetalleProformas();
			
			Boolean validadoTodosEstadoDetalleProforma=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(EstadoDetalleProforma estadodetalleproformaLocal:estadodetalleproformas) {		
				if(estadodetalleproformaLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				EstadoDetalleProformaLogicAdditional.updateEstadoDetalleProformaToSave(estadodetalleproformaLocal,this.arrDatoGeneral);
	        	
				EstadoDetalleProformaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),estadodetalleproformaLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarEstadoDetalleProforma(estadodetalleproformaLocal)) {
					EstadoDetalleProformaDataAccess.save(estadodetalleproformaLocal, connexion);				
				} else {
					validadoTodosEstadoDetalleProforma=false;
				}
			}
			
			if(!validadoTodosEstadoDetalleProforma) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			EstadoDetalleProformaLogicAdditional.checkEstadoDetalleProformaToSavesAfter(estadodetalleproformas,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowEstadoDetalleProformas();
			
			connexion.commit();		
			
			this.quitarEstadoDetalleProformasEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveEstadoDetalleProformas()throws Exception {				
		 try {	
			EstadoDetalleProformaLogicAdditional.checkEstadoDetalleProformaToSaves(estadodetalleproformas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosEstadoDetalleProforma=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(EstadoDetalleProforma estadodetalleproformaLocal:estadodetalleproformas) {				
				if(estadodetalleproformaLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				EstadoDetalleProformaLogicAdditional.updateEstadoDetalleProformaToSave(estadodetalleproformaLocal,this.arrDatoGeneral);
	        	
				EstadoDetalleProformaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),estadodetalleproformaLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarEstadoDetalleProforma(estadodetalleproformaLocal)) {				
					EstadoDetalleProformaDataAccess.save(estadodetalleproformaLocal, connexion);				
				} else {
					validadoTodosEstadoDetalleProforma=false;
				}
			}
			
			if(!validadoTodosEstadoDetalleProforma) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			EstadoDetalleProformaLogicAdditional.checkEstadoDetalleProformaToSavesAfter(estadodetalleproformas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarEstadoDetalleProformasEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public EstadoDetalleProformaParameterReturnGeneral procesarAccionEstadoDetalleProformas(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<EstadoDetalleProforma> estadodetalleproformas,EstadoDetalleProformaParameterReturnGeneral estadodetalleproformaParameterGeneral)throws Exception {
		 try {	
			EstadoDetalleProformaParameterReturnGeneral estadodetalleproformaReturnGeneral=new EstadoDetalleProformaParameterReturnGeneral();
	
			EstadoDetalleProformaLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,estadodetalleproformas,estadodetalleproformaParameterGeneral,estadodetalleproformaReturnGeneral);
			
			return estadodetalleproformaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public EstadoDetalleProformaParameterReturnGeneral procesarAccionEstadoDetalleProformasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<EstadoDetalleProforma> estadodetalleproformas,EstadoDetalleProformaParameterReturnGeneral estadodetalleproformaParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoDetalleProforma.class.getSimpleName()+"-procesarAccionEstadoDetalleProformasWithConnection");connexion.begin();			
			
			EstadoDetalleProformaParameterReturnGeneral estadodetalleproformaReturnGeneral=new EstadoDetalleProformaParameterReturnGeneral();
	
			EstadoDetalleProformaLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,estadodetalleproformas,estadodetalleproformaParameterGeneral,estadodetalleproformaReturnGeneral);
			
			this.connexion.commit();
			
			return estadodetalleproformaReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public EstadoDetalleProformaParameterReturnGeneral procesarEventosEstadoDetalleProformas(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<EstadoDetalleProforma> estadodetalleproformas,EstadoDetalleProforma estadodetalleproforma,EstadoDetalleProformaParameterReturnGeneral estadodetalleproformaParameterGeneral,Boolean isEsNuevoEstadoDetalleProforma,ArrayList<Classe> clases)throws Exception {
		 try {	
			EstadoDetalleProformaParameterReturnGeneral estadodetalleproformaReturnGeneral=new EstadoDetalleProformaParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				estadodetalleproformaReturnGeneral.setConRecargarPropiedades(true);
			}
			
			EstadoDetalleProformaLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,estadodetalleproformas,estadodetalleproforma,estadodetalleproformaParameterGeneral,estadodetalleproformaReturnGeneral,isEsNuevoEstadoDetalleProforma,clases);
			
			return estadodetalleproformaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public EstadoDetalleProformaParameterReturnGeneral procesarEventosEstadoDetalleProformasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<EstadoDetalleProforma> estadodetalleproformas,EstadoDetalleProforma estadodetalleproforma,EstadoDetalleProformaParameterReturnGeneral estadodetalleproformaParameterGeneral,Boolean isEsNuevoEstadoDetalleProforma,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoDetalleProforma.class.getSimpleName()+"-procesarEventosEstadoDetalleProformasWithConnection");connexion.begin();			
			
			EstadoDetalleProformaParameterReturnGeneral estadodetalleproformaReturnGeneral=new EstadoDetalleProformaParameterReturnGeneral();
	
			estadodetalleproformaReturnGeneral.setEstadoDetalleProforma(estadodetalleproforma);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				estadodetalleproformaReturnGeneral.setConRecargarPropiedades(true);
			}
			
			EstadoDetalleProformaLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,estadodetalleproformas,estadodetalleproforma,estadodetalleproformaParameterGeneral,estadodetalleproformaReturnGeneral,isEsNuevoEstadoDetalleProforma,clases);
			
			this.connexion.commit();
			
			return estadodetalleproformaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public EstadoDetalleProformaParameterReturnGeneral procesarImportacionEstadoDetalleProformasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,EstadoDetalleProformaParameterReturnGeneral estadodetalleproformaParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoDetalleProforma.class.getSimpleName()+"-procesarImportacionEstadoDetalleProformasWithConnection");connexion.begin();			
			
			EstadoDetalleProformaParameterReturnGeneral estadodetalleproformaReturnGeneral=new EstadoDetalleProformaParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.estadodetalleproformas=new ArrayList<EstadoDetalleProforma>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.estadodetalleproforma=new EstadoDetalleProforma();
				
				
				if(conColumnasBase) {this.estadodetalleproforma.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.estadodetalleproforma.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.estadodetalleproforma.setcodigo(arrColumnas[iColumn++]);
				this.estadodetalleproforma.setnombre(arrColumnas[iColumn++]);
				
				this.estadodetalleproformas.add(this.estadodetalleproforma);
			}
			
			this.saveEstadoDetalleProformas();
			
			this.connexion.commit();
			
			estadodetalleproformaReturnGeneral.setConRetornoEstaProcesado(true);
			estadodetalleproformaReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return estadodetalleproformaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarEstadoDetalleProformasEliminados() throws Exception {				
		
		List<EstadoDetalleProforma> estadodetalleproformasAux= new ArrayList<EstadoDetalleProforma>();
		
		for(EstadoDetalleProforma estadodetalleproforma:estadodetalleproformas) {
			if(!estadodetalleproforma.getIsDeleted()) {
				estadodetalleproformasAux.add(estadodetalleproforma);
			}
		}
		
		estadodetalleproformas=estadodetalleproformasAux;
	}
	
	public void quitarEstadoDetalleProformasNulos() throws Exception {				
		
		List<EstadoDetalleProforma> estadodetalleproformasAux= new ArrayList<EstadoDetalleProforma>();
		
		for(EstadoDetalleProforma estadodetalleproforma : this.estadodetalleproformas) {
			if(estadodetalleproforma==null) {
				estadodetalleproformasAux.add(estadodetalleproforma);
			}
		}
		
		//this.estadodetalleproformas=estadodetalleproformasAux;
		
		this.estadodetalleproformas.removeAll(estadodetalleproformasAux);
	}
	
	public void getSetVersionRowEstadoDetalleProformaWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(estadodetalleproforma.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((estadodetalleproforma.getIsDeleted() || (estadodetalleproforma.getIsChanged()&&!estadodetalleproforma.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=estadodetalleproformaDataAccess.getSetVersionRowEstadoDetalleProforma(connexion,estadodetalleproforma.getId());
				
				if(!estadodetalleproforma.getVersionRow().equals(timestamp)) {	
					estadodetalleproforma.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				estadodetalleproforma.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowEstadoDetalleProforma()throws Exception {	
		
		if(estadodetalleproforma.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((estadodetalleproforma.getIsDeleted() || (estadodetalleproforma.getIsChanged()&&!estadodetalleproforma.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=estadodetalleproformaDataAccess.getSetVersionRowEstadoDetalleProforma(connexion,estadodetalleproforma.getId());
			
			try {							
				if(!estadodetalleproforma.getVersionRow().equals(timestamp)) {	
					estadodetalleproforma.setVersionRow(timestamp);
				}
				
				estadodetalleproforma.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowEstadoDetalleProformasWithConnection()throws Exception {	
		if(estadodetalleproformas!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(EstadoDetalleProforma estadodetalleproformaAux:estadodetalleproformas) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(estadodetalleproformaAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(estadodetalleproformaAux.getIsDeleted() || (estadodetalleproformaAux.getIsChanged()&&!estadodetalleproformaAux.getIsNew())) {
						
						timestamp=estadodetalleproformaDataAccess.getSetVersionRowEstadoDetalleProforma(connexion,estadodetalleproformaAux.getId());
						
						if(!estadodetalleproforma.getVersionRow().equals(timestamp)) {	
							estadodetalleproformaAux.setVersionRow(timestamp);
						}
								
						estadodetalleproformaAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowEstadoDetalleProformas()throws Exception {	
		if(estadodetalleproformas!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(EstadoDetalleProforma estadodetalleproformaAux:estadodetalleproformas) {
					if(estadodetalleproformaAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(estadodetalleproformaAux.getIsDeleted() || (estadodetalleproformaAux.getIsChanged()&&!estadodetalleproformaAux.getIsNew())) {
						
						timestamp=estadodetalleproformaDataAccess.getSetVersionRowEstadoDetalleProforma(connexion,estadodetalleproformaAux.getId());
						
						if(!estadodetalleproformaAux.getVersionRow().equals(timestamp)) {	
							estadodetalleproformaAux.setVersionRow(timestamp);
						}
						
													
						estadodetalleproformaAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	
	public void cargarRelacionesLoteForeignKeyEstadoDetalleProformaWithConnection() throws Exception {
		ArrayList<Classe> classes=new ArrayList<Classe>();		
		
		
			DetalleProformaLogic detalleproformaLogic=new DetalleProformaLogic();
		
		try {
			
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoDetalleProforma.class.getSimpleName()+"-cargarRelacionesLoteForeignKeyEstadoDetalleProformaWithConnection");connexion.begin();
			
			
			classes.add(new Classe(DetalleProforma.class));
											
			

			detalleproformaLogic.setConnexion(this.getConnexion());
			detalleproformaLogic.setDatosCliente(this.datosCliente);
			detalleproformaLogic.setIsConRefrescarForeignKeys(true);
			
			this.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
			
			for(EstadoDetalleProforma estadodetalleproforma:this.estadodetalleproformas) {
				

				classes=new ArrayList<Classe>();
				classes=DetalleProformaConstantesFunciones.getClassesForeignKeysOfDetalleProforma(new ArrayList<Classe>(),DeepLoadType.NONE);

				detalleproformaLogic.setDetalleProformas(estadodetalleproforma.detalleproformas);
				detalleproformaLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
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
	
	public void deepLoad(EstadoDetalleProforma estadodetalleproforma,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			EstadoDetalleProformaLogicAdditional.updateEstadoDetalleProformaToGet(estadodetalleproforma,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		estadodetalleproforma.setDetalleProformas(estadodetalleproformaDataAccess.getDetalleProformas(connexion,estadodetalleproforma));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(DetalleProforma.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				estadodetalleproforma.setDetalleProformas(estadodetalleproformaDataAccess.getDetalleProformas(connexion,estadodetalleproforma));

				if(this.isConDeep) {
					DetalleProformaLogic detalleproformaLogic= new DetalleProformaLogic(this.connexion);
					detalleproformaLogic.setDetalleProformas(estadodetalleproforma.getDetalleProformas());
					ArrayList<Classe> classesLocal=DetalleProformaConstantesFunciones.getClassesForeignKeysOfDetalleProforma(new ArrayList<Classe>(),DeepLoadType.NONE);
					detalleproformaLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					DetalleProformaConstantesFunciones.refrescarForeignKeysDescripcionesDetalleProforma(detalleproformaLogic.getDetalleProformas());
					estadodetalleproforma.setDetalleProformas(detalleproformaLogic.getDetalleProformas());
				}

				continue;
			}
		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {


		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(DetalleProforma.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(DetalleProforma.class));
			estadodetalleproforma.setDetalleProformas(estadodetalleproformaDataAccess.getDetalleProformas(connexion,estadodetalleproforma));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {


		estadodetalleproforma.setDetalleProformas(estadodetalleproformaDataAccess.getDetalleProformas(connexion,estadodetalleproforma));

		for(DetalleProforma detalleproforma:estadodetalleproforma.getDetalleProformas()) {
			DetalleProformaLogic detalleproformaLogic= new DetalleProformaLogic(connexion);
			detalleproformaLogic.deepLoad(detalleproforma,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(DetalleProforma.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				estadodetalleproforma.setDetalleProformas(estadodetalleproformaDataAccess.getDetalleProformas(connexion,estadodetalleproforma));

				for(DetalleProforma detalleproforma:estadodetalleproforma.getDetalleProformas()) {
					DetalleProformaLogic detalleproformaLogic= new DetalleProformaLogic(connexion);
					detalleproformaLogic.deepLoad(detalleproforma,isDeep,deepLoadType,clases);
				}
				continue;
			}

		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {


		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(DetalleProforma.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(DetalleProforma.class));
			estadodetalleproforma.setDetalleProformas(estadodetalleproformaDataAccess.getDetalleProformas(connexion,estadodetalleproforma));

			for(DetalleProforma detalleproforma:estadodetalleproforma.getDetalleProformas()) {
				DetalleProformaLogic detalleproformaLogic= new DetalleProformaLogic(connexion);
				detalleproformaLogic.deepLoad(detalleproforma,isDeep,deepLoadType,clases);
			}
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(EstadoDetalleProforma estadodetalleproforma,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			EstadoDetalleProformaLogicAdditional.updateEstadoDetalleProformaToSave(estadodetalleproforma,this.arrDatoGeneral);
			
EstadoDetalleProformaDataAccess.save(estadodetalleproforma, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		for(DetalleProforma detalleproforma:estadodetalleproforma.getDetalleProformas()) {
			detalleproforma.setid_estado_detalle_proforma(estadodetalleproforma.getId());
			DetalleProformaDataAccess.save(detalleproforma,connexion);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {

			if(clas.clas.equals(DetalleProforma.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(DetalleProforma detalleproforma:estadodetalleproforma.getDetalleProformas()) {
					detalleproforma.setid_estado_detalle_proforma(estadodetalleproforma.getId());
					DetalleProformaDataAccess.save(detalleproforma,connexion);
				}
				continue;
			}
		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		for(DetalleProforma detalleproforma:estadodetalleproforma.getDetalleProformas()) {
			DetalleProformaLogic detalleproformaLogic= new DetalleProformaLogic(connexion);
			detalleproforma.setid_estado_detalle_proforma(estadodetalleproforma.getId());
			DetalleProformaDataAccess.save(detalleproforma,connexion);
			detalleproformaLogic.deepSave(detalleproforma,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {

			if(clas.clas.equals(DetalleProforma.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(DetalleProforma detalleproforma:estadodetalleproforma.getDetalleProformas()) {
					DetalleProformaLogic detalleproformaLogic= new DetalleProformaLogic(connexion);
					detalleproforma.setid_estado_detalle_proforma(estadodetalleproforma.getId());
					DetalleProformaDataAccess.save(detalleproforma,connexion);
					detalleproformaLogic.deepSave(detalleproforma,isDeep,deepLoadType,clases);
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
			this.getNewConnexionToDeep(EstadoDetalleProforma.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(estadodetalleproforma,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				EstadoDetalleProformaConstantesFunciones.refrescarForeignKeysDescripcionesEstadoDetalleProforma(estadodetalleproforma);
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
			this.deepLoad(this.estadodetalleproforma,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				EstadoDetalleProformaConstantesFunciones.refrescarForeignKeysDescripcionesEstadoDetalleProforma(this.estadodetalleproforma);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(EstadoDetalleProforma.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(estadodetalleproformas!=null) {
				for(EstadoDetalleProforma estadodetalleproforma:estadodetalleproformas) {
					this.deepLoad(estadodetalleproforma,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					EstadoDetalleProformaConstantesFunciones.refrescarForeignKeysDescripcionesEstadoDetalleProforma(estadodetalleproformas);
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
			if(estadodetalleproformas!=null) {
				for(EstadoDetalleProforma estadodetalleproforma:estadodetalleproformas) {
					this.deepLoad(estadodetalleproforma,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					EstadoDetalleProformaConstantesFunciones.refrescarForeignKeysDescripcionesEstadoDetalleProforma(estadodetalleproformas);
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
			this.getNewConnexionToDeep(EstadoDetalleProforma.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(estadodetalleproforma,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(EstadoDetalleProforma.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(estadodetalleproformas!=null) {
				for(EstadoDetalleProforma estadodetalleproforma:estadodetalleproformas) {
					this.deepSave(estadodetalleproforma,isDeep,deepLoadType,clases);
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
			if(estadodetalleproformas!=null) {
				for(EstadoDetalleProforma estadodetalleproforma:estadodetalleproformas) {
					this.deepSave(estadodetalleproforma,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getEstadoDetalleProformaPorCodigoWithConnection(String codigo)throws Exception {
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoDetalleProforma.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			ParameterSelectionGeneral parameterSelectionGeneralCodigo= new ParameterSelectionGeneral();
			parameterSelectionGeneralCodigo.setParameterSelectionGeneralEqual(ParameterType.STRING,codigo,EstadoDetalleProformaConstantesFunciones.CODIGO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralCodigo);

			estadodetalleproforma=estadodetalleproformaDataAccess.getEntity(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoad(this.estadodetalleproforma,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());

				EstadoDetalleProformaConstantesFunciones.refrescarForeignKeysDescripcionesEstadoDetalleProforma(this.estadodetalleproforma);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getEstadoDetalleProformaPorCodigo(String codigo)throws Exception {
		try {

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			ParameterSelectionGeneral parameterSelectionGeneralCodigo= new ParameterSelectionGeneral();
			parameterSelectionGeneralCodigo.setParameterSelectionGeneralEqual(ParameterType.STRING,codigo,EstadoDetalleProformaConstantesFunciones.CODIGO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralCodigo);

			estadodetalleproforma=estadodetalleproformaDataAccess.getEntity(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoad(this.estadodetalleproforma,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());

				EstadoDetalleProformaConstantesFunciones.refrescarForeignKeysDescripcionesEstadoDetalleProforma(this.estadodetalleproforma);
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
			if(EstadoDetalleProformaConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,EstadoDetalleProformaDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,EstadoDetalleProforma estadodetalleproforma,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(EstadoDetalleProformaConstantesFunciones.ISCONAUDITORIA) {
				if(estadodetalleproforma.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,EstadoDetalleProformaDataAccess.TABLENAME, estadodetalleproforma.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(EstadoDetalleProformaConstantesFunciones.ISCONAUDITORIADETALLE) {
						////EstadoDetalleProformaLogic.registrarAuditoriaDetallesEstadoDetalleProforma(connexion,estadodetalleproforma,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(estadodetalleproforma.getIsDeleted()) {
					/*if(!estadodetalleproforma.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,EstadoDetalleProformaDataAccess.TABLENAME, estadodetalleproforma.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////EstadoDetalleProformaLogic.registrarAuditoriaDetallesEstadoDetalleProforma(connexion,estadodetalleproforma,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,EstadoDetalleProformaDataAccess.TABLENAME, estadodetalleproforma.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(estadodetalleproforma.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,EstadoDetalleProformaDataAccess.TABLENAME, estadodetalleproforma.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(EstadoDetalleProformaConstantesFunciones.ISCONAUDITORIADETALLE) {
						////EstadoDetalleProformaLogic.registrarAuditoriaDetallesEstadoDetalleProforma(connexion,estadodetalleproforma,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesEstadoDetalleProforma(Connexion connexion,EstadoDetalleProforma estadodetalleproforma)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(estadodetalleproforma.getIsNew()||!estadodetalleproforma.getcodigo().equals(estadodetalleproforma.getEstadoDetalleProformaOriginal().getcodigo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(estadodetalleproforma.getEstadoDetalleProformaOriginal().getcodigo()!=null)
				{
					strValorActual=estadodetalleproforma.getEstadoDetalleProformaOriginal().getcodigo();
				}
				if(estadodetalleproforma.getcodigo()!=null)
				{
					strValorNuevo=estadodetalleproforma.getcodigo() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),EstadoDetalleProformaConstantesFunciones.CODIGO,strValorActual,strValorNuevo);
			}	
			
			if(estadodetalleproforma.getIsNew()||!estadodetalleproforma.getnombre().equals(estadodetalleproforma.getEstadoDetalleProformaOriginal().getnombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(estadodetalleproforma.getEstadoDetalleProformaOriginal().getnombre()!=null)
				{
					strValorActual=estadodetalleproforma.getEstadoDetalleProformaOriginal().getnombre();
				}
				if(estadodetalleproforma.getnombre()!=null)
				{
					strValorNuevo=estadodetalleproforma.getnombre() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),EstadoDetalleProformaConstantesFunciones.NOMBRE,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveEstadoDetalleProformaRelacionesWithConnection(EstadoDetalleProforma estadodetalleproforma,List<DetalleProforma> detalleproformas) throws Exception {

		if(!estadodetalleproforma.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveEstadoDetalleProformaRelacionesBase(estadodetalleproforma,detalleproformas,true);
		}
	}

	public void saveEstadoDetalleProformaRelaciones(EstadoDetalleProforma estadodetalleproforma,List<DetalleProforma> detalleproformas)throws Exception {

		if(!estadodetalleproforma.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveEstadoDetalleProformaRelacionesBase(estadodetalleproforma,detalleproformas,false);
		}
	}

	public void saveEstadoDetalleProformaRelacionesBase(EstadoDetalleProforma estadodetalleproforma,List<DetalleProforma> detalleproformas,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("EstadoDetalleProforma-saveRelacionesWithConnection");}
	
			estadodetalleproforma.setDetalleProformas(detalleproformas);

			this.setEstadoDetalleProforma(estadodetalleproforma);

			if(EstadoDetalleProformaLogicAdditional.validarSaveRelaciones(estadodetalleproforma,this)) {

				EstadoDetalleProformaLogicAdditional.updateRelacionesToSave(estadodetalleproforma,this);

				if((estadodetalleproforma.getIsNew()||estadodetalleproforma.getIsChanged())&&!estadodetalleproforma.getIsDeleted()) {
					this.saveEstadoDetalleProforma();
					this.saveEstadoDetalleProformaRelacionesDetalles(detalleproformas);

				} else if(estadodetalleproforma.getIsDeleted()) {
					this.saveEstadoDetalleProformaRelacionesDetalles(detalleproformas);
					this.saveEstadoDetalleProforma();
				}

				EstadoDetalleProformaLogicAdditional.updateRelacionesToSaveAfter(estadodetalleproforma,this);

			} else {
				throw new Exception("LOS DATOS SON INVALIDOS");
			}

			if(conConexion) {connexion.commit();}

		} catch(Exception e) {
			
			DetalleProformaConstantesFunciones.InicializarGeneralEntityAuxiliaresDetalleProformas(detalleproformas,true,true);

			if(conConexion){connexion.rollback();}
			Funciones.manageException(logger,e);
			throw e;

		} finally {
			if(conConexion){this.closeNewConnexionToDeep();}
		}
	}
	
	
	private void saveEstadoDetalleProformaRelacionesDetalles(List<DetalleProforma> detalleproformas)throws Exception {
		try {
	

			Long idEstadoDetalleProformaActual=this.getEstadoDetalleProforma().getId();

			DetalleProformaLogic detalleproformaLogic_Desde_EstadoDetalleProforma=new DetalleProformaLogic();
			detalleproformaLogic_Desde_EstadoDetalleProforma.setDetalleProformas(detalleproformas);

			detalleproformaLogic_Desde_EstadoDetalleProforma.setConnexion(this.getConnexion());
			detalleproformaLogic_Desde_EstadoDetalleProforma.setDatosCliente(this.datosCliente);

			for(DetalleProforma detalleproforma_Desde_EstadoDetalleProforma:detalleproformaLogic_Desde_EstadoDetalleProforma.getDetalleProformas()) {
				detalleproforma_Desde_EstadoDetalleProforma.setid_estado_detalle_proforma(idEstadoDetalleProformaActual);
			}

			detalleproformaLogic_Desde_EstadoDetalleProforma.saveDetalleProformas();

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfEstadoDetalleProforma(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=EstadoDetalleProformaConstantesFunciones.getClassesForeignKeysOfEstadoDetalleProforma(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfEstadoDetalleProforma(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=EstadoDetalleProformaConstantesFunciones.getClassesRelationshipsOfEstadoDetalleProforma(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

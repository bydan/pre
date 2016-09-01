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
import com.bydan.erp.facturacion.util.EstadoFactuImpreConstantesFunciones;
import com.bydan.erp.facturacion.util.EstadoFactuImpreParameterReturnGeneral;
//import com.bydan.erp.facturacion.util.EstadoFactuImpreParameterGeneral;
import com.bydan.erp.facturacion.business.entity.EstadoFactuImpre;
import com.bydan.erp.facturacion.business.logic.EstadoFactuImpreLogicAdditional;
import com.bydan.erp.facturacion.business.dataaccess.*;
import com.bydan.erp.facturacion.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;
















@SuppressWarnings("unused")
public class EstadoFactuImpreLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(EstadoFactuImpreLogic.class);
	
	protected EstadoFactuImpreDataAccess estadofactuimpreDataAccess; 	
	protected EstadoFactuImpre estadofactuimpre;
	protected List<EstadoFactuImpre> estadofactuimpres;
	protected Object estadofactuimpreObject;	
	protected List<Object> estadofactuimpresObject;
	
	public static ClassValidator<EstadoFactuImpre> estadofactuimpreValidator = new ClassValidator<EstadoFactuImpre>(EstadoFactuImpre.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected EstadoFactuImpreLogicAdditional estadofactuimpreLogicAdditional=null;
	
	public EstadoFactuImpreLogicAdditional getEstadoFactuImpreLogicAdditional() {
		return this.estadofactuimpreLogicAdditional;
	}
	
	public void setEstadoFactuImpreLogicAdditional(EstadoFactuImpreLogicAdditional estadofactuimpreLogicAdditional) {
		try {
			this.estadofactuimpreLogicAdditional=estadofactuimpreLogicAdditional;
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
	
	
	
	
	public  EstadoFactuImpreLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.estadofactuimpreDataAccess = new EstadoFactuImpreDataAccess();
			
			this.estadofactuimpres= new ArrayList<EstadoFactuImpre>();
			this.estadofactuimpre= new EstadoFactuImpre();
			
			this.estadofactuimpreObject=new Object();
			this.estadofactuimpresObject=new ArrayList<Object>();
				
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
			
			this.estadofactuimpreDataAccess.setConnexionType(this.connexionType);
			this.estadofactuimpreDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  EstadoFactuImpreLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.estadofactuimpreDataAccess = new EstadoFactuImpreDataAccess();
			this.estadofactuimpres= new ArrayList<EstadoFactuImpre>();
			this.estadofactuimpre= new EstadoFactuImpre();
			this.estadofactuimpreObject=new Object();
			this.estadofactuimpresObject=new ArrayList<Object>();
			
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
			
			this.estadofactuimpreDataAccess.setConnexionType(this.connexionType);
			this.estadofactuimpreDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public EstadoFactuImpre getEstadoFactuImpre() throws Exception {	
		EstadoFactuImpreLogicAdditional.checkEstadoFactuImpreToGet(estadofactuimpre,this.datosCliente,this.arrDatoGeneral);
		EstadoFactuImpreLogicAdditional.updateEstadoFactuImpreToGet(estadofactuimpre,this.arrDatoGeneral);
		
		return estadofactuimpre;
	}
		
	public void setEstadoFactuImpre(EstadoFactuImpre newEstadoFactuImpre) {
		this.estadofactuimpre = newEstadoFactuImpre;
	}
	
	public EstadoFactuImpreDataAccess getEstadoFactuImpreDataAccess() {
		return estadofactuimpreDataAccess;
	}
	
	public void setEstadoFactuImpreDataAccess(EstadoFactuImpreDataAccess newestadofactuimpreDataAccess) {
		this.estadofactuimpreDataAccess = newestadofactuimpreDataAccess;
	}
	
	public List<EstadoFactuImpre> getEstadoFactuImpres() throws Exception {		
		this.quitarEstadoFactuImpresNulos();
		
		EstadoFactuImpreLogicAdditional.checkEstadoFactuImpreToGets(estadofactuimpres,this.datosCliente,this.arrDatoGeneral);
		
		for (EstadoFactuImpre estadofactuimpreLocal: estadofactuimpres ) {
			EstadoFactuImpreLogicAdditional.updateEstadoFactuImpreToGet(estadofactuimpreLocal,this.arrDatoGeneral);
		}
		
		return estadofactuimpres;
	}
	
	public void setEstadoFactuImpres(List<EstadoFactuImpre> newEstadoFactuImpres) {
		this.estadofactuimpres = newEstadoFactuImpres;
	}
	
	public Object getEstadoFactuImpreObject() {	
		this.estadofactuimpreObject=this.estadofactuimpreDataAccess.getEntityObject();
		return this.estadofactuimpreObject;
	}
		
	public void setEstadoFactuImpreObject(Object newEstadoFactuImpreObject) {
		this.estadofactuimpreObject = newEstadoFactuImpreObject;
	}
	
	public List<Object> getEstadoFactuImpresObject() {		
		this.estadofactuimpresObject=this.estadofactuimpreDataAccess.getEntitiesObject();
		return this.estadofactuimpresObject;
	}
		
	public void setEstadoFactuImpresObject(List<Object> newEstadoFactuImpresObject) {
		this.estadofactuimpresObject = newEstadoFactuImpresObject;
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
		
		if(this.estadofactuimpreDataAccess!=null) {
			this.estadofactuimpreDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoFactuImpre.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			estadofactuimpreDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			estadofactuimpreDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		estadofactuimpre = new  EstadoFactuImpre();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoFactuImpre.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			estadofactuimpre=estadofactuimpreDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.estadofactuimpre,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				EstadoFactuImpreConstantesFunciones.refrescarForeignKeysDescripcionesEstadoFactuImpre(this.estadofactuimpre);
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
		estadofactuimpre = new  EstadoFactuImpre();
		  		  
        try {
			
			estadofactuimpre=estadofactuimpreDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.estadofactuimpre,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				EstadoFactuImpreConstantesFunciones.refrescarForeignKeysDescripcionesEstadoFactuImpre(this.estadofactuimpre);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		estadofactuimpre = new  EstadoFactuImpre();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoFactuImpre.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			estadofactuimpre=estadofactuimpreDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.estadofactuimpre,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				EstadoFactuImpreConstantesFunciones.refrescarForeignKeysDescripcionesEstadoFactuImpre(this.estadofactuimpre);
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
		estadofactuimpre = new  EstadoFactuImpre();
		  		  
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
		estadofactuimpre = new  EstadoFactuImpre();
		  		  
        try {
			
			estadofactuimpre=estadofactuimpreDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.estadofactuimpre,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				EstadoFactuImpreConstantesFunciones.refrescarForeignKeysDescripcionesEstadoFactuImpre(this.estadofactuimpre);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		estadofactuimpre = new  EstadoFactuImpre();
		  		  
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
		estadofactuimpre = new  EstadoFactuImpre();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoFactuImpre.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =estadofactuimpreDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		estadofactuimpre = new  EstadoFactuImpre();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=estadofactuimpreDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		estadofactuimpre = new  EstadoFactuImpre();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoFactuImpre.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =estadofactuimpreDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		estadofactuimpre = new  EstadoFactuImpre();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=estadofactuimpreDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		estadofactuimpre = new  EstadoFactuImpre();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoFactuImpre.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =estadofactuimpreDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		estadofactuimpre = new  EstadoFactuImpre();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=estadofactuimpreDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		estadofactuimpres = new  ArrayList<EstadoFactuImpre>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoFactuImpre.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			EstadoFactuImpreLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadofactuimpres=estadofactuimpreDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarEstadoFactuImpre(estadofactuimpres);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoFactuImpreConstantesFunciones.refrescarForeignKeysDescripcionesEstadoFactuImpre(this.estadofactuimpres);
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
		estadofactuimpres = new  ArrayList<EstadoFactuImpre>();
		  		  
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
		estadofactuimpres = new  ArrayList<EstadoFactuImpre>();
		  		  
        try {			
			EstadoFactuImpreLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadofactuimpres=estadofactuimpreDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarEstadoFactuImpre(estadofactuimpres);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoFactuImpreConstantesFunciones.refrescarForeignKeysDescripcionesEstadoFactuImpre(this.estadofactuimpres);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		estadofactuimpres = new  ArrayList<EstadoFactuImpre>();
		  		  
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
		estadofactuimpres = new  ArrayList<EstadoFactuImpre>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoFactuImpre.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			EstadoFactuImpreLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadofactuimpres=estadofactuimpreDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarEstadoFactuImpre(estadofactuimpres);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoFactuImpreConstantesFunciones.refrescarForeignKeysDescripcionesEstadoFactuImpre(this.estadofactuimpres);
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
		estadofactuimpres = new  ArrayList<EstadoFactuImpre>();
		  		  
        try {
			EstadoFactuImpreLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadofactuimpres=estadofactuimpreDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarEstadoFactuImpre(estadofactuimpres);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoFactuImpreConstantesFunciones.refrescarForeignKeysDescripcionesEstadoFactuImpre(this.estadofactuimpres);
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
		estadofactuimpres = new  ArrayList<EstadoFactuImpre>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoFactuImpre.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EstadoFactuImpreLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadofactuimpres=estadofactuimpreDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarEstadoFactuImpre(estadofactuimpres);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoFactuImpreConstantesFunciones.refrescarForeignKeysDescripcionesEstadoFactuImpre(this.estadofactuimpres);
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
		estadofactuimpres = new  ArrayList<EstadoFactuImpre>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EstadoFactuImpreLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadofactuimpres=estadofactuimpreDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarEstadoFactuImpre(estadofactuimpres);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoFactuImpreConstantesFunciones.refrescarForeignKeysDescripcionesEstadoFactuImpre(this.estadofactuimpres);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		estadofactuimpre = new  EstadoFactuImpre();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoFactuImpre.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EstadoFactuImpreLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadofactuimpre=estadofactuimpreDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarEstadoFactuImpre(estadofactuimpre);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoFactuImpreConstantesFunciones.refrescarForeignKeysDescripcionesEstadoFactuImpre(this.estadofactuimpre);
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
		estadofactuimpre = new  EstadoFactuImpre();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EstadoFactuImpreLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadofactuimpre=estadofactuimpreDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarEstadoFactuImpre(estadofactuimpre);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoFactuImpreConstantesFunciones.refrescarForeignKeysDescripcionesEstadoFactuImpre(this.estadofactuimpre);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		estadofactuimpres = new  ArrayList<EstadoFactuImpre>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoFactuImpre.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			EstadoFactuImpreLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadofactuimpres=estadofactuimpreDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarEstadoFactuImpre(estadofactuimpres);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoFactuImpreConstantesFunciones.refrescarForeignKeysDescripcionesEstadoFactuImpre(this.estadofactuimpres);
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
		estadofactuimpres = new  ArrayList<EstadoFactuImpre>();
		  		  
        try {
			EstadoFactuImpreLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadofactuimpres=estadofactuimpreDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarEstadoFactuImpre(estadofactuimpres);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoFactuImpreConstantesFunciones.refrescarForeignKeysDescripcionesEstadoFactuImpre(this.estadofactuimpres);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosEstadoFactuImpresWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		estadofactuimpres = new  ArrayList<EstadoFactuImpre>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoFactuImpre.class.getSimpleName()+"-getTodosEstadoFactuImpresWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EstadoFactuImpreLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadofactuimpres=estadofactuimpreDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarEstadoFactuImpre(estadofactuimpres);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoFactuImpreConstantesFunciones.refrescarForeignKeysDescripcionesEstadoFactuImpre(this.estadofactuimpres);
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
	
	public  void  getTodosEstadoFactuImpres(String sFinalQuery,Pagination pagination)throws Exception {
		estadofactuimpres = new  ArrayList<EstadoFactuImpre>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EstadoFactuImpreLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadofactuimpres=estadofactuimpreDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarEstadoFactuImpre(estadofactuimpres);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoFactuImpreConstantesFunciones.refrescarForeignKeysDescripcionesEstadoFactuImpre(this.estadofactuimpres);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarEstadoFactuImpre(EstadoFactuImpre estadofactuimpre) throws Exception {
		Boolean estaValidado=false;
		
		if(estadofactuimpre.getIsNew() || estadofactuimpre.getIsChanged()) { 
			this.invalidValues = estadofactuimpreValidator.getInvalidValues(estadofactuimpre);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(estadofactuimpre);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarEstadoFactuImpre(List<EstadoFactuImpre> EstadoFactuImpres) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(EstadoFactuImpre estadofactuimpreLocal:estadofactuimpres) {				
			estaValidadoObjeto=this.validarGuardarEstadoFactuImpre(estadofactuimpreLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarEstadoFactuImpre(List<EstadoFactuImpre> EstadoFactuImpres) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarEstadoFactuImpre(estadofactuimpres)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarEstadoFactuImpre(EstadoFactuImpre EstadoFactuImpre) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarEstadoFactuImpre(estadofactuimpre)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(EstadoFactuImpre estadofactuimpre) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+estadofactuimpre.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=EstadoFactuImpreConstantesFunciones.getEstadoFactuImpreLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"estadofactuimpre","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(EstadoFactuImpreConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(EstadoFactuImpreConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveEstadoFactuImpreWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoFactuImpre.class.getSimpleName()+"-saveEstadoFactuImpreWithConnection");connexion.begin();			
			
			EstadoFactuImpreLogicAdditional.checkEstadoFactuImpreToSave(this.estadofactuimpre,this.datosCliente,connexion,this.arrDatoGeneral);
			
			EstadoFactuImpreLogicAdditional.updateEstadoFactuImpreToSave(this.estadofactuimpre,this.arrDatoGeneral);
			
			EstadoFactuImpreLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.estadofactuimpre,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowEstadoFactuImpre();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarEstadoFactuImpre(this.estadofactuimpre)) {
				EstadoFactuImpreDataAccess.save(this.estadofactuimpre, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.estadofactuimpre,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			EstadoFactuImpreLogicAdditional.checkEstadoFactuImpreToSaveAfter(this.estadofactuimpre,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowEstadoFactuImpre();
			
			connexion.commit();			
			
			if(this.estadofactuimpre.getIsDeleted()) {
				this.estadofactuimpre=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveEstadoFactuImpre()throws Exception {	
		try {	
			
			EstadoFactuImpreLogicAdditional.checkEstadoFactuImpreToSave(this.estadofactuimpre,this.datosCliente,connexion,this.arrDatoGeneral);
			
			EstadoFactuImpreLogicAdditional.updateEstadoFactuImpreToSave(this.estadofactuimpre,this.arrDatoGeneral);
			
			EstadoFactuImpreLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.estadofactuimpre,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarEstadoFactuImpre(this.estadofactuimpre)) {			
				EstadoFactuImpreDataAccess.save(this.estadofactuimpre, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.estadofactuimpre,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			EstadoFactuImpreLogicAdditional.checkEstadoFactuImpreToSaveAfter(this.estadofactuimpre,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.estadofactuimpre.getIsDeleted()) {
				this.estadofactuimpre=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveEstadoFactuImpresWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoFactuImpre.class.getSimpleName()+"-saveEstadoFactuImpresWithConnection");connexion.begin();			
			
			EstadoFactuImpreLogicAdditional.checkEstadoFactuImpreToSaves(estadofactuimpres,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowEstadoFactuImpres();
			
			Boolean validadoTodosEstadoFactuImpre=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(EstadoFactuImpre estadofactuimpreLocal:estadofactuimpres) {		
				if(estadofactuimpreLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				EstadoFactuImpreLogicAdditional.updateEstadoFactuImpreToSave(estadofactuimpreLocal,this.arrDatoGeneral);
	        	
				EstadoFactuImpreLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),estadofactuimpreLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarEstadoFactuImpre(estadofactuimpreLocal)) {
					EstadoFactuImpreDataAccess.save(estadofactuimpreLocal, connexion);				
				} else {
					validadoTodosEstadoFactuImpre=false;
				}
			}
			
			if(!validadoTodosEstadoFactuImpre) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			EstadoFactuImpreLogicAdditional.checkEstadoFactuImpreToSavesAfter(estadofactuimpres,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowEstadoFactuImpres();
			
			connexion.commit();		
			
			this.quitarEstadoFactuImpresEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveEstadoFactuImpres()throws Exception {				
		 try {	
			EstadoFactuImpreLogicAdditional.checkEstadoFactuImpreToSaves(estadofactuimpres,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosEstadoFactuImpre=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(EstadoFactuImpre estadofactuimpreLocal:estadofactuimpres) {				
				if(estadofactuimpreLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				EstadoFactuImpreLogicAdditional.updateEstadoFactuImpreToSave(estadofactuimpreLocal,this.arrDatoGeneral);
	        	
				EstadoFactuImpreLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),estadofactuimpreLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarEstadoFactuImpre(estadofactuimpreLocal)) {				
					EstadoFactuImpreDataAccess.save(estadofactuimpreLocal, connexion);				
				} else {
					validadoTodosEstadoFactuImpre=false;
				}
			}
			
			if(!validadoTodosEstadoFactuImpre) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			EstadoFactuImpreLogicAdditional.checkEstadoFactuImpreToSavesAfter(estadofactuimpres,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarEstadoFactuImpresEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public EstadoFactuImpreParameterReturnGeneral procesarAccionEstadoFactuImpres(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<EstadoFactuImpre> estadofactuimpres,EstadoFactuImpreParameterReturnGeneral estadofactuimpreParameterGeneral)throws Exception {
		 try {	
			EstadoFactuImpreParameterReturnGeneral estadofactuimpreReturnGeneral=new EstadoFactuImpreParameterReturnGeneral();
	
			EstadoFactuImpreLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,estadofactuimpres,estadofactuimpreParameterGeneral,estadofactuimpreReturnGeneral);
			
			return estadofactuimpreReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public EstadoFactuImpreParameterReturnGeneral procesarAccionEstadoFactuImpresWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<EstadoFactuImpre> estadofactuimpres,EstadoFactuImpreParameterReturnGeneral estadofactuimpreParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoFactuImpre.class.getSimpleName()+"-procesarAccionEstadoFactuImpresWithConnection");connexion.begin();			
			
			EstadoFactuImpreParameterReturnGeneral estadofactuimpreReturnGeneral=new EstadoFactuImpreParameterReturnGeneral();
	
			EstadoFactuImpreLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,estadofactuimpres,estadofactuimpreParameterGeneral,estadofactuimpreReturnGeneral);
			
			this.connexion.commit();
			
			return estadofactuimpreReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public EstadoFactuImpreParameterReturnGeneral procesarEventosEstadoFactuImpres(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<EstadoFactuImpre> estadofactuimpres,EstadoFactuImpre estadofactuimpre,EstadoFactuImpreParameterReturnGeneral estadofactuimpreParameterGeneral,Boolean isEsNuevoEstadoFactuImpre,ArrayList<Classe> clases)throws Exception {
		 try {	
			EstadoFactuImpreParameterReturnGeneral estadofactuimpreReturnGeneral=new EstadoFactuImpreParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				estadofactuimpreReturnGeneral.setConRecargarPropiedades(true);
			}
			
			EstadoFactuImpreLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,estadofactuimpres,estadofactuimpre,estadofactuimpreParameterGeneral,estadofactuimpreReturnGeneral,isEsNuevoEstadoFactuImpre,clases);
			
			return estadofactuimpreReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public EstadoFactuImpreParameterReturnGeneral procesarEventosEstadoFactuImpresWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<EstadoFactuImpre> estadofactuimpres,EstadoFactuImpre estadofactuimpre,EstadoFactuImpreParameterReturnGeneral estadofactuimpreParameterGeneral,Boolean isEsNuevoEstadoFactuImpre,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoFactuImpre.class.getSimpleName()+"-procesarEventosEstadoFactuImpresWithConnection");connexion.begin();			
			
			EstadoFactuImpreParameterReturnGeneral estadofactuimpreReturnGeneral=new EstadoFactuImpreParameterReturnGeneral();
	
			estadofactuimpreReturnGeneral.setEstadoFactuImpre(estadofactuimpre);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				estadofactuimpreReturnGeneral.setConRecargarPropiedades(true);
			}
			
			EstadoFactuImpreLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,estadofactuimpres,estadofactuimpre,estadofactuimpreParameterGeneral,estadofactuimpreReturnGeneral,isEsNuevoEstadoFactuImpre,clases);
			
			this.connexion.commit();
			
			return estadofactuimpreReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public EstadoFactuImpreParameterReturnGeneral procesarImportacionEstadoFactuImpresWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,EstadoFactuImpreParameterReturnGeneral estadofactuimpreParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoFactuImpre.class.getSimpleName()+"-procesarImportacionEstadoFactuImpresWithConnection");connexion.begin();			
			
			EstadoFactuImpreParameterReturnGeneral estadofactuimpreReturnGeneral=new EstadoFactuImpreParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.estadofactuimpres=new ArrayList<EstadoFactuImpre>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.estadofactuimpre=new EstadoFactuImpre();
				
				
				if(conColumnasBase) {this.estadofactuimpre.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.estadofactuimpre.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.estadofactuimpre.setcodigo(arrColumnas[iColumn++]);
				this.estadofactuimpre.setnombre(arrColumnas[iColumn++]);
				
				this.estadofactuimpres.add(this.estadofactuimpre);
			}
			
			this.saveEstadoFactuImpres();
			
			this.connexion.commit();
			
			estadofactuimpreReturnGeneral.setConRetornoEstaProcesado(true);
			estadofactuimpreReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return estadofactuimpreReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarEstadoFactuImpresEliminados() throws Exception {				
		
		List<EstadoFactuImpre> estadofactuimpresAux= new ArrayList<EstadoFactuImpre>();
		
		for(EstadoFactuImpre estadofactuimpre:estadofactuimpres) {
			if(!estadofactuimpre.getIsDeleted()) {
				estadofactuimpresAux.add(estadofactuimpre);
			}
		}
		
		estadofactuimpres=estadofactuimpresAux;
	}
	
	public void quitarEstadoFactuImpresNulos() throws Exception {				
		
		List<EstadoFactuImpre> estadofactuimpresAux= new ArrayList<EstadoFactuImpre>();
		
		for(EstadoFactuImpre estadofactuimpre : this.estadofactuimpres) {
			if(estadofactuimpre==null) {
				estadofactuimpresAux.add(estadofactuimpre);
			}
		}
		
		//this.estadofactuimpres=estadofactuimpresAux;
		
		this.estadofactuimpres.removeAll(estadofactuimpresAux);
	}
	
	public void getSetVersionRowEstadoFactuImpreWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(estadofactuimpre.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((estadofactuimpre.getIsDeleted() || (estadofactuimpre.getIsChanged()&&!estadofactuimpre.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=estadofactuimpreDataAccess.getSetVersionRowEstadoFactuImpre(connexion,estadofactuimpre.getId());
				
				if(!estadofactuimpre.getVersionRow().equals(timestamp)) {	
					estadofactuimpre.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				estadofactuimpre.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowEstadoFactuImpre()throws Exception {	
		
		if(estadofactuimpre.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((estadofactuimpre.getIsDeleted() || (estadofactuimpre.getIsChanged()&&!estadofactuimpre.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=estadofactuimpreDataAccess.getSetVersionRowEstadoFactuImpre(connexion,estadofactuimpre.getId());
			
			try {							
				if(!estadofactuimpre.getVersionRow().equals(timestamp)) {	
					estadofactuimpre.setVersionRow(timestamp);
				}
				
				estadofactuimpre.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowEstadoFactuImpresWithConnection()throws Exception {	
		if(estadofactuimpres!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(EstadoFactuImpre estadofactuimpreAux:estadofactuimpres) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(estadofactuimpreAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(estadofactuimpreAux.getIsDeleted() || (estadofactuimpreAux.getIsChanged()&&!estadofactuimpreAux.getIsNew())) {
						
						timestamp=estadofactuimpreDataAccess.getSetVersionRowEstadoFactuImpre(connexion,estadofactuimpreAux.getId());
						
						if(!estadofactuimpre.getVersionRow().equals(timestamp)) {	
							estadofactuimpreAux.setVersionRow(timestamp);
						}
								
						estadofactuimpreAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowEstadoFactuImpres()throws Exception {	
		if(estadofactuimpres!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(EstadoFactuImpre estadofactuimpreAux:estadofactuimpres) {
					if(estadofactuimpreAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(estadofactuimpreAux.getIsDeleted() || (estadofactuimpreAux.getIsChanged()&&!estadofactuimpreAux.getIsNew())) {
						
						timestamp=estadofactuimpreDataAccess.getSetVersionRowEstadoFactuImpre(connexion,estadofactuimpreAux.getId());
						
						if(!estadofactuimpreAux.getVersionRow().equals(timestamp)) {	
							estadofactuimpreAux.setVersionRow(timestamp);
						}
						
													
						estadofactuimpreAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	
	public void cargarRelacionesLoteForeignKeyEstadoFactuImpreWithConnection() throws Exception {
		ArrayList<Classe> classes=new ArrayList<Classe>();		
		
		
			FacturaImpresionLogic facturaimpresionLogic=new FacturaImpresionLogic();
		
		try {
			
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoFactuImpre.class.getSimpleName()+"-cargarRelacionesLoteForeignKeyEstadoFactuImpreWithConnection");connexion.begin();
			
			
			classes.add(new Classe(FacturaImpresion.class));
											
			

			facturaimpresionLogic.setConnexion(this.getConnexion());
			facturaimpresionLogic.setDatosCliente(this.datosCliente);
			facturaimpresionLogic.setIsConRefrescarForeignKeys(true);
			
			this.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
			
			for(EstadoFactuImpre estadofactuimpre:this.estadofactuimpres) {
				

				classes=new ArrayList<Classe>();
				classes=FacturaImpresionConstantesFunciones.getClassesForeignKeysOfFacturaImpresion(new ArrayList<Classe>(),DeepLoadType.NONE);

				facturaimpresionLogic.setFacturaImpresions(estadofactuimpre.facturaimpresions);
				facturaimpresionLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
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
	
	public void deepLoad(EstadoFactuImpre estadofactuimpre,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			EstadoFactuImpreLogicAdditional.updateEstadoFactuImpreToGet(estadofactuimpre,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		estadofactuimpre.setFacturaImpresions(estadofactuimpreDataAccess.getFacturaImpresions(connexion,estadofactuimpre));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(FacturaImpresion.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				estadofactuimpre.setFacturaImpresions(estadofactuimpreDataAccess.getFacturaImpresions(connexion,estadofactuimpre));

				if(this.isConDeep) {
					FacturaImpresionLogic facturaimpresionLogic= new FacturaImpresionLogic(this.connexion);
					facturaimpresionLogic.setFacturaImpresions(estadofactuimpre.getFacturaImpresions());
					ArrayList<Classe> classesLocal=FacturaImpresionConstantesFunciones.getClassesForeignKeysOfFacturaImpresion(new ArrayList<Classe>(),DeepLoadType.NONE);
					facturaimpresionLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					FacturaImpresionConstantesFunciones.refrescarForeignKeysDescripcionesFacturaImpresion(facturaimpresionLogic.getFacturaImpresions());
					estadofactuimpre.setFacturaImpresions(facturaimpresionLogic.getFacturaImpresions());
				}

				continue;
			}
		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {


		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(FacturaImpresion.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(FacturaImpresion.class));
			estadofactuimpre.setFacturaImpresions(estadofactuimpreDataAccess.getFacturaImpresions(connexion,estadofactuimpre));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {


		estadofactuimpre.setFacturaImpresions(estadofactuimpreDataAccess.getFacturaImpresions(connexion,estadofactuimpre));

		for(FacturaImpresion facturaimpresion:estadofactuimpre.getFacturaImpresions()) {
			FacturaImpresionLogic facturaimpresionLogic= new FacturaImpresionLogic(connexion);
			facturaimpresionLogic.deepLoad(facturaimpresion,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(FacturaImpresion.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				estadofactuimpre.setFacturaImpresions(estadofactuimpreDataAccess.getFacturaImpresions(connexion,estadofactuimpre));

				for(FacturaImpresion facturaimpresion:estadofactuimpre.getFacturaImpresions()) {
					FacturaImpresionLogic facturaimpresionLogic= new FacturaImpresionLogic(connexion);
					facturaimpresionLogic.deepLoad(facturaimpresion,isDeep,deepLoadType,clases);
				}
				continue;
			}

		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {


		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(FacturaImpresion.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(FacturaImpresion.class));
			estadofactuimpre.setFacturaImpresions(estadofactuimpreDataAccess.getFacturaImpresions(connexion,estadofactuimpre));

			for(FacturaImpresion facturaimpresion:estadofactuimpre.getFacturaImpresions()) {
				FacturaImpresionLogic facturaimpresionLogic= new FacturaImpresionLogic(connexion);
				facturaimpresionLogic.deepLoad(facturaimpresion,isDeep,deepLoadType,clases);
			}
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(EstadoFactuImpre estadofactuimpre,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			EstadoFactuImpreLogicAdditional.updateEstadoFactuImpreToSave(estadofactuimpre,this.arrDatoGeneral);
			
EstadoFactuImpreDataAccess.save(estadofactuimpre, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		for(FacturaImpresion facturaimpresion:estadofactuimpre.getFacturaImpresions()) {
			facturaimpresion.setid_estado_factu_impre(estadofactuimpre.getId());
			FacturaImpresionDataAccess.save(facturaimpresion,connexion);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {

			if(clas.clas.equals(FacturaImpresion.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(FacturaImpresion facturaimpresion:estadofactuimpre.getFacturaImpresions()) {
					facturaimpresion.setid_estado_factu_impre(estadofactuimpre.getId());
					FacturaImpresionDataAccess.save(facturaimpresion,connexion);
				}
				continue;
			}
		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		for(FacturaImpresion facturaimpresion:estadofactuimpre.getFacturaImpresions()) {
			FacturaImpresionLogic facturaimpresionLogic= new FacturaImpresionLogic(connexion);
			facturaimpresion.setid_estado_factu_impre(estadofactuimpre.getId());
			FacturaImpresionDataAccess.save(facturaimpresion,connexion);
			facturaimpresionLogic.deepSave(facturaimpresion,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {

			if(clas.clas.equals(FacturaImpresion.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(FacturaImpresion facturaimpresion:estadofactuimpre.getFacturaImpresions()) {
					FacturaImpresionLogic facturaimpresionLogic= new FacturaImpresionLogic(connexion);
					facturaimpresion.setid_estado_factu_impre(estadofactuimpre.getId());
					FacturaImpresionDataAccess.save(facturaimpresion,connexion);
					facturaimpresionLogic.deepSave(facturaimpresion,isDeep,deepLoadType,clases);
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
			this.getNewConnexionToDeep(EstadoFactuImpre.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(estadofactuimpre,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				EstadoFactuImpreConstantesFunciones.refrescarForeignKeysDescripcionesEstadoFactuImpre(estadofactuimpre);
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
			this.deepLoad(this.estadofactuimpre,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				EstadoFactuImpreConstantesFunciones.refrescarForeignKeysDescripcionesEstadoFactuImpre(this.estadofactuimpre);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(EstadoFactuImpre.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(estadofactuimpres!=null) {
				for(EstadoFactuImpre estadofactuimpre:estadofactuimpres) {
					this.deepLoad(estadofactuimpre,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					EstadoFactuImpreConstantesFunciones.refrescarForeignKeysDescripcionesEstadoFactuImpre(estadofactuimpres);
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
			if(estadofactuimpres!=null) {
				for(EstadoFactuImpre estadofactuimpre:estadofactuimpres) {
					this.deepLoad(estadofactuimpre,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					EstadoFactuImpreConstantesFunciones.refrescarForeignKeysDescripcionesEstadoFactuImpre(estadofactuimpres);
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
			this.getNewConnexionToDeep(EstadoFactuImpre.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(estadofactuimpre,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(EstadoFactuImpre.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(estadofactuimpres!=null) {
				for(EstadoFactuImpre estadofactuimpre:estadofactuimpres) {
					this.deepSave(estadofactuimpre,isDeep,deepLoadType,clases);
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
			if(estadofactuimpres!=null) {
				for(EstadoFactuImpre estadofactuimpre:estadofactuimpres) {
					this.deepSave(estadofactuimpre,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getEstadoFactuImprePorCodigoWithConnection(String codigo)throws Exception {
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoFactuImpre.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			ParameterSelectionGeneral parameterSelectionGeneralCodigo= new ParameterSelectionGeneral();
			parameterSelectionGeneralCodigo.setParameterSelectionGeneralEqual(ParameterType.STRING,codigo,EstadoFactuImpreConstantesFunciones.CODIGO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralCodigo);

			estadofactuimpre=estadofactuimpreDataAccess.getEntity(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoad(this.estadofactuimpre,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());

				EstadoFactuImpreConstantesFunciones.refrescarForeignKeysDescripcionesEstadoFactuImpre(this.estadofactuimpre);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getEstadoFactuImprePorCodigo(String codigo)throws Exception {
		try {

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			ParameterSelectionGeneral parameterSelectionGeneralCodigo= new ParameterSelectionGeneral();
			parameterSelectionGeneralCodigo.setParameterSelectionGeneralEqual(ParameterType.STRING,codigo,EstadoFactuImpreConstantesFunciones.CODIGO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralCodigo);

			estadofactuimpre=estadofactuimpreDataAccess.getEntity(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoad(this.estadofactuimpre,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());

				EstadoFactuImpreConstantesFunciones.refrescarForeignKeysDescripcionesEstadoFactuImpre(this.estadofactuimpre);
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
			if(EstadoFactuImpreConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,EstadoFactuImpreDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,EstadoFactuImpre estadofactuimpre,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(EstadoFactuImpreConstantesFunciones.ISCONAUDITORIA) {
				if(estadofactuimpre.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,EstadoFactuImpreDataAccess.TABLENAME, estadofactuimpre.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(EstadoFactuImpreConstantesFunciones.ISCONAUDITORIADETALLE) {
						////EstadoFactuImpreLogic.registrarAuditoriaDetallesEstadoFactuImpre(connexion,estadofactuimpre,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(estadofactuimpre.getIsDeleted()) {
					/*if(!estadofactuimpre.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,EstadoFactuImpreDataAccess.TABLENAME, estadofactuimpre.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////EstadoFactuImpreLogic.registrarAuditoriaDetallesEstadoFactuImpre(connexion,estadofactuimpre,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,EstadoFactuImpreDataAccess.TABLENAME, estadofactuimpre.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(estadofactuimpre.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,EstadoFactuImpreDataAccess.TABLENAME, estadofactuimpre.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(EstadoFactuImpreConstantesFunciones.ISCONAUDITORIADETALLE) {
						////EstadoFactuImpreLogic.registrarAuditoriaDetallesEstadoFactuImpre(connexion,estadofactuimpre,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesEstadoFactuImpre(Connexion connexion,EstadoFactuImpre estadofactuimpre)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(estadofactuimpre.getIsNew()||!estadofactuimpre.getcodigo().equals(estadofactuimpre.getEstadoFactuImpreOriginal().getcodigo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(estadofactuimpre.getEstadoFactuImpreOriginal().getcodigo()!=null)
				{
					strValorActual=estadofactuimpre.getEstadoFactuImpreOriginal().getcodigo();
				}
				if(estadofactuimpre.getcodigo()!=null)
				{
					strValorNuevo=estadofactuimpre.getcodigo() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),EstadoFactuImpreConstantesFunciones.CODIGO,strValorActual,strValorNuevo);
			}	
			
			if(estadofactuimpre.getIsNew()||!estadofactuimpre.getnombre().equals(estadofactuimpre.getEstadoFactuImpreOriginal().getnombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(estadofactuimpre.getEstadoFactuImpreOriginal().getnombre()!=null)
				{
					strValorActual=estadofactuimpre.getEstadoFactuImpreOriginal().getnombre();
				}
				if(estadofactuimpre.getnombre()!=null)
				{
					strValorNuevo=estadofactuimpre.getnombre() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),EstadoFactuImpreConstantesFunciones.NOMBRE,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveEstadoFactuImpreRelacionesWithConnection(EstadoFactuImpre estadofactuimpre,List<FacturaImpresion> facturaimpresions) throws Exception {

		if(!estadofactuimpre.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveEstadoFactuImpreRelacionesBase(estadofactuimpre,facturaimpresions,true);
		}
	}

	public void saveEstadoFactuImpreRelaciones(EstadoFactuImpre estadofactuimpre,List<FacturaImpresion> facturaimpresions)throws Exception {

		if(!estadofactuimpre.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveEstadoFactuImpreRelacionesBase(estadofactuimpre,facturaimpresions,false);
		}
	}

	public void saveEstadoFactuImpreRelacionesBase(EstadoFactuImpre estadofactuimpre,List<FacturaImpresion> facturaimpresions,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("EstadoFactuImpre-saveRelacionesWithConnection");}
	
			estadofactuimpre.setFacturaImpresions(facturaimpresions);

			this.setEstadoFactuImpre(estadofactuimpre);

			if(EstadoFactuImpreLogicAdditional.validarSaveRelaciones(estadofactuimpre,this)) {

				EstadoFactuImpreLogicAdditional.updateRelacionesToSave(estadofactuimpre,this);

				if((estadofactuimpre.getIsNew()||estadofactuimpre.getIsChanged())&&!estadofactuimpre.getIsDeleted()) {
					this.saveEstadoFactuImpre();
					this.saveEstadoFactuImpreRelacionesDetalles(facturaimpresions);

				} else if(estadofactuimpre.getIsDeleted()) {
					this.saveEstadoFactuImpreRelacionesDetalles(facturaimpresions);
					this.saveEstadoFactuImpre();
				}

				EstadoFactuImpreLogicAdditional.updateRelacionesToSaveAfter(estadofactuimpre,this);

			} else {
				throw new Exception("LOS DATOS SON INVALIDOS");
			}

			if(conConexion) {connexion.commit();}

		} catch(Exception e) {
			
			FacturaImpresionConstantesFunciones.InicializarGeneralEntityAuxiliaresFacturaImpresions(facturaimpresions,true,true);

			if(conConexion){connexion.rollback();}
			Funciones.manageException(logger,e);
			throw e;

		} finally {
			if(conConexion){this.closeNewConnexionToDeep();}
		}
	}
	
	
	private void saveEstadoFactuImpreRelacionesDetalles(List<FacturaImpresion> facturaimpresions)throws Exception {
		try {
	

			Long idEstadoFactuImpreActual=this.getEstadoFactuImpre().getId();

			FacturaImpresionLogic facturaimpresionLogic_Desde_EstadoFactuImpre=new FacturaImpresionLogic();
			facturaimpresionLogic_Desde_EstadoFactuImpre.setFacturaImpresions(facturaimpresions);

			facturaimpresionLogic_Desde_EstadoFactuImpre.setConnexion(this.getConnexion());
			facturaimpresionLogic_Desde_EstadoFactuImpre.setDatosCliente(this.datosCliente);

			for(FacturaImpresion facturaimpresion_Desde_EstadoFactuImpre:facturaimpresionLogic_Desde_EstadoFactuImpre.getFacturaImpresions()) {
				facturaimpresion_Desde_EstadoFactuImpre.setid_estado_factu_impre(idEstadoFactuImpreActual);
			}

			facturaimpresionLogic_Desde_EstadoFactuImpre.saveFacturaImpresions();

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfEstadoFactuImpre(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=EstadoFactuImpreConstantesFunciones.getClassesForeignKeysOfEstadoFactuImpre(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfEstadoFactuImpre(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=EstadoFactuImpreConstantesFunciones.getClassesRelationshipsOfEstadoFactuImpre(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

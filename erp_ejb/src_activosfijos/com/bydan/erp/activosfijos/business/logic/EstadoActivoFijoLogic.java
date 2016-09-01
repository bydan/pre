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
import com.bydan.erp.activosfijos.util.EstadoActivoFijoConstantesFunciones;
import com.bydan.erp.activosfijos.util.EstadoActivoFijoParameterReturnGeneral;
//import com.bydan.erp.activosfijos.util.EstadoActivoFijoParameterGeneral;
import com.bydan.erp.activosfijos.business.entity.EstadoActivoFijo;
//import com.bydan.erp.activosfijos.business.logic.EstadoActivoFijoLogicAdditional;
import com.bydan.erp.activosfijos.business.dataaccess.*;
import com.bydan.erp.activosfijos.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.activosfijos.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;
import com.bydan.erp.cartera.business.logic.*;
import com.bydan.erp.contabilidad.business.logic.*;
import com.bydan.erp.facturacion.business.logic.*;
import com.bydan.erp.activosfijos.business.logic.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.facturacion.util.*;
import com.bydan.erp.activosfijos.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.cartera.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;
import com.bydan.erp.facturacion.business.dataaccess.*;
import com.bydan.erp.activosfijos.business.dataaccess.*;








@SuppressWarnings("unused")
public class EstadoActivoFijoLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(EstadoActivoFijoLogic.class);
	
	protected EstadoActivoFijoDataAccess estadoactivofijoDataAccess; 	
	protected EstadoActivoFijo estadoactivofijo;
	protected List<EstadoActivoFijo> estadoactivofijos;
	protected Object estadoactivofijoObject;	
	protected List<Object> estadoactivofijosObject;
	
	public static ClassValidator<EstadoActivoFijo> estadoactivofijoValidator = new ClassValidator<EstadoActivoFijo>(EstadoActivoFijo.class);	
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
	
	
	
	
	public  EstadoActivoFijoLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.estadoactivofijoDataAccess = new EstadoActivoFijoDataAccess();
			
			this.estadoactivofijos= new ArrayList<EstadoActivoFijo>();
			this.estadoactivofijo= new EstadoActivoFijo();
			
			this.estadoactivofijoObject=new Object();
			this.estadoactivofijosObject=new ArrayList<Object>();
				
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
			
			this.estadoactivofijoDataAccess.setConnexionType(this.connexionType);
			this.estadoactivofijoDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  EstadoActivoFijoLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.estadoactivofijoDataAccess = new EstadoActivoFijoDataAccess();
			this.estadoactivofijos= new ArrayList<EstadoActivoFijo>();
			this.estadoactivofijo= new EstadoActivoFijo();
			this.estadoactivofijoObject=new Object();
			this.estadoactivofijosObject=new ArrayList<Object>();
			
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
			
			this.estadoactivofijoDataAccess.setConnexionType(this.connexionType);
			this.estadoactivofijoDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public EstadoActivoFijo getEstadoActivoFijo() throws Exception {	
		//EstadoActivoFijoLogicAdditional.checkEstadoActivoFijoToGet(estadoactivofijo,this.datosCliente,this.arrDatoGeneral);
		//EstadoActivoFijoLogicAdditional.updateEstadoActivoFijoToGet(estadoactivofijo,this.arrDatoGeneral);
		
		return estadoactivofijo;
	}
		
	public void setEstadoActivoFijo(EstadoActivoFijo newEstadoActivoFijo) {
		this.estadoactivofijo = newEstadoActivoFijo;
	}
	
	public EstadoActivoFijoDataAccess getEstadoActivoFijoDataAccess() {
		return estadoactivofijoDataAccess;
	}
	
	public void setEstadoActivoFijoDataAccess(EstadoActivoFijoDataAccess newestadoactivofijoDataAccess) {
		this.estadoactivofijoDataAccess = newestadoactivofijoDataAccess;
	}
	
	public List<EstadoActivoFijo> getEstadoActivoFijos() throws Exception {		
		this.quitarEstadoActivoFijosNulos();
		
		//EstadoActivoFijoLogicAdditional.checkEstadoActivoFijoToGets(estadoactivofijos,this.datosCliente,this.arrDatoGeneral);
		
		for (EstadoActivoFijo estadoactivofijoLocal: estadoactivofijos ) {
			//EstadoActivoFijoLogicAdditional.updateEstadoActivoFijoToGet(estadoactivofijoLocal,this.arrDatoGeneral);
		}
		
		return estadoactivofijos;
	}
	
	public void setEstadoActivoFijos(List<EstadoActivoFijo> newEstadoActivoFijos) {
		this.estadoactivofijos = newEstadoActivoFijos;
	}
	
	public Object getEstadoActivoFijoObject() {	
		this.estadoactivofijoObject=this.estadoactivofijoDataAccess.getEntityObject();
		return this.estadoactivofijoObject;
	}
		
	public void setEstadoActivoFijoObject(Object newEstadoActivoFijoObject) {
		this.estadoactivofijoObject = newEstadoActivoFijoObject;
	}
	
	public List<Object> getEstadoActivoFijosObject() {		
		this.estadoactivofijosObject=this.estadoactivofijoDataAccess.getEntitiesObject();
		return this.estadoactivofijosObject;
	}
		
	public void setEstadoActivoFijosObject(List<Object> newEstadoActivoFijosObject) {
		this.estadoactivofijosObject = newEstadoActivoFijosObject;
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
		
		if(this.estadoactivofijoDataAccess!=null) {
			this.estadoactivofijoDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoActivoFijo.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			estadoactivofijoDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			estadoactivofijoDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		estadoactivofijo = new  EstadoActivoFijo();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoActivoFijo.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			estadoactivofijo=estadoactivofijoDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.estadoactivofijo,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				EstadoActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesEstadoActivoFijo(this.estadoactivofijo);
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
		estadoactivofijo = new  EstadoActivoFijo();
		  		  
        try {
			
			estadoactivofijo=estadoactivofijoDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.estadoactivofijo,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				EstadoActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesEstadoActivoFijo(this.estadoactivofijo);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		estadoactivofijo = new  EstadoActivoFijo();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoActivoFijo.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			estadoactivofijo=estadoactivofijoDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.estadoactivofijo,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				EstadoActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesEstadoActivoFijo(this.estadoactivofijo);
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
		estadoactivofijo = new  EstadoActivoFijo();
		  		  
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
		estadoactivofijo = new  EstadoActivoFijo();
		  		  
        try {
			
			estadoactivofijo=estadoactivofijoDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.estadoactivofijo,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				EstadoActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesEstadoActivoFijo(this.estadoactivofijo);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		estadoactivofijo = new  EstadoActivoFijo();
		  		  
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
		estadoactivofijo = new  EstadoActivoFijo();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoActivoFijo.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =estadoactivofijoDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		estadoactivofijo = new  EstadoActivoFijo();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=estadoactivofijoDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		estadoactivofijo = new  EstadoActivoFijo();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoActivoFijo.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =estadoactivofijoDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		estadoactivofijo = new  EstadoActivoFijo();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=estadoactivofijoDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		estadoactivofijo = new  EstadoActivoFijo();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoActivoFijo.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =estadoactivofijoDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		estadoactivofijo = new  EstadoActivoFijo();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=estadoactivofijoDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		estadoactivofijos = new  ArrayList<EstadoActivoFijo>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoActivoFijo.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			EstadoActivoFijoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadoactivofijos=estadoactivofijoDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarEstadoActivoFijo(estadoactivofijos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesEstadoActivoFijo(this.estadoactivofijos);
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
		estadoactivofijos = new  ArrayList<EstadoActivoFijo>();
		  		  
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
		estadoactivofijos = new  ArrayList<EstadoActivoFijo>();
		  		  
        try {			
			EstadoActivoFijoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadoactivofijos=estadoactivofijoDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarEstadoActivoFijo(estadoactivofijos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesEstadoActivoFijo(this.estadoactivofijos);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		estadoactivofijos = new  ArrayList<EstadoActivoFijo>();
		  		  
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
		estadoactivofijos = new  ArrayList<EstadoActivoFijo>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoActivoFijo.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			EstadoActivoFijoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadoactivofijos=estadoactivofijoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarEstadoActivoFijo(estadoactivofijos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesEstadoActivoFijo(this.estadoactivofijos);
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
		estadoactivofijos = new  ArrayList<EstadoActivoFijo>();
		  		  
        try {
			EstadoActivoFijoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadoactivofijos=estadoactivofijoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarEstadoActivoFijo(estadoactivofijos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesEstadoActivoFijo(this.estadoactivofijos);
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
		estadoactivofijos = new  ArrayList<EstadoActivoFijo>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoActivoFijo.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EstadoActivoFijoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadoactivofijos=estadoactivofijoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarEstadoActivoFijo(estadoactivofijos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesEstadoActivoFijo(this.estadoactivofijos);
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
		estadoactivofijos = new  ArrayList<EstadoActivoFijo>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EstadoActivoFijoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadoactivofijos=estadoactivofijoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarEstadoActivoFijo(estadoactivofijos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesEstadoActivoFijo(this.estadoactivofijos);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		estadoactivofijo = new  EstadoActivoFijo();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoActivoFijo.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EstadoActivoFijoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadoactivofijo=estadoactivofijoDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarEstadoActivoFijo(estadoactivofijo);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesEstadoActivoFijo(this.estadoactivofijo);
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
		estadoactivofijo = new  EstadoActivoFijo();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EstadoActivoFijoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadoactivofijo=estadoactivofijoDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarEstadoActivoFijo(estadoactivofijo);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesEstadoActivoFijo(this.estadoactivofijo);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	
	
	public void getTodosEstadoActivoFijosWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		estadoactivofijos = new  ArrayList<EstadoActivoFijo>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoActivoFijo.class.getSimpleName()+"-getTodosEstadoActivoFijosWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EstadoActivoFijoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadoactivofijos=estadoactivofijoDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarEstadoActivoFijo(estadoactivofijos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesEstadoActivoFijo(this.estadoactivofijos);
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
	
	public  void  getTodosEstadoActivoFijos(String sFinalQuery,Pagination pagination)throws Exception {
		estadoactivofijos = new  ArrayList<EstadoActivoFijo>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EstadoActivoFijoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadoactivofijos=estadoactivofijoDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarEstadoActivoFijo(estadoactivofijos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesEstadoActivoFijo(this.estadoactivofijos);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarEstadoActivoFijo(EstadoActivoFijo estadoactivofijo) throws Exception {
		Boolean estaValidado=false;
		
		if(estadoactivofijo.getIsNew() || estadoactivofijo.getIsChanged()) { 
			this.invalidValues = estadoactivofijoValidator.getInvalidValues(estadoactivofijo);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(estadoactivofijo);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarEstadoActivoFijo(List<EstadoActivoFijo> EstadoActivoFijos) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(EstadoActivoFijo estadoactivofijoLocal:estadoactivofijos) {				
			estaValidadoObjeto=this.validarGuardarEstadoActivoFijo(estadoactivofijoLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarEstadoActivoFijo(List<EstadoActivoFijo> EstadoActivoFijos) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarEstadoActivoFijo(estadoactivofijos)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarEstadoActivoFijo(EstadoActivoFijo EstadoActivoFijo) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarEstadoActivoFijo(estadoactivofijo)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(EstadoActivoFijo estadoactivofijo) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+estadoactivofijo.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=EstadoActivoFijoConstantesFunciones.getEstadoActivoFijoLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"estadoactivofijo","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(EstadoActivoFijoConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(EstadoActivoFijoConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveEstadoActivoFijoWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoActivoFijo.class.getSimpleName()+"-saveEstadoActivoFijoWithConnection");connexion.begin();			
			
			//EstadoActivoFijoLogicAdditional.checkEstadoActivoFijoToSave(this.estadoactivofijo,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//EstadoActivoFijoLogicAdditional.updateEstadoActivoFijoToSave(this.estadoactivofijo,this.arrDatoGeneral);
			
			EstadoActivoFijoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.estadoactivofijo,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowEstadoActivoFijo();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarEstadoActivoFijo(this.estadoactivofijo)) {
				EstadoActivoFijoDataAccess.save(this.estadoactivofijo, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.estadoactivofijo,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			//EstadoActivoFijoLogicAdditional.checkEstadoActivoFijoToSaveAfter(this.estadoactivofijo,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowEstadoActivoFijo();
			
			connexion.commit();			
			
			if(this.estadoactivofijo.getIsDeleted()) {
				this.estadoactivofijo=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveEstadoActivoFijo()throws Exception {	
		try {	
			
			//EstadoActivoFijoLogicAdditional.checkEstadoActivoFijoToSave(this.estadoactivofijo,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//EstadoActivoFijoLogicAdditional.updateEstadoActivoFijoToSave(this.estadoactivofijo,this.arrDatoGeneral);
			
			EstadoActivoFijoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.estadoactivofijo,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarEstadoActivoFijo(this.estadoactivofijo)) {			
				EstadoActivoFijoDataAccess.save(this.estadoactivofijo, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.estadoactivofijo,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			//EstadoActivoFijoLogicAdditional.checkEstadoActivoFijoToSaveAfter(this.estadoactivofijo,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.estadoactivofijo.getIsDeleted()) {
				this.estadoactivofijo=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveEstadoActivoFijosWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoActivoFijo.class.getSimpleName()+"-saveEstadoActivoFijosWithConnection");connexion.begin();			
			
			//EstadoActivoFijoLogicAdditional.checkEstadoActivoFijoToSaves(estadoactivofijos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowEstadoActivoFijos();
			
			Boolean validadoTodosEstadoActivoFijo=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(EstadoActivoFijo estadoactivofijoLocal:estadoactivofijos) {		
				if(estadoactivofijoLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				//EstadoActivoFijoLogicAdditional.updateEstadoActivoFijoToSave(estadoactivofijoLocal,this.arrDatoGeneral);
	        	
				EstadoActivoFijoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),estadoactivofijoLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarEstadoActivoFijo(estadoactivofijoLocal)) {
					EstadoActivoFijoDataAccess.save(estadoactivofijoLocal, connexion);				
				} else {
					validadoTodosEstadoActivoFijo=false;
				}
			}
			
			if(!validadoTodosEstadoActivoFijo) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			//EstadoActivoFijoLogicAdditional.checkEstadoActivoFijoToSavesAfter(estadoactivofijos,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowEstadoActivoFijos();
			
			connexion.commit();		
			
			this.quitarEstadoActivoFijosEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveEstadoActivoFijos()throws Exception {				
		 try {	
			//EstadoActivoFijoLogicAdditional.checkEstadoActivoFijoToSaves(estadoactivofijos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosEstadoActivoFijo=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(EstadoActivoFijo estadoactivofijoLocal:estadoactivofijos) {				
				if(estadoactivofijoLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				//EstadoActivoFijoLogicAdditional.updateEstadoActivoFijoToSave(estadoactivofijoLocal,this.arrDatoGeneral);
	        	
				EstadoActivoFijoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),estadoactivofijoLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarEstadoActivoFijo(estadoactivofijoLocal)) {				
					EstadoActivoFijoDataAccess.save(estadoactivofijoLocal, connexion);				
				} else {
					validadoTodosEstadoActivoFijo=false;
				}
			}
			
			if(!validadoTodosEstadoActivoFijo) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			//EstadoActivoFijoLogicAdditional.checkEstadoActivoFijoToSavesAfter(estadoactivofijos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarEstadoActivoFijosEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public EstadoActivoFijoParameterReturnGeneral procesarAccionEstadoActivoFijos(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<EstadoActivoFijo> estadoactivofijos,EstadoActivoFijoParameterReturnGeneral estadoactivofijoParameterGeneral)throws Exception {
		 try {	
			EstadoActivoFijoParameterReturnGeneral estadoactivofijoReturnGeneral=new EstadoActivoFijoParameterReturnGeneral();
	
			
			return estadoactivofijoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public EstadoActivoFijoParameterReturnGeneral procesarAccionEstadoActivoFijosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<EstadoActivoFijo> estadoactivofijos,EstadoActivoFijoParameterReturnGeneral estadoactivofijoParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoActivoFijo.class.getSimpleName()+"-procesarAccionEstadoActivoFijosWithConnection");connexion.begin();			
			
			EstadoActivoFijoParameterReturnGeneral estadoactivofijoReturnGeneral=new EstadoActivoFijoParameterReturnGeneral();
	
			
			this.connexion.commit();
			
			return estadoactivofijoReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public EstadoActivoFijoParameterReturnGeneral procesarEventosEstadoActivoFijos(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<EstadoActivoFijo> estadoactivofijos,EstadoActivoFijo estadoactivofijo,EstadoActivoFijoParameterReturnGeneral estadoactivofijoParameterGeneral,Boolean isEsNuevoEstadoActivoFijo,ArrayList<Classe> clases)throws Exception {
		 try {	
			EstadoActivoFijoParameterReturnGeneral estadoactivofijoReturnGeneral=new EstadoActivoFijoParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				estadoactivofijoReturnGeneral.setConRecargarPropiedades(true);
			}
			
			
			return estadoactivofijoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public EstadoActivoFijoParameterReturnGeneral procesarEventosEstadoActivoFijosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<EstadoActivoFijo> estadoactivofijos,EstadoActivoFijo estadoactivofijo,EstadoActivoFijoParameterReturnGeneral estadoactivofijoParameterGeneral,Boolean isEsNuevoEstadoActivoFijo,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoActivoFijo.class.getSimpleName()+"-procesarEventosEstadoActivoFijosWithConnection");connexion.begin();			
			
			EstadoActivoFijoParameterReturnGeneral estadoactivofijoReturnGeneral=new EstadoActivoFijoParameterReturnGeneral();
	
			estadoactivofijoReturnGeneral.setEstadoActivoFijo(estadoactivofijo);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				estadoactivofijoReturnGeneral.setConRecargarPropiedades(true);
			}
			
			
			this.connexion.commit();
			
			return estadoactivofijoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public EstadoActivoFijoParameterReturnGeneral procesarImportacionEstadoActivoFijosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,EstadoActivoFijoParameterReturnGeneral estadoactivofijoParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoActivoFijo.class.getSimpleName()+"-procesarImportacionEstadoActivoFijosWithConnection");connexion.begin();			
			
			EstadoActivoFijoParameterReturnGeneral estadoactivofijoReturnGeneral=new EstadoActivoFijoParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.estadoactivofijos=new ArrayList<EstadoActivoFijo>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.estadoactivofijo=new EstadoActivoFijo();
				
				
				if(conColumnasBase) {this.estadoactivofijo.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.estadoactivofijo.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.estadoactivofijo.setcodigo(arrColumnas[iColumn++]);
				this.estadoactivofijo.setnombre(arrColumnas[iColumn++]);
				
				this.estadoactivofijos.add(this.estadoactivofijo);
			}
			
			this.saveEstadoActivoFijos();
			
			this.connexion.commit();
			
			estadoactivofijoReturnGeneral.setConRetornoEstaProcesado(true);
			estadoactivofijoReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return estadoactivofijoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarEstadoActivoFijosEliminados() throws Exception {				
		
		List<EstadoActivoFijo> estadoactivofijosAux= new ArrayList<EstadoActivoFijo>();
		
		for(EstadoActivoFijo estadoactivofijo:estadoactivofijos) {
			if(!estadoactivofijo.getIsDeleted()) {
				estadoactivofijosAux.add(estadoactivofijo);
			}
		}
		
		estadoactivofijos=estadoactivofijosAux;
	}
	
	public void quitarEstadoActivoFijosNulos() throws Exception {				
		
		List<EstadoActivoFijo> estadoactivofijosAux= new ArrayList<EstadoActivoFijo>();
		
		for(EstadoActivoFijo estadoactivofijo : this.estadoactivofijos) {
			if(estadoactivofijo==null) {
				estadoactivofijosAux.add(estadoactivofijo);
			}
		}
		
		//this.estadoactivofijos=estadoactivofijosAux;
		
		this.estadoactivofijos.removeAll(estadoactivofijosAux);
	}
	
	public void getSetVersionRowEstadoActivoFijoWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(estadoactivofijo.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((estadoactivofijo.getIsDeleted() || (estadoactivofijo.getIsChanged()&&!estadoactivofijo.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=estadoactivofijoDataAccess.getSetVersionRowEstadoActivoFijo(connexion,estadoactivofijo.getId());
				
				if(!estadoactivofijo.getVersionRow().equals(timestamp)) {	
					estadoactivofijo.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				estadoactivofijo.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowEstadoActivoFijo()throws Exception {	
		
		if(estadoactivofijo.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((estadoactivofijo.getIsDeleted() || (estadoactivofijo.getIsChanged()&&!estadoactivofijo.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=estadoactivofijoDataAccess.getSetVersionRowEstadoActivoFijo(connexion,estadoactivofijo.getId());
			
			try {							
				if(!estadoactivofijo.getVersionRow().equals(timestamp)) {	
					estadoactivofijo.setVersionRow(timestamp);
				}
				
				estadoactivofijo.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowEstadoActivoFijosWithConnection()throws Exception {	
		if(estadoactivofijos!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(EstadoActivoFijo estadoactivofijoAux:estadoactivofijos) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(estadoactivofijoAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(estadoactivofijoAux.getIsDeleted() || (estadoactivofijoAux.getIsChanged()&&!estadoactivofijoAux.getIsNew())) {
						
						timestamp=estadoactivofijoDataAccess.getSetVersionRowEstadoActivoFijo(connexion,estadoactivofijoAux.getId());
						
						if(!estadoactivofijo.getVersionRow().equals(timestamp)) {	
							estadoactivofijoAux.setVersionRow(timestamp);
						}
								
						estadoactivofijoAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowEstadoActivoFijos()throws Exception {	
		if(estadoactivofijos!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(EstadoActivoFijo estadoactivofijoAux:estadoactivofijos) {
					if(estadoactivofijoAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(estadoactivofijoAux.getIsDeleted() || (estadoactivofijoAux.getIsChanged()&&!estadoactivofijoAux.getIsNew())) {
						
						timestamp=estadoactivofijoDataAccess.getSetVersionRowEstadoActivoFijo(connexion,estadoactivofijoAux.getId());
						
						if(!estadoactivofijoAux.getVersionRow().equals(timestamp)) {	
							estadoactivofijoAux.setVersionRow(timestamp);
						}
						
													
						estadoactivofijoAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public EstadoActivoFijoParameterReturnGeneral cargarCombosLoteForeignKeyEstadoActivoFijoWithConnection(String finalQueryGlobalEmpresa) throws Exception {
		EstadoActivoFijoParameterReturnGeneral  estadoactivofijoReturnGeneral =new EstadoActivoFijoParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoActivoFijo.class.getSimpleName()+"-cargarCombosLoteForeignKeyEstadoActivoFijoWithConnection");connexion.begin();
			
			estadoactivofijoReturnGeneral =new EstadoActivoFijoParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			estadoactivofijoReturnGeneral.setempresasForeignKey(empresasForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return estadoactivofijoReturnGeneral;
	}
	
	public EstadoActivoFijoParameterReturnGeneral cargarCombosLoteForeignKeyEstadoActivoFijo(String finalQueryGlobalEmpresa) throws Exception {
		EstadoActivoFijoParameterReturnGeneral  estadoactivofijoReturnGeneral =new EstadoActivoFijoParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			estadoactivofijoReturnGeneral =new EstadoActivoFijoParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			estadoactivofijoReturnGeneral.setempresasForeignKey(empresasForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return estadoactivofijoReturnGeneral;
	}
	
	public void cargarRelacionesLoteForeignKeyEstadoActivoFijoWithConnection() throws Exception {
		ArrayList<Classe> classes=new ArrayList<Classe>();		
		
		
			DetalleActivoFijoLogic detalleactivofijoLogic=new DetalleActivoFijoLogic();
			ParteActivoFijoLogic parteactivofijoLogic=new ParteActivoFijoLogic();
		
		try {
			
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoActivoFijo.class.getSimpleName()+"-cargarRelacionesLoteForeignKeyEstadoActivoFijoWithConnection");connexion.begin();
			
			
			classes.add(new Classe(DetalleActivoFijo.class));
			classes.add(new Classe(ParteActivoFijo.class));
											
			

			detalleactivofijoLogic.setConnexion(this.getConnexion());
			detalleactivofijoLogic.setDatosCliente(this.datosCliente);
			detalleactivofijoLogic.setIsConRefrescarForeignKeys(true);

			parteactivofijoLogic.setConnexion(this.getConnexion());
			parteactivofijoLogic.setDatosCliente(this.datosCliente);
			parteactivofijoLogic.setIsConRefrescarForeignKeys(true);
			
			this.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
			
			for(EstadoActivoFijo estadoactivofijo:this.estadoactivofijos) {
				

				classes=new ArrayList<Classe>();
				classes=DetalleActivoFijoConstantesFunciones.getClassesForeignKeysOfDetalleActivoFijo(new ArrayList<Classe>(),DeepLoadType.NONE);

				detalleactivofijoLogic.setDetalleActivoFijos(estadoactivofijo.detalleactivofijos);
				detalleactivofijoLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=ParteActivoFijoConstantesFunciones.getClassesForeignKeysOfParteActivoFijo(new ArrayList<Classe>(),DeepLoadType.NONE);

				parteactivofijoLogic.setParteActivoFijos(estadoactivofijo.parteactivofijos);
				parteactivofijoLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
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
	
	public void deepLoad(EstadoActivoFijo estadoactivofijo,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			//EstadoActivoFijoLogicAdditional.updateEstadoActivoFijoToGet(estadoactivofijo,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		estadoactivofijo.setEmpresa(estadoactivofijoDataAccess.getEmpresa(connexion,estadoactivofijo));
		estadoactivofijo.setDetalleActivoFijos(estadoactivofijoDataAccess.getDetalleActivoFijos(connexion,estadoactivofijo));
		estadoactivofijo.setParteActivoFijos(estadoactivofijoDataAccess.getParteActivoFijos(connexion,estadoactivofijo));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				estadoactivofijo.setEmpresa(estadoactivofijoDataAccess.getEmpresa(connexion,estadoactivofijo));
				continue;
			}

			if(clas.clas.equals(DetalleActivoFijo.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				estadoactivofijo.setDetalleActivoFijos(estadoactivofijoDataAccess.getDetalleActivoFijos(connexion,estadoactivofijo));

				if(this.isConDeep) {
					DetalleActivoFijoLogic detalleactivofijoLogic= new DetalleActivoFijoLogic(this.connexion);
					detalleactivofijoLogic.setDetalleActivoFijos(estadoactivofijo.getDetalleActivoFijos());
					ArrayList<Classe> classesLocal=DetalleActivoFijoConstantesFunciones.getClassesForeignKeysOfDetalleActivoFijo(new ArrayList<Classe>(),DeepLoadType.NONE);
					detalleactivofijoLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					DetalleActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesDetalleActivoFijo(detalleactivofijoLogic.getDetalleActivoFijos());
					estadoactivofijo.setDetalleActivoFijos(detalleactivofijoLogic.getDetalleActivoFijos());
				}

				continue;
			}

			if(clas.clas.equals(ParteActivoFijo.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				estadoactivofijo.setParteActivoFijos(estadoactivofijoDataAccess.getParteActivoFijos(connexion,estadoactivofijo));

				if(this.isConDeep) {
					ParteActivoFijoLogic parteactivofijoLogic= new ParteActivoFijoLogic(this.connexion);
					parteactivofijoLogic.setParteActivoFijos(estadoactivofijo.getParteActivoFijos());
					ArrayList<Classe> classesLocal=ParteActivoFijoConstantesFunciones.getClassesForeignKeysOfParteActivoFijo(new ArrayList<Classe>(),DeepLoadType.NONE);
					parteactivofijoLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					ParteActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesParteActivoFijo(parteactivofijoLogic.getParteActivoFijos());
					estadoactivofijo.setParteActivoFijos(parteactivofijoLogic.getParteActivoFijos());
				}

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
			estadoactivofijo.setEmpresa(estadoactivofijoDataAccess.getEmpresa(connexion,estadoactivofijo));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(DetalleActivoFijo.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(DetalleActivoFijo.class));
			estadoactivofijo.setDetalleActivoFijos(estadoactivofijoDataAccess.getDetalleActivoFijos(connexion,estadoactivofijo));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(ParteActivoFijo.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(ParteActivoFijo.class));
			estadoactivofijo.setParteActivoFijos(estadoactivofijoDataAccess.getParteActivoFijos(connexion,estadoactivofijo));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		estadoactivofijo.setEmpresa(estadoactivofijoDataAccess.getEmpresa(connexion,estadoactivofijo));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(estadoactivofijo.getEmpresa(),isDeep,deepLoadType,clases);
				

		estadoactivofijo.setDetalleActivoFijos(estadoactivofijoDataAccess.getDetalleActivoFijos(connexion,estadoactivofijo));

		for(DetalleActivoFijo detalleactivofijo:estadoactivofijo.getDetalleActivoFijos()) {
			DetalleActivoFijoLogic detalleactivofijoLogic= new DetalleActivoFijoLogic(connexion);
			detalleactivofijoLogic.deepLoad(detalleactivofijo,isDeep,deepLoadType,clases);
		}

		estadoactivofijo.setParteActivoFijos(estadoactivofijoDataAccess.getParteActivoFijos(connexion,estadoactivofijo));

		for(ParteActivoFijo parteactivofijo:estadoactivofijo.getParteActivoFijos()) {
			ParteActivoFijoLogic parteactivofijoLogic= new ParteActivoFijoLogic(connexion);
			parteactivofijoLogic.deepLoad(parteactivofijo,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				estadoactivofijo.setEmpresa(estadoactivofijoDataAccess.getEmpresa(connexion,estadoactivofijo));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(estadoactivofijo.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(DetalleActivoFijo.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				estadoactivofijo.setDetalleActivoFijos(estadoactivofijoDataAccess.getDetalleActivoFijos(connexion,estadoactivofijo));

				for(DetalleActivoFijo detalleactivofijo:estadoactivofijo.getDetalleActivoFijos()) {
					DetalleActivoFijoLogic detalleactivofijoLogic= new DetalleActivoFijoLogic(connexion);
					detalleactivofijoLogic.deepLoad(detalleactivofijo,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(ParteActivoFijo.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				estadoactivofijo.setParteActivoFijos(estadoactivofijoDataAccess.getParteActivoFijos(connexion,estadoactivofijo));

				for(ParteActivoFijo parteactivofijo:estadoactivofijo.getParteActivoFijos()) {
					ParteActivoFijoLogic parteactivofijoLogic= new ParteActivoFijoLogic(connexion);
					parteactivofijoLogic.deepLoad(parteactivofijo,isDeep,deepLoadType,clases);
				}
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
			estadoactivofijo.setEmpresa(estadoactivofijoDataAccess.getEmpresa(connexion,estadoactivofijo));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(estadoactivofijo.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(DetalleActivoFijo.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(DetalleActivoFijo.class));
			estadoactivofijo.setDetalleActivoFijos(estadoactivofijoDataAccess.getDetalleActivoFijos(connexion,estadoactivofijo));

			for(DetalleActivoFijo detalleactivofijo:estadoactivofijo.getDetalleActivoFijos()) {
				DetalleActivoFijoLogic detalleactivofijoLogic= new DetalleActivoFijoLogic(connexion);
				detalleactivofijoLogic.deepLoad(detalleactivofijo,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(ParteActivoFijo.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(ParteActivoFijo.class));
			estadoactivofijo.setParteActivoFijos(estadoactivofijoDataAccess.getParteActivoFijos(connexion,estadoactivofijo));

			for(ParteActivoFijo parteactivofijo:estadoactivofijo.getParteActivoFijos()) {
				ParteActivoFijoLogic parteactivofijoLogic= new ParteActivoFijoLogic(connexion);
				parteactivofijoLogic.deepLoad(parteactivofijo,isDeep,deepLoadType,clases);
			}
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(EstadoActivoFijo estadoactivofijo,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}	
	}
	
	public void deepLoadWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(EstadoActivoFijo.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(estadoactivofijo,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				EstadoActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesEstadoActivoFijo(estadoactivofijo);
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
			this.deepLoad(this.estadoactivofijo,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				EstadoActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesEstadoActivoFijo(this.estadoactivofijo);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(EstadoActivoFijo.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(estadoactivofijos!=null) {
				for(EstadoActivoFijo estadoactivofijo:estadoactivofijos) {
					this.deepLoad(estadoactivofijo,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					EstadoActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesEstadoActivoFijo(estadoactivofijos);
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
			if(estadoactivofijos!=null) {
				for(EstadoActivoFijo estadoactivofijo:estadoactivofijos) {
					this.deepLoad(estadoactivofijo,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					EstadoActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesEstadoActivoFijo(estadoactivofijos);
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
	
	
	public void getEstadoActivoFijosFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoActivoFijo.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,EstadoActivoFijoConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			EstadoActivoFijoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			estadoactivofijos=estadoactivofijoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				EstadoActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesEstadoActivoFijo(this.estadoactivofijos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getEstadoActivoFijosFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,EstadoActivoFijoConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			EstadoActivoFijoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			estadoactivofijos=estadoactivofijoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				EstadoActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesEstadoActivoFijo(this.estadoactivofijos);
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
			if(EstadoActivoFijoConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,EstadoActivoFijoDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,EstadoActivoFijo estadoactivofijo,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(EstadoActivoFijoConstantesFunciones.ISCONAUDITORIA) {
				if(estadoactivofijo.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,EstadoActivoFijoDataAccess.TABLENAME, estadoactivofijo.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(EstadoActivoFijoConstantesFunciones.ISCONAUDITORIADETALLE) {
						////EstadoActivoFijoLogic.registrarAuditoriaDetallesEstadoActivoFijo(connexion,estadoactivofijo,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(estadoactivofijo.getIsDeleted()) {
					/*if(!estadoactivofijo.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,EstadoActivoFijoDataAccess.TABLENAME, estadoactivofijo.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////EstadoActivoFijoLogic.registrarAuditoriaDetallesEstadoActivoFijo(connexion,estadoactivofijo,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,EstadoActivoFijoDataAccess.TABLENAME, estadoactivofijo.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(estadoactivofijo.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,EstadoActivoFijoDataAccess.TABLENAME, estadoactivofijo.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(EstadoActivoFijoConstantesFunciones.ISCONAUDITORIADETALLE) {
						////EstadoActivoFijoLogic.registrarAuditoriaDetallesEstadoActivoFijo(connexion,estadoactivofijo,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesEstadoActivoFijo(Connexion connexion,EstadoActivoFijo estadoactivofijo)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(estadoactivofijo.getIsNew()||!estadoactivofijo.getid_empresa().equals(estadoactivofijo.getEstadoActivoFijoOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(estadoactivofijo.getEstadoActivoFijoOriginal().getid_empresa()!=null)
				{
					strValorActual=estadoactivofijo.getEstadoActivoFijoOriginal().getid_empresa().toString();
				}
				if(estadoactivofijo.getid_empresa()!=null)
				{
					strValorNuevo=estadoactivofijo.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),EstadoActivoFijoConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(estadoactivofijo.getIsNew()||!estadoactivofijo.getcodigo().equals(estadoactivofijo.getEstadoActivoFijoOriginal().getcodigo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(estadoactivofijo.getEstadoActivoFijoOriginal().getcodigo()!=null)
				{
					strValorActual=estadoactivofijo.getEstadoActivoFijoOriginal().getcodigo();
				}
				if(estadoactivofijo.getcodigo()!=null)
				{
					strValorNuevo=estadoactivofijo.getcodigo() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),EstadoActivoFijoConstantesFunciones.CODIGO,strValorActual,strValorNuevo);
			}	
			
			if(estadoactivofijo.getIsNew()||!estadoactivofijo.getnombre().equals(estadoactivofijo.getEstadoActivoFijoOriginal().getnombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(estadoactivofijo.getEstadoActivoFijoOriginal().getnombre()!=null)
				{
					strValorActual=estadoactivofijo.getEstadoActivoFijoOriginal().getnombre();
				}
				if(estadoactivofijo.getnombre()!=null)
				{
					strValorNuevo=estadoactivofijo.getnombre() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),EstadoActivoFijoConstantesFunciones.NOMBRE,strValorActual,strValorNuevo);
			}	
	}
	
	
//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfEstadoActivoFijo(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=EstadoActivoFijoConstantesFunciones.getClassesForeignKeysOfEstadoActivoFijo(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfEstadoActivoFijo(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=EstadoActivoFijoConstantesFunciones.getClassesRelationshipsOfEstadoActivoFijo(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
}

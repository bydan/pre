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
import com.bydan.erp.activosfijos.util.MetodoDepreciacionConstantesFunciones;
import com.bydan.erp.activosfijos.util.MetodoDepreciacionParameterReturnGeneral;
//import com.bydan.erp.activosfijos.util.MetodoDepreciacionParameterGeneral;
import com.bydan.erp.activosfijos.business.entity.MetodoDepreciacion;
import com.bydan.erp.activosfijos.business.logic.MetodoDepreciacionLogicAdditional;
import com.bydan.erp.activosfijos.business.dataaccess.*;
import com.bydan.erp.activosfijos.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;


import com.bydan.erp.seguridad.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;








@SuppressWarnings("unused")
public class MetodoDepreciacionLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(MetodoDepreciacionLogic.class);
	
	protected MetodoDepreciacionDataAccess metododepreciacionDataAccess; 	
	protected MetodoDepreciacion metododepreciacion;
	protected List<MetodoDepreciacion> metododepreciacions;
	protected Object metododepreciacionObject;	
	protected List<Object> metododepreciacionsObject;
	
	public static ClassValidator<MetodoDepreciacion> metododepreciacionValidator = new ClassValidator<MetodoDepreciacion>(MetodoDepreciacion.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected MetodoDepreciacionLogicAdditional metododepreciacionLogicAdditional=null;
	
	public MetodoDepreciacionLogicAdditional getMetodoDepreciacionLogicAdditional() {
		return this.metododepreciacionLogicAdditional;
	}
	
	public void setMetodoDepreciacionLogicAdditional(MetodoDepreciacionLogicAdditional metododepreciacionLogicAdditional) {
		try {
			this.metododepreciacionLogicAdditional=metododepreciacionLogicAdditional;
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
	
	
	
	
	public  MetodoDepreciacionLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.metododepreciacionDataAccess = new MetodoDepreciacionDataAccess();
			
			this.metododepreciacions= new ArrayList<MetodoDepreciacion>();
			this.metododepreciacion= new MetodoDepreciacion();
			
			this.metododepreciacionObject=new Object();
			this.metododepreciacionsObject=new ArrayList<Object>();
				
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
			
			this.metododepreciacionDataAccess.setConnexionType(this.connexionType);
			this.metododepreciacionDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  MetodoDepreciacionLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.metododepreciacionDataAccess = new MetodoDepreciacionDataAccess();
			this.metododepreciacions= new ArrayList<MetodoDepreciacion>();
			this.metododepreciacion= new MetodoDepreciacion();
			this.metododepreciacionObject=new Object();
			this.metododepreciacionsObject=new ArrayList<Object>();
			
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
			
			this.metododepreciacionDataAccess.setConnexionType(this.connexionType);
			this.metododepreciacionDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public MetodoDepreciacion getMetodoDepreciacion() throws Exception {	
		MetodoDepreciacionLogicAdditional.checkMetodoDepreciacionToGet(metododepreciacion,this.datosCliente,this.arrDatoGeneral);
		MetodoDepreciacionLogicAdditional.updateMetodoDepreciacionToGet(metododepreciacion,this.arrDatoGeneral);
		
		return metododepreciacion;
	}
		
	public void setMetodoDepreciacion(MetodoDepreciacion newMetodoDepreciacion) {
		this.metododepreciacion = newMetodoDepreciacion;
	}
	
	public MetodoDepreciacionDataAccess getMetodoDepreciacionDataAccess() {
		return metododepreciacionDataAccess;
	}
	
	public void setMetodoDepreciacionDataAccess(MetodoDepreciacionDataAccess newmetododepreciacionDataAccess) {
		this.metododepreciacionDataAccess = newmetododepreciacionDataAccess;
	}
	
	public List<MetodoDepreciacion> getMetodoDepreciacions() throws Exception {		
		this.quitarMetodoDepreciacionsNulos();
		
		MetodoDepreciacionLogicAdditional.checkMetodoDepreciacionToGets(metododepreciacions,this.datosCliente,this.arrDatoGeneral);
		
		for (MetodoDepreciacion metododepreciacionLocal: metododepreciacions ) {
			MetodoDepreciacionLogicAdditional.updateMetodoDepreciacionToGet(metododepreciacionLocal,this.arrDatoGeneral);
		}
		
		return metododepreciacions;
	}
	
	public void setMetodoDepreciacions(List<MetodoDepreciacion> newMetodoDepreciacions) {
		this.metododepreciacions = newMetodoDepreciacions;
	}
	
	public Object getMetodoDepreciacionObject() {	
		this.metododepreciacionObject=this.metododepreciacionDataAccess.getEntityObject();
		return this.metododepreciacionObject;
	}
		
	public void setMetodoDepreciacionObject(Object newMetodoDepreciacionObject) {
		this.metododepreciacionObject = newMetodoDepreciacionObject;
	}
	
	public List<Object> getMetodoDepreciacionsObject() {		
		this.metododepreciacionsObject=this.metododepreciacionDataAccess.getEntitiesObject();
		return this.metododepreciacionsObject;
	}
		
	public void setMetodoDepreciacionsObject(List<Object> newMetodoDepreciacionsObject) {
		this.metododepreciacionsObject = newMetodoDepreciacionsObject;
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
		
		if(this.metododepreciacionDataAccess!=null) {
			this.metododepreciacionDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,MetodoDepreciacion.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			metododepreciacionDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			metododepreciacionDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		metododepreciacion = new  MetodoDepreciacion();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,MetodoDepreciacion.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			metododepreciacion=metododepreciacionDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.metododepreciacion,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				MetodoDepreciacionConstantesFunciones.refrescarForeignKeysDescripcionesMetodoDepreciacion(this.metododepreciacion);
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
		metododepreciacion = new  MetodoDepreciacion();
		  		  
        try {
			
			metododepreciacion=metododepreciacionDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.metododepreciacion,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				MetodoDepreciacionConstantesFunciones.refrescarForeignKeysDescripcionesMetodoDepreciacion(this.metododepreciacion);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		metododepreciacion = new  MetodoDepreciacion();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,MetodoDepreciacion.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			metododepreciacion=metododepreciacionDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.metododepreciacion,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				MetodoDepreciacionConstantesFunciones.refrescarForeignKeysDescripcionesMetodoDepreciacion(this.metododepreciacion);
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
		metododepreciacion = new  MetodoDepreciacion();
		  		  
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
		metododepreciacion = new  MetodoDepreciacion();
		  		  
        try {
			
			metododepreciacion=metododepreciacionDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.metododepreciacion,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				MetodoDepreciacionConstantesFunciones.refrescarForeignKeysDescripcionesMetodoDepreciacion(this.metododepreciacion);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		metododepreciacion = new  MetodoDepreciacion();
		  		  
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
		metododepreciacion = new  MetodoDepreciacion();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,MetodoDepreciacion.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =metododepreciacionDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		metododepreciacion = new  MetodoDepreciacion();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=metododepreciacionDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		metododepreciacion = new  MetodoDepreciacion();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,MetodoDepreciacion.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =metododepreciacionDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		metododepreciacion = new  MetodoDepreciacion();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=metododepreciacionDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		metododepreciacion = new  MetodoDepreciacion();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,MetodoDepreciacion.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =metododepreciacionDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		metododepreciacion = new  MetodoDepreciacion();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=metododepreciacionDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		metododepreciacions = new  ArrayList<MetodoDepreciacion>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,MetodoDepreciacion.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			MetodoDepreciacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			metododepreciacions=metododepreciacionDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarMetodoDepreciacion(metododepreciacions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				MetodoDepreciacionConstantesFunciones.refrescarForeignKeysDescripcionesMetodoDepreciacion(this.metododepreciacions);
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
		metododepreciacions = new  ArrayList<MetodoDepreciacion>();
		  		  
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
		metododepreciacions = new  ArrayList<MetodoDepreciacion>();
		  		  
        try {			
			MetodoDepreciacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			metododepreciacions=metododepreciacionDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarMetodoDepreciacion(metododepreciacions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				MetodoDepreciacionConstantesFunciones.refrescarForeignKeysDescripcionesMetodoDepreciacion(this.metododepreciacions);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		metododepreciacions = new  ArrayList<MetodoDepreciacion>();
		  		  
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
		metododepreciacions = new  ArrayList<MetodoDepreciacion>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,MetodoDepreciacion.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			MetodoDepreciacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			metododepreciacions=metododepreciacionDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarMetodoDepreciacion(metododepreciacions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				MetodoDepreciacionConstantesFunciones.refrescarForeignKeysDescripcionesMetodoDepreciacion(this.metododepreciacions);
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
		metododepreciacions = new  ArrayList<MetodoDepreciacion>();
		  		  
        try {
			MetodoDepreciacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			metododepreciacions=metododepreciacionDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarMetodoDepreciacion(metododepreciacions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				MetodoDepreciacionConstantesFunciones.refrescarForeignKeysDescripcionesMetodoDepreciacion(this.metododepreciacions);
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
		metododepreciacions = new  ArrayList<MetodoDepreciacion>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,MetodoDepreciacion.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			MetodoDepreciacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			metododepreciacions=metododepreciacionDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarMetodoDepreciacion(metododepreciacions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				MetodoDepreciacionConstantesFunciones.refrescarForeignKeysDescripcionesMetodoDepreciacion(this.metododepreciacions);
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
		metododepreciacions = new  ArrayList<MetodoDepreciacion>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			MetodoDepreciacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			metododepreciacions=metododepreciacionDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarMetodoDepreciacion(metododepreciacions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				MetodoDepreciacionConstantesFunciones.refrescarForeignKeysDescripcionesMetodoDepreciacion(this.metododepreciacions);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		metododepreciacion = new  MetodoDepreciacion();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,MetodoDepreciacion.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			MetodoDepreciacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			metododepreciacion=metododepreciacionDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarMetodoDepreciacion(metododepreciacion);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				MetodoDepreciacionConstantesFunciones.refrescarForeignKeysDescripcionesMetodoDepreciacion(this.metododepreciacion);
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
		metododepreciacion = new  MetodoDepreciacion();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			MetodoDepreciacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			metododepreciacion=metododepreciacionDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarMetodoDepreciacion(metododepreciacion);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				MetodoDepreciacionConstantesFunciones.refrescarForeignKeysDescripcionesMetodoDepreciacion(this.metododepreciacion);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		metododepreciacions = new  ArrayList<MetodoDepreciacion>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,MetodoDepreciacion.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			MetodoDepreciacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			metododepreciacions=metododepreciacionDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarMetodoDepreciacion(metododepreciacions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				MetodoDepreciacionConstantesFunciones.refrescarForeignKeysDescripcionesMetodoDepreciacion(this.metododepreciacions);
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
		metododepreciacions = new  ArrayList<MetodoDepreciacion>();
		  		  
        try {
			MetodoDepreciacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			metododepreciacions=metododepreciacionDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarMetodoDepreciacion(metododepreciacions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				MetodoDepreciacionConstantesFunciones.refrescarForeignKeysDescripcionesMetodoDepreciacion(this.metododepreciacions);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosMetodoDepreciacionsWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		metododepreciacions = new  ArrayList<MetodoDepreciacion>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,MetodoDepreciacion.class.getSimpleName()+"-getTodosMetodoDepreciacionsWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			MetodoDepreciacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			metododepreciacions=metododepreciacionDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarMetodoDepreciacion(metododepreciacions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				MetodoDepreciacionConstantesFunciones.refrescarForeignKeysDescripcionesMetodoDepreciacion(this.metododepreciacions);
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
	
	public  void  getTodosMetodoDepreciacions(String sFinalQuery,Pagination pagination)throws Exception {
		metododepreciacions = new  ArrayList<MetodoDepreciacion>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			MetodoDepreciacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			metododepreciacions=metododepreciacionDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarMetodoDepreciacion(metododepreciacions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				MetodoDepreciacionConstantesFunciones.refrescarForeignKeysDescripcionesMetodoDepreciacion(this.metododepreciacions);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarMetodoDepreciacion(MetodoDepreciacion metododepreciacion) throws Exception {
		Boolean estaValidado=false;
		
		if(metododepreciacion.getIsNew() || metododepreciacion.getIsChanged()) { 
			this.invalidValues = metododepreciacionValidator.getInvalidValues(metododepreciacion);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(metododepreciacion);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarMetodoDepreciacion(List<MetodoDepreciacion> MetodoDepreciacions) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(MetodoDepreciacion metododepreciacionLocal:metododepreciacions) {				
			estaValidadoObjeto=this.validarGuardarMetodoDepreciacion(metododepreciacionLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarMetodoDepreciacion(List<MetodoDepreciacion> MetodoDepreciacions) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarMetodoDepreciacion(metododepreciacions)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarMetodoDepreciacion(MetodoDepreciacion MetodoDepreciacion) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarMetodoDepreciacion(metododepreciacion)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(MetodoDepreciacion metododepreciacion) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+metododepreciacion.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=MetodoDepreciacionConstantesFunciones.getMetodoDepreciacionLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"metododepreciacion","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(MetodoDepreciacionConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(MetodoDepreciacionConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveMetodoDepreciacionWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,MetodoDepreciacion.class.getSimpleName()+"-saveMetodoDepreciacionWithConnection");connexion.begin();			
			
			MetodoDepreciacionLogicAdditional.checkMetodoDepreciacionToSave(this.metododepreciacion,this.datosCliente,connexion,this.arrDatoGeneral);
			
			MetodoDepreciacionLogicAdditional.updateMetodoDepreciacionToSave(this.metododepreciacion,this.arrDatoGeneral);
			
			MetodoDepreciacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.metododepreciacion,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowMetodoDepreciacion();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarMetodoDepreciacion(this.metododepreciacion)) {
				MetodoDepreciacionDataAccess.save(this.metododepreciacion, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.metododepreciacion,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			MetodoDepreciacionLogicAdditional.checkMetodoDepreciacionToSaveAfter(this.metododepreciacion,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowMetodoDepreciacion();
			
			connexion.commit();			
			
			if(this.metododepreciacion.getIsDeleted()) {
				this.metododepreciacion=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveMetodoDepreciacion()throws Exception {	
		try {	
			
			MetodoDepreciacionLogicAdditional.checkMetodoDepreciacionToSave(this.metododepreciacion,this.datosCliente,connexion,this.arrDatoGeneral);
			
			MetodoDepreciacionLogicAdditional.updateMetodoDepreciacionToSave(this.metododepreciacion,this.arrDatoGeneral);
			
			MetodoDepreciacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.metododepreciacion,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarMetodoDepreciacion(this.metododepreciacion)) {			
				MetodoDepreciacionDataAccess.save(this.metododepreciacion, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.metododepreciacion,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			MetodoDepreciacionLogicAdditional.checkMetodoDepreciacionToSaveAfter(this.metododepreciacion,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.metododepreciacion.getIsDeleted()) {
				this.metododepreciacion=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveMetodoDepreciacionsWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,MetodoDepreciacion.class.getSimpleName()+"-saveMetodoDepreciacionsWithConnection");connexion.begin();			
			
			MetodoDepreciacionLogicAdditional.checkMetodoDepreciacionToSaves(metododepreciacions,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowMetodoDepreciacions();
			
			Boolean validadoTodosMetodoDepreciacion=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(MetodoDepreciacion metododepreciacionLocal:metododepreciacions) {		
				if(metododepreciacionLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				MetodoDepreciacionLogicAdditional.updateMetodoDepreciacionToSave(metododepreciacionLocal,this.arrDatoGeneral);
	        	
				MetodoDepreciacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),metododepreciacionLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarMetodoDepreciacion(metododepreciacionLocal)) {
					MetodoDepreciacionDataAccess.save(metododepreciacionLocal, connexion);				
				} else {
					validadoTodosMetodoDepreciacion=false;
				}
			}
			
			if(!validadoTodosMetodoDepreciacion) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			MetodoDepreciacionLogicAdditional.checkMetodoDepreciacionToSavesAfter(metododepreciacions,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowMetodoDepreciacions();
			
			connexion.commit();		
			
			this.quitarMetodoDepreciacionsEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveMetodoDepreciacions()throws Exception {				
		 try {	
			MetodoDepreciacionLogicAdditional.checkMetodoDepreciacionToSaves(metododepreciacions,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosMetodoDepreciacion=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(MetodoDepreciacion metododepreciacionLocal:metododepreciacions) {				
				if(metododepreciacionLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				MetodoDepreciacionLogicAdditional.updateMetodoDepreciacionToSave(metododepreciacionLocal,this.arrDatoGeneral);
	        	
				MetodoDepreciacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),metododepreciacionLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarMetodoDepreciacion(metododepreciacionLocal)) {				
					MetodoDepreciacionDataAccess.save(metododepreciacionLocal, connexion);				
				} else {
					validadoTodosMetodoDepreciacion=false;
				}
			}
			
			if(!validadoTodosMetodoDepreciacion) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			MetodoDepreciacionLogicAdditional.checkMetodoDepreciacionToSavesAfter(metododepreciacions,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarMetodoDepreciacionsEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public MetodoDepreciacionParameterReturnGeneral procesarAccionMetodoDepreciacions(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<MetodoDepreciacion> metododepreciacions,MetodoDepreciacionParameterReturnGeneral metododepreciacionParameterGeneral)throws Exception {
		 try {	
			MetodoDepreciacionParameterReturnGeneral metododepreciacionReturnGeneral=new MetodoDepreciacionParameterReturnGeneral();
	
			MetodoDepreciacionLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,metododepreciacions,metododepreciacionParameterGeneral,metododepreciacionReturnGeneral);
			
			return metododepreciacionReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public MetodoDepreciacionParameterReturnGeneral procesarAccionMetodoDepreciacionsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<MetodoDepreciacion> metododepreciacions,MetodoDepreciacionParameterReturnGeneral metododepreciacionParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,MetodoDepreciacion.class.getSimpleName()+"-procesarAccionMetodoDepreciacionsWithConnection");connexion.begin();			
			
			MetodoDepreciacionParameterReturnGeneral metododepreciacionReturnGeneral=new MetodoDepreciacionParameterReturnGeneral();
	
			MetodoDepreciacionLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,metododepreciacions,metododepreciacionParameterGeneral,metododepreciacionReturnGeneral);
			
			this.connexion.commit();
			
			return metododepreciacionReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public MetodoDepreciacionParameterReturnGeneral procesarEventosMetodoDepreciacions(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<MetodoDepreciacion> metododepreciacions,MetodoDepreciacion metododepreciacion,MetodoDepreciacionParameterReturnGeneral metododepreciacionParameterGeneral,Boolean isEsNuevoMetodoDepreciacion,ArrayList<Classe> clases)throws Exception {
		 try {	
			MetodoDepreciacionParameterReturnGeneral metododepreciacionReturnGeneral=new MetodoDepreciacionParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				metododepreciacionReturnGeneral.setConRecargarPropiedades(true);
			}
			
			MetodoDepreciacionLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,metododepreciacions,metododepreciacion,metododepreciacionParameterGeneral,metododepreciacionReturnGeneral,isEsNuevoMetodoDepreciacion,clases);
			
			return metododepreciacionReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public MetodoDepreciacionParameterReturnGeneral procesarEventosMetodoDepreciacionsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<MetodoDepreciacion> metododepreciacions,MetodoDepreciacion metododepreciacion,MetodoDepreciacionParameterReturnGeneral metododepreciacionParameterGeneral,Boolean isEsNuevoMetodoDepreciacion,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,MetodoDepreciacion.class.getSimpleName()+"-procesarEventosMetodoDepreciacionsWithConnection");connexion.begin();			
			
			MetodoDepreciacionParameterReturnGeneral metododepreciacionReturnGeneral=new MetodoDepreciacionParameterReturnGeneral();
	
			metododepreciacionReturnGeneral.setMetodoDepreciacion(metododepreciacion);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				metododepreciacionReturnGeneral.setConRecargarPropiedades(true);
			}
			
			MetodoDepreciacionLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,metododepreciacions,metododepreciacion,metododepreciacionParameterGeneral,metododepreciacionReturnGeneral,isEsNuevoMetodoDepreciacion,clases);
			
			this.connexion.commit();
			
			return metododepreciacionReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public MetodoDepreciacionParameterReturnGeneral procesarImportacionMetodoDepreciacionsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,MetodoDepreciacionParameterReturnGeneral metododepreciacionParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,MetodoDepreciacion.class.getSimpleName()+"-procesarImportacionMetodoDepreciacionsWithConnection");connexion.begin();			
			
			MetodoDepreciacionParameterReturnGeneral metododepreciacionReturnGeneral=new MetodoDepreciacionParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.metododepreciacions=new ArrayList<MetodoDepreciacion>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.metododepreciacion=new MetodoDepreciacion();
				
				
				if(conColumnasBase) {this.metododepreciacion.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.metododepreciacion.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.metododepreciacion.setfecha_desde(Funciones.ConvertToDate(arrColumnas[iColumn++]));
				this.metododepreciacion.setfecha_hasta(Funciones.ConvertToDate(arrColumnas[iColumn++]));
				this.metododepreciacion.setporcentaje(Double.parseDouble(arrColumnas[iColumn++]));
				this.metododepreciacion.setvalor(Double.parseDouble(arrColumnas[iColumn++]));
				this.metododepreciacion.setnumero_dias(Integer.parseInt(arrColumnas[iColumn++]));
				
				this.metododepreciacions.add(this.metododepreciacion);
			}
			
			this.saveMetodoDepreciacions();
			
			this.connexion.commit();
			
			metododepreciacionReturnGeneral.setConRetornoEstaProcesado(true);
			metododepreciacionReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return metododepreciacionReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarMetodoDepreciacionsEliminados() throws Exception {				
		
		List<MetodoDepreciacion> metododepreciacionsAux= new ArrayList<MetodoDepreciacion>();
		
		for(MetodoDepreciacion metododepreciacion:metododepreciacions) {
			if(!metododepreciacion.getIsDeleted()) {
				metododepreciacionsAux.add(metododepreciacion);
			}
		}
		
		metododepreciacions=metododepreciacionsAux;
	}
	
	public void quitarMetodoDepreciacionsNulos() throws Exception {				
		
		List<MetodoDepreciacion> metododepreciacionsAux= new ArrayList<MetodoDepreciacion>();
		
		for(MetodoDepreciacion metododepreciacion : this.metododepreciacions) {
			if(metododepreciacion==null) {
				metododepreciacionsAux.add(metododepreciacion);
			}
		}
		
		//this.metododepreciacions=metododepreciacionsAux;
		
		this.metododepreciacions.removeAll(metododepreciacionsAux);
	}
	
	public void getSetVersionRowMetodoDepreciacionWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(metododepreciacion.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((metododepreciacion.getIsDeleted() || (metododepreciacion.getIsChanged()&&!metododepreciacion.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=metododepreciacionDataAccess.getSetVersionRowMetodoDepreciacion(connexion,metododepreciacion.getId());
				
				if(!metododepreciacion.getVersionRow().equals(timestamp)) {	
					metododepreciacion.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				metododepreciacion.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowMetodoDepreciacion()throws Exception {	
		
		if(metododepreciacion.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((metododepreciacion.getIsDeleted() || (metododepreciacion.getIsChanged()&&!metododepreciacion.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=metododepreciacionDataAccess.getSetVersionRowMetodoDepreciacion(connexion,metododepreciacion.getId());
			
			try {							
				if(!metododepreciacion.getVersionRow().equals(timestamp)) {	
					metododepreciacion.setVersionRow(timestamp);
				}
				
				metododepreciacion.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowMetodoDepreciacionsWithConnection()throws Exception {	
		if(metododepreciacions!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(MetodoDepreciacion metododepreciacionAux:metododepreciacions) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(metododepreciacionAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(metododepreciacionAux.getIsDeleted() || (metododepreciacionAux.getIsChanged()&&!metododepreciacionAux.getIsNew())) {
						
						timestamp=metododepreciacionDataAccess.getSetVersionRowMetodoDepreciacion(connexion,metododepreciacionAux.getId());
						
						if(!metododepreciacion.getVersionRow().equals(timestamp)) {	
							metododepreciacionAux.setVersionRow(timestamp);
						}
								
						metododepreciacionAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowMetodoDepreciacions()throws Exception {	
		if(metododepreciacions!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(MetodoDepreciacion metododepreciacionAux:metododepreciacions) {
					if(metododepreciacionAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(metododepreciacionAux.getIsDeleted() || (metododepreciacionAux.getIsChanged()&&!metododepreciacionAux.getIsNew())) {
						
						timestamp=metododepreciacionDataAccess.getSetVersionRowMetodoDepreciacion(connexion,metododepreciacionAux.getId());
						
						if(!metododepreciacionAux.getVersionRow().equals(timestamp)) {	
							metododepreciacionAux.setVersionRow(timestamp);
						}
						
													
						metododepreciacionAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public MetodoDepreciacionParameterReturnGeneral cargarCombosLoteForeignKeyMetodoDepreciacionWithConnection(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalDetalleActivoFijo,String finalQueryGlobalAnio) throws Exception {
		MetodoDepreciacionParameterReturnGeneral  metododepreciacionReturnGeneral =new MetodoDepreciacionParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,MetodoDepreciacion.class.getSimpleName()+"-cargarCombosLoteForeignKeyMetodoDepreciacionWithConnection");connexion.begin();
			
			metododepreciacionReturnGeneral =new MetodoDepreciacionParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			metododepreciacionReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			metododepreciacionReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<DetalleActivoFijo> detalleactivofijosForeignKey=new ArrayList<DetalleActivoFijo>();
			DetalleActivoFijoLogic detalleactivofijoLogic=new DetalleActivoFijoLogic();
			detalleactivofijoLogic.setConnexion(this.connexion);
			detalleactivofijoLogic.getDetalleActivoFijoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalDetalleActivoFijo.equals("NONE")) {
				detalleactivofijoLogic.getTodosDetalleActivoFijos(finalQueryGlobalDetalleActivoFijo,new Pagination());
				detalleactivofijosForeignKey=detalleactivofijoLogic.getDetalleActivoFijos();
			}

			metododepreciacionReturnGeneral.setdetalleactivofijosForeignKey(detalleactivofijosForeignKey);


			List<Anio> aniosForeignKey=new ArrayList<Anio>();
			AnioLogic anioLogic=new AnioLogic();
			anioLogic.setConnexion(this.connexion);
			anioLogic.getAnioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalAnio.equals("NONE")) {
				anioLogic.getTodosAnios(finalQueryGlobalAnio,new Pagination());
				aniosForeignKey=anioLogic.getAnios();
			}

			metododepreciacionReturnGeneral.setaniosForeignKey(aniosForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return metododepreciacionReturnGeneral;
	}
	
	public MetodoDepreciacionParameterReturnGeneral cargarCombosLoteForeignKeyMetodoDepreciacion(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalDetalleActivoFijo,String finalQueryGlobalAnio) throws Exception {
		MetodoDepreciacionParameterReturnGeneral  metododepreciacionReturnGeneral =new MetodoDepreciacionParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			metododepreciacionReturnGeneral =new MetodoDepreciacionParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			metododepreciacionReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			metododepreciacionReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<DetalleActivoFijo> detalleactivofijosForeignKey=new ArrayList<DetalleActivoFijo>();
			DetalleActivoFijoLogic detalleactivofijoLogic=new DetalleActivoFijoLogic();
			detalleactivofijoLogic.setConnexion(this.connexion);
			detalleactivofijoLogic.getDetalleActivoFijoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalDetalleActivoFijo.equals("NONE")) {
				detalleactivofijoLogic.getTodosDetalleActivoFijos(finalQueryGlobalDetalleActivoFijo,new Pagination());
				detalleactivofijosForeignKey=detalleactivofijoLogic.getDetalleActivoFijos();
			}

			metododepreciacionReturnGeneral.setdetalleactivofijosForeignKey(detalleactivofijosForeignKey);


			List<Anio> aniosForeignKey=new ArrayList<Anio>();
			AnioLogic anioLogic=new AnioLogic();
			anioLogic.setConnexion(this.connexion);
			anioLogic.getAnioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalAnio.equals("NONE")) {
				anioLogic.getTodosAnios(finalQueryGlobalAnio,new Pagination());
				aniosForeignKey=anioLogic.getAnios();
			}

			metododepreciacionReturnGeneral.setaniosForeignKey(aniosForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return metododepreciacionReturnGeneral;
	}
	
	
	public void deepLoad(MetodoDepreciacion metododepreciacion,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			MetodoDepreciacionLogicAdditional.updateMetodoDepreciacionToGet(metododepreciacion,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		metododepreciacion.setEmpresa(metododepreciacionDataAccess.getEmpresa(connexion,metododepreciacion));
		metododepreciacion.setSucursal(metododepreciacionDataAccess.getSucursal(connexion,metododepreciacion));
		metododepreciacion.setDetalleActivoFijo(metododepreciacionDataAccess.getDetalleActivoFijo(connexion,metododepreciacion));
		metododepreciacion.setAnio(metododepreciacionDataAccess.getAnio(connexion,metododepreciacion));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				metododepreciacion.setEmpresa(metododepreciacionDataAccess.getEmpresa(connexion,metododepreciacion));
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				metododepreciacion.setSucursal(metododepreciacionDataAccess.getSucursal(connexion,metododepreciacion));
				continue;
			}

			if(clas.clas.equals(DetalleActivoFijo.class)) {
				metododepreciacion.setDetalleActivoFijo(metododepreciacionDataAccess.getDetalleActivoFijo(connexion,metododepreciacion));
				continue;
			}

			if(clas.clas.equals(Anio.class)) {
				metododepreciacion.setAnio(metododepreciacionDataAccess.getAnio(connexion,metododepreciacion));
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
			metododepreciacion.setEmpresa(metododepreciacionDataAccess.getEmpresa(connexion,metododepreciacion));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			metododepreciacion.setSucursal(metododepreciacionDataAccess.getSucursal(connexion,metododepreciacion));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(DetalleActivoFijo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			metododepreciacion.setDetalleActivoFijo(metododepreciacionDataAccess.getDetalleActivoFijo(connexion,metododepreciacion));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Anio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			metododepreciacion.setAnio(metododepreciacionDataAccess.getAnio(connexion,metododepreciacion));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		metododepreciacion.setEmpresa(metododepreciacionDataAccess.getEmpresa(connexion,metododepreciacion));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(metododepreciacion.getEmpresa(),isDeep,deepLoadType,clases);
				
		metododepreciacion.setSucursal(metododepreciacionDataAccess.getSucursal(connexion,metododepreciacion));
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(metododepreciacion.getSucursal(),isDeep,deepLoadType,clases);
				
		metododepreciacion.setDetalleActivoFijo(metododepreciacionDataAccess.getDetalleActivoFijo(connexion,metododepreciacion));
		DetalleActivoFijoLogic detalleactivofijoLogic= new DetalleActivoFijoLogic(connexion);
		detalleactivofijoLogic.deepLoad(metododepreciacion.getDetalleActivoFijo(),isDeep,deepLoadType,clases);
				
		metododepreciacion.setAnio(metododepreciacionDataAccess.getAnio(connexion,metododepreciacion));
		AnioLogic anioLogic= new AnioLogic(connexion);
		anioLogic.deepLoad(metododepreciacion.getAnio(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				metododepreciacion.setEmpresa(metododepreciacionDataAccess.getEmpresa(connexion,metododepreciacion));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(metododepreciacion.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				metododepreciacion.setSucursal(metododepreciacionDataAccess.getSucursal(connexion,metododepreciacion));
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepLoad(metododepreciacion.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(DetalleActivoFijo.class)) {
				metododepreciacion.setDetalleActivoFijo(metododepreciacionDataAccess.getDetalleActivoFijo(connexion,metododepreciacion));
				DetalleActivoFijoLogic detalleactivofijoLogic= new DetalleActivoFijoLogic(connexion);
				detalleactivofijoLogic.deepLoad(metododepreciacion.getDetalleActivoFijo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Anio.class)) {
				metododepreciacion.setAnio(metododepreciacionDataAccess.getAnio(connexion,metododepreciacion));
				AnioLogic anioLogic= new AnioLogic(connexion);
				anioLogic.deepLoad(metododepreciacion.getAnio(),isDeep,deepLoadType,clases);				
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
			metododepreciacion.setEmpresa(metododepreciacionDataAccess.getEmpresa(connexion,metododepreciacion));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(metododepreciacion.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			metododepreciacion.setSucursal(metododepreciacionDataAccess.getSucursal(connexion,metododepreciacion));
			SucursalLogic sucursalLogic= new SucursalLogic(connexion);
			sucursalLogic.deepLoad(metododepreciacion.getSucursal(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(DetalleActivoFijo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			metododepreciacion.setDetalleActivoFijo(metododepreciacionDataAccess.getDetalleActivoFijo(connexion,metododepreciacion));
			DetalleActivoFijoLogic detalleactivofijoLogic= new DetalleActivoFijoLogic(connexion);
			detalleactivofijoLogic.deepLoad(metododepreciacion.getDetalleActivoFijo(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Anio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			metododepreciacion.setAnio(metododepreciacionDataAccess.getAnio(connexion,metododepreciacion));
			AnioLogic anioLogic= new AnioLogic(connexion);
			anioLogic.deepLoad(metododepreciacion.getAnio(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(MetodoDepreciacion metododepreciacion,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			MetodoDepreciacionLogicAdditional.updateMetodoDepreciacionToSave(metododepreciacion,this.arrDatoGeneral);
			
MetodoDepreciacionDataAccess.save(metododepreciacion, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(metododepreciacion.getEmpresa(),connexion);

		SucursalDataAccess.save(metododepreciacion.getSucursal(),connexion);

		DetalleActivoFijoDataAccess.save(metododepreciacion.getDetalleActivoFijo(),connexion);

		AnioDataAccess.save(metododepreciacion.getAnio(),connexion);
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(metododepreciacion.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(metododepreciacion.getSucursal(),connexion);
				continue;
			}

			if(clas.clas.equals(DetalleActivoFijo.class)) {
				DetalleActivoFijoDataAccess.save(metododepreciacion.getDetalleActivoFijo(),connexion);
				continue;
			}

			if(clas.clas.equals(Anio.class)) {
				AnioDataAccess.save(metododepreciacion.getAnio(),connexion);
				continue;
			}

		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(metododepreciacion.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(metododepreciacion.getEmpresa(),isDeep,deepLoadType,clases);
				

		SucursalDataAccess.save(metododepreciacion.getSucursal(),connexion);
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(metododepreciacion.getSucursal(),isDeep,deepLoadType,clases);
				

		DetalleActivoFijoDataAccess.save(metododepreciacion.getDetalleActivoFijo(),connexion);
		DetalleActivoFijoLogic detalleactivofijoLogic= new DetalleActivoFijoLogic(connexion);
		detalleactivofijoLogic.deepLoad(metododepreciacion.getDetalleActivoFijo(),isDeep,deepLoadType,clases);
				

		AnioDataAccess.save(metododepreciacion.getAnio(),connexion);
		AnioLogic anioLogic= new AnioLogic(connexion);
		anioLogic.deepLoad(metododepreciacion.getAnio(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(metododepreciacion.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(metododepreciacion.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(metododepreciacion.getSucursal(),connexion);
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepSave(metododepreciacion.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(DetalleActivoFijo.class)) {
				DetalleActivoFijoDataAccess.save(metododepreciacion.getDetalleActivoFijo(),connexion);
				DetalleActivoFijoLogic detalleactivofijoLogic= new DetalleActivoFijoLogic(connexion);
				detalleactivofijoLogic.deepSave(metododepreciacion.getDetalleActivoFijo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Anio.class)) {
				AnioDataAccess.save(metododepreciacion.getAnio(),connexion);
				AnioLogic anioLogic= new AnioLogic(connexion);
				anioLogic.deepSave(metododepreciacion.getAnio(),isDeep,deepLoadType,clases);				
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
			this.getNewConnexionToDeep(MetodoDepreciacion.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(metododepreciacion,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				MetodoDepreciacionConstantesFunciones.refrescarForeignKeysDescripcionesMetodoDepreciacion(metododepreciacion);
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
			this.deepLoad(this.metododepreciacion,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				MetodoDepreciacionConstantesFunciones.refrescarForeignKeysDescripcionesMetodoDepreciacion(this.metododepreciacion);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(MetodoDepreciacion.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(metododepreciacions!=null) {
				for(MetodoDepreciacion metododepreciacion:metododepreciacions) {
					this.deepLoad(metododepreciacion,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					MetodoDepreciacionConstantesFunciones.refrescarForeignKeysDescripcionesMetodoDepreciacion(metododepreciacions);
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
			if(metododepreciacions!=null) {
				for(MetodoDepreciacion metododepreciacion:metododepreciacions) {
					this.deepLoad(metododepreciacion,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					MetodoDepreciacionConstantesFunciones.refrescarForeignKeysDescripcionesMetodoDepreciacion(metododepreciacions);
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
			this.getNewConnexionToDeep(MetodoDepreciacion.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(metododepreciacion,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(MetodoDepreciacion.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(metododepreciacions!=null) {
				for(MetodoDepreciacion metododepreciacion:metododepreciacions) {
					this.deepSave(metododepreciacion,isDeep,deepLoadType,clases);
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
			if(metododepreciacions!=null) {
				for(MetodoDepreciacion metododepreciacion:metododepreciacions) {
					this.deepSave(metododepreciacion,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getMetodoDepreciacionsFK_IdAnioWithConnection(String sFinalQuery,Pagination pagination,Long id_anio)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,MetodoDepreciacion.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidAnio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidAnio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_anio,MetodoDepreciacionConstantesFunciones.IDANIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidAnio);

			MetodoDepreciacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdAnio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			metododepreciacions=metododepreciacionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				MetodoDepreciacionConstantesFunciones.refrescarForeignKeysDescripcionesMetodoDepreciacion(this.metododepreciacions);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getMetodoDepreciacionsFK_IdAnio(String sFinalQuery,Pagination pagination,Long id_anio)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidAnio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidAnio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_anio,MetodoDepreciacionConstantesFunciones.IDANIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidAnio);

			MetodoDepreciacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdAnio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			metododepreciacions=metododepreciacionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				MetodoDepreciacionConstantesFunciones.refrescarForeignKeysDescripcionesMetodoDepreciacion(this.metododepreciacions);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getMetodoDepreciacionsFK_IdDetalleActivoFijoWithConnection(String sFinalQuery,Pagination pagination,Long id_detalle_activo_fijo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,MetodoDepreciacion.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidDetalleActivoFijo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidDetalleActivoFijo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_detalle_activo_fijo,MetodoDepreciacionConstantesFunciones.IDDETALLEACTIVOFIJO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidDetalleActivoFijo);

			MetodoDepreciacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdDetalleActivoFijo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			metododepreciacions=metododepreciacionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				MetodoDepreciacionConstantesFunciones.refrescarForeignKeysDescripcionesMetodoDepreciacion(this.metododepreciacions);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getMetodoDepreciacionsFK_IdDetalleActivoFijo(String sFinalQuery,Pagination pagination,Long id_detalle_activo_fijo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidDetalleActivoFijo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidDetalleActivoFijo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_detalle_activo_fijo,MetodoDepreciacionConstantesFunciones.IDDETALLEACTIVOFIJO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidDetalleActivoFijo);

			MetodoDepreciacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdDetalleActivoFijo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			metododepreciacions=metododepreciacionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				MetodoDepreciacionConstantesFunciones.refrescarForeignKeysDescripcionesMetodoDepreciacion(this.metododepreciacions);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getMetodoDepreciacionsFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,MetodoDepreciacion.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,MetodoDepreciacionConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			MetodoDepreciacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			metododepreciacions=metododepreciacionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				MetodoDepreciacionConstantesFunciones.refrescarForeignKeysDescripcionesMetodoDepreciacion(this.metododepreciacions);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getMetodoDepreciacionsFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,MetodoDepreciacionConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			MetodoDepreciacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			metododepreciacions=metododepreciacionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				MetodoDepreciacionConstantesFunciones.refrescarForeignKeysDescripcionesMetodoDepreciacion(this.metododepreciacions);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getMetodoDepreciacionsFK_IdSucursalWithConnection(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,MetodoDepreciacion.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,MetodoDepreciacionConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			MetodoDepreciacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			metododepreciacions=metododepreciacionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				MetodoDepreciacionConstantesFunciones.refrescarForeignKeysDescripcionesMetodoDepreciacion(this.metododepreciacions);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getMetodoDepreciacionsFK_IdSucursal(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,MetodoDepreciacionConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			MetodoDepreciacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			metododepreciacions=metododepreciacionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				MetodoDepreciacionConstantesFunciones.refrescarForeignKeysDescripcionesMetodoDepreciacion(this.metododepreciacions);
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
			if(MetodoDepreciacionConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,MetodoDepreciacionDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,MetodoDepreciacion metododepreciacion,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(MetodoDepreciacionConstantesFunciones.ISCONAUDITORIA) {
				if(metododepreciacion.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,MetodoDepreciacionDataAccess.TABLENAME, metododepreciacion.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(MetodoDepreciacionConstantesFunciones.ISCONAUDITORIADETALLE) {
						////MetodoDepreciacionLogic.registrarAuditoriaDetallesMetodoDepreciacion(connexion,metododepreciacion,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(metododepreciacion.getIsDeleted()) {
					/*if(!metododepreciacion.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,MetodoDepreciacionDataAccess.TABLENAME, metododepreciacion.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////MetodoDepreciacionLogic.registrarAuditoriaDetallesMetodoDepreciacion(connexion,metododepreciacion,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,MetodoDepreciacionDataAccess.TABLENAME, metododepreciacion.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(metododepreciacion.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,MetodoDepreciacionDataAccess.TABLENAME, metododepreciacion.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(MetodoDepreciacionConstantesFunciones.ISCONAUDITORIADETALLE) {
						////MetodoDepreciacionLogic.registrarAuditoriaDetallesMetodoDepreciacion(connexion,metododepreciacion,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesMetodoDepreciacion(Connexion connexion,MetodoDepreciacion metododepreciacion)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(metododepreciacion.getIsNew()||!metododepreciacion.getid_empresa().equals(metododepreciacion.getMetodoDepreciacionOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(metododepreciacion.getMetodoDepreciacionOriginal().getid_empresa()!=null)
				{
					strValorActual=metododepreciacion.getMetodoDepreciacionOriginal().getid_empresa().toString();
				}
				if(metododepreciacion.getid_empresa()!=null)
				{
					strValorNuevo=metododepreciacion.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),MetodoDepreciacionConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(metododepreciacion.getIsNew()||!metododepreciacion.getid_sucursal().equals(metododepreciacion.getMetodoDepreciacionOriginal().getid_sucursal()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(metododepreciacion.getMetodoDepreciacionOriginal().getid_sucursal()!=null)
				{
					strValorActual=metododepreciacion.getMetodoDepreciacionOriginal().getid_sucursal().toString();
				}
				if(metododepreciacion.getid_sucursal()!=null)
				{
					strValorNuevo=metododepreciacion.getid_sucursal().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),MetodoDepreciacionConstantesFunciones.IDSUCURSAL,strValorActual,strValorNuevo);
			}	
			
			if(metododepreciacion.getIsNew()||!metododepreciacion.getid_detalle_activo_fijo().equals(metododepreciacion.getMetodoDepreciacionOriginal().getid_detalle_activo_fijo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(metododepreciacion.getMetodoDepreciacionOriginal().getid_detalle_activo_fijo()!=null)
				{
					strValorActual=metododepreciacion.getMetodoDepreciacionOriginal().getid_detalle_activo_fijo().toString();
				}
				if(metododepreciacion.getid_detalle_activo_fijo()!=null)
				{
					strValorNuevo=metododepreciacion.getid_detalle_activo_fijo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),MetodoDepreciacionConstantesFunciones.IDDETALLEACTIVOFIJO,strValorActual,strValorNuevo);
			}	
			
			if(metododepreciacion.getIsNew()||!metododepreciacion.getid_anio().equals(metododepreciacion.getMetodoDepreciacionOriginal().getid_anio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(metododepreciacion.getMetodoDepreciacionOriginal().getid_anio()!=null)
				{
					strValorActual=metododepreciacion.getMetodoDepreciacionOriginal().getid_anio().toString();
				}
				if(metododepreciacion.getid_anio()!=null)
				{
					strValorNuevo=metododepreciacion.getid_anio().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),MetodoDepreciacionConstantesFunciones.IDANIO,strValorActual,strValorNuevo);
			}	
			
			if(metododepreciacion.getIsNew()||!metododepreciacion.getfecha_desde().equals(metododepreciacion.getMetodoDepreciacionOriginal().getfecha_desde()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(metododepreciacion.getMetodoDepreciacionOriginal().getfecha_desde()!=null)
				{
					strValorActual=metododepreciacion.getMetodoDepreciacionOriginal().getfecha_desde().toString();
				}
				if(metododepreciacion.getfecha_desde()!=null)
				{
					strValorNuevo=metododepreciacion.getfecha_desde().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),MetodoDepreciacionConstantesFunciones.FECHADESDE,strValorActual,strValorNuevo);
			}	
			
			if(metododepreciacion.getIsNew()||!metododepreciacion.getfecha_hasta().equals(metododepreciacion.getMetodoDepreciacionOriginal().getfecha_hasta()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(metododepreciacion.getMetodoDepreciacionOriginal().getfecha_hasta()!=null)
				{
					strValorActual=metododepreciacion.getMetodoDepreciacionOriginal().getfecha_hasta().toString();
				}
				if(metododepreciacion.getfecha_hasta()!=null)
				{
					strValorNuevo=metododepreciacion.getfecha_hasta().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),MetodoDepreciacionConstantesFunciones.FECHAHASTA,strValorActual,strValorNuevo);
			}	
			
			if(metododepreciacion.getIsNew()||!metododepreciacion.getporcentaje().equals(metododepreciacion.getMetodoDepreciacionOriginal().getporcentaje()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(metododepreciacion.getMetodoDepreciacionOriginal().getporcentaje()!=null)
				{
					strValorActual=metododepreciacion.getMetodoDepreciacionOriginal().getporcentaje().toString();
				}
				if(metododepreciacion.getporcentaje()!=null)
				{
					strValorNuevo=metododepreciacion.getporcentaje().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),MetodoDepreciacionConstantesFunciones.PORCENTAJE,strValorActual,strValorNuevo);
			}	
			
			if(metododepreciacion.getIsNew()||!metododepreciacion.getvalor().equals(metododepreciacion.getMetodoDepreciacionOriginal().getvalor()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(metododepreciacion.getMetodoDepreciacionOriginal().getvalor()!=null)
				{
					strValorActual=metododepreciacion.getMetodoDepreciacionOriginal().getvalor().toString();
				}
				if(metododepreciacion.getvalor()!=null)
				{
					strValorNuevo=metododepreciacion.getvalor().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),MetodoDepreciacionConstantesFunciones.VALOR,strValorActual,strValorNuevo);
			}	
			
			if(metododepreciacion.getIsNew()||!metododepreciacion.getnumero_dias().equals(metododepreciacion.getMetodoDepreciacionOriginal().getnumero_dias()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(metododepreciacion.getMetodoDepreciacionOriginal().getnumero_dias()!=null)
				{
					strValorActual=metododepreciacion.getMetodoDepreciacionOriginal().getnumero_dias().toString();
				}
				if(metododepreciacion.getnumero_dias()!=null)
				{
					strValorNuevo=metododepreciacion.getnumero_dias().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),MetodoDepreciacionConstantesFunciones.NUMERODIAS,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveMetodoDepreciacionRelacionesWithConnection(MetodoDepreciacion metododepreciacion) throws Exception {

		if(!metododepreciacion.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveMetodoDepreciacionRelacionesBase(metododepreciacion,true);
		}
	}

	public void saveMetodoDepreciacionRelaciones(MetodoDepreciacion metododepreciacion)throws Exception {

		if(!metododepreciacion.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveMetodoDepreciacionRelacionesBase(metododepreciacion,false);
		}
	}

	public void saveMetodoDepreciacionRelacionesBase(MetodoDepreciacion metododepreciacion,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("MetodoDepreciacion-saveRelacionesWithConnection");}
	

			this.setMetodoDepreciacion(metododepreciacion);

			if(MetodoDepreciacionLogicAdditional.validarSaveRelaciones(metododepreciacion,this)) {

				MetodoDepreciacionLogicAdditional.updateRelacionesToSave(metododepreciacion,this);

				if((metododepreciacion.getIsNew()||metododepreciacion.getIsChanged())&&!metododepreciacion.getIsDeleted()) {
					this.saveMetodoDepreciacion();
					this.saveMetodoDepreciacionRelacionesDetalles();

				} else if(metododepreciacion.getIsDeleted()) {
					this.saveMetodoDepreciacionRelacionesDetalles();
					this.saveMetodoDepreciacion();
				}

				MetodoDepreciacionLogicAdditional.updateRelacionesToSaveAfter(metododepreciacion,this);

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
	
	
	private void saveMetodoDepreciacionRelacionesDetalles()throws Exception {
		try {
	

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfMetodoDepreciacion(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=MetodoDepreciacionConstantesFunciones.getClassesForeignKeysOfMetodoDepreciacion(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfMetodoDepreciacion(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=MetodoDepreciacionConstantesFunciones.getClassesRelationshipsOfMetodoDepreciacion(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

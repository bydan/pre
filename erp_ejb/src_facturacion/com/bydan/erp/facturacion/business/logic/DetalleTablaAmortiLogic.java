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
import com.bydan.erp.facturacion.util.DetalleTablaAmortiConstantesFunciones;
import com.bydan.erp.facturacion.util.DetalleTablaAmortiParameterReturnGeneral;
//import com.bydan.erp.facturacion.util.DetalleTablaAmortiParameterGeneral;
import com.bydan.erp.facturacion.business.entity.DetalleTablaAmorti;
import com.bydan.erp.facturacion.business.logic.DetalleTablaAmortiLogicAdditional;
import com.bydan.erp.facturacion.business.dataaccess.*;
import com.bydan.erp.facturacion.business.entity.*;

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
public class DetalleTablaAmortiLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(DetalleTablaAmortiLogic.class);
	
	protected DetalleTablaAmortiDataAccess detalletablaamortiDataAccess; 	
	protected DetalleTablaAmorti detalletablaamorti;
	protected List<DetalleTablaAmorti> detalletablaamortis;
	protected Object detalletablaamortiObject;	
	protected List<Object> detalletablaamortisObject;
	
	public static ClassValidator<DetalleTablaAmorti> detalletablaamortiValidator = new ClassValidator<DetalleTablaAmorti>(DetalleTablaAmorti.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected DetalleTablaAmortiLogicAdditional detalletablaamortiLogicAdditional=null;
	
	public DetalleTablaAmortiLogicAdditional getDetalleTablaAmortiLogicAdditional() {
		return this.detalletablaamortiLogicAdditional;
	}
	
	public void setDetalleTablaAmortiLogicAdditional(DetalleTablaAmortiLogicAdditional detalletablaamortiLogicAdditional) {
		try {
			this.detalletablaamortiLogicAdditional=detalletablaamortiLogicAdditional;
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
	
	
	
	
	public  DetalleTablaAmortiLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.detalletablaamortiDataAccess = new DetalleTablaAmortiDataAccess();
			
			this.detalletablaamortis= new ArrayList<DetalleTablaAmorti>();
			this.detalletablaamorti= new DetalleTablaAmorti();
			
			this.detalletablaamortiObject=new Object();
			this.detalletablaamortisObject=new ArrayList<Object>();
				
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
			
			this.detalletablaamortiDataAccess.setConnexionType(this.connexionType);
			this.detalletablaamortiDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  DetalleTablaAmortiLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.detalletablaamortiDataAccess = new DetalleTablaAmortiDataAccess();
			this.detalletablaamortis= new ArrayList<DetalleTablaAmorti>();
			this.detalletablaamorti= new DetalleTablaAmorti();
			this.detalletablaamortiObject=new Object();
			this.detalletablaamortisObject=new ArrayList<Object>();
			
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
			
			this.detalletablaamortiDataAccess.setConnexionType(this.connexionType);
			this.detalletablaamortiDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public DetalleTablaAmorti getDetalleTablaAmorti() throws Exception {	
		DetalleTablaAmortiLogicAdditional.checkDetalleTablaAmortiToGet(detalletablaamorti,this.datosCliente,this.arrDatoGeneral);
		DetalleTablaAmortiLogicAdditional.updateDetalleTablaAmortiToGet(detalletablaamorti,this.arrDatoGeneral);
		
		return detalletablaamorti;
	}
		
	public void setDetalleTablaAmorti(DetalleTablaAmorti newDetalleTablaAmorti) {
		this.detalletablaamorti = newDetalleTablaAmorti;
	}
	
	public DetalleTablaAmortiDataAccess getDetalleTablaAmortiDataAccess() {
		return detalletablaamortiDataAccess;
	}
	
	public void setDetalleTablaAmortiDataAccess(DetalleTablaAmortiDataAccess newdetalletablaamortiDataAccess) {
		this.detalletablaamortiDataAccess = newdetalletablaamortiDataAccess;
	}
	
	public List<DetalleTablaAmorti> getDetalleTablaAmortis() throws Exception {		
		this.quitarDetalleTablaAmortisNulos();
		
		DetalleTablaAmortiLogicAdditional.checkDetalleTablaAmortiToGets(detalletablaamortis,this.datosCliente,this.arrDatoGeneral);
		
		for (DetalleTablaAmorti detalletablaamortiLocal: detalletablaamortis ) {
			DetalleTablaAmortiLogicAdditional.updateDetalleTablaAmortiToGet(detalletablaamortiLocal,this.arrDatoGeneral);
		}
		
		return detalletablaamortis;
	}
	
	public void setDetalleTablaAmortis(List<DetalleTablaAmorti> newDetalleTablaAmortis) {
		this.detalletablaamortis = newDetalleTablaAmortis;
	}
	
	public Object getDetalleTablaAmortiObject() {	
		this.detalletablaamortiObject=this.detalletablaamortiDataAccess.getEntityObject();
		return this.detalletablaamortiObject;
	}
		
	public void setDetalleTablaAmortiObject(Object newDetalleTablaAmortiObject) {
		this.detalletablaamortiObject = newDetalleTablaAmortiObject;
	}
	
	public List<Object> getDetalleTablaAmortisObject() {		
		this.detalletablaamortisObject=this.detalletablaamortiDataAccess.getEntitiesObject();
		return this.detalletablaamortisObject;
	}
		
	public void setDetalleTablaAmortisObject(List<Object> newDetalleTablaAmortisObject) {
		this.detalletablaamortisObject = newDetalleTablaAmortisObject;
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
		
		if(this.detalletablaamortiDataAccess!=null) {
			this.detalletablaamortiDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleTablaAmorti.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			detalletablaamortiDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			detalletablaamortiDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		detalletablaamorti = new  DetalleTablaAmorti();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleTablaAmorti.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			detalletablaamorti=detalletablaamortiDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.detalletablaamorti,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				DetalleTablaAmortiConstantesFunciones.refrescarForeignKeysDescripcionesDetalleTablaAmorti(this.detalletablaamorti);
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
		detalletablaamorti = new  DetalleTablaAmorti();
		  		  
        try {
			
			detalletablaamorti=detalletablaamortiDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.detalletablaamorti,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				DetalleTablaAmortiConstantesFunciones.refrescarForeignKeysDescripcionesDetalleTablaAmorti(this.detalletablaamorti);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		detalletablaamorti = new  DetalleTablaAmorti();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleTablaAmorti.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			detalletablaamorti=detalletablaamortiDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.detalletablaamorti,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				DetalleTablaAmortiConstantesFunciones.refrescarForeignKeysDescripcionesDetalleTablaAmorti(this.detalletablaamorti);
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
		detalletablaamorti = new  DetalleTablaAmorti();
		  		  
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
		detalletablaamorti = new  DetalleTablaAmorti();
		  		  
        try {
			
			detalletablaamorti=detalletablaamortiDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.detalletablaamorti,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				DetalleTablaAmortiConstantesFunciones.refrescarForeignKeysDescripcionesDetalleTablaAmorti(this.detalletablaamorti);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		detalletablaamorti = new  DetalleTablaAmorti();
		  		  
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
		detalletablaamorti = new  DetalleTablaAmorti();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleTablaAmorti.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =detalletablaamortiDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		detalletablaamorti = new  DetalleTablaAmorti();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=detalletablaamortiDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		detalletablaamorti = new  DetalleTablaAmorti();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleTablaAmorti.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =detalletablaamortiDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		detalletablaamorti = new  DetalleTablaAmorti();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=detalletablaamortiDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		detalletablaamorti = new  DetalleTablaAmorti();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleTablaAmorti.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =detalletablaamortiDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		detalletablaamorti = new  DetalleTablaAmorti();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=detalletablaamortiDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		detalletablaamortis = new  ArrayList<DetalleTablaAmorti>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleTablaAmorti.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			DetalleTablaAmortiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detalletablaamortis=detalletablaamortiDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarDetalleTablaAmorti(detalletablaamortis);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleTablaAmortiConstantesFunciones.refrescarForeignKeysDescripcionesDetalleTablaAmorti(this.detalletablaamortis);
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
		detalletablaamortis = new  ArrayList<DetalleTablaAmorti>();
		  		  
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
		detalletablaamortis = new  ArrayList<DetalleTablaAmorti>();
		  		  
        try {			
			DetalleTablaAmortiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detalletablaamortis=detalletablaamortiDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarDetalleTablaAmorti(detalletablaamortis);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleTablaAmortiConstantesFunciones.refrescarForeignKeysDescripcionesDetalleTablaAmorti(this.detalletablaamortis);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		detalletablaamortis = new  ArrayList<DetalleTablaAmorti>();
		  		  
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
		detalletablaamortis = new  ArrayList<DetalleTablaAmorti>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleTablaAmorti.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			DetalleTablaAmortiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detalletablaamortis=detalletablaamortiDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarDetalleTablaAmorti(detalletablaamortis);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleTablaAmortiConstantesFunciones.refrescarForeignKeysDescripcionesDetalleTablaAmorti(this.detalletablaamortis);
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
		detalletablaamortis = new  ArrayList<DetalleTablaAmorti>();
		  		  
        try {
			DetalleTablaAmortiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detalletablaamortis=detalletablaamortiDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarDetalleTablaAmorti(detalletablaamortis);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleTablaAmortiConstantesFunciones.refrescarForeignKeysDescripcionesDetalleTablaAmorti(this.detalletablaamortis);
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
		detalletablaamortis = new  ArrayList<DetalleTablaAmorti>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleTablaAmorti.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DetalleTablaAmortiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detalletablaamortis=detalletablaamortiDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarDetalleTablaAmorti(detalletablaamortis);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleTablaAmortiConstantesFunciones.refrescarForeignKeysDescripcionesDetalleTablaAmorti(this.detalletablaamortis);
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
		detalletablaamortis = new  ArrayList<DetalleTablaAmorti>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DetalleTablaAmortiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detalletablaamortis=detalletablaamortiDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarDetalleTablaAmorti(detalletablaamortis);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleTablaAmortiConstantesFunciones.refrescarForeignKeysDescripcionesDetalleTablaAmorti(this.detalletablaamortis);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		detalletablaamorti = new  DetalleTablaAmorti();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleTablaAmorti.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DetalleTablaAmortiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detalletablaamorti=detalletablaamortiDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarDetalleTablaAmorti(detalletablaamorti);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleTablaAmortiConstantesFunciones.refrescarForeignKeysDescripcionesDetalleTablaAmorti(this.detalletablaamorti);
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
		detalletablaamorti = new  DetalleTablaAmorti();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DetalleTablaAmortiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detalletablaamorti=detalletablaamortiDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarDetalleTablaAmorti(detalletablaamorti);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleTablaAmortiConstantesFunciones.refrescarForeignKeysDescripcionesDetalleTablaAmorti(this.detalletablaamorti);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		detalletablaamortis = new  ArrayList<DetalleTablaAmorti>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleTablaAmorti.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			DetalleTablaAmortiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detalletablaamortis=detalletablaamortiDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarDetalleTablaAmorti(detalletablaamortis);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleTablaAmortiConstantesFunciones.refrescarForeignKeysDescripcionesDetalleTablaAmorti(this.detalletablaamortis);
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
		detalletablaamortis = new  ArrayList<DetalleTablaAmorti>();
		  		  
        try {
			DetalleTablaAmortiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detalletablaamortis=detalletablaamortiDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarDetalleTablaAmorti(detalletablaamortis);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleTablaAmortiConstantesFunciones.refrescarForeignKeysDescripcionesDetalleTablaAmorti(this.detalletablaamortis);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosDetalleTablaAmortisWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		detalletablaamortis = new  ArrayList<DetalleTablaAmorti>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleTablaAmorti.class.getSimpleName()+"-getTodosDetalleTablaAmortisWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DetalleTablaAmortiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detalletablaamortis=detalletablaamortiDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarDetalleTablaAmorti(detalletablaamortis);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleTablaAmortiConstantesFunciones.refrescarForeignKeysDescripcionesDetalleTablaAmorti(this.detalletablaamortis);
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
	
	public  void  getTodosDetalleTablaAmortis(String sFinalQuery,Pagination pagination)throws Exception {
		detalletablaamortis = new  ArrayList<DetalleTablaAmorti>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DetalleTablaAmortiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detalletablaamortis=detalletablaamortiDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarDetalleTablaAmorti(detalletablaamortis);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleTablaAmortiConstantesFunciones.refrescarForeignKeysDescripcionesDetalleTablaAmorti(this.detalletablaamortis);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarDetalleTablaAmorti(DetalleTablaAmorti detalletablaamorti) throws Exception {
		Boolean estaValidado=false;
		
		if(detalletablaamorti.getIsNew() || detalletablaamorti.getIsChanged()) { 
			this.invalidValues = detalletablaamortiValidator.getInvalidValues(detalletablaamorti);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(detalletablaamorti);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarDetalleTablaAmorti(List<DetalleTablaAmorti> DetalleTablaAmortis) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(DetalleTablaAmorti detalletablaamortiLocal:detalletablaamortis) {				
			estaValidadoObjeto=this.validarGuardarDetalleTablaAmorti(detalletablaamortiLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarDetalleTablaAmorti(List<DetalleTablaAmorti> DetalleTablaAmortis) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarDetalleTablaAmorti(detalletablaamortis)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarDetalleTablaAmorti(DetalleTablaAmorti DetalleTablaAmorti) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarDetalleTablaAmorti(detalletablaamorti)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(DetalleTablaAmorti detalletablaamorti) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+detalletablaamorti.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=DetalleTablaAmortiConstantesFunciones.getDetalleTablaAmortiLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"detalletablaamorti","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(DetalleTablaAmortiConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(DetalleTablaAmortiConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveDetalleTablaAmortiWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleTablaAmorti.class.getSimpleName()+"-saveDetalleTablaAmortiWithConnection");connexion.begin();			
			
			DetalleTablaAmortiLogicAdditional.checkDetalleTablaAmortiToSave(this.detalletablaamorti,this.datosCliente,connexion,this.arrDatoGeneral);
			
			DetalleTablaAmortiLogicAdditional.updateDetalleTablaAmortiToSave(this.detalletablaamorti,this.arrDatoGeneral);
			
			DetalleTablaAmortiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.detalletablaamorti,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowDetalleTablaAmorti();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarDetalleTablaAmorti(this.detalletablaamorti)) {
				DetalleTablaAmortiDataAccess.save(this.detalletablaamorti, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.detalletablaamorti,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			DetalleTablaAmortiLogicAdditional.checkDetalleTablaAmortiToSaveAfter(this.detalletablaamorti,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowDetalleTablaAmorti();
			
			connexion.commit();			
			
			if(this.detalletablaamorti.getIsDeleted()) {
				this.detalletablaamorti=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveDetalleTablaAmorti()throws Exception {	
		try {	
			
			DetalleTablaAmortiLogicAdditional.checkDetalleTablaAmortiToSave(this.detalletablaamorti,this.datosCliente,connexion,this.arrDatoGeneral);
			
			DetalleTablaAmortiLogicAdditional.updateDetalleTablaAmortiToSave(this.detalletablaamorti,this.arrDatoGeneral);
			
			DetalleTablaAmortiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.detalletablaamorti,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarDetalleTablaAmorti(this.detalletablaamorti)) {			
				DetalleTablaAmortiDataAccess.save(this.detalletablaamorti, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.detalletablaamorti,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			DetalleTablaAmortiLogicAdditional.checkDetalleTablaAmortiToSaveAfter(this.detalletablaamorti,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.detalletablaamorti.getIsDeleted()) {
				this.detalletablaamorti=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveDetalleTablaAmortisWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleTablaAmorti.class.getSimpleName()+"-saveDetalleTablaAmortisWithConnection");connexion.begin();			
			
			DetalleTablaAmortiLogicAdditional.checkDetalleTablaAmortiToSaves(detalletablaamortis,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowDetalleTablaAmortis();
			
			Boolean validadoTodosDetalleTablaAmorti=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(DetalleTablaAmorti detalletablaamortiLocal:detalletablaamortis) {		
				if(detalletablaamortiLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				DetalleTablaAmortiLogicAdditional.updateDetalleTablaAmortiToSave(detalletablaamortiLocal,this.arrDatoGeneral);
	        	
				DetalleTablaAmortiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),detalletablaamortiLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarDetalleTablaAmorti(detalletablaamortiLocal)) {
					DetalleTablaAmortiDataAccess.save(detalletablaamortiLocal, connexion);				
				} else {
					validadoTodosDetalleTablaAmorti=false;
				}
			}
			
			if(!validadoTodosDetalleTablaAmorti) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			DetalleTablaAmortiLogicAdditional.checkDetalleTablaAmortiToSavesAfter(detalletablaamortis,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowDetalleTablaAmortis();
			
			connexion.commit();		
			
			this.quitarDetalleTablaAmortisEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveDetalleTablaAmortis()throws Exception {				
		 try {	
			DetalleTablaAmortiLogicAdditional.checkDetalleTablaAmortiToSaves(detalletablaamortis,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosDetalleTablaAmorti=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(DetalleTablaAmorti detalletablaamortiLocal:detalletablaamortis) {				
				if(detalletablaamortiLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				DetalleTablaAmortiLogicAdditional.updateDetalleTablaAmortiToSave(detalletablaamortiLocal,this.arrDatoGeneral);
	        	
				DetalleTablaAmortiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),detalletablaamortiLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarDetalleTablaAmorti(detalletablaamortiLocal)) {				
					DetalleTablaAmortiDataAccess.save(detalletablaamortiLocal, connexion);				
				} else {
					validadoTodosDetalleTablaAmorti=false;
				}
			}
			
			if(!validadoTodosDetalleTablaAmorti) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			DetalleTablaAmortiLogicAdditional.checkDetalleTablaAmortiToSavesAfter(detalletablaamortis,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarDetalleTablaAmortisEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public DetalleTablaAmortiParameterReturnGeneral procesarAccionDetalleTablaAmortis(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<DetalleTablaAmorti> detalletablaamortis,DetalleTablaAmortiParameterReturnGeneral detalletablaamortiParameterGeneral)throws Exception {
		 try {	
			DetalleTablaAmortiParameterReturnGeneral detalletablaamortiReturnGeneral=new DetalleTablaAmortiParameterReturnGeneral();
	
			DetalleTablaAmortiLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,detalletablaamortis,detalletablaamortiParameterGeneral,detalletablaamortiReturnGeneral);
			
			return detalletablaamortiReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public DetalleTablaAmortiParameterReturnGeneral procesarAccionDetalleTablaAmortisWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<DetalleTablaAmorti> detalletablaamortis,DetalleTablaAmortiParameterReturnGeneral detalletablaamortiParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleTablaAmorti.class.getSimpleName()+"-procesarAccionDetalleTablaAmortisWithConnection");connexion.begin();			
			
			DetalleTablaAmortiParameterReturnGeneral detalletablaamortiReturnGeneral=new DetalleTablaAmortiParameterReturnGeneral();
	
			DetalleTablaAmortiLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,detalletablaamortis,detalletablaamortiParameterGeneral,detalletablaamortiReturnGeneral);
			
			this.connexion.commit();
			
			return detalletablaamortiReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public DetalleTablaAmortiParameterReturnGeneral procesarEventosDetalleTablaAmortis(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<DetalleTablaAmorti> detalletablaamortis,DetalleTablaAmorti detalletablaamorti,DetalleTablaAmortiParameterReturnGeneral detalletablaamortiParameterGeneral,Boolean isEsNuevoDetalleTablaAmorti,ArrayList<Classe> clases)throws Exception {
		 try {	
			DetalleTablaAmortiParameterReturnGeneral detalletablaamortiReturnGeneral=new DetalleTablaAmortiParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				detalletablaamortiReturnGeneral.setConRecargarPropiedades(true);
			}
			
			DetalleTablaAmortiLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,detalletablaamortis,detalletablaamorti,detalletablaamortiParameterGeneral,detalletablaamortiReturnGeneral,isEsNuevoDetalleTablaAmorti,clases);
			
			return detalletablaamortiReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public DetalleTablaAmortiParameterReturnGeneral procesarEventosDetalleTablaAmortisWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<DetalleTablaAmorti> detalletablaamortis,DetalleTablaAmorti detalletablaamorti,DetalleTablaAmortiParameterReturnGeneral detalletablaamortiParameterGeneral,Boolean isEsNuevoDetalleTablaAmorti,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleTablaAmorti.class.getSimpleName()+"-procesarEventosDetalleTablaAmortisWithConnection");connexion.begin();			
			
			DetalleTablaAmortiParameterReturnGeneral detalletablaamortiReturnGeneral=new DetalleTablaAmortiParameterReturnGeneral();
	
			detalletablaamortiReturnGeneral.setDetalleTablaAmorti(detalletablaamorti);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				detalletablaamortiReturnGeneral.setConRecargarPropiedades(true);
			}
			
			DetalleTablaAmortiLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,detalletablaamortis,detalletablaamorti,detalletablaamortiParameterGeneral,detalletablaamortiReturnGeneral,isEsNuevoDetalleTablaAmorti,clases);
			
			this.connexion.commit();
			
			return detalletablaamortiReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public DetalleTablaAmortiParameterReturnGeneral procesarImportacionDetalleTablaAmortisWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,DetalleTablaAmortiParameterReturnGeneral detalletablaamortiParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleTablaAmorti.class.getSimpleName()+"-procesarImportacionDetalleTablaAmortisWithConnection");connexion.begin();			
			
			DetalleTablaAmortiParameterReturnGeneral detalletablaamortiReturnGeneral=new DetalleTablaAmortiParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.detalletablaamortis=new ArrayList<DetalleTablaAmorti>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.detalletablaamorti=new DetalleTablaAmorti();
				
				
				if(conColumnasBase) {this.detalletablaamorti.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.detalletablaamorti.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.detalletablaamorti.setvalor(Double.parseDouble(arrColumnas[iColumn++]));
				this.detalletablaamorti.setinteres(Double.parseDouble(arrColumnas[iColumn++]));
				this.detalletablaamorti.setcapital(Double.parseDouble(arrColumnas[iColumn++]));
				this.detalletablaamorti.setfecha_inicio(Funciones.ConvertToDate(arrColumnas[iColumn++]));
				this.detalletablaamorti.setfecha_fin(Funciones.ConvertToDate(arrColumnas[iColumn++]));
				this.detalletablaamorti.setdescripcion(arrColumnas[iColumn++]);
				
				this.detalletablaamortis.add(this.detalletablaamorti);
			}
			
			this.saveDetalleTablaAmortis();
			
			this.connexion.commit();
			
			detalletablaamortiReturnGeneral.setConRetornoEstaProcesado(true);
			detalletablaamortiReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return detalletablaamortiReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarDetalleTablaAmortisEliminados() throws Exception {				
		
		List<DetalleTablaAmorti> detalletablaamortisAux= new ArrayList<DetalleTablaAmorti>();
		
		for(DetalleTablaAmorti detalletablaamorti:detalletablaamortis) {
			if(!detalletablaamorti.getIsDeleted()) {
				detalletablaamortisAux.add(detalletablaamorti);
			}
		}
		
		detalletablaamortis=detalletablaamortisAux;
	}
	
	public void quitarDetalleTablaAmortisNulos() throws Exception {				
		
		List<DetalleTablaAmorti> detalletablaamortisAux= new ArrayList<DetalleTablaAmorti>();
		
		for(DetalleTablaAmorti detalletablaamorti : this.detalletablaamortis) {
			if(detalletablaamorti==null) {
				detalletablaamortisAux.add(detalletablaamorti);
			}
		}
		
		//this.detalletablaamortis=detalletablaamortisAux;
		
		this.detalletablaamortis.removeAll(detalletablaamortisAux);
	}
	
	public void getSetVersionRowDetalleTablaAmortiWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(detalletablaamorti.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((detalletablaamorti.getIsDeleted() || (detalletablaamorti.getIsChanged()&&!detalletablaamorti.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=detalletablaamortiDataAccess.getSetVersionRowDetalleTablaAmorti(connexion,detalletablaamorti.getId());
				
				if(!detalletablaamorti.getVersionRow().equals(timestamp)) {	
					detalletablaamorti.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				detalletablaamorti.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowDetalleTablaAmorti()throws Exception {	
		
		if(detalletablaamorti.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((detalletablaamorti.getIsDeleted() || (detalletablaamorti.getIsChanged()&&!detalletablaamorti.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=detalletablaamortiDataAccess.getSetVersionRowDetalleTablaAmorti(connexion,detalletablaamorti.getId());
			
			try {							
				if(!detalletablaamorti.getVersionRow().equals(timestamp)) {	
					detalletablaamorti.setVersionRow(timestamp);
				}
				
				detalletablaamorti.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowDetalleTablaAmortisWithConnection()throws Exception {	
		if(detalletablaamortis!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(DetalleTablaAmorti detalletablaamortiAux:detalletablaamortis) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(detalletablaamortiAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(detalletablaamortiAux.getIsDeleted() || (detalletablaamortiAux.getIsChanged()&&!detalletablaamortiAux.getIsNew())) {
						
						timestamp=detalletablaamortiDataAccess.getSetVersionRowDetalleTablaAmorti(connexion,detalletablaamortiAux.getId());
						
						if(!detalletablaamorti.getVersionRow().equals(timestamp)) {	
							detalletablaamortiAux.setVersionRow(timestamp);
						}
								
						detalletablaamortiAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowDetalleTablaAmortis()throws Exception {	
		if(detalletablaamortis!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(DetalleTablaAmorti detalletablaamortiAux:detalletablaamortis) {
					if(detalletablaamortiAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(detalletablaamortiAux.getIsDeleted() || (detalletablaamortiAux.getIsChanged()&&!detalletablaamortiAux.getIsNew())) {
						
						timestamp=detalletablaamortiDataAccess.getSetVersionRowDetalleTablaAmorti(connexion,detalletablaamortiAux.getId());
						
						if(!detalletablaamortiAux.getVersionRow().equals(timestamp)) {	
							detalletablaamortiAux.setVersionRow(timestamp);
						}
						
													
						detalletablaamortiAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public DetalleTablaAmortiParameterReturnGeneral cargarCombosLoteForeignKeyDetalleTablaAmortiWithConnection(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalEjercicio,String finalQueryGlobalPeriodo,String finalQueryGlobalTablaAmorti,String finalQueryGlobalAnio,String finalQueryGlobalMes) throws Exception {
		DetalleTablaAmortiParameterReturnGeneral  detalletablaamortiReturnGeneral =new DetalleTablaAmortiParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleTablaAmorti.class.getSimpleName()+"-cargarCombosLoteForeignKeyDetalleTablaAmortiWithConnection");connexion.begin();
			
			detalletablaamortiReturnGeneral =new DetalleTablaAmortiParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			detalletablaamortiReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			detalletablaamortiReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Ejercicio> ejerciciosForeignKey=new ArrayList<Ejercicio>();
			EjercicioLogic ejercicioLogic=new EjercicioLogic();
			ejercicioLogic.setConnexion(this.connexion);
			//ejercicioLogic.getEjercicioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEjercicio.equals("NONE")) {
				ejercicioLogic.getTodosEjercicios(finalQueryGlobalEjercicio,new Pagination());
				ejerciciosForeignKey=ejercicioLogic.getEjercicios();
			}

			detalletablaamortiReturnGeneral.setejerciciosForeignKey(ejerciciosForeignKey);


			List<Periodo> periodosForeignKey=new ArrayList<Periodo>();
			PeriodoLogic periodoLogic=new PeriodoLogic();
			periodoLogic.setConnexion(this.connexion);
			//periodoLogic.getPeriodoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPeriodo.equals("NONE")) {
				periodoLogic.getTodosPeriodos(finalQueryGlobalPeriodo,new Pagination());
				periodosForeignKey=periodoLogic.getPeriodos();
			}

			detalletablaamortiReturnGeneral.setperiodosForeignKey(periodosForeignKey);


			List<TablaAmorti> tablaamortisForeignKey=new ArrayList<TablaAmorti>();
			TablaAmortiLogic tablaamortiLogic=new TablaAmortiLogic();
			tablaamortiLogic.setConnexion(this.connexion);
			tablaamortiLogic.getTablaAmortiDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTablaAmorti.equals("NONE")) {
				tablaamortiLogic.getTodosTablaAmortis(finalQueryGlobalTablaAmorti,new Pagination());
				tablaamortisForeignKey=tablaamortiLogic.getTablaAmortis();
			}

			detalletablaamortiReturnGeneral.settablaamortisForeignKey(tablaamortisForeignKey);


			List<Anio> aniosForeignKey=new ArrayList<Anio>();
			AnioLogic anioLogic=new AnioLogic();
			anioLogic.setConnexion(this.connexion);
			anioLogic.getAnioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalAnio.equals("NONE")) {
				anioLogic.getTodosAnios(finalQueryGlobalAnio,new Pagination());
				aniosForeignKey=anioLogic.getAnios();
			}

			detalletablaamortiReturnGeneral.setaniosForeignKey(aniosForeignKey);


			List<Mes> messForeignKey=new ArrayList<Mes>();
			MesLogic mesLogic=new MesLogic();
			mesLogic.setConnexion(this.connexion);
			mesLogic.getMesDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalMes.equals("NONE")) {
				mesLogic.getTodosMess(finalQueryGlobalMes,new Pagination());
				messForeignKey=mesLogic.getMess();
			}

			detalletablaamortiReturnGeneral.setmessForeignKey(messForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return detalletablaamortiReturnGeneral;
	}
	
	public DetalleTablaAmortiParameterReturnGeneral cargarCombosLoteForeignKeyDetalleTablaAmorti(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalEjercicio,String finalQueryGlobalPeriodo,String finalQueryGlobalTablaAmorti,String finalQueryGlobalAnio,String finalQueryGlobalMes) throws Exception {
		DetalleTablaAmortiParameterReturnGeneral  detalletablaamortiReturnGeneral =new DetalleTablaAmortiParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			detalletablaamortiReturnGeneral =new DetalleTablaAmortiParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			detalletablaamortiReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			detalletablaamortiReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Ejercicio> ejerciciosForeignKey=new ArrayList<Ejercicio>();
			EjercicioLogic ejercicioLogic=new EjercicioLogic();
			ejercicioLogic.setConnexion(this.connexion);
			//ejercicioLogic.getEjercicioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEjercicio.equals("NONE")) {
				ejercicioLogic.getTodosEjercicios(finalQueryGlobalEjercicio,new Pagination());
				ejerciciosForeignKey=ejercicioLogic.getEjercicios();
			}

			detalletablaamortiReturnGeneral.setejerciciosForeignKey(ejerciciosForeignKey);


			List<Periodo> periodosForeignKey=new ArrayList<Periodo>();
			PeriodoLogic periodoLogic=new PeriodoLogic();
			periodoLogic.setConnexion(this.connexion);
			//periodoLogic.getPeriodoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPeriodo.equals("NONE")) {
				periodoLogic.getTodosPeriodos(finalQueryGlobalPeriodo,new Pagination());
				periodosForeignKey=periodoLogic.getPeriodos();
			}

			detalletablaamortiReturnGeneral.setperiodosForeignKey(periodosForeignKey);


			List<TablaAmorti> tablaamortisForeignKey=new ArrayList<TablaAmorti>();
			TablaAmortiLogic tablaamortiLogic=new TablaAmortiLogic();
			tablaamortiLogic.setConnexion(this.connexion);
			tablaamortiLogic.getTablaAmortiDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTablaAmorti.equals("NONE")) {
				tablaamortiLogic.getTodosTablaAmortis(finalQueryGlobalTablaAmorti,new Pagination());
				tablaamortisForeignKey=tablaamortiLogic.getTablaAmortis();
			}

			detalletablaamortiReturnGeneral.settablaamortisForeignKey(tablaamortisForeignKey);


			List<Anio> aniosForeignKey=new ArrayList<Anio>();
			AnioLogic anioLogic=new AnioLogic();
			anioLogic.setConnexion(this.connexion);
			anioLogic.getAnioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalAnio.equals("NONE")) {
				anioLogic.getTodosAnios(finalQueryGlobalAnio,new Pagination());
				aniosForeignKey=anioLogic.getAnios();
			}

			detalletablaamortiReturnGeneral.setaniosForeignKey(aniosForeignKey);


			List<Mes> messForeignKey=new ArrayList<Mes>();
			MesLogic mesLogic=new MesLogic();
			mesLogic.setConnexion(this.connexion);
			mesLogic.getMesDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalMes.equals("NONE")) {
				mesLogic.getTodosMess(finalQueryGlobalMes,new Pagination());
				messForeignKey=mesLogic.getMess();
			}

			detalletablaamortiReturnGeneral.setmessForeignKey(messForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return detalletablaamortiReturnGeneral;
	}
	
	
	public void deepLoad(DetalleTablaAmorti detalletablaamorti,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			DetalleTablaAmortiLogicAdditional.updateDetalleTablaAmortiToGet(detalletablaamorti,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		detalletablaamorti.setEmpresa(detalletablaamortiDataAccess.getEmpresa(connexion,detalletablaamorti));
		detalletablaamorti.setSucursal(detalletablaamortiDataAccess.getSucursal(connexion,detalletablaamorti));
		detalletablaamorti.setEjercicio(detalletablaamortiDataAccess.getEjercicio(connexion,detalletablaamorti));
		detalletablaamorti.setPeriodo(detalletablaamortiDataAccess.getPeriodo(connexion,detalletablaamorti));
		detalletablaamorti.setTablaAmorti(detalletablaamortiDataAccess.getTablaAmorti(connexion,detalletablaamorti));
		detalletablaamorti.setAnio(detalletablaamortiDataAccess.getAnio(connexion,detalletablaamorti));
		detalletablaamorti.setMes(detalletablaamortiDataAccess.getMes(connexion,detalletablaamorti));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				detalletablaamorti.setEmpresa(detalletablaamortiDataAccess.getEmpresa(connexion,detalletablaamorti));
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				detalletablaamorti.setSucursal(detalletablaamortiDataAccess.getSucursal(connexion,detalletablaamorti));
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				detalletablaamorti.setEjercicio(detalletablaamortiDataAccess.getEjercicio(connexion,detalletablaamorti));
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				detalletablaamorti.setPeriodo(detalletablaamortiDataAccess.getPeriodo(connexion,detalletablaamorti));
				continue;
			}

			if(clas.clas.equals(TablaAmorti.class)) {
				detalletablaamorti.setTablaAmorti(detalletablaamortiDataAccess.getTablaAmorti(connexion,detalletablaamorti));
				continue;
			}

			if(clas.clas.equals(Anio.class)) {
				detalletablaamorti.setAnio(detalletablaamortiDataAccess.getAnio(connexion,detalletablaamorti));
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				detalletablaamorti.setMes(detalletablaamortiDataAccess.getMes(connexion,detalletablaamorti));
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
			detalletablaamorti.setEmpresa(detalletablaamortiDataAccess.getEmpresa(connexion,detalletablaamorti));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalletablaamorti.setSucursal(detalletablaamortiDataAccess.getSucursal(connexion,detalletablaamorti));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Ejercicio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalletablaamorti.setEjercicio(detalletablaamortiDataAccess.getEjercicio(connexion,detalletablaamorti));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Periodo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalletablaamorti.setPeriodo(detalletablaamortiDataAccess.getPeriodo(connexion,detalletablaamorti));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TablaAmorti.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalletablaamorti.setTablaAmorti(detalletablaamortiDataAccess.getTablaAmorti(connexion,detalletablaamorti));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Anio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalletablaamorti.setAnio(detalletablaamortiDataAccess.getAnio(connexion,detalletablaamorti));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Mes.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalletablaamorti.setMes(detalletablaamortiDataAccess.getMes(connexion,detalletablaamorti));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		detalletablaamorti.setEmpresa(detalletablaamortiDataAccess.getEmpresa(connexion,detalletablaamorti));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(detalletablaamorti.getEmpresa(),isDeep,deepLoadType,clases);
				
		detalletablaamorti.setSucursal(detalletablaamortiDataAccess.getSucursal(connexion,detalletablaamorti));
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(detalletablaamorti.getSucursal(),isDeep,deepLoadType,clases);
				
		detalletablaamorti.setEjercicio(detalletablaamortiDataAccess.getEjercicio(connexion,detalletablaamorti));
		EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
		ejercicioLogic.deepLoad(detalletablaamorti.getEjercicio(),isDeep,deepLoadType,clases);
				
		detalletablaamorti.setPeriodo(detalletablaamortiDataAccess.getPeriodo(connexion,detalletablaamorti));
		PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
		periodoLogic.deepLoad(detalletablaamorti.getPeriodo(),isDeep,deepLoadType,clases);
				
		detalletablaamorti.setTablaAmorti(detalletablaamortiDataAccess.getTablaAmorti(connexion,detalletablaamorti));
		TablaAmortiLogic tablaamortiLogic= new TablaAmortiLogic(connexion);
		tablaamortiLogic.deepLoad(detalletablaamorti.getTablaAmorti(),isDeep,deepLoadType,clases);
				
		detalletablaamorti.setAnio(detalletablaamortiDataAccess.getAnio(connexion,detalletablaamorti));
		AnioLogic anioLogic= new AnioLogic(connexion);
		anioLogic.deepLoad(detalletablaamorti.getAnio(),isDeep,deepLoadType,clases);
				
		detalletablaamorti.setMes(detalletablaamortiDataAccess.getMes(connexion,detalletablaamorti));
		MesLogic mesLogic= new MesLogic(connexion);
		mesLogic.deepLoad(detalletablaamorti.getMes(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				detalletablaamorti.setEmpresa(detalletablaamortiDataAccess.getEmpresa(connexion,detalletablaamorti));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(detalletablaamorti.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				detalletablaamorti.setSucursal(detalletablaamortiDataAccess.getSucursal(connexion,detalletablaamorti));
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepLoad(detalletablaamorti.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				detalletablaamorti.setEjercicio(detalletablaamortiDataAccess.getEjercicio(connexion,detalletablaamorti));
				EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
				ejercicioLogic.deepLoad(detalletablaamorti.getEjercicio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				detalletablaamorti.setPeriodo(detalletablaamortiDataAccess.getPeriodo(connexion,detalletablaamorti));
				PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
				periodoLogic.deepLoad(detalletablaamorti.getPeriodo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TablaAmorti.class)) {
				detalletablaamorti.setTablaAmorti(detalletablaamortiDataAccess.getTablaAmorti(connexion,detalletablaamorti));
				TablaAmortiLogic tablaamortiLogic= new TablaAmortiLogic(connexion);
				tablaamortiLogic.deepLoad(detalletablaamorti.getTablaAmorti(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Anio.class)) {
				detalletablaamorti.setAnio(detalletablaamortiDataAccess.getAnio(connexion,detalletablaamorti));
				AnioLogic anioLogic= new AnioLogic(connexion);
				anioLogic.deepLoad(detalletablaamorti.getAnio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				detalletablaamorti.setMes(detalletablaamortiDataAccess.getMes(connexion,detalletablaamorti));
				MesLogic mesLogic= new MesLogic(connexion);
				mesLogic.deepLoad(detalletablaamorti.getMes(),isDeep,deepLoadType,clases);				
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
			detalletablaamorti.setEmpresa(detalletablaamortiDataAccess.getEmpresa(connexion,detalletablaamorti));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(detalletablaamorti.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalletablaamorti.setSucursal(detalletablaamortiDataAccess.getSucursal(connexion,detalletablaamorti));
			SucursalLogic sucursalLogic= new SucursalLogic(connexion);
			sucursalLogic.deepLoad(detalletablaamorti.getSucursal(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Ejercicio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalletablaamorti.setEjercicio(detalletablaamortiDataAccess.getEjercicio(connexion,detalletablaamorti));
			EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
			ejercicioLogic.deepLoad(detalletablaamorti.getEjercicio(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Periodo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalletablaamorti.setPeriodo(detalletablaamortiDataAccess.getPeriodo(connexion,detalletablaamorti));
			PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
			periodoLogic.deepLoad(detalletablaamorti.getPeriodo(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TablaAmorti.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalletablaamorti.setTablaAmorti(detalletablaamortiDataAccess.getTablaAmorti(connexion,detalletablaamorti));
			TablaAmortiLogic tablaamortiLogic= new TablaAmortiLogic(connexion);
			tablaamortiLogic.deepLoad(detalletablaamorti.getTablaAmorti(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Anio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalletablaamorti.setAnio(detalletablaamortiDataAccess.getAnio(connexion,detalletablaamorti));
			AnioLogic anioLogic= new AnioLogic(connexion);
			anioLogic.deepLoad(detalletablaamorti.getAnio(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Mes.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalletablaamorti.setMes(detalletablaamortiDataAccess.getMes(connexion,detalletablaamorti));
			MesLogic mesLogic= new MesLogic(connexion);
			mesLogic.deepLoad(detalletablaamorti.getMes(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(DetalleTablaAmorti detalletablaamorti,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			DetalleTablaAmortiLogicAdditional.updateDetalleTablaAmortiToSave(detalletablaamorti,this.arrDatoGeneral);
			
DetalleTablaAmortiDataAccess.save(detalletablaamorti, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(detalletablaamorti.getEmpresa(),connexion);

		SucursalDataAccess.save(detalletablaamorti.getSucursal(),connexion);

		EjercicioDataAccess.save(detalletablaamorti.getEjercicio(),connexion);

		PeriodoDataAccess.save(detalletablaamorti.getPeriodo(),connexion);

		TablaAmortiDataAccess.save(detalletablaamorti.getTablaAmorti(),connexion);

		AnioDataAccess.save(detalletablaamorti.getAnio(),connexion);

		MesDataAccess.save(detalletablaamorti.getMes(),connexion);
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(detalletablaamorti.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(detalletablaamorti.getSucursal(),connexion);
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				EjercicioDataAccess.save(detalletablaamorti.getEjercicio(),connexion);
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				PeriodoDataAccess.save(detalletablaamorti.getPeriodo(),connexion);
				continue;
			}

			if(clas.clas.equals(TablaAmorti.class)) {
				TablaAmortiDataAccess.save(detalletablaamorti.getTablaAmorti(),connexion);
				continue;
			}

			if(clas.clas.equals(Anio.class)) {
				AnioDataAccess.save(detalletablaamorti.getAnio(),connexion);
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				MesDataAccess.save(detalletablaamorti.getMes(),connexion);
				continue;
			}

		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(detalletablaamorti.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(detalletablaamorti.getEmpresa(),isDeep,deepLoadType,clases);
				

		SucursalDataAccess.save(detalletablaamorti.getSucursal(),connexion);
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(detalletablaamorti.getSucursal(),isDeep,deepLoadType,clases);
				

		EjercicioDataAccess.save(detalletablaamorti.getEjercicio(),connexion);
		EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
		ejercicioLogic.deepLoad(detalletablaamorti.getEjercicio(),isDeep,deepLoadType,clases);
				

		PeriodoDataAccess.save(detalletablaamorti.getPeriodo(),connexion);
		PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
		periodoLogic.deepLoad(detalletablaamorti.getPeriodo(),isDeep,deepLoadType,clases);
				

		TablaAmortiDataAccess.save(detalletablaamorti.getTablaAmorti(),connexion);
		TablaAmortiLogic tablaamortiLogic= new TablaAmortiLogic(connexion);
		tablaamortiLogic.deepLoad(detalletablaamorti.getTablaAmorti(),isDeep,deepLoadType,clases);
				

		AnioDataAccess.save(detalletablaamorti.getAnio(),connexion);
		AnioLogic anioLogic= new AnioLogic(connexion);
		anioLogic.deepLoad(detalletablaamorti.getAnio(),isDeep,deepLoadType,clases);
				

		MesDataAccess.save(detalletablaamorti.getMes(),connexion);
		MesLogic mesLogic= new MesLogic(connexion);
		mesLogic.deepLoad(detalletablaamorti.getMes(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(detalletablaamorti.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(detalletablaamorti.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(detalletablaamorti.getSucursal(),connexion);
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepSave(detalletablaamorti.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				EjercicioDataAccess.save(detalletablaamorti.getEjercicio(),connexion);
				EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
				ejercicioLogic.deepSave(detalletablaamorti.getEjercicio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				PeriodoDataAccess.save(detalletablaamorti.getPeriodo(),connexion);
				PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
				periodoLogic.deepSave(detalletablaamorti.getPeriodo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TablaAmorti.class)) {
				TablaAmortiDataAccess.save(detalletablaamorti.getTablaAmorti(),connexion);
				TablaAmortiLogic tablaamortiLogic= new TablaAmortiLogic(connexion);
				tablaamortiLogic.deepSave(detalletablaamorti.getTablaAmorti(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Anio.class)) {
				AnioDataAccess.save(detalletablaamorti.getAnio(),connexion);
				AnioLogic anioLogic= new AnioLogic(connexion);
				anioLogic.deepSave(detalletablaamorti.getAnio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				MesDataAccess.save(detalletablaamorti.getMes(),connexion);
				MesLogic mesLogic= new MesLogic(connexion);
				mesLogic.deepSave(detalletablaamorti.getMes(),isDeep,deepLoadType,clases);				
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
			this.getNewConnexionToDeep(DetalleTablaAmorti.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(detalletablaamorti,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				DetalleTablaAmortiConstantesFunciones.refrescarForeignKeysDescripcionesDetalleTablaAmorti(detalletablaamorti);
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
			this.deepLoad(this.detalletablaamorti,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				DetalleTablaAmortiConstantesFunciones.refrescarForeignKeysDescripcionesDetalleTablaAmorti(this.detalletablaamorti);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(DetalleTablaAmorti.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(detalletablaamortis!=null) {
				for(DetalleTablaAmorti detalletablaamorti:detalletablaamortis) {
					this.deepLoad(detalletablaamorti,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					DetalleTablaAmortiConstantesFunciones.refrescarForeignKeysDescripcionesDetalleTablaAmorti(detalletablaamortis);
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
			if(detalletablaamortis!=null) {
				for(DetalleTablaAmorti detalletablaamorti:detalletablaamortis) {
					this.deepLoad(detalletablaamorti,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					DetalleTablaAmortiConstantesFunciones.refrescarForeignKeysDescripcionesDetalleTablaAmorti(detalletablaamortis);
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
			this.getNewConnexionToDeep(DetalleTablaAmorti.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(detalletablaamorti,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(DetalleTablaAmorti.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(detalletablaamortis!=null) {
				for(DetalleTablaAmorti detalletablaamorti:detalletablaamortis) {
					this.deepSave(detalletablaamorti,isDeep,deepLoadType,clases);
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
			if(detalletablaamortis!=null) {
				for(DetalleTablaAmorti detalletablaamorti:detalletablaamortis) {
					this.deepSave(detalletablaamorti,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getDetalleTablaAmortisFK_IdAnioWithConnection(String sFinalQuery,Pagination pagination,Long id_anio)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleTablaAmorti.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidAnio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidAnio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_anio,DetalleTablaAmortiConstantesFunciones.IDANIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidAnio);

			DetalleTablaAmortiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdAnio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalletablaamortis=detalletablaamortiDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleTablaAmortiConstantesFunciones.refrescarForeignKeysDescripcionesDetalleTablaAmorti(this.detalletablaamortis);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleTablaAmortisFK_IdAnio(String sFinalQuery,Pagination pagination,Long id_anio)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidAnio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidAnio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_anio,DetalleTablaAmortiConstantesFunciones.IDANIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidAnio);

			DetalleTablaAmortiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdAnio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalletablaamortis=detalletablaamortiDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleTablaAmortiConstantesFunciones.refrescarForeignKeysDescripcionesDetalleTablaAmorti(this.detalletablaamortis);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetalleTablaAmortisFK_IdEjercicioWithConnection(String sFinalQuery,Pagination pagination,Long id_ejercicio)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleTablaAmorti.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEjercicio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEjercicio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_ejercicio,DetalleTablaAmortiConstantesFunciones.IDEJERCICIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEjercicio);

			DetalleTablaAmortiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEjercicio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalletablaamortis=detalletablaamortiDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleTablaAmortiConstantesFunciones.refrescarForeignKeysDescripcionesDetalleTablaAmorti(this.detalletablaamortis);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleTablaAmortisFK_IdEjercicio(String sFinalQuery,Pagination pagination,Long id_ejercicio)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEjercicio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEjercicio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_ejercicio,DetalleTablaAmortiConstantesFunciones.IDEJERCICIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEjercicio);

			DetalleTablaAmortiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEjercicio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalletablaamortis=detalletablaamortiDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleTablaAmortiConstantesFunciones.refrescarForeignKeysDescripcionesDetalleTablaAmorti(this.detalletablaamortis);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetalleTablaAmortisFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleTablaAmorti.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,DetalleTablaAmortiConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			DetalleTablaAmortiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalletablaamortis=detalletablaamortiDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleTablaAmortiConstantesFunciones.refrescarForeignKeysDescripcionesDetalleTablaAmorti(this.detalletablaamortis);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleTablaAmortisFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,DetalleTablaAmortiConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			DetalleTablaAmortiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalletablaamortis=detalletablaamortiDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleTablaAmortiConstantesFunciones.refrescarForeignKeysDescripcionesDetalleTablaAmorti(this.detalletablaamortis);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetalleTablaAmortisFK_IdMesWithConnection(String sFinalQuery,Pagination pagination,Long id_mes)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleTablaAmorti.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidMes= new ParameterSelectionGeneral();
			parameterSelectionGeneralidMes.setParameterSelectionGeneralEqual(ParameterType.LONG,id_mes,DetalleTablaAmortiConstantesFunciones.IDMES,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidMes);

			DetalleTablaAmortiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdMes","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalletablaamortis=detalletablaamortiDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleTablaAmortiConstantesFunciones.refrescarForeignKeysDescripcionesDetalleTablaAmorti(this.detalletablaamortis);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleTablaAmortisFK_IdMes(String sFinalQuery,Pagination pagination,Long id_mes)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidMes= new ParameterSelectionGeneral();
			parameterSelectionGeneralidMes.setParameterSelectionGeneralEqual(ParameterType.LONG,id_mes,DetalleTablaAmortiConstantesFunciones.IDMES,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidMes);

			DetalleTablaAmortiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdMes","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalletablaamortis=detalletablaamortiDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleTablaAmortiConstantesFunciones.refrescarForeignKeysDescripcionesDetalleTablaAmorti(this.detalletablaamortis);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetalleTablaAmortisFK_IdPeriodoWithConnection(String sFinalQuery,Pagination pagination,Long id_periodo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleTablaAmorti.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPeriodo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPeriodo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_periodo,DetalleTablaAmortiConstantesFunciones.IDPERIODO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPeriodo);

			DetalleTablaAmortiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPeriodo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalletablaamortis=detalletablaamortiDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleTablaAmortiConstantesFunciones.refrescarForeignKeysDescripcionesDetalleTablaAmorti(this.detalletablaamortis);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleTablaAmortisFK_IdPeriodo(String sFinalQuery,Pagination pagination,Long id_periodo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPeriodo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPeriodo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_periodo,DetalleTablaAmortiConstantesFunciones.IDPERIODO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPeriodo);

			DetalleTablaAmortiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPeriodo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalletablaamortis=detalletablaamortiDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleTablaAmortiConstantesFunciones.refrescarForeignKeysDescripcionesDetalleTablaAmorti(this.detalletablaamortis);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetalleTablaAmortisFK_IdSucursalWithConnection(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleTablaAmorti.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,DetalleTablaAmortiConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			DetalleTablaAmortiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalletablaamortis=detalletablaamortiDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleTablaAmortiConstantesFunciones.refrescarForeignKeysDescripcionesDetalleTablaAmorti(this.detalletablaamortis);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleTablaAmortisFK_IdSucursal(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,DetalleTablaAmortiConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			DetalleTablaAmortiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalletablaamortis=detalletablaamortiDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleTablaAmortiConstantesFunciones.refrescarForeignKeysDescripcionesDetalleTablaAmorti(this.detalletablaamortis);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetalleTablaAmortisFK_IdTablaAmortiWithConnection(String sFinalQuery,Pagination pagination,Long id_tabla_amorti)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleTablaAmorti.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTablaAmorti= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTablaAmorti.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tabla_amorti,DetalleTablaAmortiConstantesFunciones.IDTABLAAMORTI,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTablaAmorti);

			DetalleTablaAmortiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTablaAmorti","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalletablaamortis=detalletablaamortiDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleTablaAmortiConstantesFunciones.refrescarForeignKeysDescripcionesDetalleTablaAmorti(this.detalletablaamortis);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleTablaAmortisFK_IdTablaAmorti(String sFinalQuery,Pagination pagination,Long id_tabla_amorti)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTablaAmorti= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTablaAmorti.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tabla_amorti,DetalleTablaAmortiConstantesFunciones.IDTABLAAMORTI,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTablaAmorti);

			DetalleTablaAmortiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTablaAmorti","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalletablaamortis=detalletablaamortiDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleTablaAmortiConstantesFunciones.refrescarForeignKeysDescripcionesDetalleTablaAmorti(this.detalletablaamortis);
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
			if(DetalleTablaAmortiConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,DetalleTablaAmortiDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,DetalleTablaAmorti detalletablaamorti,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(DetalleTablaAmortiConstantesFunciones.ISCONAUDITORIA) {
				if(detalletablaamorti.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,DetalleTablaAmortiDataAccess.TABLENAME, detalletablaamorti.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(DetalleTablaAmortiConstantesFunciones.ISCONAUDITORIADETALLE) {
						////DetalleTablaAmortiLogic.registrarAuditoriaDetallesDetalleTablaAmorti(connexion,detalletablaamorti,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(detalletablaamorti.getIsDeleted()) {
					/*if(!detalletablaamorti.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,DetalleTablaAmortiDataAccess.TABLENAME, detalletablaamorti.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////DetalleTablaAmortiLogic.registrarAuditoriaDetallesDetalleTablaAmorti(connexion,detalletablaamorti,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,DetalleTablaAmortiDataAccess.TABLENAME, detalletablaamorti.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(detalletablaamorti.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,DetalleTablaAmortiDataAccess.TABLENAME, detalletablaamorti.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(DetalleTablaAmortiConstantesFunciones.ISCONAUDITORIADETALLE) {
						////DetalleTablaAmortiLogic.registrarAuditoriaDetallesDetalleTablaAmorti(connexion,detalletablaamorti,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesDetalleTablaAmorti(Connexion connexion,DetalleTablaAmorti detalletablaamorti)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(detalletablaamorti.getIsNew()||!detalletablaamorti.getid_empresa().equals(detalletablaamorti.getDetalleTablaAmortiOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalletablaamorti.getDetalleTablaAmortiOriginal().getid_empresa()!=null)
				{
					strValorActual=detalletablaamorti.getDetalleTablaAmortiOriginal().getid_empresa().toString();
				}
				if(detalletablaamorti.getid_empresa()!=null)
				{
					strValorNuevo=detalletablaamorti.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleTablaAmortiConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(detalletablaamorti.getIsNew()||!detalletablaamorti.getid_sucursal().equals(detalletablaamorti.getDetalleTablaAmortiOriginal().getid_sucursal()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalletablaamorti.getDetalleTablaAmortiOriginal().getid_sucursal()!=null)
				{
					strValorActual=detalletablaamorti.getDetalleTablaAmortiOriginal().getid_sucursal().toString();
				}
				if(detalletablaamorti.getid_sucursal()!=null)
				{
					strValorNuevo=detalletablaamorti.getid_sucursal().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleTablaAmortiConstantesFunciones.IDSUCURSAL,strValorActual,strValorNuevo);
			}	
			
			if(detalletablaamorti.getIsNew()||!detalletablaamorti.getid_ejercicio().equals(detalletablaamorti.getDetalleTablaAmortiOriginal().getid_ejercicio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalletablaamorti.getDetalleTablaAmortiOriginal().getid_ejercicio()!=null)
				{
					strValorActual=detalletablaamorti.getDetalleTablaAmortiOriginal().getid_ejercicio().toString();
				}
				if(detalletablaamorti.getid_ejercicio()!=null)
				{
					strValorNuevo=detalletablaamorti.getid_ejercicio().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleTablaAmortiConstantesFunciones.IDEJERCICIO,strValorActual,strValorNuevo);
			}	
			
			if(detalletablaamorti.getIsNew()||!detalletablaamorti.getid_periodo().equals(detalletablaamorti.getDetalleTablaAmortiOriginal().getid_periodo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalletablaamorti.getDetalleTablaAmortiOriginal().getid_periodo()!=null)
				{
					strValorActual=detalletablaamorti.getDetalleTablaAmortiOriginal().getid_periodo().toString();
				}
				if(detalletablaamorti.getid_periodo()!=null)
				{
					strValorNuevo=detalletablaamorti.getid_periodo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleTablaAmortiConstantesFunciones.IDPERIODO,strValorActual,strValorNuevo);
			}	
			
			if(detalletablaamorti.getIsNew()||!detalletablaamorti.getid_tabla_amorti().equals(detalletablaamorti.getDetalleTablaAmortiOriginal().getid_tabla_amorti()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalletablaamorti.getDetalleTablaAmortiOriginal().getid_tabla_amorti()!=null)
				{
					strValorActual=detalletablaamorti.getDetalleTablaAmortiOriginal().getid_tabla_amorti().toString();
				}
				if(detalletablaamorti.getid_tabla_amorti()!=null)
				{
					strValorNuevo=detalletablaamorti.getid_tabla_amorti().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleTablaAmortiConstantesFunciones.IDTABLAAMORTI,strValorActual,strValorNuevo);
			}	
			
			if(detalletablaamorti.getIsNew()||!detalletablaamorti.getvalor().equals(detalletablaamorti.getDetalleTablaAmortiOriginal().getvalor()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalletablaamorti.getDetalleTablaAmortiOriginal().getvalor()!=null)
				{
					strValorActual=detalletablaamorti.getDetalleTablaAmortiOriginal().getvalor().toString();
				}
				if(detalletablaamorti.getvalor()!=null)
				{
					strValorNuevo=detalletablaamorti.getvalor().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleTablaAmortiConstantesFunciones.VALOR,strValorActual,strValorNuevo);
			}	
			
			if(detalletablaamorti.getIsNew()||!detalletablaamorti.getinteres().equals(detalletablaamorti.getDetalleTablaAmortiOriginal().getinteres()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalletablaamorti.getDetalleTablaAmortiOriginal().getinteres()!=null)
				{
					strValorActual=detalletablaamorti.getDetalleTablaAmortiOriginal().getinteres().toString();
				}
				if(detalletablaamorti.getinteres()!=null)
				{
					strValorNuevo=detalletablaamorti.getinteres().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleTablaAmortiConstantesFunciones.INTERES,strValorActual,strValorNuevo);
			}	
			
			if(detalletablaamorti.getIsNew()||!detalletablaamorti.getcapital().equals(detalletablaamorti.getDetalleTablaAmortiOriginal().getcapital()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalletablaamorti.getDetalleTablaAmortiOriginal().getcapital()!=null)
				{
					strValorActual=detalletablaamorti.getDetalleTablaAmortiOriginal().getcapital().toString();
				}
				if(detalletablaamorti.getcapital()!=null)
				{
					strValorNuevo=detalletablaamorti.getcapital().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleTablaAmortiConstantesFunciones.CAPITAL,strValorActual,strValorNuevo);
			}	
			
			if(detalletablaamorti.getIsNew()||!detalletablaamorti.getfecha_inicio().equals(detalletablaamorti.getDetalleTablaAmortiOriginal().getfecha_inicio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalletablaamorti.getDetalleTablaAmortiOriginal().getfecha_inicio()!=null)
				{
					strValorActual=detalletablaamorti.getDetalleTablaAmortiOriginal().getfecha_inicio().toString();
				}
				if(detalletablaamorti.getfecha_inicio()!=null)
				{
					strValorNuevo=detalletablaamorti.getfecha_inicio().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleTablaAmortiConstantesFunciones.FECHAINICIO,strValorActual,strValorNuevo);
			}	
			
			if(detalletablaamorti.getIsNew()||!detalletablaamorti.getfecha_fin().equals(detalletablaamorti.getDetalleTablaAmortiOriginal().getfecha_fin()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalletablaamorti.getDetalleTablaAmortiOriginal().getfecha_fin()!=null)
				{
					strValorActual=detalletablaamorti.getDetalleTablaAmortiOriginal().getfecha_fin().toString();
				}
				if(detalletablaamorti.getfecha_fin()!=null)
				{
					strValorNuevo=detalletablaamorti.getfecha_fin().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleTablaAmortiConstantesFunciones.FECHAFIN,strValorActual,strValorNuevo);
			}	
			
			if(detalletablaamorti.getIsNew()||!detalletablaamorti.getdescripcion().equals(detalletablaamorti.getDetalleTablaAmortiOriginal().getdescripcion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalletablaamorti.getDetalleTablaAmortiOriginal().getdescripcion()!=null)
				{
					strValorActual=detalletablaamorti.getDetalleTablaAmortiOriginal().getdescripcion();
				}
				if(detalletablaamorti.getdescripcion()!=null)
				{
					strValorNuevo=detalletablaamorti.getdescripcion() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleTablaAmortiConstantesFunciones.DESCRIPCION,strValorActual,strValorNuevo);
			}	
			
			if(detalletablaamorti.getIsNew()||!detalletablaamorti.getid_anio().equals(detalletablaamorti.getDetalleTablaAmortiOriginal().getid_anio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalletablaamorti.getDetalleTablaAmortiOriginal().getid_anio()!=null)
				{
					strValorActual=detalletablaamorti.getDetalleTablaAmortiOriginal().getid_anio().toString();
				}
				if(detalletablaamorti.getid_anio()!=null)
				{
					strValorNuevo=detalletablaamorti.getid_anio().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleTablaAmortiConstantesFunciones.IDANIO,strValorActual,strValorNuevo);
			}	
			
			if(detalletablaamorti.getIsNew()||!detalletablaamorti.getid_mes().equals(detalletablaamorti.getDetalleTablaAmortiOriginal().getid_mes()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalletablaamorti.getDetalleTablaAmortiOriginal().getid_mes()!=null)
				{
					strValorActual=detalletablaamorti.getDetalleTablaAmortiOriginal().getid_mes().toString();
				}
				if(detalletablaamorti.getid_mes()!=null)
				{
					strValorNuevo=detalletablaamorti.getid_mes().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleTablaAmortiConstantesFunciones.IDMES,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveDetalleTablaAmortiRelacionesWithConnection(DetalleTablaAmorti detalletablaamorti) throws Exception {

		if(!detalletablaamorti.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveDetalleTablaAmortiRelacionesBase(detalletablaamorti,true);
		}
	}

	public void saveDetalleTablaAmortiRelaciones(DetalleTablaAmorti detalletablaamorti)throws Exception {

		if(!detalletablaamorti.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveDetalleTablaAmortiRelacionesBase(detalletablaamorti,false);
		}
	}

	public void saveDetalleTablaAmortiRelacionesBase(DetalleTablaAmorti detalletablaamorti,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("DetalleTablaAmorti-saveRelacionesWithConnection");}
	

			this.setDetalleTablaAmorti(detalletablaamorti);

			if(DetalleTablaAmortiLogicAdditional.validarSaveRelaciones(detalletablaamorti,this)) {

				DetalleTablaAmortiLogicAdditional.updateRelacionesToSave(detalletablaamorti,this);

				if((detalletablaamorti.getIsNew()||detalletablaamorti.getIsChanged())&&!detalletablaamorti.getIsDeleted()) {
					this.saveDetalleTablaAmorti();
					this.saveDetalleTablaAmortiRelacionesDetalles();

				} else if(detalletablaamorti.getIsDeleted()) {
					this.saveDetalleTablaAmortiRelacionesDetalles();
					this.saveDetalleTablaAmorti();
				}

				DetalleTablaAmortiLogicAdditional.updateRelacionesToSaveAfter(detalletablaamorti,this);

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
	
	
	private void saveDetalleTablaAmortiRelacionesDetalles()throws Exception {
		try {
	

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfDetalleTablaAmorti(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=DetalleTablaAmortiConstantesFunciones.getClassesForeignKeysOfDetalleTablaAmorti(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfDetalleTablaAmorti(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=DetalleTablaAmortiConstantesFunciones.getClassesRelationshipsOfDetalleTablaAmorti(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

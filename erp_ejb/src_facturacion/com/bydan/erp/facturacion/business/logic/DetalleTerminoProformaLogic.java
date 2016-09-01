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
import com.bydan.erp.facturacion.util.DetalleTerminoProformaConstantesFunciones;
import com.bydan.erp.facturacion.util.DetalleTerminoProformaParameterReturnGeneral;
//import com.bydan.erp.facturacion.util.DetalleTerminoProformaParameterGeneral;
import com.bydan.erp.facturacion.business.entity.DetalleTerminoProforma;
import com.bydan.erp.facturacion.business.logic.DetalleTerminoProformaLogicAdditional;
import com.bydan.erp.facturacion.business.dataaccess.*;
import com.bydan.erp.facturacion.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;


import com.bydan.erp.seguridad.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;








@SuppressWarnings("unused")
public class DetalleTerminoProformaLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(DetalleTerminoProformaLogic.class);
	
	protected DetalleTerminoProformaDataAccess detalleterminoproformaDataAccess; 	
	protected DetalleTerminoProforma detalleterminoproforma;
	protected List<DetalleTerminoProforma> detalleterminoproformas;
	protected Object detalleterminoproformaObject;	
	protected List<Object> detalleterminoproformasObject;
	
	public static ClassValidator<DetalleTerminoProforma> detalleterminoproformaValidator = new ClassValidator<DetalleTerminoProforma>(DetalleTerminoProforma.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected DetalleTerminoProformaLogicAdditional detalleterminoproformaLogicAdditional=null;
	
	public DetalleTerminoProformaLogicAdditional getDetalleTerminoProformaLogicAdditional() {
		return this.detalleterminoproformaLogicAdditional;
	}
	
	public void setDetalleTerminoProformaLogicAdditional(DetalleTerminoProformaLogicAdditional detalleterminoproformaLogicAdditional) {
		try {
			this.detalleterminoproformaLogicAdditional=detalleterminoproformaLogicAdditional;
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
	
	
	
	
	public  DetalleTerminoProformaLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.detalleterminoproformaDataAccess = new DetalleTerminoProformaDataAccess();
			
			this.detalleterminoproformas= new ArrayList<DetalleTerminoProforma>();
			this.detalleterminoproforma= new DetalleTerminoProforma();
			
			this.detalleterminoproformaObject=new Object();
			this.detalleterminoproformasObject=new ArrayList<Object>();
				
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
			
			this.detalleterminoproformaDataAccess.setConnexionType(this.connexionType);
			this.detalleterminoproformaDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  DetalleTerminoProformaLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.detalleterminoproformaDataAccess = new DetalleTerminoProformaDataAccess();
			this.detalleterminoproformas= new ArrayList<DetalleTerminoProforma>();
			this.detalleterminoproforma= new DetalleTerminoProforma();
			this.detalleterminoproformaObject=new Object();
			this.detalleterminoproformasObject=new ArrayList<Object>();
			
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
			
			this.detalleterminoproformaDataAccess.setConnexionType(this.connexionType);
			this.detalleterminoproformaDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public DetalleTerminoProforma getDetalleTerminoProforma() throws Exception {	
		DetalleTerminoProformaLogicAdditional.checkDetalleTerminoProformaToGet(detalleterminoproforma,this.datosCliente,this.arrDatoGeneral);
		DetalleTerminoProformaLogicAdditional.updateDetalleTerminoProformaToGet(detalleterminoproforma,this.arrDatoGeneral);
		
		return detalleterminoproforma;
	}
		
	public void setDetalleTerminoProforma(DetalleTerminoProforma newDetalleTerminoProforma) {
		this.detalleterminoproforma = newDetalleTerminoProforma;
	}
	
	public DetalleTerminoProformaDataAccess getDetalleTerminoProformaDataAccess() {
		return detalleterminoproformaDataAccess;
	}
	
	public void setDetalleTerminoProformaDataAccess(DetalleTerminoProformaDataAccess newdetalleterminoproformaDataAccess) {
		this.detalleterminoproformaDataAccess = newdetalleterminoproformaDataAccess;
	}
	
	public List<DetalleTerminoProforma> getDetalleTerminoProformas() throws Exception {		
		this.quitarDetalleTerminoProformasNulos();
		
		DetalleTerminoProformaLogicAdditional.checkDetalleTerminoProformaToGets(detalleterminoproformas,this.datosCliente,this.arrDatoGeneral);
		
		for (DetalleTerminoProforma detalleterminoproformaLocal: detalleterminoproformas ) {
			DetalleTerminoProformaLogicAdditional.updateDetalleTerminoProformaToGet(detalleterminoproformaLocal,this.arrDatoGeneral);
		}
		
		return detalleterminoproformas;
	}
	
	public void setDetalleTerminoProformas(List<DetalleTerminoProforma> newDetalleTerminoProformas) {
		this.detalleterminoproformas = newDetalleTerminoProformas;
	}
	
	public Object getDetalleTerminoProformaObject() {	
		this.detalleterminoproformaObject=this.detalleterminoproformaDataAccess.getEntityObject();
		return this.detalleterminoproformaObject;
	}
		
	public void setDetalleTerminoProformaObject(Object newDetalleTerminoProformaObject) {
		this.detalleterminoproformaObject = newDetalleTerminoProformaObject;
	}
	
	public List<Object> getDetalleTerminoProformasObject() {		
		this.detalleterminoproformasObject=this.detalleterminoproformaDataAccess.getEntitiesObject();
		return this.detalleterminoproformasObject;
	}
		
	public void setDetalleTerminoProformasObject(List<Object> newDetalleTerminoProformasObject) {
		this.detalleterminoproformasObject = newDetalleTerminoProformasObject;
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
		
		if(this.detalleterminoproformaDataAccess!=null) {
			this.detalleterminoproformaDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleTerminoProforma.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			detalleterminoproformaDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			detalleterminoproformaDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		detalleterminoproforma = new  DetalleTerminoProforma();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleTerminoProforma.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			detalleterminoproforma=detalleterminoproformaDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.detalleterminoproforma,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				DetalleTerminoProformaConstantesFunciones.refrescarForeignKeysDescripcionesDetalleTerminoProforma(this.detalleterminoproforma);
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
		detalleterminoproforma = new  DetalleTerminoProforma();
		  		  
        try {
			
			detalleterminoproforma=detalleterminoproformaDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.detalleterminoproforma,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				DetalleTerminoProformaConstantesFunciones.refrescarForeignKeysDescripcionesDetalleTerminoProforma(this.detalleterminoproforma);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		detalleterminoproforma = new  DetalleTerminoProforma();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleTerminoProforma.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			detalleterminoproforma=detalleterminoproformaDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.detalleterminoproforma,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				DetalleTerminoProformaConstantesFunciones.refrescarForeignKeysDescripcionesDetalleTerminoProforma(this.detalleterminoproforma);
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
		detalleterminoproforma = new  DetalleTerminoProforma();
		  		  
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
		detalleterminoproforma = new  DetalleTerminoProforma();
		  		  
        try {
			
			detalleterminoproforma=detalleterminoproformaDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.detalleterminoproforma,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				DetalleTerminoProformaConstantesFunciones.refrescarForeignKeysDescripcionesDetalleTerminoProforma(this.detalleterminoproforma);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		detalleterminoproforma = new  DetalleTerminoProforma();
		  		  
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
		detalleterminoproforma = new  DetalleTerminoProforma();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleTerminoProforma.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =detalleterminoproformaDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		detalleterminoproforma = new  DetalleTerminoProforma();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=detalleterminoproformaDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		detalleterminoproforma = new  DetalleTerminoProforma();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleTerminoProforma.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =detalleterminoproformaDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		detalleterminoproforma = new  DetalleTerminoProforma();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=detalleterminoproformaDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		detalleterminoproforma = new  DetalleTerminoProforma();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleTerminoProforma.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =detalleterminoproformaDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		detalleterminoproforma = new  DetalleTerminoProforma();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=detalleterminoproformaDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		detalleterminoproformas = new  ArrayList<DetalleTerminoProforma>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleTerminoProforma.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			DetalleTerminoProformaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detalleterminoproformas=detalleterminoproformaDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarDetalleTerminoProforma(detalleterminoproformas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleTerminoProformaConstantesFunciones.refrescarForeignKeysDescripcionesDetalleTerminoProforma(this.detalleterminoproformas);
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
		detalleterminoproformas = new  ArrayList<DetalleTerminoProforma>();
		  		  
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
		detalleterminoproformas = new  ArrayList<DetalleTerminoProforma>();
		  		  
        try {			
			DetalleTerminoProformaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detalleterminoproformas=detalleterminoproformaDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarDetalleTerminoProforma(detalleterminoproformas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleTerminoProformaConstantesFunciones.refrescarForeignKeysDescripcionesDetalleTerminoProforma(this.detalleterminoproformas);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		detalleterminoproformas = new  ArrayList<DetalleTerminoProforma>();
		  		  
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
		detalleterminoproformas = new  ArrayList<DetalleTerminoProforma>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleTerminoProforma.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			DetalleTerminoProformaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detalleterminoproformas=detalleterminoproformaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarDetalleTerminoProforma(detalleterminoproformas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleTerminoProformaConstantesFunciones.refrescarForeignKeysDescripcionesDetalleTerminoProforma(this.detalleterminoproformas);
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
		detalleterminoproformas = new  ArrayList<DetalleTerminoProforma>();
		  		  
        try {
			DetalleTerminoProformaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detalleterminoproformas=detalleterminoproformaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarDetalleTerminoProforma(detalleterminoproformas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleTerminoProformaConstantesFunciones.refrescarForeignKeysDescripcionesDetalleTerminoProforma(this.detalleterminoproformas);
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
		detalleterminoproformas = new  ArrayList<DetalleTerminoProforma>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleTerminoProforma.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DetalleTerminoProformaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detalleterminoproformas=detalleterminoproformaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarDetalleTerminoProforma(detalleterminoproformas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleTerminoProformaConstantesFunciones.refrescarForeignKeysDescripcionesDetalleTerminoProforma(this.detalleterminoproformas);
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
		detalleterminoproformas = new  ArrayList<DetalleTerminoProforma>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DetalleTerminoProformaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detalleterminoproformas=detalleterminoproformaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarDetalleTerminoProforma(detalleterminoproformas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleTerminoProformaConstantesFunciones.refrescarForeignKeysDescripcionesDetalleTerminoProforma(this.detalleterminoproformas);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		detalleterminoproforma = new  DetalleTerminoProforma();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleTerminoProforma.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DetalleTerminoProformaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detalleterminoproforma=detalleterminoproformaDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarDetalleTerminoProforma(detalleterminoproforma);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleTerminoProformaConstantesFunciones.refrescarForeignKeysDescripcionesDetalleTerminoProforma(this.detalleterminoproforma);
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
		detalleterminoproforma = new  DetalleTerminoProforma();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DetalleTerminoProformaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detalleterminoproforma=detalleterminoproformaDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarDetalleTerminoProforma(detalleterminoproforma);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleTerminoProformaConstantesFunciones.refrescarForeignKeysDescripcionesDetalleTerminoProforma(this.detalleterminoproforma);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		detalleterminoproformas = new  ArrayList<DetalleTerminoProforma>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleTerminoProforma.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			DetalleTerminoProformaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detalleterminoproformas=detalleterminoproformaDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarDetalleTerminoProforma(detalleterminoproformas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleTerminoProformaConstantesFunciones.refrescarForeignKeysDescripcionesDetalleTerminoProforma(this.detalleterminoproformas);
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
		detalleterminoproformas = new  ArrayList<DetalleTerminoProforma>();
		  		  
        try {
			DetalleTerminoProformaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detalleterminoproformas=detalleterminoproformaDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarDetalleTerminoProforma(detalleterminoproformas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleTerminoProformaConstantesFunciones.refrescarForeignKeysDescripcionesDetalleTerminoProforma(this.detalleterminoproformas);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosDetalleTerminoProformasWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		detalleterminoproformas = new  ArrayList<DetalleTerminoProforma>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleTerminoProforma.class.getSimpleName()+"-getTodosDetalleTerminoProformasWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DetalleTerminoProformaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detalleterminoproformas=detalleterminoproformaDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarDetalleTerminoProforma(detalleterminoproformas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleTerminoProformaConstantesFunciones.refrescarForeignKeysDescripcionesDetalleTerminoProforma(this.detalleterminoproformas);
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
	
	public  void  getTodosDetalleTerminoProformas(String sFinalQuery,Pagination pagination)throws Exception {
		detalleterminoproformas = new  ArrayList<DetalleTerminoProforma>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DetalleTerminoProformaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detalleterminoproformas=detalleterminoproformaDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarDetalleTerminoProforma(detalleterminoproformas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleTerminoProformaConstantesFunciones.refrescarForeignKeysDescripcionesDetalleTerminoProforma(this.detalleterminoproformas);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarDetalleTerminoProforma(DetalleTerminoProforma detalleterminoproforma) throws Exception {
		Boolean estaValidado=false;
		
		if(detalleterminoproforma.getIsNew() || detalleterminoproforma.getIsChanged()) { 
			this.invalidValues = detalleterminoproformaValidator.getInvalidValues(detalleterminoproforma);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(detalleterminoproforma);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarDetalleTerminoProforma(List<DetalleTerminoProforma> DetalleTerminoProformas) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(DetalleTerminoProforma detalleterminoproformaLocal:detalleterminoproformas) {				
			estaValidadoObjeto=this.validarGuardarDetalleTerminoProforma(detalleterminoproformaLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarDetalleTerminoProforma(List<DetalleTerminoProforma> DetalleTerminoProformas) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarDetalleTerminoProforma(detalleterminoproformas)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarDetalleTerminoProforma(DetalleTerminoProforma DetalleTerminoProforma) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarDetalleTerminoProforma(detalleterminoproforma)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(DetalleTerminoProforma detalleterminoproforma) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+detalleterminoproforma.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=DetalleTerminoProformaConstantesFunciones.getDetalleTerminoProformaLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"detalleterminoproforma","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(DetalleTerminoProformaConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(DetalleTerminoProformaConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveDetalleTerminoProformaWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleTerminoProforma.class.getSimpleName()+"-saveDetalleTerminoProformaWithConnection");connexion.begin();			
			
			DetalleTerminoProformaLogicAdditional.checkDetalleTerminoProformaToSave(this.detalleterminoproforma,this.datosCliente,connexion,this.arrDatoGeneral);
			
			DetalleTerminoProformaLogicAdditional.updateDetalleTerminoProformaToSave(this.detalleterminoproforma,this.arrDatoGeneral);
			
			DetalleTerminoProformaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.detalleterminoproforma,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowDetalleTerminoProforma();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarDetalleTerminoProforma(this.detalleterminoproforma)) {
				DetalleTerminoProformaDataAccess.save(this.detalleterminoproforma, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.detalleterminoproforma,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			DetalleTerminoProformaLogicAdditional.checkDetalleTerminoProformaToSaveAfter(this.detalleterminoproforma,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowDetalleTerminoProforma();
			
			connexion.commit();			
			
			if(this.detalleterminoproforma.getIsDeleted()) {
				this.detalleterminoproforma=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveDetalleTerminoProforma()throws Exception {	
		try {	
			
			DetalleTerminoProformaLogicAdditional.checkDetalleTerminoProformaToSave(this.detalleterminoproforma,this.datosCliente,connexion,this.arrDatoGeneral);
			
			DetalleTerminoProformaLogicAdditional.updateDetalleTerminoProformaToSave(this.detalleterminoproforma,this.arrDatoGeneral);
			
			DetalleTerminoProformaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.detalleterminoproforma,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarDetalleTerminoProforma(this.detalleterminoproforma)) {			
				DetalleTerminoProformaDataAccess.save(this.detalleterminoproforma, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.detalleterminoproforma,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			DetalleTerminoProformaLogicAdditional.checkDetalleTerminoProformaToSaveAfter(this.detalleterminoproforma,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.detalleterminoproforma.getIsDeleted()) {
				this.detalleterminoproforma=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveDetalleTerminoProformasWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleTerminoProforma.class.getSimpleName()+"-saveDetalleTerminoProformasWithConnection");connexion.begin();			
			
			DetalleTerminoProformaLogicAdditional.checkDetalleTerminoProformaToSaves(detalleterminoproformas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowDetalleTerminoProformas();
			
			Boolean validadoTodosDetalleTerminoProforma=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(DetalleTerminoProforma detalleterminoproformaLocal:detalleterminoproformas) {		
				if(detalleterminoproformaLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				DetalleTerminoProformaLogicAdditional.updateDetalleTerminoProformaToSave(detalleterminoproformaLocal,this.arrDatoGeneral);
	        	
				DetalleTerminoProformaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),detalleterminoproformaLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarDetalleTerminoProforma(detalleterminoproformaLocal)) {
					DetalleTerminoProformaDataAccess.save(detalleterminoproformaLocal, connexion);				
				} else {
					validadoTodosDetalleTerminoProforma=false;
				}
			}
			
			if(!validadoTodosDetalleTerminoProforma) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			DetalleTerminoProformaLogicAdditional.checkDetalleTerminoProformaToSavesAfter(detalleterminoproformas,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowDetalleTerminoProformas();
			
			connexion.commit();		
			
			this.quitarDetalleTerminoProformasEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveDetalleTerminoProformas()throws Exception {				
		 try {	
			DetalleTerminoProformaLogicAdditional.checkDetalleTerminoProformaToSaves(detalleterminoproformas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosDetalleTerminoProforma=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(DetalleTerminoProforma detalleterminoproformaLocal:detalleterminoproformas) {				
				if(detalleterminoproformaLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				DetalleTerminoProformaLogicAdditional.updateDetalleTerminoProformaToSave(detalleterminoproformaLocal,this.arrDatoGeneral);
	        	
				DetalleTerminoProformaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),detalleterminoproformaLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarDetalleTerminoProforma(detalleterminoproformaLocal)) {				
					DetalleTerminoProformaDataAccess.save(detalleterminoproformaLocal, connexion);				
				} else {
					validadoTodosDetalleTerminoProforma=false;
				}
			}
			
			if(!validadoTodosDetalleTerminoProforma) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			DetalleTerminoProformaLogicAdditional.checkDetalleTerminoProformaToSavesAfter(detalleterminoproformas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarDetalleTerminoProformasEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public DetalleTerminoProformaParameterReturnGeneral procesarAccionDetalleTerminoProformas(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<DetalleTerminoProforma> detalleterminoproformas,DetalleTerminoProformaParameterReturnGeneral detalleterminoproformaParameterGeneral)throws Exception {
		 try {	
			DetalleTerminoProformaParameterReturnGeneral detalleterminoproformaReturnGeneral=new DetalleTerminoProformaParameterReturnGeneral();
	
			DetalleTerminoProformaLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,detalleterminoproformas,detalleterminoproformaParameterGeneral,detalleterminoproformaReturnGeneral);
			
			return detalleterminoproformaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public DetalleTerminoProformaParameterReturnGeneral procesarAccionDetalleTerminoProformasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<DetalleTerminoProforma> detalleterminoproformas,DetalleTerminoProformaParameterReturnGeneral detalleterminoproformaParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleTerminoProforma.class.getSimpleName()+"-procesarAccionDetalleTerminoProformasWithConnection");connexion.begin();			
			
			DetalleTerminoProformaParameterReturnGeneral detalleterminoproformaReturnGeneral=new DetalleTerminoProformaParameterReturnGeneral();
	
			DetalleTerminoProformaLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,detalleterminoproformas,detalleterminoproformaParameterGeneral,detalleterminoproformaReturnGeneral);
			
			this.connexion.commit();
			
			return detalleterminoproformaReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public DetalleTerminoProformaParameterReturnGeneral procesarEventosDetalleTerminoProformas(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<DetalleTerminoProforma> detalleterminoproformas,DetalleTerminoProforma detalleterminoproforma,DetalleTerminoProformaParameterReturnGeneral detalleterminoproformaParameterGeneral,Boolean isEsNuevoDetalleTerminoProforma,ArrayList<Classe> clases)throws Exception {
		 try {	
			DetalleTerminoProformaParameterReturnGeneral detalleterminoproformaReturnGeneral=new DetalleTerminoProformaParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				detalleterminoproformaReturnGeneral.setConRecargarPropiedades(true);
			}
			
			DetalleTerminoProformaLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,detalleterminoproformas,detalleterminoproforma,detalleterminoproformaParameterGeneral,detalleterminoproformaReturnGeneral,isEsNuevoDetalleTerminoProforma,clases);
			
			return detalleterminoproformaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public DetalleTerminoProformaParameterReturnGeneral procesarEventosDetalleTerminoProformasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<DetalleTerminoProforma> detalleterminoproformas,DetalleTerminoProforma detalleterminoproforma,DetalleTerminoProformaParameterReturnGeneral detalleterminoproformaParameterGeneral,Boolean isEsNuevoDetalleTerminoProforma,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleTerminoProforma.class.getSimpleName()+"-procesarEventosDetalleTerminoProformasWithConnection");connexion.begin();			
			
			DetalleTerminoProformaParameterReturnGeneral detalleterminoproformaReturnGeneral=new DetalleTerminoProformaParameterReturnGeneral();
	
			detalleterminoproformaReturnGeneral.setDetalleTerminoProforma(detalleterminoproforma);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				detalleterminoproformaReturnGeneral.setConRecargarPropiedades(true);
			}
			
			DetalleTerminoProformaLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,detalleterminoproformas,detalleterminoproforma,detalleterminoproformaParameterGeneral,detalleterminoproformaReturnGeneral,isEsNuevoDetalleTerminoProforma,clases);
			
			this.connexion.commit();
			
			return detalleterminoproformaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public DetalleTerminoProformaParameterReturnGeneral procesarImportacionDetalleTerminoProformasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,DetalleTerminoProformaParameterReturnGeneral detalleterminoproformaParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleTerminoProforma.class.getSimpleName()+"-procesarImportacionDetalleTerminoProformasWithConnection");connexion.begin();			
			
			DetalleTerminoProformaParameterReturnGeneral detalleterminoproformaReturnGeneral=new DetalleTerminoProformaParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.detalleterminoproformas=new ArrayList<DetalleTerminoProforma>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.detalleterminoproforma=new DetalleTerminoProforma();
				
				
				if(conColumnasBase) {this.detalleterminoproforma.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.detalleterminoproforma.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.detalleterminoproforma.setnumero(Integer.parseInt(arrColumnas[iColumn++]));
			this.detalleterminoproforma.setdetalle(arrColumnas[iColumn++]);
				
				this.detalleterminoproformas.add(this.detalleterminoproforma);
			}
			
			this.saveDetalleTerminoProformas();
			
			this.connexion.commit();
			
			detalleterminoproformaReturnGeneral.setConRetornoEstaProcesado(true);
			detalleterminoproformaReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return detalleterminoproformaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarDetalleTerminoProformasEliminados() throws Exception {				
		
		List<DetalleTerminoProforma> detalleterminoproformasAux= new ArrayList<DetalleTerminoProforma>();
		
		for(DetalleTerminoProforma detalleterminoproforma:detalleterminoproformas) {
			if(!detalleterminoproforma.getIsDeleted()) {
				detalleterminoproformasAux.add(detalleterminoproforma);
			}
		}
		
		detalleterminoproformas=detalleterminoproformasAux;
	}
	
	public void quitarDetalleTerminoProformasNulos() throws Exception {				
		
		List<DetalleTerminoProforma> detalleterminoproformasAux= new ArrayList<DetalleTerminoProforma>();
		
		for(DetalleTerminoProforma detalleterminoproforma : this.detalleterminoproformas) {
			if(detalleterminoproforma==null) {
				detalleterminoproformasAux.add(detalleterminoproforma);
			}
		}
		
		//this.detalleterminoproformas=detalleterminoproformasAux;
		
		this.detalleterminoproformas.removeAll(detalleterminoproformasAux);
	}
	
	public void getSetVersionRowDetalleTerminoProformaWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(detalleterminoproforma.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((detalleterminoproforma.getIsDeleted() || (detalleterminoproforma.getIsChanged()&&!detalleterminoproforma.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=detalleterminoproformaDataAccess.getSetVersionRowDetalleTerminoProforma(connexion,detalleterminoproforma.getId());
				
				if(!detalleterminoproforma.getVersionRow().equals(timestamp)) {	
					detalleterminoproforma.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				detalleterminoproforma.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowDetalleTerminoProforma()throws Exception {	
		
		if(detalleterminoproforma.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((detalleterminoproforma.getIsDeleted() || (detalleterminoproforma.getIsChanged()&&!detalleterminoproforma.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=detalleterminoproformaDataAccess.getSetVersionRowDetalleTerminoProforma(connexion,detalleterminoproforma.getId());
			
			try {							
				if(!detalleterminoproforma.getVersionRow().equals(timestamp)) {	
					detalleterminoproforma.setVersionRow(timestamp);
				}
				
				detalleterminoproforma.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowDetalleTerminoProformasWithConnection()throws Exception {	
		if(detalleterminoproformas!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(DetalleTerminoProforma detalleterminoproformaAux:detalleterminoproformas) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(detalleterminoproformaAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(detalleterminoproformaAux.getIsDeleted() || (detalleterminoproformaAux.getIsChanged()&&!detalleterminoproformaAux.getIsNew())) {
						
						timestamp=detalleterminoproformaDataAccess.getSetVersionRowDetalleTerminoProforma(connexion,detalleterminoproformaAux.getId());
						
						if(!detalleterminoproforma.getVersionRow().equals(timestamp)) {	
							detalleterminoproformaAux.setVersionRow(timestamp);
						}
								
						detalleterminoproformaAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowDetalleTerminoProformas()throws Exception {	
		if(detalleterminoproformas!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(DetalleTerminoProforma detalleterminoproformaAux:detalleterminoproformas) {
					if(detalleterminoproformaAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(detalleterminoproformaAux.getIsDeleted() || (detalleterminoproformaAux.getIsChanged()&&!detalleterminoproformaAux.getIsNew())) {
						
						timestamp=detalleterminoproformaDataAccess.getSetVersionRowDetalleTerminoProforma(connexion,detalleterminoproformaAux.getId());
						
						if(!detalleterminoproformaAux.getVersionRow().equals(timestamp)) {	
							detalleterminoproformaAux.setVersionRow(timestamp);
						}
						
													
						detalleterminoproformaAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public DetalleTerminoProformaParameterReturnGeneral cargarCombosLoteForeignKeyDetalleTerminoProformaWithConnection(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalTerminoProforma) throws Exception {
		DetalleTerminoProformaParameterReturnGeneral  detalleterminoproformaReturnGeneral =new DetalleTerminoProformaParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleTerminoProforma.class.getSimpleName()+"-cargarCombosLoteForeignKeyDetalleTerminoProformaWithConnection");connexion.begin();
			
			detalleterminoproformaReturnGeneral =new DetalleTerminoProformaParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			detalleterminoproformaReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			detalleterminoproformaReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<TerminoProforma> terminoproformasForeignKey=new ArrayList<TerminoProforma>();
			TerminoProformaLogic terminoproformaLogic=new TerminoProformaLogic();
			terminoproformaLogic.setConnexion(this.connexion);
			terminoproformaLogic.getTerminoProformaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTerminoProforma.equals("NONE")) {
				terminoproformaLogic.getTodosTerminoProformas(finalQueryGlobalTerminoProforma,new Pagination());
				terminoproformasForeignKey=terminoproformaLogic.getTerminoProformas();
			}

			detalleterminoproformaReturnGeneral.setterminoproformasForeignKey(terminoproformasForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return detalleterminoproformaReturnGeneral;
	}
	
	public DetalleTerminoProformaParameterReturnGeneral cargarCombosLoteForeignKeyDetalleTerminoProforma(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalTerminoProforma) throws Exception {
		DetalleTerminoProformaParameterReturnGeneral  detalleterminoproformaReturnGeneral =new DetalleTerminoProformaParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			detalleterminoproformaReturnGeneral =new DetalleTerminoProformaParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			detalleterminoproformaReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			detalleterminoproformaReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<TerminoProforma> terminoproformasForeignKey=new ArrayList<TerminoProforma>();
			TerminoProformaLogic terminoproformaLogic=new TerminoProformaLogic();
			terminoproformaLogic.setConnexion(this.connexion);
			terminoproformaLogic.getTerminoProformaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTerminoProforma.equals("NONE")) {
				terminoproformaLogic.getTodosTerminoProformas(finalQueryGlobalTerminoProforma,new Pagination());
				terminoproformasForeignKey=terminoproformaLogic.getTerminoProformas();
			}

			detalleterminoproformaReturnGeneral.setterminoproformasForeignKey(terminoproformasForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return detalleterminoproformaReturnGeneral;
	}
	
	
	public void deepLoad(DetalleTerminoProforma detalleterminoproforma,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			DetalleTerminoProformaLogicAdditional.updateDetalleTerminoProformaToGet(detalleterminoproforma,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		detalleterminoproforma.setEmpresa(detalleterminoproformaDataAccess.getEmpresa(connexion,detalleterminoproforma));
		detalleterminoproforma.setSucursal(detalleterminoproformaDataAccess.getSucursal(connexion,detalleterminoproforma));
		detalleterminoproforma.setTerminoProforma(detalleterminoproformaDataAccess.getTerminoProforma(connexion,detalleterminoproforma));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				detalleterminoproforma.setEmpresa(detalleterminoproformaDataAccess.getEmpresa(connexion,detalleterminoproforma));
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				detalleterminoproforma.setSucursal(detalleterminoproformaDataAccess.getSucursal(connexion,detalleterminoproforma));
				continue;
			}

			if(clas.clas.equals(TerminoProforma.class)) {
				detalleterminoproforma.setTerminoProforma(detalleterminoproformaDataAccess.getTerminoProforma(connexion,detalleterminoproforma));
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
			detalleterminoproforma.setEmpresa(detalleterminoproformaDataAccess.getEmpresa(connexion,detalleterminoproforma));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalleterminoproforma.setSucursal(detalleterminoproformaDataAccess.getSucursal(connexion,detalleterminoproforma));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TerminoProforma.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalleterminoproforma.setTerminoProforma(detalleterminoproformaDataAccess.getTerminoProforma(connexion,detalleterminoproforma));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		detalleterminoproforma.setEmpresa(detalleterminoproformaDataAccess.getEmpresa(connexion,detalleterminoproforma));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(detalleterminoproforma.getEmpresa(),isDeep,deepLoadType,clases);
				
		detalleterminoproforma.setSucursal(detalleterminoproformaDataAccess.getSucursal(connexion,detalleterminoproforma));
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(detalleterminoproforma.getSucursal(),isDeep,deepLoadType,clases);
				
		detalleterminoproforma.setTerminoProforma(detalleterminoproformaDataAccess.getTerminoProforma(connexion,detalleterminoproforma));
		TerminoProformaLogic terminoproformaLogic= new TerminoProformaLogic(connexion);
		terminoproformaLogic.deepLoad(detalleterminoproforma.getTerminoProforma(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				detalleterminoproforma.setEmpresa(detalleterminoproformaDataAccess.getEmpresa(connexion,detalleterminoproforma));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(detalleterminoproforma.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				detalleterminoproforma.setSucursal(detalleterminoproformaDataAccess.getSucursal(connexion,detalleterminoproforma));
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepLoad(detalleterminoproforma.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TerminoProforma.class)) {
				detalleterminoproforma.setTerminoProforma(detalleterminoproformaDataAccess.getTerminoProforma(connexion,detalleterminoproforma));
				TerminoProformaLogic terminoproformaLogic= new TerminoProformaLogic(connexion);
				terminoproformaLogic.deepLoad(detalleterminoproforma.getTerminoProforma(),isDeep,deepLoadType,clases);				
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
			detalleterminoproforma.setEmpresa(detalleterminoproformaDataAccess.getEmpresa(connexion,detalleterminoproforma));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(detalleterminoproforma.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalleterminoproforma.setSucursal(detalleterminoproformaDataAccess.getSucursal(connexion,detalleterminoproforma));
			SucursalLogic sucursalLogic= new SucursalLogic(connexion);
			sucursalLogic.deepLoad(detalleterminoproforma.getSucursal(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TerminoProforma.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalleterminoproforma.setTerminoProforma(detalleterminoproformaDataAccess.getTerminoProforma(connexion,detalleterminoproforma));
			TerminoProformaLogic terminoproformaLogic= new TerminoProformaLogic(connexion);
			terminoproformaLogic.deepLoad(detalleterminoproforma.getTerminoProforma(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(DetalleTerminoProforma detalleterminoproforma,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			DetalleTerminoProformaLogicAdditional.updateDetalleTerminoProformaToSave(detalleterminoproforma,this.arrDatoGeneral);
			
DetalleTerminoProformaDataAccess.save(detalleterminoproforma, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(detalleterminoproforma.getEmpresa(),connexion);

		SucursalDataAccess.save(detalleterminoproforma.getSucursal(),connexion);

		TerminoProformaDataAccess.save(detalleterminoproforma.getTerminoProforma(),connexion);
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(detalleterminoproforma.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(detalleterminoproforma.getSucursal(),connexion);
				continue;
			}

			if(clas.clas.equals(TerminoProforma.class)) {
				TerminoProformaDataAccess.save(detalleterminoproforma.getTerminoProforma(),connexion);
				continue;
			}

		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(detalleterminoproforma.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(detalleterminoproforma.getEmpresa(),isDeep,deepLoadType,clases);
				

		SucursalDataAccess.save(detalleterminoproforma.getSucursal(),connexion);
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(detalleterminoproforma.getSucursal(),isDeep,deepLoadType,clases);
				

		TerminoProformaDataAccess.save(detalleterminoproforma.getTerminoProforma(),connexion);
		TerminoProformaLogic terminoproformaLogic= new TerminoProformaLogic(connexion);
		terminoproformaLogic.deepLoad(detalleterminoproforma.getTerminoProforma(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(detalleterminoproforma.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(detalleterminoproforma.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(detalleterminoproforma.getSucursal(),connexion);
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepSave(detalleterminoproforma.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TerminoProforma.class)) {
				TerminoProformaDataAccess.save(detalleterminoproforma.getTerminoProforma(),connexion);
				TerminoProformaLogic terminoproformaLogic= new TerminoProformaLogic(connexion);
				terminoproformaLogic.deepSave(detalleterminoproforma.getTerminoProforma(),isDeep,deepLoadType,clases);				
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
			this.getNewConnexionToDeep(DetalleTerminoProforma.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(detalleterminoproforma,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				DetalleTerminoProformaConstantesFunciones.refrescarForeignKeysDescripcionesDetalleTerminoProforma(detalleterminoproforma);
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
			this.deepLoad(this.detalleterminoproforma,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				DetalleTerminoProformaConstantesFunciones.refrescarForeignKeysDescripcionesDetalleTerminoProforma(this.detalleterminoproforma);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(DetalleTerminoProforma.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(detalleterminoproformas!=null) {
				for(DetalleTerminoProforma detalleterminoproforma:detalleterminoproformas) {
					this.deepLoad(detalleterminoproforma,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					DetalleTerminoProformaConstantesFunciones.refrescarForeignKeysDescripcionesDetalleTerminoProforma(detalleterminoproformas);
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
			if(detalleterminoproformas!=null) {
				for(DetalleTerminoProforma detalleterminoproforma:detalleterminoproformas) {
					this.deepLoad(detalleterminoproforma,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					DetalleTerminoProformaConstantesFunciones.refrescarForeignKeysDescripcionesDetalleTerminoProforma(detalleterminoproformas);
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
			this.getNewConnexionToDeep(DetalleTerminoProforma.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(detalleterminoproforma,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(DetalleTerminoProforma.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(detalleterminoproformas!=null) {
				for(DetalleTerminoProforma detalleterminoproforma:detalleterminoproformas) {
					this.deepSave(detalleterminoproforma,isDeep,deepLoadType,clases);
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
			if(detalleterminoproformas!=null) {
				for(DetalleTerminoProforma detalleterminoproforma:detalleterminoproformas) {
					this.deepSave(detalleterminoproforma,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getDetalleTerminoProformasFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleTerminoProforma.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,DetalleTerminoProformaConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			DetalleTerminoProformaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleterminoproformas=detalleterminoproformaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleTerminoProformaConstantesFunciones.refrescarForeignKeysDescripcionesDetalleTerminoProforma(this.detalleterminoproformas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleTerminoProformasFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,DetalleTerminoProformaConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			DetalleTerminoProformaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleterminoproformas=detalleterminoproformaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleTerminoProformaConstantesFunciones.refrescarForeignKeysDescripcionesDetalleTerminoProforma(this.detalleterminoproformas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetalleTerminoProformasFK_IdSucursalWithConnection(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleTerminoProforma.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,DetalleTerminoProformaConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			DetalleTerminoProformaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleterminoproformas=detalleterminoproformaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleTerminoProformaConstantesFunciones.refrescarForeignKeysDescripcionesDetalleTerminoProforma(this.detalleterminoproformas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleTerminoProformasFK_IdSucursal(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,DetalleTerminoProformaConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			DetalleTerminoProformaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleterminoproformas=detalleterminoproformaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleTerminoProformaConstantesFunciones.refrescarForeignKeysDescripcionesDetalleTerminoProforma(this.detalleterminoproformas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetalleTerminoProformasFK_IdTerminoProformaWithConnection(String sFinalQuery,Pagination pagination,Long id_termino_proforma)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleTerminoProforma.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTerminoProforma= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTerminoProforma.setParameterSelectionGeneralEqual(ParameterType.LONG,id_termino_proforma,DetalleTerminoProformaConstantesFunciones.IDTERMINOPROFORMA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTerminoProforma);

			DetalleTerminoProformaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTerminoProforma","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleterminoproformas=detalleterminoproformaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleTerminoProformaConstantesFunciones.refrescarForeignKeysDescripcionesDetalleTerminoProforma(this.detalleterminoproformas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleTerminoProformasFK_IdTerminoProforma(String sFinalQuery,Pagination pagination,Long id_termino_proforma)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTerminoProforma= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTerminoProforma.setParameterSelectionGeneralEqual(ParameterType.LONG,id_termino_proforma,DetalleTerminoProformaConstantesFunciones.IDTERMINOPROFORMA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTerminoProforma);

			DetalleTerminoProformaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTerminoProforma","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleterminoproformas=detalleterminoproformaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleTerminoProformaConstantesFunciones.refrescarForeignKeysDescripcionesDetalleTerminoProforma(this.detalleterminoproformas);
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
			if(DetalleTerminoProformaConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,DetalleTerminoProformaDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,DetalleTerminoProforma detalleterminoproforma,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(DetalleTerminoProformaConstantesFunciones.ISCONAUDITORIA) {
				if(detalleterminoproforma.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,DetalleTerminoProformaDataAccess.TABLENAME, detalleterminoproforma.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(DetalleTerminoProformaConstantesFunciones.ISCONAUDITORIADETALLE) {
						////DetalleTerminoProformaLogic.registrarAuditoriaDetallesDetalleTerminoProforma(connexion,detalleterminoproforma,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(detalleterminoproforma.getIsDeleted()) {
					/*if(!detalleterminoproforma.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,DetalleTerminoProformaDataAccess.TABLENAME, detalleterminoproforma.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////DetalleTerminoProformaLogic.registrarAuditoriaDetallesDetalleTerminoProforma(connexion,detalleterminoproforma,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,DetalleTerminoProformaDataAccess.TABLENAME, detalleterminoproforma.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(detalleterminoproforma.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,DetalleTerminoProformaDataAccess.TABLENAME, detalleterminoproforma.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(DetalleTerminoProformaConstantesFunciones.ISCONAUDITORIADETALLE) {
						////DetalleTerminoProformaLogic.registrarAuditoriaDetallesDetalleTerminoProforma(connexion,detalleterminoproforma,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesDetalleTerminoProforma(Connexion connexion,DetalleTerminoProforma detalleterminoproforma)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(detalleterminoproforma.getIsNew()||!detalleterminoproforma.getid_empresa().equals(detalleterminoproforma.getDetalleTerminoProformaOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleterminoproforma.getDetalleTerminoProformaOriginal().getid_empresa()!=null)
				{
					strValorActual=detalleterminoproforma.getDetalleTerminoProformaOriginal().getid_empresa().toString();
				}
				if(detalleterminoproforma.getid_empresa()!=null)
				{
					strValorNuevo=detalleterminoproforma.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleTerminoProformaConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(detalleterminoproforma.getIsNew()||!detalleterminoproforma.getid_sucursal().equals(detalleterminoproforma.getDetalleTerminoProformaOriginal().getid_sucursal()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleterminoproforma.getDetalleTerminoProformaOriginal().getid_sucursal()!=null)
				{
					strValorActual=detalleterminoproforma.getDetalleTerminoProformaOriginal().getid_sucursal().toString();
				}
				if(detalleterminoproforma.getid_sucursal()!=null)
				{
					strValorNuevo=detalleterminoproforma.getid_sucursal().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleTerminoProformaConstantesFunciones.IDSUCURSAL,strValorActual,strValorNuevo);
			}	
			
			if(detalleterminoproforma.getIsNew()||!detalleterminoproforma.getid_termino_proforma().equals(detalleterminoproforma.getDetalleTerminoProformaOriginal().getid_termino_proforma()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleterminoproforma.getDetalleTerminoProformaOriginal().getid_termino_proforma()!=null)
				{
					strValorActual=detalleterminoproforma.getDetalleTerminoProformaOriginal().getid_termino_proforma().toString();
				}
				if(detalleterminoproforma.getid_termino_proforma()!=null)
				{
					strValorNuevo=detalleterminoproforma.getid_termino_proforma().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleTerminoProformaConstantesFunciones.IDTERMINOPROFORMA,strValorActual,strValorNuevo);
			}	
			
			if(detalleterminoproforma.getIsNew()||!detalleterminoproforma.getnumero().equals(detalleterminoproforma.getDetalleTerminoProformaOriginal().getnumero()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleterminoproforma.getDetalleTerminoProformaOriginal().getnumero()!=null)
				{
					strValorActual=detalleterminoproforma.getDetalleTerminoProformaOriginal().getnumero().toString();
				}
				if(detalleterminoproforma.getnumero()!=null)
				{
					strValorNuevo=detalleterminoproforma.getnumero().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleTerminoProformaConstantesFunciones.NUMERO,strValorActual,strValorNuevo);
			}	
			
			if(detalleterminoproforma.getIsNew()||!detalleterminoproforma.getdetalle().equals(detalleterminoproforma.getDetalleTerminoProformaOriginal().getdetalle()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleterminoproforma.getDetalleTerminoProformaOriginal().getdetalle()!=null)
				{
					strValorActual=detalleterminoproforma.getDetalleTerminoProformaOriginal().getdetalle();
				}
				if(detalleterminoproforma.getdetalle()!=null)
				{
					strValorNuevo=detalleterminoproforma.getdetalle() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleTerminoProformaConstantesFunciones.DETALLE,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveDetalleTerminoProformaRelacionesWithConnection(DetalleTerminoProforma detalleterminoproforma) throws Exception {

		if(!detalleterminoproforma.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveDetalleTerminoProformaRelacionesBase(detalleterminoproforma,true);
		}
	}

	public void saveDetalleTerminoProformaRelaciones(DetalleTerminoProforma detalleterminoproforma)throws Exception {

		if(!detalleterminoproforma.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveDetalleTerminoProformaRelacionesBase(detalleterminoproforma,false);
		}
	}

	public void saveDetalleTerminoProformaRelacionesBase(DetalleTerminoProforma detalleterminoproforma,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("DetalleTerminoProforma-saveRelacionesWithConnection");}
	

			this.setDetalleTerminoProforma(detalleterminoproforma);

			if(DetalleTerminoProformaLogicAdditional.validarSaveRelaciones(detalleterminoproforma,this)) {

				DetalleTerminoProformaLogicAdditional.updateRelacionesToSave(detalleterminoproforma,this);

				if((detalleterminoproforma.getIsNew()||detalleterminoproforma.getIsChanged())&&!detalleterminoproforma.getIsDeleted()) {
					this.saveDetalleTerminoProforma();
					this.saveDetalleTerminoProformaRelacionesDetalles();

				} else if(detalleterminoproforma.getIsDeleted()) {
					this.saveDetalleTerminoProformaRelacionesDetalles();
					this.saveDetalleTerminoProforma();
				}

				DetalleTerminoProformaLogicAdditional.updateRelacionesToSaveAfter(detalleterminoproforma,this);

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
	
	
	private void saveDetalleTerminoProformaRelacionesDetalles()throws Exception {
		try {
	

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfDetalleTerminoProforma(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=DetalleTerminoProformaConstantesFunciones.getClassesForeignKeysOfDetalleTerminoProforma(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfDetalleTerminoProforma(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=DetalleTerminoProformaConstantesFunciones.getClassesRelationshipsOfDetalleTerminoProforma(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

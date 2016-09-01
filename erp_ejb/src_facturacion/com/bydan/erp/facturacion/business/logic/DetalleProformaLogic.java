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
import com.bydan.erp.facturacion.util.DetalleProformaConstantesFunciones;
import com.bydan.erp.facturacion.util.DetalleProformaParameterReturnGeneral;
//import com.bydan.erp.facturacion.util.DetalleProformaParameterGeneral;
import com.bydan.erp.facturacion.business.entity.DetalleProforma;
import com.bydan.erp.facturacion.business.logic.DetalleProformaLogicAdditional;
import com.bydan.erp.facturacion.business.dataaccess.*;
import com.bydan.erp.facturacion.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;
import com.bydan.erp.contabilidad.business.logic.*;
import com.bydan.erp.inventario.business.logic.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.inventario.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;
import com.bydan.erp.inventario.business.dataaccess.*;








@SuppressWarnings("unused")
public class DetalleProformaLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(DetalleProformaLogic.class);
	
	protected DetalleProformaDataAccess detalleproformaDataAccess; 	
	protected DetalleProforma detalleproforma;
	protected List<DetalleProforma> detalleproformas;
	protected Object detalleproformaObject;	
	protected List<Object> detalleproformasObject;
	
	public static ClassValidator<DetalleProforma> detalleproformaValidator = new ClassValidator<DetalleProforma>(DetalleProforma.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected DetalleProformaLogicAdditional detalleproformaLogicAdditional=null;
	
	public DetalleProformaLogicAdditional getDetalleProformaLogicAdditional() {
		return this.detalleproformaLogicAdditional;
	}
	
	public void setDetalleProformaLogicAdditional(DetalleProformaLogicAdditional detalleproformaLogicAdditional) {
		try {
			this.detalleproformaLogicAdditional=detalleproformaLogicAdditional;
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
	
	
	
	
	public  DetalleProformaLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.detalleproformaDataAccess = new DetalleProformaDataAccess();
			
			this.detalleproformas= new ArrayList<DetalleProforma>();
			this.detalleproforma= new DetalleProforma();
			
			this.detalleproformaObject=new Object();
			this.detalleproformasObject=new ArrayList<Object>();
				
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
			
			this.detalleproformaDataAccess.setConnexionType(this.connexionType);
			this.detalleproformaDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  DetalleProformaLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.detalleproformaDataAccess = new DetalleProformaDataAccess();
			this.detalleproformas= new ArrayList<DetalleProforma>();
			this.detalleproforma= new DetalleProforma();
			this.detalleproformaObject=new Object();
			this.detalleproformasObject=new ArrayList<Object>();
			
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
			
			this.detalleproformaDataAccess.setConnexionType(this.connexionType);
			this.detalleproformaDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public DetalleProforma getDetalleProforma() throws Exception {	
		DetalleProformaLogicAdditional.checkDetalleProformaToGet(detalleproforma,this.datosCliente,this.arrDatoGeneral);
		DetalleProformaLogicAdditional.updateDetalleProformaToGet(detalleproforma,this.arrDatoGeneral);
		
		return detalleproforma;
	}
		
	public void setDetalleProforma(DetalleProforma newDetalleProforma) {
		this.detalleproforma = newDetalleProforma;
	}
	
	public DetalleProformaDataAccess getDetalleProformaDataAccess() {
		return detalleproformaDataAccess;
	}
	
	public void setDetalleProformaDataAccess(DetalleProformaDataAccess newdetalleproformaDataAccess) {
		this.detalleproformaDataAccess = newdetalleproformaDataAccess;
	}
	
	public List<DetalleProforma> getDetalleProformas() throws Exception {		
		this.quitarDetalleProformasNulos();
		
		DetalleProformaLogicAdditional.checkDetalleProformaToGets(detalleproformas,this.datosCliente,this.arrDatoGeneral);
		
		for (DetalleProforma detalleproformaLocal: detalleproformas ) {
			DetalleProformaLogicAdditional.updateDetalleProformaToGet(detalleproformaLocal,this.arrDatoGeneral);
		}
		
		return detalleproformas;
	}
	
	public void setDetalleProformas(List<DetalleProforma> newDetalleProformas) {
		this.detalleproformas = newDetalleProformas;
	}
	
	public Object getDetalleProformaObject() {	
		this.detalleproformaObject=this.detalleproformaDataAccess.getEntityObject();
		return this.detalleproformaObject;
	}
		
	public void setDetalleProformaObject(Object newDetalleProformaObject) {
		this.detalleproformaObject = newDetalleProformaObject;
	}
	
	public List<Object> getDetalleProformasObject() {		
		this.detalleproformasObject=this.detalleproformaDataAccess.getEntitiesObject();
		return this.detalleproformasObject;
	}
		
	public void setDetalleProformasObject(List<Object> newDetalleProformasObject) {
		this.detalleproformasObject = newDetalleProformasObject;
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
		
		if(this.detalleproformaDataAccess!=null) {
			this.detalleproformaDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleProforma.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			detalleproformaDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			detalleproformaDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		detalleproforma = new  DetalleProforma();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleProforma.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			detalleproforma=detalleproformaDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.detalleproforma,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				DetalleProformaConstantesFunciones.refrescarForeignKeysDescripcionesDetalleProforma(this.detalleproforma);
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
		detalleproforma = new  DetalleProforma();
		  		  
        try {
			
			detalleproforma=detalleproformaDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.detalleproforma,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				DetalleProformaConstantesFunciones.refrescarForeignKeysDescripcionesDetalleProforma(this.detalleproforma);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		detalleproforma = new  DetalleProforma();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleProforma.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			detalleproforma=detalleproformaDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.detalleproforma,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				DetalleProformaConstantesFunciones.refrescarForeignKeysDescripcionesDetalleProforma(this.detalleproforma);
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
		detalleproforma = new  DetalleProforma();
		  		  
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
		detalleproforma = new  DetalleProforma();
		  		  
        try {
			
			detalleproforma=detalleproformaDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.detalleproforma,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				DetalleProformaConstantesFunciones.refrescarForeignKeysDescripcionesDetalleProforma(this.detalleproforma);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		detalleproforma = new  DetalleProforma();
		  		  
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
		detalleproforma = new  DetalleProforma();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleProforma.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =detalleproformaDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		detalleproforma = new  DetalleProforma();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=detalleproformaDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		detalleproforma = new  DetalleProforma();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleProforma.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =detalleproformaDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		detalleproforma = new  DetalleProforma();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=detalleproformaDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		detalleproforma = new  DetalleProforma();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleProforma.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =detalleproformaDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		detalleproforma = new  DetalleProforma();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=detalleproformaDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		detalleproformas = new  ArrayList<DetalleProforma>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleProforma.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			DetalleProformaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detalleproformas=detalleproformaDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarDetalleProforma(detalleproformas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleProformaConstantesFunciones.refrescarForeignKeysDescripcionesDetalleProforma(this.detalleproformas);
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
		detalleproformas = new  ArrayList<DetalleProforma>();
		  		  
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
		detalleproformas = new  ArrayList<DetalleProforma>();
		  		  
        try {			
			DetalleProformaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detalleproformas=detalleproformaDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarDetalleProforma(detalleproformas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleProformaConstantesFunciones.refrescarForeignKeysDescripcionesDetalleProforma(this.detalleproformas);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		detalleproformas = new  ArrayList<DetalleProforma>();
		  		  
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
		detalleproformas = new  ArrayList<DetalleProforma>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleProforma.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			DetalleProformaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detalleproformas=detalleproformaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarDetalleProforma(detalleproformas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleProformaConstantesFunciones.refrescarForeignKeysDescripcionesDetalleProforma(this.detalleproformas);
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
		detalleproformas = new  ArrayList<DetalleProforma>();
		  		  
        try {
			DetalleProformaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detalleproformas=detalleproformaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarDetalleProforma(detalleproformas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleProformaConstantesFunciones.refrescarForeignKeysDescripcionesDetalleProforma(this.detalleproformas);
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
		detalleproformas = new  ArrayList<DetalleProforma>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleProforma.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DetalleProformaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detalleproformas=detalleproformaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarDetalleProforma(detalleproformas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleProformaConstantesFunciones.refrescarForeignKeysDescripcionesDetalleProforma(this.detalleproformas);
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
		detalleproformas = new  ArrayList<DetalleProforma>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DetalleProformaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detalleproformas=detalleproformaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarDetalleProforma(detalleproformas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleProformaConstantesFunciones.refrescarForeignKeysDescripcionesDetalleProforma(this.detalleproformas);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		detalleproforma = new  DetalleProforma();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleProforma.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DetalleProformaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detalleproforma=detalleproformaDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarDetalleProforma(detalleproforma);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleProformaConstantesFunciones.refrescarForeignKeysDescripcionesDetalleProforma(this.detalleproforma);
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
		detalleproforma = new  DetalleProforma();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DetalleProformaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detalleproforma=detalleproformaDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarDetalleProforma(detalleproforma);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleProformaConstantesFunciones.refrescarForeignKeysDescripcionesDetalleProforma(this.detalleproforma);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		detalleproformas = new  ArrayList<DetalleProforma>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleProforma.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			DetalleProformaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detalleproformas=detalleproformaDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarDetalleProforma(detalleproformas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleProformaConstantesFunciones.refrescarForeignKeysDescripcionesDetalleProforma(this.detalleproformas);
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
		detalleproformas = new  ArrayList<DetalleProforma>();
		  		  
        try {
			DetalleProformaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detalleproformas=detalleproformaDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarDetalleProforma(detalleproformas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleProformaConstantesFunciones.refrescarForeignKeysDescripcionesDetalleProforma(this.detalleproformas);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosDetalleProformasWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		detalleproformas = new  ArrayList<DetalleProforma>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleProforma.class.getSimpleName()+"-getTodosDetalleProformasWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DetalleProformaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detalleproformas=detalleproformaDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarDetalleProforma(detalleproformas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleProformaConstantesFunciones.refrescarForeignKeysDescripcionesDetalleProforma(this.detalleproformas);
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
	
	public  void  getTodosDetalleProformas(String sFinalQuery,Pagination pagination)throws Exception {
		detalleproformas = new  ArrayList<DetalleProforma>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DetalleProformaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detalleproformas=detalleproformaDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarDetalleProforma(detalleproformas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleProformaConstantesFunciones.refrescarForeignKeysDescripcionesDetalleProforma(this.detalleproformas);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarDetalleProforma(DetalleProforma detalleproforma) throws Exception {
		Boolean estaValidado=false;
		
		if(detalleproforma.getIsNew() || detalleproforma.getIsChanged()) { 
			this.invalidValues = detalleproformaValidator.getInvalidValues(detalleproforma);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(detalleproforma);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarDetalleProforma(List<DetalleProforma> DetalleProformas) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(DetalleProforma detalleproformaLocal:detalleproformas) {				
			estaValidadoObjeto=this.validarGuardarDetalleProforma(detalleproformaLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarDetalleProforma(List<DetalleProforma> DetalleProformas) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarDetalleProforma(detalleproformas)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarDetalleProforma(DetalleProforma DetalleProforma) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarDetalleProforma(detalleproforma)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(DetalleProforma detalleproforma) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+detalleproforma.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=DetalleProformaConstantesFunciones.getDetalleProformaLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"detalleproforma","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(DetalleProformaConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(DetalleProformaConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveDetalleProformaWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleProforma.class.getSimpleName()+"-saveDetalleProformaWithConnection");connexion.begin();			
			
			DetalleProformaLogicAdditional.checkDetalleProformaToSave(this.detalleproforma,this.datosCliente,connexion,this.arrDatoGeneral);
			
			DetalleProformaLogicAdditional.updateDetalleProformaToSave(this.detalleproforma,this.arrDatoGeneral);
			
			DetalleProformaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.detalleproforma,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowDetalleProforma();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarDetalleProforma(this.detalleproforma)) {
				DetalleProformaDataAccess.save(this.detalleproforma, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.detalleproforma,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			DetalleProformaLogicAdditional.checkDetalleProformaToSaveAfter(this.detalleproforma,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowDetalleProforma();
			
			connexion.commit();			
			
			if(this.detalleproforma.getIsDeleted()) {
				this.detalleproforma=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveDetalleProforma()throws Exception {	
		try {	
			
			DetalleProformaLogicAdditional.checkDetalleProformaToSave(this.detalleproforma,this.datosCliente,connexion,this.arrDatoGeneral);
			
			DetalleProformaLogicAdditional.updateDetalleProformaToSave(this.detalleproforma,this.arrDatoGeneral);
			
			DetalleProformaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.detalleproforma,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarDetalleProforma(this.detalleproforma)) {			
				DetalleProformaDataAccess.save(this.detalleproforma, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.detalleproforma,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			DetalleProformaLogicAdditional.checkDetalleProformaToSaveAfter(this.detalleproforma,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.detalleproforma.getIsDeleted()) {
				this.detalleproforma=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveDetalleProformasWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleProforma.class.getSimpleName()+"-saveDetalleProformasWithConnection");connexion.begin();			
			
			DetalleProformaLogicAdditional.checkDetalleProformaToSaves(detalleproformas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowDetalleProformas();
			
			Boolean validadoTodosDetalleProforma=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(DetalleProforma detalleproformaLocal:detalleproformas) {		
				if(detalleproformaLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				DetalleProformaLogicAdditional.updateDetalleProformaToSave(detalleproformaLocal,this.arrDatoGeneral);
	        	
				DetalleProformaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),detalleproformaLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarDetalleProforma(detalleproformaLocal)) {
					DetalleProformaDataAccess.save(detalleproformaLocal, connexion);				
				} else {
					validadoTodosDetalleProforma=false;
				}
			}
			
			if(!validadoTodosDetalleProforma) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			DetalleProformaLogicAdditional.checkDetalleProformaToSavesAfter(detalleproformas,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowDetalleProformas();
			
			connexion.commit();		
			
			this.quitarDetalleProformasEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveDetalleProformas()throws Exception {				
		 try {	
			DetalleProformaLogicAdditional.checkDetalleProformaToSaves(detalleproformas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosDetalleProforma=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(DetalleProforma detalleproformaLocal:detalleproformas) {				
				if(detalleproformaLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				DetalleProformaLogicAdditional.updateDetalleProformaToSave(detalleproformaLocal,this.arrDatoGeneral);
	        	
				DetalleProformaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),detalleproformaLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarDetalleProforma(detalleproformaLocal)) {				
					DetalleProformaDataAccess.save(detalleproformaLocal, connexion);				
				} else {
					validadoTodosDetalleProforma=false;
				}
			}
			
			if(!validadoTodosDetalleProforma) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			DetalleProformaLogicAdditional.checkDetalleProformaToSavesAfter(detalleproformas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarDetalleProformasEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public DetalleProformaParameterReturnGeneral procesarAccionDetalleProformas(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<DetalleProforma> detalleproformas,DetalleProformaParameterReturnGeneral detalleproformaParameterGeneral)throws Exception {
		 try {	
			DetalleProformaParameterReturnGeneral detalleproformaReturnGeneral=new DetalleProformaParameterReturnGeneral();
	
			DetalleProformaLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,detalleproformas,detalleproformaParameterGeneral,detalleproformaReturnGeneral);
			
			return detalleproformaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public DetalleProformaParameterReturnGeneral procesarAccionDetalleProformasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<DetalleProforma> detalleproformas,DetalleProformaParameterReturnGeneral detalleproformaParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleProforma.class.getSimpleName()+"-procesarAccionDetalleProformasWithConnection");connexion.begin();			
			
			DetalleProformaParameterReturnGeneral detalleproformaReturnGeneral=new DetalleProformaParameterReturnGeneral();
	
			DetalleProformaLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,detalleproformas,detalleproformaParameterGeneral,detalleproformaReturnGeneral);
			
			this.connexion.commit();
			
			return detalleproformaReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public DetalleProformaParameterReturnGeneral procesarEventosDetalleProformas(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<DetalleProforma> detalleproformas,DetalleProforma detalleproforma,DetalleProformaParameterReturnGeneral detalleproformaParameterGeneral,Boolean isEsNuevoDetalleProforma,ArrayList<Classe> clases)throws Exception {
		 try {	
			DetalleProformaParameterReturnGeneral detalleproformaReturnGeneral=new DetalleProformaParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				detalleproformaReturnGeneral.setConRecargarPropiedades(true);
			}
			
			DetalleProformaLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,detalleproformas,detalleproforma,detalleproformaParameterGeneral,detalleproformaReturnGeneral,isEsNuevoDetalleProforma,clases);
			
			return detalleproformaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public DetalleProformaParameterReturnGeneral procesarEventosDetalleProformasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<DetalleProforma> detalleproformas,DetalleProforma detalleproforma,DetalleProformaParameterReturnGeneral detalleproformaParameterGeneral,Boolean isEsNuevoDetalleProforma,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleProforma.class.getSimpleName()+"-procesarEventosDetalleProformasWithConnection");connexion.begin();			
			
			DetalleProformaParameterReturnGeneral detalleproformaReturnGeneral=new DetalleProformaParameterReturnGeneral();
	
			detalleproformaReturnGeneral.setDetalleProforma(detalleproforma);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				detalleproformaReturnGeneral.setConRecargarPropiedades(true);
			}
			
			DetalleProformaLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,detalleproformas,detalleproforma,detalleproformaParameterGeneral,detalleproformaReturnGeneral,isEsNuevoDetalleProforma,clases);
			
			this.connexion.commit();
			
			return detalleproformaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public DetalleProformaParameterReturnGeneral procesarImportacionDetalleProformasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,DetalleProformaParameterReturnGeneral detalleproformaParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleProforma.class.getSimpleName()+"-procesarImportacionDetalleProformasWithConnection");connexion.begin();			
			
			DetalleProformaParameterReturnGeneral detalleproformaReturnGeneral=new DetalleProformaParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.detalleproformas=new ArrayList<DetalleProforma>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.detalleproforma=new DetalleProforma();
				
				
				if(conColumnasBase) {this.detalleproforma.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.detalleproforma.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.detalleproforma.setdescripcion(arrColumnas[iColumn++]);
				this.detalleproforma.setcantidad_envases(Double.parseDouble(arrColumnas[iColumn++]));
				this.detalleproforma.setcantidad(Integer.parseInt(arrColumnas[iColumn++]));
				this.detalleproforma.setprecio(Double.parseDouble(arrColumnas[iColumn++]));
				this.detalleproforma.setiva(Double.parseDouble(arrColumnas[iColumn++]));
				this.detalleproforma.setdescuento_porcentaje(Double.parseDouble(arrColumnas[iColumn++]));
				this.detalleproforma.setdescuento_valor(Double.parseDouble(arrColumnas[iColumn++]));
				this.detalleproforma.setlote(arrColumnas[iColumn++]);
				this.detalleproforma.settotal(Double.parseDouble(arrColumnas[iColumn++]));
				
				this.detalleproformas.add(this.detalleproforma);
			}
			
			this.saveDetalleProformas();
			
			this.connexion.commit();
			
			detalleproformaReturnGeneral.setConRetornoEstaProcesado(true);
			detalleproformaReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return detalleproformaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarDetalleProformasEliminados() throws Exception {				
		
		List<DetalleProforma> detalleproformasAux= new ArrayList<DetalleProforma>();
		
		for(DetalleProforma detalleproforma:detalleproformas) {
			if(!detalleproforma.getIsDeleted()) {
				detalleproformasAux.add(detalleproforma);
			}
		}
		
		detalleproformas=detalleproformasAux;
	}
	
	public void quitarDetalleProformasNulos() throws Exception {				
		
		List<DetalleProforma> detalleproformasAux= new ArrayList<DetalleProforma>();
		
		for(DetalleProforma detalleproforma : this.detalleproformas) {
			if(detalleproforma==null) {
				detalleproformasAux.add(detalleproforma);
			}
		}
		
		//this.detalleproformas=detalleproformasAux;
		
		this.detalleproformas.removeAll(detalleproformasAux);
	}
	
	public void getSetVersionRowDetalleProformaWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(detalleproforma.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((detalleproforma.getIsDeleted() || (detalleproforma.getIsChanged()&&!detalleproforma.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=detalleproformaDataAccess.getSetVersionRowDetalleProforma(connexion,detalleproforma.getId());
				
				if(!detalleproforma.getVersionRow().equals(timestamp)) {	
					detalleproforma.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				detalleproforma.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowDetalleProforma()throws Exception {	
		
		if(detalleproforma.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((detalleproforma.getIsDeleted() || (detalleproforma.getIsChanged()&&!detalleproforma.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=detalleproformaDataAccess.getSetVersionRowDetalleProforma(connexion,detalleproforma.getId());
			
			try {							
				if(!detalleproforma.getVersionRow().equals(timestamp)) {	
					detalleproforma.setVersionRow(timestamp);
				}
				
				detalleproforma.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowDetalleProformasWithConnection()throws Exception {	
		if(detalleproformas!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(DetalleProforma detalleproformaAux:detalleproformas) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(detalleproformaAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(detalleproformaAux.getIsDeleted() || (detalleproformaAux.getIsChanged()&&!detalleproformaAux.getIsNew())) {
						
						timestamp=detalleproformaDataAccess.getSetVersionRowDetalleProforma(connexion,detalleproformaAux.getId());
						
						if(!detalleproforma.getVersionRow().equals(timestamp)) {	
							detalleproformaAux.setVersionRow(timestamp);
						}
								
						detalleproformaAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowDetalleProformas()throws Exception {	
		if(detalleproformas!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(DetalleProforma detalleproformaAux:detalleproformas) {
					if(detalleproformaAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(detalleproformaAux.getIsDeleted() || (detalleproformaAux.getIsChanged()&&!detalleproformaAux.getIsNew())) {
						
						timestamp=detalleproformaDataAccess.getSetVersionRowDetalleProforma(connexion,detalleproformaAux.getId());
						
						if(!detalleproformaAux.getVersionRow().equals(timestamp)) {	
							detalleproformaAux.setVersionRow(timestamp);
						}
						
													
						detalleproformaAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public DetalleProformaParameterReturnGeneral cargarCombosLoteForeignKeyDetalleProformaWithConnection(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalEjercicio,String finalQueryGlobalPeriodo,String finalQueryGlobalAnio,String finalQueryGlobalMes,String finalQueryGlobalProforma,String finalQueryGlobalBodega,String finalQueryGlobalProducto,String finalQueryGlobalUnidad,String finalQueryGlobalEmpaque,String finalQueryGlobalCentroCosto,String finalQueryGlobalEstadoDetalleProforma) throws Exception {
		DetalleProformaParameterReturnGeneral  detalleproformaReturnGeneral =new DetalleProformaParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleProforma.class.getSimpleName()+"-cargarCombosLoteForeignKeyDetalleProformaWithConnection");connexion.begin();
			
			detalleproformaReturnGeneral =new DetalleProformaParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			detalleproformaReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			detalleproformaReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Ejercicio> ejerciciosForeignKey=new ArrayList<Ejercicio>();
			EjercicioLogic ejercicioLogic=new EjercicioLogic();
			ejercicioLogic.setConnexion(this.connexion);
			//ejercicioLogic.getEjercicioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEjercicio.equals("NONE")) {
				ejercicioLogic.getTodosEjercicios(finalQueryGlobalEjercicio,new Pagination());
				ejerciciosForeignKey=ejercicioLogic.getEjercicios();
			}

			detalleproformaReturnGeneral.setejerciciosForeignKey(ejerciciosForeignKey);


			List<Periodo> periodosForeignKey=new ArrayList<Periodo>();
			PeriodoLogic periodoLogic=new PeriodoLogic();
			periodoLogic.setConnexion(this.connexion);
			//periodoLogic.getPeriodoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPeriodo.equals("NONE")) {
				periodoLogic.getTodosPeriodos(finalQueryGlobalPeriodo,new Pagination());
				periodosForeignKey=periodoLogic.getPeriodos();
			}

			detalleproformaReturnGeneral.setperiodosForeignKey(periodosForeignKey);


			List<Anio> aniosForeignKey=new ArrayList<Anio>();
			AnioLogic anioLogic=new AnioLogic();
			anioLogic.setConnexion(this.connexion);
			anioLogic.getAnioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalAnio.equals("NONE")) {
				anioLogic.getTodosAnios(finalQueryGlobalAnio,new Pagination());
				aniosForeignKey=anioLogic.getAnios();
			}

			detalleproformaReturnGeneral.setaniosForeignKey(aniosForeignKey);


			List<Mes> messForeignKey=new ArrayList<Mes>();
			MesLogic mesLogic=new MesLogic();
			mesLogic.setConnexion(this.connexion);
			mesLogic.getMesDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalMes.equals("NONE")) {
				mesLogic.getTodosMess(finalQueryGlobalMes,new Pagination());
				messForeignKey=mesLogic.getMess();
			}

			detalleproformaReturnGeneral.setmessForeignKey(messForeignKey);


			List<Proforma> proformasForeignKey=new ArrayList<Proforma>();
			ProformaLogic proformaLogic=new ProformaLogic();
			proformaLogic.setConnexion(this.connexion);
			proformaLogic.getProformaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalProforma.equals("NONE")) {
				proformaLogic.getTodosProformas(finalQueryGlobalProforma,new Pagination());
				proformasForeignKey=proformaLogic.getProformas();
			}

			detalleproformaReturnGeneral.setproformasForeignKey(proformasForeignKey);


			List<Bodega> bodegasForeignKey=new ArrayList<Bodega>();
			BodegaLogic bodegaLogic=new BodegaLogic();
			bodegaLogic.setConnexion(this.connexion);
			bodegaLogic.getBodegaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalBodega.equals("NONE")) {
				bodegaLogic.getTodosBodegas(finalQueryGlobalBodega,new Pagination());
				bodegasForeignKey=bodegaLogic.getBodegas();
			}

			detalleproformaReturnGeneral.setbodegasForeignKey(bodegasForeignKey);


			List<Producto> productosForeignKey=new ArrayList<Producto>();
			ProductoLogic productoLogic=new ProductoLogic();
			productoLogic.setConnexion(this.connexion);
			//productoLogic.getProductoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalProducto.equals("NONE")) {
				productoLogic.getTodosProductos(finalQueryGlobalProducto,new Pagination());
				productosForeignKey=productoLogic.getProductos();
			}

			detalleproformaReturnGeneral.setproductosForeignKey(productosForeignKey);


			List<Unidad> unidadsForeignKey=new ArrayList<Unidad>();
			UnidadLogic unidadLogic=new UnidadLogic();
			unidadLogic.setConnexion(this.connexion);
			unidadLogic.getUnidadDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalUnidad.equals("NONE")) {
				unidadLogic.getTodosUnidads(finalQueryGlobalUnidad,new Pagination());
				unidadsForeignKey=unidadLogic.getUnidads();
			}

			detalleproformaReturnGeneral.setunidadsForeignKey(unidadsForeignKey);


			List<Empaque> empaquesForeignKey=new ArrayList<Empaque>();
			EmpaqueLogic empaqueLogic=new EmpaqueLogic();
			empaqueLogic.setConnexion(this.connexion);
			empaqueLogic.getEmpaqueDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpaque.equals("NONE")) {
				empaqueLogic.getTodosEmpaques(finalQueryGlobalEmpaque,new Pagination());
				empaquesForeignKey=empaqueLogic.getEmpaques();
			}

			detalleproformaReturnGeneral.setempaquesForeignKey(empaquesForeignKey);


			List<CentroCosto> centrocostosForeignKey=new ArrayList<CentroCosto>();
			CentroCostoLogic centrocostoLogic=new CentroCostoLogic();
			centrocostoLogic.setConnexion(this.connexion);
			centrocostoLogic.getCentroCostoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCentroCosto.equals("NONE")) {
				centrocostoLogic.getTodosCentroCostos(finalQueryGlobalCentroCosto,new Pagination());
				centrocostosForeignKey=centrocostoLogic.getCentroCostos();
			}

			detalleproformaReturnGeneral.setcentrocostosForeignKey(centrocostosForeignKey);


			List<EstadoDetalleProforma> estadodetalleproformasForeignKey=new ArrayList<EstadoDetalleProforma>();
			EstadoDetalleProformaLogic estadodetalleproformaLogic=new EstadoDetalleProformaLogic();
			estadodetalleproformaLogic.setConnexion(this.connexion);
			estadodetalleproformaLogic.getEstadoDetalleProformaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEstadoDetalleProforma.equals("NONE")) {
				estadodetalleproformaLogic.getTodosEstadoDetalleProformas(finalQueryGlobalEstadoDetalleProforma,new Pagination());
				estadodetalleproformasForeignKey=estadodetalleproformaLogic.getEstadoDetalleProformas();
			}

			detalleproformaReturnGeneral.setestadodetalleproformasForeignKey(estadodetalleproformasForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return detalleproformaReturnGeneral;
	}
	
	public DetalleProformaParameterReturnGeneral cargarCombosLoteForeignKeyDetalleProforma(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalEjercicio,String finalQueryGlobalPeriodo,String finalQueryGlobalAnio,String finalQueryGlobalMes,String finalQueryGlobalProforma,String finalQueryGlobalBodega,String finalQueryGlobalProducto,String finalQueryGlobalUnidad,String finalQueryGlobalEmpaque,String finalQueryGlobalCentroCosto,String finalQueryGlobalEstadoDetalleProforma) throws Exception {
		DetalleProformaParameterReturnGeneral  detalleproformaReturnGeneral =new DetalleProformaParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			detalleproformaReturnGeneral =new DetalleProformaParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			detalleproformaReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			detalleproformaReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Ejercicio> ejerciciosForeignKey=new ArrayList<Ejercicio>();
			EjercicioLogic ejercicioLogic=new EjercicioLogic();
			ejercicioLogic.setConnexion(this.connexion);
			//ejercicioLogic.getEjercicioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEjercicio.equals("NONE")) {
				ejercicioLogic.getTodosEjercicios(finalQueryGlobalEjercicio,new Pagination());
				ejerciciosForeignKey=ejercicioLogic.getEjercicios();
			}

			detalleproformaReturnGeneral.setejerciciosForeignKey(ejerciciosForeignKey);


			List<Periodo> periodosForeignKey=new ArrayList<Periodo>();
			PeriodoLogic periodoLogic=new PeriodoLogic();
			periodoLogic.setConnexion(this.connexion);
			//periodoLogic.getPeriodoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPeriodo.equals("NONE")) {
				periodoLogic.getTodosPeriodos(finalQueryGlobalPeriodo,new Pagination());
				periodosForeignKey=periodoLogic.getPeriodos();
			}

			detalleproformaReturnGeneral.setperiodosForeignKey(periodosForeignKey);


			List<Anio> aniosForeignKey=new ArrayList<Anio>();
			AnioLogic anioLogic=new AnioLogic();
			anioLogic.setConnexion(this.connexion);
			anioLogic.getAnioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalAnio.equals("NONE")) {
				anioLogic.getTodosAnios(finalQueryGlobalAnio,new Pagination());
				aniosForeignKey=anioLogic.getAnios();
			}

			detalleproformaReturnGeneral.setaniosForeignKey(aniosForeignKey);


			List<Mes> messForeignKey=new ArrayList<Mes>();
			MesLogic mesLogic=new MesLogic();
			mesLogic.setConnexion(this.connexion);
			mesLogic.getMesDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalMes.equals("NONE")) {
				mesLogic.getTodosMess(finalQueryGlobalMes,new Pagination());
				messForeignKey=mesLogic.getMess();
			}

			detalleproformaReturnGeneral.setmessForeignKey(messForeignKey);


			List<Proforma> proformasForeignKey=new ArrayList<Proforma>();
			ProformaLogic proformaLogic=new ProformaLogic();
			proformaLogic.setConnexion(this.connexion);
			proformaLogic.getProformaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalProforma.equals("NONE")) {
				proformaLogic.getTodosProformas(finalQueryGlobalProforma,new Pagination());
				proformasForeignKey=proformaLogic.getProformas();
			}

			detalleproformaReturnGeneral.setproformasForeignKey(proformasForeignKey);


			List<Bodega> bodegasForeignKey=new ArrayList<Bodega>();
			BodegaLogic bodegaLogic=new BodegaLogic();
			bodegaLogic.setConnexion(this.connexion);
			bodegaLogic.getBodegaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalBodega.equals("NONE")) {
				bodegaLogic.getTodosBodegas(finalQueryGlobalBodega,new Pagination());
				bodegasForeignKey=bodegaLogic.getBodegas();
			}

			detalleproformaReturnGeneral.setbodegasForeignKey(bodegasForeignKey);


			List<Producto> productosForeignKey=new ArrayList<Producto>();
			ProductoLogic productoLogic=new ProductoLogic();
			productoLogic.setConnexion(this.connexion);
			//productoLogic.getProductoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalProducto.equals("NONE")) {
				productoLogic.getTodosProductos(finalQueryGlobalProducto,new Pagination());
				productosForeignKey=productoLogic.getProductos();
			}

			detalleproformaReturnGeneral.setproductosForeignKey(productosForeignKey);


			List<Unidad> unidadsForeignKey=new ArrayList<Unidad>();
			UnidadLogic unidadLogic=new UnidadLogic();
			unidadLogic.setConnexion(this.connexion);
			unidadLogic.getUnidadDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalUnidad.equals("NONE")) {
				unidadLogic.getTodosUnidads(finalQueryGlobalUnidad,new Pagination());
				unidadsForeignKey=unidadLogic.getUnidads();
			}

			detalleproformaReturnGeneral.setunidadsForeignKey(unidadsForeignKey);


			List<Empaque> empaquesForeignKey=new ArrayList<Empaque>();
			EmpaqueLogic empaqueLogic=new EmpaqueLogic();
			empaqueLogic.setConnexion(this.connexion);
			empaqueLogic.getEmpaqueDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpaque.equals("NONE")) {
				empaqueLogic.getTodosEmpaques(finalQueryGlobalEmpaque,new Pagination());
				empaquesForeignKey=empaqueLogic.getEmpaques();
			}

			detalleproformaReturnGeneral.setempaquesForeignKey(empaquesForeignKey);


			List<CentroCosto> centrocostosForeignKey=new ArrayList<CentroCosto>();
			CentroCostoLogic centrocostoLogic=new CentroCostoLogic();
			centrocostoLogic.setConnexion(this.connexion);
			centrocostoLogic.getCentroCostoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCentroCosto.equals("NONE")) {
				centrocostoLogic.getTodosCentroCostos(finalQueryGlobalCentroCosto,new Pagination());
				centrocostosForeignKey=centrocostoLogic.getCentroCostos();
			}

			detalleproformaReturnGeneral.setcentrocostosForeignKey(centrocostosForeignKey);


			List<EstadoDetalleProforma> estadodetalleproformasForeignKey=new ArrayList<EstadoDetalleProforma>();
			EstadoDetalleProformaLogic estadodetalleproformaLogic=new EstadoDetalleProformaLogic();
			estadodetalleproformaLogic.setConnexion(this.connexion);
			estadodetalleproformaLogic.getEstadoDetalleProformaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEstadoDetalleProforma.equals("NONE")) {
				estadodetalleproformaLogic.getTodosEstadoDetalleProformas(finalQueryGlobalEstadoDetalleProforma,new Pagination());
				estadodetalleproformasForeignKey=estadodetalleproformaLogic.getEstadoDetalleProformas();
			}

			detalleproformaReturnGeneral.setestadodetalleproformasForeignKey(estadodetalleproformasForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return detalleproformaReturnGeneral;
	}
	
	
	public void deepLoad(DetalleProforma detalleproforma,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			DetalleProformaLogicAdditional.updateDetalleProformaToGet(detalleproforma,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		detalleproforma.setEmpresa(detalleproformaDataAccess.getEmpresa(connexion,detalleproforma));
		detalleproforma.setSucursal(detalleproformaDataAccess.getSucursal(connexion,detalleproforma));
		detalleproforma.setEjercicio(detalleproformaDataAccess.getEjercicio(connexion,detalleproforma));
		detalleproforma.setPeriodo(detalleproformaDataAccess.getPeriodo(connexion,detalleproforma));
		detalleproforma.setAnio(detalleproformaDataAccess.getAnio(connexion,detalleproforma));
		detalleproforma.setMes(detalleproformaDataAccess.getMes(connexion,detalleproforma));
		detalleproforma.setProforma(detalleproformaDataAccess.getProforma(connexion,detalleproforma));
		detalleproforma.setBodega(detalleproformaDataAccess.getBodega(connexion,detalleproforma));
		detalleproforma.setProducto(detalleproformaDataAccess.getProducto(connexion,detalleproforma));
		detalleproforma.setUnidad(detalleproformaDataAccess.getUnidad(connexion,detalleproforma));
		detalleproforma.setEmpaque(detalleproformaDataAccess.getEmpaque(connexion,detalleproforma));
		detalleproforma.setCentroCosto(detalleproformaDataAccess.getCentroCosto(connexion,detalleproforma));
		detalleproforma.setEstadoDetalleProforma(detalleproformaDataAccess.getEstadoDetalleProforma(connexion,detalleproforma));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				detalleproforma.setEmpresa(detalleproformaDataAccess.getEmpresa(connexion,detalleproforma));
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				detalleproforma.setSucursal(detalleproformaDataAccess.getSucursal(connexion,detalleproforma));
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				detalleproforma.setEjercicio(detalleproformaDataAccess.getEjercicio(connexion,detalleproforma));
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				detalleproforma.setPeriodo(detalleproformaDataAccess.getPeriodo(connexion,detalleproforma));
				continue;
			}

			if(clas.clas.equals(Anio.class)) {
				detalleproforma.setAnio(detalleproformaDataAccess.getAnio(connexion,detalleproforma));
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				detalleproforma.setMes(detalleproformaDataAccess.getMes(connexion,detalleproforma));
				continue;
			}

			if(clas.clas.equals(Proforma.class)) {
				detalleproforma.setProforma(detalleproformaDataAccess.getProforma(connexion,detalleproforma));
				continue;
			}

			if(clas.clas.equals(Bodega.class)) {
				detalleproforma.setBodega(detalleproformaDataAccess.getBodega(connexion,detalleproforma));
				continue;
			}

			if(clas.clas.equals(Producto.class)) {
				detalleproforma.setProducto(detalleproformaDataAccess.getProducto(connexion,detalleproforma));
				continue;
			}

			if(clas.clas.equals(Unidad.class)) {
				detalleproforma.setUnidad(detalleproformaDataAccess.getUnidad(connexion,detalleproforma));
				continue;
			}

			if(clas.clas.equals(Empaque.class)) {
				detalleproforma.setEmpaque(detalleproformaDataAccess.getEmpaque(connexion,detalleproforma));
				continue;
			}

			if(clas.clas.equals(CentroCosto.class)) {
				detalleproforma.setCentroCosto(detalleproformaDataAccess.getCentroCosto(connexion,detalleproforma));
				continue;
			}

			if(clas.clas.equals(EstadoDetalleProforma.class)) {
				detalleproforma.setEstadoDetalleProforma(detalleproformaDataAccess.getEstadoDetalleProforma(connexion,detalleproforma));
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
			detalleproforma.setEmpresa(detalleproformaDataAccess.getEmpresa(connexion,detalleproforma));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalleproforma.setSucursal(detalleproformaDataAccess.getSucursal(connexion,detalleproforma));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Ejercicio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalleproforma.setEjercicio(detalleproformaDataAccess.getEjercicio(connexion,detalleproforma));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Periodo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalleproforma.setPeriodo(detalleproformaDataAccess.getPeriodo(connexion,detalleproforma));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Anio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalleproforma.setAnio(detalleproformaDataAccess.getAnio(connexion,detalleproforma));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Mes.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalleproforma.setMes(detalleproformaDataAccess.getMes(connexion,detalleproforma));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Proforma.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalleproforma.setProforma(detalleproformaDataAccess.getProforma(connexion,detalleproforma));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Bodega.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalleproforma.setBodega(detalleproformaDataAccess.getBodega(connexion,detalleproforma));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Producto.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalleproforma.setProducto(detalleproformaDataAccess.getProducto(connexion,detalleproforma));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Unidad.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalleproforma.setUnidad(detalleproformaDataAccess.getUnidad(connexion,detalleproforma));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Empaque.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalleproforma.setEmpaque(detalleproformaDataAccess.getEmpaque(connexion,detalleproforma));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CentroCosto.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalleproforma.setCentroCosto(detalleproformaDataAccess.getCentroCosto(connexion,detalleproforma));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(EstadoDetalleProforma.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalleproforma.setEstadoDetalleProforma(detalleproformaDataAccess.getEstadoDetalleProforma(connexion,detalleproforma));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		detalleproforma.setEmpresa(detalleproformaDataAccess.getEmpresa(connexion,detalleproforma));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(detalleproforma.getEmpresa(),isDeep,deepLoadType,clases);
				
		detalleproforma.setSucursal(detalleproformaDataAccess.getSucursal(connexion,detalleproforma));
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(detalleproforma.getSucursal(),isDeep,deepLoadType,clases);
				
		detalleproforma.setEjercicio(detalleproformaDataAccess.getEjercicio(connexion,detalleproforma));
		EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
		ejercicioLogic.deepLoad(detalleproforma.getEjercicio(),isDeep,deepLoadType,clases);
				
		detalleproforma.setPeriodo(detalleproformaDataAccess.getPeriodo(connexion,detalleproforma));
		PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
		periodoLogic.deepLoad(detalleproforma.getPeriodo(),isDeep,deepLoadType,clases);
				
		detalleproforma.setAnio(detalleproformaDataAccess.getAnio(connexion,detalleproforma));
		AnioLogic anioLogic= new AnioLogic(connexion);
		anioLogic.deepLoad(detalleproforma.getAnio(),isDeep,deepLoadType,clases);
				
		detalleproforma.setMes(detalleproformaDataAccess.getMes(connexion,detalleproforma));
		MesLogic mesLogic= new MesLogic(connexion);
		mesLogic.deepLoad(detalleproforma.getMes(),isDeep,deepLoadType,clases);
				
		detalleproforma.setProforma(detalleproformaDataAccess.getProforma(connexion,detalleproforma));
		ProformaLogic proformaLogic= new ProformaLogic(connexion);
		proformaLogic.deepLoad(detalleproforma.getProforma(),isDeep,deepLoadType,clases);
				
		detalleproforma.setBodega(detalleproformaDataAccess.getBodega(connexion,detalleproforma));
		BodegaLogic bodegaLogic= new BodegaLogic(connexion);
		bodegaLogic.deepLoad(detalleproforma.getBodega(),isDeep,deepLoadType,clases);
				
		detalleproforma.setProducto(detalleproformaDataAccess.getProducto(connexion,detalleproforma));
		ProductoLogic productoLogic= new ProductoLogic(connexion);
		productoLogic.deepLoad(detalleproforma.getProducto(),isDeep,deepLoadType,clases);
				
		detalleproforma.setUnidad(detalleproformaDataAccess.getUnidad(connexion,detalleproforma));
		UnidadLogic unidadLogic= new UnidadLogic(connexion);
		unidadLogic.deepLoad(detalleproforma.getUnidad(),isDeep,deepLoadType,clases);
				
		detalleproforma.setEmpaque(detalleproformaDataAccess.getEmpaque(connexion,detalleproforma));
		EmpaqueLogic empaqueLogic= new EmpaqueLogic(connexion);
		empaqueLogic.deepLoad(detalleproforma.getEmpaque(),isDeep,deepLoadType,clases);
				
		detalleproforma.setCentroCosto(detalleproformaDataAccess.getCentroCosto(connexion,detalleproforma));
		CentroCostoLogic centrocostoLogic= new CentroCostoLogic(connexion);
		centrocostoLogic.deepLoad(detalleproforma.getCentroCosto(),isDeep,deepLoadType,clases);
				
		detalleproforma.setEstadoDetalleProforma(detalleproformaDataAccess.getEstadoDetalleProforma(connexion,detalleproforma));
		EstadoDetalleProformaLogic estadodetalleproformaLogic= new EstadoDetalleProformaLogic(connexion);
		estadodetalleproformaLogic.deepLoad(detalleproforma.getEstadoDetalleProforma(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				detalleproforma.setEmpresa(detalleproformaDataAccess.getEmpresa(connexion,detalleproforma));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(detalleproforma.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				detalleproforma.setSucursal(detalleproformaDataAccess.getSucursal(connexion,detalleproforma));
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepLoad(detalleproforma.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				detalleproforma.setEjercicio(detalleproformaDataAccess.getEjercicio(connexion,detalleproforma));
				EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
				ejercicioLogic.deepLoad(detalleproforma.getEjercicio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				detalleproforma.setPeriodo(detalleproformaDataAccess.getPeriodo(connexion,detalleproforma));
				PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
				periodoLogic.deepLoad(detalleproforma.getPeriodo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Anio.class)) {
				detalleproforma.setAnio(detalleproformaDataAccess.getAnio(connexion,detalleproforma));
				AnioLogic anioLogic= new AnioLogic(connexion);
				anioLogic.deepLoad(detalleproforma.getAnio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				detalleproforma.setMes(detalleproformaDataAccess.getMes(connexion,detalleproforma));
				MesLogic mesLogic= new MesLogic(connexion);
				mesLogic.deepLoad(detalleproforma.getMes(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Proforma.class)) {
				detalleproforma.setProforma(detalleproformaDataAccess.getProforma(connexion,detalleproforma));
				ProformaLogic proformaLogic= new ProformaLogic(connexion);
				proformaLogic.deepLoad(detalleproforma.getProforma(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Bodega.class)) {
				detalleproforma.setBodega(detalleproformaDataAccess.getBodega(connexion,detalleproforma));
				BodegaLogic bodegaLogic= new BodegaLogic(connexion);
				bodegaLogic.deepLoad(detalleproforma.getBodega(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Producto.class)) {
				detalleproforma.setProducto(detalleproformaDataAccess.getProducto(connexion,detalleproforma));
				ProductoLogic productoLogic= new ProductoLogic(connexion);
				productoLogic.deepLoad(detalleproforma.getProducto(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Unidad.class)) {
				detalleproforma.setUnidad(detalleproformaDataAccess.getUnidad(connexion,detalleproforma));
				UnidadLogic unidadLogic= new UnidadLogic(connexion);
				unidadLogic.deepLoad(detalleproforma.getUnidad(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Empaque.class)) {
				detalleproforma.setEmpaque(detalleproformaDataAccess.getEmpaque(connexion,detalleproforma));
				EmpaqueLogic empaqueLogic= new EmpaqueLogic(connexion);
				empaqueLogic.deepLoad(detalleproforma.getEmpaque(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CentroCosto.class)) {
				detalleproforma.setCentroCosto(detalleproformaDataAccess.getCentroCosto(connexion,detalleproforma));
				CentroCostoLogic centrocostoLogic= new CentroCostoLogic(connexion);
				centrocostoLogic.deepLoad(detalleproforma.getCentroCosto(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(EstadoDetalleProforma.class)) {
				detalleproforma.setEstadoDetalleProforma(detalleproformaDataAccess.getEstadoDetalleProforma(connexion,detalleproforma));
				EstadoDetalleProformaLogic estadodetalleproformaLogic= new EstadoDetalleProformaLogic(connexion);
				estadodetalleproformaLogic.deepLoad(detalleproforma.getEstadoDetalleProforma(),isDeep,deepLoadType,clases);				
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
			detalleproforma.setEmpresa(detalleproformaDataAccess.getEmpresa(connexion,detalleproforma));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(detalleproforma.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalleproforma.setSucursal(detalleproformaDataAccess.getSucursal(connexion,detalleproforma));
			SucursalLogic sucursalLogic= new SucursalLogic(connexion);
			sucursalLogic.deepLoad(detalleproforma.getSucursal(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Ejercicio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalleproforma.setEjercicio(detalleproformaDataAccess.getEjercicio(connexion,detalleproforma));
			EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
			ejercicioLogic.deepLoad(detalleproforma.getEjercicio(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Periodo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalleproforma.setPeriodo(detalleproformaDataAccess.getPeriodo(connexion,detalleproforma));
			PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
			periodoLogic.deepLoad(detalleproforma.getPeriodo(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Anio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalleproforma.setAnio(detalleproformaDataAccess.getAnio(connexion,detalleproforma));
			AnioLogic anioLogic= new AnioLogic(connexion);
			anioLogic.deepLoad(detalleproforma.getAnio(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Mes.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalleproforma.setMes(detalleproformaDataAccess.getMes(connexion,detalleproforma));
			MesLogic mesLogic= new MesLogic(connexion);
			mesLogic.deepLoad(detalleproforma.getMes(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Proforma.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalleproforma.setProforma(detalleproformaDataAccess.getProforma(connexion,detalleproforma));
			ProformaLogic proformaLogic= new ProformaLogic(connexion);
			proformaLogic.deepLoad(detalleproforma.getProforma(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Bodega.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalleproforma.setBodega(detalleproformaDataAccess.getBodega(connexion,detalleproforma));
			BodegaLogic bodegaLogic= new BodegaLogic(connexion);
			bodegaLogic.deepLoad(detalleproforma.getBodega(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Producto.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalleproforma.setProducto(detalleproformaDataAccess.getProducto(connexion,detalleproforma));
			ProductoLogic productoLogic= new ProductoLogic(connexion);
			productoLogic.deepLoad(detalleproforma.getProducto(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Unidad.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalleproforma.setUnidad(detalleproformaDataAccess.getUnidad(connexion,detalleproforma));
			UnidadLogic unidadLogic= new UnidadLogic(connexion);
			unidadLogic.deepLoad(detalleproforma.getUnidad(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Empaque.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalleproforma.setEmpaque(detalleproformaDataAccess.getEmpaque(connexion,detalleproforma));
			EmpaqueLogic empaqueLogic= new EmpaqueLogic(connexion);
			empaqueLogic.deepLoad(detalleproforma.getEmpaque(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(CentroCosto.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalleproforma.setCentroCosto(detalleproformaDataAccess.getCentroCosto(connexion,detalleproforma));
			CentroCostoLogic centrocostoLogic= new CentroCostoLogic(connexion);
			centrocostoLogic.deepLoad(detalleproforma.getCentroCosto(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(EstadoDetalleProforma.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalleproforma.setEstadoDetalleProforma(detalleproformaDataAccess.getEstadoDetalleProforma(connexion,detalleproforma));
			EstadoDetalleProformaLogic estadodetalleproformaLogic= new EstadoDetalleProformaLogic(connexion);
			estadodetalleproformaLogic.deepLoad(detalleproforma.getEstadoDetalleProforma(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(DetalleProforma detalleproforma,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			DetalleProformaLogicAdditional.updateDetalleProformaToSave(detalleproforma,this.arrDatoGeneral);
			
DetalleProformaDataAccess.save(detalleproforma, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(detalleproforma.getEmpresa(),connexion);

		SucursalDataAccess.save(detalleproforma.getSucursal(),connexion);

		EjercicioDataAccess.save(detalleproforma.getEjercicio(),connexion);

		PeriodoDataAccess.save(detalleproforma.getPeriodo(),connexion);

		AnioDataAccess.save(detalleproforma.getAnio(),connexion);

		MesDataAccess.save(detalleproforma.getMes(),connexion);

		ProformaDataAccess.save(detalleproforma.getProforma(),connexion);

		BodegaDataAccess.save(detalleproforma.getBodega(),connexion);

		ProductoDataAccess.save(detalleproforma.getProducto(),connexion);

		UnidadDataAccess.save(detalleproforma.getUnidad(),connexion);

		EmpaqueDataAccess.save(detalleproforma.getEmpaque(),connexion);

		CentroCostoDataAccess.save(detalleproforma.getCentroCosto(),connexion);

		EstadoDetalleProformaDataAccess.save(detalleproforma.getEstadoDetalleProforma(),connexion);
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(detalleproforma.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(detalleproforma.getSucursal(),connexion);
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				EjercicioDataAccess.save(detalleproforma.getEjercicio(),connexion);
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				PeriodoDataAccess.save(detalleproforma.getPeriodo(),connexion);
				continue;
			}

			if(clas.clas.equals(Anio.class)) {
				AnioDataAccess.save(detalleproforma.getAnio(),connexion);
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				MesDataAccess.save(detalleproforma.getMes(),connexion);
				continue;
			}

			if(clas.clas.equals(Proforma.class)) {
				ProformaDataAccess.save(detalleproforma.getProforma(),connexion);
				continue;
			}

			if(clas.clas.equals(Bodega.class)) {
				BodegaDataAccess.save(detalleproforma.getBodega(),connexion);
				continue;
			}

			if(clas.clas.equals(Producto.class)) {
				ProductoDataAccess.save(detalleproforma.getProducto(),connexion);
				continue;
			}

			if(clas.clas.equals(Unidad.class)) {
				UnidadDataAccess.save(detalleproforma.getUnidad(),connexion);
				continue;
			}

			if(clas.clas.equals(Empaque.class)) {
				EmpaqueDataAccess.save(detalleproforma.getEmpaque(),connexion);
				continue;
			}

			if(clas.clas.equals(CentroCosto.class)) {
				CentroCostoDataAccess.save(detalleproforma.getCentroCosto(),connexion);
				continue;
			}

			if(clas.clas.equals(EstadoDetalleProforma.class)) {
				EstadoDetalleProformaDataAccess.save(detalleproforma.getEstadoDetalleProforma(),connexion);
				continue;
			}

		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(detalleproforma.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(detalleproforma.getEmpresa(),isDeep,deepLoadType,clases);
				

		SucursalDataAccess.save(detalleproforma.getSucursal(),connexion);
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(detalleproforma.getSucursal(),isDeep,deepLoadType,clases);
				

		EjercicioDataAccess.save(detalleproforma.getEjercicio(),connexion);
		EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
		ejercicioLogic.deepLoad(detalleproforma.getEjercicio(),isDeep,deepLoadType,clases);
				

		PeriodoDataAccess.save(detalleproforma.getPeriodo(),connexion);
		PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
		periodoLogic.deepLoad(detalleproforma.getPeriodo(),isDeep,deepLoadType,clases);
				

		AnioDataAccess.save(detalleproforma.getAnio(),connexion);
		AnioLogic anioLogic= new AnioLogic(connexion);
		anioLogic.deepLoad(detalleproforma.getAnio(),isDeep,deepLoadType,clases);
				

		MesDataAccess.save(detalleproforma.getMes(),connexion);
		MesLogic mesLogic= new MesLogic(connexion);
		mesLogic.deepLoad(detalleproforma.getMes(),isDeep,deepLoadType,clases);
				

		ProformaDataAccess.save(detalleproforma.getProforma(),connexion);
		ProformaLogic proformaLogic= new ProformaLogic(connexion);
		proformaLogic.deepLoad(detalleproforma.getProforma(),isDeep,deepLoadType,clases);
				

		BodegaDataAccess.save(detalleproforma.getBodega(),connexion);
		BodegaLogic bodegaLogic= new BodegaLogic(connexion);
		bodegaLogic.deepLoad(detalleproforma.getBodega(),isDeep,deepLoadType,clases);
				

		ProductoDataAccess.save(detalleproforma.getProducto(),connexion);
		ProductoLogic productoLogic= new ProductoLogic(connexion);
		productoLogic.deepLoad(detalleproforma.getProducto(),isDeep,deepLoadType,clases);
				

		UnidadDataAccess.save(detalleproforma.getUnidad(),connexion);
		UnidadLogic unidadLogic= new UnidadLogic(connexion);
		unidadLogic.deepLoad(detalleproforma.getUnidad(),isDeep,deepLoadType,clases);
				

		EmpaqueDataAccess.save(detalleproforma.getEmpaque(),connexion);
		EmpaqueLogic empaqueLogic= new EmpaqueLogic(connexion);
		empaqueLogic.deepLoad(detalleproforma.getEmpaque(),isDeep,deepLoadType,clases);
				

		CentroCostoDataAccess.save(detalleproforma.getCentroCosto(),connexion);
		CentroCostoLogic centrocostoLogic= new CentroCostoLogic(connexion);
		centrocostoLogic.deepLoad(detalleproforma.getCentroCosto(),isDeep,deepLoadType,clases);
				

		EstadoDetalleProformaDataAccess.save(detalleproforma.getEstadoDetalleProforma(),connexion);
		EstadoDetalleProformaLogic estadodetalleproformaLogic= new EstadoDetalleProformaLogic(connexion);
		estadodetalleproformaLogic.deepLoad(detalleproforma.getEstadoDetalleProforma(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(detalleproforma.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(detalleproforma.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(detalleproforma.getSucursal(),connexion);
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepSave(detalleproforma.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				EjercicioDataAccess.save(detalleproforma.getEjercicio(),connexion);
				EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
				ejercicioLogic.deepSave(detalleproforma.getEjercicio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				PeriodoDataAccess.save(detalleproforma.getPeriodo(),connexion);
				PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
				periodoLogic.deepSave(detalleproforma.getPeriodo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Anio.class)) {
				AnioDataAccess.save(detalleproforma.getAnio(),connexion);
				AnioLogic anioLogic= new AnioLogic(connexion);
				anioLogic.deepSave(detalleproforma.getAnio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				MesDataAccess.save(detalleproforma.getMes(),connexion);
				MesLogic mesLogic= new MesLogic(connexion);
				mesLogic.deepSave(detalleproforma.getMes(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Proforma.class)) {
				ProformaDataAccess.save(detalleproforma.getProforma(),connexion);
				ProformaLogic proformaLogic= new ProformaLogic(connexion);
				proformaLogic.deepSave(detalleproforma.getProforma(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Bodega.class)) {
				BodegaDataAccess.save(detalleproforma.getBodega(),connexion);
				BodegaLogic bodegaLogic= new BodegaLogic(connexion);
				bodegaLogic.deepSave(detalleproforma.getBodega(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Producto.class)) {
				ProductoDataAccess.save(detalleproforma.getProducto(),connexion);
				ProductoLogic productoLogic= new ProductoLogic(connexion);
				productoLogic.deepSave(detalleproforma.getProducto(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Unidad.class)) {
				UnidadDataAccess.save(detalleproforma.getUnidad(),connexion);
				UnidadLogic unidadLogic= new UnidadLogic(connexion);
				unidadLogic.deepSave(detalleproforma.getUnidad(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Empaque.class)) {
				EmpaqueDataAccess.save(detalleproforma.getEmpaque(),connexion);
				EmpaqueLogic empaqueLogic= new EmpaqueLogic(connexion);
				empaqueLogic.deepSave(detalleproforma.getEmpaque(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CentroCosto.class)) {
				CentroCostoDataAccess.save(detalleproforma.getCentroCosto(),connexion);
				CentroCostoLogic centrocostoLogic= new CentroCostoLogic(connexion);
				centrocostoLogic.deepSave(detalleproforma.getCentroCosto(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(EstadoDetalleProforma.class)) {
				EstadoDetalleProformaDataAccess.save(detalleproforma.getEstadoDetalleProforma(),connexion);
				EstadoDetalleProformaLogic estadodetalleproformaLogic= new EstadoDetalleProformaLogic(connexion);
				estadodetalleproformaLogic.deepSave(detalleproforma.getEstadoDetalleProforma(),isDeep,deepLoadType,clases);				
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
			this.getNewConnexionToDeep(DetalleProforma.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(detalleproforma,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				DetalleProformaConstantesFunciones.refrescarForeignKeysDescripcionesDetalleProforma(detalleproforma);
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
			this.deepLoad(this.detalleproforma,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				DetalleProformaConstantesFunciones.refrescarForeignKeysDescripcionesDetalleProforma(this.detalleproforma);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(DetalleProforma.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(detalleproformas!=null) {
				for(DetalleProforma detalleproforma:detalleproformas) {
					this.deepLoad(detalleproforma,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					DetalleProformaConstantesFunciones.refrescarForeignKeysDescripcionesDetalleProforma(detalleproformas);
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
			if(detalleproformas!=null) {
				for(DetalleProforma detalleproforma:detalleproformas) {
					this.deepLoad(detalleproforma,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					DetalleProformaConstantesFunciones.refrescarForeignKeysDescripcionesDetalleProforma(detalleproformas);
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
			this.getNewConnexionToDeep(DetalleProforma.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(detalleproforma,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(DetalleProforma.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(detalleproformas!=null) {
				for(DetalleProforma detalleproforma:detalleproformas) {
					this.deepSave(detalleproforma,isDeep,deepLoadType,clases);
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
			if(detalleproformas!=null) {
				for(DetalleProforma detalleproforma:detalleproformas) {
					this.deepSave(detalleproforma,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getDetalleProformasFK_IdAnioWithConnection(String sFinalQuery,Pagination pagination,Long id_anio)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleProforma.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidAnio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidAnio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_anio,DetalleProformaConstantesFunciones.IDANIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidAnio);

			DetalleProformaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdAnio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleproformas=detalleproformaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleProformaConstantesFunciones.refrescarForeignKeysDescripcionesDetalleProforma(this.detalleproformas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleProformasFK_IdAnio(String sFinalQuery,Pagination pagination,Long id_anio)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidAnio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidAnio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_anio,DetalleProformaConstantesFunciones.IDANIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidAnio);

			DetalleProformaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdAnio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleproformas=detalleproformaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleProformaConstantesFunciones.refrescarForeignKeysDescripcionesDetalleProforma(this.detalleproformas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetalleProformasFK_IdBodegaWithConnection(String sFinalQuery,Pagination pagination,Long id_bodega)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleProforma.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidBodega= new ParameterSelectionGeneral();
			parameterSelectionGeneralidBodega.setParameterSelectionGeneralEqual(ParameterType.LONG,id_bodega,DetalleProformaConstantesFunciones.IDBODEGA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidBodega);

			DetalleProformaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdBodega","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleproformas=detalleproformaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleProformaConstantesFunciones.refrescarForeignKeysDescripcionesDetalleProforma(this.detalleproformas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleProformasFK_IdBodega(String sFinalQuery,Pagination pagination,Long id_bodega)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidBodega= new ParameterSelectionGeneral();
			parameterSelectionGeneralidBodega.setParameterSelectionGeneralEqual(ParameterType.LONG,id_bodega,DetalleProformaConstantesFunciones.IDBODEGA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidBodega);

			DetalleProformaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdBodega","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleproformas=detalleproformaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleProformaConstantesFunciones.refrescarForeignKeysDescripcionesDetalleProforma(this.detalleproformas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetalleProformasFK_IdCentroCostoWithConnection(String sFinalQuery,Pagination pagination,Long id_centro_costo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleProforma.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCentroCosto= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCentroCosto.setParameterSelectionGeneralEqual(ParameterType.LONG,id_centro_costo,DetalleProformaConstantesFunciones.IDCENTROCOSTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCentroCosto);

			DetalleProformaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCentroCosto","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleproformas=detalleproformaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleProformaConstantesFunciones.refrescarForeignKeysDescripcionesDetalleProforma(this.detalleproformas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleProformasFK_IdCentroCosto(String sFinalQuery,Pagination pagination,Long id_centro_costo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCentroCosto= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCentroCosto.setParameterSelectionGeneralEqual(ParameterType.LONG,id_centro_costo,DetalleProformaConstantesFunciones.IDCENTROCOSTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCentroCosto);

			DetalleProformaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCentroCosto","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleproformas=detalleproformaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleProformaConstantesFunciones.refrescarForeignKeysDescripcionesDetalleProforma(this.detalleproformas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetalleProformasFK_IdEjercicioWithConnection(String sFinalQuery,Pagination pagination,Long id_ejercicio)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleProforma.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEjercicio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEjercicio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_ejercicio,DetalleProformaConstantesFunciones.IDEJERCICIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEjercicio);

			DetalleProformaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEjercicio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleproformas=detalleproformaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleProformaConstantesFunciones.refrescarForeignKeysDescripcionesDetalleProforma(this.detalleproformas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleProformasFK_IdEjercicio(String sFinalQuery,Pagination pagination,Long id_ejercicio)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEjercicio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEjercicio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_ejercicio,DetalleProformaConstantesFunciones.IDEJERCICIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEjercicio);

			DetalleProformaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEjercicio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleproformas=detalleproformaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleProformaConstantesFunciones.refrescarForeignKeysDescripcionesDetalleProforma(this.detalleproformas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetalleProformasFK_IdEmpaqueWithConnection(String sFinalQuery,Pagination pagination,Long id_empaque)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleProforma.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpaque= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpaque.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empaque,DetalleProformaConstantesFunciones.IDEMPAQUE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpaque);

			DetalleProformaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpaque","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleproformas=detalleproformaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleProformaConstantesFunciones.refrescarForeignKeysDescripcionesDetalleProforma(this.detalleproformas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleProformasFK_IdEmpaque(String sFinalQuery,Pagination pagination,Long id_empaque)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpaque= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpaque.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empaque,DetalleProformaConstantesFunciones.IDEMPAQUE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpaque);

			DetalleProformaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpaque","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleproformas=detalleproformaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleProformaConstantesFunciones.refrescarForeignKeysDescripcionesDetalleProforma(this.detalleproformas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetalleProformasFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleProforma.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,DetalleProformaConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			DetalleProformaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleproformas=detalleproformaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleProformaConstantesFunciones.refrescarForeignKeysDescripcionesDetalleProforma(this.detalleproformas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleProformasFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,DetalleProformaConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			DetalleProformaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleproformas=detalleproformaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleProformaConstantesFunciones.refrescarForeignKeysDescripcionesDetalleProforma(this.detalleproformas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetalleProformasFK_IdEstadoDetalleProformaWithConnection(String sFinalQuery,Pagination pagination,Long id_estado_detalle_proforma)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleProforma.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEstadoDetalleProforma= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEstadoDetalleProforma.setParameterSelectionGeneralEqual(ParameterType.LONG,id_estado_detalle_proforma,DetalleProformaConstantesFunciones.IDESTADODETALLEPROFORMA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEstadoDetalleProforma);

			DetalleProformaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEstadoDetalleProforma","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleproformas=detalleproformaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleProformaConstantesFunciones.refrescarForeignKeysDescripcionesDetalleProforma(this.detalleproformas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleProformasFK_IdEstadoDetalleProforma(String sFinalQuery,Pagination pagination,Long id_estado_detalle_proforma)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEstadoDetalleProforma= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEstadoDetalleProforma.setParameterSelectionGeneralEqual(ParameterType.LONG,id_estado_detalle_proforma,DetalleProformaConstantesFunciones.IDESTADODETALLEPROFORMA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEstadoDetalleProforma);

			DetalleProformaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEstadoDetalleProforma","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleproformas=detalleproformaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleProformaConstantesFunciones.refrescarForeignKeysDescripcionesDetalleProforma(this.detalleproformas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetalleProformasFK_IdMesWithConnection(String sFinalQuery,Pagination pagination,Long id_mes)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleProforma.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidMes= new ParameterSelectionGeneral();
			parameterSelectionGeneralidMes.setParameterSelectionGeneralEqual(ParameterType.LONG,id_mes,DetalleProformaConstantesFunciones.IDMES,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidMes);

			DetalleProformaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdMes","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleproformas=detalleproformaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleProformaConstantesFunciones.refrescarForeignKeysDescripcionesDetalleProforma(this.detalleproformas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleProformasFK_IdMes(String sFinalQuery,Pagination pagination,Long id_mes)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidMes= new ParameterSelectionGeneral();
			parameterSelectionGeneralidMes.setParameterSelectionGeneralEqual(ParameterType.LONG,id_mes,DetalleProformaConstantesFunciones.IDMES,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidMes);

			DetalleProformaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdMes","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleproformas=detalleproformaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleProformaConstantesFunciones.refrescarForeignKeysDescripcionesDetalleProforma(this.detalleproformas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetalleProformasFK_IdPeriodoWithConnection(String sFinalQuery,Pagination pagination,Long id_periodo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleProforma.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPeriodo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPeriodo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_periodo,DetalleProformaConstantesFunciones.IDPERIODO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPeriodo);

			DetalleProformaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPeriodo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleproformas=detalleproformaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleProformaConstantesFunciones.refrescarForeignKeysDescripcionesDetalleProforma(this.detalleproformas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleProformasFK_IdPeriodo(String sFinalQuery,Pagination pagination,Long id_periodo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPeriodo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPeriodo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_periodo,DetalleProformaConstantesFunciones.IDPERIODO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPeriodo);

			DetalleProformaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPeriodo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleproformas=detalleproformaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleProformaConstantesFunciones.refrescarForeignKeysDescripcionesDetalleProforma(this.detalleproformas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetalleProformasFK_IdProductoWithConnection(String sFinalQuery,Pagination pagination,Long id_producto)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleProforma.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidProducto= new ParameterSelectionGeneral();
			parameterSelectionGeneralidProducto.setParameterSelectionGeneralEqual(ParameterType.LONG,id_producto,DetalleProformaConstantesFunciones.IDPRODUCTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidProducto);

			DetalleProformaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdProducto","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleproformas=detalleproformaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleProformaConstantesFunciones.refrescarForeignKeysDescripcionesDetalleProforma(this.detalleproformas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleProformasFK_IdProducto(String sFinalQuery,Pagination pagination,Long id_producto)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidProducto= new ParameterSelectionGeneral();
			parameterSelectionGeneralidProducto.setParameterSelectionGeneralEqual(ParameterType.LONG,id_producto,DetalleProformaConstantesFunciones.IDPRODUCTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidProducto);

			DetalleProformaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdProducto","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleproformas=detalleproformaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleProformaConstantesFunciones.refrescarForeignKeysDescripcionesDetalleProforma(this.detalleproformas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetalleProformasFK_IdProformaWithConnection(String sFinalQuery,Pagination pagination,Long id_proforma)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleProforma.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidProforma= new ParameterSelectionGeneral();
			parameterSelectionGeneralidProforma.setParameterSelectionGeneralEqual(ParameterType.LONG,id_proforma,DetalleProformaConstantesFunciones.IDPROFORMA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidProforma);

			DetalleProformaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdProforma","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleproformas=detalleproformaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleProformaConstantesFunciones.refrescarForeignKeysDescripcionesDetalleProforma(this.detalleproformas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleProformasFK_IdProforma(String sFinalQuery,Pagination pagination,Long id_proforma)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidProforma= new ParameterSelectionGeneral();
			parameterSelectionGeneralidProforma.setParameterSelectionGeneralEqual(ParameterType.LONG,id_proforma,DetalleProformaConstantesFunciones.IDPROFORMA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidProforma);

			DetalleProformaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdProforma","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleproformas=detalleproformaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleProformaConstantesFunciones.refrescarForeignKeysDescripcionesDetalleProforma(this.detalleproformas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetalleProformasFK_IdSucursalWithConnection(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleProforma.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,DetalleProformaConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			DetalleProformaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleproformas=detalleproformaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleProformaConstantesFunciones.refrescarForeignKeysDescripcionesDetalleProforma(this.detalleproformas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleProformasFK_IdSucursal(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,DetalleProformaConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			DetalleProformaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleproformas=detalleproformaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleProformaConstantesFunciones.refrescarForeignKeysDescripcionesDetalleProforma(this.detalleproformas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetalleProformasFK_IdUnidadWithConnection(String sFinalQuery,Pagination pagination,Long id_unidad)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleProforma.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidUnidad= new ParameterSelectionGeneral();
			parameterSelectionGeneralidUnidad.setParameterSelectionGeneralEqual(ParameterType.LONG,id_unidad,DetalleProformaConstantesFunciones.IDUNIDAD,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidUnidad);

			DetalleProformaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdUnidad","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleproformas=detalleproformaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleProformaConstantesFunciones.refrescarForeignKeysDescripcionesDetalleProforma(this.detalleproformas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleProformasFK_IdUnidad(String sFinalQuery,Pagination pagination,Long id_unidad)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidUnidad= new ParameterSelectionGeneral();
			parameterSelectionGeneralidUnidad.setParameterSelectionGeneralEqual(ParameterType.LONG,id_unidad,DetalleProformaConstantesFunciones.IDUNIDAD,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidUnidad);

			DetalleProformaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdUnidad","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleproformas=detalleproformaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleProformaConstantesFunciones.refrescarForeignKeysDescripcionesDetalleProforma(this.detalleproformas);
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
			if(DetalleProformaConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,DetalleProformaDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,DetalleProforma detalleproforma,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(DetalleProformaConstantesFunciones.ISCONAUDITORIA) {
				if(detalleproforma.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,DetalleProformaDataAccess.TABLENAME, detalleproforma.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(DetalleProformaConstantesFunciones.ISCONAUDITORIADETALLE) {
						////DetalleProformaLogic.registrarAuditoriaDetallesDetalleProforma(connexion,detalleproforma,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(detalleproforma.getIsDeleted()) {
					/*if(!detalleproforma.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,DetalleProformaDataAccess.TABLENAME, detalleproforma.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////DetalleProformaLogic.registrarAuditoriaDetallesDetalleProforma(connexion,detalleproforma,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,DetalleProformaDataAccess.TABLENAME, detalleproforma.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(detalleproforma.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,DetalleProformaDataAccess.TABLENAME, detalleproforma.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(DetalleProformaConstantesFunciones.ISCONAUDITORIADETALLE) {
						////DetalleProformaLogic.registrarAuditoriaDetallesDetalleProforma(connexion,detalleproforma,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesDetalleProforma(Connexion connexion,DetalleProforma detalleproforma)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(detalleproforma.getIsNew()||!detalleproforma.getid_empresa().equals(detalleproforma.getDetalleProformaOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleproforma.getDetalleProformaOriginal().getid_empresa()!=null)
				{
					strValorActual=detalleproforma.getDetalleProformaOriginal().getid_empresa().toString();
				}
				if(detalleproforma.getid_empresa()!=null)
				{
					strValorNuevo=detalleproforma.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleProformaConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(detalleproforma.getIsNew()||!detalleproforma.getid_sucursal().equals(detalleproforma.getDetalleProformaOriginal().getid_sucursal()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleproforma.getDetalleProformaOriginal().getid_sucursal()!=null)
				{
					strValorActual=detalleproforma.getDetalleProformaOriginal().getid_sucursal().toString();
				}
				if(detalleproforma.getid_sucursal()!=null)
				{
					strValorNuevo=detalleproforma.getid_sucursal().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleProformaConstantesFunciones.IDSUCURSAL,strValorActual,strValorNuevo);
			}	
			
			if(detalleproforma.getIsNew()||!detalleproforma.getid_ejercicio().equals(detalleproforma.getDetalleProformaOriginal().getid_ejercicio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleproforma.getDetalleProformaOriginal().getid_ejercicio()!=null)
				{
					strValorActual=detalleproforma.getDetalleProformaOriginal().getid_ejercicio().toString();
				}
				if(detalleproforma.getid_ejercicio()!=null)
				{
					strValorNuevo=detalleproforma.getid_ejercicio().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleProformaConstantesFunciones.IDEJERCICIO,strValorActual,strValorNuevo);
			}	
			
			if(detalleproforma.getIsNew()||!detalleproforma.getid_periodo().equals(detalleproforma.getDetalleProformaOriginal().getid_periodo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleproforma.getDetalleProformaOriginal().getid_periodo()!=null)
				{
					strValorActual=detalleproforma.getDetalleProformaOriginal().getid_periodo().toString();
				}
				if(detalleproforma.getid_periodo()!=null)
				{
					strValorNuevo=detalleproforma.getid_periodo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleProformaConstantesFunciones.IDPERIODO,strValorActual,strValorNuevo);
			}	
			
			if(detalleproforma.getIsNew()||!detalleproforma.getid_anio().equals(detalleproforma.getDetalleProformaOriginal().getid_anio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleproforma.getDetalleProformaOriginal().getid_anio()!=null)
				{
					strValorActual=detalleproforma.getDetalleProformaOriginal().getid_anio().toString();
				}
				if(detalleproforma.getid_anio()!=null)
				{
					strValorNuevo=detalleproforma.getid_anio().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleProformaConstantesFunciones.IDANIO,strValorActual,strValorNuevo);
			}	
			
			if(detalleproforma.getIsNew()||!detalleproforma.getid_mes().equals(detalleproforma.getDetalleProformaOriginal().getid_mes()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleproforma.getDetalleProformaOriginal().getid_mes()!=null)
				{
					strValorActual=detalleproforma.getDetalleProformaOriginal().getid_mes().toString();
				}
				if(detalleproforma.getid_mes()!=null)
				{
					strValorNuevo=detalleproforma.getid_mes().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleProformaConstantesFunciones.IDMES,strValorActual,strValorNuevo);
			}	
			
			if(detalleproforma.getIsNew()||!detalleproforma.getid_proforma().equals(detalleproforma.getDetalleProformaOriginal().getid_proforma()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleproforma.getDetalleProformaOriginal().getid_proforma()!=null)
				{
					strValorActual=detalleproforma.getDetalleProformaOriginal().getid_proforma().toString();
				}
				if(detalleproforma.getid_proforma()!=null)
				{
					strValorNuevo=detalleproforma.getid_proforma().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleProformaConstantesFunciones.IDPROFORMA,strValorActual,strValorNuevo);
			}	
			
			if(detalleproforma.getIsNew()||!detalleproforma.getid_bodega().equals(detalleproforma.getDetalleProformaOriginal().getid_bodega()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleproforma.getDetalleProformaOriginal().getid_bodega()!=null)
				{
					strValorActual=detalleproforma.getDetalleProformaOriginal().getid_bodega().toString();
				}
				if(detalleproforma.getid_bodega()!=null)
				{
					strValorNuevo=detalleproforma.getid_bodega().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleProformaConstantesFunciones.IDBODEGA,strValorActual,strValorNuevo);
			}	
			
			if(detalleproforma.getIsNew()||!detalleproforma.getid_producto().equals(detalleproforma.getDetalleProformaOriginal().getid_producto()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleproforma.getDetalleProformaOriginal().getid_producto()!=null)
				{
					strValorActual=detalleproforma.getDetalleProformaOriginal().getid_producto().toString();
				}
				if(detalleproforma.getid_producto()!=null)
				{
					strValorNuevo=detalleproforma.getid_producto().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleProformaConstantesFunciones.IDPRODUCTO,strValorActual,strValorNuevo);
			}	
			
			if(detalleproforma.getIsNew()||!detalleproforma.getid_unidad().equals(detalleproforma.getDetalleProformaOriginal().getid_unidad()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleproforma.getDetalleProformaOriginal().getid_unidad()!=null)
				{
					strValorActual=detalleproforma.getDetalleProformaOriginal().getid_unidad().toString();
				}
				if(detalleproforma.getid_unidad()!=null)
				{
					strValorNuevo=detalleproforma.getid_unidad().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleProformaConstantesFunciones.IDUNIDAD,strValorActual,strValorNuevo);
			}	
			
			if(detalleproforma.getIsNew()||!detalleproforma.getid_empaque().equals(detalleproforma.getDetalleProformaOriginal().getid_empaque()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleproforma.getDetalleProformaOriginal().getid_empaque()!=null)
				{
					strValorActual=detalleproforma.getDetalleProformaOriginal().getid_empaque().toString();
				}
				if(detalleproforma.getid_empaque()!=null)
				{
					strValorNuevo=detalleproforma.getid_empaque().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleProformaConstantesFunciones.IDEMPAQUE,strValorActual,strValorNuevo);
			}	
			
			if(detalleproforma.getIsNew()||!detalleproforma.getid_centro_costo().equals(detalleproforma.getDetalleProformaOriginal().getid_centro_costo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleproforma.getDetalleProformaOriginal().getid_centro_costo()!=null)
				{
					strValorActual=detalleproforma.getDetalleProformaOriginal().getid_centro_costo().toString();
				}
				if(detalleproforma.getid_centro_costo()!=null)
				{
					strValorNuevo=detalleproforma.getid_centro_costo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleProformaConstantesFunciones.IDCENTROCOSTO,strValorActual,strValorNuevo);
			}	
			
			if(detalleproforma.getIsNew()||!detalleproforma.getid_estado_detalle_proforma().equals(detalleproforma.getDetalleProformaOriginal().getid_estado_detalle_proforma()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleproforma.getDetalleProformaOriginal().getid_estado_detalle_proforma()!=null)
				{
					strValorActual=detalleproforma.getDetalleProformaOriginal().getid_estado_detalle_proforma().toString();
				}
				if(detalleproforma.getid_estado_detalle_proforma()!=null)
				{
					strValorNuevo=detalleproforma.getid_estado_detalle_proforma().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleProformaConstantesFunciones.IDESTADODETALLEPROFORMA,strValorActual,strValorNuevo);
			}	
			
			if(detalleproforma.getIsNew()||!detalleproforma.getdescripcion().equals(detalleproforma.getDetalleProformaOriginal().getdescripcion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleproforma.getDetalleProformaOriginal().getdescripcion()!=null)
				{
					strValorActual=detalleproforma.getDetalleProformaOriginal().getdescripcion();
				}
				if(detalleproforma.getdescripcion()!=null)
				{
					strValorNuevo=detalleproforma.getdescripcion() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleProformaConstantesFunciones.DESCRIPCION,strValorActual,strValorNuevo);
			}	
			
			if(detalleproforma.getIsNew()||!detalleproforma.getcantidad_envases().equals(detalleproforma.getDetalleProformaOriginal().getcantidad_envases()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleproforma.getDetalleProformaOriginal().getcantidad_envases()!=null)
				{
					strValorActual=detalleproforma.getDetalleProformaOriginal().getcantidad_envases().toString();
				}
				if(detalleproforma.getcantidad_envases()!=null)
				{
					strValorNuevo=detalleproforma.getcantidad_envases().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleProformaConstantesFunciones.CANTIDADENVASES,strValorActual,strValorNuevo);
			}	
			
			if(detalleproforma.getIsNew()||!detalleproforma.getcantidad().equals(detalleproforma.getDetalleProformaOriginal().getcantidad()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleproforma.getDetalleProformaOriginal().getcantidad()!=null)
				{
					strValorActual=detalleproforma.getDetalleProformaOriginal().getcantidad().toString();
				}
				if(detalleproforma.getcantidad()!=null)
				{
					strValorNuevo=detalleproforma.getcantidad().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleProformaConstantesFunciones.CANTIDAD,strValorActual,strValorNuevo);
			}	
			
			if(detalleproforma.getIsNew()||!detalleproforma.getprecio().equals(detalleproforma.getDetalleProformaOriginal().getprecio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleproforma.getDetalleProformaOriginal().getprecio()!=null)
				{
					strValorActual=detalleproforma.getDetalleProformaOriginal().getprecio().toString();
				}
				if(detalleproforma.getprecio()!=null)
				{
					strValorNuevo=detalleproforma.getprecio().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleProformaConstantesFunciones.PRECIO,strValorActual,strValorNuevo);
			}	
			
			if(detalleproforma.getIsNew()||!detalleproforma.getiva().equals(detalleproforma.getDetalleProformaOriginal().getiva()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleproforma.getDetalleProformaOriginal().getiva()!=null)
				{
					strValorActual=detalleproforma.getDetalleProformaOriginal().getiva().toString();
				}
				if(detalleproforma.getiva()!=null)
				{
					strValorNuevo=detalleproforma.getiva().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleProformaConstantesFunciones.IVA,strValorActual,strValorNuevo);
			}	
			
			if(detalleproforma.getIsNew()||!detalleproforma.getdescuento_porcentaje().equals(detalleproforma.getDetalleProformaOriginal().getdescuento_porcentaje()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleproforma.getDetalleProformaOriginal().getdescuento_porcentaje()!=null)
				{
					strValorActual=detalleproforma.getDetalleProformaOriginal().getdescuento_porcentaje().toString();
				}
				if(detalleproforma.getdescuento_porcentaje()!=null)
				{
					strValorNuevo=detalleproforma.getdescuento_porcentaje().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleProformaConstantesFunciones.DESCUENTOPORCENTAJE,strValorActual,strValorNuevo);
			}	
			
			if(detalleproforma.getIsNew()||!detalleproforma.getdescuento_valor().equals(detalleproforma.getDetalleProformaOriginal().getdescuento_valor()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleproforma.getDetalleProformaOriginal().getdescuento_valor()!=null)
				{
					strValorActual=detalleproforma.getDetalleProformaOriginal().getdescuento_valor().toString();
				}
				if(detalleproforma.getdescuento_valor()!=null)
				{
					strValorNuevo=detalleproforma.getdescuento_valor().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleProformaConstantesFunciones.DESCUENTOVALOR,strValorActual,strValorNuevo);
			}	
			
			if(detalleproforma.getIsNew()||!detalleproforma.getlote().equals(detalleproforma.getDetalleProformaOriginal().getlote()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleproforma.getDetalleProformaOriginal().getlote()!=null)
				{
					strValorActual=detalleproforma.getDetalleProformaOriginal().getlote();
				}
				if(detalleproforma.getlote()!=null)
				{
					strValorNuevo=detalleproforma.getlote() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleProformaConstantesFunciones.LOTE,strValorActual,strValorNuevo);
			}	
			
			if(detalleproforma.getIsNew()||!detalleproforma.gettotal().equals(detalleproforma.getDetalleProformaOriginal().gettotal()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleproforma.getDetalleProformaOriginal().gettotal()!=null)
				{
					strValorActual=detalleproforma.getDetalleProformaOriginal().gettotal().toString();
				}
				if(detalleproforma.gettotal()!=null)
				{
					strValorNuevo=detalleproforma.gettotal().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleProformaConstantesFunciones.TOTAL,strValorActual,strValorNuevo);
			}	
			
			if(detalleproforma.getIsNew()||!detalleproforma.getice().equals(detalleproforma.getDetalleProformaOriginal().getice()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleproforma.getDetalleProformaOriginal().getice()!=null)
				{
					strValorActual=detalleproforma.getDetalleProformaOriginal().getice().toString();
				}
				if(detalleproforma.getice()!=null)
				{
					strValorNuevo=detalleproforma.getice().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleProformaConstantesFunciones.ICE,strValorActual,strValorNuevo);
			}	
			
			if(detalleproforma.getIsNew()||!detalleproforma.getcosto().equals(detalleproforma.getDetalleProformaOriginal().getcosto()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleproforma.getDetalleProformaOriginal().getcosto()!=null)
				{
					strValorActual=detalleproforma.getDetalleProformaOriginal().getcosto().toString();
				}
				if(detalleproforma.getcosto()!=null)
				{
					strValorNuevo=detalleproforma.getcosto().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleProformaConstantesFunciones.COSTO,strValorActual,strValorNuevo);
			}	
			
			if(detalleproforma.getIsNew()||!detalleproforma.getutilidad().equals(detalleproforma.getDetalleProformaOriginal().getutilidad()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleproforma.getDetalleProformaOriginal().getutilidad()!=null)
				{
					strValorActual=detalleproforma.getDetalleProformaOriginal().getutilidad().toString();
				}
				if(detalleproforma.getutilidad()!=null)
				{
					strValorNuevo=detalleproforma.getutilidad().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleProformaConstantesFunciones.UTILIDAD,strValorActual,strValorNuevo);
			}	
			
			if(detalleproforma.getIsNew()||!detalleproforma.getarea().equals(detalleproforma.getDetalleProformaOriginal().getarea()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleproforma.getDetalleProformaOriginal().getarea()!=null)
				{
					strValorActual=detalleproforma.getDetalleProformaOriginal().getarea();
				}
				if(detalleproforma.getarea()!=null)
				{
					strValorNuevo=detalleproforma.getarea() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleProformaConstantesFunciones.AREA,strValorActual,strValorNuevo);
			}	
			
			if(detalleproforma.getIsNew()||!detalleproforma.getmedida().equals(detalleproforma.getDetalleProformaOriginal().getmedida()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleproforma.getDetalleProformaOriginal().getmedida()!=null)
				{
					strValorActual=detalleproforma.getDetalleProformaOriginal().getmedida();
				}
				if(detalleproforma.getmedida()!=null)
				{
					strValorNuevo=detalleproforma.getmedida() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleProformaConstantesFunciones.MEDIDA,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveDetalleProformaRelacionesWithConnection(DetalleProforma detalleproforma) throws Exception {

		if(!detalleproforma.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveDetalleProformaRelacionesBase(detalleproforma,true);
		}
	}

	public void saveDetalleProformaRelaciones(DetalleProforma detalleproforma)throws Exception {

		if(!detalleproforma.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveDetalleProformaRelacionesBase(detalleproforma,false);
		}
	}

	public void saveDetalleProformaRelacionesBase(DetalleProforma detalleproforma,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("DetalleProforma-saveRelacionesWithConnection");}
	

			this.setDetalleProforma(detalleproforma);

			if(DetalleProformaLogicAdditional.validarSaveRelaciones(detalleproforma,this)) {

				DetalleProformaLogicAdditional.updateRelacionesToSave(detalleproforma,this);

				if((detalleproforma.getIsNew()||detalleproforma.getIsChanged())&&!detalleproforma.getIsDeleted()) {
					this.saveDetalleProforma();
					this.saveDetalleProformaRelacionesDetalles();

				} else if(detalleproforma.getIsDeleted()) {
					this.saveDetalleProformaRelacionesDetalles();
					this.saveDetalleProforma();
				}

				DetalleProformaLogicAdditional.updateRelacionesToSaveAfter(detalleproforma,this);

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
	
	
	private void saveDetalleProformaRelacionesDetalles()throws Exception {
		try {
	

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfDetalleProforma(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=DetalleProformaConstantesFunciones.getClassesForeignKeysOfDetalleProforma(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfDetalleProforma(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=DetalleProformaConstantesFunciones.getClassesRelationshipsOfDetalleProforma(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

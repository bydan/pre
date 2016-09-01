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
import com.bydan.erp.activosfijos.util.DetalleActivoFijoConstantesFunciones;
import com.bydan.erp.activosfijos.util.DetalleActivoFijoParameterReturnGeneral;
//import com.bydan.erp.activosfijos.util.DetalleActivoFijoParameterGeneral;
import com.bydan.erp.activosfijos.business.entity.DetalleActivoFijo;
import com.bydan.erp.activosfijos.business.logic.DetalleActivoFijoLogicAdditional;
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
public class DetalleActivoFijoLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(DetalleActivoFijoLogic.class);
	
	protected DetalleActivoFijoDataAccess detalleactivofijoDataAccess; 	
	protected DetalleActivoFijo detalleactivofijo;
	protected List<DetalleActivoFijo> detalleactivofijos;
	protected Object detalleactivofijoObject;	
	protected List<Object> detalleactivofijosObject;
	
	public static ClassValidator<DetalleActivoFijo> detalleactivofijoValidator = new ClassValidator<DetalleActivoFijo>(DetalleActivoFijo.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected DetalleActivoFijoLogicAdditional detalleactivofijoLogicAdditional=null;
	
	public DetalleActivoFijoLogicAdditional getDetalleActivoFijoLogicAdditional() {
		return this.detalleactivofijoLogicAdditional;
	}
	
	public void setDetalleActivoFijoLogicAdditional(DetalleActivoFijoLogicAdditional detalleactivofijoLogicAdditional) {
		try {
			this.detalleactivofijoLogicAdditional=detalleactivofijoLogicAdditional;
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
	
	
	
	
	public  DetalleActivoFijoLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.detalleactivofijoDataAccess = new DetalleActivoFijoDataAccess();
			
			this.detalleactivofijos= new ArrayList<DetalleActivoFijo>();
			this.detalleactivofijo= new DetalleActivoFijo();
			
			this.detalleactivofijoObject=new Object();
			this.detalleactivofijosObject=new ArrayList<Object>();
				
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
			
			this.detalleactivofijoDataAccess.setConnexionType(this.connexionType);
			this.detalleactivofijoDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  DetalleActivoFijoLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.detalleactivofijoDataAccess = new DetalleActivoFijoDataAccess();
			this.detalleactivofijos= new ArrayList<DetalleActivoFijo>();
			this.detalleactivofijo= new DetalleActivoFijo();
			this.detalleactivofijoObject=new Object();
			this.detalleactivofijosObject=new ArrayList<Object>();
			
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
			
			this.detalleactivofijoDataAccess.setConnexionType(this.connexionType);
			this.detalleactivofijoDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public DetalleActivoFijo getDetalleActivoFijo() throws Exception {	
		DetalleActivoFijoLogicAdditional.checkDetalleActivoFijoToGet(detalleactivofijo,this.datosCliente,this.arrDatoGeneral);
		DetalleActivoFijoLogicAdditional.updateDetalleActivoFijoToGet(detalleactivofijo,this.arrDatoGeneral);
		
		return detalleactivofijo;
	}
		
	public void setDetalleActivoFijo(DetalleActivoFijo newDetalleActivoFijo) {
		this.detalleactivofijo = newDetalleActivoFijo;
	}
	
	public DetalleActivoFijoDataAccess getDetalleActivoFijoDataAccess() {
		return detalleactivofijoDataAccess;
	}
	
	public void setDetalleActivoFijoDataAccess(DetalleActivoFijoDataAccess newdetalleactivofijoDataAccess) {
		this.detalleactivofijoDataAccess = newdetalleactivofijoDataAccess;
	}
	
	public List<DetalleActivoFijo> getDetalleActivoFijos() throws Exception {		
		this.quitarDetalleActivoFijosNulos();
		
		DetalleActivoFijoLogicAdditional.checkDetalleActivoFijoToGets(detalleactivofijos,this.datosCliente,this.arrDatoGeneral);
		
		for (DetalleActivoFijo detalleactivofijoLocal: detalleactivofijos ) {
			DetalleActivoFijoLogicAdditional.updateDetalleActivoFijoToGet(detalleactivofijoLocal,this.arrDatoGeneral);
		}
		
		return detalleactivofijos;
	}
	
	public void setDetalleActivoFijos(List<DetalleActivoFijo> newDetalleActivoFijos) {
		this.detalleactivofijos = newDetalleActivoFijos;
	}
	
	public Object getDetalleActivoFijoObject() {	
		this.detalleactivofijoObject=this.detalleactivofijoDataAccess.getEntityObject();
		return this.detalleactivofijoObject;
	}
		
	public void setDetalleActivoFijoObject(Object newDetalleActivoFijoObject) {
		this.detalleactivofijoObject = newDetalleActivoFijoObject;
	}
	
	public List<Object> getDetalleActivoFijosObject() {		
		this.detalleactivofijosObject=this.detalleactivofijoDataAccess.getEntitiesObject();
		return this.detalleactivofijosObject;
	}
		
	public void setDetalleActivoFijosObject(List<Object> newDetalleActivoFijosObject) {
		this.detalleactivofijosObject = newDetalleActivoFijosObject;
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
		
		if(this.detalleactivofijoDataAccess!=null) {
			this.detalleactivofijoDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleActivoFijo.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			detalleactivofijoDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			detalleactivofijoDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		detalleactivofijo = new  DetalleActivoFijo();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleActivoFijo.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			detalleactivofijo=detalleactivofijoDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.detalleactivofijo,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				DetalleActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesDetalleActivoFijo(this.detalleactivofijo);
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
		detalleactivofijo = new  DetalleActivoFijo();
		  		  
        try {
			
			detalleactivofijo=detalleactivofijoDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.detalleactivofijo,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				DetalleActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesDetalleActivoFijo(this.detalleactivofijo);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		detalleactivofijo = new  DetalleActivoFijo();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleActivoFijo.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			detalleactivofijo=detalleactivofijoDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.detalleactivofijo,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				DetalleActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesDetalleActivoFijo(this.detalleactivofijo);
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
		detalleactivofijo = new  DetalleActivoFijo();
		  		  
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
		detalleactivofijo = new  DetalleActivoFijo();
		  		  
        try {
			
			detalleactivofijo=detalleactivofijoDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.detalleactivofijo,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				DetalleActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesDetalleActivoFijo(this.detalleactivofijo);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		detalleactivofijo = new  DetalleActivoFijo();
		  		  
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
		detalleactivofijo = new  DetalleActivoFijo();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleActivoFijo.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =detalleactivofijoDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		detalleactivofijo = new  DetalleActivoFijo();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=detalleactivofijoDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		detalleactivofijo = new  DetalleActivoFijo();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleActivoFijo.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =detalleactivofijoDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		detalleactivofijo = new  DetalleActivoFijo();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=detalleactivofijoDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		detalleactivofijo = new  DetalleActivoFijo();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleActivoFijo.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =detalleactivofijoDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		detalleactivofijo = new  DetalleActivoFijo();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=detalleactivofijoDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		detalleactivofijos = new  ArrayList<DetalleActivoFijo>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleActivoFijo.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			DetalleActivoFijoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detalleactivofijos=detalleactivofijoDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarDetalleActivoFijo(detalleactivofijos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesDetalleActivoFijo(this.detalleactivofijos);
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
		detalleactivofijos = new  ArrayList<DetalleActivoFijo>();
		  		  
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
		detalleactivofijos = new  ArrayList<DetalleActivoFijo>();
		  		  
        try {			
			DetalleActivoFijoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detalleactivofijos=detalleactivofijoDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarDetalleActivoFijo(detalleactivofijos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesDetalleActivoFijo(this.detalleactivofijos);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		detalleactivofijos = new  ArrayList<DetalleActivoFijo>();
		  		  
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
		detalleactivofijos = new  ArrayList<DetalleActivoFijo>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleActivoFijo.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			DetalleActivoFijoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detalleactivofijos=detalleactivofijoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarDetalleActivoFijo(detalleactivofijos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesDetalleActivoFijo(this.detalleactivofijos);
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
		detalleactivofijos = new  ArrayList<DetalleActivoFijo>();
		  		  
        try {
			DetalleActivoFijoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detalleactivofijos=detalleactivofijoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarDetalleActivoFijo(detalleactivofijos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesDetalleActivoFijo(this.detalleactivofijos);
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
		detalleactivofijos = new  ArrayList<DetalleActivoFijo>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleActivoFijo.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DetalleActivoFijoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detalleactivofijos=detalleactivofijoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarDetalleActivoFijo(detalleactivofijos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesDetalleActivoFijo(this.detalleactivofijos);
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
		detalleactivofijos = new  ArrayList<DetalleActivoFijo>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DetalleActivoFijoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detalleactivofijos=detalleactivofijoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarDetalleActivoFijo(detalleactivofijos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesDetalleActivoFijo(this.detalleactivofijos);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		detalleactivofijo = new  DetalleActivoFijo();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleActivoFijo.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DetalleActivoFijoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detalleactivofijo=detalleactivofijoDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarDetalleActivoFijo(detalleactivofijo);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesDetalleActivoFijo(this.detalleactivofijo);
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
		detalleactivofijo = new  DetalleActivoFijo();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DetalleActivoFijoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detalleactivofijo=detalleactivofijoDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarDetalleActivoFijo(detalleactivofijo);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesDetalleActivoFijo(this.detalleactivofijo);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		detalleactivofijos = new  ArrayList<DetalleActivoFijo>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleActivoFijo.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			DetalleActivoFijoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detalleactivofijos=detalleactivofijoDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarDetalleActivoFijo(detalleactivofijos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesDetalleActivoFijo(this.detalleactivofijos);
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
		detalleactivofijos = new  ArrayList<DetalleActivoFijo>();
		  		  
        try {
			DetalleActivoFijoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detalleactivofijos=detalleactivofijoDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarDetalleActivoFijo(detalleactivofijos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesDetalleActivoFijo(this.detalleactivofijos);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosDetalleActivoFijosWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		detalleactivofijos = new  ArrayList<DetalleActivoFijo>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleActivoFijo.class.getSimpleName()+"-getTodosDetalleActivoFijosWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DetalleActivoFijoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detalleactivofijos=detalleactivofijoDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarDetalleActivoFijo(detalleactivofijos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesDetalleActivoFijo(this.detalleactivofijos);
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
	
	public  void  getTodosDetalleActivoFijos(String sFinalQuery,Pagination pagination)throws Exception {
		detalleactivofijos = new  ArrayList<DetalleActivoFijo>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DetalleActivoFijoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detalleactivofijos=detalleactivofijoDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarDetalleActivoFijo(detalleactivofijos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesDetalleActivoFijo(this.detalleactivofijos);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarDetalleActivoFijo(DetalleActivoFijo detalleactivofijo) throws Exception {
		Boolean estaValidado=false;
		
		if(detalleactivofijo.getIsNew() || detalleactivofijo.getIsChanged()) { 
			this.invalidValues = detalleactivofijoValidator.getInvalidValues(detalleactivofijo);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(detalleactivofijo);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarDetalleActivoFijo(List<DetalleActivoFijo> DetalleActivoFijos) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(DetalleActivoFijo detalleactivofijoLocal:detalleactivofijos) {				
			estaValidadoObjeto=this.validarGuardarDetalleActivoFijo(detalleactivofijoLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarDetalleActivoFijo(List<DetalleActivoFijo> DetalleActivoFijos) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarDetalleActivoFijo(detalleactivofijos)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarDetalleActivoFijo(DetalleActivoFijo DetalleActivoFijo) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarDetalleActivoFijo(detalleactivofijo)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(DetalleActivoFijo detalleactivofijo) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+detalleactivofijo.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=DetalleActivoFijoConstantesFunciones.getDetalleActivoFijoLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"detalleactivofijo","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(DetalleActivoFijoConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(DetalleActivoFijoConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveDetalleActivoFijoWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleActivoFijo.class.getSimpleName()+"-saveDetalleActivoFijoWithConnection");connexion.begin();			
			
			DetalleActivoFijoLogicAdditional.checkDetalleActivoFijoToSave(this.detalleactivofijo,this.datosCliente,connexion,this.arrDatoGeneral);
			
			DetalleActivoFijoLogicAdditional.updateDetalleActivoFijoToSave(this.detalleactivofijo,this.arrDatoGeneral);
			
			DetalleActivoFijoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.detalleactivofijo,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowDetalleActivoFijo();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarDetalleActivoFijo(this.detalleactivofijo)) {
				DetalleActivoFijoDataAccess.save(this.detalleactivofijo, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.detalleactivofijo,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			DetalleActivoFijoLogicAdditional.checkDetalleActivoFijoToSaveAfter(this.detalleactivofijo,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowDetalleActivoFijo();
			
			connexion.commit();			
			
			if(this.detalleactivofijo.getIsDeleted()) {
				this.detalleactivofijo=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveDetalleActivoFijo()throws Exception {	
		try {	
			
			DetalleActivoFijoLogicAdditional.checkDetalleActivoFijoToSave(this.detalleactivofijo,this.datosCliente,connexion,this.arrDatoGeneral);
			
			DetalleActivoFijoLogicAdditional.updateDetalleActivoFijoToSave(this.detalleactivofijo,this.arrDatoGeneral);
			
			DetalleActivoFijoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.detalleactivofijo,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarDetalleActivoFijo(this.detalleactivofijo)) {			
				DetalleActivoFijoDataAccess.save(this.detalleactivofijo, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.detalleactivofijo,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			DetalleActivoFijoLogicAdditional.checkDetalleActivoFijoToSaveAfter(this.detalleactivofijo,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.detalleactivofijo.getIsDeleted()) {
				this.detalleactivofijo=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveDetalleActivoFijosWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleActivoFijo.class.getSimpleName()+"-saveDetalleActivoFijosWithConnection");connexion.begin();			
			
			DetalleActivoFijoLogicAdditional.checkDetalleActivoFijoToSaves(detalleactivofijos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowDetalleActivoFijos();
			
			Boolean validadoTodosDetalleActivoFijo=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(DetalleActivoFijo detalleactivofijoLocal:detalleactivofijos) {		
				if(detalleactivofijoLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				DetalleActivoFijoLogicAdditional.updateDetalleActivoFijoToSave(detalleactivofijoLocal,this.arrDatoGeneral);
	        	
				DetalleActivoFijoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),detalleactivofijoLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarDetalleActivoFijo(detalleactivofijoLocal)) {
					DetalleActivoFijoDataAccess.save(detalleactivofijoLocal, connexion);				
				} else {
					validadoTodosDetalleActivoFijo=false;
				}
			}
			
			if(!validadoTodosDetalleActivoFijo) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			DetalleActivoFijoLogicAdditional.checkDetalleActivoFijoToSavesAfter(detalleactivofijos,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowDetalleActivoFijos();
			
			connexion.commit();		
			
			this.quitarDetalleActivoFijosEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveDetalleActivoFijos()throws Exception {				
		 try {	
			DetalleActivoFijoLogicAdditional.checkDetalleActivoFijoToSaves(detalleactivofijos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosDetalleActivoFijo=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(DetalleActivoFijo detalleactivofijoLocal:detalleactivofijos) {				
				if(detalleactivofijoLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				DetalleActivoFijoLogicAdditional.updateDetalleActivoFijoToSave(detalleactivofijoLocal,this.arrDatoGeneral);
	        	
				DetalleActivoFijoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),detalleactivofijoLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarDetalleActivoFijo(detalleactivofijoLocal)) {				
					DetalleActivoFijoDataAccess.save(detalleactivofijoLocal, connexion);				
				} else {
					validadoTodosDetalleActivoFijo=false;
				}
			}
			
			if(!validadoTodosDetalleActivoFijo) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			DetalleActivoFijoLogicAdditional.checkDetalleActivoFijoToSavesAfter(detalleactivofijos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarDetalleActivoFijosEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public DetalleActivoFijoParameterReturnGeneral procesarAccionDetalleActivoFijos(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<DetalleActivoFijo> detalleactivofijos,DetalleActivoFijoParameterReturnGeneral detalleactivofijoParameterGeneral)throws Exception {
		 try {	
			DetalleActivoFijoParameterReturnGeneral detalleactivofijoReturnGeneral=new DetalleActivoFijoParameterReturnGeneral();
	
			DetalleActivoFijoLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,detalleactivofijos,detalleactivofijoParameterGeneral,detalleactivofijoReturnGeneral);
			
			return detalleactivofijoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public DetalleActivoFijoParameterReturnGeneral procesarAccionDetalleActivoFijosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<DetalleActivoFijo> detalleactivofijos,DetalleActivoFijoParameterReturnGeneral detalleactivofijoParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleActivoFijo.class.getSimpleName()+"-procesarAccionDetalleActivoFijosWithConnection");connexion.begin();			
			
			DetalleActivoFijoParameterReturnGeneral detalleactivofijoReturnGeneral=new DetalleActivoFijoParameterReturnGeneral();
	
			DetalleActivoFijoLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,detalleactivofijos,detalleactivofijoParameterGeneral,detalleactivofijoReturnGeneral);
			
			this.connexion.commit();
			
			return detalleactivofijoReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public DetalleActivoFijoParameterReturnGeneral procesarEventosDetalleActivoFijos(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<DetalleActivoFijo> detalleactivofijos,DetalleActivoFijo detalleactivofijo,DetalleActivoFijoParameterReturnGeneral detalleactivofijoParameterGeneral,Boolean isEsNuevoDetalleActivoFijo,ArrayList<Classe> clases)throws Exception {
		 try {	
			DetalleActivoFijoParameterReturnGeneral detalleactivofijoReturnGeneral=new DetalleActivoFijoParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				detalleactivofijoReturnGeneral.setConRecargarPropiedades(true);
			}
			
			DetalleActivoFijoLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,detalleactivofijos,detalleactivofijo,detalleactivofijoParameterGeneral,detalleactivofijoReturnGeneral,isEsNuevoDetalleActivoFijo,clases);
			
			return detalleactivofijoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public DetalleActivoFijoParameterReturnGeneral procesarEventosDetalleActivoFijosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<DetalleActivoFijo> detalleactivofijos,DetalleActivoFijo detalleactivofijo,DetalleActivoFijoParameterReturnGeneral detalleactivofijoParameterGeneral,Boolean isEsNuevoDetalleActivoFijo,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleActivoFijo.class.getSimpleName()+"-procesarEventosDetalleActivoFijosWithConnection");connexion.begin();			
			
			DetalleActivoFijoParameterReturnGeneral detalleactivofijoReturnGeneral=new DetalleActivoFijoParameterReturnGeneral();
	
			detalleactivofijoReturnGeneral.setDetalleActivoFijo(detalleactivofijo);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				detalleactivofijoReturnGeneral.setConRecargarPropiedades(true);
			}
			
			DetalleActivoFijoLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,detalleactivofijos,detalleactivofijo,detalleactivofijoParameterGeneral,detalleactivofijoReturnGeneral,isEsNuevoDetalleActivoFijo,clases);
			
			this.connexion.commit();
			
			return detalleactivofijoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public DetalleActivoFijoParameterReturnGeneral procesarImportacionDetalleActivoFijosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,DetalleActivoFijoParameterReturnGeneral detalleactivofijoParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleActivoFijo.class.getSimpleName()+"-procesarImportacionDetalleActivoFijosWithConnection");connexion.begin();			
			
			DetalleActivoFijoParameterReturnGeneral detalleactivofijoReturnGeneral=new DetalleActivoFijoParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.detalleactivofijos=new ArrayList<DetalleActivoFijo>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.detalleactivofijo=new DetalleActivoFijo();
				
				
				if(conColumnasBase) {this.detalleactivofijo.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.detalleactivofijo.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.detalleactivofijo.setcodigo(arrColumnas[iColumn++]);
				this.detalleactivofijo.setnombre(arrColumnas[iColumn++]);
				this.detalleactivofijo.setserie(arrColumnas[iColumn++]);
				this.detalleactivofijo.setfecha_compra(Funciones.ConvertToDate(arrColumnas[iColumn++]));
				this.detalleactivofijo.setfecha_mantenimiento(Funciones.ConvertToDate(arrColumnas[iColumn++]));
				this.detalleactivofijo.setfecha_correccion(Funciones.ConvertToDate(arrColumnas[iColumn++]));
				this.detalleactivofijo.setfecha_depreciacion(Funciones.ConvertToDate(arrColumnas[iColumn++]));
				this.detalleactivofijo.setclave(arrColumnas[iColumn++]);
				this.detalleactivofijo.setmarca(arrColumnas[iColumn++]);
				this.detalleactivofijo.setmodelo(arrColumnas[iColumn++]);
				this.detalleactivofijo.setcolor(arrColumnas[iColumn++]);
				this.detalleactivofijo.setfecha(Funciones.ConvertToDate(arrColumnas[iColumn++]));
				this.detalleactivofijo.setvalor_util(Double.parseDouble(arrColumnas[iColumn++]));
				this.detalleactivofijo.setcosto_de_compra(Double.parseDouble(arrColumnas[iColumn++]));
				this.detalleactivofijo.setvida_util(Double.parseDouble(arrColumnas[iColumn++]));
				this.detalleactivofijo.setvalor_residual(Double.parseDouble(arrColumnas[iColumn++]));
				this.detalleactivofijo.setcantidad(Integer.parseInt(arrColumnas[iColumn++]));
				this.detalleactivofijo.setnombre_propietario(arrColumnas[iColumn++]);
				this.detalleactivofijo.setresponsable(arrColumnas[iColumn++]);
				this.detalleactivofijo.setpath_foto(arrColumnas[iColumn++]);
				this.detalleactivofijo.setnumero_comprobante(arrColumnas[iColumn++]);
				this.detalleactivofijo.setreferencia(arrColumnas[iColumn++]);
				this.detalleactivofijo.setvalor_cotizacion(Double.parseDouble(arrColumnas[iColumn++]));
				this.detalleactivofijo.setcon_partes(Boolean.parseBoolean(arrColumnas[iColumn++]));
				this.detalleactivofijo.setcon_garantia(Boolean.parseBoolean(arrColumnas[iColumn++]));
				this.detalleactivofijo.setcon_existencia(Boolean.parseBoolean(arrColumnas[iColumn++]));
				this.detalleactivofijo.setfecha_baja(Funciones.ConvertToDate(arrColumnas[iColumn++]));
				this.detalleactivofijo.setpath_foto2(arrColumnas[iColumn++]);
				
				this.detalleactivofijos.add(this.detalleactivofijo);
			}
			
			this.saveDetalleActivoFijos();
			
			this.connexion.commit();
			
			detalleactivofijoReturnGeneral.setConRetornoEstaProcesado(true);
			detalleactivofijoReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return detalleactivofijoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarDetalleActivoFijosEliminados() throws Exception {				
		
		List<DetalleActivoFijo> detalleactivofijosAux= new ArrayList<DetalleActivoFijo>();
		
		for(DetalleActivoFijo detalleactivofijo:detalleactivofijos) {
			if(!detalleactivofijo.getIsDeleted()) {
				detalleactivofijosAux.add(detalleactivofijo);
			}
		}
		
		detalleactivofijos=detalleactivofijosAux;
	}
	
	public void quitarDetalleActivoFijosNulos() throws Exception {				
		
		List<DetalleActivoFijo> detalleactivofijosAux= new ArrayList<DetalleActivoFijo>();
		
		for(DetalleActivoFijo detalleactivofijo : this.detalleactivofijos) {
			if(detalleactivofijo==null) {
				detalleactivofijosAux.add(detalleactivofijo);
			}
		}
		
		//this.detalleactivofijos=detalleactivofijosAux;
		
		this.detalleactivofijos.removeAll(detalleactivofijosAux);
	}
	
	public void getSetVersionRowDetalleActivoFijoWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(detalleactivofijo.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((detalleactivofijo.getIsDeleted() || (detalleactivofijo.getIsChanged()&&!detalleactivofijo.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=detalleactivofijoDataAccess.getSetVersionRowDetalleActivoFijo(connexion,detalleactivofijo.getId());
				
				if(!detalleactivofijo.getVersionRow().equals(timestamp)) {	
					detalleactivofijo.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				detalleactivofijo.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowDetalleActivoFijo()throws Exception {	
		
		if(detalleactivofijo.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((detalleactivofijo.getIsDeleted() || (detalleactivofijo.getIsChanged()&&!detalleactivofijo.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=detalleactivofijoDataAccess.getSetVersionRowDetalleActivoFijo(connexion,detalleactivofijo.getId());
			
			try {							
				if(!detalleactivofijo.getVersionRow().equals(timestamp)) {	
					detalleactivofijo.setVersionRow(timestamp);
				}
				
				detalleactivofijo.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowDetalleActivoFijosWithConnection()throws Exception {	
		if(detalleactivofijos!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(DetalleActivoFijo detalleactivofijoAux:detalleactivofijos) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(detalleactivofijoAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(detalleactivofijoAux.getIsDeleted() || (detalleactivofijoAux.getIsChanged()&&!detalleactivofijoAux.getIsNew())) {
						
						timestamp=detalleactivofijoDataAccess.getSetVersionRowDetalleActivoFijo(connexion,detalleactivofijoAux.getId());
						
						if(!detalleactivofijo.getVersionRow().equals(timestamp)) {	
							detalleactivofijoAux.setVersionRow(timestamp);
						}
								
						detalleactivofijoAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowDetalleActivoFijos()throws Exception {	
		if(detalleactivofijos!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(DetalleActivoFijo detalleactivofijoAux:detalleactivofijos) {
					if(detalleactivofijoAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(detalleactivofijoAux.getIsDeleted() || (detalleactivofijoAux.getIsChanged()&&!detalleactivofijoAux.getIsNew())) {
						
						timestamp=detalleactivofijoDataAccess.getSetVersionRowDetalleActivoFijo(connexion,detalleactivofijoAux.getId());
						
						if(!detalleactivofijoAux.getVersionRow().equals(timestamp)) {	
							detalleactivofijoAux.setVersionRow(timestamp);
						}
						
													
						detalleactivofijoAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public DetalleActivoFijoParameterReturnGeneral cargarCombosLoteForeignKeyDetalleActivoFijoWithConnection(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalDetalleGrupoActivoFijo,String finalQueryGlobalSubGrupoActivoFijo,String finalQueryGlobalTipoRamoActivoFijo,String finalQueryGlobalTipoActivoFijoEmpresa,String finalQueryGlobalTipoDepreciacionEmpresa,String finalQueryGlobalEstadoActivoFijo,String finalQueryGlobalCliente,String finalQueryGlobalPartidaPresu) throws Exception {
		DetalleActivoFijoParameterReturnGeneral  detalleactivofijoReturnGeneral =new DetalleActivoFijoParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleActivoFijo.class.getSimpleName()+"-cargarCombosLoteForeignKeyDetalleActivoFijoWithConnection");connexion.begin();
			
			detalleactivofijoReturnGeneral =new DetalleActivoFijoParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			detalleactivofijoReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			detalleactivofijoReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<DetalleGrupoActivoFijo> detallegrupoactivofijosForeignKey=new ArrayList<DetalleGrupoActivoFijo>();
			DetalleGrupoActivoFijoLogic detallegrupoactivofijoLogic=new DetalleGrupoActivoFijoLogic();
			detallegrupoactivofijoLogic.setConnexion(this.connexion);
			detallegrupoactivofijoLogic.getDetalleGrupoActivoFijoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalDetalleGrupoActivoFijo.equals("NONE")) {
				detallegrupoactivofijoLogic.getTodosDetalleGrupoActivoFijos(finalQueryGlobalDetalleGrupoActivoFijo,new Pagination());
				detallegrupoactivofijosForeignKey=detallegrupoactivofijoLogic.getDetalleGrupoActivoFijos();
			}

			detalleactivofijoReturnGeneral.setdetallegrupoactivofijosForeignKey(detallegrupoactivofijosForeignKey);


			List<SubGrupoActivoFijo> subgrupoactivofijosForeignKey=new ArrayList<SubGrupoActivoFijo>();
			SubGrupoActivoFijoLogic subgrupoactivofijoLogic=new SubGrupoActivoFijoLogic();
			subgrupoactivofijoLogic.setConnexion(this.connexion);
			subgrupoactivofijoLogic.getSubGrupoActivoFijoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSubGrupoActivoFijo.equals("NONE")) {
				subgrupoactivofijoLogic.getTodosSubGrupoActivoFijos(finalQueryGlobalSubGrupoActivoFijo,new Pagination());
				subgrupoactivofijosForeignKey=subgrupoactivofijoLogic.getSubGrupoActivoFijos();
			}

			detalleactivofijoReturnGeneral.setsubgrupoactivofijosForeignKey(subgrupoactivofijosForeignKey);


			List<TipoRamoActivoFijo> tiporamoactivofijosForeignKey=new ArrayList<TipoRamoActivoFijo>();
			TipoRamoActivoFijoLogic tiporamoactivofijoLogic=new TipoRamoActivoFijoLogic();
			tiporamoactivofijoLogic.setConnexion(this.connexion);
			tiporamoactivofijoLogic.getTipoRamoActivoFijoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoRamoActivoFijo.equals("NONE")) {
				tiporamoactivofijoLogic.getTodosTipoRamoActivoFijos(finalQueryGlobalTipoRamoActivoFijo,new Pagination());
				tiporamoactivofijosForeignKey=tiporamoactivofijoLogic.getTipoRamoActivoFijos();
			}

			detalleactivofijoReturnGeneral.settiporamoactivofijosForeignKey(tiporamoactivofijosForeignKey);


			List<TipoActivoFijoEmpresa> tipoactivofijoempresasForeignKey=new ArrayList<TipoActivoFijoEmpresa>();
			TipoActivoFijoEmpresaLogic tipoactivofijoempresaLogic=new TipoActivoFijoEmpresaLogic();
			tipoactivofijoempresaLogic.setConnexion(this.connexion);
			tipoactivofijoempresaLogic.getTipoActivoFijoEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoActivoFijoEmpresa.equals("NONE")) {
				tipoactivofijoempresaLogic.getTodosTipoActivoFijoEmpresas(finalQueryGlobalTipoActivoFijoEmpresa,new Pagination());
				tipoactivofijoempresasForeignKey=tipoactivofijoempresaLogic.getTipoActivoFijoEmpresas();
			}

			detalleactivofijoReturnGeneral.settipoactivofijoempresasForeignKey(tipoactivofijoempresasForeignKey);


			List<TipoDepreciacionEmpresa> tipodepreciacionempresasForeignKey=new ArrayList<TipoDepreciacionEmpresa>();
			TipoDepreciacionEmpresaLogic tipodepreciacionempresaLogic=new TipoDepreciacionEmpresaLogic();
			tipodepreciacionempresaLogic.setConnexion(this.connexion);
			tipodepreciacionempresaLogic.getTipoDepreciacionEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoDepreciacionEmpresa.equals("NONE")) {
				tipodepreciacionempresaLogic.getTodosTipoDepreciacionEmpresas(finalQueryGlobalTipoDepreciacionEmpresa,new Pagination());
				tipodepreciacionempresasForeignKey=tipodepreciacionempresaLogic.getTipoDepreciacionEmpresas();
			}

			detalleactivofijoReturnGeneral.settipodepreciacionempresasForeignKey(tipodepreciacionempresasForeignKey);


			List<EstadoActivoFijo> estadoactivofijosForeignKey=new ArrayList<EstadoActivoFijo>();
			EstadoActivoFijoLogic estadoactivofijoLogic=new EstadoActivoFijoLogic();
			estadoactivofijoLogic.setConnexion(this.connexion);
			estadoactivofijoLogic.getEstadoActivoFijoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEstadoActivoFijo.equals("NONE")) {
				estadoactivofijoLogic.getTodosEstadoActivoFijos(finalQueryGlobalEstadoActivoFijo,new Pagination());
				estadoactivofijosForeignKey=estadoactivofijoLogic.getEstadoActivoFijos();
			}

			detalleactivofijoReturnGeneral.setestadoactivofijosForeignKey(estadoactivofijosForeignKey);


			List<Cliente> clientesForeignKey=new ArrayList<Cliente>();
			ClienteLogic clienteLogic=new ClienteLogic();
			clienteLogic.setConnexion(this.connexion);
			clienteLogic.getClienteDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCliente.equals("NONE")) {
				clienteLogic.getTodosClientes(finalQueryGlobalCliente,new Pagination());
				clientesForeignKey=clienteLogic.getClientes();
			}

			detalleactivofijoReturnGeneral.setclientesForeignKey(clientesForeignKey);


			List<PartidaPresu> partidapresusForeignKey=new ArrayList<PartidaPresu>();
			PartidaPresuLogic partidapresuLogic=new PartidaPresuLogic();
			partidapresuLogic.setConnexion(this.connexion);
			partidapresuLogic.getPartidaPresuDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPartidaPresu.equals("NONE")) {
				partidapresuLogic.getTodosPartidaPresus(finalQueryGlobalPartidaPresu,new Pagination());
				partidapresusForeignKey=partidapresuLogic.getPartidaPresus();
			}

			detalleactivofijoReturnGeneral.setpartidapresusForeignKey(partidapresusForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return detalleactivofijoReturnGeneral;
	}
	
	public DetalleActivoFijoParameterReturnGeneral cargarCombosLoteForeignKeyDetalleActivoFijo(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalDetalleGrupoActivoFijo,String finalQueryGlobalSubGrupoActivoFijo,String finalQueryGlobalTipoRamoActivoFijo,String finalQueryGlobalTipoActivoFijoEmpresa,String finalQueryGlobalTipoDepreciacionEmpresa,String finalQueryGlobalEstadoActivoFijo,String finalQueryGlobalCliente,String finalQueryGlobalPartidaPresu) throws Exception {
		DetalleActivoFijoParameterReturnGeneral  detalleactivofijoReturnGeneral =new DetalleActivoFijoParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			detalleactivofijoReturnGeneral =new DetalleActivoFijoParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			detalleactivofijoReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			detalleactivofijoReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<DetalleGrupoActivoFijo> detallegrupoactivofijosForeignKey=new ArrayList<DetalleGrupoActivoFijo>();
			DetalleGrupoActivoFijoLogic detallegrupoactivofijoLogic=new DetalleGrupoActivoFijoLogic();
			detallegrupoactivofijoLogic.setConnexion(this.connexion);
			detallegrupoactivofijoLogic.getDetalleGrupoActivoFijoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalDetalleGrupoActivoFijo.equals("NONE")) {
				detallegrupoactivofijoLogic.getTodosDetalleGrupoActivoFijos(finalQueryGlobalDetalleGrupoActivoFijo,new Pagination());
				detallegrupoactivofijosForeignKey=detallegrupoactivofijoLogic.getDetalleGrupoActivoFijos();
			}

			detalleactivofijoReturnGeneral.setdetallegrupoactivofijosForeignKey(detallegrupoactivofijosForeignKey);


			List<SubGrupoActivoFijo> subgrupoactivofijosForeignKey=new ArrayList<SubGrupoActivoFijo>();
			SubGrupoActivoFijoLogic subgrupoactivofijoLogic=new SubGrupoActivoFijoLogic();
			subgrupoactivofijoLogic.setConnexion(this.connexion);
			subgrupoactivofijoLogic.getSubGrupoActivoFijoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSubGrupoActivoFijo.equals("NONE")) {
				subgrupoactivofijoLogic.getTodosSubGrupoActivoFijos(finalQueryGlobalSubGrupoActivoFijo,new Pagination());
				subgrupoactivofijosForeignKey=subgrupoactivofijoLogic.getSubGrupoActivoFijos();
			}

			detalleactivofijoReturnGeneral.setsubgrupoactivofijosForeignKey(subgrupoactivofijosForeignKey);


			List<TipoRamoActivoFijo> tiporamoactivofijosForeignKey=new ArrayList<TipoRamoActivoFijo>();
			TipoRamoActivoFijoLogic tiporamoactivofijoLogic=new TipoRamoActivoFijoLogic();
			tiporamoactivofijoLogic.setConnexion(this.connexion);
			tiporamoactivofijoLogic.getTipoRamoActivoFijoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoRamoActivoFijo.equals("NONE")) {
				tiporamoactivofijoLogic.getTodosTipoRamoActivoFijos(finalQueryGlobalTipoRamoActivoFijo,new Pagination());
				tiporamoactivofijosForeignKey=tiporamoactivofijoLogic.getTipoRamoActivoFijos();
			}

			detalleactivofijoReturnGeneral.settiporamoactivofijosForeignKey(tiporamoactivofijosForeignKey);


			List<TipoActivoFijoEmpresa> tipoactivofijoempresasForeignKey=new ArrayList<TipoActivoFijoEmpresa>();
			TipoActivoFijoEmpresaLogic tipoactivofijoempresaLogic=new TipoActivoFijoEmpresaLogic();
			tipoactivofijoempresaLogic.setConnexion(this.connexion);
			tipoactivofijoempresaLogic.getTipoActivoFijoEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoActivoFijoEmpresa.equals("NONE")) {
				tipoactivofijoempresaLogic.getTodosTipoActivoFijoEmpresas(finalQueryGlobalTipoActivoFijoEmpresa,new Pagination());
				tipoactivofijoempresasForeignKey=tipoactivofijoempresaLogic.getTipoActivoFijoEmpresas();
			}

			detalleactivofijoReturnGeneral.settipoactivofijoempresasForeignKey(tipoactivofijoempresasForeignKey);


			List<TipoDepreciacionEmpresa> tipodepreciacionempresasForeignKey=new ArrayList<TipoDepreciacionEmpresa>();
			TipoDepreciacionEmpresaLogic tipodepreciacionempresaLogic=new TipoDepreciacionEmpresaLogic();
			tipodepreciacionempresaLogic.setConnexion(this.connexion);
			tipodepreciacionempresaLogic.getTipoDepreciacionEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoDepreciacionEmpresa.equals("NONE")) {
				tipodepreciacionempresaLogic.getTodosTipoDepreciacionEmpresas(finalQueryGlobalTipoDepreciacionEmpresa,new Pagination());
				tipodepreciacionempresasForeignKey=tipodepreciacionempresaLogic.getTipoDepreciacionEmpresas();
			}

			detalleactivofijoReturnGeneral.settipodepreciacionempresasForeignKey(tipodepreciacionempresasForeignKey);


			List<EstadoActivoFijo> estadoactivofijosForeignKey=new ArrayList<EstadoActivoFijo>();
			EstadoActivoFijoLogic estadoactivofijoLogic=new EstadoActivoFijoLogic();
			estadoactivofijoLogic.setConnexion(this.connexion);
			estadoactivofijoLogic.getEstadoActivoFijoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEstadoActivoFijo.equals("NONE")) {
				estadoactivofijoLogic.getTodosEstadoActivoFijos(finalQueryGlobalEstadoActivoFijo,new Pagination());
				estadoactivofijosForeignKey=estadoactivofijoLogic.getEstadoActivoFijos();
			}

			detalleactivofijoReturnGeneral.setestadoactivofijosForeignKey(estadoactivofijosForeignKey);


			List<Cliente> clientesForeignKey=new ArrayList<Cliente>();
			ClienteLogic clienteLogic=new ClienteLogic();
			clienteLogic.setConnexion(this.connexion);
			clienteLogic.getClienteDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCliente.equals("NONE")) {
				clienteLogic.getTodosClientes(finalQueryGlobalCliente,new Pagination());
				clientesForeignKey=clienteLogic.getClientes();
			}

			detalleactivofijoReturnGeneral.setclientesForeignKey(clientesForeignKey);


			List<PartidaPresu> partidapresusForeignKey=new ArrayList<PartidaPresu>();
			PartidaPresuLogic partidapresuLogic=new PartidaPresuLogic();
			partidapresuLogic.setConnexion(this.connexion);
			partidapresuLogic.getPartidaPresuDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPartidaPresu.equals("NONE")) {
				partidapresuLogic.getTodosPartidaPresus(finalQueryGlobalPartidaPresu,new Pagination());
				partidapresusForeignKey=partidapresuLogic.getPartidaPresus();
			}

			detalleactivofijoReturnGeneral.setpartidapresusForeignKey(partidapresusForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return detalleactivofijoReturnGeneral;
	}
	
	public void cargarRelacionesLoteForeignKeyDetalleActivoFijoWithConnection() throws Exception {
		ArrayList<Classe> classes=new ArrayList<Classe>();		
		
		
			MantenimientoActivoFijoLogic mantenimientoactivofijoLogic=new MantenimientoActivoFijoLogic();
			ServicioTransporteLogic serviciotransporteLogic=new ServicioTransporteLogic();
			MovimientoActivoFijoLogic movimientoactivofijoLogic=new MovimientoActivoFijoLogic();
			VehiculoLogic vehiculoLogic=new VehiculoLogic();
			MetodoDepreciacionLogic metododepreciacionLogic=new MetodoDepreciacionLogic();
			ResponsableActivoFijoLogic responsableactivofijoLogic=new ResponsableActivoFijoLogic();
			DepreciacionActivoFijoLogic depreciacionactivofijoLogic=new DepreciacionActivoFijoLogic();
			GastoDepreciacionCentroCostoLogic gastodepreciacioncentrocostoLogic=new GastoDepreciacionCentroCostoLogic();
			ParteActivoFijoLogic parteactivofijoLogic=new ParteActivoFijoLogic();
		
		try {
			
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleActivoFijo.class.getSimpleName()+"-cargarRelacionesLoteForeignKeyDetalleActivoFijoWithConnection");connexion.begin();
			
			
			classes.add(new Classe(MantenimientoActivoFijo.class));
			classes.add(new Classe(ServicioTransporte.class));
			classes.add(new Classe(MovimientoActivoFijo.class));
			classes.add(new Classe(Vehiculo.class));
			classes.add(new Classe(MetodoDepreciacion.class));
			classes.add(new Classe(ResponsableActivoFijo.class));
			classes.add(new Classe(DepreciacionActivoFijo.class));
			classes.add(new Classe(GastoDepreciacionCentroCosto.class));
			classes.add(new Classe(ParteActivoFijo.class));
											
			

			mantenimientoactivofijoLogic.setConnexion(this.getConnexion());
			mantenimientoactivofijoLogic.setDatosCliente(this.datosCliente);
			mantenimientoactivofijoLogic.setIsConRefrescarForeignKeys(true);

			serviciotransporteLogic.setConnexion(this.getConnexion());
			serviciotransporteLogic.setDatosCliente(this.datosCliente);
			serviciotransporteLogic.setIsConRefrescarForeignKeys(true);

			movimientoactivofijoLogic.setConnexion(this.getConnexion());
			movimientoactivofijoLogic.setDatosCliente(this.datosCliente);
			movimientoactivofijoLogic.setIsConRefrescarForeignKeys(true);

			vehiculoLogic.setConnexion(this.getConnexion());
			vehiculoLogic.setDatosCliente(this.datosCliente);
			vehiculoLogic.setIsConRefrescarForeignKeys(true);

			metododepreciacionLogic.setConnexion(this.getConnexion());
			metododepreciacionLogic.setDatosCliente(this.datosCliente);
			metododepreciacionLogic.setIsConRefrescarForeignKeys(true);

			responsableactivofijoLogic.setConnexion(this.getConnexion());
			responsableactivofijoLogic.setDatosCliente(this.datosCliente);
			responsableactivofijoLogic.setIsConRefrescarForeignKeys(true);

			depreciacionactivofijoLogic.setConnexion(this.getConnexion());
			depreciacionactivofijoLogic.setDatosCliente(this.datosCliente);
			depreciacionactivofijoLogic.setIsConRefrescarForeignKeys(true);

			gastodepreciacioncentrocostoLogic.setConnexion(this.getConnexion());
			gastodepreciacioncentrocostoLogic.setDatosCliente(this.datosCliente);
			gastodepreciacioncentrocostoLogic.setIsConRefrescarForeignKeys(true);

			parteactivofijoLogic.setConnexion(this.getConnexion());
			parteactivofijoLogic.setDatosCliente(this.datosCliente);
			parteactivofijoLogic.setIsConRefrescarForeignKeys(true);
			
			this.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
			
			for(DetalleActivoFijo detalleactivofijo:this.detalleactivofijos) {
				

				classes=new ArrayList<Classe>();
				classes=MantenimientoActivoFijoConstantesFunciones.getClassesForeignKeysOfMantenimientoActivoFijo(new ArrayList<Classe>(),DeepLoadType.NONE);

				mantenimientoactivofijoLogic.setMantenimientoActivoFijos(detalleactivofijo.mantenimientoactivofijos);
				mantenimientoactivofijoLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=ServicioTransporteConstantesFunciones.getClassesForeignKeysOfServicioTransporte(new ArrayList<Classe>(),DeepLoadType.NONE);

				serviciotransporteLogic.setServicioTransportes(detalleactivofijo.serviciotransportes);
				serviciotransporteLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=MovimientoActivoFijoConstantesFunciones.getClassesForeignKeysOfMovimientoActivoFijo(new ArrayList<Classe>(),DeepLoadType.NONE);

				movimientoactivofijoLogic.setMovimientoActivoFijos(detalleactivofijo.movimientoactivofijoDestinos);
				movimientoactivofijoLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=VehiculoConstantesFunciones.getClassesForeignKeysOfVehiculo(new ArrayList<Classe>(),DeepLoadType.NONE);

				vehiculoLogic.setVehiculos(detalleactivofijo.vehiculos);
				vehiculoLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=MetodoDepreciacionConstantesFunciones.getClassesForeignKeysOfMetodoDepreciacion(new ArrayList<Classe>(),DeepLoadType.NONE);

				metododepreciacionLogic.setMetodoDepreciacions(detalleactivofijo.metododepreciacions);
				metododepreciacionLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=ResponsableActivoFijoConstantesFunciones.getClassesForeignKeysOfResponsableActivoFijo(new ArrayList<Classe>(),DeepLoadType.NONE);

				responsableactivofijoLogic.setResponsableActivoFijos(detalleactivofijo.responsableactivofijos);
				responsableactivofijoLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=DepreciacionActivoFijoConstantesFunciones.getClassesForeignKeysOfDepreciacionActivoFijo(new ArrayList<Classe>(),DeepLoadType.NONE);

				depreciacionactivofijoLogic.setDepreciacionActivoFijos(detalleactivofijo.depreciacionactivofijos);
				depreciacionactivofijoLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=GastoDepreciacionCentroCostoConstantesFunciones.getClassesForeignKeysOfGastoDepreciacionCentroCosto(new ArrayList<Classe>(),DeepLoadType.NONE);

				gastodepreciacioncentrocostoLogic.setGastoDepreciacionCentroCostos(detalleactivofijo.gastodepreciacioncentrocostos);
				gastodepreciacioncentrocostoLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=ParteActivoFijoConstantesFunciones.getClassesForeignKeysOfParteActivoFijo(new ArrayList<Classe>(),DeepLoadType.NONE);

				parteactivofijoLogic.setParteActivoFijos(detalleactivofijo.parteactivofijos);
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
	
	public void deepLoad(DetalleActivoFijo detalleactivofijo,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			DetalleActivoFijoLogicAdditional.updateDetalleActivoFijoToGet(detalleactivofijo,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		detalleactivofijo.setEmpresa(detalleactivofijoDataAccess.getEmpresa(connexion,detalleactivofijo));
		detalleactivofijo.setSucursal(detalleactivofijoDataAccess.getSucursal(connexion,detalleactivofijo));
		detalleactivofijo.setDetalleGrupoActivoFijo(detalleactivofijoDataAccess.getDetalleGrupoActivoFijo(connexion,detalleactivofijo));
		detalleactivofijo.setSubGrupoActivoFijo(detalleactivofijoDataAccess.getSubGrupoActivoFijo(connexion,detalleactivofijo));
		detalleactivofijo.setTipoRamoActivoFijo(detalleactivofijoDataAccess.getTipoRamoActivoFijo(connexion,detalleactivofijo));
		detalleactivofijo.setTipoActivoFijoEmpresa(detalleactivofijoDataAccess.getTipoActivoFijoEmpresa(connexion,detalleactivofijo));
		detalleactivofijo.setTipoDepreciacionEmpresa(detalleactivofijoDataAccess.getTipoDepreciacionEmpresa(connexion,detalleactivofijo));
		detalleactivofijo.setEstadoActivoFijo(detalleactivofijoDataAccess.getEstadoActivoFijo(connexion,detalleactivofijo));
		detalleactivofijo.setCliente(detalleactivofijoDataAccess.getCliente(connexion,detalleactivofijo));
		detalleactivofijo.setPartidaPresu(detalleactivofijoDataAccess.getPartidaPresu(connexion,detalleactivofijo));
		detalleactivofijo.setMantenimientoActivoFijos(detalleactivofijoDataAccess.getMantenimientoActivoFijos(connexion,detalleactivofijo));
		detalleactivofijo.setServicioTransportes(detalleactivofijoDataAccess.getServicioTransportes(connexion,detalleactivofijo));
		detalleactivofijo.setMovimientoActivoFijoDestinos(detalleactivofijoDataAccess.getMovimientoActivoFijoDestinos(connexion,detalleactivofijo));
		detalleactivofijo.setVehiculos(detalleactivofijoDataAccess.getVehiculos(connexion,detalleactivofijo));
		detalleactivofijo.setMetodoDepreciacions(detalleactivofijoDataAccess.getMetodoDepreciacions(connexion,detalleactivofijo));
		detalleactivofijo.setResponsableActivoFijos(detalleactivofijoDataAccess.getResponsableActivoFijos(connexion,detalleactivofijo));
		detalleactivofijo.setDepreciacionActivoFijos(detalleactivofijoDataAccess.getDepreciacionActivoFijos(connexion,detalleactivofijo));
		detalleactivofijo.setGastoDepreciacionCentroCostos(detalleactivofijoDataAccess.getGastoDepreciacionCentroCostos(connexion,detalleactivofijo));
		detalleactivofijo.setParteActivoFijos(detalleactivofijoDataAccess.getParteActivoFijos(connexion,detalleactivofijo));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				detalleactivofijo.setEmpresa(detalleactivofijoDataAccess.getEmpresa(connexion,detalleactivofijo));
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				detalleactivofijo.setSucursal(detalleactivofijoDataAccess.getSucursal(connexion,detalleactivofijo));
				continue;
			}

			if(clas.clas.equals(DetalleGrupoActivoFijo.class)) {
				detalleactivofijo.setDetalleGrupoActivoFijo(detalleactivofijoDataAccess.getDetalleGrupoActivoFijo(connexion,detalleactivofijo));
				continue;
			}

			if(clas.clas.equals(SubGrupoActivoFijo.class)) {
				detalleactivofijo.setSubGrupoActivoFijo(detalleactivofijoDataAccess.getSubGrupoActivoFijo(connexion,detalleactivofijo));
				continue;
			}

			if(clas.clas.equals(TipoRamoActivoFijo.class)) {
				detalleactivofijo.setTipoRamoActivoFijo(detalleactivofijoDataAccess.getTipoRamoActivoFijo(connexion,detalleactivofijo));
				continue;
			}

			if(clas.clas.equals(TipoActivoFijoEmpresa.class)) {
				detalleactivofijo.setTipoActivoFijoEmpresa(detalleactivofijoDataAccess.getTipoActivoFijoEmpresa(connexion,detalleactivofijo));
				continue;
			}

			if(clas.clas.equals(TipoDepreciacionEmpresa.class)) {
				detalleactivofijo.setTipoDepreciacionEmpresa(detalleactivofijoDataAccess.getTipoDepreciacionEmpresa(connexion,detalleactivofijo));
				continue;
			}

			if(clas.clas.equals(EstadoActivoFijo.class)) {
				detalleactivofijo.setEstadoActivoFijo(detalleactivofijoDataAccess.getEstadoActivoFijo(connexion,detalleactivofijo));
				continue;
			}

			if(clas.clas.equals(Cliente.class)) {
				detalleactivofijo.setCliente(detalleactivofijoDataAccess.getCliente(connexion,detalleactivofijo));
				continue;
			}

			if(clas.clas.equals(PartidaPresu.class)) {
				detalleactivofijo.setPartidaPresu(detalleactivofijoDataAccess.getPartidaPresu(connexion,detalleactivofijo));
				continue;
			}

			if(clas.clas.equals(MantenimientoActivoFijo.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				detalleactivofijo.setMantenimientoActivoFijos(detalleactivofijoDataAccess.getMantenimientoActivoFijos(connexion,detalleactivofijo));

				if(this.isConDeep) {
					MantenimientoActivoFijoLogic mantenimientoactivofijoLogic= new MantenimientoActivoFijoLogic(this.connexion);
					mantenimientoactivofijoLogic.setMantenimientoActivoFijos(detalleactivofijo.getMantenimientoActivoFijos());
					ArrayList<Classe> classesLocal=MantenimientoActivoFijoConstantesFunciones.getClassesForeignKeysOfMantenimientoActivoFijo(new ArrayList<Classe>(),DeepLoadType.NONE);
					mantenimientoactivofijoLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					MantenimientoActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesMantenimientoActivoFijo(mantenimientoactivofijoLogic.getMantenimientoActivoFijos());
					detalleactivofijo.setMantenimientoActivoFijos(mantenimientoactivofijoLogic.getMantenimientoActivoFijos());
				}

				continue;
			}

			if(clas.clas.equals(ServicioTransporte.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				detalleactivofijo.setServicioTransportes(detalleactivofijoDataAccess.getServicioTransportes(connexion,detalleactivofijo));

				if(this.isConDeep) {
					ServicioTransporteLogic serviciotransporteLogic= new ServicioTransporteLogic(this.connexion);
					serviciotransporteLogic.setServicioTransportes(detalleactivofijo.getServicioTransportes());
					ArrayList<Classe> classesLocal=ServicioTransporteConstantesFunciones.getClassesForeignKeysOfServicioTransporte(new ArrayList<Classe>(),DeepLoadType.NONE);
					serviciotransporteLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					ServicioTransporteConstantesFunciones.refrescarForeignKeysDescripcionesServicioTransporte(serviciotransporteLogic.getServicioTransportes());
					detalleactivofijo.setServicioTransportes(serviciotransporteLogic.getServicioTransportes());
				}

				continue;
			}

			if(clas.clas.equals(MovimientoActivoFijo.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				detalleactivofijo.setMovimientoActivoFijoDestinos(detalleactivofijoDataAccess.getMovimientoActivoFijoDestinos(connexion,detalleactivofijo));

				if(this.isConDeep) {
					MovimientoActivoFijoLogic movimientoactivofijoLogic= new MovimientoActivoFijoLogic(this.connexion);
					movimientoactivofijoLogic.setMovimientoActivoFijos(detalleactivofijo.getMovimientoActivoFijoDestinos());
					ArrayList<Classe> classesLocal=MovimientoActivoFijoConstantesFunciones.getClassesForeignKeysOfMovimientoActivoFijo(new ArrayList<Classe>(),DeepLoadType.NONE);
					movimientoactivofijoLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					MovimientoActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesMovimientoActivoFijo(movimientoactivofijoLogic.getMovimientoActivoFijos());
					detalleactivofijo.setMovimientoActivoFijoDestinos(movimientoactivofijoLogic.getMovimientoActivoFijos());
				}

				continue;
			}

			if(clas.clas.equals(Vehiculo.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				detalleactivofijo.setVehiculos(detalleactivofijoDataAccess.getVehiculos(connexion,detalleactivofijo));

				if(this.isConDeep) {
					VehiculoLogic vehiculoLogic= new VehiculoLogic(this.connexion);
					vehiculoLogic.setVehiculos(detalleactivofijo.getVehiculos());
					ArrayList<Classe> classesLocal=VehiculoConstantesFunciones.getClassesForeignKeysOfVehiculo(new ArrayList<Classe>(),DeepLoadType.NONE);
					vehiculoLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					VehiculoConstantesFunciones.refrescarForeignKeysDescripcionesVehiculo(vehiculoLogic.getVehiculos());
					detalleactivofijo.setVehiculos(vehiculoLogic.getVehiculos());
				}

				continue;
			}

			if(clas.clas.equals(MetodoDepreciacion.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				detalleactivofijo.setMetodoDepreciacions(detalleactivofijoDataAccess.getMetodoDepreciacions(connexion,detalleactivofijo));

				if(this.isConDeep) {
					MetodoDepreciacionLogic metododepreciacionLogic= new MetodoDepreciacionLogic(this.connexion);
					metododepreciacionLogic.setMetodoDepreciacions(detalleactivofijo.getMetodoDepreciacions());
					ArrayList<Classe> classesLocal=MetodoDepreciacionConstantesFunciones.getClassesForeignKeysOfMetodoDepreciacion(new ArrayList<Classe>(),DeepLoadType.NONE);
					metododepreciacionLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					MetodoDepreciacionConstantesFunciones.refrescarForeignKeysDescripcionesMetodoDepreciacion(metododepreciacionLogic.getMetodoDepreciacions());
					detalleactivofijo.setMetodoDepreciacions(metododepreciacionLogic.getMetodoDepreciacions());
				}

				continue;
			}

			if(clas.clas.equals(ResponsableActivoFijo.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				detalleactivofijo.setResponsableActivoFijos(detalleactivofijoDataAccess.getResponsableActivoFijos(connexion,detalleactivofijo));

				if(this.isConDeep) {
					ResponsableActivoFijoLogic responsableactivofijoLogic= new ResponsableActivoFijoLogic(this.connexion);
					responsableactivofijoLogic.setResponsableActivoFijos(detalleactivofijo.getResponsableActivoFijos());
					ArrayList<Classe> classesLocal=ResponsableActivoFijoConstantesFunciones.getClassesForeignKeysOfResponsableActivoFijo(new ArrayList<Classe>(),DeepLoadType.NONE);
					responsableactivofijoLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					ResponsableActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesResponsableActivoFijo(responsableactivofijoLogic.getResponsableActivoFijos());
					detalleactivofijo.setResponsableActivoFijos(responsableactivofijoLogic.getResponsableActivoFijos());
				}

				continue;
			}

			if(clas.clas.equals(DepreciacionActivoFijo.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				detalleactivofijo.setDepreciacionActivoFijos(detalleactivofijoDataAccess.getDepreciacionActivoFijos(connexion,detalleactivofijo));

				if(this.isConDeep) {
					DepreciacionActivoFijoLogic depreciacionactivofijoLogic= new DepreciacionActivoFijoLogic(this.connexion);
					depreciacionactivofijoLogic.setDepreciacionActivoFijos(detalleactivofijo.getDepreciacionActivoFijos());
					ArrayList<Classe> classesLocal=DepreciacionActivoFijoConstantesFunciones.getClassesForeignKeysOfDepreciacionActivoFijo(new ArrayList<Classe>(),DeepLoadType.NONE);
					depreciacionactivofijoLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					DepreciacionActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesDepreciacionActivoFijo(depreciacionactivofijoLogic.getDepreciacionActivoFijos());
					detalleactivofijo.setDepreciacionActivoFijos(depreciacionactivofijoLogic.getDepreciacionActivoFijos());
				}

				continue;
			}

			if(clas.clas.equals(GastoDepreciacionCentroCosto.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				detalleactivofijo.setGastoDepreciacionCentroCostos(detalleactivofijoDataAccess.getGastoDepreciacionCentroCostos(connexion,detalleactivofijo));

				if(this.isConDeep) {
					GastoDepreciacionCentroCostoLogic gastodepreciacioncentrocostoLogic= new GastoDepreciacionCentroCostoLogic(this.connexion);
					gastodepreciacioncentrocostoLogic.setGastoDepreciacionCentroCostos(detalleactivofijo.getGastoDepreciacionCentroCostos());
					ArrayList<Classe> classesLocal=GastoDepreciacionCentroCostoConstantesFunciones.getClassesForeignKeysOfGastoDepreciacionCentroCosto(new ArrayList<Classe>(),DeepLoadType.NONE);
					gastodepreciacioncentrocostoLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					GastoDepreciacionCentroCostoConstantesFunciones.refrescarForeignKeysDescripcionesGastoDepreciacionCentroCosto(gastodepreciacioncentrocostoLogic.getGastoDepreciacionCentroCostos());
					detalleactivofijo.setGastoDepreciacionCentroCostos(gastodepreciacioncentrocostoLogic.getGastoDepreciacionCentroCostos());
				}

				continue;
			}

			if(clas.clas.equals(ParteActivoFijo.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				detalleactivofijo.setParteActivoFijos(detalleactivofijoDataAccess.getParteActivoFijos(connexion,detalleactivofijo));

				if(this.isConDeep) {
					ParteActivoFijoLogic parteactivofijoLogic= new ParteActivoFijoLogic(this.connexion);
					parteactivofijoLogic.setParteActivoFijos(detalleactivofijo.getParteActivoFijos());
					ArrayList<Classe> classesLocal=ParteActivoFijoConstantesFunciones.getClassesForeignKeysOfParteActivoFijo(new ArrayList<Classe>(),DeepLoadType.NONE);
					parteactivofijoLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					ParteActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesParteActivoFijo(parteactivofijoLogic.getParteActivoFijos());
					detalleactivofijo.setParteActivoFijos(parteactivofijoLogic.getParteActivoFijos());
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
			detalleactivofijo.setEmpresa(detalleactivofijoDataAccess.getEmpresa(connexion,detalleactivofijo));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalleactivofijo.setSucursal(detalleactivofijoDataAccess.getSucursal(connexion,detalleactivofijo));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(DetalleGrupoActivoFijo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalleactivofijo.setDetalleGrupoActivoFijo(detalleactivofijoDataAccess.getDetalleGrupoActivoFijo(connexion,detalleactivofijo));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(SubGrupoActivoFijo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalleactivofijo.setSubGrupoActivoFijo(detalleactivofijoDataAccess.getSubGrupoActivoFijo(connexion,detalleactivofijo));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoRamoActivoFijo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalleactivofijo.setTipoRamoActivoFijo(detalleactivofijoDataAccess.getTipoRamoActivoFijo(connexion,detalleactivofijo));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoActivoFijoEmpresa.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalleactivofijo.setTipoActivoFijoEmpresa(detalleactivofijoDataAccess.getTipoActivoFijoEmpresa(connexion,detalleactivofijo));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoDepreciacionEmpresa.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalleactivofijo.setTipoDepreciacionEmpresa(detalleactivofijoDataAccess.getTipoDepreciacionEmpresa(connexion,detalleactivofijo));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(EstadoActivoFijo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalleactivofijo.setEstadoActivoFijo(detalleactivofijoDataAccess.getEstadoActivoFijo(connexion,detalleactivofijo));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Cliente.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalleactivofijo.setCliente(detalleactivofijoDataAccess.getCliente(connexion,detalleactivofijo));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(PartidaPresu.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalleactivofijo.setPartidaPresu(detalleactivofijoDataAccess.getPartidaPresu(connexion,detalleactivofijo));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(MantenimientoActivoFijo.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(MantenimientoActivoFijo.class));
			detalleactivofijo.setMantenimientoActivoFijos(detalleactivofijoDataAccess.getMantenimientoActivoFijos(connexion,detalleactivofijo));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(ServicioTransporte.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(ServicioTransporte.class));
			detalleactivofijo.setServicioTransportes(detalleactivofijoDataAccess.getServicioTransportes(connexion,detalleactivofijo));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(MovimientoActivoFijo.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(MovimientoActivoFijo.class));
			detalleactivofijo.setMovimientoActivoFijoDestinos(detalleactivofijoDataAccess.getMovimientoActivoFijoDestinos(connexion,detalleactivofijo));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Vehiculo.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(Vehiculo.class));
			detalleactivofijo.setVehiculos(detalleactivofijoDataAccess.getVehiculos(connexion,detalleactivofijo));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(MetodoDepreciacion.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(MetodoDepreciacion.class));
			detalleactivofijo.setMetodoDepreciacions(detalleactivofijoDataAccess.getMetodoDepreciacions(connexion,detalleactivofijo));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(ResponsableActivoFijo.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(ResponsableActivoFijo.class));
			detalleactivofijo.setResponsableActivoFijos(detalleactivofijoDataAccess.getResponsableActivoFijos(connexion,detalleactivofijo));
		}

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
			detalleactivofijo.setDepreciacionActivoFijos(detalleactivofijoDataAccess.getDepreciacionActivoFijos(connexion,detalleactivofijo));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(GastoDepreciacionCentroCosto.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(GastoDepreciacionCentroCosto.class));
			detalleactivofijo.setGastoDepreciacionCentroCostos(detalleactivofijoDataAccess.getGastoDepreciacionCentroCostos(connexion,detalleactivofijo));
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
			detalleactivofijo.setParteActivoFijos(detalleactivofijoDataAccess.getParteActivoFijos(connexion,detalleactivofijo));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		detalleactivofijo.setEmpresa(detalleactivofijoDataAccess.getEmpresa(connexion,detalleactivofijo));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(detalleactivofijo.getEmpresa(),isDeep,deepLoadType,clases);
				
		detalleactivofijo.setSucursal(detalleactivofijoDataAccess.getSucursal(connexion,detalleactivofijo));
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(detalleactivofijo.getSucursal(),isDeep,deepLoadType,clases);
				
		detalleactivofijo.setDetalleGrupoActivoFijo(detalleactivofijoDataAccess.getDetalleGrupoActivoFijo(connexion,detalleactivofijo));
		DetalleGrupoActivoFijoLogic detallegrupoactivofijoLogic= new DetalleGrupoActivoFijoLogic(connexion);
		detallegrupoactivofijoLogic.deepLoad(detalleactivofijo.getDetalleGrupoActivoFijo(),isDeep,deepLoadType,clases);
				
		detalleactivofijo.setSubGrupoActivoFijo(detalleactivofijoDataAccess.getSubGrupoActivoFijo(connexion,detalleactivofijo));
		SubGrupoActivoFijoLogic subgrupoactivofijoLogic= new SubGrupoActivoFijoLogic(connexion);
		subgrupoactivofijoLogic.deepLoad(detalleactivofijo.getSubGrupoActivoFijo(),isDeep,deepLoadType,clases);
				
		detalleactivofijo.setTipoRamoActivoFijo(detalleactivofijoDataAccess.getTipoRamoActivoFijo(connexion,detalleactivofijo));
		TipoRamoActivoFijoLogic tiporamoactivofijoLogic= new TipoRamoActivoFijoLogic(connexion);
		tiporamoactivofijoLogic.deepLoad(detalleactivofijo.getTipoRamoActivoFijo(),isDeep,deepLoadType,clases);
				
		detalleactivofijo.setTipoActivoFijoEmpresa(detalleactivofijoDataAccess.getTipoActivoFijoEmpresa(connexion,detalleactivofijo));
		TipoActivoFijoEmpresaLogic tipoactivofijoempresaLogic= new TipoActivoFijoEmpresaLogic(connexion);
		tipoactivofijoempresaLogic.deepLoad(detalleactivofijo.getTipoActivoFijoEmpresa(),isDeep,deepLoadType,clases);
				
		detalleactivofijo.setTipoDepreciacionEmpresa(detalleactivofijoDataAccess.getTipoDepreciacionEmpresa(connexion,detalleactivofijo));
		TipoDepreciacionEmpresaLogic tipodepreciacionempresaLogic= new TipoDepreciacionEmpresaLogic(connexion);
		tipodepreciacionempresaLogic.deepLoad(detalleactivofijo.getTipoDepreciacionEmpresa(),isDeep,deepLoadType,clases);
				
		detalleactivofijo.setEstadoActivoFijo(detalleactivofijoDataAccess.getEstadoActivoFijo(connexion,detalleactivofijo));
		EstadoActivoFijoLogic estadoactivofijoLogic= new EstadoActivoFijoLogic(connexion);
		estadoactivofijoLogic.deepLoad(detalleactivofijo.getEstadoActivoFijo(),isDeep,deepLoadType,clases);
				
		detalleactivofijo.setCliente(detalleactivofijoDataAccess.getCliente(connexion,detalleactivofijo));
		ClienteLogic clienteLogic= new ClienteLogic(connexion);
		clienteLogic.deepLoad(detalleactivofijo.getCliente(),isDeep,deepLoadType,clases);
				
		detalleactivofijo.setPartidaPresu(detalleactivofijoDataAccess.getPartidaPresu(connexion,detalleactivofijo));
		PartidaPresuLogic partidapresuLogic= new PartidaPresuLogic(connexion);
		partidapresuLogic.deepLoad(detalleactivofijo.getPartidaPresu(),isDeep,deepLoadType,clases);
				

		detalleactivofijo.setMantenimientoActivoFijos(detalleactivofijoDataAccess.getMantenimientoActivoFijos(connexion,detalleactivofijo));

		for(MantenimientoActivoFijo mantenimientoactivofijo:detalleactivofijo.getMantenimientoActivoFijos()) {
			MantenimientoActivoFijoLogic mantenimientoactivofijoLogic= new MantenimientoActivoFijoLogic(connexion);
			mantenimientoactivofijoLogic.deepLoad(mantenimientoactivofijo,isDeep,deepLoadType,clases);
		}

		detalleactivofijo.setServicioTransportes(detalleactivofijoDataAccess.getServicioTransportes(connexion,detalleactivofijo));

		for(ServicioTransporte serviciotransporte:detalleactivofijo.getServicioTransportes()) {
			ServicioTransporteLogic serviciotransporteLogic= new ServicioTransporteLogic(connexion);
			serviciotransporteLogic.deepLoad(serviciotransporte,isDeep,deepLoadType,clases);
		}

		detalleactivofijo.setMovimientoActivoFijoDestinos(detalleactivofijoDataAccess.getMovimientoActivoFijoDestinos(connexion,detalleactivofijo));

		for(MovimientoActivoFijo movimientoactivofijo:detalleactivofijo.getMovimientoActivoFijoDestinos()) {
			MovimientoActivoFijoLogic movimientoactivofijoLogic= new MovimientoActivoFijoLogic(connexion);
			movimientoactivofijoLogic.deepLoad(movimientoactivofijo,isDeep,deepLoadType,clases);
		}

		detalleactivofijo.setVehiculos(detalleactivofijoDataAccess.getVehiculos(connexion,detalleactivofijo));

		for(Vehiculo vehiculo:detalleactivofijo.getVehiculos()) {
			VehiculoLogic vehiculoLogic= new VehiculoLogic(connexion);
			vehiculoLogic.deepLoad(vehiculo,isDeep,deepLoadType,clases);
		}

		detalleactivofijo.setMetodoDepreciacions(detalleactivofijoDataAccess.getMetodoDepreciacions(connexion,detalleactivofijo));

		for(MetodoDepreciacion metododepreciacion:detalleactivofijo.getMetodoDepreciacions()) {
			MetodoDepreciacionLogic metododepreciacionLogic= new MetodoDepreciacionLogic(connexion);
			metododepreciacionLogic.deepLoad(metododepreciacion,isDeep,deepLoadType,clases);
		}

		detalleactivofijo.setResponsableActivoFijos(detalleactivofijoDataAccess.getResponsableActivoFijos(connexion,detalleactivofijo));

		for(ResponsableActivoFijo responsableactivofijo:detalleactivofijo.getResponsableActivoFijos()) {
			ResponsableActivoFijoLogic responsableactivofijoLogic= new ResponsableActivoFijoLogic(connexion);
			responsableactivofijoLogic.deepLoad(responsableactivofijo,isDeep,deepLoadType,clases);
		}

		detalleactivofijo.setDepreciacionActivoFijos(detalleactivofijoDataAccess.getDepreciacionActivoFijos(connexion,detalleactivofijo));

		for(DepreciacionActivoFijo depreciacionactivofijo:detalleactivofijo.getDepreciacionActivoFijos()) {
			DepreciacionActivoFijoLogic depreciacionactivofijoLogic= new DepreciacionActivoFijoLogic(connexion);
			depreciacionactivofijoLogic.deepLoad(depreciacionactivofijo,isDeep,deepLoadType,clases);
		}

		detalleactivofijo.setGastoDepreciacionCentroCostos(detalleactivofijoDataAccess.getGastoDepreciacionCentroCostos(connexion,detalleactivofijo));

		for(GastoDepreciacionCentroCosto gastodepreciacioncentrocosto:detalleactivofijo.getGastoDepreciacionCentroCostos()) {
			GastoDepreciacionCentroCostoLogic gastodepreciacioncentrocostoLogic= new GastoDepreciacionCentroCostoLogic(connexion);
			gastodepreciacioncentrocostoLogic.deepLoad(gastodepreciacioncentrocosto,isDeep,deepLoadType,clases);
		}

		detalleactivofijo.setParteActivoFijos(detalleactivofijoDataAccess.getParteActivoFijos(connexion,detalleactivofijo));

		for(ParteActivoFijo parteactivofijo:detalleactivofijo.getParteActivoFijos()) {
			ParteActivoFijoLogic parteactivofijoLogic= new ParteActivoFijoLogic(connexion);
			parteactivofijoLogic.deepLoad(parteactivofijo,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				detalleactivofijo.setEmpresa(detalleactivofijoDataAccess.getEmpresa(connexion,detalleactivofijo));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(detalleactivofijo.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				detalleactivofijo.setSucursal(detalleactivofijoDataAccess.getSucursal(connexion,detalleactivofijo));
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepLoad(detalleactivofijo.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(DetalleGrupoActivoFijo.class)) {
				detalleactivofijo.setDetalleGrupoActivoFijo(detalleactivofijoDataAccess.getDetalleGrupoActivoFijo(connexion,detalleactivofijo));
				DetalleGrupoActivoFijoLogic detallegrupoactivofijoLogic= new DetalleGrupoActivoFijoLogic(connexion);
				detallegrupoactivofijoLogic.deepLoad(detalleactivofijo.getDetalleGrupoActivoFijo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(SubGrupoActivoFijo.class)) {
				detalleactivofijo.setSubGrupoActivoFijo(detalleactivofijoDataAccess.getSubGrupoActivoFijo(connexion,detalleactivofijo));
				SubGrupoActivoFijoLogic subgrupoactivofijoLogic= new SubGrupoActivoFijoLogic(connexion);
				subgrupoactivofijoLogic.deepLoad(detalleactivofijo.getSubGrupoActivoFijo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoRamoActivoFijo.class)) {
				detalleactivofijo.setTipoRamoActivoFijo(detalleactivofijoDataAccess.getTipoRamoActivoFijo(connexion,detalleactivofijo));
				TipoRamoActivoFijoLogic tiporamoactivofijoLogic= new TipoRamoActivoFijoLogic(connexion);
				tiporamoactivofijoLogic.deepLoad(detalleactivofijo.getTipoRamoActivoFijo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoActivoFijoEmpresa.class)) {
				detalleactivofijo.setTipoActivoFijoEmpresa(detalleactivofijoDataAccess.getTipoActivoFijoEmpresa(connexion,detalleactivofijo));
				TipoActivoFijoEmpresaLogic tipoactivofijoempresaLogic= new TipoActivoFijoEmpresaLogic(connexion);
				tipoactivofijoempresaLogic.deepLoad(detalleactivofijo.getTipoActivoFijoEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoDepreciacionEmpresa.class)) {
				detalleactivofijo.setTipoDepreciacionEmpresa(detalleactivofijoDataAccess.getTipoDepreciacionEmpresa(connexion,detalleactivofijo));
				TipoDepreciacionEmpresaLogic tipodepreciacionempresaLogic= new TipoDepreciacionEmpresaLogic(connexion);
				tipodepreciacionempresaLogic.deepLoad(detalleactivofijo.getTipoDepreciacionEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(EstadoActivoFijo.class)) {
				detalleactivofijo.setEstadoActivoFijo(detalleactivofijoDataAccess.getEstadoActivoFijo(connexion,detalleactivofijo));
				EstadoActivoFijoLogic estadoactivofijoLogic= new EstadoActivoFijoLogic(connexion);
				estadoactivofijoLogic.deepLoad(detalleactivofijo.getEstadoActivoFijo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Cliente.class)) {
				detalleactivofijo.setCliente(detalleactivofijoDataAccess.getCliente(connexion,detalleactivofijo));
				ClienteLogic clienteLogic= new ClienteLogic(connexion);
				clienteLogic.deepLoad(detalleactivofijo.getCliente(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(PartidaPresu.class)) {
				detalleactivofijo.setPartidaPresu(detalleactivofijoDataAccess.getPartidaPresu(connexion,detalleactivofijo));
				PartidaPresuLogic partidapresuLogic= new PartidaPresuLogic(connexion);
				partidapresuLogic.deepLoad(detalleactivofijo.getPartidaPresu(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(MantenimientoActivoFijo.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				detalleactivofijo.setMantenimientoActivoFijos(detalleactivofijoDataAccess.getMantenimientoActivoFijos(connexion,detalleactivofijo));

				for(MantenimientoActivoFijo mantenimientoactivofijo:detalleactivofijo.getMantenimientoActivoFijos()) {
					MantenimientoActivoFijoLogic mantenimientoactivofijoLogic= new MantenimientoActivoFijoLogic(connexion);
					mantenimientoactivofijoLogic.deepLoad(mantenimientoactivofijo,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(ServicioTransporte.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				detalleactivofijo.setServicioTransportes(detalleactivofijoDataAccess.getServicioTransportes(connexion,detalleactivofijo));

				for(ServicioTransporte serviciotransporte:detalleactivofijo.getServicioTransportes()) {
					ServicioTransporteLogic serviciotransporteLogic= new ServicioTransporteLogic(connexion);
					serviciotransporteLogic.deepLoad(serviciotransporte,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(MovimientoActivoFijo.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				detalleactivofijo.setMovimientoActivoFijoDestinos(detalleactivofijoDataAccess.getMovimientoActivoFijoDestinos(connexion,detalleactivofijo));

				for(MovimientoActivoFijo movimientoactivofijo:detalleactivofijo.getMovimientoActivoFijoDestinos()) {
					MovimientoActivoFijoLogic movimientoactivofijoLogic= new MovimientoActivoFijoLogic(connexion);
					movimientoactivofijoLogic.deepLoad(movimientoactivofijo,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(Vehiculo.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				detalleactivofijo.setVehiculos(detalleactivofijoDataAccess.getVehiculos(connexion,detalleactivofijo));

				for(Vehiculo vehiculo:detalleactivofijo.getVehiculos()) {
					VehiculoLogic vehiculoLogic= new VehiculoLogic(connexion);
					vehiculoLogic.deepLoad(vehiculo,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(MetodoDepreciacion.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				detalleactivofijo.setMetodoDepreciacions(detalleactivofijoDataAccess.getMetodoDepreciacions(connexion,detalleactivofijo));

				for(MetodoDepreciacion metododepreciacion:detalleactivofijo.getMetodoDepreciacions()) {
					MetodoDepreciacionLogic metododepreciacionLogic= new MetodoDepreciacionLogic(connexion);
					metododepreciacionLogic.deepLoad(metododepreciacion,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(ResponsableActivoFijo.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				detalleactivofijo.setResponsableActivoFijos(detalleactivofijoDataAccess.getResponsableActivoFijos(connexion,detalleactivofijo));

				for(ResponsableActivoFijo responsableactivofijo:detalleactivofijo.getResponsableActivoFijos()) {
					ResponsableActivoFijoLogic responsableactivofijoLogic= new ResponsableActivoFijoLogic(connexion);
					responsableactivofijoLogic.deepLoad(responsableactivofijo,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(DepreciacionActivoFijo.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				detalleactivofijo.setDepreciacionActivoFijos(detalleactivofijoDataAccess.getDepreciacionActivoFijos(connexion,detalleactivofijo));

				for(DepreciacionActivoFijo depreciacionactivofijo:detalleactivofijo.getDepreciacionActivoFijos()) {
					DepreciacionActivoFijoLogic depreciacionactivofijoLogic= new DepreciacionActivoFijoLogic(connexion);
					depreciacionactivofijoLogic.deepLoad(depreciacionactivofijo,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(GastoDepreciacionCentroCosto.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				detalleactivofijo.setGastoDepreciacionCentroCostos(detalleactivofijoDataAccess.getGastoDepreciacionCentroCostos(connexion,detalleactivofijo));

				for(GastoDepreciacionCentroCosto gastodepreciacioncentrocosto:detalleactivofijo.getGastoDepreciacionCentroCostos()) {
					GastoDepreciacionCentroCostoLogic gastodepreciacioncentrocostoLogic= new GastoDepreciacionCentroCostoLogic(connexion);
					gastodepreciacioncentrocostoLogic.deepLoad(gastodepreciacioncentrocosto,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(ParteActivoFijo.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				detalleactivofijo.setParteActivoFijos(detalleactivofijoDataAccess.getParteActivoFijos(connexion,detalleactivofijo));

				for(ParteActivoFijo parteactivofijo:detalleactivofijo.getParteActivoFijos()) {
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
			detalleactivofijo.setEmpresa(detalleactivofijoDataAccess.getEmpresa(connexion,detalleactivofijo));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(detalleactivofijo.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalleactivofijo.setSucursal(detalleactivofijoDataAccess.getSucursal(connexion,detalleactivofijo));
			SucursalLogic sucursalLogic= new SucursalLogic(connexion);
			sucursalLogic.deepLoad(detalleactivofijo.getSucursal(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(DetalleGrupoActivoFijo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalleactivofijo.setDetalleGrupoActivoFijo(detalleactivofijoDataAccess.getDetalleGrupoActivoFijo(connexion,detalleactivofijo));
			DetalleGrupoActivoFijoLogic detallegrupoactivofijoLogic= new DetalleGrupoActivoFijoLogic(connexion);
			detallegrupoactivofijoLogic.deepLoad(detalleactivofijo.getDetalleGrupoActivoFijo(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(SubGrupoActivoFijo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalleactivofijo.setSubGrupoActivoFijo(detalleactivofijoDataAccess.getSubGrupoActivoFijo(connexion,detalleactivofijo));
			SubGrupoActivoFijoLogic subgrupoactivofijoLogic= new SubGrupoActivoFijoLogic(connexion);
			subgrupoactivofijoLogic.deepLoad(detalleactivofijo.getSubGrupoActivoFijo(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoRamoActivoFijo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalleactivofijo.setTipoRamoActivoFijo(detalleactivofijoDataAccess.getTipoRamoActivoFijo(connexion,detalleactivofijo));
			TipoRamoActivoFijoLogic tiporamoactivofijoLogic= new TipoRamoActivoFijoLogic(connexion);
			tiporamoactivofijoLogic.deepLoad(detalleactivofijo.getTipoRamoActivoFijo(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoActivoFijoEmpresa.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalleactivofijo.setTipoActivoFijoEmpresa(detalleactivofijoDataAccess.getTipoActivoFijoEmpresa(connexion,detalleactivofijo));
			TipoActivoFijoEmpresaLogic tipoactivofijoempresaLogic= new TipoActivoFijoEmpresaLogic(connexion);
			tipoactivofijoempresaLogic.deepLoad(detalleactivofijo.getTipoActivoFijoEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoDepreciacionEmpresa.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalleactivofijo.setTipoDepreciacionEmpresa(detalleactivofijoDataAccess.getTipoDepreciacionEmpresa(connexion,detalleactivofijo));
			TipoDepreciacionEmpresaLogic tipodepreciacionempresaLogic= new TipoDepreciacionEmpresaLogic(connexion);
			tipodepreciacionempresaLogic.deepLoad(detalleactivofijo.getTipoDepreciacionEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(EstadoActivoFijo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalleactivofijo.setEstadoActivoFijo(detalleactivofijoDataAccess.getEstadoActivoFijo(connexion,detalleactivofijo));
			EstadoActivoFijoLogic estadoactivofijoLogic= new EstadoActivoFijoLogic(connexion);
			estadoactivofijoLogic.deepLoad(detalleactivofijo.getEstadoActivoFijo(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Cliente.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalleactivofijo.setCliente(detalleactivofijoDataAccess.getCliente(connexion,detalleactivofijo));
			ClienteLogic clienteLogic= new ClienteLogic(connexion);
			clienteLogic.deepLoad(detalleactivofijo.getCliente(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(PartidaPresu.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalleactivofijo.setPartidaPresu(detalleactivofijoDataAccess.getPartidaPresu(connexion,detalleactivofijo));
			PartidaPresuLogic partidapresuLogic= new PartidaPresuLogic(connexion);
			partidapresuLogic.deepLoad(detalleactivofijo.getPartidaPresu(),isDeep,deepLoadType,clases);
				
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(MantenimientoActivoFijo.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(MantenimientoActivoFijo.class));
			detalleactivofijo.setMantenimientoActivoFijos(detalleactivofijoDataAccess.getMantenimientoActivoFijos(connexion,detalleactivofijo));

			for(MantenimientoActivoFijo mantenimientoactivofijo:detalleactivofijo.getMantenimientoActivoFijos()) {
				MantenimientoActivoFijoLogic mantenimientoactivofijoLogic= new MantenimientoActivoFijoLogic(connexion);
				mantenimientoactivofijoLogic.deepLoad(mantenimientoactivofijo,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(ServicioTransporte.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(ServicioTransporte.class));
			detalleactivofijo.setServicioTransportes(detalleactivofijoDataAccess.getServicioTransportes(connexion,detalleactivofijo));

			for(ServicioTransporte serviciotransporte:detalleactivofijo.getServicioTransportes()) {
				ServicioTransporteLogic serviciotransporteLogic= new ServicioTransporteLogic(connexion);
				serviciotransporteLogic.deepLoad(serviciotransporte,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(MovimientoActivoFijo.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(MovimientoActivoFijo.class));
			detalleactivofijo.setMovimientoActivoFijoDestinos(detalleactivofijoDataAccess.getMovimientoActivoFijoDestinos(connexion,detalleactivofijo));

			for(MovimientoActivoFijo movimientoactivofijo:detalleactivofijo.getMovimientoActivoFijoDestinos()) {
				MovimientoActivoFijoLogic movimientoactivofijoLogic= new MovimientoActivoFijoLogic(connexion);
				movimientoactivofijoLogic.deepLoad(movimientoactivofijo,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Vehiculo.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(Vehiculo.class));
			detalleactivofijo.setVehiculos(detalleactivofijoDataAccess.getVehiculos(connexion,detalleactivofijo));

			for(Vehiculo vehiculo:detalleactivofijo.getVehiculos()) {
				VehiculoLogic vehiculoLogic= new VehiculoLogic(connexion);
				vehiculoLogic.deepLoad(vehiculo,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(MetodoDepreciacion.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(MetodoDepreciacion.class));
			detalleactivofijo.setMetodoDepreciacions(detalleactivofijoDataAccess.getMetodoDepreciacions(connexion,detalleactivofijo));

			for(MetodoDepreciacion metododepreciacion:detalleactivofijo.getMetodoDepreciacions()) {
				MetodoDepreciacionLogic metododepreciacionLogic= new MetodoDepreciacionLogic(connexion);
				metododepreciacionLogic.deepLoad(metododepreciacion,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(ResponsableActivoFijo.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(ResponsableActivoFijo.class));
			detalleactivofijo.setResponsableActivoFijos(detalleactivofijoDataAccess.getResponsableActivoFijos(connexion,detalleactivofijo));

			for(ResponsableActivoFijo responsableactivofijo:detalleactivofijo.getResponsableActivoFijos()) {
				ResponsableActivoFijoLogic responsableactivofijoLogic= new ResponsableActivoFijoLogic(connexion);
				responsableactivofijoLogic.deepLoad(responsableactivofijo,isDeep,deepLoadType,clases);
			}
		}

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
			detalleactivofijo.setDepreciacionActivoFijos(detalleactivofijoDataAccess.getDepreciacionActivoFijos(connexion,detalleactivofijo));

			for(DepreciacionActivoFijo depreciacionactivofijo:detalleactivofijo.getDepreciacionActivoFijos()) {
				DepreciacionActivoFijoLogic depreciacionactivofijoLogic= new DepreciacionActivoFijoLogic(connexion);
				depreciacionactivofijoLogic.deepLoad(depreciacionactivofijo,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(GastoDepreciacionCentroCosto.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(GastoDepreciacionCentroCosto.class));
			detalleactivofijo.setGastoDepreciacionCentroCostos(detalleactivofijoDataAccess.getGastoDepreciacionCentroCostos(connexion,detalleactivofijo));

			for(GastoDepreciacionCentroCosto gastodepreciacioncentrocosto:detalleactivofijo.getGastoDepreciacionCentroCostos()) {
				GastoDepreciacionCentroCostoLogic gastodepreciacioncentrocostoLogic= new GastoDepreciacionCentroCostoLogic(connexion);
				gastodepreciacioncentrocostoLogic.deepLoad(gastodepreciacioncentrocosto,isDeep,deepLoadType,clases);
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
			detalleactivofijo.setParteActivoFijos(detalleactivofijoDataAccess.getParteActivoFijos(connexion,detalleactivofijo));

			for(ParteActivoFijo parteactivofijo:detalleactivofijo.getParteActivoFijos()) {
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
	
	public void deepSave(DetalleActivoFijo detalleactivofijo,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			DetalleActivoFijoLogicAdditional.updateDetalleActivoFijoToSave(detalleactivofijo,this.arrDatoGeneral);
			
DetalleActivoFijoDataAccess.save(detalleactivofijo, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(detalleactivofijo.getEmpresa(),connexion);

		SucursalDataAccess.save(detalleactivofijo.getSucursal(),connexion);

		DetalleGrupoActivoFijoDataAccess.save(detalleactivofijo.getDetalleGrupoActivoFijo(),connexion);

		SubGrupoActivoFijoDataAccess.save(detalleactivofijo.getSubGrupoActivoFijo(),connexion);

		TipoRamoActivoFijoDataAccess.save(detalleactivofijo.getTipoRamoActivoFijo(),connexion);

		TipoActivoFijoEmpresaDataAccess.save(detalleactivofijo.getTipoActivoFijoEmpresa(),connexion);

		TipoDepreciacionEmpresaDataAccess.save(detalleactivofijo.getTipoDepreciacionEmpresa(),connexion);

		EstadoActivoFijoDataAccess.save(detalleactivofijo.getEstadoActivoFijo(),connexion);

		ClienteDataAccess.save(detalleactivofijo.getCliente(),connexion);

		PartidaPresuDataAccess.save(detalleactivofijo.getPartidaPresu(),connexion);

		for(MantenimientoActivoFijo mantenimientoactivofijo:detalleactivofijo.getMantenimientoActivoFijos()) {
			mantenimientoactivofijo.setid_detalle_activo_fijo(detalleactivofijo.getId());
			MantenimientoActivoFijoDataAccess.save(mantenimientoactivofijo,connexion);
		}

		for(ServicioTransporte serviciotransporte:detalleactivofijo.getServicioTransportes()) {
			serviciotransporte.setid_detalle_activo_fijo(detalleactivofijo.getId());
			ServicioTransporteDataAccess.save(serviciotransporte,connexion);
		}

		for(MovimientoActivoFijo movimientoactivofijo:detalleactivofijo.getMovimientoActivoFijoDestinos()) {
			movimientoactivofijo.setid_detalle_activo_fijo_destino(detalleactivofijo.getId());
			MovimientoActivoFijoDataAccess.save(movimientoactivofijo,connexion);
		}

		for(Vehiculo vehiculo:detalleactivofijo.getVehiculos()) {
			vehiculo.setid_detalle_activo_fijo(detalleactivofijo.getId());
			VehiculoDataAccess.save(vehiculo,connexion);
		}

		for(MetodoDepreciacion metododepreciacion:detalleactivofijo.getMetodoDepreciacions()) {
			metododepreciacion.setid_detalle_activo_fijo(detalleactivofijo.getId());
			MetodoDepreciacionDataAccess.save(metododepreciacion,connexion);
		}

		for(ResponsableActivoFijo responsableactivofijo:detalleactivofijo.getResponsableActivoFijos()) {
			responsableactivofijo.setid_detalle_activo_fijo(detalleactivofijo.getId());
			ResponsableActivoFijoDataAccess.save(responsableactivofijo,connexion);
		}

		for(DepreciacionActivoFijo depreciacionactivofijo:detalleactivofijo.getDepreciacionActivoFijos()) {
			depreciacionactivofijo.setid_detalle_activo_fijo(detalleactivofijo.getId());
			DepreciacionActivoFijoDataAccess.save(depreciacionactivofijo,connexion);
		}

		for(GastoDepreciacionCentroCosto gastodepreciacioncentrocosto:detalleactivofijo.getGastoDepreciacionCentroCostos()) {
			gastodepreciacioncentrocosto.setid_detalle_activo_fijo(detalleactivofijo.getId());
			GastoDepreciacionCentroCostoDataAccess.save(gastodepreciacioncentrocosto,connexion);
		}

		for(ParteActivoFijo parteactivofijo:detalleactivofijo.getParteActivoFijos()) {
			parteactivofijo.setid_detalle_activo_fijo(detalleactivofijo.getId());
			ParteActivoFijoDataAccess.save(parteactivofijo,connexion);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(detalleactivofijo.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(detalleactivofijo.getSucursal(),connexion);
				continue;
			}

			if(clas.clas.equals(DetalleGrupoActivoFijo.class)) {
				DetalleGrupoActivoFijoDataAccess.save(detalleactivofijo.getDetalleGrupoActivoFijo(),connexion);
				continue;
			}

			if(clas.clas.equals(SubGrupoActivoFijo.class)) {
				SubGrupoActivoFijoDataAccess.save(detalleactivofijo.getSubGrupoActivoFijo(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoRamoActivoFijo.class)) {
				TipoRamoActivoFijoDataAccess.save(detalleactivofijo.getTipoRamoActivoFijo(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoActivoFijoEmpresa.class)) {
				TipoActivoFijoEmpresaDataAccess.save(detalleactivofijo.getTipoActivoFijoEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoDepreciacionEmpresa.class)) {
				TipoDepreciacionEmpresaDataAccess.save(detalleactivofijo.getTipoDepreciacionEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(EstadoActivoFijo.class)) {
				EstadoActivoFijoDataAccess.save(detalleactivofijo.getEstadoActivoFijo(),connexion);
				continue;
			}

			if(clas.clas.equals(Cliente.class)) {
				ClienteDataAccess.save(detalleactivofijo.getCliente(),connexion);
				continue;
			}

			if(clas.clas.equals(PartidaPresu.class)) {
				PartidaPresuDataAccess.save(detalleactivofijo.getPartidaPresu(),connexion);
				continue;
			}


			if(clas.clas.equals(MantenimientoActivoFijo.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(MantenimientoActivoFijo mantenimientoactivofijo:detalleactivofijo.getMantenimientoActivoFijos()) {
					mantenimientoactivofijo.setid_detalle_activo_fijo(detalleactivofijo.getId());
					MantenimientoActivoFijoDataAccess.save(mantenimientoactivofijo,connexion);
				}
				continue;
			}

			if(clas.clas.equals(ServicioTransporte.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(ServicioTransporte serviciotransporte:detalleactivofijo.getServicioTransportes()) {
					serviciotransporte.setid_detalle_activo_fijo(detalleactivofijo.getId());
					ServicioTransporteDataAccess.save(serviciotransporte,connexion);
				}
				continue;
			}

			if(clas.clas.equals(MovimientoActivoFijo.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(MovimientoActivoFijo movimientoactivofijo:detalleactivofijo.getMovimientoActivoFijoDestinos()) {
					movimientoactivofijo.setid_detalle_activo_fijo_destino(detalleactivofijo.getId());
					MovimientoActivoFijoDataAccess.save(movimientoactivofijo,connexion);
				}
				continue;
			}

			if(clas.clas.equals(Vehiculo.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(Vehiculo vehiculo:detalleactivofijo.getVehiculos()) {
					vehiculo.setid_detalle_activo_fijo(detalleactivofijo.getId());
					VehiculoDataAccess.save(vehiculo,connexion);
				}
				continue;
			}

			if(clas.clas.equals(MetodoDepreciacion.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(MetodoDepreciacion metododepreciacion:detalleactivofijo.getMetodoDepreciacions()) {
					metododepreciacion.setid_detalle_activo_fijo(detalleactivofijo.getId());
					MetodoDepreciacionDataAccess.save(metododepreciacion,connexion);
				}
				continue;
			}

			if(clas.clas.equals(ResponsableActivoFijo.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(ResponsableActivoFijo responsableactivofijo:detalleactivofijo.getResponsableActivoFijos()) {
					responsableactivofijo.setid_detalle_activo_fijo(detalleactivofijo.getId());
					ResponsableActivoFijoDataAccess.save(responsableactivofijo,connexion);
				}
				continue;
			}

			if(clas.clas.equals(DepreciacionActivoFijo.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(DepreciacionActivoFijo depreciacionactivofijo:detalleactivofijo.getDepreciacionActivoFijos()) {
					depreciacionactivofijo.setid_detalle_activo_fijo(detalleactivofijo.getId());
					DepreciacionActivoFijoDataAccess.save(depreciacionactivofijo,connexion);
				}
				continue;
			}

			if(clas.clas.equals(GastoDepreciacionCentroCosto.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(GastoDepreciacionCentroCosto gastodepreciacioncentrocosto:detalleactivofijo.getGastoDepreciacionCentroCostos()) {
					gastodepreciacioncentrocosto.setid_detalle_activo_fijo(detalleactivofijo.getId());
					GastoDepreciacionCentroCostoDataAccess.save(gastodepreciacioncentrocosto,connexion);
				}
				continue;
			}

			if(clas.clas.equals(ParteActivoFijo.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(ParteActivoFijo parteactivofijo:detalleactivofijo.getParteActivoFijos()) {
					parteactivofijo.setid_detalle_activo_fijo(detalleactivofijo.getId());
					ParteActivoFijoDataAccess.save(parteactivofijo,connexion);
				}
				continue;
			}
		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(detalleactivofijo.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(detalleactivofijo.getEmpresa(),isDeep,deepLoadType,clases);
				

		SucursalDataAccess.save(detalleactivofijo.getSucursal(),connexion);
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(detalleactivofijo.getSucursal(),isDeep,deepLoadType,clases);
				

		DetalleGrupoActivoFijoDataAccess.save(detalleactivofijo.getDetalleGrupoActivoFijo(),connexion);
		DetalleGrupoActivoFijoLogic detallegrupoactivofijoLogic= new DetalleGrupoActivoFijoLogic(connexion);
		detallegrupoactivofijoLogic.deepLoad(detalleactivofijo.getDetalleGrupoActivoFijo(),isDeep,deepLoadType,clases);
				

		SubGrupoActivoFijoDataAccess.save(detalleactivofijo.getSubGrupoActivoFijo(),connexion);
		SubGrupoActivoFijoLogic subgrupoactivofijoLogic= new SubGrupoActivoFijoLogic(connexion);
		subgrupoactivofijoLogic.deepLoad(detalleactivofijo.getSubGrupoActivoFijo(),isDeep,deepLoadType,clases);
				

		TipoRamoActivoFijoDataAccess.save(detalleactivofijo.getTipoRamoActivoFijo(),connexion);
		TipoRamoActivoFijoLogic tiporamoactivofijoLogic= new TipoRamoActivoFijoLogic(connexion);
		tiporamoactivofijoLogic.deepLoad(detalleactivofijo.getTipoRamoActivoFijo(),isDeep,deepLoadType,clases);
				

		TipoActivoFijoEmpresaDataAccess.save(detalleactivofijo.getTipoActivoFijoEmpresa(),connexion);
		TipoActivoFijoEmpresaLogic tipoactivofijoempresaLogic= new TipoActivoFijoEmpresaLogic(connexion);
		tipoactivofijoempresaLogic.deepLoad(detalleactivofijo.getTipoActivoFijoEmpresa(),isDeep,deepLoadType,clases);
				

		TipoDepreciacionEmpresaDataAccess.save(detalleactivofijo.getTipoDepreciacionEmpresa(),connexion);
		TipoDepreciacionEmpresaLogic tipodepreciacionempresaLogic= new TipoDepreciacionEmpresaLogic(connexion);
		tipodepreciacionempresaLogic.deepLoad(detalleactivofijo.getTipoDepreciacionEmpresa(),isDeep,deepLoadType,clases);
				

		EstadoActivoFijoDataAccess.save(detalleactivofijo.getEstadoActivoFijo(),connexion);
		EstadoActivoFijoLogic estadoactivofijoLogic= new EstadoActivoFijoLogic(connexion);
		estadoactivofijoLogic.deepLoad(detalleactivofijo.getEstadoActivoFijo(),isDeep,deepLoadType,clases);
				

		ClienteDataAccess.save(detalleactivofijo.getCliente(),connexion);
		ClienteLogic clienteLogic= new ClienteLogic(connexion);
		clienteLogic.deepLoad(detalleactivofijo.getCliente(),isDeep,deepLoadType,clases);
				

		PartidaPresuDataAccess.save(detalleactivofijo.getPartidaPresu(),connexion);
		PartidaPresuLogic partidapresuLogic= new PartidaPresuLogic(connexion);
		partidapresuLogic.deepLoad(detalleactivofijo.getPartidaPresu(),isDeep,deepLoadType,clases);
				

		for(MantenimientoActivoFijo mantenimientoactivofijo:detalleactivofijo.getMantenimientoActivoFijos()) {
			MantenimientoActivoFijoLogic mantenimientoactivofijoLogic= new MantenimientoActivoFijoLogic(connexion);
			mantenimientoactivofijo.setid_detalle_activo_fijo(detalleactivofijo.getId());
			MantenimientoActivoFijoDataAccess.save(mantenimientoactivofijo,connexion);
			mantenimientoactivofijoLogic.deepSave(mantenimientoactivofijo,isDeep,deepLoadType,clases);
		}

		for(ServicioTransporte serviciotransporte:detalleactivofijo.getServicioTransportes()) {
			ServicioTransporteLogic serviciotransporteLogic= new ServicioTransporteLogic(connexion);
			serviciotransporte.setid_detalle_activo_fijo(detalleactivofijo.getId());
			ServicioTransporteDataAccess.save(serviciotransporte,connexion);
			serviciotransporteLogic.deepSave(serviciotransporte,isDeep,deepLoadType,clases);
		}

		for(MovimientoActivoFijo movimientoactivofijo:detalleactivofijo.getMovimientoActivoFijoDestinos()) {
			MovimientoActivoFijoLogic movimientoactivofijoLogic= new MovimientoActivoFijoLogic(connexion);
			movimientoactivofijo.setid_detalle_activo_fijo_destino(detalleactivofijo.getId());
			MovimientoActivoFijoDataAccess.save(movimientoactivofijo,connexion);
			movimientoactivofijoLogic.deepSave(movimientoactivofijo,isDeep,deepLoadType,clases);
		}

		for(Vehiculo vehiculo:detalleactivofijo.getVehiculos()) {
			VehiculoLogic vehiculoLogic= new VehiculoLogic(connexion);
			vehiculo.setid_detalle_activo_fijo(detalleactivofijo.getId());
			VehiculoDataAccess.save(vehiculo,connexion);
			vehiculoLogic.deepSave(vehiculo,isDeep,deepLoadType,clases);
		}

		for(MetodoDepreciacion metododepreciacion:detalleactivofijo.getMetodoDepreciacions()) {
			MetodoDepreciacionLogic metododepreciacionLogic= new MetodoDepreciacionLogic(connexion);
			metododepreciacion.setid_detalle_activo_fijo(detalleactivofijo.getId());
			MetodoDepreciacionDataAccess.save(metododepreciacion,connexion);
			metododepreciacionLogic.deepSave(metododepreciacion,isDeep,deepLoadType,clases);
		}

		for(ResponsableActivoFijo responsableactivofijo:detalleactivofijo.getResponsableActivoFijos()) {
			ResponsableActivoFijoLogic responsableactivofijoLogic= new ResponsableActivoFijoLogic(connexion);
			responsableactivofijo.setid_detalle_activo_fijo(detalleactivofijo.getId());
			ResponsableActivoFijoDataAccess.save(responsableactivofijo,connexion);
			responsableactivofijoLogic.deepSave(responsableactivofijo,isDeep,deepLoadType,clases);
		}

		for(DepreciacionActivoFijo depreciacionactivofijo:detalleactivofijo.getDepreciacionActivoFijos()) {
			DepreciacionActivoFijoLogic depreciacionactivofijoLogic= new DepreciacionActivoFijoLogic(connexion);
			depreciacionactivofijo.setid_detalle_activo_fijo(detalleactivofijo.getId());
			DepreciacionActivoFijoDataAccess.save(depreciacionactivofijo,connexion);
			depreciacionactivofijoLogic.deepSave(depreciacionactivofijo,isDeep,deepLoadType,clases);
		}

		for(GastoDepreciacionCentroCosto gastodepreciacioncentrocosto:detalleactivofijo.getGastoDepreciacionCentroCostos()) {
			GastoDepreciacionCentroCostoLogic gastodepreciacioncentrocostoLogic= new GastoDepreciacionCentroCostoLogic(connexion);
			gastodepreciacioncentrocosto.setid_detalle_activo_fijo(detalleactivofijo.getId());
			GastoDepreciacionCentroCostoDataAccess.save(gastodepreciacioncentrocosto,connexion);
			gastodepreciacioncentrocostoLogic.deepSave(gastodepreciacioncentrocosto,isDeep,deepLoadType,clases);
		}

		for(ParteActivoFijo parteactivofijo:detalleactivofijo.getParteActivoFijos()) {
			ParteActivoFijoLogic parteactivofijoLogic= new ParteActivoFijoLogic(connexion);
			parteactivofijo.setid_detalle_activo_fijo(detalleactivofijo.getId());
			ParteActivoFijoDataAccess.save(parteactivofijo,connexion);
			parteactivofijoLogic.deepSave(parteactivofijo,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(detalleactivofijo.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(detalleactivofijo.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(detalleactivofijo.getSucursal(),connexion);
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepSave(detalleactivofijo.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(DetalleGrupoActivoFijo.class)) {
				DetalleGrupoActivoFijoDataAccess.save(detalleactivofijo.getDetalleGrupoActivoFijo(),connexion);
				DetalleGrupoActivoFijoLogic detallegrupoactivofijoLogic= new DetalleGrupoActivoFijoLogic(connexion);
				detallegrupoactivofijoLogic.deepSave(detalleactivofijo.getDetalleGrupoActivoFijo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(SubGrupoActivoFijo.class)) {
				SubGrupoActivoFijoDataAccess.save(detalleactivofijo.getSubGrupoActivoFijo(),connexion);
				SubGrupoActivoFijoLogic subgrupoactivofijoLogic= new SubGrupoActivoFijoLogic(connexion);
				subgrupoactivofijoLogic.deepSave(detalleactivofijo.getSubGrupoActivoFijo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoRamoActivoFijo.class)) {
				TipoRamoActivoFijoDataAccess.save(detalleactivofijo.getTipoRamoActivoFijo(),connexion);
				TipoRamoActivoFijoLogic tiporamoactivofijoLogic= new TipoRamoActivoFijoLogic(connexion);
				tiporamoactivofijoLogic.deepSave(detalleactivofijo.getTipoRamoActivoFijo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoActivoFijoEmpresa.class)) {
				TipoActivoFijoEmpresaDataAccess.save(detalleactivofijo.getTipoActivoFijoEmpresa(),connexion);
				TipoActivoFijoEmpresaLogic tipoactivofijoempresaLogic= new TipoActivoFijoEmpresaLogic(connexion);
				tipoactivofijoempresaLogic.deepSave(detalleactivofijo.getTipoActivoFijoEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoDepreciacionEmpresa.class)) {
				TipoDepreciacionEmpresaDataAccess.save(detalleactivofijo.getTipoDepreciacionEmpresa(),connexion);
				TipoDepreciacionEmpresaLogic tipodepreciacionempresaLogic= new TipoDepreciacionEmpresaLogic(connexion);
				tipodepreciacionempresaLogic.deepSave(detalleactivofijo.getTipoDepreciacionEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(EstadoActivoFijo.class)) {
				EstadoActivoFijoDataAccess.save(detalleactivofijo.getEstadoActivoFijo(),connexion);
				EstadoActivoFijoLogic estadoactivofijoLogic= new EstadoActivoFijoLogic(connexion);
				estadoactivofijoLogic.deepSave(detalleactivofijo.getEstadoActivoFijo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Cliente.class)) {
				ClienteDataAccess.save(detalleactivofijo.getCliente(),connexion);
				ClienteLogic clienteLogic= new ClienteLogic(connexion);
				clienteLogic.deepSave(detalleactivofijo.getCliente(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(PartidaPresu.class)) {
				PartidaPresuDataAccess.save(detalleactivofijo.getPartidaPresu(),connexion);
				PartidaPresuLogic partidapresuLogic= new PartidaPresuLogic(connexion);
				partidapresuLogic.deepSave(detalleactivofijo.getPartidaPresu(),isDeep,deepLoadType,clases);				
				continue;
			}


			if(clas.clas.equals(MantenimientoActivoFijo.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(MantenimientoActivoFijo mantenimientoactivofijo:detalleactivofijo.getMantenimientoActivoFijos()) {
					MantenimientoActivoFijoLogic mantenimientoactivofijoLogic= new MantenimientoActivoFijoLogic(connexion);
					mantenimientoactivofijo.setid_detalle_activo_fijo(detalleactivofijo.getId());
					MantenimientoActivoFijoDataAccess.save(mantenimientoactivofijo,connexion);
					mantenimientoactivofijoLogic.deepSave(mantenimientoactivofijo,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(ServicioTransporte.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(ServicioTransporte serviciotransporte:detalleactivofijo.getServicioTransportes()) {
					ServicioTransporteLogic serviciotransporteLogic= new ServicioTransporteLogic(connexion);
					serviciotransporte.setid_detalle_activo_fijo(detalleactivofijo.getId());
					ServicioTransporteDataAccess.save(serviciotransporte,connexion);
					serviciotransporteLogic.deepSave(serviciotransporte,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(MovimientoActivoFijo.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(MovimientoActivoFijo movimientoactivofijo:detalleactivofijo.getMovimientoActivoFijoDestinos()) {
					MovimientoActivoFijoLogic movimientoactivofijoLogic= new MovimientoActivoFijoLogic(connexion);
					movimientoactivofijo.setid_detalle_activo_fijo_destino(detalleactivofijo.getId());
					MovimientoActivoFijoDataAccess.save(movimientoactivofijo,connexion);
					movimientoactivofijoLogic.deepSave(movimientoactivofijo,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(Vehiculo.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(Vehiculo vehiculo:detalleactivofijo.getVehiculos()) {
					VehiculoLogic vehiculoLogic= new VehiculoLogic(connexion);
					vehiculo.setid_detalle_activo_fijo(detalleactivofijo.getId());
					VehiculoDataAccess.save(vehiculo,connexion);
					vehiculoLogic.deepSave(vehiculo,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(MetodoDepreciacion.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(MetodoDepreciacion metododepreciacion:detalleactivofijo.getMetodoDepreciacions()) {
					MetodoDepreciacionLogic metododepreciacionLogic= new MetodoDepreciacionLogic(connexion);
					metododepreciacion.setid_detalle_activo_fijo(detalleactivofijo.getId());
					MetodoDepreciacionDataAccess.save(metododepreciacion,connexion);
					metododepreciacionLogic.deepSave(metododepreciacion,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(ResponsableActivoFijo.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(ResponsableActivoFijo responsableactivofijo:detalleactivofijo.getResponsableActivoFijos()) {
					ResponsableActivoFijoLogic responsableactivofijoLogic= new ResponsableActivoFijoLogic(connexion);
					responsableactivofijo.setid_detalle_activo_fijo(detalleactivofijo.getId());
					ResponsableActivoFijoDataAccess.save(responsableactivofijo,connexion);
					responsableactivofijoLogic.deepSave(responsableactivofijo,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(DepreciacionActivoFijo.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(DepreciacionActivoFijo depreciacionactivofijo:detalleactivofijo.getDepreciacionActivoFijos()) {
					DepreciacionActivoFijoLogic depreciacionactivofijoLogic= new DepreciacionActivoFijoLogic(connexion);
					depreciacionactivofijo.setid_detalle_activo_fijo(detalleactivofijo.getId());
					DepreciacionActivoFijoDataAccess.save(depreciacionactivofijo,connexion);
					depreciacionactivofijoLogic.deepSave(depreciacionactivofijo,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(GastoDepreciacionCentroCosto.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(GastoDepreciacionCentroCosto gastodepreciacioncentrocosto:detalleactivofijo.getGastoDepreciacionCentroCostos()) {
					GastoDepreciacionCentroCostoLogic gastodepreciacioncentrocostoLogic= new GastoDepreciacionCentroCostoLogic(connexion);
					gastodepreciacioncentrocosto.setid_detalle_activo_fijo(detalleactivofijo.getId());
					GastoDepreciacionCentroCostoDataAccess.save(gastodepreciacioncentrocosto,connexion);
					gastodepreciacioncentrocostoLogic.deepSave(gastodepreciacioncentrocosto,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(ParteActivoFijo.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(ParteActivoFijo parteactivofijo:detalleactivofijo.getParteActivoFijos()) {
					ParteActivoFijoLogic parteactivofijoLogic= new ParteActivoFijoLogic(connexion);
					parteactivofijo.setid_detalle_activo_fijo(detalleactivofijo.getId());
					ParteActivoFijoDataAccess.save(parteactivofijo,connexion);
					parteactivofijoLogic.deepSave(parteactivofijo,isDeep,deepLoadType,clases);
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
			this.getNewConnexionToDeep(DetalleActivoFijo.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(detalleactivofijo,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				DetalleActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesDetalleActivoFijo(detalleactivofijo);
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
			this.deepLoad(this.detalleactivofijo,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				DetalleActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesDetalleActivoFijo(this.detalleactivofijo);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(DetalleActivoFijo.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(detalleactivofijos!=null) {
				for(DetalleActivoFijo detalleactivofijo:detalleactivofijos) {
					this.deepLoad(detalleactivofijo,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					DetalleActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesDetalleActivoFijo(detalleactivofijos);
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
			if(detalleactivofijos!=null) {
				for(DetalleActivoFijo detalleactivofijo:detalleactivofijos) {
					this.deepLoad(detalleactivofijo,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					DetalleActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesDetalleActivoFijo(detalleactivofijos);
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
			this.getNewConnexionToDeep(DetalleActivoFijo.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(detalleactivofijo,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(DetalleActivoFijo.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(detalleactivofijos!=null) {
				for(DetalleActivoFijo detalleactivofijo:detalleactivofijos) {
					this.deepSave(detalleactivofijo,isDeep,deepLoadType,clases);
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
			if(detalleactivofijos!=null) {
				for(DetalleActivoFijo detalleactivofijo:detalleactivofijos) {
					this.deepSave(detalleactivofijo,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getDetalleActivoFijosFK_IdClienteWithConnection(String sFinalQuery,Pagination pagination,Long id_cliente)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleActivoFijo.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCliente= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCliente.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cliente,DetalleActivoFijoConstantesFunciones.IDCLIENTE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCliente);

			DetalleActivoFijoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCliente","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleactivofijos=detalleactivofijoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesDetalleActivoFijo(this.detalleactivofijos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleActivoFijosFK_IdCliente(String sFinalQuery,Pagination pagination,Long id_cliente)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCliente= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCliente.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cliente,DetalleActivoFijoConstantesFunciones.IDCLIENTE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCliente);

			DetalleActivoFijoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCliente","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleactivofijos=detalleactivofijoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesDetalleActivoFijo(this.detalleactivofijos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetalleActivoFijosFK_IdDetalleGrupoActivoFijoWithConnection(String sFinalQuery,Pagination pagination,Long id_detalle_grupo_activo_fijo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleActivoFijo.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidDetalleGrupoActivoFijo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidDetalleGrupoActivoFijo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_detalle_grupo_activo_fijo,DetalleActivoFijoConstantesFunciones.IDDETALLEGRUPOACTIVOFIJO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidDetalleGrupoActivoFijo);

			DetalleActivoFijoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdDetalleGrupoActivoFijo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleactivofijos=detalleactivofijoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesDetalleActivoFijo(this.detalleactivofijos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleActivoFijosFK_IdDetalleGrupoActivoFijo(String sFinalQuery,Pagination pagination,Long id_detalle_grupo_activo_fijo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidDetalleGrupoActivoFijo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidDetalleGrupoActivoFijo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_detalle_grupo_activo_fijo,DetalleActivoFijoConstantesFunciones.IDDETALLEGRUPOACTIVOFIJO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidDetalleGrupoActivoFijo);

			DetalleActivoFijoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdDetalleGrupoActivoFijo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleactivofijos=detalleactivofijoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesDetalleActivoFijo(this.detalleactivofijos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetalleActivoFijosFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleActivoFijo.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,DetalleActivoFijoConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			DetalleActivoFijoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleactivofijos=detalleactivofijoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesDetalleActivoFijo(this.detalleactivofijos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleActivoFijosFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,DetalleActivoFijoConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			DetalleActivoFijoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleactivofijos=detalleactivofijoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesDetalleActivoFijo(this.detalleactivofijos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetalleActivoFijosFK_IdEstadoActivoFijoWithConnection(String sFinalQuery,Pagination pagination,Long id_estado_activo_fijo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleActivoFijo.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEstadoActivoFijo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEstadoActivoFijo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_estado_activo_fijo,DetalleActivoFijoConstantesFunciones.IDESTADOACTIVOFIJO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEstadoActivoFijo);

			DetalleActivoFijoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEstadoActivoFijo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleactivofijos=detalleactivofijoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesDetalleActivoFijo(this.detalleactivofijos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleActivoFijosFK_IdEstadoActivoFijo(String sFinalQuery,Pagination pagination,Long id_estado_activo_fijo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEstadoActivoFijo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEstadoActivoFijo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_estado_activo_fijo,DetalleActivoFijoConstantesFunciones.IDESTADOACTIVOFIJO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEstadoActivoFijo);

			DetalleActivoFijoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEstadoActivoFijo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleactivofijos=detalleactivofijoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesDetalleActivoFijo(this.detalleactivofijos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetalleActivoFijosFK_IdPartidaPresuWithConnection(String sFinalQuery,Pagination pagination,Long id_partida_presu)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleActivoFijo.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPartidaPresu= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPartidaPresu.setParameterSelectionGeneralEqual(ParameterType.LONG,id_partida_presu,DetalleActivoFijoConstantesFunciones.IDPARTIDAPRESU,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPartidaPresu);

			DetalleActivoFijoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPartidaPresu","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleactivofijos=detalleactivofijoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesDetalleActivoFijo(this.detalleactivofijos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleActivoFijosFK_IdPartidaPresu(String sFinalQuery,Pagination pagination,Long id_partida_presu)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPartidaPresu= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPartidaPresu.setParameterSelectionGeneralEqual(ParameterType.LONG,id_partida_presu,DetalleActivoFijoConstantesFunciones.IDPARTIDAPRESU,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPartidaPresu);

			DetalleActivoFijoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPartidaPresu","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleactivofijos=detalleactivofijoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesDetalleActivoFijo(this.detalleactivofijos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetalleActivoFijosFK_IdSubGrupoActivoFijoWithConnection(String sFinalQuery,Pagination pagination,Long id_sub_grupo_activo_fijo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleActivoFijo.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSubGrupoActivoFijo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSubGrupoActivoFijo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sub_grupo_activo_fijo,DetalleActivoFijoConstantesFunciones.IDSUBGRUPOACTIVOFIJO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSubGrupoActivoFijo);

			DetalleActivoFijoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSubGrupoActivoFijo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleactivofijos=detalleactivofijoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesDetalleActivoFijo(this.detalleactivofijos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleActivoFijosFK_IdSubGrupoActivoFijo(String sFinalQuery,Pagination pagination,Long id_sub_grupo_activo_fijo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSubGrupoActivoFijo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSubGrupoActivoFijo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sub_grupo_activo_fijo,DetalleActivoFijoConstantesFunciones.IDSUBGRUPOACTIVOFIJO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSubGrupoActivoFijo);

			DetalleActivoFijoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSubGrupoActivoFijo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleactivofijos=detalleactivofijoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesDetalleActivoFijo(this.detalleactivofijos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetalleActivoFijosFK_IdSucursalWithConnection(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleActivoFijo.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,DetalleActivoFijoConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			DetalleActivoFijoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleactivofijos=detalleactivofijoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesDetalleActivoFijo(this.detalleactivofijos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleActivoFijosFK_IdSucursal(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,DetalleActivoFijoConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			DetalleActivoFijoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleactivofijos=detalleactivofijoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesDetalleActivoFijo(this.detalleactivofijos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetalleActivoFijosFK_IdTipoActivoFijoEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_activo_fijo_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleActivoFijo.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoActivoFijoEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoActivoFijoEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_activo_fijo_empresa,DetalleActivoFijoConstantesFunciones.IDTIPOACTIVOFIJOEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoActivoFijoEmpresa);

			DetalleActivoFijoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoActivoFijoEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleactivofijos=detalleactivofijoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesDetalleActivoFijo(this.detalleactivofijos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleActivoFijosFK_IdTipoActivoFijoEmpresa(String sFinalQuery,Pagination pagination,Long id_tipo_activo_fijo_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoActivoFijoEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoActivoFijoEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_activo_fijo_empresa,DetalleActivoFijoConstantesFunciones.IDTIPOACTIVOFIJOEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoActivoFijoEmpresa);

			DetalleActivoFijoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoActivoFijoEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleactivofijos=detalleactivofijoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesDetalleActivoFijo(this.detalleactivofijos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetalleActivoFijosFK_IdTipoDepreciacionEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_depreciacion_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleActivoFijo.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoDepreciacionEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoDepreciacionEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_depreciacion_empresa,DetalleActivoFijoConstantesFunciones.IDTIPODEPRECIACIONEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoDepreciacionEmpresa);

			DetalleActivoFijoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoDepreciacionEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleactivofijos=detalleactivofijoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesDetalleActivoFijo(this.detalleactivofijos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleActivoFijosFK_IdTipoDepreciacionEmpresa(String sFinalQuery,Pagination pagination,Long id_tipo_depreciacion_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoDepreciacionEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoDepreciacionEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_depreciacion_empresa,DetalleActivoFijoConstantesFunciones.IDTIPODEPRECIACIONEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoDepreciacionEmpresa);

			DetalleActivoFijoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoDepreciacionEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleactivofijos=detalleactivofijoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesDetalleActivoFijo(this.detalleactivofijos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetalleActivoFijosFK_IdTipoRamoActivoFijoWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_ramo_activo_fijo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleActivoFijo.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoRamoActivoFijo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoRamoActivoFijo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_ramo_activo_fijo,DetalleActivoFijoConstantesFunciones.IDTIPORAMOACTIVOFIJO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoRamoActivoFijo);

			DetalleActivoFijoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoRamoActivoFijo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleactivofijos=detalleactivofijoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesDetalleActivoFijo(this.detalleactivofijos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleActivoFijosFK_IdTipoRamoActivoFijo(String sFinalQuery,Pagination pagination,Long id_tipo_ramo_activo_fijo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoRamoActivoFijo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoRamoActivoFijo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_ramo_activo_fijo,DetalleActivoFijoConstantesFunciones.IDTIPORAMOACTIVOFIJO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoRamoActivoFijo);

			DetalleActivoFijoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoRamoActivoFijo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleactivofijos=detalleactivofijoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesDetalleActivoFijo(this.detalleactivofijos);
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
			if(DetalleActivoFijoConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,DetalleActivoFijoDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,DetalleActivoFijo detalleactivofijo,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(DetalleActivoFijoConstantesFunciones.ISCONAUDITORIA) {
				if(detalleactivofijo.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,DetalleActivoFijoDataAccess.TABLENAME, detalleactivofijo.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(DetalleActivoFijoConstantesFunciones.ISCONAUDITORIADETALLE) {
						////DetalleActivoFijoLogic.registrarAuditoriaDetallesDetalleActivoFijo(connexion,detalleactivofijo,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(detalleactivofijo.getIsDeleted()) {
					/*if(!detalleactivofijo.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,DetalleActivoFijoDataAccess.TABLENAME, detalleactivofijo.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////DetalleActivoFijoLogic.registrarAuditoriaDetallesDetalleActivoFijo(connexion,detalleactivofijo,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,DetalleActivoFijoDataAccess.TABLENAME, detalleactivofijo.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(detalleactivofijo.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,DetalleActivoFijoDataAccess.TABLENAME, detalleactivofijo.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(DetalleActivoFijoConstantesFunciones.ISCONAUDITORIADETALLE) {
						////DetalleActivoFijoLogic.registrarAuditoriaDetallesDetalleActivoFijo(connexion,detalleactivofijo,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesDetalleActivoFijo(Connexion connexion,DetalleActivoFijo detalleactivofijo)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(detalleactivofijo.getIsNew()||!detalleactivofijo.getid_empresa().equals(detalleactivofijo.getDetalleActivoFijoOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleactivofijo.getDetalleActivoFijoOriginal().getid_empresa()!=null)
				{
					strValorActual=detalleactivofijo.getDetalleActivoFijoOriginal().getid_empresa().toString();
				}
				if(detalleactivofijo.getid_empresa()!=null)
				{
					strValorNuevo=detalleactivofijo.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleActivoFijoConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(detalleactivofijo.getIsNew()||!detalleactivofijo.getid_sucursal().equals(detalleactivofijo.getDetalleActivoFijoOriginal().getid_sucursal()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleactivofijo.getDetalleActivoFijoOriginal().getid_sucursal()!=null)
				{
					strValorActual=detalleactivofijo.getDetalleActivoFijoOriginal().getid_sucursal().toString();
				}
				if(detalleactivofijo.getid_sucursal()!=null)
				{
					strValorNuevo=detalleactivofijo.getid_sucursal().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleActivoFijoConstantesFunciones.IDSUCURSAL,strValorActual,strValorNuevo);
			}	
			
			if(detalleactivofijo.getIsNew()||!detalleactivofijo.getid_detalle_grupo_activo_fijo().equals(detalleactivofijo.getDetalleActivoFijoOriginal().getid_detalle_grupo_activo_fijo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleactivofijo.getDetalleActivoFijoOriginal().getid_detalle_grupo_activo_fijo()!=null)
				{
					strValorActual=detalleactivofijo.getDetalleActivoFijoOriginal().getid_detalle_grupo_activo_fijo().toString();
				}
				if(detalleactivofijo.getid_detalle_grupo_activo_fijo()!=null)
				{
					strValorNuevo=detalleactivofijo.getid_detalle_grupo_activo_fijo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleActivoFijoConstantesFunciones.IDDETALLEGRUPOACTIVOFIJO,strValorActual,strValorNuevo);
			}	
			
			if(detalleactivofijo.getIsNew()||!detalleactivofijo.getid_sub_grupo_activo_fijo().equals(detalleactivofijo.getDetalleActivoFijoOriginal().getid_sub_grupo_activo_fijo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleactivofijo.getDetalleActivoFijoOriginal().getid_sub_grupo_activo_fijo()!=null)
				{
					strValorActual=detalleactivofijo.getDetalleActivoFijoOriginal().getid_sub_grupo_activo_fijo().toString();
				}
				if(detalleactivofijo.getid_sub_grupo_activo_fijo()!=null)
				{
					strValorNuevo=detalleactivofijo.getid_sub_grupo_activo_fijo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleActivoFijoConstantesFunciones.IDSUBGRUPOACTIVOFIJO,strValorActual,strValorNuevo);
			}	
			
			if(detalleactivofijo.getIsNew()||!detalleactivofijo.getid_tipo_ramo_activo_fijo().equals(detalleactivofijo.getDetalleActivoFijoOriginal().getid_tipo_ramo_activo_fijo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleactivofijo.getDetalleActivoFijoOriginal().getid_tipo_ramo_activo_fijo()!=null)
				{
					strValorActual=detalleactivofijo.getDetalleActivoFijoOriginal().getid_tipo_ramo_activo_fijo().toString();
				}
				if(detalleactivofijo.getid_tipo_ramo_activo_fijo()!=null)
				{
					strValorNuevo=detalleactivofijo.getid_tipo_ramo_activo_fijo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleActivoFijoConstantesFunciones.IDTIPORAMOACTIVOFIJO,strValorActual,strValorNuevo);
			}	
			
			if(detalleactivofijo.getIsNew()||!detalleactivofijo.getid_tipo_activo_fijo_empresa().equals(detalleactivofijo.getDetalleActivoFijoOriginal().getid_tipo_activo_fijo_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleactivofijo.getDetalleActivoFijoOriginal().getid_tipo_activo_fijo_empresa()!=null)
				{
					strValorActual=detalleactivofijo.getDetalleActivoFijoOriginal().getid_tipo_activo_fijo_empresa().toString();
				}
				if(detalleactivofijo.getid_tipo_activo_fijo_empresa()!=null)
				{
					strValorNuevo=detalleactivofijo.getid_tipo_activo_fijo_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleActivoFijoConstantesFunciones.IDTIPOACTIVOFIJOEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(detalleactivofijo.getIsNew()||!detalleactivofijo.getid_tipo_depreciacion_empresa().equals(detalleactivofijo.getDetalleActivoFijoOriginal().getid_tipo_depreciacion_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleactivofijo.getDetalleActivoFijoOriginal().getid_tipo_depreciacion_empresa()!=null)
				{
					strValorActual=detalleactivofijo.getDetalleActivoFijoOriginal().getid_tipo_depreciacion_empresa().toString();
				}
				if(detalleactivofijo.getid_tipo_depreciacion_empresa()!=null)
				{
					strValorNuevo=detalleactivofijo.getid_tipo_depreciacion_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleActivoFijoConstantesFunciones.IDTIPODEPRECIACIONEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(detalleactivofijo.getIsNew()||!detalleactivofijo.getid_estado_activo_fijo().equals(detalleactivofijo.getDetalleActivoFijoOriginal().getid_estado_activo_fijo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleactivofijo.getDetalleActivoFijoOriginal().getid_estado_activo_fijo()!=null)
				{
					strValorActual=detalleactivofijo.getDetalleActivoFijoOriginal().getid_estado_activo_fijo().toString();
				}
				if(detalleactivofijo.getid_estado_activo_fijo()!=null)
				{
					strValorNuevo=detalleactivofijo.getid_estado_activo_fijo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleActivoFijoConstantesFunciones.IDESTADOACTIVOFIJO,strValorActual,strValorNuevo);
			}	
			
			if(detalleactivofijo.getIsNew()||!detalleactivofijo.getid_cliente().equals(detalleactivofijo.getDetalleActivoFijoOriginal().getid_cliente()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleactivofijo.getDetalleActivoFijoOriginal().getid_cliente()!=null)
				{
					strValorActual=detalleactivofijo.getDetalleActivoFijoOriginal().getid_cliente().toString();
				}
				if(detalleactivofijo.getid_cliente()!=null)
				{
					strValorNuevo=detalleactivofijo.getid_cliente().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleActivoFijoConstantesFunciones.IDCLIENTE,strValorActual,strValorNuevo);
			}	
			
			if(detalleactivofijo.getIsNew()||!detalleactivofijo.getid_partida_presu().equals(detalleactivofijo.getDetalleActivoFijoOriginal().getid_partida_presu()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleactivofijo.getDetalleActivoFijoOriginal().getid_partida_presu()!=null)
				{
					strValorActual=detalleactivofijo.getDetalleActivoFijoOriginal().getid_partida_presu().toString();
				}
				if(detalleactivofijo.getid_partida_presu()!=null)
				{
					strValorNuevo=detalleactivofijo.getid_partida_presu().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleActivoFijoConstantesFunciones.IDPARTIDAPRESU,strValorActual,strValorNuevo);
			}	
			
			if(detalleactivofijo.getIsNew()||!detalleactivofijo.getcodigo().equals(detalleactivofijo.getDetalleActivoFijoOriginal().getcodigo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleactivofijo.getDetalleActivoFijoOriginal().getcodigo()!=null)
				{
					strValorActual=detalleactivofijo.getDetalleActivoFijoOriginal().getcodigo();
				}
				if(detalleactivofijo.getcodigo()!=null)
				{
					strValorNuevo=detalleactivofijo.getcodigo() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleActivoFijoConstantesFunciones.CODIGO,strValorActual,strValorNuevo);
			}	
			
			if(detalleactivofijo.getIsNew()||!detalleactivofijo.getnombre().equals(detalleactivofijo.getDetalleActivoFijoOriginal().getnombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleactivofijo.getDetalleActivoFijoOriginal().getnombre()!=null)
				{
					strValorActual=detalleactivofijo.getDetalleActivoFijoOriginal().getnombre();
				}
				if(detalleactivofijo.getnombre()!=null)
				{
					strValorNuevo=detalleactivofijo.getnombre() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleActivoFijoConstantesFunciones.NOMBRE,strValorActual,strValorNuevo);
			}	
			
			if(detalleactivofijo.getIsNew()||!detalleactivofijo.getserie().equals(detalleactivofijo.getDetalleActivoFijoOriginal().getserie()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleactivofijo.getDetalleActivoFijoOriginal().getserie()!=null)
				{
					strValorActual=detalleactivofijo.getDetalleActivoFijoOriginal().getserie();
				}
				if(detalleactivofijo.getserie()!=null)
				{
					strValorNuevo=detalleactivofijo.getserie() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleActivoFijoConstantesFunciones.SERIE,strValorActual,strValorNuevo);
			}	
			
			if(detalleactivofijo.getIsNew()||!detalleactivofijo.getfecha_compra().equals(detalleactivofijo.getDetalleActivoFijoOriginal().getfecha_compra()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleactivofijo.getDetalleActivoFijoOriginal().getfecha_compra()!=null)
				{
					strValorActual=detalleactivofijo.getDetalleActivoFijoOriginal().getfecha_compra().toString();
				}
				if(detalleactivofijo.getfecha_compra()!=null)
				{
					strValorNuevo=detalleactivofijo.getfecha_compra().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleActivoFijoConstantesFunciones.FECHACOMPRA,strValorActual,strValorNuevo);
			}	
			
			if(detalleactivofijo.getIsNew()||!detalleactivofijo.getfecha_mantenimiento().equals(detalleactivofijo.getDetalleActivoFijoOriginal().getfecha_mantenimiento()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleactivofijo.getDetalleActivoFijoOriginal().getfecha_mantenimiento()!=null)
				{
					strValorActual=detalleactivofijo.getDetalleActivoFijoOriginal().getfecha_mantenimiento().toString();
				}
				if(detalleactivofijo.getfecha_mantenimiento()!=null)
				{
					strValorNuevo=detalleactivofijo.getfecha_mantenimiento().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleActivoFijoConstantesFunciones.FECHAMANTENIMIENTO,strValorActual,strValorNuevo);
			}	
			
			if(detalleactivofijo.getIsNew()||!detalleactivofijo.getfecha_correccion().equals(detalleactivofijo.getDetalleActivoFijoOriginal().getfecha_correccion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleactivofijo.getDetalleActivoFijoOriginal().getfecha_correccion()!=null)
				{
					strValorActual=detalleactivofijo.getDetalleActivoFijoOriginal().getfecha_correccion().toString();
				}
				if(detalleactivofijo.getfecha_correccion()!=null)
				{
					strValorNuevo=detalleactivofijo.getfecha_correccion().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleActivoFijoConstantesFunciones.FECHACORRECCION,strValorActual,strValorNuevo);
			}	
			
			if(detalleactivofijo.getIsNew()||!detalleactivofijo.getfecha_depreciacion().equals(detalleactivofijo.getDetalleActivoFijoOriginal().getfecha_depreciacion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleactivofijo.getDetalleActivoFijoOriginal().getfecha_depreciacion()!=null)
				{
					strValorActual=detalleactivofijo.getDetalleActivoFijoOriginal().getfecha_depreciacion().toString();
				}
				if(detalleactivofijo.getfecha_depreciacion()!=null)
				{
					strValorNuevo=detalleactivofijo.getfecha_depreciacion().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleActivoFijoConstantesFunciones.FECHADEPRECIACION,strValorActual,strValorNuevo);
			}	
			
			if(detalleactivofijo.getIsNew()||!detalleactivofijo.getclave().equals(detalleactivofijo.getDetalleActivoFijoOriginal().getclave()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleactivofijo.getDetalleActivoFijoOriginal().getclave()!=null)
				{
					strValorActual=detalleactivofijo.getDetalleActivoFijoOriginal().getclave();
				}
				if(detalleactivofijo.getclave()!=null)
				{
					strValorNuevo=detalleactivofijo.getclave() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleActivoFijoConstantesFunciones.CLAVE,strValorActual,strValorNuevo);
			}	
			
			if(detalleactivofijo.getIsNew()||!detalleactivofijo.getmarca().equals(detalleactivofijo.getDetalleActivoFijoOriginal().getmarca()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleactivofijo.getDetalleActivoFijoOriginal().getmarca()!=null)
				{
					strValorActual=detalleactivofijo.getDetalleActivoFijoOriginal().getmarca();
				}
				if(detalleactivofijo.getmarca()!=null)
				{
					strValorNuevo=detalleactivofijo.getmarca() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleActivoFijoConstantesFunciones.MARCA,strValorActual,strValorNuevo);
			}	
			
			if(detalleactivofijo.getIsNew()||!detalleactivofijo.getmodelo().equals(detalleactivofijo.getDetalleActivoFijoOriginal().getmodelo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleactivofijo.getDetalleActivoFijoOriginal().getmodelo()!=null)
				{
					strValorActual=detalleactivofijo.getDetalleActivoFijoOriginal().getmodelo();
				}
				if(detalleactivofijo.getmodelo()!=null)
				{
					strValorNuevo=detalleactivofijo.getmodelo() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleActivoFijoConstantesFunciones.MODELO,strValorActual,strValorNuevo);
			}	
			
			if(detalleactivofijo.getIsNew()||!detalleactivofijo.getcolor().equals(detalleactivofijo.getDetalleActivoFijoOriginal().getcolor()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleactivofijo.getDetalleActivoFijoOriginal().getcolor()!=null)
				{
					strValorActual=detalleactivofijo.getDetalleActivoFijoOriginal().getcolor();
				}
				if(detalleactivofijo.getcolor()!=null)
				{
					strValorNuevo=detalleactivofijo.getcolor() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleActivoFijoConstantesFunciones.COLOR,strValorActual,strValorNuevo);
			}	
			
			if(detalleactivofijo.getIsNew()||!detalleactivofijo.getfecha().equals(detalleactivofijo.getDetalleActivoFijoOriginal().getfecha()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleactivofijo.getDetalleActivoFijoOriginal().getfecha()!=null)
				{
					strValorActual=detalleactivofijo.getDetalleActivoFijoOriginal().getfecha().toString();
				}
				if(detalleactivofijo.getfecha()!=null)
				{
					strValorNuevo=detalleactivofijo.getfecha().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleActivoFijoConstantesFunciones.FECHA,strValorActual,strValorNuevo);
			}	
			
			if(detalleactivofijo.getIsNew()||!detalleactivofijo.getvalor_util().equals(detalleactivofijo.getDetalleActivoFijoOriginal().getvalor_util()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleactivofijo.getDetalleActivoFijoOriginal().getvalor_util()!=null)
				{
					strValorActual=detalleactivofijo.getDetalleActivoFijoOriginal().getvalor_util().toString();
				}
				if(detalleactivofijo.getvalor_util()!=null)
				{
					strValorNuevo=detalleactivofijo.getvalor_util().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleActivoFijoConstantesFunciones.VALORUTIL,strValorActual,strValorNuevo);
			}	
			
			if(detalleactivofijo.getIsNew()||!detalleactivofijo.getcosto_de_compra().equals(detalleactivofijo.getDetalleActivoFijoOriginal().getcosto_de_compra()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleactivofijo.getDetalleActivoFijoOriginal().getcosto_de_compra()!=null)
				{
					strValorActual=detalleactivofijo.getDetalleActivoFijoOriginal().getcosto_de_compra().toString();
				}
				if(detalleactivofijo.getcosto_de_compra()!=null)
				{
					strValorNuevo=detalleactivofijo.getcosto_de_compra().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleActivoFijoConstantesFunciones.COSTODECOMPRA,strValorActual,strValorNuevo);
			}	
			
			if(detalleactivofijo.getIsNew()||!detalleactivofijo.getvida_util().equals(detalleactivofijo.getDetalleActivoFijoOriginal().getvida_util()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleactivofijo.getDetalleActivoFijoOriginal().getvida_util()!=null)
				{
					strValorActual=detalleactivofijo.getDetalleActivoFijoOriginal().getvida_util().toString();
				}
				if(detalleactivofijo.getvida_util()!=null)
				{
					strValorNuevo=detalleactivofijo.getvida_util().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleActivoFijoConstantesFunciones.VIDAUTIL,strValorActual,strValorNuevo);
			}	
			
			if(detalleactivofijo.getIsNew()||!detalleactivofijo.getvalor_residual().equals(detalleactivofijo.getDetalleActivoFijoOriginal().getvalor_residual()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleactivofijo.getDetalleActivoFijoOriginal().getvalor_residual()!=null)
				{
					strValorActual=detalleactivofijo.getDetalleActivoFijoOriginal().getvalor_residual().toString();
				}
				if(detalleactivofijo.getvalor_residual()!=null)
				{
					strValorNuevo=detalleactivofijo.getvalor_residual().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleActivoFijoConstantesFunciones.VALORRESIDUAL,strValorActual,strValorNuevo);
			}	
			
			if(detalleactivofijo.getIsNew()||!detalleactivofijo.getcantidad().equals(detalleactivofijo.getDetalleActivoFijoOriginal().getcantidad()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleactivofijo.getDetalleActivoFijoOriginal().getcantidad()!=null)
				{
					strValorActual=detalleactivofijo.getDetalleActivoFijoOriginal().getcantidad().toString();
				}
				if(detalleactivofijo.getcantidad()!=null)
				{
					strValorNuevo=detalleactivofijo.getcantidad().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleActivoFijoConstantesFunciones.CANTIDAD,strValorActual,strValorNuevo);
			}	
			
			if(detalleactivofijo.getIsNew()||!detalleactivofijo.getnombre_propietario().equals(detalleactivofijo.getDetalleActivoFijoOriginal().getnombre_propietario()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleactivofijo.getDetalleActivoFijoOriginal().getnombre_propietario()!=null)
				{
					strValorActual=detalleactivofijo.getDetalleActivoFijoOriginal().getnombre_propietario();
				}
				if(detalleactivofijo.getnombre_propietario()!=null)
				{
					strValorNuevo=detalleactivofijo.getnombre_propietario() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleActivoFijoConstantesFunciones.NOMBREPROPIETARIO,strValorActual,strValorNuevo);
			}	
			
			if(detalleactivofijo.getIsNew()||!detalleactivofijo.getresponsable().equals(detalleactivofijo.getDetalleActivoFijoOriginal().getresponsable()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleactivofijo.getDetalleActivoFijoOriginal().getresponsable()!=null)
				{
					strValorActual=detalleactivofijo.getDetalleActivoFijoOriginal().getresponsable();
				}
				if(detalleactivofijo.getresponsable()!=null)
				{
					strValorNuevo=detalleactivofijo.getresponsable() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleActivoFijoConstantesFunciones.RESPONSABLE,strValorActual,strValorNuevo);
			}	
			
			if(detalleactivofijo.getIsNew()||!detalleactivofijo.getpath_foto().equals(detalleactivofijo.getDetalleActivoFijoOriginal().getpath_foto()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleactivofijo.getDetalleActivoFijoOriginal().getpath_foto()!=null)
				{
					strValorActual=detalleactivofijo.getDetalleActivoFijoOriginal().getpath_foto();
				}
				if(detalleactivofijo.getpath_foto()!=null)
				{
					strValorNuevo=detalleactivofijo.getpath_foto() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleActivoFijoConstantesFunciones.PATHFOTO,strValorActual,strValorNuevo);
			}	
			
			if(detalleactivofijo.getIsNew()||!detalleactivofijo.getnumero_comprobante().equals(detalleactivofijo.getDetalleActivoFijoOriginal().getnumero_comprobante()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleactivofijo.getDetalleActivoFijoOriginal().getnumero_comprobante()!=null)
				{
					strValorActual=detalleactivofijo.getDetalleActivoFijoOriginal().getnumero_comprobante();
				}
				if(detalleactivofijo.getnumero_comprobante()!=null)
				{
					strValorNuevo=detalleactivofijo.getnumero_comprobante() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleActivoFijoConstantesFunciones.NUMEROCOMPROBANTE,strValorActual,strValorNuevo);
			}	
			
			if(detalleactivofijo.getIsNew()||!detalleactivofijo.getreferencia().equals(detalleactivofijo.getDetalleActivoFijoOriginal().getreferencia()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleactivofijo.getDetalleActivoFijoOriginal().getreferencia()!=null)
				{
					strValorActual=detalleactivofijo.getDetalleActivoFijoOriginal().getreferencia();
				}
				if(detalleactivofijo.getreferencia()!=null)
				{
					strValorNuevo=detalleactivofijo.getreferencia() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleActivoFijoConstantesFunciones.REFERENCIA,strValorActual,strValorNuevo);
			}	
			
			if(detalleactivofijo.getIsNew()||!detalleactivofijo.getvalor_cotizacion().equals(detalleactivofijo.getDetalleActivoFijoOriginal().getvalor_cotizacion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleactivofijo.getDetalleActivoFijoOriginal().getvalor_cotizacion()!=null)
				{
					strValorActual=detalleactivofijo.getDetalleActivoFijoOriginal().getvalor_cotizacion().toString();
				}
				if(detalleactivofijo.getvalor_cotizacion()!=null)
				{
					strValorNuevo=detalleactivofijo.getvalor_cotizacion().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleActivoFijoConstantesFunciones.VALORCOTIZACION,strValorActual,strValorNuevo);
			}	
			
			if(detalleactivofijo.getIsNew()||!detalleactivofijo.getcon_partes().equals(detalleactivofijo.getDetalleActivoFijoOriginal().getcon_partes()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleactivofijo.getDetalleActivoFijoOriginal().getcon_partes()!=null)
				{
					strValorActual=detalleactivofijo.getDetalleActivoFijoOriginal().getcon_partes().toString();
				}
				if(detalleactivofijo.getcon_partes()!=null)
				{
					strValorNuevo=detalleactivofijo.getcon_partes().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleActivoFijoConstantesFunciones.CONPARTES,strValorActual,strValorNuevo);
			}	
			
			if(detalleactivofijo.getIsNew()||!detalleactivofijo.getcon_garantia().equals(detalleactivofijo.getDetalleActivoFijoOriginal().getcon_garantia()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleactivofijo.getDetalleActivoFijoOriginal().getcon_garantia()!=null)
				{
					strValorActual=detalleactivofijo.getDetalleActivoFijoOriginal().getcon_garantia().toString();
				}
				if(detalleactivofijo.getcon_garantia()!=null)
				{
					strValorNuevo=detalleactivofijo.getcon_garantia().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleActivoFijoConstantesFunciones.CONGARANTIA,strValorActual,strValorNuevo);
			}	
			
			if(detalleactivofijo.getIsNew()||!detalleactivofijo.getcon_existencia().equals(detalleactivofijo.getDetalleActivoFijoOriginal().getcon_existencia()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleactivofijo.getDetalleActivoFijoOriginal().getcon_existencia()!=null)
				{
					strValorActual=detalleactivofijo.getDetalleActivoFijoOriginal().getcon_existencia().toString();
				}
				if(detalleactivofijo.getcon_existencia()!=null)
				{
					strValorNuevo=detalleactivofijo.getcon_existencia().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleActivoFijoConstantesFunciones.CONEXISTENCIA,strValorActual,strValorNuevo);
			}	
			
			if(detalleactivofijo.getIsNew()||!detalleactivofijo.getfecha_baja().equals(detalleactivofijo.getDetalleActivoFijoOriginal().getfecha_baja()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleactivofijo.getDetalleActivoFijoOriginal().getfecha_baja()!=null)
				{
					strValorActual=detalleactivofijo.getDetalleActivoFijoOriginal().getfecha_baja().toString();
				}
				if(detalleactivofijo.getfecha_baja()!=null)
				{
					strValorNuevo=detalleactivofijo.getfecha_baja().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleActivoFijoConstantesFunciones.FECHABAJA,strValorActual,strValorNuevo);
			}	
			
			if(detalleactivofijo.getIsNew()||!detalleactivofijo.getpath_foto2().equals(detalleactivofijo.getDetalleActivoFijoOriginal().getpath_foto2()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleactivofijo.getDetalleActivoFijoOriginal().getpath_foto2()!=null)
				{
					strValorActual=detalleactivofijo.getDetalleActivoFijoOriginal().getpath_foto2();
				}
				if(detalleactivofijo.getpath_foto2()!=null)
				{
					strValorNuevo=detalleactivofijo.getpath_foto2() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleActivoFijoConstantesFunciones.PATHFOTO2,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveDetalleActivoFijoRelacionesWithConnection(DetalleActivoFijo detalleactivofijo,List<MantenimientoActivoFijo> mantenimientoactivofijos,List<ServicioTransporte> serviciotransportes,List<MovimientoActivoFijo> movimientoactivofijoDestinos,List<Vehiculo> vehiculos,List<MetodoDepreciacion> metododepreciacions,List<ResponsableActivoFijo> responsableactivofijos,List<DepreciacionActivoFijo> depreciacionactivofijos,List<GastoDepreciacionCentroCosto> gastodepreciacioncentrocostos,List<ParteActivoFijo> parteactivofijos) throws Exception {

		if(!detalleactivofijo.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveDetalleActivoFijoRelacionesBase(detalleactivofijo,mantenimientoactivofijos,serviciotransportes,movimientoactivofijoDestinos,vehiculos,metododepreciacions,responsableactivofijos,depreciacionactivofijos,gastodepreciacioncentrocostos,parteactivofijos,true);
		}
	}

	public void saveDetalleActivoFijoRelaciones(DetalleActivoFijo detalleactivofijo,List<MantenimientoActivoFijo> mantenimientoactivofijos,List<ServicioTransporte> serviciotransportes,List<MovimientoActivoFijo> movimientoactivofijoDestinos,List<Vehiculo> vehiculos,List<MetodoDepreciacion> metododepreciacions,List<ResponsableActivoFijo> responsableactivofijos,List<DepreciacionActivoFijo> depreciacionactivofijos,List<GastoDepreciacionCentroCosto> gastodepreciacioncentrocostos,List<ParteActivoFijo> parteactivofijos)throws Exception {

		if(!detalleactivofijo.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveDetalleActivoFijoRelacionesBase(detalleactivofijo,mantenimientoactivofijos,serviciotransportes,movimientoactivofijoDestinos,vehiculos,metododepreciacions,responsableactivofijos,depreciacionactivofijos,gastodepreciacioncentrocostos,parteactivofijos,false);
		}
	}

	public void saveDetalleActivoFijoRelacionesBase(DetalleActivoFijo detalleactivofijo,List<MantenimientoActivoFijo> mantenimientoactivofijos,List<ServicioTransporte> serviciotransportes,List<MovimientoActivoFijo> movimientoactivofijoDestinos,List<Vehiculo> vehiculos,List<MetodoDepreciacion> metododepreciacions,List<ResponsableActivoFijo> responsableactivofijos,List<DepreciacionActivoFijo> depreciacionactivofijos,List<GastoDepreciacionCentroCosto> gastodepreciacioncentrocostos,List<ParteActivoFijo> parteactivofijos,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("DetalleActivoFijo-saveRelacionesWithConnection");}
	
			detalleactivofijo.setMantenimientoActivoFijos(mantenimientoactivofijos);
			detalleactivofijo.setServicioTransportes(serviciotransportes);
			detalleactivofijo.setMovimientoActivoFijoDestinos(movimientoactivofijoDestinos);
			detalleactivofijo.setVehiculos(vehiculos);
			detalleactivofijo.setMetodoDepreciacions(metododepreciacions);
			detalleactivofijo.setResponsableActivoFijos(responsableactivofijos);
			detalleactivofijo.setDepreciacionActivoFijos(depreciacionactivofijos);
			detalleactivofijo.setGastoDepreciacionCentroCostos(gastodepreciacioncentrocostos);
			detalleactivofijo.setParteActivoFijos(parteactivofijos);

			this.setDetalleActivoFijo(detalleactivofijo);

			if(DetalleActivoFijoLogicAdditional.validarSaveRelaciones(detalleactivofijo,this)) {

				DetalleActivoFijoLogicAdditional.updateRelacionesToSave(detalleactivofijo,this);

				if((detalleactivofijo.getIsNew()||detalleactivofijo.getIsChanged())&&!detalleactivofijo.getIsDeleted()) {
					this.saveDetalleActivoFijo();
					this.saveDetalleActivoFijoRelacionesDetalles(mantenimientoactivofijos,serviciotransportes,movimientoactivofijoDestinos,vehiculos,metododepreciacions,responsableactivofijos,depreciacionactivofijos,gastodepreciacioncentrocostos,parteactivofijos);

				} else if(detalleactivofijo.getIsDeleted()) {
					this.saveDetalleActivoFijoRelacionesDetalles(mantenimientoactivofijos,serviciotransportes,movimientoactivofijoDestinos,vehiculos,metododepreciacions,responsableactivofijos,depreciacionactivofijos,gastodepreciacioncentrocostos,parteactivofijos);
					this.saveDetalleActivoFijo();
				}

				DetalleActivoFijoLogicAdditional.updateRelacionesToSaveAfter(detalleactivofijo,this);

			} else {
				throw new Exception("LOS DATOS SON INVALIDOS");
			}

			if(conConexion) {connexion.commit();}

		} catch(Exception e) {
			
			MantenimientoActivoFijoConstantesFunciones.InicializarGeneralEntityAuxiliaresMantenimientoActivoFijos(mantenimientoactivofijos,true,true);
			ServicioTransporteConstantesFunciones.InicializarGeneralEntityAuxiliaresServicioTransportes(serviciotransportes,true,true);
			MovimientoActivoFijoConstantesFunciones.InicializarGeneralEntityAuxiliaresMovimientoActivoFijos(movimientoactivofijoDestinos,true,true);
			VehiculoConstantesFunciones.InicializarGeneralEntityAuxiliaresVehiculos(vehiculos,true,true);
			MetodoDepreciacionConstantesFunciones.InicializarGeneralEntityAuxiliaresMetodoDepreciacions(metododepreciacions,true,true);
			ResponsableActivoFijoConstantesFunciones.InicializarGeneralEntityAuxiliaresResponsableActivoFijos(responsableactivofijos,true,true);
			DepreciacionActivoFijoConstantesFunciones.InicializarGeneralEntityAuxiliaresDepreciacionActivoFijos(depreciacionactivofijos,true,true);
			GastoDepreciacionCentroCostoConstantesFunciones.InicializarGeneralEntityAuxiliaresGastoDepreciacionCentroCostos(gastodepreciacioncentrocostos,true,true);
			ParteActivoFijoConstantesFunciones.InicializarGeneralEntityAuxiliaresParteActivoFijos(parteactivofijos,true,true);

			if(conConexion){connexion.rollback();}
			Funciones.manageException(logger,e);
			throw e;

		} finally {
			if(conConexion){this.closeNewConnexionToDeep();}
		}
	}
	
	
	private void saveDetalleActivoFijoRelacionesDetalles(List<MantenimientoActivoFijo> mantenimientoactivofijos,List<ServicioTransporte> serviciotransportes,List<MovimientoActivoFijo> movimientoactivofijoDestinos,List<Vehiculo> vehiculos,List<MetodoDepreciacion> metododepreciacions,List<ResponsableActivoFijo> responsableactivofijos,List<DepreciacionActivoFijo> depreciacionactivofijos,List<GastoDepreciacionCentroCosto> gastodepreciacioncentrocostos,List<ParteActivoFijo> parteactivofijos)throws Exception {
		try {
	

			Long idDetalleActivoFijoActual=this.getDetalleActivoFijo().getId();

			MantenimientoActivoFijoLogic mantenimientoactivofijoLogic_Desde_DetalleActivoFijo=new MantenimientoActivoFijoLogic();
			mantenimientoactivofijoLogic_Desde_DetalleActivoFijo.setMantenimientoActivoFijos(mantenimientoactivofijos);

			mantenimientoactivofijoLogic_Desde_DetalleActivoFijo.setConnexion(this.getConnexion());
			mantenimientoactivofijoLogic_Desde_DetalleActivoFijo.setDatosCliente(this.datosCliente);

			for(MantenimientoActivoFijo mantenimientoactivofijo_Desde_DetalleActivoFijo:mantenimientoactivofijoLogic_Desde_DetalleActivoFijo.getMantenimientoActivoFijos()) {
				mantenimientoactivofijo_Desde_DetalleActivoFijo.setid_detalle_activo_fijo(idDetalleActivoFijoActual);
			}

			mantenimientoactivofijoLogic_Desde_DetalleActivoFijo.saveMantenimientoActivoFijos();

			ServicioTransporteLogic serviciotransporteLogic_Desde_DetalleActivoFijo=new ServicioTransporteLogic();
			serviciotransporteLogic_Desde_DetalleActivoFijo.setServicioTransportes(serviciotransportes);

			serviciotransporteLogic_Desde_DetalleActivoFijo.setConnexion(this.getConnexion());
			serviciotransporteLogic_Desde_DetalleActivoFijo.setDatosCliente(this.datosCliente);

			for(ServicioTransporte serviciotransporte_Desde_DetalleActivoFijo:serviciotransporteLogic_Desde_DetalleActivoFijo.getServicioTransportes()) {
				serviciotransporte_Desde_DetalleActivoFijo.setid_detalle_activo_fijo(idDetalleActivoFijoActual);

				serviciotransporteLogic_Desde_DetalleActivoFijo.setServicioTransporte(serviciotransporte_Desde_DetalleActivoFijo);
				serviciotransporteLogic_Desde_DetalleActivoFijo.saveServicioTransporte();

				Long idServicioTransporteActual=serviciotransporte_Desde_DetalleActivoFijo.getId();

				DetalleServicioTransporteLogic detalleserviciotransporteLogic_Desde_ServicioTransporte=new DetalleServicioTransporteLogic();

				if(serviciotransporte_Desde_DetalleActivoFijo.getDetalleServicioTransportes()==null){
					serviciotransporte_Desde_DetalleActivoFijo.setDetalleServicioTransportes(new ArrayList<DetalleServicioTransporte>());
				}

				detalleserviciotransporteLogic_Desde_ServicioTransporte.setDetalleServicioTransportes(serviciotransporte_Desde_DetalleActivoFijo.getDetalleServicioTransportes());

				detalleserviciotransporteLogic_Desde_ServicioTransporte.setConnexion(this.getConnexion());
				detalleserviciotransporteLogic_Desde_ServicioTransporte.setDatosCliente(this.datosCliente);

				for(DetalleServicioTransporte detalleserviciotransporte_Desde_ServicioTransporte:detalleserviciotransporteLogic_Desde_ServicioTransporte.getDetalleServicioTransportes()) {
					detalleserviciotransporte_Desde_ServicioTransporte.setid_servicio_transporte(idServicioTransporteActual);
				}

				detalleserviciotransporteLogic_Desde_ServicioTransporte.saveDetalleServicioTransportes();
			}


			MovimientoActivoFijoLogic movimientoactivofijoDestinoLogic_Desde_DetalleActivoFijo=new MovimientoActivoFijoLogic();
			movimientoactivofijoDestinoLogic_Desde_DetalleActivoFijo.setMovimientoActivoFijos(movimientoactivofijoDestinos);

			movimientoactivofijoDestinoLogic_Desde_DetalleActivoFijo.setConnexion(this.getConnexion());
			movimientoactivofijoDestinoLogic_Desde_DetalleActivoFijo.setDatosCliente(this.datosCliente);

			for(MovimientoActivoFijo movimientoactivofijo_Desde_DetalleActivoFijo:movimientoactivofijoDestinoLogic_Desde_DetalleActivoFijo.getMovimientoActivoFijos()) {
				movimientoactivofijo_Desde_DetalleActivoFijo.setid_detalle_activo_fijo_destino(idDetalleActivoFijoActual);
			}

			movimientoactivofijoDestinoLogic_Desde_DetalleActivoFijo.saveMovimientoActivoFijos();

			VehiculoLogic vehiculoLogic_Desde_DetalleActivoFijo=new VehiculoLogic();
			vehiculoLogic_Desde_DetalleActivoFijo.setVehiculos(vehiculos);

			vehiculoLogic_Desde_DetalleActivoFijo.setConnexion(this.getConnexion());
			vehiculoLogic_Desde_DetalleActivoFijo.setDatosCliente(this.datosCliente);

			for(Vehiculo vehiculo_Desde_DetalleActivoFijo:vehiculoLogic_Desde_DetalleActivoFijo.getVehiculos()) {
				vehiculo_Desde_DetalleActivoFijo.setid_detalle_activo_fijo(idDetalleActivoFijoActual);

				vehiculoLogic_Desde_DetalleActivoFijo.setVehiculo(vehiculo_Desde_DetalleActivoFijo);
				vehiculoLogic_Desde_DetalleActivoFijo.saveVehiculo();

				Long idVehiculoActual=vehiculo_Desde_DetalleActivoFijo.getId();

				ServicioTransporteLogic serviciotransporteLogic_Desde_Vehiculo=new ServicioTransporteLogic();

				if(vehiculo_Desde_DetalleActivoFijo.getServicioTransportes()==null){
					vehiculo_Desde_DetalleActivoFijo.setServicioTransportes(new ArrayList<ServicioTransporte>());
				}

				serviciotransporteLogic_Desde_Vehiculo.setServicioTransportes(vehiculo_Desde_DetalleActivoFijo.getServicioTransportes());

				serviciotransporteLogic_Desde_Vehiculo.setConnexion(this.getConnexion());
				serviciotransporteLogic_Desde_Vehiculo.setDatosCliente(this.datosCliente);

				for(ServicioTransporte serviciotransporte_Desde_Vehiculo:serviciotransporteLogic_Desde_Vehiculo.getServicioTransportes()) {
					serviciotransporte_Desde_Vehiculo.setid_vehiculo(idVehiculoActual);

					serviciotransporteLogic_Desde_Vehiculo.setServicioTransporte(serviciotransporte_Desde_Vehiculo);
					serviciotransporteLogic_Desde_Vehiculo.saveServicioTransporte();

					Long idServicioTransporteActual=serviciotransporte_Desde_Vehiculo.getId();

					DetalleServicioTransporteLogic detalleserviciotransporteLogic_Desde_ServicioTransporte=new DetalleServicioTransporteLogic();

					if(serviciotransporte_Desde_Vehiculo.getDetalleServicioTransportes()==null){
						serviciotransporte_Desde_Vehiculo.setDetalleServicioTransportes(new ArrayList<DetalleServicioTransporte>());
					}

					detalleserviciotransporteLogic_Desde_ServicioTransporte.setDetalleServicioTransportes(serviciotransporte_Desde_Vehiculo.getDetalleServicioTransportes());

					detalleserviciotransporteLogic_Desde_ServicioTransporte.setConnexion(this.getConnexion());
					detalleserviciotransporteLogic_Desde_ServicioTransporte.setDatosCliente(this.datosCliente);

					for(DetalleServicioTransporte detalleserviciotransporte_Desde_ServicioTransporte:detalleserviciotransporteLogic_Desde_ServicioTransporte.getDetalleServicioTransportes()) {
						detalleserviciotransporte_Desde_ServicioTransporte.setid_servicio_transporte(idServicioTransporteActual);
					}

					detalleserviciotransporteLogic_Desde_ServicioTransporte.saveDetalleServicioTransportes();
				}

			}


			MetodoDepreciacionLogic metododepreciacionLogic_Desde_DetalleActivoFijo=new MetodoDepreciacionLogic();
			metododepreciacionLogic_Desde_DetalleActivoFijo.setMetodoDepreciacions(metododepreciacions);

			metododepreciacionLogic_Desde_DetalleActivoFijo.setConnexion(this.getConnexion());
			metododepreciacionLogic_Desde_DetalleActivoFijo.setDatosCliente(this.datosCliente);

			for(MetodoDepreciacion metododepreciacion_Desde_DetalleActivoFijo:metododepreciacionLogic_Desde_DetalleActivoFijo.getMetodoDepreciacions()) {
				metododepreciacion_Desde_DetalleActivoFijo.setid_detalle_activo_fijo(idDetalleActivoFijoActual);
			}

			metododepreciacionLogic_Desde_DetalleActivoFijo.saveMetodoDepreciacions();

			ResponsableActivoFijoLogic responsableactivofijoLogic_Desde_DetalleActivoFijo=new ResponsableActivoFijoLogic();
			responsableactivofijoLogic_Desde_DetalleActivoFijo.setResponsableActivoFijos(responsableactivofijos);

			responsableactivofijoLogic_Desde_DetalleActivoFijo.setConnexion(this.getConnexion());
			responsableactivofijoLogic_Desde_DetalleActivoFijo.setDatosCliente(this.datosCliente);

			for(ResponsableActivoFijo responsableactivofijo_Desde_DetalleActivoFijo:responsableactivofijoLogic_Desde_DetalleActivoFijo.getResponsableActivoFijos()) {
				responsableactivofijo_Desde_DetalleActivoFijo.setid_detalle_activo_fijo(idDetalleActivoFijoActual);
			}

			responsableactivofijoLogic_Desde_DetalleActivoFijo.saveResponsableActivoFijos();

			DepreciacionActivoFijoLogic depreciacionactivofijoLogic_Desde_DetalleActivoFijo=new DepreciacionActivoFijoLogic();
			depreciacionactivofijoLogic_Desde_DetalleActivoFijo.setDepreciacionActivoFijos(depreciacionactivofijos);

			depreciacionactivofijoLogic_Desde_DetalleActivoFijo.setConnexion(this.getConnexion());
			depreciacionactivofijoLogic_Desde_DetalleActivoFijo.setDatosCliente(this.datosCliente);

			for(DepreciacionActivoFijo depreciacionactivofijo_Desde_DetalleActivoFijo:depreciacionactivofijoLogic_Desde_DetalleActivoFijo.getDepreciacionActivoFijos()) {
				depreciacionactivofijo_Desde_DetalleActivoFijo.setid_detalle_activo_fijo(idDetalleActivoFijoActual);
			}

			depreciacionactivofijoLogic_Desde_DetalleActivoFijo.saveDepreciacionActivoFijos();

			GastoDepreciacionCentroCostoLogic gastodepreciacioncentrocostoLogic_Desde_DetalleActivoFijo=new GastoDepreciacionCentroCostoLogic();
			gastodepreciacioncentrocostoLogic_Desde_DetalleActivoFijo.setGastoDepreciacionCentroCostos(gastodepreciacioncentrocostos);

			gastodepreciacioncentrocostoLogic_Desde_DetalleActivoFijo.setConnexion(this.getConnexion());
			gastodepreciacioncentrocostoLogic_Desde_DetalleActivoFijo.setDatosCliente(this.datosCliente);

			for(GastoDepreciacionCentroCosto gastodepreciacioncentrocosto_Desde_DetalleActivoFijo:gastodepreciacioncentrocostoLogic_Desde_DetalleActivoFijo.getGastoDepreciacionCentroCostos()) {
				gastodepreciacioncentrocosto_Desde_DetalleActivoFijo.setid_detalle_activo_fijo(idDetalleActivoFijoActual);
			}

			gastodepreciacioncentrocostoLogic_Desde_DetalleActivoFijo.saveGastoDepreciacionCentroCostos();

			ParteActivoFijoLogic parteactivofijoLogic_Desde_DetalleActivoFijo=new ParteActivoFijoLogic();
			parteactivofijoLogic_Desde_DetalleActivoFijo.setParteActivoFijos(parteactivofijos);

			parteactivofijoLogic_Desde_DetalleActivoFijo.setConnexion(this.getConnexion());
			parteactivofijoLogic_Desde_DetalleActivoFijo.setDatosCliente(this.datosCliente);

			for(ParteActivoFijo parteactivofijo_Desde_DetalleActivoFijo:parteactivofijoLogic_Desde_DetalleActivoFijo.getParteActivoFijos()) {
				parteactivofijo_Desde_DetalleActivoFijo.setid_detalle_activo_fijo(idDetalleActivoFijoActual);
			}

			parteactivofijoLogic_Desde_DetalleActivoFijo.saveParteActivoFijos();

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfDetalleActivoFijo(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=DetalleActivoFijoConstantesFunciones.getClassesForeignKeysOfDetalleActivoFijo(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfDetalleActivoFijo(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=DetalleActivoFijoConstantesFunciones.getClassesRelationshipsOfDetalleActivoFijo(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

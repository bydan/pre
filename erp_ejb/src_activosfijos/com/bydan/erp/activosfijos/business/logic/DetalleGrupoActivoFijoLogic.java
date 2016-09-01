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
import com.bydan.erp.activosfijos.util.DetalleGrupoActivoFijoConstantesFunciones;
import com.bydan.erp.activosfijos.util.DetalleGrupoActivoFijoParameterReturnGeneral;
//import com.bydan.erp.activosfijos.util.DetalleGrupoActivoFijoParameterGeneral;
import com.bydan.erp.activosfijos.business.entity.DetalleGrupoActivoFijo;
import com.bydan.erp.activosfijos.business.logic.DetalleGrupoActivoFijoLogicAdditional;
import com.bydan.erp.activosfijos.business.dataaccess.*;
import com.bydan.erp.activosfijos.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.activosfijos.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;
import com.bydan.erp.contabilidad.business.logic.*;
import com.bydan.erp.cartera.business.logic.*;
import com.bydan.erp.facturacion.business.logic.*;
import com.bydan.erp.activosfijos.business.logic.*;
import com.bydan.erp.tesoreria.business.logic.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.facturacion.util.*;
import com.bydan.erp.activosfijos.util.*;
import com.bydan.erp.tesoreria.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;
import com.bydan.erp.cartera.business.dataaccess.*;
import com.bydan.erp.facturacion.business.dataaccess.*;
import com.bydan.erp.activosfijos.business.dataaccess.*;
import com.bydan.erp.tesoreria.business.dataaccess.*;








@SuppressWarnings("unused")
public class DetalleGrupoActivoFijoLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(DetalleGrupoActivoFijoLogic.class);
	
	protected DetalleGrupoActivoFijoDataAccess detallegrupoactivofijoDataAccess; 	
	protected DetalleGrupoActivoFijo detallegrupoactivofijo;
	protected List<DetalleGrupoActivoFijo> detallegrupoactivofijos;
	protected Object detallegrupoactivofijoObject;	
	protected List<Object> detallegrupoactivofijosObject;
	
	public static ClassValidator<DetalleGrupoActivoFijo> detallegrupoactivofijoValidator = new ClassValidator<DetalleGrupoActivoFijo>(DetalleGrupoActivoFijo.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected DetalleGrupoActivoFijoLogicAdditional detallegrupoactivofijoLogicAdditional=null;
	
	public DetalleGrupoActivoFijoLogicAdditional getDetalleGrupoActivoFijoLogicAdditional() {
		return this.detallegrupoactivofijoLogicAdditional;
	}
	
	public void setDetalleGrupoActivoFijoLogicAdditional(DetalleGrupoActivoFijoLogicAdditional detallegrupoactivofijoLogicAdditional) {
		try {
			this.detallegrupoactivofijoLogicAdditional=detallegrupoactivofijoLogicAdditional;
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
	
	
	
	
	public  DetalleGrupoActivoFijoLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.detallegrupoactivofijoDataAccess = new DetalleGrupoActivoFijoDataAccess();
			
			this.detallegrupoactivofijos= new ArrayList<DetalleGrupoActivoFijo>();
			this.detallegrupoactivofijo= new DetalleGrupoActivoFijo();
			
			this.detallegrupoactivofijoObject=new Object();
			this.detallegrupoactivofijosObject=new ArrayList<Object>();
				
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
			
			this.detallegrupoactivofijoDataAccess.setConnexionType(this.connexionType);
			this.detallegrupoactivofijoDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  DetalleGrupoActivoFijoLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.detallegrupoactivofijoDataAccess = new DetalleGrupoActivoFijoDataAccess();
			this.detallegrupoactivofijos= new ArrayList<DetalleGrupoActivoFijo>();
			this.detallegrupoactivofijo= new DetalleGrupoActivoFijo();
			this.detallegrupoactivofijoObject=new Object();
			this.detallegrupoactivofijosObject=new ArrayList<Object>();
			
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
			
			this.detallegrupoactivofijoDataAccess.setConnexionType(this.connexionType);
			this.detallegrupoactivofijoDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public DetalleGrupoActivoFijo getDetalleGrupoActivoFijo() throws Exception {	
		DetalleGrupoActivoFijoLogicAdditional.checkDetalleGrupoActivoFijoToGet(detallegrupoactivofijo,this.datosCliente,this.arrDatoGeneral);
		DetalleGrupoActivoFijoLogicAdditional.updateDetalleGrupoActivoFijoToGet(detallegrupoactivofijo,this.arrDatoGeneral);
		
		return detallegrupoactivofijo;
	}
		
	public void setDetalleGrupoActivoFijo(DetalleGrupoActivoFijo newDetalleGrupoActivoFijo) {
		this.detallegrupoactivofijo = newDetalleGrupoActivoFijo;
	}
	
	public DetalleGrupoActivoFijoDataAccess getDetalleGrupoActivoFijoDataAccess() {
		return detallegrupoactivofijoDataAccess;
	}
	
	public void setDetalleGrupoActivoFijoDataAccess(DetalleGrupoActivoFijoDataAccess newdetallegrupoactivofijoDataAccess) {
		this.detallegrupoactivofijoDataAccess = newdetallegrupoactivofijoDataAccess;
	}
	
	public List<DetalleGrupoActivoFijo> getDetalleGrupoActivoFijos() throws Exception {		
		this.quitarDetalleGrupoActivoFijosNulos();
		
		DetalleGrupoActivoFijoLogicAdditional.checkDetalleGrupoActivoFijoToGets(detallegrupoactivofijos,this.datosCliente,this.arrDatoGeneral);
		
		for (DetalleGrupoActivoFijo detallegrupoactivofijoLocal: detallegrupoactivofijos ) {
			DetalleGrupoActivoFijoLogicAdditional.updateDetalleGrupoActivoFijoToGet(detallegrupoactivofijoLocal,this.arrDatoGeneral);
		}
		
		return detallegrupoactivofijos;
	}
	
	public void setDetalleGrupoActivoFijos(List<DetalleGrupoActivoFijo> newDetalleGrupoActivoFijos) {
		this.detallegrupoactivofijos = newDetalleGrupoActivoFijos;
	}
	
	public Object getDetalleGrupoActivoFijoObject() {	
		this.detallegrupoactivofijoObject=this.detallegrupoactivofijoDataAccess.getEntityObject();
		return this.detallegrupoactivofijoObject;
	}
		
	public void setDetalleGrupoActivoFijoObject(Object newDetalleGrupoActivoFijoObject) {
		this.detallegrupoactivofijoObject = newDetalleGrupoActivoFijoObject;
	}
	
	public List<Object> getDetalleGrupoActivoFijosObject() {		
		this.detallegrupoactivofijosObject=this.detallegrupoactivofijoDataAccess.getEntitiesObject();
		return this.detallegrupoactivofijosObject;
	}
		
	public void setDetalleGrupoActivoFijosObject(List<Object> newDetalleGrupoActivoFijosObject) {
		this.detallegrupoactivofijosObject = newDetalleGrupoActivoFijosObject;
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
		
		if(this.detallegrupoactivofijoDataAccess!=null) {
			this.detallegrupoactivofijoDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleGrupoActivoFijo.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			detallegrupoactivofijoDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			detallegrupoactivofijoDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		detallegrupoactivofijo = new  DetalleGrupoActivoFijo();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleGrupoActivoFijo.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			detallegrupoactivofijo=detallegrupoactivofijoDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.detallegrupoactivofijo,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				DetalleGrupoActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesDetalleGrupoActivoFijo(this.detallegrupoactivofijo);
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
		detallegrupoactivofijo = new  DetalleGrupoActivoFijo();
		  		  
        try {
			
			detallegrupoactivofijo=detallegrupoactivofijoDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.detallegrupoactivofijo,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				DetalleGrupoActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesDetalleGrupoActivoFijo(this.detallegrupoactivofijo);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		detallegrupoactivofijo = new  DetalleGrupoActivoFijo();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleGrupoActivoFijo.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			detallegrupoactivofijo=detallegrupoactivofijoDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.detallegrupoactivofijo,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				DetalleGrupoActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesDetalleGrupoActivoFijo(this.detallegrupoactivofijo);
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
		detallegrupoactivofijo = new  DetalleGrupoActivoFijo();
		  		  
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
		detallegrupoactivofijo = new  DetalleGrupoActivoFijo();
		  		  
        try {
			
			detallegrupoactivofijo=detallegrupoactivofijoDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.detallegrupoactivofijo,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				DetalleGrupoActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesDetalleGrupoActivoFijo(this.detallegrupoactivofijo);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		detallegrupoactivofijo = new  DetalleGrupoActivoFijo();
		  		  
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
		detallegrupoactivofijo = new  DetalleGrupoActivoFijo();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleGrupoActivoFijo.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =detallegrupoactivofijoDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		detallegrupoactivofijo = new  DetalleGrupoActivoFijo();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=detallegrupoactivofijoDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		detallegrupoactivofijo = new  DetalleGrupoActivoFijo();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleGrupoActivoFijo.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =detallegrupoactivofijoDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		detallegrupoactivofijo = new  DetalleGrupoActivoFijo();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=detallegrupoactivofijoDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		detallegrupoactivofijo = new  DetalleGrupoActivoFijo();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleGrupoActivoFijo.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =detallegrupoactivofijoDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		detallegrupoactivofijo = new  DetalleGrupoActivoFijo();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=detallegrupoactivofijoDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		detallegrupoactivofijos = new  ArrayList<DetalleGrupoActivoFijo>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleGrupoActivoFijo.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			DetalleGrupoActivoFijoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detallegrupoactivofijos=detallegrupoactivofijoDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarDetalleGrupoActivoFijo(detallegrupoactivofijos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleGrupoActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesDetalleGrupoActivoFijo(this.detallegrupoactivofijos);
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
		detallegrupoactivofijos = new  ArrayList<DetalleGrupoActivoFijo>();
		  		  
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
		detallegrupoactivofijos = new  ArrayList<DetalleGrupoActivoFijo>();
		  		  
        try {			
			DetalleGrupoActivoFijoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detallegrupoactivofijos=detallegrupoactivofijoDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarDetalleGrupoActivoFijo(detallegrupoactivofijos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleGrupoActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesDetalleGrupoActivoFijo(this.detallegrupoactivofijos);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		detallegrupoactivofijos = new  ArrayList<DetalleGrupoActivoFijo>();
		  		  
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
		detallegrupoactivofijos = new  ArrayList<DetalleGrupoActivoFijo>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleGrupoActivoFijo.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			DetalleGrupoActivoFijoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detallegrupoactivofijos=detallegrupoactivofijoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarDetalleGrupoActivoFijo(detallegrupoactivofijos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleGrupoActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesDetalleGrupoActivoFijo(this.detallegrupoactivofijos);
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
		detallegrupoactivofijos = new  ArrayList<DetalleGrupoActivoFijo>();
		  		  
        try {
			DetalleGrupoActivoFijoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detallegrupoactivofijos=detallegrupoactivofijoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarDetalleGrupoActivoFijo(detallegrupoactivofijos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleGrupoActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesDetalleGrupoActivoFijo(this.detallegrupoactivofijos);
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
		detallegrupoactivofijos = new  ArrayList<DetalleGrupoActivoFijo>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleGrupoActivoFijo.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DetalleGrupoActivoFijoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detallegrupoactivofijos=detallegrupoactivofijoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarDetalleGrupoActivoFijo(detallegrupoactivofijos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleGrupoActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesDetalleGrupoActivoFijo(this.detallegrupoactivofijos);
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
		detallegrupoactivofijos = new  ArrayList<DetalleGrupoActivoFijo>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DetalleGrupoActivoFijoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detallegrupoactivofijos=detallegrupoactivofijoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarDetalleGrupoActivoFijo(detallegrupoactivofijos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleGrupoActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesDetalleGrupoActivoFijo(this.detallegrupoactivofijos);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		detallegrupoactivofijo = new  DetalleGrupoActivoFijo();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleGrupoActivoFijo.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DetalleGrupoActivoFijoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detallegrupoactivofijo=detallegrupoactivofijoDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarDetalleGrupoActivoFijo(detallegrupoactivofijo);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleGrupoActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesDetalleGrupoActivoFijo(this.detallegrupoactivofijo);
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
		detallegrupoactivofijo = new  DetalleGrupoActivoFijo();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DetalleGrupoActivoFijoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detallegrupoactivofijo=detallegrupoactivofijoDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarDetalleGrupoActivoFijo(detallegrupoactivofijo);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleGrupoActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesDetalleGrupoActivoFijo(this.detallegrupoactivofijo);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		detallegrupoactivofijos = new  ArrayList<DetalleGrupoActivoFijo>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleGrupoActivoFijo.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			DetalleGrupoActivoFijoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detallegrupoactivofijos=detallegrupoactivofijoDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarDetalleGrupoActivoFijo(detallegrupoactivofijos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleGrupoActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesDetalleGrupoActivoFijo(this.detallegrupoactivofijos);
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
		detallegrupoactivofijos = new  ArrayList<DetalleGrupoActivoFijo>();
		  		  
        try {
			DetalleGrupoActivoFijoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detallegrupoactivofijos=detallegrupoactivofijoDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarDetalleGrupoActivoFijo(detallegrupoactivofijos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleGrupoActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesDetalleGrupoActivoFijo(this.detallegrupoactivofijos);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosDetalleGrupoActivoFijosWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		detallegrupoactivofijos = new  ArrayList<DetalleGrupoActivoFijo>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleGrupoActivoFijo.class.getSimpleName()+"-getTodosDetalleGrupoActivoFijosWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DetalleGrupoActivoFijoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detallegrupoactivofijos=detallegrupoactivofijoDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarDetalleGrupoActivoFijo(detallegrupoactivofijos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleGrupoActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesDetalleGrupoActivoFijo(this.detallegrupoactivofijos);
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
	
	public  void  getTodosDetalleGrupoActivoFijos(String sFinalQuery,Pagination pagination)throws Exception {
		detallegrupoactivofijos = new  ArrayList<DetalleGrupoActivoFijo>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DetalleGrupoActivoFijoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detallegrupoactivofijos=detallegrupoactivofijoDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarDetalleGrupoActivoFijo(detallegrupoactivofijos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleGrupoActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesDetalleGrupoActivoFijo(this.detallegrupoactivofijos);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarDetalleGrupoActivoFijo(DetalleGrupoActivoFijo detallegrupoactivofijo) throws Exception {
		Boolean estaValidado=false;
		
		if(detallegrupoactivofijo.getIsNew() || detallegrupoactivofijo.getIsChanged()) { 
			this.invalidValues = detallegrupoactivofijoValidator.getInvalidValues(detallegrupoactivofijo);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(detallegrupoactivofijo);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarDetalleGrupoActivoFijo(List<DetalleGrupoActivoFijo> DetalleGrupoActivoFijos) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(DetalleGrupoActivoFijo detallegrupoactivofijoLocal:detallegrupoactivofijos) {				
			estaValidadoObjeto=this.validarGuardarDetalleGrupoActivoFijo(detallegrupoactivofijoLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarDetalleGrupoActivoFijo(List<DetalleGrupoActivoFijo> DetalleGrupoActivoFijos) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarDetalleGrupoActivoFijo(detallegrupoactivofijos)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarDetalleGrupoActivoFijo(DetalleGrupoActivoFijo DetalleGrupoActivoFijo) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarDetalleGrupoActivoFijo(detallegrupoactivofijo)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(DetalleGrupoActivoFijo detallegrupoactivofijo) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+detallegrupoactivofijo.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=DetalleGrupoActivoFijoConstantesFunciones.getDetalleGrupoActivoFijoLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"detallegrupoactivofijo","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(DetalleGrupoActivoFijoConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(DetalleGrupoActivoFijoConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveDetalleGrupoActivoFijoWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleGrupoActivoFijo.class.getSimpleName()+"-saveDetalleGrupoActivoFijoWithConnection");connexion.begin();			
			
			DetalleGrupoActivoFijoLogicAdditional.checkDetalleGrupoActivoFijoToSave(this.detallegrupoactivofijo,this.datosCliente,connexion,this.arrDatoGeneral);
			
			DetalleGrupoActivoFijoLogicAdditional.updateDetalleGrupoActivoFijoToSave(this.detallegrupoactivofijo,this.arrDatoGeneral);
			
			DetalleGrupoActivoFijoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.detallegrupoactivofijo,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowDetalleGrupoActivoFijo();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarDetalleGrupoActivoFijo(this.detallegrupoactivofijo)) {
				DetalleGrupoActivoFijoDataAccess.save(this.detallegrupoactivofijo, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.detallegrupoactivofijo,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			DetalleGrupoActivoFijoLogicAdditional.checkDetalleGrupoActivoFijoToSaveAfter(this.detallegrupoactivofijo,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowDetalleGrupoActivoFijo();
			
			connexion.commit();			
			
			if(this.detallegrupoactivofijo.getIsDeleted()) {
				this.detallegrupoactivofijo=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveDetalleGrupoActivoFijo()throws Exception {	
		try {	
			
			DetalleGrupoActivoFijoLogicAdditional.checkDetalleGrupoActivoFijoToSave(this.detallegrupoactivofijo,this.datosCliente,connexion,this.arrDatoGeneral);
			
			DetalleGrupoActivoFijoLogicAdditional.updateDetalleGrupoActivoFijoToSave(this.detallegrupoactivofijo,this.arrDatoGeneral);
			
			DetalleGrupoActivoFijoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.detallegrupoactivofijo,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarDetalleGrupoActivoFijo(this.detallegrupoactivofijo)) {			
				DetalleGrupoActivoFijoDataAccess.save(this.detallegrupoactivofijo, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.detallegrupoactivofijo,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			DetalleGrupoActivoFijoLogicAdditional.checkDetalleGrupoActivoFijoToSaveAfter(this.detallegrupoactivofijo,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.detallegrupoactivofijo.getIsDeleted()) {
				this.detallegrupoactivofijo=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveDetalleGrupoActivoFijosWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleGrupoActivoFijo.class.getSimpleName()+"-saveDetalleGrupoActivoFijosWithConnection");connexion.begin();			
			
			DetalleGrupoActivoFijoLogicAdditional.checkDetalleGrupoActivoFijoToSaves(detallegrupoactivofijos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowDetalleGrupoActivoFijos();
			
			Boolean validadoTodosDetalleGrupoActivoFijo=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(DetalleGrupoActivoFijo detallegrupoactivofijoLocal:detallegrupoactivofijos) {		
				if(detallegrupoactivofijoLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				DetalleGrupoActivoFijoLogicAdditional.updateDetalleGrupoActivoFijoToSave(detallegrupoactivofijoLocal,this.arrDatoGeneral);
	        	
				DetalleGrupoActivoFijoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),detallegrupoactivofijoLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarDetalleGrupoActivoFijo(detallegrupoactivofijoLocal)) {
					DetalleGrupoActivoFijoDataAccess.save(detallegrupoactivofijoLocal, connexion);				
				} else {
					validadoTodosDetalleGrupoActivoFijo=false;
				}
			}
			
			if(!validadoTodosDetalleGrupoActivoFijo) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			DetalleGrupoActivoFijoLogicAdditional.checkDetalleGrupoActivoFijoToSavesAfter(detallegrupoactivofijos,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowDetalleGrupoActivoFijos();
			
			connexion.commit();		
			
			this.quitarDetalleGrupoActivoFijosEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveDetalleGrupoActivoFijos()throws Exception {				
		 try {	
			DetalleGrupoActivoFijoLogicAdditional.checkDetalleGrupoActivoFijoToSaves(detallegrupoactivofijos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosDetalleGrupoActivoFijo=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(DetalleGrupoActivoFijo detallegrupoactivofijoLocal:detallegrupoactivofijos) {				
				if(detallegrupoactivofijoLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				DetalleGrupoActivoFijoLogicAdditional.updateDetalleGrupoActivoFijoToSave(detallegrupoactivofijoLocal,this.arrDatoGeneral);
	        	
				DetalleGrupoActivoFijoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),detallegrupoactivofijoLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarDetalleGrupoActivoFijo(detallegrupoactivofijoLocal)) {				
					DetalleGrupoActivoFijoDataAccess.save(detallegrupoactivofijoLocal, connexion);				
				} else {
					validadoTodosDetalleGrupoActivoFijo=false;
				}
			}
			
			if(!validadoTodosDetalleGrupoActivoFijo) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			DetalleGrupoActivoFijoLogicAdditional.checkDetalleGrupoActivoFijoToSavesAfter(detallegrupoactivofijos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarDetalleGrupoActivoFijosEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public DetalleGrupoActivoFijoParameterReturnGeneral procesarAccionDetalleGrupoActivoFijos(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<DetalleGrupoActivoFijo> detallegrupoactivofijos,DetalleGrupoActivoFijoParameterReturnGeneral detallegrupoactivofijoParameterGeneral)throws Exception {
		 try {	
			DetalleGrupoActivoFijoParameterReturnGeneral detallegrupoactivofijoReturnGeneral=new DetalleGrupoActivoFijoParameterReturnGeneral();
	
			DetalleGrupoActivoFijoLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,detallegrupoactivofijos,detallegrupoactivofijoParameterGeneral,detallegrupoactivofijoReturnGeneral);
			
			return detallegrupoactivofijoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public DetalleGrupoActivoFijoParameterReturnGeneral procesarAccionDetalleGrupoActivoFijosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<DetalleGrupoActivoFijo> detallegrupoactivofijos,DetalleGrupoActivoFijoParameterReturnGeneral detallegrupoactivofijoParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleGrupoActivoFijo.class.getSimpleName()+"-procesarAccionDetalleGrupoActivoFijosWithConnection");connexion.begin();			
			
			DetalleGrupoActivoFijoParameterReturnGeneral detallegrupoactivofijoReturnGeneral=new DetalleGrupoActivoFijoParameterReturnGeneral();
	
			DetalleGrupoActivoFijoLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,detallegrupoactivofijos,detallegrupoactivofijoParameterGeneral,detallegrupoactivofijoReturnGeneral);
			
			this.connexion.commit();
			
			return detallegrupoactivofijoReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public DetalleGrupoActivoFijoParameterReturnGeneral procesarEventosDetalleGrupoActivoFijos(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<DetalleGrupoActivoFijo> detallegrupoactivofijos,DetalleGrupoActivoFijo detallegrupoactivofijo,DetalleGrupoActivoFijoParameterReturnGeneral detallegrupoactivofijoParameterGeneral,Boolean isEsNuevoDetalleGrupoActivoFijo,ArrayList<Classe> clases)throws Exception {
		 try {	
			DetalleGrupoActivoFijoParameterReturnGeneral detallegrupoactivofijoReturnGeneral=new DetalleGrupoActivoFijoParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				detallegrupoactivofijoReturnGeneral.setConRecargarPropiedades(true);
			}
			
			DetalleGrupoActivoFijoLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,detallegrupoactivofijos,detallegrupoactivofijo,detallegrupoactivofijoParameterGeneral,detallegrupoactivofijoReturnGeneral,isEsNuevoDetalleGrupoActivoFijo,clases);
			
			return detallegrupoactivofijoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public DetalleGrupoActivoFijoParameterReturnGeneral procesarEventosDetalleGrupoActivoFijosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<DetalleGrupoActivoFijo> detallegrupoactivofijos,DetalleGrupoActivoFijo detallegrupoactivofijo,DetalleGrupoActivoFijoParameterReturnGeneral detallegrupoactivofijoParameterGeneral,Boolean isEsNuevoDetalleGrupoActivoFijo,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleGrupoActivoFijo.class.getSimpleName()+"-procesarEventosDetalleGrupoActivoFijosWithConnection");connexion.begin();			
			
			DetalleGrupoActivoFijoParameterReturnGeneral detallegrupoactivofijoReturnGeneral=new DetalleGrupoActivoFijoParameterReturnGeneral();
	
			detallegrupoactivofijoReturnGeneral.setDetalleGrupoActivoFijo(detallegrupoactivofijo);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				detallegrupoactivofijoReturnGeneral.setConRecargarPropiedades(true);
			}
			
			DetalleGrupoActivoFijoLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,detallegrupoactivofijos,detallegrupoactivofijo,detallegrupoactivofijoParameterGeneral,detallegrupoactivofijoReturnGeneral,isEsNuevoDetalleGrupoActivoFijo,clases);
			
			this.connexion.commit();
			
			return detallegrupoactivofijoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public DetalleGrupoActivoFijoParameterReturnGeneral procesarImportacionDetalleGrupoActivoFijosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,DetalleGrupoActivoFijoParameterReturnGeneral detallegrupoactivofijoParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleGrupoActivoFijo.class.getSimpleName()+"-procesarImportacionDetalleGrupoActivoFijosWithConnection");connexion.begin();			
			
			DetalleGrupoActivoFijoParameterReturnGeneral detallegrupoactivofijoReturnGeneral=new DetalleGrupoActivoFijoParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.detallegrupoactivofijos=new ArrayList<DetalleGrupoActivoFijo>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.detallegrupoactivofijo=new DetalleGrupoActivoFijo();
				
				
				if(conColumnasBase) {this.detallegrupoactivofijo.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.detallegrupoactivofijo.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.detallegrupoactivofijo.setcodigo(arrColumnas[iColumn++]);
				this.detallegrupoactivofijo.setnombre(arrColumnas[iColumn++]);
				this.detallegrupoactivofijo.setsiglas(arrColumnas[iColumn++]);
				
				this.detallegrupoactivofijos.add(this.detallegrupoactivofijo);
			}
			
			this.saveDetalleGrupoActivoFijos();
			
			this.connexion.commit();
			
			detallegrupoactivofijoReturnGeneral.setConRetornoEstaProcesado(true);
			detallegrupoactivofijoReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return detallegrupoactivofijoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarDetalleGrupoActivoFijosEliminados() throws Exception {				
		
		List<DetalleGrupoActivoFijo> detallegrupoactivofijosAux= new ArrayList<DetalleGrupoActivoFijo>();
		
		for(DetalleGrupoActivoFijo detallegrupoactivofijo:detallegrupoactivofijos) {
			if(!detallegrupoactivofijo.getIsDeleted()) {
				detallegrupoactivofijosAux.add(detallegrupoactivofijo);
			}
		}
		
		detallegrupoactivofijos=detallegrupoactivofijosAux;
	}
	
	public void quitarDetalleGrupoActivoFijosNulos() throws Exception {				
		
		List<DetalleGrupoActivoFijo> detallegrupoactivofijosAux= new ArrayList<DetalleGrupoActivoFijo>();
		
		for(DetalleGrupoActivoFijo detallegrupoactivofijo : this.detallegrupoactivofijos) {
			if(detallegrupoactivofijo==null) {
				detallegrupoactivofijosAux.add(detallegrupoactivofijo);
			}
		}
		
		//this.detallegrupoactivofijos=detallegrupoactivofijosAux;
		
		this.detallegrupoactivofijos.removeAll(detallegrupoactivofijosAux);
	}
	
	public void getSetVersionRowDetalleGrupoActivoFijoWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(detallegrupoactivofijo.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((detallegrupoactivofijo.getIsDeleted() || (detallegrupoactivofijo.getIsChanged()&&!detallegrupoactivofijo.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=detallegrupoactivofijoDataAccess.getSetVersionRowDetalleGrupoActivoFijo(connexion,detallegrupoactivofijo.getId());
				
				if(!detallegrupoactivofijo.getVersionRow().equals(timestamp)) {	
					detallegrupoactivofijo.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				detallegrupoactivofijo.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowDetalleGrupoActivoFijo()throws Exception {	
		
		if(detallegrupoactivofijo.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((detallegrupoactivofijo.getIsDeleted() || (detallegrupoactivofijo.getIsChanged()&&!detallegrupoactivofijo.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=detallegrupoactivofijoDataAccess.getSetVersionRowDetalleGrupoActivoFijo(connexion,detallegrupoactivofijo.getId());
			
			try {							
				if(!detallegrupoactivofijo.getVersionRow().equals(timestamp)) {	
					detallegrupoactivofijo.setVersionRow(timestamp);
				}
				
				detallegrupoactivofijo.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowDetalleGrupoActivoFijosWithConnection()throws Exception {	
		if(detallegrupoactivofijos!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(DetalleGrupoActivoFijo detallegrupoactivofijoAux:detallegrupoactivofijos) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(detallegrupoactivofijoAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(detallegrupoactivofijoAux.getIsDeleted() || (detallegrupoactivofijoAux.getIsChanged()&&!detallegrupoactivofijoAux.getIsNew())) {
						
						timestamp=detallegrupoactivofijoDataAccess.getSetVersionRowDetalleGrupoActivoFijo(connexion,detallegrupoactivofijoAux.getId());
						
						if(!detallegrupoactivofijo.getVersionRow().equals(timestamp)) {	
							detallegrupoactivofijoAux.setVersionRow(timestamp);
						}
								
						detallegrupoactivofijoAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowDetalleGrupoActivoFijos()throws Exception {	
		if(detallegrupoactivofijos!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(DetalleGrupoActivoFijo detallegrupoactivofijoAux:detallegrupoactivofijos) {
					if(detallegrupoactivofijoAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(detallegrupoactivofijoAux.getIsDeleted() || (detallegrupoactivofijoAux.getIsChanged()&&!detallegrupoactivofijoAux.getIsNew())) {
						
						timestamp=detallegrupoactivofijoDataAccess.getSetVersionRowDetalleGrupoActivoFijo(connexion,detallegrupoactivofijoAux.getId());
						
						if(!detallegrupoactivofijoAux.getVersionRow().equals(timestamp)) {	
							detallegrupoactivofijoAux.setVersionRow(timestamp);
						}
						
													
						detallegrupoactivofijoAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public DetalleGrupoActivoFijoParameterReturnGeneral cargarCombosLoteForeignKeyDetalleGrupoActivoFijoWithConnection(String finalQueryGlobalEmpresa,String finalQueryGlobalCuentaContableCostoOriginal,String finalQueryGlobalCuentaContableDepreNormal,String finalQueryGlobalCuentaContableDepreGastoNormal) throws Exception {
		DetalleGrupoActivoFijoParameterReturnGeneral  detallegrupoactivofijoReturnGeneral =new DetalleGrupoActivoFijoParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleGrupoActivoFijo.class.getSimpleName()+"-cargarCombosLoteForeignKeyDetalleGrupoActivoFijoWithConnection");connexion.begin();
			
			detallegrupoactivofijoReturnGeneral =new DetalleGrupoActivoFijoParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			detallegrupoactivofijoReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<CuentaContable> cuentacontablecostooriginalsForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontablecostooriginalLogic=new CuentaContableLogic();
			cuentacontablecostooriginalLogic.setConnexion(this.connexion);
			cuentacontablecostooriginalLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContableCostoOriginal.equals("NONE")) {
				cuentacontablecostooriginalLogic.getTodosCuentaContables(finalQueryGlobalCuentaContableCostoOriginal,new Pagination());
				cuentacontablecostooriginalsForeignKey=cuentacontablecostooriginalLogic.getCuentaContables();
			}

			detallegrupoactivofijoReturnGeneral.setcuentacontablecostooriginalsForeignKey(cuentacontablecostooriginalsForeignKey);


			List<CuentaContable> cuentacontabledeprenormalsForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontabledeprenormalLogic=new CuentaContableLogic();
			cuentacontabledeprenormalLogic.setConnexion(this.connexion);
			cuentacontabledeprenormalLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContableDepreNormal.equals("NONE")) {
				cuentacontabledeprenormalLogic.getTodosCuentaContables(finalQueryGlobalCuentaContableDepreNormal,new Pagination());
				cuentacontabledeprenormalsForeignKey=cuentacontabledeprenormalLogic.getCuentaContables();
			}

			detallegrupoactivofijoReturnGeneral.setcuentacontabledeprenormalsForeignKey(cuentacontabledeprenormalsForeignKey);


			List<CuentaContable> cuentacontabledepregastonormalsForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontabledepregastonormalLogic=new CuentaContableLogic();
			cuentacontabledepregastonormalLogic.setConnexion(this.connexion);
			cuentacontabledepregastonormalLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContableDepreGastoNormal.equals("NONE")) {
				cuentacontabledepregastonormalLogic.getTodosCuentaContables(finalQueryGlobalCuentaContableDepreGastoNormal,new Pagination());
				cuentacontabledepregastonormalsForeignKey=cuentacontabledepregastonormalLogic.getCuentaContables();
			}

			detallegrupoactivofijoReturnGeneral.setcuentacontabledepregastonormalsForeignKey(cuentacontabledepregastonormalsForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return detallegrupoactivofijoReturnGeneral;
	}
	
	public DetalleGrupoActivoFijoParameterReturnGeneral cargarCombosLoteForeignKeyDetalleGrupoActivoFijo(String finalQueryGlobalEmpresa,String finalQueryGlobalCuentaContableCostoOriginal,String finalQueryGlobalCuentaContableDepreNormal,String finalQueryGlobalCuentaContableDepreGastoNormal) throws Exception {
		DetalleGrupoActivoFijoParameterReturnGeneral  detallegrupoactivofijoReturnGeneral =new DetalleGrupoActivoFijoParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			detallegrupoactivofijoReturnGeneral =new DetalleGrupoActivoFijoParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			detallegrupoactivofijoReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<CuentaContable> cuentacontablecostooriginalsForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontablecostooriginalLogic=new CuentaContableLogic();
			cuentacontablecostooriginalLogic.setConnexion(this.connexion);
			cuentacontablecostooriginalLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContableCostoOriginal.equals("NONE")) {
				cuentacontablecostooriginalLogic.getTodosCuentaContables(finalQueryGlobalCuentaContableCostoOriginal,new Pagination());
				cuentacontablecostooriginalsForeignKey=cuentacontablecostooriginalLogic.getCuentaContables();
			}

			detallegrupoactivofijoReturnGeneral.setcuentacontablecostooriginalsForeignKey(cuentacontablecostooriginalsForeignKey);


			List<CuentaContable> cuentacontabledeprenormalsForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontabledeprenormalLogic=new CuentaContableLogic();
			cuentacontabledeprenormalLogic.setConnexion(this.connexion);
			cuentacontabledeprenormalLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContableDepreNormal.equals("NONE")) {
				cuentacontabledeprenormalLogic.getTodosCuentaContables(finalQueryGlobalCuentaContableDepreNormal,new Pagination());
				cuentacontabledeprenormalsForeignKey=cuentacontabledeprenormalLogic.getCuentaContables();
			}

			detallegrupoactivofijoReturnGeneral.setcuentacontabledeprenormalsForeignKey(cuentacontabledeprenormalsForeignKey);


			List<CuentaContable> cuentacontabledepregastonormalsForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontabledepregastonormalLogic=new CuentaContableLogic();
			cuentacontabledepregastonormalLogic.setConnexion(this.connexion);
			cuentacontabledepregastonormalLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContableDepreGastoNormal.equals("NONE")) {
				cuentacontabledepregastonormalLogic.getTodosCuentaContables(finalQueryGlobalCuentaContableDepreGastoNormal,new Pagination());
				cuentacontabledepregastonormalsForeignKey=cuentacontabledepregastonormalLogic.getCuentaContables();
			}

			detallegrupoactivofijoReturnGeneral.setcuentacontabledepregastonormalsForeignKey(cuentacontabledepregastonormalsForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return detallegrupoactivofijoReturnGeneral;
	}
	
	public void cargarRelacionesLoteForeignKeyDetalleGrupoActivoFijoWithConnection() throws Exception {
		ArrayList<Classe> classes=new ArrayList<Classe>();		
		
		
			DetalleActivoFijoLogic detalleactivofijoLogic=new DetalleActivoFijoLogic();
			CuentaContaDetaGrupoActiLogic cuentacontadetagrupoactiLogic=new CuentaContaDetaGrupoActiLogic();
			SubGrupoActivoFijoLogic subgrupoactivofijoLogic=new SubGrupoActivoFijoLogic();
			GastoDepreciacionLogic gastodepreciacionLogic=new GastoDepreciacionLogic();
		
		try {
			
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleGrupoActivoFijo.class.getSimpleName()+"-cargarRelacionesLoteForeignKeyDetalleGrupoActivoFijoWithConnection");connexion.begin();
			
			
			classes.add(new Classe(DetalleActivoFijo.class));
			classes.add(new Classe(CuentaContaDetaGrupoActi.class));
			classes.add(new Classe(SubGrupoActivoFijo.class));
			classes.add(new Classe(GastoDepreciacion.class));
											
			

			detalleactivofijoLogic.setConnexion(this.getConnexion());
			detalleactivofijoLogic.setDatosCliente(this.datosCliente);
			detalleactivofijoLogic.setIsConRefrescarForeignKeys(true);

			cuentacontadetagrupoactiLogic.setConnexion(this.getConnexion());
			cuentacontadetagrupoactiLogic.setDatosCliente(this.datosCliente);
			cuentacontadetagrupoactiLogic.setIsConRefrescarForeignKeys(true);

			subgrupoactivofijoLogic.setConnexion(this.getConnexion());
			subgrupoactivofijoLogic.setDatosCliente(this.datosCliente);
			subgrupoactivofijoLogic.setIsConRefrescarForeignKeys(true);

			gastodepreciacionLogic.setConnexion(this.getConnexion());
			gastodepreciacionLogic.setDatosCliente(this.datosCliente);
			gastodepreciacionLogic.setIsConRefrescarForeignKeys(true);
			
			this.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
			
			for(DetalleGrupoActivoFijo detallegrupoactivofijo:this.detallegrupoactivofijos) {
				

				classes=new ArrayList<Classe>();
				classes=DetalleActivoFijoConstantesFunciones.getClassesForeignKeysOfDetalleActivoFijo(new ArrayList<Classe>(),DeepLoadType.NONE);

				detalleactivofijoLogic.setDetalleActivoFijos(detallegrupoactivofijo.detalleactivofijos);
				detalleactivofijoLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=CuentaContaDetaGrupoActiConstantesFunciones.getClassesForeignKeysOfCuentaContaDetaGrupoActi(new ArrayList<Classe>(),DeepLoadType.NONE);

				cuentacontadetagrupoactiLogic.setCuentaContaDetaGrupoActis(detallegrupoactivofijo.cuentacontadetagrupoactis);
				cuentacontadetagrupoactiLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=SubGrupoActivoFijoConstantesFunciones.getClassesForeignKeysOfSubGrupoActivoFijo(new ArrayList<Classe>(),DeepLoadType.NONE);

				subgrupoactivofijoLogic.setSubGrupoActivoFijos(detallegrupoactivofijo.subgrupoactivofijos);
				subgrupoactivofijoLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=GastoDepreciacionConstantesFunciones.getClassesForeignKeysOfGastoDepreciacion(new ArrayList<Classe>(),DeepLoadType.NONE);

				gastodepreciacionLogic.setGastoDepreciacions(detallegrupoactivofijo.gastodepreciacions);
				gastodepreciacionLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
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
	
	public void deepLoad(DetalleGrupoActivoFijo detallegrupoactivofijo,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			DetalleGrupoActivoFijoLogicAdditional.updateDetalleGrupoActivoFijoToGet(detallegrupoactivofijo,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		detallegrupoactivofijo.setEmpresa(detallegrupoactivofijoDataAccess.getEmpresa(connexion,detallegrupoactivofijo));
		detallegrupoactivofijo.setCuentaContableCostoOriginal(detallegrupoactivofijoDataAccess.getCuentaContableCostoOriginal(connexion,detallegrupoactivofijo));
		detallegrupoactivofijo.setCuentaContableDepreNormal(detallegrupoactivofijoDataAccess.getCuentaContableDepreNormal(connexion,detallegrupoactivofijo));
		detallegrupoactivofijo.setCuentaContableDepreGastoNormal(detallegrupoactivofijoDataAccess.getCuentaContableDepreGastoNormal(connexion,detallegrupoactivofijo));
		detallegrupoactivofijo.setDetalleActivoFijos(detallegrupoactivofijoDataAccess.getDetalleActivoFijos(connexion,detallegrupoactivofijo));
		detallegrupoactivofijo.setCuentaContaDetaGrupoActis(detallegrupoactivofijoDataAccess.getCuentaContaDetaGrupoActis(connexion,detallegrupoactivofijo));
		detallegrupoactivofijo.setSubGrupoActivoFijos(detallegrupoactivofijoDataAccess.getSubGrupoActivoFijos(connexion,detallegrupoactivofijo));
		detallegrupoactivofijo.setGastoDepreciacions(detallegrupoactivofijoDataAccess.getGastoDepreciacions(connexion,detallegrupoactivofijo));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				detallegrupoactivofijo.setEmpresa(detallegrupoactivofijoDataAccess.getEmpresa(connexion,detallegrupoactivofijo));
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				detallegrupoactivofijo.setCuentaContableCostoOriginal(detallegrupoactivofijoDataAccess.getCuentaContableCostoOriginal(connexion,detallegrupoactivofijo));
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				detallegrupoactivofijo.setCuentaContableDepreNormal(detallegrupoactivofijoDataAccess.getCuentaContableDepreNormal(connexion,detallegrupoactivofijo));
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				detallegrupoactivofijo.setCuentaContableDepreGastoNormal(detallegrupoactivofijoDataAccess.getCuentaContableDepreGastoNormal(connexion,detallegrupoactivofijo));
				continue;
			}

			if(clas.clas.equals(DetalleActivoFijo.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				detallegrupoactivofijo.setDetalleActivoFijos(detallegrupoactivofijoDataAccess.getDetalleActivoFijos(connexion,detallegrupoactivofijo));

				if(this.isConDeep) {
					DetalleActivoFijoLogic detalleactivofijoLogic= new DetalleActivoFijoLogic(this.connexion);
					detalleactivofijoLogic.setDetalleActivoFijos(detallegrupoactivofijo.getDetalleActivoFijos());
					ArrayList<Classe> classesLocal=DetalleActivoFijoConstantesFunciones.getClassesForeignKeysOfDetalleActivoFijo(new ArrayList<Classe>(),DeepLoadType.NONE);
					detalleactivofijoLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					DetalleActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesDetalleActivoFijo(detalleactivofijoLogic.getDetalleActivoFijos());
					detallegrupoactivofijo.setDetalleActivoFijos(detalleactivofijoLogic.getDetalleActivoFijos());
				}

				continue;
			}

			if(clas.clas.equals(CuentaContaDetaGrupoActi.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				detallegrupoactivofijo.setCuentaContaDetaGrupoActis(detallegrupoactivofijoDataAccess.getCuentaContaDetaGrupoActis(connexion,detallegrupoactivofijo));

				if(this.isConDeep) {
					CuentaContaDetaGrupoActiLogic cuentacontadetagrupoactiLogic= new CuentaContaDetaGrupoActiLogic(this.connexion);
					cuentacontadetagrupoactiLogic.setCuentaContaDetaGrupoActis(detallegrupoactivofijo.getCuentaContaDetaGrupoActis());
					ArrayList<Classe> classesLocal=CuentaContaDetaGrupoActiConstantesFunciones.getClassesForeignKeysOfCuentaContaDetaGrupoActi(new ArrayList<Classe>(),DeepLoadType.NONE);
					cuentacontadetagrupoactiLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					CuentaContaDetaGrupoActiConstantesFunciones.refrescarForeignKeysDescripcionesCuentaContaDetaGrupoActi(cuentacontadetagrupoactiLogic.getCuentaContaDetaGrupoActis());
					detallegrupoactivofijo.setCuentaContaDetaGrupoActis(cuentacontadetagrupoactiLogic.getCuentaContaDetaGrupoActis());
				}

				continue;
			}

			if(clas.clas.equals(SubGrupoActivoFijo.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				detallegrupoactivofijo.setSubGrupoActivoFijos(detallegrupoactivofijoDataAccess.getSubGrupoActivoFijos(connexion,detallegrupoactivofijo));

				if(this.isConDeep) {
					SubGrupoActivoFijoLogic subgrupoactivofijoLogic= new SubGrupoActivoFijoLogic(this.connexion);
					subgrupoactivofijoLogic.setSubGrupoActivoFijos(detallegrupoactivofijo.getSubGrupoActivoFijos());
					ArrayList<Classe> classesLocal=SubGrupoActivoFijoConstantesFunciones.getClassesForeignKeysOfSubGrupoActivoFijo(new ArrayList<Classe>(),DeepLoadType.NONE);
					subgrupoactivofijoLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					SubGrupoActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesSubGrupoActivoFijo(subgrupoactivofijoLogic.getSubGrupoActivoFijos());
					detallegrupoactivofijo.setSubGrupoActivoFijos(subgrupoactivofijoLogic.getSubGrupoActivoFijos());
				}

				continue;
			}

			if(clas.clas.equals(GastoDepreciacion.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				detallegrupoactivofijo.setGastoDepreciacions(detallegrupoactivofijoDataAccess.getGastoDepreciacions(connexion,detallegrupoactivofijo));

				if(this.isConDeep) {
					GastoDepreciacionLogic gastodepreciacionLogic= new GastoDepreciacionLogic(this.connexion);
					gastodepreciacionLogic.setGastoDepreciacions(detallegrupoactivofijo.getGastoDepreciacions());
					ArrayList<Classe> classesLocal=GastoDepreciacionConstantesFunciones.getClassesForeignKeysOfGastoDepreciacion(new ArrayList<Classe>(),DeepLoadType.NONE);
					gastodepreciacionLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					GastoDepreciacionConstantesFunciones.refrescarForeignKeysDescripcionesGastoDepreciacion(gastodepreciacionLogic.getGastoDepreciacions());
					detallegrupoactivofijo.setGastoDepreciacions(gastodepreciacionLogic.getGastoDepreciacions());
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
			detallegrupoactivofijo.setEmpresa(detallegrupoactivofijoDataAccess.getEmpresa(connexion,detallegrupoactivofijo));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallegrupoactivofijo.setCuentaContableCostoOriginal(detallegrupoactivofijoDataAccess.getCuentaContableCostoOriginal(connexion,detallegrupoactivofijo));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallegrupoactivofijo.setCuentaContableDepreNormal(detallegrupoactivofijoDataAccess.getCuentaContableDepreNormal(connexion,detallegrupoactivofijo));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallegrupoactivofijo.setCuentaContableDepreGastoNormal(detallegrupoactivofijoDataAccess.getCuentaContableDepreGastoNormal(connexion,detallegrupoactivofijo));
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
			detallegrupoactivofijo.setDetalleActivoFijos(detallegrupoactivofijoDataAccess.getDetalleActivoFijos(connexion,detallegrupoactivofijo));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContaDetaGrupoActi.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(CuentaContaDetaGrupoActi.class));
			detallegrupoactivofijo.setCuentaContaDetaGrupoActis(detallegrupoactivofijoDataAccess.getCuentaContaDetaGrupoActis(connexion,detallegrupoactivofijo));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(SubGrupoActivoFijo.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(SubGrupoActivoFijo.class));
			detallegrupoactivofijo.setSubGrupoActivoFijos(detallegrupoactivofijoDataAccess.getSubGrupoActivoFijos(connexion,detallegrupoactivofijo));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(GastoDepreciacion.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(GastoDepreciacion.class));
			detallegrupoactivofijo.setGastoDepreciacions(detallegrupoactivofijoDataAccess.getGastoDepreciacions(connexion,detallegrupoactivofijo));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		detallegrupoactivofijo.setEmpresa(detallegrupoactivofijoDataAccess.getEmpresa(connexion,detallegrupoactivofijo));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(detallegrupoactivofijo.getEmpresa(),isDeep,deepLoadType,clases);
				
		detallegrupoactivofijo.setCuentaContableCostoOriginal(detallegrupoactivofijoDataAccess.getCuentaContableCostoOriginal(connexion,detallegrupoactivofijo));
		CuentaContableLogic cuentacontablecostooriginalLogic= new CuentaContableLogic(connexion);
		cuentacontablecostooriginalLogic.deepLoad(detallegrupoactivofijo.getCuentaContableCostoOriginal(),isDeep,deepLoadType,clases);
				
		detallegrupoactivofijo.setCuentaContableDepreNormal(detallegrupoactivofijoDataAccess.getCuentaContableDepreNormal(connexion,detallegrupoactivofijo));
		CuentaContableLogic cuentacontabledeprenormalLogic= new CuentaContableLogic(connexion);
		cuentacontabledeprenormalLogic.deepLoad(detallegrupoactivofijo.getCuentaContableDepreNormal(),isDeep,deepLoadType,clases);
				
		detallegrupoactivofijo.setCuentaContableDepreGastoNormal(detallegrupoactivofijoDataAccess.getCuentaContableDepreGastoNormal(connexion,detallegrupoactivofijo));
		CuentaContableLogic cuentacontabledepregastonormalLogic= new CuentaContableLogic(connexion);
		cuentacontabledepregastonormalLogic.deepLoad(detallegrupoactivofijo.getCuentaContableDepreGastoNormal(),isDeep,deepLoadType,clases);
				

		detallegrupoactivofijo.setDetalleActivoFijos(detallegrupoactivofijoDataAccess.getDetalleActivoFijos(connexion,detallegrupoactivofijo));

		for(DetalleActivoFijo detalleactivofijo:detallegrupoactivofijo.getDetalleActivoFijos()) {
			DetalleActivoFijoLogic detalleactivofijoLogic= new DetalleActivoFijoLogic(connexion);
			detalleactivofijoLogic.deepLoad(detalleactivofijo,isDeep,deepLoadType,clases);
		}

		detallegrupoactivofijo.setCuentaContaDetaGrupoActis(detallegrupoactivofijoDataAccess.getCuentaContaDetaGrupoActis(connexion,detallegrupoactivofijo));

		for(CuentaContaDetaGrupoActi cuentacontadetagrupoacti:detallegrupoactivofijo.getCuentaContaDetaGrupoActis()) {
			CuentaContaDetaGrupoActiLogic cuentacontadetagrupoactiLogic= new CuentaContaDetaGrupoActiLogic(connexion);
			cuentacontadetagrupoactiLogic.deepLoad(cuentacontadetagrupoacti,isDeep,deepLoadType,clases);
		}

		detallegrupoactivofijo.setSubGrupoActivoFijos(detallegrupoactivofijoDataAccess.getSubGrupoActivoFijos(connexion,detallegrupoactivofijo));

		for(SubGrupoActivoFijo subgrupoactivofijo:detallegrupoactivofijo.getSubGrupoActivoFijos()) {
			SubGrupoActivoFijoLogic subgrupoactivofijoLogic= new SubGrupoActivoFijoLogic(connexion);
			subgrupoactivofijoLogic.deepLoad(subgrupoactivofijo,isDeep,deepLoadType,clases);
		}

		detallegrupoactivofijo.setGastoDepreciacions(detallegrupoactivofijoDataAccess.getGastoDepreciacions(connexion,detallegrupoactivofijo));

		for(GastoDepreciacion gastodepreciacion:detallegrupoactivofijo.getGastoDepreciacions()) {
			GastoDepreciacionLogic gastodepreciacionLogic= new GastoDepreciacionLogic(connexion);
			gastodepreciacionLogic.deepLoad(gastodepreciacion,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				detallegrupoactivofijo.setEmpresa(detallegrupoactivofijoDataAccess.getEmpresa(connexion,detallegrupoactivofijo));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(detallegrupoactivofijo.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				detallegrupoactivofijo.setCuentaContableCostoOriginal(detallegrupoactivofijoDataAccess.getCuentaContableCostoOriginal(connexion,detallegrupoactivofijo));
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepLoad(detallegrupoactivofijo.getCuentaContableCostoOriginal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				detallegrupoactivofijo.setCuentaContableDepreNormal(detallegrupoactivofijoDataAccess.getCuentaContableDepreNormal(connexion,detallegrupoactivofijo));
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepLoad(detallegrupoactivofijo.getCuentaContableDepreNormal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				detallegrupoactivofijo.setCuentaContableDepreGastoNormal(detallegrupoactivofijoDataAccess.getCuentaContableDepreGastoNormal(connexion,detallegrupoactivofijo));
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepLoad(detallegrupoactivofijo.getCuentaContableDepreGastoNormal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(DetalleActivoFijo.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				detallegrupoactivofijo.setDetalleActivoFijos(detallegrupoactivofijoDataAccess.getDetalleActivoFijos(connexion,detallegrupoactivofijo));

				for(DetalleActivoFijo detalleactivofijo:detallegrupoactivofijo.getDetalleActivoFijos()) {
					DetalleActivoFijoLogic detalleactivofijoLogic= new DetalleActivoFijoLogic(connexion);
					detalleactivofijoLogic.deepLoad(detalleactivofijo,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(CuentaContaDetaGrupoActi.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				detallegrupoactivofijo.setCuentaContaDetaGrupoActis(detallegrupoactivofijoDataAccess.getCuentaContaDetaGrupoActis(connexion,detallegrupoactivofijo));

				for(CuentaContaDetaGrupoActi cuentacontadetagrupoacti:detallegrupoactivofijo.getCuentaContaDetaGrupoActis()) {
					CuentaContaDetaGrupoActiLogic cuentacontadetagrupoactiLogic= new CuentaContaDetaGrupoActiLogic(connexion);
					cuentacontadetagrupoactiLogic.deepLoad(cuentacontadetagrupoacti,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(SubGrupoActivoFijo.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				detallegrupoactivofijo.setSubGrupoActivoFijos(detallegrupoactivofijoDataAccess.getSubGrupoActivoFijos(connexion,detallegrupoactivofijo));

				for(SubGrupoActivoFijo subgrupoactivofijo:detallegrupoactivofijo.getSubGrupoActivoFijos()) {
					SubGrupoActivoFijoLogic subgrupoactivofijoLogic= new SubGrupoActivoFijoLogic(connexion);
					subgrupoactivofijoLogic.deepLoad(subgrupoactivofijo,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(GastoDepreciacion.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				detallegrupoactivofijo.setGastoDepreciacions(detallegrupoactivofijoDataAccess.getGastoDepreciacions(connexion,detallegrupoactivofijo));

				for(GastoDepreciacion gastodepreciacion:detallegrupoactivofijo.getGastoDepreciacions()) {
					GastoDepreciacionLogic gastodepreciacionLogic= new GastoDepreciacionLogic(connexion);
					gastodepreciacionLogic.deepLoad(gastodepreciacion,isDeep,deepLoadType,clases);
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
			detallegrupoactivofijo.setEmpresa(detallegrupoactivofijoDataAccess.getEmpresa(connexion,detallegrupoactivofijo));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(detallegrupoactivofijo.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallegrupoactivofijo.setCuentaContableCostoOriginal(detallegrupoactivofijoDataAccess.getCuentaContableCostoOriginal(connexion,detallegrupoactivofijo));
			CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
			cuentacontableLogic.deepLoad(detallegrupoactivofijo.getCuentaContableCostoOriginal(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallegrupoactivofijo.setCuentaContableDepreNormal(detallegrupoactivofijoDataAccess.getCuentaContableDepreNormal(connexion,detallegrupoactivofijo));
			CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
			cuentacontableLogic.deepLoad(detallegrupoactivofijo.getCuentaContableDepreNormal(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallegrupoactivofijo.setCuentaContableDepreGastoNormal(detallegrupoactivofijoDataAccess.getCuentaContableDepreGastoNormal(connexion,detallegrupoactivofijo));
			CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
			cuentacontableLogic.deepLoad(detallegrupoactivofijo.getCuentaContableDepreGastoNormal(),isDeep,deepLoadType,clases);
				
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
			detallegrupoactivofijo.setDetalleActivoFijos(detallegrupoactivofijoDataAccess.getDetalleActivoFijos(connexion,detallegrupoactivofijo));

			for(DetalleActivoFijo detalleactivofijo:detallegrupoactivofijo.getDetalleActivoFijos()) {
				DetalleActivoFijoLogic detalleactivofijoLogic= new DetalleActivoFijoLogic(connexion);
				detalleactivofijoLogic.deepLoad(detalleactivofijo,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContaDetaGrupoActi.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(CuentaContaDetaGrupoActi.class));
			detallegrupoactivofijo.setCuentaContaDetaGrupoActis(detallegrupoactivofijoDataAccess.getCuentaContaDetaGrupoActis(connexion,detallegrupoactivofijo));

			for(CuentaContaDetaGrupoActi cuentacontadetagrupoacti:detallegrupoactivofijo.getCuentaContaDetaGrupoActis()) {
				CuentaContaDetaGrupoActiLogic cuentacontadetagrupoactiLogic= new CuentaContaDetaGrupoActiLogic(connexion);
				cuentacontadetagrupoactiLogic.deepLoad(cuentacontadetagrupoacti,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(SubGrupoActivoFijo.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(SubGrupoActivoFijo.class));
			detallegrupoactivofijo.setSubGrupoActivoFijos(detallegrupoactivofijoDataAccess.getSubGrupoActivoFijos(connexion,detallegrupoactivofijo));

			for(SubGrupoActivoFijo subgrupoactivofijo:detallegrupoactivofijo.getSubGrupoActivoFijos()) {
				SubGrupoActivoFijoLogic subgrupoactivofijoLogic= new SubGrupoActivoFijoLogic(connexion);
				subgrupoactivofijoLogic.deepLoad(subgrupoactivofijo,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(GastoDepreciacion.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(GastoDepreciacion.class));
			detallegrupoactivofijo.setGastoDepreciacions(detallegrupoactivofijoDataAccess.getGastoDepreciacions(connexion,detallegrupoactivofijo));

			for(GastoDepreciacion gastodepreciacion:detallegrupoactivofijo.getGastoDepreciacions()) {
				GastoDepreciacionLogic gastodepreciacionLogic= new GastoDepreciacionLogic(connexion);
				gastodepreciacionLogic.deepLoad(gastodepreciacion,isDeep,deepLoadType,clases);
			}
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(DetalleGrupoActivoFijo detallegrupoactivofijo,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			DetalleGrupoActivoFijoLogicAdditional.updateDetalleGrupoActivoFijoToSave(detallegrupoactivofijo,this.arrDatoGeneral);
			
DetalleGrupoActivoFijoDataAccess.save(detallegrupoactivofijo, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(detallegrupoactivofijo.getEmpresa(),connexion);

		CuentaContableDataAccess.save(detallegrupoactivofijo.getCuentaContableCostoOriginal(),connexion);

		CuentaContableDataAccess.save(detallegrupoactivofijo.getCuentaContableDepreNormal(),connexion);

		CuentaContableDataAccess.save(detallegrupoactivofijo.getCuentaContableDepreGastoNormal(),connexion);

		for(DetalleActivoFijo detalleactivofijo:detallegrupoactivofijo.getDetalleActivoFijos()) {
			detalleactivofijo.setid_detalle_grupo_activo_fijo(detallegrupoactivofijo.getId());
			DetalleActivoFijoDataAccess.save(detalleactivofijo,connexion);
		}

		for(CuentaContaDetaGrupoActi cuentacontadetagrupoacti:detallegrupoactivofijo.getCuentaContaDetaGrupoActis()) {
			cuentacontadetagrupoacti.setid_detalle_grupo_activo_fijo(detallegrupoactivofijo.getId());
			CuentaContaDetaGrupoActiDataAccess.save(cuentacontadetagrupoacti,connexion);
		}

		for(SubGrupoActivoFijo subgrupoactivofijo:detallegrupoactivofijo.getSubGrupoActivoFijos()) {
			subgrupoactivofijo.setid_detalle_grupo_activo_fijo(detallegrupoactivofijo.getId());
			SubGrupoActivoFijoDataAccess.save(subgrupoactivofijo,connexion);
		}

		for(GastoDepreciacion gastodepreciacion:detallegrupoactivofijo.getGastoDepreciacions()) {
			gastodepreciacion.setid_detalle_grupo_activo_fijo(detallegrupoactivofijo.getId());
			GastoDepreciacionDataAccess.save(gastodepreciacion,connexion);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(detallegrupoactivofijo.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(detallegrupoactivofijo.getCuentaContableCostoOriginal(),connexion);
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(detallegrupoactivofijo.getCuentaContableDepreNormal(),connexion);
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(detallegrupoactivofijo.getCuentaContableDepreGastoNormal(),connexion);
				continue;
			}


			if(clas.clas.equals(DetalleActivoFijo.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(DetalleActivoFijo detalleactivofijo:detallegrupoactivofijo.getDetalleActivoFijos()) {
					detalleactivofijo.setid_detalle_grupo_activo_fijo(detallegrupoactivofijo.getId());
					DetalleActivoFijoDataAccess.save(detalleactivofijo,connexion);
				}
				continue;
			}

			if(clas.clas.equals(CuentaContaDetaGrupoActi.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(CuentaContaDetaGrupoActi cuentacontadetagrupoacti:detallegrupoactivofijo.getCuentaContaDetaGrupoActis()) {
					cuentacontadetagrupoacti.setid_detalle_grupo_activo_fijo(detallegrupoactivofijo.getId());
					CuentaContaDetaGrupoActiDataAccess.save(cuentacontadetagrupoacti,connexion);
				}
				continue;
			}

			if(clas.clas.equals(SubGrupoActivoFijo.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(SubGrupoActivoFijo subgrupoactivofijo:detallegrupoactivofijo.getSubGrupoActivoFijos()) {
					subgrupoactivofijo.setid_detalle_grupo_activo_fijo(detallegrupoactivofijo.getId());
					SubGrupoActivoFijoDataAccess.save(subgrupoactivofijo,connexion);
				}
				continue;
			}

			if(clas.clas.equals(GastoDepreciacion.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(GastoDepreciacion gastodepreciacion:detallegrupoactivofijo.getGastoDepreciacions()) {
					gastodepreciacion.setid_detalle_grupo_activo_fijo(detallegrupoactivofijo.getId());
					GastoDepreciacionDataAccess.save(gastodepreciacion,connexion);
				}
				continue;
			}
		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(detallegrupoactivofijo.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(detallegrupoactivofijo.getEmpresa(),isDeep,deepLoadType,clases);
				

		CuentaContableDataAccess.save(detallegrupoactivofijo.getCuentaContableCostoOriginal(),connexion);
		CuentaContableLogic cuentacontablecostooriginalLogic= new CuentaContableLogic(connexion);
		cuentacontablecostooriginalLogic.deepLoad(detallegrupoactivofijo.getCuentaContableCostoOriginal(),isDeep,deepLoadType,clases);
				

		CuentaContableDataAccess.save(detallegrupoactivofijo.getCuentaContableDepreNormal(),connexion);
		CuentaContableLogic cuentacontabledeprenormalLogic= new CuentaContableLogic(connexion);
		cuentacontabledeprenormalLogic.deepLoad(detallegrupoactivofijo.getCuentaContableDepreNormal(),isDeep,deepLoadType,clases);
				

		CuentaContableDataAccess.save(detallegrupoactivofijo.getCuentaContableDepreGastoNormal(),connexion);
		CuentaContableLogic cuentacontabledepregastonormalLogic= new CuentaContableLogic(connexion);
		cuentacontabledepregastonormalLogic.deepLoad(detallegrupoactivofijo.getCuentaContableDepreGastoNormal(),isDeep,deepLoadType,clases);
				

		for(DetalleActivoFijo detalleactivofijo:detallegrupoactivofijo.getDetalleActivoFijos()) {
			DetalleActivoFijoLogic detalleactivofijoLogic= new DetalleActivoFijoLogic(connexion);
			detalleactivofijo.setid_detalle_grupo_activo_fijo(detallegrupoactivofijo.getId());
			DetalleActivoFijoDataAccess.save(detalleactivofijo,connexion);
			detalleactivofijoLogic.deepSave(detalleactivofijo,isDeep,deepLoadType,clases);
		}

		for(CuentaContaDetaGrupoActi cuentacontadetagrupoacti:detallegrupoactivofijo.getCuentaContaDetaGrupoActis()) {
			CuentaContaDetaGrupoActiLogic cuentacontadetagrupoactiLogic= new CuentaContaDetaGrupoActiLogic(connexion);
			cuentacontadetagrupoacti.setid_detalle_grupo_activo_fijo(detallegrupoactivofijo.getId());
			CuentaContaDetaGrupoActiDataAccess.save(cuentacontadetagrupoacti,connexion);
			cuentacontadetagrupoactiLogic.deepSave(cuentacontadetagrupoacti,isDeep,deepLoadType,clases);
		}

		for(SubGrupoActivoFijo subgrupoactivofijo:detallegrupoactivofijo.getSubGrupoActivoFijos()) {
			SubGrupoActivoFijoLogic subgrupoactivofijoLogic= new SubGrupoActivoFijoLogic(connexion);
			subgrupoactivofijo.setid_detalle_grupo_activo_fijo(detallegrupoactivofijo.getId());
			SubGrupoActivoFijoDataAccess.save(subgrupoactivofijo,connexion);
			subgrupoactivofijoLogic.deepSave(subgrupoactivofijo,isDeep,deepLoadType,clases);
		}

		for(GastoDepreciacion gastodepreciacion:detallegrupoactivofijo.getGastoDepreciacions()) {
			GastoDepreciacionLogic gastodepreciacionLogic= new GastoDepreciacionLogic(connexion);
			gastodepreciacion.setid_detalle_grupo_activo_fijo(detallegrupoactivofijo.getId());
			GastoDepreciacionDataAccess.save(gastodepreciacion,connexion);
			gastodepreciacionLogic.deepSave(gastodepreciacion,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(detallegrupoactivofijo.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(detallegrupoactivofijo.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(detallegrupoactivofijo.getCuentaContableCostoOriginal(),connexion);
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepSave(detallegrupoactivofijo.getCuentaContableCostoOriginal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(detallegrupoactivofijo.getCuentaContableDepreNormal(),connexion);
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepSave(detallegrupoactivofijo.getCuentaContableDepreNormal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(detallegrupoactivofijo.getCuentaContableDepreGastoNormal(),connexion);
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepSave(detallegrupoactivofijo.getCuentaContableDepreGastoNormal(),isDeep,deepLoadType,clases);				
				continue;
			}


			if(clas.clas.equals(DetalleActivoFijo.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(DetalleActivoFijo detalleactivofijo:detallegrupoactivofijo.getDetalleActivoFijos()) {
					DetalleActivoFijoLogic detalleactivofijoLogic= new DetalleActivoFijoLogic(connexion);
					detalleactivofijo.setid_detalle_grupo_activo_fijo(detallegrupoactivofijo.getId());
					DetalleActivoFijoDataAccess.save(detalleactivofijo,connexion);
					detalleactivofijoLogic.deepSave(detalleactivofijo,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(CuentaContaDetaGrupoActi.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(CuentaContaDetaGrupoActi cuentacontadetagrupoacti:detallegrupoactivofijo.getCuentaContaDetaGrupoActis()) {
					CuentaContaDetaGrupoActiLogic cuentacontadetagrupoactiLogic= new CuentaContaDetaGrupoActiLogic(connexion);
					cuentacontadetagrupoacti.setid_detalle_grupo_activo_fijo(detallegrupoactivofijo.getId());
					CuentaContaDetaGrupoActiDataAccess.save(cuentacontadetagrupoacti,connexion);
					cuentacontadetagrupoactiLogic.deepSave(cuentacontadetagrupoacti,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(SubGrupoActivoFijo.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(SubGrupoActivoFijo subgrupoactivofijo:detallegrupoactivofijo.getSubGrupoActivoFijos()) {
					SubGrupoActivoFijoLogic subgrupoactivofijoLogic= new SubGrupoActivoFijoLogic(connexion);
					subgrupoactivofijo.setid_detalle_grupo_activo_fijo(detallegrupoactivofijo.getId());
					SubGrupoActivoFijoDataAccess.save(subgrupoactivofijo,connexion);
					subgrupoactivofijoLogic.deepSave(subgrupoactivofijo,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(GastoDepreciacion.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(GastoDepreciacion gastodepreciacion:detallegrupoactivofijo.getGastoDepreciacions()) {
					GastoDepreciacionLogic gastodepreciacionLogic= new GastoDepreciacionLogic(connexion);
					gastodepreciacion.setid_detalle_grupo_activo_fijo(detallegrupoactivofijo.getId());
					GastoDepreciacionDataAccess.save(gastodepreciacion,connexion);
					gastodepreciacionLogic.deepSave(gastodepreciacion,isDeep,deepLoadType,clases);
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
			this.getNewConnexionToDeep(DetalleGrupoActivoFijo.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(detallegrupoactivofijo,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				DetalleGrupoActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesDetalleGrupoActivoFijo(detallegrupoactivofijo);
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
			this.deepLoad(this.detallegrupoactivofijo,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				DetalleGrupoActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesDetalleGrupoActivoFijo(this.detallegrupoactivofijo);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(DetalleGrupoActivoFijo.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(detallegrupoactivofijos!=null) {
				for(DetalleGrupoActivoFijo detallegrupoactivofijo:detallegrupoactivofijos) {
					this.deepLoad(detallegrupoactivofijo,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					DetalleGrupoActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesDetalleGrupoActivoFijo(detallegrupoactivofijos);
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
			if(detallegrupoactivofijos!=null) {
				for(DetalleGrupoActivoFijo detallegrupoactivofijo:detallegrupoactivofijos) {
					this.deepLoad(detallegrupoactivofijo,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					DetalleGrupoActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesDetalleGrupoActivoFijo(detallegrupoactivofijos);
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
			this.getNewConnexionToDeep(DetalleGrupoActivoFijo.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(detallegrupoactivofijo,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(DetalleGrupoActivoFijo.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(detallegrupoactivofijos!=null) {
				for(DetalleGrupoActivoFijo detallegrupoactivofijo:detallegrupoactivofijos) {
					this.deepSave(detallegrupoactivofijo,isDeep,deepLoadType,clases);
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
			if(detallegrupoactivofijos!=null) {
				for(DetalleGrupoActivoFijo detallegrupoactivofijo:detallegrupoactivofijos) {
					this.deepSave(detallegrupoactivofijo,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getDetalleGrupoActivoFijosFK_IdCuentaContableCostoOriginalWithConnection(String sFinalQuery,Pagination pagination,Long id_cuenta_contable_costo_original)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleGrupoActivoFijo.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContableCostoOriginal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContableCostoOriginal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable_costo_original,DetalleGrupoActivoFijoConstantesFunciones.IDCUENTACONTABLECOSTOORIGINAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContableCostoOriginal);

			DetalleGrupoActivoFijoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContableCostoOriginal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallegrupoactivofijos=detallegrupoactivofijoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleGrupoActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesDetalleGrupoActivoFijo(this.detallegrupoactivofijos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleGrupoActivoFijosFK_IdCuentaContableCostoOriginal(String sFinalQuery,Pagination pagination,Long id_cuenta_contable_costo_original)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContableCostoOriginal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContableCostoOriginal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable_costo_original,DetalleGrupoActivoFijoConstantesFunciones.IDCUENTACONTABLECOSTOORIGINAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContableCostoOriginal);

			DetalleGrupoActivoFijoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContableCostoOriginal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallegrupoactivofijos=detallegrupoactivofijoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleGrupoActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesDetalleGrupoActivoFijo(this.detallegrupoactivofijos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetalleGrupoActivoFijosFK_IdCuentaContableDepreGastoNormalWithConnection(String sFinalQuery,Pagination pagination,Long id_cuenta_contable_depre_gasto_normal)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleGrupoActivoFijo.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContableDepreGastoNormal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContableDepreGastoNormal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable_depre_gasto_normal,DetalleGrupoActivoFijoConstantesFunciones.IDCUENTACONTABLEDEPREGASTONORMAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContableDepreGastoNormal);

			DetalleGrupoActivoFijoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContableDepreGastoNormal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallegrupoactivofijos=detallegrupoactivofijoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleGrupoActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesDetalleGrupoActivoFijo(this.detallegrupoactivofijos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleGrupoActivoFijosFK_IdCuentaContableDepreGastoNormal(String sFinalQuery,Pagination pagination,Long id_cuenta_contable_depre_gasto_normal)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContableDepreGastoNormal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContableDepreGastoNormal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable_depre_gasto_normal,DetalleGrupoActivoFijoConstantesFunciones.IDCUENTACONTABLEDEPREGASTONORMAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContableDepreGastoNormal);

			DetalleGrupoActivoFijoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContableDepreGastoNormal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallegrupoactivofijos=detallegrupoactivofijoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleGrupoActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesDetalleGrupoActivoFijo(this.detallegrupoactivofijos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetalleGrupoActivoFijosFK_IdCuentaContableDepreNormalWithConnection(String sFinalQuery,Pagination pagination,Long id_cuenta_contable_depre_normal)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleGrupoActivoFijo.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContableDepreNormal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContableDepreNormal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable_depre_normal,DetalleGrupoActivoFijoConstantesFunciones.IDCUENTACONTABLEDEPRENORMAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContableDepreNormal);

			DetalleGrupoActivoFijoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContableDepreNormal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallegrupoactivofijos=detallegrupoactivofijoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleGrupoActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesDetalleGrupoActivoFijo(this.detallegrupoactivofijos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleGrupoActivoFijosFK_IdCuentaContableDepreNormal(String sFinalQuery,Pagination pagination,Long id_cuenta_contable_depre_normal)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContableDepreNormal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContableDepreNormal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable_depre_normal,DetalleGrupoActivoFijoConstantesFunciones.IDCUENTACONTABLEDEPRENORMAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContableDepreNormal);

			DetalleGrupoActivoFijoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContableDepreNormal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallegrupoactivofijos=detallegrupoactivofijoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleGrupoActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesDetalleGrupoActivoFijo(this.detallegrupoactivofijos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetalleGrupoActivoFijosFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleGrupoActivoFijo.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,DetalleGrupoActivoFijoConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			DetalleGrupoActivoFijoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallegrupoactivofijos=detallegrupoactivofijoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleGrupoActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesDetalleGrupoActivoFijo(this.detallegrupoactivofijos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleGrupoActivoFijosFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,DetalleGrupoActivoFijoConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			DetalleGrupoActivoFijoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallegrupoactivofijos=detallegrupoactivofijoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleGrupoActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesDetalleGrupoActivoFijo(this.detallegrupoactivofijos);
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
			if(DetalleGrupoActivoFijoConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,DetalleGrupoActivoFijoDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,DetalleGrupoActivoFijo detallegrupoactivofijo,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(DetalleGrupoActivoFijoConstantesFunciones.ISCONAUDITORIA) {
				if(detallegrupoactivofijo.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,DetalleGrupoActivoFijoDataAccess.TABLENAME, detallegrupoactivofijo.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(DetalleGrupoActivoFijoConstantesFunciones.ISCONAUDITORIADETALLE) {
						////DetalleGrupoActivoFijoLogic.registrarAuditoriaDetallesDetalleGrupoActivoFijo(connexion,detallegrupoactivofijo,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(detallegrupoactivofijo.getIsDeleted()) {
					/*if(!detallegrupoactivofijo.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,DetalleGrupoActivoFijoDataAccess.TABLENAME, detallegrupoactivofijo.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////DetalleGrupoActivoFijoLogic.registrarAuditoriaDetallesDetalleGrupoActivoFijo(connexion,detallegrupoactivofijo,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,DetalleGrupoActivoFijoDataAccess.TABLENAME, detallegrupoactivofijo.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(detallegrupoactivofijo.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,DetalleGrupoActivoFijoDataAccess.TABLENAME, detallegrupoactivofijo.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(DetalleGrupoActivoFijoConstantesFunciones.ISCONAUDITORIADETALLE) {
						////DetalleGrupoActivoFijoLogic.registrarAuditoriaDetallesDetalleGrupoActivoFijo(connexion,detallegrupoactivofijo,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesDetalleGrupoActivoFijo(Connexion connexion,DetalleGrupoActivoFijo detallegrupoactivofijo)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(detallegrupoactivofijo.getIsNew()||!detallegrupoactivofijo.getid_empresa().equals(detallegrupoactivofijo.getDetalleGrupoActivoFijoOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallegrupoactivofijo.getDetalleGrupoActivoFijoOriginal().getid_empresa()!=null)
				{
					strValorActual=detallegrupoactivofijo.getDetalleGrupoActivoFijoOriginal().getid_empresa().toString();
				}
				if(detallegrupoactivofijo.getid_empresa()!=null)
				{
					strValorNuevo=detallegrupoactivofijo.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleGrupoActivoFijoConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(detallegrupoactivofijo.getIsNew()||!detallegrupoactivofijo.getcodigo().equals(detallegrupoactivofijo.getDetalleGrupoActivoFijoOriginal().getcodigo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallegrupoactivofijo.getDetalleGrupoActivoFijoOriginal().getcodigo()!=null)
				{
					strValorActual=detallegrupoactivofijo.getDetalleGrupoActivoFijoOriginal().getcodigo();
				}
				if(detallegrupoactivofijo.getcodigo()!=null)
				{
					strValorNuevo=detallegrupoactivofijo.getcodigo() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleGrupoActivoFijoConstantesFunciones.CODIGO,strValorActual,strValorNuevo);
			}	
			
			if(detallegrupoactivofijo.getIsNew()||!detallegrupoactivofijo.getnombre().equals(detallegrupoactivofijo.getDetalleGrupoActivoFijoOriginal().getnombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallegrupoactivofijo.getDetalleGrupoActivoFijoOriginal().getnombre()!=null)
				{
					strValorActual=detallegrupoactivofijo.getDetalleGrupoActivoFijoOriginal().getnombre();
				}
				if(detallegrupoactivofijo.getnombre()!=null)
				{
					strValorNuevo=detallegrupoactivofijo.getnombre() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleGrupoActivoFijoConstantesFunciones.NOMBRE,strValorActual,strValorNuevo);
			}	
			
			if(detallegrupoactivofijo.getIsNew()||!detallegrupoactivofijo.getsiglas().equals(detallegrupoactivofijo.getDetalleGrupoActivoFijoOriginal().getsiglas()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallegrupoactivofijo.getDetalleGrupoActivoFijoOriginal().getsiglas()!=null)
				{
					strValorActual=detallegrupoactivofijo.getDetalleGrupoActivoFijoOriginal().getsiglas();
				}
				if(detallegrupoactivofijo.getsiglas()!=null)
				{
					strValorNuevo=detallegrupoactivofijo.getsiglas() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleGrupoActivoFijoConstantesFunciones.SIGLAS,strValorActual,strValorNuevo);
			}	
			
			if(detallegrupoactivofijo.getIsNew()||!detallegrupoactivofijo.getid_cuenta_contable_costo_original().equals(detallegrupoactivofijo.getDetalleGrupoActivoFijoOriginal().getid_cuenta_contable_costo_original()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallegrupoactivofijo.getDetalleGrupoActivoFijoOriginal().getid_cuenta_contable_costo_original()!=null)
				{
					strValorActual=detallegrupoactivofijo.getDetalleGrupoActivoFijoOriginal().getid_cuenta_contable_costo_original().toString();
				}
				if(detallegrupoactivofijo.getid_cuenta_contable_costo_original()!=null)
				{
					strValorNuevo=detallegrupoactivofijo.getid_cuenta_contable_costo_original().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleGrupoActivoFijoConstantesFunciones.IDCUENTACONTABLECOSTOORIGINAL,strValorActual,strValorNuevo);
			}	
			
			if(detallegrupoactivofijo.getIsNew()||!detallegrupoactivofijo.getid_cuenta_contable_depre_normal().equals(detallegrupoactivofijo.getDetalleGrupoActivoFijoOriginal().getid_cuenta_contable_depre_normal()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallegrupoactivofijo.getDetalleGrupoActivoFijoOriginal().getid_cuenta_contable_depre_normal()!=null)
				{
					strValorActual=detallegrupoactivofijo.getDetalleGrupoActivoFijoOriginal().getid_cuenta_contable_depre_normal().toString();
				}
				if(detallegrupoactivofijo.getid_cuenta_contable_depre_normal()!=null)
				{
					strValorNuevo=detallegrupoactivofijo.getid_cuenta_contable_depre_normal().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleGrupoActivoFijoConstantesFunciones.IDCUENTACONTABLEDEPRENORMAL,strValorActual,strValorNuevo);
			}	
			
			if(detallegrupoactivofijo.getIsNew()||!detallegrupoactivofijo.getid_cuenta_contable_depre_gasto_normal().equals(detallegrupoactivofijo.getDetalleGrupoActivoFijoOriginal().getid_cuenta_contable_depre_gasto_normal()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallegrupoactivofijo.getDetalleGrupoActivoFijoOriginal().getid_cuenta_contable_depre_gasto_normal()!=null)
				{
					strValorActual=detallegrupoactivofijo.getDetalleGrupoActivoFijoOriginal().getid_cuenta_contable_depre_gasto_normal().toString();
				}
				if(detallegrupoactivofijo.getid_cuenta_contable_depre_gasto_normal()!=null)
				{
					strValorNuevo=detallegrupoactivofijo.getid_cuenta_contable_depre_gasto_normal().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleGrupoActivoFijoConstantesFunciones.IDCUENTACONTABLEDEPREGASTONORMAL,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveDetalleGrupoActivoFijoRelacionesWithConnection(DetalleGrupoActivoFijo detallegrupoactivofijo,List<DetalleActivoFijo> detalleactivofijos,List<CuentaContaDetaGrupoActi> cuentacontadetagrupoactis,List<SubGrupoActivoFijo> subgrupoactivofijos,List<GastoDepreciacion> gastodepreciacions) throws Exception {

		if(!detallegrupoactivofijo.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveDetalleGrupoActivoFijoRelacionesBase(detallegrupoactivofijo,detalleactivofijos,cuentacontadetagrupoactis,subgrupoactivofijos,gastodepreciacions,true);
		}
	}

	public void saveDetalleGrupoActivoFijoRelaciones(DetalleGrupoActivoFijo detallegrupoactivofijo,List<DetalleActivoFijo> detalleactivofijos,List<CuentaContaDetaGrupoActi> cuentacontadetagrupoactis,List<SubGrupoActivoFijo> subgrupoactivofijos,List<GastoDepreciacion> gastodepreciacions)throws Exception {

		if(!detallegrupoactivofijo.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveDetalleGrupoActivoFijoRelacionesBase(detallegrupoactivofijo,detalleactivofijos,cuentacontadetagrupoactis,subgrupoactivofijos,gastodepreciacions,false);
		}
	}

	public void saveDetalleGrupoActivoFijoRelacionesBase(DetalleGrupoActivoFijo detallegrupoactivofijo,List<DetalleActivoFijo> detalleactivofijos,List<CuentaContaDetaGrupoActi> cuentacontadetagrupoactis,List<SubGrupoActivoFijo> subgrupoactivofijos,List<GastoDepreciacion> gastodepreciacions,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("DetalleGrupoActivoFijo-saveRelacionesWithConnection");}
	
			detallegrupoactivofijo.setDetalleActivoFijos(detalleactivofijos);
			detallegrupoactivofijo.setCuentaContaDetaGrupoActis(cuentacontadetagrupoactis);
			detallegrupoactivofijo.setSubGrupoActivoFijos(subgrupoactivofijos);
			detallegrupoactivofijo.setGastoDepreciacions(gastodepreciacions);

			this.setDetalleGrupoActivoFijo(detallegrupoactivofijo);

			if(DetalleGrupoActivoFijoLogicAdditional.validarSaveRelaciones(detallegrupoactivofijo,this)) {

				DetalleGrupoActivoFijoLogicAdditional.updateRelacionesToSave(detallegrupoactivofijo,this);

				if((detallegrupoactivofijo.getIsNew()||detallegrupoactivofijo.getIsChanged())&&!detallegrupoactivofijo.getIsDeleted()) {
					this.saveDetalleGrupoActivoFijo();
					this.saveDetalleGrupoActivoFijoRelacionesDetalles(detalleactivofijos,cuentacontadetagrupoactis,subgrupoactivofijos,gastodepreciacions);

				} else if(detallegrupoactivofijo.getIsDeleted()) {
					this.saveDetalleGrupoActivoFijoRelacionesDetalles(detalleactivofijos,cuentacontadetagrupoactis,subgrupoactivofijos,gastodepreciacions);
					this.saveDetalleGrupoActivoFijo();
				}

				DetalleGrupoActivoFijoLogicAdditional.updateRelacionesToSaveAfter(detallegrupoactivofijo,this);

			} else {
				throw new Exception("LOS DATOS SON INVALIDOS");
			}

			if(conConexion) {connexion.commit();}

		} catch(Exception e) {
			
			DetalleActivoFijoConstantesFunciones.InicializarGeneralEntityAuxiliaresDetalleActivoFijos(detalleactivofijos,true,true);
			CuentaContaDetaGrupoActiConstantesFunciones.InicializarGeneralEntityAuxiliaresCuentaContaDetaGrupoActis(cuentacontadetagrupoactis,true,true);
			SubGrupoActivoFijoConstantesFunciones.InicializarGeneralEntityAuxiliaresSubGrupoActivoFijos(subgrupoactivofijos,true,true);
			GastoDepreciacionConstantesFunciones.InicializarGeneralEntityAuxiliaresGastoDepreciacions(gastodepreciacions,true,true);

			if(conConexion){connexion.rollback();}
			Funciones.manageException(logger,e);
			throw e;

		} finally {
			if(conConexion){this.closeNewConnexionToDeep();}
		}
	}
	
	
	private void saveDetalleGrupoActivoFijoRelacionesDetalles(List<DetalleActivoFijo> detalleactivofijos,List<CuentaContaDetaGrupoActi> cuentacontadetagrupoactis,List<SubGrupoActivoFijo> subgrupoactivofijos,List<GastoDepreciacion> gastodepreciacions)throws Exception {
		try {
	

			Long idDetalleGrupoActivoFijoActual=this.getDetalleGrupoActivoFijo().getId();

			DetalleActivoFijoLogic detalleactivofijoLogic_Desde_DetalleGrupoActivoFijo=new DetalleActivoFijoLogic();
			detalleactivofijoLogic_Desde_DetalleGrupoActivoFijo.setDetalleActivoFijos(detalleactivofijos);

			detalleactivofijoLogic_Desde_DetalleGrupoActivoFijo.setConnexion(this.getConnexion());
			detalleactivofijoLogic_Desde_DetalleGrupoActivoFijo.setDatosCliente(this.datosCliente);

			for(DetalleActivoFijo detalleactivofijo_Desde_DetalleGrupoActivoFijo:detalleactivofijoLogic_Desde_DetalleGrupoActivoFijo.getDetalleActivoFijos()) {
				detalleactivofijo_Desde_DetalleGrupoActivoFijo.setid_detalle_grupo_activo_fijo(idDetalleGrupoActivoFijoActual);

				detalleactivofijoLogic_Desde_DetalleGrupoActivoFijo.setDetalleActivoFijo(detalleactivofijo_Desde_DetalleGrupoActivoFijo);
				detalleactivofijoLogic_Desde_DetalleGrupoActivoFijo.saveDetalleActivoFijo();
			}


			CuentaContaDetaGrupoActiLogic cuentacontadetagrupoactiLogic_Desde_DetalleGrupoActivoFijo=new CuentaContaDetaGrupoActiLogic();
			cuentacontadetagrupoactiLogic_Desde_DetalleGrupoActivoFijo.setCuentaContaDetaGrupoActis(cuentacontadetagrupoactis);

			cuentacontadetagrupoactiLogic_Desde_DetalleGrupoActivoFijo.setConnexion(this.getConnexion());
			cuentacontadetagrupoactiLogic_Desde_DetalleGrupoActivoFijo.setDatosCliente(this.datosCliente);

			for(CuentaContaDetaGrupoActi cuentacontadetagrupoacti_Desde_DetalleGrupoActivoFijo:cuentacontadetagrupoactiLogic_Desde_DetalleGrupoActivoFijo.getCuentaContaDetaGrupoActis()) {
				cuentacontadetagrupoacti_Desde_DetalleGrupoActivoFijo.setid_detalle_grupo_activo_fijo(idDetalleGrupoActivoFijoActual);
			}

			cuentacontadetagrupoactiLogic_Desde_DetalleGrupoActivoFijo.saveCuentaContaDetaGrupoActis();

			SubGrupoActivoFijoLogic subgrupoactivofijoLogic_Desde_DetalleGrupoActivoFijo=new SubGrupoActivoFijoLogic();
			subgrupoactivofijoLogic_Desde_DetalleGrupoActivoFijo.setSubGrupoActivoFijos(subgrupoactivofijos);

			subgrupoactivofijoLogic_Desde_DetalleGrupoActivoFijo.setConnexion(this.getConnexion());
			subgrupoactivofijoLogic_Desde_DetalleGrupoActivoFijo.setDatosCliente(this.datosCliente);

			for(SubGrupoActivoFijo subgrupoactivofijo_Desde_DetalleGrupoActivoFijo:subgrupoactivofijoLogic_Desde_DetalleGrupoActivoFijo.getSubGrupoActivoFijos()) {
				subgrupoactivofijo_Desde_DetalleGrupoActivoFijo.setid_detalle_grupo_activo_fijo(idDetalleGrupoActivoFijoActual);

				subgrupoactivofijoLogic_Desde_DetalleGrupoActivoFijo.setSubGrupoActivoFijo(subgrupoactivofijo_Desde_DetalleGrupoActivoFijo);
				subgrupoactivofijoLogic_Desde_DetalleGrupoActivoFijo.saveSubGrupoActivoFijo();

				Long idSubGrupoActivoFijoActual=subgrupoactivofijo_Desde_DetalleGrupoActivoFijo.getId();

				DetalleActivoFijoLogic detalleactivofijoLogic_Desde_SubGrupoActivoFijo=new DetalleActivoFijoLogic();

				if(subgrupoactivofijo_Desde_DetalleGrupoActivoFijo.getDetalleActivoFijos()==null){
					subgrupoactivofijo_Desde_DetalleGrupoActivoFijo.setDetalleActivoFijos(new ArrayList<DetalleActivoFijo>());
				}

				detalleactivofijoLogic_Desde_SubGrupoActivoFijo.setDetalleActivoFijos(subgrupoactivofijo_Desde_DetalleGrupoActivoFijo.getDetalleActivoFijos());

				detalleactivofijoLogic_Desde_SubGrupoActivoFijo.setConnexion(this.getConnexion());
				detalleactivofijoLogic_Desde_SubGrupoActivoFijo.setDatosCliente(this.datosCliente);

				for(DetalleActivoFijo detalleactivofijo_Desde_SubGrupoActivoFijo:detalleactivofijoLogic_Desde_SubGrupoActivoFijo.getDetalleActivoFijos()) {
					detalleactivofijo_Desde_SubGrupoActivoFijo.setid_sub_grupo_activo_fijo(idSubGrupoActivoFijoActual);

					detalleactivofijoLogic_Desde_SubGrupoActivoFijo.setDetalleActivoFijo(detalleactivofijo_Desde_SubGrupoActivoFijo);
					detalleactivofijoLogic_Desde_SubGrupoActivoFijo.saveDetalleActivoFijo();
				}

			}


			GastoDepreciacionLogic gastodepreciacionLogic_Desde_DetalleGrupoActivoFijo=new GastoDepreciacionLogic();
			gastodepreciacionLogic_Desde_DetalleGrupoActivoFijo.setGastoDepreciacions(gastodepreciacions);

			gastodepreciacionLogic_Desde_DetalleGrupoActivoFijo.setConnexion(this.getConnexion());
			gastodepreciacionLogic_Desde_DetalleGrupoActivoFijo.setDatosCliente(this.datosCliente);

			for(GastoDepreciacion gastodepreciacion_Desde_DetalleGrupoActivoFijo:gastodepreciacionLogic_Desde_DetalleGrupoActivoFijo.getGastoDepreciacions()) {
				gastodepreciacion_Desde_DetalleGrupoActivoFijo.setid_detalle_grupo_activo_fijo(idDetalleGrupoActivoFijoActual);

				gastodepreciacionLogic_Desde_DetalleGrupoActivoFijo.setGastoDepreciacion(gastodepreciacion_Desde_DetalleGrupoActivoFijo);
				gastodepreciacionLogic_Desde_DetalleGrupoActivoFijo.saveGastoDepreciacion();

				Long idGastoDepreciacionActual=gastodepreciacion_Desde_DetalleGrupoActivoFijo.getId();

				CuentaContaGastoDepreLogic cuentacontagastodepreLogic_Desde_GastoDepreciacion=new CuentaContaGastoDepreLogic();

				if(gastodepreciacion_Desde_DetalleGrupoActivoFijo.getCuentaContaGastoDepres()==null){
					gastodepreciacion_Desde_DetalleGrupoActivoFijo.setCuentaContaGastoDepres(new ArrayList<CuentaContaGastoDepre>());
				}

				cuentacontagastodepreLogic_Desde_GastoDepreciacion.setCuentaContaGastoDepres(gastodepreciacion_Desde_DetalleGrupoActivoFijo.getCuentaContaGastoDepres());

				cuentacontagastodepreLogic_Desde_GastoDepreciacion.setConnexion(this.getConnexion());
				cuentacontagastodepreLogic_Desde_GastoDepreciacion.setDatosCliente(this.datosCliente);

				for(CuentaContaGastoDepre cuentacontagastodepre_Desde_GastoDepreciacion:cuentacontagastodepreLogic_Desde_GastoDepreciacion.getCuentaContaGastoDepres()) {
					cuentacontagastodepre_Desde_GastoDepreciacion.setid_gasto_depreciacion(idGastoDepreciacionActual);
				}

				cuentacontagastodepreLogic_Desde_GastoDepreciacion.saveCuentaContaGastoDepres();
			}


		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfDetalleGrupoActivoFijo(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=DetalleGrupoActivoFijoConstantesFunciones.getClassesForeignKeysOfDetalleGrupoActivoFijo(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfDetalleGrupoActivoFijo(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=DetalleGrupoActivoFijoConstantesFunciones.getClassesRelationshipsOfDetalleGrupoActivoFijo(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

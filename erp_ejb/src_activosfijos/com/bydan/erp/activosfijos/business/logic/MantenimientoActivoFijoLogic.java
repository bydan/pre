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
import com.bydan.erp.activosfijos.util.MantenimientoActivoFijoConstantesFunciones;
import com.bydan.erp.activosfijos.util.MantenimientoActivoFijoParameterReturnGeneral;
//import com.bydan.erp.activosfijos.util.MantenimientoActivoFijoParameterGeneral;
import com.bydan.erp.activosfijos.business.entity.MantenimientoActivoFijo;
import com.bydan.erp.activosfijos.business.logic.MantenimientoActivoFijoLogicAdditional;
import com.bydan.erp.activosfijos.business.dataaccess.*;
import com.bydan.erp.activosfijos.business.entity.*;

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
public class MantenimientoActivoFijoLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(MantenimientoActivoFijoLogic.class);
	
	protected MantenimientoActivoFijoDataAccess mantenimientoactivofijoDataAccess; 	
	protected MantenimientoActivoFijo mantenimientoactivofijo;
	protected List<MantenimientoActivoFijo> mantenimientoactivofijos;
	protected Object mantenimientoactivofijoObject;	
	protected List<Object> mantenimientoactivofijosObject;
	
	public static ClassValidator<MantenimientoActivoFijo> mantenimientoactivofijoValidator = new ClassValidator<MantenimientoActivoFijo>(MantenimientoActivoFijo.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected MantenimientoActivoFijoLogicAdditional mantenimientoactivofijoLogicAdditional=null;
	
	public MantenimientoActivoFijoLogicAdditional getMantenimientoActivoFijoLogicAdditional() {
		return this.mantenimientoactivofijoLogicAdditional;
	}
	
	public void setMantenimientoActivoFijoLogicAdditional(MantenimientoActivoFijoLogicAdditional mantenimientoactivofijoLogicAdditional) {
		try {
			this.mantenimientoactivofijoLogicAdditional=mantenimientoactivofijoLogicAdditional;
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
	
	
	
	
	public  MantenimientoActivoFijoLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.mantenimientoactivofijoDataAccess = new MantenimientoActivoFijoDataAccess();
			
			this.mantenimientoactivofijos= new ArrayList<MantenimientoActivoFijo>();
			this.mantenimientoactivofijo= new MantenimientoActivoFijo();
			
			this.mantenimientoactivofijoObject=new Object();
			this.mantenimientoactivofijosObject=new ArrayList<Object>();
				
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
			
			this.mantenimientoactivofijoDataAccess.setConnexionType(this.connexionType);
			this.mantenimientoactivofijoDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  MantenimientoActivoFijoLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.mantenimientoactivofijoDataAccess = new MantenimientoActivoFijoDataAccess();
			this.mantenimientoactivofijos= new ArrayList<MantenimientoActivoFijo>();
			this.mantenimientoactivofijo= new MantenimientoActivoFijo();
			this.mantenimientoactivofijoObject=new Object();
			this.mantenimientoactivofijosObject=new ArrayList<Object>();
			
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
			
			this.mantenimientoactivofijoDataAccess.setConnexionType(this.connexionType);
			this.mantenimientoactivofijoDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public MantenimientoActivoFijo getMantenimientoActivoFijo() throws Exception {	
		MantenimientoActivoFijoLogicAdditional.checkMantenimientoActivoFijoToGet(mantenimientoactivofijo,this.datosCliente,this.arrDatoGeneral);
		MantenimientoActivoFijoLogicAdditional.updateMantenimientoActivoFijoToGet(mantenimientoactivofijo,this.arrDatoGeneral);
		
		return mantenimientoactivofijo;
	}
		
	public void setMantenimientoActivoFijo(MantenimientoActivoFijo newMantenimientoActivoFijo) {
		this.mantenimientoactivofijo = newMantenimientoActivoFijo;
	}
	
	public MantenimientoActivoFijoDataAccess getMantenimientoActivoFijoDataAccess() {
		return mantenimientoactivofijoDataAccess;
	}
	
	public void setMantenimientoActivoFijoDataAccess(MantenimientoActivoFijoDataAccess newmantenimientoactivofijoDataAccess) {
		this.mantenimientoactivofijoDataAccess = newmantenimientoactivofijoDataAccess;
	}
	
	public List<MantenimientoActivoFijo> getMantenimientoActivoFijos() throws Exception {		
		this.quitarMantenimientoActivoFijosNulos();
		
		MantenimientoActivoFijoLogicAdditional.checkMantenimientoActivoFijoToGets(mantenimientoactivofijos,this.datosCliente,this.arrDatoGeneral);
		
		for (MantenimientoActivoFijo mantenimientoactivofijoLocal: mantenimientoactivofijos ) {
			MantenimientoActivoFijoLogicAdditional.updateMantenimientoActivoFijoToGet(mantenimientoactivofijoLocal,this.arrDatoGeneral);
		}
		
		return mantenimientoactivofijos;
	}
	
	public void setMantenimientoActivoFijos(List<MantenimientoActivoFijo> newMantenimientoActivoFijos) {
		this.mantenimientoactivofijos = newMantenimientoActivoFijos;
	}
	
	public Object getMantenimientoActivoFijoObject() {	
		this.mantenimientoactivofijoObject=this.mantenimientoactivofijoDataAccess.getEntityObject();
		return this.mantenimientoactivofijoObject;
	}
		
	public void setMantenimientoActivoFijoObject(Object newMantenimientoActivoFijoObject) {
		this.mantenimientoactivofijoObject = newMantenimientoActivoFijoObject;
	}
	
	public List<Object> getMantenimientoActivoFijosObject() {		
		this.mantenimientoactivofijosObject=this.mantenimientoactivofijoDataAccess.getEntitiesObject();
		return this.mantenimientoactivofijosObject;
	}
		
	public void setMantenimientoActivoFijosObject(List<Object> newMantenimientoActivoFijosObject) {
		this.mantenimientoactivofijosObject = newMantenimientoActivoFijosObject;
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
		
		if(this.mantenimientoactivofijoDataAccess!=null) {
			this.mantenimientoactivofijoDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,MantenimientoActivoFijo.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			mantenimientoactivofijoDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			mantenimientoactivofijoDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		mantenimientoactivofijo = new  MantenimientoActivoFijo();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,MantenimientoActivoFijo.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			mantenimientoactivofijo=mantenimientoactivofijoDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.mantenimientoactivofijo,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				MantenimientoActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesMantenimientoActivoFijo(this.mantenimientoactivofijo);
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
		mantenimientoactivofijo = new  MantenimientoActivoFijo();
		  		  
        try {
			
			mantenimientoactivofijo=mantenimientoactivofijoDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.mantenimientoactivofijo,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				MantenimientoActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesMantenimientoActivoFijo(this.mantenimientoactivofijo);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		mantenimientoactivofijo = new  MantenimientoActivoFijo();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,MantenimientoActivoFijo.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			mantenimientoactivofijo=mantenimientoactivofijoDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.mantenimientoactivofijo,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				MantenimientoActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesMantenimientoActivoFijo(this.mantenimientoactivofijo);
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
		mantenimientoactivofijo = new  MantenimientoActivoFijo();
		  		  
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
		mantenimientoactivofijo = new  MantenimientoActivoFijo();
		  		  
        try {
			
			mantenimientoactivofijo=mantenimientoactivofijoDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.mantenimientoactivofijo,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				MantenimientoActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesMantenimientoActivoFijo(this.mantenimientoactivofijo);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		mantenimientoactivofijo = new  MantenimientoActivoFijo();
		  		  
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
		mantenimientoactivofijo = new  MantenimientoActivoFijo();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,MantenimientoActivoFijo.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =mantenimientoactivofijoDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		mantenimientoactivofijo = new  MantenimientoActivoFijo();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=mantenimientoactivofijoDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		mantenimientoactivofijo = new  MantenimientoActivoFijo();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,MantenimientoActivoFijo.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =mantenimientoactivofijoDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		mantenimientoactivofijo = new  MantenimientoActivoFijo();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=mantenimientoactivofijoDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		mantenimientoactivofijo = new  MantenimientoActivoFijo();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,MantenimientoActivoFijo.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =mantenimientoactivofijoDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		mantenimientoactivofijo = new  MantenimientoActivoFijo();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=mantenimientoactivofijoDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		mantenimientoactivofijos = new  ArrayList<MantenimientoActivoFijo>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,MantenimientoActivoFijo.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			MantenimientoActivoFijoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			mantenimientoactivofijos=mantenimientoactivofijoDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarMantenimientoActivoFijo(mantenimientoactivofijos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				MantenimientoActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesMantenimientoActivoFijo(this.mantenimientoactivofijos);
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
		mantenimientoactivofijos = new  ArrayList<MantenimientoActivoFijo>();
		  		  
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
		mantenimientoactivofijos = new  ArrayList<MantenimientoActivoFijo>();
		  		  
        try {			
			MantenimientoActivoFijoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			mantenimientoactivofijos=mantenimientoactivofijoDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarMantenimientoActivoFijo(mantenimientoactivofijos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				MantenimientoActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesMantenimientoActivoFijo(this.mantenimientoactivofijos);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		mantenimientoactivofijos = new  ArrayList<MantenimientoActivoFijo>();
		  		  
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
		mantenimientoactivofijos = new  ArrayList<MantenimientoActivoFijo>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,MantenimientoActivoFijo.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			MantenimientoActivoFijoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			mantenimientoactivofijos=mantenimientoactivofijoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarMantenimientoActivoFijo(mantenimientoactivofijos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				MantenimientoActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesMantenimientoActivoFijo(this.mantenimientoactivofijos);
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
		mantenimientoactivofijos = new  ArrayList<MantenimientoActivoFijo>();
		  		  
        try {
			MantenimientoActivoFijoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			mantenimientoactivofijos=mantenimientoactivofijoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarMantenimientoActivoFijo(mantenimientoactivofijos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				MantenimientoActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesMantenimientoActivoFijo(this.mantenimientoactivofijos);
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
		mantenimientoactivofijos = new  ArrayList<MantenimientoActivoFijo>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,MantenimientoActivoFijo.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			MantenimientoActivoFijoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			mantenimientoactivofijos=mantenimientoactivofijoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarMantenimientoActivoFijo(mantenimientoactivofijos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				MantenimientoActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesMantenimientoActivoFijo(this.mantenimientoactivofijos);
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
		mantenimientoactivofijos = new  ArrayList<MantenimientoActivoFijo>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			MantenimientoActivoFijoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			mantenimientoactivofijos=mantenimientoactivofijoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarMantenimientoActivoFijo(mantenimientoactivofijos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				MantenimientoActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesMantenimientoActivoFijo(this.mantenimientoactivofijos);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		mantenimientoactivofijo = new  MantenimientoActivoFijo();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,MantenimientoActivoFijo.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			MantenimientoActivoFijoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			mantenimientoactivofijo=mantenimientoactivofijoDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarMantenimientoActivoFijo(mantenimientoactivofijo);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				MantenimientoActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesMantenimientoActivoFijo(this.mantenimientoactivofijo);
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
		mantenimientoactivofijo = new  MantenimientoActivoFijo();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			MantenimientoActivoFijoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			mantenimientoactivofijo=mantenimientoactivofijoDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarMantenimientoActivoFijo(mantenimientoactivofijo);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				MantenimientoActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesMantenimientoActivoFijo(this.mantenimientoactivofijo);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		mantenimientoactivofijos = new  ArrayList<MantenimientoActivoFijo>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,MantenimientoActivoFijo.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			MantenimientoActivoFijoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			mantenimientoactivofijos=mantenimientoactivofijoDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarMantenimientoActivoFijo(mantenimientoactivofijos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				MantenimientoActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesMantenimientoActivoFijo(this.mantenimientoactivofijos);
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
		mantenimientoactivofijos = new  ArrayList<MantenimientoActivoFijo>();
		  		  
        try {
			MantenimientoActivoFijoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			mantenimientoactivofijos=mantenimientoactivofijoDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarMantenimientoActivoFijo(mantenimientoactivofijos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				MantenimientoActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesMantenimientoActivoFijo(this.mantenimientoactivofijos);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosMantenimientoActivoFijosWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		mantenimientoactivofijos = new  ArrayList<MantenimientoActivoFijo>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,MantenimientoActivoFijo.class.getSimpleName()+"-getTodosMantenimientoActivoFijosWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			MantenimientoActivoFijoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			mantenimientoactivofijos=mantenimientoactivofijoDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarMantenimientoActivoFijo(mantenimientoactivofijos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				MantenimientoActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesMantenimientoActivoFijo(this.mantenimientoactivofijos);
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
	
	public  void  getTodosMantenimientoActivoFijos(String sFinalQuery,Pagination pagination)throws Exception {
		mantenimientoactivofijos = new  ArrayList<MantenimientoActivoFijo>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			MantenimientoActivoFijoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			mantenimientoactivofijos=mantenimientoactivofijoDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarMantenimientoActivoFijo(mantenimientoactivofijos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				MantenimientoActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesMantenimientoActivoFijo(this.mantenimientoactivofijos);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarMantenimientoActivoFijo(MantenimientoActivoFijo mantenimientoactivofijo) throws Exception {
		Boolean estaValidado=false;
		
		if(mantenimientoactivofijo.getIsNew() || mantenimientoactivofijo.getIsChanged()) { 
			this.invalidValues = mantenimientoactivofijoValidator.getInvalidValues(mantenimientoactivofijo);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(mantenimientoactivofijo);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarMantenimientoActivoFijo(List<MantenimientoActivoFijo> MantenimientoActivoFijos) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(MantenimientoActivoFijo mantenimientoactivofijoLocal:mantenimientoactivofijos) {				
			estaValidadoObjeto=this.validarGuardarMantenimientoActivoFijo(mantenimientoactivofijoLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarMantenimientoActivoFijo(List<MantenimientoActivoFijo> MantenimientoActivoFijos) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarMantenimientoActivoFijo(mantenimientoactivofijos)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarMantenimientoActivoFijo(MantenimientoActivoFijo MantenimientoActivoFijo) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarMantenimientoActivoFijo(mantenimientoactivofijo)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(MantenimientoActivoFijo mantenimientoactivofijo) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+mantenimientoactivofijo.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=MantenimientoActivoFijoConstantesFunciones.getMantenimientoActivoFijoLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"mantenimientoactivofijo","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(MantenimientoActivoFijoConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(MantenimientoActivoFijoConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveMantenimientoActivoFijoWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,MantenimientoActivoFijo.class.getSimpleName()+"-saveMantenimientoActivoFijoWithConnection");connexion.begin();			
			
			MantenimientoActivoFijoLogicAdditional.checkMantenimientoActivoFijoToSave(this.mantenimientoactivofijo,this.datosCliente,connexion,this.arrDatoGeneral);
			
			MantenimientoActivoFijoLogicAdditional.updateMantenimientoActivoFijoToSave(this.mantenimientoactivofijo,this.arrDatoGeneral);
			
			MantenimientoActivoFijoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.mantenimientoactivofijo,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowMantenimientoActivoFijo();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarMantenimientoActivoFijo(this.mantenimientoactivofijo)) {
				MantenimientoActivoFijoDataAccess.save(this.mantenimientoactivofijo, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.mantenimientoactivofijo,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			MantenimientoActivoFijoLogicAdditional.checkMantenimientoActivoFijoToSaveAfter(this.mantenimientoactivofijo,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowMantenimientoActivoFijo();
			
			connexion.commit();			
			
			if(this.mantenimientoactivofijo.getIsDeleted()) {
				this.mantenimientoactivofijo=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveMantenimientoActivoFijo()throws Exception {	
		try {	
			
			MantenimientoActivoFijoLogicAdditional.checkMantenimientoActivoFijoToSave(this.mantenimientoactivofijo,this.datosCliente,connexion,this.arrDatoGeneral);
			
			MantenimientoActivoFijoLogicAdditional.updateMantenimientoActivoFijoToSave(this.mantenimientoactivofijo,this.arrDatoGeneral);
			
			MantenimientoActivoFijoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.mantenimientoactivofijo,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarMantenimientoActivoFijo(this.mantenimientoactivofijo)) {			
				MantenimientoActivoFijoDataAccess.save(this.mantenimientoactivofijo, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.mantenimientoactivofijo,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			MantenimientoActivoFijoLogicAdditional.checkMantenimientoActivoFijoToSaveAfter(this.mantenimientoactivofijo,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.mantenimientoactivofijo.getIsDeleted()) {
				this.mantenimientoactivofijo=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveMantenimientoActivoFijosWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,MantenimientoActivoFijo.class.getSimpleName()+"-saveMantenimientoActivoFijosWithConnection");connexion.begin();			
			
			MantenimientoActivoFijoLogicAdditional.checkMantenimientoActivoFijoToSaves(mantenimientoactivofijos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowMantenimientoActivoFijos();
			
			Boolean validadoTodosMantenimientoActivoFijo=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(MantenimientoActivoFijo mantenimientoactivofijoLocal:mantenimientoactivofijos) {		
				if(mantenimientoactivofijoLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				MantenimientoActivoFijoLogicAdditional.updateMantenimientoActivoFijoToSave(mantenimientoactivofijoLocal,this.arrDatoGeneral);
	        	
				MantenimientoActivoFijoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),mantenimientoactivofijoLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarMantenimientoActivoFijo(mantenimientoactivofijoLocal)) {
					MantenimientoActivoFijoDataAccess.save(mantenimientoactivofijoLocal, connexion);				
				} else {
					validadoTodosMantenimientoActivoFijo=false;
				}
			}
			
			if(!validadoTodosMantenimientoActivoFijo) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			MantenimientoActivoFijoLogicAdditional.checkMantenimientoActivoFijoToSavesAfter(mantenimientoactivofijos,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowMantenimientoActivoFijos();
			
			connexion.commit();		
			
			this.quitarMantenimientoActivoFijosEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveMantenimientoActivoFijos()throws Exception {				
		 try {	
			MantenimientoActivoFijoLogicAdditional.checkMantenimientoActivoFijoToSaves(mantenimientoactivofijos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosMantenimientoActivoFijo=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(MantenimientoActivoFijo mantenimientoactivofijoLocal:mantenimientoactivofijos) {				
				if(mantenimientoactivofijoLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				MantenimientoActivoFijoLogicAdditional.updateMantenimientoActivoFijoToSave(mantenimientoactivofijoLocal,this.arrDatoGeneral);
	        	
				MantenimientoActivoFijoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),mantenimientoactivofijoLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarMantenimientoActivoFijo(mantenimientoactivofijoLocal)) {				
					MantenimientoActivoFijoDataAccess.save(mantenimientoactivofijoLocal, connexion);				
				} else {
					validadoTodosMantenimientoActivoFijo=false;
				}
			}
			
			if(!validadoTodosMantenimientoActivoFijo) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			MantenimientoActivoFijoLogicAdditional.checkMantenimientoActivoFijoToSavesAfter(mantenimientoactivofijos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarMantenimientoActivoFijosEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public MantenimientoActivoFijoParameterReturnGeneral procesarAccionMantenimientoActivoFijos(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<MantenimientoActivoFijo> mantenimientoactivofijos,MantenimientoActivoFijoParameterReturnGeneral mantenimientoactivofijoParameterGeneral)throws Exception {
		 try {	
			MantenimientoActivoFijoParameterReturnGeneral mantenimientoactivofijoReturnGeneral=new MantenimientoActivoFijoParameterReturnGeneral();
	
			MantenimientoActivoFijoLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,mantenimientoactivofijos,mantenimientoactivofijoParameterGeneral,mantenimientoactivofijoReturnGeneral);
			
			return mantenimientoactivofijoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public MantenimientoActivoFijoParameterReturnGeneral procesarAccionMantenimientoActivoFijosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<MantenimientoActivoFijo> mantenimientoactivofijos,MantenimientoActivoFijoParameterReturnGeneral mantenimientoactivofijoParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,MantenimientoActivoFijo.class.getSimpleName()+"-procesarAccionMantenimientoActivoFijosWithConnection");connexion.begin();			
			
			MantenimientoActivoFijoParameterReturnGeneral mantenimientoactivofijoReturnGeneral=new MantenimientoActivoFijoParameterReturnGeneral();
	
			MantenimientoActivoFijoLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,mantenimientoactivofijos,mantenimientoactivofijoParameterGeneral,mantenimientoactivofijoReturnGeneral);
			
			this.connexion.commit();
			
			return mantenimientoactivofijoReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public MantenimientoActivoFijoParameterReturnGeneral procesarEventosMantenimientoActivoFijos(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<MantenimientoActivoFijo> mantenimientoactivofijos,MantenimientoActivoFijo mantenimientoactivofijo,MantenimientoActivoFijoParameterReturnGeneral mantenimientoactivofijoParameterGeneral,Boolean isEsNuevoMantenimientoActivoFijo,ArrayList<Classe> clases)throws Exception {
		 try {	
			MantenimientoActivoFijoParameterReturnGeneral mantenimientoactivofijoReturnGeneral=new MantenimientoActivoFijoParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				mantenimientoactivofijoReturnGeneral.setConRecargarPropiedades(true);
			}
			
			MantenimientoActivoFijoLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,mantenimientoactivofijos,mantenimientoactivofijo,mantenimientoactivofijoParameterGeneral,mantenimientoactivofijoReturnGeneral,isEsNuevoMantenimientoActivoFijo,clases);
			
			return mantenimientoactivofijoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public MantenimientoActivoFijoParameterReturnGeneral procesarEventosMantenimientoActivoFijosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<MantenimientoActivoFijo> mantenimientoactivofijos,MantenimientoActivoFijo mantenimientoactivofijo,MantenimientoActivoFijoParameterReturnGeneral mantenimientoactivofijoParameterGeneral,Boolean isEsNuevoMantenimientoActivoFijo,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,MantenimientoActivoFijo.class.getSimpleName()+"-procesarEventosMantenimientoActivoFijosWithConnection");connexion.begin();			
			
			MantenimientoActivoFijoParameterReturnGeneral mantenimientoactivofijoReturnGeneral=new MantenimientoActivoFijoParameterReturnGeneral();
	
			mantenimientoactivofijoReturnGeneral.setMantenimientoActivoFijo(mantenimientoactivofijo);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				mantenimientoactivofijoReturnGeneral.setConRecargarPropiedades(true);
			}
			
			MantenimientoActivoFijoLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,mantenimientoactivofijos,mantenimientoactivofijo,mantenimientoactivofijoParameterGeneral,mantenimientoactivofijoReturnGeneral,isEsNuevoMantenimientoActivoFijo,clases);
			
			this.connexion.commit();
			
			return mantenimientoactivofijoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public MantenimientoActivoFijoParameterReturnGeneral procesarImportacionMantenimientoActivoFijosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,MantenimientoActivoFijoParameterReturnGeneral mantenimientoactivofijoParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,MantenimientoActivoFijo.class.getSimpleName()+"-procesarImportacionMantenimientoActivoFijosWithConnection");connexion.begin();			
			
			MantenimientoActivoFijoParameterReturnGeneral mantenimientoactivofijoReturnGeneral=new MantenimientoActivoFijoParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.mantenimientoactivofijos=new ArrayList<MantenimientoActivoFijo>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.mantenimientoactivofijo=new MantenimientoActivoFijo();
				
				
				if(conColumnasBase) {this.mantenimientoactivofijo.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.mantenimientoactivofijo.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.mantenimientoactivofijo.setnumero_documento(arrColumnas[iColumn++]);
			this.mantenimientoactivofijo.setcausa(arrColumnas[iColumn++]);
			this.mantenimientoactivofijo.setreferencia(arrColumnas[iColumn++]);
			this.mantenimientoactivofijo.settaller(arrColumnas[iColumn++]);
				this.mantenimientoactivofijo.settelefono(arrColumnas[iColumn++]);
				this.mantenimientoactivofijo.setfecha_inicio(Funciones.ConvertToDate(arrColumnas[iColumn++]));
				this.mantenimientoactivofijo.setfecha_entrega(Funciones.ConvertToDate(arrColumnas[iColumn++]));
				this.mantenimientoactivofijo.setcosto(Double.parseDouble(arrColumnas[iColumn++]));
			this.mantenimientoactivofijo.setresponsable(arrColumnas[iColumn++]);
			this.mantenimientoactivofijo.setobservacion(arrColumnas[iColumn++]);
				
				this.mantenimientoactivofijos.add(this.mantenimientoactivofijo);
			}
			
			this.saveMantenimientoActivoFijos();
			
			this.connexion.commit();
			
			mantenimientoactivofijoReturnGeneral.setConRetornoEstaProcesado(true);
			mantenimientoactivofijoReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return mantenimientoactivofijoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarMantenimientoActivoFijosEliminados() throws Exception {				
		
		List<MantenimientoActivoFijo> mantenimientoactivofijosAux= new ArrayList<MantenimientoActivoFijo>();
		
		for(MantenimientoActivoFijo mantenimientoactivofijo:mantenimientoactivofijos) {
			if(!mantenimientoactivofijo.getIsDeleted()) {
				mantenimientoactivofijosAux.add(mantenimientoactivofijo);
			}
		}
		
		mantenimientoactivofijos=mantenimientoactivofijosAux;
	}
	
	public void quitarMantenimientoActivoFijosNulos() throws Exception {				
		
		List<MantenimientoActivoFijo> mantenimientoactivofijosAux= new ArrayList<MantenimientoActivoFijo>();
		
		for(MantenimientoActivoFijo mantenimientoactivofijo : this.mantenimientoactivofijos) {
			if(mantenimientoactivofijo==null) {
				mantenimientoactivofijosAux.add(mantenimientoactivofijo);
			}
		}
		
		//this.mantenimientoactivofijos=mantenimientoactivofijosAux;
		
		this.mantenimientoactivofijos.removeAll(mantenimientoactivofijosAux);
	}
	
	public void getSetVersionRowMantenimientoActivoFijoWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(mantenimientoactivofijo.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((mantenimientoactivofijo.getIsDeleted() || (mantenimientoactivofijo.getIsChanged()&&!mantenimientoactivofijo.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=mantenimientoactivofijoDataAccess.getSetVersionRowMantenimientoActivoFijo(connexion,mantenimientoactivofijo.getId());
				
				if(!mantenimientoactivofijo.getVersionRow().equals(timestamp)) {	
					mantenimientoactivofijo.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				mantenimientoactivofijo.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowMantenimientoActivoFijo()throws Exception {	
		
		if(mantenimientoactivofijo.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((mantenimientoactivofijo.getIsDeleted() || (mantenimientoactivofijo.getIsChanged()&&!mantenimientoactivofijo.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=mantenimientoactivofijoDataAccess.getSetVersionRowMantenimientoActivoFijo(connexion,mantenimientoactivofijo.getId());
			
			try {							
				if(!mantenimientoactivofijo.getVersionRow().equals(timestamp)) {	
					mantenimientoactivofijo.setVersionRow(timestamp);
				}
				
				mantenimientoactivofijo.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowMantenimientoActivoFijosWithConnection()throws Exception {	
		if(mantenimientoactivofijos!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(MantenimientoActivoFijo mantenimientoactivofijoAux:mantenimientoactivofijos) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(mantenimientoactivofijoAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(mantenimientoactivofijoAux.getIsDeleted() || (mantenimientoactivofijoAux.getIsChanged()&&!mantenimientoactivofijoAux.getIsNew())) {
						
						timestamp=mantenimientoactivofijoDataAccess.getSetVersionRowMantenimientoActivoFijo(connexion,mantenimientoactivofijoAux.getId());
						
						if(!mantenimientoactivofijo.getVersionRow().equals(timestamp)) {	
							mantenimientoactivofijoAux.setVersionRow(timestamp);
						}
								
						mantenimientoactivofijoAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowMantenimientoActivoFijos()throws Exception {	
		if(mantenimientoactivofijos!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(MantenimientoActivoFijo mantenimientoactivofijoAux:mantenimientoactivofijos) {
					if(mantenimientoactivofijoAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(mantenimientoactivofijoAux.getIsDeleted() || (mantenimientoactivofijoAux.getIsChanged()&&!mantenimientoactivofijoAux.getIsNew())) {
						
						timestamp=mantenimientoactivofijoDataAccess.getSetVersionRowMantenimientoActivoFijo(connexion,mantenimientoactivofijoAux.getId());
						
						if(!mantenimientoactivofijoAux.getVersionRow().equals(timestamp)) {	
							mantenimientoactivofijoAux.setVersionRow(timestamp);
						}
						
													
						mantenimientoactivofijoAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public MantenimientoActivoFijoParameterReturnGeneral cargarCombosLoteForeignKeyMantenimientoActivoFijoWithConnection(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalDetalleActivoFijo,String finalQueryGlobalTipoMovimiento) throws Exception {
		MantenimientoActivoFijoParameterReturnGeneral  mantenimientoactivofijoReturnGeneral =new MantenimientoActivoFijoParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,MantenimientoActivoFijo.class.getSimpleName()+"-cargarCombosLoteForeignKeyMantenimientoActivoFijoWithConnection");connexion.begin();
			
			mantenimientoactivofijoReturnGeneral =new MantenimientoActivoFijoParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			mantenimientoactivofijoReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			mantenimientoactivofijoReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<DetalleActivoFijo> detalleactivofijosForeignKey=new ArrayList<DetalleActivoFijo>();
			DetalleActivoFijoLogic detalleactivofijoLogic=new DetalleActivoFijoLogic();
			detalleactivofijoLogic.setConnexion(this.connexion);
			detalleactivofijoLogic.getDetalleActivoFijoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalDetalleActivoFijo.equals("NONE")) {
				detalleactivofijoLogic.getTodosDetalleActivoFijos(finalQueryGlobalDetalleActivoFijo,new Pagination());
				detalleactivofijosForeignKey=detalleactivofijoLogic.getDetalleActivoFijos();
			}

			mantenimientoactivofijoReturnGeneral.setdetalleactivofijosForeignKey(detalleactivofijosForeignKey);


			List<TipoMovimiento> tipomovimientosForeignKey=new ArrayList<TipoMovimiento>();
			TipoMovimientoLogic tipomovimientoLogic=new TipoMovimientoLogic();
			tipomovimientoLogic.setConnexion(this.connexion);
			tipomovimientoLogic.getTipoMovimientoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoMovimiento.equals("NONE")) {
				tipomovimientoLogic.getTodosTipoMovimientos(finalQueryGlobalTipoMovimiento,new Pagination());
				tipomovimientosForeignKey=tipomovimientoLogic.getTipoMovimientos();
			}

			mantenimientoactivofijoReturnGeneral.settipomovimientosForeignKey(tipomovimientosForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return mantenimientoactivofijoReturnGeneral;
	}
	
	public MantenimientoActivoFijoParameterReturnGeneral cargarCombosLoteForeignKeyMantenimientoActivoFijo(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalDetalleActivoFijo,String finalQueryGlobalTipoMovimiento) throws Exception {
		MantenimientoActivoFijoParameterReturnGeneral  mantenimientoactivofijoReturnGeneral =new MantenimientoActivoFijoParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			mantenimientoactivofijoReturnGeneral =new MantenimientoActivoFijoParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			mantenimientoactivofijoReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			mantenimientoactivofijoReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<DetalleActivoFijo> detalleactivofijosForeignKey=new ArrayList<DetalleActivoFijo>();
			DetalleActivoFijoLogic detalleactivofijoLogic=new DetalleActivoFijoLogic();
			detalleactivofijoLogic.setConnexion(this.connexion);
			detalleactivofijoLogic.getDetalleActivoFijoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalDetalleActivoFijo.equals("NONE")) {
				detalleactivofijoLogic.getTodosDetalleActivoFijos(finalQueryGlobalDetalleActivoFijo,new Pagination());
				detalleactivofijosForeignKey=detalleactivofijoLogic.getDetalleActivoFijos();
			}

			mantenimientoactivofijoReturnGeneral.setdetalleactivofijosForeignKey(detalleactivofijosForeignKey);


			List<TipoMovimiento> tipomovimientosForeignKey=new ArrayList<TipoMovimiento>();
			TipoMovimientoLogic tipomovimientoLogic=new TipoMovimientoLogic();
			tipomovimientoLogic.setConnexion(this.connexion);
			tipomovimientoLogic.getTipoMovimientoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoMovimiento.equals("NONE")) {
				tipomovimientoLogic.getTodosTipoMovimientos(finalQueryGlobalTipoMovimiento,new Pagination());
				tipomovimientosForeignKey=tipomovimientoLogic.getTipoMovimientos();
			}

			mantenimientoactivofijoReturnGeneral.settipomovimientosForeignKey(tipomovimientosForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return mantenimientoactivofijoReturnGeneral;
	}
	
	
	public void deepLoad(MantenimientoActivoFijo mantenimientoactivofijo,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			MantenimientoActivoFijoLogicAdditional.updateMantenimientoActivoFijoToGet(mantenimientoactivofijo,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		mantenimientoactivofijo.setEmpresa(mantenimientoactivofijoDataAccess.getEmpresa(connexion,mantenimientoactivofijo));
		mantenimientoactivofijo.setSucursal(mantenimientoactivofijoDataAccess.getSucursal(connexion,mantenimientoactivofijo));
		mantenimientoactivofijo.setDetalleActivoFijo(mantenimientoactivofijoDataAccess.getDetalleActivoFijo(connexion,mantenimientoactivofijo));
		mantenimientoactivofijo.setTipoMovimiento(mantenimientoactivofijoDataAccess.getTipoMovimiento(connexion,mantenimientoactivofijo));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				mantenimientoactivofijo.setEmpresa(mantenimientoactivofijoDataAccess.getEmpresa(connexion,mantenimientoactivofijo));
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				mantenimientoactivofijo.setSucursal(mantenimientoactivofijoDataAccess.getSucursal(connexion,mantenimientoactivofijo));
				continue;
			}

			if(clas.clas.equals(DetalleActivoFijo.class)) {
				mantenimientoactivofijo.setDetalleActivoFijo(mantenimientoactivofijoDataAccess.getDetalleActivoFijo(connexion,mantenimientoactivofijo));
				continue;
			}

			if(clas.clas.equals(TipoMovimiento.class)) {
				mantenimientoactivofijo.setTipoMovimiento(mantenimientoactivofijoDataAccess.getTipoMovimiento(connexion,mantenimientoactivofijo));
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
			mantenimientoactivofijo.setEmpresa(mantenimientoactivofijoDataAccess.getEmpresa(connexion,mantenimientoactivofijo));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			mantenimientoactivofijo.setSucursal(mantenimientoactivofijoDataAccess.getSucursal(connexion,mantenimientoactivofijo));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(DetalleActivoFijo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			mantenimientoactivofijo.setDetalleActivoFijo(mantenimientoactivofijoDataAccess.getDetalleActivoFijo(connexion,mantenimientoactivofijo));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoMovimiento.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			mantenimientoactivofijo.setTipoMovimiento(mantenimientoactivofijoDataAccess.getTipoMovimiento(connexion,mantenimientoactivofijo));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		mantenimientoactivofijo.setEmpresa(mantenimientoactivofijoDataAccess.getEmpresa(connexion,mantenimientoactivofijo));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(mantenimientoactivofijo.getEmpresa(),isDeep,deepLoadType,clases);
				
		mantenimientoactivofijo.setSucursal(mantenimientoactivofijoDataAccess.getSucursal(connexion,mantenimientoactivofijo));
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(mantenimientoactivofijo.getSucursal(),isDeep,deepLoadType,clases);
				
		mantenimientoactivofijo.setDetalleActivoFijo(mantenimientoactivofijoDataAccess.getDetalleActivoFijo(connexion,mantenimientoactivofijo));
		DetalleActivoFijoLogic detalleactivofijoLogic= new DetalleActivoFijoLogic(connexion);
		detalleactivofijoLogic.deepLoad(mantenimientoactivofijo.getDetalleActivoFijo(),isDeep,deepLoadType,clases);
				
		mantenimientoactivofijo.setTipoMovimiento(mantenimientoactivofijoDataAccess.getTipoMovimiento(connexion,mantenimientoactivofijo));
		TipoMovimientoLogic tipomovimientoLogic= new TipoMovimientoLogic(connexion);
		tipomovimientoLogic.deepLoad(mantenimientoactivofijo.getTipoMovimiento(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				mantenimientoactivofijo.setEmpresa(mantenimientoactivofijoDataAccess.getEmpresa(connexion,mantenimientoactivofijo));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(mantenimientoactivofijo.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				mantenimientoactivofijo.setSucursal(mantenimientoactivofijoDataAccess.getSucursal(connexion,mantenimientoactivofijo));
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepLoad(mantenimientoactivofijo.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(DetalleActivoFijo.class)) {
				mantenimientoactivofijo.setDetalleActivoFijo(mantenimientoactivofijoDataAccess.getDetalleActivoFijo(connexion,mantenimientoactivofijo));
				DetalleActivoFijoLogic detalleactivofijoLogic= new DetalleActivoFijoLogic(connexion);
				detalleactivofijoLogic.deepLoad(mantenimientoactivofijo.getDetalleActivoFijo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoMovimiento.class)) {
				mantenimientoactivofijo.setTipoMovimiento(mantenimientoactivofijoDataAccess.getTipoMovimiento(connexion,mantenimientoactivofijo));
				TipoMovimientoLogic tipomovimientoLogic= new TipoMovimientoLogic(connexion);
				tipomovimientoLogic.deepLoad(mantenimientoactivofijo.getTipoMovimiento(),isDeep,deepLoadType,clases);				
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
			mantenimientoactivofijo.setEmpresa(mantenimientoactivofijoDataAccess.getEmpresa(connexion,mantenimientoactivofijo));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(mantenimientoactivofijo.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			mantenimientoactivofijo.setSucursal(mantenimientoactivofijoDataAccess.getSucursal(connexion,mantenimientoactivofijo));
			SucursalLogic sucursalLogic= new SucursalLogic(connexion);
			sucursalLogic.deepLoad(mantenimientoactivofijo.getSucursal(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(DetalleActivoFijo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			mantenimientoactivofijo.setDetalleActivoFijo(mantenimientoactivofijoDataAccess.getDetalleActivoFijo(connexion,mantenimientoactivofijo));
			DetalleActivoFijoLogic detalleactivofijoLogic= new DetalleActivoFijoLogic(connexion);
			detalleactivofijoLogic.deepLoad(mantenimientoactivofijo.getDetalleActivoFijo(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoMovimiento.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			mantenimientoactivofijo.setTipoMovimiento(mantenimientoactivofijoDataAccess.getTipoMovimiento(connexion,mantenimientoactivofijo));
			TipoMovimientoLogic tipomovimientoLogic= new TipoMovimientoLogic(connexion);
			tipomovimientoLogic.deepLoad(mantenimientoactivofijo.getTipoMovimiento(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(MantenimientoActivoFijo mantenimientoactivofijo,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			MantenimientoActivoFijoLogicAdditional.updateMantenimientoActivoFijoToSave(mantenimientoactivofijo,this.arrDatoGeneral);
			
MantenimientoActivoFijoDataAccess.save(mantenimientoactivofijo, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(mantenimientoactivofijo.getEmpresa(),connexion);

		SucursalDataAccess.save(mantenimientoactivofijo.getSucursal(),connexion);

		DetalleActivoFijoDataAccess.save(mantenimientoactivofijo.getDetalleActivoFijo(),connexion);

		TipoMovimientoDataAccess.save(mantenimientoactivofijo.getTipoMovimiento(),connexion);
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(mantenimientoactivofijo.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(mantenimientoactivofijo.getSucursal(),connexion);
				continue;
			}

			if(clas.clas.equals(DetalleActivoFijo.class)) {
				DetalleActivoFijoDataAccess.save(mantenimientoactivofijo.getDetalleActivoFijo(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoMovimiento.class)) {
				TipoMovimientoDataAccess.save(mantenimientoactivofijo.getTipoMovimiento(),connexion);
				continue;
			}

		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(mantenimientoactivofijo.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(mantenimientoactivofijo.getEmpresa(),isDeep,deepLoadType,clases);
				

		SucursalDataAccess.save(mantenimientoactivofijo.getSucursal(),connexion);
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(mantenimientoactivofijo.getSucursal(),isDeep,deepLoadType,clases);
				

		DetalleActivoFijoDataAccess.save(mantenimientoactivofijo.getDetalleActivoFijo(),connexion);
		DetalleActivoFijoLogic detalleactivofijoLogic= new DetalleActivoFijoLogic(connexion);
		detalleactivofijoLogic.deepLoad(mantenimientoactivofijo.getDetalleActivoFijo(),isDeep,deepLoadType,clases);
				

		TipoMovimientoDataAccess.save(mantenimientoactivofijo.getTipoMovimiento(),connexion);
		TipoMovimientoLogic tipomovimientoLogic= new TipoMovimientoLogic(connexion);
		tipomovimientoLogic.deepLoad(mantenimientoactivofijo.getTipoMovimiento(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(mantenimientoactivofijo.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(mantenimientoactivofijo.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(mantenimientoactivofijo.getSucursal(),connexion);
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepSave(mantenimientoactivofijo.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(DetalleActivoFijo.class)) {
				DetalleActivoFijoDataAccess.save(mantenimientoactivofijo.getDetalleActivoFijo(),connexion);
				DetalleActivoFijoLogic detalleactivofijoLogic= new DetalleActivoFijoLogic(connexion);
				detalleactivofijoLogic.deepSave(mantenimientoactivofijo.getDetalleActivoFijo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoMovimiento.class)) {
				TipoMovimientoDataAccess.save(mantenimientoactivofijo.getTipoMovimiento(),connexion);
				TipoMovimientoLogic tipomovimientoLogic= new TipoMovimientoLogic(connexion);
				tipomovimientoLogic.deepSave(mantenimientoactivofijo.getTipoMovimiento(),isDeep,deepLoadType,clases);				
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
			this.getNewConnexionToDeep(MantenimientoActivoFijo.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(mantenimientoactivofijo,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				MantenimientoActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesMantenimientoActivoFijo(mantenimientoactivofijo);
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
			this.deepLoad(this.mantenimientoactivofijo,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				MantenimientoActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesMantenimientoActivoFijo(this.mantenimientoactivofijo);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(MantenimientoActivoFijo.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(mantenimientoactivofijos!=null) {
				for(MantenimientoActivoFijo mantenimientoactivofijo:mantenimientoactivofijos) {
					this.deepLoad(mantenimientoactivofijo,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					MantenimientoActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesMantenimientoActivoFijo(mantenimientoactivofijos);
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
			if(mantenimientoactivofijos!=null) {
				for(MantenimientoActivoFijo mantenimientoactivofijo:mantenimientoactivofijos) {
					this.deepLoad(mantenimientoactivofijo,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					MantenimientoActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesMantenimientoActivoFijo(mantenimientoactivofijos);
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
			this.getNewConnexionToDeep(MantenimientoActivoFijo.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(mantenimientoactivofijo,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(MantenimientoActivoFijo.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(mantenimientoactivofijos!=null) {
				for(MantenimientoActivoFijo mantenimientoactivofijo:mantenimientoactivofijos) {
					this.deepSave(mantenimientoactivofijo,isDeep,deepLoadType,clases);
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
			if(mantenimientoactivofijos!=null) {
				for(MantenimientoActivoFijo mantenimientoactivofijo:mantenimientoactivofijos) {
					this.deepSave(mantenimientoactivofijo,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getMantenimientoActivoFijosFK_IdDetalleActivoFijoWithConnection(String sFinalQuery,Pagination pagination,Long id_detalle_activo_fijo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,MantenimientoActivoFijo.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidDetalleActivoFijo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidDetalleActivoFijo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_detalle_activo_fijo,MantenimientoActivoFijoConstantesFunciones.IDDETALLEACTIVOFIJO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidDetalleActivoFijo);

			MantenimientoActivoFijoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdDetalleActivoFijo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			mantenimientoactivofijos=mantenimientoactivofijoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				MantenimientoActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesMantenimientoActivoFijo(this.mantenimientoactivofijos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getMantenimientoActivoFijosFK_IdDetalleActivoFijo(String sFinalQuery,Pagination pagination,Long id_detalle_activo_fijo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidDetalleActivoFijo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidDetalleActivoFijo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_detalle_activo_fijo,MantenimientoActivoFijoConstantesFunciones.IDDETALLEACTIVOFIJO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidDetalleActivoFijo);

			MantenimientoActivoFijoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdDetalleActivoFijo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			mantenimientoactivofijos=mantenimientoactivofijoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				MantenimientoActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesMantenimientoActivoFijo(this.mantenimientoactivofijos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getMantenimientoActivoFijosFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,MantenimientoActivoFijo.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,MantenimientoActivoFijoConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			MantenimientoActivoFijoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			mantenimientoactivofijos=mantenimientoactivofijoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				MantenimientoActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesMantenimientoActivoFijo(this.mantenimientoactivofijos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getMantenimientoActivoFijosFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,MantenimientoActivoFijoConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			MantenimientoActivoFijoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			mantenimientoactivofijos=mantenimientoactivofijoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				MantenimientoActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesMantenimientoActivoFijo(this.mantenimientoactivofijos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getMantenimientoActivoFijosFK_IdSucursalWithConnection(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,MantenimientoActivoFijo.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,MantenimientoActivoFijoConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			MantenimientoActivoFijoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			mantenimientoactivofijos=mantenimientoactivofijoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				MantenimientoActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesMantenimientoActivoFijo(this.mantenimientoactivofijos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getMantenimientoActivoFijosFK_IdSucursal(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,MantenimientoActivoFijoConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			MantenimientoActivoFijoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			mantenimientoactivofijos=mantenimientoactivofijoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				MantenimientoActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesMantenimientoActivoFijo(this.mantenimientoactivofijos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getMantenimientoActivoFijosFK_IdTipoMovimientoWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_movimiento)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,MantenimientoActivoFijo.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoMovimiento= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoMovimiento.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_movimiento,MantenimientoActivoFijoConstantesFunciones.IDTIPOMOVIMIENTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoMovimiento);

			MantenimientoActivoFijoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoMovimiento","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			mantenimientoactivofijos=mantenimientoactivofijoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				MantenimientoActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesMantenimientoActivoFijo(this.mantenimientoactivofijos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getMantenimientoActivoFijosFK_IdTipoMovimiento(String sFinalQuery,Pagination pagination,Long id_tipo_movimiento)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoMovimiento= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoMovimiento.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_movimiento,MantenimientoActivoFijoConstantesFunciones.IDTIPOMOVIMIENTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoMovimiento);

			MantenimientoActivoFijoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoMovimiento","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			mantenimientoactivofijos=mantenimientoactivofijoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				MantenimientoActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesMantenimientoActivoFijo(this.mantenimientoactivofijos);
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
			if(MantenimientoActivoFijoConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,MantenimientoActivoFijoDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,MantenimientoActivoFijo mantenimientoactivofijo,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(MantenimientoActivoFijoConstantesFunciones.ISCONAUDITORIA) {
				if(mantenimientoactivofijo.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,MantenimientoActivoFijoDataAccess.TABLENAME, mantenimientoactivofijo.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(MantenimientoActivoFijoConstantesFunciones.ISCONAUDITORIADETALLE) {
						////MantenimientoActivoFijoLogic.registrarAuditoriaDetallesMantenimientoActivoFijo(connexion,mantenimientoactivofijo,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(mantenimientoactivofijo.getIsDeleted()) {
					/*if(!mantenimientoactivofijo.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,MantenimientoActivoFijoDataAccess.TABLENAME, mantenimientoactivofijo.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////MantenimientoActivoFijoLogic.registrarAuditoriaDetallesMantenimientoActivoFijo(connexion,mantenimientoactivofijo,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,MantenimientoActivoFijoDataAccess.TABLENAME, mantenimientoactivofijo.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(mantenimientoactivofijo.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,MantenimientoActivoFijoDataAccess.TABLENAME, mantenimientoactivofijo.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(MantenimientoActivoFijoConstantesFunciones.ISCONAUDITORIADETALLE) {
						////MantenimientoActivoFijoLogic.registrarAuditoriaDetallesMantenimientoActivoFijo(connexion,mantenimientoactivofijo,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesMantenimientoActivoFijo(Connexion connexion,MantenimientoActivoFijo mantenimientoactivofijo)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(mantenimientoactivofijo.getIsNew()||!mantenimientoactivofijo.getid_empresa().equals(mantenimientoactivofijo.getMantenimientoActivoFijoOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(mantenimientoactivofijo.getMantenimientoActivoFijoOriginal().getid_empresa()!=null)
				{
					strValorActual=mantenimientoactivofijo.getMantenimientoActivoFijoOriginal().getid_empresa().toString();
				}
				if(mantenimientoactivofijo.getid_empresa()!=null)
				{
					strValorNuevo=mantenimientoactivofijo.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),MantenimientoActivoFijoConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(mantenimientoactivofijo.getIsNew()||!mantenimientoactivofijo.getid_sucursal().equals(mantenimientoactivofijo.getMantenimientoActivoFijoOriginal().getid_sucursal()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(mantenimientoactivofijo.getMantenimientoActivoFijoOriginal().getid_sucursal()!=null)
				{
					strValorActual=mantenimientoactivofijo.getMantenimientoActivoFijoOriginal().getid_sucursal().toString();
				}
				if(mantenimientoactivofijo.getid_sucursal()!=null)
				{
					strValorNuevo=mantenimientoactivofijo.getid_sucursal().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),MantenimientoActivoFijoConstantesFunciones.IDSUCURSAL,strValorActual,strValorNuevo);
			}	
			
			if(mantenimientoactivofijo.getIsNew()||!mantenimientoactivofijo.getid_detalle_activo_fijo().equals(mantenimientoactivofijo.getMantenimientoActivoFijoOriginal().getid_detalle_activo_fijo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(mantenimientoactivofijo.getMantenimientoActivoFijoOriginal().getid_detalle_activo_fijo()!=null)
				{
					strValorActual=mantenimientoactivofijo.getMantenimientoActivoFijoOriginal().getid_detalle_activo_fijo().toString();
				}
				if(mantenimientoactivofijo.getid_detalle_activo_fijo()!=null)
				{
					strValorNuevo=mantenimientoactivofijo.getid_detalle_activo_fijo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),MantenimientoActivoFijoConstantesFunciones.IDDETALLEACTIVOFIJO,strValorActual,strValorNuevo);
			}	
			
			if(mantenimientoactivofijo.getIsNew()||!mantenimientoactivofijo.getid_tipo_movimiento().equals(mantenimientoactivofijo.getMantenimientoActivoFijoOriginal().getid_tipo_movimiento()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(mantenimientoactivofijo.getMantenimientoActivoFijoOriginal().getid_tipo_movimiento()!=null)
				{
					strValorActual=mantenimientoactivofijo.getMantenimientoActivoFijoOriginal().getid_tipo_movimiento().toString();
				}
				if(mantenimientoactivofijo.getid_tipo_movimiento()!=null)
				{
					strValorNuevo=mantenimientoactivofijo.getid_tipo_movimiento().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),MantenimientoActivoFijoConstantesFunciones.IDTIPOMOVIMIENTO,strValorActual,strValorNuevo);
			}	
			
			if(mantenimientoactivofijo.getIsNew()||!mantenimientoactivofijo.getnumero_documento().equals(mantenimientoactivofijo.getMantenimientoActivoFijoOriginal().getnumero_documento()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(mantenimientoactivofijo.getMantenimientoActivoFijoOriginal().getnumero_documento()!=null)
				{
					strValorActual=mantenimientoactivofijo.getMantenimientoActivoFijoOriginal().getnumero_documento();
				}
				if(mantenimientoactivofijo.getnumero_documento()!=null)
				{
					strValorNuevo=mantenimientoactivofijo.getnumero_documento() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),MantenimientoActivoFijoConstantesFunciones.NUMERODOCUMENTO,strValorActual,strValorNuevo);
			}	
			
			if(mantenimientoactivofijo.getIsNew()||!mantenimientoactivofijo.getcausa().equals(mantenimientoactivofijo.getMantenimientoActivoFijoOriginal().getcausa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(mantenimientoactivofijo.getMantenimientoActivoFijoOriginal().getcausa()!=null)
				{
					strValorActual=mantenimientoactivofijo.getMantenimientoActivoFijoOriginal().getcausa();
				}
				if(mantenimientoactivofijo.getcausa()!=null)
				{
					strValorNuevo=mantenimientoactivofijo.getcausa() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),MantenimientoActivoFijoConstantesFunciones.CAUSA,strValorActual,strValorNuevo);
			}	
			
			if(mantenimientoactivofijo.getIsNew()||!mantenimientoactivofijo.getreferencia().equals(mantenimientoactivofijo.getMantenimientoActivoFijoOriginal().getreferencia()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(mantenimientoactivofijo.getMantenimientoActivoFijoOriginal().getreferencia()!=null)
				{
					strValorActual=mantenimientoactivofijo.getMantenimientoActivoFijoOriginal().getreferencia();
				}
				if(mantenimientoactivofijo.getreferencia()!=null)
				{
					strValorNuevo=mantenimientoactivofijo.getreferencia() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),MantenimientoActivoFijoConstantesFunciones.REFERENCIA,strValorActual,strValorNuevo);
			}	
			
			if(mantenimientoactivofijo.getIsNew()||!mantenimientoactivofijo.gettaller().equals(mantenimientoactivofijo.getMantenimientoActivoFijoOriginal().gettaller()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(mantenimientoactivofijo.getMantenimientoActivoFijoOriginal().gettaller()!=null)
				{
					strValorActual=mantenimientoactivofijo.getMantenimientoActivoFijoOriginal().gettaller();
				}
				if(mantenimientoactivofijo.gettaller()!=null)
				{
					strValorNuevo=mantenimientoactivofijo.gettaller() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),MantenimientoActivoFijoConstantesFunciones.TALLER,strValorActual,strValorNuevo);
			}	
			
			if(mantenimientoactivofijo.getIsNew()||!mantenimientoactivofijo.gettelefono().equals(mantenimientoactivofijo.getMantenimientoActivoFijoOriginal().gettelefono()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(mantenimientoactivofijo.getMantenimientoActivoFijoOriginal().gettelefono()!=null)
				{
					strValorActual=mantenimientoactivofijo.getMantenimientoActivoFijoOriginal().gettelefono();
				}
				if(mantenimientoactivofijo.gettelefono()!=null)
				{
					strValorNuevo=mantenimientoactivofijo.gettelefono() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),MantenimientoActivoFijoConstantesFunciones.TELEFONO,strValorActual,strValorNuevo);
			}	
			
			if(mantenimientoactivofijo.getIsNew()||!mantenimientoactivofijo.getfecha_inicio().equals(mantenimientoactivofijo.getMantenimientoActivoFijoOriginal().getfecha_inicio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(mantenimientoactivofijo.getMantenimientoActivoFijoOriginal().getfecha_inicio()!=null)
				{
					strValorActual=mantenimientoactivofijo.getMantenimientoActivoFijoOriginal().getfecha_inicio().toString();
				}
				if(mantenimientoactivofijo.getfecha_inicio()!=null)
				{
					strValorNuevo=mantenimientoactivofijo.getfecha_inicio().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),MantenimientoActivoFijoConstantesFunciones.FECHAINICIO,strValorActual,strValorNuevo);
			}	
			
			if(mantenimientoactivofijo.getIsNew()||!mantenimientoactivofijo.getfecha_entrega().equals(mantenimientoactivofijo.getMantenimientoActivoFijoOriginal().getfecha_entrega()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(mantenimientoactivofijo.getMantenimientoActivoFijoOriginal().getfecha_entrega()!=null)
				{
					strValorActual=mantenimientoactivofijo.getMantenimientoActivoFijoOriginal().getfecha_entrega().toString();
				}
				if(mantenimientoactivofijo.getfecha_entrega()!=null)
				{
					strValorNuevo=mantenimientoactivofijo.getfecha_entrega().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),MantenimientoActivoFijoConstantesFunciones.FECHAENTREGA,strValorActual,strValorNuevo);
			}	
			
			if(mantenimientoactivofijo.getIsNew()||!mantenimientoactivofijo.getcosto().equals(mantenimientoactivofijo.getMantenimientoActivoFijoOriginal().getcosto()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(mantenimientoactivofijo.getMantenimientoActivoFijoOriginal().getcosto()!=null)
				{
					strValorActual=mantenimientoactivofijo.getMantenimientoActivoFijoOriginal().getcosto().toString();
				}
				if(mantenimientoactivofijo.getcosto()!=null)
				{
					strValorNuevo=mantenimientoactivofijo.getcosto().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),MantenimientoActivoFijoConstantesFunciones.COSTO,strValorActual,strValorNuevo);
			}	
			
			if(mantenimientoactivofijo.getIsNew()||!mantenimientoactivofijo.getresponsable().equals(mantenimientoactivofijo.getMantenimientoActivoFijoOriginal().getresponsable()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(mantenimientoactivofijo.getMantenimientoActivoFijoOriginal().getresponsable()!=null)
				{
					strValorActual=mantenimientoactivofijo.getMantenimientoActivoFijoOriginal().getresponsable();
				}
				if(mantenimientoactivofijo.getresponsable()!=null)
				{
					strValorNuevo=mantenimientoactivofijo.getresponsable() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),MantenimientoActivoFijoConstantesFunciones.RESPONSABLE,strValorActual,strValorNuevo);
			}	
			
			if(mantenimientoactivofijo.getIsNew()||!mantenimientoactivofijo.getobservacion().equals(mantenimientoactivofijo.getMantenimientoActivoFijoOriginal().getobservacion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(mantenimientoactivofijo.getMantenimientoActivoFijoOriginal().getobservacion()!=null)
				{
					strValorActual=mantenimientoactivofijo.getMantenimientoActivoFijoOriginal().getobservacion();
				}
				if(mantenimientoactivofijo.getobservacion()!=null)
				{
					strValorNuevo=mantenimientoactivofijo.getobservacion() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),MantenimientoActivoFijoConstantesFunciones.OBSERVACION,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveMantenimientoActivoFijoRelacionesWithConnection(MantenimientoActivoFijo mantenimientoactivofijo) throws Exception {

		if(!mantenimientoactivofijo.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveMantenimientoActivoFijoRelacionesBase(mantenimientoactivofijo,true);
		}
	}

	public void saveMantenimientoActivoFijoRelaciones(MantenimientoActivoFijo mantenimientoactivofijo)throws Exception {

		if(!mantenimientoactivofijo.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveMantenimientoActivoFijoRelacionesBase(mantenimientoactivofijo,false);
		}
	}

	public void saveMantenimientoActivoFijoRelacionesBase(MantenimientoActivoFijo mantenimientoactivofijo,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("MantenimientoActivoFijo-saveRelacionesWithConnection");}
	

			this.setMantenimientoActivoFijo(mantenimientoactivofijo);

			if(MantenimientoActivoFijoLogicAdditional.validarSaveRelaciones(mantenimientoactivofijo,this)) {

				MantenimientoActivoFijoLogicAdditional.updateRelacionesToSave(mantenimientoactivofijo,this);

				if((mantenimientoactivofijo.getIsNew()||mantenimientoactivofijo.getIsChanged())&&!mantenimientoactivofijo.getIsDeleted()) {
					this.saveMantenimientoActivoFijo();
					this.saveMantenimientoActivoFijoRelacionesDetalles();

				} else if(mantenimientoactivofijo.getIsDeleted()) {
					this.saveMantenimientoActivoFijoRelacionesDetalles();
					this.saveMantenimientoActivoFijo();
				}

				MantenimientoActivoFijoLogicAdditional.updateRelacionesToSaveAfter(mantenimientoactivofijo,this);

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
	
	
	private void saveMantenimientoActivoFijoRelacionesDetalles()throws Exception {
		try {
	

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfMantenimientoActivoFijo(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=MantenimientoActivoFijoConstantesFunciones.getClassesForeignKeysOfMantenimientoActivoFijo(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfMantenimientoActivoFijo(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=MantenimientoActivoFijoConstantesFunciones.getClassesRelationshipsOfMantenimientoActivoFijo(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

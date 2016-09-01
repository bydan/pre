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
package com.bydan.erp.contabilidad.business.logic;

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
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.contabilidad.util.ParametroContabilidadDefectoConstantesFunciones;
import com.bydan.erp.contabilidad.util.ParametroContabilidadDefectoParameterReturnGeneral;
//import com.bydan.erp.contabilidad.util.ParametroContabilidadDefectoParameterGeneral;
import com.bydan.erp.contabilidad.business.entity.ParametroContabilidadDefecto;
import com.bydan.erp.contabilidad.business.logic.ParametroContabilidadDefectoLogicAdditional;
import com.bydan.erp.contabilidad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;


import com.bydan.erp.seguridad.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;








@SuppressWarnings("unused")
public class ParametroContabilidadDefectoLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(ParametroContabilidadDefectoLogic.class);
	
	protected ParametroContabilidadDefectoDataAccess parametrocontabilidaddefectoDataAccess; 	
	protected ParametroContabilidadDefecto parametrocontabilidaddefecto;
	protected List<ParametroContabilidadDefecto> parametrocontabilidaddefectos;
	protected Object parametrocontabilidaddefectoObject;	
	protected List<Object> parametrocontabilidaddefectosObject;
	
	public static ClassValidator<ParametroContabilidadDefecto> parametrocontabilidaddefectoValidator = new ClassValidator<ParametroContabilidadDefecto>(ParametroContabilidadDefecto.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected ParametroContabilidadDefectoLogicAdditional parametrocontabilidaddefectoLogicAdditional=null;
	
	public ParametroContabilidadDefectoLogicAdditional getParametroContabilidadDefectoLogicAdditional() {
		return this.parametrocontabilidaddefectoLogicAdditional;
	}
	
	public void setParametroContabilidadDefectoLogicAdditional(ParametroContabilidadDefectoLogicAdditional parametrocontabilidaddefectoLogicAdditional) {
		try {
			this.parametrocontabilidaddefectoLogicAdditional=parametrocontabilidaddefectoLogicAdditional;
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
	
	
	
	
	public  ParametroContabilidadDefectoLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.parametrocontabilidaddefectoDataAccess = new ParametroContabilidadDefectoDataAccess();
			
			this.parametrocontabilidaddefectos= new ArrayList<ParametroContabilidadDefecto>();
			this.parametrocontabilidaddefecto= new ParametroContabilidadDefecto();
			
			this.parametrocontabilidaddefectoObject=new Object();
			this.parametrocontabilidaddefectosObject=new ArrayList<Object>();
				
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
			
			this.parametrocontabilidaddefectoDataAccess.setConnexionType(this.connexionType);
			this.parametrocontabilidaddefectoDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  ParametroContabilidadDefectoLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.parametrocontabilidaddefectoDataAccess = new ParametroContabilidadDefectoDataAccess();
			this.parametrocontabilidaddefectos= new ArrayList<ParametroContabilidadDefecto>();
			this.parametrocontabilidaddefecto= new ParametroContabilidadDefecto();
			this.parametrocontabilidaddefectoObject=new Object();
			this.parametrocontabilidaddefectosObject=new ArrayList<Object>();
			
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
			
			this.parametrocontabilidaddefectoDataAccess.setConnexionType(this.connexionType);
			this.parametrocontabilidaddefectoDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public ParametroContabilidadDefecto getParametroContabilidadDefecto() throws Exception {	
		ParametroContabilidadDefectoLogicAdditional.checkParametroContabilidadDefectoToGet(parametrocontabilidaddefecto,this.datosCliente,this.arrDatoGeneral);
		ParametroContabilidadDefectoLogicAdditional.updateParametroContabilidadDefectoToGet(parametrocontabilidaddefecto,this.arrDatoGeneral);
		
		return parametrocontabilidaddefecto;
	}
		
	public void setParametroContabilidadDefecto(ParametroContabilidadDefecto newParametroContabilidadDefecto) {
		this.parametrocontabilidaddefecto = newParametroContabilidadDefecto;
	}
	
	public ParametroContabilidadDefectoDataAccess getParametroContabilidadDefectoDataAccess() {
		return parametrocontabilidaddefectoDataAccess;
	}
	
	public void setParametroContabilidadDefectoDataAccess(ParametroContabilidadDefectoDataAccess newparametrocontabilidaddefectoDataAccess) {
		this.parametrocontabilidaddefectoDataAccess = newparametrocontabilidaddefectoDataAccess;
	}
	
	public List<ParametroContabilidadDefecto> getParametroContabilidadDefectos() throws Exception {		
		this.quitarParametroContabilidadDefectosNulos();
		
		ParametroContabilidadDefectoLogicAdditional.checkParametroContabilidadDefectoToGets(parametrocontabilidaddefectos,this.datosCliente,this.arrDatoGeneral);
		
		for (ParametroContabilidadDefecto parametrocontabilidaddefectoLocal: parametrocontabilidaddefectos ) {
			ParametroContabilidadDefectoLogicAdditional.updateParametroContabilidadDefectoToGet(parametrocontabilidaddefectoLocal,this.arrDatoGeneral);
		}
		
		return parametrocontabilidaddefectos;
	}
	
	public void setParametroContabilidadDefectos(List<ParametroContabilidadDefecto> newParametroContabilidadDefectos) {
		this.parametrocontabilidaddefectos = newParametroContabilidadDefectos;
	}
	
	public Object getParametroContabilidadDefectoObject() {	
		this.parametrocontabilidaddefectoObject=this.parametrocontabilidaddefectoDataAccess.getEntityObject();
		return this.parametrocontabilidaddefectoObject;
	}
		
	public void setParametroContabilidadDefectoObject(Object newParametroContabilidadDefectoObject) {
		this.parametrocontabilidaddefectoObject = newParametroContabilidadDefectoObject;
	}
	
	public List<Object> getParametroContabilidadDefectosObject() {		
		this.parametrocontabilidaddefectosObject=this.parametrocontabilidaddefectoDataAccess.getEntitiesObject();
		return this.parametrocontabilidaddefectosObject;
	}
		
	public void setParametroContabilidadDefectosObject(List<Object> newParametroContabilidadDefectosObject) {
		this.parametrocontabilidaddefectosObject = newParametroContabilidadDefectosObject;
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
		
		if(this.parametrocontabilidaddefectoDataAccess!=null) {
			this.parametrocontabilidaddefectoDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroContabilidadDefecto.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			parametrocontabilidaddefectoDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			parametrocontabilidaddefectoDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		parametrocontabilidaddefecto = new  ParametroContabilidadDefecto();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroContabilidadDefecto.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			parametrocontabilidaddefecto=parametrocontabilidaddefectoDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.parametrocontabilidaddefecto,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ParametroContabilidadDefectoConstantesFunciones.refrescarForeignKeysDescripcionesParametroContabilidadDefecto(this.parametrocontabilidaddefecto);
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
		parametrocontabilidaddefecto = new  ParametroContabilidadDefecto();
		  		  
        try {
			
			parametrocontabilidaddefecto=parametrocontabilidaddefectoDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.parametrocontabilidaddefecto,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ParametroContabilidadDefectoConstantesFunciones.refrescarForeignKeysDescripcionesParametroContabilidadDefecto(this.parametrocontabilidaddefecto);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		parametrocontabilidaddefecto = new  ParametroContabilidadDefecto();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroContabilidadDefecto.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			parametrocontabilidaddefecto=parametrocontabilidaddefectoDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.parametrocontabilidaddefecto,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ParametroContabilidadDefectoConstantesFunciones.refrescarForeignKeysDescripcionesParametroContabilidadDefecto(this.parametrocontabilidaddefecto);
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
		parametrocontabilidaddefecto = new  ParametroContabilidadDefecto();
		  		  
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
		parametrocontabilidaddefecto = new  ParametroContabilidadDefecto();
		  		  
        try {
			
			parametrocontabilidaddefecto=parametrocontabilidaddefectoDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.parametrocontabilidaddefecto,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ParametroContabilidadDefectoConstantesFunciones.refrescarForeignKeysDescripcionesParametroContabilidadDefecto(this.parametrocontabilidaddefecto);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		parametrocontabilidaddefecto = new  ParametroContabilidadDefecto();
		  		  
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
		parametrocontabilidaddefecto = new  ParametroContabilidadDefecto();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroContabilidadDefecto.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =parametrocontabilidaddefectoDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		parametrocontabilidaddefecto = new  ParametroContabilidadDefecto();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=parametrocontabilidaddefectoDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		parametrocontabilidaddefecto = new  ParametroContabilidadDefecto();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroContabilidadDefecto.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =parametrocontabilidaddefectoDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		parametrocontabilidaddefecto = new  ParametroContabilidadDefecto();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=parametrocontabilidaddefectoDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		parametrocontabilidaddefecto = new  ParametroContabilidadDefecto();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroContabilidadDefecto.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =parametrocontabilidaddefectoDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		parametrocontabilidaddefecto = new  ParametroContabilidadDefecto();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=parametrocontabilidaddefectoDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		parametrocontabilidaddefectos = new  ArrayList<ParametroContabilidadDefecto>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroContabilidadDefecto.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			ParametroContabilidadDefectoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametrocontabilidaddefectos=parametrocontabilidaddefectoDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarParametroContabilidadDefecto(parametrocontabilidaddefectos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroContabilidadDefectoConstantesFunciones.refrescarForeignKeysDescripcionesParametroContabilidadDefecto(this.parametrocontabilidaddefectos);
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
		parametrocontabilidaddefectos = new  ArrayList<ParametroContabilidadDefecto>();
		  		  
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
		parametrocontabilidaddefectos = new  ArrayList<ParametroContabilidadDefecto>();
		  		  
        try {			
			ParametroContabilidadDefectoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametrocontabilidaddefectos=parametrocontabilidaddefectoDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarParametroContabilidadDefecto(parametrocontabilidaddefectos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroContabilidadDefectoConstantesFunciones.refrescarForeignKeysDescripcionesParametroContabilidadDefecto(this.parametrocontabilidaddefectos);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		parametrocontabilidaddefectos = new  ArrayList<ParametroContabilidadDefecto>();
		  		  
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
		parametrocontabilidaddefectos = new  ArrayList<ParametroContabilidadDefecto>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroContabilidadDefecto.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			ParametroContabilidadDefectoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametrocontabilidaddefectos=parametrocontabilidaddefectoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarParametroContabilidadDefecto(parametrocontabilidaddefectos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroContabilidadDefectoConstantesFunciones.refrescarForeignKeysDescripcionesParametroContabilidadDefecto(this.parametrocontabilidaddefectos);
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
		parametrocontabilidaddefectos = new  ArrayList<ParametroContabilidadDefecto>();
		  		  
        try {
			ParametroContabilidadDefectoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametrocontabilidaddefectos=parametrocontabilidaddefectoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarParametroContabilidadDefecto(parametrocontabilidaddefectos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroContabilidadDefectoConstantesFunciones.refrescarForeignKeysDescripcionesParametroContabilidadDefecto(this.parametrocontabilidaddefectos);
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
		parametrocontabilidaddefectos = new  ArrayList<ParametroContabilidadDefecto>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroContabilidadDefecto.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ParametroContabilidadDefectoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametrocontabilidaddefectos=parametrocontabilidaddefectoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarParametroContabilidadDefecto(parametrocontabilidaddefectos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroContabilidadDefectoConstantesFunciones.refrescarForeignKeysDescripcionesParametroContabilidadDefecto(this.parametrocontabilidaddefectos);
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
		parametrocontabilidaddefectos = new  ArrayList<ParametroContabilidadDefecto>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ParametroContabilidadDefectoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametrocontabilidaddefectos=parametrocontabilidaddefectoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarParametroContabilidadDefecto(parametrocontabilidaddefectos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroContabilidadDefectoConstantesFunciones.refrescarForeignKeysDescripcionesParametroContabilidadDefecto(this.parametrocontabilidaddefectos);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		parametrocontabilidaddefecto = new  ParametroContabilidadDefecto();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroContabilidadDefecto.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ParametroContabilidadDefectoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametrocontabilidaddefecto=parametrocontabilidaddefectoDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarParametroContabilidadDefecto(parametrocontabilidaddefecto);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroContabilidadDefectoConstantesFunciones.refrescarForeignKeysDescripcionesParametroContabilidadDefecto(this.parametrocontabilidaddefecto);
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
		parametrocontabilidaddefecto = new  ParametroContabilidadDefecto();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ParametroContabilidadDefectoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametrocontabilidaddefecto=parametrocontabilidaddefectoDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarParametroContabilidadDefecto(parametrocontabilidaddefecto);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroContabilidadDefectoConstantesFunciones.refrescarForeignKeysDescripcionesParametroContabilidadDefecto(this.parametrocontabilidaddefecto);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		parametrocontabilidaddefectos = new  ArrayList<ParametroContabilidadDefecto>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroContabilidadDefecto.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			ParametroContabilidadDefectoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametrocontabilidaddefectos=parametrocontabilidaddefectoDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarParametroContabilidadDefecto(parametrocontabilidaddefectos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroContabilidadDefectoConstantesFunciones.refrescarForeignKeysDescripcionesParametroContabilidadDefecto(this.parametrocontabilidaddefectos);
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
		parametrocontabilidaddefectos = new  ArrayList<ParametroContabilidadDefecto>();
		  		  
        try {
			ParametroContabilidadDefectoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametrocontabilidaddefectos=parametrocontabilidaddefectoDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarParametroContabilidadDefecto(parametrocontabilidaddefectos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroContabilidadDefectoConstantesFunciones.refrescarForeignKeysDescripcionesParametroContabilidadDefecto(this.parametrocontabilidaddefectos);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosParametroContabilidadDefectosWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		parametrocontabilidaddefectos = new  ArrayList<ParametroContabilidadDefecto>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroContabilidadDefecto.class.getSimpleName()+"-getTodosParametroContabilidadDefectosWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ParametroContabilidadDefectoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametrocontabilidaddefectos=parametrocontabilidaddefectoDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarParametroContabilidadDefecto(parametrocontabilidaddefectos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroContabilidadDefectoConstantesFunciones.refrescarForeignKeysDescripcionesParametroContabilidadDefecto(this.parametrocontabilidaddefectos);
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
	
	public  void  getTodosParametroContabilidadDefectos(String sFinalQuery,Pagination pagination)throws Exception {
		parametrocontabilidaddefectos = new  ArrayList<ParametroContabilidadDefecto>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ParametroContabilidadDefectoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametrocontabilidaddefectos=parametrocontabilidaddefectoDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarParametroContabilidadDefecto(parametrocontabilidaddefectos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroContabilidadDefectoConstantesFunciones.refrescarForeignKeysDescripcionesParametroContabilidadDefecto(this.parametrocontabilidaddefectos);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarParametroContabilidadDefecto(ParametroContabilidadDefecto parametrocontabilidaddefecto) throws Exception {
		Boolean estaValidado=false;
		
		if(parametrocontabilidaddefecto.getIsNew() || parametrocontabilidaddefecto.getIsChanged()) { 
			this.invalidValues = parametrocontabilidaddefectoValidator.getInvalidValues(parametrocontabilidaddefecto);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(parametrocontabilidaddefecto);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarParametroContabilidadDefecto(List<ParametroContabilidadDefecto> ParametroContabilidadDefectos) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(ParametroContabilidadDefecto parametrocontabilidaddefectoLocal:parametrocontabilidaddefectos) {				
			estaValidadoObjeto=this.validarGuardarParametroContabilidadDefecto(parametrocontabilidaddefectoLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarParametroContabilidadDefecto(List<ParametroContabilidadDefecto> ParametroContabilidadDefectos) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarParametroContabilidadDefecto(parametrocontabilidaddefectos)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarParametroContabilidadDefecto(ParametroContabilidadDefecto ParametroContabilidadDefecto) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarParametroContabilidadDefecto(parametrocontabilidaddefecto)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(ParametroContabilidadDefecto parametrocontabilidaddefecto) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+parametrocontabilidaddefecto.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=ParametroContabilidadDefectoConstantesFunciones.getParametroContabilidadDefectoLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"parametrocontabilidaddefecto","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(ParametroContabilidadDefectoConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(ParametroContabilidadDefectoConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveParametroContabilidadDefectoWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroContabilidadDefecto.class.getSimpleName()+"-saveParametroContabilidadDefectoWithConnection");connexion.begin();			
			
			ParametroContabilidadDefectoLogicAdditional.checkParametroContabilidadDefectoToSave(this.parametrocontabilidaddefecto,this.datosCliente,connexion,this.arrDatoGeneral);
			
			ParametroContabilidadDefectoLogicAdditional.updateParametroContabilidadDefectoToSave(this.parametrocontabilidaddefecto,this.arrDatoGeneral);
			
			ParametroContabilidadDefectoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.parametrocontabilidaddefecto,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowParametroContabilidadDefecto();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarParametroContabilidadDefecto(this.parametrocontabilidaddefecto)) {
				ParametroContabilidadDefectoDataAccess.save(this.parametrocontabilidaddefecto, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.parametrocontabilidaddefecto,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			ParametroContabilidadDefectoLogicAdditional.checkParametroContabilidadDefectoToSaveAfter(this.parametrocontabilidaddefecto,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowParametroContabilidadDefecto();
			
			connexion.commit();			
			
			if(this.parametrocontabilidaddefecto.getIsDeleted()) {
				this.parametrocontabilidaddefecto=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveParametroContabilidadDefecto()throws Exception {	
		try {	
			
			ParametroContabilidadDefectoLogicAdditional.checkParametroContabilidadDefectoToSave(this.parametrocontabilidaddefecto,this.datosCliente,connexion,this.arrDatoGeneral);
			
			ParametroContabilidadDefectoLogicAdditional.updateParametroContabilidadDefectoToSave(this.parametrocontabilidaddefecto,this.arrDatoGeneral);
			
			ParametroContabilidadDefectoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.parametrocontabilidaddefecto,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarParametroContabilidadDefecto(this.parametrocontabilidaddefecto)) {			
				ParametroContabilidadDefectoDataAccess.save(this.parametrocontabilidaddefecto, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.parametrocontabilidaddefecto,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			ParametroContabilidadDefectoLogicAdditional.checkParametroContabilidadDefectoToSaveAfter(this.parametrocontabilidaddefecto,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.parametrocontabilidaddefecto.getIsDeleted()) {
				this.parametrocontabilidaddefecto=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveParametroContabilidadDefectosWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroContabilidadDefecto.class.getSimpleName()+"-saveParametroContabilidadDefectosWithConnection");connexion.begin();			
			
			ParametroContabilidadDefectoLogicAdditional.checkParametroContabilidadDefectoToSaves(parametrocontabilidaddefectos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowParametroContabilidadDefectos();
			
			Boolean validadoTodosParametroContabilidadDefecto=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(ParametroContabilidadDefecto parametrocontabilidaddefectoLocal:parametrocontabilidaddefectos) {		
				if(parametrocontabilidaddefectoLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				ParametroContabilidadDefectoLogicAdditional.updateParametroContabilidadDefectoToSave(parametrocontabilidaddefectoLocal,this.arrDatoGeneral);
	        	
				ParametroContabilidadDefectoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),parametrocontabilidaddefectoLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarParametroContabilidadDefecto(parametrocontabilidaddefectoLocal)) {
					ParametroContabilidadDefectoDataAccess.save(parametrocontabilidaddefectoLocal, connexion);				
				} else {
					validadoTodosParametroContabilidadDefecto=false;
				}
			}
			
			if(!validadoTodosParametroContabilidadDefecto) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			ParametroContabilidadDefectoLogicAdditional.checkParametroContabilidadDefectoToSavesAfter(parametrocontabilidaddefectos,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowParametroContabilidadDefectos();
			
			connexion.commit();		
			
			this.quitarParametroContabilidadDefectosEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveParametroContabilidadDefectos()throws Exception {				
		 try {	
			ParametroContabilidadDefectoLogicAdditional.checkParametroContabilidadDefectoToSaves(parametrocontabilidaddefectos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosParametroContabilidadDefecto=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(ParametroContabilidadDefecto parametrocontabilidaddefectoLocal:parametrocontabilidaddefectos) {				
				if(parametrocontabilidaddefectoLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				ParametroContabilidadDefectoLogicAdditional.updateParametroContabilidadDefectoToSave(parametrocontabilidaddefectoLocal,this.arrDatoGeneral);
	        	
				ParametroContabilidadDefectoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),parametrocontabilidaddefectoLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarParametroContabilidadDefecto(parametrocontabilidaddefectoLocal)) {				
					ParametroContabilidadDefectoDataAccess.save(parametrocontabilidaddefectoLocal, connexion);				
				} else {
					validadoTodosParametroContabilidadDefecto=false;
				}
			}
			
			if(!validadoTodosParametroContabilidadDefecto) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			ParametroContabilidadDefectoLogicAdditional.checkParametroContabilidadDefectoToSavesAfter(parametrocontabilidaddefectos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarParametroContabilidadDefectosEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public ParametroContabilidadDefectoParameterReturnGeneral procesarAccionParametroContabilidadDefectos(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<ParametroContabilidadDefecto> parametrocontabilidaddefectos,ParametroContabilidadDefectoParameterReturnGeneral parametrocontabilidaddefectoParameterGeneral)throws Exception {
		 try {	
			ParametroContabilidadDefectoParameterReturnGeneral parametrocontabilidaddefectoReturnGeneral=new ParametroContabilidadDefectoParameterReturnGeneral();
	
			ParametroContabilidadDefectoLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,parametrocontabilidaddefectos,parametrocontabilidaddefectoParameterGeneral,parametrocontabilidaddefectoReturnGeneral);
			
			return parametrocontabilidaddefectoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public ParametroContabilidadDefectoParameterReturnGeneral procesarAccionParametroContabilidadDefectosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<ParametroContabilidadDefecto> parametrocontabilidaddefectos,ParametroContabilidadDefectoParameterReturnGeneral parametrocontabilidaddefectoParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroContabilidadDefecto.class.getSimpleName()+"-procesarAccionParametroContabilidadDefectosWithConnection");connexion.begin();			
			
			ParametroContabilidadDefectoParameterReturnGeneral parametrocontabilidaddefectoReturnGeneral=new ParametroContabilidadDefectoParameterReturnGeneral();
	
			ParametroContabilidadDefectoLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,parametrocontabilidaddefectos,parametrocontabilidaddefectoParameterGeneral,parametrocontabilidaddefectoReturnGeneral);
			
			this.connexion.commit();
			
			return parametrocontabilidaddefectoReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public ParametroContabilidadDefectoParameterReturnGeneral procesarEventosParametroContabilidadDefectos(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<ParametroContabilidadDefecto> parametrocontabilidaddefectos,ParametroContabilidadDefecto parametrocontabilidaddefecto,ParametroContabilidadDefectoParameterReturnGeneral parametrocontabilidaddefectoParameterGeneral,Boolean isEsNuevoParametroContabilidadDefecto,ArrayList<Classe> clases)throws Exception {
		 try {	
			ParametroContabilidadDefectoParameterReturnGeneral parametrocontabilidaddefectoReturnGeneral=new ParametroContabilidadDefectoParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				parametrocontabilidaddefectoReturnGeneral.setConRecargarPropiedades(true);
			}
			
			ParametroContabilidadDefectoLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,parametrocontabilidaddefectos,parametrocontabilidaddefecto,parametrocontabilidaddefectoParameterGeneral,parametrocontabilidaddefectoReturnGeneral,isEsNuevoParametroContabilidadDefecto,clases);
			
			return parametrocontabilidaddefectoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public ParametroContabilidadDefectoParameterReturnGeneral procesarEventosParametroContabilidadDefectosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<ParametroContabilidadDefecto> parametrocontabilidaddefectos,ParametroContabilidadDefecto parametrocontabilidaddefecto,ParametroContabilidadDefectoParameterReturnGeneral parametrocontabilidaddefectoParameterGeneral,Boolean isEsNuevoParametroContabilidadDefecto,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroContabilidadDefecto.class.getSimpleName()+"-procesarEventosParametroContabilidadDefectosWithConnection");connexion.begin();			
			
			ParametroContabilidadDefectoParameterReturnGeneral parametrocontabilidaddefectoReturnGeneral=new ParametroContabilidadDefectoParameterReturnGeneral();
	
			parametrocontabilidaddefectoReturnGeneral.setParametroContabilidadDefecto(parametrocontabilidaddefecto);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				parametrocontabilidaddefectoReturnGeneral.setConRecargarPropiedades(true);
			}
			
			ParametroContabilidadDefectoLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,parametrocontabilidaddefectos,parametrocontabilidaddefecto,parametrocontabilidaddefectoParameterGeneral,parametrocontabilidaddefectoReturnGeneral,isEsNuevoParametroContabilidadDefecto,clases);
			
			this.connexion.commit();
			
			return parametrocontabilidaddefectoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public ParametroContabilidadDefectoParameterReturnGeneral procesarImportacionParametroContabilidadDefectosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,ParametroContabilidadDefectoParameterReturnGeneral parametrocontabilidaddefectoParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroContabilidadDefecto.class.getSimpleName()+"-procesarImportacionParametroContabilidadDefectosWithConnection");connexion.begin();			
			
			ParametroContabilidadDefectoParameterReturnGeneral parametrocontabilidaddefectoReturnGeneral=new ParametroContabilidadDefectoParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.parametrocontabilidaddefectos=new ArrayList<ParametroContabilidadDefecto>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.parametrocontabilidaddefecto=new ParametroContabilidadDefecto();
				
				
				if(conColumnasBase) {this.parametrocontabilidaddefecto.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.parametrocontabilidaddefecto.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				
				this.parametrocontabilidaddefectos.add(this.parametrocontabilidaddefecto);
			}
			
			this.saveParametroContabilidadDefectos();
			
			this.connexion.commit();
			
			parametrocontabilidaddefectoReturnGeneral.setConRetornoEstaProcesado(true);
			parametrocontabilidaddefectoReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return parametrocontabilidaddefectoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarParametroContabilidadDefectosEliminados() throws Exception {				
		
		List<ParametroContabilidadDefecto> parametrocontabilidaddefectosAux= new ArrayList<ParametroContabilidadDefecto>();
		
		for(ParametroContabilidadDefecto parametrocontabilidaddefecto:parametrocontabilidaddefectos) {
			if(!parametrocontabilidaddefecto.getIsDeleted()) {
				parametrocontabilidaddefectosAux.add(parametrocontabilidaddefecto);
			}
		}
		
		parametrocontabilidaddefectos=parametrocontabilidaddefectosAux;
	}
	
	public void quitarParametroContabilidadDefectosNulos() throws Exception {				
		
		List<ParametroContabilidadDefecto> parametrocontabilidaddefectosAux= new ArrayList<ParametroContabilidadDefecto>();
		
		for(ParametroContabilidadDefecto parametrocontabilidaddefecto : this.parametrocontabilidaddefectos) {
			if(parametrocontabilidaddefecto==null) {
				parametrocontabilidaddefectosAux.add(parametrocontabilidaddefecto);
			}
		}
		
		//this.parametrocontabilidaddefectos=parametrocontabilidaddefectosAux;
		
		this.parametrocontabilidaddefectos.removeAll(parametrocontabilidaddefectosAux);
	}
	
	public void getSetVersionRowParametroContabilidadDefectoWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(parametrocontabilidaddefecto.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((parametrocontabilidaddefecto.getIsDeleted() || (parametrocontabilidaddefecto.getIsChanged()&&!parametrocontabilidaddefecto.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=parametrocontabilidaddefectoDataAccess.getSetVersionRowParametroContabilidadDefecto(connexion,parametrocontabilidaddefecto.getId());
				
				if(!parametrocontabilidaddefecto.getVersionRow().equals(timestamp)) {	
					parametrocontabilidaddefecto.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				parametrocontabilidaddefecto.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowParametroContabilidadDefecto()throws Exception {	
		
		if(parametrocontabilidaddefecto.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((parametrocontabilidaddefecto.getIsDeleted() || (parametrocontabilidaddefecto.getIsChanged()&&!parametrocontabilidaddefecto.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=parametrocontabilidaddefectoDataAccess.getSetVersionRowParametroContabilidadDefecto(connexion,parametrocontabilidaddefecto.getId());
			
			try {							
				if(!parametrocontabilidaddefecto.getVersionRow().equals(timestamp)) {	
					parametrocontabilidaddefecto.setVersionRow(timestamp);
				}
				
				parametrocontabilidaddefecto.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowParametroContabilidadDefectosWithConnection()throws Exception {	
		if(parametrocontabilidaddefectos!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(ParametroContabilidadDefecto parametrocontabilidaddefectoAux:parametrocontabilidaddefectos) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(parametrocontabilidaddefectoAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(parametrocontabilidaddefectoAux.getIsDeleted() || (parametrocontabilidaddefectoAux.getIsChanged()&&!parametrocontabilidaddefectoAux.getIsNew())) {
						
						timestamp=parametrocontabilidaddefectoDataAccess.getSetVersionRowParametroContabilidadDefecto(connexion,parametrocontabilidaddefectoAux.getId());
						
						if(!parametrocontabilidaddefecto.getVersionRow().equals(timestamp)) {	
							parametrocontabilidaddefectoAux.setVersionRow(timestamp);
						}
								
						parametrocontabilidaddefectoAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowParametroContabilidadDefectos()throws Exception {	
		if(parametrocontabilidaddefectos!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(ParametroContabilidadDefecto parametrocontabilidaddefectoAux:parametrocontabilidaddefectos) {
					if(parametrocontabilidaddefectoAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(parametrocontabilidaddefectoAux.getIsDeleted() || (parametrocontabilidaddefectoAux.getIsChanged()&&!parametrocontabilidaddefectoAux.getIsNew())) {
						
						timestamp=parametrocontabilidaddefectoDataAccess.getSetVersionRowParametroContabilidadDefecto(connexion,parametrocontabilidaddefectoAux.getId());
						
						if(!parametrocontabilidaddefectoAux.getVersionRow().equals(timestamp)) {	
							parametrocontabilidaddefectoAux.setVersionRow(timestamp);
						}
						
													
						parametrocontabilidaddefectoAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public ParametroContabilidadDefectoParameterReturnGeneral cargarCombosLoteForeignKeyParametroContabilidadDefectoWithConnection(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalTipoMoneda,String finalQueryGlobalMoneda,String finalQueryGlobalModulo,String finalQueryGlobalTipoIntervalo,String finalQueryGlobalTipoMovimiento,String finalQueryGlobalTipoDocumento,String finalQueryGlobalEstadoAsientoContable) throws Exception {
		ParametroContabilidadDefectoParameterReturnGeneral  parametrocontabilidaddefectoReturnGeneral =new ParametroContabilidadDefectoParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroContabilidadDefecto.class.getSimpleName()+"-cargarCombosLoteForeignKeyParametroContabilidadDefectoWithConnection");connexion.begin();
			
			parametrocontabilidaddefectoReturnGeneral =new ParametroContabilidadDefectoParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			parametrocontabilidaddefectoReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			parametrocontabilidaddefectoReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<TipoMoneda> tipomonedasForeignKey=new ArrayList<TipoMoneda>();
			TipoMonedaLogic tipomonedaLogic=new TipoMonedaLogic();
			tipomonedaLogic.setConnexion(this.connexion);
			tipomonedaLogic.getTipoMonedaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoMoneda.equals("NONE")) {
				tipomonedaLogic.getTodosTipoMonedas(finalQueryGlobalTipoMoneda,new Pagination());
				tipomonedasForeignKey=tipomonedaLogic.getTipoMonedas();
			}

			parametrocontabilidaddefectoReturnGeneral.settipomonedasForeignKey(tipomonedasForeignKey);


			List<Moneda> monedasForeignKey=new ArrayList<Moneda>();
			MonedaLogic monedaLogic=new MonedaLogic();
			monedaLogic.setConnexion(this.connexion);
			//monedaLogic.getMonedaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalMoneda.equals("NONE")) {
				monedaLogic.getTodosMonedas(finalQueryGlobalMoneda,new Pagination());
				monedasForeignKey=monedaLogic.getMonedas();
			}

			parametrocontabilidaddefectoReturnGeneral.setmonedasForeignKey(monedasForeignKey);


			List<Modulo> modulosForeignKey=new ArrayList<Modulo>();
			ModuloLogic moduloLogic=new ModuloLogic();
			moduloLogic.setConnexion(this.connexion);
			moduloLogic.getModuloDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalModulo.equals("NONE")) {
				moduloLogic.getTodosModulos(finalQueryGlobalModulo,new Pagination());
				modulosForeignKey=moduloLogic.getModulos();
			}

			parametrocontabilidaddefectoReturnGeneral.setmodulosForeignKey(modulosForeignKey);


			List<TipoIntervalo> tipointervalosForeignKey=new ArrayList<TipoIntervalo>();
			TipoIntervaloLogic tipointervaloLogic=new TipoIntervaloLogic();
			tipointervaloLogic.setConnexion(this.connexion);
			tipointervaloLogic.getTipoIntervaloDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoIntervalo.equals("NONE")) {
				tipointervaloLogic.getTodosTipoIntervalos(finalQueryGlobalTipoIntervalo,new Pagination());
				tipointervalosForeignKey=tipointervaloLogic.getTipoIntervalos();
			}

			parametrocontabilidaddefectoReturnGeneral.settipointervalosForeignKey(tipointervalosForeignKey);


			List<TipoMovimiento> tipomovimientosForeignKey=new ArrayList<TipoMovimiento>();
			TipoMovimientoLogic tipomovimientoLogic=new TipoMovimientoLogic();
			tipomovimientoLogic.setConnexion(this.connexion);
			tipomovimientoLogic.getTipoMovimientoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoMovimiento.equals("NONE")) {
				tipomovimientoLogic.getTodosTipoMovimientos(finalQueryGlobalTipoMovimiento,new Pagination());
				tipomovimientosForeignKey=tipomovimientoLogic.getTipoMovimientos();
			}

			parametrocontabilidaddefectoReturnGeneral.settipomovimientosForeignKey(tipomovimientosForeignKey);


			List<TipoDocumento> tipodocumentosForeignKey=new ArrayList<TipoDocumento>();
			TipoDocumentoLogic tipodocumentoLogic=new TipoDocumentoLogic();
			tipodocumentoLogic.setConnexion(this.connexion);
			tipodocumentoLogic.getTipoDocumentoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoDocumento.equals("NONE")) {
				tipodocumentoLogic.getTodosTipoDocumentos(finalQueryGlobalTipoDocumento,new Pagination());
				tipodocumentosForeignKey=tipodocumentoLogic.getTipoDocumentos();
			}

			parametrocontabilidaddefectoReturnGeneral.settipodocumentosForeignKey(tipodocumentosForeignKey);


			List<EstadoAsientoContable> estadoasientocontablesForeignKey=new ArrayList<EstadoAsientoContable>();
			EstadoAsientoContableLogic estadoasientocontableLogic=new EstadoAsientoContableLogic();
			estadoasientocontableLogic.setConnexion(this.connexion);
			estadoasientocontableLogic.getEstadoAsientoContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEstadoAsientoContable.equals("NONE")) {
				estadoasientocontableLogic.getTodosEstadoAsientoContables(finalQueryGlobalEstadoAsientoContable,new Pagination());
				estadoasientocontablesForeignKey=estadoasientocontableLogic.getEstadoAsientoContables();
			}

			parametrocontabilidaddefectoReturnGeneral.setestadoasientocontablesForeignKey(estadoasientocontablesForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return parametrocontabilidaddefectoReturnGeneral;
	}
	
	public ParametroContabilidadDefectoParameterReturnGeneral cargarCombosLoteForeignKeyParametroContabilidadDefecto(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalTipoMoneda,String finalQueryGlobalMoneda,String finalQueryGlobalModulo,String finalQueryGlobalTipoIntervalo,String finalQueryGlobalTipoMovimiento,String finalQueryGlobalTipoDocumento,String finalQueryGlobalEstadoAsientoContable) throws Exception {
		ParametroContabilidadDefectoParameterReturnGeneral  parametrocontabilidaddefectoReturnGeneral =new ParametroContabilidadDefectoParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			parametrocontabilidaddefectoReturnGeneral =new ParametroContabilidadDefectoParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			parametrocontabilidaddefectoReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			parametrocontabilidaddefectoReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<TipoMoneda> tipomonedasForeignKey=new ArrayList<TipoMoneda>();
			TipoMonedaLogic tipomonedaLogic=new TipoMonedaLogic();
			tipomonedaLogic.setConnexion(this.connexion);
			tipomonedaLogic.getTipoMonedaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoMoneda.equals("NONE")) {
				tipomonedaLogic.getTodosTipoMonedas(finalQueryGlobalTipoMoneda,new Pagination());
				tipomonedasForeignKey=tipomonedaLogic.getTipoMonedas();
			}

			parametrocontabilidaddefectoReturnGeneral.settipomonedasForeignKey(tipomonedasForeignKey);


			List<Moneda> monedasForeignKey=new ArrayList<Moneda>();
			MonedaLogic monedaLogic=new MonedaLogic();
			monedaLogic.setConnexion(this.connexion);
			//monedaLogic.getMonedaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalMoneda.equals("NONE")) {
				monedaLogic.getTodosMonedas(finalQueryGlobalMoneda,new Pagination());
				monedasForeignKey=monedaLogic.getMonedas();
			}

			parametrocontabilidaddefectoReturnGeneral.setmonedasForeignKey(monedasForeignKey);


			List<Modulo> modulosForeignKey=new ArrayList<Modulo>();
			ModuloLogic moduloLogic=new ModuloLogic();
			moduloLogic.setConnexion(this.connexion);
			moduloLogic.getModuloDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalModulo.equals("NONE")) {
				moduloLogic.getTodosModulos(finalQueryGlobalModulo,new Pagination());
				modulosForeignKey=moduloLogic.getModulos();
			}

			parametrocontabilidaddefectoReturnGeneral.setmodulosForeignKey(modulosForeignKey);


			List<TipoIntervalo> tipointervalosForeignKey=new ArrayList<TipoIntervalo>();
			TipoIntervaloLogic tipointervaloLogic=new TipoIntervaloLogic();
			tipointervaloLogic.setConnexion(this.connexion);
			tipointervaloLogic.getTipoIntervaloDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoIntervalo.equals("NONE")) {
				tipointervaloLogic.getTodosTipoIntervalos(finalQueryGlobalTipoIntervalo,new Pagination());
				tipointervalosForeignKey=tipointervaloLogic.getTipoIntervalos();
			}

			parametrocontabilidaddefectoReturnGeneral.settipointervalosForeignKey(tipointervalosForeignKey);


			List<TipoMovimiento> tipomovimientosForeignKey=new ArrayList<TipoMovimiento>();
			TipoMovimientoLogic tipomovimientoLogic=new TipoMovimientoLogic();
			tipomovimientoLogic.setConnexion(this.connexion);
			tipomovimientoLogic.getTipoMovimientoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoMovimiento.equals("NONE")) {
				tipomovimientoLogic.getTodosTipoMovimientos(finalQueryGlobalTipoMovimiento,new Pagination());
				tipomovimientosForeignKey=tipomovimientoLogic.getTipoMovimientos();
			}

			parametrocontabilidaddefectoReturnGeneral.settipomovimientosForeignKey(tipomovimientosForeignKey);


			List<TipoDocumento> tipodocumentosForeignKey=new ArrayList<TipoDocumento>();
			TipoDocumentoLogic tipodocumentoLogic=new TipoDocumentoLogic();
			tipodocumentoLogic.setConnexion(this.connexion);
			tipodocumentoLogic.getTipoDocumentoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoDocumento.equals("NONE")) {
				tipodocumentoLogic.getTodosTipoDocumentos(finalQueryGlobalTipoDocumento,new Pagination());
				tipodocumentosForeignKey=tipodocumentoLogic.getTipoDocumentos();
			}

			parametrocontabilidaddefectoReturnGeneral.settipodocumentosForeignKey(tipodocumentosForeignKey);


			List<EstadoAsientoContable> estadoasientocontablesForeignKey=new ArrayList<EstadoAsientoContable>();
			EstadoAsientoContableLogic estadoasientocontableLogic=new EstadoAsientoContableLogic();
			estadoasientocontableLogic.setConnexion(this.connexion);
			estadoasientocontableLogic.getEstadoAsientoContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEstadoAsientoContable.equals("NONE")) {
				estadoasientocontableLogic.getTodosEstadoAsientoContables(finalQueryGlobalEstadoAsientoContable,new Pagination());
				estadoasientocontablesForeignKey=estadoasientocontableLogic.getEstadoAsientoContables();
			}

			parametrocontabilidaddefectoReturnGeneral.setestadoasientocontablesForeignKey(estadoasientocontablesForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return parametrocontabilidaddefectoReturnGeneral;
	}
	
	
	public void deepLoad(ParametroContabilidadDefecto parametrocontabilidaddefecto,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			ParametroContabilidadDefectoLogicAdditional.updateParametroContabilidadDefectoToGet(parametrocontabilidaddefecto,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		parametrocontabilidaddefecto.setEmpresa(parametrocontabilidaddefectoDataAccess.getEmpresa(connexion,parametrocontabilidaddefecto));
		parametrocontabilidaddefecto.setSucursal(parametrocontabilidaddefectoDataAccess.getSucursal(connexion,parametrocontabilidaddefecto));
		parametrocontabilidaddefecto.setTipoMoneda(parametrocontabilidaddefectoDataAccess.getTipoMoneda(connexion,parametrocontabilidaddefecto));
		parametrocontabilidaddefecto.setMoneda(parametrocontabilidaddefectoDataAccess.getMoneda(connexion,parametrocontabilidaddefecto));
		parametrocontabilidaddefecto.setModulo(parametrocontabilidaddefectoDataAccess.getModulo(connexion,parametrocontabilidaddefecto));
		parametrocontabilidaddefecto.setTipoIntervalo(parametrocontabilidaddefectoDataAccess.getTipoIntervalo(connexion,parametrocontabilidaddefecto));
		parametrocontabilidaddefecto.setTipoMovimiento(parametrocontabilidaddefectoDataAccess.getTipoMovimiento(connexion,parametrocontabilidaddefecto));
		parametrocontabilidaddefecto.setTipoDocumento(parametrocontabilidaddefectoDataAccess.getTipoDocumento(connexion,parametrocontabilidaddefecto));
		parametrocontabilidaddefecto.setEstadoAsientoContable(parametrocontabilidaddefectoDataAccess.getEstadoAsientoContable(connexion,parametrocontabilidaddefecto));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				parametrocontabilidaddefecto.setEmpresa(parametrocontabilidaddefectoDataAccess.getEmpresa(connexion,parametrocontabilidaddefecto));
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				parametrocontabilidaddefecto.setSucursal(parametrocontabilidaddefectoDataAccess.getSucursal(connexion,parametrocontabilidaddefecto));
				continue;
			}

			if(clas.clas.equals(TipoMoneda.class)) {
				parametrocontabilidaddefecto.setTipoMoneda(parametrocontabilidaddefectoDataAccess.getTipoMoneda(connexion,parametrocontabilidaddefecto));
				continue;
			}

			if(clas.clas.equals(Moneda.class)) {
				parametrocontabilidaddefecto.setMoneda(parametrocontabilidaddefectoDataAccess.getMoneda(connexion,parametrocontabilidaddefecto));
				continue;
			}

			if(clas.clas.equals(Modulo.class)) {
				parametrocontabilidaddefecto.setModulo(parametrocontabilidaddefectoDataAccess.getModulo(connexion,parametrocontabilidaddefecto));
				continue;
			}

			if(clas.clas.equals(TipoIntervalo.class)) {
				parametrocontabilidaddefecto.setTipoIntervalo(parametrocontabilidaddefectoDataAccess.getTipoIntervalo(connexion,parametrocontabilidaddefecto));
				continue;
			}

			if(clas.clas.equals(TipoMovimiento.class)) {
				parametrocontabilidaddefecto.setTipoMovimiento(parametrocontabilidaddefectoDataAccess.getTipoMovimiento(connexion,parametrocontabilidaddefecto));
				continue;
			}

			if(clas.clas.equals(TipoDocumento.class)) {
				parametrocontabilidaddefecto.setTipoDocumento(parametrocontabilidaddefectoDataAccess.getTipoDocumento(connexion,parametrocontabilidaddefecto));
				continue;
			}

			if(clas.clas.equals(EstadoAsientoContable.class)) {
				parametrocontabilidaddefecto.setEstadoAsientoContable(parametrocontabilidaddefectoDataAccess.getEstadoAsientoContable(connexion,parametrocontabilidaddefecto));
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
			parametrocontabilidaddefecto.setEmpresa(parametrocontabilidaddefectoDataAccess.getEmpresa(connexion,parametrocontabilidaddefecto));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrocontabilidaddefecto.setSucursal(parametrocontabilidaddefectoDataAccess.getSucursal(connexion,parametrocontabilidaddefecto));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoMoneda.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrocontabilidaddefecto.setTipoMoneda(parametrocontabilidaddefectoDataAccess.getTipoMoneda(connexion,parametrocontabilidaddefecto));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Moneda.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrocontabilidaddefecto.setMoneda(parametrocontabilidaddefectoDataAccess.getMoneda(connexion,parametrocontabilidaddefecto));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Modulo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrocontabilidaddefecto.setModulo(parametrocontabilidaddefectoDataAccess.getModulo(connexion,parametrocontabilidaddefecto));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoIntervalo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrocontabilidaddefecto.setTipoIntervalo(parametrocontabilidaddefectoDataAccess.getTipoIntervalo(connexion,parametrocontabilidaddefecto));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoMovimiento.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrocontabilidaddefecto.setTipoMovimiento(parametrocontabilidaddefectoDataAccess.getTipoMovimiento(connexion,parametrocontabilidaddefecto));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoDocumento.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrocontabilidaddefecto.setTipoDocumento(parametrocontabilidaddefectoDataAccess.getTipoDocumento(connexion,parametrocontabilidaddefecto));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(EstadoAsientoContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrocontabilidaddefecto.setEstadoAsientoContable(parametrocontabilidaddefectoDataAccess.getEstadoAsientoContable(connexion,parametrocontabilidaddefecto));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		parametrocontabilidaddefecto.setEmpresa(parametrocontabilidaddefectoDataAccess.getEmpresa(connexion,parametrocontabilidaddefecto));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(parametrocontabilidaddefecto.getEmpresa(),isDeep,deepLoadType,clases);
				
		parametrocontabilidaddefecto.setSucursal(parametrocontabilidaddefectoDataAccess.getSucursal(connexion,parametrocontabilidaddefecto));
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(parametrocontabilidaddefecto.getSucursal(),isDeep,deepLoadType,clases);
				
		parametrocontabilidaddefecto.setTipoMoneda(parametrocontabilidaddefectoDataAccess.getTipoMoneda(connexion,parametrocontabilidaddefecto));
		TipoMonedaLogic tipomonedaLogic= new TipoMonedaLogic(connexion);
		tipomonedaLogic.deepLoad(parametrocontabilidaddefecto.getTipoMoneda(),isDeep,deepLoadType,clases);
				
		parametrocontabilidaddefecto.setMoneda(parametrocontabilidaddefectoDataAccess.getMoneda(connexion,parametrocontabilidaddefecto));
		MonedaLogic monedaLogic= new MonedaLogic(connexion);
		monedaLogic.deepLoad(parametrocontabilidaddefecto.getMoneda(),isDeep,deepLoadType,clases);
				
		parametrocontabilidaddefecto.setModulo(parametrocontabilidaddefectoDataAccess.getModulo(connexion,parametrocontabilidaddefecto));
		ModuloLogic moduloLogic= new ModuloLogic(connexion);
		moduloLogic.deepLoad(parametrocontabilidaddefecto.getModulo(),isDeep,deepLoadType,clases);
				
		parametrocontabilidaddefecto.setTipoIntervalo(parametrocontabilidaddefectoDataAccess.getTipoIntervalo(connexion,parametrocontabilidaddefecto));
		TipoIntervaloLogic tipointervaloLogic= new TipoIntervaloLogic(connexion);
		tipointervaloLogic.deepLoad(parametrocontabilidaddefecto.getTipoIntervalo(),isDeep,deepLoadType,clases);
				
		parametrocontabilidaddefecto.setTipoMovimiento(parametrocontabilidaddefectoDataAccess.getTipoMovimiento(connexion,parametrocontabilidaddefecto));
		TipoMovimientoLogic tipomovimientoLogic= new TipoMovimientoLogic(connexion);
		tipomovimientoLogic.deepLoad(parametrocontabilidaddefecto.getTipoMovimiento(),isDeep,deepLoadType,clases);
				
		parametrocontabilidaddefecto.setTipoDocumento(parametrocontabilidaddefectoDataAccess.getTipoDocumento(connexion,parametrocontabilidaddefecto));
		TipoDocumentoLogic tipodocumentoLogic= new TipoDocumentoLogic(connexion);
		tipodocumentoLogic.deepLoad(parametrocontabilidaddefecto.getTipoDocumento(),isDeep,deepLoadType,clases);
				
		parametrocontabilidaddefecto.setEstadoAsientoContable(parametrocontabilidaddefectoDataAccess.getEstadoAsientoContable(connexion,parametrocontabilidaddefecto));
		EstadoAsientoContableLogic estadoasientocontableLogic= new EstadoAsientoContableLogic(connexion);
		estadoasientocontableLogic.deepLoad(parametrocontabilidaddefecto.getEstadoAsientoContable(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				parametrocontabilidaddefecto.setEmpresa(parametrocontabilidaddefectoDataAccess.getEmpresa(connexion,parametrocontabilidaddefecto));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(parametrocontabilidaddefecto.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				parametrocontabilidaddefecto.setSucursal(parametrocontabilidaddefectoDataAccess.getSucursal(connexion,parametrocontabilidaddefecto));
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepLoad(parametrocontabilidaddefecto.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoMoneda.class)) {
				parametrocontabilidaddefecto.setTipoMoneda(parametrocontabilidaddefectoDataAccess.getTipoMoneda(connexion,parametrocontabilidaddefecto));
				TipoMonedaLogic tipomonedaLogic= new TipoMonedaLogic(connexion);
				tipomonedaLogic.deepLoad(parametrocontabilidaddefecto.getTipoMoneda(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Moneda.class)) {
				parametrocontabilidaddefecto.setMoneda(parametrocontabilidaddefectoDataAccess.getMoneda(connexion,parametrocontabilidaddefecto));
				MonedaLogic monedaLogic= new MonedaLogic(connexion);
				monedaLogic.deepLoad(parametrocontabilidaddefecto.getMoneda(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Modulo.class)) {
				parametrocontabilidaddefecto.setModulo(parametrocontabilidaddefectoDataAccess.getModulo(connexion,parametrocontabilidaddefecto));
				ModuloLogic moduloLogic= new ModuloLogic(connexion);
				moduloLogic.deepLoad(parametrocontabilidaddefecto.getModulo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoIntervalo.class)) {
				parametrocontabilidaddefecto.setTipoIntervalo(parametrocontabilidaddefectoDataAccess.getTipoIntervalo(connexion,parametrocontabilidaddefecto));
				TipoIntervaloLogic tipointervaloLogic= new TipoIntervaloLogic(connexion);
				tipointervaloLogic.deepLoad(parametrocontabilidaddefecto.getTipoIntervalo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoMovimiento.class)) {
				parametrocontabilidaddefecto.setTipoMovimiento(parametrocontabilidaddefectoDataAccess.getTipoMovimiento(connexion,parametrocontabilidaddefecto));
				TipoMovimientoLogic tipomovimientoLogic= new TipoMovimientoLogic(connexion);
				tipomovimientoLogic.deepLoad(parametrocontabilidaddefecto.getTipoMovimiento(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoDocumento.class)) {
				parametrocontabilidaddefecto.setTipoDocumento(parametrocontabilidaddefectoDataAccess.getTipoDocumento(connexion,parametrocontabilidaddefecto));
				TipoDocumentoLogic tipodocumentoLogic= new TipoDocumentoLogic(connexion);
				tipodocumentoLogic.deepLoad(parametrocontabilidaddefecto.getTipoDocumento(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(EstadoAsientoContable.class)) {
				parametrocontabilidaddefecto.setEstadoAsientoContable(parametrocontabilidaddefectoDataAccess.getEstadoAsientoContable(connexion,parametrocontabilidaddefecto));
				EstadoAsientoContableLogic estadoasientocontableLogic= new EstadoAsientoContableLogic(connexion);
				estadoasientocontableLogic.deepLoad(parametrocontabilidaddefecto.getEstadoAsientoContable(),isDeep,deepLoadType,clases);				
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
			parametrocontabilidaddefecto.setEmpresa(parametrocontabilidaddefectoDataAccess.getEmpresa(connexion,parametrocontabilidaddefecto));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(parametrocontabilidaddefecto.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrocontabilidaddefecto.setSucursal(parametrocontabilidaddefectoDataAccess.getSucursal(connexion,parametrocontabilidaddefecto));
			SucursalLogic sucursalLogic= new SucursalLogic(connexion);
			sucursalLogic.deepLoad(parametrocontabilidaddefecto.getSucursal(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoMoneda.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrocontabilidaddefecto.setTipoMoneda(parametrocontabilidaddefectoDataAccess.getTipoMoneda(connexion,parametrocontabilidaddefecto));
			TipoMonedaLogic tipomonedaLogic= new TipoMonedaLogic(connexion);
			tipomonedaLogic.deepLoad(parametrocontabilidaddefecto.getTipoMoneda(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Moneda.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrocontabilidaddefecto.setMoneda(parametrocontabilidaddefectoDataAccess.getMoneda(connexion,parametrocontabilidaddefecto));
			MonedaLogic monedaLogic= new MonedaLogic(connexion);
			monedaLogic.deepLoad(parametrocontabilidaddefecto.getMoneda(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Modulo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrocontabilidaddefecto.setModulo(parametrocontabilidaddefectoDataAccess.getModulo(connexion,parametrocontabilidaddefecto));
			ModuloLogic moduloLogic= new ModuloLogic(connexion);
			moduloLogic.deepLoad(parametrocontabilidaddefecto.getModulo(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoIntervalo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrocontabilidaddefecto.setTipoIntervalo(parametrocontabilidaddefectoDataAccess.getTipoIntervalo(connexion,parametrocontabilidaddefecto));
			TipoIntervaloLogic tipointervaloLogic= new TipoIntervaloLogic(connexion);
			tipointervaloLogic.deepLoad(parametrocontabilidaddefecto.getTipoIntervalo(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoMovimiento.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrocontabilidaddefecto.setTipoMovimiento(parametrocontabilidaddefectoDataAccess.getTipoMovimiento(connexion,parametrocontabilidaddefecto));
			TipoMovimientoLogic tipomovimientoLogic= new TipoMovimientoLogic(connexion);
			tipomovimientoLogic.deepLoad(parametrocontabilidaddefecto.getTipoMovimiento(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoDocumento.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrocontabilidaddefecto.setTipoDocumento(parametrocontabilidaddefectoDataAccess.getTipoDocumento(connexion,parametrocontabilidaddefecto));
			TipoDocumentoLogic tipodocumentoLogic= new TipoDocumentoLogic(connexion);
			tipodocumentoLogic.deepLoad(parametrocontabilidaddefecto.getTipoDocumento(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(EstadoAsientoContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrocontabilidaddefecto.setEstadoAsientoContable(parametrocontabilidaddefectoDataAccess.getEstadoAsientoContable(connexion,parametrocontabilidaddefecto));
			EstadoAsientoContableLogic estadoasientocontableLogic= new EstadoAsientoContableLogic(connexion);
			estadoasientocontableLogic.deepLoad(parametrocontabilidaddefecto.getEstadoAsientoContable(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(ParametroContabilidadDefecto parametrocontabilidaddefecto,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			ParametroContabilidadDefectoLogicAdditional.updateParametroContabilidadDefectoToSave(parametrocontabilidaddefecto,this.arrDatoGeneral);
			
ParametroContabilidadDefectoDataAccess.save(parametrocontabilidaddefecto, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(parametrocontabilidaddefecto.getEmpresa(),connexion);

		SucursalDataAccess.save(parametrocontabilidaddefecto.getSucursal(),connexion);

		TipoMonedaDataAccess.save(parametrocontabilidaddefecto.getTipoMoneda(),connexion);

		MonedaDataAccess.save(parametrocontabilidaddefecto.getMoneda(),connexion);

		ModuloDataAccess.save(parametrocontabilidaddefecto.getModulo(),connexion);

		TipoIntervaloDataAccess.save(parametrocontabilidaddefecto.getTipoIntervalo(),connexion);

		TipoMovimientoDataAccess.save(parametrocontabilidaddefecto.getTipoMovimiento(),connexion);

		TipoDocumentoDataAccess.save(parametrocontabilidaddefecto.getTipoDocumento(),connexion);

		EstadoAsientoContableDataAccess.save(parametrocontabilidaddefecto.getEstadoAsientoContable(),connexion);
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(parametrocontabilidaddefecto.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(parametrocontabilidaddefecto.getSucursal(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoMoneda.class)) {
				TipoMonedaDataAccess.save(parametrocontabilidaddefecto.getTipoMoneda(),connexion);
				continue;
			}

			if(clas.clas.equals(Moneda.class)) {
				MonedaDataAccess.save(parametrocontabilidaddefecto.getMoneda(),connexion);
				continue;
			}

			if(clas.clas.equals(Modulo.class)) {
				ModuloDataAccess.save(parametrocontabilidaddefecto.getModulo(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoIntervalo.class)) {
				TipoIntervaloDataAccess.save(parametrocontabilidaddefecto.getTipoIntervalo(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoMovimiento.class)) {
				TipoMovimientoDataAccess.save(parametrocontabilidaddefecto.getTipoMovimiento(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoDocumento.class)) {
				TipoDocumentoDataAccess.save(parametrocontabilidaddefecto.getTipoDocumento(),connexion);
				continue;
			}

			if(clas.clas.equals(EstadoAsientoContable.class)) {
				EstadoAsientoContableDataAccess.save(parametrocontabilidaddefecto.getEstadoAsientoContable(),connexion);
				continue;
			}

		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(parametrocontabilidaddefecto.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(parametrocontabilidaddefecto.getEmpresa(),isDeep,deepLoadType,clases);
				

		SucursalDataAccess.save(parametrocontabilidaddefecto.getSucursal(),connexion);
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(parametrocontabilidaddefecto.getSucursal(),isDeep,deepLoadType,clases);
				

		TipoMonedaDataAccess.save(parametrocontabilidaddefecto.getTipoMoneda(),connexion);
		TipoMonedaLogic tipomonedaLogic= new TipoMonedaLogic(connexion);
		tipomonedaLogic.deepLoad(parametrocontabilidaddefecto.getTipoMoneda(),isDeep,deepLoadType,clases);
				

		MonedaDataAccess.save(parametrocontabilidaddefecto.getMoneda(),connexion);
		MonedaLogic monedaLogic= new MonedaLogic(connexion);
		monedaLogic.deepLoad(parametrocontabilidaddefecto.getMoneda(),isDeep,deepLoadType,clases);
				

		ModuloDataAccess.save(parametrocontabilidaddefecto.getModulo(),connexion);
		ModuloLogic moduloLogic= new ModuloLogic(connexion);
		moduloLogic.deepLoad(parametrocontabilidaddefecto.getModulo(),isDeep,deepLoadType,clases);
				

		TipoIntervaloDataAccess.save(parametrocontabilidaddefecto.getTipoIntervalo(),connexion);
		TipoIntervaloLogic tipointervaloLogic= new TipoIntervaloLogic(connexion);
		tipointervaloLogic.deepLoad(parametrocontabilidaddefecto.getTipoIntervalo(),isDeep,deepLoadType,clases);
				

		TipoMovimientoDataAccess.save(parametrocontabilidaddefecto.getTipoMovimiento(),connexion);
		TipoMovimientoLogic tipomovimientoLogic= new TipoMovimientoLogic(connexion);
		tipomovimientoLogic.deepLoad(parametrocontabilidaddefecto.getTipoMovimiento(),isDeep,deepLoadType,clases);
				

		TipoDocumentoDataAccess.save(parametrocontabilidaddefecto.getTipoDocumento(),connexion);
		TipoDocumentoLogic tipodocumentoLogic= new TipoDocumentoLogic(connexion);
		tipodocumentoLogic.deepLoad(parametrocontabilidaddefecto.getTipoDocumento(),isDeep,deepLoadType,clases);
				

		EstadoAsientoContableDataAccess.save(parametrocontabilidaddefecto.getEstadoAsientoContable(),connexion);
		EstadoAsientoContableLogic estadoasientocontableLogic= new EstadoAsientoContableLogic(connexion);
		estadoasientocontableLogic.deepLoad(parametrocontabilidaddefecto.getEstadoAsientoContable(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(parametrocontabilidaddefecto.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(parametrocontabilidaddefecto.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(parametrocontabilidaddefecto.getSucursal(),connexion);
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepSave(parametrocontabilidaddefecto.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoMoneda.class)) {
				TipoMonedaDataAccess.save(parametrocontabilidaddefecto.getTipoMoneda(),connexion);
				TipoMonedaLogic tipomonedaLogic= new TipoMonedaLogic(connexion);
				tipomonedaLogic.deepSave(parametrocontabilidaddefecto.getTipoMoneda(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Moneda.class)) {
				MonedaDataAccess.save(parametrocontabilidaddefecto.getMoneda(),connexion);
				MonedaLogic monedaLogic= new MonedaLogic(connexion);
				monedaLogic.deepSave(parametrocontabilidaddefecto.getMoneda(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Modulo.class)) {
				ModuloDataAccess.save(parametrocontabilidaddefecto.getModulo(),connexion);
				ModuloLogic moduloLogic= new ModuloLogic(connexion);
				moduloLogic.deepSave(parametrocontabilidaddefecto.getModulo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoIntervalo.class)) {
				TipoIntervaloDataAccess.save(parametrocontabilidaddefecto.getTipoIntervalo(),connexion);
				TipoIntervaloLogic tipointervaloLogic= new TipoIntervaloLogic(connexion);
				tipointervaloLogic.deepSave(parametrocontabilidaddefecto.getTipoIntervalo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoMovimiento.class)) {
				TipoMovimientoDataAccess.save(parametrocontabilidaddefecto.getTipoMovimiento(),connexion);
				TipoMovimientoLogic tipomovimientoLogic= new TipoMovimientoLogic(connexion);
				tipomovimientoLogic.deepSave(parametrocontabilidaddefecto.getTipoMovimiento(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoDocumento.class)) {
				TipoDocumentoDataAccess.save(parametrocontabilidaddefecto.getTipoDocumento(),connexion);
				TipoDocumentoLogic tipodocumentoLogic= new TipoDocumentoLogic(connexion);
				tipodocumentoLogic.deepSave(parametrocontabilidaddefecto.getTipoDocumento(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(EstadoAsientoContable.class)) {
				EstadoAsientoContableDataAccess.save(parametrocontabilidaddefecto.getEstadoAsientoContable(),connexion);
				EstadoAsientoContableLogic estadoasientocontableLogic= new EstadoAsientoContableLogic(connexion);
				estadoasientocontableLogic.deepSave(parametrocontabilidaddefecto.getEstadoAsientoContable(),isDeep,deepLoadType,clases);				
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
			this.getNewConnexionToDeep(ParametroContabilidadDefecto.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(parametrocontabilidaddefecto,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				ParametroContabilidadDefectoConstantesFunciones.refrescarForeignKeysDescripcionesParametroContabilidadDefecto(parametrocontabilidaddefecto);
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
			this.deepLoad(this.parametrocontabilidaddefecto,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				ParametroContabilidadDefectoConstantesFunciones.refrescarForeignKeysDescripcionesParametroContabilidadDefecto(this.parametrocontabilidaddefecto);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(ParametroContabilidadDefecto.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(parametrocontabilidaddefectos!=null) {
				for(ParametroContabilidadDefecto parametrocontabilidaddefecto:parametrocontabilidaddefectos) {
					this.deepLoad(parametrocontabilidaddefecto,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					ParametroContabilidadDefectoConstantesFunciones.refrescarForeignKeysDescripcionesParametroContabilidadDefecto(parametrocontabilidaddefectos);
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
			if(parametrocontabilidaddefectos!=null) {
				for(ParametroContabilidadDefecto parametrocontabilidaddefecto:parametrocontabilidaddefectos) {
					this.deepLoad(parametrocontabilidaddefecto,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					ParametroContabilidadDefectoConstantesFunciones.refrescarForeignKeysDescripcionesParametroContabilidadDefecto(parametrocontabilidaddefectos);
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
			this.getNewConnexionToDeep(ParametroContabilidadDefecto.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(parametrocontabilidaddefecto,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(ParametroContabilidadDefecto.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(parametrocontabilidaddefectos!=null) {
				for(ParametroContabilidadDefecto parametrocontabilidaddefecto:parametrocontabilidaddefectos) {
					this.deepSave(parametrocontabilidaddefecto,isDeep,deepLoadType,clases);
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
			if(parametrocontabilidaddefectos!=null) {
				for(ParametroContabilidadDefecto parametrocontabilidaddefecto:parametrocontabilidaddefectos) {
					this.deepSave(parametrocontabilidaddefecto,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getParametroContabilidadDefectosFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroContabilidadDefecto.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,ParametroContabilidadDefectoConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			ParametroContabilidadDefectoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrocontabilidaddefectos=parametrocontabilidaddefectoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroContabilidadDefectoConstantesFunciones.refrescarForeignKeysDescripcionesParametroContabilidadDefecto(this.parametrocontabilidaddefectos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getParametroContabilidadDefectosFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,ParametroContabilidadDefectoConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			ParametroContabilidadDefectoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrocontabilidaddefectos=parametrocontabilidaddefectoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroContabilidadDefectoConstantesFunciones.refrescarForeignKeysDescripcionesParametroContabilidadDefecto(this.parametrocontabilidaddefectos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getParametroContabilidadDefectosFK_IdEstadoAsientoContableWithConnection(String sFinalQuery,Pagination pagination,Long id_estado_asiento_contable)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroContabilidadDefecto.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEstadoAsientoContable= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEstadoAsientoContable.setParameterSelectionGeneralEqual(ParameterType.LONG,id_estado_asiento_contable,ParametroContabilidadDefectoConstantesFunciones.IDESTADOASIENTOCONTABLE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEstadoAsientoContable);

			ParametroContabilidadDefectoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEstadoAsientoContable","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrocontabilidaddefectos=parametrocontabilidaddefectoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroContabilidadDefectoConstantesFunciones.refrescarForeignKeysDescripcionesParametroContabilidadDefecto(this.parametrocontabilidaddefectos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getParametroContabilidadDefectosFK_IdEstadoAsientoContable(String sFinalQuery,Pagination pagination,Long id_estado_asiento_contable)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEstadoAsientoContable= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEstadoAsientoContable.setParameterSelectionGeneralEqual(ParameterType.LONG,id_estado_asiento_contable,ParametroContabilidadDefectoConstantesFunciones.IDESTADOASIENTOCONTABLE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEstadoAsientoContable);

			ParametroContabilidadDefectoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEstadoAsientoContable","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrocontabilidaddefectos=parametrocontabilidaddefectoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroContabilidadDefectoConstantesFunciones.refrescarForeignKeysDescripcionesParametroContabilidadDefecto(this.parametrocontabilidaddefectos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getParametroContabilidadDefectosFK_IdModuloWithConnection(String sFinalQuery,Pagination pagination,Long id_modulo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroContabilidadDefecto.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidModulo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidModulo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_modulo,ParametroContabilidadDefectoConstantesFunciones.IDMODULO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidModulo);

			ParametroContabilidadDefectoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdModulo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrocontabilidaddefectos=parametrocontabilidaddefectoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroContabilidadDefectoConstantesFunciones.refrescarForeignKeysDescripcionesParametroContabilidadDefecto(this.parametrocontabilidaddefectos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getParametroContabilidadDefectosFK_IdModulo(String sFinalQuery,Pagination pagination,Long id_modulo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidModulo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidModulo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_modulo,ParametroContabilidadDefectoConstantesFunciones.IDMODULO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidModulo);

			ParametroContabilidadDefectoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdModulo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrocontabilidaddefectos=parametrocontabilidaddefectoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroContabilidadDefectoConstantesFunciones.refrescarForeignKeysDescripcionesParametroContabilidadDefecto(this.parametrocontabilidaddefectos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getParametroContabilidadDefectosFK_IdMonedaWithConnection(String sFinalQuery,Pagination pagination,Long id_moneda)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroContabilidadDefecto.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidMoneda= new ParameterSelectionGeneral();
			parameterSelectionGeneralidMoneda.setParameterSelectionGeneralEqual(ParameterType.LONG,id_moneda,ParametroContabilidadDefectoConstantesFunciones.IDMONEDA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidMoneda);

			ParametroContabilidadDefectoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdMoneda","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrocontabilidaddefectos=parametrocontabilidaddefectoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroContabilidadDefectoConstantesFunciones.refrescarForeignKeysDescripcionesParametroContabilidadDefecto(this.parametrocontabilidaddefectos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getParametroContabilidadDefectosFK_IdMoneda(String sFinalQuery,Pagination pagination,Long id_moneda)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidMoneda= new ParameterSelectionGeneral();
			parameterSelectionGeneralidMoneda.setParameterSelectionGeneralEqual(ParameterType.LONG,id_moneda,ParametroContabilidadDefectoConstantesFunciones.IDMONEDA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidMoneda);

			ParametroContabilidadDefectoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdMoneda","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrocontabilidaddefectos=parametrocontabilidaddefectoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroContabilidadDefectoConstantesFunciones.refrescarForeignKeysDescripcionesParametroContabilidadDefecto(this.parametrocontabilidaddefectos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getParametroContabilidadDefectosFK_IdSucursalWithConnection(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroContabilidadDefecto.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,ParametroContabilidadDefectoConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			ParametroContabilidadDefectoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrocontabilidaddefectos=parametrocontabilidaddefectoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroContabilidadDefectoConstantesFunciones.refrescarForeignKeysDescripcionesParametroContabilidadDefecto(this.parametrocontabilidaddefectos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getParametroContabilidadDefectosFK_IdSucursal(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,ParametroContabilidadDefectoConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			ParametroContabilidadDefectoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrocontabilidaddefectos=parametrocontabilidaddefectoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroContabilidadDefectoConstantesFunciones.refrescarForeignKeysDescripcionesParametroContabilidadDefecto(this.parametrocontabilidaddefectos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getParametroContabilidadDefectosFK_IdTipoDocumentoWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_documento)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroContabilidadDefecto.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoDocumento= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoDocumento.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_documento,ParametroContabilidadDefectoConstantesFunciones.IDTIPODOCUMENTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoDocumento);

			ParametroContabilidadDefectoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoDocumento","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrocontabilidaddefectos=parametrocontabilidaddefectoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroContabilidadDefectoConstantesFunciones.refrescarForeignKeysDescripcionesParametroContabilidadDefecto(this.parametrocontabilidaddefectos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getParametroContabilidadDefectosFK_IdTipoDocumento(String sFinalQuery,Pagination pagination,Long id_tipo_documento)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoDocumento= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoDocumento.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_documento,ParametroContabilidadDefectoConstantesFunciones.IDTIPODOCUMENTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoDocumento);

			ParametroContabilidadDefectoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoDocumento","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrocontabilidaddefectos=parametrocontabilidaddefectoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroContabilidadDefectoConstantesFunciones.refrescarForeignKeysDescripcionesParametroContabilidadDefecto(this.parametrocontabilidaddefectos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getParametroContabilidadDefectosFK_IdTipoIntervaloWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_intervalo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroContabilidadDefecto.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoIntervalo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoIntervalo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_intervalo,ParametroContabilidadDefectoConstantesFunciones.IDTIPOINTERVALO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoIntervalo);

			ParametroContabilidadDefectoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoIntervalo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrocontabilidaddefectos=parametrocontabilidaddefectoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroContabilidadDefectoConstantesFunciones.refrescarForeignKeysDescripcionesParametroContabilidadDefecto(this.parametrocontabilidaddefectos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getParametroContabilidadDefectosFK_IdTipoIntervalo(String sFinalQuery,Pagination pagination,Long id_tipo_intervalo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoIntervalo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoIntervalo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_intervalo,ParametroContabilidadDefectoConstantesFunciones.IDTIPOINTERVALO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoIntervalo);

			ParametroContabilidadDefectoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoIntervalo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrocontabilidaddefectos=parametrocontabilidaddefectoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroContabilidadDefectoConstantesFunciones.refrescarForeignKeysDescripcionesParametroContabilidadDefecto(this.parametrocontabilidaddefectos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getParametroContabilidadDefectosFK_IdTipoMonedaWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_moneda)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroContabilidadDefecto.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoMoneda= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoMoneda.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_moneda,ParametroContabilidadDefectoConstantesFunciones.IDTIPOMONEDA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoMoneda);

			ParametroContabilidadDefectoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoMoneda","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrocontabilidaddefectos=parametrocontabilidaddefectoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroContabilidadDefectoConstantesFunciones.refrescarForeignKeysDescripcionesParametroContabilidadDefecto(this.parametrocontabilidaddefectos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getParametroContabilidadDefectosFK_IdTipoMoneda(String sFinalQuery,Pagination pagination,Long id_tipo_moneda)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoMoneda= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoMoneda.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_moneda,ParametroContabilidadDefectoConstantesFunciones.IDTIPOMONEDA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoMoneda);

			ParametroContabilidadDefectoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoMoneda","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrocontabilidaddefectos=parametrocontabilidaddefectoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroContabilidadDefectoConstantesFunciones.refrescarForeignKeysDescripcionesParametroContabilidadDefecto(this.parametrocontabilidaddefectos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getParametroContabilidadDefectosFK_IdTipoMovimientoWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_movimiento)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroContabilidadDefecto.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoMovimiento= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoMovimiento.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_movimiento,ParametroContabilidadDefectoConstantesFunciones.IDTIPOMOVIMIENTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoMovimiento);

			ParametroContabilidadDefectoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoMovimiento","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrocontabilidaddefectos=parametrocontabilidaddefectoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroContabilidadDefectoConstantesFunciones.refrescarForeignKeysDescripcionesParametroContabilidadDefecto(this.parametrocontabilidaddefectos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getParametroContabilidadDefectosFK_IdTipoMovimiento(String sFinalQuery,Pagination pagination,Long id_tipo_movimiento)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoMovimiento= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoMovimiento.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_movimiento,ParametroContabilidadDefectoConstantesFunciones.IDTIPOMOVIMIENTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoMovimiento);

			ParametroContabilidadDefectoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoMovimiento","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrocontabilidaddefectos=parametrocontabilidaddefectoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroContabilidadDefectoConstantesFunciones.refrescarForeignKeysDescripcionesParametroContabilidadDefecto(this.parametrocontabilidaddefectos);
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
			if(ParametroContabilidadDefectoConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,ParametroContabilidadDefectoDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,ParametroContabilidadDefecto parametrocontabilidaddefecto,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(ParametroContabilidadDefectoConstantesFunciones.ISCONAUDITORIA) {
				if(parametrocontabilidaddefecto.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,ParametroContabilidadDefectoDataAccess.TABLENAME, parametrocontabilidaddefecto.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(ParametroContabilidadDefectoConstantesFunciones.ISCONAUDITORIADETALLE) {
						////ParametroContabilidadDefectoLogic.registrarAuditoriaDetallesParametroContabilidadDefecto(connexion,parametrocontabilidaddefecto,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(parametrocontabilidaddefecto.getIsDeleted()) {
					/*if(!parametrocontabilidaddefecto.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,ParametroContabilidadDefectoDataAccess.TABLENAME, parametrocontabilidaddefecto.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////ParametroContabilidadDefectoLogic.registrarAuditoriaDetallesParametroContabilidadDefecto(connexion,parametrocontabilidaddefecto,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,ParametroContabilidadDefectoDataAccess.TABLENAME, parametrocontabilidaddefecto.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(parametrocontabilidaddefecto.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,ParametroContabilidadDefectoDataAccess.TABLENAME, parametrocontabilidaddefecto.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(ParametroContabilidadDefectoConstantesFunciones.ISCONAUDITORIADETALLE) {
						////ParametroContabilidadDefectoLogic.registrarAuditoriaDetallesParametroContabilidadDefecto(connexion,parametrocontabilidaddefecto,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesParametroContabilidadDefecto(Connexion connexion,ParametroContabilidadDefecto parametrocontabilidaddefecto)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(parametrocontabilidaddefecto.getIsNew()||!parametrocontabilidaddefecto.getid_empresa().equals(parametrocontabilidaddefecto.getParametroContabilidadDefectoOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametrocontabilidaddefecto.getParametroContabilidadDefectoOriginal().getid_empresa()!=null)
				{
					strValorActual=parametrocontabilidaddefecto.getParametroContabilidadDefectoOriginal().getid_empresa().toString();
				}
				if(parametrocontabilidaddefecto.getid_empresa()!=null)
				{
					strValorNuevo=parametrocontabilidaddefecto.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroContabilidadDefectoConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(parametrocontabilidaddefecto.getIsNew()||!parametrocontabilidaddefecto.getid_sucursal().equals(parametrocontabilidaddefecto.getParametroContabilidadDefectoOriginal().getid_sucursal()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametrocontabilidaddefecto.getParametroContabilidadDefectoOriginal().getid_sucursal()!=null)
				{
					strValorActual=parametrocontabilidaddefecto.getParametroContabilidadDefectoOriginal().getid_sucursal().toString();
				}
				if(parametrocontabilidaddefecto.getid_sucursal()!=null)
				{
					strValorNuevo=parametrocontabilidaddefecto.getid_sucursal().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroContabilidadDefectoConstantesFunciones.IDSUCURSAL,strValorActual,strValorNuevo);
			}	
			
			if(parametrocontabilidaddefecto.getIsNew()||!parametrocontabilidaddefecto.getid_tipo_moneda().equals(parametrocontabilidaddefecto.getParametroContabilidadDefectoOriginal().getid_tipo_moneda()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametrocontabilidaddefecto.getParametroContabilidadDefectoOriginal().getid_tipo_moneda()!=null)
				{
					strValorActual=parametrocontabilidaddefecto.getParametroContabilidadDefectoOriginal().getid_tipo_moneda().toString();
				}
				if(parametrocontabilidaddefecto.getid_tipo_moneda()!=null)
				{
					strValorNuevo=parametrocontabilidaddefecto.getid_tipo_moneda().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroContabilidadDefectoConstantesFunciones.IDTIPOMONEDA,strValorActual,strValorNuevo);
			}	
			
			if(parametrocontabilidaddefecto.getIsNew()||!parametrocontabilidaddefecto.getid_moneda().equals(parametrocontabilidaddefecto.getParametroContabilidadDefectoOriginal().getid_moneda()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametrocontabilidaddefecto.getParametroContabilidadDefectoOriginal().getid_moneda()!=null)
				{
					strValorActual=parametrocontabilidaddefecto.getParametroContabilidadDefectoOriginal().getid_moneda().toString();
				}
				if(parametrocontabilidaddefecto.getid_moneda()!=null)
				{
					strValorNuevo=parametrocontabilidaddefecto.getid_moneda().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroContabilidadDefectoConstantesFunciones.IDMONEDA,strValorActual,strValorNuevo);
			}	
			
			if(parametrocontabilidaddefecto.getIsNew()||!parametrocontabilidaddefecto.getid_modulo().equals(parametrocontabilidaddefecto.getParametroContabilidadDefectoOriginal().getid_modulo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametrocontabilidaddefecto.getParametroContabilidadDefectoOriginal().getid_modulo()!=null)
				{
					strValorActual=parametrocontabilidaddefecto.getParametroContabilidadDefectoOriginal().getid_modulo().toString();
				}
				if(parametrocontabilidaddefecto.getid_modulo()!=null)
				{
					strValorNuevo=parametrocontabilidaddefecto.getid_modulo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroContabilidadDefectoConstantesFunciones.IDMODULO,strValorActual,strValorNuevo);
			}	
			
			if(parametrocontabilidaddefecto.getIsNew()||!parametrocontabilidaddefecto.getid_tipo_intervalo().equals(parametrocontabilidaddefecto.getParametroContabilidadDefectoOriginal().getid_tipo_intervalo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametrocontabilidaddefecto.getParametroContabilidadDefectoOriginal().getid_tipo_intervalo()!=null)
				{
					strValorActual=parametrocontabilidaddefecto.getParametroContabilidadDefectoOriginal().getid_tipo_intervalo().toString();
				}
				if(parametrocontabilidaddefecto.getid_tipo_intervalo()!=null)
				{
					strValorNuevo=parametrocontabilidaddefecto.getid_tipo_intervalo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroContabilidadDefectoConstantesFunciones.IDTIPOINTERVALO,strValorActual,strValorNuevo);
			}	
			
			if(parametrocontabilidaddefecto.getIsNew()||!parametrocontabilidaddefecto.getid_tipo_movimiento().equals(parametrocontabilidaddefecto.getParametroContabilidadDefectoOriginal().getid_tipo_movimiento()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametrocontabilidaddefecto.getParametroContabilidadDefectoOriginal().getid_tipo_movimiento()!=null)
				{
					strValorActual=parametrocontabilidaddefecto.getParametroContabilidadDefectoOriginal().getid_tipo_movimiento().toString();
				}
				if(parametrocontabilidaddefecto.getid_tipo_movimiento()!=null)
				{
					strValorNuevo=parametrocontabilidaddefecto.getid_tipo_movimiento().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroContabilidadDefectoConstantesFunciones.IDTIPOMOVIMIENTO,strValorActual,strValorNuevo);
			}	
			
			if(parametrocontabilidaddefecto.getIsNew()||!parametrocontabilidaddefecto.getid_tipo_documento().equals(parametrocontabilidaddefecto.getParametroContabilidadDefectoOriginal().getid_tipo_documento()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametrocontabilidaddefecto.getParametroContabilidadDefectoOriginal().getid_tipo_documento()!=null)
				{
					strValorActual=parametrocontabilidaddefecto.getParametroContabilidadDefectoOriginal().getid_tipo_documento().toString();
				}
				if(parametrocontabilidaddefecto.getid_tipo_documento()!=null)
				{
					strValorNuevo=parametrocontabilidaddefecto.getid_tipo_documento().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroContabilidadDefectoConstantesFunciones.IDTIPODOCUMENTO,strValorActual,strValorNuevo);
			}	
			
			if(parametrocontabilidaddefecto.getIsNew()||!parametrocontabilidaddefecto.getid_estado_asiento_contable().equals(parametrocontabilidaddefecto.getParametroContabilidadDefectoOriginal().getid_estado_asiento_contable()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametrocontabilidaddefecto.getParametroContabilidadDefectoOriginal().getid_estado_asiento_contable()!=null)
				{
					strValorActual=parametrocontabilidaddefecto.getParametroContabilidadDefectoOriginal().getid_estado_asiento_contable().toString();
				}
				if(parametrocontabilidaddefecto.getid_estado_asiento_contable()!=null)
				{
					strValorNuevo=parametrocontabilidaddefecto.getid_estado_asiento_contable().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroContabilidadDefectoConstantesFunciones.IDESTADOASIENTOCONTABLE,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveParametroContabilidadDefectoRelacionesWithConnection(ParametroContabilidadDefecto parametrocontabilidaddefecto) throws Exception {

		if(!parametrocontabilidaddefecto.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveParametroContabilidadDefectoRelacionesBase(parametrocontabilidaddefecto,true);
		}
	}

	public void saveParametroContabilidadDefectoRelaciones(ParametroContabilidadDefecto parametrocontabilidaddefecto)throws Exception {

		if(!parametrocontabilidaddefecto.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveParametroContabilidadDefectoRelacionesBase(parametrocontabilidaddefecto,false);
		}
	}

	public void saveParametroContabilidadDefectoRelacionesBase(ParametroContabilidadDefecto parametrocontabilidaddefecto,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("ParametroContabilidadDefecto-saveRelacionesWithConnection");}
	

			this.setParametroContabilidadDefecto(parametrocontabilidaddefecto);

			if(ParametroContabilidadDefectoLogicAdditional.validarSaveRelaciones(parametrocontabilidaddefecto,this)) {

				ParametroContabilidadDefectoLogicAdditional.updateRelacionesToSave(parametrocontabilidaddefecto,this);

				if((parametrocontabilidaddefecto.getIsNew()||parametrocontabilidaddefecto.getIsChanged())&&!parametrocontabilidaddefecto.getIsDeleted()) {
					this.saveParametroContabilidadDefecto();
					this.saveParametroContabilidadDefectoRelacionesDetalles();

				} else if(parametrocontabilidaddefecto.getIsDeleted()) {
					this.saveParametroContabilidadDefectoRelacionesDetalles();
					this.saveParametroContabilidadDefecto();
				}

				ParametroContabilidadDefectoLogicAdditional.updateRelacionesToSaveAfter(parametrocontabilidaddefecto,this);

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
	
	
	private void saveParametroContabilidadDefectoRelacionesDetalles()throws Exception {
		try {
	

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfParametroContabilidadDefecto(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=ParametroContabilidadDefectoConstantesFunciones.getClassesForeignKeysOfParametroContabilidadDefecto(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfParametroContabilidadDefecto(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=ParametroContabilidadDefectoConstantesFunciones.getClassesRelationshipsOfParametroContabilidadDefecto(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

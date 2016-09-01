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
package com.bydan.erp.inventario.business.logic;

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
import com.bydan.erp.inventario.util.*;
import com.bydan.erp.inventario.util.ParametroInventarioDefectoConstantesFunciones;
import com.bydan.erp.inventario.util.ParametroInventarioDefectoParameterReturnGeneral;
//import com.bydan.erp.inventario.util.ParametroInventarioDefectoParameterGeneral;
import com.bydan.erp.inventario.business.entity.ParametroInventarioDefecto;
import com.bydan.erp.inventario.business.logic.ParametroInventarioDefectoLogicAdditional;
import com.bydan.erp.inventario.business.dataaccess.*;
import com.bydan.erp.inventario.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;
import com.bydan.erp.facturacion.business.logic.*;
import com.bydan.erp.cartera.business.logic.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.facturacion.util.*;
import com.bydan.erp.cartera.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.facturacion.business.dataaccess.*;
import com.bydan.erp.cartera.business.dataaccess.*;








@SuppressWarnings("unused")
public class ParametroInventarioDefectoLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(ParametroInventarioDefectoLogic.class);
	
	protected ParametroInventarioDefectoDataAccess parametroinventariodefectoDataAccess; 	
	protected ParametroInventarioDefecto parametroinventariodefecto;
	protected List<ParametroInventarioDefecto> parametroinventariodefectos;
	protected Object parametroinventariodefectoObject;	
	protected List<Object> parametroinventariodefectosObject;
	
	public static ClassValidator<ParametroInventarioDefecto> parametroinventariodefectoValidator = new ClassValidator<ParametroInventarioDefecto>(ParametroInventarioDefecto.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected ParametroInventarioDefectoLogicAdditional parametroinventariodefectoLogicAdditional=null;
	
	public ParametroInventarioDefectoLogicAdditional getParametroInventarioDefectoLogicAdditional() {
		return this.parametroinventariodefectoLogicAdditional;
	}
	
	public void setParametroInventarioDefectoLogicAdditional(ParametroInventarioDefectoLogicAdditional parametroinventariodefectoLogicAdditional) {
		try {
			this.parametroinventariodefectoLogicAdditional=parametroinventariodefectoLogicAdditional;
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
	
	
	
	
	public  ParametroInventarioDefectoLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.parametroinventariodefectoDataAccess = new ParametroInventarioDefectoDataAccess();
			
			this.parametroinventariodefectos= new ArrayList<ParametroInventarioDefecto>();
			this.parametroinventariodefecto= new ParametroInventarioDefecto();
			
			this.parametroinventariodefectoObject=new Object();
			this.parametroinventariodefectosObject=new ArrayList<Object>();
				
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
			
			this.parametroinventariodefectoDataAccess.setConnexionType(this.connexionType);
			this.parametroinventariodefectoDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  ParametroInventarioDefectoLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.parametroinventariodefectoDataAccess = new ParametroInventarioDefectoDataAccess();
			this.parametroinventariodefectos= new ArrayList<ParametroInventarioDefecto>();
			this.parametroinventariodefecto= new ParametroInventarioDefecto();
			this.parametroinventariodefectoObject=new Object();
			this.parametroinventariodefectosObject=new ArrayList<Object>();
			
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
			
			this.parametroinventariodefectoDataAccess.setConnexionType(this.connexionType);
			this.parametroinventariodefectoDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public ParametroInventarioDefecto getParametroInventarioDefecto() throws Exception {	
		ParametroInventarioDefectoLogicAdditional.checkParametroInventarioDefectoToGet(parametroinventariodefecto,this.datosCliente,this.arrDatoGeneral);
		ParametroInventarioDefectoLogicAdditional.updateParametroInventarioDefectoToGet(parametroinventariodefecto,this.arrDatoGeneral);
		
		return parametroinventariodefecto;
	}
		
	public void setParametroInventarioDefecto(ParametroInventarioDefecto newParametroInventarioDefecto) {
		this.parametroinventariodefecto = newParametroInventarioDefecto;
	}
	
	public ParametroInventarioDefectoDataAccess getParametroInventarioDefectoDataAccess() {
		return parametroinventariodefectoDataAccess;
	}
	
	public void setParametroInventarioDefectoDataAccess(ParametroInventarioDefectoDataAccess newparametroinventariodefectoDataAccess) {
		this.parametroinventariodefectoDataAccess = newparametroinventariodefectoDataAccess;
	}
	
	public List<ParametroInventarioDefecto> getParametroInventarioDefectos() throws Exception {		
		this.quitarParametroInventarioDefectosNulos();
		
		ParametroInventarioDefectoLogicAdditional.checkParametroInventarioDefectoToGets(parametroinventariodefectos,this.datosCliente,this.arrDatoGeneral);
		
		for (ParametroInventarioDefecto parametroinventariodefectoLocal: parametroinventariodefectos ) {
			ParametroInventarioDefectoLogicAdditional.updateParametroInventarioDefectoToGet(parametroinventariodefectoLocal,this.arrDatoGeneral);
		}
		
		return parametroinventariodefectos;
	}
	
	public void setParametroInventarioDefectos(List<ParametroInventarioDefecto> newParametroInventarioDefectos) {
		this.parametroinventariodefectos = newParametroInventarioDefectos;
	}
	
	public Object getParametroInventarioDefectoObject() {	
		this.parametroinventariodefectoObject=this.parametroinventariodefectoDataAccess.getEntityObject();
		return this.parametroinventariodefectoObject;
	}
		
	public void setParametroInventarioDefectoObject(Object newParametroInventarioDefectoObject) {
		this.parametroinventariodefectoObject = newParametroInventarioDefectoObject;
	}
	
	public List<Object> getParametroInventarioDefectosObject() {		
		this.parametroinventariodefectosObject=this.parametroinventariodefectoDataAccess.getEntitiesObject();
		return this.parametroinventariodefectosObject;
	}
		
	public void setParametroInventarioDefectosObject(List<Object> newParametroInventarioDefectosObject) {
		this.parametroinventariodefectosObject = newParametroInventarioDefectosObject;
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
		
		if(this.parametroinventariodefectoDataAccess!=null) {
			this.parametroinventariodefectoDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroInventarioDefecto.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			parametroinventariodefectoDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			parametroinventariodefectoDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		parametroinventariodefecto = new  ParametroInventarioDefecto();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroInventarioDefecto.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			parametroinventariodefecto=parametroinventariodefectoDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.parametroinventariodefecto,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ParametroInventarioDefectoConstantesFunciones.refrescarForeignKeysDescripcionesParametroInventarioDefecto(this.parametroinventariodefecto);
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
		parametroinventariodefecto = new  ParametroInventarioDefecto();
		  		  
        try {
			
			parametroinventariodefecto=parametroinventariodefectoDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.parametroinventariodefecto,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ParametroInventarioDefectoConstantesFunciones.refrescarForeignKeysDescripcionesParametroInventarioDefecto(this.parametroinventariodefecto);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		parametroinventariodefecto = new  ParametroInventarioDefecto();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroInventarioDefecto.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			parametroinventariodefecto=parametroinventariodefectoDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.parametroinventariodefecto,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ParametroInventarioDefectoConstantesFunciones.refrescarForeignKeysDescripcionesParametroInventarioDefecto(this.parametroinventariodefecto);
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
		parametroinventariodefecto = new  ParametroInventarioDefecto();
		  		  
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
		parametroinventariodefecto = new  ParametroInventarioDefecto();
		  		  
        try {
			
			parametroinventariodefecto=parametroinventariodefectoDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.parametroinventariodefecto,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ParametroInventarioDefectoConstantesFunciones.refrescarForeignKeysDescripcionesParametroInventarioDefecto(this.parametroinventariodefecto);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		parametroinventariodefecto = new  ParametroInventarioDefecto();
		  		  
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
		parametroinventariodefecto = new  ParametroInventarioDefecto();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroInventarioDefecto.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =parametroinventariodefectoDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		parametroinventariodefecto = new  ParametroInventarioDefecto();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=parametroinventariodefectoDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		parametroinventariodefecto = new  ParametroInventarioDefecto();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroInventarioDefecto.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =parametroinventariodefectoDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		parametroinventariodefecto = new  ParametroInventarioDefecto();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=parametroinventariodefectoDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		parametroinventariodefecto = new  ParametroInventarioDefecto();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroInventarioDefecto.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =parametroinventariodefectoDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		parametroinventariodefecto = new  ParametroInventarioDefecto();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=parametroinventariodefectoDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		parametroinventariodefectos = new  ArrayList<ParametroInventarioDefecto>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroInventarioDefecto.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			ParametroInventarioDefectoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametroinventariodefectos=parametroinventariodefectoDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarParametroInventarioDefecto(parametroinventariodefectos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroInventarioDefectoConstantesFunciones.refrescarForeignKeysDescripcionesParametroInventarioDefecto(this.parametroinventariodefectos);
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
		parametroinventariodefectos = new  ArrayList<ParametroInventarioDefecto>();
		  		  
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
		parametroinventariodefectos = new  ArrayList<ParametroInventarioDefecto>();
		  		  
        try {			
			ParametroInventarioDefectoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametroinventariodefectos=parametroinventariodefectoDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarParametroInventarioDefecto(parametroinventariodefectos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroInventarioDefectoConstantesFunciones.refrescarForeignKeysDescripcionesParametroInventarioDefecto(this.parametroinventariodefectos);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		parametroinventariodefectos = new  ArrayList<ParametroInventarioDefecto>();
		  		  
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
		parametroinventariodefectos = new  ArrayList<ParametroInventarioDefecto>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroInventarioDefecto.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			ParametroInventarioDefectoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametroinventariodefectos=parametroinventariodefectoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarParametroInventarioDefecto(parametroinventariodefectos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroInventarioDefectoConstantesFunciones.refrescarForeignKeysDescripcionesParametroInventarioDefecto(this.parametroinventariodefectos);
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
		parametroinventariodefectos = new  ArrayList<ParametroInventarioDefecto>();
		  		  
        try {
			ParametroInventarioDefectoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametroinventariodefectos=parametroinventariodefectoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarParametroInventarioDefecto(parametroinventariodefectos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroInventarioDefectoConstantesFunciones.refrescarForeignKeysDescripcionesParametroInventarioDefecto(this.parametroinventariodefectos);
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
		parametroinventariodefectos = new  ArrayList<ParametroInventarioDefecto>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroInventarioDefecto.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ParametroInventarioDefectoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametroinventariodefectos=parametroinventariodefectoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarParametroInventarioDefecto(parametroinventariodefectos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroInventarioDefectoConstantesFunciones.refrescarForeignKeysDescripcionesParametroInventarioDefecto(this.parametroinventariodefectos);
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
		parametroinventariodefectos = new  ArrayList<ParametroInventarioDefecto>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ParametroInventarioDefectoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametroinventariodefectos=parametroinventariodefectoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarParametroInventarioDefecto(parametroinventariodefectos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroInventarioDefectoConstantesFunciones.refrescarForeignKeysDescripcionesParametroInventarioDefecto(this.parametroinventariodefectos);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		parametroinventariodefecto = new  ParametroInventarioDefecto();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroInventarioDefecto.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ParametroInventarioDefectoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametroinventariodefecto=parametroinventariodefectoDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarParametroInventarioDefecto(parametroinventariodefecto);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroInventarioDefectoConstantesFunciones.refrescarForeignKeysDescripcionesParametroInventarioDefecto(this.parametroinventariodefecto);
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
		parametroinventariodefecto = new  ParametroInventarioDefecto();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ParametroInventarioDefectoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametroinventariodefecto=parametroinventariodefectoDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarParametroInventarioDefecto(parametroinventariodefecto);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroInventarioDefectoConstantesFunciones.refrescarForeignKeysDescripcionesParametroInventarioDefecto(this.parametroinventariodefecto);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		parametroinventariodefectos = new  ArrayList<ParametroInventarioDefecto>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroInventarioDefecto.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			ParametroInventarioDefectoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametroinventariodefectos=parametroinventariodefectoDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarParametroInventarioDefecto(parametroinventariodefectos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroInventarioDefectoConstantesFunciones.refrescarForeignKeysDescripcionesParametroInventarioDefecto(this.parametroinventariodefectos);
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
		parametroinventariodefectos = new  ArrayList<ParametroInventarioDefecto>();
		  		  
        try {
			ParametroInventarioDefectoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametroinventariodefectos=parametroinventariodefectoDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarParametroInventarioDefecto(parametroinventariodefectos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroInventarioDefectoConstantesFunciones.refrescarForeignKeysDescripcionesParametroInventarioDefecto(this.parametroinventariodefectos);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosParametroInventarioDefectosWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		parametroinventariodefectos = new  ArrayList<ParametroInventarioDefecto>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroInventarioDefecto.class.getSimpleName()+"-getTodosParametroInventarioDefectosWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ParametroInventarioDefectoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametroinventariodefectos=parametroinventariodefectoDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarParametroInventarioDefecto(parametroinventariodefectos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroInventarioDefectoConstantesFunciones.refrescarForeignKeysDescripcionesParametroInventarioDefecto(this.parametroinventariodefectos);
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
	
	public  void  getTodosParametroInventarioDefectos(String sFinalQuery,Pagination pagination)throws Exception {
		parametroinventariodefectos = new  ArrayList<ParametroInventarioDefecto>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ParametroInventarioDefectoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametroinventariodefectos=parametroinventariodefectoDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarParametroInventarioDefecto(parametroinventariodefectos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroInventarioDefectoConstantesFunciones.refrescarForeignKeysDescripcionesParametroInventarioDefecto(this.parametroinventariodefectos);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarParametroInventarioDefecto(ParametroInventarioDefecto parametroinventariodefecto) throws Exception {
		Boolean estaValidado=false;
		
		if(parametroinventariodefecto.getIsNew() || parametroinventariodefecto.getIsChanged()) { 
			this.invalidValues = parametroinventariodefectoValidator.getInvalidValues(parametroinventariodefecto);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(parametroinventariodefecto);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarParametroInventarioDefecto(List<ParametroInventarioDefecto> ParametroInventarioDefectos) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(ParametroInventarioDefecto parametroinventariodefectoLocal:parametroinventariodefectos) {				
			estaValidadoObjeto=this.validarGuardarParametroInventarioDefecto(parametroinventariodefectoLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarParametroInventarioDefecto(List<ParametroInventarioDefecto> ParametroInventarioDefectos) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarParametroInventarioDefecto(parametroinventariodefectos)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarParametroInventarioDefecto(ParametroInventarioDefecto ParametroInventarioDefecto) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarParametroInventarioDefecto(parametroinventariodefecto)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(ParametroInventarioDefecto parametroinventariodefecto) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+parametroinventariodefecto.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=ParametroInventarioDefectoConstantesFunciones.getParametroInventarioDefectoLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"parametroinventariodefecto","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(ParametroInventarioDefectoConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(ParametroInventarioDefectoConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveParametroInventarioDefectoWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroInventarioDefecto.class.getSimpleName()+"-saveParametroInventarioDefectoWithConnection");connexion.begin();			
			
			ParametroInventarioDefectoLogicAdditional.checkParametroInventarioDefectoToSave(this.parametroinventariodefecto,this.datosCliente,connexion,this.arrDatoGeneral);
			
			ParametroInventarioDefectoLogicAdditional.updateParametroInventarioDefectoToSave(this.parametroinventariodefecto,this.arrDatoGeneral);
			
			ParametroInventarioDefectoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.parametroinventariodefecto,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowParametroInventarioDefecto();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarParametroInventarioDefecto(this.parametroinventariodefecto)) {
				ParametroInventarioDefectoDataAccess.save(this.parametroinventariodefecto, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.parametroinventariodefecto,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			ParametroInventarioDefectoLogicAdditional.checkParametroInventarioDefectoToSaveAfter(this.parametroinventariodefecto,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowParametroInventarioDefecto();
			
			connexion.commit();			
			
			if(this.parametroinventariodefecto.getIsDeleted()) {
				this.parametroinventariodefecto=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveParametroInventarioDefecto()throws Exception {	
		try {	
			
			ParametroInventarioDefectoLogicAdditional.checkParametroInventarioDefectoToSave(this.parametroinventariodefecto,this.datosCliente,connexion,this.arrDatoGeneral);
			
			ParametroInventarioDefectoLogicAdditional.updateParametroInventarioDefectoToSave(this.parametroinventariodefecto,this.arrDatoGeneral);
			
			ParametroInventarioDefectoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.parametroinventariodefecto,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarParametroInventarioDefecto(this.parametroinventariodefecto)) {			
				ParametroInventarioDefectoDataAccess.save(this.parametroinventariodefecto, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.parametroinventariodefecto,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			ParametroInventarioDefectoLogicAdditional.checkParametroInventarioDefectoToSaveAfter(this.parametroinventariodefecto,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.parametroinventariodefecto.getIsDeleted()) {
				this.parametroinventariodefecto=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveParametroInventarioDefectosWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroInventarioDefecto.class.getSimpleName()+"-saveParametroInventarioDefectosWithConnection");connexion.begin();			
			
			ParametroInventarioDefectoLogicAdditional.checkParametroInventarioDefectoToSaves(parametroinventariodefectos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowParametroInventarioDefectos();
			
			Boolean validadoTodosParametroInventarioDefecto=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(ParametroInventarioDefecto parametroinventariodefectoLocal:parametroinventariodefectos) {		
				if(parametroinventariodefectoLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				ParametroInventarioDefectoLogicAdditional.updateParametroInventarioDefectoToSave(parametroinventariodefectoLocal,this.arrDatoGeneral);
	        	
				ParametroInventarioDefectoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),parametroinventariodefectoLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarParametroInventarioDefecto(parametroinventariodefectoLocal)) {
					ParametroInventarioDefectoDataAccess.save(parametroinventariodefectoLocal, connexion);				
				} else {
					validadoTodosParametroInventarioDefecto=false;
				}
			}
			
			if(!validadoTodosParametroInventarioDefecto) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			ParametroInventarioDefectoLogicAdditional.checkParametroInventarioDefectoToSavesAfter(parametroinventariodefectos,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowParametroInventarioDefectos();
			
			connexion.commit();		
			
			this.quitarParametroInventarioDefectosEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveParametroInventarioDefectos()throws Exception {				
		 try {	
			ParametroInventarioDefectoLogicAdditional.checkParametroInventarioDefectoToSaves(parametroinventariodefectos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosParametroInventarioDefecto=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(ParametroInventarioDefecto parametroinventariodefectoLocal:parametroinventariodefectos) {				
				if(parametroinventariodefectoLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				ParametroInventarioDefectoLogicAdditional.updateParametroInventarioDefectoToSave(parametroinventariodefectoLocal,this.arrDatoGeneral);
	        	
				ParametroInventarioDefectoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),parametroinventariodefectoLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarParametroInventarioDefecto(parametroinventariodefectoLocal)) {				
					ParametroInventarioDefectoDataAccess.save(parametroinventariodefectoLocal, connexion);				
				} else {
					validadoTodosParametroInventarioDefecto=false;
				}
			}
			
			if(!validadoTodosParametroInventarioDefecto) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			ParametroInventarioDefectoLogicAdditional.checkParametroInventarioDefectoToSavesAfter(parametroinventariodefectos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarParametroInventarioDefectosEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public ParametroInventarioDefectoParameterReturnGeneral procesarAccionParametroInventarioDefectos(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<ParametroInventarioDefecto> parametroinventariodefectos,ParametroInventarioDefectoParameterReturnGeneral parametroinventariodefectoParameterGeneral)throws Exception {
		 try {	
			ParametroInventarioDefectoParameterReturnGeneral parametroinventariodefectoReturnGeneral=new ParametroInventarioDefectoParameterReturnGeneral();
	
			ParametroInventarioDefectoLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,parametroinventariodefectos,parametroinventariodefectoParameterGeneral,parametroinventariodefectoReturnGeneral);
			
			return parametroinventariodefectoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public ParametroInventarioDefectoParameterReturnGeneral procesarAccionParametroInventarioDefectosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<ParametroInventarioDefecto> parametroinventariodefectos,ParametroInventarioDefectoParameterReturnGeneral parametroinventariodefectoParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroInventarioDefecto.class.getSimpleName()+"-procesarAccionParametroInventarioDefectosWithConnection");connexion.begin();			
			
			ParametroInventarioDefectoParameterReturnGeneral parametroinventariodefectoReturnGeneral=new ParametroInventarioDefectoParameterReturnGeneral();
	
			ParametroInventarioDefectoLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,parametroinventariodefectos,parametroinventariodefectoParameterGeneral,parametroinventariodefectoReturnGeneral);
			
			this.connexion.commit();
			
			return parametroinventariodefectoReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public ParametroInventarioDefectoParameterReturnGeneral procesarEventosParametroInventarioDefectos(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<ParametroInventarioDefecto> parametroinventariodefectos,ParametroInventarioDefecto parametroinventariodefecto,ParametroInventarioDefectoParameterReturnGeneral parametroinventariodefectoParameterGeneral,Boolean isEsNuevoParametroInventarioDefecto,ArrayList<Classe> clases)throws Exception {
		 try {	
			ParametroInventarioDefectoParameterReturnGeneral parametroinventariodefectoReturnGeneral=new ParametroInventarioDefectoParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				parametroinventariodefectoReturnGeneral.setConRecargarPropiedades(true);
			}
			
			ParametroInventarioDefectoLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,parametroinventariodefectos,parametroinventariodefecto,parametroinventariodefectoParameterGeneral,parametroinventariodefectoReturnGeneral,isEsNuevoParametroInventarioDefecto,clases);
			
			return parametroinventariodefectoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public ParametroInventarioDefectoParameterReturnGeneral procesarEventosParametroInventarioDefectosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<ParametroInventarioDefecto> parametroinventariodefectos,ParametroInventarioDefecto parametroinventariodefecto,ParametroInventarioDefectoParameterReturnGeneral parametroinventariodefectoParameterGeneral,Boolean isEsNuevoParametroInventarioDefecto,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroInventarioDefecto.class.getSimpleName()+"-procesarEventosParametroInventarioDefectosWithConnection");connexion.begin();			
			
			ParametroInventarioDefectoParameterReturnGeneral parametroinventariodefectoReturnGeneral=new ParametroInventarioDefectoParameterReturnGeneral();
	
			parametroinventariodefectoReturnGeneral.setParametroInventarioDefecto(parametroinventariodefecto);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				parametroinventariodefectoReturnGeneral.setConRecargarPropiedades(true);
			}
			
			ParametroInventarioDefectoLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,parametroinventariodefectos,parametroinventariodefecto,parametroinventariodefectoParameterGeneral,parametroinventariodefectoReturnGeneral,isEsNuevoParametroInventarioDefecto,clases);
			
			this.connexion.commit();
			
			return parametroinventariodefectoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public ParametroInventarioDefectoParameterReturnGeneral procesarImportacionParametroInventarioDefectosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,ParametroInventarioDefectoParameterReturnGeneral parametroinventariodefectoParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroInventarioDefecto.class.getSimpleName()+"-procesarImportacionParametroInventarioDefectosWithConnection");connexion.begin();			
			
			ParametroInventarioDefectoParameterReturnGeneral parametroinventariodefectoReturnGeneral=new ParametroInventarioDefectoParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.parametroinventariodefectos=new ArrayList<ParametroInventarioDefecto>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.parametroinventariodefecto=new ParametroInventarioDefecto();
				
				
				if(conColumnasBase) {this.parametroinventariodefecto.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.parametroinventariodefecto.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				
				this.parametroinventariodefectos.add(this.parametroinventariodefecto);
			}
			
			this.saveParametroInventarioDefectos();
			
			this.connexion.commit();
			
			parametroinventariodefectoReturnGeneral.setConRetornoEstaProcesado(true);
			parametroinventariodefectoReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return parametroinventariodefectoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarParametroInventarioDefectosEliminados() throws Exception {				
		
		List<ParametroInventarioDefecto> parametroinventariodefectosAux= new ArrayList<ParametroInventarioDefecto>();
		
		for(ParametroInventarioDefecto parametroinventariodefecto:parametroinventariodefectos) {
			if(!parametroinventariodefecto.getIsDeleted()) {
				parametroinventariodefectosAux.add(parametroinventariodefecto);
			}
		}
		
		parametroinventariodefectos=parametroinventariodefectosAux;
	}
	
	public void quitarParametroInventarioDefectosNulos() throws Exception {				
		
		List<ParametroInventarioDefecto> parametroinventariodefectosAux= new ArrayList<ParametroInventarioDefecto>();
		
		for(ParametroInventarioDefecto parametroinventariodefecto : this.parametroinventariodefectos) {
			if(parametroinventariodefecto==null) {
				parametroinventariodefectosAux.add(parametroinventariodefecto);
			}
		}
		
		//this.parametroinventariodefectos=parametroinventariodefectosAux;
		
		this.parametroinventariodefectos.removeAll(parametroinventariodefectosAux);
	}
	
	public void getSetVersionRowParametroInventarioDefectoWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(parametroinventariodefecto.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((parametroinventariodefecto.getIsDeleted() || (parametroinventariodefecto.getIsChanged()&&!parametroinventariodefecto.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=parametroinventariodefectoDataAccess.getSetVersionRowParametroInventarioDefecto(connexion,parametroinventariodefecto.getId());
				
				if(!parametroinventariodefecto.getVersionRow().equals(timestamp)) {	
					parametroinventariodefecto.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				parametroinventariodefecto.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowParametroInventarioDefecto()throws Exception {	
		
		if(parametroinventariodefecto.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((parametroinventariodefecto.getIsDeleted() || (parametroinventariodefecto.getIsChanged()&&!parametroinventariodefecto.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=parametroinventariodefectoDataAccess.getSetVersionRowParametroInventarioDefecto(connexion,parametroinventariodefecto.getId());
			
			try {							
				if(!parametroinventariodefecto.getVersionRow().equals(timestamp)) {	
					parametroinventariodefecto.setVersionRow(timestamp);
				}
				
				parametroinventariodefecto.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowParametroInventarioDefectosWithConnection()throws Exception {	
		if(parametroinventariodefectos!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(ParametroInventarioDefecto parametroinventariodefectoAux:parametroinventariodefectos) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(parametroinventariodefectoAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(parametroinventariodefectoAux.getIsDeleted() || (parametroinventariodefectoAux.getIsChanged()&&!parametroinventariodefectoAux.getIsNew())) {
						
						timestamp=parametroinventariodefectoDataAccess.getSetVersionRowParametroInventarioDefecto(connexion,parametroinventariodefectoAux.getId());
						
						if(!parametroinventariodefecto.getVersionRow().equals(timestamp)) {	
							parametroinventariodefectoAux.setVersionRow(timestamp);
						}
								
						parametroinventariodefectoAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowParametroInventarioDefectos()throws Exception {	
		if(parametroinventariodefectos!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(ParametroInventarioDefecto parametroinventariodefectoAux:parametroinventariodefectos) {
					if(parametroinventariodefectoAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(parametroinventariodefectoAux.getIsDeleted() || (parametroinventariodefectoAux.getIsChanged()&&!parametroinventariodefectoAux.getIsNew())) {
						
						timestamp=parametroinventariodefectoDataAccess.getSetVersionRowParametroInventarioDefecto(connexion,parametroinventariodefectoAux.getId());
						
						if(!parametroinventariodefectoAux.getVersionRow().equals(timestamp)) {	
							parametroinventariodefectoAux.setVersionRow(timestamp);
						}
						
													
						parametroinventariodefectoAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public ParametroInventarioDefectoParameterReturnGeneral cargarCombosLoteForeignKeyParametroInventarioDefectoWithConnection(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalGrupoBodega,String finalQueryGlobalCalidadProducto,String finalQueryGlobalTipoServicio,String finalQueryGlobalTipoProductoServicioInven,String finalQueryGlobalTipoProductoServicio,String finalQueryGlobalTipoCosteo,String finalQueryGlobalTipoProducto,String finalQueryGlobalTipoViaTransporte,String finalQueryGlobalRangoUnidadVenta,String finalQueryGlobalPais,String finalQueryGlobalCiudad,String finalQueryGlobalColorProducto,String finalQueryGlobalClaseProducto,String finalQueryGlobalEfectoProducto,String finalQueryGlobalMarcaProducto,String finalQueryGlobalModeloProducto,String finalQueryGlobalMaterialProducto,String finalQueryGlobalSegmentoProducto,String finalQueryGlobalTallaProducto) throws Exception {
		ParametroInventarioDefectoParameterReturnGeneral  parametroinventariodefectoReturnGeneral =new ParametroInventarioDefectoParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroInventarioDefecto.class.getSimpleName()+"-cargarCombosLoteForeignKeyParametroInventarioDefectoWithConnection");connexion.begin();
			
			parametroinventariodefectoReturnGeneral =new ParametroInventarioDefectoParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			parametroinventariodefectoReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			parametroinventariodefectoReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<GrupoBodega> grupobodegasForeignKey=new ArrayList<GrupoBodega>();
			GrupoBodegaLogic grupobodegaLogic=new GrupoBodegaLogic();
			grupobodegaLogic.setConnexion(this.connexion);
			grupobodegaLogic.getGrupoBodegaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalGrupoBodega.equals("NONE")) {
				grupobodegaLogic.getTodosGrupoBodegas(finalQueryGlobalGrupoBodega,new Pagination());
				grupobodegasForeignKey=grupobodegaLogic.getGrupoBodegas();
			}

			parametroinventariodefectoReturnGeneral.setgrupobodegasForeignKey(grupobodegasForeignKey);


			List<CalidadProducto> calidadproductosForeignKey=new ArrayList<CalidadProducto>();
			CalidadProductoLogic calidadproductoLogic=new CalidadProductoLogic();
			calidadproductoLogic.setConnexion(this.connexion);
			calidadproductoLogic.getCalidadProductoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCalidadProducto.equals("NONE")) {
				calidadproductoLogic.getTodosCalidadProductos(finalQueryGlobalCalidadProducto,new Pagination());
				calidadproductosForeignKey=calidadproductoLogic.getCalidadProductos();
			}

			parametroinventariodefectoReturnGeneral.setcalidadproductosForeignKey(calidadproductosForeignKey);


			List<TipoServicio> tiposerviciosForeignKey=new ArrayList<TipoServicio>();
			TipoServicioLogic tiposervicioLogic=new TipoServicioLogic();
			tiposervicioLogic.setConnexion(this.connexion);
			tiposervicioLogic.getTipoServicioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoServicio.equals("NONE")) {
				tiposervicioLogic.getTodosTipoServicios(finalQueryGlobalTipoServicio,new Pagination());
				tiposerviciosForeignKey=tiposervicioLogic.getTipoServicios();
			}

			parametroinventariodefectoReturnGeneral.settiposerviciosForeignKey(tiposerviciosForeignKey);


			List<TipoProductoServicioInven> tipoproductoservicioinvensForeignKey=new ArrayList<TipoProductoServicioInven>();
			TipoProductoServicioInvenLogic tipoproductoservicioinvenLogic=new TipoProductoServicioInvenLogic();
			tipoproductoservicioinvenLogic.setConnexion(this.connexion);
			tipoproductoservicioinvenLogic.getTipoProductoServicioInvenDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoProductoServicioInven.equals("NONE")) {
				tipoproductoservicioinvenLogic.getTodosTipoProductoServicioInvens(finalQueryGlobalTipoProductoServicioInven,new Pagination());
				tipoproductoservicioinvensForeignKey=tipoproductoservicioinvenLogic.getTipoProductoServicioInvens();
			}

			parametroinventariodefectoReturnGeneral.settipoproductoservicioinvensForeignKey(tipoproductoservicioinvensForeignKey);


			List<TipoProductoServicio> tipoproductoserviciosForeignKey=new ArrayList<TipoProductoServicio>();
			TipoProductoServicioLogic tipoproductoservicioLogic=new TipoProductoServicioLogic();
			tipoproductoservicioLogic.setConnexion(this.connexion);
			tipoproductoservicioLogic.getTipoProductoServicioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoProductoServicio.equals("NONE")) {
				tipoproductoservicioLogic.getTodosTipoProductoServicios(finalQueryGlobalTipoProductoServicio,new Pagination());
				tipoproductoserviciosForeignKey=tipoproductoservicioLogic.getTipoProductoServicios();
			}

			parametroinventariodefectoReturnGeneral.settipoproductoserviciosForeignKey(tipoproductoserviciosForeignKey);


			List<TipoCosteo> tipocosteosForeignKey=new ArrayList<TipoCosteo>();
			TipoCosteoLogic tipocosteoLogic=new TipoCosteoLogic();
			tipocosteoLogic.setConnexion(this.connexion);
			tipocosteoLogic.getTipoCosteoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoCosteo.equals("NONE")) {
				tipocosteoLogic.getTodosTipoCosteos(finalQueryGlobalTipoCosteo,new Pagination());
				tipocosteosForeignKey=tipocosteoLogic.getTipoCosteos();
			}

			parametroinventariodefectoReturnGeneral.settipocosteosForeignKey(tipocosteosForeignKey);


			List<TipoProducto> tipoproductosForeignKey=new ArrayList<TipoProducto>();
			TipoProductoLogic tipoproductoLogic=new TipoProductoLogic();
			tipoproductoLogic.setConnexion(this.connexion);
			tipoproductoLogic.getTipoProductoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoProducto.equals("NONE")) {
				tipoproductoLogic.getTodosTipoProductos(finalQueryGlobalTipoProducto,new Pagination());
				tipoproductosForeignKey=tipoproductoLogic.getTipoProductos();
			}

			parametroinventariodefectoReturnGeneral.settipoproductosForeignKey(tipoproductosForeignKey);


			List<TipoViaTransporte> tipoviatransportesForeignKey=new ArrayList<TipoViaTransporte>();
			TipoViaTransporteLogic tipoviatransporteLogic=new TipoViaTransporteLogic();
			tipoviatransporteLogic.setConnexion(this.connexion);
			tipoviatransporteLogic.getTipoViaTransporteDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoViaTransporte.equals("NONE")) {
				tipoviatransporteLogic.getTodosTipoViaTransportes(finalQueryGlobalTipoViaTransporte,new Pagination());
				tipoviatransportesForeignKey=tipoviatransporteLogic.getTipoViaTransportes();
			}

			parametroinventariodefectoReturnGeneral.settipoviatransportesForeignKey(tipoviatransportesForeignKey);


			List<RangoUnidadVenta> rangounidadventasForeignKey=new ArrayList<RangoUnidadVenta>();
			RangoUnidadVentaLogic rangounidadventaLogic=new RangoUnidadVentaLogic();
			rangounidadventaLogic.setConnexion(this.connexion);
			rangounidadventaLogic.getRangoUnidadVentaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalRangoUnidadVenta.equals("NONE")) {
				rangounidadventaLogic.getTodosRangoUnidadVentas(finalQueryGlobalRangoUnidadVenta,new Pagination());
				rangounidadventasForeignKey=rangounidadventaLogic.getRangoUnidadVentas();
			}

			parametroinventariodefectoReturnGeneral.setrangounidadventasForeignKey(rangounidadventasForeignKey);


			List<Pais> paissForeignKey=new ArrayList<Pais>();
			PaisLogic paisLogic=new PaisLogic();
			paisLogic.setConnexion(this.connexion);
			paisLogic.getPaisDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPais.equals("NONE")) {
				paisLogic.getTodosPaiss(finalQueryGlobalPais,new Pagination());
				paissForeignKey=paisLogic.getPaiss();
			}

			parametroinventariodefectoReturnGeneral.setpaissForeignKey(paissForeignKey);


			List<Ciudad> ciudadsForeignKey=new ArrayList<Ciudad>();
			CiudadLogic ciudadLogic=new CiudadLogic();
			ciudadLogic.setConnexion(this.connexion);
			ciudadLogic.getCiudadDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCiudad.equals("NONE")) {
				ciudadLogic.getTodosCiudads(finalQueryGlobalCiudad,new Pagination());
				ciudadsForeignKey=ciudadLogic.getCiudads();
			}

			parametroinventariodefectoReturnGeneral.setciudadsForeignKey(ciudadsForeignKey);


			List<ColorProducto> colorproductosForeignKey=new ArrayList<ColorProducto>();
			ColorProductoLogic colorproductoLogic=new ColorProductoLogic();
			colorproductoLogic.setConnexion(this.connexion);
			colorproductoLogic.getColorProductoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalColorProducto.equals("NONE")) {
				colorproductoLogic.getTodosColorProductos(finalQueryGlobalColorProducto,new Pagination());
				colorproductosForeignKey=colorproductoLogic.getColorProductos();
			}

			parametroinventariodefectoReturnGeneral.setcolorproductosForeignKey(colorproductosForeignKey);


			List<ClaseProducto> claseproductosForeignKey=new ArrayList<ClaseProducto>();
			ClaseProductoLogic claseproductoLogic=new ClaseProductoLogic();
			claseproductoLogic.setConnexion(this.connexion);
			claseproductoLogic.getClaseProductoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalClaseProducto.equals("NONE")) {
				claseproductoLogic.getTodosClaseProductos(finalQueryGlobalClaseProducto,new Pagination());
				claseproductosForeignKey=claseproductoLogic.getClaseProductos();
			}

			parametroinventariodefectoReturnGeneral.setclaseproductosForeignKey(claseproductosForeignKey);


			List<EfectoProducto> efectoproductosForeignKey=new ArrayList<EfectoProducto>();
			EfectoProductoLogic efectoproductoLogic=new EfectoProductoLogic();
			efectoproductoLogic.setConnexion(this.connexion);
			efectoproductoLogic.getEfectoProductoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEfectoProducto.equals("NONE")) {
				efectoproductoLogic.getTodosEfectoProductos(finalQueryGlobalEfectoProducto,new Pagination());
				efectoproductosForeignKey=efectoproductoLogic.getEfectoProductos();
			}

			parametroinventariodefectoReturnGeneral.setefectoproductosForeignKey(efectoproductosForeignKey);


			List<MarcaProducto> marcaproductosForeignKey=new ArrayList<MarcaProducto>();
			MarcaProductoLogic marcaproductoLogic=new MarcaProductoLogic();
			marcaproductoLogic.setConnexion(this.connexion);
			marcaproductoLogic.getMarcaProductoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalMarcaProducto.equals("NONE")) {
				marcaproductoLogic.getTodosMarcaProductos(finalQueryGlobalMarcaProducto,new Pagination());
				marcaproductosForeignKey=marcaproductoLogic.getMarcaProductos();
			}

			parametroinventariodefectoReturnGeneral.setmarcaproductosForeignKey(marcaproductosForeignKey);


			List<ModeloProducto> modeloproductosForeignKey=new ArrayList<ModeloProducto>();
			ModeloProductoLogic modeloproductoLogic=new ModeloProductoLogic();
			modeloproductoLogic.setConnexion(this.connexion);
			modeloproductoLogic.getModeloProductoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalModeloProducto.equals("NONE")) {
				modeloproductoLogic.getTodosModeloProductos(finalQueryGlobalModeloProducto,new Pagination());
				modeloproductosForeignKey=modeloproductoLogic.getModeloProductos();
			}

			parametroinventariodefectoReturnGeneral.setmodeloproductosForeignKey(modeloproductosForeignKey);


			List<MaterialProducto> materialproductosForeignKey=new ArrayList<MaterialProducto>();
			MaterialProductoLogic materialproductoLogic=new MaterialProductoLogic();
			materialproductoLogic.setConnexion(this.connexion);
			materialproductoLogic.getMaterialProductoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalMaterialProducto.equals("NONE")) {
				materialproductoLogic.getTodosMaterialProductos(finalQueryGlobalMaterialProducto,new Pagination());
				materialproductosForeignKey=materialproductoLogic.getMaterialProductos();
			}

			parametroinventariodefectoReturnGeneral.setmaterialproductosForeignKey(materialproductosForeignKey);


			List<SegmentoProducto> segmentoproductosForeignKey=new ArrayList<SegmentoProducto>();
			SegmentoProductoLogic segmentoproductoLogic=new SegmentoProductoLogic();
			segmentoproductoLogic.setConnexion(this.connexion);
			segmentoproductoLogic.getSegmentoProductoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSegmentoProducto.equals("NONE")) {
				segmentoproductoLogic.getTodosSegmentoProductos(finalQueryGlobalSegmentoProducto,new Pagination());
				segmentoproductosForeignKey=segmentoproductoLogic.getSegmentoProductos();
			}

			parametroinventariodefectoReturnGeneral.setsegmentoproductosForeignKey(segmentoproductosForeignKey);


			List<TallaProducto> tallaproductosForeignKey=new ArrayList<TallaProducto>();
			TallaProductoLogic tallaproductoLogic=new TallaProductoLogic();
			tallaproductoLogic.setConnexion(this.connexion);
			tallaproductoLogic.getTallaProductoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTallaProducto.equals("NONE")) {
				tallaproductoLogic.getTodosTallaProductos(finalQueryGlobalTallaProducto,new Pagination());
				tallaproductosForeignKey=tallaproductoLogic.getTallaProductos();
			}

			parametroinventariodefectoReturnGeneral.settallaproductosForeignKey(tallaproductosForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return parametroinventariodefectoReturnGeneral;
	}
	
	public ParametroInventarioDefectoParameterReturnGeneral cargarCombosLoteForeignKeyParametroInventarioDefecto(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalGrupoBodega,String finalQueryGlobalCalidadProducto,String finalQueryGlobalTipoServicio,String finalQueryGlobalTipoProductoServicioInven,String finalQueryGlobalTipoProductoServicio,String finalQueryGlobalTipoCosteo,String finalQueryGlobalTipoProducto,String finalQueryGlobalTipoViaTransporte,String finalQueryGlobalRangoUnidadVenta,String finalQueryGlobalPais,String finalQueryGlobalCiudad,String finalQueryGlobalColorProducto,String finalQueryGlobalClaseProducto,String finalQueryGlobalEfectoProducto,String finalQueryGlobalMarcaProducto,String finalQueryGlobalModeloProducto,String finalQueryGlobalMaterialProducto,String finalQueryGlobalSegmentoProducto,String finalQueryGlobalTallaProducto) throws Exception {
		ParametroInventarioDefectoParameterReturnGeneral  parametroinventariodefectoReturnGeneral =new ParametroInventarioDefectoParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			parametroinventariodefectoReturnGeneral =new ParametroInventarioDefectoParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			parametroinventariodefectoReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			parametroinventariodefectoReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<GrupoBodega> grupobodegasForeignKey=new ArrayList<GrupoBodega>();
			GrupoBodegaLogic grupobodegaLogic=new GrupoBodegaLogic();
			grupobodegaLogic.setConnexion(this.connexion);
			grupobodegaLogic.getGrupoBodegaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalGrupoBodega.equals("NONE")) {
				grupobodegaLogic.getTodosGrupoBodegas(finalQueryGlobalGrupoBodega,new Pagination());
				grupobodegasForeignKey=grupobodegaLogic.getGrupoBodegas();
			}

			parametroinventariodefectoReturnGeneral.setgrupobodegasForeignKey(grupobodegasForeignKey);


			List<CalidadProducto> calidadproductosForeignKey=new ArrayList<CalidadProducto>();
			CalidadProductoLogic calidadproductoLogic=new CalidadProductoLogic();
			calidadproductoLogic.setConnexion(this.connexion);
			calidadproductoLogic.getCalidadProductoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCalidadProducto.equals("NONE")) {
				calidadproductoLogic.getTodosCalidadProductos(finalQueryGlobalCalidadProducto,new Pagination());
				calidadproductosForeignKey=calidadproductoLogic.getCalidadProductos();
			}

			parametroinventariodefectoReturnGeneral.setcalidadproductosForeignKey(calidadproductosForeignKey);


			List<TipoServicio> tiposerviciosForeignKey=new ArrayList<TipoServicio>();
			TipoServicioLogic tiposervicioLogic=new TipoServicioLogic();
			tiposervicioLogic.setConnexion(this.connexion);
			tiposervicioLogic.getTipoServicioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoServicio.equals("NONE")) {
				tiposervicioLogic.getTodosTipoServicios(finalQueryGlobalTipoServicio,new Pagination());
				tiposerviciosForeignKey=tiposervicioLogic.getTipoServicios();
			}

			parametroinventariodefectoReturnGeneral.settiposerviciosForeignKey(tiposerviciosForeignKey);


			List<TipoProductoServicioInven> tipoproductoservicioinvensForeignKey=new ArrayList<TipoProductoServicioInven>();
			TipoProductoServicioInvenLogic tipoproductoservicioinvenLogic=new TipoProductoServicioInvenLogic();
			tipoproductoservicioinvenLogic.setConnexion(this.connexion);
			tipoproductoservicioinvenLogic.getTipoProductoServicioInvenDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoProductoServicioInven.equals("NONE")) {
				tipoproductoservicioinvenLogic.getTodosTipoProductoServicioInvens(finalQueryGlobalTipoProductoServicioInven,new Pagination());
				tipoproductoservicioinvensForeignKey=tipoproductoservicioinvenLogic.getTipoProductoServicioInvens();
			}

			parametroinventariodefectoReturnGeneral.settipoproductoservicioinvensForeignKey(tipoproductoservicioinvensForeignKey);


			List<TipoProductoServicio> tipoproductoserviciosForeignKey=new ArrayList<TipoProductoServicio>();
			TipoProductoServicioLogic tipoproductoservicioLogic=new TipoProductoServicioLogic();
			tipoproductoservicioLogic.setConnexion(this.connexion);
			tipoproductoservicioLogic.getTipoProductoServicioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoProductoServicio.equals("NONE")) {
				tipoproductoservicioLogic.getTodosTipoProductoServicios(finalQueryGlobalTipoProductoServicio,new Pagination());
				tipoproductoserviciosForeignKey=tipoproductoservicioLogic.getTipoProductoServicios();
			}

			parametroinventariodefectoReturnGeneral.settipoproductoserviciosForeignKey(tipoproductoserviciosForeignKey);


			List<TipoCosteo> tipocosteosForeignKey=new ArrayList<TipoCosteo>();
			TipoCosteoLogic tipocosteoLogic=new TipoCosteoLogic();
			tipocosteoLogic.setConnexion(this.connexion);
			tipocosteoLogic.getTipoCosteoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoCosteo.equals("NONE")) {
				tipocosteoLogic.getTodosTipoCosteos(finalQueryGlobalTipoCosteo,new Pagination());
				tipocosteosForeignKey=tipocosteoLogic.getTipoCosteos();
			}

			parametroinventariodefectoReturnGeneral.settipocosteosForeignKey(tipocosteosForeignKey);


			List<TipoProducto> tipoproductosForeignKey=new ArrayList<TipoProducto>();
			TipoProductoLogic tipoproductoLogic=new TipoProductoLogic();
			tipoproductoLogic.setConnexion(this.connexion);
			tipoproductoLogic.getTipoProductoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoProducto.equals("NONE")) {
				tipoproductoLogic.getTodosTipoProductos(finalQueryGlobalTipoProducto,new Pagination());
				tipoproductosForeignKey=tipoproductoLogic.getTipoProductos();
			}

			parametroinventariodefectoReturnGeneral.settipoproductosForeignKey(tipoproductosForeignKey);


			List<TipoViaTransporte> tipoviatransportesForeignKey=new ArrayList<TipoViaTransporte>();
			TipoViaTransporteLogic tipoviatransporteLogic=new TipoViaTransporteLogic();
			tipoviatransporteLogic.setConnexion(this.connexion);
			tipoviatransporteLogic.getTipoViaTransporteDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoViaTransporte.equals("NONE")) {
				tipoviatransporteLogic.getTodosTipoViaTransportes(finalQueryGlobalTipoViaTransporte,new Pagination());
				tipoviatransportesForeignKey=tipoviatransporteLogic.getTipoViaTransportes();
			}

			parametroinventariodefectoReturnGeneral.settipoviatransportesForeignKey(tipoviatransportesForeignKey);


			List<RangoUnidadVenta> rangounidadventasForeignKey=new ArrayList<RangoUnidadVenta>();
			RangoUnidadVentaLogic rangounidadventaLogic=new RangoUnidadVentaLogic();
			rangounidadventaLogic.setConnexion(this.connexion);
			rangounidadventaLogic.getRangoUnidadVentaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalRangoUnidadVenta.equals("NONE")) {
				rangounidadventaLogic.getTodosRangoUnidadVentas(finalQueryGlobalRangoUnidadVenta,new Pagination());
				rangounidadventasForeignKey=rangounidadventaLogic.getRangoUnidadVentas();
			}

			parametroinventariodefectoReturnGeneral.setrangounidadventasForeignKey(rangounidadventasForeignKey);


			List<Pais> paissForeignKey=new ArrayList<Pais>();
			PaisLogic paisLogic=new PaisLogic();
			paisLogic.setConnexion(this.connexion);
			paisLogic.getPaisDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPais.equals("NONE")) {
				paisLogic.getTodosPaiss(finalQueryGlobalPais,new Pagination());
				paissForeignKey=paisLogic.getPaiss();
			}

			parametroinventariodefectoReturnGeneral.setpaissForeignKey(paissForeignKey);


			List<Ciudad> ciudadsForeignKey=new ArrayList<Ciudad>();
			CiudadLogic ciudadLogic=new CiudadLogic();
			ciudadLogic.setConnexion(this.connexion);
			ciudadLogic.getCiudadDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCiudad.equals("NONE")) {
				ciudadLogic.getTodosCiudads(finalQueryGlobalCiudad,new Pagination());
				ciudadsForeignKey=ciudadLogic.getCiudads();
			}

			parametroinventariodefectoReturnGeneral.setciudadsForeignKey(ciudadsForeignKey);


			List<ColorProducto> colorproductosForeignKey=new ArrayList<ColorProducto>();
			ColorProductoLogic colorproductoLogic=new ColorProductoLogic();
			colorproductoLogic.setConnexion(this.connexion);
			colorproductoLogic.getColorProductoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalColorProducto.equals("NONE")) {
				colorproductoLogic.getTodosColorProductos(finalQueryGlobalColorProducto,new Pagination());
				colorproductosForeignKey=colorproductoLogic.getColorProductos();
			}

			parametroinventariodefectoReturnGeneral.setcolorproductosForeignKey(colorproductosForeignKey);


			List<ClaseProducto> claseproductosForeignKey=new ArrayList<ClaseProducto>();
			ClaseProductoLogic claseproductoLogic=new ClaseProductoLogic();
			claseproductoLogic.setConnexion(this.connexion);
			claseproductoLogic.getClaseProductoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalClaseProducto.equals("NONE")) {
				claseproductoLogic.getTodosClaseProductos(finalQueryGlobalClaseProducto,new Pagination());
				claseproductosForeignKey=claseproductoLogic.getClaseProductos();
			}

			parametroinventariodefectoReturnGeneral.setclaseproductosForeignKey(claseproductosForeignKey);


			List<EfectoProducto> efectoproductosForeignKey=new ArrayList<EfectoProducto>();
			EfectoProductoLogic efectoproductoLogic=new EfectoProductoLogic();
			efectoproductoLogic.setConnexion(this.connexion);
			efectoproductoLogic.getEfectoProductoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEfectoProducto.equals("NONE")) {
				efectoproductoLogic.getTodosEfectoProductos(finalQueryGlobalEfectoProducto,new Pagination());
				efectoproductosForeignKey=efectoproductoLogic.getEfectoProductos();
			}

			parametroinventariodefectoReturnGeneral.setefectoproductosForeignKey(efectoproductosForeignKey);


			List<MarcaProducto> marcaproductosForeignKey=new ArrayList<MarcaProducto>();
			MarcaProductoLogic marcaproductoLogic=new MarcaProductoLogic();
			marcaproductoLogic.setConnexion(this.connexion);
			marcaproductoLogic.getMarcaProductoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalMarcaProducto.equals("NONE")) {
				marcaproductoLogic.getTodosMarcaProductos(finalQueryGlobalMarcaProducto,new Pagination());
				marcaproductosForeignKey=marcaproductoLogic.getMarcaProductos();
			}

			parametroinventariodefectoReturnGeneral.setmarcaproductosForeignKey(marcaproductosForeignKey);


			List<ModeloProducto> modeloproductosForeignKey=new ArrayList<ModeloProducto>();
			ModeloProductoLogic modeloproductoLogic=new ModeloProductoLogic();
			modeloproductoLogic.setConnexion(this.connexion);
			modeloproductoLogic.getModeloProductoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalModeloProducto.equals("NONE")) {
				modeloproductoLogic.getTodosModeloProductos(finalQueryGlobalModeloProducto,new Pagination());
				modeloproductosForeignKey=modeloproductoLogic.getModeloProductos();
			}

			parametroinventariodefectoReturnGeneral.setmodeloproductosForeignKey(modeloproductosForeignKey);


			List<MaterialProducto> materialproductosForeignKey=new ArrayList<MaterialProducto>();
			MaterialProductoLogic materialproductoLogic=new MaterialProductoLogic();
			materialproductoLogic.setConnexion(this.connexion);
			materialproductoLogic.getMaterialProductoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalMaterialProducto.equals("NONE")) {
				materialproductoLogic.getTodosMaterialProductos(finalQueryGlobalMaterialProducto,new Pagination());
				materialproductosForeignKey=materialproductoLogic.getMaterialProductos();
			}

			parametroinventariodefectoReturnGeneral.setmaterialproductosForeignKey(materialproductosForeignKey);


			List<SegmentoProducto> segmentoproductosForeignKey=new ArrayList<SegmentoProducto>();
			SegmentoProductoLogic segmentoproductoLogic=new SegmentoProductoLogic();
			segmentoproductoLogic.setConnexion(this.connexion);
			segmentoproductoLogic.getSegmentoProductoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSegmentoProducto.equals("NONE")) {
				segmentoproductoLogic.getTodosSegmentoProductos(finalQueryGlobalSegmentoProducto,new Pagination());
				segmentoproductosForeignKey=segmentoproductoLogic.getSegmentoProductos();
			}

			parametroinventariodefectoReturnGeneral.setsegmentoproductosForeignKey(segmentoproductosForeignKey);


			List<TallaProducto> tallaproductosForeignKey=new ArrayList<TallaProducto>();
			TallaProductoLogic tallaproductoLogic=new TallaProductoLogic();
			tallaproductoLogic.setConnexion(this.connexion);
			tallaproductoLogic.getTallaProductoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTallaProducto.equals("NONE")) {
				tallaproductoLogic.getTodosTallaProductos(finalQueryGlobalTallaProducto,new Pagination());
				tallaproductosForeignKey=tallaproductoLogic.getTallaProductos();
			}

			parametroinventariodefectoReturnGeneral.settallaproductosForeignKey(tallaproductosForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return parametroinventariodefectoReturnGeneral;
	}
	
	
	public void deepLoad(ParametroInventarioDefecto parametroinventariodefecto,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			ParametroInventarioDefectoLogicAdditional.updateParametroInventarioDefectoToGet(parametroinventariodefecto,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		parametroinventariodefecto.setEmpresa(parametroinventariodefectoDataAccess.getEmpresa(connexion,parametroinventariodefecto));
		parametroinventariodefecto.setSucursal(parametroinventariodefectoDataAccess.getSucursal(connexion,parametroinventariodefecto));
		parametroinventariodefecto.setGrupoBodega(parametroinventariodefectoDataAccess.getGrupoBodega(connexion,parametroinventariodefecto));
		parametroinventariodefecto.setCalidadProducto(parametroinventariodefectoDataAccess.getCalidadProducto(connexion,parametroinventariodefecto));
		parametroinventariodefecto.setTipoServicio(parametroinventariodefectoDataAccess.getTipoServicio(connexion,parametroinventariodefecto));
		parametroinventariodefecto.setTipoProductoServicioInven(parametroinventariodefectoDataAccess.getTipoProductoServicioInven(connexion,parametroinventariodefecto));
		parametroinventariodefecto.setTipoProductoServicio(parametroinventariodefectoDataAccess.getTipoProductoServicio(connexion,parametroinventariodefecto));
		parametroinventariodefecto.setTipoCosteo(parametroinventariodefectoDataAccess.getTipoCosteo(connexion,parametroinventariodefecto));
		parametroinventariodefecto.setTipoProducto(parametroinventariodefectoDataAccess.getTipoProducto(connexion,parametroinventariodefecto));
		parametroinventariodefecto.setTipoViaTransporte(parametroinventariodefectoDataAccess.getTipoViaTransporte(connexion,parametroinventariodefecto));
		parametroinventariodefecto.setRangoUnidadVenta(parametroinventariodefectoDataAccess.getRangoUnidadVenta(connexion,parametroinventariodefecto));
		parametroinventariodefecto.setPais(parametroinventariodefectoDataAccess.getPais(connexion,parametroinventariodefecto));
		parametroinventariodefecto.setCiudad(parametroinventariodefectoDataAccess.getCiudad(connexion,parametroinventariodefecto));
		parametroinventariodefecto.setColorProducto(parametroinventariodefectoDataAccess.getColorProducto(connexion,parametroinventariodefecto));
		parametroinventariodefecto.setClaseProducto(parametroinventariodefectoDataAccess.getClaseProducto(connexion,parametroinventariodefecto));
		parametroinventariodefecto.setEfectoProducto(parametroinventariodefectoDataAccess.getEfectoProducto(connexion,parametroinventariodefecto));
		parametroinventariodefecto.setMarcaProducto(parametroinventariodefectoDataAccess.getMarcaProducto(connexion,parametroinventariodefecto));
		parametroinventariodefecto.setModeloProducto(parametroinventariodefectoDataAccess.getModeloProducto(connexion,parametroinventariodefecto));
		parametroinventariodefecto.setMaterialProducto(parametroinventariodefectoDataAccess.getMaterialProducto(connexion,parametroinventariodefecto));
		parametroinventariodefecto.setSegmentoProducto(parametroinventariodefectoDataAccess.getSegmentoProducto(connexion,parametroinventariodefecto));
		parametroinventariodefecto.setTallaProducto(parametroinventariodefectoDataAccess.getTallaProducto(connexion,parametroinventariodefecto));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				parametroinventariodefecto.setEmpresa(parametroinventariodefectoDataAccess.getEmpresa(connexion,parametroinventariodefecto));
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				parametroinventariodefecto.setSucursal(parametroinventariodefectoDataAccess.getSucursal(connexion,parametroinventariodefecto));
				continue;
			}

			if(clas.clas.equals(GrupoBodega.class)) {
				parametroinventariodefecto.setGrupoBodega(parametroinventariodefectoDataAccess.getGrupoBodega(connexion,parametroinventariodefecto));
				continue;
			}

			if(clas.clas.equals(CalidadProducto.class)) {
				parametroinventariodefecto.setCalidadProducto(parametroinventariodefectoDataAccess.getCalidadProducto(connexion,parametroinventariodefecto));
				continue;
			}

			if(clas.clas.equals(TipoServicio.class)) {
				parametroinventariodefecto.setTipoServicio(parametroinventariodefectoDataAccess.getTipoServicio(connexion,parametroinventariodefecto));
				continue;
			}

			if(clas.clas.equals(TipoProductoServicioInven.class)) {
				parametroinventariodefecto.setTipoProductoServicioInven(parametroinventariodefectoDataAccess.getTipoProductoServicioInven(connexion,parametroinventariodefecto));
				continue;
			}

			if(clas.clas.equals(TipoProductoServicio.class)) {
				parametroinventariodefecto.setTipoProductoServicio(parametroinventariodefectoDataAccess.getTipoProductoServicio(connexion,parametroinventariodefecto));
				continue;
			}

			if(clas.clas.equals(TipoCosteo.class)) {
				parametroinventariodefecto.setTipoCosteo(parametroinventariodefectoDataAccess.getTipoCosteo(connexion,parametroinventariodefecto));
				continue;
			}

			if(clas.clas.equals(TipoProducto.class)) {
				parametroinventariodefecto.setTipoProducto(parametroinventariodefectoDataAccess.getTipoProducto(connexion,parametroinventariodefecto));
				continue;
			}

			if(clas.clas.equals(TipoViaTransporte.class)) {
				parametroinventariodefecto.setTipoViaTransporte(parametroinventariodefectoDataAccess.getTipoViaTransporte(connexion,parametroinventariodefecto));
				continue;
			}

			if(clas.clas.equals(RangoUnidadVenta.class)) {
				parametroinventariodefecto.setRangoUnidadVenta(parametroinventariodefectoDataAccess.getRangoUnidadVenta(connexion,parametroinventariodefecto));
				continue;
			}

			if(clas.clas.equals(Pais.class)) {
				parametroinventariodefecto.setPais(parametroinventariodefectoDataAccess.getPais(connexion,parametroinventariodefecto));
				continue;
			}

			if(clas.clas.equals(Ciudad.class)) {
				parametroinventariodefecto.setCiudad(parametroinventariodefectoDataAccess.getCiudad(connexion,parametroinventariodefecto));
				continue;
			}

			if(clas.clas.equals(ColorProducto.class)) {
				parametroinventariodefecto.setColorProducto(parametroinventariodefectoDataAccess.getColorProducto(connexion,parametroinventariodefecto));
				continue;
			}

			if(clas.clas.equals(ClaseProducto.class)) {
				parametroinventariodefecto.setClaseProducto(parametroinventariodefectoDataAccess.getClaseProducto(connexion,parametroinventariodefecto));
				continue;
			}

			if(clas.clas.equals(EfectoProducto.class)) {
				parametroinventariodefecto.setEfectoProducto(parametroinventariodefectoDataAccess.getEfectoProducto(connexion,parametroinventariodefecto));
				continue;
			}

			if(clas.clas.equals(MarcaProducto.class)) {
				parametroinventariodefecto.setMarcaProducto(parametroinventariodefectoDataAccess.getMarcaProducto(connexion,parametroinventariodefecto));
				continue;
			}

			if(clas.clas.equals(ModeloProducto.class)) {
				parametroinventariodefecto.setModeloProducto(parametroinventariodefectoDataAccess.getModeloProducto(connexion,parametroinventariodefecto));
				continue;
			}

			if(clas.clas.equals(MaterialProducto.class)) {
				parametroinventariodefecto.setMaterialProducto(parametroinventariodefectoDataAccess.getMaterialProducto(connexion,parametroinventariodefecto));
				continue;
			}

			if(clas.clas.equals(SegmentoProducto.class)) {
				parametroinventariodefecto.setSegmentoProducto(parametroinventariodefectoDataAccess.getSegmentoProducto(connexion,parametroinventariodefecto));
				continue;
			}

			if(clas.clas.equals(TallaProducto.class)) {
				parametroinventariodefecto.setTallaProducto(parametroinventariodefectoDataAccess.getTallaProducto(connexion,parametroinventariodefecto));
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
			parametroinventariodefecto.setEmpresa(parametroinventariodefectoDataAccess.getEmpresa(connexion,parametroinventariodefecto));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametroinventariodefecto.setSucursal(parametroinventariodefectoDataAccess.getSucursal(connexion,parametroinventariodefecto));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(GrupoBodega.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametroinventariodefecto.setGrupoBodega(parametroinventariodefectoDataAccess.getGrupoBodega(connexion,parametroinventariodefecto));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CalidadProducto.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametroinventariodefecto.setCalidadProducto(parametroinventariodefectoDataAccess.getCalidadProducto(connexion,parametroinventariodefecto));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoServicio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametroinventariodefecto.setTipoServicio(parametroinventariodefectoDataAccess.getTipoServicio(connexion,parametroinventariodefecto));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoProductoServicioInven.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametroinventariodefecto.setTipoProductoServicioInven(parametroinventariodefectoDataAccess.getTipoProductoServicioInven(connexion,parametroinventariodefecto));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoProductoServicio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametroinventariodefecto.setTipoProductoServicio(parametroinventariodefectoDataAccess.getTipoProductoServicio(connexion,parametroinventariodefecto));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoCosteo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametroinventariodefecto.setTipoCosteo(parametroinventariodefectoDataAccess.getTipoCosteo(connexion,parametroinventariodefecto));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoProducto.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametroinventariodefecto.setTipoProducto(parametroinventariodefectoDataAccess.getTipoProducto(connexion,parametroinventariodefecto));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoViaTransporte.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametroinventariodefecto.setTipoViaTransporte(parametroinventariodefectoDataAccess.getTipoViaTransporte(connexion,parametroinventariodefecto));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(RangoUnidadVenta.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametroinventariodefecto.setRangoUnidadVenta(parametroinventariodefectoDataAccess.getRangoUnidadVenta(connexion,parametroinventariodefecto));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Pais.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametroinventariodefecto.setPais(parametroinventariodefectoDataAccess.getPais(connexion,parametroinventariodefecto));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Ciudad.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametroinventariodefecto.setCiudad(parametroinventariodefectoDataAccess.getCiudad(connexion,parametroinventariodefecto));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(ColorProducto.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametroinventariodefecto.setColorProducto(parametroinventariodefectoDataAccess.getColorProducto(connexion,parametroinventariodefecto));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(ClaseProducto.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametroinventariodefecto.setClaseProducto(parametroinventariodefectoDataAccess.getClaseProducto(connexion,parametroinventariodefecto));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(EfectoProducto.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametroinventariodefecto.setEfectoProducto(parametroinventariodefectoDataAccess.getEfectoProducto(connexion,parametroinventariodefecto));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(MarcaProducto.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametroinventariodefecto.setMarcaProducto(parametroinventariodefectoDataAccess.getMarcaProducto(connexion,parametroinventariodefecto));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(ModeloProducto.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametroinventariodefecto.setModeloProducto(parametroinventariodefectoDataAccess.getModeloProducto(connexion,parametroinventariodefecto));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(MaterialProducto.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametroinventariodefecto.setMaterialProducto(parametroinventariodefectoDataAccess.getMaterialProducto(connexion,parametroinventariodefecto));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(SegmentoProducto.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametroinventariodefecto.setSegmentoProducto(parametroinventariodefectoDataAccess.getSegmentoProducto(connexion,parametroinventariodefecto));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TallaProducto.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametroinventariodefecto.setTallaProducto(parametroinventariodefectoDataAccess.getTallaProducto(connexion,parametroinventariodefecto));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		parametroinventariodefecto.setEmpresa(parametroinventariodefectoDataAccess.getEmpresa(connexion,parametroinventariodefecto));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(parametroinventariodefecto.getEmpresa(),isDeep,deepLoadType,clases);
				
		parametroinventariodefecto.setSucursal(parametroinventariodefectoDataAccess.getSucursal(connexion,parametroinventariodefecto));
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(parametroinventariodefecto.getSucursal(),isDeep,deepLoadType,clases);
				
		parametroinventariodefecto.setGrupoBodega(parametroinventariodefectoDataAccess.getGrupoBodega(connexion,parametroinventariodefecto));
		GrupoBodegaLogic grupobodegaLogic= new GrupoBodegaLogic(connexion);
		grupobodegaLogic.deepLoad(parametroinventariodefecto.getGrupoBodega(),isDeep,deepLoadType,clases);
				
		parametroinventariodefecto.setCalidadProducto(parametroinventariodefectoDataAccess.getCalidadProducto(connexion,parametroinventariodefecto));
		CalidadProductoLogic calidadproductoLogic= new CalidadProductoLogic(connexion);
		calidadproductoLogic.deepLoad(parametroinventariodefecto.getCalidadProducto(),isDeep,deepLoadType,clases);
				
		parametroinventariodefecto.setTipoServicio(parametroinventariodefectoDataAccess.getTipoServicio(connexion,parametroinventariodefecto));
		TipoServicioLogic tiposervicioLogic= new TipoServicioLogic(connexion);
		tiposervicioLogic.deepLoad(parametroinventariodefecto.getTipoServicio(),isDeep,deepLoadType,clases);
				
		parametroinventariodefecto.setTipoProductoServicioInven(parametroinventariodefectoDataAccess.getTipoProductoServicioInven(connexion,parametroinventariodefecto));
		TipoProductoServicioInvenLogic tipoproductoservicioinvenLogic= new TipoProductoServicioInvenLogic(connexion);
		tipoproductoservicioinvenLogic.deepLoad(parametroinventariodefecto.getTipoProductoServicioInven(),isDeep,deepLoadType,clases);
				
		parametroinventariodefecto.setTipoProductoServicio(parametroinventariodefectoDataAccess.getTipoProductoServicio(connexion,parametroinventariodefecto));
		TipoProductoServicioLogic tipoproductoservicioLogic= new TipoProductoServicioLogic(connexion);
		tipoproductoservicioLogic.deepLoad(parametroinventariodefecto.getTipoProductoServicio(),isDeep,deepLoadType,clases);
				
		parametroinventariodefecto.setTipoCosteo(parametroinventariodefectoDataAccess.getTipoCosteo(connexion,parametroinventariodefecto));
		TipoCosteoLogic tipocosteoLogic= new TipoCosteoLogic(connexion);
		tipocosteoLogic.deepLoad(parametroinventariodefecto.getTipoCosteo(),isDeep,deepLoadType,clases);
				
		parametroinventariodefecto.setTipoProducto(parametroinventariodefectoDataAccess.getTipoProducto(connexion,parametroinventariodefecto));
		TipoProductoLogic tipoproductoLogic= new TipoProductoLogic(connexion);
		tipoproductoLogic.deepLoad(parametroinventariodefecto.getTipoProducto(),isDeep,deepLoadType,clases);
				
		parametroinventariodefecto.setTipoViaTransporte(parametroinventariodefectoDataAccess.getTipoViaTransporte(connexion,parametroinventariodefecto));
		TipoViaTransporteLogic tipoviatransporteLogic= new TipoViaTransporteLogic(connexion);
		tipoviatransporteLogic.deepLoad(parametroinventariodefecto.getTipoViaTransporte(),isDeep,deepLoadType,clases);
				
		parametroinventariodefecto.setRangoUnidadVenta(parametroinventariodefectoDataAccess.getRangoUnidadVenta(connexion,parametroinventariodefecto));
		RangoUnidadVentaLogic rangounidadventaLogic= new RangoUnidadVentaLogic(connexion);
		rangounidadventaLogic.deepLoad(parametroinventariodefecto.getRangoUnidadVenta(),isDeep,deepLoadType,clases);
				
		parametroinventariodefecto.setPais(parametroinventariodefectoDataAccess.getPais(connexion,parametroinventariodefecto));
		PaisLogic paisLogic= new PaisLogic(connexion);
		paisLogic.deepLoad(parametroinventariodefecto.getPais(),isDeep,deepLoadType,clases);
				
		parametroinventariodefecto.setCiudad(parametroinventariodefectoDataAccess.getCiudad(connexion,parametroinventariodefecto));
		CiudadLogic ciudadLogic= new CiudadLogic(connexion);
		ciudadLogic.deepLoad(parametroinventariodefecto.getCiudad(),isDeep,deepLoadType,clases);
				
		parametroinventariodefecto.setColorProducto(parametroinventariodefectoDataAccess.getColorProducto(connexion,parametroinventariodefecto));
		ColorProductoLogic colorproductoLogic= new ColorProductoLogic(connexion);
		colorproductoLogic.deepLoad(parametroinventariodefecto.getColorProducto(),isDeep,deepLoadType,clases);
				
		parametroinventariodefecto.setClaseProducto(parametroinventariodefectoDataAccess.getClaseProducto(connexion,parametroinventariodefecto));
		ClaseProductoLogic claseproductoLogic= new ClaseProductoLogic(connexion);
		claseproductoLogic.deepLoad(parametroinventariodefecto.getClaseProducto(),isDeep,deepLoadType,clases);
				
		parametroinventariodefecto.setEfectoProducto(parametroinventariodefectoDataAccess.getEfectoProducto(connexion,parametroinventariodefecto));
		EfectoProductoLogic efectoproductoLogic= new EfectoProductoLogic(connexion);
		efectoproductoLogic.deepLoad(parametroinventariodefecto.getEfectoProducto(),isDeep,deepLoadType,clases);
				
		parametroinventariodefecto.setMarcaProducto(parametroinventariodefectoDataAccess.getMarcaProducto(connexion,parametroinventariodefecto));
		MarcaProductoLogic marcaproductoLogic= new MarcaProductoLogic(connexion);
		marcaproductoLogic.deepLoad(parametroinventariodefecto.getMarcaProducto(),isDeep,deepLoadType,clases);
				
		parametroinventariodefecto.setModeloProducto(parametroinventariodefectoDataAccess.getModeloProducto(connexion,parametroinventariodefecto));
		ModeloProductoLogic modeloproductoLogic= new ModeloProductoLogic(connexion);
		modeloproductoLogic.deepLoad(parametroinventariodefecto.getModeloProducto(),isDeep,deepLoadType,clases);
				
		parametroinventariodefecto.setMaterialProducto(parametroinventariodefectoDataAccess.getMaterialProducto(connexion,parametroinventariodefecto));
		MaterialProductoLogic materialproductoLogic= new MaterialProductoLogic(connexion);
		materialproductoLogic.deepLoad(parametroinventariodefecto.getMaterialProducto(),isDeep,deepLoadType,clases);
				
		parametroinventariodefecto.setSegmentoProducto(parametroinventariodefectoDataAccess.getSegmentoProducto(connexion,parametroinventariodefecto));
		SegmentoProductoLogic segmentoproductoLogic= new SegmentoProductoLogic(connexion);
		segmentoproductoLogic.deepLoad(parametroinventariodefecto.getSegmentoProducto(),isDeep,deepLoadType,clases);
				
		parametroinventariodefecto.setTallaProducto(parametroinventariodefectoDataAccess.getTallaProducto(connexion,parametroinventariodefecto));
		TallaProductoLogic tallaproductoLogic= new TallaProductoLogic(connexion);
		tallaproductoLogic.deepLoad(parametroinventariodefecto.getTallaProducto(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				parametroinventariodefecto.setEmpresa(parametroinventariodefectoDataAccess.getEmpresa(connexion,parametroinventariodefecto));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(parametroinventariodefecto.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				parametroinventariodefecto.setSucursal(parametroinventariodefectoDataAccess.getSucursal(connexion,parametroinventariodefecto));
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepLoad(parametroinventariodefecto.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(GrupoBodega.class)) {
				parametroinventariodefecto.setGrupoBodega(parametroinventariodefectoDataAccess.getGrupoBodega(connexion,parametroinventariodefecto));
				GrupoBodegaLogic grupobodegaLogic= new GrupoBodegaLogic(connexion);
				grupobodegaLogic.deepLoad(parametroinventariodefecto.getGrupoBodega(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CalidadProducto.class)) {
				parametroinventariodefecto.setCalidadProducto(parametroinventariodefectoDataAccess.getCalidadProducto(connexion,parametroinventariodefecto));
				CalidadProductoLogic calidadproductoLogic= new CalidadProductoLogic(connexion);
				calidadproductoLogic.deepLoad(parametroinventariodefecto.getCalidadProducto(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoServicio.class)) {
				parametroinventariodefecto.setTipoServicio(parametroinventariodefectoDataAccess.getTipoServicio(connexion,parametroinventariodefecto));
				TipoServicioLogic tiposervicioLogic= new TipoServicioLogic(connexion);
				tiposervicioLogic.deepLoad(parametroinventariodefecto.getTipoServicio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoProductoServicioInven.class)) {
				parametroinventariodefecto.setTipoProductoServicioInven(parametroinventariodefectoDataAccess.getTipoProductoServicioInven(connexion,parametroinventariodefecto));
				TipoProductoServicioInvenLogic tipoproductoservicioinvenLogic= new TipoProductoServicioInvenLogic(connexion);
				tipoproductoservicioinvenLogic.deepLoad(parametroinventariodefecto.getTipoProductoServicioInven(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoProductoServicio.class)) {
				parametroinventariodefecto.setTipoProductoServicio(parametroinventariodefectoDataAccess.getTipoProductoServicio(connexion,parametroinventariodefecto));
				TipoProductoServicioLogic tipoproductoservicioLogic= new TipoProductoServicioLogic(connexion);
				tipoproductoservicioLogic.deepLoad(parametroinventariodefecto.getTipoProductoServicio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoCosteo.class)) {
				parametroinventariodefecto.setTipoCosteo(parametroinventariodefectoDataAccess.getTipoCosteo(connexion,parametroinventariodefecto));
				TipoCosteoLogic tipocosteoLogic= new TipoCosteoLogic(connexion);
				tipocosteoLogic.deepLoad(parametroinventariodefecto.getTipoCosteo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoProducto.class)) {
				parametroinventariodefecto.setTipoProducto(parametroinventariodefectoDataAccess.getTipoProducto(connexion,parametroinventariodefecto));
				TipoProductoLogic tipoproductoLogic= new TipoProductoLogic(connexion);
				tipoproductoLogic.deepLoad(parametroinventariodefecto.getTipoProducto(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoViaTransporte.class)) {
				parametroinventariodefecto.setTipoViaTransporte(parametroinventariodefectoDataAccess.getTipoViaTransporte(connexion,parametroinventariodefecto));
				TipoViaTransporteLogic tipoviatransporteLogic= new TipoViaTransporteLogic(connexion);
				tipoviatransporteLogic.deepLoad(parametroinventariodefecto.getTipoViaTransporte(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(RangoUnidadVenta.class)) {
				parametroinventariodefecto.setRangoUnidadVenta(parametroinventariodefectoDataAccess.getRangoUnidadVenta(connexion,parametroinventariodefecto));
				RangoUnidadVentaLogic rangounidadventaLogic= new RangoUnidadVentaLogic(connexion);
				rangounidadventaLogic.deepLoad(parametroinventariodefecto.getRangoUnidadVenta(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Pais.class)) {
				parametroinventariodefecto.setPais(parametroinventariodefectoDataAccess.getPais(connexion,parametroinventariodefecto));
				PaisLogic paisLogic= new PaisLogic(connexion);
				paisLogic.deepLoad(parametroinventariodefecto.getPais(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Ciudad.class)) {
				parametroinventariodefecto.setCiudad(parametroinventariodefectoDataAccess.getCiudad(connexion,parametroinventariodefecto));
				CiudadLogic ciudadLogic= new CiudadLogic(connexion);
				ciudadLogic.deepLoad(parametroinventariodefecto.getCiudad(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(ColorProducto.class)) {
				parametroinventariodefecto.setColorProducto(parametroinventariodefectoDataAccess.getColorProducto(connexion,parametroinventariodefecto));
				ColorProductoLogic colorproductoLogic= new ColorProductoLogic(connexion);
				colorproductoLogic.deepLoad(parametroinventariodefecto.getColorProducto(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(ClaseProducto.class)) {
				parametroinventariodefecto.setClaseProducto(parametroinventariodefectoDataAccess.getClaseProducto(connexion,parametroinventariodefecto));
				ClaseProductoLogic claseproductoLogic= new ClaseProductoLogic(connexion);
				claseproductoLogic.deepLoad(parametroinventariodefecto.getClaseProducto(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(EfectoProducto.class)) {
				parametroinventariodefecto.setEfectoProducto(parametroinventariodefectoDataAccess.getEfectoProducto(connexion,parametroinventariodefecto));
				EfectoProductoLogic efectoproductoLogic= new EfectoProductoLogic(connexion);
				efectoproductoLogic.deepLoad(parametroinventariodefecto.getEfectoProducto(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(MarcaProducto.class)) {
				parametroinventariodefecto.setMarcaProducto(parametroinventariodefectoDataAccess.getMarcaProducto(connexion,parametroinventariodefecto));
				MarcaProductoLogic marcaproductoLogic= new MarcaProductoLogic(connexion);
				marcaproductoLogic.deepLoad(parametroinventariodefecto.getMarcaProducto(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(ModeloProducto.class)) {
				parametroinventariodefecto.setModeloProducto(parametroinventariodefectoDataAccess.getModeloProducto(connexion,parametroinventariodefecto));
				ModeloProductoLogic modeloproductoLogic= new ModeloProductoLogic(connexion);
				modeloproductoLogic.deepLoad(parametroinventariodefecto.getModeloProducto(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(MaterialProducto.class)) {
				parametroinventariodefecto.setMaterialProducto(parametroinventariodefectoDataAccess.getMaterialProducto(connexion,parametroinventariodefecto));
				MaterialProductoLogic materialproductoLogic= new MaterialProductoLogic(connexion);
				materialproductoLogic.deepLoad(parametroinventariodefecto.getMaterialProducto(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(SegmentoProducto.class)) {
				parametroinventariodefecto.setSegmentoProducto(parametroinventariodefectoDataAccess.getSegmentoProducto(connexion,parametroinventariodefecto));
				SegmentoProductoLogic segmentoproductoLogic= new SegmentoProductoLogic(connexion);
				segmentoproductoLogic.deepLoad(parametroinventariodefecto.getSegmentoProducto(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TallaProducto.class)) {
				parametroinventariodefecto.setTallaProducto(parametroinventariodefectoDataAccess.getTallaProducto(connexion,parametroinventariodefecto));
				TallaProductoLogic tallaproductoLogic= new TallaProductoLogic(connexion);
				tallaproductoLogic.deepLoad(parametroinventariodefecto.getTallaProducto(),isDeep,deepLoadType,clases);				
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
			parametroinventariodefecto.setEmpresa(parametroinventariodefectoDataAccess.getEmpresa(connexion,parametroinventariodefecto));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(parametroinventariodefecto.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametroinventariodefecto.setSucursal(parametroinventariodefectoDataAccess.getSucursal(connexion,parametroinventariodefecto));
			SucursalLogic sucursalLogic= new SucursalLogic(connexion);
			sucursalLogic.deepLoad(parametroinventariodefecto.getSucursal(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(GrupoBodega.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametroinventariodefecto.setGrupoBodega(parametroinventariodefectoDataAccess.getGrupoBodega(connexion,parametroinventariodefecto));
			GrupoBodegaLogic grupobodegaLogic= new GrupoBodegaLogic(connexion);
			grupobodegaLogic.deepLoad(parametroinventariodefecto.getGrupoBodega(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(CalidadProducto.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametroinventariodefecto.setCalidadProducto(parametroinventariodefectoDataAccess.getCalidadProducto(connexion,parametroinventariodefecto));
			CalidadProductoLogic calidadproductoLogic= new CalidadProductoLogic(connexion);
			calidadproductoLogic.deepLoad(parametroinventariodefecto.getCalidadProducto(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoServicio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametroinventariodefecto.setTipoServicio(parametroinventariodefectoDataAccess.getTipoServicio(connexion,parametroinventariodefecto));
			TipoServicioLogic tiposervicioLogic= new TipoServicioLogic(connexion);
			tiposervicioLogic.deepLoad(parametroinventariodefecto.getTipoServicio(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoProductoServicioInven.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametroinventariodefecto.setTipoProductoServicioInven(parametroinventariodefectoDataAccess.getTipoProductoServicioInven(connexion,parametroinventariodefecto));
			TipoProductoServicioInvenLogic tipoproductoservicioinvenLogic= new TipoProductoServicioInvenLogic(connexion);
			tipoproductoservicioinvenLogic.deepLoad(parametroinventariodefecto.getTipoProductoServicioInven(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoProductoServicio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametroinventariodefecto.setTipoProductoServicio(parametroinventariodefectoDataAccess.getTipoProductoServicio(connexion,parametroinventariodefecto));
			TipoProductoServicioLogic tipoproductoservicioLogic= new TipoProductoServicioLogic(connexion);
			tipoproductoservicioLogic.deepLoad(parametroinventariodefecto.getTipoProductoServicio(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoCosteo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametroinventariodefecto.setTipoCosteo(parametroinventariodefectoDataAccess.getTipoCosteo(connexion,parametroinventariodefecto));
			TipoCosteoLogic tipocosteoLogic= new TipoCosteoLogic(connexion);
			tipocosteoLogic.deepLoad(parametroinventariodefecto.getTipoCosteo(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoProducto.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametroinventariodefecto.setTipoProducto(parametroinventariodefectoDataAccess.getTipoProducto(connexion,parametroinventariodefecto));
			TipoProductoLogic tipoproductoLogic= new TipoProductoLogic(connexion);
			tipoproductoLogic.deepLoad(parametroinventariodefecto.getTipoProducto(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoViaTransporte.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametroinventariodefecto.setTipoViaTransporte(parametroinventariodefectoDataAccess.getTipoViaTransporte(connexion,parametroinventariodefecto));
			TipoViaTransporteLogic tipoviatransporteLogic= new TipoViaTransporteLogic(connexion);
			tipoviatransporteLogic.deepLoad(parametroinventariodefecto.getTipoViaTransporte(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(RangoUnidadVenta.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametroinventariodefecto.setRangoUnidadVenta(parametroinventariodefectoDataAccess.getRangoUnidadVenta(connexion,parametroinventariodefecto));
			RangoUnidadVentaLogic rangounidadventaLogic= new RangoUnidadVentaLogic(connexion);
			rangounidadventaLogic.deepLoad(parametroinventariodefecto.getRangoUnidadVenta(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Pais.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametroinventariodefecto.setPais(parametroinventariodefectoDataAccess.getPais(connexion,parametroinventariodefecto));
			PaisLogic paisLogic= new PaisLogic(connexion);
			paisLogic.deepLoad(parametroinventariodefecto.getPais(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Ciudad.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametroinventariodefecto.setCiudad(parametroinventariodefectoDataAccess.getCiudad(connexion,parametroinventariodefecto));
			CiudadLogic ciudadLogic= new CiudadLogic(connexion);
			ciudadLogic.deepLoad(parametroinventariodefecto.getCiudad(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(ColorProducto.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametroinventariodefecto.setColorProducto(parametroinventariodefectoDataAccess.getColorProducto(connexion,parametroinventariodefecto));
			ColorProductoLogic colorproductoLogic= new ColorProductoLogic(connexion);
			colorproductoLogic.deepLoad(parametroinventariodefecto.getColorProducto(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(ClaseProducto.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametroinventariodefecto.setClaseProducto(parametroinventariodefectoDataAccess.getClaseProducto(connexion,parametroinventariodefecto));
			ClaseProductoLogic claseproductoLogic= new ClaseProductoLogic(connexion);
			claseproductoLogic.deepLoad(parametroinventariodefecto.getClaseProducto(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(EfectoProducto.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametroinventariodefecto.setEfectoProducto(parametroinventariodefectoDataAccess.getEfectoProducto(connexion,parametroinventariodefecto));
			EfectoProductoLogic efectoproductoLogic= new EfectoProductoLogic(connexion);
			efectoproductoLogic.deepLoad(parametroinventariodefecto.getEfectoProducto(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(MarcaProducto.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametroinventariodefecto.setMarcaProducto(parametroinventariodefectoDataAccess.getMarcaProducto(connexion,parametroinventariodefecto));
			MarcaProductoLogic marcaproductoLogic= new MarcaProductoLogic(connexion);
			marcaproductoLogic.deepLoad(parametroinventariodefecto.getMarcaProducto(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(ModeloProducto.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametroinventariodefecto.setModeloProducto(parametroinventariodefectoDataAccess.getModeloProducto(connexion,parametroinventariodefecto));
			ModeloProductoLogic modeloproductoLogic= new ModeloProductoLogic(connexion);
			modeloproductoLogic.deepLoad(parametroinventariodefecto.getModeloProducto(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(MaterialProducto.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametroinventariodefecto.setMaterialProducto(parametroinventariodefectoDataAccess.getMaterialProducto(connexion,parametroinventariodefecto));
			MaterialProductoLogic materialproductoLogic= new MaterialProductoLogic(connexion);
			materialproductoLogic.deepLoad(parametroinventariodefecto.getMaterialProducto(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(SegmentoProducto.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametroinventariodefecto.setSegmentoProducto(parametroinventariodefectoDataAccess.getSegmentoProducto(connexion,parametroinventariodefecto));
			SegmentoProductoLogic segmentoproductoLogic= new SegmentoProductoLogic(connexion);
			segmentoproductoLogic.deepLoad(parametroinventariodefecto.getSegmentoProducto(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TallaProducto.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametroinventariodefecto.setTallaProducto(parametroinventariodefectoDataAccess.getTallaProducto(connexion,parametroinventariodefecto));
			TallaProductoLogic tallaproductoLogic= new TallaProductoLogic(connexion);
			tallaproductoLogic.deepLoad(parametroinventariodefecto.getTallaProducto(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(ParametroInventarioDefecto parametroinventariodefecto,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			ParametroInventarioDefectoLogicAdditional.updateParametroInventarioDefectoToSave(parametroinventariodefecto,this.arrDatoGeneral);
			
ParametroInventarioDefectoDataAccess.save(parametroinventariodefecto, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(parametroinventariodefecto.getEmpresa(),connexion);

		SucursalDataAccess.save(parametroinventariodefecto.getSucursal(),connexion);

		GrupoBodegaDataAccess.save(parametroinventariodefecto.getGrupoBodega(),connexion);

		CalidadProductoDataAccess.save(parametroinventariodefecto.getCalidadProducto(),connexion);

		TipoServicioDataAccess.save(parametroinventariodefecto.getTipoServicio(),connexion);

		TipoProductoServicioInvenDataAccess.save(parametroinventariodefecto.getTipoProductoServicioInven(),connexion);

		TipoProductoServicioDataAccess.save(parametroinventariodefecto.getTipoProductoServicio(),connexion);

		TipoCosteoDataAccess.save(parametroinventariodefecto.getTipoCosteo(),connexion);

		TipoProductoDataAccess.save(parametroinventariodefecto.getTipoProducto(),connexion);

		TipoViaTransporteDataAccess.save(parametroinventariodefecto.getTipoViaTransporte(),connexion);

		RangoUnidadVentaDataAccess.save(parametroinventariodefecto.getRangoUnidadVenta(),connexion);

		PaisDataAccess.save(parametroinventariodefecto.getPais(),connexion);

		CiudadDataAccess.save(parametroinventariodefecto.getCiudad(),connexion);

		ColorProductoDataAccess.save(parametroinventariodefecto.getColorProducto(),connexion);

		ClaseProductoDataAccess.save(parametroinventariodefecto.getClaseProducto(),connexion);

		EfectoProductoDataAccess.save(parametroinventariodefecto.getEfectoProducto(),connexion);

		MarcaProductoDataAccess.save(parametroinventariodefecto.getMarcaProducto(),connexion);

		ModeloProductoDataAccess.save(parametroinventariodefecto.getModeloProducto(),connexion);

		MaterialProductoDataAccess.save(parametroinventariodefecto.getMaterialProducto(),connexion);

		SegmentoProductoDataAccess.save(parametroinventariodefecto.getSegmentoProducto(),connexion);

		TallaProductoDataAccess.save(parametroinventariodefecto.getTallaProducto(),connexion);
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(parametroinventariodefecto.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(parametroinventariodefecto.getSucursal(),connexion);
				continue;
			}

			if(clas.clas.equals(GrupoBodega.class)) {
				GrupoBodegaDataAccess.save(parametroinventariodefecto.getGrupoBodega(),connexion);
				continue;
			}

			if(clas.clas.equals(CalidadProducto.class)) {
				CalidadProductoDataAccess.save(parametroinventariodefecto.getCalidadProducto(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoServicio.class)) {
				TipoServicioDataAccess.save(parametroinventariodefecto.getTipoServicio(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoProductoServicioInven.class)) {
				TipoProductoServicioInvenDataAccess.save(parametroinventariodefecto.getTipoProductoServicioInven(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoProductoServicio.class)) {
				TipoProductoServicioDataAccess.save(parametroinventariodefecto.getTipoProductoServicio(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoCosteo.class)) {
				TipoCosteoDataAccess.save(parametroinventariodefecto.getTipoCosteo(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoProducto.class)) {
				TipoProductoDataAccess.save(parametroinventariodefecto.getTipoProducto(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoViaTransporte.class)) {
				TipoViaTransporteDataAccess.save(parametroinventariodefecto.getTipoViaTransporte(),connexion);
				continue;
			}

			if(clas.clas.equals(RangoUnidadVenta.class)) {
				RangoUnidadVentaDataAccess.save(parametroinventariodefecto.getRangoUnidadVenta(),connexion);
				continue;
			}

			if(clas.clas.equals(Pais.class)) {
				PaisDataAccess.save(parametroinventariodefecto.getPais(),connexion);
				continue;
			}

			if(clas.clas.equals(Ciudad.class)) {
				CiudadDataAccess.save(parametroinventariodefecto.getCiudad(),connexion);
				continue;
			}

			if(clas.clas.equals(ColorProducto.class)) {
				ColorProductoDataAccess.save(parametroinventariodefecto.getColorProducto(),connexion);
				continue;
			}

			if(clas.clas.equals(ClaseProducto.class)) {
				ClaseProductoDataAccess.save(parametroinventariodefecto.getClaseProducto(),connexion);
				continue;
			}

			if(clas.clas.equals(EfectoProducto.class)) {
				EfectoProductoDataAccess.save(parametroinventariodefecto.getEfectoProducto(),connexion);
				continue;
			}

			if(clas.clas.equals(MarcaProducto.class)) {
				MarcaProductoDataAccess.save(parametroinventariodefecto.getMarcaProducto(),connexion);
				continue;
			}

			if(clas.clas.equals(ModeloProducto.class)) {
				ModeloProductoDataAccess.save(parametroinventariodefecto.getModeloProducto(),connexion);
				continue;
			}

			if(clas.clas.equals(MaterialProducto.class)) {
				MaterialProductoDataAccess.save(parametroinventariodefecto.getMaterialProducto(),connexion);
				continue;
			}

			if(clas.clas.equals(SegmentoProducto.class)) {
				SegmentoProductoDataAccess.save(parametroinventariodefecto.getSegmentoProducto(),connexion);
				continue;
			}

			if(clas.clas.equals(TallaProducto.class)) {
				TallaProductoDataAccess.save(parametroinventariodefecto.getTallaProducto(),connexion);
				continue;
			}

		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(parametroinventariodefecto.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(parametroinventariodefecto.getEmpresa(),isDeep,deepLoadType,clases);
				

		SucursalDataAccess.save(parametroinventariodefecto.getSucursal(),connexion);
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(parametroinventariodefecto.getSucursal(),isDeep,deepLoadType,clases);
				

		GrupoBodegaDataAccess.save(parametroinventariodefecto.getGrupoBodega(),connexion);
		GrupoBodegaLogic grupobodegaLogic= new GrupoBodegaLogic(connexion);
		grupobodegaLogic.deepLoad(parametroinventariodefecto.getGrupoBodega(),isDeep,deepLoadType,clases);
				

		CalidadProductoDataAccess.save(parametroinventariodefecto.getCalidadProducto(),connexion);
		CalidadProductoLogic calidadproductoLogic= new CalidadProductoLogic(connexion);
		calidadproductoLogic.deepLoad(parametroinventariodefecto.getCalidadProducto(),isDeep,deepLoadType,clases);
				

		TipoServicioDataAccess.save(parametroinventariodefecto.getTipoServicio(),connexion);
		TipoServicioLogic tiposervicioLogic= new TipoServicioLogic(connexion);
		tiposervicioLogic.deepLoad(parametroinventariodefecto.getTipoServicio(),isDeep,deepLoadType,clases);
				

		TipoProductoServicioInvenDataAccess.save(parametroinventariodefecto.getTipoProductoServicioInven(),connexion);
		TipoProductoServicioInvenLogic tipoproductoservicioinvenLogic= new TipoProductoServicioInvenLogic(connexion);
		tipoproductoservicioinvenLogic.deepLoad(parametroinventariodefecto.getTipoProductoServicioInven(),isDeep,deepLoadType,clases);
				

		TipoProductoServicioDataAccess.save(parametroinventariodefecto.getTipoProductoServicio(),connexion);
		TipoProductoServicioLogic tipoproductoservicioLogic= new TipoProductoServicioLogic(connexion);
		tipoproductoservicioLogic.deepLoad(parametroinventariodefecto.getTipoProductoServicio(),isDeep,deepLoadType,clases);
				

		TipoCosteoDataAccess.save(parametroinventariodefecto.getTipoCosteo(),connexion);
		TipoCosteoLogic tipocosteoLogic= new TipoCosteoLogic(connexion);
		tipocosteoLogic.deepLoad(parametroinventariodefecto.getTipoCosteo(),isDeep,deepLoadType,clases);
				

		TipoProductoDataAccess.save(parametroinventariodefecto.getTipoProducto(),connexion);
		TipoProductoLogic tipoproductoLogic= new TipoProductoLogic(connexion);
		tipoproductoLogic.deepLoad(parametroinventariodefecto.getTipoProducto(),isDeep,deepLoadType,clases);
				

		TipoViaTransporteDataAccess.save(parametroinventariodefecto.getTipoViaTransporte(),connexion);
		TipoViaTransporteLogic tipoviatransporteLogic= new TipoViaTransporteLogic(connexion);
		tipoviatransporteLogic.deepLoad(parametroinventariodefecto.getTipoViaTransporte(),isDeep,deepLoadType,clases);
				

		RangoUnidadVentaDataAccess.save(parametroinventariodefecto.getRangoUnidadVenta(),connexion);
		RangoUnidadVentaLogic rangounidadventaLogic= new RangoUnidadVentaLogic(connexion);
		rangounidadventaLogic.deepLoad(parametroinventariodefecto.getRangoUnidadVenta(),isDeep,deepLoadType,clases);
				

		PaisDataAccess.save(parametroinventariodefecto.getPais(),connexion);
		PaisLogic paisLogic= new PaisLogic(connexion);
		paisLogic.deepLoad(parametroinventariodefecto.getPais(),isDeep,deepLoadType,clases);
				

		CiudadDataAccess.save(parametroinventariodefecto.getCiudad(),connexion);
		CiudadLogic ciudadLogic= new CiudadLogic(connexion);
		ciudadLogic.deepLoad(parametroinventariodefecto.getCiudad(),isDeep,deepLoadType,clases);
				

		ColorProductoDataAccess.save(parametroinventariodefecto.getColorProducto(),connexion);
		ColorProductoLogic colorproductoLogic= new ColorProductoLogic(connexion);
		colorproductoLogic.deepLoad(parametroinventariodefecto.getColorProducto(),isDeep,deepLoadType,clases);
				

		ClaseProductoDataAccess.save(parametroinventariodefecto.getClaseProducto(),connexion);
		ClaseProductoLogic claseproductoLogic= new ClaseProductoLogic(connexion);
		claseproductoLogic.deepLoad(parametroinventariodefecto.getClaseProducto(),isDeep,deepLoadType,clases);
				

		EfectoProductoDataAccess.save(parametroinventariodefecto.getEfectoProducto(),connexion);
		EfectoProductoLogic efectoproductoLogic= new EfectoProductoLogic(connexion);
		efectoproductoLogic.deepLoad(parametroinventariodefecto.getEfectoProducto(),isDeep,deepLoadType,clases);
				

		MarcaProductoDataAccess.save(parametroinventariodefecto.getMarcaProducto(),connexion);
		MarcaProductoLogic marcaproductoLogic= new MarcaProductoLogic(connexion);
		marcaproductoLogic.deepLoad(parametroinventariodefecto.getMarcaProducto(),isDeep,deepLoadType,clases);
				

		ModeloProductoDataAccess.save(parametroinventariodefecto.getModeloProducto(),connexion);
		ModeloProductoLogic modeloproductoLogic= new ModeloProductoLogic(connexion);
		modeloproductoLogic.deepLoad(parametroinventariodefecto.getModeloProducto(),isDeep,deepLoadType,clases);
				

		MaterialProductoDataAccess.save(parametroinventariodefecto.getMaterialProducto(),connexion);
		MaterialProductoLogic materialproductoLogic= new MaterialProductoLogic(connexion);
		materialproductoLogic.deepLoad(parametroinventariodefecto.getMaterialProducto(),isDeep,deepLoadType,clases);
				

		SegmentoProductoDataAccess.save(parametroinventariodefecto.getSegmentoProducto(),connexion);
		SegmentoProductoLogic segmentoproductoLogic= new SegmentoProductoLogic(connexion);
		segmentoproductoLogic.deepLoad(parametroinventariodefecto.getSegmentoProducto(),isDeep,deepLoadType,clases);
				

		TallaProductoDataAccess.save(parametroinventariodefecto.getTallaProducto(),connexion);
		TallaProductoLogic tallaproductoLogic= new TallaProductoLogic(connexion);
		tallaproductoLogic.deepLoad(parametroinventariodefecto.getTallaProducto(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(parametroinventariodefecto.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(parametroinventariodefecto.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(parametroinventariodefecto.getSucursal(),connexion);
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepSave(parametroinventariodefecto.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(GrupoBodega.class)) {
				GrupoBodegaDataAccess.save(parametroinventariodefecto.getGrupoBodega(),connexion);
				GrupoBodegaLogic grupobodegaLogic= new GrupoBodegaLogic(connexion);
				grupobodegaLogic.deepSave(parametroinventariodefecto.getGrupoBodega(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CalidadProducto.class)) {
				CalidadProductoDataAccess.save(parametroinventariodefecto.getCalidadProducto(),connexion);
				CalidadProductoLogic calidadproductoLogic= new CalidadProductoLogic(connexion);
				calidadproductoLogic.deepSave(parametroinventariodefecto.getCalidadProducto(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoServicio.class)) {
				TipoServicioDataAccess.save(parametroinventariodefecto.getTipoServicio(),connexion);
				TipoServicioLogic tiposervicioLogic= new TipoServicioLogic(connexion);
				tiposervicioLogic.deepSave(parametroinventariodefecto.getTipoServicio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoProductoServicioInven.class)) {
				TipoProductoServicioInvenDataAccess.save(parametroinventariodefecto.getTipoProductoServicioInven(),connexion);
				TipoProductoServicioInvenLogic tipoproductoservicioinvenLogic= new TipoProductoServicioInvenLogic(connexion);
				tipoproductoservicioinvenLogic.deepSave(parametroinventariodefecto.getTipoProductoServicioInven(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoProductoServicio.class)) {
				TipoProductoServicioDataAccess.save(parametroinventariodefecto.getTipoProductoServicio(),connexion);
				TipoProductoServicioLogic tipoproductoservicioLogic= new TipoProductoServicioLogic(connexion);
				tipoproductoservicioLogic.deepSave(parametroinventariodefecto.getTipoProductoServicio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoCosteo.class)) {
				TipoCosteoDataAccess.save(parametroinventariodefecto.getTipoCosteo(),connexion);
				TipoCosteoLogic tipocosteoLogic= new TipoCosteoLogic(connexion);
				tipocosteoLogic.deepSave(parametroinventariodefecto.getTipoCosteo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoProducto.class)) {
				TipoProductoDataAccess.save(parametroinventariodefecto.getTipoProducto(),connexion);
				TipoProductoLogic tipoproductoLogic= new TipoProductoLogic(connexion);
				tipoproductoLogic.deepSave(parametroinventariodefecto.getTipoProducto(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoViaTransporte.class)) {
				TipoViaTransporteDataAccess.save(parametroinventariodefecto.getTipoViaTransporte(),connexion);
				TipoViaTransporteLogic tipoviatransporteLogic= new TipoViaTransporteLogic(connexion);
				tipoviatransporteLogic.deepSave(parametroinventariodefecto.getTipoViaTransporte(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(RangoUnidadVenta.class)) {
				RangoUnidadVentaDataAccess.save(parametroinventariodefecto.getRangoUnidadVenta(),connexion);
				RangoUnidadVentaLogic rangounidadventaLogic= new RangoUnidadVentaLogic(connexion);
				rangounidadventaLogic.deepSave(parametroinventariodefecto.getRangoUnidadVenta(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Pais.class)) {
				PaisDataAccess.save(parametroinventariodefecto.getPais(),connexion);
				PaisLogic paisLogic= new PaisLogic(connexion);
				paisLogic.deepSave(parametroinventariodefecto.getPais(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Ciudad.class)) {
				CiudadDataAccess.save(parametroinventariodefecto.getCiudad(),connexion);
				CiudadLogic ciudadLogic= new CiudadLogic(connexion);
				ciudadLogic.deepSave(parametroinventariodefecto.getCiudad(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(ColorProducto.class)) {
				ColorProductoDataAccess.save(parametroinventariodefecto.getColorProducto(),connexion);
				ColorProductoLogic colorproductoLogic= new ColorProductoLogic(connexion);
				colorproductoLogic.deepSave(parametroinventariodefecto.getColorProducto(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(ClaseProducto.class)) {
				ClaseProductoDataAccess.save(parametroinventariodefecto.getClaseProducto(),connexion);
				ClaseProductoLogic claseproductoLogic= new ClaseProductoLogic(connexion);
				claseproductoLogic.deepSave(parametroinventariodefecto.getClaseProducto(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(EfectoProducto.class)) {
				EfectoProductoDataAccess.save(parametroinventariodefecto.getEfectoProducto(),connexion);
				EfectoProductoLogic efectoproductoLogic= new EfectoProductoLogic(connexion);
				efectoproductoLogic.deepSave(parametroinventariodefecto.getEfectoProducto(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(MarcaProducto.class)) {
				MarcaProductoDataAccess.save(parametroinventariodefecto.getMarcaProducto(),connexion);
				MarcaProductoLogic marcaproductoLogic= new MarcaProductoLogic(connexion);
				marcaproductoLogic.deepSave(parametroinventariodefecto.getMarcaProducto(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(ModeloProducto.class)) {
				ModeloProductoDataAccess.save(parametroinventariodefecto.getModeloProducto(),connexion);
				ModeloProductoLogic modeloproductoLogic= new ModeloProductoLogic(connexion);
				modeloproductoLogic.deepSave(parametroinventariodefecto.getModeloProducto(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(MaterialProducto.class)) {
				MaterialProductoDataAccess.save(parametroinventariodefecto.getMaterialProducto(),connexion);
				MaterialProductoLogic materialproductoLogic= new MaterialProductoLogic(connexion);
				materialproductoLogic.deepSave(parametroinventariodefecto.getMaterialProducto(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(SegmentoProducto.class)) {
				SegmentoProductoDataAccess.save(parametroinventariodefecto.getSegmentoProducto(),connexion);
				SegmentoProductoLogic segmentoproductoLogic= new SegmentoProductoLogic(connexion);
				segmentoproductoLogic.deepSave(parametroinventariodefecto.getSegmentoProducto(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TallaProducto.class)) {
				TallaProductoDataAccess.save(parametroinventariodefecto.getTallaProducto(),connexion);
				TallaProductoLogic tallaproductoLogic= new TallaProductoLogic(connexion);
				tallaproductoLogic.deepSave(parametroinventariodefecto.getTallaProducto(),isDeep,deepLoadType,clases);				
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
			this.getNewConnexionToDeep(ParametroInventarioDefecto.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(parametroinventariodefecto,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				ParametroInventarioDefectoConstantesFunciones.refrescarForeignKeysDescripcionesParametroInventarioDefecto(parametroinventariodefecto);
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
			this.deepLoad(this.parametroinventariodefecto,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				ParametroInventarioDefectoConstantesFunciones.refrescarForeignKeysDescripcionesParametroInventarioDefecto(this.parametroinventariodefecto);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(ParametroInventarioDefecto.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(parametroinventariodefectos!=null) {
				for(ParametroInventarioDefecto parametroinventariodefecto:parametroinventariodefectos) {
					this.deepLoad(parametroinventariodefecto,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					ParametroInventarioDefectoConstantesFunciones.refrescarForeignKeysDescripcionesParametroInventarioDefecto(parametroinventariodefectos);
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
			if(parametroinventariodefectos!=null) {
				for(ParametroInventarioDefecto parametroinventariodefecto:parametroinventariodefectos) {
					this.deepLoad(parametroinventariodefecto,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					ParametroInventarioDefectoConstantesFunciones.refrescarForeignKeysDescripcionesParametroInventarioDefecto(parametroinventariodefectos);
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
			this.getNewConnexionToDeep(ParametroInventarioDefecto.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(parametroinventariodefecto,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(ParametroInventarioDefecto.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(parametroinventariodefectos!=null) {
				for(ParametroInventarioDefecto parametroinventariodefecto:parametroinventariodefectos) {
					this.deepSave(parametroinventariodefecto,isDeep,deepLoadType,clases);
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
			if(parametroinventariodefectos!=null) {
				for(ParametroInventarioDefecto parametroinventariodefecto:parametroinventariodefectos) {
					this.deepSave(parametroinventariodefecto,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getParametroInventarioDefectosFK_IdCalidadProductoWithConnection(String sFinalQuery,Pagination pagination,Long id_calidad_producto)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroInventarioDefecto.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCalidadProducto= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCalidadProducto.setParameterSelectionGeneralEqual(ParameterType.LONG,id_calidad_producto,ParametroInventarioDefectoConstantesFunciones.IDCALIDADPRODUCTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCalidadProducto);

			ParametroInventarioDefectoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCalidadProducto","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametroinventariodefectos=parametroinventariodefectoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroInventarioDefectoConstantesFunciones.refrescarForeignKeysDescripcionesParametroInventarioDefecto(this.parametroinventariodefectos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getParametroInventarioDefectosFK_IdCalidadProducto(String sFinalQuery,Pagination pagination,Long id_calidad_producto)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCalidadProducto= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCalidadProducto.setParameterSelectionGeneralEqual(ParameterType.LONG,id_calidad_producto,ParametroInventarioDefectoConstantesFunciones.IDCALIDADPRODUCTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCalidadProducto);

			ParametroInventarioDefectoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCalidadProducto","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametroinventariodefectos=parametroinventariodefectoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroInventarioDefectoConstantesFunciones.refrescarForeignKeysDescripcionesParametroInventarioDefecto(this.parametroinventariodefectos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getParametroInventarioDefectosFK_IdCiudadWithConnection(String sFinalQuery,Pagination pagination,Long id_ciudad)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroInventarioDefecto.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCiudad= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCiudad.setParameterSelectionGeneralEqual(ParameterType.LONG,id_ciudad,ParametroInventarioDefectoConstantesFunciones.IDCIUDAD,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCiudad);

			ParametroInventarioDefectoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCiudad","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametroinventariodefectos=parametroinventariodefectoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroInventarioDefectoConstantesFunciones.refrescarForeignKeysDescripcionesParametroInventarioDefecto(this.parametroinventariodefectos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getParametroInventarioDefectosFK_IdCiudad(String sFinalQuery,Pagination pagination,Long id_ciudad)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCiudad= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCiudad.setParameterSelectionGeneralEqual(ParameterType.LONG,id_ciudad,ParametroInventarioDefectoConstantesFunciones.IDCIUDAD,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCiudad);

			ParametroInventarioDefectoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCiudad","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametroinventariodefectos=parametroinventariodefectoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroInventarioDefectoConstantesFunciones.refrescarForeignKeysDescripcionesParametroInventarioDefecto(this.parametroinventariodefectos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getParametroInventarioDefectosFK_IdClaseProductoWithConnection(String sFinalQuery,Pagination pagination,Long id_clase_producto)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroInventarioDefecto.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidClaseProducto= new ParameterSelectionGeneral();
			parameterSelectionGeneralidClaseProducto.setParameterSelectionGeneralEqual(ParameterType.LONG,id_clase_producto,ParametroInventarioDefectoConstantesFunciones.IDCLASEPRODUCTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidClaseProducto);

			ParametroInventarioDefectoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdClaseProducto","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametroinventariodefectos=parametroinventariodefectoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroInventarioDefectoConstantesFunciones.refrescarForeignKeysDescripcionesParametroInventarioDefecto(this.parametroinventariodefectos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getParametroInventarioDefectosFK_IdClaseProducto(String sFinalQuery,Pagination pagination,Long id_clase_producto)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidClaseProducto= new ParameterSelectionGeneral();
			parameterSelectionGeneralidClaseProducto.setParameterSelectionGeneralEqual(ParameterType.LONG,id_clase_producto,ParametroInventarioDefectoConstantesFunciones.IDCLASEPRODUCTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidClaseProducto);

			ParametroInventarioDefectoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdClaseProducto","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametroinventariodefectos=parametroinventariodefectoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroInventarioDefectoConstantesFunciones.refrescarForeignKeysDescripcionesParametroInventarioDefecto(this.parametroinventariodefectos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getParametroInventarioDefectosFK_IdColorProductoWithConnection(String sFinalQuery,Pagination pagination,Long id_color_producto)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroInventarioDefecto.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidColorProducto= new ParameterSelectionGeneral();
			parameterSelectionGeneralidColorProducto.setParameterSelectionGeneralEqual(ParameterType.LONG,id_color_producto,ParametroInventarioDefectoConstantesFunciones.IDCOLORPRODUCTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidColorProducto);

			ParametroInventarioDefectoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdColorProducto","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametroinventariodefectos=parametroinventariodefectoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroInventarioDefectoConstantesFunciones.refrescarForeignKeysDescripcionesParametroInventarioDefecto(this.parametroinventariodefectos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getParametroInventarioDefectosFK_IdColorProducto(String sFinalQuery,Pagination pagination,Long id_color_producto)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidColorProducto= new ParameterSelectionGeneral();
			parameterSelectionGeneralidColorProducto.setParameterSelectionGeneralEqual(ParameterType.LONG,id_color_producto,ParametroInventarioDefectoConstantesFunciones.IDCOLORPRODUCTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidColorProducto);

			ParametroInventarioDefectoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdColorProducto","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametroinventariodefectos=parametroinventariodefectoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroInventarioDefectoConstantesFunciones.refrescarForeignKeysDescripcionesParametroInventarioDefecto(this.parametroinventariodefectos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getParametroInventarioDefectosFK_IdEfectoProductoWithConnection(String sFinalQuery,Pagination pagination,Long id_efecto_producto)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroInventarioDefecto.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEfectoProducto= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEfectoProducto.setParameterSelectionGeneralEqual(ParameterType.LONG,id_efecto_producto,ParametroInventarioDefectoConstantesFunciones.IDEFECTOPRODUCTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEfectoProducto);

			ParametroInventarioDefectoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEfectoProducto","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametroinventariodefectos=parametroinventariodefectoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroInventarioDefectoConstantesFunciones.refrescarForeignKeysDescripcionesParametroInventarioDefecto(this.parametroinventariodefectos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getParametroInventarioDefectosFK_IdEfectoProducto(String sFinalQuery,Pagination pagination,Long id_efecto_producto)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEfectoProducto= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEfectoProducto.setParameterSelectionGeneralEqual(ParameterType.LONG,id_efecto_producto,ParametroInventarioDefectoConstantesFunciones.IDEFECTOPRODUCTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEfectoProducto);

			ParametroInventarioDefectoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEfectoProducto","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametroinventariodefectos=parametroinventariodefectoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroInventarioDefectoConstantesFunciones.refrescarForeignKeysDescripcionesParametroInventarioDefecto(this.parametroinventariodefectos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getParametroInventarioDefectosFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroInventarioDefecto.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,ParametroInventarioDefectoConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			ParametroInventarioDefectoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametroinventariodefectos=parametroinventariodefectoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroInventarioDefectoConstantesFunciones.refrescarForeignKeysDescripcionesParametroInventarioDefecto(this.parametroinventariodefectos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getParametroInventarioDefectosFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,ParametroInventarioDefectoConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			ParametroInventarioDefectoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametroinventariodefectos=parametroinventariodefectoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroInventarioDefectoConstantesFunciones.refrescarForeignKeysDescripcionesParametroInventarioDefecto(this.parametroinventariodefectos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getParametroInventarioDefectosFK_IdGrupoBodegaWithConnection(String sFinalQuery,Pagination pagination,Long id_grupo_bodega)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroInventarioDefecto.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidGrupoBodega= new ParameterSelectionGeneral();
			parameterSelectionGeneralidGrupoBodega.setParameterSelectionGeneralEqual(ParameterType.LONG,id_grupo_bodega,ParametroInventarioDefectoConstantesFunciones.IDGRUPOBODEGA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidGrupoBodega);

			ParametroInventarioDefectoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdGrupoBodega","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametroinventariodefectos=parametroinventariodefectoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroInventarioDefectoConstantesFunciones.refrescarForeignKeysDescripcionesParametroInventarioDefecto(this.parametroinventariodefectos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getParametroInventarioDefectosFK_IdGrupoBodega(String sFinalQuery,Pagination pagination,Long id_grupo_bodega)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidGrupoBodega= new ParameterSelectionGeneral();
			parameterSelectionGeneralidGrupoBodega.setParameterSelectionGeneralEqual(ParameterType.LONG,id_grupo_bodega,ParametroInventarioDefectoConstantesFunciones.IDGRUPOBODEGA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidGrupoBodega);

			ParametroInventarioDefectoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdGrupoBodega","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametroinventariodefectos=parametroinventariodefectoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroInventarioDefectoConstantesFunciones.refrescarForeignKeysDescripcionesParametroInventarioDefecto(this.parametroinventariodefectos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getParametroInventarioDefectosFK_IdMarcaProductoWithConnection(String sFinalQuery,Pagination pagination,Long id_marca_producto)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroInventarioDefecto.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidMarcaProducto= new ParameterSelectionGeneral();
			parameterSelectionGeneralidMarcaProducto.setParameterSelectionGeneralEqual(ParameterType.LONG,id_marca_producto,ParametroInventarioDefectoConstantesFunciones.IDMARCAPRODUCTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidMarcaProducto);

			ParametroInventarioDefectoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdMarcaProducto","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametroinventariodefectos=parametroinventariodefectoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroInventarioDefectoConstantesFunciones.refrescarForeignKeysDescripcionesParametroInventarioDefecto(this.parametroinventariodefectos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getParametroInventarioDefectosFK_IdMarcaProducto(String sFinalQuery,Pagination pagination,Long id_marca_producto)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidMarcaProducto= new ParameterSelectionGeneral();
			parameterSelectionGeneralidMarcaProducto.setParameterSelectionGeneralEqual(ParameterType.LONG,id_marca_producto,ParametroInventarioDefectoConstantesFunciones.IDMARCAPRODUCTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidMarcaProducto);

			ParametroInventarioDefectoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdMarcaProducto","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametroinventariodefectos=parametroinventariodefectoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroInventarioDefectoConstantesFunciones.refrescarForeignKeysDescripcionesParametroInventarioDefecto(this.parametroinventariodefectos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getParametroInventarioDefectosFK_IdMaterialProductoWithConnection(String sFinalQuery,Pagination pagination,Long id_material_producto)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroInventarioDefecto.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidMaterialProducto= new ParameterSelectionGeneral();
			parameterSelectionGeneralidMaterialProducto.setParameterSelectionGeneralEqual(ParameterType.LONG,id_material_producto,ParametroInventarioDefectoConstantesFunciones.IDMATERIALPRODUCTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidMaterialProducto);

			ParametroInventarioDefectoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdMaterialProducto","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametroinventariodefectos=parametroinventariodefectoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroInventarioDefectoConstantesFunciones.refrescarForeignKeysDescripcionesParametroInventarioDefecto(this.parametroinventariodefectos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getParametroInventarioDefectosFK_IdMaterialProducto(String sFinalQuery,Pagination pagination,Long id_material_producto)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidMaterialProducto= new ParameterSelectionGeneral();
			parameterSelectionGeneralidMaterialProducto.setParameterSelectionGeneralEqual(ParameterType.LONG,id_material_producto,ParametroInventarioDefectoConstantesFunciones.IDMATERIALPRODUCTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidMaterialProducto);

			ParametroInventarioDefectoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdMaterialProducto","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametroinventariodefectos=parametroinventariodefectoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroInventarioDefectoConstantesFunciones.refrescarForeignKeysDescripcionesParametroInventarioDefecto(this.parametroinventariodefectos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getParametroInventarioDefectosFK_IdModeloProductoWithConnection(String sFinalQuery,Pagination pagination,Long id_modelo_producto)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroInventarioDefecto.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidModeloProducto= new ParameterSelectionGeneral();
			parameterSelectionGeneralidModeloProducto.setParameterSelectionGeneralEqual(ParameterType.LONG,id_modelo_producto,ParametroInventarioDefectoConstantesFunciones.IDMODELOPRODUCTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidModeloProducto);

			ParametroInventarioDefectoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdModeloProducto","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametroinventariodefectos=parametroinventariodefectoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroInventarioDefectoConstantesFunciones.refrescarForeignKeysDescripcionesParametroInventarioDefecto(this.parametroinventariodefectos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getParametroInventarioDefectosFK_IdModeloProducto(String sFinalQuery,Pagination pagination,Long id_modelo_producto)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidModeloProducto= new ParameterSelectionGeneral();
			parameterSelectionGeneralidModeloProducto.setParameterSelectionGeneralEqual(ParameterType.LONG,id_modelo_producto,ParametroInventarioDefectoConstantesFunciones.IDMODELOPRODUCTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidModeloProducto);

			ParametroInventarioDefectoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdModeloProducto","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametroinventariodefectos=parametroinventariodefectoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroInventarioDefectoConstantesFunciones.refrescarForeignKeysDescripcionesParametroInventarioDefecto(this.parametroinventariodefectos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getParametroInventarioDefectosFK_IdPaisWithConnection(String sFinalQuery,Pagination pagination,Long id_pais)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroInventarioDefecto.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPais= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPais.setParameterSelectionGeneralEqual(ParameterType.LONG,id_pais,ParametroInventarioDefectoConstantesFunciones.IDPAIS,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPais);

			ParametroInventarioDefectoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPais","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametroinventariodefectos=parametroinventariodefectoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroInventarioDefectoConstantesFunciones.refrescarForeignKeysDescripcionesParametroInventarioDefecto(this.parametroinventariodefectos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getParametroInventarioDefectosFK_IdPais(String sFinalQuery,Pagination pagination,Long id_pais)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPais= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPais.setParameterSelectionGeneralEqual(ParameterType.LONG,id_pais,ParametroInventarioDefectoConstantesFunciones.IDPAIS,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPais);

			ParametroInventarioDefectoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPais","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametroinventariodefectos=parametroinventariodefectoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroInventarioDefectoConstantesFunciones.refrescarForeignKeysDescripcionesParametroInventarioDefecto(this.parametroinventariodefectos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getParametroInventarioDefectosFK_IdRangoUnidadVentaWithConnection(String sFinalQuery,Pagination pagination,Long id_rango_unidad_venta)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroInventarioDefecto.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidRangoUnidadVenta= new ParameterSelectionGeneral();
			parameterSelectionGeneralidRangoUnidadVenta.setParameterSelectionGeneralEqual(ParameterType.LONG,id_rango_unidad_venta,ParametroInventarioDefectoConstantesFunciones.IDRANGOUNIDADVENTA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidRangoUnidadVenta);

			ParametroInventarioDefectoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdRangoUnidadVenta","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametroinventariodefectos=parametroinventariodefectoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroInventarioDefectoConstantesFunciones.refrescarForeignKeysDescripcionesParametroInventarioDefecto(this.parametroinventariodefectos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getParametroInventarioDefectosFK_IdRangoUnidadVenta(String sFinalQuery,Pagination pagination,Long id_rango_unidad_venta)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidRangoUnidadVenta= new ParameterSelectionGeneral();
			parameterSelectionGeneralidRangoUnidadVenta.setParameterSelectionGeneralEqual(ParameterType.LONG,id_rango_unidad_venta,ParametroInventarioDefectoConstantesFunciones.IDRANGOUNIDADVENTA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidRangoUnidadVenta);

			ParametroInventarioDefectoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdRangoUnidadVenta","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametroinventariodefectos=parametroinventariodefectoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroInventarioDefectoConstantesFunciones.refrescarForeignKeysDescripcionesParametroInventarioDefecto(this.parametroinventariodefectos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getParametroInventarioDefectosFK_IdSegmentoProductoWithConnection(String sFinalQuery,Pagination pagination,Long id_segmento_producto)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroInventarioDefecto.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSegmentoProducto= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSegmentoProducto.setParameterSelectionGeneralEqual(ParameterType.LONG,id_segmento_producto,ParametroInventarioDefectoConstantesFunciones.IDSEGMENTOPRODUCTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSegmentoProducto);

			ParametroInventarioDefectoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSegmentoProducto","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametroinventariodefectos=parametroinventariodefectoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroInventarioDefectoConstantesFunciones.refrescarForeignKeysDescripcionesParametroInventarioDefecto(this.parametroinventariodefectos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getParametroInventarioDefectosFK_IdSegmentoProducto(String sFinalQuery,Pagination pagination,Long id_segmento_producto)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSegmentoProducto= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSegmentoProducto.setParameterSelectionGeneralEqual(ParameterType.LONG,id_segmento_producto,ParametroInventarioDefectoConstantesFunciones.IDSEGMENTOPRODUCTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSegmentoProducto);

			ParametroInventarioDefectoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSegmentoProducto","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametroinventariodefectos=parametroinventariodefectoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroInventarioDefectoConstantesFunciones.refrescarForeignKeysDescripcionesParametroInventarioDefecto(this.parametroinventariodefectos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getParametroInventarioDefectosFK_IdSucursalWithConnection(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroInventarioDefecto.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,ParametroInventarioDefectoConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			ParametroInventarioDefectoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametroinventariodefectos=parametroinventariodefectoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroInventarioDefectoConstantesFunciones.refrescarForeignKeysDescripcionesParametroInventarioDefecto(this.parametroinventariodefectos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getParametroInventarioDefectosFK_IdSucursal(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,ParametroInventarioDefectoConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			ParametroInventarioDefectoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametroinventariodefectos=parametroinventariodefectoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroInventarioDefectoConstantesFunciones.refrescarForeignKeysDescripcionesParametroInventarioDefecto(this.parametroinventariodefectos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getParametroInventarioDefectosFK_IdTallaProductoWithConnection(String sFinalQuery,Pagination pagination,Long id_talla_producto)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroInventarioDefecto.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTallaProducto= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTallaProducto.setParameterSelectionGeneralEqual(ParameterType.LONG,id_talla_producto,ParametroInventarioDefectoConstantesFunciones.IDTALLAPRODUCTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTallaProducto);

			ParametroInventarioDefectoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTallaProducto","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametroinventariodefectos=parametroinventariodefectoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroInventarioDefectoConstantesFunciones.refrescarForeignKeysDescripcionesParametroInventarioDefecto(this.parametroinventariodefectos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getParametroInventarioDefectosFK_IdTallaProducto(String sFinalQuery,Pagination pagination,Long id_talla_producto)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTallaProducto= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTallaProducto.setParameterSelectionGeneralEqual(ParameterType.LONG,id_talla_producto,ParametroInventarioDefectoConstantesFunciones.IDTALLAPRODUCTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTallaProducto);

			ParametroInventarioDefectoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTallaProducto","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametroinventariodefectos=parametroinventariodefectoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroInventarioDefectoConstantesFunciones.refrescarForeignKeysDescripcionesParametroInventarioDefecto(this.parametroinventariodefectos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getParametroInventarioDefectosFK_IdTipoCosteoWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_costeo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroInventarioDefecto.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoCosteo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoCosteo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_costeo,ParametroInventarioDefectoConstantesFunciones.IDTIPOCOSTEO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoCosteo);

			ParametroInventarioDefectoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoCosteo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametroinventariodefectos=parametroinventariodefectoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroInventarioDefectoConstantesFunciones.refrescarForeignKeysDescripcionesParametroInventarioDefecto(this.parametroinventariodefectos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getParametroInventarioDefectosFK_IdTipoCosteo(String sFinalQuery,Pagination pagination,Long id_tipo_costeo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoCosteo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoCosteo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_costeo,ParametroInventarioDefectoConstantesFunciones.IDTIPOCOSTEO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoCosteo);

			ParametroInventarioDefectoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoCosteo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametroinventariodefectos=parametroinventariodefectoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroInventarioDefectoConstantesFunciones.refrescarForeignKeysDescripcionesParametroInventarioDefecto(this.parametroinventariodefectos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getParametroInventarioDefectosFK_IdTipoProductoWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_producto)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroInventarioDefecto.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoProducto= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoProducto.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_producto,ParametroInventarioDefectoConstantesFunciones.IDTIPOPRODUCTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoProducto);

			ParametroInventarioDefectoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoProducto","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametroinventariodefectos=parametroinventariodefectoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroInventarioDefectoConstantesFunciones.refrescarForeignKeysDescripcionesParametroInventarioDefecto(this.parametroinventariodefectos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getParametroInventarioDefectosFK_IdTipoProducto(String sFinalQuery,Pagination pagination,Long id_tipo_producto)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoProducto= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoProducto.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_producto,ParametroInventarioDefectoConstantesFunciones.IDTIPOPRODUCTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoProducto);

			ParametroInventarioDefectoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoProducto","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametroinventariodefectos=parametroinventariodefectoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroInventarioDefectoConstantesFunciones.refrescarForeignKeysDescripcionesParametroInventarioDefecto(this.parametroinventariodefectos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getParametroInventarioDefectosFK_IdTipoProductoServicioWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_producto_servicio)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroInventarioDefecto.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoProductoServicio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoProductoServicio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_producto_servicio,ParametroInventarioDefectoConstantesFunciones.IDTIPOPRODUCTOSERVICIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoProductoServicio);

			ParametroInventarioDefectoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoProductoServicio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametroinventariodefectos=parametroinventariodefectoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroInventarioDefectoConstantesFunciones.refrescarForeignKeysDescripcionesParametroInventarioDefecto(this.parametroinventariodefectos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getParametroInventarioDefectosFK_IdTipoProductoServicio(String sFinalQuery,Pagination pagination,Long id_tipo_producto_servicio)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoProductoServicio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoProductoServicio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_producto_servicio,ParametroInventarioDefectoConstantesFunciones.IDTIPOPRODUCTOSERVICIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoProductoServicio);

			ParametroInventarioDefectoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoProductoServicio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametroinventariodefectos=parametroinventariodefectoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroInventarioDefectoConstantesFunciones.refrescarForeignKeysDescripcionesParametroInventarioDefecto(this.parametroinventariodefectos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getParametroInventarioDefectosFK_IdTipoProductoServicioInvenWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_producto_servicio_inven)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroInventarioDefecto.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoProductoServicioInven= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoProductoServicioInven.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_producto_servicio_inven,ParametroInventarioDefectoConstantesFunciones.IDTIPOPRODUCTOSERVICIOINVEN,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoProductoServicioInven);

			ParametroInventarioDefectoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoProductoServicioInven","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametroinventariodefectos=parametroinventariodefectoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroInventarioDefectoConstantesFunciones.refrescarForeignKeysDescripcionesParametroInventarioDefecto(this.parametroinventariodefectos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getParametroInventarioDefectosFK_IdTipoProductoServicioInven(String sFinalQuery,Pagination pagination,Long id_tipo_producto_servicio_inven)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoProductoServicioInven= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoProductoServicioInven.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_producto_servicio_inven,ParametroInventarioDefectoConstantesFunciones.IDTIPOPRODUCTOSERVICIOINVEN,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoProductoServicioInven);

			ParametroInventarioDefectoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoProductoServicioInven","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametroinventariodefectos=parametroinventariodefectoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroInventarioDefectoConstantesFunciones.refrescarForeignKeysDescripcionesParametroInventarioDefecto(this.parametroinventariodefectos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getParametroInventarioDefectosFK_IdTipoServicioWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_servicio)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroInventarioDefecto.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoServicio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoServicio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_servicio,ParametroInventarioDefectoConstantesFunciones.IDTIPOSERVICIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoServicio);

			ParametroInventarioDefectoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoServicio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametroinventariodefectos=parametroinventariodefectoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroInventarioDefectoConstantesFunciones.refrescarForeignKeysDescripcionesParametroInventarioDefecto(this.parametroinventariodefectos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getParametroInventarioDefectosFK_IdTipoServicio(String sFinalQuery,Pagination pagination,Long id_tipo_servicio)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoServicio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoServicio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_servicio,ParametroInventarioDefectoConstantesFunciones.IDTIPOSERVICIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoServicio);

			ParametroInventarioDefectoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoServicio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametroinventariodefectos=parametroinventariodefectoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroInventarioDefectoConstantesFunciones.refrescarForeignKeysDescripcionesParametroInventarioDefecto(this.parametroinventariodefectos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getParametroInventarioDefectosFK_IdTipoViaTransporteWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_via_transporte)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroInventarioDefecto.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoViaTransporte= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoViaTransporte.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_via_transporte,ParametroInventarioDefectoConstantesFunciones.IDTIPOVIATRANSPORTE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoViaTransporte);

			ParametroInventarioDefectoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoViaTransporte","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametroinventariodefectos=parametroinventariodefectoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroInventarioDefectoConstantesFunciones.refrescarForeignKeysDescripcionesParametroInventarioDefecto(this.parametroinventariodefectos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getParametroInventarioDefectosFK_IdTipoViaTransporte(String sFinalQuery,Pagination pagination,Long id_tipo_via_transporte)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoViaTransporte= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoViaTransporte.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_via_transporte,ParametroInventarioDefectoConstantesFunciones.IDTIPOVIATRANSPORTE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoViaTransporte);

			ParametroInventarioDefectoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoViaTransporte","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametroinventariodefectos=parametroinventariodefectoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroInventarioDefectoConstantesFunciones.refrescarForeignKeysDescripcionesParametroInventarioDefecto(this.parametroinventariodefectos);
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
			if(ParametroInventarioDefectoConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,ParametroInventarioDefectoDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,ParametroInventarioDefecto parametroinventariodefecto,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(ParametroInventarioDefectoConstantesFunciones.ISCONAUDITORIA) {
				if(parametroinventariodefecto.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,ParametroInventarioDefectoDataAccess.TABLENAME, parametroinventariodefecto.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(ParametroInventarioDefectoConstantesFunciones.ISCONAUDITORIADETALLE) {
						////ParametroInventarioDefectoLogic.registrarAuditoriaDetallesParametroInventarioDefecto(connexion,parametroinventariodefecto,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(parametroinventariodefecto.getIsDeleted()) {
					/*if(!parametroinventariodefecto.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,ParametroInventarioDefectoDataAccess.TABLENAME, parametroinventariodefecto.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////ParametroInventarioDefectoLogic.registrarAuditoriaDetallesParametroInventarioDefecto(connexion,parametroinventariodefecto,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,ParametroInventarioDefectoDataAccess.TABLENAME, parametroinventariodefecto.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(parametroinventariodefecto.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,ParametroInventarioDefectoDataAccess.TABLENAME, parametroinventariodefecto.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(ParametroInventarioDefectoConstantesFunciones.ISCONAUDITORIADETALLE) {
						////ParametroInventarioDefectoLogic.registrarAuditoriaDetallesParametroInventarioDefecto(connexion,parametroinventariodefecto,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesParametroInventarioDefecto(Connexion connexion,ParametroInventarioDefecto parametroinventariodefecto)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(parametroinventariodefecto.getIsNew()||!parametroinventariodefecto.getid_empresa().equals(parametroinventariodefecto.getParametroInventarioDefectoOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametroinventariodefecto.getParametroInventarioDefectoOriginal().getid_empresa()!=null)
				{
					strValorActual=parametroinventariodefecto.getParametroInventarioDefectoOriginal().getid_empresa().toString();
				}
				if(parametroinventariodefecto.getid_empresa()!=null)
				{
					strValorNuevo=parametroinventariodefecto.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroInventarioDefectoConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(parametroinventariodefecto.getIsNew()||!parametroinventariodefecto.getid_sucursal().equals(parametroinventariodefecto.getParametroInventarioDefectoOriginal().getid_sucursal()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametroinventariodefecto.getParametroInventarioDefectoOriginal().getid_sucursal()!=null)
				{
					strValorActual=parametroinventariodefecto.getParametroInventarioDefectoOriginal().getid_sucursal().toString();
				}
				if(parametroinventariodefecto.getid_sucursal()!=null)
				{
					strValorNuevo=parametroinventariodefecto.getid_sucursal().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroInventarioDefectoConstantesFunciones.IDSUCURSAL,strValorActual,strValorNuevo);
			}	
			
			if(parametroinventariodefecto.getIsNew()||!parametroinventariodefecto.getid_grupo_bodega().equals(parametroinventariodefecto.getParametroInventarioDefectoOriginal().getid_grupo_bodega()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametroinventariodefecto.getParametroInventarioDefectoOriginal().getid_grupo_bodega()!=null)
				{
					strValorActual=parametroinventariodefecto.getParametroInventarioDefectoOriginal().getid_grupo_bodega().toString();
				}
				if(parametroinventariodefecto.getid_grupo_bodega()!=null)
				{
					strValorNuevo=parametroinventariodefecto.getid_grupo_bodega().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroInventarioDefectoConstantesFunciones.IDGRUPOBODEGA,strValorActual,strValorNuevo);
			}	
			
			if(parametroinventariodefecto.getIsNew()||!parametroinventariodefecto.getid_calidad_producto().equals(parametroinventariodefecto.getParametroInventarioDefectoOriginal().getid_calidad_producto()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametroinventariodefecto.getParametroInventarioDefectoOriginal().getid_calidad_producto()!=null)
				{
					strValorActual=parametroinventariodefecto.getParametroInventarioDefectoOriginal().getid_calidad_producto().toString();
				}
				if(parametroinventariodefecto.getid_calidad_producto()!=null)
				{
					strValorNuevo=parametroinventariodefecto.getid_calidad_producto().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroInventarioDefectoConstantesFunciones.IDCALIDADPRODUCTO,strValorActual,strValorNuevo);
			}	
			
			if(parametroinventariodefecto.getIsNew()||!parametroinventariodefecto.getid_tipo_servicio().equals(parametroinventariodefecto.getParametroInventarioDefectoOriginal().getid_tipo_servicio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametroinventariodefecto.getParametroInventarioDefectoOriginal().getid_tipo_servicio()!=null)
				{
					strValorActual=parametroinventariodefecto.getParametroInventarioDefectoOriginal().getid_tipo_servicio().toString();
				}
				if(parametroinventariodefecto.getid_tipo_servicio()!=null)
				{
					strValorNuevo=parametroinventariodefecto.getid_tipo_servicio().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroInventarioDefectoConstantesFunciones.IDTIPOSERVICIO,strValorActual,strValorNuevo);
			}	
			
			if(parametroinventariodefecto.getIsNew()||!parametroinventariodefecto.getid_tipo_producto_servicio_inven().equals(parametroinventariodefecto.getParametroInventarioDefectoOriginal().getid_tipo_producto_servicio_inven()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametroinventariodefecto.getParametroInventarioDefectoOriginal().getid_tipo_producto_servicio_inven()!=null)
				{
					strValorActual=parametroinventariodefecto.getParametroInventarioDefectoOriginal().getid_tipo_producto_servicio_inven().toString();
				}
				if(parametroinventariodefecto.getid_tipo_producto_servicio_inven()!=null)
				{
					strValorNuevo=parametroinventariodefecto.getid_tipo_producto_servicio_inven().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroInventarioDefectoConstantesFunciones.IDTIPOPRODUCTOSERVICIOINVEN,strValorActual,strValorNuevo);
			}	
			
			if(parametroinventariodefecto.getIsNew()||!parametroinventariodefecto.getid_tipo_producto_servicio().equals(parametroinventariodefecto.getParametroInventarioDefectoOriginal().getid_tipo_producto_servicio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametroinventariodefecto.getParametroInventarioDefectoOriginal().getid_tipo_producto_servicio()!=null)
				{
					strValorActual=parametroinventariodefecto.getParametroInventarioDefectoOriginal().getid_tipo_producto_servicio().toString();
				}
				if(parametroinventariodefecto.getid_tipo_producto_servicio()!=null)
				{
					strValorNuevo=parametroinventariodefecto.getid_tipo_producto_servicio().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroInventarioDefectoConstantesFunciones.IDTIPOPRODUCTOSERVICIO,strValorActual,strValorNuevo);
			}	
			
			if(parametroinventariodefecto.getIsNew()||!parametroinventariodefecto.getid_tipo_costeo().equals(parametroinventariodefecto.getParametroInventarioDefectoOriginal().getid_tipo_costeo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametroinventariodefecto.getParametroInventarioDefectoOriginal().getid_tipo_costeo()!=null)
				{
					strValorActual=parametroinventariodefecto.getParametroInventarioDefectoOriginal().getid_tipo_costeo().toString();
				}
				if(parametroinventariodefecto.getid_tipo_costeo()!=null)
				{
					strValorNuevo=parametroinventariodefecto.getid_tipo_costeo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroInventarioDefectoConstantesFunciones.IDTIPOCOSTEO,strValorActual,strValorNuevo);
			}	
			
			if(parametroinventariodefecto.getIsNew()||!parametroinventariodefecto.getid_tipo_producto().equals(parametroinventariodefecto.getParametroInventarioDefectoOriginal().getid_tipo_producto()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametroinventariodefecto.getParametroInventarioDefectoOriginal().getid_tipo_producto()!=null)
				{
					strValorActual=parametroinventariodefecto.getParametroInventarioDefectoOriginal().getid_tipo_producto().toString();
				}
				if(parametroinventariodefecto.getid_tipo_producto()!=null)
				{
					strValorNuevo=parametroinventariodefecto.getid_tipo_producto().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroInventarioDefectoConstantesFunciones.IDTIPOPRODUCTO,strValorActual,strValorNuevo);
			}	
			
			if(parametroinventariodefecto.getIsNew()||!parametroinventariodefecto.getid_tipo_via_transporte().equals(parametroinventariodefecto.getParametroInventarioDefectoOriginal().getid_tipo_via_transporte()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametroinventariodefecto.getParametroInventarioDefectoOriginal().getid_tipo_via_transporte()!=null)
				{
					strValorActual=parametroinventariodefecto.getParametroInventarioDefectoOriginal().getid_tipo_via_transporte().toString();
				}
				if(parametroinventariodefecto.getid_tipo_via_transporte()!=null)
				{
					strValorNuevo=parametroinventariodefecto.getid_tipo_via_transporte().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroInventarioDefectoConstantesFunciones.IDTIPOVIATRANSPORTE,strValorActual,strValorNuevo);
			}	
			
			if(parametroinventariodefecto.getIsNew()||!parametroinventariodefecto.getid_rango_unidad_venta().equals(parametroinventariodefecto.getParametroInventarioDefectoOriginal().getid_rango_unidad_venta()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametroinventariodefecto.getParametroInventarioDefectoOriginal().getid_rango_unidad_venta()!=null)
				{
					strValorActual=parametroinventariodefecto.getParametroInventarioDefectoOriginal().getid_rango_unidad_venta().toString();
				}
				if(parametroinventariodefecto.getid_rango_unidad_venta()!=null)
				{
					strValorNuevo=parametroinventariodefecto.getid_rango_unidad_venta().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroInventarioDefectoConstantesFunciones.IDRANGOUNIDADVENTA,strValorActual,strValorNuevo);
			}	
			
			if(parametroinventariodefecto.getIsNew()||!parametroinventariodefecto.getid_pais().equals(parametroinventariodefecto.getParametroInventarioDefectoOriginal().getid_pais()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametroinventariodefecto.getParametroInventarioDefectoOriginal().getid_pais()!=null)
				{
					strValorActual=parametroinventariodefecto.getParametroInventarioDefectoOriginal().getid_pais().toString();
				}
				if(parametroinventariodefecto.getid_pais()!=null)
				{
					strValorNuevo=parametroinventariodefecto.getid_pais().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroInventarioDefectoConstantesFunciones.IDPAIS,strValorActual,strValorNuevo);
			}	
			
			if(parametroinventariodefecto.getIsNew()||!parametroinventariodefecto.getid_ciudad().equals(parametroinventariodefecto.getParametroInventarioDefectoOriginal().getid_ciudad()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametroinventariodefecto.getParametroInventarioDefectoOriginal().getid_ciudad()!=null)
				{
					strValorActual=parametroinventariodefecto.getParametroInventarioDefectoOriginal().getid_ciudad().toString();
				}
				if(parametroinventariodefecto.getid_ciudad()!=null)
				{
					strValorNuevo=parametroinventariodefecto.getid_ciudad().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroInventarioDefectoConstantesFunciones.IDCIUDAD,strValorActual,strValorNuevo);
			}	
			
			if(parametroinventariodefecto.getIsNew()||!parametroinventariodefecto.getid_color_producto().equals(parametroinventariodefecto.getParametroInventarioDefectoOriginal().getid_color_producto()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametroinventariodefecto.getParametroInventarioDefectoOriginal().getid_color_producto()!=null)
				{
					strValorActual=parametroinventariodefecto.getParametroInventarioDefectoOriginal().getid_color_producto().toString();
				}
				if(parametroinventariodefecto.getid_color_producto()!=null)
				{
					strValorNuevo=parametroinventariodefecto.getid_color_producto().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroInventarioDefectoConstantesFunciones.IDCOLORPRODUCTO,strValorActual,strValorNuevo);
			}	
			
			if(parametroinventariodefecto.getIsNew()||!parametroinventariodefecto.getid_clase_producto().equals(parametroinventariodefecto.getParametroInventarioDefectoOriginal().getid_clase_producto()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametroinventariodefecto.getParametroInventarioDefectoOriginal().getid_clase_producto()!=null)
				{
					strValorActual=parametroinventariodefecto.getParametroInventarioDefectoOriginal().getid_clase_producto().toString();
				}
				if(parametroinventariodefecto.getid_clase_producto()!=null)
				{
					strValorNuevo=parametroinventariodefecto.getid_clase_producto().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroInventarioDefectoConstantesFunciones.IDCLASEPRODUCTO,strValorActual,strValorNuevo);
			}	
			
			if(parametroinventariodefecto.getIsNew()||!parametroinventariodefecto.getid_efecto_producto().equals(parametroinventariodefecto.getParametroInventarioDefectoOriginal().getid_efecto_producto()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametroinventariodefecto.getParametroInventarioDefectoOriginal().getid_efecto_producto()!=null)
				{
					strValorActual=parametroinventariodefecto.getParametroInventarioDefectoOriginal().getid_efecto_producto().toString();
				}
				if(parametroinventariodefecto.getid_efecto_producto()!=null)
				{
					strValorNuevo=parametroinventariodefecto.getid_efecto_producto().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroInventarioDefectoConstantesFunciones.IDEFECTOPRODUCTO,strValorActual,strValorNuevo);
			}	
			
			if(parametroinventariodefecto.getIsNew()||!parametroinventariodefecto.getid_marca_producto().equals(parametroinventariodefecto.getParametroInventarioDefectoOriginal().getid_marca_producto()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametroinventariodefecto.getParametroInventarioDefectoOriginal().getid_marca_producto()!=null)
				{
					strValorActual=parametroinventariodefecto.getParametroInventarioDefectoOriginal().getid_marca_producto().toString();
				}
				if(parametroinventariodefecto.getid_marca_producto()!=null)
				{
					strValorNuevo=parametroinventariodefecto.getid_marca_producto().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroInventarioDefectoConstantesFunciones.IDMARCAPRODUCTO,strValorActual,strValorNuevo);
			}	
			
			if(parametroinventariodefecto.getIsNew()||!parametroinventariodefecto.getid_modelo_producto().equals(parametroinventariodefecto.getParametroInventarioDefectoOriginal().getid_modelo_producto()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametroinventariodefecto.getParametroInventarioDefectoOriginal().getid_modelo_producto()!=null)
				{
					strValorActual=parametroinventariodefecto.getParametroInventarioDefectoOriginal().getid_modelo_producto().toString();
				}
				if(parametroinventariodefecto.getid_modelo_producto()!=null)
				{
					strValorNuevo=parametroinventariodefecto.getid_modelo_producto().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroInventarioDefectoConstantesFunciones.IDMODELOPRODUCTO,strValorActual,strValorNuevo);
			}	
			
			if(parametroinventariodefecto.getIsNew()||!parametroinventariodefecto.getid_material_producto().equals(parametroinventariodefecto.getParametroInventarioDefectoOriginal().getid_material_producto()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametroinventariodefecto.getParametroInventarioDefectoOriginal().getid_material_producto()!=null)
				{
					strValorActual=parametroinventariodefecto.getParametroInventarioDefectoOriginal().getid_material_producto().toString();
				}
				if(parametroinventariodefecto.getid_material_producto()!=null)
				{
					strValorNuevo=parametroinventariodefecto.getid_material_producto().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroInventarioDefectoConstantesFunciones.IDMATERIALPRODUCTO,strValorActual,strValorNuevo);
			}	
			
			if(parametroinventariodefecto.getIsNew()||!parametroinventariodefecto.getid_segmento_producto().equals(parametroinventariodefecto.getParametroInventarioDefectoOriginal().getid_segmento_producto()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametroinventariodefecto.getParametroInventarioDefectoOriginal().getid_segmento_producto()!=null)
				{
					strValorActual=parametroinventariodefecto.getParametroInventarioDefectoOriginal().getid_segmento_producto().toString();
				}
				if(parametroinventariodefecto.getid_segmento_producto()!=null)
				{
					strValorNuevo=parametroinventariodefecto.getid_segmento_producto().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroInventarioDefectoConstantesFunciones.IDSEGMENTOPRODUCTO,strValorActual,strValorNuevo);
			}	
			
			if(parametroinventariodefecto.getIsNew()||!parametroinventariodefecto.getid_talla_producto().equals(parametroinventariodefecto.getParametroInventarioDefectoOriginal().getid_talla_producto()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametroinventariodefecto.getParametroInventarioDefectoOriginal().getid_talla_producto()!=null)
				{
					strValorActual=parametroinventariodefecto.getParametroInventarioDefectoOriginal().getid_talla_producto().toString();
				}
				if(parametroinventariodefecto.getid_talla_producto()!=null)
				{
					strValorNuevo=parametroinventariodefecto.getid_talla_producto().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroInventarioDefectoConstantesFunciones.IDTALLAPRODUCTO,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveParametroInventarioDefectoRelacionesWithConnection(ParametroInventarioDefecto parametroinventariodefecto) throws Exception {

		if(!parametroinventariodefecto.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveParametroInventarioDefectoRelacionesBase(parametroinventariodefecto,true);
		}
	}

	public void saveParametroInventarioDefectoRelaciones(ParametroInventarioDefecto parametroinventariodefecto)throws Exception {

		if(!parametroinventariodefecto.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveParametroInventarioDefectoRelacionesBase(parametroinventariodefecto,false);
		}
	}

	public void saveParametroInventarioDefectoRelacionesBase(ParametroInventarioDefecto parametroinventariodefecto,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("ParametroInventarioDefecto-saveRelacionesWithConnection");}
	

			this.setParametroInventarioDefecto(parametroinventariodefecto);

			if(ParametroInventarioDefectoLogicAdditional.validarSaveRelaciones(parametroinventariodefecto,this)) {

				ParametroInventarioDefectoLogicAdditional.updateRelacionesToSave(parametroinventariodefecto,this);

				if((parametroinventariodefecto.getIsNew()||parametroinventariodefecto.getIsChanged())&&!parametroinventariodefecto.getIsDeleted()) {
					this.saveParametroInventarioDefecto();
					this.saveParametroInventarioDefectoRelacionesDetalles();

				} else if(parametroinventariodefecto.getIsDeleted()) {
					this.saveParametroInventarioDefectoRelacionesDetalles();
					this.saveParametroInventarioDefecto();
				}

				ParametroInventarioDefectoLogicAdditional.updateRelacionesToSaveAfter(parametroinventariodefecto,this);

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
	
	
	private void saveParametroInventarioDefectoRelacionesDetalles()throws Exception {
		try {
	

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfParametroInventarioDefecto(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=ParametroInventarioDefectoConstantesFunciones.getClassesForeignKeysOfParametroInventarioDefecto(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfParametroInventarioDefecto(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=ParametroInventarioDefectoConstantesFunciones.getClassesRelationshipsOfParametroInventarioDefecto(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

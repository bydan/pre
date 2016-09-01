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
package com.bydan.erp.cartera.business.logic;

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
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.cartera.util.ParametroCarteraDefectoConstantesFunciones;
import com.bydan.erp.cartera.util.ParametroCarteraDefectoParameterReturnGeneral;
//import com.bydan.erp.cartera.util.ParametroCarteraDefectoParameterGeneral;
import com.bydan.erp.cartera.business.entity.ParametroCarteraDefecto;
import com.bydan.erp.cartera.business.logic.ParametroCarteraDefectoLogicAdditional;
import com.bydan.erp.cartera.business.dataaccess.*;
import com.bydan.erp.cartera.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.comisiones.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;
import com.bydan.erp.nomina.business.logic.*;
import com.bydan.erp.contabilidad.business.logic.*;
import com.bydan.erp.comisiones.business.logic.*;
import com.bydan.erp.inventario.business.logic.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.nomina.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.comisiones.util.*;
import com.bydan.erp.inventario.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.nomina.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;
import com.bydan.erp.comisiones.business.dataaccess.*;
import com.bydan.erp.inventario.business.dataaccess.*;








@SuppressWarnings("unused")
public class ParametroCarteraDefectoLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(ParametroCarteraDefectoLogic.class);
	
	protected ParametroCarteraDefectoDataAccess parametrocarteradefectoDataAccess; 	
	protected ParametroCarteraDefecto parametrocarteradefecto;
	protected List<ParametroCarteraDefecto> parametrocarteradefectos;
	protected Object parametrocarteradefectoObject;	
	protected List<Object> parametrocarteradefectosObject;
	
	public static ClassValidator<ParametroCarteraDefecto> parametrocarteradefectoValidator = new ClassValidator<ParametroCarteraDefecto>(ParametroCarteraDefecto.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected ParametroCarteraDefectoLogicAdditional parametrocarteradefectoLogicAdditional=null;
	
	public ParametroCarteraDefectoLogicAdditional getParametroCarteraDefectoLogicAdditional() {
		return this.parametrocarteradefectoLogicAdditional;
	}
	
	public void setParametroCarteraDefectoLogicAdditional(ParametroCarteraDefectoLogicAdditional parametrocarteradefectoLogicAdditional) {
		try {
			this.parametrocarteradefectoLogicAdditional=parametrocarteradefectoLogicAdditional;
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
	
	
	
	
	public  ParametroCarteraDefectoLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.parametrocarteradefectoDataAccess = new ParametroCarteraDefectoDataAccess();
			
			this.parametrocarteradefectos= new ArrayList<ParametroCarteraDefecto>();
			this.parametrocarteradefecto= new ParametroCarteraDefecto();
			
			this.parametrocarteradefectoObject=new Object();
			this.parametrocarteradefectosObject=new ArrayList<Object>();
				
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
			
			this.parametrocarteradefectoDataAccess.setConnexionType(this.connexionType);
			this.parametrocarteradefectoDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  ParametroCarteraDefectoLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.parametrocarteradefectoDataAccess = new ParametroCarteraDefectoDataAccess();
			this.parametrocarteradefectos= new ArrayList<ParametroCarteraDefecto>();
			this.parametrocarteradefecto= new ParametroCarteraDefecto();
			this.parametrocarteradefectoObject=new Object();
			this.parametrocarteradefectosObject=new ArrayList<Object>();
			
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
			
			this.parametrocarteradefectoDataAccess.setConnexionType(this.connexionType);
			this.parametrocarteradefectoDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public ParametroCarteraDefecto getParametroCarteraDefecto() throws Exception {	
		ParametroCarteraDefectoLogicAdditional.checkParametroCarteraDefectoToGet(parametrocarteradefecto,this.datosCliente,this.arrDatoGeneral);
		ParametroCarteraDefectoLogicAdditional.updateParametroCarteraDefectoToGet(parametrocarteradefecto,this.arrDatoGeneral);
		
		return parametrocarteradefecto;
	}
		
	public void setParametroCarteraDefecto(ParametroCarteraDefecto newParametroCarteraDefecto) {
		this.parametrocarteradefecto = newParametroCarteraDefecto;
	}
	
	public ParametroCarteraDefectoDataAccess getParametroCarteraDefectoDataAccess() {
		return parametrocarteradefectoDataAccess;
	}
	
	public void setParametroCarteraDefectoDataAccess(ParametroCarteraDefectoDataAccess newparametrocarteradefectoDataAccess) {
		this.parametrocarteradefectoDataAccess = newparametrocarteradefectoDataAccess;
	}
	
	public List<ParametroCarteraDefecto> getParametroCarteraDefectos() throws Exception {		
		this.quitarParametroCarteraDefectosNulos();
		
		ParametroCarteraDefectoLogicAdditional.checkParametroCarteraDefectoToGets(parametrocarteradefectos,this.datosCliente,this.arrDatoGeneral);
		
		for (ParametroCarteraDefecto parametrocarteradefectoLocal: parametrocarteradefectos ) {
			ParametroCarteraDefectoLogicAdditional.updateParametroCarteraDefectoToGet(parametrocarteradefectoLocal,this.arrDatoGeneral);
		}
		
		return parametrocarteradefectos;
	}
	
	public void setParametroCarteraDefectos(List<ParametroCarteraDefecto> newParametroCarteraDefectos) {
		this.parametrocarteradefectos = newParametroCarteraDefectos;
	}
	
	public Object getParametroCarteraDefectoObject() {	
		this.parametrocarteradefectoObject=this.parametrocarteradefectoDataAccess.getEntityObject();
		return this.parametrocarteradefectoObject;
	}
		
	public void setParametroCarteraDefectoObject(Object newParametroCarteraDefectoObject) {
		this.parametrocarteradefectoObject = newParametroCarteraDefectoObject;
	}
	
	public List<Object> getParametroCarteraDefectosObject() {		
		this.parametrocarteradefectosObject=this.parametrocarteradefectoDataAccess.getEntitiesObject();
		return this.parametrocarteradefectosObject;
	}
		
	public void setParametroCarteraDefectosObject(List<Object> newParametroCarteraDefectosObject) {
		this.parametrocarteradefectosObject = newParametroCarteraDefectosObject;
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
		
		if(this.parametrocarteradefectoDataAccess!=null) {
			this.parametrocarteradefectoDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroCarteraDefecto.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			parametrocarteradefectoDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			parametrocarteradefectoDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		parametrocarteradefecto = new  ParametroCarteraDefecto();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroCarteraDefecto.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			parametrocarteradefecto=parametrocarteradefectoDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.parametrocarteradefecto,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ParametroCarteraDefectoConstantesFunciones.refrescarForeignKeysDescripcionesParametroCarteraDefecto(this.parametrocarteradefecto);
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
		parametrocarteradefecto = new  ParametroCarteraDefecto();
		  		  
        try {
			
			parametrocarteradefecto=parametrocarteradefectoDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.parametrocarteradefecto,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ParametroCarteraDefectoConstantesFunciones.refrescarForeignKeysDescripcionesParametroCarteraDefecto(this.parametrocarteradefecto);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		parametrocarteradefecto = new  ParametroCarteraDefecto();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroCarteraDefecto.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			parametrocarteradefecto=parametrocarteradefectoDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.parametrocarteradefecto,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ParametroCarteraDefectoConstantesFunciones.refrescarForeignKeysDescripcionesParametroCarteraDefecto(this.parametrocarteradefecto);
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
		parametrocarteradefecto = new  ParametroCarteraDefecto();
		  		  
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
		parametrocarteradefecto = new  ParametroCarteraDefecto();
		  		  
        try {
			
			parametrocarteradefecto=parametrocarteradefectoDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.parametrocarteradefecto,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ParametroCarteraDefectoConstantesFunciones.refrescarForeignKeysDescripcionesParametroCarteraDefecto(this.parametrocarteradefecto);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		parametrocarteradefecto = new  ParametroCarteraDefecto();
		  		  
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
		parametrocarteradefecto = new  ParametroCarteraDefecto();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroCarteraDefecto.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =parametrocarteradefectoDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		parametrocarteradefecto = new  ParametroCarteraDefecto();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=parametrocarteradefectoDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		parametrocarteradefecto = new  ParametroCarteraDefecto();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroCarteraDefecto.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =parametrocarteradefectoDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		parametrocarteradefecto = new  ParametroCarteraDefecto();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=parametrocarteradefectoDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		parametrocarteradefecto = new  ParametroCarteraDefecto();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroCarteraDefecto.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =parametrocarteradefectoDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		parametrocarteradefecto = new  ParametroCarteraDefecto();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=parametrocarteradefectoDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		parametrocarteradefectos = new  ArrayList<ParametroCarteraDefecto>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroCarteraDefecto.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			ParametroCarteraDefectoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametrocarteradefectos=parametrocarteradefectoDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarParametroCarteraDefecto(parametrocarteradefectos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroCarteraDefectoConstantesFunciones.refrescarForeignKeysDescripcionesParametroCarteraDefecto(this.parametrocarteradefectos);
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
		parametrocarteradefectos = new  ArrayList<ParametroCarteraDefecto>();
		  		  
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
		parametrocarteradefectos = new  ArrayList<ParametroCarteraDefecto>();
		  		  
        try {			
			ParametroCarteraDefectoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametrocarteradefectos=parametrocarteradefectoDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarParametroCarteraDefecto(parametrocarteradefectos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroCarteraDefectoConstantesFunciones.refrescarForeignKeysDescripcionesParametroCarteraDefecto(this.parametrocarteradefectos);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		parametrocarteradefectos = new  ArrayList<ParametroCarteraDefecto>();
		  		  
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
		parametrocarteradefectos = new  ArrayList<ParametroCarteraDefecto>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroCarteraDefecto.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			ParametroCarteraDefectoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametrocarteradefectos=parametrocarteradefectoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarParametroCarteraDefecto(parametrocarteradefectos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroCarteraDefectoConstantesFunciones.refrescarForeignKeysDescripcionesParametroCarteraDefecto(this.parametrocarteradefectos);
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
		parametrocarteradefectos = new  ArrayList<ParametroCarteraDefecto>();
		  		  
        try {
			ParametroCarteraDefectoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametrocarteradefectos=parametrocarteradefectoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarParametroCarteraDefecto(parametrocarteradefectos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroCarteraDefectoConstantesFunciones.refrescarForeignKeysDescripcionesParametroCarteraDefecto(this.parametrocarteradefectos);
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
		parametrocarteradefectos = new  ArrayList<ParametroCarteraDefecto>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroCarteraDefecto.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ParametroCarteraDefectoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametrocarteradefectos=parametrocarteradefectoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarParametroCarteraDefecto(parametrocarteradefectos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroCarteraDefectoConstantesFunciones.refrescarForeignKeysDescripcionesParametroCarteraDefecto(this.parametrocarteradefectos);
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
		parametrocarteradefectos = new  ArrayList<ParametroCarteraDefecto>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ParametroCarteraDefectoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametrocarteradefectos=parametrocarteradefectoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarParametroCarteraDefecto(parametrocarteradefectos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroCarteraDefectoConstantesFunciones.refrescarForeignKeysDescripcionesParametroCarteraDefecto(this.parametrocarteradefectos);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		parametrocarteradefecto = new  ParametroCarteraDefecto();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroCarteraDefecto.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ParametroCarteraDefectoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametrocarteradefecto=parametrocarteradefectoDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarParametroCarteraDefecto(parametrocarteradefecto);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroCarteraDefectoConstantesFunciones.refrescarForeignKeysDescripcionesParametroCarteraDefecto(this.parametrocarteradefecto);
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
		parametrocarteradefecto = new  ParametroCarteraDefecto();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ParametroCarteraDefectoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametrocarteradefecto=parametrocarteradefectoDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarParametroCarteraDefecto(parametrocarteradefecto);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroCarteraDefectoConstantesFunciones.refrescarForeignKeysDescripcionesParametroCarteraDefecto(this.parametrocarteradefecto);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		parametrocarteradefectos = new  ArrayList<ParametroCarteraDefecto>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroCarteraDefecto.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			ParametroCarteraDefectoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametrocarteradefectos=parametrocarteradefectoDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarParametroCarteraDefecto(parametrocarteradefectos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroCarteraDefectoConstantesFunciones.refrescarForeignKeysDescripcionesParametroCarteraDefecto(this.parametrocarteradefectos);
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
		parametrocarteradefectos = new  ArrayList<ParametroCarteraDefecto>();
		  		  
        try {
			ParametroCarteraDefectoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametrocarteradefectos=parametrocarteradefectoDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarParametroCarteraDefecto(parametrocarteradefectos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroCarteraDefectoConstantesFunciones.refrescarForeignKeysDescripcionesParametroCarteraDefecto(this.parametrocarteradefectos);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosParametroCarteraDefectosWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		parametrocarteradefectos = new  ArrayList<ParametroCarteraDefecto>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroCarteraDefecto.class.getSimpleName()+"-getTodosParametroCarteraDefectosWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ParametroCarteraDefectoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametrocarteradefectos=parametrocarteradefectoDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarParametroCarteraDefecto(parametrocarteradefectos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroCarteraDefectoConstantesFunciones.refrescarForeignKeysDescripcionesParametroCarteraDefecto(this.parametrocarteradefectos);
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
	
	public  void  getTodosParametroCarteraDefectos(String sFinalQuery,Pagination pagination)throws Exception {
		parametrocarteradefectos = new  ArrayList<ParametroCarteraDefecto>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ParametroCarteraDefectoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametrocarteradefectos=parametrocarteradefectoDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarParametroCarteraDefecto(parametrocarteradefectos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroCarteraDefectoConstantesFunciones.refrescarForeignKeysDescripcionesParametroCarteraDefecto(this.parametrocarteradefectos);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarParametroCarteraDefecto(ParametroCarteraDefecto parametrocarteradefecto) throws Exception {
		Boolean estaValidado=false;
		
		if(parametrocarteradefecto.getIsNew() || parametrocarteradefecto.getIsChanged()) { 
			this.invalidValues = parametrocarteradefectoValidator.getInvalidValues(parametrocarteradefecto);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(parametrocarteradefecto);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarParametroCarteraDefecto(List<ParametroCarteraDefecto> ParametroCarteraDefectos) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(ParametroCarteraDefecto parametrocarteradefectoLocal:parametrocarteradefectos) {				
			estaValidadoObjeto=this.validarGuardarParametroCarteraDefecto(parametrocarteradefectoLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarParametroCarteraDefecto(List<ParametroCarteraDefecto> ParametroCarteraDefectos) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarParametroCarteraDefecto(parametrocarteradefectos)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarParametroCarteraDefecto(ParametroCarteraDefecto ParametroCarteraDefecto) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarParametroCarteraDefecto(parametrocarteradefecto)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(ParametroCarteraDefecto parametrocarteradefecto) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+parametrocarteradefecto.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=ParametroCarteraDefectoConstantesFunciones.getParametroCarteraDefectoLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"parametrocarteradefecto","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(ParametroCarteraDefectoConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(ParametroCarteraDefectoConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveParametroCarteraDefectoWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroCarteraDefecto.class.getSimpleName()+"-saveParametroCarteraDefectoWithConnection");connexion.begin();			
			
			ParametroCarteraDefectoLogicAdditional.checkParametroCarteraDefectoToSave(this.parametrocarteradefecto,this.datosCliente,connexion,this.arrDatoGeneral);
			
			ParametroCarteraDefectoLogicAdditional.updateParametroCarteraDefectoToSave(this.parametrocarteradefecto,this.arrDatoGeneral);
			
			ParametroCarteraDefectoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.parametrocarteradefecto,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowParametroCarteraDefecto();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarParametroCarteraDefecto(this.parametrocarteradefecto)) {
				ParametroCarteraDefectoDataAccess.save(this.parametrocarteradefecto, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.parametrocarteradefecto,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			ParametroCarteraDefectoLogicAdditional.checkParametroCarteraDefectoToSaveAfter(this.parametrocarteradefecto,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowParametroCarteraDefecto();
			
			connexion.commit();			
			
			if(this.parametrocarteradefecto.getIsDeleted()) {
				this.parametrocarteradefecto=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveParametroCarteraDefecto()throws Exception {	
		try {	
			
			ParametroCarteraDefectoLogicAdditional.checkParametroCarteraDefectoToSave(this.parametrocarteradefecto,this.datosCliente,connexion,this.arrDatoGeneral);
			
			ParametroCarteraDefectoLogicAdditional.updateParametroCarteraDefectoToSave(this.parametrocarteradefecto,this.arrDatoGeneral);
			
			ParametroCarteraDefectoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.parametrocarteradefecto,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarParametroCarteraDefecto(this.parametrocarteradefecto)) {			
				ParametroCarteraDefectoDataAccess.save(this.parametrocarteradefecto, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.parametrocarteradefecto,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			ParametroCarteraDefectoLogicAdditional.checkParametroCarteraDefectoToSaveAfter(this.parametrocarteradefecto,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.parametrocarteradefecto.getIsDeleted()) {
				this.parametrocarteradefecto=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveParametroCarteraDefectosWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroCarteraDefecto.class.getSimpleName()+"-saveParametroCarteraDefectosWithConnection");connexion.begin();			
			
			ParametroCarteraDefectoLogicAdditional.checkParametroCarteraDefectoToSaves(parametrocarteradefectos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowParametroCarteraDefectos();
			
			Boolean validadoTodosParametroCarteraDefecto=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(ParametroCarteraDefecto parametrocarteradefectoLocal:parametrocarteradefectos) {		
				if(parametrocarteradefectoLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				ParametroCarteraDefectoLogicAdditional.updateParametroCarteraDefectoToSave(parametrocarteradefectoLocal,this.arrDatoGeneral);
	        	
				ParametroCarteraDefectoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),parametrocarteradefectoLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarParametroCarteraDefecto(parametrocarteradefectoLocal)) {
					ParametroCarteraDefectoDataAccess.save(parametrocarteradefectoLocal, connexion);				
				} else {
					validadoTodosParametroCarteraDefecto=false;
				}
			}
			
			if(!validadoTodosParametroCarteraDefecto) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			ParametroCarteraDefectoLogicAdditional.checkParametroCarteraDefectoToSavesAfter(parametrocarteradefectos,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowParametroCarteraDefectos();
			
			connexion.commit();		
			
			this.quitarParametroCarteraDefectosEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveParametroCarteraDefectos()throws Exception {				
		 try {	
			ParametroCarteraDefectoLogicAdditional.checkParametroCarteraDefectoToSaves(parametrocarteradefectos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosParametroCarteraDefecto=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(ParametroCarteraDefecto parametrocarteradefectoLocal:parametrocarteradefectos) {				
				if(parametrocarteradefectoLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				ParametroCarteraDefectoLogicAdditional.updateParametroCarteraDefectoToSave(parametrocarteradefectoLocal,this.arrDatoGeneral);
	        	
				ParametroCarteraDefectoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),parametrocarteradefectoLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarParametroCarteraDefecto(parametrocarteradefectoLocal)) {				
					ParametroCarteraDefectoDataAccess.save(parametrocarteradefectoLocal, connexion);				
				} else {
					validadoTodosParametroCarteraDefecto=false;
				}
			}
			
			if(!validadoTodosParametroCarteraDefecto) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			ParametroCarteraDefectoLogicAdditional.checkParametroCarteraDefectoToSavesAfter(parametrocarteradefectos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarParametroCarteraDefectosEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public ParametroCarteraDefectoParameterReturnGeneral procesarAccionParametroCarteraDefectos(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<ParametroCarteraDefecto> parametrocarteradefectos,ParametroCarteraDefectoParameterReturnGeneral parametrocarteradefectoParameterGeneral)throws Exception {
		 try {	
			ParametroCarteraDefectoParameterReturnGeneral parametrocarteradefectoReturnGeneral=new ParametroCarteraDefectoParameterReturnGeneral();
	
			ParametroCarteraDefectoLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,parametrocarteradefectos,parametrocarteradefectoParameterGeneral,parametrocarteradefectoReturnGeneral);
			
			return parametrocarteradefectoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public ParametroCarteraDefectoParameterReturnGeneral procesarAccionParametroCarteraDefectosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<ParametroCarteraDefecto> parametrocarteradefectos,ParametroCarteraDefectoParameterReturnGeneral parametrocarteradefectoParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroCarteraDefecto.class.getSimpleName()+"-procesarAccionParametroCarteraDefectosWithConnection");connexion.begin();			
			
			ParametroCarteraDefectoParameterReturnGeneral parametrocarteradefectoReturnGeneral=new ParametroCarteraDefectoParameterReturnGeneral();
	
			ParametroCarteraDefectoLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,parametrocarteradefectos,parametrocarteradefectoParameterGeneral,parametrocarteradefectoReturnGeneral);
			
			this.connexion.commit();
			
			return parametrocarteradefectoReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public ParametroCarteraDefectoParameterReturnGeneral procesarEventosParametroCarteraDefectos(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<ParametroCarteraDefecto> parametrocarteradefectos,ParametroCarteraDefecto parametrocarteradefecto,ParametroCarteraDefectoParameterReturnGeneral parametrocarteradefectoParameterGeneral,Boolean isEsNuevoParametroCarteraDefecto,ArrayList<Classe> clases)throws Exception {
		 try {	
			ParametroCarteraDefectoParameterReturnGeneral parametrocarteradefectoReturnGeneral=new ParametroCarteraDefectoParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				parametrocarteradefectoReturnGeneral.setConRecargarPropiedades(true);
			}
			
			ParametroCarteraDefectoLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,parametrocarteradefectos,parametrocarteradefecto,parametrocarteradefectoParameterGeneral,parametrocarteradefectoReturnGeneral,isEsNuevoParametroCarteraDefecto,clases);
			
			return parametrocarteradefectoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public ParametroCarteraDefectoParameterReturnGeneral procesarEventosParametroCarteraDefectosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<ParametroCarteraDefecto> parametrocarteradefectos,ParametroCarteraDefecto parametrocarteradefecto,ParametroCarteraDefectoParameterReturnGeneral parametrocarteradefectoParameterGeneral,Boolean isEsNuevoParametroCarteraDefecto,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroCarteraDefecto.class.getSimpleName()+"-procesarEventosParametroCarteraDefectosWithConnection");connexion.begin();			
			
			ParametroCarteraDefectoParameterReturnGeneral parametrocarteradefectoReturnGeneral=new ParametroCarteraDefectoParameterReturnGeneral();
	
			parametrocarteradefectoReturnGeneral.setParametroCarteraDefecto(parametrocarteradefecto);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				parametrocarteradefectoReturnGeneral.setConRecargarPropiedades(true);
			}
			
			ParametroCarteraDefectoLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,parametrocarteradefectos,parametrocarteradefecto,parametrocarteradefectoParameterGeneral,parametrocarteradefectoReturnGeneral,isEsNuevoParametroCarteraDefecto,clases);
			
			this.connexion.commit();
			
			return parametrocarteradefectoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public ParametroCarteraDefectoParameterReturnGeneral procesarImportacionParametroCarteraDefectosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,ParametroCarteraDefectoParameterReturnGeneral parametrocarteradefectoParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroCarteraDefecto.class.getSimpleName()+"-procesarImportacionParametroCarteraDefectosWithConnection");connexion.begin();			
			
			ParametroCarteraDefectoParameterReturnGeneral parametrocarteradefectoReturnGeneral=new ParametroCarteraDefectoParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.parametrocarteradefectos=new ArrayList<ParametroCarteraDefecto>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.parametrocarteradefecto=new ParametroCarteraDefecto();
				
				
				if(conColumnasBase) {this.parametrocarteradefecto.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.parametrocarteradefecto.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				
				this.parametrocarteradefectos.add(this.parametrocarteradefecto);
			}
			
			this.saveParametroCarteraDefectos();
			
			this.connexion.commit();
			
			parametrocarteradefectoReturnGeneral.setConRetornoEstaProcesado(true);
			parametrocarteradefectoReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return parametrocarteradefectoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarParametroCarteraDefectosEliminados() throws Exception {				
		
		List<ParametroCarteraDefecto> parametrocarteradefectosAux= new ArrayList<ParametroCarteraDefecto>();
		
		for(ParametroCarteraDefecto parametrocarteradefecto:parametrocarteradefectos) {
			if(!parametrocarteradefecto.getIsDeleted()) {
				parametrocarteradefectosAux.add(parametrocarteradefecto);
			}
		}
		
		parametrocarteradefectos=parametrocarteradefectosAux;
	}
	
	public void quitarParametroCarteraDefectosNulos() throws Exception {				
		
		List<ParametroCarteraDefecto> parametrocarteradefectosAux= new ArrayList<ParametroCarteraDefecto>();
		
		for(ParametroCarteraDefecto parametrocarteradefecto : this.parametrocarteradefectos) {
			if(parametrocarteradefecto==null) {
				parametrocarteradefectosAux.add(parametrocarteradefecto);
			}
		}
		
		//this.parametrocarteradefectos=parametrocarteradefectosAux;
		
		this.parametrocarteradefectos.removeAll(parametrocarteradefectosAux);
	}
	
	public void getSetVersionRowParametroCarteraDefectoWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(parametrocarteradefecto.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((parametrocarteradefecto.getIsDeleted() || (parametrocarteradefecto.getIsChanged()&&!parametrocarteradefecto.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=parametrocarteradefectoDataAccess.getSetVersionRowParametroCarteraDefecto(connexion,parametrocarteradefecto.getId());
				
				if(!parametrocarteradefecto.getVersionRow().equals(timestamp)) {	
					parametrocarteradefecto.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				parametrocarteradefecto.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowParametroCarteraDefecto()throws Exception {	
		
		if(parametrocarteradefecto.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((parametrocarteradefecto.getIsDeleted() || (parametrocarteradefecto.getIsChanged()&&!parametrocarteradefecto.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=parametrocarteradefectoDataAccess.getSetVersionRowParametroCarteraDefecto(connexion,parametrocarteradefecto.getId());
			
			try {							
				if(!parametrocarteradefecto.getVersionRow().equals(timestamp)) {	
					parametrocarteradefecto.setVersionRow(timestamp);
				}
				
				parametrocarteradefecto.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowParametroCarteraDefectosWithConnection()throws Exception {	
		if(parametrocarteradefectos!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(ParametroCarteraDefecto parametrocarteradefectoAux:parametrocarteradefectos) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(parametrocarteradefectoAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(parametrocarteradefectoAux.getIsDeleted() || (parametrocarteradefectoAux.getIsChanged()&&!parametrocarteradefectoAux.getIsNew())) {
						
						timestamp=parametrocarteradefectoDataAccess.getSetVersionRowParametroCarteraDefecto(connexion,parametrocarteradefectoAux.getId());
						
						if(!parametrocarteradefecto.getVersionRow().equals(timestamp)) {	
							parametrocarteradefectoAux.setVersionRow(timestamp);
						}
								
						parametrocarteradefectoAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowParametroCarteraDefectos()throws Exception {	
		if(parametrocarteradefectos!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(ParametroCarteraDefecto parametrocarteradefectoAux:parametrocarteradefectos) {
					if(parametrocarteradefectoAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(parametrocarteradefectoAux.getIsDeleted() || (parametrocarteradefectoAux.getIsChanged()&&!parametrocarteradefectoAux.getIsNew())) {
						
						timestamp=parametrocarteradefectoDataAccess.getSetVersionRowParametroCarteraDefecto(connexion,parametrocarteradefectoAux.getId());
						
						if(!parametrocarteradefectoAux.getVersionRow().equals(timestamp)) {	
							parametrocarteradefectoAux.setVersionRow(timestamp);
						}
						
													
						parametrocarteradefectoAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public ParametroCarteraDefectoParameterReturnGeneral cargarCombosLoteForeignKeyParametroCarteraDefectoWithConnection(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalPais,String finalQueryGlobalRegion,String finalQueryGlobalProvincia,String finalQueryGlobalCiudad,String finalQueryGlobalZona,String finalQueryGlobalTipoIdentificacion,String finalQueryGlobalTipoNivelEdu,String finalQueryGlobalPaisNacionalidad,String finalQueryGlobalTipoGenero,String finalQueryGlobalEstadoCivil,String finalQueryGlobalEstadoLegal,String finalQueryGlobalCuentaContable,String finalQueryGlobalVendedor,String finalQueryGlobalRuta,String finalQueryGlobalDia,String finalQueryGlobalTipoPrecio,String finalQueryGlobalTipoListaPrecio) throws Exception {
		ParametroCarteraDefectoParameterReturnGeneral  parametrocarteradefectoReturnGeneral =new ParametroCarteraDefectoParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroCarteraDefecto.class.getSimpleName()+"-cargarCombosLoteForeignKeyParametroCarteraDefectoWithConnection");connexion.begin();
			
			parametrocarteradefectoReturnGeneral =new ParametroCarteraDefectoParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			parametrocarteradefectoReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			parametrocarteradefectoReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Pais> paissForeignKey=new ArrayList<Pais>();
			PaisLogic paisLogic=new PaisLogic();
			paisLogic.setConnexion(this.connexion);
			paisLogic.getPaisDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPais.equals("NONE")) {
				paisLogic.getTodosPaiss(finalQueryGlobalPais,new Pagination());
				paissForeignKey=paisLogic.getPaiss();
			}

			parametrocarteradefectoReturnGeneral.setpaissForeignKey(paissForeignKey);


			List<Region> regionsForeignKey=new ArrayList<Region>();
			RegionLogic regionLogic=new RegionLogic();
			regionLogic.setConnexion(this.connexion);
			regionLogic.getRegionDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalRegion.equals("NONE")) {
				regionLogic.getTodosRegions(finalQueryGlobalRegion,new Pagination());
				regionsForeignKey=regionLogic.getRegions();
			}

			parametrocarteradefectoReturnGeneral.setregionsForeignKey(regionsForeignKey);


			List<Provincia> provinciasForeignKey=new ArrayList<Provincia>();
			ProvinciaLogic provinciaLogic=new ProvinciaLogic();
			provinciaLogic.setConnexion(this.connexion);
			provinciaLogic.getProvinciaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalProvincia.equals("NONE")) {
				provinciaLogic.getTodosProvincias(finalQueryGlobalProvincia,new Pagination());
				provinciasForeignKey=provinciaLogic.getProvincias();
			}

			parametrocarteradefectoReturnGeneral.setprovinciasForeignKey(provinciasForeignKey);


			List<Ciudad> ciudadsForeignKey=new ArrayList<Ciudad>();
			CiudadLogic ciudadLogic=new CiudadLogic();
			ciudadLogic.setConnexion(this.connexion);
			ciudadLogic.getCiudadDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCiudad.equals("NONE")) {
				ciudadLogic.getTodosCiudads(finalQueryGlobalCiudad,new Pagination());
				ciudadsForeignKey=ciudadLogic.getCiudads();
			}

			parametrocarteradefectoReturnGeneral.setciudadsForeignKey(ciudadsForeignKey);


			List<Zona> zonasForeignKey=new ArrayList<Zona>();
			ZonaLogic zonaLogic=new ZonaLogic();
			zonaLogic.setConnexion(this.connexion);
			zonaLogic.getZonaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalZona.equals("NONE")) {
				zonaLogic.getTodosZonas(finalQueryGlobalZona,new Pagination());
				zonasForeignKey=zonaLogic.getZonas();
			}

			parametrocarteradefectoReturnGeneral.setzonasForeignKey(zonasForeignKey);


			List<TipoIdentificacion> tipoidentificacionsForeignKey=new ArrayList<TipoIdentificacion>();
			TipoIdentificacionLogic tipoidentificacionLogic=new TipoIdentificacionLogic();
			tipoidentificacionLogic.setConnexion(this.connexion);
			tipoidentificacionLogic.getTipoIdentificacionDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoIdentificacion.equals("NONE")) {
				tipoidentificacionLogic.getTodosTipoIdentificacions(finalQueryGlobalTipoIdentificacion,new Pagination());
				tipoidentificacionsForeignKey=tipoidentificacionLogic.getTipoIdentificacions();
			}

			parametrocarteradefectoReturnGeneral.settipoidentificacionsForeignKey(tipoidentificacionsForeignKey);


			List<TipoNivelEdu> tiponiveledusForeignKey=new ArrayList<TipoNivelEdu>();
			TipoNivelEduLogic tiponiveleduLogic=new TipoNivelEduLogic();
			tiponiveleduLogic.setConnexion(this.connexion);
			//tiponiveleduLogic.getTipoNivelEduDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoNivelEdu.equals("NONE")) {
				tiponiveleduLogic.getTodosTipoNivelEdus(finalQueryGlobalTipoNivelEdu,new Pagination());
				tiponiveledusForeignKey=tiponiveleduLogic.getTipoNivelEdus();
			}

			parametrocarteradefectoReturnGeneral.settiponiveledusForeignKey(tiponiveledusForeignKey);


			List<Pais> paisnacionalidadsForeignKey=new ArrayList<Pais>();
			PaisLogic paisnacionalidadLogic=new PaisLogic();
			paisnacionalidadLogic.setConnexion(this.connexion);
			paisnacionalidadLogic.getPaisDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPaisNacionalidad.equals("NONE")) {
				paisnacionalidadLogic.getTodosPaiss(finalQueryGlobalPaisNacionalidad,new Pagination());
				paisnacionalidadsForeignKey=paisnacionalidadLogic.getPaiss();
			}

			parametrocarteradefectoReturnGeneral.setpaisnacionalidadsForeignKey(paisnacionalidadsForeignKey);


			List<TipoGenero> tipogenerosForeignKey=new ArrayList<TipoGenero>();
			TipoGeneroLogic tipogeneroLogic=new TipoGeneroLogic();
			tipogeneroLogic.setConnexion(this.connexion);
			tipogeneroLogic.getTipoGeneroDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoGenero.equals("NONE")) {
				tipogeneroLogic.getTodosTipoGeneros(finalQueryGlobalTipoGenero,new Pagination());
				tipogenerosForeignKey=tipogeneroLogic.getTipoGeneros();
			}

			parametrocarteradefectoReturnGeneral.settipogenerosForeignKey(tipogenerosForeignKey);


			List<EstadoCivil> estadocivilsForeignKey=new ArrayList<EstadoCivil>();
			EstadoCivilLogic estadocivilLogic=new EstadoCivilLogic();
			estadocivilLogic.setConnexion(this.connexion);
			estadocivilLogic.getEstadoCivilDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEstadoCivil.equals("NONE")) {
				estadocivilLogic.getTodosEstadoCivils(finalQueryGlobalEstadoCivil,new Pagination());
				estadocivilsForeignKey=estadocivilLogic.getEstadoCivils();
			}

			parametrocarteradefectoReturnGeneral.setestadocivilsForeignKey(estadocivilsForeignKey);


			List<EstadoLegal> estadolegalsForeignKey=new ArrayList<EstadoLegal>();
			EstadoLegalLogic estadolegalLogic=new EstadoLegalLogic();
			estadolegalLogic.setConnexion(this.connexion);
			estadolegalLogic.getEstadoLegalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEstadoLegal.equals("NONE")) {
				estadolegalLogic.getTodosEstadoLegals(finalQueryGlobalEstadoLegal,new Pagination());
				estadolegalsForeignKey=estadolegalLogic.getEstadoLegals();
			}

			parametrocarteradefectoReturnGeneral.setestadolegalsForeignKey(estadolegalsForeignKey);


			List<CuentaContable> cuentacontablesForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontableLogic=new CuentaContableLogic();
			cuentacontableLogic.setConnexion(this.connexion);
			cuentacontableLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContable.equals("NONE")) {
				cuentacontableLogic.getTodosCuentaContables(finalQueryGlobalCuentaContable,new Pagination());
				cuentacontablesForeignKey=cuentacontableLogic.getCuentaContables();
			}

			parametrocarteradefectoReturnGeneral.setcuentacontablesForeignKey(cuentacontablesForeignKey);


			List<Vendedor> vendedorsForeignKey=new ArrayList<Vendedor>();
			VendedorLogic vendedorLogic=new VendedorLogic();
			vendedorLogic.setConnexion(this.connexion);
			vendedorLogic.getVendedorDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalVendedor.equals("NONE")) {
				vendedorLogic.getTodosVendedors(finalQueryGlobalVendedor,new Pagination());
				vendedorsForeignKey=vendedorLogic.getVendedors();
			}

			parametrocarteradefectoReturnGeneral.setvendedorsForeignKey(vendedorsForeignKey);


			List<Ruta> rutasForeignKey=new ArrayList<Ruta>();
			RutaLogic rutaLogic=new RutaLogic();
			rutaLogic.setConnexion(this.connexion);
			rutaLogic.getRutaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalRuta.equals("NONE")) {
				rutaLogic.getTodosRutas(finalQueryGlobalRuta,new Pagination());
				rutasForeignKey=rutaLogic.getRutas();
			}

			parametrocarteradefectoReturnGeneral.setrutasForeignKey(rutasForeignKey);


			List<Dia> diasForeignKey=new ArrayList<Dia>();
			DiaLogic diaLogic=new DiaLogic();
			diaLogic.setConnexion(this.connexion);
			diaLogic.getDiaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalDia.equals("NONE")) {
				diaLogic.getTodosDias(finalQueryGlobalDia,new Pagination());
				diasForeignKey=diaLogic.getDias();
			}

			parametrocarteradefectoReturnGeneral.setdiasForeignKey(diasForeignKey);


			List<TipoPrecio> tipopreciosForeignKey=new ArrayList<TipoPrecio>();
			TipoPrecioLogic tipoprecioLogic=new TipoPrecioLogic();
			tipoprecioLogic.setConnexion(this.connexion);
			tipoprecioLogic.getTipoPrecioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoPrecio.equals("NONE")) {
				tipoprecioLogic.getTodosTipoPrecios(finalQueryGlobalTipoPrecio,new Pagination());
				tipopreciosForeignKey=tipoprecioLogic.getTipoPrecios();
			}

			parametrocarteradefectoReturnGeneral.settipopreciosForeignKey(tipopreciosForeignKey);


			List<TipoListaPrecio> tipolistapreciosForeignKey=new ArrayList<TipoListaPrecio>();
			TipoListaPrecioLogic tipolistaprecioLogic=new TipoListaPrecioLogic();
			tipolistaprecioLogic.setConnexion(this.connexion);
			tipolistaprecioLogic.getTipoListaPrecioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoListaPrecio.equals("NONE")) {
				tipolistaprecioLogic.getTodosTipoListaPrecios(finalQueryGlobalTipoListaPrecio,new Pagination());
				tipolistapreciosForeignKey=tipolistaprecioLogic.getTipoListaPrecios();
			}

			parametrocarteradefectoReturnGeneral.settipolistapreciosForeignKey(tipolistapreciosForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return parametrocarteradefectoReturnGeneral;
	}
	
	public ParametroCarteraDefectoParameterReturnGeneral cargarCombosLoteForeignKeyParametroCarteraDefecto(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalPais,String finalQueryGlobalRegion,String finalQueryGlobalProvincia,String finalQueryGlobalCiudad,String finalQueryGlobalZona,String finalQueryGlobalTipoIdentificacion,String finalQueryGlobalTipoNivelEdu,String finalQueryGlobalPaisNacionalidad,String finalQueryGlobalTipoGenero,String finalQueryGlobalEstadoCivil,String finalQueryGlobalEstadoLegal,String finalQueryGlobalCuentaContable,String finalQueryGlobalVendedor,String finalQueryGlobalRuta,String finalQueryGlobalDia,String finalQueryGlobalTipoPrecio,String finalQueryGlobalTipoListaPrecio) throws Exception {
		ParametroCarteraDefectoParameterReturnGeneral  parametrocarteradefectoReturnGeneral =new ParametroCarteraDefectoParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			parametrocarteradefectoReturnGeneral =new ParametroCarteraDefectoParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			parametrocarteradefectoReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			parametrocarteradefectoReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Pais> paissForeignKey=new ArrayList<Pais>();
			PaisLogic paisLogic=new PaisLogic();
			paisLogic.setConnexion(this.connexion);
			paisLogic.getPaisDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPais.equals("NONE")) {
				paisLogic.getTodosPaiss(finalQueryGlobalPais,new Pagination());
				paissForeignKey=paisLogic.getPaiss();
			}

			parametrocarteradefectoReturnGeneral.setpaissForeignKey(paissForeignKey);


			List<Region> regionsForeignKey=new ArrayList<Region>();
			RegionLogic regionLogic=new RegionLogic();
			regionLogic.setConnexion(this.connexion);
			regionLogic.getRegionDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalRegion.equals("NONE")) {
				regionLogic.getTodosRegions(finalQueryGlobalRegion,new Pagination());
				regionsForeignKey=regionLogic.getRegions();
			}

			parametrocarteradefectoReturnGeneral.setregionsForeignKey(regionsForeignKey);


			List<Provincia> provinciasForeignKey=new ArrayList<Provincia>();
			ProvinciaLogic provinciaLogic=new ProvinciaLogic();
			provinciaLogic.setConnexion(this.connexion);
			provinciaLogic.getProvinciaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalProvincia.equals("NONE")) {
				provinciaLogic.getTodosProvincias(finalQueryGlobalProvincia,new Pagination());
				provinciasForeignKey=provinciaLogic.getProvincias();
			}

			parametrocarteradefectoReturnGeneral.setprovinciasForeignKey(provinciasForeignKey);


			List<Ciudad> ciudadsForeignKey=new ArrayList<Ciudad>();
			CiudadLogic ciudadLogic=new CiudadLogic();
			ciudadLogic.setConnexion(this.connexion);
			ciudadLogic.getCiudadDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCiudad.equals("NONE")) {
				ciudadLogic.getTodosCiudads(finalQueryGlobalCiudad,new Pagination());
				ciudadsForeignKey=ciudadLogic.getCiudads();
			}

			parametrocarteradefectoReturnGeneral.setciudadsForeignKey(ciudadsForeignKey);


			List<Zona> zonasForeignKey=new ArrayList<Zona>();
			ZonaLogic zonaLogic=new ZonaLogic();
			zonaLogic.setConnexion(this.connexion);
			zonaLogic.getZonaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalZona.equals("NONE")) {
				zonaLogic.getTodosZonas(finalQueryGlobalZona,new Pagination());
				zonasForeignKey=zonaLogic.getZonas();
			}

			parametrocarteradefectoReturnGeneral.setzonasForeignKey(zonasForeignKey);


			List<TipoIdentificacion> tipoidentificacionsForeignKey=new ArrayList<TipoIdentificacion>();
			TipoIdentificacionLogic tipoidentificacionLogic=new TipoIdentificacionLogic();
			tipoidentificacionLogic.setConnexion(this.connexion);
			tipoidentificacionLogic.getTipoIdentificacionDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoIdentificacion.equals("NONE")) {
				tipoidentificacionLogic.getTodosTipoIdentificacions(finalQueryGlobalTipoIdentificacion,new Pagination());
				tipoidentificacionsForeignKey=tipoidentificacionLogic.getTipoIdentificacions();
			}

			parametrocarteradefectoReturnGeneral.settipoidentificacionsForeignKey(tipoidentificacionsForeignKey);


			List<TipoNivelEdu> tiponiveledusForeignKey=new ArrayList<TipoNivelEdu>();
			TipoNivelEduLogic tiponiveleduLogic=new TipoNivelEduLogic();
			tiponiveleduLogic.setConnexion(this.connexion);
			//tiponiveleduLogic.getTipoNivelEduDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoNivelEdu.equals("NONE")) {
				tiponiveleduLogic.getTodosTipoNivelEdus(finalQueryGlobalTipoNivelEdu,new Pagination());
				tiponiveledusForeignKey=tiponiveleduLogic.getTipoNivelEdus();
			}

			parametrocarteradefectoReturnGeneral.settiponiveledusForeignKey(tiponiveledusForeignKey);


			List<Pais> paisnacionalidadsForeignKey=new ArrayList<Pais>();
			PaisLogic paisnacionalidadLogic=new PaisLogic();
			paisnacionalidadLogic.setConnexion(this.connexion);
			paisnacionalidadLogic.getPaisDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPaisNacionalidad.equals("NONE")) {
				paisnacionalidadLogic.getTodosPaiss(finalQueryGlobalPaisNacionalidad,new Pagination());
				paisnacionalidadsForeignKey=paisnacionalidadLogic.getPaiss();
			}

			parametrocarteradefectoReturnGeneral.setpaisnacionalidadsForeignKey(paisnacionalidadsForeignKey);


			List<TipoGenero> tipogenerosForeignKey=new ArrayList<TipoGenero>();
			TipoGeneroLogic tipogeneroLogic=new TipoGeneroLogic();
			tipogeneroLogic.setConnexion(this.connexion);
			tipogeneroLogic.getTipoGeneroDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoGenero.equals("NONE")) {
				tipogeneroLogic.getTodosTipoGeneros(finalQueryGlobalTipoGenero,new Pagination());
				tipogenerosForeignKey=tipogeneroLogic.getTipoGeneros();
			}

			parametrocarteradefectoReturnGeneral.settipogenerosForeignKey(tipogenerosForeignKey);


			List<EstadoCivil> estadocivilsForeignKey=new ArrayList<EstadoCivil>();
			EstadoCivilLogic estadocivilLogic=new EstadoCivilLogic();
			estadocivilLogic.setConnexion(this.connexion);
			estadocivilLogic.getEstadoCivilDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEstadoCivil.equals("NONE")) {
				estadocivilLogic.getTodosEstadoCivils(finalQueryGlobalEstadoCivil,new Pagination());
				estadocivilsForeignKey=estadocivilLogic.getEstadoCivils();
			}

			parametrocarteradefectoReturnGeneral.setestadocivilsForeignKey(estadocivilsForeignKey);


			List<EstadoLegal> estadolegalsForeignKey=new ArrayList<EstadoLegal>();
			EstadoLegalLogic estadolegalLogic=new EstadoLegalLogic();
			estadolegalLogic.setConnexion(this.connexion);
			estadolegalLogic.getEstadoLegalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEstadoLegal.equals("NONE")) {
				estadolegalLogic.getTodosEstadoLegals(finalQueryGlobalEstadoLegal,new Pagination());
				estadolegalsForeignKey=estadolegalLogic.getEstadoLegals();
			}

			parametrocarteradefectoReturnGeneral.setestadolegalsForeignKey(estadolegalsForeignKey);


			List<CuentaContable> cuentacontablesForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontableLogic=new CuentaContableLogic();
			cuentacontableLogic.setConnexion(this.connexion);
			cuentacontableLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContable.equals("NONE")) {
				cuentacontableLogic.getTodosCuentaContables(finalQueryGlobalCuentaContable,new Pagination());
				cuentacontablesForeignKey=cuentacontableLogic.getCuentaContables();
			}

			parametrocarteradefectoReturnGeneral.setcuentacontablesForeignKey(cuentacontablesForeignKey);


			List<Vendedor> vendedorsForeignKey=new ArrayList<Vendedor>();
			VendedorLogic vendedorLogic=new VendedorLogic();
			vendedorLogic.setConnexion(this.connexion);
			vendedorLogic.getVendedorDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalVendedor.equals("NONE")) {
				vendedorLogic.getTodosVendedors(finalQueryGlobalVendedor,new Pagination());
				vendedorsForeignKey=vendedorLogic.getVendedors();
			}

			parametrocarteradefectoReturnGeneral.setvendedorsForeignKey(vendedorsForeignKey);


			List<Ruta> rutasForeignKey=new ArrayList<Ruta>();
			RutaLogic rutaLogic=new RutaLogic();
			rutaLogic.setConnexion(this.connexion);
			rutaLogic.getRutaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalRuta.equals("NONE")) {
				rutaLogic.getTodosRutas(finalQueryGlobalRuta,new Pagination());
				rutasForeignKey=rutaLogic.getRutas();
			}

			parametrocarteradefectoReturnGeneral.setrutasForeignKey(rutasForeignKey);


			List<Dia> diasForeignKey=new ArrayList<Dia>();
			DiaLogic diaLogic=new DiaLogic();
			diaLogic.setConnexion(this.connexion);
			diaLogic.getDiaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalDia.equals("NONE")) {
				diaLogic.getTodosDias(finalQueryGlobalDia,new Pagination());
				diasForeignKey=diaLogic.getDias();
			}

			parametrocarteradefectoReturnGeneral.setdiasForeignKey(diasForeignKey);


			List<TipoPrecio> tipopreciosForeignKey=new ArrayList<TipoPrecio>();
			TipoPrecioLogic tipoprecioLogic=new TipoPrecioLogic();
			tipoprecioLogic.setConnexion(this.connexion);
			tipoprecioLogic.getTipoPrecioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoPrecio.equals("NONE")) {
				tipoprecioLogic.getTodosTipoPrecios(finalQueryGlobalTipoPrecio,new Pagination());
				tipopreciosForeignKey=tipoprecioLogic.getTipoPrecios();
			}

			parametrocarteradefectoReturnGeneral.settipopreciosForeignKey(tipopreciosForeignKey);


			List<TipoListaPrecio> tipolistapreciosForeignKey=new ArrayList<TipoListaPrecio>();
			TipoListaPrecioLogic tipolistaprecioLogic=new TipoListaPrecioLogic();
			tipolistaprecioLogic.setConnexion(this.connexion);
			tipolistaprecioLogic.getTipoListaPrecioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoListaPrecio.equals("NONE")) {
				tipolistaprecioLogic.getTodosTipoListaPrecios(finalQueryGlobalTipoListaPrecio,new Pagination());
				tipolistapreciosForeignKey=tipolistaprecioLogic.getTipoListaPrecios();
			}

			parametrocarteradefectoReturnGeneral.settipolistapreciosForeignKey(tipolistapreciosForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return parametrocarteradefectoReturnGeneral;
	}
	
	
	public void deepLoad(ParametroCarteraDefecto parametrocarteradefecto,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			ParametroCarteraDefectoLogicAdditional.updateParametroCarteraDefectoToGet(parametrocarteradefecto,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		parametrocarteradefecto.setEmpresa(parametrocarteradefectoDataAccess.getEmpresa(connexion,parametrocarteradefecto));
		parametrocarteradefecto.setSucursal(parametrocarteradefectoDataAccess.getSucursal(connexion,parametrocarteradefecto));
		parametrocarteradefecto.setPais(parametrocarteradefectoDataAccess.getPais(connexion,parametrocarteradefecto));
		parametrocarteradefecto.setRegion(parametrocarteradefectoDataAccess.getRegion(connexion,parametrocarteradefecto));
		parametrocarteradefecto.setProvincia(parametrocarteradefectoDataAccess.getProvincia(connexion,parametrocarteradefecto));
		parametrocarteradefecto.setCiudad(parametrocarteradefectoDataAccess.getCiudad(connexion,parametrocarteradefecto));
		parametrocarteradefecto.setZona(parametrocarteradefectoDataAccess.getZona(connexion,parametrocarteradefecto));
		parametrocarteradefecto.setTipoIdentificacion(parametrocarteradefectoDataAccess.getTipoIdentificacion(connexion,parametrocarteradefecto));
		parametrocarteradefecto.setTipoNivelEdu(parametrocarteradefectoDataAccess.getTipoNivelEdu(connexion,parametrocarteradefecto));
		parametrocarteradefecto.setPaisNacionalidad(parametrocarteradefectoDataAccess.getPaisNacionalidad(connexion,parametrocarteradefecto));
		parametrocarteradefecto.setTipoGenero(parametrocarteradefectoDataAccess.getTipoGenero(connexion,parametrocarteradefecto));
		parametrocarteradefecto.setEstadoCivil(parametrocarteradefectoDataAccess.getEstadoCivil(connexion,parametrocarteradefecto));
		parametrocarteradefecto.setEstadoLegal(parametrocarteradefectoDataAccess.getEstadoLegal(connexion,parametrocarteradefecto));
		parametrocarteradefecto.setCuentaContable(parametrocarteradefectoDataAccess.getCuentaContable(connexion,parametrocarteradefecto));
		parametrocarteradefecto.setVendedor(parametrocarteradefectoDataAccess.getVendedor(connexion,parametrocarteradefecto));
		parametrocarteradefecto.setRuta(parametrocarteradefectoDataAccess.getRuta(connexion,parametrocarteradefecto));
		parametrocarteradefecto.setDia(parametrocarteradefectoDataAccess.getDia(connexion,parametrocarteradefecto));
		parametrocarteradefecto.setTipoPrecio(parametrocarteradefectoDataAccess.getTipoPrecio(connexion,parametrocarteradefecto));
		parametrocarteradefecto.setTipoListaPrecio(parametrocarteradefectoDataAccess.getTipoListaPrecio(connexion,parametrocarteradefecto));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				parametrocarteradefecto.setEmpresa(parametrocarteradefectoDataAccess.getEmpresa(connexion,parametrocarteradefecto));
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				parametrocarteradefecto.setSucursal(parametrocarteradefectoDataAccess.getSucursal(connexion,parametrocarteradefecto));
				continue;
			}

			if(clas.clas.equals(Pais.class)) {
				parametrocarteradefecto.setPais(parametrocarteradefectoDataAccess.getPais(connexion,parametrocarteradefecto));
				continue;
			}

			if(clas.clas.equals(Region.class)) {
				parametrocarteradefecto.setRegion(parametrocarteradefectoDataAccess.getRegion(connexion,parametrocarteradefecto));
				continue;
			}

			if(clas.clas.equals(Provincia.class)) {
				parametrocarteradefecto.setProvincia(parametrocarteradefectoDataAccess.getProvincia(connexion,parametrocarteradefecto));
				continue;
			}

			if(clas.clas.equals(Ciudad.class)) {
				parametrocarteradefecto.setCiudad(parametrocarteradefectoDataAccess.getCiudad(connexion,parametrocarteradefecto));
				continue;
			}

			if(clas.clas.equals(Zona.class)) {
				parametrocarteradefecto.setZona(parametrocarteradefectoDataAccess.getZona(connexion,parametrocarteradefecto));
				continue;
			}

			if(clas.clas.equals(TipoIdentificacion.class)) {
				parametrocarteradefecto.setTipoIdentificacion(parametrocarteradefectoDataAccess.getTipoIdentificacion(connexion,parametrocarteradefecto));
				continue;
			}

			if(clas.clas.equals(TipoNivelEdu.class)) {
				parametrocarteradefecto.setTipoNivelEdu(parametrocarteradefectoDataAccess.getTipoNivelEdu(connexion,parametrocarteradefecto));
				continue;
			}

			if(clas.clas.equals(Pais.class)) {
				parametrocarteradefecto.setPaisNacionalidad(parametrocarteradefectoDataAccess.getPaisNacionalidad(connexion,parametrocarteradefecto));
				continue;
			}

			if(clas.clas.equals(TipoGenero.class)) {
				parametrocarteradefecto.setTipoGenero(parametrocarteradefectoDataAccess.getTipoGenero(connexion,parametrocarteradefecto));
				continue;
			}

			if(clas.clas.equals(EstadoCivil.class)) {
				parametrocarteradefecto.setEstadoCivil(parametrocarteradefectoDataAccess.getEstadoCivil(connexion,parametrocarteradefecto));
				continue;
			}

			if(clas.clas.equals(EstadoLegal.class)) {
				parametrocarteradefecto.setEstadoLegal(parametrocarteradefectoDataAccess.getEstadoLegal(connexion,parametrocarteradefecto));
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				parametrocarteradefecto.setCuentaContable(parametrocarteradefectoDataAccess.getCuentaContable(connexion,parametrocarteradefecto));
				continue;
			}

			if(clas.clas.equals(Vendedor.class)) {
				parametrocarteradefecto.setVendedor(parametrocarteradefectoDataAccess.getVendedor(connexion,parametrocarteradefecto));
				continue;
			}

			if(clas.clas.equals(Ruta.class)) {
				parametrocarteradefecto.setRuta(parametrocarteradefectoDataAccess.getRuta(connexion,parametrocarteradefecto));
				continue;
			}

			if(clas.clas.equals(Dia.class)) {
				parametrocarteradefecto.setDia(parametrocarteradefectoDataAccess.getDia(connexion,parametrocarteradefecto));
				continue;
			}

			if(clas.clas.equals(TipoPrecio.class)) {
				parametrocarteradefecto.setTipoPrecio(parametrocarteradefectoDataAccess.getTipoPrecio(connexion,parametrocarteradefecto));
				continue;
			}

			if(clas.clas.equals(TipoListaPrecio.class)) {
				parametrocarteradefecto.setTipoListaPrecio(parametrocarteradefectoDataAccess.getTipoListaPrecio(connexion,parametrocarteradefecto));
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
			parametrocarteradefecto.setEmpresa(parametrocarteradefectoDataAccess.getEmpresa(connexion,parametrocarteradefecto));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrocarteradefecto.setSucursal(parametrocarteradefectoDataAccess.getSucursal(connexion,parametrocarteradefecto));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Pais.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrocarteradefecto.setPais(parametrocarteradefectoDataAccess.getPais(connexion,parametrocarteradefecto));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Region.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrocarteradefecto.setRegion(parametrocarteradefectoDataAccess.getRegion(connexion,parametrocarteradefecto));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Provincia.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrocarteradefecto.setProvincia(parametrocarteradefectoDataAccess.getProvincia(connexion,parametrocarteradefecto));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Ciudad.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrocarteradefecto.setCiudad(parametrocarteradefectoDataAccess.getCiudad(connexion,parametrocarteradefecto));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Zona.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrocarteradefecto.setZona(parametrocarteradefectoDataAccess.getZona(connexion,parametrocarteradefecto));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoIdentificacion.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrocarteradefecto.setTipoIdentificacion(parametrocarteradefectoDataAccess.getTipoIdentificacion(connexion,parametrocarteradefecto));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoNivelEdu.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrocarteradefecto.setTipoNivelEdu(parametrocarteradefectoDataAccess.getTipoNivelEdu(connexion,parametrocarteradefecto));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Pais.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrocarteradefecto.setPaisNacionalidad(parametrocarteradefectoDataAccess.getPaisNacionalidad(connexion,parametrocarteradefecto));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoGenero.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrocarteradefecto.setTipoGenero(parametrocarteradefectoDataAccess.getTipoGenero(connexion,parametrocarteradefecto));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(EstadoCivil.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrocarteradefecto.setEstadoCivil(parametrocarteradefectoDataAccess.getEstadoCivil(connexion,parametrocarteradefecto));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(EstadoLegal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrocarteradefecto.setEstadoLegal(parametrocarteradefectoDataAccess.getEstadoLegal(connexion,parametrocarteradefecto));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrocarteradefecto.setCuentaContable(parametrocarteradefectoDataAccess.getCuentaContable(connexion,parametrocarteradefecto));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Vendedor.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrocarteradefecto.setVendedor(parametrocarteradefectoDataAccess.getVendedor(connexion,parametrocarteradefecto));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Ruta.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrocarteradefecto.setRuta(parametrocarteradefectoDataAccess.getRuta(connexion,parametrocarteradefecto));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Dia.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrocarteradefecto.setDia(parametrocarteradefectoDataAccess.getDia(connexion,parametrocarteradefecto));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoPrecio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrocarteradefecto.setTipoPrecio(parametrocarteradefectoDataAccess.getTipoPrecio(connexion,parametrocarteradefecto));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoListaPrecio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrocarteradefecto.setTipoListaPrecio(parametrocarteradefectoDataAccess.getTipoListaPrecio(connexion,parametrocarteradefecto));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		parametrocarteradefecto.setEmpresa(parametrocarteradefectoDataAccess.getEmpresa(connexion,parametrocarteradefecto));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(parametrocarteradefecto.getEmpresa(),isDeep,deepLoadType,clases);
				
		parametrocarteradefecto.setSucursal(parametrocarteradefectoDataAccess.getSucursal(connexion,parametrocarteradefecto));
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(parametrocarteradefecto.getSucursal(),isDeep,deepLoadType,clases);
				
		parametrocarteradefecto.setPais(parametrocarteradefectoDataAccess.getPais(connexion,parametrocarteradefecto));
		PaisLogic paisLogic= new PaisLogic(connexion);
		paisLogic.deepLoad(parametrocarteradefecto.getPais(),isDeep,deepLoadType,clases);
				
		parametrocarteradefecto.setRegion(parametrocarteradefectoDataAccess.getRegion(connexion,parametrocarteradefecto));
		RegionLogic regionLogic= new RegionLogic(connexion);
		regionLogic.deepLoad(parametrocarteradefecto.getRegion(),isDeep,deepLoadType,clases);
				
		parametrocarteradefecto.setProvincia(parametrocarteradefectoDataAccess.getProvincia(connexion,parametrocarteradefecto));
		ProvinciaLogic provinciaLogic= new ProvinciaLogic(connexion);
		provinciaLogic.deepLoad(parametrocarteradefecto.getProvincia(),isDeep,deepLoadType,clases);
				
		parametrocarteradefecto.setCiudad(parametrocarteradefectoDataAccess.getCiudad(connexion,parametrocarteradefecto));
		CiudadLogic ciudadLogic= new CiudadLogic(connexion);
		ciudadLogic.deepLoad(parametrocarteradefecto.getCiudad(),isDeep,deepLoadType,clases);
				
		parametrocarteradefecto.setZona(parametrocarteradefectoDataAccess.getZona(connexion,parametrocarteradefecto));
		ZonaLogic zonaLogic= new ZonaLogic(connexion);
		zonaLogic.deepLoad(parametrocarteradefecto.getZona(),isDeep,deepLoadType,clases);
				
		parametrocarteradefecto.setTipoIdentificacion(parametrocarteradefectoDataAccess.getTipoIdentificacion(connexion,parametrocarteradefecto));
		TipoIdentificacionLogic tipoidentificacionLogic= new TipoIdentificacionLogic(connexion);
		tipoidentificacionLogic.deepLoad(parametrocarteradefecto.getTipoIdentificacion(),isDeep,deepLoadType,clases);
				
		parametrocarteradefecto.setTipoNivelEdu(parametrocarteradefectoDataAccess.getTipoNivelEdu(connexion,parametrocarteradefecto));
		TipoNivelEduLogic tiponiveleduLogic= new TipoNivelEduLogic(connexion);
		tiponiveleduLogic.deepLoad(parametrocarteradefecto.getTipoNivelEdu(),isDeep,deepLoadType,clases);
				
		parametrocarteradefecto.setPaisNacionalidad(parametrocarteradefectoDataAccess.getPaisNacionalidad(connexion,parametrocarteradefecto));
		PaisLogic paisnacionalidadLogic= new PaisLogic(connexion);
		paisnacionalidadLogic.deepLoad(parametrocarteradefecto.getPaisNacionalidad(),isDeep,deepLoadType,clases);
				
		parametrocarteradefecto.setTipoGenero(parametrocarteradefectoDataAccess.getTipoGenero(connexion,parametrocarteradefecto));
		TipoGeneroLogic tipogeneroLogic= new TipoGeneroLogic(connexion);
		tipogeneroLogic.deepLoad(parametrocarteradefecto.getTipoGenero(),isDeep,deepLoadType,clases);
				
		parametrocarteradefecto.setEstadoCivil(parametrocarteradefectoDataAccess.getEstadoCivil(connexion,parametrocarteradefecto));
		EstadoCivilLogic estadocivilLogic= new EstadoCivilLogic(connexion);
		estadocivilLogic.deepLoad(parametrocarteradefecto.getEstadoCivil(),isDeep,deepLoadType,clases);
				
		parametrocarteradefecto.setEstadoLegal(parametrocarteradefectoDataAccess.getEstadoLegal(connexion,parametrocarteradefecto));
		EstadoLegalLogic estadolegalLogic= new EstadoLegalLogic(connexion);
		estadolegalLogic.deepLoad(parametrocarteradefecto.getEstadoLegal(),isDeep,deepLoadType,clases);
				
		parametrocarteradefecto.setCuentaContable(parametrocarteradefectoDataAccess.getCuentaContable(connexion,parametrocarteradefecto));
		CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
		cuentacontableLogic.deepLoad(parametrocarteradefecto.getCuentaContable(),isDeep,deepLoadType,clases);
				
		parametrocarteradefecto.setVendedor(parametrocarteradefectoDataAccess.getVendedor(connexion,parametrocarteradefecto));
		VendedorLogic vendedorLogic= new VendedorLogic(connexion);
		vendedorLogic.deepLoad(parametrocarteradefecto.getVendedor(),isDeep,deepLoadType,clases);
				
		parametrocarteradefecto.setRuta(parametrocarteradefectoDataAccess.getRuta(connexion,parametrocarteradefecto));
		RutaLogic rutaLogic= new RutaLogic(connexion);
		rutaLogic.deepLoad(parametrocarteradefecto.getRuta(),isDeep,deepLoadType,clases);
				
		parametrocarteradefecto.setDia(parametrocarteradefectoDataAccess.getDia(connexion,parametrocarteradefecto));
		DiaLogic diaLogic= new DiaLogic(connexion);
		diaLogic.deepLoad(parametrocarteradefecto.getDia(),isDeep,deepLoadType,clases);
				
		parametrocarteradefecto.setTipoPrecio(parametrocarteradefectoDataAccess.getTipoPrecio(connexion,parametrocarteradefecto));
		TipoPrecioLogic tipoprecioLogic= new TipoPrecioLogic(connexion);
		tipoprecioLogic.deepLoad(parametrocarteradefecto.getTipoPrecio(),isDeep,deepLoadType,clases);
				
		parametrocarteradefecto.setTipoListaPrecio(parametrocarteradefectoDataAccess.getTipoListaPrecio(connexion,parametrocarteradefecto));
		TipoListaPrecioLogic tipolistaprecioLogic= new TipoListaPrecioLogic(connexion);
		tipolistaprecioLogic.deepLoad(parametrocarteradefecto.getTipoListaPrecio(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				parametrocarteradefecto.setEmpresa(parametrocarteradefectoDataAccess.getEmpresa(connexion,parametrocarteradefecto));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(parametrocarteradefecto.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				parametrocarteradefecto.setSucursal(parametrocarteradefectoDataAccess.getSucursal(connexion,parametrocarteradefecto));
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepLoad(parametrocarteradefecto.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Pais.class)) {
				parametrocarteradefecto.setPais(parametrocarteradefectoDataAccess.getPais(connexion,parametrocarteradefecto));
				PaisLogic paisLogic= new PaisLogic(connexion);
				paisLogic.deepLoad(parametrocarteradefecto.getPais(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Region.class)) {
				parametrocarteradefecto.setRegion(parametrocarteradefectoDataAccess.getRegion(connexion,parametrocarteradefecto));
				RegionLogic regionLogic= new RegionLogic(connexion);
				regionLogic.deepLoad(parametrocarteradefecto.getRegion(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Provincia.class)) {
				parametrocarteradefecto.setProvincia(parametrocarteradefectoDataAccess.getProvincia(connexion,parametrocarteradefecto));
				ProvinciaLogic provinciaLogic= new ProvinciaLogic(connexion);
				provinciaLogic.deepLoad(parametrocarteradefecto.getProvincia(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Ciudad.class)) {
				parametrocarteradefecto.setCiudad(parametrocarteradefectoDataAccess.getCiudad(connexion,parametrocarteradefecto));
				CiudadLogic ciudadLogic= new CiudadLogic(connexion);
				ciudadLogic.deepLoad(parametrocarteradefecto.getCiudad(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Zona.class)) {
				parametrocarteradefecto.setZona(parametrocarteradefectoDataAccess.getZona(connexion,parametrocarteradefecto));
				ZonaLogic zonaLogic= new ZonaLogic(connexion);
				zonaLogic.deepLoad(parametrocarteradefecto.getZona(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoIdentificacion.class)) {
				parametrocarteradefecto.setTipoIdentificacion(parametrocarteradefectoDataAccess.getTipoIdentificacion(connexion,parametrocarteradefecto));
				TipoIdentificacionLogic tipoidentificacionLogic= new TipoIdentificacionLogic(connexion);
				tipoidentificacionLogic.deepLoad(parametrocarteradefecto.getTipoIdentificacion(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoNivelEdu.class)) {
				parametrocarteradefecto.setTipoNivelEdu(parametrocarteradefectoDataAccess.getTipoNivelEdu(connexion,parametrocarteradefecto));
				TipoNivelEduLogic tiponiveleduLogic= new TipoNivelEduLogic(connexion);
				tiponiveleduLogic.deepLoad(parametrocarteradefecto.getTipoNivelEdu(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Pais.class)) {
				parametrocarteradefecto.setPaisNacionalidad(parametrocarteradefectoDataAccess.getPaisNacionalidad(connexion,parametrocarteradefecto));
				PaisLogic paisLogic= new PaisLogic(connexion);
				paisLogic.deepLoad(parametrocarteradefecto.getPaisNacionalidad(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoGenero.class)) {
				parametrocarteradefecto.setTipoGenero(parametrocarteradefectoDataAccess.getTipoGenero(connexion,parametrocarteradefecto));
				TipoGeneroLogic tipogeneroLogic= new TipoGeneroLogic(connexion);
				tipogeneroLogic.deepLoad(parametrocarteradefecto.getTipoGenero(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(EstadoCivil.class)) {
				parametrocarteradefecto.setEstadoCivil(parametrocarteradefectoDataAccess.getEstadoCivil(connexion,parametrocarteradefecto));
				EstadoCivilLogic estadocivilLogic= new EstadoCivilLogic(connexion);
				estadocivilLogic.deepLoad(parametrocarteradefecto.getEstadoCivil(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(EstadoLegal.class)) {
				parametrocarteradefecto.setEstadoLegal(parametrocarteradefectoDataAccess.getEstadoLegal(connexion,parametrocarteradefecto));
				EstadoLegalLogic estadolegalLogic= new EstadoLegalLogic(connexion);
				estadolegalLogic.deepLoad(parametrocarteradefecto.getEstadoLegal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				parametrocarteradefecto.setCuentaContable(parametrocarteradefectoDataAccess.getCuentaContable(connexion,parametrocarteradefecto));
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepLoad(parametrocarteradefecto.getCuentaContable(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Vendedor.class)) {
				parametrocarteradefecto.setVendedor(parametrocarteradefectoDataAccess.getVendedor(connexion,parametrocarteradefecto));
				VendedorLogic vendedorLogic= new VendedorLogic(connexion);
				vendedorLogic.deepLoad(parametrocarteradefecto.getVendedor(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Ruta.class)) {
				parametrocarteradefecto.setRuta(parametrocarteradefectoDataAccess.getRuta(connexion,parametrocarteradefecto));
				RutaLogic rutaLogic= new RutaLogic(connexion);
				rutaLogic.deepLoad(parametrocarteradefecto.getRuta(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Dia.class)) {
				parametrocarteradefecto.setDia(parametrocarteradefectoDataAccess.getDia(connexion,parametrocarteradefecto));
				DiaLogic diaLogic= new DiaLogic(connexion);
				diaLogic.deepLoad(parametrocarteradefecto.getDia(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoPrecio.class)) {
				parametrocarteradefecto.setTipoPrecio(parametrocarteradefectoDataAccess.getTipoPrecio(connexion,parametrocarteradefecto));
				TipoPrecioLogic tipoprecioLogic= new TipoPrecioLogic(connexion);
				tipoprecioLogic.deepLoad(parametrocarteradefecto.getTipoPrecio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoListaPrecio.class)) {
				parametrocarteradefecto.setTipoListaPrecio(parametrocarteradefectoDataAccess.getTipoListaPrecio(connexion,parametrocarteradefecto));
				TipoListaPrecioLogic tipolistaprecioLogic= new TipoListaPrecioLogic(connexion);
				tipolistaprecioLogic.deepLoad(parametrocarteradefecto.getTipoListaPrecio(),isDeep,deepLoadType,clases);				
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
			parametrocarteradefecto.setEmpresa(parametrocarteradefectoDataAccess.getEmpresa(connexion,parametrocarteradefecto));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(parametrocarteradefecto.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrocarteradefecto.setSucursal(parametrocarteradefectoDataAccess.getSucursal(connexion,parametrocarteradefecto));
			SucursalLogic sucursalLogic= new SucursalLogic(connexion);
			sucursalLogic.deepLoad(parametrocarteradefecto.getSucursal(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Pais.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrocarteradefecto.setPais(parametrocarteradefectoDataAccess.getPais(connexion,parametrocarteradefecto));
			PaisLogic paisLogic= new PaisLogic(connexion);
			paisLogic.deepLoad(parametrocarteradefecto.getPais(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Region.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrocarteradefecto.setRegion(parametrocarteradefectoDataAccess.getRegion(connexion,parametrocarteradefecto));
			RegionLogic regionLogic= new RegionLogic(connexion);
			regionLogic.deepLoad(parametrocarteradefecto.getRegion(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Provincia.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrocarteradefecto.setProvincia(parametrocarteradefectoDataAccess.getProvincia(connexion,parametrocarteradefecto));
			ProvinciaLogic provinciaLogic= new ProvinciaLogic(connexion);
			provinciaLogic.deepLoad(parametrocarteradefecto.getProvincia(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Ciudad.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrocarteradefecto.setCiudad(parametrocarteradefectoDataAccess.getCiudad(connexion,parametrocarteradefecto));
			CiudadLogic ciudadLogic= new CiudadLogic(connexion);
			ciudadLogic.deepLoad(parametrocarteradefecto.getCiudad(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Zona.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrocarteradefecto.setZona(parametrocarteradefectoDataAccess.getZona(connexion,parametrocarteradefecto));
			ZonaLogic zonaLogic= new ZonaLogic(connexion);
			zonaLogic.deepLoad(parametrocarteradefecto.getZona(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoIdentificacion.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrocarteradefecto.setTipoIdentificacion(parametrocarteradefectoDataAccess.getTipoIdentificacion(connexion,parametrocarteradefecto));
			TipoIdentificacionLogic tipoidentificacionLogic= new TipoIdentificacionLogic(connexion);
			tipoidentificacionLogic.deepLoad(parametrocarteradefecto.getTipoIdentificacion(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoNivelEdu.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrocarteradefecto.setTipoNivelEdu(parametrocarteradefectoDataAccess.getTipoNivelEdu(connexion,parametrocarteradefecto));
			TipoNivelEduLogic tiponiveleduLogic= new TipoNivelEduLogic(connexion);
			tiponiveleduLogic.deepLoad(parametrocarteradefecto.getTipoNivelEdu(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Pais.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrocarteradefecto.setPaisNacionalidad(parametrocarteradefectoDataAccess.getPaisNacionalidad(connexion,parametrocarteradefecto));
			PaisLogic paisLogic= new PaisLogic(connexion);
			paisLogic.deepLoad(parametrocarteradefecto.getPaisNacionalidad(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoGenero.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrocarteradefecto.setTipoGenero(parametrocarteradefectoDataAccess.getTipoGenero(connexion,parametrocarteradefecto));
			TipoGeneroLogic tipogeneroLogic= new TipoGeneroLogic(connexion);
			tipogeneroLogic.deepLoad(parametrocarteradefecto.getTipoGenero(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(EstadoCivil.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrocarteradefecto.setEstadoCivil(parametrocarteradefectoDataAccess.getEstadoCivil(connexion,parametrocarteradefecto));
			EstadoCivilLogic estadocivilLogic= new EstadoCivilLogic(connexion);
			estadocivilLogic.deepLoad(parametrocarteradefecto.getEstadoCivil(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(EstadoLegal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrocarteradefecto.setEstadoLegal(parametrocarteradefectoDataAccess.getEstadoLegal(connexion,parametrocarteradefecto));
			EstadoLegalLogic estadolegalLogic= new EstadoLegalLogic(connexion);
			estadolegalLogic.deepLoad(parametrocarteradefecto.getEstadoLegal(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrocarteradefecto.setCuentaContable(parametrocarteradefectoDataAccess.getCuentaContable(connexion,parametrocarteradefecto));
			CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
			cuentacontableLogic.deepLoad(parametrocarteradefecto.getCuentaContable(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Vendedor.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrocarteradefecto.setVendedor(parametrocarteradefectoDataAccess.getVendedor(connexion,parametrocarteradefecto));
			VendedorLogic vendedorLogic= new VendedorLogic(connexion);
			vendedorLogic.deepLoad(parametrocarteradefecto.getVendedor(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Ruta.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrocarteradefecto.setRuta(parametrocarteradefectoDataAccess.getRuta(connexion,parametrocarteradefecto));
			RutaLogic rutaLogic= new RutaLogic(connexion);
			rutaLogic.deepLoad(parametrocarteradefecto.getRuta(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Dia.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrocarteradefecto.setDia(parametrocarteradefectoDataAccess.getDia(connexion,parametrocarteradefecto));
			DiaLogic diaLogic= new DiaLogic(connexion);
			diaLogic.deepLoad(parametrocarteradefecto.getDia(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoPrecio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrocarteradefecto.setTipoPrecio(parametrocarteradefectoDataAccess.getTipoPrecio(connexion,parametrocarteradefecto));
			TipoPrecioLogic tipoprecioLogic= new TipoPrecioLogic(connexion);
			tipoprecioLogic.deepLoad(parametrocarteradefecto.getTipoPrecio(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoListaPrecio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrocarteradefecto.setTipoListaPrecio(parametrocarteradefectoDataAccess.getTipoListaPrecio(connexion,parametrocarteradefecto));
			TipoListaPrecioLogic tipolistaprecioLogic= new TipoListaPrecioLogic(connexion);
			tipolistaprecioLogic.deepLoad(parametrocarteradefecto.getTipoListaPrecio(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(ParametroCarteraDefecto parametrocarteradefecto,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			ParametroCarteraDefectoLogicAdditional.updateParametroCarteraDefectoToSave(parametrocarteradefecto,this.arrDatoGeneral);
			
ParametroCarteraDefectoDataAccess.save(parametrocarteradefecto, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(parametrocarteradefecto.getEmpresa(),connexion);

		SucursalDataAccess.save(parametrocarteradefecto.getSucursal(),connexion);

		PaisDataAccess.save(parametrocarteradefecto.getPais(),connexion);

		RegionDataAccess.save(parametrocarteradefecto.getRegion(),connexion);

		ProvinciaDataAccess.save(parametrocarteradefecto.getProvincia(),connexion);

		CiudadDataAccess.save(parametrocarteradefecto.getCiudad(),connexion);

		ZonaDataAccess.save(parametrocarteradefecto.getZona(),connexion);

		TipoIdentificacionDataAccess.save(parametrocarteradefecto.getTipoIdentificacion(),connexion);

		TipoNivelEduDataAccess.save(parametrocarteradefecto.getTipoNivelEdu(),connexion);

		PaisDataAccess.save(parametrocarteradefecto.getPaisNacionalidad(),connexion);

		TipoGeneroDataAccess.save(parametrocarteradefecto.getTipoGenero(),connexion);

		EstadoCivilDataAccess.save(parametrocarteradefecto.getEstadoCivil(),connexion);

		EstadoLegalDataAccess.save(parametrocarteradefecto.getEstadoLegal(),connexion);

		CuentaContableDataAccess.save(parametrocarteradefecto.getCuentaContable(),connexion);

		VendedorDataAccess.save(parametrocarteradefecto.getVendedor(),connexion);

		RutaDataAccess.save(parametrocarteradefecto.getRuta(),connexion);

		DiaDataAccess.save(parametrocarteradefecto.getDia(),connexion);

		TipoPrecioDataAccess.save(parametrocarteradefecto.getTipoPrecio(),connexion);

		TipoListaPrecioDataAccess.save(parametrocarteradefecto.getTipoListaPrecio(),connexion);
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(parametrocarteradefecto.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(parametrocarteradefecto.getSucursal(),connexion);
				continue;
			}

			if(clas.clas.equals(Pais.class)) {
				PaisDataAccess.save(parametrocarteradefecto.getPais(),connexion);
				continue;
			}

			if(clas.clas.equals(Region.class)) {
				RegionDataAccess.save(parametrocarteradefecto.getRegion(),connexion);
				continue;
			}

			if(clas.clas.equals(Provincia.class)) {
				ProvinciaDataAccess.save(parametrocarteradefecto.getProvincia(),connexion);
				continue;
			}

			if(clas.clas.equals(Ciudad.class)) {
				CiudadDataAccess.save(parametrocarteradefecto.getCiudad(),connexion);
				continue;
			}

			if(clas.clas.equals(Zona.class)) {
				ZonaDataAccess.save(parametrocarteradefecto.getZona(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoIdentificacion.class)) {
				TipoIdentificacionDataAccess.save(parametrocarteradefecto.getTipoIdentificacion(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoNivelEdu.class)) {
				TipoNivelEduDataAccess.save(parametrocarteradefecto.getTipoNivelEdu(),connexion);
				continue;
			}

			if(clas.clas.equals(Pais.class)) {
				PaisDataAccess.save(parametrocarteradefecto.getPaisNacionalidad(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoGenero.class)) {
				TipoGeneroDataAccess.save(parametrocarteradefecto.getTipoGenero(),connexion);
				continue;
			}

			if(clas.clas.equals(EstadoCivil.class)) {
				EstadoCivilDataAccess.save(parametrocarteradefecto.getEstadoCivil(),connexion);
				continue;
			}

			if(clas.clas.equals(EstadoLegal.class)) {
				EstadoLegalDataAccess.save(parametrocarteradefecto.getEstadoLegal(),connexion);
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(parametrocarteradefecto.getCuentaContable(),connexion);
				continue;
			}

			if(clas.clas.equals(Vendedor.class)) {
				VendedorDataAccess.save(parametrocarteradefecto.getVendedor(),connexion);
				continue;
			}

			if(clas.clas.equals(Ruta.class)) {
				RutaDataAccess.save(parametrocarteradefecto.getRuta(),connexion);
				continue;
			}

			if(clas.clas.equals(Dia.class)) {
				DiaDataAccess.save(parametrocarteradefecto.getDia(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoPrecio.class)) {
				TipoPrecioDataAccess.save(parametrocarteradefecto.getTipoPrecio(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoListaPrecio.class)) {
				TipoListaPrecioDataAccess.save(parametrocarteradefecto.getTipoListaPrecio(),connexion);
				continue;
			}

		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(parametrocarteradefecto.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(parametrocarteradefecto.getEmpresa(),isDeep,deepLoadType,clases);
				

		SucursalDataAccess.save(parametrocarteradefecto.getSucursal(),connexion);
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(parametrocarteradefecto.getSucursal(),isDeep,deepLoadType,clases);
				

		PaisDataAccess.save(parametrocarteradefecto.getPais(),connexion);
		PaisLogic paisLogic= new PaisLogic(connexion);
		paisLogic.deepLoad(parametrocarteradefecto.getPais(),isDeep,deepLoadType,clases);
				

		RegionDataAccess.save(parametrocarteradefecto.getRegion(),connexion);
		RegionLogic regionLogic= new RegionLogic(connexion);
		regionLogic.deepLoad(parametrocarteradefecto.getRegion(),isDeep,deepLoadType,clases);
				

		ProvinciaDataAccess.save(parametrocarteradefecto.getProvincia(),connexion);
		ProvinciaLogic provinciaLogic= new ProvinciaLogic(connexion);
		provinciaLogic.deepLoad(parametrocarteradefecto.getProvincia(),isDeep,deepLoadType,clases);
				

		CiudadDataAccess.save(parametrocarteradefecto.getCiudad(),connexion);
		CiudadLogic ciudadLogic= new CiudadLogic(connexion);
		ciudadLogic.deepLoad(parametrocarteradefecto.getCiudad(),isDeep,deepLoadType,clases);
				

		ZonaDataAccess.save(parametrocarteradefecto.getZona(),connexion);
		ZonaLogic zonaLogic= new ZonaLogic(connexion);
		zonaLogic.deepLoad(parametrocarteradefecto.getZona(),isDeep,deepLoadType,clases);
				

		TipoIdentificacionDataAccess.save(parametrocarteradefecto.getTipoIdentificacion(),connexion);
		TipoIdentificacionLogic tipoidentificacionLogic= new TipoIdentificacionLogic(connexion);
		tipoidentificacionLogic.deepLoad(parametrocarteradefecto.getTipoIdentificacion(),isDeep,deepLoadType,clases);
				

		TipoNivelEduDataAccess.save(parametrocarteradefecto.getTipoNivelEdu(),connexion);
		TipoNivelEduLogic tiponiveleduLogic= new TipoNivelEduLogic(connexion);
		tiponiveleduLogic.deepLoad(parametrocarteradefecto.getTipoNivelEdu(),isDeep,deepLoadType,clases);
				

		PaisDataAccess.save(parametrocarteradefecto.getPaisNacionalidad(),connexion);
		PaisLogic paisnacionalidadLogic= new PaisLogic(connexion);
		paisnacionalidadLogic.deepLoad(parametrocarteradefecto.getPaisNacionalidad(),isDeep,deepLoadType,clases);
				

		TipoGeneroDataAccess.save(parametrocarteradefecto.getTipoGenero(),connexion);
		TipoGeneroLogic tipogeneroLogic= new TipoGeneroLogic(connexion);
		tipogeneroLogic.deepLoad(parametrocarteradefecto.getTipoGenero(),isDeep,deepLoadType,clases);
				

		EstadoCivilDataAccess.save(parametrocarteradefecto.getEstadoCivil(),connexion);
		EstadoCivilLogic estadocivilLogic= new EstadoCivilLogic(connexion);
		estadocivilLogic.deepLoad(parametrocarteradefecto.getEstadoCivil(),isDeep,deepLoadType,clases);
				

		EstadoLegalDataAccess.save(parametrocarteradefecto.getEstadoLegal(),connexion);
		EstadoLegalLogic estadolegalLogic= new EstadoLegalLogic(connexion);
		estadolegalLogic.deepLoad(parametrocarteradefecto.getEstadoLegal(),isDeep,deepLoadType,clases);
				

		CuentaContableDataAccess.save(parametrocarteradefecto.getCuentaContable(),connexion);
		CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
		cuentacontableLogic.deepLoad(parametrocarteradefecto.getCuentaContable(),isDeep,deepLoadType,clases);
				

		VendedorDataAccess.save(parametrocarteradefecto.getVendedor(),connexion);
		VendedorLogic vendedorLogic= new VendedorLogic(connexion);
		vendedorLogic.deepLoad(parametrocarteradefecto.getVendedor(),isDeep,deepLoadType,clases);
				

		RutaDataAccess.save(parametrocarteradefecto.getRuta(),connexion);
		RutaLogic rutaLogic= new RutaLogic(connexion);
		rutaLogic.deepLoad(parametrocarteradefecto.getRuta(),isDeep,deepLoadType,clases);
				

		DiaDataAccess.save(parametrocarteradefecto.getDia(),connexion);
		DiaLogic diaLogic= new DiaLogic(connexion);
		diaLogic.deepLoad(parametrocarteradefecto.getDia(),isDeep,deepLoadType,clases);
				

		TipoPrecioDataAccess.save(parametrocarteradefecto.getTipoPrecio(),connexion);
		TipoPrecioLogic tipoprecioLogic= new TipoPrecioLogic(connexion);
		tipoprecioLogic.deepLoad(parametrocarteradefecto.getTipoPrecio(),isDeep,deepLoadType,clases);
				

		TipoListaPrecioDataAccess.save(parametrocarteradefecto.getTipoListaPrecio(),connexion);
		TipoListaPrecioLogic tipolistaprecioLogic= new TipoListaPrecioLogic(connexion);
		tipolistaprecioLogic.deepLoad(parametrocarteradefecto.getTipoListaPrecio(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(parametrocarteradefecto.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(parametrocarteradefecto.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(parametrocarteradefecto.getSucursal(),connexion);
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepSave(parametrocarteradefecto.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Pais.class)) {
				PaisDataAccess.save(parametrocarteradefecto.getPais(),connexion);
				PaisLogic paisLogic= new PaisLogic(connexion);
				paisLogic.deepSave(parametrocarteradefecto.getPais(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Region.class)) {
				RegionDataAccess.save(parametrocarteradefecto.getRegion(),connexion);
				RegionLogic regionLogic= new RegionLogic(connexion);
				regionLogic.deepSave(parametrocarteradefecto.getRegion(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Provincia.class)) {
				ProvinciaDataAccess.save(parametrocarteradefecto.getProvincia(),connexion);
				ProvinciaLogic provinciaLogic= new ProvinciaLogic(connexion);
				provinciaLogic.deepSave(parametrocarteradefecto.getProvincia(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Ciudad.class)) {
				CiudadDataAccess.save(parametrocarteradefecto.getCiudad(),connexion);
				CiudadLogic ciudadLogic= new CiudadLogic(connexion);
				ciudadLogic.deepSave(parametrocarteradefecto.getCiudad(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Zona.class)) {
				ZonaDataAccess.save(parametrocarteradefecto.getZona(),connexion);
				ZonaLogic zonaLogic= new ZonaLogic(connexion);
				zonaLogic.deepSave(parametrocarteradefecto.getZona(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoIdentificacion.class)) {
				TipoIdentificacionDataAccess.save(parametrocarteradefecto.getTipoIdentificacion(),connexion);
				TipoIdentificacionLogic tipoidentificacionLogic= new TipoIdentificacionLogic(connexion);
				tipoidentificacionLogic.deepSave(parametrocarteradefecto.getTipoIdentificacion(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoNivelEdu.class)) {
				TipoNivelEduDataAccess.save(parametrocarteradefecto.getTipoNivelEdu(),connexion);
				TipoNivelEduLogic tiponiveleduLogic= new TipoNivelEduLogic(connexion);
				tiponiveleduLogic.deepSave(parametrocarteradefecto.getTipoNivelEdu(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Pais.class)) {
				PaisDataAccess.save(parametrocarteradefecto.getPaisNacionalidad(),connexion);
				PaisLogic paisLogic= new PaisLogic(connexion);
				paisLogic.deepSave(parametrocarteradefecto.getPaisNacionalidad(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoGenero.class)) {
				TipoGeneroDataAccess.save(parametrocarteradefecto.getTipoGenero(),connexion);
				TipoGeneroLogic tipogeneroLogic= new TipoGeneroLogic(connexion);
				tipogeneroLogic.deepSave(parametrocarteradefecto.getTipoGenero(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(EstadoCivil.class)) {
				EstadoCivilDataAccess.save(parametrocarteradefecto.getEstadoCivil(),connexion);
				EstadoCivilLogic estadocivilLogic= new EstadoCivilLogic(connexion);
				estadocivilLogic.deepSave(parametrocarteradefecto.getEstadoCivil(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(EstadoLegal.class)) {
				EstadoLegalDataAccess.save(parametrocarteradefecto.getEstadoLegal(),connexion);
				EstadoLegalLogic estadolegalLogic= new EstadoLegalLogic(connexion);
				estadolegalLogic.deepSave(parametrocarteradefecto.getEstadoLegal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(parametrocarteradefecto.getCuentaContable(),connexion);
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepSave(parametrocarteradefecto.getCuentaContable(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Vendedor.class)) {
				VendedorDataAccess.save(parametrocarteradefecto.getVendedor(),connexion);
				VendedorLogic vendedorLogic= new VendedorLogic(connexion);
				vendedorLogic.deepSave(parametrocarteradefecto.getVendedor(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Ruta.class)) {
				RutaDataAccess.save(parametrocarteradefecto.getRuta(),connexion);
				RutaLogic rutaLogic= new RutaLogic(connexion);
				rutaLogic.deepSave(parametrocarteradefecto.getRuta(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Dia.class)) {
				DiaDataAccess.save(parametrocarteradefecto.getDia(),connexion);
				DiaLogic diaLogic= new DiaLogic(connexion);
				diaLogic.deepSave(parametrocarteradefecto.getDia(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoPrecio.class)) {
				TipoPrecioDataAccess.save(parametrocarteradefecto.getTipoPrecio(),connexion);
				TipoPrecioLogic tipoprecioLogic= new TipoPrecioLogic(connexion);
				tipoprecioLogic.deepSave(parametrocarteradefecto.getTipoPrecio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoListaPrecio.class)) {
				TipoListaPrecioDataAccess.save(parametrocarteradefecto.getTipoListaPrecio(),connexion);
				TipoListaPrecioLogic tipolistaprecioLogic= new TipoListaPrecioLogic(connexion);
				tipolistaprecioLogic.deepSave(parametrocarteradefecto.getTipoListaPrecio(),isDeep,deepLoadType,clases);				
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
			this.getNewConnexionToDeep(ParametroCarteraDefecto.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(parametrocarteradefecto,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				ParametroCarteraDefectoConstantesFunciones.refrescarForeignKeysDescripcionesParametroCarteraDefecto(parametrocarteradefecto);
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
			this.deepLoad(this.parametrocarteradefecto,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				ParametroCarteraDefectoConstantesFunciones.refrescarForeignKeysDescripcionesParametroCarteraDefecto(this.parametrocarteradefecto);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(ParametroCarteraDefecto.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(parametrocarteradefectos!=null) {
				for(ParametroCarteraDefecto parametrocarteradefecto:parametrocarteradefectos) {
					this.deepLoad(parametrocarteradefecto,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					ParametroCarteraDefectoConstantesFunciones.refrescarForeignKeysDescripcionesParametroCarteraDefecto(parametrocarteradefectos);
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
			if(parametrocarteradefectos!=null) {
				for(ParametroCarteraDefecto parametrocarteradefecto:parametrocarteradefectos) {
					this.deepLoad(parametrocarteradefecto,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					ParametroCarteraDefectoConstantesFunciones.refrescarForeignKeysDescripcionesParametroCarteraDefecto(parametrocarteradefectos);
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
			this.getNewConnexionToDeep(ParametroCarteraDefecto.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(parametrocarteradefecto,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(ParametroCarteraDefecto.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(parametrocarteradefectos!=null) {
				for(ParametroCarteraDefecto parametrocarteradefecto:parametrocarteradefectos) {
					this.deepSave(parametrocarteradefecto,isDeep,deepLoadType,clases);
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
			if(parametrocarteradefectos!=null) {
				for(ParametroCarteraDefecto parametrocarteradefecto:parametrocarteradefectos) {
					this.deepSave(parametrocarteradefecto,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getParametroCarteraDefectosFK_IdCiudadWithConnection(String sFinalQuery,Pagination pagination,Long id_ciudad)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroCarteraDefecto.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCiudad= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCiudad.setParameterSelectionGeneralEqual(ParameterType.LONG,id_ciudad,ParametroCarteraDefectoConstantesFunciones.IDCIUDAD,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCiudad);

			ParametroCarteraDefectoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCiudad","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrocarteradefectos=parametrocarteradefectoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroCarteraDefectoConstantesFunciones.refrescarForeignKeysDescripcionesParametroCarteraDefecto(this.parametrocarteradefectos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getParametroCarteraDefectosFK_IdCiudad(String sFinalQuery,Pagination pagination,Long id_ciudad)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCiudad= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCiudad.setParameterSelectionGeneralEqual(ParameterType.LONG,id_ciudad,ParametroCarteraDefectoConstantesFunciones.IDCIUDAD,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCiudad);

			ParametroCarteraDefectoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCiudad","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrocarteradefectos=parametrocarteradefectoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroCarteraDefectoConstantesFunciones.refrescarForeignKeysDescripcionesParametroCarteraDefecto(this.parametrocarteradefectos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getParametroCarteraDefectosFK_IdCuentaContableWithConnection(String sFinalQuery,Pagination pagination,Long id_cuenta_contable)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroCarteraDefecto.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContable= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContable.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable,ParametroCarteraDefectoConstantesFunciones.IDCUENTACONTABLE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContable);

			ParametroCarteraDefectoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContable","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrocarteradefectos=parametrocarteradefectoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroCarteraDefectoConstantesFunciones.refrescarForeignKeysDescripcionesParametroCarteraDefecto(this.parametrocarteradefectos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getParametroCarteraDefectosFK_IdCuentaContable(String sFinalQuery,Pagination pagination,Long id_cuenta_contable)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContable= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContable.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable,ParametroCarteraDefectoConstantesFunciones.IDCUENTACONTABLE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContable);

			ParametroCarteraDefectoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContable","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrocarteradefectos=parametrocarteradefectoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroCarteraDefectoConstantesFunciones.refrescarForeignKeysDescripcionesParametroCarteraDefecto(this.parametrocarteradefectos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getParametroCarteraDefectosFK_IdDiaWithConnection(String sFinalQuery,Pagination pagination,Long id_dia)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroCarteraDefecto.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidDia= new ParameterSelectionGeneral();
			parameterSelectionGeneralidDia.setParameterSelectionGeneralEqual(ParameterType.LONG,id_dia,ParametroCarteraDefectoConstantesFunciones.IDDIA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidDia);

			ParametroCarteraDefectoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdDia","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrocarteradefectos=parametrocarteradefectoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroCarteraDefectoConstantesFunciones.refrescarForeignKeysDescripcionesParametroCarteraDefecto(this.parametrocarteradefectos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getParametroCarteraDefectosFK_IdDia(String sFinalQuery,Pagination pagination,Long id_dia)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidDia= new ParameterSelectionGeneral();
			parameterSelectionGeneralidDia.setParameterSelectionGeneralEqual(ParameterType.LONG,id_dia,ParametroCarteraDefectoConstantesFunciones.IDDIA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidDia);

			ParametroCarteraDefectoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdDia","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrocarteradefectos=parametrocarteradefectoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroCarteraDefectoConstantesFunciones.refrescarForeignKeysDescripcionesParametroCarteraDefecto(this.parametrocarteradefectos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getParametroCarteraDefectosFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroCarteraDefecto.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,ParametroCarteraDefectoConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			ParametroCarteraDefectoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrocarteradefectos=parametrocarteradefectoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroCarteraDefectoConstantesFunciones.refrescarForeignKeysDescripcionesParametroCarteraDefecto(this.parametrocarteradefectos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getParametroCarteraDefectosFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,ParametroCarteraDefectoConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			ParametroCarteraDefectoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrocarteradefectos=parametrocarteradefectoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroCarteraDefectoConstantesFunciones.refrescarForeignKeysDescripcionesParametroCarteraDefecto(this.parametrocarteradefectos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getParametroCarteraDefectosFK_IdEstadoCivilWithConnection(String sFinalQuery,Pagination pagination,Long id_estado_civil)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroCarteraDefecto.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEstadoCivil= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEstadoCivil.setParameterSelectionGeneralEqual(ParameterType.LONG,id_estado_civil,ParametroCarteraDefectoConstantesFunciones.IDESTADOCIVIL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEstadoCivil);

			ParametroCarteraDefectoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEstadoCivil","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrocarteradefectos=parametrocarteradefectoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroCarteraDefectoConstantesFunciones.refrescarForeignKeysDescripcionesParametroCarteraDefecto(this.parametrocarteradefectos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getParametroCarteraDefectosFK_IdEstadoCivil(String sFinalQuery,Pagination pagination,Long id_estado_civil)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEstadoCivil= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEstadoCivil.setParameterSelectionGeneralEqual(ParameterType.LONG,id_estado_civil,ParametroCarteraDefectoConstantesFunciones.IDESTADOCIVIL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEstadoCivil);

			ParametroCarteraDefectoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEstadoCivil","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrocarteradefectos=parametrocarteradefectoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroCarteraDefectoConstantesFunciones.refrescarForeignKeysDescripcionesParametroCarteraDefecto(this.parametrocarteradefectos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getParametroCarteraDefectosFK_IdEstadoLegalWithConnection(String sFinalQuery,Pagination pagination,Long id_estado_legal)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroCarteraDefecto.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEstadoLegal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEstadoLegal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_estado_legal,ParametroCarteraDefectoConstantesFunciones.IDESTADOLEGAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEstadoLegal);

			ParametroCarteraDefectoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEstadoLegal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrocarteradefectos=parametrocarteradefectoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroCarteraDefectoConstantesFunciones.refrescarForeignKeysDescripcionesParametroCarteraDefecto(this.parametrocarteradefectos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getParametroCarteraDefectosFK_IdEstadoLegal(String sFinalQuery,Pagination pagination,Long id_estado_legal)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEstadoLegal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEstadoLegal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_estado_legal,ParametroCarteraDefectoConstantesFunciones.IDESTADOLEGAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEstadoLegal);

			ParametroCarteraDefectoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEstadoLegal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrocarteradefectos=parametrocarteradefectoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroCarteraDefectoConstantesFunciones.refrescarForeignKeysDescripcionesParametroCarteraDefecto(this.parametrocarteradefectos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getParametroCarteraDefectosFK_IdPaisWithConnection(String sFinalQuery,Pagination pagination,Long id_pais)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroCarteraDefecto.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPais= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPais.setParameterSelectionGeneralEqual(ParameterType.LONG,id_pais,ParametroCarteraDefectoConstantesFunciones.IDPAIS,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPais);

			ParametroCarteraDefectoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPais","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrocarteradefectos=parametrocarteradefectoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroCarteraDefectoConstantesFunciones.refrescarForeignKeysDescripcionesParametroCarteraDefecto(this.parametrocarteradefectos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getParametroCarteraDefectosFK_IdPais(String sFinalQuery,Pagination pagination,Long id_pais)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPais= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPais.setParameterSelectionGeneralEqual(ParameterType.LONG,id_pais,ParametroCarteraDefectoConstantesFunciones.IDPAIS,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPais);

			ParametroCarteraDefectoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPais","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrocarteradefectos=parametrocarteradefectoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroCarteraDefectoConstantesFunciones.refrescarForeignKeysDescripcionesParametroCarteraDefecto(this.parametrocarteradefectos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getParametroCarteraDefectosFK_IdPaisNacionalidadWithConnection(String sFinalQuery,Pagination pagination,Long id_pais_nacionalidad)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroCarteraDefecto.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPaisNacionalidad= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPaisNacionalidad.setParameterSelectionGeneralEqual(ParameterType.LONG,id_pais_nacionalidad,ParametroCarteraDefectoConstantesFunciones.IDPAISNACIONALIDAD,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPaisNacionalidad);

			ParametroCarteraDefectoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPaisNacionalidad","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrocarteradefectos=parametrocarteradefectoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroCarteraDefectoConstantesFunciones.refrescarForeignKeysDescripcionesParametroCarteraDefecto(this.parametrocarteradefectos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getParametroCarteraDefectosFK_IdPaisNacionalidad(String sFinalQuery,Pagination pagination,Long id_pais_nacionalidad)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPaisNacionalidad= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPaisNacionalidad.setParameterSelectionGeneralEqual(ParameterType.LONG,id_pais_nacionalidad,ParametroCarteraDefectoConstantesFunciones.IDPAISNACIONALIDAD,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPaisNacionalidad);

			ParametroCarteraDefectoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPaisNacionalidad","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrocarteradefectos=parametrocarteradefectoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroCarteraDefectoConstantesFunciones.refrescarForeignKeysDescripcionesParametroCarteraDefecto(this.parametrocarteradefectos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getParametroCarteraDefectosFK_IdProvinciaWithConnection(String sFinalQuery,Pagination pagination,Long id_provincia)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroCarteraDefecto.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidProvincia= new ParameterSelectionGeneral();
			parameterSelectionGeneralidProvincia.setParameterSelectionGeneralEqual(ParameterType.LONG,id_provincia,ParametroCarteraDefectoConstantesFunciones.IDPROVINCIA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidProvincia);

			ParametroCarteraDefectoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdProvincia","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrocarteradefectos=parametrocarteradefectoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroCarteraDefectoConstantesFunciones.refrescarForeignKeysDescripcionesParametroCarteraDefecto(this.parametrocarteradefectos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getParametroCarteraDefectosFK_IdProvincia(String sFinalQuery,Pagination pagination,Long id_provincia)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidProvincia= new ParameterSelectionGeneral();
			parameterSelectionGeneralidProvincia.setParameterSelectionGeneralEqual(ParameterType.LONG,id_provincia,ParametroCarteraDefectoConstantesFunciones.IDPROVINCIA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidProvincia);

			ParametroCarteraDefectoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdProvincia","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrocarteradefectos=parametrocarteradefectoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroCarteraDefectoConstantesFunciones.refrescarForeignKeysDescripcionesParametroCarteraDefecto(this.parametrocarteradefectos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getParametroCarteraDefectosFK_IdRegionWithConnection(String sFinalQuery,Pagination pagination,Long id_region)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroCarteraDefecto.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidRegion= new ParameterSelectionGeneral();
			parameterSelectionGeneralidRegion.setParameterSelectionGeneralEqual(ParameterType.LONG,id_region,ParametroCarteraDefectoConstantesFunciones.IDREGION,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidRegion);

			ParametroCarteraDefectoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdRegion","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrocarteradefectos=parametrocarteradefectoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroCarteraDefectoConstantesFunciones.refrescarForeignKeysDescripcionesParametroCarteraDefecto(this.parametrocarteradefectos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getParametroCarteraDefectosFK_IdRegion(String sFinalQuery,Pagination pagination,Long id_region)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidRegion= new ParameterSelectionGeneral();
			parameterSelectionGeneralidRegion.setParameterSelectionGeneralEqual(ParameterType.LONG,id_region,ParametroCarteraDefectoConstantesFunciones.IDREGION,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidRegion);

			ParametroCarteraDefectoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdRegion","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrocarteradefectos=parametrocarteradefectoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroCarteraDefectoConstantesFunciones.refrescarForeignKeysDescripcionesParametroCarteraDefecto(this.parametrocarteradefectos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getParametroCarteraDefectosFK_IdRutaWithConnection(String sFinalQuery,Pagination pagination,Long id_ruta)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroCarteraDefecto.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidRuta= new ParameterSelectionGeneral();
			parameterSelectionGeneralidRuta.setParameterSelectionGeneralEqual(ParameterType.LONG,id_ruta,ParametroCarteraDefectoConstantesFunciones.IDRUTA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidRuta);

			ParametroCarteraDefectoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdRuta","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrocarteradefectos=parametrocarteradefectoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroCarteraDefectoConstantesFunciones.refrescarForeignKeysDescripcionesParametroCarteraDefecto(this.parametrocarteradefectos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getParametroCarteraDefectosFK_IdRuta(String sFinalQuery,Pagination pagination,Long id_ruta)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidRuta= new ParameterSelectionGeneral();
			parameterSelectionGeneralidRuta.setParameterSelectionGeneralEqual(ParameterType.LONG,id_ruta,ParametroCarteraDefectoConstantesFunciones.IDRUTA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidRuta);

			ParametroCarteraDefectoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdRuta","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrocarteradefectos=parametrocarteradefectoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroCarteraDefectoConstantesFunciones.refrescarForeignKeysDescripcionesParametroCarteraDefecto(this.parametrocarteradefectos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getParametroCarteraDefectosFK_IdSucursalWithConnection(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroCarteraDefecto.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,ParametroCarteraDefectoConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			ParametroCarteraDefectoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrocarteradefectos=parametrocarteradefectoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroCarteraDefectoConstantesFunciones.refrescarForeignKeysDescripcionesParametroCarteraDefecto(this.parametrocarteradefectos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getParametroCarteraDefectosFK_IdSucursal(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,ParametroCarteraDefectoConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			ParametroCarteraDefectoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrocarteradefectos=parametrocarteradefectoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroCarteraDefectoConstantesFunciones.refrescarForeignKeysDescripcionesParametroCarteraDefecto(this.parametrocarteradefectos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getParametroCarteraDefectosFK_IdTipoGeneroWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_genero)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroCarteraDefecto.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoGenero= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoGenero.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_genero,ParametroCarteraDefectoConstantesFunciones.IDTIPOGENERO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoGenero);

			ParametroCarteraDefectoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoGenero","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrocarteradefectos=parametrocarteradefectoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroCarteraDefectoConstantesFunciones.refrescarForeignKeysDescripcionesParametroCarteraDefecto(this.parametrocarteradefectos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getParametroCarteraDefectosFK_IdTipoGenero(String sFinalQuery,Pagination pagination,Long id_tipo_genero)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoGenero= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoGenero.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_genero,ParametroCarteraDefectoConstantesFunciones.IDTIPOGENERO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoGenero);

			ParametroCarteraDefectoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoGenero","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrocarteradefectos=parametrocarteradefectoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroCarteraDefectoConstantesFunciones.refrescarForeignKeysDescripcionesParametroCarteraDefecto(this.parametrocarteradefectos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getParametroCarteraDefectosFK_IdTipoIdentificacionWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_identificacion)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroCarteraDefecto.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoIdentificacion= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoIdentificacion.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_identificacion,ParametroCarteraDefectoConstantesFunciones.IDTIPOIDENTIFICACION,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoIdentificacion);

			ParametroCarteraDefectoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoIdentificacion","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrocarteradefectos=parametrocarteradefectoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroCarteraDefectoConstantesFunciones.refrescarForeignKeysDescripcionesParametroCarteraDefecto(this.parametrocarteradefectos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getParametroCarteraDefectosFK_IdTipoIdentificacion(String sFinalQuery,Pagination pagination,Long id_tipo_identificacion)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoIdentificacion= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoIdentificacion.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_identificacion,ParametroCarteraDefectoConstantesFunciones.IDTIPOIDENTIFICACION,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoIdentificacion);

			ParametroCarteraDefectoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoIdentificacion","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrocarteradefectos=parametrocarteradefectoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroCarteraDefectoConstantesFunciones.refrescarForeignKeysDescripcionesParametroCarteraDefecto(this.parametrocarteradefectos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getParametroCarteraDefectosFK_IdTipoListaPrecioWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_lista_precio)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroCarteraDefecto.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoListaPrecio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoListaPrecio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_lista_precio,ParametroCarteraDefectoConstantesFunciones.IDTIPOLISTAPRECIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoListaPrecio);

			ParametroCarteraDefectoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoListaPrecio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrocarteradefectos=parametrocarteradefectoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroCarteraDefectoConstantesFunciones.refrescarForeignKeysDescripcionesParametroCarteraDefecto(this.parametrocarteradefectos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getParametroCarteraDefectosFK_IdTipoListaPrecio(String sFinalQuery,Pagination pagination,Long id_tipo_lista_precio)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoListaPrecio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoListaPrecio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_lista_precio,ParametroCarteraDefectoConstantesFunciones.IDTIPOLISTAPRECIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoListaPrecio);

			ParametroCarteraDefectoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoListaPrecio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrocarteradefectos=parametrocarteradefectoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroCarteraDefectoConstantesFunciones.refrescarForeignKeysDescripcionesParametroCarteraDefecto(this.parametrocarteradefectos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getParametroCarteraDefectosFK_IdTipoNivelEduWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_nivel_edu)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroCarteraDefecto.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoNivelEdu= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoNivelEdu.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_nivel_edu,ParametroCarteraDefectoConstantesFunciones.IDTIPONIVELEDU,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoNivelEdu);

			ParametroCarteraDefectoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoNivelEdu","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrocarteradefectos=parametrocarteradefectoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroCarteraDefectoConstantesFunciones.refrescarForeignKeysDescripcionesParametroCarteraDefecto(this.parametrocarteradefectos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getParametroCarteraDefectosFK_IdTipoNivelEdu(String sFinalQuery,Pagination pagination,Long id_tipo_nivel_edu)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoNivelEdu= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoNivelEdu.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_nivel_edu,ParametroCarteraDefectoConstantesFunciones.IDTIPONIVELEDU,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoNivelEdu);

			ParametroCarteraDefectoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoNivelEdu","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrocarteradefectos=parametrocarteradefectoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroCarteraDefectoConstantesFunciones.refrescarForeignKeysDescripcionesParametroCarteraDefecto(this.parametrocarteradefectos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getParametroCarteraDefectosFK_IdTipoPrecioWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_precio)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroCarteraDefecto.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoPrecio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoPrecio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_precio,ParametroCarteraDefectoConstantesFunciones.IDTIPOPRECIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoPrecio);

			ParametroCarteraDefectoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoPrecio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrocarteradefectos=parametrocarteradefectoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroCarteraDefectoConstantesFunciones.refrescarForeignKeysDescripcionesParametroCarteraDefecto(this.parametrocarteradefectos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getParametroCarteraDefectosFK_IdTipoPrecio(String sFinalQuery,Pagination pagination,Long id_tipo_precio)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoPrecio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoPrecio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_precio,ParametroCarteraDefectoConstantesFunciones.IDTIPOPRECIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoPrecio);

			ParametroCarteraDefectoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoPrecio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrocarteradefectos=parametrocarteradefectoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroCarteraDefectoConstantesFunciones.refrescarForeignKeysDescripcionesParametroCarteraDefecto(this.parametrocarteradefectos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getParametroCarteraDefectosFK_IdVendedorWithConnection(String sFinalQuery,Pagination pagination,Long id_vendedor)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroCarteraDefecto.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidVendedor= new ParameterSelectionGeneral();
			parameterSelectionGeneralidVendedor.setParameterSelectionGeneralEqual(ParameterType.LONG,id_vendedor,ParametroCarteraDefectoConstantesFunciones.IDVENDEDOR,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidVendedor);

			ParametroCarteraDefectoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdVendedor","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrocarteradefectos=parametrocarteradefectoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroCarteraDefectoConstantesFunciones.refrescarForeignKeysDescripcionesParametroCarteraDefecto(this.parametrocarteradefectos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getParametroCarteraDefectosFK_IdVendedor(String sFinalQuery,Pagination pagination,Long id_vendedor)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidVendedor= new ParameterSelectionGeneral();
			parameterSelectionGeneralidVendedor.setParameterSelectionGeneralEqual(ParameterType.LONG,id_vendedor,ParametroCarteraDefectoConstantesFunciones.IDVENDEDOR,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidVendedor);

			ParametroCarteraDefectoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdVendedor","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrocarteradefectos=parametrocarteradefectoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroCarteraDefectoConstantesFunciones.refrescarForeignKeysDescripcionesParametroCarteraDefecto(this.parametrocarteradefectos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getParametroCarteraDefectosFK_IdZonaWithConnection(String sFinalQuery,Pagination pagination,Long id_zona)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroCarteraDefecto.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidZona= new ParameterSelectionGeneral();
			parameterSelectionGeneralidZona.setParameterSelectionGeneralEqual(ParameterType.LONG,id_zona,ParametroCarteraDefectoConstantesFunciones.IDZONA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidZona);

			ParametroCarteraDefectoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdZona","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrocarteradefectos=parametrocarteradefectoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroCarteraDefectoConstantesFunciones.refrescarForeignKeysDescripcionesParametroCarteraDefecto(this.parametrocarteradefectos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getParametroCarteraDefectosFK_IdZona(String sFinalQuery,Pagination pagination,Long id_zona)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidZona= new ParameterSelectionGeneral();
			parameterSelectionGeneralidZona.setParameterSelectionGeneralEqual(ParameterType.LONG,id_zona,ParametroCarteraDefectoConstantesFunciones.IDZONA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidZona);

			ParametroCarteraDefectoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdZona","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrocarteradefectos=parametrocarteradefectoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroCarteraDefectoConstantesFunciones.refrescarForeignKeysDescripcionesParametroCarteraDefecto(this.parametrocarteradefectos);
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
			if(ParametroCarteraDefectoConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,ParametroCarteraDefectoDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,ParametroCarteraDefecto parametrocarteradefecto,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(ParametroCarteraDefectoConstantesFunciones.ISCONAUDITORIA) {
				if(parametrocarteradefecto.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,ParametroCarteraDefectoDataAccess.TABLENAME, parametrocarteradefecto.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(ParametroCarteraDefectoConstantesFunciones.ISCONAUDITORIADETALLE) {
						////ParametroCarteraDefectoLogic.registrarAuditoriaDetallesParametroCarteraDefecto(connexion,parametrocarteradefecto,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(parametrocarteradefecto.getIsDeleted()) {
					/*if(!parametrocarteradefecto.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,ParametroCarteraDefectoDataAccess.TABLENAME, parametrocarteradefecto.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////ParametroCarteraDefectoLogic.registrarAuditoriaDetallesParametroCarteraDefecto(connexion,parametrocarteradefecto,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,ParametroCarteraDefectoDataAccess.TABLENAME, parametrocarteradefecto.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(parametrocarteradefecto.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,ParametroCarteraDefectoDataAccess.TABLENAME, parametrocarteradefecto.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(ParametroCarteraDefectoConstantesFunciones.ISCONAUDITORIADETALLE) {
						////ParametroCarteraDefectoLogic.registrarAuditoriaDetallesParametroCarteraDefecto(connexion,parametrocarteradefecto,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesParametroCarteraDefecto(Connexion connexion,ParametroCarteraDefecto parametrocarteradefecto)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(parametrocarteradefecto.getIsNew()||!parametrocarteradefecto.getid_empresa().equals(parametrocarteradefecto.getParametroCarteraDefectoOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametrocarteradefecto.getParametroCarteraDefectoOriginal().getid_empresa()!=null)
				{
					strValorActual=parametrocarteradefecto.getParametroCarteraDefectoOriginal().getid_empresa().toString();
				}
				if(parametrocarteradefecto.getid_empresa()!=null)
				{
					strValorNuevo=parametrocarteradefecto.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroCarteraDefectoConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(parametrocarteradefecto.getIsNew()||!parametrocarteradefecto.getid_sucursal().equals(parametrocarteradefecto.getParametroCarteraDefectoOriginal().getid_sucursal()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametrocarteradefecto.getParametroCarteraDefectoOriginal().getid_sucursal()!=null)
				{
					strValorActual=parametrocarteradefecto.getParametroCarteraDefectoOriginal().getid_sucursal().toString();
				}
				if(parametrocarteradefecto.getid_sucursal()!=null)
				{
					strValorNuevo=parametrocarteradefecto.getid_sucursal().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroCarteraDefectoConstantesFunciones.IDSUCURSAL,strValorActual,strValorNuevo);
			}	
			
			if(parametrocarteradefecto.getIsNew()||!parametrocarteradefecto.getid_pais().equals(parametrocarteradefecto.getParametroCarteraDefectoOriginal().getid_pais()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametrocarteradefecto.getParametroCarteraDefectoOriginal().getid_pais()!=null)
				{
					strValorActual=parametrocarteradefecto.getParametroCarteraDefectoOriginal().getid_pais().toString();
				}
				if(parametrocarteradefecto.getid_pais()!=null)
				{
					strValorNuevo=parametrocarteradefecto.getid_pais().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroCarteraDefectoConstantesFunciones.IDPAIS,strValorActual,strValorNuevo);
			}	
			
			if(parametrocarteradefecto.getIsNew()||!parametrocarteradefecto.getid_region().equals(parametrocarteradefecto.getParametroCarteraDefectoOriginal().getid_region()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametrocarteradefecto.getParametroCarteraDefectoOriginal().getid_region()!=null)
				{
					strValorActual=parametrocarteradefecto.getParametroCarteraDefectoOriginal().getid_region().toString();
				}
				if(parametrocarteradefecto.getid_region()!=null)
				{
					strValorNuevo=parametrocarteradefecto.getid_region().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroCarteraDefectoConstantesFunciones.IDREGION,strValorActual,strValorNuevo);
			}	
			
			if(parametrocarteradefecto.getIsNew()||!parametrocarteradefecto.getid_provincia().equals(parametrocarteradefecto.getParametroCarteraDefectoOriginal().getid_provincia()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametrocarteradefecto.getParametroCarteraDefectoOriginal().getid_provincia()!=null)
				{
					strValorActual=parametrocarteradefecto.getParametroCarteraDefectoOriginal().getid_provincia().toString();
				}
				if(parametrocarteradefecto.getid_provincia()!=null)
				{
					strValorNuevo=parametrocarteradefecto.getid_provincia().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroCarteraDefectoConstantesFunciones.IDPROVINCIA,strValorActual,strValorNuevo);
			}	
			
			if(parametrocarteradefecto.getIsNew()||!parametrocarteradefecto.getid_ciudad().equals(parametrocarteradefecto.getParametroCarteraDefectoOriginal().getid_ciudad()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametrocarteradefecto.getParametroCarteraDefectoOriginal().getid_ciudad()!=null)
				{
					strValorActual=parametrocarteradefecto.getParametroCarteraDefectoOriginal().getid_ciudad().toString();
				}
				if(parametrocarteradefecto.getid_ciudad()!=null)
				{
					strValorNuevo=parametrocarteradefecto.getid_ciudad().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroCarteraDefectoConstantesFunciones.IDCIUDAD,strValorActual,strValorNuevo);
			}	
			
			if(parametrocarteradefecto.getIsNew()||!parametrocarteradefecto.getid_zona().equals(parametrocarteradefecto.getParametroCarteraDefectoOriginal().getid_zona()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametrocarteradefecto.getParametroCarteraDefectoOriginal().getid_zona()!=null)
				{
					strValorActual=parametrocarteradefecto.getParametroCarteraDefectoOriginal().getid_zona().toString();
				}
				if(parametrocarteradefecto.getid_zona()!=null)
				{
					strValorNuevo=parametrocarteradefecto.getid_zona().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroCarteraDefectoConstantesFunciones.IDZONA,strValorActual,strValorNuevo);
			}	
			
			if(parametrocarteradefecto.getIsNew()||!parametrocarteradefecto.getid_tipo_identificacion().equals(parametrocarteradefecto.getParametroCarteraDefectoOriginal().getid_tipo_identificacion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametrocarteradefecto.getParametroCarteraDefectoOriginal().getid_tipo_identificacion()!=null)
				{
					strValorActual=parametrocarteradefecto.getParametroCarteraDefectoOriginal().getid_tipo_identificacion().toString();
				}
				if(parametrocarteradefecto.getid_tipo_identificacion()!=null)
				{
					strValorNuevo=parametrocarteradefecto.getid_tipo_identificacion().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroCarteraDefectoConstantesFunciones.IDTIPOIDENTIFICACION,strValorActual,strValorNuevo);
			}	
			
			if(parametrocarteradefecto.getIsNew()||!parametrocarteradefecto.getid_tipo_nivel_edu().equals(parametrocarteradefecto.getParametroCarteraDefectoOriginal().getid_tipo_nivel_edu()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametrocarteradefecto.getParametroCarteraDefectoOriginal().getid_tipo_nivel_edu()!=null)
				{
					strValorActual=parametrocarteradefecto.getParametroCarteraDefectoOriginal().getid_tipo_nivel_edu().toString();
				}
				if(parametrocarteradefecto.getid_tipo_nivel_edu()!=null)
				{
					strValorNuevo=parametrocarteradefecto.getid_tipo_nivel_edu().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroCarteraDefectoConstantesFunciones.IDTIPONIVELEDU,strValorActual,strValorNuevo);
			}	
			
			if(parametrocarteradefecto.getIsNew()||!parametrocarteradefecto.getid_pais_nacionalidad().equals(parametrocarteradefecto.getParametroCarteraDefectoOriginal().getid_pais_nacionalidad()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametrocarteradefecto.getParametroCarteraDefectoOriginal().getid_pais_nacionalidad()!=null)
				{
					strValorActual=parametrocarteradefecto.getParametroCarteraDefectoOriginal().getid_pais_nacionalidad().toString();
				}
				if(parametrocarteradefecto.getid_pais_nacionalidad()!=null)
				{
					strValorNuevo=parametrocarteradefecto.getid_pais_nacionalidad().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroCarteraDefectoConstantesFunciones.IDPAISNACIONALIDAD,strValorActual,strValorNuevo);
			}	
			
			if(parametrocarteradefecto.getIsNew()||!parametrocarteradefecto.getid_tipo_genero().equals(parametrocarteradefecto.getParametroCarteraDefectoOriginal().getid_tipo_genero()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametrocarteradefecto.getParametroCarteraDefectoOriginal().getid_tipo_genero()!=null)
				{
					strValorActual=parametrocarteradefecto.getParametroCarteraDefectoOriginal().getid_tipo_genero().toString();
				}
				if(parametrocarteradefecto.getid_tipo_genero()!=null)
				{
					strValorNuevo=parametrocarteradefecto.getid_tipo_genero().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroCarteraDefectoConstantesFunciones.IDTIPOGENERO,strValorActual,strValorNuevo);
			}	
			
			if(parametrocarteradefecto.getIsNew()||!parametrocarteradefecto.getid_estado_civil().equals(parametrocarteradefecto.getParametroCarteraDefectoOriginal().getid_estado_civil()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametrocarteradefecto.getParametroCarteraDefectoOriginal().getid_estado_civil()!=null)
				{
					strValorActual=parametrocarteradefecto.getParametroCarteraDefectoOriginal().getid_estado_civil().toString();
				}
				if(parametrocarteradefecto.getid_estado_civil()!=null)
				{
					strValorNuevo=parametrocarteradefecto.getid_estado_civil().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroCarteraDefectoConstantesFunciones.IDESTADOCIVIL,strValorActual,strValorNuevo);
			}	
			
			if(parametrocarteradefecto.getIsNew()||!parametrocarteradefecto.getid_estado_legal().equals(parametrocarteradefecto.getParametroCarteraDefectoOriginal().getid_estado_legal()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametrocarteradefecto.getParametroCarteraDefectoOriginal().getid_estado_legal()!=null)
				{
					strValorActual=parametrocarteradefecto.getParametroCarteraDefectoOriginal().getid_estado_legal().toString();
				}
				if(parametrocarteradefecto.getid_estado_legal()!=null)
				{
					strValorNuevo=parametrocarteradefecto.getid_estado_legal().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroCarteraDefectoConstantesFunciones.IDESTADOLEGAL,strValorActual,strValorNuevo);
			}	
			
			if(parametrocarteradefecto.getIsNew()||!parametrocarteradefecto.getid_cuenta_contable().equals(parametrocarteradefecto.getParametroCarteraDefectoOriginal().getid_cuenta_contable()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametrocarteradefecto.getParametroCarteraDefectoOriginal().getid_cuenta_contable()!=null)
				{
					strValorActual=parametrocarteradefecto.getParametroCarteraDefectoOriginal().getid_cuenta_contable().toString();
				}
				if(parametrocarteradefecto.getid_cuenta_contable()!=null)
				{
					strValorNuevo=parametrocarteradefecto.getid_cuenta_contable().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroCarteraDefectoConstantesFunciones.IDCUENTACONTABLE,strValorActual,strValorNuevo);
			}	
			
			if(parametrocarteradefecto.getIsNew()||!parametrocarteradefecto.getid_vendedor().equals(parametrocarteradefecto.getParametroCarteraDefectoOriginal().getid_vendedor()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametrocarteradefecto.getParametroCarteraDefectoOriginal().getid_vendedor()!=null)
				{
					strValorActual=parametrocarteradefecto.getParametroCarteraDefectoOriginal().getid_vendedor().toString();
				}
				if(parametrocarteradefecto.getid_vendedor()!=null)
				{
					strValorNuevo=parametrocarteradefecto.getid_vendedor().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroCarteraDefectoConstantesFunciones.IDVENDEDOR,strValorActual,strValorNuevo);
			}	
			
			if(parametrocarteradefecto.getIsNew()||!parametrocarteradefecto.getid_ruta().equals(parametrocarteradefecto.getParametroCarteraDefectoOriginal().getid_ruta()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametrocarteradefecto.getParametroCarteraDefectoOriginal().getid_ruta()!=null)
				{
					strValorActual=parametrocarteradefecto.getParametroCarteraDefectoOriginal().getid_ruta().toString();
				}
				if(parametrocarteradefecto.getid_ruta()!=null)
				{
					strValorNuevo=parametrocarteradefecto.getid_ruta().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroCarteraDefectoConstantesFunciones.IDRUTA,strValorActual,strValorNuevo);
			}	
			
			if(parametrocarteradefecto.getIsNew()||!parametrocarteradefecto.getid_dia().equals(parametrocarteradefecto.getParametroCarteraDefectoOriginal().getid_dia()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametrocarteradefecto.getParametroCarteraDefectoOriginal().getid_dia()!=null)
				{
					strValorActual=parametrocarteradefecto.getParametroCarteraDefectoOriginal().getid_dia().toString();
				}
				if(parametrocarteradefecto.getid_dia()!=null)
				{
					strValorNuevo=parametrocarteradefecto.getid_dia().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroCarteraDefectoConstantesFunciones.IDDIA,strValorActual,strValorNuevo);
			}	
			
			if(parametrocarteradefecto.getIsNew()||!parametrocarteradefecto.getid_tipo_precio().equals(parametrocarteradefecto.getParametroCarteraDefectoOriginal().getid_tipo_precio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametrocarteradefecto.getParametroCarteraDefectoOriginal().getid_tipo_precio()!=null)
				{
					strValorActual=parametrocarteradefecto.getParametroCarteraDefectoOriginal().getid_tipo_precio().toString();
				}
				if(parametrocarteradefecto.getid_tipo_precio()!=null)
				{
					strValorNuevo=parametrocarteradefecto.getid_tipo_precio().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroCarteraDefectoConstantesFunciones.IDTIPOPRECIO,strValorActual,strValorNuevo);
			}	
			
			if(parametrocarteradefecto.getIsNew()||!parametrocarteradefecto.getid_tipo_lista_precio().equals(parametrocarteradefecto.getParametroCarteraDefectoOriginal().getid_tipo_lista_precio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametrocarteradefecto.getParametroCarteraDefectoOriginal().getid_tipo_lista_precio()!=null)
				{
					strValorActual=parametrocarteradefecto.getParametroCarteraDefectoOriginal().getid_tipo_lista_precio().toString();
				}
				if(parametrocarteradefecto.getid_tipo_lista_precio()!=null)
				{
					strValorNuevo=parametrocarteradefecto.getid_tipo_lista_precio().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroCarteraDefectoConstantesFunciones.IDTIPOLISTAPRECIO,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveParametroCarteraDefectoRelacionesWithConnection(ParametroCarteraDefecto parametrocarteradefecto) throws Exception {

		if(!parametrocarteradefecto.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveParametroCarteraDefectoRelacionesBase(parametrocarteradefecto,true);
		}
	}

	public void saveParametroCarteraDefectoRelaciones(ParametroCarteraDefecto parametrocarteradefecto)throws Exception {

		if(!parametrocarteradefecto.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveParametroCarteraDefectoRelacionesBase(parametrocarteradefecto,false);
		}
	}

	public void saveParametroCarteraDefectoRelacionesBase(ParametroCarteraDefecto parametrocarteradefecto,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("ParametroCarteraDefecto-saveRelacionesWithConnection");}
	

			this.setParametroCarteraDefecto(parametrocarteradefecto);

			if(ParametroCarteraDefectoLogicAdditional.validarSaveRelaciones(parametrocarteradefecto,this)) {

				ParametroCarteraDefectoLogicAdditional.updateRelacionesToSave(parametrocarteradefecto,this);

				if((parametrocarteradefecto.getIsNew()||parametrocarteradefecto.getIsChanged())&&!parametrocarteradefecto.getIsDeleted()) {
					this.saveParametroCarteraDefecto();
					this.saveParametroCarteraDefectoRelacionesDetalles();

				} else if(parametrocarteradefecto.getIsDeleted()) {
					this.saveParametroCarteraDefectoRelacionesDetalles();
					this.saveParametroCarteraDefecto();
				}

				ParametroCarteraDefectoLogicAdditional.updateRelacionesToSaveAfter(parametrocarteradefecto,this);

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
	
	
	private void saveParametroCarteraDefectoRelacionesDetalles()throws Exception {
		try {
	

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfParametroCarteraDefecto(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=ParametroCarteraDefectoConstantesFunciones.getClassesForeignKeysOfParametroCarteraDefecto(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfParametroCarteraDefecto(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=ParametroCarteraDefectoConstantesFunciones.getClassesRelationshipsOfParametroCarteraDefecto(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

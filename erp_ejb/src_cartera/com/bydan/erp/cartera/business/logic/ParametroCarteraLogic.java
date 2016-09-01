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
import com.bydan.erp.cartera.util.ParametroCarteraConstantesFunciones;
import com.bydan.erp.cartera.util.ParametroCarteraParameterReturnGeneral;
//import com.bydan.erp.cartera.util.ParametroCarteraParameterGeneral;
import com.bydan.erp.cartera.business.entity.ParametroCartera;
import com.bydan.erp.cartera.business.logic.ParametroCarteraLogicAdditional;
import com.bydan.erp.cartera.business.dataaccess.*;
import com.bydan.erp.cartera.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;
import com.bydan.erp.tesoreria.business.logic.*;
import com.bydan.erp.nomina.business.logic.*;
import com.bydan.erp.inventario.business.logic.*;
import com.bydan.erp.contabilidad.business.logic.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.tesoreria.util.*;
import com.bydan.erp.nomina.util.*;
import com.bydan.erp.inventario.util.*;
import com.bydan.erp.contabilidad.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.tesoreria.business.dataaccess.*;
import com.bydan.erp.nomina.business.dataaccess.*;
import com.bydan.erp.inventario.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;








@SuppressWarnings("unused")
public class ParametroCarteraLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(ParametroCarteraLogic.class);
	
	protected ParametroCarteraDataAccess parametrocarteraDataAccess; 	
	protected ParametroCartera parametrocartera;
	protected List<ParametroCartera> parametrocarteras;
	protected Object parametrocarteraObject;	
	protected List<Object> parametrocarterasObject;
	
	public static ClassValidator<ParametroCartera> parametrocarteraValidator = new ClassValidator<ParametroCartera>(ParametroCartera.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected ParametroCarteraLogicAdditional parametrocarteraLogicAdditional=null;
	
	public ParametroCarteraLogicAdditional getParametroCarteraLogicAdditional() {
		return this.parametrocarteraLogicAdditional;
	}
	
	public void setParametroCarteraLogicAdditional(ParametroCarteraLogicAdditional parametrocarteraLogicAdditional) {
		try {
			this.parametrocarteraLogicAdditional=parametrocarteraLogicAdditional;
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
	
	
	
	
	public  ParametroCarteraLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.parametrocarteraDataAccess = new ParametroCarteraDataAccess();
			
			this.parametrocarteras= new ArrayList<ParametroCartera>();
			this.parametrocartera= new ParametroCartera();
			
			this.parametrocarteraObject=new Object();
			this.parametrocarterasObject=new ArrayList<Object>();
				
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
			
			this.parametrocarteraDataAccess.setConnexionType(this.connexionType);
			this.parametrocarteraDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  ParametroCarteraLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.parametrocarteraDataAccess = new ParametroCarteraDataAccess();
			this.parametrocarteras= new ArrayList<ParametroCartera>();
			this.parametrocartera= new ParametroCartera();
			this.parametrocarteraObject=new Object();
			this.parametrocarterasObject=new ArrayList<Object>();
			
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
			
			this.parametrocarteraDataAccess.setConnexionType(this.connexionType);
			this.parametrocarteraDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public ParametroCartera getParametroCartera() throws Exception {	
		ParametroCarteraLogicAdditional.checkParametroCarteraToGet(parametrocartera,this.datosCliente,this.arrDatoGeneral);
		ParametroCarteraLogicAdditional.updateParametroCarteraToGet(parametrocartera,this.arrDatoGeneral);
		
		return parametrocartera;
	}
		
	public void setParametroCartera(ParametroCartera newParametroCartera) {
		this.parametrocartera = newParametroCartera;
	}
	
	public ParametroCarteraDataAccess getParametroCarteraDataAccess() {
		return parametrocarteraDataAccess;
	}
	
	public void setParametroCarteraDataAccess(ParametroCarteraDataAccess newparametrocarteraDataAccess) {
		this.parametrocarteraDataAccess = newparametrocarteraDataAccess;
	}
	
	public List<ParametroCartera> getParametroCarteras() throws Exception {		
		this.quitarParametroCarterasNulos();
		
		ParametroCarteraLogicAdditional.checkParametroCarteraToGets(parametrocarteras,this.datosCliente,this.arrDatoGeneral);
		
		for (ParametroCartera parametrocarteraLocal: parametrocarteras ) {
			ParametroCarteraLogicAdditional.updateParametroCarteraToGet(parametrocarteraLocal,this.arrDatoGeneral);
		}
		
		return parametrocarteras;
	}
	
	public void setParametroCarteras(List<ParametroCartera> newParametroCarteras) {
		this.parametrocarteras = newParametroCarteras;
	}
	
	public Object getParametroCarteraObject() {	
		this.parametrocarteraObject=this.parametrocarteraDataAccess.getEntityObject();
		return this.parametrocarteraObject;
	}
		
	public void setParametroCarteraObject(Object newParametroCarteraObject) {
		this.parametrocarteraObject = newParametroCarteraObject;
	}
	
	public List<Object> getParametroCarterasObject() {		
		this.parametrocarterasObject=this.parametrocarteraDataAccess.getEntitiesObject();
		return this.parametrocarterasObject;
	}
		
	public void setParametroCarterasObject(List<Object> newParametroCarterasObject) {
		this.parametrocarterasObject = newParametroCarterasObject;
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
		
		if(this.parametrocarteraDataAccess!=null) {
			this.parametrocarteraDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroCartera.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			parametrocarteraDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			parametrocarteraDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		parametrocartera = new  ParametroCartera();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroCartera.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			parametrocartera=parametrocarteraDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.parametrocartera,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ParametroCarteraConstantesFunciones.refrescarForeignKeysDescripcionesParametroCartera(this.parametrocartera);
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
		parametrocartera = new  ParametroCartera();
		  		  
        try {
			
			parametrocartera=parametrocarteraDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.parametrocartera,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ParametroCarteraConstantesFunciones.refrescarForeignKeysDescripcionesParametroCartera(this.parametrocartera);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		parametrocartera = new  ParametroCartera();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroCartera.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			parametrocartera=parametrocarteraDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.parametrocartera,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ParametroCarteraConstantesFunciones.refrescarForeignKeysDescripcionesParametroCartera(this.parametrocartera);
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
		parametrocartera = new  ParametroCartera();
		  		  
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
		parametrocartera = new  ParametroCartera();
		  		  
        try {
			
			parametrocartera=parametrocarteraDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.parametrocartera,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ParametroCarteraConstantesFunciones.refrescarForeignKeysDescripcionesParametroCartera(this.parametrocartera);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		parametrocartera = new  ParametroCartera();
		  		  
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
		parametrocartera = new  ParametroCartera();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroCartera.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =parametrocarteraDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		parametrocartera = new  ParametroCartera();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=parametrocarteraDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		parametrocartera = new  ParametroCartera();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroCartera.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =parametrocarteraDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		parametrocartera = new  ParametroCartera();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=parametrocarteraDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		parametrocartera = new  ParametroCartera();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroCartera.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =parametrocarteraDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		parametrocartera = new  ParametroCartera();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=parametrocarteraDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		parametrocarteras = new  ArrayList<ParametroCartera>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroCartera.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			ParametroCarteraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametrocarteras=parametrocarteraDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarParametroCartera(parametrocarteras);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroCarteraConstantesFunciones.refrescarForeignKeysDescripcionesParametroCartera(this.parametrocarteras);
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
		parametrocarteras = new  ArrayList<ParametroCartera>();
		  		  
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
		parametrocarteras = new  ArrayList<ParametroCartera>();
		  		  
        try {			
			ParametroCarteraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametrocarteras=parametrocarteraDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarParametroCartera(parametrocarteras);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroCarteraConstantesFunciones.refrescarForeignKeysDescripcionesParametroCartera(this.parametrocarteras);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		parametrocarteras = new  ArrayList<ParametroCartera>();
		  		  
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
		parametrocarteras = new  ArrayList<ParametroCartera>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroCartera.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			ParametroCarteraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametrocarteras=parametrocarteraDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarParametroCartera(parametrocarteras);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroCarteraConstantesFunciones.refrescarForeignKeysDescripcionesParametroCartera(this.parametrocarteras);
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
		parametrocarteras = new  ArrayList<ParametroCartera>();
		  		  
        try {
			ParametroCarteraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametrocarteras=parametrocarteraDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarParametroCartera(parametrocarteras);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroCarteraConstantesFunciones.refrescarForeignKeysDescripcionesParametroCartera(this.parametrocarteras);
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
		parametrocarteras = new  ArrayList<ParametroCartera>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroCartera.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ParametroCarteraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametrocarteras=parametrocarteraDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarParametroCartera(parametrocarteras);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroCarteraConstantesFunciones.refrescarForeignKeysDescripcionesParametroCartera(this.parametrocarteras);
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
		parametrocarteras = new  ArrayList<ParametroCartera>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ParametroCarteraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametrocarteras=parametrocarteraDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarParametroCartera(parametrocarteras);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroCarteraConstantesFunciones.refrescarForeignKeysDescripcionesParametroCartera(this.parametrocarteras);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		parametrocartera = new  ParametroCartera();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroCartera.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ParametroCarteraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametrocartera=parametrocarteraDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarParametroCartera(parametrocartera);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroCarteraConstantesFunciones.refrescarForeignKeysDescripcionesParametroCartera(this.parametrocartera);
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
		parametrocartera = new  ParametroCartera();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ParametroCarteraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametrocartera=parametrocarteraDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarParametroCartera(parametrocartera);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroCarteraConstantesFunciones.refrescarForeignKeysDescripcionesParametroCartera(this.parametrocartera);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		parametrocarteras = new  ArrayList<ParametroCartera>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroCartera.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			ParametroCarteraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametrocarteras=parametrocarteraDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarParametroCartera(parametrocarteras);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroCarteraConstantesFunciones.refrescarForeignKeysDescripcionesParametroCartera(this.parametrocarteras);
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
		parametrocarteras = new  ArrayList<ParametroCartera>();
		  		  
        try {
			ParametroCarteraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametrocarteras=parametrocarteraDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarParametroCartera(parametrocarteras);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroCarteraConstantesFunciones.refrescarForeignKeysDescripcionesParametroCartera(this.parametrocarteras);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosParametroCarterasWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		parametrocarteras = new  ArrayList<ParametroCartera>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroCartera.class.getSimpleName()+"-getTodosParametroCarterasWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ParametroCarteraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametrocarteras=parametrocarteraDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarParametroCartera(parametrocarteras);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroCarteraConstantesFunciones.refrescarForeignKeysDescripcionesParametroCartera(this.parametrocarteras);
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
	
	public  void  getTodosParametroCarteras(String sFinalQuery,Pagination pagination)throws Exception {
		parametrocarteras = new  ArrayList<ParametroCartera>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ParametroCarteraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametrocarteras=parametrocarteraDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarParametroCartera(parametrocarteras);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroCarteraConstantesFunciones.refrescarForeignKeysDescripcionesParametroCartera(this.parametrocarteras);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarParametroCartera(ParametroCartera parametrocartera) throws Exception {
		Boolean estaValidado=false;
		
		if(parametrocartera.getIsNew() || parametrocartera.getIsChanged()) { 
			this.invalidValues = parametrocarteraValidator.getInvalidValues(parametrocartera);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(parametrocartera);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarParametroCartera(List<ParametroCartera> ParametroCarteras) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(ParametroCartera parametrocarteraLocal:parametrocarteras) {				
			estaValidadoObjeto=this.validarGuardarParametroCartera(parametrocarteraLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarParametroCartera(List<ParametroCartera> ParametroCarteras) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarParametroCartera(parametrocarteras)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarParametroCartera(ParametroCartera ParametroCartera) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarParametroCartera(parametrocartera)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(ParametroCartera parametrocartera) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+parametrocartera.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=ParametroCarteraConstantesFunciones.getParametroCarteraLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"parametrocartera","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(ParametroCarteraConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(ParametroCarteraConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveParametroCarteraWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroCartera.class.getSimpleName()+"-saveParametroCarteraWithConnection");connexion.begin();			
			
			ParametroCarteraLogicAdditional.checkParametroCarteraToSave(this.parametrocartera,this.datosCliente,connexion,this.arrDatoGeneral);
			
			ParametroCarteraLogicAdditional.updateParametroCarteraToSave(this.parametrocartera,this.arrDatoGeneral);
			
			ParametroCarteraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.parametrocartera,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowParametroCartera();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarParametroCartera(this.parametrocartera)) {
				ParametroCarteraDataAccess.save(this.parametrocartera, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.parametrocartera,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			ParametroCarteraLogicAdditional.checkParametroCarteraToSaveAfter(this.parametrocartera,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowParametroCartera();
			
			connexion.commit();			
			
			if(this.parametrocartera.getIsDeleted()) {
				this.parametrocartera=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveParametroCartera()throws Exception {	
		try {	
			
			ParametroCarteraLogicAdditional.checkParametroCarteraToSave(this.parametrocartera,this.datosCliente,connexion,this.arrDatoGeneral);
			
			ParametroCarteraLogicAdditional.updateParametroCarteraToSave(this.parametrocartera,this.arrDatoGeneral);
			
			ParametroCarteraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.parametrocartera,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarParametroCartera(this.parametrocartera)) {			
				ParametroCarteraDataAccess.save(this.parametrocartera, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.parametrocartera,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			ParametroCarteraLogicAdditional.checkParametroCarteraToSaveAfter(this.parametrocartera,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.parametrocartera.getIsDeleted()) {
				this.parametrocartera=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveParametroCarterasWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroCartera.class.getSimpleName()+"-saveParametroCarterasWithConnection");connexion.begin();			
			
			ParametroCarteraLogicAdditional.checkParametroCarteraToSaves(parametrocarteras,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowParametroCarteras();
			
			Boolean validadoTodosParametroCartera=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(ParametroCartera parametrocarteraLocal:parametrocarteras) {		
				if(parametrocarteraLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				ParametroCarteraLogicAdditional.updateParametroCarteraToSave(parametrocarteraLocal,this.arrDatoGeneral);
	        	
				ParametroCarteraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),parametrocarteraLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarParametroCartera(parametrocarteraLocal)) {
					ParametroCarteraDataAccess.save(parametrocarteraLocal, connexion);				
				} else {
					validadoTodosParametroCartera=false;
				}
			}
			
			if(!validadoTodosParametroCartera) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			ParametroCarteraLogicAdditional.checkParametroCarteraToSavesAfter(parametrocarteras,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowParametroCarteras();
			
			connexion.commit();		
			
			this.quitarParametroCarterasEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveParametroCarteras()throws Exception {				
		 try {	
			ParametroCarteraLogicAdditional.checkParametroCarteraToSaves(parametrocarteras,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosParametroCartera=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(ParametroCartera parametrocarteraLocal:parametrocarteras) {				
				if(parametrocarteraLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				ParametroCarteraLogicAdditional.updateParametroCarteraToSave(parametrocarteraLocal,this.arrDatoGeneral);
	        	
				ParametroCarteraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),parametrocarteraLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarParametroCartera(parametrocarteraLocal)) {				
					ParametroCarteraDataAccess.save(parametrocarteraLocal, connexion);				
				} else {
					validadoTodosParametroCartera=false;
				}
			}
			
			if(!validadoTodosParametroCartera) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			ParametroCarteraLogicAdditional.checkParametroCarteraToSavesAfter(parametrocarteras,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarParametroCarterasEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public ParametroCarteraParameterReturnGeneral procesarAccionParametroCarteras(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<ParametroCartera> parametrocarteras,ParametroCarteraParameterReturnGeneral parametrocarteraParameterGeneral)throws Exception {
		 try {	
			ParametroCarteraParameterReturnGeneral parametrocarteraReturnGeneral=new ParametroCarteraParameterReturnGeneral();
	
			ParametroCarteraLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,parametrocarteras,parametrocarteraParameterGeneral,parametrocarteraReturnGeneral);
			
			return parametrocarteraReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public ParametroCarteraParameterReturnGeneral procesarAccionParametroCarterasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<ParametroCartera> parametrocarteras,ParametroCarteraParameterReturnGeneral parametrocarteraParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroCartera.class.getSimpleName()+"-procesarAccionParametroCarterasWithConnection");connexion.begin();			
			
			ParametroCarteraParameterReturnGeneral parametrocarteraReturnGeneral=new ParametroCarteraParameterReturnGeneral();
	
			ParametroCarteraLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,parametrocarteras,parametrocarteraParameterGeneral,parametrocarteraReturnGeneral);
			
			this.connexion.commit();
			
			return parametrocarteraReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public ParametroCarteraParameterReturnGeneral procesarEventosParametroCarteras(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<ParametroCartera> parametrocarteras,ParametroCartera parametrocartera,ParametroCarteraParameterReturnGeneral parametrocarteraParameterGeneral,Boolean isEsNuevoParametroCartera,ArrayList<Classe> clases)throws Exception {
		 try {	
			ParametroCarteraParameterReturnGeneral parametrocarteraReturnGeneral=new ParametroCarteraParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				parametrocarteraReturnGeneral.setConRecargarPropiedades(true);
			}
			
			ParametroCarteraLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,parametrocarteras,parametrocartera,parametrocarteraParameterGeneral,parametrocarteraReturnGeneral,isEsNuevoParametroCartera,clases);
			
			return parametrocarteraReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public ParametroCarteraParameterReturnGeneral procesarEventosParametroCarterasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<ParametroCartera> parametrocarteras,ParametroCartera parametrocartera,ParametroCarteraParameterReturnGeneral parametrocarteraParameterGeneral,Boolean isEsNuevoParametroCartera,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroCartera.class.getSimpleName()+"-procesarEventosParametroCarterasWithConnection");connexion.begin();			
			
			ParametroCarteraParameterReturnGeneral parametrocarteraReturnGeneral=new ParametroCarteraParameterReturnGeneral();
	
			parametrocarteraReturnGeneral.setParametroCartera(parametrocartera);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				parametrocarteraReturnGeneral.setConRecargarPropiedades(true);
			}
			
			ParametroCarteraLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,parametrocarteras,parametrocartera,parametrocarteraParameterGeneral,parametrocarteraReturnGeneral,isEsNuevoParametroCartera,clases);
			
			this.connexion.commit();
			
			return parametrocarteraReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public ParametroCarteraParameterReturnGeneral procesarImportacionParametroCarterasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,ParametroCarteraParameterReturnGeneral parametrocarteraParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroCartera.class.getSimpleName()+"-procesarImportacionParametroCarterasWithConnection");connexion.begin();			
			
			ParametroCarteraParameterReturnGeneral parametrocarteraReturnGeneral=new ParametroCarteraParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.parametrocarteras=new ArrayList<ParametroCartera>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.parametrocartera=new ParametroCartera();
				
				
				if(conColumnasBase) {this.parametrocartera.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.parametrocartera.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.parametrocartera.setnumero_digitos_factura(Integer.parseInt(arrColumnas[iColumn++]));
				this.parametrocartera.setpor_lotes(Boolean.parseBoolean(arrColumnas[iColumn++]));
				this.parametrocartera.setnumero_orden_pago(arrColumnas[iColumn++]);
				this.parametrocartera.setdescripcion(arrColumnas[iColumn++]);
				
				this.parametrocarteras.add(this.parametrocartera);
			}
			
			this.saveParametroCarteras();
			
			this.connexion.commit();
			
			parametrocarteraReturnGeneral.setConRetornoEstaProcesado(true);
			parametrocarteraReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return parametrocarteraReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarParametroCarterasEliminados() throws Exception {				
		
		List<ParametroCartera> parametrocarterasAux= new ArrayList<ParametroCartera>();
		
		for(ParametroCartera parametrocartera:parametrocarteras) {
			if(!parametrocartera.getIsDeleted()) {
				parametrocarterasAux.add(parametrocartera);
			}
		}
		
		parametrocarteras=parametrocarterasAux;
	}
	
	public void quitarParametroCarterasNulos() throws Exception {				
		
		List<ParametroCartera> parametrocarterasAux= new ArrayList<ParametroCartera>();
		
		for(ParametroCartera parametrocartera : this.parametrocarteras) {
			if(parametrocartera==null) {
				parametrocarterasAux.add(parametrocartera);
			}
		}
		
		//this.parametrocarteras=parametrocarterasAux;
		
		this.parametrocarteras.removeAll(parametrocarterasAux);
	}
	
	public void getSetVersionRowParametroCarteraWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(parametrocartera.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((parametrocartera.getIsDeleted() || (parametrocartera.getIsChanged()&&!parametrocartera.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=parametrocarteraDataAccess.getSetVersionRowParametroCartera(connexion,parametrocartera.getId());
				
				if(!parametrocartera.getVersionRow().equals(timestamp)) {	
					parametrocartera.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				parametrocartera.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowParametroCartera()throws Exception {	
		
		if(parametrocartera.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((parametrocartera.getIsDeleted() || (parametrocartera.getIsChanged()&&!parametrocartera.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=parametrocarteraDataAccess.getSetVersionRowParametroCartera(connexion,parametrocartera.getId());
			
			try {							
				if(!parametrocartera.getVersionRow().equals(timestamp)) {	
					parametrocartera.setVersionRow(timestamp);
				}
				
				parametrocartera.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowParametroCarterasWithConnection()throws Exception {	
		if(parametrocarteras!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(ParametroCartera parametrocarteraAux:parametrocarteras) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(parametrocarteraAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(parametrocarteraAux.getIsDeleted() || (parametrocarteraAux.getIsChanged()&&!parametrocarteraAux.getIsNew())) {
						
						timestamp=parametrocarteraDataAccess.getSetVersionRowParametroCartera(connexion,parametrocarteraAux.getId());
						
						if(!parametrocartera.getVersionRow().equals(timestamp)) {	
							parametrocarteraAux.setVersionRow(timestamp);
						}
								
						parametrocarteraAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowParametroCarteras()throws Exception {	
		if(parametrocarteras!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(ParametroCartera parametrocarteraAux:parametrocarteras) {
					if(parametrocarteraAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(parametrocarteraAux.getIsDeleted() || (parametrocarteraAux.getIsChanged()&&!parametrocarteraAux.getIsNew())) {
						
						timestamp=parametrocarteraDataAccess.getSetVersionRowParametroCartera(connexion,parametrocarteraAux.getId());
						
						if(!parametrocarteraAux.getVersionRow().equals(timestamp)) {	
							parametrocarteraAux.setVersionRow(timestamp);
						}
						
													
						parametrocarteraAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public ParametroCarteraParameterReturnGeneral cargarCombosLoteForeignKeyParametroCarteraWithConnection(String finalQueryGlobalEmpresa,String finalQueryGlobalTransaccionFactura,String finalQueryGlobalEmpleado,String finalQueryGlobalTransaccionDeshabilita,String finalQueryGlobalTransaccionHabilita,String finalQueryGlobalBodega,String finalQueryGlobalTipoFactura,String finalQueryGlobalTipoAutoPago,String finalQueryGlobalCuentaContableCreditoFiscal) throws Exception {
		ParametroCarteraParameterReturnGeneral  parametrocarteraReturnGeneral =new ParametroCarteraParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroCartera.class.getSimpleName()+"-cargarCombosLoteForeignKeyParametroCarteraWithConnection");connexion.begin();
			
			parametrocarteraReturnGeneral =new ParametroCarteraParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			parametrocarteraReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Transaccion> transaccionfacturasForeignKey=new ArrayList<Transaccion>();
			TransaccionLogic transaccionfacturaLogic=new TransaccionLogic();
			transaccionfacturaLogic.setConnexion(this.connexion);
			transaccionfacturaLogic.getTransaccionDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTransaccionFactura.equals("NONE")) {
				transaccionfacturaLogic.getTodosTransaccions(finalQueryGlobalTransaccionFactura,new Pagination());
				transaccionfacturasForeignKey=transaccionfacturaLogic.getTransaccions();
			}

			parametrocarteraReturnGeneral.settransaccionfacturasForeignKey(transaccionfacturasForeignKey);


			List<Empleado> empleadosForeignKey=new ArrayList<Empleado>();
			EmpleadoLogic empleadoLogic=new EmpleadoLogic();
			empleadoLogic.setConnexion(this.connexion);
			empleadoLogic.getEmpleadoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpleado.equals("NONE")) {
				empleadoLogic.getTodosEmpleados(finalQueryGlobalEmpleado,new Pagination());
				empleadosForeignKey=empleadoLogic.getEmpleados();
			}

			parametrocarteraReturnGeneral.setempleadosForeignKey(empleadosForeignKey);


			List<Transaccion> transacciondeshabilitasForeignKey=new ArrayList<Transaccion>();
			TransaccionLogic transacciondeshabilitaLogic=new TransaccionLogic();
			transacciondeshabilitaLogic.setConnexion(this.connexion);
			transacciondeshabilitaLogic.getTransaccionDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTransaccionDeshabilita.equals("NONE")) {
				transacciondeshabilitaLogic.getTodosTransaccions(finalQueryGlobalTransaccionDeshabilita,new Pagination());
				transacciondeshabilitasForeignKey=transacciondeshabilitaLogic.getTransaccions();
			}

			parametrocarteraReturnGeneral.settransacciondeshabilitasForeignKey(transacciondeshabilitasForeignKey);


			List<Transaccion> transaccionhabilitasForeignKey=new ArrayList<Transaccion>();
			TransaccionLogic transaccionhabilitaLogic=new TransaccionLogic();
			transaccionhabilitaLogic.setConnexion(this.connexion);
			transaccionhabilitaLogic.getTransaccionDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTransaccionHabilita.equals("NONE")) {
				transaccionhabilitaLogic.getTodosTransaccions(finalQueryGlobalTransaccionHabilita,new Pagination());
				transaccionhabilitasForeignKey=transaccionhabilitaLogic.getTransaccions();
			}

			parametrocarteraReturnGeneral.settransaccionhabilitasForeignKey(transaccionhabilitasForeignKey);


			List<Bodega> bodegasForeignKey=new ArrayList<Bodega>();
			BodegaLogic bodegaLogic=new BodegaLogic();
			bodegaLogic.setConnexion(this.connexion);
			bodegaLogic.getBodegaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalBodega.equals("NONE")) {
				bodegaLogic.getTodosBodegas(finalQueryGlobalBodega,new Pagination());
				bodegasForeignKey=bodegaLogic.getBodegas();
			}

			parametrocarteraReturnGeneral.setbodegasForeignKey(bodegasForeignKey);


			List<TipoFactura> tipofacturasForeignKey=new ArrayList<TipoFactura>();
			TipoFacturaLogic tipofacturaLogic=new TipoFacturaLogic();
			tipofacturaLogic.setConnexion(this.connexion);
			tipofacturaLogic.getTipoFacturaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoFactura.equals("NONE")) {
				tipofacturaLogic.getTodosTipoFacturas(finalQueryGlobalTipoFactura,new Pagination());
				tipofacturasForeignKey=tipofacturaLogic.getTipoFacturas();
			}

			parametrocarteraReturnGeneral.settipofacturasForeignKey(tipofacturasForeignKey);


			List<TipoAutoPago> tipoautopagosForeignKey=new ArrayList<TipoAutoPago>();
			TipoAutoPagoLogic tipoautopagoLogic=new TipoAutoPagoLogic();
			tipoautopagoLogic.setConnexion(this.connexion);
			tipoautopagoLogic.getTipoAutoPagoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoAutoPago.equals("NONE")) {
				tipoautopagoLogic.getTodosTipoAutoPagos(finalQueryGlobalTipoAutoPago,new Pagination());
				tipoautopagosForeignKey=tipoautopagoLogic.getTipoAutoPagos();
			}

			parametrocarteraReturnGeneral.settipoautopagosForeignKey(tipoautopagosForeignKey);


			List<CuentaContable> cuentacontablecreditofiscalsForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontablecreditofiscalLogic=new CuentaContableLogic();
			cuentacontablecreditofiscalLogic.setConnexion(this.connexion);
			cuentacontablecreditofiscalLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContableCreditoFiscal.equals("NONE")) {
				cuentacontablecreditofiscalLogic.getTodosCuentaContables(finalQueryGlobalCuentaContableCreditoFiscal,new Pagination());
				cuentacontablecreditofiscalsForeignKey=cuentacontablecreditofiscalLogic.getCuentaContables();
			}

			parametrocarteraReturnGeneral.setcuentacontablecreditofiscalsForeignKey(cuentacontablecreditofiscalsForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return parametrocarteraReturnGeneral;
	}
	
	public ParametroCarteraParameterReturnGeneral cargarCombosLoteForeignKeyParametroCartera(String finalQueryGlobalEmpresa,String finalQueryGlobalTransaccionFactura,String finalQueryGlobalEmpleado,String finalQueryGlobalTransaccionDeshabilita,String finalQueryGlobalTransaccionHabilita,String finalQueryGlobalBodega,String finalQueryGlobalTipoFactura,String finalQueryGlobalTipoAutoPago,String finalQueryGlobalCuentaContableCreditoFiscal) throws Exception {
		ParametroCarteraParameterReturnGeneral  parametrocarteraReturnGeneral =new ParametroCarteraParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			parametrocarteraReturnGeneral =new ParametroCarteraParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			parametrocarteraReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Transaccion> transaccionfacturasForeignKey=new ArrayList<Transaccion>();
			TransaccionLogic transaccionfacturaLogic=new TransaccionLogic();
			transaccionfacturaLogic.setConnexion(this.connexion);
			transaccionfacturaLogic.getTransaccionDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTransaccionFactura.equals("NONE")) {
				transaccionfacturaLogic.getTodosTransaccions(finalQueryGlobalTransaccionFactura,new Pagination());
				transaccionfacturasForeignKey=transaccionfacturaLogic.getTransaccions();
			}

			parametrocarteraReturnGeneral.settransaccionfacturasForeignKey(transaccionfacturasForeignKey);


			List<Empleado> empleadosForeignKey=new ArrayList<Empleado>();
			EmpleadoLogic empleadoLogic=new EmpleadoLogic();
			empleadoLogic.setConnexion(this.connexion);
			empleadoLogic.getEmpleadoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpleado.equals("NONE")) {
				empleadoLogic.getTodosEmpleados(finalQueryGlobalEmpleado,new Pagination());
				empleadosForeignKey=empleadoLogic.getEmpleados();
			}

			parametrocarteraReturnGeneral.setempleadosForeignKey(empleadosForeignKey);


			List<Transaccion> transacciondeshabilitasForeignKey=new ArrayList<Transaccion>();
			TransaccionLogic transacciondeshabilitaLogic=new TransaccionLogic();
			transacciondeshabilitaLogic.setConnexion(this.connexion);
			transacciondeshabilitaLogic.getTransaccionDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTransaccionDeshabilita.equals("NONE")) {
				transacciondeshabilitaLogic.getTodosTransaccions(finalQueryGlobalTransaccionDeshabilita,new Pagination());
				transacciondeshabilitasForeignKey=transacciondeshabilitaLogic.getTransaccions();
			}

			parametrocarteraReturnGeneral.settransacciondeshabilitasForeignKey(transacciondeshabilitasForeignKey);


			List<Transaccion> transaccionhabilitasForeignKey=new ArrayList<Transaccion>();
			TransaccionLogic transaccionhabilitaLogic=new TransaccionLogic();
			transaccionhabilitaLogic.setConnexion(this.connexion);
			transaccionhabilitaLogic.getTransaccionDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTransaccionHabilita.equals("NONE")) {
				transaccionhabilitaLogic.getTodosTransaccions(finalQueryGlobalTransaccionHabilita,new Pagination());
				transaccionhabilitasForeignKey=transaccionhabilitaLogic.getTransaccions();
			}

			parametrocarteraReturnGeneral.settransaccionhabilitasForeignKey(transaccionhabilitasForeignKey);


			List<Bodega> bodegasForeignKey=new ArrayList<Bodega>();
			BodegaLogic bodegaLogic=new BodegaLogic();
			bodegaLogic.setConnexion(this.connexion);
			bodegaLogic.getBodegaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalBodega.equals("NONE")) {
				bodegaLogic.getTodosBodegas(finalQueryGlobalBodega,new Pagination());
				bodegasForeignKey=bodegaLogic.getBodegas();
			}

			parametrocarteraReturnGeneral.setbodegasForeignKey(bodegasForeignKey);


			List<TipoFactura> tipofacturasForeignKey=new ArrayList<TipoFactura>();
			TipoFacturaLogic tipofacturaLogic=new TipoFacturaLogic();
			tipofacturaLogic.setConnexion(this.connexion);
			tipofacturaLogic.getTipoFacturaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoFactura.equals("NONE")) {
				tipofacturaLogic.getTodosTipoFacturas(finalQueryGlobalTipoFactura,new Pagination());
				tipofacturasForeignKey=tipofacturaLogic.getTipoFacturas();
			}

			parametrocarteraReturnGeneral.settipofacturasForeignKey(tipofacturasForeignKey);


			List<TipoAutoPago> tipoautopagosForeignKey=new ArrayList<TipoAutoPago>();
			TipoAutoPagoLogic tipoautopagoLogic=new TipoAutoPagoLogic();
			tipoautopagoLogic.setConnexion(this.connexion);
			tipoautopagoLogic.getTipoAutoPagoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoAutoPago.equals("NONE")) {
				tipoautopagoLogic.getTodosTipoAutoPagos(finalQueryGlobalTipoAutoPago,new Pagination());
				tipoautopagosForeignKey=tipoautopagoLogic.getTipoAutoPagos();
			}

			parametrocarteraReturnGeneral.settipoautopagosForeignKey(tipoautopagosForeignKey);


			List<CuentaContable> cuentacontablecreditofiscalsForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontablecreditofiscalLogic=new CuentaContableLogic();
			cuentacontablecreditofiscalLogic.setConnexion(this.connexion);
			cuentacontablecreditofiscalLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContableCreditoFiscal.equals("NONE")) {
				cuentacontablecreditofiscalLogic.getTodosCuentaContables(finalQueryGlobalCuentaContableCreditoFiscal,new Pagination());
				cuentacontablecreditofiscalsForeignKey=cuentacontablecreditofiscalLogic.getCuentaContables();
			}

			parametrocarteraReturnGeneral.setcuentacontablecreditofiscalsForeignKey(cuentacontablecreditofiscalsForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return parametrocarteraReturnGeneral;
	}
	
	
	public void deepLoad(ParametroCartera parametrocartera,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			ParametroCarteraLogicAdditional.updateParametroCarteraToGet(parametrocartera,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		parametrocartera.setEmpresa(parametrocarteraDataAccess.getEmpresa(connexion,parametrocartera));
		parametrocartera.setTransaccionFactura(parametrocarteraDataAccess.getTransaccionFactura(connexion,parametrocartera));
		parametrocartera.setEmpleado(parametrocarteraDataAccess.getEmpleado(connexion,parametrocartera));
		parametrocartera.setTransaccionDeshabilita(parametrocarteraDataAccess.getTransaccionDeshabilita(connexion,parametrocartera));
		parametrocartera.setTransaccionHabilita(parametrocarteraDataAccess.getTransaccionHabilita(connexion,parametrocartera));
		parametrocartera.setBodega(parametrocarteraDataAccess.getBodega(connexion,parametrocartera));
		parametrocartera.setTipoFactura(parametrocarteraDataAccess.getTipoFactura(connexion,parametrocartera));
		parametrocartera.setTipoAutoPago(parametrocarteraDataAccess.getTipoAutoPago(connexion,parametrocartera));
		parametrocartera.setCuentaContableCreditoFiscal(parametrocarteraDataAccess.getCuentaContableCreditoFiscal(connexion,parametrocartera));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				parametrocartera.setEmpresa(parametrocarteraDataAccess.getEmpresa(connexion,parametrocartera));
				continue;
			}

			if(clas.clas.equals(Transaccion.class)) {
				parametrocartera.setTransaccionFactura(parametrocarteraDataAccess.getTransaccionFactura(connexion,parametrocartera));
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				parametrocartera.setEmpleado(parametrocarteraDataAccess.getEmpleado(connexion,parametrocartera));
				continue;
			}

			if(clas.clas.equals(Transaccion.class)) {
				parametrocartera.setTransaccionDeshabilita(parametrocarteraDataAccess.getTransaccionDeshabilita(connexion,parametrocartera));
				continue;
			}

			if(clas.clas.equals(Transaccion.class)) {
				parametrocartera.setTransaccionHabilita(parametrocarteraDataAccess.getTransaccionHabilita(connexion,parametrocartera));
				continue;
			}

			if(clas.clas.equals(Bodega.class)) {
				parametrocartera.setBodega(parametrocarteraDataAccess.getBodega(connexion,parametrocartera));
				continue;
			}

			if(clas.clas.equals(TipoFactura.class)) {
				parametrocartera.setTipoFactura(parametrocarteraDataAccess.getTipoFactura(connexion,parametrocartera));
				continue;
			}

			if(clas.clas.equals(TipoAutoPago.class)) {
				parametrocartera.setTipoAutoPago(parametrocarteraDataAccess.getTipoAutoPago(connexion,parametrocartera));
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				parametrocartera.setCuentaContableCreditoFiscal(parametrocarteraDataAccess.getCuentaContableCreditoFiscal(connexion,parametrocartera));
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
			parametrocartera.setEmpresa(parametrocarteraDataAccess.getEmpresa(connexion,parametrocartera));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Transaccion.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrocartera.setTransaccionFactura(parametrocarteraDataAccess.getTransaccionFactura(connexion,parametrocartera));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Empleado.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrocartera.setEmpleado(parametrocarteraDataAccess.getEmpleado(connexion,parametrocartera));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Transaccion.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrocartera.setTransaccionDeshabilita(parametrocarteraDataAccess.getTransaccionDeshabilita(connexion,parametrocartera));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Transaccion.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrocartera.setTransaccionHabilita(parametrocarteraDataAccess.getTransaccionHabilita(connexion,parametrocartera));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Bodega.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrocartera.setBodega(parametrocarteraDataAccess.getBodega(connexion,parametrocartera));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoFactura.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrocartera.setTipoFactura(parametrocarteraDataAccess.getTipoFactura(connexion,parametrocartera));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoAutoPago.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrocartera.setTipoAutoPago(parametrocarteraDataAccess.getTipoAutoPago(connexion,parametrocartera));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrocartera.setCuentaContableCreditoFiscal(parametrocarteraDataAccess.getCuentaContableCreditoFiscal(connexion,parametrocartera));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		parametrocartera.setEmpresa(parametrocarteraDataAccess.getEmpresa(connexion,parametrocartera));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(parametrocartera.getEmpresa(),isDeep,deepLoadType,clases);
				
		parametrocartera.setTransaccionFactura(parametrocarteraDataAccess.getTransaccionFactura(connexion,parametrocartera));
		TransaccionLogic transaccionfacturaLogic= new TransaccionLogic(connexion);
		transaccionfacturaLogic.deepLoad(parametrocartera.getTransaccionFactura(),isDeep,deepLoadType,clases);
				
		parametrocartera.setEmpleado(parametrocarteraDataAccess.getEmpleado(connexion,parametrocartera));
		EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
		empleadoLogic.deepLoad(parametrocartera.getEmpleado(),isDeep,deepLoadType,clases);
				
		parametrocartera.setTransaccionDeshabilita(parametrocarteraDataAccess.getTransaccionDeshabilita(connexion,parametrocartera));
		TransaccionLogic transacciondeshabilitaLogic= new TransaccionLogic(connexion);
		transacciondeshabilitaLogic.deepLoad(parametrocartera.getTransaccionDeshabilita(),isDeep,deepLoadType,clases);
				
		parametrocartera.setTransaccionHabilita(parametrocarteraDataAccess.getTransaccionHabilita(connexion,parametrocartera));
		TransaccionLogic transaccionhabilitaLogic= new TransaccionLogic(connexion);
		transaccionhabilitaLogic.deepLoad(parametrocartera.getTransaccionHabilita(),isDeep,deepLoadType,clases);
				
		parametrocartera.setBodega(parametrocarteraDataAccess.getBodega(connexion,parametrocartera));
		BodegaLogic bodegaLogic= new BodegaLogic(connexion);
		bodegaLogic.deepLoad(parametrocartera.getBodega(),isDeep,deepLoadType,clases);
				
		parametrocartera.setTipoFactura(parametrocarteraDataAccess.getTipoFactura(connexion,parametrocartera));
		TipoFacturaLogic tipofacturaLogic= new TipoFacturaLogic(connexion);
		tipofacturaLogic.deepLoad(parametrocartera.getTipoFactura(),isDeep,deepLoadType,clases);
				
		parametrocartera.setTipoAutoPago(parametrocarteraDataAccess.getTipoAutoPago(connexion,parametrocartera));
		TipoAutoPagoLogic tipoautopagoLogic= new TipoAutoPagoLogic(connexion);
		tipoautopagoLogic.deepLoad(parametrocartera.getTipoAutoPago(),isDeep,deepLoadType,clases);
				
		parametrocartera.setCuentaContableCreditoFiscal(parametrocarteraDataAccess.getCuentaContableCreditoFiscal(connexion,parametrocartera));
		CuentaContableLogic cuentacontablecreditofiscalLogic= new CuentaContableLogic(connexion);
		cuentacontablecreditofiscalLogic.deepLoad(parametrocartera.getCuentaContableCreditoFiscal(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				parametrocartera.setEmpresa(parametrocarteraDataAccess.getEmpresa(connexion,parametrocartera));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(parametrocartera.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Transaccion.class)) {
				parametrocartera.setTransaccionFactura(parametrocarteraDataAccess.getTransaccionFactura(connexion,parametrocartera));
				TransaccionLogic transaccionLogic= new TransaccionLogic(connexion);
				transaccionLogic.deepLoad(parametrocartera.getTransaccionFactura(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				parametrocartera.setEmpleado(parametrocarteraDataAccess.getEmpleado(connexion,parametrocartera));
				EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
				empleadoLogic.deepLoad(parametrocartera.getEmpleado(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Transaccion.class)) {
				parametrocartera.setTransaccionDeshabilita(parametrocarteraDataAccess.getTransaccionDeshabilita(connexion,parametrocartera));
				TransaccionLogic transaccionLogic= new TransaccionLogic(connexion);
				transaccionLogic.deepLoad(parametrocartera.getTransaccionDeshabilita(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Transaccion.class)) {
				parametrocartera.setTransaccionHabilita(parametrocarteraDataAccess.getTransaccionHabilita(connexion,parametrocartera));
				TransaccionLogic transaccionLogic= new TransaccionLogic(connexion);
				transaccionLogic.deepLoad(parametrocartera.getTransaccionHabilita(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Bodega.class)) {
				parametrocartera.setBodega(parametrocarteraDataAccess.getBodega(connexion,parametrocartera));
				BodegaLogic bodegaLogic= new BodegaLogic(connexion);
				bodegaLogic.deepLoad(parametrocartera.getBodega(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoFactura.class)) {
				parametrocartera.setTipoFactura(parametrocarteraDataAccess.getTipoFactura(connexion,parametrocartera));
				TipoFacturaLogic tipofacturaLogic= new TipoFacturaLogic(connexion);
				tipofacturaLogic.deepLoad(parametrocartera.getTipoFactura(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoAutoPago.class)) {
				parametrocartera.setTipoAutoPago(parametrocarteraDataAccess.getTipoAutoPago(connexion,parametrocartera));
				TipoAutoPagoLogic tipoautopagoLogic= new TipoAutoPagoLogic(connexion);
				tipoautopagoLogic.deepLoad(parametrocartera.getTipoAutoPago(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				parametrocartera.setCuentaContableCreditoFiscal(parametrocarteraDataAccess.getCuentaContableCreditoFiscal(connexion,parametrocartera));
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepLoad(parametrocartera.getCuentaContableCreditoFiscal(),isDeep,deepLoadType,clases);				
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
			parametrocartera.setEmpresa(parametrocarteraDataAccess.getEmpresa(connexion,parametrocartera));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(parametrocartera.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Transaccion.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrocartera.setTransaccionFactura(parametrocarteraDataAccess.getTransaccionFactura(connexion,parametrocartera));
			TransaccionLogic transaccionLogic= new TransaccionLogic(connexion);
			transaccionLogic.deepLoad(parametrocartera.getTransaccionFactura(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Empleado.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrocartera.setEmpleado(parametrocarteraDataAccess.getEmpleado(connexion,parametrocartera));
			EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
			empleadoLogic.deepLoad(parametrocartera.getEmpleado(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Transaccion.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrocartera.setTransaccionDeshabilita(parametrocarteraDataAccess.getTransaccionDeshabilita(connexion,parametrocartera));
			TransaccionLogic transaccionLogic= new TransaccionLogic(connexion);
			transaccionLogic.deepLoad(parametrocartera.getTransaccionDeshabilita(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Transaccion.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrocartera.setTransaccionHabilita(parametrocarteraDataAccess.getTransaccionHabilita(connexion,parametrocartera));
			TransaccionLogic transaccionLogic= new TransaccionLogic(connexion);
			transaccionLogic.deepLoad(parametrocartera.getTransaccionHabilita(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Bodega.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrocartera.setBodega(parametrocarteraDataAccess.getBodega(connexion,parametrocartera));
			BodegaLogic bodegaLogic= new BodegaLogic(connexion);
			bodegaLogic.deepLoad(parametrocartera.getBodega(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoFactura.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrocartera.setTipoFactura(parametrocarteraDataAccess.getTipoFactura(connexion,parametrocartera));
			TipoFacturaLogic tipofacturaLogic= new TipoFacturaLogic(connexion);
			tipofacturaLogic.deepLoad(parametrocartera.getTipoFactura(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoAutoPago.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrocartera.setTipoAutoPago(parametrocarteraDataAccess.getTipoAutoPago(connexion,parametrocartera));
			TipoAutoPagoLogic tipoautopagoLogic= new TipoAutoPagoLogic(connexion);
			tipoautopagoLogic.deepLoad(parametrocartera.getTipoAutoPago(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrocartera.setCuentaContableCreditoFiscal(parametrocarteraDataAccess.getCuentaContableCreditoFiscal(connexion,parametrocartera));
			CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
			cuentacontableLogic.deepLoad(parametrocartera.getCuentaContableCreditoFiscal(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(ParametroCartera parametrocartera,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			ParametroCarteraLogicAdditional.updateParametroCarteraToSave(parametrocartera,this.arrDatoGeneral);
			
ParametroCarteraDataAccess.save(parametrocartera, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(parametrocartera.getEmpresa(),connexion);

		TransaccionDataAccess.save(parametrocartera.getTransaccionFactura(),connexion);

		EmpleadoDataAccess.save(parametrocartera.getEmpleado(),connexion);

		TransaccionDataAccess.save(parametrocartera.getTransaccionDeshabilita(),connexion);

		TransaccionDataAccess.save(parametrocartera.getTransaccionHabilita(),connexion);

		BodegaDataAccess.save(parametrocartera.getBodega(),connexion);

		TipoFacturaDataAccess.save(parametrocartera.getTipoFactura(),connexion);

		TipoAutoPagoDataAccess.save(parametrocartera.getTipoAutoPago(),connexion);

		CuentaContableDataAccess.save(parametrocartera.getCuentaContableCreditoFiscal(),connexion);
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(parametrocartera.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(Transaccion.class)) {
				TransaccionDataAccess.save(parametrocartera.getTransaccionFactura(),connexion);
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				EmpleadoDataAccess.save(parametrocartera.getEmpleado(),connexion);
				continue;
			}

			if(clas.clas.equals(Transaccion.class)) {
				TransaccionDataAccess.save(parametrocartera.getTransaccionDeshabilita(),connexion);
				continue;
			}

			if(clas.clas.equals(Transaccion.class)) {
				TransaccionDataAccess.save(parametrocartera.getTransaccionHabilita(),connexion);
				continue;
			}

			if(clas.clas.equals(Bodega.class)) {
				BodegaDataAccess.save(parametrocartera.getBodega(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoFactura.class)) {
				TipoFacturaDataAccess.save(parametrocartera.getTipoFactura(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoAutoPago.class)) {
				TipoAutoPagoDataAccess.save(parametrocartera.getTipoAutoPago(),connexion);
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(parametrocartera.getCuentaContableCreditoFiscal(),connexion);
				continue;
			}

		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(parametrocartera.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(parametrocartera.getEmpresa(),isDeep,deepLoadType,clases);
				

		TransaccionDataAccess.save(parametrocartera.getTransaccionFactura(),connexion);
		TransaccionLogic transaccionfacturaLogic= new TransaccionLogic(connexion);
		transaccionfacturaLogic.deepLoad(parametrocartera.getTransaccionFactura(),isDeep,deepLoadType,clases);
				

		EmpleadoDataAccess.save(parametrocartera.getEmpleado(),connexion);
		EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
		empleadoLogic.deepLoad(parametrocartera.getEmpleado(),isDeep,deepLoadType,clases);
				

		TransaccionDataAccess.save(parametrocartera.getTransaccionDeshabilita(),connexion);
		TransaccionLogic transacciondeshabilitaLogic= new TransaccionLogic(connexion);
		transacciondeshabilitaLogic.deepLoad(parametrocartera.getTransaccionDeshabilita(),isDeep,deepLoadType,clases);
				

		TransaccionDataAccess.save(parametrocartera.getTransaccionHabilita(),connexion);
		TransaccionLogic transaccionhabilitaLogic= new TransaccionLogic(connexion);
		transaccionhabilitaLogic.deepLoad(parametrocartera.getTransaccionHabilita(),isDeep,deepLoadType,clases);
				

		BodegaDataAccess.save(parametrocartera.getBodega(),connexion);
		BodegaLogic bodegaLogic= new BodegaLogic(connexion);
		bodegaLogic.deepLoad(parametrocartera.getBodega(),isDeep,deepLoadType,clases);
				

		TipoFacturaDataAccess.save(parametrocartera.getTipoFactura(),connexion);
		TipoFacturaLogic tipofacturaLogic= new TipoFacturaLogic(connexion);
		tipofacturaLogic.deepLoad(parametrocartera.getTipoFactura(),isDeep,deepLoadType,clases);
				

		TipoAutoPagoDataAccess.save(parametrocartera.getTipoAutoPago(),connexion);
		TipoAutoPagoLogic tipoautopagoLogic= new TipoAutoPagoLogic(connexion);
		tipoautopagoLogic.deepLoad(parametrocartera.getTipoAutoPago(),isDeep,deepLoadType,clases);
				

		CuentaContableDataAccess.save(parametrocartera.getCuentaContableCreditoFiscal(),connexion);
		CuentaContableLogic cuentacontablecreditofiscalLogic= new CuentaContableLogic(connexion);
		cuentacontablecreditofiscalLogic.deepLoad(parametrocartera.getCuentaContableCreditoFiscal(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(parametrocartera.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(parametrocartera.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Transaccion.class)) {
				TransaccionDataAccess.save(parametrocartera.getTransaccionFactura(),connexion);
				TransaccionLogic transaccionLogic= new TransaccionLogic(connexion);
				transaccionLogic.deepSave(parametrocartera.getTransaccionFactura(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				EmpleadoDataAccess.save(parametrocartera.getEmpleado(),connexion);
				EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
				empleadoLogic.deepSave(parametrocartera.getEmpleado(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Transaccion.class)) {
				TransaccionDataAccess.save(parametrocartera.getTransaccionDeshabilita(),connexion);
				TransaccionLogic transaccionLogic= new TransaccionLogic(connexion);
				transaccionLogic.deepSave(parametrocartera.getTransaccionDeshabilita(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Transaccion.class)) {
				TransaccionDataAccess.save(parametrocartera.getTransaccionHabilita(),connexion);
				TransaccionLogic transaccionLogic= new TransaccionLogic(connexion);
				transaccionLogic.deepSave(parametrocartera.getTransaccionHabilita(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Bodega.class)) {
				BodegaDataAccess.save(parametrocartera.getBodega(),connexion);
				BodegaLogic bodegaLogic= new BodegaLogic(connexion);
				bodegaLogic.deepSave(parametrocartera.getBodega(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoFactura.class)) {
				TipoFacturaDataAccess.save(parametrocartera.getTipoFactura(),connexion);
				TipoFacturaLogic tipofacturaLogic= new TipoFacturaLogic(connexion);
				tipofacturaLogic.deepSave(parametrocartera.getTipoFactura(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoAutoPago.class)) {
				TipoAutoPagoDataAccess.save(parametrocartera.getTipoAutoPago(),connexion);
				TipoAutoPagoLogic tipoautopagoLogic= new TipoAutoPagoLogic(connexion);
				tipoautopagoLogic.deepSave(parametrocartera.getTipoAutoPago(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(parametrocartera.getCuentaContableCreditoFiscal(),connexion);
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepSave(parametrocartera.getCuentaContableCreditoFiscal(),isDeep,deepLoadType,clases);				
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
			this.getNewConnexionToDeep(ParametroCartera.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(parametrocartera,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				ParametroCarteraConstantesFunciones.refrescarForeignKeysDescripcionesParametroCartera(parametrocartera);
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
			this.deepLoad(this.parametrocartera,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				ParametroCarteraConstantesFunciones.refrescarForeignKeysDescripcionesParametroCartera(this.parametrocartera);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(ParametroCartera.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(parametrocarteras!=null) {
				for(ParametroCartera parametrocartera:parametrocarteras) {
					this.deepLoad(parametrocartera,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					ParametroCarteraConstantesFunciones.refrescarForeignKeysDescripcionesParametroCartera(parametrocarteras);
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
			if(parametrocarteras!=null) {
				for(ParametroCartera parametrocartera:parametrocarteras) {
					this.deepLoad(parametrocartera,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					ParametroCarteraConstantesFunciones.refrescarForeignKeysDescripcionesParametroCartera(parametrocarteras);
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
			this.getNewConnexionToDeep(ParametroCartera.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(parametrocartera,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(ParametroCartera.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(parametrocarteras!=null) {
				for(ParametroCartera parametrocartera:parametrocarteras) {
					this.deepSave(parametrocartera,isDeep,deepLoadType,clases);
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
			if(parametrocarteras!=null) {
				for(ParametroCartera parametrocartera:parametrocarteras) {
					this.deepSave(parametrocartera,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getParametroCarterasFK_IdBodegaWithConnection(String sFinalQuery,Pagination pagination,Long id_bodega)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroCartera.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidBodega= new ParameterSelectionGeneral();
			parameterSelectionGeneralidBodega.setParameterSelectionGeneralEqual(ParameterType.LONG,id_bodega,ParametroCarteraConstantesFunciones.IDBODEGA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidBodega);

			ParametroCarteraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdBodega","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrocarteras=parametrocarteraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroCarteraConstantesFunciones.refrescarForeignKeysDescripcionesParametroCartera(this.parametrocarteras);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getParametroCarterasFK_IdBodega(String sFinalQuery,Pagination pagination,Long id_bodega)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidBodega= new ParameterSelectionGeneral();
			parameterSelectionGeneralidBodega.setParameterSelectionGeneralEqual(ParameterType.LONG,id_bodega,ParametroCarteraConstantesFunciones.IDBODEGA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidBodega);

			ParametroCarteraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdBodega","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrocarteras=parametrocarteraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroCarteraConstantesFunciones.refrescarForeignKeysDescripcionesParametroCartera(this.parametrocarteras);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getParametroCarterasFK_IdCuentaContableCreditoFiscalWithConnection(String sFinalQuery,Pagination pagination,Long id_cuenta_contable_credito_fiscal)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroCartera.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContableCreditoFiscal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContableCreditoFiscal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable_credito_fiscal,ParametroCarteraConstantesFunciones.IDCUENTACONTABLECREDITOFISCAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContableCreditoFiscal);

			ParametroCarteraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContableCreditoFiscal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrocarteras=parametrocarteraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroCarteraConstantesFunciones.refrescarForeignKeysDescripcionesParametroCartera(this.parametrocarteras);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getParametroCarterasFK_IdCuentaContableCreditoFiscal(String sFinalQuery,Pagination pagination,Long id_cuenta_contable_credito_fiscal)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContableCreditoFiscal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContableCreditoFiscal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable_credito_fiscal,ParametroCarteraConstantesFunciones.IDCUENTACONTABLECREDITOFISCAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContableCreditoFiscal);

			ParametroCarteraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContableCreditoFiscal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrocarteras=parametrocarteraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroCarteraConstantesFunciones.refrescarForeignKeysDescripcionesParametroCartera(this.parametrocarteras);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getParametroCarterasFK_IdEmpleadoWithConnection(String sFinalQuery,Pagination pagination,Long id_empleado)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroCartera.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpleado= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpleado.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empleado,ParametroCarteraConstantesFunciones.IDEMPLEADO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpleado);

			ParametroCarteraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpleado","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrocarteras=parametrocarteraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroCarteraConstantesFunciones.refrescarForeignKeysDescripcionesParametroCartera(this.parametrocarteras);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getParametroCarterasFK_IdEmpleado(String sFinalQuery,Pagination pagination,Long id_empleado)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpleado= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpleado.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empleado,ParametroCarteraConstantesFunciones.IDEMPLEADO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpleado);

			ParametroCarteraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpleado","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrocarteras=parametrocarteraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroCarteraConstantesFunciones.refrescarForeignKeysDescripcionesParametroCartera(this.parametrocarteras);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getParametroCarterasFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroCartera.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,ParametroCarteraConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			ParametroCarteraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrocarteras=parametrocarteraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroCarteraConstantesFunciones.refrescarForeignKeysDescripcionesParametroCartera(this.parametrocarteras);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getParametroCarterasFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,ParametroCarteraConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			ParametroCarteraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrocarteras=parametrocarteraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroCarteraConstantesFunciones.refrescarForeignKeysDescripcionesParametroCartera(this.parametrocarteras);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getParametroCarterasFK_IdTipoAutoPagoWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_auto_pago)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroCartera.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoAutoPago= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoAutoPago.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_auto_pago,ParametroCarteraConstantesFunciones.IDTIPOAUTOPAGO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoAutoPago);

			ParametroCarteraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoAutoPago","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrocarteras=parametrocarteraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroCarteraConstantesFunciones.refrescarForeignKeysDescripcionesParametroCartera(this.parametrocarteras);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getParametroCarterasFK_IdTipoAutoPago(String sFinalQuery,Pagination pagination,Long id_tipo_auto_pago)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoAutoPago= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoAutoPago.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_auto_pago,ParametroCarteraConstantesFunciones.IDTIPOAUTOPAGO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoAutoPago);

			ParametroCarteraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoAutoPago","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrocarteras=parametrocarteraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroCarteraConstantesFunciones.refrescarForeignKeysDescripcionesParametroCartera(this.parametrocarteras);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getParametroCarterasFK_IdTipoFacturaWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_factura)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroCartera.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoFactura= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoFactura.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_factura,ParametroCarteraConstantesFunciones.IDTIPOFACTURA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoFactura);

			ParametroCarteraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoFactura","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrocarteras=parametrocarteraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroCarteraConstantesFunciones.refrescarForeignKeysDescripcionesParametroCartera(this.parametrocarteras);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getParametroCarterasFK_IdTipoFactura(String sFinalQuery,Pagination pagination,Long id_tipo_factura)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoFactura= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoFactura.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_factura,ParametroCarteraConstantesFunciones.IDTIPOFACTURA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoFactura);

			ParametroCarteraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoFactura","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrocarteras=parametrocarteraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroCarteraConstantesFunciones.refrescarForeignKeysDescripcionesParametroCartera(this.parametrocarteras);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getParametroCarterasFK_IdTransaccionDeshabilitaWithConnection(String sFinalQuery,Pagination pagination,Long id_transaccion_deshabilita)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroCartera.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTransaccionDeshabilita= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTransaccionDeshabilita.setParameterSelectionGeneralEqual(ParameterType.LONG,id_transaccion_deshabilita,ParametroCarteraConstantesFunciones.IDTRANSACCIONDESHABILITA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTransaccionDeshabilita);

			ParametroCarteraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTransaccionDeshabilita","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrocarteras=parametrocarteraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroCarteraConstantesFunciones.refrescarForeignKeysDescripcionesParametroCartera(this.parametrocarteras);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getParametroCarterasFK_IdTransaccionDeshabilita(String sFinalQuery,Pagination pagination,Long id_transaccion_deshabilita)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTransaccionDeshabilita= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTransaccionDeshabilita.setParameterSelectionGeneralEqual(ParameterType.LONG,id_transaccion_deshabilita,ParametroCarteraConstantesFunciones.IDTRANSACCIONDESHABILITA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTransaccionDeshabilita);

			ParametroCarteraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTransaccionDeshabilita","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrocarteras=parametrocarteraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroCarteraConstantesFunciones.refrescarForeignKeysDescripcionesParametroCartera(this.parametrocarteras);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getParametroCarterasFK_IdTransaccionFacturaWithConnection(String sFinalQuery,Pagination pagination,Long id_transaccion_factura)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroCartera.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTransaccionFactura= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTransaccionFactura.setParameterSelectionGeneralEqual(ParameterType.LONG,id_transaccion_factura,ParametroCarteraConstantesFunciones.IDTRANSACCIONFACTURA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTransaccionFactura);

			ParametroCarteraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTransaccionFactura","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrocarteras=parametrocarteraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroCarteraConstantesFunciones.refrescarForeignKeysDescripcionesParametroCartera(this.parametrocarteras);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getParametroCarterasFK_IdTransaccionFactura(String sFinalQuery,Pagination pagination,Long id_transaccion_factura)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTransaccionFactura= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTransaccionFactura.setParameterSelectionGeneralEqual(ParameterType.LONG,id_transaccion_factura,ParametroCarteraConstantesFunciones.IDTRANSACCIONFACTURA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTransaccionFactura);

			ParametroCarteraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTransaccionFactura","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrocarteras=parametrocarteraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroCarteraConstantesFunciones.refrescarForeignKeysDescripcionesParametroCartera(this.parametrocarteras);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getParametroCarterasFK_IdTransaccionHabilitaWithConnection(String sFinalQuery,Pagination pagination,Long id_transaccion_habilita)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroCartera.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTransaccionHabilita= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTransaccionHabilita.setParameterSelectionGeneralEqual(ParameterType.LONG,id_transaccion_habilita,ParametroCarteraConstantesFunciones.IDTRANSACCIONHABILITA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTransaccionHabilita);

			ParametroCarteraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTransaccionHabilita","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrocarteras=parametrocarteraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroCarteraConstantesFunciones.refrescarForeignKeysDescripcionesParametroCartera(this.parametrocarteras);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getParametroCarterasFK_IdTransaccionHabilita(String sFinalQuery,Pagination pagination,Long id_transaccion_habilita)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTransaccionHabilita= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTransaccionHabilita.setParameterSelectionGeneralEqual(ParameterType.LONG,id_transaccion_habilita,ParametroCarteraConstantesFunciones.IDTRANSACCIONHABILITA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTransaccionHabilita);

			ParametroCarteraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTransaccionHabilita","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrocarteras=parametrocarteraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroCarteraConstantesFunciones.refrescarForeignKeysDescripcionesParametroCartera(this.parametrocarteras);
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
			if(ParametroCarteraConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,ParametroCarteraDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,ParametroCartera parametrocartera,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(ParametroCarteraConstantesFunciones.ISCONAUDITORIA) {
				if(parametrocartera.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,ParametroCarteraDataAccess.TABLENAME, parametrocartera.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(ParametroCarteraConstantesFunciones.ISCONAUDITORIADETALLE) {
						////ParametroCarteraLogic.registrarAuditoriaDetallesParametroCartera(connexion,parametrocartera,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(parametrocartera.getIsDeleted()) {
					/*if(!parametrocartera.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,ParametroCarteraDataAccess.TABLENAME, parametrocartera.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////ParametroCarteraLogic.registrarAuditoriaDetallesParametroCartera(connexion,parametrocartera,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,ParametroCarteraDataAccess.TABLENAME, parametrocartera.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(parametrocartera.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,ParametroCarteraDataAccess.TABLENAME, parametrocartera.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(ParametroCarteraConstantesFunciones.ISCONAUDITORIADETALLE) {
						////ParametroCarteraLogic.registrarAuditoriaDetallesParametroCartera(connexion,parametrocartera,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesParametroCartera(Connexion connexion,ParametroCartera parametrocartera)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(parametrocartera.getIsNew()||!parametrocartera.getid_empresa().equals(parametrocartera.getParametroCarteraOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametrocartera.getParametroCarteraOriginal().getid_empresa()!=null)
				{
					strValorActual=parametrocartera.getParametroCarteraOriginal().getid_empresa().toString();
				}
				if(parametrocartera.getid_empresa()!=null)
				{
					strValorNuevo=parametrocartera.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroCarteraConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(parametrocartera.getIsNew()||!parametrocartera.getid_transaccion_factura().equals(parametrocartera.getParametroCarteraOriginal().getid_transaccion_factura()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametrocartera.getParametroCarteraOriginal().getid_transaccion_factura()!=null)
				{
					strValorActual=parametrocartera.getParametroCarteraOriginal().getid_transaccion_factura().toString();
				}
				if(parametrocartera.getid_transaccion_factura()!=null)
				{
					strValorNuevo=parametrocartera.getid_transaccion_factura().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroCarteraConstantesFunciones.IDTRANSACCIONFACTURA,strValorActual,strValorNuevo);
			}	
			
			if(parametrocartera.getIsNew()||!parametrocartera.getnumero_digitos_factura().equals(parametrocartera.getParametroCarteraOriginal().getnumero_digitos_factura()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametrocartera.getParametroCarteraOriginal().getnumero_digitos_factura()!=null)
				{
					strValorActual=parametrocartera.getParametroCarteraOriginal().getnumero_digitos_factura().toString();
				}
				if(parametrocartera.getnumero_digitos_factura()!=null)
				{
					strValorNuevo=parametrocartera.getnumero_digitos_factura().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroCarteraConstantesFunciones.NUMERODIGITOSFACTURA,strValorActual,strValorNuevo);
			}	
			
			if(parametrocartera.getIsNew()||!parametrocartera.getpor_lotes().equals(parametrocartera.getParametroCarteraOriginal().getpor_lotes()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametrocartera.getParametroCarteraOriginal().getpor_lotes()!=null)
				{
					strValorActual=parametrocartera.getParametroCarteraOriginal().getpor_lotes().toString();
				}
				if(parametrocartera.getpor_lotes()!=null)
				{
					strValorNuevo=parametrocartera.getpor_lotes().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroCarteraConstantesFunciones.PORLOTES,strValorActual,strValorNuevo);
			}	
			
			if(parametrocartera.getIsNew()||!parametrocartera.getid_empleado().equals(parametrocartera.getParametroCarteraOriginal().getid_empleado()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametrocartera.getParametroCarteraOriginal().getid_empleado()!=null)
				{
					strValorActual=parametrocartera.getParametroCarteraOriginal().getid_empleado().toString();
				}
				if(parametrocartera.getid_empleado()!=null)
				{
					strValorNuevo=parametrocartera.getid_empleado().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroCarteraConstantesFunciones.IDEMPLEADO,strValorActual,strValorNuevo);
			}	
			
			if(parametrocartera.getIsNew()||!parametrocartera.getid_transaccion_deshabilita().equals(parametrocartera.getParametroCarteraOriginal().getid_transaccion_deshabilita()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametrocartera.getParametroCarteraOriginal().getid_transaccion_deshabilita()!=null)
				{
					strValorActual=parametrocartera.getParametroCarteraOriginal().getid_transaccion_deshabilita().toString();
				}
				if(parametrocartera.getid_transaccion_deshabilita()!=null)
				{
					strValorNuevo=parametrocartera.getid_transaccion_deshabilita().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroCarteraConstantesFunciones.IDTRANSACCIONDESHABILITA,strValorActual,strValorNuevo);
			}	
			
			if(parametrocartera.getIsNew()||!parametrocartera.getid_transaccion_habilita().equals(parametrocartera.getParametroCarteraOriginal().getid_transaccion_habilita()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametrocartera.getParametroCarteraOriginal().getid_transaccion_habilita()!=null)
				{
					strValorActual=parametrocartera.getParametroCarteraOriginal().getid_transaccion_habilita().toString();
				}
				if(parametrocartera.getid_transaccion_habilita()!=null)
				{
					strValorNuevo=parametrocartera.getid_transaccion_habilita().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroCarteraConstantesFunciones.IDTRANSACCIONHABILITA,strValorActual,strValorNuevo);
			}	
			
			if(parametrocartera.getIsNew()||!parametrocartera.getid_bodega().equals(parametrocartera.getParametroCarteraOriginal().getid_bodega()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametrocartera.getParametroCarteraOriginal().getid_bodega()!=null)
				{
					strValorActual=parametrocartera.getParametroCarteraOriginal().getid_bodega().toString();
				}
				if(parametrocartera.getid_bodega()!=null)
				{
					strValorNuevo=parametrocartera.getid_bodega().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroCarteraConstantesFunciones.IDBODEGA,strValorActual,strValorNuevo);
			}	
			
			if(parametrocartera.getIsNew()||!parametrocartera.getid_tipo_factura().equals(parametrocartera.getParametroCarteraOriginal().getid_tipo_factura()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametrocartera.getParametroCarteraOriginal().getid_tipo_factura()!=null)
				{
					strValorActual=parametrocartera.getParametroCarteraOriginal().getid_tipo_factura().toString();
				}
				if(parametrocartera.getid_tipo_factura()!=null)
				{
					strValorNuevo=parametrocartera.getid_tipo_factura().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroCarteraConstantesFunciones.IDTIPOFACTURA,strValorActual,strValorNuevo);
			}	
			
			if(parametrocartera.getIsNew()||!parametrocartera.getid_tipo_auto_pago().equals(parametrocartera.getParametroCarteraOriginal().getid_tipo_auto_pago()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametrocartera.getParametroCarteraOriginal().getid_tipo_auto_pago()!=null)
				{
					strValorActual=parametrocartera.getParametroCarteraOriginal().getid_tipo_auto_pago().toString();
				}
				if(parametrocartera.getid_tipo_auto_pago()!=null)
				{
					strValorNuevo=parametrocartera.getid_tipo_auto_pago().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroCarteraConstantesFunciones.IDTIPOAUTOPAGO,strValorActual,strValorNuevo);
			}	
			
			if(parametrocartera.getIsNew()||!parametrocartera.getnumero_orden_pago().equals(parametrocartera.getParametroCarteraOriginal().getnumero_orden_pago()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametrocartera.getParametroCarteraOriginal().getnumero_orden_pago()!=null)
				{
					strValorActual=parametrocartera.getParametroCarteraOriginal().getnumero_orden_pago();
				}
				if(parametrocartera.getnumero_orden_pago()!=null)
				{
					strValorNuevo=parametrocartera.getnumero_orden_pago() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroCarteraConstantesFunciones.NUMEROORDENPAGO,strValorActual,strValorNuevo);
			}	
			
			if(parametrocartera.getIsNew()||!parametrocartera.getid_cuenta_contable_credito_fiscal().equals(parametrocartera.getParametroCarteraOriginal().getid_cuenta_contable_credito_fiscal()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametrocartera.getParametroCarteraOriginal().getid_cuenta_contable_credito_fiscal()!=null)
				{
					strValorActual=parametrocartera.getParametroCarteraOriginal().getid_cuenta_contable_credito_fiscal().toString();
				}
				if(parametrocartera.getid_cuenta_contable_credito_fiscal()!=null)
				{
					strValorNuevo=parametrocartera.getid_cuenta_contable_credito_fiscal().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroCarteraConstantesFunciones.IDCUENTACONTABLECREDITOFISCAL,strValorActual,strValorNuevo);
			}	
			
			if(parametrocartera.getIsNew()||!parametrocartera.getdescripcion().equals(parametrocartera.getParametroCarteraOriginal().getdescripcion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametrocartera.getParametroCarteraOriginal().getdescripcion()!=null)
				{
					strValorActual=parametrocartera.getParametroCarteraOriginal().getdescripcion();
				}
				if(parametrocartera.getdescripcion()!=null)
				{
					strValorNuevo=parametrocartera.getdescripcion() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroCarteraConstantesFunciones.DESCRIPCION,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveParametroCarteraRelacionesWithConnection(ParametroCartera parametrocartera) throws Exception {

		if(!parametrocartera.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveParametroCarteraRelacionesBase(parametrocartera,true);
		}
	}

	public void saveParametroCarteraRelaciones(ParametroCartera parametrocartera)throws Exception {

		if(!parametrocartera.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveParametroCarteraRelacionesBase(parametrocartera,false);
		}
	}

	public void saveParametroCarteraRelacionesBase(ParametroCartera parametrocartera,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("ParametroCartera-saveRelacionesWithConnection");}
	

			this.setParametroCartera(parametrocartera);

			if(ParametroCarteraLogicAdditional.validarSaveRelaciones(parametrocartera,this)) {

				ParametroCarteraLogicAdditional.updateRelacionesToSave(parametrocartera,this);

				if((parametrocartera.getIsNew()||parametrocartera.getIsChanged())&&!parametrocartera.getIsDeleted()) {
					this.saveParametroCartera();
					this.saveParametroCarteraRelacionesDetalles();

				} else if(parametrocartera.getIsDeleted()) {
					this.saveParametroCarteraRelacionesDetalles();
					this.saveParametroCartera();
				}

				ParametroCarteraLogicAdditional.updateRelacionesToSaveAfter(parametrocartera,this);

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
	
	
	private void saveParametroCarteraRelacionesDetalles()throws Exception {
		try {
	

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfParametroCartera(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=ParametroCarteraConstantesFunciones.getClassesForeignKeysOfParametroCartera(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfParametroCartera(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=ParametroCarteraConstantesFunciones.getClassesRelationshipsOfParametroCartera(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

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
package com.bydan.erp.tesoreria.business.logic;

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
import com.bydan.erp.tesoreria.util.*;
import com.bydan.erp.tesoreria.util.TablaRetencionConstantesFunciones;
import com.bydan.erp.tesoreria.util.TablaRetencionParameterReturnGeneral;
//import com.bydan.erp.tesoreria.util.TablaRetencionParameterGeneral;
import com.bydan.erp.tesoreria.business.entity.TablaRetencion;
import com.bydan.erp.tesoreria.business.logic.TablaRetencionLogicAdditional;
import com.bydan.erp.tesoreria.business.dataaccess.*;
import com.bydan.erp.tesoreria.business.entity.*;

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
public class TablaRetencionLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(TablaRetencionLogic.class);
	
	protected TablaRetencionDataAccess tablaretencionDataAccess; 	
	protected TablaRetencion tablaretencion;
	protected List<TablaRetencion> tablaretencions;
	protected Object tablaretencionObject;	
	protected List<Object> tablaretencionsObject;
	
	public static ClassValidator<TablaRetencion> tablaretencionValidator = new ClassValidator<TablaRetencion>(TablaRetencion.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected TablaRetencionLogicAdditional tablaretencionLogicAdditional=null;
	
	public TablaRetencionLogicAdditional getTablaRetencionLogicAdditional() {
		return this.tablaretencionLogicAdditional;
	}
	
	public void setTablaRetencionLogicAdditional(TablaRetencionLogicAdditional tablaretencionLogicAdditional) {
		try {
			this.tablaretencionLogicAdditional=tablaretencionLogicAdditional;
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
	
	
	
	
	public  TablaRetencionLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.tablaretencionDataAccess = new TablaRetencionDataAccess();
			
			this.tablaretencions= new ArrayList<TablaRetencion>();
			this.tablaretencion= new TablaRetencion();
			
			this.tablaretencionObject=new Object();
			this.tablaretencionsObject=new ArrayList<Object>();
				
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
			
			this.tablaretencionDataAccess.setConnexionType(this.connexionType);
			this.tablaretencionDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  TablaRetencionLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.tablaretencionDataAccess = new TablaRetencionDataAccess();
			this.tablaretencions= new ArrayList<TablaRetencion>();
			this.tablaretencion= new TablaRetencion();
			this.tablaretencionObject=new Object();
			this.tablaretencionsObject=new ArrayList<Object>();
			
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
			
			this.tablaretencionDataAccess.setConnexionType(this.connexionType);
			this.tablaretencionDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public TablaRetencion getTablaRetencion() throws Exception {	
		TablaRetencionLogicAdditional.checkTablaRetencionToGet(tablaretencion,this.datosCliente,this.arrDatoGeneral);
		TablaRetencionLogicAdditional.updateTablaRetencionToGet(tablaretencion,this.arrDatoGeneral);
		
		return tablaretencion;
	}
		
	public void setTablaRetencion(TablaRetencion newTablaRetencion) {
		this.tablaretencion = newTablaRetencion;
	}
	
	public TablaRetencionDataAccess getTablaRetencionDataAccess() {
		return tablaretencionDataAccess;
	}
	
	public void setTablaRetencionDataAccess(TablaRetencionDataAccess newtablaretencionDataAccess) {
		this.tablaretencionDataAccess = newtablaretencionDataAccess;
	}
	
	public List<TablaRetencion> getTablaRetencions() throws Exception {		
		this.quitarTablaRetencionsNulos();
		
		TablaRetencionLogicAdditional.checkTablaRetencionToGets(tablaretencions,this.datosCliente,this.arrDatoGeneral);
		
		for (TablaRetencion tablaretencionLocal: tablaretencions ) {
			TablaRetencionLogicAdditional.updateTablaRetencionToGet(tablaretencionLocal,this.arrDatoGeneral);
		}
		
		return tablaretencions;
	}
	
	public void setTablaRetencions(List<TablaRetencion> newTablaRetencions) {
		this.tablaretencions = newTablaRetencions;
	}
	
	public Object getTablaRetencionObject() {	
		this.tablaretencionObject=this.tablaretencionDataAccess.getEntityObject();
		return this.tablaretencionObject;
	}
		
	public void setTablaRetencionObject(Object newTablaRetencionObject) {
		this.tablaretencionObject = newTablaRetencionObject;
	}
	
	public List<Object> getTablaRetencionsObject() {		
		this.tablaretencionsObject=this.tablaretencionDataAccess.getEntitiesObject();
		return this.tablaretencionsObject;
	}
		
	public void setTablaRetencionsObject(List<Object> newTablaRetencionsObject) {
		this.tablaretencionsObject = newTablaRetencionsObject;
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
		
		if(this.tablaretencionDataAccess!=null) {
			this.tablaretencionDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TablaRetencion.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			tablaretencionDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			tablaretencionDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		tablaretencion = new  TablaRetencion();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TablaRetencion.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			tablaretencion=tablaretencionDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tablaretencion,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TablaRetencionConstantesFunciones.refrescarForeignKeysDescripcionesTablaRetencion(this.tablaretencion);
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
		tablaretencion = new  TablaRetencion();
		  		  
        try {
			
			tablaretencion=tablaretencionDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tablaretencion,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TablaRetencionConstantesFunciones.refrescarForeignKeysDescripcionesTablaRetencion(this.tablaretencion);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		tablaretencion = new  TablaRetencion();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TablaRetencion.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			tablaretencion=tablaretencionDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tablaretencion,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TablaRetencionConstantesFunciones.refrescarForeignKeysDescripcionesTablaRetencion(this.tablaretencion);
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
		tablaretencion = new  TablaRetencion();
		  		  
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
		tablaretencion = new  TablaRetencion();
		  		  
        try {
			
			tablaretencion=tablaretencionDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tablaretencion,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TablaRetencionConstantesFunciones.refrescarForeignKeysDescripcionesTablaRetencion(this.tablaretencion);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		tablaretencion = new  TablaRetencion();
		  		  
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
		tablaretencion = new  TablaRetencion();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TablaRetencion.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =tablaretencionDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tablaretencion = new  TablaRetencion();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=tablaretencionDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		tablaretencion = new  TablaRetencion();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TablaRetencion.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =tablaretencionDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tablaretencion = new  TablaRetencion();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=tablaretencionDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		tablaretencion = new  TablaRetencion();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TablaRetencion.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =tablaretencionDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tablaretencion = new  TablaRetencion();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=tablaretencionDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		tablaretencions = new  ArrayList<TablaRetencion>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TablaRetencion.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			TablaRetencionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tablaretencions=tablaretencionDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTablaRetencion(tablaretencions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TablaRetencionConstantesFunciones.refrescarForeignKeysDescripcionesTablaRetencion(this.tablaretencions);
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
		tablaretencions = new  ArrayList<TablaRetencion>();
		  		  
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
		tablaretencions = new  ArrayList<TablaRetencion>();
		  		  
        try {			
			TablaRetencionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tablaretencions=tablaretencionDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarTablaRetencion(tablaretencions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TablaRetencionConstantesFunciones.refrescarForeignKeysDescripcionesTablaRetencion(this.tablaretencions);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		tablaretencions = new  ArrayList<TablaRetencion>();
		  		  
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
		tablaretencions = new  ArrayList<TablaRetencion>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TablaRetencion.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			TablaRetencionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tablaretencions=tablaretencionDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTablaRetencion(tablaretencions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TablaRetencionConstantesFunciones.refrescarForeignKeysDescripcionesTablaRetencion(this.tablaretencions);
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
		tablaretencions = new  ArrayList<TablaRetencion>();
		  		  
        try {
			TablaRetencionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tablaretencions=tablaretencionDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTablaRetencion(tablaretencions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TablaRetencionConstantesFunciones.refrescarForeignKeysDescripcionesTablaRetencion(this.tablaretencions);
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
		tablaretencions = new  ArrayList<TablaRetencion>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TablaRetencion.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TablaRetencionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tablaretencions=tablaretencionDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTablaRetencion(tablaretencions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TablaRetencionConstantesFunciones.refrescarForeignKeysDescripcionesTablaRetencion(this.tablaretencions);
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
		tablaretencions = new  ArrayList<TablaRetencion>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TablaRetencionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tablaretencions=tablaretencionDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTablaRetencion(tablaretencions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TablaRetencionConstantesFunciones.refrescarForeignKeysDescripcionesTablaRetencion(this.tablaretencions);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		tablaretencion = new  TablaRetencion();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TablaRetencion.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TablaRetencionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tablaretencion=tablaretencionDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTablaRetencion(tablaretencion);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TablaRetencionConstantesFunciones.refrescarForeignKeysDescripcionesTablaRetencion(this.tablaretencion);
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
		tablaretencion = new  TablaRetencion();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TablaRetencionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tablaretencion=tablaretencionDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTablaRetencion(tablaretencion);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TablaRetencionConstantesFunciones.refrescarForeignKeysDescripcionesTablaRetencion(this.tablaretencion);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		tablaretencions = new  ArrayList<TablaRetencion>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TablaRetencion.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			TablaRetencionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tablaretencions=tablaretencionDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTablaRetencion(tablaretencions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TablaRetencionConstantesFunciones.refrescarForeignKeysDescripcionesTablaRetencion(this.tablaretencions);
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
		tablaretencions = new  ArrayList<TablaRetencion>();
		  		  
        try {
			TablaRetencionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tablaretencions=tablaretencionDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTablaRetencion(tablaretencions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TablaRetencionConstantesFunciones.refrescarForeignKeysDescripcionesTablaRetencion(this.tablaretencions);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosTablaRetencionsWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		tablaretencions = new  ArrayList<TablaRetencion>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TablaRetencion.class.getSimpleName()+"-getTodosTablaRetencionsWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TablaRetencionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tablaretencions=tablaretencionDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarTablaRetencion(tablaretencions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TablaRetencionConstantesFunciones.refrescarForeignKeysDescripcionesTablaRetencion(this.tablaretencions);
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
	
	public  void  getTodosTablaRetencions(String sFinalQuery,Pagination pagination)throws Exception {
		tablaretencions = new  ArrayList<TablaRetencion>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TablaRetencionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tablaretencions=tablaretencionDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarTablaRetencion(tablaretencions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TablaRetencionConstantesFunciones.refrescarForeignKeysDescripcionesTablaRetencion(this.tablaretencions);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarTablaRetencion(TablaRetencion tablaretencion) throws Exception {
		Boolean estaValidado=false;
		
		if(tablaretencion.getIsNew() || tablaretencion.getIsChanged()) { 
			this.invalidValues = tablaretencionValidator.getInvalidValues(tablaretencion);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(tablaretencion);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarTablaRetencion(List<TablaRetencion> TablaRetencions) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(TablaRetencion tablaretencionLocal:tablaretencions) {				
			estaValidadoObjeto=this.validarGuardarTablaRetencion(tablaretencionLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarTablaRetencion(List<TablaRetencion> TablaRetencions) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarTablaRetencion(tablaretencions)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarTablaRetencion(TablaRetencion TablaRetencion) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarTablaRetencion(tablaretencion)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(TablaRetencion tablaretencion) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+tablaretencion.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=TablaRetencionConstantesFunciones.getTablaRetencionLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"tablaretencion","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(TablaRetencionConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(TablaRetencionConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveTablaRetencionWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TablaRetencion.class.getSimpleName()+"-saveTablaRetencionWithConnection");connexion.begin();			
			
			TablaRetencionLogicAdditional.checkTablaRetencionToSave(this.tablaretencion,this.datosCliente,connexion,this.arrDatoGeneral);
			
			TablaRetencionLogicAdditional.updateTablaRetencionToSave(this.tablaretencion,this.arrDatoGeneral);
			
			TablaRetencionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.tablaretencion,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowTablaRetencion();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarTablaRetencion(this.tablaretencion)) {
				TablaRetencionDataAccess.save(this.tablaretencion, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.tablaretencion,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			TablaRetencionLogicAdditional.checkTablaRetencionToSaveAfter(this.tablaretencion,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowTablaRetencion();
			
			connexion.commit();			
			
			if(this.tablaretencion.getIsDeleted()) {
				this.tablaretencion=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveTablaRetencion()throws Exception {	
		try {	
			
			TablaRetencionLogicAdditional.checkTablaRetencionToSave(this.tablaretencion,this.datosCliente,connexion,this.arrDatoGeneral);
			
			TablaRetencionLogicAdditional.updateTablaRetencionToSave(this.tablaretencion,this.arrDatoGeneral);
			
			TablaRetencionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.tablaretencion,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarTablaRetencion(this.tablaretencion)) {			
				TablaRetencionDataAccess.save(this.tablaretencion, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.tablaretencion,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			TablaRetencionLogicAdditional.checkTablaRetencionToSaveAfter(this.tablaretencion,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.tablaretencion.getIsDeleted()) {
				this.tablaretencion=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveTablaRetencionsWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TablaRetencion.class.getSimpleName()+"-saveTablaRetencionsWithConnection");connexion.begin();			
			
			TablaRetencionLogicAdditional.checkTablaRetencionToSaves(tablaretencions,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowTablaRetencions();
			
			Boolean validadoTodosTablaRetencion=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(TablaRetencion tablaretencionLocal:tablaretencions) {		
				if(tablaretencionLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				TablaRetencionLogicAdditional.updateTablaRetencionToSave(tablaretencionLocal,this.arrDatoGeneral);
	        	
				TablaRetencionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),tablaretencionLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarTablaRetencion(tablaretencionLocal)) {
					TablaRetencionDataAccess.save(tablaretencionLocal, connexion);				
				} else {
					validadoTodosTablaRetencion=false;
				}
			}
			
			if(!validadoTodosTablaRetencion) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			TablaRetencionLogicAdditional.checkTablaRetencionToSavesAfter(tablaretencions,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowTablaRetencions();
			
			connexion.commit();		
			
			this.quitarTablaRetencionsEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveTablaRetencions()throws Exception {				
		 try {	
			TablaRetencionLogicAdditional.checkTablaRetencionToSaves(tablaretencions,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosTablaRetencion=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(TablaRetencion tablaretencionLocal:tablaretencions) {				
				if(tablaretencionLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				TablaRetencionLogicAdditional.updateTablaRetencionToSave(tablaretencionLocal,this.arrDatoGeneral);
	        	
				TablaRetencionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),tablaretencionLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarTablaRetencion(tablaretencionLocal)) {				
					TablaRetencionDataAccess.save(tablaretencionLocal, connexion);				
				} else {
					validadoTodosTablaRetencion=false;
				}
			}
			
			if(!validadoTodosTablaRetencion) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			TablaRetencionLogicAdditional.checkTablaRetencionToSavesAfter(tablaretencions,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarTablaRetencionsEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public TablaRetencionParameterReturnGeneral procesarAccionTablaRetencions(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<TablaRetencion> tablaretencions,TablaRetencionParameterReturnGeneral tablaretencionParameterGeneral)throws Exception {
		 try {	
			TablaRetencionParameterReturnGeneral tablaretencionReturnGeneral=new TablaRetencionParameterReturnGeneral();
	
			TablaRetencionLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,tablaretencions,tablaretencionParameterGeneral,tablaretencionReturnGeneral);
			
			return tablaretencionReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public TablaRetencionParameterReturnGeneral procesarAccionTablaRetencionsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<TablaRetencion> tablaretencions,TablaRetencionParameterReturnGeneral tablaretencionParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TablaRetencion.class.getSimpleName()+"-procesarAccionTablaRetencionsWithConnection");connexion.begin();			
			
			TablaRetencionParameterReturnGeneral tablaretencionReturnGeneral=new TablaRetencionParameterReturnGeneral();
	
			TablaRetencionLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,tablaretencions,tablaretencionParameterGeneral,tablaretencionReturnGeneral);
			
			this.connexion.commit();
			
			return tablaretencionReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public TablaRetencionParameterReturnGeneral procesarEventosTablaRetencions(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<TablaRetencion> tablaretencions,TablaRetencion tablaretencion,TablaRetencionParameterReturnGeneral tablaretencionParameterGeneral,Boolean isEsNuevoTablaRetencion,ArrayList<Classe> clases)throws Exception {
		 try {	
			TablaRetencionParameterReturnGeneral tablaretencionReturnGeneral=new TablaRetencionParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				tablaretencionReturnGeneral.setConRecargarPropiedades(true);
			}
			
			TablaRetencionLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,tablaretencions,tablaretencion,tablaretencionParameterGeneral,tablaretencionReturnGeneral,isEsNuevoTablaRetencion,clases);
			
			return tablaretencionReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public TablaRetencionParameterReturnGeneral procesarEventosTablaRetencionsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<TablaRetencion> tablaretencions,TablaRetencion tablaretencion,TablaRetencionParameterReturnGeneral tablaretencionParameterGeneral,Boolean isEsNuevoTablaRetencion,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TablaRetencion.class.getSimpleName()+"-procesarEventosTablaRetencionsWithConnection");connexion.begin();			
			
			TablaRetencionParameterReturnGeneral tablaretencionReturnGeneral=new TablaRetencionParameterReturnGeneral();
	
			tablaretencionReturnGeneral.setTablaRetencion(tablaretencion);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				tablaretencionReturnGeneral.setConRecargarPropiedades(true);
			}
			
			TablaRetencionLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,tablaretencions,tablaretencion,tablaretencionParameterGeneral,tablaretencionReturnGeneral,isEsNuevoTablaRetencion,clases);
			
			this.connexion.commit();
			
			return tablaretencionReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public TablaRetencionParameterReturnGeneral procesarImportacionTablaRetencionsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,TablaRetencionParameterReturnGeneral tablaretencionParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TablaRetencion.class.getSimpleName()+"-procesarImportacionTablaRetencionsWithConnection");connexion.begin();			
			
			TablaRetencionParameterReturnGeneral tablaretencionReturnGeneral=new TablaRetencionParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.tablaretencions=new ArrayList<TablaRetencion>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.tablaretencion=new TablaRetencion();
				
				
				if(conColumnasBase) {this.tablaretencion.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.tablaretencion.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.tablaretencion.setcodigo(arrColumnas[iColumn++]);
				this.tablaretencion.setnombre(arrColumnas[iColumn++]);
				this.tablaretencion.setporcentaje(Double.parseDouble(arrColumnas[iColumn++]));
				this.tablaretencion.setmonto_minimo(Double.parseDouble(arrColumnas[iColumn++]));
				this.tablaretencion.setes_debito(Boolean.parseBoolean(arrColumnas[iColumn++]));
				this.tablaretencion.setes_retencion_fuente(Boolean.parseBoolean(arrColumnas[iColumn++]));
				this.tablaretencion.setcon_secuencial(Boolean.parseBoolean(arrColumnas[iColumn++]));
				this.tablaretencion.setcon_sub_total_factura(Boolean.parseBoolean(arrColumnas[iColumn++]));
				this.tablaretencion.setcon_iva_factura(Boolean.parseBoolean(arrColumnas[iColumn++]));
				
				this.tablaretencions.add(this.tablaretencion);
			}
			
			this.saveTablaRetencions();
			
			this.connexion.commit();
			
			tablaretencionReturnGeneral.setConRetornoEstaProcesado(true);
			tablaretencionReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return tablaretencionReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarTablaRetencionsEliminados() throws Exception {				
		
		List<TablaRetencion> tablaretencionsAux= new ArrayList<TablaRetencion>();
		
		for(TablaRetencion tablaretencion:tablaretencions) {
			if(!tablaretencion.getIsDeleted()) {
				tablaretencionsAux.add(tablaretencion);
			}
		}
		
		tablaretencions=tablaretencionsAux;
	}
	
	public void quitarTablaRetencionsNulos() throws Exception {				
		
		List<TablaRetencion> tablaretencionsAux= new ArrayList<TablaRetencion>();
		
		for(TablaRetencion tablaretencion : this.tablaretencions) {
			if(tablaretencion==null) {
				tablaretencionsAux.add(tablaretencion);
			}
		}
		
		//this.tablaretencions=tablaretencionsAux;
		
		this.tablaretencions.removeAll(tablaretencionsAux);
	}
	
	public void getSetVersionRowTablaRetencionWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(tablaretencion.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((tablaretencion.getIsDeleted() || (tablaretencion.getIsChanged()&&!tablaretencion.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=tablaretencionDataAccess.getSetVersionRowTablaRetencion(connexion,tablaretencion.getId());
				
				if(!tablaretencion.getVersionRow().equals(timestamp)) {	
					tablaretencion.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				tablaretencion.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowTablaRetencion()throws Exception {	
		
		if(tablaretencion.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((tablaretencion.getIsDeleted() || (tablaretencion.getIsChanged()&&!tablaretencion.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=tablaretencionDataAccess.getSetVersionRowTablaRetencion(connexion,tablaretencion.getId());
			
			try {							
				if(!tablaretencion.getVersionRow().equals(timestamp)) {	
					tablaretencion.setVersionRow(timestamp);
				}
				
				tablaretencion.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowTablaRetencionsWithConnection()throws Exception {	
		if(tablaretencions!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(TablaRetencion tablaretencionAux:tablaretencions) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(tablaretencionAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(tablaretencionAux.getIsDeleted() || (tablaretencionAux.getIsChanged()&&!tablaretencionAux.getIsNew())) {
						
						timestamp=tablaretencionDataAccess.getSetVersionRowTablaRetencion(connexion,tablaretencionAux.getId());
						
						if(!tablaretencion.getVersionRow().equals(timestamp)) {	
							tablaretencionAux.setVersionRow(timestamp);
						}
								
						tablaretencionAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowTablaRetencions()throws Exception {	
		if(tablaretencions!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(TablaRetencion tablaretencionAux:tablaretencions) {
					if(tablaretencionAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(tablaretencionAux.getIsDeleted() || (tablaretencionAux.getIsChanged()&&!tablaretencionAux.getIsNew())) {
						
						timestamp=tablaretencionDataAccess.getSetVersionRowTablaRetencion(connexion,tablaretencionAux.getId());
						
						if(!tablaretencionAux.getVersionRow().equals(timestamp)) {	
							tablaretencionAux.setVersionRow(timestamp);
						}
						
													
						tablaretencionAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public TablaRetencionParameterReturnGeneral cargarCombosLoteForeignKeyTablaRetencionWithConnection(String finalQueryGlobalEmpresa,String finalQueryGlobalTipoRetencion,String finalQueryGlobalCuentaContableDebito,String finalQueryGlobalCuentaContableCredito) throws Exception {
		TablaRetencionParameterReturnGeneral  tablaretencionReturnGeneral =new TablaRetencionParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TablaRetencion.class.getSimpleName()+"-cargarCombosLoteForeignKeyTablaRetencionWithConnection");connexion.begin();
			
			tablaretencionReturnGeneral =new TablaRetencionParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			tablaretencionReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<TipoRetencion> tiporetencionsForeignKey=new ArrayList<TipoRetencion>();
			TipoRetencionLogic tiporetencionLogic=new TipoRetencionLogic();
			tiporetencionLogic.setConnexion(this.connexion);
			tiporetencionLogic.getTipoRetencionDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoRetencion.equals("NONE")) {
				tiporetencionLogic.getTodosTipoRetencions(finalQueryGlobalTipoRetencion,new Pagination());
				tiporetencionsForeignKey=tiporetencionLogic.getTipoRetencions();
			}

			tablaretencionReturnGeneral.settiporetencionsForeignKey(tiporetencionsForeignKey);


			List<CuentaContable> cuentacontabledebitosForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontabledebitoLogic=new CuentaContableLogic();
			cuentacontabledebitoLogic.setConnexion(this.connexion);
			cuentacontabledebitoLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContableDebito.equals("NONE")) {
				cuentacontabledebitoLogic.getTodosCuentaContables(finalQueryGlobalCuentaContableDebito,new Pagination());
				cuentacontabledebitosForeignKey=cuentacontabledebitoLogic.getCuentaContables();
			}

			tablaretencionReturnGeneral.setcuentacontabledebitosForeignKey(cuentacontabledebitosForeignKey);


			List<CuentaContable> cuentacontablecreditosForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontablecreditoLogic=new CuentaContableLogic();
			cuentacontablecreditoLogic.setConnexion(this.connexion);
			cuentacontablecreditoLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContableCredito.equals("NONE")) {
				cuentacontablecreditoLogic.getTodosCuentaContables(finalQueryGlobalCuentaContableCredito,new Pagination());
				cuentacontablecreditosForeignKey=cuentacontablecreditoLogic.getCuentaContables();
			}

			tablaretencionReturnGeneral.setcuentacontablecreditosForeignKey(cuentacontablecreditosForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return tablaretencionReturnGeneral;
	}
	
	public TablaRetencionParameterReturnGeneral cargarCombosLoteForeignKeyTablaRetencion(String finalQueryGlobalEmpresa,String finalQueryGlobalTipoRetencion,String finalQueryGlobalCuentaContableDebito,String finalQueryGlobalCuentaContableCredito) throws Exception {
		TablaRetencionParameterReturnGeneral  tablaretencionReturnGeneral =new TablaRetencionParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			tablaretencionReturnGeneral =new TablaRetencionParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			tablaretencionReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<TipoRetencion> tiporetencionsForeignKey=new ArrayList<TipoRetencion>();
			TipoRetencionLogic tiporetencionLogic=new TipoRetencionLogic();
			tiporetencionLogic.setConnexion(this.connexion);
			tiporetencionLogic.getTipoRetencionDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoRetencion.equals("NONE")) {
				tiporetencionLogic.getTodosTipoRetencions(finalQueryGlobalTipoRetencion,new Pagination());
				tiporetencionsForeignKey=tiporetencionLogic.getTipoRetencions();
			}

			tablaretencionReturnGeneral.settiporetencionsForeignKey(tiporetencionsForeignKey);


			List<CuentaContable> cuentacontabledebitosForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontabledebitoLogic=new CuentaContableLogic();
			cuentacontabledebitoLogic.setConnexion(this.connexion);
			cuentacontabledebitoLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContableDebito.equals("NONE")) {
				cuentacontabledebitoLogic.getTodosCuentaContables(finalQueryGlobalCuentaContableDebito,new Pagination());
				cuentacontabledebitosForeignKey=cuentacontabledebitoLogic.getCuentaContables();
			}

			tablaretencionReturnGeneral.setcuentacontabledebitosForeignKey(cuentacontabledebitosForeignKey);


			List<CuentaContable> cuentacontablecreditosForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontablecreditoLogic=new CuentaContableLogic();
			cuentacontablecreditoLogic.setConnexion(this.connexion);
			cuentacontablecreditoLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContableCredito.equals("NONE")) {
				cuentacontablecreditoLogic.getTodosCuentaContables(finalQueryGlobalCuentaContableCredito,new Pagination());
				cuentacontablecreditosForeignKey=cuentacontablecreditoLogic.getCuentaContables();
			}

			tablaretencionReturnGeneral.setcuentacontablecreditosForeignKey(cuentacontablecreditosForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return tablaretencionReturnGeneral;
	}
	
	
	public void deepLoad(TablaRetencion tablaretencion,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			TablaRetencionLogicAdditional.updateTablaRetencionToGet(tablaretencion,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		tablaretencion.setEmpresa(tablaretencionDataAccess.getEmpresa(connexion,tablaretencion));
		tablaretencion.setTipoRetencion(tablaretencionDataAccess.getTipoRetencion(connexion,tablaretencion));
		tablaretencion.setCuentaContableDebito(tablaretencionDataAccess.getCuentaContableDebito(connexion,tablaretencion));
		tablaretencion.setCuentaContableCredito(tablaretencionDataAccess.getCuentaContableCredito(connexion,tablaretencion));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				tablaretencion.setEmpresa(tablaretencionDataAccess.getEmpresa(connexion,tablaretencion));
				continue;
			}

			if(clas.clas.equals(TipoRetencion.class)) {
				tablaretencion.setTipoRetencion(tablaretencionDataAccess.getTipoRetencion(connexion,tablaretencion));
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				tablaretencion.setCuentaContableDebito(tablaretencionDataAccess.getCuentaContableDebito(connexion,tablaretencion));
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				tablaretencion.setCuentaContableCredito(tablaretencionDataAccess.getCuentaContableCredito(connexion,tablaretencion));
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
			tablaretencion.setEmpresa(tablaretencionDataAccess.getEmpresa(connexion,tablaretencion));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoRetencion.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			tablaretencion.setTipoRetencion(tablaretencionDataAccess.getTipoRetencion(connexion,tablaretencion));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			tablaretencion.setCuentaContableDebito(tablaretencionDataAccess.getCuentaContableDebito(connexion,tablaretencion));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			tablaretencion.setCuentaContableCredito(tablaretencionDataAccess.getCuentaContableCredito(connexion,tablaretencion));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		tablaretencion.setEmpresa(tablaretencionDataAccess.getEmpresa(connexion,tablaretencion));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(tablaretencion.getEmpresa(),isDeep,deepLoadType,clases);
				
		tablaretencion.setTipoRetencion(tablaretencionDataAccess.getTipoRetencion(connexion,tablaretencion));
		TipoRetencionLogic tiporetencionLogic= new TipoRetencionLogic(connexion);
		tiporetencionLogic.deepLoad(tablaretencion.getTipoRetencion(),isDeep,deepLoadType,clases);
				
		tablaretencion.setCuentaContableDebito(tablaretencionDataAccess.getCuentaContableDebito(connexion,tablaretencion));
		CuentaContableLogic cuentacontabledebitoLogic= new CuentaContableLogic(connexion);
		cuentacontabledebitoLogic.deepLoad(tablaretencion.getCuentaContableDebito(),isDeep,deepLoadType,clases);
				
		tablaretencion.setCuentaContableCredito(tablaretencionDataAccess.getCuentaContableCredito(connexion,tablaretencion));
		CuentaContableLogic cuentacontablecreditoLogic= new CuentaContableLogic(connexion);
		cuentacontablecreditoLogic.deepLoad(tablaretencion.getCuentaContableCredito(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				tablaretencion.setEmpresa(tablaretencionDataAccess.getEmpresa(connexion,tablaretencion));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(tablaretencion.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoRetencion.class)) {
				tablaretencion.setTipoRetencion(tablaretencionDataAccess.getTipoRetencion(connexion,tablaretencion));
				TipoRetencionLogic tiporetencionLogic= new TipoRetencionLogic(connexion);
				tiporetencionLogic.deepLoad(tablaretencion.getTipoRetencion(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				tablaretencion.setCuentaContableDebito(tablaretencionDataAccess.getCuentaContableDebito(connexion,tablaretencion));
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepLoad(tablaretencion.getCuentaContableDebito(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				tablaretencion.setCuentaContableCredito(tablaretencionDataAccess.getCuentaContableCredito(connexion,tablaretencion));
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepLoad(tablaretencion.getCuentaContableCredito(),isDeep,deepLoadType,clases);				
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
			tablaretencion.setEmpresa(tablaretencionDataAccess.getEmpresa(connexion,tablaretencion));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(tablaretencion.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoRetencion.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			tablaretencion.setTipoRetencion(tablaretencionDataAccess.getTipoRetencion(connexion,tablaretencion));
			TipoRetencionLogic tiporetencionLogic= new TipoRetencionLogic(connexion);
			tiporetencionLogic.deepLoad(tablaretencion.getTipoRetencion(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			tablaretencion.setCuentaContableDebito(tablaretencionDataAccess.getCuentaContableDebito(connexion,tablaretencion));
			CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
			cuentacontableLogic.deepLoad(tablaretencion.getCuentaContableDebito(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			tablaretencion.setCuentaContableCredito(tablaretencionDataAccess.getCuentaContableCredito(connexion,tablaretencion));
			CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
			cuentacontableLogic.deepLoad(tablaretencion.getCuentaContableCredito(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(TablaRetencion tablaretencion,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			TablaRetencionLogicAdditional.updateTablaRetencionToSave(tablaretencion,this.arrDatoGeneral);
			
TablaRetencionDataAccess.save(tablaretencion, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(tablaretencion.getEmpresa(),connexion);

		TipoRetencionDataAccess.save(tablaretencion.getTipoRetencion(),connexion);

		CuentaContableDataAccess.save(tablaretencion.getCuentaContableDebito(),connexion);

		CuentaContableDataAccess.save(tablaretencion.getCuentaContableCredito(),connexion);
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(tablaretencion.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoRetencion.class)) {
				TipoRetencionDataAccess.save(tablaretencion.getTipoRetencion(),connexion);
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(tablaretencion.getCuentaContableDebito(),connexion);
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(tablaretencion.getCuentaContableCredito(),connexion);
				continue;
			}

		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(tablaretencion.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(tablaretencion.getEmpresa(),isDeep,deepLoadType,clases);
				

		TipoRetencionDataAccess.save(tablaretencion.getTipoRetencion(),connexion);
		TipoRetencionLogic tiporetencionLogic= new TipoRetencionLogic(connexion);
		tiporetencionLogic.deepLoad(tablaretencion.getTipoRetencion(),isDeep,deepLoadType,clases);
				

		CuentaContableDataAccess.save(tablaretencion.getCuentaContableDebito(),connexion);
		CuentaContableLogic cuentacontabledebitoLogic= new CuentaContableLogic(connexion);
		cuentacontabledebitoLogic.deepLoad(tablaretencion.getCuentaContableDebito(),isDeep,deepLoadType,clases);
				

		CuentaContableDataAccess.save(tablaretencion.getCuentaContableCredito(),connexion);
		CuentaContableLogic cuentacontablecreditoLogic= new CuentaContableLogic(connexion);
		cuentacontablecreditoLogic.deepLoad(tablaretencion.getCuentaContableCredito(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(tablaretencion.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(tablaretencion.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoRetencion.class)) {
				TipoRetencionDataAccess.save(tablaretencion.getTipoRetencion(),connexion);
				TipoRetencionLogic tiporetencionLogic= new TipoRetencionLogic(connexion);
				tiporetencionLogic.deepSave(tablaretencion.getTipoRetencion(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(tablaretencion.getCuentaContableDebito(),connexion);
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepSave(tablaretencion.getCuentaContableDebito(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(tablaretencion.getCuentaContableCredito(),connexion);
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepSave(tablaretencion.getCuentaContableCredito(),isDeep,deepLoadType,clases);				
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
			this.getNewConnexionToDeep(TablaRetencion.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(tablaretencion,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				TablaRetencionConstantesFunciones.refrescarForeignKeysDescripcionesTablaRetencion(tablaretencion);
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
			this.deepLoad(this.tablaretencion,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				TablaRetencionConstantesFunciones.refrescarForeignKeysDescripcionesTablaRetencion(this.tablaretencion);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(TablaRetencion.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(tablaretencions!=null) {
				for(TablaRetencion tablaretencion:tablaretencions) {
					this.deepLoad(tablaretencion,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					TablaRetencionConstantesFunciones.refrescarForeignKeysDescripcionesTablaRetencion(tablaretencions);
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
			if(tablaretencions!=null) {
				for(TablaRetencion tablaretencion:tablaretencions) {
					this.deepLoad(tablaretencion,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					TablaRetencionConstantesFunciones.refrescarForeignKeysDescripcionesTablaRetencion(tablaretencions);
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
			this.getNewConnexionToDeep(TablaRetencion.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(tablaretencion,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(TablaRetencion.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(tablaretencions!=null) {
				for(TablaRetencion tablaretencion:tablaretencions) {
					this.deepSave(tablaretencion,isDeep,deepLoadType,clases);
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
			if(tablaretencions!=null) {
				for(TablaRetencion tablaretencion:tablaretencions) {
					this.deepSave(tablaretencion,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getTablaRetencionsBusquedaPorCodigoWithConnection(String sFinalQuery,Pagination pagination,String codigo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TablaRetencion.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralCodigo= new ParameterSelectionGeneral();
			parameterSelectionGeneralCodigo.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+codigo+"%",TablaRetencionConstantesFunciones.CODIGO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralCodigo);

			TablaRetencionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorCodigo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tablaretencions=tablaretencionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TablaRetencionConstantesFunciones.refrescarForeignKeysDescripcionesTablaRetencion(this.tablaretencions);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTablaRetencionsBusquedaPorCodigo(String sFinalQuery,Pagination pagination,String codigo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralCodigo= new ParameterSelectionGeneral();
			parameterSelectionGeneralCodigo.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+codigo+"%",TablaRetencionConstantesFunciones.CODIGO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralCodigo);

			TablaRetencionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorCodigo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tablaretencions=tablaretencionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TablaRetencionConstantesFunciones.refrescarForeignKeysDescripcionesTablaRetencion(this.tablaretencions);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getTablaRetencionsBusquedaPorNombreWithConnection(String sFinalQuery,Pagination pagination,String nombre)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TablaRetencion.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralNombre= new ParameterSelectionGeneral();
			parameterSelectionGeneralNombre.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+nombre+"%",TablaRetencionConstantesFunciones.NOMBRE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNombre);

			TablaRetencionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorNombre","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tablaretencions=tablaretencionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TablaRetencionConstantesFunciones.refrescarForeignKeysDescripcionesTablaRetencion(this.tablaretencions);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTablaRetencionsBusquedaPorNombre(String sFinalQuery,Pagination pagination,String nombre)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralNombre= new ParameterSelectionGeneral();
			parameterSelectionGeneralNombre.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+nombre+"%",TablaRetencionConstantesFunciones.NOMBRE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNombre);

			TablaRetencionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorNombre","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tablaretencions=tablaretencionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TablaRetencionConstantesFunciones.refrescarForeignKeysDescripcionesTablaRetencion(this.tablaretencions);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getTablaRetencionsFK_IdCuentaContableCreditoWithConnection(String sFinalQuery,Pagination pagination,Long id_cuenta_contable_credito)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TablaRetencion.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContableCredito= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContableCredito.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable_credito,TablaRetencionConstantesFunciones.IDCUENTACONTABLECREDITO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContableCredito);

			TablaRetencionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContableCredito","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tablaretencions=tablaretencionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TablaRetencionConstantesFunciones.refrescarForeignKeysDescripcionesTablaRetencion(this.tablaretencions);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTablaRetencionsFK_IdCuentaContableCredito(String sFinalQuery,Pagination pagination,Long id_cuenta_contable_credito)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContableCredito= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContableCredito.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable_credito,TablaRetencionConstantesFunciones.IDCUENTACONTABLECREDITO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContableCredito);

			TablaRetencionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContableCredito","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tablaretencions=tablaretencionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TablaRetencionConstantesFunciones.refrescarForeignKeysDescripcionesTablaRetencion(this.tablaretencions);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getTablaRetencionsFK_IdCuentaContableDebitoWithConnection(String sFinalQuery,Pagination pagination,Long id_cuenta_contable_debito)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TablaRetencion.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContableDebito= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContableDebito.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable_debito,TablaRetencionConstantesFunciones.IDCUENTACONTABLEDEBITO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContableDebito);

			TablaRetencionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContableDebito","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tablaretencions=tablaretencionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TablaRetencionConstantesFunciones.refrescarForeignKeysDescripcionesTablaRetencion(this.tablaretencions);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTablaRetencionsFK_IdCuentaContableDebito(String sFinalQuery,Pagination pagination,Long id_cuenta_contable_debito)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContableDebito= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContableDebito.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable_debito,TablaRetencionConstantesFunciones.IDCUENTACONTABLEDEBITO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContableDebito);

			TablaRetencionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContableDebito","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tablaretencions=tablaretencionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TablaRetencionConstantesFunciones.refrescarForeignKeysDescripcionesTablaRetencion(this.tablaretencions);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getTablaRetencionsFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TablaRetencion.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,TablaRetencionConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			TablaRetencionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tablaretencions=tablaretencionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TablaRetencionConstantesFunciones.refrescarForeignKeysDescripcionesTablaRetencion(this.tablaretencions);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTablaRetencionsFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,TablaRetencionConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			TablaRetencionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tablaretencions=tablaretencionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TablaRetencionConstantesFunciones.refrescarForeignKeysDescripcionesTablaRetencion(this.tablaretencions);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getTablaRetencionsFK_IdTipoRetencionWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_retencion)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TablaRetencion.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoRetencion= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoRetencion.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_retencion,TablaRetencionConstantesFunciones.IDTIPORETENCION,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoRetencion);

			TablaRetencionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoRetencion","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tablaretencions=tablaretencionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TablaRetencionConstantesFunciones.refrescarForeignKeysDescripcionesTablaRetencion(this.tablaretencions);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTablaRetencionsFK_IdTipoRetencion(String sFinalQuery,Pagination pagination,Long id_tipo_retencion)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoRetencion= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoRetencion.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_retencion,TablaRetencionConstantesFunciones.IDTIPORETENCION,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoRetencion);

			TablaRetencionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoRetencion","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tablaretencions=tablaretencionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TablaRetencionConstantesFunciones.refrescarForeignKeysDescripcionesTablaRetencion(this.tablaretencions);
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
			if(TablaRetencionConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,TablaRetencionDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,TablaRetencion tablaretencion,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(TablaRetencionConstantesFunciones.ISCONAUDITORIA) {
				if(tablaretencion.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TablaRetencionDataAccess.TABLENAME, tablaretencion.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(TablaRetencionConstantesFunciones.ISCONAUDITORIADETALLE) {
						////TablaRetencionLogic.registrarAuditoriaDetallesTablaRetencion(connexion,tablaretencion,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(tablaretencion.getIsDeleted()) {
					/*if(!tablaretencion.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,TablaRetencionDataAccess.TABLENAME, tablaretencion.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////TablaRetencionLogic.registrarAuditoriaDetallesTablaRetencion(connexion,tablaretencion,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TablaRetencionDataAccess.TABLENAME, tablaretencion.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(tablaretencion.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TablaRetencionDataAccess.TABLENAME, tablaretencion.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(TablaRetencionConstantesFunciones.ISCONAUDITORIADETALLE) {
						////TablaRetencionLogic.registrarAuditoriaDetallesTablaRetencion(connexion,tablaretencion,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesTablaRetencion(Connexion connexion,TablaRetencion tablaretencion)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(tablaretencion.getIsNew()||!tablaretencion.getid_empresa().equals(tablaretencion.getTablaRetencionOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tablaretencion.getTablaRetencionOriginal().getid_empresa()!=null)
				{
					strValorActual=tablaretencion.getTablaRetencionOriginal().getid_empresa().toString();
				}
				if(tablaretencion.getid_empresa()!=null)
				{
					strValorNuevo=tablaretencion.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TablaRetencionConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(tablaretencion.getIsNew()||!tablaretencion.getcodigo().equals(tablaretencion.getTablaRetencionOriginal().getcodigo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tablaretencion.getTablaRetencionOriginal().getcodigo()!=null)
				{
					strValorActual=tablaretencion.getTablaRetencionOriginal().getcodigo();
				}
				if(tablaretencion.getcodigo()!=null)
				{
					strValorNuevo=tablaretencion.getcodigo() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TablaRetencionConstantesFunciones.CODIGO,strValorActual,strValorNuevo);
			}	
			
			if(tablaretencion.getIsNew()||!tablaretencion.getnombre().equals(tablaretencion.getTablaRetencionOriginal().getnombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tablaretencion.getTablaRetencionOriginal().getnombre()!=null)
				{
					strValorActual=tablaretencion.getTablaRetencionOriginal().getnombre();
				}
				if(tablaretencion.getnombre()!=null)
				{
					strValorNuevo=tablaretencion.getnombre() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TablaRetencionConstantesFunciones.NOMBRE,strValorActual,strValorNuevo);
			}	
			
			if(tablaretencion.getIsNew()||!tablaretencion.getporcentaje().equals(tablaretencion.getTablaRetencionOriginal().getporcentaje()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tablaretencion.getTablaRetencionOriginal().getporcentaje()!=null)
				{
					strValorActual=tablaretencion.getTablaRetencionOriginal().getporcentaje().toString();
				}
				if(tablaretencion.getporcentaje()!=null)
				{
					strValorNuevo=tablaretencion.getporcentaje().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TablaRetencionConstantesFunciones.PORCENTAJE,strValorActual,strValorNuevo);
			}	
			
			if(tablaretencion.getIsNew()||!tablaretencion.getmonto_minimo().equals(tablaretencion.getTablaRetencionOriginal().getmonto_minimo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tablaretencion.getTablaRetencionOriginal().getmonto_minimo()!=null)
				{
					strValorActual=tablaretencion.getTablaRetencionOriginal().getmonto_minimo().toString();
				}
				if(tablaretencion.getmonto_minimo()!=null)
				{
					strValorNuevo=tablaretencion.getmonto_minimo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TablaRetencionConstantesFunciones.MONTOMINIMO,strValorActual,strValorNuevo);
			}	
			
			if(tablaretencion.getIsNew()||!tablaretencion.getid_tipo_retencion().equals(tablaretencion.getTablaRetencionOriginal().getid_tipo_retencion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tablaretencion.getTablaRetencionOriginal().getid_tipo_retencion()!=null)
				{
					strValorActual=tablaretencion.getTablaRetencionOriginal().getid_tipo_retencion().toString();
				}
				if(tablaretencion.getid_tipo_retencion()!=null)
				{
					strValorNuevo=tablaretencion.getid_tipo_retencion().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TablaRetencionConstantesFunciones.IDTIPORETENCION,strValorActual,strValorNuevo);
			}	
			
			if(tablaretencion.getIsNew()||!tablaretencion.getid_cuenta_contable_debito().equals(tablaretencion.getTablaRetencionOriginal().getid_cuenta_contable_debito()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tablaretencion.getTablaRetencionOriginal().getid_cuenta_contable_debito()!=null)
				{
					strValorActual=tablaretencion.getTablaRetencionOriginal().getid_cuenta_contable_debito().toString();
				}
				if(tablaretencion.getid_cuenta_contable_debito()!=null)
				{
					strValorNuevo=tablaretencion.getid_cuenta_contable_debito().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TablaRetencionConstantesFunciones.IDCUENTACONTABLEDEBITO,strValorActual,strValorNuevo);
			}	
			
			if(tablaretencion.getIsNew()||!tablaretencion.getid_cuenta_contable_credito().equals(tablaretencion.getTablaRetencionOriginal().getid_cuenta_contable_credito()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tablaretencion.getTablaRetencionOriginal().getid_cuenta_contable_credito()!=null)
				{
					strValorActual=tablaretencion.getTablaRetencionOriginal().getid_cuenta_contable_credito().toString();
				}
				if(tablaretencion.getid_cuenta_contable_credito()!=null)
				{
					strValorNuevo=tablaretencion.getid_cuenta_contable_credito().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TablaRetencionConstantesFunciones.IDCUENTACONTABLECREDITO,strValorActual,strValorNuevo);
			}	
			
			if(tablaretencion.getIsNew()||!tablaretencion.getes_debito().equals(tablaretencion.getTablaRetencionOriginal().getes_debito()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tablaretencion.getTablaRetencionOriginal().getes_debito()!=null)
				{
					strValorActual=tablaretencion.getTablaRetencionOriginal().getes_debito().toString();
				}
				if(tablaretencion.getes_debito()!=null)
				{
					strValorNuevo=tablaretencion.getes_debito().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TablaRetencionConstantesFunciones.ESDEBITO,strValorActual,strValorNuevo);
			}	
			
			if(tablaretencion.getIsNew()||!tablaretencion.getes_retencion_fuente().equals(tablaretencion.getTablaRetencionOriginal().getes_retencion_fuente()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tablaretencion.getTablaRetencionOriginal().getes_retencion_fuente()!=null)
				{
					strValorActual=tablaretencion.getTablaRetencionOriginal().getes_retencion_fuente().toString();
				}
				if(tablaretencion.getes_retencion_fuente()!=null)
				{
					strValorNuevo=tablaretencion.getes_retencion_fuente().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TablaRetencionConstantesFunciones.ESRETENCIONFUENTE,strValorActual,strValorNuevo);
			}	
			
			if(tablaretencion.getIsNew()||!tablaretencion.getcon_secuencial().equals(tablaretencion.getTablaRetencionOriginal().getcon_secuencial()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tablaretencion.getTablaRetencionOriginal().getcon_secuencial()!=null)
				{
					strValorActual=tablaretencion.getTablaRetencionOriginal().getcon_secuencial().toString();
				}
				if(tablaretencion.getcon_secuencial()!=null)
				{
					strValorNuevo=tablaretencion.getcon_secuencial().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TablaRetencionConstantesFunciones.CONSECUENCIAL,strValorActual,strValorNuevo);
			}	
			
			if(tablaretencion.getIsNew()||!tablaretencion.getcon_sub_total_factura().equals(tablaretencion.getTablaRetencionOriginal().getcon_sub_total_factura()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tablaretencion.getTablaRetencionOriginal().getcon_sub_total_factura()!=null)
				{
					strValorActual=tablaretencion.getTablaRetencionOriginal().getcon_sub_total_factura().toString();
				}
				if(tablaretencion.getcon_sub_total_factura()!=null)
				{
					strValorNuevo=tablaretencion.getcon_sub_total_factura().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TablaRetencionConstantesFunciones.CONSUBTOTALFACTURA,strValorActual,strValorNuevo);
			}	
			
			if(tablaretencion.getIsNew()||!tablaretencion.getcon_iva_factura().equals(tablaretencion.getTablaRetencionOriginal().getcon_iva_factura()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tablaretencion.getTablaRetencionOriginal().getcon_iva_factura()!=null)
				{
					strValorActual=tablaretencion.getTablaRetencionOriginal().getcon_iva_factura().toString();
				}
				if(tablaretencion.getcon_iva_factura()!=null)
				{
					strValorNuevo=tablaretencion.getcon_iva_factura().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TablaRetencionConstantesFunciones.CONIVAFACTURA,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveTablaRetencionRelacionesWithConnection(TablaRetencion tablaretencion) throws Exception {

		if(!tablaretencion.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveTablaRetencionRelacionesBase(tablaretencion,true);
		}
	}

	public void saveTablaRetencionRelaciones(TablaRetencion tablaretencion)throws Exception {

		if(!tablaretencion.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveTablaRetencionRelacionesBase(tablaretencion,false);
		}
	}

	public void saveTablaRetencionRelacionesBase(TablaRetencion tablaretencion,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("TablaRetencion-saveRelacionesWithConnection");}
	

			this.setTablaRetencion(tablaretencion);

			if(TablaRetencionLogicAdditional.validarSaveRelaciones(tablaretencion,this)) {

				TablaRetencionLogicAdditional.updateRelacionesToSave(tablaretencion,this);

				if((tablaretencion.getIsNew()||tablaretencion.getIsChanged())&&!tablaretencion.getIsDeleted()) {
					this.saveTablaRetencion();
					this.saveTablaRetencionRelacionesDetalles();

				} else if(tablaretencion.getIsDeleted()) {
					this.saveTablaRetencionRelacionesDetalles();
					this.saveTablaRetencion();
				}

				TablaRetencionLogicAdditional.updateRelacionesToSaveAfter(tablaretencion,this);

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
	
	
	private void saveTablaRetencionRelacionesDetalles()throws Exception {
		try {
	

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfTablaRetencion(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=TablaRetencionConstantesFunciones.getClassesForeignKeysOfTablaRetencion(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTablaRetencion(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=TablaRetencionConstantesFunciones.getClassesRelationshipsOfTablaRetencion(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

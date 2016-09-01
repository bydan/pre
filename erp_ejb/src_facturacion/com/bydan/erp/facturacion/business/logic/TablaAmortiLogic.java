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
import com.bydan.erp.facturacion.util.TablaAmortiConstantesFunciones;
import com.bydan.erp.facturacion.util.TablaAmortiParameterReturnGeneral;
//import com.bydan.erp.facturacion.util.TablaAmortiParameterGeneral;
import com.bydan.erp.facturacion.business.entity.TablaAmorti;
import com.bydan.erp.facturacion.business.logic.TablaAmortiLogicAdditional;
import com.bydan.erp.facturacion.business.dataaccess.*;
import com.bydan.erp.facturacion.business.entity.*;

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
public class TablaAmortiLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(TablaAmortiLogic.class);
	
	protected TablaAmortiDataAccess tablaamortiDataAccess; 	
	protected TablaAmorti tablaamorti;
	protected List<TablaAmorti> tablaamortis;
	protected Object tablaamortiObject;	
	protected List<Object> tablaamortisObject;
	
	public static ClassValidator<TablaAmorti> tablaamortiValidator = new ClassValidator<TablaAmorti>(TablaAmorti.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected TablaAmortiLogicAdditional tablaamortiLogicAdditional=null;
	
	public TablaAmortiLogicAdditional getTablaAmortiLogicAdditional() {
		return this.tablaamortiLogicAdditional;
	}
	
	public void setTablaAmortiLogicAdditional(TablaAmortiLogicAdditional tablaamortiLogicAdditional) {
		try {
			this.tablaamortiLogicAdditional=tablaamortiLogicAdditional;
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
	
	
	
	
	public  TablaAmortiLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.tablaamortiDataAccess = new TablaAmortiDataAccess();
			
			this.tablaamortis= new ArrayList<TablaAmorti>();
			this.tablaamorti= new TablaAmorti();
			
			this.tablaamortiObject=new Object();
			this.tablaamortisObject=new ArrayList<Object>();
				
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
			
			this.tablaamortiDataAccess.setConnexionType(this.connexionType);
			this.tablaamortiDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  TablaAmortiLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.tablaamortiDataAccess = new TablaAmortiDataAccess();
			this.tablaamortis= new ArrayList<TablaAmorti>();
			this.tablaamorti= new TablaAmorti();
			this.tablaamortiObject=new Object();
			this.tablaamortisObject=new ArrayList<Object>();
			
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
			
			this.tablaamortiDataAccess.setConnexionType(this.connexionType);
			this.tablaamortiDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public TablaAmorti getTablaAmorti() throws Exception {	
		TablaAmortiLogicAdditional.checkTablaAmortiToGet(tablaamorti,this.datosCliente,this.arrDatoGeneral);
		TablaAmortiLogicAdditional.updateTablaAmortiToGet(tablaamorti,this.arrDatoGeneral);
		
		return tablaamorti;
	}
		
	public void setTablaAmorti(TablaAmorti newTablaAmorti) {
		this.tablaamorti = newTablaAmorti;
	}
	
	public TablaAmortiDataAccess getTablaAmortiDataAccess() {
		return tablaamortiDataAccess;
	}
	
	public void setTablaAmortiDataAccess(TablaAmortiDataAccess newtablaamortiDataAccess) {
		this.tablaamortiDataAccess = newtablaamortiDataAccess;
	}
	
	public List<TablaAmorti> getTablaAmortis() throws Exception {		
		this.quitarTablaAmortisNulos();
		
		TablaAmortiLogicAdditional.checkTablaAmortiToGets(tablaamortis,this.datosCliente,this.arrDatoGeneral);
		
		for (TablaAmorti tablaamortiLocal: tablaamortis ) {
			TablaAmortiLogicAdditional.updateTablaAmortiToGet(tablaamortiLocal,this.arrDatoGeneral);
		}
		
		return tablaamortis;
	}
	
	public void setTablaAmortis(List<TablaAmorti> newTablaAmortis) {
		this.tablaamortis = newTablaAmortis;
	}
	
	public Object getTablaAmortiObject() {	
		this.tablaamortiObject=this.tablaamortiDataAccess.getEntityObject();
		return this.tablaamortiObject;
	}
		
	public void setTablaAmortiObject(Object newTablaAmortiObject) {
		this.tablaamortiObject = newTablaAmortiObject;
	}
	
	public List<Object> getTablaAmortisObject() {		
		this.tablaamortisObject=this.tablaamortiDataAccess.getEntitiesObject();
		return this.tablaamortisObject;
	}
		
	public void setTablaAmortisObject(List<Object> newTablaAmortisObject) {
		this.tablaamortisObject = newTablaAmortisObject;
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
		
		if(this.tablaamortiDataAccess!=null) {
			this.tablaamortiDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TablaAmorti.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			tablaamortiDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			tablaamortiDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		tablaamorti = new  TablaAmorti();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TablaAmorti.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			tablaamorti=tablaamortiDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tablaamorti,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TablaAmortiConstantesFunciones.refrescarForeignKeysDescripcionesTablaAmorti(this.tablaamorti);
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
		tablaamorti = new  TablaAmorti();
		  		  
        try {
			
			tablaamorti=tablaamortiDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tablaamorti,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TablaAmortiConstantesFunciones.refrescarForeignKeysDescripcionesTablaAmorti(this.tablaamorti);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		tablaamorti = new  TablaAmorti();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TablaAmorti.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			tablaamorti=tablaamortiDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tablaamorti,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TablaAmortiConstantesFunciones.refrescarForeignKeysDescripcionesTablaAmorti(this.tablaamorti);
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
		tablaamorti = new  TablaAmorti();
		  		  
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
		tablaamorti = new  TablaAmorti();
		  		  
        try {
			
			tablaamorti=tablaamortiDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tablaamorti,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TablaAmortiConstantesFunciones.refrescarForeignKeysDescripcionesTablaAmorti(this.tablaamorti);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		tablaamorti = new  TablaAmorti();
		  		  
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
		tablaamorti = new  TablaAmorti();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TablaAmorti.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =tablaamortiDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tablaamorti = new  TablaAmorti();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=tablaamortiDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		tablaamorti = new  TablaAmorti();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TablaAmorti.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =tablaamortiDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tablaamorti = new  TablaAmorti();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=tablaamortiDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		tablaamorti = new  TablaAmorti();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TablaAmorti.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =tablaamortiDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tablaamorti = new  TablaAmorti();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=tablaamortiDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		tablaamortis = new  ArrayList<TablaAmorti>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TablaAmorti.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			TablaAmortiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tablaamortis=tablaamortiDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTablaAmorti(tablaamortis);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TablaAmortiConstantesFunciones.refrescarForeignKeysDescripcionesTablaAmorti(this.tablaamortis);
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
		tablaamortis = new  ArrayList<TablaAmorti>();
		  		  
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
		tablaamortis = new  ArrayList<TablaAmorti>();
		  		  
        try {			
			TablaAmortiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tablaamortis=tablaamortiDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarTablaAmorti(tablaamortis);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TablaAmortiConstantesFunciones.refrescarForeignKeysDescripcionesTablaAmorti(this.tablaamortis);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		tablaamortis = new  ArrayList<TablaAmorti>();
		  		  
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
		tablaamortis = new  ArrayList<TablaAmorti>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TablaAmorti.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			TablaAmortiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tablaamortis=tablaamortiDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTablaAmorti(tablaamortis);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TablaAmortiConstantesFunciones.refrescarForeignKeysDescripcionesTablaAmorti(this.tablaamortis);
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
		tablaamortis = new  ArrayList<TablaAmorti>();
		  		  
        try {
			TablaAmortiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tablaamortis=tablaamortiDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTablaAmorti(tablaamortis);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TablaAmortiConstantesFunciones.refrescarForeignKeysDescripcionesTablaAmorti(this.tablaamortis);
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
		tablaamortis = new  ArrayList<TablaAmorti>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TablaAmorti.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TablaAmortiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tablaamortis=tablaamortiDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTablaAmorti(tablaamortis);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TablaAmortiConstantesFunciones.refrescarForeignKeysDescripcionesTablaAmorti(this.tablaamortis);
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
		tablaamortis = new  ArrayList<TablaAmorti>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TablaAmortiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tablaamortis=tablaamortiDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTablaAmorti(tablaamortis);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TablaAmortiConstantesFunciones.refrescarForeignKeysDescripcionesTablaAmorti(this.tablaamortis);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		tablaamorti = new  TablaAmorti();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TablaAmorti.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TablaAmortiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tablaamorti=tablaamortiDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTablaAmorti(tablaamorti);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TablaAmortiConstantesFunciones.refrescarForeignKeysDescripcionesTablaAmorti(this.tablaamorti);
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
		tablaamorti = new  TablaAmorti();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TablaAmortiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tablaamorti=tablaamortiDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTablaAmorti(tablaamorti);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TablaAmortiConstantesFunciones.refrescarForeignKeysDescripcionesTablaAmorti(this.tablaamorti);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		tablaamortis = new  ArrayList<TablaAmorti>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TablaAmorti.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			TablaAmortiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tablaamortis=tablaamortiDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTablaAmorti(tablaamortis);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TablaAmortiConstantesFunciones.refrescarForeignKeysDescripcionesTablaAmorti(this.tablaamortis);
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
		tablaamortis = new  ArrayList<TablaAmorti>();
		  		  
        try {
			TablaAmortiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tablaamortis=tablaamortiDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTablaAmorti(tablaamortis);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TablaAmortiConstantesFunciones.refrescarForeignKeysDescripcionesTablaAmorti(this.tablaamortis);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosTablaAmortisWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		tablaamortis = new  ArrayList<TablaAmorti>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TablaAmorti.class.getSimpleName()+"-getTodosTablaAmortisWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TablaAmortiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tablaamortis=tablaamortiDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarTablaAmorti(tablaamortis);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TablaAmortiConstantesFunciones.refrescarForeignKeysDescripcionesTablaAmorti(this.tablaamortis);
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
	
	public  void  getTodosTablaAmortis(String sFinalQuery,Pagination pagination)throws Exception {
		tablaamortis = new  ArrayList<TablaAmorti>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TablaAmortiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tablaamortis=tablaamortiDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarTablaAmorti(tablaamortis);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TablaAmortiConstantesFunciones.refrescarForeignKeysDescripcionesTablaAmorti(this.tablaamortis);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarTablaAmorti(TablaAmorti tablaamorti) throws Exception {
		Boolean estaValidado=false;
		
		if(tablaamorti.getIsNew() || tablaamorti.getIsChanged()) { 
			this.invalidValues = tablaamortiValidator.getInvalidValues(tablaamorti);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(tablaamorti);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarTablaAmorti(List<TablaAmorti> TablaAmortis) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(TablaAmorti tablaamortiLocal:tablaamortis) {				
			estaValidadoObjeto=this.validarGuardarTablaAmorti(tablaamortiLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarTablaAmorti(List<TablaAmorti> TablaAmortis) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarTablaAmorti(tablaamortis)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarTablaAmorti(TablaAmorti TablaAmorti) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarTablaAmorti(tablaamorti)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(TablaAmorti tablaamorti) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+tablaamorti.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=TablaAmortiConstantesFunciones.getTablaAmortiLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"tablaamorti","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(TablaAmortiConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(TablaAmortiConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveTablaAmortiWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TablaAmorti.class.getSimpleName()+"-saveTablaAmortiWithConnection");connexion.begin();			
			
			TablaAmortiLogicAdditional.checkTablaAmortiToSave(this.tablaamorti,this.datosCliente,connexion,this.arrDatoGeneral);
			
			TablaAmortiLogicAdditional.updateTablaAmortiToSave(this.tablaamorti,this.arrDatoGeneral);
			
			TablaAmortiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.tablaamorti,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowTablaAmorti();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarTablaAmorti(this.tablaamorti)) {
				TablaAmortiDataAccess.save(this.tablaamorti, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.tablaamorti,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			TablaAmortiLogicAdditional.checkTablaAmortiToSaveAfter(this.tablaamorti,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowTablaAmorti();
			
			connexion.commit();			
			
			if(this.tablaamorti.getIsDeleted()) {
				this.tablaamorti=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveTablaAmorti()throws Exception {	
		try {	
			
			TablaAmortiLogicAdditional.checkTablaAmortiToSave(this.tablaamorti,this.datosCliente,connexion,this.arrDatoGeneral);
			
			TablaAmortiLogicAdditional.updateTablaAmortiToSave(this.tablaamorti,this.arrDatoGeneral);
			
			TablaAmortiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.tablaamorti,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarTablaAmorti(this.tablaamorti)) {			
				TablaAmortiDataAccess.save(this.tablaamorti, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.tablaamorti,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			TablaAmortiLogicAdditional.checkTablaAmortiToSaveAfter(this.tablaamorti,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.tablaamorti.getIsDeleted()) {
				this.tablaamorti=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveTablaAmortisWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TablaAmorti.class.getSimpleName()+"-saveTablaAmortisWithConnection");connexion.begin();			
			
			TablaAmortiLogicAdditional.checkTablaAmortiToSaves(tablaamortis,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowTablaAmortis();
			
			Boolean validadoTodosTablaAmorti=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(TablaAmorti tablaamortiLocal:tablaamortis) {		
				if(tablaamortiLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				TablaAmortiLogicAdditional.updateTablaAmortiToSave(tablaamortiLocal,this.arrDatoGeneral);
	        	
				TablaAmortiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),tablaamortiLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarTablaAmorti(tablaamortiLocal)) {
					TablaAmortiDataAccess.save(tablaamortiLocal, connexion);				
				} else {
					validadoTodosTablaAmorti=false;
				}
			}
			
			if(!validadoTodosTablaAmorti) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			TablaAmortiLogicAdditional.checkTablaAmortiToSavesAfter(tablaamortis,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowTablaAmortis();
			
			connexion.commit();		
			
			this.quitarTablaAmortisEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveTablaAmortis()throws Exception {				
		 try {	
			TablaAmortiLogicAdditional.checkTablaAmortiToSaves(tablaamortis,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosTablaAmorti=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(TablaAmorti tablaamortiLocal:tablaamortis) {				
				if(tablaamortiLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				TablaAmortiLogicAdditional.updateTablaAmortiToSave(tablaamortiLocal,this.arrDatoGeneral);
	        	
				TablaAmortiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),tablaamortiLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarTablaAmorti(tablaamortiLocal)) {				
					TablaAmortiDataAccess.save(tablaamortiLocal, connexion);				
				} else {
					validadoTodosTablaAmorti=false;
				}
			}
			
			if(!validadoTodosTablaAmorti) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			TablaAmortiLogicAdditional.checkTablaAmortiToSavesAfter(tablaamortis,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarTablaAmortisEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public TablaAmortiParameterReturnGeneral procesarAccionTablaAmortis(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<TablaAmorti> tablaamortis,TablaAmortiParameterReturnGeneral tablaamortiParameterGeneral)throws Exception {
		 try {	
			TablaAmortiParameterReturnGeneral tablaamortiReturnGeneral=new TablaAmortiParameterReturnGeneral();
	
			TablaAmortiLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,tablaamortis,tablaamortiParameterGeneral,tablaamortiReturnGeneral);
			
			return tablaamortiReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public TablaAmortiParameterReturnGeneral procesarAccionTablaAmortisWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<TablaAmorti> tablaamortis,TablaAmortiParameterReturnGeneral tablaamortiParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TablaAmorti.class.getSimpleName()+"-procesarAccionTablaAmortisWithConnection");connexion.begin();			
			
			TablaAmortiParameterReturnGeneral tablaamortiReturnGeneral=new TablaAmortiParameterReturnGeneral();
	
			TablaAmortiLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,tablaamortis,tablaamortiParameterGeneral,tablaamortiReturnGeneral);
			
			this.connexion.commit();
			
			return tablaamortiReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public TablaAmortiParameterReturnGeneral procesarEventosTablaAmortis(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<TablaAmorti> tablaamortis,TablaAmorti tablaamorti,TablaAmortiParameterReturnGeneral tablaamortiParameterGeneral,Boolean isEsNuevoTablaAmorti,ArrayList<Classe> clases)throws Exception {
		 try {	
			TablaAmortiParameterReturnGeneral tablaamortiReturnGeneral=new TablaAmortiParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				tablaamortiReturnGeneral.setConRecargarPropiedades(true);
			}
			
			TablaAmortiLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,tablaamortis,tablaamorti,tablaamortiParameterGeneral,tablaamortiReturnGeneral,isEsNuevoTablaAmorti,clases);
			
			return tablaamortiReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public TablaAmortiParameterReturnGeneral procesarEventosTablaAmortisWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<TablaAmorti> tablaamortis,TablaAmorti tablaamorti,TablaAmortiParameterReturnGeneral tablaamortiParameterGeneral,Boolean isEsNuevoTablaAmorti,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TablaAmorti.class.getSimpleName()+"-procesarEventosTablaAmortisWithConnection");connexion.begin();			
			
			TablaAmortiParameterReturnGeneral tablaamortiReturnGeneral=new TablaAmortiParameterReturnGeneral();
	
			tablaamortiReturnGeneral.setTablaAmorti(tablaamorti);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				tablaamortiReturnGeneral.setConRecargarPropiedades(true);
			}
			
			TablaAmortiLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,tablaamortis,tablaamorti,tablaamortiParameterGeneral,tablaamortiReturnGeneral,isEsNuevoTablaAmorti,clases);
			
			this.connexion.commit();
			
			return tablaamortiReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public TablaAmortiParameterReturnGeneral procesarImportacionTablaAmortisWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,TablaAmortiParameterReturnGeneral tablaamortiParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TablaAmorti.class.getSimpleName()+"-procesarImportacionTablaAmortisWithConnection");connexion.begin();			
			
			TablaAmortiParameterReturnGeneral tablaamortiReturnGeneral=new TablaAmortiParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.tablaamortis=new ArrayList<TablaAmorti>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.tablaamorti=new TablaAmorti();
				
				
				if(conColumnasBase) {this.tablaamorti.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.tablaamorti.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.tablaamorti.setfecha_emision(Funciones.ConvertToDate(arrColumnas[iColumn++]));
				this.tablaamorti.setfecha_vencimiento(Funciones.ConvertToDate(arrColumnas[iColumn++]));
				this.tablaamorti.setvalor_prestamo(Double.parseDouble(arrColumnas[iColumn++]));
				this.tablaamorti.setnumero_cuotas(Integer.parseInt(arrColumnas[iColumn++]));
				
				this.tablaamortis.add(this.tablaamorti);
			}
			
			this.saveTablaAmortis();
			
			this.connexion.commit();
			
			tablaamortiReturnGeneral.setConRetornoEstaProcesado(true);
			tablaamortiReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return tablaamortiReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarTablaAmortisEliminados() throws Exception {				
		
		List<TablaAmorti> tablaamortisAux= new ArrayList<TablaAmorti>();
		
		for(TablaAmorti tablaamorti:tablaamortis) {
			if(!tablaamorti.getIsDeleted()) {
				tablaamortisAux.add(tablaamorti);
			}
		}
		
		tablaamortis=tablaamortisAux;
	}
	
	public void quitarTablaAmortisNulos() throws Exception {				
		
		List<TablaAmorti> tablaamortisAux= new ArrayList<TablaAmorti>();
		
		for(TablaAmorti tablaamorti : this.tablaamortis) {
			if(tablaamorti==null) {
				tablaamortisAux.add(tablaamorti);
			}
		}
		
		//this.tablaamortis=tablaamortisAux;
		
		this.tablaamortis.removeAll(tablaamortisAux);
	}
	
	public void getSetVersionRowTablaAmortiWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(tablaamorti.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((tablaamorti.getIsDeleted() || (tablaamorti.getIsChanged()&&!tablaamorti.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=tablaamortiDataAccess.getSetVersionRowTablaAmorti(connexion,tablaamorti.getId());
				
				if(!tablaamorti.getVersionRow().equals(timestamp)) {	
					tablaamorti.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				tablaamorti.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowTablaAmorti()throws Exception {	
		
		if(tablaamorti.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((tablaamorti.getIsDeleted() || (tablaamorti.getIsChanged()&&!tablaamorti.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=tablaamortiDataAccess.getSetVersionRowTablaAmorti(connexion,tablaamorti.getId());
			
			try {							
				if(!tablaamorti.getVersionRow().equals(timestamp)) {	
					tablaamorti.setVersionRow(timestamp);
				}
				
				tablaamorti.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowTablaAmortisWithConnection()throws Exception {	
		if(tablaamortis!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(TablaAmorti tablaamortiAux:tablaamortis) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(tablaamortiAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(tablaamortiAux.getIsDeleted() || (tablaamortiAux.getIsChanged()&&!tablaamortiAux.getIsNew())) {
						
						timestamp=tablaamortiDataAccess.getSetVersionRowTablaAmorti(connexion,tablaamortiAux.getId());
						
						if(!tablaamorti.getVersionRow().equals(timestamp)) {	
							tablaamortiAux.setVersionRow(timestamp);
						}
								
						tablaamortiAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowTablaAmortis()throws Exception {	
		if(tablaamortis!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(TablaAmorti tablaamortiAux:tablaamortis) {
					if(tablaamortiAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(tablaamortiAux.getIsDeleted() || (tablaamortiAux.getIsChanged()&&!tablaamortiAux.getIsNew())) {
						
						timestamp=tablaamortiDataAccess.getSetVersionRowTablaAmorti(connexion,tablaamortiAux.getId());
						
						if(!tablaamortiAux.getVersionRow().equals(timestamp)) {	
							tablaamortiAux.setVersionRow(timestamp);
						}
						
													
						tablaamortiAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public TablaAmortiParameterReturnGeneral cargarCombosLoteForeignKeyTablaAmortiWithConnection(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalEjercicio,String finalQueryGlobalPeriodo,String finalQueryGlobalTasa,String finalQueryGlobalFactura,String finalQueryGlobalAnio,String finalQueryGlobalMes) throws Exception {
		TablaAmortiParameterReturnGeneral  tablaamortiReturnGeneral =new TablaAmortiParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TablaAmorti.class.getSimpleName()+"-cargarCombosLoteForeignKeyTablaAmortiWithConnection");connexion.begin();
			
			tablaamortiReturnGeneral =new TablaAmortiParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			tablaamortiReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			tablaamortiReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Ejercicio> ejerciciosForeignKey=new ArrayList<Ejercicio>();
			EjercicioLogic ejercicioLogic=new EjercicioLogic();
			ejercicioLogic.setConnexion(this.connexion);
			//ejercicioLogic.getEjercicioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEjercicio.equals("NONE")) {
				ejercicioLogic.getTodosEjercicios(finalQueryGlobalEjercicio,new Pagination());
				ejerciciosForeignKey=ejercicioLogic.getEjercicios();
			}

			tablaamortiReturnGeneral.setejerciciosForeignKey(ejerciciosForeignKey);


			List<Periodo> periodosForeignKey=new ArrayList<Periodo>();
			PeriodoLogic periodoLogic=new PeriodoLogic();
			periodoLogic.setConnexion(this.connexion);
			//periodoLogic.getPeriodoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPeriodo.equals("NONE")) {
				periodoLogic.getTodosPeriodos(finalQueryGlobalPeriodo,new Pagination());
				periodosForeignKey=periodoLogic.getPeriodos();
			}

			tablaamortiReturnGeneral.setperiodosForeignKey(periodosForeignKey);


			List<Tasa> tasasForeignKey=new ArrayList<Tasa>();
			TasaLogic tasaLogic=new TasaLogic();
			tasaLogic.setConnexion(this.connexion);
			tasaLogic.getTasaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTasa.equals("NONE")) {
				tasaLogic.getTodosTasas(finalQueryGlobalTasa,new Pagination());
				tasasForeignKey=tasaLogic.getTasas();
			}

			tablaamortiReturnGeneral.settasasForeignKey(tasasForeignKey);


			List<Factura> facturasForeignKey=new ArrayList<Factura>();
			FacturaLogic facturaLogic=new FacturaLogic();
			facturaLogic.setConnexion(this.connexion);
			facturaLogic.getFacturaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalFactura.equals("NONE")) {
				facturaLogic.getTodosFacturas(finalQueryGlobalFactura,new Pagination());
				facturasForeignKey=facturaLogic.getFacturas();
			}

			tablaamortiReturnGeneral.setfacturasForeignKey(facturasForeignKey);


			List<Anio> aniosForeignKey=new ArrayList<Anio>();
			AnioLogic anioLogic=new AnioLogic();
			anioLogic.setConnexion(this.connexion);
			anioLogic.getAnioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalAnio.equals("NONE")) {
				anioLogic.getTodosAnios(finalQueryGlobalAnio,new Pagination());
				aniosForeignKey=anioLogic.getAnios();
			}

			tablaamortiReturnGeneral.setaniosForeignKey(aniosForeignKey);


			List<Mes> messForeignKey=new ArrayList<Mes>();
			MesLogic mesLogic=new MesLogic();
			mesLogic.setConnexion(this.connexion);
			mesLogic.getMesDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalMes.equals("NONE")) {
				mesLogic.getTodosMess(finalQueryGlobalMes,new Pagination());
				messForeignKey=mesLogic.getMess();
			}

			tablaamortiReturnGeneral.setmessForeignKey(messForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return tablaamortiReturnGeneral;
	}
	
	public TablaAmortiParameterReturnGeneral cargarCombosLoteForeignKeyTablaAmorti(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalEjercicio,String finalQueryGlobalPeriodo,String finalQueryGlobalTasa,String finalQueryGlobalFactura,String finalQueryGlobalAnio,String finalQueryGlobalMes) throws Exception {
		TablaAmortiParameterReturnGeneral  tablaamortiReturnGeneral =new TablaAmortiParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			tablaamortiReturnGeneral =new TablaAmortiParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			tablaamortiReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			tablaamortiReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Ejercicio> ejerciciosForeignKey=new ArrayList<Ejercicio>();
			EjercicioLogic ejercicioLogic=new EjercicioLogic();
			ejercicioLogic.setConnexion(this.connexion);
			//ejercicioLogic.getEjercicioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEjercicio.equals("NONE")) {
				ejercicioLogic.getTodosEjercicios(finalQueryGlobalEjercicio,new Pagination());
				ejerciciosForeignKey=ejercicioLogic.getEjercicios();
			}

			tablaamortiReturnGeneral.setejerciciosForeignKey(ejerciciosForeignKey);


			List<Periodo> periodosForeignKey=new ArrayList<Periodo>();
			PeriodoLogic periodoLogic=new PeriodoLogic();
			periodoLogic.setConnexion(this.connexion);
			//periodoLogic.getPeriodoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPeriodo.equals("NONE")) {
				periodoLogic.getTodosPeriodos(finalQueryGlobalPeriodo,new Pagination());
				periodosForeignKey=periodoLogic.getPeriodos();
			}

			tablaamortiReturnGeneral.setperiodosForeignKey(periodosForeignKey);


			List<Tasa> tasasForeignKey=new ArrayList<Tasa>();
			TasaLogic tasaLogic=new TasaLogic();
			tasaLogic.setConnexion(this.connexion);
			tasaLogic.getTasaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTasa.equals("NONE")) {
				tasaLogic.getTodosTasas(finalQueryGlobalTasa,new Pagination());
				tasasForeignKey=tasaLogic.getTasas();
			}

			tablaamortiReturnGeneral.settasasForeignKey(tasasForeignKey);


			List<Factura> facturasForeignKey=new ArrayList<Factura>();
			FacturaLogic facturaLogic=new FacturaLogic();
			facturaLogic.setConnexion(this.connexion);
			facturaLogic.getFacturaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalFactura.equals("NONE")) {
				facturaLogic.getTodosFacturas(finalQueryGlobalFactura,new Pagination());
				facturasForeignKey=facturaLogic.getFacturas();
			}

			tablaamortiReturnGeneral.setfacturasForeignKey(facturasForeignKey);


			List<Anio> aniosForeignKey=new ArrayList<Anio>();
			AnioLogic anioLogic=new AnioLogic();
			anioLogic.setConnexion(this.connexion);
			anioLogic.getAnioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalAnio.equals("NONE")) {
				anioLogic.getTodosAnios(finalQueryGlobalAnio,new Pagination());
				aniosForeignKey=anioLogic.getAnios();
			}

			tablaamortiReturnGeneral.setaniosForeignKey(aniosForeignKey);


			List<Mes> messForeignKey=new ArrayList<Mes>();
			MesLogic mesLogic=new MesLogic();
			mesLogic.setConnexion(this.connexion);
			mesLogic.getMesDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalMes.equals("NONE")) {
				mesLogic.getTodosMess(finalQueryGlobalMes,new Pagination());
				messForeignKey=mesLogic.getMess();
			}

			tablaamortiReturnGeneral.setmessForeignKey(messForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return tablaamortiReturnGeneral;
	}
	
	public void cargarRelacionesLoteForeignKeyTablaAmortiWithConnection() throws Exception {
		ArrayList<Classe> classes=new ArrayList<Classe>();		
		
		
			DetalleTablaAmortiLogic detalletablaamortiLogic=new DetalleTablaAmortiLogic();
		
		try {
			
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TablaAmorti.class.getSimpleName()+"-cargarRelacionesLoteForeignKeyTablaAmortiWithConnection");connexion.begin();
			
			
			classes.add(new Classe(DetalleTablaAmorti.class));
											
			

			detalletablaamortiLogic.setConnexion(this.getConnexion());
			detalletablaamortiLogic.setDatosCliente(this.datosCliente);
			detalletablaamortiLogic.setIsConRefrescarForeignKeys(true);
			
			this.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
			
			for(TablaAmorti tablaamorti:this.tablaamortis) {
				

				classes=new ArrayList<Classe>();
				classes=DetalleTablaAmortiConstantesFunciones.getClassesForeignKeysOfDetalleTablaAmorti(new ArrayList<Classe>(),DeepLoadType.NONE);

				detalletablaamortiLogic.setDetalleTablaAmortis(tablaamorti.detalletablaamortis);
				detalletablaamortiLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
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
	
	public void deepLoad(TablaAmorti tablaamorti,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			TablaAmortiLogicAdditional.updateTablaAmortiToGet(tablaamorti,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		tablaamorti.setEmpresa(tablaamortiDataAccess.getEmpresa(connexion,tablaamorti));
		tablaamorti.setSucursal(tablaamortiDataAccess.getSucursal(connexion,tablaamorti));
		tablaamorti.setEjercicio(tablaamortiDataAccess.getEjercicio(connexion,tablaamorti));
		tablaamorti.setPeriodo(tablaamortiDataAccess.getPeriodo(connexion,tablaamorti));
		tablaamorti.setTasa(tablaamortiDataAccess.getTasa(connexion,tablaamorti));
		tablaamorti.setFactura(tablaamortiDataAccess.getFactura(connexion,tablaamorti));
		tablaamorti.setAnio(tablaamortiDataAccess.getAnio(connexion,tablaamorti));
		tablaamorti.setMes(tablaamortiDataAccess.getMes(connexion,tablaamorti));
		tablaamorti.setDetalleTablaAmortis(tablaamortiDataAccess.getDetalleTablaAmortis(connexion,tablaamorti));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				tablaamorti.setEmpresa(tablaamortiDataAccess.getEmpresa(connexion,tablaamorti));
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				tablaamorti.setSucursal(tablaamortiDataAccess.getSucursal(connexion,tablaamorti));
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				tablaamorti.setEjercicio(tablaamortiDataAccess.getEjercicio(connexion,tablaamorti));
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				tablaamorti.setPeriodo(tablaamortiDataAccess.getPeriodo(connexion,tablaamorti));
				continue;
			}

			if(clas.clas.equals(Tasa.class)) {
				tablaamorti.setTasa(tablaamortiDataAccess.getTasa(connexion,tablaamorti));
				continue;
			}

			if(clas.clas.equals(Factura.class)) {
				tablaamorti.setFactura(tablaamortiDataAccess.getFactura(connexion,tablaamorti));
				continue;
			}

			if(clas.clas.equals(Anio.class)) {
				tablaamorti.setAnio(tablaamortiDataAccess.getAnio(connexion,tablaamorti));
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				tablaamorti.setMes(tablaamortiDataAccess.getMes(connexion,tablaamorti));
				continue;
			}

			if(clas.clas.equals(DetalleTablaAmorti.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tablaamorti.setDetalleTablaAmortis(tablaamortiDataAccess.getDetalleTablaAmortis(connexion,tablaamorti));

				if(this.isConDeep) {
					DetalleTablaAmortiLogic detalletablaamortiLogic= new DetalleTablaAmortiLogic(this.connexion);
					detalletablaamortiLogic.setDetalleTablaAmortis(tablaamorti.getDetalleTablaAmortis());
					ArrayList<Classe> classesLocal=DetalleTablaAmortiConstantesFunciones.getClassesForeignKeysOfDetalleTablaAmorti(new ArrayList<Classe>(),DeepLoadType.NONE);
					detalletablaamortiLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					DetalleTablaAmortiConstantesFunciones.refrescarForeignKeysDescripcionesDetalleTablaAmorti(detalletablaamortiLogic.getDetalleTablaAmortis());
					tablaamorti.setDetalleTablaAmortis(detalletablaamortiLogic.getDetalleTablaAmortis());
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
			tablaamorti.setEmpresa(tablaamortiDataAccess.getEmpresa(connexion,tablaamorti));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			tablaamorti.setSucursal(tablaamortiDataAccess.getSucursal(connexion,tablaamorti));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Ejercicio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			tablaamorti.setEjercicio(tablaamortiDataAccess.getEjercicio(connexion,tablaamorti));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Periodo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			tablaamorti.setPeriodo(tablaamortiDataAccess.getPeriodo(connexion,tablaamorti));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Tasa.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			tablaamorti.setTasa(tablaamortiDataAccess.getTasa(connexion,tablaamorti));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Factura.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			tablaamorti.setFactura(tablaamortiDataAccess.getFactura(connexion,tablaamorti));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Anio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			tablaamorti.setAnio(tablaamortiDataAccess.getAnio(connexion,tablaamorti));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Mes.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			tablaamorti.setMes(tablaamortiDataAccess.getMes(connexion,tablaamorti));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(DetalleTablaAmorti.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(DetalleTablaAmorti.class));
			tablaamorti.setDetalleTablaAmortis(tablaamortiDataAccess.getDetalleTablaAmortis(connexion,tablaamorti));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		tablaamorti.setEmpresa(tablaamortiDataAccess.getEmpresa(connexion,tablaamorti));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(tablaamorti.getEmpresa(),isDeep,deepLoadType,clases);
				
		tablaamorti.setSucursal(tablaamortiDataAccess.getSucursal(connexion,tablaamorti));
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(tablaamorti.getSucursal(),isDeep,deepLoadType,clases);
				
		tablaamorti.setEjercicio(tablaamortiDataAccess.getEjercicio(connexion,tablaamorti));
		EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
		ejercicioLogic.deepLoad(tablaamorti.getEjercicio(),isDeep,deepLoadType,clases);
				
		tablaamorti.setPeriodo(tablaamortiDataAccess.getPeriodo(connexion,tablaamorti));
		PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
		periodoLogic.deepLoad(tablaamorti.getPeriodo(),isDeep,deepLoadType,clases);
				
		tablaamorti.setTasa(tablaamortiDataAccess.getTasa(connexion,tablaamorti));
		TasaLogic tasaLogic= new TasaLogic(connexion);
		tasaLogic.deepLoad(tablaamorti.getTasa(),isDeep,deepLoadType,clases);
				
		tablaamorti.setFactura(tablaamortiDataAccess.getFactura(connexion,tablaamorti));
		FacturaLogic facturaLogic= new FacturaLogic(connexion);
		facturaLogic.deepLoad(tablaamorti.getFactura(),isDeep,deepLoadType,clases);
				
		tablaamorti.setAnio(tablaamortiDataAccess.getAnio(connexion,tablaamorti));
		AnioLogic anioLogic= new AnioLogic(connexion);
		anioLogic.deepLoad(tablaamorti.getAnio(),isDeep,deepLoadType,clases);
				
		tablaamorti.setMes(tablaamortiDataAccess.getMes(connexion,tablaamorti));
		MesLogic mesLogic= new MesLogic(connexion);
		mesLogic.deepLoad(tablaamorti.getMes(),isDeep,deepLoadType,clases);
				

		tablaamorti.setDetalleTablaAmortis(tablaamortiDataAccess.getDetalleTablaAmortis(connexion,tablaamorti));

		for(DetalleTablaAmorti detalletablaamorti:tablaamorti.getDetalleTablaAmortis()) {
			DetalleTablaAmortiLogic detalletablaamortiLogic= new DetalleTablaAmortiLogic(connexion);
			detalletablaamortiLogic.deepLoad(detalletablaamorti,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				tablaamorti.setEmpresa(tablaamortiDataAccess.getEmpresa(connexion,tablaamorti));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(tablaamorti.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				tablaamorti.setSucursal(tablaamortiDataAccess.getSucursal(connexion,tablaamorti));
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepLoad(tablaamorti.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				tablaamorti.setEjercicio(tablaamortiDataAccess.getEjercicio(connexion,tablaamorti));
				EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
				ejercicioLogic.deepLoad(tablaamorti.getEjercicio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				tablaamorti.setPeriodo(tablaamortiDataAccess.getPeriodo(connexion,tablaamorti));
				PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
				periodoLogic.deepLoad(tablaamorti.getPeriodo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Tasa.class)) {
				tablaamorti.setTasa(tablaamortiDataAccess.getTasa(connexion,tablaamorti));
				TasaLogic tasaLogic= new TasaLogic(connexion);
				tasaLogic.deepLoad(tablaamorti.getTasa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Factura.class)) {
				tablaamorti.setFactura(tablaamortiDataAccess.getFactura(connexion,tablaamorti));
				FacturaLogic facturaLogic= new FacturaLogic(connexion);
				facturaLogic.deepLoad(tablaamorti.getFactura(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Anio.class)) {
				tablaamorti.setAnio(tablaamortiDataAccess.getAnio(connexion,tablaamorti));
				AnioLogic anioLogic= new AnioLogic(connexion);
				anioLogic.deepLoad(tablaamorti.getAnio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				tablaamorti.setMes(tablaamortiDataAccess.getMes(connexion,tablaamorti));
				MesLogic mesLogic= new MesLogic(connexion);
				mesLogic.deepLoad(tablaamorti.getMes(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(DetalleTablaAmorti.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tablaamorti.setDetalleTablaAmortis(tablaamortiDataAccess.getDetalleTablaAmortis(connexion,tablaamorti));

				for(DetalleTablaAmorti detalletablaamorti:tablaamorti.getDetalleTablaAmortis()) {
					DetalleTablaAmortiLogic detalletablaamortiLogic= new DetalleTablaAmortiLogic(connexion);
					detalletablaamortiLogic.deepLoad(detalletablaamorti,isDeep,deepLoadType,clases);
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
			tablaamorti.setEmpresa(tablaamortiDataAccess.getEmpresa(connexion,tablaamorti));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(tablaamorti.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			tablaamorti.setSucursal(tablaamortiDataAccess.getSucursal(connexion,tablaamorti));
			SucursalLogic sucursalLogic= new SucursalLogic(connexion);
			sucursalLogic.deepLoad(tablaamorti.getSucursal(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Ejercicio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			tablaamorti.setEjercicio(tablaamortiDataAccess.getEjercicio(connexion,tablaamorti));
			EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
			ejercicioLogic.deepLoad(tablaamorti.getEjercicio(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Periodo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			tablaamorti.setPeriodo(tablaamortiDataAccess.getPeriodo(connexion,tablaamorti));
			PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
			periodoLogic.deepLoad(tablaamorti.getPeriodo(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Tasa.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			tablaamorti.setTasa(tablaamortiDataAccess.getTasa(connexion,tablaamorti));
			TasaLogic tasaLogic= new TasaLogic(connexion);
			tasaLogic.deepLoad(tablaamorti.getTasa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Factura.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			tablaamorti.setFactura(tablaamortiDataAccess.getFactura(connexion,tablaamorti));
			FacturaLogic facturaLogic= new FacturaLogic(connexion);
			facturaLogic.deepLoad(tablaamorti.getFactura(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Anio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			tablaamorti.setAnio(tablaamortiDataAccess.getAnio(connexion,tablaamorti));
			AnioLogic anioLogic= new AnioLogic(connexion);
			anioLogic.deepLoad(tablaamorti.getAnio(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Mes.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			tablaamorti.setMes(tablaamortiDataAccess.getMes(connexion,tablaamorti));
			MesLogic mesLogic= new MesLogic(connexion);
			mesLogic.deepLoad(tablaamorti.getMes(),isDeep,deepLoadType,clases);
				
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(DetalleTablaAmorti.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(DetalleTablaAmorti.class));
			tablaamorti.setDetalleTablaAmortis(tablaamortiDataAccess.getDetalleTablaAmortis(connexion,tablaamorti));

			for(DetalleTablaAmorti detalletablaamorti:tablaamorti.getDetalleTablaAmortis()) {
				DetalleTablaAmortiLogic detalletablaamortiLogic= new DetalleTablaAmortiLogic(connexion);
				detalletablaamortiLogic.deepLoad(detalletablaamorti,isDeep,deepLoadType,clases);
			}
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(TablaAmorti tablaamorti,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			TablaAmortiLogicAdditional.updateTablaAmortiToSave(tablaamorti,this.arrDatoGeneral);
			
TablaAmortiDataAccess.save(tablaamorti, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(tablaamorti.getEmpresa(),connexion);

		SucursalDataAccess.save(tablaamorti.getSucursal(),connexion);

		EjercicioDataAccess.save(tablaamorti.getEjercicio(),connexion);

		PeriodoDataAccess.save(tablaamorti.getPeriodo(),connexion);

		TasaDataAccess.save(tablaamorti.getTasa(),connexion);

		FacturaDataAccess.save(tablaamorti.getFactura(),connexion);

		AnioDataAccess.save(tablaamorti.getAnio(),connexion);

		MesDataAccess.save(tablaamorti.getMes(),connexion);

		for(DetalleTablaAmorti detalletablaamorti:tablaamorti.getDetalleTablaAmortis()) {
			detalletablaamorti.setid_tabla_amorti(tablaamorti.getId());
			DetalleTablaAmortiDataAccess.save(detalletablaamorti,connexion);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(tablaamorti.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(tablaamorti.getSucursal(),connexion);
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				EjercicioDataAccess.save(tablaamorti.getEjercicio(),connexion);
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				PeriodoDataAccess.save(tablaamorti.getPeriodo(),connexion);
				continue;
			}

			if(clas.clas.equals(Tasa.class)) {
				TasaDataAccess.save(tablaamorti.getTasa(),connexion);
				continue;
			}

			if(clas.clas.equals(Factura.class)) {
				FacturaDataAccess.save(tablaamorti.getFactura(),connexion);
				continue;
			}

			if(clas.clas.equals(Anio.class)) {
				AnioDataAccess.save(tablaamorti.getAnio(),connexion);
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				MesDataAccess.save(tablaamorti.getMes(),connexion);
				continue;
			}


			if(clas.clas.equals(DetalleTablaAmorti.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(DetalleTablaAmorti detalletablaamorti:tablaamorti.getDetalleTablaAmortis()) {
					detalletablaamorti.setid_tabla_amorti(tablaamorti.getId());
					DetalleTablaAmortiDataAccess.save(detalletablaamorti,connexion);
				}
				continue;
			}
		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(tablaamorti.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(tablaamorti.getEmpresa(),isDeep,deepLoadType,clases);
				

		SucursalDataAccess.save(tablaamorti.getSucursal(),connexion);
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(tablaamorti.getSucursal(),isDeep,deepLoadType,clases);
				

		EjercicioDataAccess.save(tablaamorti.getEjercicio(),connexion);
		EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
		ejercicioLogic.deepLoad(tablaamorti.getEjercicio(),isDeep,deepLoadType,clases);
				

		PeriodoDataAccess.save(tablaamorti.getPeriodo(),connexion);
		PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
		periodoLogic.deepLoad(tablaamorti.getPeriodo(),isDeep,deepLoadType,clases);
				

		TasaDataAccess.save(tablaamorti.getTasa(),connexion);
		TasaLogic tasaLogic= new TasaLogic(connexion);
		tasaLogic.deepLoad(tablaamorti.getTasa(),isDeep,deepLoadType,clases);
				

		FacturaDataAccess.save(tablaamorti.getFactura(),connexion);
		FacturaLogic facturaLogic= new FacturaLogic(connexion);
		facturaLogic.deepLoad(tablaamorti.getFactura(),isDeep,deepLoadType,clases);
				

		AnioDataAccess.save(tablaamorti.getAnio(),connexion);
		AnioLogic anioLogic= new AnioLogic(connexion);
		anioLogic.deepLoad(tablaamorti.getAnio(),isDeep,deepLoadType,clases);
				

		MesDataAccess.save(tablaamorti.getMes(),connexion);
		MesLogic mesLogic= new MesLogic(connexion);
		mesLogic.deepLoad(tablaamorti.getMes(),isDeep,deepLoadType,clases);
				

		for(DetalleTablaAmorti detalletablaamorti:tablaamorti.getDetalleTablaAmortis()) {
			DetalleTablaAmortiLogic detalletablaamortiLogic= new DetalleTablaAmortiLogic(connexion);
			detalletablaamorti.setid_tabla_amorti(tablaamorti.getId());
			DetalleTablaAmortiDataAccess.save(detalletablaamorti,connexion);
			detalletablaamortiLogic.deepSave(detalletablaamorti,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(tablaamorti.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(tablaamorti.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(tablaamorti.getSucursal(),connexion);
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepSave(tablaamorti.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				EjercicioDataAccess.save(tablaamorti.getEjercicio(),connexion);
				EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
				ejercicioLogic.deepSave(tablaamorti.getEjercicio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				PeriodoDataAccess.save(tablaamorti.getPeriodo(),connexion);
				PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
				periodoLogic.deepSave(tablaamorti.getPeriodo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Tasa.class)) {
				TasaDataAccess.save(tablaamorti.getTasa(),connexion);
				TasaLogic tasaLogic= new TasaLogic(connexion);
				tasaLogic.deepSave(tablaamorti.getTasa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Factura.class)) {
				FacturaDataAccess.save(tablaamorti.getFactura(),connexion);
				FacturaLogic facturaLogic= new FacturaLogic(connexion);
				facturaLogic.deepSave(tablaamorti.getFactura(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Anio.class)) {
				AnioDataAccess.save(tablaamorti.getAnio(),connexion);
				AnioLogic anioLogic= new AnioLogic(connexion);
				anioLogic.deepSave(tablaamorti.getAnio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				MesDataAccess.save(tablaamorti.getMes(),connexion);
				MesLogic mesLogic= new MesLogic(connexion);
				mesLogic.deepSave(tablaamorti.getMes(),isDeep,deepLoadType,clases);				
				continue;
			}


			if(clas.clas.equals(DetalleTablaAmorti.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(DetalleTablaAmorti detalletablaamorti:tablaamorti.getDetalleTablaAmortis()) {
					DetalleTablaAmortiLogic detalletablaamortiLogic= new DetalleTablaAmortiLogic(connexion);
					detalletablaamorti.setid_tabla_amorti(tablaamorti.getId());
					DetalleTablaAmortiDataAccess.save(detalletablaamorti,connexion);
					detalletablaamortiLogic.deepSave(detalletablaamorti,isDeep,deepLoadType,clases);
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
			this.getNewConnexionToDeep(TablaAmorti.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(tablaamorti,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				TablaAmortiConstantesFunciones.refrescarForeignKeysDescripcionesTablaAmorti(tablaamorti);
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
			this.deepLoad(this.tablaamorti,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				TablaAmortiConstantesFunciones.refrescarForeignKeysDescripcionesTablaAmorti(this.tablaamorti);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(TablaAmorti.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(tablaamortis!=null) {
				for(TablaAmorti tablaamorti:tablaamortis) {
					this.deepLoad(tablaamorti,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					TablaAmortiConstantesFunciones.refrescarForeignKeysDescripcionesTablaAmorti(tablaamortis);
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
			if(tablaamortis!=null) {
				for(TablaAmorti tablaamorti:tablaamortis) {
					this.deepLoad(tablaamorti,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					TablaAmortiConstantesFunciones.refrescarForeignKeysDescripcionesTablaAmorti(tablaamortis);
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
			this.getNewConnexionToDeep(TablaAmorti.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(tablaamorti,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(TablaAmorti.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(tablaamortis!=null) {
				for(TablaAmorti tablaamorti:tablaamortis) {
					this.deepSave(tablaamorti,isDeep,deepLoadType,clases);
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
			if(tablaamortis!=null) {
				for(TablaAmorti tablaamorti:tablaamortis) {
					this.deepSave(tablaamorti,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getTablaAmortisFK_IdAnioWithConnection(String sFinalQuery,Pagination pagination,Long id_anio)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TablaAmorti.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidAnio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidAnio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_anio,TablaAmortiConstantesFunciones.IDANIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidAnio);

			TablaAmortiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdAnio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tablaamortis=tablaamortiDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TablaAmortiConstantesFunciones.refrescarForeignKeysDescripcionesTablaAmorti(this.tablaamortis);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTablaAmortisFK_IdAnio(String sFinalQuery,Pagination pagination,Long id_anio)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidAnio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidAnio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_anio,TablaAmortiConstantesFunciones.IDANIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidAnio);

			TablaAmortiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdAnio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tablaamortis=tablaamortiDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TablaAmortiConstantesFunciones.refrescarForeignKeysDescripcionesTablaAmorti(this.tablaamortis);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getTablaAmortisFK_IdEjercicioWithConnection(String sFinalQuery,Pagination pagination,Long id_ejercicio)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TablaAmorti.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEjercicio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEjercicio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_ejercicio,TablaAmortiConstantesFunciones.IDEJERCICIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEjercicio);

			TablaAmortiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEjercicio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tablaamortis=tablaamortiDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TablaAmortiConstantesFunciones.refrescarForeignKeysDescripcionesTablaAmorti(this.tablaamortis);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTablaAmortisFK_IdEjercicio(String sFinalQuery,Pagination pagination,Long id_ejercicio)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEjercicio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEjercicio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_ejercicio,TablaAmortiConstantesFunciones.IDEJERCICIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEjercicio);

			TablaAmortiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEjercicio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tablaamortis=tablaamortiDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TablaAmortiConstantesFunciones.refrescarForeignKeysDescripcionesTablaAmorti(this.tablaamortis);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getTablaAmortisFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TablaAmorti.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,TablaAmortiConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			TablaAmortiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tablaamortis=tablaamortiDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TablaAmortiConstantesFunciones.refrescarForeignKeysDescripcionesTablaAmorti(this.tablaamortis);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTablaAmortisFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,TablaAmortiConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			TablaAmortiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tablaamortis=tablaamortiDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TablaAmortiConstantesFunciones.refrescarForeignKeysDescripcionesTablaAmorti(this.tablaamortis);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getTablaAmortisFK_IdFacturaWithConnection(String sFinalQuery,Pagination pagination,Long id_factura)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TablaAmorti.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidFactura= new ParameterSelectionGeneral();
			parameterSelectionGeneralidFactura.setParameterSelectionGeneralEqual(ParameterType.LONG,id_factura,TablaAmortiConstantesFunciones.IDFACTURA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidFactura);

			TablaAmortiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdFactura","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tablaamortis=tablaamortiDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TablaAmortiConstantesFunciones.refrescarForeignKeysDescripcionesTablaAmorti(this.tablaamortis);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTablaAmortisFK_IdFactura(String sFinalQuery,Pagination pagination,Long id_factura)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidFactura= new ParameterSelectionGeneral();
			parameterSelectionGeneralidFactura.setParameterSelectionGeneralEqual(ParameterType.LONG,id_factura,TablaAmortiConstantesFunciones.IDFACTURA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidFactura);

			TablaAmortiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdFactura","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tablaamortis=tablaamortiDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TablaAmortiConstantesFunciones.refrescarForeignKeysDescripcionesTablaAmorti(this.tablaamortis);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getTablaAmortisFK_IdMesWithConnection(String sFinalQuery,Pagination pagination,Long id_mes)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TablaAmorti.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidMes= new ParameterSelectionGeneral();
			parameterSelectionGeneralidMes.setParameterSelectionGeneralEqual(ParameterType.LONG,id_mes,TablaAmortiConstantesFunciones.IDMES,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidMes);

			TablaAmortiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdMes","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tablaamortis=tablaamortiDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TablaAmortiConstantesFunciones.refrescarForeignKeysDescripcionesTablaAmorti(this.tablaamortis);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTablaAmortisFK_IdMes(String sFinalQuery,Pagination pagination,Long id_mes)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidMes= new ParameterSelectionGeneral();
			parameterSelectionGeneralidMes.setParameterSelectionGeneralEqual(ParameterType.LONG,id_mes,TablaAmortiConstantesFunciones.IDMES,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidMes);

			TablaAmortiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdMes","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tablaamortis=tablaamortiDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TablaAmortiConstantesFunciones.refrescarForeignKeysDescripcionesTablaAmorti(this.tablaamortis);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getTablaAmortisFK_IdPeriodoWithConnection(String sFinalQuery,Pagination pagination,Long id_periodo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TablaAmorti.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPeriodo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPeriodo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_periodo,TablaAmortiConstantesFunciones.IDPERIODO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPeriodo);

			TablaAmortiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPeriodo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tablaamortis=tablaamortiDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TablaAmortiConstantesFunciones.refrescarForeignKeysDescripcionesTablaAmorti(this.tablaamortis);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTablaAmortisFK_IdPeriodo(String sFinalQuery,Pagination pagination,Long id_periodo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPeriodo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPeriodo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_periodo,TablaAmortiConstantesFunciones.IDPERIODO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPeriodo);

			TablaAmortiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPeriodo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tablaamortis=tablaamortiDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TablaAmortiConstantesFunciones.refrescarForeignKeysDescripcionesTablaAmorti(this.tablaamortis);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getTablaAmortisFK_IdSucursalWithConnection(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TablaAmorti.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,TablaAmortiConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			TablaAmortiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tablaamortis=tablaamortiDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TablaAmortiConstantesFunciones.refrescarForeignKeysDescripcionesTablaAmorti(this.tablaamortis);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTablaAmortisFK_IdSucursal(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,TablaAmortiConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			TablaAmortiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tablaamortis=tablaamortiDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TablaAmortiConstantesFunciones.refrescarForeignKeysDescripcionesTablaAmorti(this.tablaamortis);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getTablaAmortisFK_IdTasaWithConnection(String sFinalQuery,Pagination pagination,Long id_tasa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TablaAmorti.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTasa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTasa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tasa,TablaAmortiConstantesFunciones.IDTASA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTasa);

			TablaAmortiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTasa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tablaamortis=tablaamortiDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TablaAmortiConstantesFunciones.refrescarForeignKeysDescripcionesTablaAmorti(this.tablaamortis);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTablaAmortisFK_IdTasa(String sFinalQuery,Pagination pagination,Long id_tasa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTasa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTasa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tasa,TablaAmortiConstantesFunciones.IDTASA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTasa);

			TablaAmortiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTasa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tablaamortis=tablaamortiDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TablaAmortiConstantesFunciones.refrescarForeignKeysDescripcionesTablaAmorti(this.tablaamortis);
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
			if(TablaAmortiConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,TablaAmortiDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,TablaAmorti tablaamorti,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(TablaAmortiConstantesFunciones.ISCONAUDITORIA) {
				if(tablaamorti.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TablaAmortiDataAccess.TABLENAME, tablaamorti.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(TablaAmortiConstantesFunciones.ISCONAUDITORIADETALLE) {
						////TablaAmortiLogic.registrarAuditoriaDetallesTablaAmorti(connexion,tablaamorti,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(tablaamorti.getIsDeleted()) {
					/*if(!tablaamorti.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,TablaAmortiDataAccess.TABLENAME, tablaamorti.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////TablaAmortiLogic.registrarAuditoriaDetallesTablaAmorti(connexion,tablaamorti,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TablaAmortiDataAccess.TABLENAME, tablaamorti.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(tablaamorti.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TablaAmortiDataAccess.TABLENAME, tablaamorti.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(TablaAmortiConstantesFunciones.ISCONAUDITORIADETALLE) {
						////TablaAmortiLogic.registrarAuditoriaDetallesTablaAmorti(connexion,tablaamorti,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesTablaAmorti(Connexion connexion,TablaAmorti tablaamorti)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(tablaamorti.getIsNew()||!tablaamorti.getid_empresa().equals(tablaamorti.getTablaAmortiOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tablaamorti.getTablaAmortiOriginal().getid_empresa()!=null)
				{
					strValorActual=tablaamorti.getTablaAmortiOriginal().getid_empresa().toString();
				}
				if(tablaamorti.getid_empresa()!=null)
				{
					strValorNuevo=tablaamorti.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TablaAmortiConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(tablaamorti.getIsNew()||!tablaamorti.getid_sucursal().equals(tablaamorti.getTablaAmortiOriginal().getid_sucursal()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tablaamorti.getTablaAmortiOriginal().getid_sucursal()!=null)
				{
					strValorActual=tablaamorti.getTablaAmortiOriginal().getid_sucursal().toString();
				}
				if(tablaamorti.getid_sucursal()!=null)
				{
					strValorNuevo=tablaamorti.getid_sucursal().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TablaAmortiConstantesFunciones.IDSUCURSAL,strValorActual,strValorNuevo);
			}	
			
			if(tablaamorti.getIsNew()||!tablaamorti.getid_ejercicio().equals(tablaamorti.getTablaAmortiOriginal().getid_ejercicio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tablaamorti.getTablaAmortiOriginal().getid_ejercicio()!=null)
				{
					strValorActual=tablaamorti.getTablaAmortiOriginal().getid_ejercicio().toString();
				}
				if(tablaamorti.getid_ejercicio()!=null)
				{
					strValorNuevo=tablaamorti.getid_ejercicio().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TablaAmortiConstantesFunciones.IDEJERCICIO,strValorActual,strValorNuevo);
			}	
			
			if(tablaamorti.getIsNew()||!tablaamorti.getid_periodo().equals(tablaamorti.getTablaAmortiOriginal().getid_periodo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tablaamorti.getTablaAmortiOriginal().getid_periodo()!=null)
				{
					strValorActual=tablaamorti.getTablaAmortiOriginal().getid_periodo().toString();
				}
				if(tablaamorti.getid_periodo()!=null)
				{
					strValorNuevo=tablaamorti.getid_periodo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TablaAmortiConstantesFunciones.IDPERIODO,strValorActual,strValorNuevo);
			}	
			
			if(tablaamorti.getIsNew()||!tablaamorti.getid_tasa().equals(tablaamorti.getTablaAmortiOriginal().getid_tasa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tablaamorti.getTablaAmortiOriginal().getid_tasa()!=null)
				{
					strValorActual=tablaamorti.getTablaAmortiOriginal().getid_tasa().toString();
				}
				if(tablaamorti.getid_tasa()!=null)
				{
					strValorNuevo=tablaamorti.getid_tasa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TablaAmortiConstantesFunciones.IDTASA,strValorActual,strValorNuevo);
			}	
			
			if(tablaamorti.getIsNew()||!tablaamorti.getid_factura().equals(tablaamorti.getTablaAmortiOriginal().getid_factura()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tablaamorti.getTablaAmortiOriginal().getid_factura()!=null)
				{
					strValorActual=tablaamorti.getTablaAmortiOriginal().getid_factura().toString();
				}
				if(tablaamorti.getid_factura()!=null)
				{
					strValorNuevo=tablaamorti.getid_factura().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TablaAmortiConstantesFunciones.IDFACTURA,strValorActual,strValorNuevo);
			}	
			
			if(tablaamorti.getIsNew()||!tablaamorti.getfecha_emision().equals(tablaamorti.getTablaAmortiOriginal().getfecha_emision()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tablaamorti.getTablaAmortiOriginal().getfecha_emision()!=null)
				{
					strValorActual=tablaamorti.getTablaAmortiOriginal().getfecha_emision().toString();
				}
				if(tablaamorti.getfecha_emision()!=null)
				{
					strValorNuevo=tablaamorti.getfecha_emision().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TablaAmortiConstantesFunciones.FECHAEMISION,strValorActual,strValorNuevo);
			}	
			
			if(tablaamorti.getIsNew()||!tablaamorti.getfecha_vencimiento().equals(tablaamorti.getTablaAmortiOriginal().getfecha_vencimiento()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tablaamorti.getTablaAmortiOriginal().getfecha_vencimiento()!=null)
				{
					strValorActual=tablaamorti.getTablaAmortiOriginal().getfecha_vencimiento().toString();
				}
				if(tablaamorti.getfecha_vencimiento()!=null)
				{
					strValorNuevo=tablaamorti.getfecha_vencimiento().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TablaAmortiConstantesFunciones.FECHAVENCIMIENTO,strValorActual,strValorNuevo);
			}	
			
			if(tablaamorti.getIsNew()||!tablaamorti.getvalor_prestamo().equals(tablaamorti.getTablaAmortiOriginal().getvalor_prestamo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tablaamorti.getTablaAmortiOriginal().getvalor_prestamo()!=null)
				{
					strValorActual=tablaamorti.getTablaAmortiOriginal().getvalor_prestamo().toString();
				}
				if(tablaamorti.getvalor_prestamo()!=null)
				{
					strValorNuevo=tablaamorti.getvalor_prestamo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TablaAmortiConstantesFunciones.VALORPRESTAMO,strValorActual,strValorNuevo);
			}	
			
			if(tablaamorti.getIsNew()||!tablaamorti.getnumero_cuotas().equals(tablaamorti.getTablaAmortiOriginal().getnumero_cuotas()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tablaamorti.getTablaAmortiOriginal().getnumero_cuotas()!=null)
				{
					strValorActual=tablaamorti.getTablaAmortiOriginal().getnumero_cuotas().toString();
				}
				if(tablaamorti.getnumero_cuotas()!=null)
				{
					strValorNuevo=tablaamorti.getnumero_cuotas().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TablaAmortiConstantesFunciones.NUMEROCUOTAS,strValorActual,strValorNuevo);
			}	
			
			if(tablaamorti.getIsNew()||!tablaamorti.getid_anio().equals(tablaamorti.getTablaAmortiOriginal().getid_anio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tablaamorti.getTablaAmortiOriginal().getid_anio()!=null)
				{
					strValorActual=tablaamorti.getTablaAmortiOriginal().getid_anio().toString();
				}
				if(tablaamorti.getid_anio()!=null)
				{
					strValorNuevo=tablaamorti.getid_anio().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TablaAmortiConstantesFunciones.IDANIO,strValorActual,strValorNuevo);
			}	
			
			if(tablaamorti.getIsNew()||!tablaamorti.getid_mes().equals(tablaamorti.getTablaAmortiOriginal().getid_mes()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tablaamorti.getTablaAmortiOriginal().getid_mes()!=null)
				{
					strValorActual=tablaamorti.getTablaAmortiOriginal().getid_mes().toString();
				}
				if(tablaamorti.getid_mes()!=null)
				{
					strValorNuevo=tablaamorti.getid_mes().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TablaAmortiConstantesFunciones.IDMES,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveTablaAmortiRelacionesWithConnection(TablaAmorti tablaamorti,List<DetalleTablaAmorti> detalletablaamortis) throws Exception {

		if(!tablaamorti.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveTablaAmortiRelacionesBase(tablaamorti,detalletablaamortis,true);
		}
	}

	public void saveTablaAmortiRelaciones(TablaAmorti tablaamorti,List<DetalleTablaAmorti> detalletablaamortis)throws Exception {

		if(!tablaamorti.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveTablaAmortiRelacionesBase(tablaamorti,detalletablaamortis,false);
		}
	}

	public void saveTablaAmortiRelacionesBase(TablaAmorti tablaamorti,List<DetalleTablaAmorti> detalletablaamortis,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("TablaAmorti-saveRelacionesWithConnection");}
	
			tablaamorti.setDetalleTablaAmortis(detalletablaamortis);

			this.setTablaAmorti(tablaamorti);

			if(TablaAmortiLogicAdditional.validarSaveRelaciones(tablaamorti,this)) {

				TablaAmortiLogicAdditional.updateRelacionesToSave(tablaamorti,this);

				if((tablaamorti.getIsNew()||tablaamorti.getIsChanged())&&!tablaamorti.getIsDeleted()) {
					this.saveTablaAmorti();
					this.saveTablaAmortiRelacionesDetalles(detalletablaamortis);

				} else if(tablaamorti.getIsDeleted()) {
					this.saveTablaAmortiRelacionesDetalles(detalletablaamortis);
					this.saveTablaAmorti();
				}

				TablaAmortiLogicAdditional.updateRelacionesToSaveAfter(tablaamorti,this);

			} else {
				throw new Exception("LOS DATOS SON INVALIDOS");
			}

			if(conConexion) {connexion.commit();}

		} catch(Exception e) {
			
			DetalleTablaAmortiConstantesFunciones.InicializarGeneralEntityAuxiliaresDetalleTablaAmortis(detalletablaamortis,true,true);

			if(conConexion){connexion.rollback();}
			Funciones.manageException(logger,e);
			throw e;

		} finally {
			if(conConexion){this.closeNewConnexionToDeep();}
		}
	}
	
	
	private void saveTablaAmortiRelacionesDetalles(List<DetalleTablaAmorti> detalletablaamortis)throws Exception {
		try {
	

			Long idTablaAmortiActual=this.getTablaAmorti().getId();

			DetalleTablaAmortiLogic detalletablaamortiLogic_Desde_TablaAmorti=new DetalleTablaAmortiLogic();
			detalletablaamortiLogic_Desde_TablaAmorti.setDetalleTablaAmortis(detalletablaamortis);

			detalletablaamortiLogic_Desde_TablaAmorti.setConnexion(this.getConnexion());
			detalletablaamortiLogic_Desde_TablaAmorti.setDatosCliente(this.datosCliente);

			for(DetalleTablaAmorti detalletablaamorti_Desde_TablaAmorti:detalletablaamortiLogic_Desde_TablaAmorti.getDetalleTablaAmortis()) {
				detalletablaamorti_Desde_TablaAmorti.setid_tabla_amorti(idTablaAmortiActual);
			}

			detalletablaamortiLogic_Desde_TablaAmorti.saveDetalleTablaAmortis();

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfTablaAmorti(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=TablaAmortiConstantesFunciones.getClassesForeignKeysOfTablaAmorti(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTablaAmorti(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=TablaAmortiConstantesFunciones.getClassesRelationshipsOfTablaAmorti(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

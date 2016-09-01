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
import com.bydan.erp.facturacion.util.TablaAmortiDetalleConstantesFunciones;
import com.bydan.erp.facturacion.util.TablaAmortiDetalleParameterReturnGeneral;
//import com.bydan.erp.facturacion.util.TablaAmortiDetalleParameterGeneral;
import com.bydan.erp.facturacion.business.entity.TablaAmortiDetalle;
import com.bydan.erp.facturacion.business.logic.TablaAmortiDetalleLogicAdditional;
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
public class TablaAmortiDetalleLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(TablaAmortiDetalleLogic.class);
	
	protected TablaAmortiDetalleDataAccess tablaamortidetalleDataAccess; 	
	protected TablaAmortiDetalle tablaamortidetalle;
	protected List<TablaAmortiDetalle> tablaamortidetalles;
	protected Object tablaamortidetalleObject;	
	protected List<Object> tablaamortidetallesObject;
	
	public static ClassValidator<TablaAmortiDetalle> tablaamortidetalleValidator = new ClassValidator<TablaAmortiDetalle>(TablaAmortiDetalle.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected TablaAmortiDetalleLogicAdditional tablaamortidetalleLogicAdditional=null;
	
	public TablaAmortiDetalleLogicAdditional getTablaAmortiDetalleLogicAdditional() {
		return this.tablaamortidetalleLogicAdditional;
	}
	
	public void setTablaAmortiDetalleLogicAdditional(TablaAmortiDetalleLogicAdditional tablaamortidetalleLogicAdditional) {
		try {
			this.tablaamortidetalleLogicAdditional=tablaamortidetalleLogicAdditional;
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
	
	
	
	
	public  TablaAmortiDetalleLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.tablaamortidetalleDataAccess = new TablaAmortiDetalleDataAccess();
			
			this.tablaamortidetalles= new ArrayList<TablaAmortiDetalle>();
			this.tablaamortidetalle= new TablaAmortiDetalle();
			
			this.tablaamortidetalleObject=new Object();
			this.tablaamortidetallesObject=new ArrayList<Object>();
				
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
			
			this.tablaamortidetalleDataAccess.setConnexionType(this.connexionType);
			this.tablaamortidetalleDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  TablaAmortiDetalleLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.tablaamortidetalleDataAccess = new TablaAmortiDetalleDataAccess();
			this.tablaamortidetalles= new ArrayList<TablaAmortiDetalle>();
			this.tablaamortidetalle= new TablaAmortiDetalle();
			this.tablaamortidetalleObject=new Object();
			this.tablaamortidetallesObject=new ArrayList<Object>();
			
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
			
			this.tablaamortidetalleDataAccess.setConnexionType(this.connexionType);
			this.tablaamortidetalleDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public TablaAmortiDetalle getTablaAmortiDetalle() throws Exception {	
		TablaAmortiDetalleLogicAdditional.checkTablaAmortiDetalleToGet(tablaamortidetalle,this.datosCliente,this.arrDatoGeneral);
		TablaAmortiDetalleLogicAdditional.updateTablaAmortiDetalleToGet(tablaamortidetalle,this.arrDatoGeneral);
		
		return tablaamortidetalle;
	}
		
	public void setTablaAmortiDetalle(TablaAmortiDetalle newTablaAmortiDetalle) {
		this.tablaamortidetalle = newTablaAmortiDetalle;
	}
	
	public TablaAmortiDetalleDataAccess getTablaAmortiDetalleDataAccess() {
		return tablaamortidetalleDataAccess;
	}
	
	public void setTablaAmortiDetalleDataAccess(TablaAmortiDetalleDataAccess newtablaamortidetalleDataAccess) {
		this.tablaamortidetalleDataAccess = newtablaamortidetalleDataAccess;
	}
	
	public List<TablaAmortiDetalle> getTablaAmortiDetalles() throws Exception {		
		this.quitarTablaAmortiDetallesNulos();
		
		TablaAmortiDetalleLogicAdditional.checkTablaAmortiDetalleToGets(tablaamortidetalles,this.datosCliente,this.arrDatoGeneral);
		
		for (TablaAmortiDetalle tablaamortidetalleLocal: tablaamortidetalles ) {
			TablaAmortiDetalleLogicAdditional.updateTablaAmortiDetalleToGet(tablaamortidetalleLocal,this.arrDatoGeneral);
		}
		
		return tablaamortidetalles;
	}
	
	public void setTablaAmortiDetalles(List<TablaAmortiDetalle> newTablaAmortiDetalles) {
		this.tablaamortidetalles = newTablaAmortiDetalles;
	}
	
	public Object getTablaAmortiDetalleObject() {	
		this.tablaamortidetalleObject=this.tablaamortidetalleDataAccess.getEntityObject();
		return this.tablaamortidetalleObject;
	}
		
	public void setTablaAmortiDetalleObject(Object newTablaAmortiDetalleObject) {
		this.tablaamortidetalleObject = newTablaAmortiDetalleObject;
	}
	
	public List<Object> getTablaAmortiDetallesObject() {		
		this.tablaamortidetallesObject=this.tablaamortidetalleDataAccess.getEntitiesObject();
		return this.tablaamortidetallesObject;
	}
		
	public void setTablaAmortiDetallesObject(List<Object> newTablaAmortiDetallesObject) {
		this.tablaamortidetallesObject = newTablaAmortiDetallesObject;
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
		
		if(this.tablaamortidetalleDataAccess!=null) {
			this.tablaamortidetalleDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TablaAmortiDetalle.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			tablaamortidetalleDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			tablaamortidetalleDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		tablaamortidetalle = new  TablaAmortiDetalle();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TablaAmortiDetalle.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			tablaamortidetalle=tablaamortidetalleDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tablaamortidetalle,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TablaAmortiDetalleConstantesFunciones.refrescarForeignKeysDescripcionesTablaAmortiDetalle(this.tablaamortidetalle);
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
		tablaamortidetalle = new  TablaAmortiDetalle();
		  		  
        try {
			
			tablaamortidetalle=tablaamortidetalleDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tablaamortidetalle,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TablaAmortiDetalleConstantesFunciones.refrescarForeignKeysDescripcionesTablaAmortiDetalle(this.tablaamortidetalle);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		tablaamortidetalle = new  TablaAmortiDetalle();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TablaAmortiDetalle.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			tablaamortidetalle=tablaamortidetalleDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tablaamortidetalle,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TablaAmortiDetalleConstantesFunciones.refrescarForeignKeysDescripcionesTablaAmortiDetalle(this.tablaamortidetalle);
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
		tablaamortidetalle = new  TablaAmortiDetalle();
		  		  
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
		tablaamortidetalle = new  TablaAmortiDetalle();
		  		  
        try {
			
			tablaamortidetalle=tablaamortidetalleDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tablaamortidetalle,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TablaAmortiDetalleConstantesFunciones.refrescarForeignKeysDescripcionesTablaAmortiDetalle(this.tablaamortidetalle);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		tablaamortidetalle = new  TablaAmortiDetalle();
		  		  
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
		tablaamortidetalle = new  TablaAmortiDetalle();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TablaAmortiDetalle.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =tablaamortidetalleDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tablaamortidetalle = new  TablaAmortiDetalle();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=tablaamortidetalleDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		tablaamortidetalle = new  TablaAmortiDetalle();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TablaAmortiDetalle.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =tablaamortidetalleDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tablaamortidetalle = new  TablaAmortiDetalle();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=tablaamortidetalleDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		tablaamortidetalle = new  TablaAmortiDetalle();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TablaAmortiDetalle.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =tablaamortidetalleDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tablaamortidetalle = new  TablaAmortiDetalle();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=tablaamortidetalleDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		tablaamortidetalles = new  ArrayList<TablaAmortiDetalle>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TablaAmortiDetalle.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			TablaAmortiDetalleLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tablaamortidetalles=tablaamortidetalleDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTablaAmortiDetalle(tablaamortidetalles);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TablaAmortiDetalleConstantesFunciones.refrescarForeignKeysDescripcionesTablaAmortiDetalle(this.tablaamortidetalles);
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
		tablaamortidetalles = new  ArrayList<TablaAmortiDetalle>();
		  		  
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
		tablaamortidetalles = new  ArrayList<TablaAmortiDetalle>();
		  		  
        try {			
			TablaAmortiDetalleLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tablaamortidetalles=tablaamortidetalleDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarTablaAmortiDetalle(tablaamortidetalles);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TablaAmortiDetalleConstantesFunciones.refrescarForeignKeysDescripcionesTablaAmortiDetalle(this.tablaamortidetalles);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		tablaamortidetalles = new  ArrayList<TablaAmortiDetalle>();
		  		  
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
		tablaamortidetalles = new  ArrayList<TablaAmortiDetalle>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TablaAmortiDetalle.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			TablaAmortiDetalleLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tablaamortidetalles=tablaamortidetalleDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTablaAmortiDetalle(tablaamortidetalles);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TablaAmortiDetalleConstantesFunciones.refrescarForeignKeysDescripcionesTablaAmortiDetalle(this.tablaamortidetalles);
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
		tablaamortidetalles = new  ArrayList<TablaAmortiDetalle>();
		  		  
        try {
			TablaAmortiDetalleLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tablaamortidetalles=tablaamortidetalleDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTablaAmortiDetalle(tablaamortidetalles);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TablaAmortiDetalleConstantesFunciones.refrescarForeignKeysDescripcionesTablaAmortiDetalle(this.tablaamortidetalles);
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
		tablaamortidetalles = new  ArrayList<TablaAmortiDetalle>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TablaAmortiDetalle.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TablaAmortiDetalleLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tablaamortidetalles=tablaamortidetalleDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTablaAmortiDetalle(tablaamortidetalles);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TablaAmortiDetalleConstantesFunciones.refrescarForeignKeysDescripcionesTablaAmortiDetalle(this.tablaamortidetalles);
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
		tablaamortidetalles = new  ArrayList<TablaAmortiDetalle>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TablaAmortiDetalleLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tablaamortidetalles=tablaamortidetalleDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTablaAmortiDetalle(tablaamortidetalles);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TablaAmortiDetalleConstantesFunciones.refrescarForeignKeysDescripcionesTablaAmortiDetalle(this.tablaamortidetalles);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		tablaamortidetalle = new  TablaAmortiDetalle();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TablaAmortiDetalle.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TablaAmortiDetalleLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tablaamortidetalle=tablaamortidetalleDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTablaAmortiDetalle(tablaamortidetalle);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TablaAmortiDetalleConstantesFunciones.refrescarForeignKeysDescripcionesTablaAmortiDetalle(this.tablaamortidetalle);
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
		tablaamortidetalle = new  TablaAmortiDetalle();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TablaAmortiDetalleLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tablaamortidetalle=tablaamortidetalleDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTablaAmortiDetalle(tablaamortidetalle);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TablaAmortiDetalleConstantesFunciones.refrescarForeignKeysDescripcionesTablaAmortiDetalle(this.tablaamortidetalle);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		tablaamortidetalles = new  ArrayList<TablaAmortiDetalle>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TablaAmortiDetalle.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			TablaAmortiDetalleLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tablaamortidetalles=tablaamortidetalleDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTablaAmortiDetalle(tablaamortidetalles);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TablaAmortiDetalleConstantesFunciones.refrescarForeignKeysDescripcionesTablaAmortiDetalle(this.tablaamortidetalles);
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
		tablaamortidetalles = new  ArrayList<TablaAmortiDetalle>();
		  		  
        try {
			TablaAmortiDetalleLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tablaamortidetalles=tablaamortidetalleDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTablaAmortiDetalle(tablaamortidetalles);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TablaAmortiDetalleConstantesFunciones.refrescarForeignKeysDescripcionesTablaAmortiDetalle(this.tablaamortidetalles);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosTablaAmortiDetallesWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		tablaamortidetalles = new  ArrayList<TablaAmortiDetalle>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TablaAmortiDetalle.class.getSimpleName()+"-getTodosTablaAmortiDetallesWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TablaAmortiDetalleLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tablaamortidetalles=tablaamortidetalleDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarTablaAmortiDetalle(tablaamortidetalles);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TablaAmortiDetalleConstantesFunciones.refrescarForeignKeysDescripcionesTablaAmortiDetalle(this.tablaamortidetalles);
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
	
	public  void  getTodosTablaAmortiDetalles(String sFinalQuery,Pagination pagination)throws Exception {
		tablaamortidetalles = new  ArrayList<TablaAmortiDetalle>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TablaAmortiDetalleLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tablaamortidetalles=tablaamortidetalleDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarTablaAmortiDetalle(tablaamortidetalles);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TablaAmortiDetalleConstantesFunciones.refrescarForeignKeysDescripcionesTablaAmortiDetalle(this.tablaamortidetalles);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarTablaAmortiDetalle(TablaAmortiDetalle tablaamortidetalle) throws Exception {
		Boolean estaValidado=false;
		
		if(tablaamortidetalle.getIsNew() || tablaamortidetalle.getIsChanged()) { 
			this.invalidValues = tablaamortidetalleValidator.getInvalidValues(tablaamortidetalle);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(tablaamortidetalle);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarTablaAmortiDetalle(List<TablaAmortiDetalle> TablaAmortiDetalles) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(TablaAmortiDetalle tablaamortidetalleLocal:tablaamortidetalles) {				
			estaValidadoObjeto=this.validarGuardarTablaAmortiDetalle(tablaamortidetalleLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarTablaAmortiDetalle(List<TablaAmortiDetalle> TablaAmortiDetalles) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarTablaAmortiDetalle(tablaamortidetalles)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarTablaAmortiDetalle(TablaAmortiDetalle TablaAmortiDetalle) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarTablaAmortiDetalle(tablaamortidetalle)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(TablaAmortiDetalle tablaamortidetalle) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+tablaamortidetalle.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=TablaAmortiDetalleConstantesFunciones.getTablaAmortiDetalleLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"tablaamortidetalle","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(TablaAmortiDetalleConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(TablaAmortiDetalleConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveTablaAmortiDetalleWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TablaAmortiDetalle.class.getSimpleName()+"-saveTablaAmortiDetalleWithConnection");connexion.begin();			
			
			TablaAmortiDetalleLogicAdditional.checkTablaAmortiDetalleToSave(this.tablaamortidetalle,this.datosCliente,connexion,this.arrDatoGeneral);
			
			TablaAmortiDetalleLogicAdditional.updateTablaAmortiDetalleToSave(this.tablaamortidetalle,this.arrDatoGeneral);
			
			TablaAmortiDetalleLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.tablaamortidetalle,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowTablaAmortiDetalle();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarTablaAmortiDetalle(this.tablaamortidetalle)) {
				TablaAmortiDetalleDataAccess.save(this.tablaamortidetalle, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.tablaamortidetalle,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			TablaAmortiDetalleLogicAdditional.checkTablaAmortiDetalleToSaveAfter(this.tablaamortidetalle,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowTablaAmortiDetalle();
			
			connexion.commit();			
			
			if(this.tablaamortidetalle.getIsDeleted()) {
				this.tablaamortidetalle=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveTablaAmortiDetalle()throws Exception {	
		try {	
			
			TablaAmortiDetalleLogicAdditional.checkTablaAmortiDetalleToSave(this.tablaamortidetalle,this.datosCliente,connexion,this.arrDatoGeneral);
			
			TablaAmortiDetalleLogicAdditional.updateTablaAmortiDetalleToSave(this.tablaamortidetalle,this.arrDatoGeneral);
			
			TablaAmortiDetalleLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.tablaamortidetalle,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarTablaAmortiDetalle(this.tablaamortidetalle)) {			
				TablaAmortiDetalleDataAccess.save(this.tablaamortidetalle, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.tablaamortidetalle,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			TablaAmortiDetalleLogicAdditional.checkTablaAmortiDetalleToSaveAfter(this.tablaamortidetalle,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.tablaamortidetalle.getIsDeleted()) {
				this.tablaamortidetalle=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveTablaAmortiDetallesWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TablaAmortiDetalle.class.getSimpleName()+"-saveTablaAmortiDetallesWithConnection");connexion.begin();			
			
			TablaAmortiDetalleLogicAdditional.checkTablaAmortiDetalleToSaves(tablaamortidetalles,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowTablaAmortiDetalles();
			
			Boolean validadoTodosTablaAmortiDetalle=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(TablaAmortiDetalle tablaamortidetalleLocal:tablaamortidetalles) {		
				if(tablaamortidetalleLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				TablaAmortiDetalleLogicAdditional.updateTablaAmortiDetalleToSave(tablaamortidetalleLocal,this.arrDatoGeneral);
	        	
				TablaAmortiDetalleLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),tablaamortidetalleLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarTablaAmortiDetalle(tablaamortidetalleLocal)) {
					TablaAmortiDetalleDataAccess.save(tablaamortidetalleLocal, connexion);				
				} else {
					validadoTodosTablaAmortiDetalle=false;
				}
			}
			
			if(!validadoTodosTablaAmortiDetalle) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			TablaAmortiDetalleLogicAdditional.checkTablaAmortiDetalleToSavesAfter(tablaamortidetalles,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowTablaAmortiDetalles();
			
			connexion.commit();		
			
			this.quitarTablaAmortiDetallesEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveTablaAmortiDetalles()throws Exception {				
		 try {	
			TablaAmortiDetalleLogicAdditional.checkTablaAmortiDetalleToSaves(tablaamortidetalles,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosTablaAmortiDetalle=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(TablaAmortiDetalle tablaamortidetalleLocal:tablaamortidetalles) {				
				if(tablaamortidetalleLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				TablaAmortiDetalleLogicAdditional.updateTablaAmortiDetalleToSave(tablaamortidetalleLocal,this.arrDatoGeneral);
	        	
				TablaAmortiDetalleLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),tablaamortidetalleLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarTablaAmortiDetalle(tablaamortidetalleLocal)) {				
					TablaAmortiDetalleDataAccess.save(tablaamortidetalleLocal, connexion);				
				} else {
					validadoTodosTablaAmortiDetalle=false;
				}
			}
			
			if(!validadoTodosTablaAmortiDetalle) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			TablaAmortiDetalleLogicAdditional.checkTablaAmortiDetalleToSavesAfter(tablaamortidetalles,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarTablaAmortiDetallesEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public TablaAmortiDetalleParameterReturnGeneral procesarAccionTablaAmortiDetalles(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<TablaAmortiDetalle> tablaamortidetalles,TablaAmortiDetalleParameterReturnGeneral tablaamortidetalleParameterGeneral)throws Exception {
		 try {	
			TablaAmortiDetalleParameterReturnGeneral tablaamortidetalleReturnGeneral=new TablaAmortiDetalleParameterReturnGeneral();
	
			TablaAmortiDetalleLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,tablaamortidetalles,tablaamortidetalleParameterGeneral,tablaamortidetalleReturnGeneral);
			
			return tablaamortidetalleReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public TablaAmortiDetalleParameterReturnGeneral procesarAccionTablaAmortiDetallesWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<TablaAmortiDetalle> tablaamortidetalles,TablaAmortiDetalleParameterReturnGeneral tablaamortidetalleParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TablaAmortiDetalle.class.getSimpleName()+"-procesarAccionTablaAmortiDetallesWithConnection");connexion.begin();			
			
			TablaAmortiDetalleParameterReturnGeneral tablaamortidetalleReturnGeneral=new TablaAmortiDetalleParameterReturnGeneral();
	
			TablaAmortiDetalleLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,tablaamortidetalles,tablaamortidetalleParameterGeneral,tablaamortidetalleReturnGeneral);
			
			this.connexion.commit();
			
			return tablaamortidetalleReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public TablaAmortiDetalleParameterReturnGeneral procesarEventosTablaAmortiDetalles(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<TablaAmortiDetalle> tablaamortidetalles,TablaAmortiDetalle tablaamortidetalle,TablaAmortiDetalleParameterReturnGeneral tablaamortidetalleParameterGeneral,Boolean isEsNuevoTablaAmortiDetalle,ArrayList<Classe> clases)throws Exception {
		 try {	
			TablaAmortiDetalleParameterReturnGeneral tablaamortidetalleReturnGeneral=new TablaAmortiDetalleParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				tablaamortidetalleReturnGeneral.setConRecargarPropiedades(true);
			}
			
			TablaAmortiDetalleLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,tablaamortidetalles,tablaamortidetalle,tablaamortidetalleParameterGeneral,tablaamortidetalleReturnGeneral,isEsNuevoTablaAmortiDetalle,clases);
			
			return tablaamortidetalleReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public TablaAmortiDetalleParameterReturnGeneral procesarEventosTablaAmortiDetallesWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<TablaAmortiDetalle> tablaamortidetalles,TablaAmortiDetalle tablaamortidetalle,TablaAmortiDetalleParameterReturnGeneral tablaamortidetalleParameterGeneral,Boolean isEsNuevoTablaAmortiDetalle,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TablaAmortiDetalle.class.getSimpleName()+"-procesarEventosTablaAmortiDetallesWithConnection");connexion.begin();			
			
			TablaAmortiDetalleParameterReturnGeneral tablaamortidetalleReturnGeneral=new TablaAmortiDetalleParameterReturnGeneral();
	
			tablaamortidetalleReturnGeneral.setTablaAmortiDetalle(tablaamortidetalle);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				tablaamortidetalleReturnGeneral.setConRecargarPropiedades(true);
			}
			
			TablaAmortiDetalleLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,tablaamortidetalles,tablaamortidetalle,tablaamortidetalleParameterGeneral,tablaamortidetalleReturnGeneral,isEsNuevoTablaAmortiDetalle,clases);
			
			this.connexion.commit();
			
			return tablaamortidetalleReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public TablaAmortiDetalleParameterReturnGeneral procesarImportacionTablaAmortiDetallesWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,TablaAmortiDetalleParameterReturnGeneral tablaamortidetalleParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TablaAmortiDetalle.class.getSimpleName()+"-procesarImportacionTablaAmortiDetallesWithConnection");connexion.begin();			
			
			TablaAmortiDetalleParameterReturnGeneral tablaamortidetalleReturnGeneral=new TablaAmortiDetalleParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.tablaamortidetalles=new ArrayList<TablaAmortiDetalle>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.tablaamortidetalle=new TablaAmortiDetalle();
				
				
				if(conColumnasBase) {this.tablaamortidetalle.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.tablaamortidetalle.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.tablaamortidetalle.setfecha_emision(Funciones.ConvertToDate(arrColumnas[iColumn++]));
				this.tablaamortidetalle.setfecha_vencimiento(Funciones.ConvertToDate(arrColumnas[iColumn++]));
				this.tablaamortidetalle.setfecha_inicial(Funciones.ConvertToDate(arrColumnas[iColumn++]));
				this.tablaamortidetalle.setfecha_final(Funciones.ConvertToDate(arrColumnas[iColumn++]));
				this.tablaamortidetalle.setvalor(Double.parseDouble(arrColumnas[iColumn++]));
				this.tablaamortidetalle.setinteres(Double.parseDouble(arrColumnas[iColumn++]));
				this.tablaamortidetalle.setcapital(Double.parseDouble(arrColumnas[iColumn++]));
				this.tablaamortidetalle.setnumero_cuotas(Integer.parseInt(arrColumnas[iColumn++]));
				
				this.tablaamortidetalles.add(this.tablaamortidetalle);
			}
			
			this.saveTablaAmortiDetalles();
			
			this.connexion.commit();
			
			tablaamortidetalleReturnGeneral.setConRetornoEstaProcesado(true);
			tablaamortidetalleReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return tablaamortidetalleReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarTablaAmortiDetallesEliminados() throws Exception {				
		
		List<TablaAmortiDetalle> tablaamortidetallesAux= new ArrayList<TablaAmortiDetalle>();
		
		for(TablaAmortiDetalle tablaamortidetalle:tablaamortidetalles) {
			if(!tablaamortidetalle.getIsDeleted()) {
				tablaamortidetallesAux.add(tablaamortidetalle);
			}
		}
		
		tablaamortidetalles=tablaamortidetallesAux;
	}
	
	public void quitarTablaAmortiDetallesNulos() throws Exception {				
		
		List<TablaAmortiDetalle> tablaamortidetallesAux= new ArrayList<TablaAmortiDetalle>();
		
		for(TablaAmortiDetalle tablaamortidetalle : this.tablaamortidetalles) {
			if(tablaamortidetalle==null) {
				tablaamortidetallesAux.add(tablaamortidetalle);
			}
		}
		
		//this.tablaamortidetalles=tablaamortidetallesAux;
		
		this.tablaamortidetalles.removeAll(tablaamortidetallesAux);
	}
	
	public void getSetVersionRowTablaAmortiDetalleWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(tablaamortidetalle.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((tablaamortidetalle.getIsDeleted() || (tablaamortidetalle.getIsChanged()&&!tablaamortidetalle.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=tablaamortidetalleDataAccess.getSetVersionRowTablaAmortiDetalle(connexion,tablaamortidetalle.getId());
				
				if(!tablaamortidetalle.getVersionRow().equals(timestamp)) {	
					tablaamortidetalle.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				tablaamortidetalle.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowTablaAmortiDetalle()throws Exception {	
		
		if(tablaamortidetalle.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((tablaamortidetalle.getIsDeleted() || (tablaamortidetalle.getIsChanged()&&!tablaamortidetalle.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=tablaamortidetalleDataAccess.getSetVersionRowTablaAmortiDetalle(connexion,tablaamortidetalle.getId());
			
			try {							
				if(!tablaamortidetalle.getVersionRow().equals(timestamp)) {	
					tablaamortidetalle.setVersionRow(timestamp);
				}
				
				tablaamortidetalle.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowTablaAmortiDetallesWithConnection()throws Exception {	
		if(tablaamortidetalles!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(TablaAmortiDetalle tablaamortidetalleAux:tablaamortidetalles) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(tablaamortidetalleAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(tablaamortidetalleAux.getIsDeleted() || (tablaamortidetalleAux.getIsChanged()&&!tablaamortidetalleAux.getIsNew())) {
						
						timestamp=tablaamortidetalleDataAccess.getSetVersionRowTablaAmortiDetalle(connexion,tablaamortidetalleAux.getId());
						
						if(!tablaamortidetalle.getVersionRow().equals(timestamp)) {	
							tablaamortidetalleAux.setVersionRow(timestamp);
						}
								
						tablaamortidetalleAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowTablaAmortiDetalles()throws Exception {	
		if(tablaamortidetalles!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(TablaAmortiDetalle tablaamortidetalleAux:tablaamortidetalles) {
					if(tablaamortidetalleAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(tablaamortidetalleAux.getIsDeleted() || (tablaamortidetalleAux.getIsChanged()&&!tablaamortidetalleAux.getIsNew())) {
						
						timestamp=tablaamortidetalleDataAccess.getSetVersionRowTablaAmortiDetalle(connexion,tablaamortidetalleAux.getId());
						
						if(!tablaamortidetalleAux.getVersionRow().equals(timestamp)) {	
							tablaamortidetalleAux.setVersionRow(timestamp);
						}
						
													
						tablaamortidetalleAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public TablaAmortiDetalleParameterReturnGeneral cargarCombosLoteForeignKeyTablaAmortiDetalleWithConnection(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalEjercicio,String finalQueryGlobalPeriodo,String finalQueryGlobalTasa,String finalQueryGlobalFactura,String finalQueryGlobalTipoIntervalo,String finalQueryGlobalAnio,String finalQueryGlobalMes) throws Exception {
		TablaAmortiDetalleParameterReturnGeneral  tablaamortidetalleReturnGeneral =new TablaAmortiDetalleParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TablaAmortiDetalle.class.getSimpleName()+"-cargarCombosLoteForeignKeyTablaAmortiDetalleWithConnection");connexion.begin();
			
			tablaamortidetalleReturnGeneral =new TablaAmortiDetalleParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			tablaamortidetalleReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			tablaamortidetalleReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Ejercicio> ejerciciosForeignKey=new ArrayList<Ejercicio>();
			EjercicioLogic ejercicioLogic=new EjercicioLogic();
			ejercicioLogic.setConnexion(this.connexion);
			//ejercicioLogic.getEjercicioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEjercicio.equals("NONE")) {
				ejercicioLogic.getTodosEjercicios(finalQueryGlobalEjercicio,new Pagination());
				ejerciciosForeignKey=ejercicioLogic.getEjercicios();
			}

			tablaamortidetalleReturnGeneral.setejerciciosForeignKey(ejerciciosForeignKey);


			List<Periodo> periodosForeignKey=new ArrayList<Periodo>();
			PeriodoLogic periodoLogic=new PeriodoLogic();
			periodoLogic.setConnexion(this.connexion);
			//periodoLogic.getPeriodoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPeriodo.equals("NONE")) {
				periodoLogic.getTodosPeriodos(finalQueryGlobalPeriodo,new Pagination());
				periodosForeignKey=periodoLogic.getPeriodos();
			}

			tablaamortidetalleReturnGeneral.setperiodosForeignKey(periodosForeignKey);


			List<Tasa> tasasForeignKey=new ArrayList<Tasa>();
			TasaLogic tasaLogic=new TasaLogic();
			tasaLogic.setConnexion(this.connexion);
			tasaLogic.getTasaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTasa.equals("NONE")) {
				tasaLogic.getTodosTasas(finalQueryGlobalTasa,new Pagination());
				tasasForeignKey=tasaLogic.getTasas();
			}

			tablaamortidetalleReturnGeneral.settasasForeignKey(tasasForeignKey);


			List<Factura> facturasForeignKey=new ArrayList<Factura>();
			FacturaLogic facturaLogic=new FacturaLogic();
			facturaLogic.setConnexion(this.connexion);
			facturaLogic.getFacturaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalFactura.equals("NONE")) {
				facturaLogic.getTodosFacturas(finalQueryGlobalFactura,new Pagination());
				facturasForeignKey=facturaLogic.getFacturas();
			}

			tablaamortidetalleReturnGeneral.setfacturasForeignKey(facturasForeignKey);


			List<TipoIntervalo> tipointervalosForeignKey=new ArrayList<TipoIntervalo>();
			TipoIntervaloLogic tipointervaloLogic=new TipoIntervaloLogic();
			tipointervaloLogic.setConnexion(this.connexion);
			tipointervaloLogic.getTipoIntervaloDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoIntervalo.equals("NONE")) {
				tipointervaloLogic.getTodosTipoIntervalos(finalQueryGlobalTipoIntervalo,new Pagination());
				tipointervalosForeignKey=tipointervaloLogic.getTipoIntervalos();
			}

			tablaamortidetalleReturnGeneral.settipointervalosForeignKey(tipointervalosForeignKey);


			List<Anio> aniosForeignKey=new ArrayList<Anio>();
			AnioLogic anioLogic=new AnioLogic();
			anioLogic.setConnexion(this.connexion);
			anioLogic.getAnioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalAnio.equals("NONE")) {
				anioLogic.getTodosAnios(finalQueryGlobalAnio,new Pagination());
				aniosForeignKey=anioLogic.getAnios();
			}

			tablaamortidetalleReturnGeneral.setaniosForeignKey(aniosForeignKey);


			List<Mes> messForeignKey=new ArrayList<Mes>();
			MesLogic mesLogic=new MesLogic();
			mesLogic.setConnexion(this.connexion);
			mesLogic.getMesDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalMes.equals("NONE")) {
				mesLogic.getTodosMess(finalQueryGlobalMes,new Pagination());
				messForeignKey=mesLogic.getMess();
			}

			tablaamortidetalleReturnGeneral.setmessForeignKey(messForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return tablaamortidetalleReturnGeneral;
	}
	
	public TablaAmortiDetalleParameterReturnGeneral cargarCombosLoteForeignKeyTablaAmortiDetalle(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalEjercicio,String finalQueryGlobalPeriodo,String finalQueryGlobalTasa,String finalQueryGlobalFactura,String finalQueryGlobalTipoIntervalo,String finalQueryGlobalAnio,String finalQueryGlobalMes) throws Exception {
		TablaAmortiDetalleParameterReturnGeneral  tablaamortidetalleReturnGeneral =new TablaAmortiDetalleParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			tablaamortidetalleReturnGeneral =new TablaAmortiDetalleParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			tablaamortidetalleReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			tablaamortidetalleReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Ejercicio> ejerciciosForeignKey=new ArrayList<Ejercicio>();
			EjercicioLogic ejercicioLogic=new EjercicioLogic();
			ejercicioLogic.setConnexion(this.connexion);
			//ejercicioLogic.getEjercicioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEjercicio.equals("NONE")) {
				ejercicioLogic.getTodosEjercicios(finalQueryGlobalEjercicio,new Pagination());
				ejerciciosForeignKey=ejercicioLogic.getEjercicios();
			}

			tablaamortidetalleReturnGeneral.setejerciciosForeignKey(ejerciciosForeignKey);


			List<Periodo> periodosForeignKey=new ArrayList<Periodo>();
			PeriodoLogic periodoLogic=new PeriodoLogic();
			periodoLogic.setConnexion(this.connexion);
			//periodoLogic.getPeriodoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPeriodo.equals("NONE")) {
				periodoLogic.getTodosPeriodos(finalQueryGlobalPeriodo,new Pagination());
				periodosForeignKey=periodoLogic.getPeriodos();
			}

			tablaamortidetalleReturnGeneral.setperiodosForeignKey(periodosForeignKey);


			List<Tasa> tasasForeignKey=new ArrayList<Tasa>();
			TasaLogic tasaLogic=new TasaLogic();
			tasaLogic.setConnexion(this.connexion);
			tasaLogic.getTasaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTasa.equals("NONE")) {
				tasaLogic.getTodosTasas(finalQueryGlobalTasa,new Pagination());
				tasasForeignKey=tasaLogic.getTasas();
			}

			tablaamortidetalleReturnGeneral.settasasForeignKey(tasasForeignKey);


			List<Factura> facturasForeignKey=new ArrayList<Factura>();
			FacturaLogic facturaLogic=new FacturaLogic();
			facturaLogic.setConnexion(this.connexion);
			facturaLogic.getFacturaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalFactura.equals("NONE")) {
				facturaLogic.getTodosFacturas(finalQueryGlobalFactura,new Pagination());
				facturasForeignKey=facturaLogic.getFacturas();
			}

			tablaamortidetalleReturnGeneral.setfacturasForeignKey(facturasForeignKey);


			List<TipoIntervalo> tipointervalosForeignKey=new ArrayList<TipoIntervalo>();
			TipoIntervaloLogic tipointervaloLogic=new TipoIntervaloLogic();
			tipointervaloLogic.setConnexion(this.connexion);
			tipointervaloLogic.getTipoIntervaloDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoIntervalo.equals("NONE")) {
				tipointervaloLogic.getTodosTipoIntervalos(finalQueryGlobalTipoIntervalo,new Pagination());
				tipointervalosForeignKey=tipointervaloLogic.getTipoIntervalos();
			}

			tablaamortidetalleReturnGeneral.settipointervalosForeignKey(tipointervalosForeignKey);


			List<Anio> aniosForeignKey=new ArrayList<Anio>();
			AnioLogic anioLogic=new AnioLogic();
			anioLogic.setConnexion(this.connexion);
			anioLogic.getAnioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalAnio.equals("NONE")) {
				anioLogic.getTodosAnios(finalQueryGlobalAnio,new Pagination());
				aniosForeignKey=anioLogic.getAnios();
			}

			tablaamortidetalleReturnGeneral.setaniosForeignKey(aniosForeignKey);


			List<Mes> messForeignKey=new ArrayList<Mes>();
			MesLogic mesLogic=new MesLogic();
			mesLogic.setConnexion(this.connexion);
			mesLogic.getMesDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalMes.equals("NONE")) {
				mesLogic.getTodosMess(finalQueryGlobalMes,new Pagination());
				messForeignKey=mesLogic.getMess();
			}

			tablaamortidetalleReturnGeneral.setmessForeignKey(messForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return tablaamortidetalleReturnGeneral;
	}
	
	
	public void deepLoad(TablaAmortiDetalle tablaamortidetalle,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			TablaAmortiDetalleLogicAdditional.updateTablaAmortiDetalleToGet(tablaamortidetalle,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		tablaamortidetalle.setEmpresa(tablaamortidetalleDataAccess.getEmpresa(connexion,tablaamortidetalle));
		tablaamortidetalle.setSucursal(tablaamortidetalleDataAccess.getSucursal(connexion,tablaamortidetalle));
		tablaamortidetalle.setEjercicio(tablaamortidetalleDataAccess.getEjercicio(connexion,tablaamortidetalle));
		tablaamortidetalle.setPeriodo(tablaamortidetalleDataAccess.getPeriodo(connexion,tablaamortidetalle));
		tablaamortidetalle.setTasa(tablaamortidetalleDataAccess.getTasa(connexion,tablaamortidetalle));
		tablaamortidetalle.setFactura(tablaamortidetalleDataAccess.getFactura(connexion,tablaamortidetalle));
		tablaamortidetalle.setTipoIntervalo(tablaamortidetalleDataAccess.getTipoIntervalo(connexion,tablaamortidetalle));
		tablaamortidetalle.setAnio(tablaamortidetalleDataAccess.getAnio(connexion,tablaamortidetalle));
		tablaamortidetalle.setMes(tablaamortidetalleDataAccess.getMes(connexion,tablaamortidetalle));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				tablaamortidetalle.setEmpresa(tablaamortidetalleDataAccess.getEmpresa(connexion,tablaamortidetalle));
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				tablaamortidetalle.setSucursal(tablaamortidetalleDataAccess.getSucursal(connexion,tablaamortidetalle));
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				tablaamortidetalle.setEjercicio(tablaamortidetalleDataAccess.getEjercicio(connexion,tablaamortidetalle));
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				tablaamortidetalle.setPeriodo(tablaamortidetalleDataAccess.getPeriodo(connexion,tablaamortidetalle));
				continue;
			}

			if(clas.clas.equals(Tasa.class)) {
				tablaamortidetalle.setTasa(tablaamortidetalleDataAccess.getTasa(connexion,tablaamortidetalle));
				continue;
			}

			if(clas.clas.equals(Factura.class)) {
				tablaamortidetalle.setFactura(tablaamortidetalleDataAccess.getFactura(connexion,tablaamortidetalle));
				continue;
			}

			if(clas.clas.equals(TipoIntervalo.class)) {
				tablaamortidetalle.setTipoIntervalo(tablaamortidetalleDataAccess.getTipoIntervalo(connexion,tablaamortidetalle));
				continue;
			}

			if(clas.clas.equals(Anio.class)) {
				tablaamortidetalle.setAnio(tablaamortidetalleDataAccess.getAnio(connexion,tablaamortidetalle));
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				tablaamortidetalle.setMes(tablaamortidetalleDataAccess.getMes(connexion,tablaamortidetalle));
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
			tablaamortidetalle.setEmpresa(tablaamortidetalleDataAccess.getEmpresa(connexion,tablaamortidetalle));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			tablaamortidetalle.setSucursal(tablaamortidetalleDataAccess.getSucursal(connexion,tablaamortidetalle));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Ejercicio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			tablaamortidetalle.setEjercicio(tablaamortidetalleDataAccess.getEjercicio(connexion,tablaamortidetalle));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Periodo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			tablaamortidetalle.setPeriodo(tablaamortidetalleDataAccess.getPeriodo(connexion,tablaamortidetalle));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Tasa.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			tablaamortidetalle.setTasa(tablaamortidetalleDataAccess.getTasa(connexion,tablaamortidetalle));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Factura.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			tablaamortidetalle.setFactura(tablaamortidetalleDataAccess.getFactura(connexion,tablaamortidetalle));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoIntervalo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			tablaamortidetalle.setTipoIntervalo(tablaamortidetalleDataAccess.getTipoIntervalo(connexion,tablaamortidetalle));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Anio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			tablaamortidetalle.setAnio(tablaamortidetalleDataAccess.getAnio(connexion,tablaamortidetalle));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Mes.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			tablaamortidetalle.setMes(tablaamortidetalleDataAccess.getMes(connexion,tablaamortidetalle));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		tablaamortidetalle.setEmpresa(tablaamortidetalleDataAccess.getEmpresa(connexion,tablaamortidetalle));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(tablaamortidetalle.getEmpresa(),isDeep,deepLoadType,clases);
				
		tablaamortidetalle.setSucursal(tablaamortidetalleDataAccess.getSucursal(connexion,tablaamortidetalle));
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(tablaamortidetalle.getSucursal(),isDeep,deepLoadType,clases);
				
		tablaamortidetalle.setEjercicio(tablaamortidetalleDataAccess.getEjercicio(connexion,tablaamortidetalle));
		EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
		ejercicioLogic.deepLoad(tablaamortidetalle.getEjercicio(),isDeep,deepLoadType,clases);
				
		tablaamortidetalle.setPeriodo(tablaamortidetalleDataAccess.getPeriodo(connexion,tablaamortidetalle));
		PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
		periodoLogic.deepLoad(tablaamortidetalle.getPeriodo(),isDeep,deepLoadType,clases);
				
		tablaamortidetalle.setTasa(tablaamortidetalleDataAccess.getTasa(connexion,tablaamortidetalle));
		TasaLogic tasaLogic= new TasaLogic(connexion);
		tasaLogic.deepLoad(tablaamortidetalle.getTasa(),isDeep,deepLoadType,clases);
				
		tablaamortidetalle.setFactura(tablaamortidetalleDataAccess.getFactura(connexion,tablaamortidetalle));
		FacturaLogic facturaLogic= new FacturaLogic(connexion);
		facturaLogic.deepLoad(tablaamortidetalle.getFactura(),isDeep,deepLoadType,clases);
				
		tablaamortidetalle.setTipoIntervalo(tablaamortidetalleDataAccess.getTipoIntervalo(connexion,tablaamortidetalle));
		TipoIntervaloLogic tipointervaloLogic= new TipoIntervaloLogic(connexion);
		tipointervaloLogic.deepLoad(tablaamortidetalle.getTipoIntervalo(),isDeep,deepLoadType,clases);
				
		tablaamortidetalle.setAnio(tablaamortidetalleDataAccess.getAnio(connexion,tablaamortidetalle));
		AnioLogic anioLogic= new AnioLogic(connexion);
		anioLogic.deepLoad(tablaamortidetalle.getAnio(),isDeep,deepLoadType,clases);
				
		tablaamortidetalle.setMes(tablaamortidetalleDataAccess.getMes(connexion,tablaamortidetalle));
		MesLogic mesLogic= new MesLogic(connexion);
		mesLogic.deepLoad(tablaamortidetalle.getMes(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				tablaamortidetalle.setEmpresa(tablaamortidetalleDataAccess.getEmpresa(connexion,tablaamortidetalle));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(tablaamortidetalle.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				tablaamortidetalle.setSucursal(tablaamortidetalleDataAccess.getSucursal(connexion,tablaamortidetalle));
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepLoad(tablaamortidetalle.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				tablaamortidetalle.setEjercicio(tablaamortidetalleDataAccess.getEjercicio(connexion,tablaamortidetalle));
				EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
				ejercicioLogic.deepLoad(tablaamortidetalle.getEjercicio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				tablaamortidetalle.setPeriodo(tablaamortidetalleDataAccess.getPeriodo(connexion,tablaamortidetalle));
				PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
				periodoLogic.deepLoad(tablaamortidetalle.getPeriodo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Tasa.class)) {
				tablaamortidetalle.setTasa(tablaamortidetalleDataAccess.getTasa(connexion,tablaamortidetalle));
				TasaLogic tasaLogic= new TasaLogic(connexion);
				tasaLogic.deepLoad(tablaamortidetalle.getTasa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Factura.class)) {
				tablaamortidetalle.setFactura(tablaamortidetalleDataAccess.getFactura(connexion,tablaamortidetalle));
				FacturaLogic facturaLogic= new FacturaLogic(connexion);
				facturaLogic.deepLoad(tablaamortidetalle.getFactura(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoIntervalo.class)) {
				tablaamortidetalle.setTipoIntervalo(tablaamortidetalleDataAccess.getTipoIntervalo(connexion,tablaamortidetalle));
				TipoIntervaloLogic tipointervaloLogic= new TipoIntervaloLogic(connexion);
				tipointervaloLogic.deepLoad(tablaamortidetalle.getTipoIntervalo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Anio.class)) {
				tablaamortidetalle.setAnio(tablaamortidetalleDataAccess.getAnio(connexion,tablaamortidetalle));
				AnioLogic anioLogic= new AnioLogic(connexion);
				anioLogic.deepLoad(tablaamortidetalle.getAnio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				tablaamortidetalle.setMes(tablaamortidetalleDataAccess.getMes(connexion,tablaamortidetalle));
				MesLogic mesLogic= new MesLogic(connexion);
				mesLogic.deepLoad(tablaamortidetalle.getMes(),isDeep,deepLoadType,clases);				
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
			tablaamortidetalle.setEmpresa(tablaamortidetalleDataAccess.getEmpresa(connexion,tablaamortidetalle));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(tablaamortidetalle.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			tablaamortidetalle.setSucursal(tablaamortidetalleDataAccess.getSucursal(connexion,tablaamortidetalle));
			SucursalLogic sucursalLogic= new SucursalLogic(connexion);
			sucursalLogic.deepLoad(tablaamortidetalle.getSucursal(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Ejercicio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			tablaamortidetalle.setEjercicio(tablaamortidetalleDataAccess.getEjercicio(connexion,tablaamortidetalle));
			EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
			ejercicioLogic.deepLoad(tablaamortidetalle.getEjercicio(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Periodo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			tablaamortidetalle.setPeriodo(tablaamortidetalleDataAccess.getPeriodo(connexion,tablaamortidetalle));
			PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
			periodoLogic.deepLoad(tablaamortidetalle.getPeriodo(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Tasa.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			tablaamortidetalle.setTasa(tablaamortidetalleDataAccess.getTasa(connexion,tablaamortidetalle));
			TasaLogic tasaLogic= new TasaLogic(connexion);
			tasaLogic.deepLoad(tablaamortidetalle.getTasa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Factura.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			tablaamortidetalle.setFactura(tablaamortidetalleDataAccess.getFactura(connexion,tablaamortidetalle));
			FacturaLogic facturaLogic= new FacturaLogic(connexion);
			facturaLogic.deepLoad(tablaamortidetalle.getFactura(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoIntervalo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			tablaamortidetalle.setTipoIntervalo(tablaamortidetalleDataAccess.getTipoIntervalo(connexion,tablaamortidetalle));
			TipoIntervaloLogic tipointervaloLogic= new TipoIntervaloLogic(connexion);
			tipointervaloLogic.deepLoad(tablaamortidetalle.getTipoIntervalo(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Anio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			tablaamortidetalle.setAnio(tablaamortidetalleDataAccess.getAnio(connexion,tablaamortidetalle));
			AnioLogic anioLogic= new AnioLogic(connexion);
			anioLogic.deepLoad(tablaamortidetalle.getAnio(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Mes.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			tablaamortidetalle.setMes(tablaamortidetalleDataAccess.getMes(connexion,tablaamortidetalle));
			MesLogic mesLogic= new MesLogic(connexion);
			mesLogic.deepLoad(tablaamortidetalle.getMes(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(TablaAmortiDetalle tablaamortidetalle,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			TablaAmortiDetalleLogicAdditional.updateTablaAmortiDetalleToSave(tablaamortidetalle,this.arrDatoGeneral);
			
TablaAmortiDetalleDataAccess.save(tablaamortidetalle, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(tablaamortidetalle.getEmpresa(),connexion);

		SucursalDataAccess.save(tablaamortidetalle.getSucursal(),connexion);

		EjercicioDataAccess.save(tablaamortidetalle.getEjercicio(),connexion);

		PeriodoDataAccess.save(tablaamortidetalle.getPeriodo(),connexion);

		TasaDataAccess.save(tablaamortidetalle.getTasa(),connexion);

		FacturaDataAccess.save(tablaamortidetalle.getFactura(),connexion);

		TipoIntervaloDataAccess.save(tablaamortidetalle.getTipoIntervalo(),connexion);

		AnioDataAccess.save(tablaamortidetalle.getAnio(),connexion);

		MesDataAccess.save(tablaamortidetalle.getMes(),connexion);
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(tablaamortidetalle.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(tablaamortidetalle.getSucursal(),connexion);
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				EjercicioDataAccess.save(tablaamortidetalle.getEjercicio(),connexion);
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				PeriodoDataAccess.save(tablaamortidetalle.getPeriodo(),connexion);
				continue;
			}

			if(clas.clas.equals(Tasa.class)) {
				TasaDataAccess.save(tablaamortidetalle.getTasa(),connexion);
				continue;
			}

			if(clas.clas.equals(Factura.class)) {
				FacturaDataAccess.save(tablaamortidetalle.getFactura(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoIntervalo.class)) {
				TipoIntervaloDataAccess.save(tablaamortidetalle.getTipoIntervalo(),connexion);
				continue;
			}

			if(clas.clas.equals(Anio.class)) {
				AnioDataAccess.save(tablaamortidetalle.getAnio(),connexion);
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				MesDataAccess.save(tablaamortidetalle.getMes(),connexion);
				continue;
			}

		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(tablaamortidetalle.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(tablaamortidetalle.getEmpresa(),isDeep,deepLoadType,clases);
				

		SucursalDataAccess.save(tablaamortidetalle.getSucursal(),connexion);
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(tablaamortidetalle.getSucursal(),isDeep,deepLoadType,clases);
				

		EjercicioDataAccess.save(tablaamortidetalle.getEjercicio(),connexion);
		EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
		ejercicioLogic.deepLoad(tablaamortidetalle.getEjercicio(),isDeep,deepLoadType,clases);
				

		PeriodoDataAccess.save(tablaamortidetalle.getPeriodo(),connexion);
		PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
		periodoLogic.deepLoad(tablaamortidetalle.getPeriodo(),isDeep,deepLoadType,clases);
				

		TasaDataAccess.save(tablaamortidetalle.getTasa(),connexion);
		TasaLogic tasaLogic= new TasaLogic(connexion);
		tasaLogic.deepLoad(tablaamortidetalle.getTasa(),isDeep,deepLoadType,clases);
				

		FacturaDataAccess.save(tablaamortidetalle.getFactura(),connexion);
		FacturaLogic facturaLogic= new FacturaLogic(connexion);
		facturaLogic.deepLoad(tablaamortidetalle.getFactura(),isDeep,deepLoadType,clases);
				

		TipoIntervaloDataAccess.save(tablaamortidetalle.getTipoIntervalo(),connexion);
		TipoIntervaloLogic tipointervaloLogic= new TipoIntervaloLogic(connexion);
		tipointervaloLogic.deepLoad(tablaamortidetalle.getTipoIntervalo(),isDeep,deepLoadType,clases);
				

		AnioDataAccess.save(tablaamortidetalle.getAnio(),connexion);
		AnioLogic anioLogic= new AnioLogic(connexion);
		anioLogic.deepLoad(tablaamortidetalle.getAnio(),isDeep,deepLoadType,clases);
				

		MesDataAccess.save(tablaamortidetalle.getMes(),connexion);
		MesLogic mesLogic= new MesLogic(connexion);
		mesLogic.deepLoad(tablaamortidetalle.getMes(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(tablaamortidetalle.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(tablaamortidetalle.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(tablaamortidetalle.getSucursal(),connexion);
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepSave(tablaamortidetalle.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				EjercicioDataAccess.save(tablaamortidetalle.getEjercicio(),connexion);
				EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
				ejercicioLogic.deepSave(tablaamortidetalle.getEjercicio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				PeriodoDataAccess.save(tablaamortidetalle.getPeriodo(),connexion);
				PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
				periodoLogic.deepSave(tablaamortidetalle.getPeriodo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Tasa.class)) {
				TasaDataAccess.save(tablaamortidetalle.getTasa(),connexion);
				TasaLogic tasaLogic= new TasaLogic(connexion);
				tasaLogic.deepSave(tablaamortidetalle.getTasa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Factura.class)) {
				FacturaDataAccess.save(tablaamortidetalle.getFactura(),connexion);
				FacturaLogic facturaLogic= new FacturaLogic(connexion);
				facturaLogic.deepSave(tablaamortidetalle.getFactura(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoIntervalo.class)) {
				TipoIntervaloDataAccess.save(tablaamortidetalle.getTipoIntervalo(),connexion);
				TipoIntervaloLogic tipointervaloLogic= new TipoIntervaloLogic(connexion);
				tipointervaloLogic.deepSave(tablaamortidetalle.getTipoIntervalo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Anio.class)) {
				AnioDataAccess.save(tablaamortidetalle.getAnio(),connexion);
				AnioLogic anioLogic= new AnioLogic(connexion);
				anioLogic.deepSave(tablaamortidetalle.getAnio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				MesDataAccess.save(tablaamortidetalle.getMes(),connexion);
				MesLogic mesLogic= new MesLogic(connexion);
				mesLogic.deepSave(tablaamortidetalle.getMes(),isDeep,deepLoadType,clases);				
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
			this.getNewConnexionToDeep(TablaAmortiDetalle.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(tablaamortidetalle,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				TablaAmortiDetalleConstantesFunciones.refrescarForeignKeysDescripcionesTablaAmortiDetalle(tablaamortidetalle);
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
			this.deepLoad(this.tablaamortidetalle,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				TablaAmortiDetalleConstantesFunciones.refrescarForeignKeysDescripcionesTablaAmortiDetalle(this.tablaamortidetalle);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(TablaAmortiDetalle.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(tablaamortidetalles!=null) {
				for(TablaAmortiDetalle tablaamortidetalle:tablaamortidetalles) {
					this.deepLoad(tablaamortidetalle,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					TablaAmortiDetalleConstantesFunciones.refrescarForeignKeysDescripcionesTablaAmortiDetalle(tablaamortidetalles);
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
			if(tablaamortidetalles!=null) {
				for(TablaAmortiDetalle tablaamortidetalle:tablaamortidetalles) {
					this.deepLoad(tablaamortidetalle,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					TablaAmortiDetalleConstantesFunciones.refrescarForeignKeysDescripcionesTablaAmortiDetalle(tablaamortidetalles);
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
			this.getNewConnexionToDeep(TablaAmortiDetalle.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(tablaamortidetalle,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(TablaAmortiDetalle.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(tablaamortidetalles!=null) {
				for(TablaAmortiDetalle tablaamortidetalle:tablaamortidetalles) {
					this.deepSave(tablaamortidetalle,isDeep,deepLoadType,clases);
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
			if(tablaamortidetalles!=null) {
				for(TablaAmortiDetalle tablaamortidetalle:tablaamortidetalles) {
					this.deepSave(tablaamortidetalle,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getTablaAmortiDetallesFK_IdAnioWithConnection(String sFinalQuery,Pagination pagination,Long id_anio)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TablaAmortiDetalle.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidAnio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidAnio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_anio,TablaAmortiDetalleConstantesFunciones.IDANIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidAnio);

			TablaAmortiDetalleLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdAnio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tablaamortidetalles=tablaamortidetalleDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TablaAmortiDetalleConstantesFunciones.refrescarForeignKeysDescripcionesTablaAmortiDetalle(this.tablaamortidetalles);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTablaAmortiDetallesFK_IdAnio(String sFinalQuery,Pagination pagination,Long id_anio)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidAnio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidAnio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_anio,TablaAmortiDetalleConstantesFunciones.IDANIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidAnio);

			TablaAmortiDetalleLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdAnio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tablaamortidetalles=tablaamortidetalleDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TablaAmortiDetalleConstantesFunciones.refrescarForeignKeysDescripcionesTablaAmortiDetalle(this.tablaamortidetalles);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getTablaAmortiDetallesFK_IdEjercicioWithConnection(String sFinalQuery,Pagination pagination,Long id_ejercicio)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TablaAmortiDetalle.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEjercicio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEjercicio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_ejercicio,TablaAmortiDetalleConstantesFunciones.IDEJERCICIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEjercicio);

			TablaAmortiDetalleLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEjercicio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tablaamortidetalles=tablaamortidetalleDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TablaAmortiDetalleConstantesFunciones.refrescarForeignKeysDescripcionesTablaAmortiDetalle(this.tablaamortidetalles);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTablaAmortiDetallesFK_IdEjercicio(String sFinalQuery,Pagination pagination,Long id_ejercicio)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEjercicio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEjercicio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_ejercicio,TablaAmortiDetalleConstantesFunciones.IDEJERCICIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEjercicio);

			TablaAmortiDetalleLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEjercicio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tablaamortidetalles=tablaamortidetalleDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TablaAmortiDetalleConstantesFunciones.refrescarForeignKeysDescripcionesTablaAmortiDetalle(this.tablaamortidetalles);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getTablaAmortiDetallesFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TablaAmortiDetalle.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,TablaAmortiDetalleConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			TablaAmortiDetalleLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tablaamortidetalles=tablaamortidetalleDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TablaAmortiDetalleConstantesFunciones.refrescarForeignKeysDescripcionesTablaAmortiDetalle(this.tablaamortidetalles);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTablaAmortiDetallesFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,TablaAmortiDetalleConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			TablaAmortiDetalleLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tablaamortidetalles=tablaamortidetalleDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TablaAmortiDetalleConstantesFunciones.refrescarForeignKeysDescripcionesTablaAmortiDetalle(this.tablaamortidetalles);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getTablaAmortiDetallesFK_IdFacturaWithConnection(String sFinalQuery,Pagination pagination,Long id_factura)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TablaAmortiDetalle.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidFactura= new ParameterSelectionGeneral();
			parameterSelectionGeneralidFactura.setParameterSelectionGeneralEqual(ParameterType.LONG,id_factura,TablaAmortiDetalleConstantesFunciones.IDFACTURA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidFactura);

			TablaAmortiDetalleLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdFactura","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tablaamortidetalles=tablaamortidetalleDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TablaAmortiDetalleConstantesFunciones.refrescarForeignKeysDescripcionesTablaAmortiDetalle(this.tablaamortidetalles);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTablaAmortiDetallesFK_IdFactura(String sFinalQuery,Pagination pagination,Long id_factura)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidFactura= new ParameterSelectionGeneral();
			parameterSelectionGeneralidFactura.setParameterSelectionGeneralEqual(ParameterType.LONG,id_factura,TablaAmortiDetalleConstantesFunciones.IDFACTURA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidFactura);

			TablaAmortiDetalleLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdFactura","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tablaamortidetalles=tablaamortidetalleDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TablaAmortiDetalleConstantesFunciones.refrescarForeignKeysDescripcionesTablaAmortiDetalle(this.tablaamortidetalles);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getTablaAmortiDetallesFK_IdMesWithConnection(String sFinalQuery,Pagination pagination,Long id_mes)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TablaAmortiDetalle.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidMes= new ParameterSelectionGeneral();
			parameterSelectionGeneralidMes.setParameterSelectionGeneralEqual(ParameterType.LONG,id_mes,TablaAmortiDetalleConstantesFunciones.IDMES,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidMes);

			TablaAmortiDetalleLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdMes","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tablaamortidetalles=tablaamortidetalleDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TablaAmortiDetalleConstantesFunciones.refrescarForeignKeysDescripcionesTablaAmortiDetalle(this.tablaamortidetalles);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTablaAmortiDetallesFK_IdMes(String sFinalQuery,Pagination pagination,Long id_mes)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidMes= new ParameterSelectionGeneral();
			parameterSelectionGeneralidMes.setParameterSelectionGeneralEqual(ParameterType.LONG,id_mes,TablaAmortiDetalleConstantesFunciones.IDMES,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidMes);

			TablaAmortiDetalleLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdMes","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tablaamortidetalles=tablaamortidetalleDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TablaAmortiDetalleConstantesFunciones.refrescarForeignKeysDescripcionesTablaAmortiDetalle(this.tablaamortidetalles);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getTablaAmortiDetallesFK_IdPeriodoWithConnection(String sFinalQuery,Pagination pagination,Long id_periodo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TablaAmortiDetalle.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPeriodo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPeriodo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_periodo,TablaAmortiDetalleConstantesFunciones.IDPERIODO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPeriodo);

			TablaAmortiDetalleLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPeriodo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tablaamortidetalles=tablaamortidetalleDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TablaAmortiDetalleConstantesFunciones.refrescarForeignKeysDescripcionesTablaAmortiDetalle(this.tablaamortidetalles);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTablaAmortiDetallesFK_IdPeriodo(String sFinalQuery,Pagination pagination,Long id_periodo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPeriodo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPeriodo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_periodo,TablaAmortiDetalleConstantesFunciones.IDPERIODO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPeriodo);

			TablaAmortiDetalleLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPeriodo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tablaamortidetalles=tablaamortidetalleDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TablaAmortiDetalleConstantesFunciones.refrescarForeignKeysDescripcionesTablaAmortiDetalle(this.tablaamortidetalles);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getTablaAmortiDetallesFK_IdSucursalWithConnection(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TablaAmortiDetalle.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,TablaAmortiDetalleConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			TablaAmortiDetalleLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tablaamortidetalles=tablaamortidetalleDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TablaAmortiDetalleConstantesFunciones.refrescarForeignKeysDescripcionesTablaAmortiDetalle(this.tablaamortidetalles);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTablaAmortiDetallesFK_IdSucursal(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,TablaAmortiDetalleConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			TablaAmortiDetalleLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tablaamortidetalles=tablaamortidetalleDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TablaAmortiDetalleConstantesFunciones.refrescarForeignKeysDescripcionesTablaAmortiDetalle(this.tablaamortidetalles);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getTablaAmortiDetallesFK_IdTasaWithConnection(String sFinalQuery,Pagination pagination,Long id_tasa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TablaAmortiDetalle.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTasa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTasa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tasa,TablaAmortiDetalleConstantesFunciones.IDTASA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTasa);

			TablaAmortiDetalleLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTasa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tablaamortidetalles=tablaamortidetalleDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TablaAmortiDetalleConstantesFunciones.refrescarForeignKeysDescripcionesTablaAmortiDetalle(this.tablaamortidetalles);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTablaAmortiDetallesFK_IdTasa(String sFinalQuery,Pagination pagination,Long id_tasa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTasa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTasa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tasa,TablaAmortiDetalleConstantesFunciones.IDTASA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTasa);

			TablaAmortiDetalleLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTasa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tablaamortidetalles=tablaamortidetalleDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TablaAmortiDetalleConstantesFunciones.refrescarForeignKeysDescripcionesTablaAmortiDetalle(this.tablaamortidetalles);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getTablaAmortiDetallesFK_IdTipoIntervaloWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_intervalo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TablaAmortiDetalle.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoIntervalo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoIntervalo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_intervalo,TablaAmortiDetalleConstantesFunciones.IDTIPOINTERVALO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoIntervalo);

			TablaAmortiDetalleLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoIntervalo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tablaamortidetalles=tablaamortidetalleDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TablaAmortiDetalleConstantesFunciones.refrescarForeignKeysDescripcionesTablaAmortiDetalle(this.tablaamortidetalles);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTablaAmortiDetallesFK_IdTipoIntervalo(String sFinalQuery,Pagination pagination,Long id_tipo_intervalo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoIntervalo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoIntervalo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_intervalo,TablaAmortiDetalleConstantesFunciones.IDTIPOINTERVALO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoIntervalo);

			TablaAmortiDetalleLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoIntervalo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tablaamortidetalles=tablaamortidetalleDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TablaAmortiDetalleConstantesFunciones.refrescarForeignKeysDescripcionesTablaAmortiDetalle(this.tablaamortidetalles);
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
			if(TablaAmortiDetalleConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,TablaAmortiDetalleDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,TablaAmortiDetalle tablaamortidetalle,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(TablaAmortiDetalleConstantesFunciones.ISCONAUDITORIA) {
				if(tablaamortidetalle.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TablaAmortiDetalleDataAccess.TABLENAME, tablaamortidetalle.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(TablaAmortiDetalleConstantesFunciones.ISCONAUDITORIADETALLE) {
						////TablaAmortiDetalleLogic.registrarAuditoriaDetallesTablaAmortiDetalle(connexion,tablaamortidetalle,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(tablaamortidetalle.getIsDeleted()) {
					/*if(!tablaamortidetalle.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,TablaAmortiDetalleDataAccess.TABLENAME, tablaamortidetalle.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////TablaAmortiDetalleLogic.registrarAuditoriaDetallesTablaAmortiDetalle(connexion,tablaamortidetalle,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TablaAmortiDetalleDataAccess.TABLENAME, tablaamortidetalle.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(tablaamortidetalle.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TablaAmortiDetalleDataAccess.TABLENAME, tablaamortidetalle.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(TablaAmortiDetalleConstantesFunciones.ISCONAUDITORIADETALLE) {
						////TablaAmortiDetalleLogic.registrarAuditoriaDetallesTablaAmortiDetalle(connexion,tablaamortidetalle,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesTablaAmortiDetalle(Connexion connexion,TablaAmortiDetalle tablaamortidetalle)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(tablaamortidetalle.getIsNew()||!tablaamortidetalle.getid_empresa().equals(tablaamortidetalle.getTablaAmortiDetalleOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tablaamortidetalle.getTablaAmortiDetalleOriginal().getid_empresa()!=null)
				{
					strValorActual=tablaamortidetalle.getTablaAmortiDetalleOriginal().getid_empresa().toString();
				}
				if(tablaamortidetalle.getid_empresa()!=null)
				{
					strValorNuevo=tablaamortidetalle.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TablaAmortiDetalleConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(tablaamortidetalle.getIsNew()||!tablaamortidetalle.getid_sucursal().equals(tablaamortidetalle.getTablaAmortiDetalleOriginal().getid_sucursal()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tablaamortidetalle.getTablaAmortiDetalleOriginal().getid_sucursal()!=null)
				{
					strValorActual=tablaamortidetalle.getTablaAmortiDetalleOriginal().getid_sucursal().toString();
				}
				if(tablaamortidetalle.getid_sucursal()!=null)
				{
					strValorNuevo=tablaamortidetalle.getid_sucursal().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TablaAmortiDetalleConstantesFunciones.IDSUCURSAL,strValorActual,strValorNuevo);
			}	
			
			if(tablaamortidetalle.getIsNew()||!tablaamortidetalle.getid_ejercicio().equals(tablaamortidetalle.getTablaAmortiDetalleOriginal().getid_ejercicio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tablaamortidetalle.getTablaAmortiDetalleOriginal().getid_ejercicio()!=null)
				{
					strValorActual=tablaamortidetalle.getTablaAmortiDetalleOriginal().getid_ejercicio().toString();
				}
				if(tablaamortidetalle.getid_ejercicio()!=null)
				{
					strValorNuevo=tablaamortidetalle.getid_ejercicio().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TablaAmortiDetalleConstantesFunciones.IDEJERCICIO,strValorActual,strValorNuevo);
			}	
			
			if(tablaamortidetalle.getIsNew()||!tablaamortidetalle.getid_periodo().equals(tablaamortidetalle.getTablaAmortiDetalleOriginal().getid_periodo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tablaamortidetalle.getTablaAmortiDetalleOriginal().getid_periodo()!=null)
				{
					strValorActual=tablaamortidetalle.getTablaAmortiDetalleOriginal().getid_periodo().toString();
				}
				if(tablaamortidetalle.getid_periodo()!=null)
				{
					strValorNuevo=tablaamortidetalle.getid_periodo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TablaAmortiDetalleConstantesFunciones.IDPERIODO,strValorActual,strValorNuevo);
			}	
			
			if(tablaamortidetalle.getIsNew()||!tablaamortidetalle.getid_tasa().equals(tablaamortidetalle.getTablaAmortiDetalleOriginal().getid_tasa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tablaamortidetalle.getTablaAmortiDetalleOriginal().getid_tasa()!=null)
				{
					strValorActual=tablaamortidetalle.getTablaAmortiDetalleOriginal().getid_tasa().toString();
				}
				if(tablaamortidetalle.getid_tasa()!=null)
				{
					strValorNuevo=tablaamortidetalle.getid_tasa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TablaAmortiDetalleConstantesFunciones.IDTASA,strValorActual,strValorNuevo);
			}	
			
			if(tablaamortidetalle.getIsNew()||!tablaamortidetalle.getid_factura().equals(tablaamortidetalle.getTablaAmortiDetalleOriginal().getid_factura()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tablaamortidetalle.getTablaAmortiDetalleOriginal().getid_factura()!=null)
				{
					strValorActual=tablaamortidetalle.getTablaAmortiDetalleOriginal().getid_factura().toString();
				}
				if(tablaamortidetalle.getid_factura()!=null)
				{
					strValorNuevo=tablaamortidetalle.getid_factura().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TablaAmortiDetalleConstantesFunciones.IDFACTURA,strValorActual,strValorNuevo);
			}	
			
			if(tablaamortidetalle.getIsNew()||!tablaamortidetalle.getid_tipo_intervalo().equals(tablaamortidetalle.getTablaAmortiDetalleOriginal().getid_tipo_intervalo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tablaamortidetalle.getTablaAmortiDetalleOriginal().getid_tipo_intervalo()!=null)
				{
					strValorActual=tablaamortidetalle.getTablaAmortiDetalleOriginal().getid_tipo_intervalo().toString();
				}
				if(tablaamortidetalle.getid_tipo_intervalo()!=null)
				{
					strValorNuevo=tablaamortidetalle.getid_tipo_intervalo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TablaAmortiDetalleConstantesFunciones.IDTIPOINTERVALO,strValorActual,strValorNuevo);
			}	
			
			if(tablaamortidetalle.getIsNew()||!tablaamortidetalle.getfecha_emision().equals(tablaamortidetalle.getTablaAmortiDetalleOriginal().getfecha_emision()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tablaamortidetalle.getTablaAmortiDetalleOriginal().getfecha_emision()!=null)
				{
					strValorActual=tablaamortidetalle.getTablaAmortiDetalleOriginal().getfecha_emision().toString();
				}
				if(tablaamortidetalle.getfecha_emision()!=null)
				{
					strValorNuevo=tablaamortidetalle.getfecha_emision().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TablaAmortiDetalleConstantesFunciones.FECHAEMISION,strValorActual,strValorNuevo);
			}	
			
			if(tablaamortidetalle.getIsNew()||!tablaamortidetalle.getfecha_vencimiento().equals(tablaamortidetalle.getTablaAmortiDetalleOriginal().getfecha_vencimiento()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tablaamortidetalle.getTablaAmortiDetalleOriginal().getfecha_vencimiento()!=null)
				{
					strValorActual=tablaamortidetalle.getTablaAmortiDetalleOriginal().getfecha_vencimiento().toString();
				}
				if(tablaamortidetalle.getfecha_vencimiento()!=null)
				{
					strValorNuevo=tablaamortidetalle.getfecha_vencimiento().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TablaAmortiDetalleConstantesFunciones.FECHAVENCIMIENTO,strValorActual,strValorNuevo);
			}	
			
			if(tablaamortidetalle.getIsNew()||!tablaamortidetalle.getfecha_inicial().equals(tablaamortidetalle.getTablaAmortiDetalleOriginal().getfecha_inicial()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tablaamortidetalle.getTablaAmortiDetalleOriginal().getfecha_inicial()!=null)
				{
					strValorActual=tablaamortidetalle.getTablaAmortiDetalleOriginal().getfecha_inicial().toString();
				}
				if(tablaamortidetalle.getfecha_inicial()!=null)
				{
					strValorNuevo=tablaamortidetalle.getfecha_inicial().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TablaAmortiDetalleConstantesFunciones.FECHAINICIAL,strValorActual,strValorNuevo);
			}	
			
			if(tablaamortidetalle.getIsNew()||!tablaamortidetalle.getfecha_final().equals(tablaamortidetalle.getTablaAmortiDetalleOriginal().getfecha_final()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tablaamortidetalle.getTablaAmortiDetalleOriginal().getfecha_final()!=null)
				{
					strValorActual=tablaamortidetalle.getTablaAmortiDetalleOriginal().getfecha_final().toString();
				}
				if(tablaamortidetalle.getfecha_final()!=null)
				{
					strValorNuevo=tablaamortidetalle.getfecha_final().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TablaAmortiDetalleConstantesFunciones.FECHAFINAL,strValorActual,strValorNuevo);
			}	
			
			if(tablaamortidetalle.getIsNew()||!tablaamortidetalle.getvalor().equals(tablaamortidetalle.getTablaAmortiDetalleOriginal().getvalor()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tablaamortidetalle.getTablaAmortiDetalleOriginal().getvalor()!=null)
				{
					strValorActual=tablaamortidetalle.getTablaAmortiDetalleOriginal().getvalor().toString();
				}
				if(tablaamortidetalle.getvalor()!=null)
				{
					strValorNuevo=tablaamortidetalle.getvalor().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TablaAmortiDetalleConstantesFunciones.VALOR,strValorActual,strValorNuevo);
			}	
			
			if(tablaamortidetalle.getIsNew()||!tablaamortidetalle.getinteres().equals(tablaamortidetalle.getTablaAmortiDetalleOriginal().getinteres()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tablaamortidetalle.getTablaAmortiDetalleOriginal().getinteres()!=null)
				{
					strValorActual=tablaamortidetalle.getTablaAmortiDetalleOriginal().getinteres().toString();
				}
				if(tablaamortidetalle.getinteres()!=null)
				{
					strValorNuevo=tablaamortidetalle.getinteres().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TablaAmortiDetalleConstantesFunciones.INTERES,strValorActual,strValorNuevo);
			}	
			
			if(tablaamortidetalle.getIsNew()||!tablaamortidetalle.getcapital().equals(tablaamortidetalle.getTablaAmortiDetalleOriginal().getcapital()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tablaamortidetalle.getTablaAmortiDetalleOriginal().getcapital()!=null)
				{
					strValorActual=tablaamortidetalle.getTablaAmortiDetalleOriginal().getcapital().toString();
				}
				if(tablaamortidetalle.getcapital()!=null)
				{
					strValorNuevo=tablaamortidetalle.getcapital().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TablaAmortiDetalleConstantesFunciones.CAPITAL,strValorActual,strValorNuevo);
			}	
			
			if(tablaamortidetalle.getIsNew()||!tablaamortidetalle.getnumero_cuotas().equals(tablaamortidetalle.getTablaAmortiDetalleOriginal().getnumero_cuotas()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tablaamortidetalle.getTablaAmortiDetalleOriginal().getnumero_cuotas()!=null)
				{
					strValorActual=tablaamortidetalle.getTablaAmortiDetalleOriginal().getnumero_cuotas().toString();
				}
				if(tablaamortidetalle.getnumero_cuotas()!=null)
				{
					strValorNuevo=tablaamortidetalle.getnumero_cuotas().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TablaAmortiDetalleConstantesFunciones.NUMEROCUOTA,strValorActual,strValorNuevo);
			}	
			
			if(tablaamortidetalle.getIsNew()||!tablaamortidetalle.getid_anio().equals(tablaamortidetalle.getTablaAmortiDetalleOriginal().getid_anio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tablaamortidetalle.getTablaAmortiDetalleOriginal().getid_anio()!=null)
				{
					strValorActual=tablaamortidetalle.getTablaAmortiDetalleOriginal().getid_anio().toString();
				}
				if(tablaamortidetalle.getid_anio()!=null)
				{
					strValorNuevo=tablaamortidetalle.getid_anio().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TablaAmortiDetalleConstantesFunciones.IDANIO,strValorActual,strValorNuevo);
			}	
			
			if(tablaamortidetalle.getIsNew()||!tablaamortidetalle.getid_mes().equals(tablaamortidetalle.getTablaAmortiDetalleOriginal().getid_mes()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tablaamortidetalle.getTablaAmortiDetalleOriginal().getid_mes()!=null)
				{
					strValorActual=tablaamortidetalle.getTablaAmortiDetalleOriginal().getid_mes().toString();
				}
				if(tablaamortidetalle.getid_mes()!=null)
				{
					strValorNuevo=tablaamortidetalle.getid_mes().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TablaAmortiDetalleConstantesFunciones.IDMES,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveTablaAmortiDetalleRelacionesWithConnection(TablaAmortiDetalle tablaamortidetalle) throws Exception {

		if(!tablaamortidetalle.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveTablaAmortiDetalleRelacionesBase(tablaamortidetalle,true);
		}
	}

	public void saveTablaAmortiDetalleRelaciones(TablaAmortiDetalle tablaamortidetalle)throws Exception {

		if(!tablaamortidetalle.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveTablaAmortiDetalleRelacionesBase(tablaamortidetalle,false);
		}
	}

	public void saveTablaAmortiDetalleRelacionesBase(TablaAmortiDetalle tablaamortidetalle,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("TablaAmortiDetalle-saveRelacionesWithConnection");}
	

			this.setTablaAmortiDetalle(tablaamortidetalle);

			if(TablaAmortiDetalleLogicAdditional.validarSaveRelaciones(tablaamortidetalle,this)) {

				TablaAmortiDetalleLogicAdditional.updateRelacionesToSave(tablaamortidetalle,this);

				if((tablaamortidetalle.getIsNew()||tablaamortidetalle.getIsChanged())&&!tablaamortidetalle.getIsDeleted()) {
					this.saveTablaAmortiDetalle();
					this.saveTablaAmortiDetalleRelacionesDetalles();

				} else if(tablaamortidetalle.getIsDeleted()) {
					this.saveTablaAmortiDetalleRelacionesDetalles();
					this.saveTablaAmortiDetalle();
				}

				TablaAmortiDetalleLogicAdditional.updateRelacionesToSaveAfter(tablaamortidetalle,this);

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
	
	
	private void saveTablaAmortiDetalleRelacionesDetalles()throws Exception {
		try {
	

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfTablaAmortiDetalle(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=TablaAmortiDetalleConstantesFunciones.getClassesForeignKeysOfTablaAmortiDetalle(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTablaAmortiDetalle(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=TablaAmortiDetalleConstantesFunciones.getClassesRelationshipsOfTablaAmortiDetalle(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

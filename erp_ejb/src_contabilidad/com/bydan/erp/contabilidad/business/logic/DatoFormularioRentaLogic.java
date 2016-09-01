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
import com.bydan.erp.contabilidad.util.DatoFormularioRentaConstantesFunciones;
import com.bydan.erp.contabilidad.util.DatoFormularioRentaParameterReturnGeneral;
//import com.bydan.erp.contabilidad.util.DatoFormularioRentaParameterGeneral;
import com.bydan.erp.contabilidad.business.entity.DatoFormularioRenta;
import com.bydan.erp.contabilidad.business.logic.DatoFormularioRentaLogicAdditional;
import com.bydan.erp.contabilidad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;


import com.bydan.erp.seguridad.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;








@SuppressWarnings("unused")
public class DatoFormularioRentaLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(DatoFormularioRentaLogic.class);
	
	protected DatoFormularioRentaDataAccess datoformulariorentaDataAccess; 	
	protected DatoFormularioRenta datoformulariorenta;
	protected List<DatoFormularioRenta> datoformulariorentas;
	protected Object datoformulariorentaObject;	
	protected List<Object> datoformulariorentasObject;
	
	public static ClassValidator<DatoFormularioRenta> datoformulariorentaValidator = new ClassValidator<DatoFormularioRenta>(DatoFormularioRenta.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected DatoFormularioRentaLogicAdditional datoformulariorentaLogicAdditional=null;
	
	public DatoFormularioRentaLogicAdditional getDatoFormularioRentaLogicAdditional() {
		return this.datoformulariorentaLogicAdditional;
	}
	
	public void setDatoFormularioRentaLogicAdditional(DatoFormularioRentaLogicAdditional datoformulariorentaLogicAdditional) {
		try {
			this.datoformulariorentaLogicAdditional=datoformulariorentaLogicAdditional;
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
	
	
	
	
	public  DatoFormularioRentaLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.datoformulariorentaDataAccess = new DatoFormularioRentaDataAccess();
			
			this.datoformulariorentas= new ArrayList<DatoFormularioRenta>();
			this.datoformulariorenta= new DatoFormularioRenta();
			
			this.datoformulariorentaObject=new Object();
			this.datoformulariorentasObject=new ArrayList<Object>();
				
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
			
			this.datoformulariorentaDataAccess.setConnexionType(this.connexionType);
			this.datoformulariorentaDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  DatoFormularioRentaLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.datoformulariorentaDataAccess = new DatoFormularioRentaDataAccess();
			this.datoformulariorentas= new ArrayList<DatoFormularioRenta>();
			this.datoformulariorenta= new DatoFormularioRenta();
			this.datoformulariorentaObject=new Object();
			this.datoformulariorentasObject=new ArrayList<Object>();
			
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
			
			this.datoformulariorentaDataAccess.setConnexionType(this.connexionType);
			this.datoformulariorentaDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public DatoFormularioRenta getDatoFormularioRenta() throws Exception {	
		DatoFormularioRentaLogicAdditional.checkDatoFormularioRentaToGet(datoformulariorenta,this.datosCliente,this.arrDatoGeneral);
		DatoFormularioRentaLogicAdditional.updateDatoFormularioRentaToGet(datoformulariorenta,this.arrDatoGeneral);
		
		return datoformulariorenta;
	}
		
	public void setDatoFormularioRenta(DatoFormularioRenta newDatoFormularioRenta) {
		this.datoformulariorenta = newDatoFormularioRenta;
	}
	
	public DatoFormularioRentaDataAccess getDatoFormularioRentaDataAccess() {
		return datoformulariorentaDataAccess;
	}
	
	public void setDatoFormularioRentaDataAccess(DatoFormularioRentaDataAccess newdatoformulariorentaDataAccess) {
		this.datoformulariorentaDataAccess = newdatoformulariorentaDataAccess;
	}
	
	public List<DatoFormularioRenta> getDatoFormularioRentas() throws Exception {		
		this.quitarDatoFormularioRentasNulos();
		
		DatoFormularioRentaLogicAdditional.checkDatoFormularioRentaToGets(datoformulariorentas,this.datosCliente,this.arrDatoGeneral);
		
		for (DatoFormularioRenta datoformulariorentaLocal: datoformulariorentas ) {
			DatoFormularioRentaLogicAdditional.updateDatoFormularioRentaToGet(datoformulariorentaLocal,this.arrDatoGeneral);
		}
		
		return datoformulariorentas;
	}
	
	public void setDatoFormularioRentas(List<DatoFormularioRenta> newDatoFormularioRentas) {
		this.datoformulariorentas = newDatoFormularioRentas;
	}
	
	public Object getDatoFormularioRentaObject() {	
		this.datoformulariorentaObject=this.datoformulariorentaDataAccess.getEntityObject();
		return this.datoformulariorentaObject;
	}
		
	public void setDatoFormularioRentaObject(Object newDatoFormularioRentaObject) {
		this.datoformulariorentaObject = newDatoFormularioRentaObject;
	}
	
	public List<Object> getDatoFormularioRentasObject() {		
		this.datoformulariorentasObject=this.datoformulariorentaDataAccess.getEntitiesObject();
		return this.datoformulariorentasObject;
	}
		
	public void setDatoFormularioRentasObject(List<Object> newDatoFormularioRentasObject) {
		this.datoformulariorentasObject = newDatoFormularioRentasObject;
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
		
		if(this.datoformulariorentaDataAccess!=null) {
			this.datoformulariorentaDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DatoFormularioRenta.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			datoformulariorentaDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			datoformulariorentaDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		datoformulariorenta = new  DatoFormularioRenta();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DatoFormularioRenta.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			datoformulariorenta=datoformulariorentaDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.datoformulariorenta,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				DatoFormularioRentaConstantesFunciones.refrescarForeignKeysDescripcionesDatoFormularioRenta(this.datoformulariorenta);
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
		datoformulariorenta = new  DatoFormularioRenta();
		  		  
        try {
			
			datoformulariorenta=datoformulariorentaDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.datoformulariorenta,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				DatoFormularioRentaConstantesFunciones.refrescarForeignKeysDescripcionesDatoFormularioRenta(this.datoformulariorenta);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		datoformulariorenta = new  DatoFormularioRenta();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DatoFormularioRenta.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			datoformulariorenta=datoformulariorentaDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.datoformulariorenta,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				DatoFormularioRentaConstantesFunciones.refrescarForeignKeysDescripcionesDatoFormularioRenta(this.datoformulariorenta);
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
		datoformulariorenta = new  DatoFormularioRenta();
		  		  
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
		datoformulariorenta = new  DatoFormularioRenta();
		  		  
        try {
			
			datoformulariorenta=datoformulariorentaDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.datoformulariorenta,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				DatoFormularioRentaConstantesFunciones.refrescarForeignKeysDescripcionesDatoFormularioRenta(this.datoformulariorenta);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		datoformulariorenta = new  DatoFormularioRenta();
		  		  
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
		datoformulariorenta = new  DatoFormularioRenta();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DatoFormularioRenta.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =datoformulariorentaDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		datoformulariorenta = new  DatoFormularioRenta();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=datoformulariorentaDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		datoformulariorenta = new  DatoFormularioRenta();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DatoFormularioRenta.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =datoformulariorentaDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		datoformulariorenta = new  DatoFormularioRenta();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=datoformulariorentaDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		datoformulariorenta = new  DatoFormularioRenta();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DatoFormularioRenta.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =datoformulariorentaDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		datoformulariorenta = new  DatoFormularioRenta();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=datoformulariorentaDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		datoformulariorentas = new  ArrayList<DatoFormularioRenta>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DatoFormularioRenta.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			DatoFormularioRentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			datoformulariorentas=datoformulariorentaDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarDatoFormularioRenta(datoformulariorentas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DatoFormularioRentaConstantesFunciones.refrescarForeignKeysDescripcionesDatoFormularioRenta(this.datoformulariorentas);
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
		datoformulariorentas = new  ArrayList<DatoFormularioRenta>();
		  		  
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
		datoformulariorentas = new  ArrayList<DatoFormularioRenta>();
		  		  
        try {			
			DatoFormularioRentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			datoformulariorentas=datoformulariorentaDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarDatoFormularioRenta(datoformulariorentas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DatoFormularioRentaConstantesFunciones.refrescarForeignKeysDescripcionesDatoFormularioRenta(this.datoformulariorentas);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		datoformulariorentas = new  ArrayList<DatoFormularioRenta>();
		  		  
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
		datoformulariorentas = new  ArrayList<DatoFormularioRenta>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DatoFormularioRenta.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			DatoFormularioRentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			datoformulariorentas=datoformulariorentaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarDatoFormularioRenta(datoformulariorentas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DatoFormularioRentaConstantesFunciones.refrescarForeignKeysDescripcionesDatoFormularioRenta(this.datoformulariorentas);
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
		datoformulariorentas = new  ArrayList<DatoFormularioRenta>();
		  		  
        try {
			DatoFormularioRentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			datoformulariorentas=datoformulariorentaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarDatoFormularioRenta(datoformulariorentas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DatoFormularioRentaConstantesFunciones.refrescarForeignKeysDescripcionesDatoFormularioRenta(this.datoformulariorentas);
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
		datoformulariorentas = new  ArrayList<DatoFormularioRenta>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DatoFormularioRenta.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DatoFormularioRentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			datoformulariorentas=datoformulariorentaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarDatoFormularioRenta(datoformulariorentas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DatoFormularioRentaConstantesFunciones.refrescarForeignKeysDescripcionesDatoFormularioRenta(this.datoformulariorentas);
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
		datoformulariorentas = new  ArrayList<DatoFormularioRenta>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DatoFormularioRentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			datoformulariorentas=datoformulariorentaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarDatoFormularioRenta(datoformulariorentas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DatoFormularioRentaConstantesFunciones.refrescarForeignKeysDescripcionesDatoFormularioRenta(this.datoformulariorentas);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		datoformulariorenta = new  DatoFormularioRenta();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DatoFormularioRenta.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DatoFormularioRentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			datoformulariorenta=datoformulariorentaDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarDatoFormularioRenta(datoformulariorenta);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DatoFormularioRentaConstantesFunciones.refrescarForeignKeysDescripcionesDatoFormularioRenta(this.datoformulariorenta);
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
		datoformulariorenta = new  DatoFormularioRenta();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DatoFormularioRentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			datoformulariorenta=datoformulariorentaDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarDatoFormularioRenta(datoformulariorenta);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DatoFormularioRentaConstantesFunciones.refrescarForeignKeysDescripcionesDatoFormularioRenta(this.datoformulariorenta);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		datoformulariorentas = new  ArrayList<DatoFormularioRenta>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DatoFormularioRenta.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			DatoFormularioRentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			datoformulariorentas=datoformulariorentaDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarDatoFormularioRenta(datoformulariorentas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DatoFormularioRentaConstantesFunciones.refrescarForeignKeysDescripcionesDatoFormularioRenta(this.datoformulariorentas);
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
		datoformulariorentas = new  ArrayList<DatoFormularioRenta>();
		  		  
        try {
			DatoFormularioRentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			datoformulariorentas=datoformulariorentaDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarDatoFormularioRenta(datoformulariorentas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DatoFormularioRentaConstantesFunciones.refrescarForeignKeysDescripcionesDatoFormularioRenta(this.datoformulariorentas);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosDatoFormularioRentasWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		datoformulariorentas = new  ArrayList<DatoFormularioRenta>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DatoFormularioRenta.class.getSimpleName()+"-getTodosDatoFormularioRentasWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DatoFormularioRentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			datoformulariorentas=datoformulariorentaDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarDatoFormularioRenta(datoformulariorentas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DatoFormularioRentaConstantesFunciones.refrescarForeignKeysDescripcionesDatoFormularioRenta(this.datoformulariorentas);
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
	
	public  void  getTodosDatoFormularioRentas(String sFinalQuery,Pagination pagination)throws Exception {
		datoformulariorentas = new  ArrayList<DatoFormularioRenta>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DatoFormularioRentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			datoformulariorentas=datoformulariorentaDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarDatoFormularioRenta(datoformulariorentas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DatoFormularioRentaConstantesFunciones.refrescarForeignKeysDescripcionesDatoFormularioRenta(this.datoformulariorentas);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarDatoFormularioRenta(DatoFormularioRenta datoformulariorenta) throws Exception {
		Boolean estaValidado=false;
		
		if(datoformulariorenta.getIsNew() || datoformulariorenta.getIsChanged()) { 
			this.invalidValues = datoformulariorentaValidator.getInvalidValues(datoformulariorenta);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(datoformulariorenta);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarDatoFormularioRenta(List<DatoFormularioRenta> DatoFormularioRentas) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(DatoFormularioRenta datoformulariorentaLocal:datoformulariorentas) {				
			estaValidadoObjeto=this.validarGuardarDatoFormularioRenta(datoformulariorentaLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarDatoFormularioRenta(List<DatoFormularioRenta> DatoFormularioRentas) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarDatoFormularioRenta(datoformulariorentas)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarDatoFormularioRenta(DatoFormularioRenta DatoFormularioRenta) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarDatoFormularioRenta(datoformulariorenta)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(DatoFormularioRenta datoformulariorenta) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+datoformulariorenta.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=DatoFormularioRentaConstantesFunciones.getDatoFormularioRentaLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"datoformulariorenta","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(DatoFormularioRentaConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(DatoFormularioRentaConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveDatoFormularioRentaWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DatoFormularioRenta.class.getSimpleName()+"-saveDatoFormularioRentaWithConnection");connexion.begin();			
			
			DatoFormularioRentaLogicAdditional.checkDatoFormularioRentaToSave(this.datoformulariorenta,this.datosCliente,connexion,this.arrDatoGeneral);
			
			DatoFormularioRentaLogicAdditional.updateDatoFormularioRentaToSave(this.datoformulariorenta,this.arrDatoGeneral);
			
			DatoFormularioRentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.datoformulariorenta,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowDatoFormularioRenta();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarDatoFormularioRenta(this.datoformulariorenta)) {
				DatoFormularioRentaDataAccess.save(this.datoformulariorenta, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.datoformulariorenta,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			DatoFormularioRentaLogicAdditional.checkDatoFormularioRentaToSaveAfter(this.datoformulariorenta,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowDatoFormularioRenta();
			
			connexion.commit();			
			
			if(this.datoformulariorenta.getIsDeleted()) {
				this.datoformulariorenta=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveDatoFormularioRenta()throws Exception {	
		try {	
			
			DatoFormularioRentaLogicAdditional.checkDatoFormularioRentaToSave(this.datoformulariorenta,this.datosCliente,connexion,this.arrDatoGeneral);
			
			DatoFormularioRentaLogicAdditional.updateDatoFormularioRentaToSave(this.datoformulariorenta,this.arrDatoGeneral);
			
			DatoFormularioRentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.datoformulariorenta,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarDatoFormularioRenta(this.datoformulariorenta)) {			
				DatoFormularioRentaDataAccess.save(this.datoformulariorenta, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.datoformulariorenta,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			DatoFormularioRentaLogicAdditional.checkDatoFormularioRentaToSaveAfter(this.datoformulariorenta,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.datoformulariorenta.getIsDeleted()) {
				this.datoformulariorenta=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveDatoFormularioRentasWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DatoFormularioRenta.class.getSimpleName()+"-saveDatoFormularioRentasWithConnection");connexion.begin();			
			
			DatoFormularioRentaLogicAdditional.checkDatoFormularioRentaToSaves(datoformulariorentas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowDatoFormularioRentas();
			
			Boolean validadoTodosDatoFormularioRenta=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(DatoFormularioRenta datoformulariorentaLocal:datoformulariorentas) {		
				if(datoformulariorentaLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				DatoFormularioRentaLogicAdditional.updateDatoFormularioRentaToSave(datoformulariorentaLocal,this.arrDatoGeneral);
	        	
				DatoFormularioRentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),datoformulariorentaLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarDatoFormularioRenta(datoformulariorentaLocal)) {
					DatoFormularioRentaDataAccess.save(datoformulariorentaLocal, connexion);				
				} else {
					validadoTodosDatoFormularioRenta=false;
				}
			}
			
			if(!validadoTodosDatoFormularioRenta) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			DatoFormularioRentaLogicAdditional.checkDatoFormularioRentaToSavesAfter(datoformulariorentas,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowDatoFormularioRentas();
			
			connexion.commit();		
			
			this.quitarDatoFormularioRentasEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveDatoFormularioRentas()throws Exception {				
		 try {	
			DatoFormularioRentaLogicAdditional.checkDatoFormularioRentaToSaves(datoformulariorentas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosDatoFormularioRenta=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(DatoFormularioRenta datoformulariorentaLocal:datoformulariorentas) {				
				if(datoformulariorentaLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				DatoFormularioRentaLogicAdditional.updateDatoFormularioRentaToSave(datoformulariorentaLocal,this.arrDatoGeneral);
	        	
				DatoFormularioRentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),datoformulariorentaLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarDatoFormularioRenta(datoformulariorentaLocal)) {				
					DatoFormularioRentaDataAccess.save(datoformulariorentaLocal, connexion);				
				} else {
					validadoTodosDatoFormularioRenta=false;
				}
			}
			
			if(!validadoTodosDatoFormularioRenta) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			DatoFormularioRentaLogicAdditional.checkDatoFormularioRentaToSavesAfter(datoformulariorentas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarDatoFormularioRentasEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public DatoFormularioRentaParameterReturnGeneral procesarAccionDatoFormularioRentas(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<DatoFormularioRenta> datoformulariorentas,DatoFormularioRentaParameterReturnGeneral datoformulariorentaParameterGeneral)throws Exception {
		 try {	
			DatoFormularioRentaParameterReturnGeneral datoformulariorentaReturnGeneral=new DatoFormularioRentaParameterReturnGeneral();
	
			DatoFormularioRentaLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,datoformulariorentas,datoformulariorentaParameterGeneral,datoformulariorentaReturnGeneral);
			
			return datoformulariorentaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public DatoFormularioRentaParameterReturnGeneral procesarAccionDatoFormularioRentasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<DatoFormularioRenta> datoformulariorentas,DatoFormularioRentaParameterReturnGeneral datoformulariorentaParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DatoFormularioRenta.class.getSimpleName()+"-procesarAccionDatoFormularioRentasWithConnection");connexion.begin();			
			
			DatoFormularioRentaParameterReturnGeneral datoformulariorentaReturnGeneral=new DatoFormularioRentaParameterReturnGeneral();
	
			DatoFormularioRentaLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,datoformulariorentas,datoformulariorentaParameterGeneral,datoformulariorentaReturnGeneral);
			
			this.connexion.commit();
			
			return datoformulariorentaReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public DatoFormularioRentaParameterReturnGeneral procesarEventosDatoFormularioRentas(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<DatoFormularioRenta> datoformulariorentas,DatoFormularioRenta datoformulariorenta,DatoFormularioRentaParameterReturnGeneral datoformulariorentaParameterGeneral,Boolean isEsNuevoDatoFormularioRenta,ArrayList<Classe> clases)throws Exception {
		 try {	
			DatoFormularioRentaParameterReturnGeneral datoformulariorentaReturnGeneral=new DatoFormularioRentaParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				datoformulariorentaReturnGeneral.setConRecargarPropiedades(true);
			}
			
			DatoFormularioRentaLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,datoformulariorentas,datoformulariorenta,datoformulariorentaParameterGeneral,datoformulariorentaReturnGeneral,isEsNuevoDatoFormularioRenta,clases);
			
			return datoformulariorentaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public DatoFormularioRentaParameterReturnGeneral procesarEventosDatoFormularioRentasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<DatoFormularioRenta> datoformulariorentas,DatoFormularioRenta datoformulariorenta,DatoFormularioRentaParameterReturnGeneral datoformulariorentaParameterGeneral,Boolean isEsNuevoDatoFormularioRenta,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DatoFormularioRenta.class.getSimpleName()+"-procesarEventosDatoFormularioRentasWithConnection");connexion.begin();			
			
			DatoFormularioRentaParameterReturnGeneral datoformulariorentaReturnGeneral=new DatoFormularioRentaParameterReturnGeneral();
	
			datoformulariorentaReturnGeneral.setDatoFormularioRenta(datoformulariorenta);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				datoformulariorentaReturnGeneral.setConRecargarPropiedades(true);
			}
			
			DatoFormularioRentaLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,datoformulariorentas,datoformulariorenta,datoformulariorentaParameterGeneral,datoformulariorentaReturnGeneral,isEsNuevoDatoFormularioRenta,clases);
			
			this.connexion.commit();
			
			return datoformulariorentaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public DatoFormularioRentaParameterReturnGeneral procesarImportacionDatoFormularioRentasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,DatoFormularioRentaParameterReturnGeneral datoformulariorentaParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DatoFormularioRenta.class.getSimpleName()+"-procesarImportacionDatoFormularioRentasWithConnection");connexion.begin();			
			
			DatoFormularioRentaParameterReturnGeneral datoformulariorentaReturnGeneral=new DatoFormularioRentaParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.datoformulariorentas=new ArrayList<DatoFormularioRenta>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.datoformulariorenta=new DatoFormularioRenta();
				
				
				if(conColumnasBase) {this.datoformulariorenta.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.datoformulariorenta.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.datoformulariorenta.setes_sustitutiva(Boolean.parseBoolean(arrColumnas[iColumn++]));
				this.datoformulariorenta.setnumero_formulario(arrColumnas[iColumn++]);
				this.datoformulariorenta.setcedula_representante(arrColumnas[iColumn++]);
				this.datoformulariorenta.setnumero_fiscal(arrColumnas[iColumn++]);
				
				this.datoformulariorentas.add(this.datoformulariorenta);
			}
			
			this.saveDatoFormularioRentas();
			
			this.connexion.commit();
			
			datoformulariorentaReturnGeneral.setConRetornoEstaProcesado(true);
			datoformulariorentaReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return datoformulariorentaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarDatoFormularioRentasEliminados() throws Exception {				
		
		List<DatoFormularioRenta> datoformulariorentasAux= new ArrayList<DatoFormularioRenta>();
		
		for(DatoFormularioRenta datoformulariorenta:datoformulariorentas) {
			if(!datoformulariorenta.getIsDeleted()) {
				datoformulariorentasAux.add(datoformulariorenta);
			}
		}
		
		datoformulariorentas=datoformulariorentasAux;
	}
	
	public void quitarDatoFormularioRentasNulos() throws Exception {				
		
		List<DatoFormularioRenta> datoformulariorentasAux= new ArrayList<DatoFormularioRenta>();
		
		for(DatoFormularioRenta datoformulariorenta : this.datoformulariorentas) {
			if(datoformulariorenta==null) {
				datoformulariorentasAux.add(datoformulariorenta);
			}
		}
		
		//this.datoformulariorentas=datoformulariorentasAux;
		
		this.datoformulariorentas.removeAll(datoformulariorentasAux);
	}
	
	public void getSetVersionRowDatoFormularioRentaWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(datoformulariorenta.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((datoformulariorenta.getIsDeleted() || (datoformulariorenta.getIsChanged()&&!datoformulariorenta.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=datoformulariorentaDataAccess.getSetVersionRowDatoFormularioRenta(connexion,datoformulariorenta.getId());
				
				if(!datoformulariorenta.getVersionRow().equals(timestamp)) {	
					datoformulariorenta.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				datoformulariorenta.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowDatoFormularioRenta()throws Exception {	
		
		if(datoformulariorenta.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((datoformulariorenta.getIsDeleted() || (datoformulariorenta.getIsChanged()&&!datoformulariorenta.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=datoformulariorentaDataAccess.getSetVersionRowDatoFormularioRenta(connexion,datoformulariorenta.getId());
			
			try {							
				if(!datoformulariorenta.getVersionRow().equals(timestamp)) {	
					datoformulariorenta.setVersionRow(timestamp);
				}
				
				datoformulariorenta.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowDatoFormularioRentasWithConnection()throws Exception {	
		if(datoformulariorentas!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(DatoFormularioRenta datoformulariorentaAux:datoformulariorentas) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(datoformulariorentaAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(datoformulariorentaAux.getIsDeleted() || (datoformulariorentaAux.getIsChanged()&&!datoformulariorentaAux.getIsNew())) {
						
						timestamp=datoformulariorentaDataAccess.getSetVersionRowDatoFormularioRenta(connexion,datoformulariorentaAux.getId());
						
						if(!datoformulariorenta.getVersionRow().equals(timestamp)) {	
							datoformulariorentaAux.setVersionRow(timestamp);
						}
								
						datoformulariorentaAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowDatoFormularioRentas()throws Exception {	
		if(datoformulariorentas!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(DatoFormularioRenta datoformulariorentaAux:datoformulariorentas) {
					if(datoformulariorentaAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(datoformulariorentaAux.getIsDeleted() || (datoformulariorentaAux.getIsChanged()&&!datoformulariorentaAux.getIsNew())) {
						
						timestamp=datoformulariorentaDataAccess.getSetVersionRowDatoFormularioRenta(connexion,datoformulariorentaAux.getId());
						
						if(!datoformulariorentaAux.getVersionRow().equals(timestamp)) {	
							datoformulariorentaAux.setVersionRow(timestamp);
						}
						
													
						datoformulariorentaAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public DatoFormularioRentaParameterReturnGeneral cargarCombosLoteForeignKeyDatoFormularioRentaWithConnection(String finalQueryGlobalAnio,String finalQueryGlobalMes) throws Exception {
		DatoFormularioRentaParameterReturnGeneral  datoformulariorentaReturnGeneral =new DatoFormularioRentaParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DatoFormularioRenta.class.getSimpleName()+"-cargarCombosLoteForeignKeyDatoFormularioRentaWithConnection");connexion.begin();
			
			datoformulariorentaReturnGeneral =new DatoFormularioRentaParameterReturnGeneral();
			
			

			List<Anio> aniosForeignKey=new ArrayList<Anio>();
			AnioLogic anioLogic=new AnioLogic();
			anioLogic.setConnexion(this.connexion);
			anioLogic.getAnioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalAnio.equals("NONE")) {
				anioLogic.getTodosAnios(finalQueryGlobalAnio,new Pagination());
				aniosForeignKey=anioLogic.getAnios();
			}

			datoformulariorentaReturnGeneral.setaniosForeignKey(aniosForeignKey);


			List<Mes> messForeignKey=new ArrayList<Mes>();
			MesLogic mesLogic=new MesLogic();
			mesLogic.setConnexion(this.connexion);
			mesLogic.getMesDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalMes.equals("NONE")) {
				mesLogic.getTodosMess(finalQueryGlobalMes,new Pagination());
				messForeignKey=mesLogic.getMess();
			}

			datoformulariorentaReturnGeneral.setmessForeignKey(messForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return datoformulariorentaReturnGeneral;
	}
	
	public DatoFormularioRentaParameterReturnGeneral cargarCombosLoteForeignKeyDatoFormularioRenta(String finalQueryGlobalAnio,String finalQueryGlobalMes) throws Exception {
		DatoFormularioRentaParameterReturnGeneral  datoformulariorentaReturnGeneral =new DatoFormularioRentaParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			datoformulariorentaReturnGeneral =new DatoFormularioRentaParameterReturnGeneral();
			
			

			List<Anio> aniosForeignKey=new ArrayList<Anio>();
			AnioLogic anioLogic=new AnioLogic();
			anioLogic.setConnexion(this.connexion);
			anioLogic.getAnioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalAnio.equals("NONE")) {
				anioLogic.getTodosAnios(finalQueryGlobalAnio,new Pagination());
				aniosForeignKey=anioLogic.getAnios();
			}

			datoformulariorentaReturnGeneral.setaniosForeignKey(aniosForeignKey);


			List<Mes> messForeignKey=new ArrayList<Mes>();
			MesLogic mesLogic=new MesLogic();
			mesLogic.setConnexion(this.connexion);
			mesLogic.getMesDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalMes.equals("NONE")) {
				mesLogic.getTodosMess(finalQueryGlobalMes,new Pagination());
				messForeignKey=mesLogic.getMess();
			}

			datoformulariorentaReturnGeneral.setmessForeignKey(messForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return datoformulariorentaReturnGeneral;
	}
	
	public void cargarRelacionesLoteForeignKeyDatoFormularioRentaWithConnection() throws Exception {
		ArrayList<Classe> classes=new ArrayList<Classe>();		
		
		
			FormularioRentaLogic formulariorentaLogic=new FormularioRentaLogic();
			FormularioRentaExtraLogic formulariorentaextraLogic=new FormularioRentaExtraLogic();
		
		try {
			
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DatoFormularioRenta.class.getSimpleName()+"-cargarRelacionesLoteForeignKeyDatoFormularioRentaWithConnection");connexion.begin();
			
			
			classes.add(new Classe(FormularioRenta.class));
			classes.add(new Classe(FormularioRentaExtra.class));
											
			

			formulariorentaLogic.setConnexion(this.getConnexion());
			formulariorentaLogic.setDatosCliente(this.datosCliente);
			formulariorentaLogic.setIsConRefrescarForeignKeys(true);

			formulariorentaextraLogic.setConnexion(this.getConnexion());
			formulariorentaextraLogic.setDatosCliente(this.datosCliente);
			formulariorentaextraLogic.setIsConRefrescarForeignKeys(true);
			
			this.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
			
			for(DatoFormularioRenta datoformulariorenta:this.datoformulariorentas) {
				

				classes=new ArrayList<Classe>();
				classes=FormularioRentaConstantesFunciones.getClassesForeignKeysOfFormularioRenta(new ArrayList<Classe>(),DeepLoadType.NONE);

				formulariorentaLogic.setFormularioRentas(datoformulariorenta.formulariorentas);
				formulariorentaLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=FormularioRentaExtraConstantesFunciones.getClassesForeignKeysOfFormularioRentaExtra(new ArrayList<Classe>(),DeepLoadType.NONE);

				formulariorentaextraLogic.setFormularioRentaExtras(datoformulariorenta.formulariorentaextras);
				formulariorentaextraLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
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
	
	public void deepLoad(DatoFormularioRenta datoformulariorenta,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			DatoFormularioRentaLogicAdditional.updateDatoFormularioRentaToGet(datoformulariorenta,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		datoformulariorenta.setAnio(datoformulariorentaDataAccess.getAnio(connexion,datoformulariorenta));
		datoformulariorenta.setMes(datoformulariorentaDataAccess.getMes(connexion,datoformulariorenta));
		datoformulariorenta.setFormularioRentas(datoformulariorentaDataAccess.getFormularioRentas(connexion,datoformulariorenta));
		datoformulariorenta.setFormularioRentaExtras(datoformulariorentaDataAccess.getFormularioRentaExtras(connexion,datoformulariorenta));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Anio.class)) {
				datoformulariorenta.setAnio(datoformulariorentaDataAccess.getAnio(connexion,datoformulariorenta));
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				datoformulariorenta.setMes(datoformulariorentaDataAccess.getMes(connexion,datoformulariorenta));
				continue;
			}

			if(clas.clas.equals(FormularioRenta.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				datoformulariorenta.setFormularioRentas(datoformulariorentaDataAccess.getFormularioRentas(connexion,datoformulariorenta));

				if(this.isConDeep) {
					FormularioRentaLogic formulariorentaLogic= new FormularioRentaLogic(this.connexion);
					formulariorentaLogic.setFormularioRentas(datoformulariorenta.getFormularioRentas());
					ArrayList<Classe> classesLocal=FormularioRentaConstantesFunciones.getClassesForeignKeysOfFormularioRenta(new ArrayList<Classe>(),DeepLoadType.NONE);
					formulariorentaLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					FormularioRentaConstantesFunciones.refrescarForeignKeysDescripcionesFormularioRenta(formulariorentaLogic.getFormularioRentas());
					datoformulariorenta.setFormularioRentas(formulariorentaLogic.getFormularioRentas());
				}

				continue;
			}

			if(clas.clas.equals(FormularioRentaExtra.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				datoformulariorenta.setFormularioRentaExtras(datoformulariorentaDataAccess.getFormularioRentaExtras(connexion,datoformulariorenta));

				if(this.isConDeep) {
					FormularioRentaExtraLogic formulariorentaextraLogic= new FormularioRentaExtraLogic(this.connexion);
					formulariorentaextraLogic.setFormularioRentaExtras(datoformulariorenta.getFormularioRentaExtras());
					ArrayList<Classe> classesLocal=FormularioRentaExtraConstantesFunciones.getClassesForeignKeysOfFormularioRentaExtra(new ArrayList<Classe>(),DeepLoadType.NONE);
					formulariorentaextraLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					FormularioRentaExtraConstantesFunciones.refrescarForeignKeysDescripcionesFormularioRentaExtra(formulariorentaextraLogic.getFormularioRentaExtras());
					datoformulariorenta.setFormularioRentaExtras(formulariorentaextraLogic.getFormularioRentaExtras());
				}

				continue;
			}
		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Anio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			datoformulariorenta.setAnio(datoformulariorentaDataAccess.getAnio(connexion,datoformulariorenta));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Mes.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			datoformulariorenta.setMes(datoformulariorentaDataAccess.getMes(connexion,datoformulariorenta));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(FormularioRenta.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(FormularioRenta.class));
			datoformulariorenta.setFormularioRentas(datoformulariorentaDataAccess.getFormularioRentas(connexion,datoformulariorenta));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(FormularioRentaExtra.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(FormularioRentaExtra.class));
			datoformulariorenta.setFormularioRentaExtras(datoformulariorentaDataAccess.getFormularioRentaExtras(connexion,datoformulariorenta));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		datoformulariorenta.setAnio(datoformulariorentaDataAccess.getAnio(connexion,datoformulariorenta));
		AnioLogic anioLogic= new AnioLogic(connexion);
		anioLogic.deepLoad(datoformulariorenta.getAnio(),isDeep,deepLoadType,clases);
				
		datoformulariorenta.setMes(datoformulariorentaDataAccess.getMes(connexion,datoformulariorenta));
		MesLogic mesLogic= new MesLogic(connexion);
		mesLogic.deepLoad(datoformulariorenta.getMes(),isDeep,deepLoadType,clases);
				

		datoformulariorenta.setFormularioRentas(datoformulariorentaDataAccess.getFormularioRentas(connexion,datoformulariorenta));

		for(FormularioRenta formulariorenta:datoformulariorenta.getFormularioRentas()) {
			FormularioRentaLogic formulariorentaLogic= new FormularioRentaLogic(connexion);
			formulariorentaLogic.deepLoad(formulariorenta,isDeep,deepLoadType,clases);
		}

		datoformulariorenta.setFormularioRentaExtras(datoformulariorentaDataAccess.getFormularioRentaExtras(connexion,datoformulariorenta));

		for(FormularioRentaExtra formulariorentaextra:datoformulariorenta.getFormularioRentaExtras()) {
			FormularioRentaExtraLogic formulariorentaextraLogic= new FormularioRentaExtraLogic(connexion);
			formulariorentaextraLogic.deepLoad(formulariorentaextra,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Anio.class)) {
				datoformulariorenta.setAnio(datoformulariorentaDataAccess.getAnio(connexion,datoformulariorenta));
				AnioLogic anioLogic= new AnioLogic(connexion);
				anioLogic.deepLoad(datoformulariorenta.getAnio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				datoformulariorenta.setMes(datoformulariorentaDataAccess.getMes(connexion,datoformulariorenta));
				MesLogic mesLogic= new MesLogic(connexion);
				mesLogic.deepLoad(datoformulariorenta.getMes(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(FormularioRenta.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				datoformulariorenta.setFormularioRentas(datoformulariorentaDataAccess.getFormularioRentas(connexion,datoformulariorenta));

				for(FormularioRenta formulariorenta:datoformulariorenta.getFormularioRentas()) {
					FormularioRentaLogic formulariorentaLogic= new FormularioRentaLogic(connexion);
					formulariorentaLogic.deepLoad(formulariorenta,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(FormularioRentaExtra.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				datoformulariorenta.setFormularioRentaExtras(datoformulariorentaDataAccess.getFormularioRentaExtras(connexion,datoformulariorenta));

				for(FormularioRentaExtra formulariorentaextra:datoformulariorenta.getFormularioRentaExtras()) {
					FormularioRentaExtraLogic formulariorentaextraLogic= new FormularioRentaExtraLogic(connexion);
					formulariorentaextraLogic.deepLoad(formulariorentaextra,isDeep,deepLoadType,clases);
				}
				continue;
			}

		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {


		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Anio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			datoformulariorenta.setAnio(datoformulariorentaDataAccess.getAnio(connexion,datoformulariorenta));
			AnioLogic anioLogic= new AnioLogic(connexion);
			anioLogic.deepLoad(datoformulariorenta.getAnio(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Mes.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			datoformulariorenta.setMes(datoformulariorentaDataAccess.getMes(connexion,datoformulariorenta));
			MesLogic mesLogic= new MesLogic(connexion);
			mesLogic.deepLoad(datoformulariorenta.getMes(),isDeep,deepLoadType,clases);
				
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(FormularioRenta.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(FormularioRenta.class));
			datoformulariorenta.setFormularioRentas(datoformulariorentaDataAccess.getFormularioRentas(connexion,datoformulariorenta));

			for(FormularioRenta formulariorenta:datoformulariorenta.getFormularioRentas()) {
				FormularioRentaLogic formulariorentaLogic= new FormularioRentaLogic(connexion);
				formulariorentaLogic.deepLoad(formulariorenta,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(FormularioRentaExtra.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(FormularioRentaExtra.class));
			datoformulariorenta.setFormularioRentaExtras(datoformulariorentaDataAccess.getFormularioRentaExtras(connexion,datoformulariorenta));

			for(FormularioRentaExtra formulariorentaextra:datoformulariorenta.getFormularioRentaExtras()) {
				FormularioRentaExtraLogic formulariorentaextraLogic= new FormularioRentaExtraLogic(connexion);
				formulariorentaextraLogic.deepLoad(formulariorentaextra,isDeep,deepLoadType,clases);
			}
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(DatoFormularioRenta datoformulariorenta,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			DatoFormularioRentaLogicAdditional.updateDatoFormularioRentaToSave(datoformulariorenta,this.arrDatoGeneral);
			
DatoFormularioRentaDataAccess.save(datoformulariorenta, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		AnioDataAccess.save(datoformulariorenta.getAnio(),connexion);

		MesDataAccess.save(datoformulariorenta.getMes(),connexion);

		for(FormularioRenta formulariorenta:datoformulariorenta.getFormularioRentas()) {
			formulariorenta.setid_dato_formulario_renta(datoformulariorenta.getId());
			FormularioRentaDataAccess.save(formulariorenta,connexion);
		}

		for(FormularioRentaExtra formulariorentaextra:datoformulariorenta.getFormularioRentaExtras()) {
			formulariorentaextra.setid_dato_formulario_renta(datoformulariorenta.getId());
			FormularioRentaExtraDataAccess.save(formulariorentaextra,connexion);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Anio.class)) {
				AnioDataAccess.save(datoformulariorenta.getAnio(),connexion);
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				MesDataAccess.save(datoformulariorenta.getMes(),connexion);
				continue;
			}


			if(clas.clas.equals(FormularioRenta.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(FormularioRenta formulariorenta:datoformulariorenta.getFormularioRentas()) {
					formulariorenta.setid_dato_formulario_renta(datoformulariorenta.getId());
					FormularioRentaDataAccess.save(formulariorenta,connexion);
				}
				continue;
			}

			if(clas.clas.equals(FormularioRentaExtra.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(FormularioRentaExtra formulariorentaextra:datoformulariorenta.getFormularioRentaExtras()) {
					formulariorentaextra.setid_dato_formulario_renta(datoformulariorenta.getId());
					FormularioRentaExtraDataAccess.save(formulariorentaextra,connexion);
				}
				continue;
			}
		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		AnioDataAccess.save(datoformulariorenta.getAnio(),connexion);
		AnioLogic anioLogic= new AnioLogic(connexion);
		anioLogic.deepLoad(datoformulariorenta.getAnio(),isDeep,deepLoadType,clases);
				

		MesDataAccess.save(datoformulariorenta.getMes(),connexion);
		MesLogic mesLogic= new MesLogic(connexion);
		mesLogic.deepLoad(datoformulariorenta.getMes(),isDeep,deepLoadType,clases);
				

		for(FormularioRenta formulariorenta:datoformulariorenta.getFormularioRentas()) {
			FormularioRentaLogic formulariorentaLogic= new FormularioRentaLogic(connexion);
			formulariorenta.setid_dato_formulario_renta(datoformulariorenta.getId());
			FormularioRentaDataAccess.save(formulariorenta,connexion);
			formulariorentaLogic.deepSave(formulariorenta,isDeep,deepLoadType,clases);
		}

		for(FormularioRentaExtra formulariorentaextra:datoformulariorenta.getFormularioRentaExtras()) {
			FormularioRentaExtraLogic formulariorentaextraLogic= new FormularioRentaExtraLogic(connexion);
			formulariorentaextra.setid_dato_formulario_renta(datoformulariorenta.getId());
			FormularioRentaExtraDataAccess.save(formulariorentaextra,connexion);
			formulariorentaextraLogic.deepSave(formulariorentaextra,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Anio.class)) {
				AnioDataAccess.save(datoformulariorenta.getAnio(),connexion);
				AnioLogic anioLogic= new AnioLogic(connexion);
				anioLogic.deepSave(datoformulariorenta.getAnio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				MesDataAccess.save(datoformulariorenta.getMes(),connexion);
				MesLogic mesLogic= new MesLogic(connexion);
				mesLogic.deepSave(datoformulariorenta.getMes(),isDeep,deepLoadType,clases);				
				continue;
			}


			if(clas.clas.equals(FormularioRenta.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(FormularioRenta formulariorenta:datoformulariorenta.getFormularioRentas()) {
					FormularioRentaLogic formulariorentaLogic= new FormularioRentaLogic(connexion);
					formulariorenta.setid_dato_formulario_renta(datoformulariorenta.getId());
					FormularioRentaDataAccess.save(formulariorenta,connexion);
					formulariorentaLogic.deepSave(formulariorenta,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(FormularioRentaExtra.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(FormularioRentaExtra formulariorentaextra:datoformulariorenta.getFormularioRentaExtras()) {
					FormularioRentaExtraLogic formulariorentaextraLogic= new FormularioRentaExtraLogic(connexion);
					formulariorentaextra.setid_dato_formulario_renta(datoformulariorenta.getId());
					FormularioRentaExtraDataAccess.save(formulariorentaextra,connexion);
					formulariorentaextraLogic.deepSave(formulariorentaextra,isDeep,deepLoadType,clases);
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
			this.getNewConnexionToDeep(DatoFormularioRenta.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(datoformulariorenta,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				DatoFormularioRentaConstantesFunciones.refrescarForeignKeysDescripcionesDatoFormularioRenta(datoformulariorenta);
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
			this.deepLoad(this.datoformulariorenta,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				DatoFormularioRentaConstantesFunciones.refrescarForeignKeysDescripcionesDatoFormularioRenta(this.datoformulariorenta);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(DatoFormularioRenta.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(datoformulariorentas!=null) {
				for(DatoFormularioRenta datoformulariorenta:datoformulariorentas) {
					this.deepLoad(datoformulariorenta,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					DatoFormularioRentaConstantesFunciones.refrescarForeignKeysDescripcionesDatoFormularioRenta(datoformulariorentas);
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
			if(datoformulariorentas!=null) {
				for(DatoFormularioRenta datoformulariorenta:datoformulariorentas) {
					this.deepLoad(datoformulariorenta,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					DatoFormularioRentaConstantesFunciones.refrescarForeignKeysDescripcionesDatoFormularioRenta(datoformulariorentas);
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
			this.getNewConnexionToDeep(DatoFormularioRenta.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(datoformulariorenta,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(DatoFormularioRenta.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(datoformulariorentas!=null) {
				for(DatoFormularioRenta datoformulariorenta:datoformulariorentas) {
					this.deepSave(datoformulariorenta,isDeep,deepLoadType,clases);
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
			if(datoformulariorentas!=null) {
				for(DatoFormularioRenta datoformulariorenta:datoformulariorentas) {
					this.deepSave(datoformulariorenta,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getDatoFormularioRentasFK_IdAnioWithConnection(String sFinalQuery,Pagination pagination,Long id_anio)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DatoFormularioRenta.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidAnio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidAnio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_anio,DatoFormularioRentaConstantesFunciones.IDANIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidAnio);

			DatoFormularioRentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdAnio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			datoformulariorentas=datoformulariorentaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DatoFormularioRentaConstantesFunciones.refrescarForeignKeysDescripcionesDatoFormularioRenta(this.datoformulariorentas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDatoFormularioRentasFK_IdAnio(String sFinalQuery,Pagination pagination,Long id_anio)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidAnio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidAnio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_anio,DatoFormularioRentaConstantesFunciones.IDANIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidAnio);

			DatoFormularioRentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdAnio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			datoformulariorentas=datoformulariorentaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DatoFormularioRentaConstantesFunciones.refrescarForeignKeysDescripcionesDatoFormularioRenta(this.datoformulariorentas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDatoFormularioRentasFK_IdMesWithConnection(String sFinalQuery,Pagination pagination,Long id_mes)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DatoFormularioRenta.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidMes= new ParameterSelectionGeneral();
			parameterSelectionGeneralidMes.setParameterSelectionGeneralEqual(ParameterType.LONG,id_mes,DatoFormularioRentaConstantesFunciones.IDMES,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidMes);

			DatoFormularioRentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdMes","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			datoformulariorentas=datoformulariorentaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DatoFormularioRentaConstantesFunciones.refrescarForeignKeysDescripcionesDatoFormularioRenta(this.datoformulariorentas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDatoFormularioRentasFK_IdMes(String sFinalQuery,Pagination pagination,Long id_mes)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidMes= new ParameterSelectionGeneral();
			parameterSelectionGeneralidMes.setParameterSelectionGeneralEqual(ParameterType.LONG,id_mes,DatoFormularioRentaConstantesFunciones.IDMES,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidMes);

			DatoFormularioRentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdMes","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			datoformulariorentas=datoformulariorentaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DatoFormularioRentaConstantesFunciones.refrescarForeignKeysDescripcionesDatoFormularioRenta(this.datoformulariorentas);
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
			if(DatoFormularioRentaConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,DatoFormularioRentaDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,DatoFormularioRenta datoformulariorenta,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(DatoFormularioRentaConstantesFunciones.ISCONAUDITORIA) {
				if(datoformulariorenta.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,DatoFormularioRentaDataAccess.TABLENAME, datoformulariorenta.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(DatoFormularioRentaConstantesFunciones.ISCONAUDITORIADETALLE) {
						////DatoFormularioRentaLogic.registrarAuditoriaDetallesDatoFormularioRenta(connexion,datoformulariorenta,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(datoformulariorenta.getIsDeleted()) {
					/*if(!datoformulariorenta.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,DatoFormularioRentaDataAccess.TABLENAME, datoformulariorenta.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////DatoFormularioRentaLogic.registrarAuditoriaDetallesDatoFormularioRenta(connexion,datoformulariorenta,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,DatoFormularioRentaDataAccess.TABLENAME, datoformulariorenta.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(datoformulariorenta.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,DatoFormularioRentaDataAccess.TABLENAME, datoformulariorenta.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(DatoFormularioRentaConstantesFunciones.ISCONAUDITORIADETALLE) {
						////DatoFormularioRentaLogic.registrarAuditoriaDetallesDatoFormularioRenta(connexion,datoformulariorenta,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesDatoFormularioRenta(Connexion connexion,DatoFormularioRenta datoformulariorenta)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(datoformulariorenta.getIsNew()||!datoformulariorenta.getid_anio().equals(datoformulariorenta.getDatoFormularioRentaOriginal().getid_anio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(datoformulariorenta.getDatoFormularioRentaOriginal().getid_anio()!=null)
				{
					strValorActual=datoformulariorenta.getDatoFormularioRentaOriginal().getid_anio().toString();
				}
				if(datoformulariorenta.getid_anio()!=null)
				{
					strValorNuevo=datoformulariorenta.getid_anio().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DatoFormularioRentaConstantesFunciones.IDANIO,strValorActual,strValorNuevo);
			}	
			
			if(datoformulariorenta.getIsNew()||!datoformulariorenta.getid_mes().equals(datoformulariorenta.getDatoFormularioRentaOriginal().getid_mes()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(datoformulariorenta.getDatoFormularioRentaOriginal().getid_mes()!=null)
				{
					strValorActual=datoformulariorenta.getDatoFormularioRentaOriginal().getid_mes().toString();
				}
				if(datoformulariorenta.getid_mes()!=null)
				{
					strValorNuevo=datoformulariorenta.getid_mes().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DatoFormularioRentaConstantesFunciones.IDMES,strValorActual,strValorNuevo);
			}	
			
			if(datoformulariorenta.getIsNew()||!datoformulariorenta.getes_sustitutiva().equals(datoformulariorenta.getDatoFormularioRentaOriginal().getes_sustitutiva()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(datoformulariorenta.getDatoFormularioRentaOriginal().getes_sustitutiva()!=null)
				{
					strValorActual=datoformulariorenta.getDatoFormularioRentaOriginal().getes_sustitutiva().toString();
				}
				if(datoformulariorenta.getes_sustitutiva()!=null)
				{
					strValorNuevo=datoformulariorenta.getes_sustitutiva().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DatoFormularioRentaConstantesFunciones.ESSUSTITUTIVA,strValorActual,strValorNuevo);
			}	
			
			if(datoformulariorenta.getIsNew()||!datoformulariorenta.getnumero_formulario().equals(datoformulariorenta.getDatoFormularioRentaOriginal().getnumero_formulario()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(datoformulariorenta.getDatoFormularioRentaOriginal().getnumero_formulario()!=null)
				{
					strValorActual=datoformulariorenta.getDatoFormularioRentaOriginal().getnumero_formulario();
				}
				if(datoformulariorenta.getnumero_formulario()!=null)
				{
					strValorNuevo=datoformulariorenta.getnumero_formulario() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DatoFormularioRentaConstantesFunciones.NUMEROFORMULARIO,strValorActual,strValorNuevo);
			}	
			
			if(datoformulariorenta.getIsNew()||!datoformulariorenta.getcedula_representante().equals(datoformulariorenta.getDatoFormularioRentaOriginal().getcedula_representante()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(datoformulariorenta.getDatoFormularioRentaOriginal().getcedula_representante()!=null)
				{
					strValorActual=datoformulariorenta.getDatoFormularioRentaOriginal().getcedula_representante();
				}
				if(datoformulariorenta.getcedula_representante()!=null)
				{
					strValorNuevo=datoformulariorenta.getcedula_representante() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DatoFormularioRentaConstantesFunciones.CEDULAREPRESENTANTE,strValorActual,strValorNuevo);
			}	
			
			if(datoformulariorenta.getIsNew()||!datoformulariorenta.getnumero_fiscal().equals(datoformulariorenta.getDatoFormularioRentaOriginal().getnumero_fiscal()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(datoformulariorenta.getDatoFormularioRentaOriginal().getnumero_fiscal()!=null)
				{
					strValorActual=datoformulariorenta.getDatoFormularioRentaOriginal().getnumero_fiscal();
				}
				if(datoformulariorenta.getnumero_fiscal()!=null)
				{
					strValorNuevo=datoformulariorenta.getnumero_fiscal() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DatoFormularioRentaConstantesFunciones.NUMEROFISCAL,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveDatoFormularioRentaRelacionesWithConnection(DatoFormularioRenta datoformulariorenta,List<FormularioRenta> formulariorentas,List<FormularioRentaExtra> formulariorentaextras) throws Exception {

		if(!datoformulariorenta.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveDatoFormularioRentaRelacionesBase(datoformulariorenta,formulariorentas,formulariorentaextras,true);
		}
	}

	public void saveDatoFormularioRentaRelaciones(DatoFormularioRenta datoformulariorenta,List<FormularioRenta> formulariorentas,List<FormularioRentaExtra> formulariorentaextras)throws Exception {

		if(!datoformulariorenta.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveDatoFormularioRentaRelacionesBase(datoformulariorenta,formulariorentas,formulariorentaextras,false);
		}
	}

	public void saveDatoFormularioRentaRelacionesBase(DatoFormularioRenta datoformulariorenta,List<FormularioRenta> formulariorentas,List<FormularioRentaExtra> formulariorentaextras,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("DatoFormularioRenta-saveRelacionesWithConnection");}
	
			datoformulariorenta.setFormularioRentas(formulariorentas);
			datoformulariorenta.setFormularioRentaExtras(formulariorentaextras);

			this.setDatoFormularioRenta(datoformulariorenta);

			if(DatoFormularioRentaLogicAdditional.validarSaveRelaciones(datoformulariorenta,this)) {

				DatoFormularioRentaLogicAdditional.updateRelacionesToSave(datoformulariorenta,this);

				if((datoformulariorenta.getIsNew()||datoformulariorenta.getIsChanged())&&!datoformulariorenta.getIsDeleted()) {
					this.saveDatoFormularioRenta();
					this.saveDatoFormularioRentaRelacionesDetalles(formulariorentas,formulariorentaextras);

				} else if(datoformulariorenta.getIsDeleted()) {
					this.saveDatoFormularioRentaRelacionesDetalles(formulariorentas,formulariorentaextras);
					this.saveDatoFormularioRenta();
				}

				DatoFormularioRentaLogicAdditional.updateRelacionesToSaveAfter(datoformulariorenta,this);

			} else {
				throw new Exception("LOS DATOS SON INVALIDOS");
			}

			if(conConexion) {connexion.commit();}

		} catch(Exception e) {
			
			FormularioRentaConstantesFunciones.InicializarGeneralEntityAuxiliaresFormularioRentas(formulariorentas,true,true);
			FormularioRentaExtraConstantesFunciones.InicializarGeneralEntityAuxiliaresFormularioRentaExtras(formulariorentaextras,true,true);

			if(conConexion){connexion.rollback();}
			Funciones.manageException(logger,e);
			throw e;

		} finally {
			if(conConexion){this.closeNewConnexionToDeep();}
		}
	}
	
	
	private void saveDatoFormularioRentaRelacionesDetalles(List<FormularioRenta> formulariorentas,List<FormularioRentaExtra> formulariorentaextras)throws Exception {
		try {
	

			Long idDatoFormularioRentaActual=this.getDatoFormularioRenta().getId();

			FormularioRentaLogic formulariorentaLogic_Desde_DatoFormularioRenta=new FormularioRentaLogic();
			formulariorentaLogic_Desde_DatoFormularioRenta.setFormularioRentas(formulariorentas);

			formulariorentaLogic_Desde_DatoFormularioRenta.setConnexion(this.getConnexion());
			formulariorentaLogic_Desde_DatoFormularioRenta.setDatosCliente(this.datosCliente);

			for(FormularioRenta formulariorenta_Desde_DatoFormularioRenta:formulariorentaLogic_Desde_DatoFormularioRenta.getFormularioRentas()) {
				formulariorenta_Desde_DatoFormularioRenta.setid_dato_formulario_renta(idDatoFormularioRentaActual);
			}

			formulariorentaLogic_Desde_DatoFormularioRenta.saveFormularioRentas();

			FormularioRentaExtraLogic formulariorentaextraLogic_Desde_DatoFormularioRenta=new FormularioRentaExtraLogic();
			formulariorentaextraLogic_Desde_DatoFormularioRenta.setFormularioRentaExtras(formulariorentaextras);

			formulariorentaextraLogic_Desde_DatoFormularioRenta.setConnexion(this.getConnexion());
			formulariorentaextraLogic_Desde_DatoFormularioRenta.setDatosCliente(this.datosCliente);

			for(FormularioRentaExtra formulariorentaextra_Desde_DatoFormularioRenta:formulariorentaextraLogic_Desde_DatoFormularioRenta.getFormularioRentaExtras()) {
				formulariorentaextra_Desde_DatoFormularioRenta.setid_dato_formulario_renta(idDatoFormularioRentaActual);
			}

			formulariorentaextraLogic_Desde_DatoFormularioRenta.saveFormularioRentaExtras();

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfDatoFormularioRenta(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=DatoFormularioRentaConstantesFunciones.getClassesForeignKeysOfDatoFormularioRenta(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfDatoFormularioRenta(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=DatoFormularioRentaConstantesFunciones.getClassesRelationshipsOfDatoFormularioRenta(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

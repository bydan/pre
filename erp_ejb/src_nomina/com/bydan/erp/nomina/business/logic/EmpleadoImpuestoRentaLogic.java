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
package com.bydan.erp.nomina.business.logic;

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
import com.bydan.erp.nomina.util.*;
import com.bydan.erp.nomina.util.EmpleadoImpuestoRentaConstantesFunciones;
import com.bydan.erp.nomina.util.EmpleadoImpuestoRentaParameterReturnGeneral;
//import com.bydan.erp.nomina.util.EmpleadoImpuestoRentaParameterGeneral;
import com.bydan.erp.nomina.business.entity.EmpleadoImpuestoRenta;
import com.bydan.erp.nomina.business.logic.EmpleadoImpuestoRentaLogicAdditional;
import com.bydan.erp.nomina.business.dataaccess.*;
import com.bydan.erp.nomina.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;


import com.bydan.erp.seguridad.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;








@SuppressWarnings("unused")
public class EmpleadoImpuestoRentaLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(EmpleadoImpuestoRentaLogic.class);
	
	protected EmpleadoImpuestoRentaDataAccess empleadoimpuestorentaDataAccess; 	
	protected EmpleadoImpuestoRenta empleadoimpuestorenta;
	protected List<EmpleadoImpuestoRenta> empleadoimpuestorentas;
	protected Object empleadoimpuestorentaObject;	
	protected List<Object> empleadoimpuestorentasObject;
	
	public static ClassValidator<EmpleadoImpuestoRenta> empleadoimpuestorentaValidator = new ClassValidator<EmpleadoImpuestoRenta>(EmpleadoImpuestoRenta.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected EmpleadoImpuestoRentaLogicAdditional empleadoimpuestorentaLogicAdditional=null;
	
	public EmpleadoImpuestoRentaLogicAdditional getEmpleadoImpuestoRentaLogicAdditional() {
		return this.empleadoimpuestorentaLogicAdditional;
	}
	
	public void setEmpleadoImpuestoRentaLogicAdditional(EmpleadoImpuestoRentaLogicAdditional empleadoimpuestorentaLogicAdditional) {
		try {
			this.empleadoimpuestorentaLogicAdditional=empleadoimpuestorentaLogicAdditional;
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
	
	
	
	
	public  EmpleadoImpuestoRentaLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.empleadoimpuestorentaDataAccess = new EmpleadoImpuestoRentaDataAccess();
			
			this.empleadoimpuestorentas= new ArrayList<EmpleadoImpuestoRenta>();
			this.empleadoimpuestorenta= new EmpleadoImpuestoRenta();
			
			this.empleadoimpuestorentaObject=new Object();
			this.empleadoimpuestorentasObject=new ArrayList<Object>();
				
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
			
			this.empleadoimpuestorentaDataAccess.setConnexionType(this.connexionType);
			this.empleadoimpuestorentaDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  EmpleadoImpuestoRentaLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.empleadoimpuestorentaDataAccess = new EmpleadoImpuestoRentaDataAccess();
			this.empleadoimpuestorentas= new ArrayList<EmpleadoImpuestoRenta>();
			this.empleadoimpuestorenta= new EmpleadoImpuestoRenta();
			this.empleadoimpuestorentaObject=new Object();
			this.empleadoimpuestorentasObject=new ArrayList<Object>();
			
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
			
			this.empleadoimpuestorentaDataAccess.setConnexionType(this.connexionType);
			this.empleadoimpuestorentaDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public EmpleadoImpuestoRenta getEmpleadoImpuestoRenta() throws Exception {	
		EmpleadoImpuestoRentaLogicAdditional.checkEmpleadoImpuestoRentaToGet(empleadoimpuestorenta,this.datosCliente,this.arrDatoGeneral);
		EmpleadoImpuestoRentaLogicAdditional.updateEmpleadoImpuestoRentaToGet(empleadoimpuestorenta,this.arrDatoGeneral);
		
		return empleadoimpuestorenta;
	}
		
	public void setEmpleadoImpuestoRenta(EmpleadoImpuestoRenta newEmpleadoImpuestoRenta) {
		this.empleadoimpuestorenta = newEmpleadoImpuestoRenta;
	}
	
	public EmpleadoImpuestoRentaDataAccess getEmpleadoImpuestoRentaDataAccess() {
		return empleadoimpuestorentaDataAccess;
	}
	
	public void setEmpleadoImpuestoRentaDataAccess(EmpleadoImpuestoRentaDataAccess newempleadoimpuestorentaDataAccess) {
		this.empleadoimpuestorentaDataAccess = newempleadoimpuestorentaDataAccess;
	}
	
	public List<EmpleadoImpuestoRenta> getEmpleadoImpuestoRentas() throws Exception {		
		this.quitarEmpleadoImpuestoRentasNulos();
		
		EmpleadoImpuestoRentaLogicAdditional.checkEmpleadoImpuestoRentaToGets(empleadoimpuestorentas,this.datosCliente,this.arrDatoGeneral);
		
		for (EmpleadoImpuestoRenta empleadoimpuestorentaLocal: empleadoimpuestorentas ) {
			EmpleadoImpuestoRentaLogicAdditional.updateEmpleadoImpuestoRentaToGet(empleadoimpuestorentaLocal,this.arrDatoGeneral);
		}
		
		return empleadoimpuestorentas;
	}
	
	public void setEmpleadoImpuestoRentas(List<EmpleadoImpuestoRenta> newEmpleadoImpuestoRentas) {
		this.empleadoimpuestorentas = newEmpleadoImpuestoRentas;
	}
	
	public Object getEmpleadoImpuestoRentaObject() {	
		this.empleadoimpuestorentaObject=this.empleadoimpuestorentaDataAccess.getEntityObject();
		return this.empleadoimpuestorentaObject;
	}
		
	public void setEmpleadoImpuestoRentaObject(Object newEmpleadoImpuestoRentaObject) {
		this.empleadoimpuestorentaObject = newEmpleadoImpuestoRentaObject;
	}
	
	public List<Object> getEmpleadoImpuestoRentasObject() {		
		this.empleadoimpuestorentasObject=this.empleadoimpuestorentaDataAccess.getEntitiesObject();
		return this.empleadoimpuestorentasObject;
	}
		
	public void setEmpleadoImpuestoRentasObject(List<Object> newEmpleadoImpuestoRentasObject) {
		this.empleadoimpuestorentasObject = newEmpleadoImpuestoRentasObject;
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
		
		if(this.empleadoimpuestorentaDataAccess!=null) {
			this.empleadoimpuestorentaDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EmpleadoImpuestoRenta.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			empleadoimpuestorentaDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			empleadoimpuestorentaDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		empleadoimpuestorenta = new  EmpleadoImpuestoRenta();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EmpleadoImpuestoRenta.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			empleadoimpuestorenta=empleadoimpuestorentaDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.empleadoimpuestorenta,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				EmpleadoImpuestoRentaConstantesFunciones.refrescarForeignKeysDescripcionesEmpleadoImpuestoRenta(this.empleadoimpuestorenta);
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
		empleadoimpuestorenta = new  EmpleadoImpuestoRenta();
		  		  
        try {
			
			empleadoimpuestorenta=empleadoimpuestorentaDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.empleadoimpuestorenta,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				EmpleadoImpuestoRentaConstantesFunciones.refrescarForeignKeysDescripcionesEmpleadoImpuestoRenta(this.empleadoimpuestorenta);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		empleadoimpuestorenta = new  EmpleadoImpuestoRenta();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EmpleadoImpuestoRenta.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			empleadoimpuestorenta=empleadoimpuestorentaDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.empleadoimpuestorenta,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				EmpleadoImpuestoRentaConstantesFunciones.refrescarForeignKeysDescripcionesEmpleadoImpuestoRenta(this.empleadoimpuestorenta);
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
		empleadoimpuestorenta = new  EmpleadoImpuestoRenta();
		  		  
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
		empleadoimpuestorenta = new  EmpleadoImpuestoRenta();
		  		  
        try {
			
			empleadoimpuestorenta=empleadoimpuestorentaDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.empleadoimpuestorenta,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				EmpleadoImpuestoRentaConstantesFunciones.refrescarForeignKeysDescripcionesEmpleadoImpuestoRenta(this.empleadoimpuestorenta);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		empleadoimpuestorenta = new  EmpleadoImpuestoRenta();
		  		  
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
		empleadoimpuestorenta = new  EmpleadoImpuestoRenta();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EmpleadoImpuestoRenta.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =empleadoimpuestorentaDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		empleadoimpuestorenta = new  EmpleadoImpuestoRenta();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=empleadoimpuestorentaDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		empleadoimpuestorenta = new  EmpleadoImpuestoRenta();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EmpleadoImpuestoRenta.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =empleadoimpuestorentaDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		empleadoimpuestorenta = new  EmpleadoImpuestoRenta();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=empleadoimpuestorentaDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		empleadoimpuestorenta = new  EmpleadoImpuestoRenta();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EmpleadoImpuestoRenta.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =empleadoimpuestorentaDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		empleadoimpuestorenta = new  EmpleadoImpuestoRenta();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=empleadoimpuestorentaDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		empleadoimpuestorentas = new  ArrayList<EmpleadoImpuestoRenta>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EmpleadoImpuestoRenta.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			EmpleadoImpuestoRentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			empleadoimpuestorentas=empleadoimpuestorentaDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarEmpleadoImpuestoRenta(empleadoimpuestorentas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EmpleadoImpuestoRentaConstantesFunciones.refrescarForeignKeysDescripcionesEmpleadoImpuestoRenta(this.empleadoimpuestorentas);
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
		empleadoimpuestorentas = new  ArrayList<EmpleadoImpuestoRenta>();
		  		  
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
		empleadoimpuestorentas = new  ArrayList<EmpleadoImpuestoRenta>();
		  		  
        try {			
			EmpleadoImpuestoRentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			empleadoimpuestorentas=empleadoimpuestorentaDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarEmpleadoImpuestoRenta(empleadoimpuestorentas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EmpleadoImpuestoRentaConstantesFunciones.refrescarForeignKeysDescripcionesEmpleadoImpuestoRenta(this.empleadoimpuestorentas);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		empleadoimpuestorentas = new  ArrayList<EmpleadoImpuestoRenta>();
		  		  
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
		empleadoimpuestorentas = new  ArrayList<EmpleadoImpuestoRenta>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EmpleadoImpuestoRenta.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			EmpleadoImpuestoRentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			empleadoimpuestorentas=empleadoimpuestorentaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarEmpleadoImpuestoRenta(empleadoimpuestorentas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EmpleadoImpuestoRentaConstantesFunciones.refrescarForeignKeysDescripcionesEmpleadoImpuestoRenta(this.empleadoimpuestorentas);
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
		empleadoimpuestorentas = new  ArrayList<EmpleadoImpuestoRenta>();
		  		  
        try {
			EmpleadoImpuestoRentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			empleadoimpuestorentas=empleadoimpuestorentaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarEmpleadoImpuestoRenta(empleadoimpuestorentas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EmpleadoImpuestoRentaConstantesFunciones.refrescarForeignKeysDescripcionesEmpleadoImpuestoRenta(this.empleadoimpuestorentas);
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
		empleadoimpuestorentas = new  ArrayList<EmpleadoImpuestoRenta>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EmpleadoImpuestoRenta.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EmpleadoImpuestoRentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			empleadoimpuestorentas=empleadoimpuestorentaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarEmpleadoImpuestoRenta(empleadoimpuestorentas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EmpleadoImpuestoRentaConstantesFunciones.refrescarForeignKeysDescripcionesEmpleadoImpuestoRenta(this.empleadoimpuestorentas);
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
		empleadoimpuestorentas = new  ArrayList<EmpleadoImpuestoRenta>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EmpleadoImpuestoRentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			empleadoimpuestorentas=empleadoimpuestorentaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarEmpleadoImpuestoRenta(empleadoimpuestorentas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EmpleadoImpuestoRentaConstantesFunciones.refrescarForeignKeysDescripcionesEmpleadoImpuestoRenta(this.empleadoimpuestorentas);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		empleadoimpuestorenta = new  EmpleadoImpuestoRenta();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EmpleadoImpuestoRenta.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EmpleadoImpuestoRentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			empleadoimpuestorenta=empleadoimpuestorentaDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarEmpleadoImpuestoRenta(empleadoimpuestorenta);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EmpleadoImpuestoRentaConstantesFunciones.refrescarForeignKeysDescripcionesEmpleadoImpuestoRenta(this.empleadoimpuestorenta);
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
		empleadoimpuestorenta = new  EmpleadoImpuestoRenta();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EmpleadoImpuestoRentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			empleadoimpuestorenta=empleadoimpuestorentaDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarEmpleadoImpuestoRenta(empleadoimpuestorenta);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EmpleadoImpuestoRentaConstantesFunciones.refrescarForeignKeysDescripcionesEmpleadoImpuestoRenta(this.empleadoimpuestorenta);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		empleadoimpuestorentas = new  ArrayList<EmpleadoImpuestoRenta>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EmpleadoImpuestoRenta.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			EmpleadoImpuestoRentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			empleadoimpuestorentas=empleadoimpuestorentaDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarEmpleadoImpuestoRenta(empleadoimpuestorentas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EmpleadoImpuestoRentaConstantesFunciones.refrescarForeignKeysDescripcionesEmpleadoImpuestoRenta(this.empleadoimpuestorentas);
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
		empleadoimpuestorentas = new  ArrayList<EmpleadoImpuestoRenta>();
		  		  
        try {
			EmpleadoImpuestoRentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			empleadoimpuestorentas=empleadoimpuestorentaDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarEmpleadoImpuestoRenta(empleadoimpuestorentas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EmpleadoImpuestoRentaConstantesFunciones.refrescarForeignKeysDescripcionesEmpleadoImpuestoRenta(this.empleadoimpuestorentas);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosEmpleadoImpuestoRentasWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		empleadoimpuestorentas = new  ArrayList<EmpleadoImpuestoRenta>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EmpleadoImpuestoRenta.class.getSimpleName()+"-getTodosEmpleadoImpuestoRentasWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EmpleadoImpuestoRentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			empleadoimpuestorentas=empleadoimpuestorentaDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarEmpleadoImpuestoRenta(empleadoimpuestorentas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EmpleadoImpuestoRentaConstantesFunciones.refrescarForeignKeysDescripcionesEmpleadoImpuestoRenta(this.empleadoimpuestorentas);
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
	
	public  void  getTodosEmpleadoImpuestoRentas(String sFinalQuery,Pagination pagination)throws Exception {
		empleadoimpuestorentas = new  ArrayList<EmpleadoImpuestoRenta>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EmpleadoImpuestoRentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			empleadoimpuestorentas=empleadoimpuestorentaDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarEmpleadoImpuestoRenta(empleadoimpuestorentas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EmpleadoImpuestoRentaConstantesFunciones.refrescarForeignKeysDescripcionesEmpleadoImpuestoRenta(this.empleadoimpuestorentas);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarEmpleadoImpuestoRenta(EmpleadoImpuestoRenta empleadoimpuestorenta) throws Exception {
		Boolean estaValidado=false;
		
		if(empleadoimpuestorenta.getIsNew() || empleadoimpuestorenta.getIsChanged()) { 
			this.invalidValues = empleadoimpuestorentaValidator.getInvalidValues(empleadoimpuestorenta);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(empleadoimpuestorenta);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarEmpleadoImpuestoRenta(List<EmpleadoImpuestoRenta> EmpleadoImpuestoRentas) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(EmpleadoImpuestoRenta empleadoimpuestorentaLocal:empleadoimpuestorentas) {				
			estaValidadoObjeto=this.validarGuardarEmpleadoImpuestoRenta(empleadoimpuestorentaLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarEmpleadoImpuestoRenta(List<EmpleadoImpuestoRenta> EmpleadoImpuestoRentas) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarEmpleadoImpuestoRenta(empleadoimpuestorentas)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarEmpleadoImpuestoRenta(EmpleadoImpuestoRenta EmpleadoImpuestoRenta) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarEmpleadoImpuestoRenta(empleadoimpuestorenta)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(EmpleadoImpuestoRenta empleadoimpuestorenta) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+empleadoimpuestorenta.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=EmpleadoImpuestoRentaConstantesFunciones.getEmpleadoImpuestoRentaLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"empleadoimpuestorenta","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(EmpleadoImpuestoRentaConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(EmpleadoImpuestoRentaConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveEmpleadoImpuestoRentaWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EmpleadoImpuestoRenta.class.getSimpleName()+"-saveEmpleadoImpuestoRentaWithConnection");connexion.begin();			
			
			EmpleadoImpuestoRentaLogicAdditional.checkEmpleadoImpuestoRentaToSave(this.empleadoimpuestorenta,this.datosCliente,connexion,this.arrDatoGeneral);
			
			EmpleadoImpuestoRentaLogicAdditional.updateEmpleadoImpuestoRentaToSave(this.empleadoimpuestorenta,this.arrDatoGeneral);
			
			EmpleadoImpuestoRentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.empleadoimpuestorenta,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowEmpleadoImpuestoRenta();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarEmpleadoImpuestoRenta(this.empleadoimpuestorenta)) {
				EmpleadoImpuestoRentaDataAccess.save(this.empleadoimpuestorenta, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.empleadoimpuestorenta,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			EmpleadoImpuestoRentaLogicAdditional.checkEmpleadoImpuestoRentaToSaveAfter(this.empleadoimpuestorenta,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowEmpleadoImpuestoRenta();
			
			connexion.commit();			
			
			if(this.empleadoimpuestorenta.getIsDeleted()) {
				this.empleadoimpuestorenta=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveEmpleadoImpuestoRenta()throws Exception {	
		try {	
			
			EmpleadoImpuestoRentaLogicAdditional.checkEmpleadoImpuestoRentaToSave(this.empleadoimpuestorenta,this.datosCliente,connexion,this.arrDatoGeneral);
			
			EmpleadoImpuestoRentaLogicAdditional.updateEmpleadoImpuestoRentaToSave(this.empleadoimpuestorenta,this.arrDatoGeneral);
			
			EmpleadoImpuestoRentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.empleadoimpuestorenta,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarEmpleadoImpuestoRenta(this.empleadoimpuestorenta)) {			
				EmpleadoImpuestoRentaDataAccess.save(this.empleadoimpuestorenta, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.empleadoimpuestorenta,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			EmpleadoImpuestoRentaLogicAdditional.checkEmpleadoImpuestoRentaToSaveAfter(this.empleadoimpuestorenta,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.empleadoimpuestorenta.getIsDeleted()) {
				this.empleadoimpuestorenta=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveEmpleadoImpuestoRentasWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EmpleadoImpuestoRenta.class.getSimpleName()+"-saveEmpleadoImpuestoRentasWithConnection");connexion.begin();			
			
			EmpleadoImpuestoRentaLogicAdditional.checkEmpleadoImpuestoRentaToSaves(empleadoimpuestorentas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowEmpleadoImpuestoRentas();
			
			Boolean validadoTodosEmpleadoImpuestoRenta=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(EmpleadoImpuestoRenta empleadoimpuestorentaLocal:empleadoimpuestorentas) {		
				if(empleadoimpuestorentaLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				EmpleadoImpuestoRentaLogicAdditional.updateEmpleadoImpuestoRentaToSave(empleadoimpuestorentaLocal,this.arrDatoGeneral);
	        	
				EmpleadoImpuestoRentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),empleadoimpuestorentaLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarEmpleadoImpuestoRenta(empleadoimpuestorentaLocal)) {
					EmpleadoImpuestoRentaDataAccess.save(empleadoimpuestorentaLocal, connexion);				
				} else {
					validadoTodosEmpleadoImpuestoRenta=false;
				}
			}
			
			if(!validadoTodosEmpleadoImpuestoRenta) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			EmpleadoImpuestoRentaLogicAdditional.checkEmpleadoImpuestoRentaToSavesAfter(empleadoimpuestorentas,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowEmpleadoImpuestoRentas();
			
			connexion.commit();		
			
			this.quitarEmpleadoImpuestoRentasEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveEmpleadoImpuestoRentas()throws Exception {				
		 try {	
			EmpleadoImpuestoRentaLogicAdditional.checkEmpleadoImpuestoRentaToSaves(empleadoimpuestorentas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosEmpleadoImpuestoRenta=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(EmpleadoImpuestoRenta empleadoimpuestorentaLocal:empleadoimpuestorentas) {				
				if(empleadoimpuestorentaLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				EmpleadoImpuestoRentaLogicAdditional.updateEmpleadoImpuestoRentaToSave(empleadoimpuestorentaLocal,this.arrDatoGeneral);
	        	
				EmpleadoImpuestoRentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),empleadoimpuestorentaLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarEmpleadoImpuestoRenta(empleadoimpuestorentaLocal)) {				
					EmpleadoImpuestoRentaDataAccess.save(empleadoimpuestorentaLocal, connexion);				
				} else {
					validadoTodosEmpleadoImpuestoRenta=false;
				}
			}
			
			if(!validadoTodosEmpleadoImpuestoRenta) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			EmpleadoImpuestoRentaLogicAdditional.checkEmpleadoImpuestoRentaToSavesAfter(empleadoimpuestorentas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarEmpleadoImpuestoRentasEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public EmpleadoImpuestoRentaParameterReturnGeneral procesarAccionEmpleadoImpuestoRentas(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<EmpleadoImpuestoRenta> empleadoimpuestorentas,EmpleadoImpuestoRentaParameterReturnGeneral empleadoimpuestorentaParameterGeneral)throws Exception {
		 try {	
			EmpleadoImpuestoRentaParameterReturnGeneral empleadoimpuestorentaReturnGeneral=new EmpleadoImpuestoRentaParameterReturnGeneral();
	
			EmpleadoImpuestoRentaLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,empleadoimpuestorentas,empleadoimpuestorentaParameterGeneral,empleadoimpuestorentaReturnGeneral);
			
			return empleadoimpuestorentaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public EmpleadoImpuestoRentaParameterReturnGeneral procesarAccionEmpleadoImpuestoRentasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<EmpleadoImpuestoRenta> empleadoimpuestorentas,EmpleadoImpuestoRentaParameterReturnGeneral empleadoimpuestorentaParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EmpleadoImpuestoRenta.class.getSimpleName()+"-procesarAccionEmpleadoImpuestoRentasWithConnection");connexion.begin();			
			
			EmpleadoImpuestoRentaParameterReturnGeneral empleadoimpuestorentaReturnGeneral=new EmpleadoImpuestoRentaParameterReturnGeneral();
	
			EmpleadoImpuestoRentaLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,empleadoimpuestorentas,empleadoimpuestorentaParameterGeneral,empleadoimpuestorentaReturnGeneral);
			
			this.connexion.commit();
			
			return empleadoimpuestorentaReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public EmpleadoImpuestoRentaParameterReturnGeneral procesarEventosEmpleadoImpuestoRentas(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<EmpleadoImpuestoRenta> empleadoimpuestorentas,EmpleadoImpuestoRenta empleadoimpuestorenta,EmpleadoImpuestoRentaParameterReturnGeneral empleadoimpuestorentaParameterGeneral,Boolean isEsNuevoEmpleadoImpuestoRenta,ArrayList<Classe> clases)throws Exception {
		 try {	
			EmpleadoImpuestoRentaParameterReturnGeneral empleadoimpuestorentaReturnGeneral=new EmpleadoImpuestoRentaParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				empleadoimpuestorentaReturnGeneral.setConRecargarPropiedades(true);
			}
			
			EmpleadoImpuestoRentaLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,empleadoimpuestorentas,empleadoimpuestorenta,empleadoimpuestorentaParameterGeneral,empleadoimpuestorentaReturnGeneral,isEsNuevoEmpleadoImpuestoRenta,clases);
			
			return empleadoimpuestorentaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public EmpleadoImpuestoRentaParameterReturnGeneral procesarEventosEmpleadoImpuestoRentasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<EmpleadoImpuestoRenta> empleadoimpuestorentas,EmpleadoImpuestoRenta empleadoimpuestorenta,EmpleadoImpuestoRentaParameterReturnGeneral empleadoimpuestorentaParameterGeneral,Boolean isEsNuevoEmpleadoImpuestoRenta,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EmpleadoImpuestoRenta.class.getSimpleName()+"-procesarEventosEmpleadoImpuestoRentasWithConnection");connexion.begin();			
			
			EmpleadoImpuestoRentaParameterReturnGeneral empleadoimpuestorentaReturnGeneral=new EmpleadoImpuestoRentaParameterReturnGeneral();
	
			empleadoimpuestorentaReturnGeneral.setEmpleadoImpuestoRenta(empleadoimpuestorenta);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				empleadoimpuestorentaReturnGeneral.setConRecargarPropiedades(true);
			}
			
			EmpleadoImpuestoRentaLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,empleadoimpuestorentas,empleadoimpuestorenta,empleadoimpuestorentaParameterGeneral,empleadoimpuestorentaReturnGeneral,isEsNuevoEmpleadoImpuestoRenta,clases);
			
			this.connexion.commit();
			
			return empleadoimpuestorentaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public EmpleadoImpuestoRentaParameterReturnGeneral procesarImportacionEmpleadoImpuestoRentasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,EmpleadoImpuestoRentaParameterReturnGeneral empleadoimpuestorentaParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EmpleadoImpuestoRenta.class.getSimpleName()+"-procesarImportacionEmpleadoImpuestoRentasWithConnection");connexion.begin();			
			
			EmpleadoImpuestoRentaParameterReturnGeneral empleadoimpuestorentaReturnGeneral=new EmpleadoImpuestoRentaParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.empleadoimpuestorentas=new ArrayList<EmpleadoImpuestoRenta>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.empleadoimpuestorenta=new EmpleadoImpuestoRenta();
				
				
				if(conColumnasBase) {this.empleadoimpuestorenta.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.empleadoimpuestorenta.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.empleadoimpuestorenta.setfecha(Funciones.ConvertToDate(arrColumnas[iColumn++]));
				this.empleadoimpuestorenta.setvalor_pago(Double.parseDouble(arrColumnas[iColumn++]));
				this.empleadoimpuestorenta.setingreso_liquido(Double.parseDouble(arrColumnas[iColumn++]));
				this.empleadoimpuestorenta.setaporte_iess(Double.parseDouble(arrColumnas[iColumn++]));
				
				this.empleadoimpuestorentas.add(this.empleadoimpuestorenta);
			}
			
			this.saveEmpleadoImpuestoRentas();
			
			this.connexion.commit();
			
			empleadoimpuestorentaReturnGeneral.setConRetornoEstaProcesado(true);
			empleadoimpuestorentaReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return empleadoimpuestorentaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarEmpleadoImpuestoRentasEliminados() throws Exception {				
		
		List<EmpleadoImpuestoRenta> empleadoimpuestorentasAux= new ArrayList<EmpleadoImpuestoRenta>();
		
		for(EmpleadoImpuestoRenta empleadoimpuestorenta:empleadoimpuestorentas) {
			if(!empleadoimpuestorenta.getIsDeleted()) {
				empleadoimpuestorentasAux.add(empleadoimpuestorenta);
			}
		}
		
		empleadoimpuestorentas=empleadoimpuestorentasAux;
	}
	
	public void quitarEmpleadoImpuestoRentasNulos() throws Exception {				
		
		List<EmpleadoImpuestoRenta> empleadoimpuestorentasAux= new ArrayList<EmpleadoImpuestoRenta>();
		
		for(EmpleadoImpuestoRenta empleadoimpuestorenta : this.empleadoimpuestorentas) {
			if(empleadoimpuestorenta==null) {
				empleadoimpuestorentasAux.add(empleadoimpuestorenta);
			}
		}
		
		//this.empleadoimpuestorentas=empleadoimpuestorentasAux;
		
		this.empleadoimpuestorentas.removeAll(empleadoimpuestorentasAux);
	}
	
	public void getSetVersionRowEmpleadoImpuestoRentaWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(empleadoimpuestorenta.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((empleadoimpuestorenta.getIsDeleted() || (empleadoimpuestorenta.getIsChanged()&&!empleadoimpuestorenta.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=empleadoimpuestorentaDataAccess.getSetVersionRowEmpleadoImpuestoRenta(connexion,empleadoimpuestorenta.getId());
				
				if(!empleadoimpuestorenta.getVersionRow().equals(timestamp)) {	
					empleadoimpuestorenta.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				empleadoimpuestorenta.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowEmpleadoImpuestoRenta()throws Exception {	
		
		if(empleadoimpuestorenta.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((empleadoimpuestorenta.getIsDeleted() || (empleadoimpuestorenta.getIsChanged()&&!empleadoimpuestorenta.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=empleadoimpuestorentaDataAccess.getSetVersionRowEmpleadoImpuestoRenta(connexion,empleadoimpuestorenta.getId());
			
			try {							
				if(!empleadoimpuestorenta.getVersionRow().equals(timestamp)) {	
					empleadoimpuestorenta.setVersionRow(timestamp);
				}
				
				empleadoimpuestorenta.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowEmpleadoImpuestoRentasWithConnection()throws Exception {	
		if(empleadoimpuestorentas!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(EmpleadoImpuestoRenta empleadoimpuestorentaAux:empleadoimpuestorentas) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(empleadoimpuestorentaAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(empleadoimpuestorentaAux.getIsDeleted() || (empleadoimpuestorentaAux.getIsChanged()&&!empleadoimpuestorentaAux.getIsNew())) {
						
						timestamp=empleadoimpuestorentaDataAccess.getSetVersionRowEmpleadoImpuestoRenta(connexion,empleadoimpuestorentaAux.getId());
						
						if(!empleadoimpuestorenta.getVersionRow().equals(timestamp)) {	
							empleadoimpuestorentaAux.setVersionRow(timestamp);
						}
								
						empleadoimpuestorentaAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowEmpleadoImpuestoRentas()throws Exception {	
		if(empleadoimpuestorentas!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(EmpleadoImpuestoRenta empleadoimpuestorentaAux:empleadoimpuestorentas) {
					if(empleadoimpuestorentaAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(empleadoimpuestorentaAux.getIsDeleted() || (empleadoimpuestorentaAux.getIsChanged()&&!empleadoimpuestorentaAux.getIsNew())) {
						
						timestamp=empleadoimpuestorentaDataAccess.getSetVersionRowEmpleadoImpuestoRenta(connexion,empleadoimpuestorentaAux.getId());
						
						if(!empleadoimpuestorentaAux.getVersionRow().equals(timestamp)) {	
							empleadoimpuestorentaAux.setVersionRow(timestamp);
						}
						
													
						empleadoimpuestorentaAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public EmpleadoImpuestoRentaParameterReturnGeneral cargarCombosLoteForeignKeyEmpleadoImpuestoRentaWithConnection(String finalQueryGlobalEmpresa,String finalQueryGlobalEmpleado,String finalQueryGlobalAnio,String finalQueryGlobalMes,String finalQueryGlobalEstructura) throws Exception {
		EmpleadoImpuestoRentaParameterReturnGeneral  empleadoimpuestorentaReturnGeneral =new EmpleadoImpuestoRentaParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EmpleadoImpuestoRenta.class.getSimpleName()+"-cargarCombosLoteForeignKeyEmpleadoImpuestoRentaWithConnection");connexion.begin();
			
			empleadoimpuestorentaReturnGeneral =new EmpleadoImpuestoRentaParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			empleadoimpuestorentaReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Empleado> empleadosForeignKey=new ArrayList<Empleado>();
			EmpleadoLogic empleadoLogic=new EmpleadoLogic();
			empleadoLogic.setConnexion(this.connexion);
			empleadoLogic.getEmpleadoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpleado.equals("NONE")) {
				empleadoLogic.getTodosEmpleados(finalQueryGlobalEmpleado,new Pagination());
				empleadosForeignKey=empleadoLogic.getEmpleados();
			}

			empleadoimpuestorentaReturnGeneral.setempleadosForeignKey(empleadosForeignKey);


			List<Anio> aniosForeignKey=new ArrayList<Anio>();
			AnioLogic anioLogic=new AnioLogic();
			anioLogic.setConnexion(this.connexion);
			anioLogic.getAnioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalAnio.equals("NONE")) {
				anioLogic.getTodosAnios(finalQueryGlobalAnio,new Pagination());
				aniosForeignKey=anioLogic.getAnios();
			}

			empleadoimpuestorentaReturnGeneral.setaniosForeignKey(aniosForeignKey);


			List<Mes> messForeignKey=new ArrayList<Mes>();
			MesLogic mesLogic=new MesLogic();
			mesLogic.setConnexion(this.connexion);
			mesLogic.getMesDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalMes.equals("NONE")) {
				mesLogic.getTodosMess(finalQueryGlobalMes,new Pagination());
				messForeignKey=mesLogic.getMess();
			}

			empleadoimpuestorentaReturnGeneral.setmessForeignKey(messForeignKey);


			List<Estructura> estructurasForeignKey=new ArrayList<Estructura>();
			EstructuraLogic estructuraLogic=new EstructuraLogic();
			estructuraLogic.setConnexion(this.connexion);
			estructuraLogic.getEstructuraDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEstructura.equals("NONE")) {
				estructuraLogic.getTodosEstructuras(finalQueryGlobalEstructura,new Pagination());
				estructurasForeignKey=estructuraLogic.getEstructuras();
			}

			empleadoimpuestorentaReturnGeneral.setestructurasForeignKey(estructurasForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return empleadoimpuestorentaReturnGeneral;
	}
	
	public EmpleadoImpuestoRentaParameterReturnGeneral cargarCombosLoteForeignKeyEmpleadoImpuestoRenta(String finalQueryGlobalEmpresa,String finalQueryGlobalEmpleado,String finalQueryGlobalAnio,String finalQueryGlobalMes,String finalQueryGlobalEstructura) throws Exception {
		EmpleadoImpuestoRentaParameterReturnGeneral  empleadoimpuestorentaReturnGeneral =new EmpleadoImpuestoRentaParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			empleadoimpuestorentaReturnGeneral =new EmpleadoImpuestoRentaParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			empleadoimpuestorentaReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Empleado> empleadosForeignKey=new ArrayList<Empleado>();
			EmpleadoLogic empleadoLogic=new EmpleadoLogic();
			empleadoLogic.setConnexion(this.connexion);
			empleadoLogic.getEmpleadoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpleado.equals("NONE")) {
				empleadoLogic.getTodosEmpleados(finalQueryGlobalEmpleado,new Pagination());
				empleadosForeignKey=empleadoLogic.getEmpleados();
			}

			empleadoimpuestorentaReturnGeneral.setempleadosForeignKey(empleadosForeignKey);


			List<Anio> aniosForeignKey=new ArrayList<Anio>();
			AnioLogic anioLogic=new AnioLogic();
			anioLogic.setConnexion(this.connexion);
			anioLogic.getAnioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalAnio.equals("NONE")) {
				anioLogic.getTodosAnios(finalQueryGlobalAnio,new Pagination());
				aniosForeignKey=anioLogic.getAnios();
			}

			empleadoimpuestorentaReturnGeneral.setaniosForeignKey(aniosForeignKey);


			List<Mes> messForeignKey=new ArrayList<Mes>();
			MesLogic mesLogic=new MesLogic();
			mesLogic.setConnexion(this.connexion);
			mesLogic.getMesDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalMes.equals("NONE")) {
				mesLogic.getTodosMess(finalQueryGlobalMes,new Pagination());
				messForeignKey=mesLogic.getMess();
			}

			empleadoimpuestorentaReturnGeneral.setmessForeignKey(messForeignKey);


			List<Estructura> estructurasForeignKey=new ArrayList<Estructura>();
			EstructuraLogic estructuraLogic=new EstructuraLogic();
			estructuraLogic.setConnexion(this.connexion);
			estructuraLogic.getEstructuraDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEstructura.equals("NONE")) {
				estructuraLogic.getTodosEstructuras(finalQueryGlobalEstructura,new Pagination());
				estructurasForeignKey=estructuraLogic.getEstructuras();
			}

			empleadoimpuestorentaReturnGeneral.setestructurasForeignKey(estructurasForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return empleadoimpuestorentaReturnGeneral;
	}
	
	
	public void deepLoad(EmpleadoImpuestoRenta empleadoimpuestorenta,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			EmpleadoImpuestoRentaLogicAdditional.updateEmpleadoImpuestoRentaToGet(empleadoimpuestorenta,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		empleadoimpuestorenta.setEmpresa(empleadoimpuestorentaDataAccess.getEmpresa(connexion,empleadoimpuestorenta));
		empleadoimpuestorenta.setEmpleado(empleadoimpuestorentaDataAccess.getEmpleado(connexion,empleadoimpuestorenta));
		empleadoimpuestorenta.setAnio(empleadoimpuestorentaDataAccess.getAnio(connexion,empleadoimpuestorenta));
		empleadoimpuestorenta.setMes(empleadoimpuestorentaDataAccess.getMes(connexion,empleadoimpuestorenta));
		empleadoimpuestorenta.setEstructura(empleadoimpuestorentaDataAccess.getEstructura(connexion,empleadoimpuestorenta));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				empleadoimpuestorenta.setEmpresa(empleadoimpuestorentaDataAccess.getEmpresa(connexion,empleadoimpuestorenta));
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				empleadoimpuestorenta.setEmpleado(empleadoimpuestorentaDataAccess.getEmpleado(connexion,empleadoimpuestorenta));
				continue;
			}

			if(clas.clas.equals(Anio.class)) {
				empleadoimpuestorenta.setAnio(empleadoimpuestorentaDataAccess.getAnio(connexion,empleadoimpuestorenta));
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				empleadoimpuestorenta.setMes(empleadoimpuestorentaDataAccess.getMes(connexion,empleadoimpuestorenta));
				continue;
			}

			if(clas.clas.equals(Estructura.class)) {
				empleadoimpuestorenta.setEstructura(empleadoimpuestorentaDataAccess.getEstructura(connexion,empleadoimpuestorenta));
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
			empleadoimpuestorenta.setEmpresa(empleadoimpuestorentaDataAccess.getEmpresa(connexion,empleadoimpuestorenta));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Empleado.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			empleadoimpuestorenta.setEmpleado(empleadoimpuestorentaDataAccess.getEmpleado(connexion,empleadoimpuestorenta));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Anio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			empleadoimpuestorenta.setAnio(empleadoimpuestorentaDataAccess.getAnio(connexion,empleadoimpuestorenta));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Mes.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			empleadoimpuestorenta.setMes(empleadoimpuestorentaDataAccess.getMes(connexion,empleadoimpuestorenta));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Estructura.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			empleadoimpuestorenta.setEstructura(empleadoimpuestorentaDataAccess.getEstructura(connexion,empleadoimpuestorenta));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		empleadoimpuestorenta.setEmpresa(empleadoimpuestorentaDataAccess.getEmpresa(connexion,empleadoimpuestorenta));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(empleadoimpuestorenta.getEmpresa(),isDeep,deepLoadType,clases);
				
		empleadoimpuestorenta.setEmpleado(empleadoimpuestorentaDataAccess.getEmpleado(connexion,empleadoimpuestorenta));
		EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
		empleadoLogic.deepLoad(empleadoimpuestorenta.getEmpleado(),isDeep,deepLoadType,clases);
				
		empleadoimpuestorenta.setAnio(empleadoimpuestorentaDataAccess.getAnio(connexion,empleadoimpuestorenta));
		AnioLogic anioLogic= new AnioLogic(connexion);
		anioLogic.deepLoad(empleadoimpuestorenta.getAnio(),isDeep,deepLoadType,clases);
				
		empleadoimpuestorenta.setMes(empleadoimpuestorentaDataAccess.getMes(connexion,empleadoimpuestorenta));
		MesLogic mesLogic= new MesLogic(connexion);
		mesLogic.deepLoad(empleadoimpuestorenta.getMes(),isDeep,deepLoadType,clases);
				
		empleadoimpuestorenta.setEstructura(empleadoimpuestorentaDataAccess.getEstructura(connexion,empleadoimpuestorenta));
		EstructuraLogic estructuraLogic= new EstructuraLogic(connexion);
		estructuraLogic.deepLoad(empleadoimpuestorenta.getEstructura(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				empleadoimpuestorenta.setEmpresa(empleadoimpuestorentaDataAccess.getEmpresa(connexion,empleadoimpuestorenta));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(empleadoimpuestorenta.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				empleadoimpuestorenta.setEmpleado(empleadoimpuestorentaDataAccess.getEmpleado(connexion,empleadoimpuestorenta));
				EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
				empleadoLogic.deepLoad(empleadoimpuestorenta.getEmpleado(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Anio.class)) {
				empleadoimpuestorenta.setAnio(empleadoimpuestorentaDataAccess.getAnio(connexion,empleadoimpuestorenta));
				AnioLogic anioLogic= new AnioLogic(connexion);
				anioLogic.deepLoad(empleadoimpuestorenta.getAnio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				empleadoimpuestorenta.setMes(empleadoimpuestorentaDataAccess.getMes(connexion,empleadoimpuestorenta));
				MesLogic mesLogic= new MesLogic(connexion);
				mesLogic.deepLoad(empleadoimpuestorenta.getMes(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Estructura.class)) {
				empleadoimpuestorenta.setEstructura(empleadoimpuestorentaDataAccess.getEstructura(connexion,empleadoimpuestorenta));
				EstructuraLogic estructuraLogic= new EstructuraLogic(connexion);
				estructuraLogic.deepLoad(empleadoimpuestorenta.getEstructura(),isDeep,deepLoadType,clases);				
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
			empleadoimpuestorenta.setEmpresa(empleadoimpuestorentaDataAccess.getEmpresa(connexion,empleadoimpuestorenta));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(empleadoimpuestorenta.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Empleado.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			empleadoimpuestorenta.setEmpleado(empleadoimpuestorentaDataAccess.getEmpleado(connexion,empleadoimpuestorenta));
			EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
			empleadoLogic.deepLoad(empleadoimpuestorenta.getEmpleado(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Anio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			empleadoimpuestorenta.setAnio(empleadoimpuestorentaDataAccess.getAnio(connexion,empleadoimpuestorenta));
			AnioLogic anioLogic= new AnioLogic(connexion);
			anioLogic.deepLoad(empleadoimpuestorenta.getAnio(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Mes.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			empleadoimpuestorenta.setMes(empleadoimpuestorentaDataAccess.getMes(connexion,empleadoimpuestorenta));
			MesLogic mesLogic= new MesLogic(connexion);
			mesLogic.deepLoad(empleadoimpuestorenta.getMes(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Estructura.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			empleadoimpuestorenta.setEstructura(empleadoimpuestorentaDataAccess.getEstructura(connexion,empleadoimpuestorenta));
			EstructuraLogic estructuraLogic= new EstructuraLogic(connexion);
			estructuraLogic.deepLoad(empleadoimpuestorenta.getEstructura(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(EmpleadoImpuestoRenta empleadoimpuestorenta,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			EmpleadoImpuestoRentaLogicAdditional.updateEmpleadoImpuestoRentaToSave(empleadoimpuestorenta,this.arrDatoGeneral);
			
EmpleadoImpuestoRentaDataAccess.save(empleadoimpuestorenta, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(empleadoimpuestorenta.getEmpresa(),connexion);

		EmpleadoDataAccess.save(empleadoimpuestorenta.getEmpleado(),connexion);

		AnioDataAccess.save(empleadoimpuestorenta.getAnio(),connexion);

		MesDataAccess.save(empleadoimpuestorenta.getMes(),connexion);

		EstructuraDataAccess.save(empleadoimpuestorenta.getEstructura(),connexion);
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(empleadoimpuestorenta.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				EmpleadoDataAccess.save(empleadoimpuestorenta.getEmpleado(),connexion);
				continue;
			}

			if(clas.clas.equals(Anio.class)) {
				AnioDataAccess.save(empleadoimpuestorenta.getAnio(),connexion);
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				MesDataAccess.save(empleadoimpuestorenta.getMes(),connexion);
				continue;
			}

			if(clas.clas.equals(Estructura.class)) {
				EstructuraDataAccess.save(empleadoimpuestorenta.getEstructura(),connexion);
				continue;
			}

		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(empleadoimpuestorenta.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(empleadoimpuestorenta.getEmpresa(),isDeep,deepLoadType,clases);
				

		EmpleadoDataAccess.save(empleadoimpuestorenta.getEmpleado(),connexion);
		EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
		empleadoLogic.deepLoad(empleadoimpuestorenta.getEmpleado(),isDeep,deepLoadType,clases);
				

		AnioDataAccess.save(empleadoimpuestorenta.getAnio(),connexion);
		AnioLogic anioLogic= new AnioLogic(connexion);
		anioLogic.deepLoad(empleadoimpuestorenta.getAnio(),isDeep,deepLoadType,clases);
				

		MesDataAccess.save(empleadoimpuestorenta.getMes(),connexion);
		MesLogic mesLogic= new MesLogic(connexion);
		mesLogic.deepLoad(empleadoimpuestorenta.getMes(),isDeep,deepLoadType,clases);
				

		EstructuraDataAccess.save(empleadoimpuestorenta.getEstructura(),connexion);
		EstructuraLogic estructuraLogic= new EstructuraLogic(connexion);
		estructuraLogic.deepLoad(empleadoimpuestorenta.getEstructura(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(empleadoimpuestorenta.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(empleadoimpuestorenta.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				EmpleadoDataAccess.save(empleadoimpuestorenta.getEmpleado(),connexion);
				EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
				empleadoLogic.deepSave(empleadoimpuestorenta.getEmpleado(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Anio.class)) {
				AnioDataAccess.save(empleadoimpuestorenta.getAnio(),connexion);
				AnioLogic anioLogic= new AnioLogic(connexion);
				anioLogic.deepSave(empleadoimpuestorenta.getAnio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				MesDataAccess.save(empleadoimpuestorenta.getMes(),connexion);
				MesLogic mesLogic= new MesLogic(connexion);
				mesLogic.deepSave(empleadoimpuestorenta.getMes(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Estructura.class)) {
				EstructuraDataAccess.save(empleadoimpuestorenta.getEstructura(),connexion);
				EstructuraLogic estructuraLogic= new EstructuraLogic(connexion);
				estructuraLogic.deepSave(empleadoimpuestorenta.getEstructura(),isDeep,deepLoadType,clases);				
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
			this.getNewConnexionToDeep(EmpleadoImpuestoRenta.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(empleadoimpuestorenta,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				EmpleadoImpuestoRentaConstantesFunciones.refrescarForeignKeysDescripcionesEmpleadoImpuestoRenta(empleadoimpuestorenta);
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
			this.deepLoad(this.empleadoimpuestorenta,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				EmpleadoImpuestoRentaConstantesFunciones.refrescarForeignKeysDescripcionesEmpleadoImpuestoRenta(this.empleadoimpuestorenta);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(EmpleadoImpuestoRenta.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(empleadoimpuestorentas!=null) {
				for(EmpleadoImpuestoRenta empleadoimpuestorenta:empleadoimpuestorentas) {
					this.deepLoad(empleadoimpuestorenta,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					EmpleadoImpuestoRentaConstantesFunciones.refrescarForeignKeysDescripcionesEmpleadoImpuestoRenta(empleadoimpuestorentas);
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
			if(empleadoimpuestorentas!=null) {
				for(EmpleadoImpuestoRenta empleadoimpuestorenta:empleadoimpuestorentas) {
					this.deepLoad(empleadoimpuestorenta,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					EmpleadoImpuestoRentaConstantesFunciones.refrescarForeignKeysDescripcionesEmpleadoImpuestoRenta(empleadoimpuestorentas);
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
			this.getNewConnexionToDeep(EmpleadoImpuestoRenta.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(empleadoimpuestorenta,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(EmpleadoImpuestoRenta.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(empleadoimpuestorentas!=null) {
				for(EmpleadoImpuestoRenta empleadoimpuestorenta:empleadoimpuestorentas) {
					this.deepSave(empleadoimpuestorenta,isDeep,deepLoadType,clases);
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
			if(empleadoimpuestorentas!=null) {
				for(EmpleadoImpuestoRenta empleadoimpuestorenta:empleadoimpuestorentas) {
					this.deepSave(empleadoimpuestorenta,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getEmpleadoImpuestoRentasFK_IdAnioWithConnection(String sFinalQuery,Pagination pagination,Long id_anio)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EmpleadoImpuestoRenta.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidAnio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidAnio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_anio,EmpleadoImpuestoRentaConstantesFunciones.IDANIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidAnio);

			EmpleadoImpuestoRentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdAnio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			empleadoimpuestorentas=empleadoimpuestorentaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				EmpleadoImpuestoRentaConstantesFunciones.refrescarForeignKeysDescripcionesEmpleadoImpuestoRenta(this.empleadoimpuestorentas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getEmpleadoImpuestoRentasFK_IdAnio(String sFinalQuery,Pagination pagination,Long id_anio)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidAnio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidAnio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_anio,EmpleadoImpuestoRentaConstantesFunciones.IDANIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidAnio);

			EmpleadoImpuestoRentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdAnio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			empleadoimpuestorentas=empleadoimpuestorentaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				EmpleadoImpuestoRentaConstantesFunciones.refrescarForeignKeysDescripcionesEmpleadoImpuestoRenta(this.empleadoimpuestorentas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getEmpleadoImpuestoRentasFK_IdEmpleadoWithConnection(String sFinalQuery,Pagination pagination,Long id_empleado)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EmpleadoImpuestoRenta.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpleado= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpleado.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empleado,EmpleadoImpuestoRentaConstantesFunciones.IDEMPLEADO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpleado);

			EmpleadoImpuestoRentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpleado","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			empleadoimpuestorentas=empleadoimpuestorentaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				EmpleadoImpuestoRentaConstantesFunciones.refrescarForeignKeysDescripcionesEmpleadoImpuestoRenta(this.empleadoimpuestorentas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getEmpleadoImpuestoRentasFK_IdEmpleado(String sFinalQuery,Pagination pagination,Long id_empleado)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpleado= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpleado.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empleado,EmpleadoImpuestoRentaConstantesFunciones.IDEMPLEADO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpleado);

			EmpleadoImpuestoRentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpleado","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			empleadoimpuestorentas=empleadoimpuestorentaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				EmpleadoImpuestoRentaConstantesFunciones.refrescarForeignKeysDescripcionesEmpleadoImpuestoRenta(this.empleadoimpuestorentas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getEmpleadoImpuestoRentasFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EmpleadoImpuestoRenta.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,EmpleadoImpuestoRentaConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			EmpleadoImpuestoRentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			empleadoimpuestorentas=empleadoimpuestorentaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				EmpleadoImpuestoRentaConstantesFunciones.refrescarForeignKeysDescripcionesEmpleadoImpuestoRenta(this.empleadoimpuestorentas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getEmpleadoImpuestoRentasFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,EmpleadoImpuestoRentaConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			EmpleadoImpuestoRentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			empleadoimpuestorentas=empleadoimpuestorentaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				EmpleadoImpuestoRentaConstantesFunciones.refrescarForeignKeysDescripcionesEmpleadoImpuestoRenta(this.empleadoimpuestorentas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getEmpleadoImpuestoRentasFK_IdEstructuraWithConnection(String sFinalQuery,Pagination pagination,Long id_estructura)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EmpleadoImpuestoRenta.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEstructura= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEstructura.setParameterSelectionGeneralEqual(ParameterType.LONG,id_estructura,EmpleadoImpuestoRentaConstantesFunciones.IDESTRUCTURA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEstructura);

			EmpleadoImpuestoRentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEstructura","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			empleadoimpuestorentas=empleadoimpuestorentaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				EmpleadoImpuestoRentaConstantesFunciones.refrescarForeignKeysDescripcionesEmpleadoImpuestoRenta(this.empleadoimpuestorentas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getEmpleadoImpuestoRentasFK_IdEstructura(String sFinalQuery,Pagination pagination,Long id_estructura)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEstructura= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEstructura.setParameterSelectionGeneralEqual(ParameterType.LONG,id_estructura,EmpleadoImpuestoRentaConstantesFunciones.IDESTRUCTURA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEstructura);

			EmpleadoImpuestoRentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEstructura","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			empleadoimpuestorentas=empleadoimpuestorentaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				EmpleadoImpuestoRentaConstantesFunciones.refrescarForeignKeysDescripcionesEmpleadoImpuestoRenta(this.empleadoimpuestorentas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getEmpleadoImpuestoRentasFK_IdMesWithConnection(String sFinalQuery,Pagination pagination,Long id_mes)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EmpleadoImpuestoRenta.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidMes= new ParameterSelectionGeneral();
			parameterSelectionGeneralidMes.setParameterSelectionGeneralEqual(ParameterType.LONG,id_mes,EmpleadoImpuestoRentaConstantesFunciones.IDMES,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidMes);

			EmpleadoImpuestoRentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdMes","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			empleadoimpuestorentas=empleadoimpuestorentaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				EmpleadoImpuestoRentaConstantesFunciones.refrescarForeignKeysDescripcionesEmpleadoImpuestoRenta(this.empleadoimpuestorentas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getEmpleadoImpuestoRentasFK_IdMes(String sFinalQuery,Pagination pagination,Long id_mes)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidMes= new ParameterSelectionGeneral();
			parameterSelectionGeneralidMes.setParameterSelectionGeneralEqual(ParameterType.LONG,id_mes,EmpleadoImpuestoRentaConstantesFunciones.IDMES,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidMes);

			EmpleadoImpuestoRentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdMes","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			empleadoimpuestorentas=empleadoimpuestorentaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				EmpleadoImpuestoRentaConstantesFunciones.refrescarForeignKeysDescripcionesEmpleadoImpuestoRenta(this.empleadoimpuestorentas);
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
			if(EmpleadoImpuestoRentaConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,EmpleadoImpuestoRentaDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,EmpleadoImpuestoRenta empleadoimpuestorenta,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(EmpleadoImpuestoRentaConstantesFunciones.ISCONAUDITORIA) {
				if(empleadoimpuestorenta.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,EmpleadoImpuestoRentaDataAccess.TABLENAME, empleadoimpuestorenta.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(EmpleadoImpuestoRentaConstantesFunciones.ISCONAUDITORIADETALLE) {
						////EmpleadoImpuestoRentaLogic.registrarAuditoriaDetallesEmpleadoImpuestoRenta(connexion,empleadoimpuestorenta,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(empleadoimpuestorenta.getIsDeleted()) {
					/*if(!empleadoimpuestorenta.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,EmpleadoImpuestoRentaDataAccess.TABLENAME, empleadoimpuestorenta.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////EmpleadoImpuestoRentaLogic.registrarAuditoriaDetallesEmpleadoImpuestoRenta(connexion,empleadoimpuestorenta,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,EmpleadoImpuestoRentaDataAccess.TABLENAME, empleadoimpuestorenta.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(empleadoimpuestorenta.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,EmpleadoImpuestoRentaDataAccess.TABLENAME, empleadoimpuestorenta.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(EmpleadoImpuestoRentaConstantesFunciones.ISCONAUDITORIADETALLE) {
						////EmpleadoImpuestoRentaLogic.registrarAuditoriaDetallesEmpleadoImpuestoRenta(connexion,empleadoimpuestorenta,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesEmpleadoImpuestoRenta(Connexion connexion,EmpleadoImpuestoRenta empleadoimpuestorenta)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(empleadoimpuestorenta.getIsNew()||!empleadoimpuestorenta.getid_empresa().equals(empleadoimpuestorenta.getEmpleadoImpuestoRentaOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(empleadoimpuestorenta.getEmpleadoImpuestoRentaOriginal().getid_empresa()!=null)
				{
					strValorActual=empleadoimpuestorenta.getEmpleadoImpuestoRentaOriginal().getid_empresa().toString();
				}
				if(empleadoimpuestorenta.getid_empresa()!=null)
				{
					strValorNuevo=empleadoimpuestorenta.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),EmpleadoImpuestoRentaConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(empleadoimpuestorenta.getIsNew()||!empleadoimpuestorenta.getid_empleado().equals(empleadoimpuestorenta.getEmpleadoImpuestoRentaOriginal().getid_empleado()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(empleadoimpuestorenta.getEmpleadoImpuestoRentaOriginal().getid_empleado()!=null)
				{
					strValorActual=empleadoimpuestorenta.getEmpleadoImpuestoRentaOriginal().getid_empleado().toString();
				}
				if(empleadoimpuestorenta.getid_empleado()!=null)
				{
					strValorNuevo=empleadoimpuestorenta.getid_empleado().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),EmpleadoImpuestoRentaConstantesFunciones.IDEMPLEADO,strValorActual,strValorNuevo);
			}	
			
			if(empleadoimpuestorenta.getIsNew()||!empleadoimpuestorenta.getid_anio().equals(empleadoimpuestorenta.getEmpleadoImpuestoRentaOriginal().getid_anio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(empleadoimpuestorenta.getEmpleadoImpuestoRentaOriginal().getid_anio()!=null)
				{
					strValorActual=empleadoimpuestorenta.getEmpleadoImpuestoRentaOriginal().getid_anio().toString();
				}
				if(empleadoimpuestorenta.getid_anio()!=null)
				{
					strValorNuevo=empleadoimpuestorenta.getid_anio().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),EmpleadoImpuestoRentaConstantesFunciones.IDANIO,strValorActual,strValorNuevo);
			}	
			
			if(empleadoimpuestorenta.getIsNew()||!empleadoimpuestorenta.getid_mes().equals(empleadoimpuestorenta.getEmpleadoImpuestoRentaOriginal().getid_mes()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(empleadoimpuestorenta.getEmpleadoImpuestoRentaOriginal().getid_mes()!=null)
				{
					strValorActual=empleadoimpuestorenta.getEmpleadoImpuestoRentaOriginal().getid_mes().toString();
				}
				if(empleadoimpuestorenta.getid_mes()!=null)
				{
					strValorNuevo=empleadoimpuestorenta.getid_mes().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),EmpleadoImpuestoRentaConstantesFunciones.IDMES,strValorActual,strValorNuevo);
			}	
			
			if(empleadoimpuestorenta.getIsNew()||!empleadoimpuestorenta.getid_estructura().equals(empleadoimpuestorenta.getEmpleadoImpuestoRentaOriginal().getid_estructura()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(empleadoimpuestorenta.getEmpleadoImpuestoRentaOriginal().getid_estructura()!=null)
				{
					strValorActual=empleadoimpuestorenta.getEmpleadoImpuestoRentaOriginal().getid_estructura().toString();
				}
				if(empleadoimpuestorenta.getid_estructura()!=null)
				{
					strValorNuevo=empleadoimpuestorenta.getid_estructura().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),EmpleadoImpuestoRentaConstantesFunciones.IDESTRUCTURA,strValorActual,strValorNuevo);
			}	
			
			if(empleadoimpuestorenta.getIsNew()||!empleadoimpuestorenta.getfecha().equals(empleadoimpuestorenta.getEmpleadoImpuestoRentaOriginal().getfecha()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(empleadoimpuestorenta.getEmpleadoImpuestoRentaOriginal().getfecha()!=null)
				{
					strValorActual=empleadoimpuestorenta.getEmpleadoImpuestoRentaOriginal().getfecha().toString();
				}
				if(empleadoimpuestorenta.getfecha()!=null)
				{
					strValorNuevo=empleadoimpuestorenta.getfecha().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),EmpleadoImpuestoRentaConstantesFunciones.FECHA,strValorActual,strValorNuevo);
			}	
			
			if(empleadoimpuestorenta.getIsNew()||!empleadoimpuestorenta.getvalor_pago().equals(empleadoimpuestorenta.getEmpleadoImpuestoRentaOriginal().getvalor_pago()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(empleadoimpuestorenta.getEmpleadoImpuestoRentaOriginal().getvalor_pago()!=null)
				{
					strValorActual=empleadoimpuestorenta.getEmpleadoImpuestoRentaOriginal().getvalor_pago().toString();
				}
				if(empleadoimpuestorenta.getvalor_pago()!=null)
				{
					strValorNuevo=empleadoimpuestorenta.getvalor_pago().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),EmpleadoImpuestoRentaConstantesFunciones.VALORPAGO,strValorActual,strValorNuevo);
			}	
			
			if(empleadoimpuestorenta.getIsNew()||!empleadoimpuestorenta.getingreso_liquido().equals(empleadoimpuestorenta.getEmpleadoImpuestoRentaOriginal().getingreso_liquido()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(empleadoimpuestorenta.getEmpleadoImpuestoRentaOriginal().getingreso_liquido()!=null)
				{
					strValorActual=empleadoimpuestorenta.getEmpleadoImpuestoRentaOriginal().getingreso_liquido().toString();
				}
				if(empleadoimpuestorenta.getingreso_liquido()!=null)
				{
					strValorNuevo=empleadoimpuestorenta.getingreso_liquido().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),EmpleadoImpuestoRentaConstantesFunciones.INGRESOLIQUIDO,strValorActual,strValorNuevo);
			}	
			
			if(empleadoimpuestorenta.getIsNew()||!empleadoimpuestorenta.getaporte_iess().equals(empleadoimpuestorenta.getEmpleadoImpuestoRentaOriginal().getaporte_iess()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(empleadoimpuestorenta.getEmpleadoImpuestoRentaOriginal().getaporte_iess()!=null)
				{
					strValorActual=empleadoimpuestorenta.getEmpleadoImpuestoRentaOriginal().getaporte_iess().toString();
				}
				if(empleadoimpuestorenta.getaporte_iess()!=null)
				{
					strValorNuevo=empleadoimpuestorenta.getaporte_iess().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),EmpleadoImpuestoRentaConstantesFunciones.APORTEIESS,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveEmpleadoImpuestoRentaRelacionesWithConnection(EmpleadoImpuestoRenta empleadoimpuestorenta) throws Exception {

		if(!empleadoimpuestorenta.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveEmpleadoImpuestoRentaRelacionesBase(empleadoimpuestorenta,true);
		}
	}

	public void saveEmpleadoImpuestoRentaRelaciones(EmpleadoImpuestoRenta empleadoimpuestorenta)throws Exception {

		if(!empleadoimpuestorenta.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveEmpleadoImpuestoRentaRelacionesBase(empleadoimpuestorenta,false);
		}
	}

	public void saveEmpleadoImpuestoRentaRelacionesBase(EmpleadoImpuestoRenta empleadoimpuestorenta,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("EmpleadoImpuestoRenta-saveRelacionesWithConnection");}
	

			this.setEmpleadoImpuestoRenta(empleadoimpuestorenta);

			if(EmpleadoImpuestoRentaLogicAdditional.validarSaveRelaciones(empleadoimpuestorenta,this)) {

				EmpleadoImpuestoRentaLogicAdditional.updateRelacionesToSave(empleadoimpuestorenta,this);

				if((empleadoimpuestorenta.getIsNew()||empleadoimpuestorenta.getIsChanged())&&!empleadoimpuestorenta.getIsDeleted()) {
					this.saveEmpleadoImpuestoRenta();
					this.saveEmpleadoImpuestoRentaRelacionesDetalles();

				} else if(empleadoimpuestorenta.getIsDeleted()) {
					this.saveEmpleadoImpuestoRentaRelacionesDetalles();
					this.saveEmpleadoImpuestoRenta();
				}

				EmpleadoImpuestoRentaLogicAdditional.updateRelacionesToSaveAfter(empleadoimpuestorenta,this);

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
	
	
	private void saveEmpleadoImpuestoRentaRelacionesDetalles()throws Exception {
		try {
	

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfEmpleadoImpuestoRenta(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=EmpleadoImpuestoRentaConstantesFunciones.getClassesForeignKeysOfEmpleadoImpuestoRenta(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfEmpleadoImpuestoRenta(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=EmpleadoImpuestoRentaConstantesFunciones.getClassesRelationshipsOfEmpleadoImpuestoRenta(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

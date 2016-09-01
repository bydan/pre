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
import com.bydan.erp.facturacion.util.ParametroFactuTransaccionConstantesFunciones;
import com.bydan.erp.facturacion.util.ParametroFactuTransaccionParameterReturnGeneral;
//import com.bydan.erp.facturacion.util.ParametroFactuTransaccionParameterGeneral;
import com.bydan.erp.facturacion.business.entity.ParametroFactuTransaccion;
import com.bydan.erp.facturacion.business.logic.ParametroFactuTransaccionLogicAdditional;
import com.bydan.erp.facturacion.business.dataaccess.*;
import com.bydan.erp.facturacion.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;
import com.bydan.erp.tesoreria.business.logic.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.tesoreria.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.tesoreria.business.dataaccess.*;








@SuppressWarnings("unused")
public class ParametroFactuTransaccionLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(ParametroFactuTransaccionLogic.class);
	
	protected ParametroFactuTransaccionDataAccess parametrofactutransaccionDataAccess; 	
	protected ParametroFactuTransaccion parametrofactutransaccion;
	protected List<ParametroFactuTransaccion> parametrofactutransaccions;
	protected Object parametrofactutransaccionObject;	
	protected List<Object> parametrofactutransaccionsObject;
	
	public static ClassValidator<ParametroFactuTransaccion> parametrofactutransaccionValidator = new ClassValidator<ParametroFactuTransaccion>(ParametroFactuTransaccion.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected ParametroFactuTransaccionLogicAdditional parametrofactutransaccionLogicAdditional=null;
	
	public ParametroFactuTransaccionLogicAdditional getParametroFactuTransaccionLogicAdditional() {
		return this.parametrofactutransaccionLogicAdditional;
	}
	
	public void setParametroFactuTransaccionLogicAdditional(ParametroFactuTransaccionLogicAdditional parametrofactutransaccionLogicAdditional) {
		try {
			this.parametrofactutransaccionLogicAdditional=parametrofactutransaccionLogicAdditional;
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
	
	
	
	
	public  ParametroFactuTransaccionLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.parametrofactutransaccionDataAccess = new ParametroFactuTransaccionDataAccess();
			
			this.parametrofactutransaccions= new ArrayList<ParametroFactuTransaccion>();
			this.parametrofactutransaccion= new ParametroFactuTransaccion();
			
			this.parametrofactutransaccionObject=new Object();
			this.parametrofactutransaccionsObject=new ArrayList<Object>();
				
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
			
			this.parametrofactutransaccionDataAccess.setConnexionType(this.connexionType);
			this.parametrofactutransaccionDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  ParametroFactuTransaccionLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.parametrofactutransaccionDataAccess = new ParametroFactuTransaccionDataAccess();
			this.parametrofactutransaccions= new ArrayList<ParametroFactuTransaccion>();
			this.parametrofactutransaccion= new ParametroFactuTransaccion();
			this.parametrofactutransaccionObject=new Object();
			this.parametrofactutransaccionsObject=new ArrayList<Object>();
			
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
			
			this.parametrofactutransaccionDataAccess.setConnexionType(this.connexionType);
			this.parametrofactutransaccionDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public ParametroFactuTransaccion getParametroFactuTransaccion() throws Exception {	
		ParametroFactuTransaccionLogicAdditional.checkParametroFactuTransaccionToGet(parametrofactutransaccion,this.datosCliente,this.arrDatoGeneral);
		ParametroFactuTransaccionLogicAdditional.updateParametroFactuTransaccionToGet(parametrofactutransaccion,this.arrDatoGeneral);
		
		return parametrofactutransaccion;
	}
		
	public void setParametroFactuTransaccion(ParametroFactuTransaccion newParametroFactuTransaccion) {
		this.parametrofactutransaccion = newParametroFactuTransaccion;
	}
	
	public ParametroFactuTransaccionDataAccess getParametroFactuTransaccionDataAccess() {
		return parametrofactutransaccionDataAccess;
	}
	
	public void setParametroFactuTransaccionDataAccess(ParametroFactuTransaccionDataAccess newparametrofactutransaccionDataAccess) {
		this.parametrofactutransaccionDataAccess = newparametrofactutransaccionDataAccess;
	}
	
	public List<ParametroFactuTransaccion> getParametroFactuTransaccions() throws Exception {		
		this.quitarParametroFactuTransaccionsNulos();
		
		ParametroFactuTransaccionLogicAdditional.checkParametroFactuTransaccionToGets(parametrofactutransaccions,this.datosCliente,this.arrDatoGeneral);
		
		for (ParametroFactuTransaccion parametrofactutransaccionLocal: parametrofactutransaccions ) {
			ParametroFactuTransaccionLogicAdditional.updateParametroFactuTransaccionToGet(parametrofactutransaccionLocal,this.arrDatoGeneral);
		}
		
		return parametrofactutransaccions;
	}
	
	public void setParametroFactuTransaccions(List<ParametroFactuTransaccion> newParametroFactuTransaccions) {
		this.parametrofactutransaccions = newParametroFactuTransaccions;
	}
	
	public Object getParametroFactuTransaccionObject() {	
		this.parametrofactutransaccionObject=this.parametrofactutransaccionDataAccess.getEntityObject();
		return this.parametrofactutransaccionObject;
	}
		
	public void setParametroFactuTransaccionObject(Object newParametroFactuTransaccionObject) {
		this.parametrofactutransaccionObject = newParametroFactuTransaccionObject;
	}
	
	public List<Object> getParametroFactuTransaccionsObject() {		
		this.parametrofactutransaccionsObject=this.parametrofactutransaccionDataAccess.getEntitiesObject();
		return this.parametrofactutransaccionsObject;
	}
		
	public void setParametroFactuTransaccionsObject(List<Object> newParametroFactuTransaccionsObject) {
		this.parametrofactutransaccionsObject = newParametroFactuTransaccionsObject;
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
		
		if(this.parametrofactutransaccionDataAccess!=null) {
			this.parametrofactutransaccionDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroFactuTransaccion.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			parametrofactutransaccionDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			parametrofactutransaccionDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		parametrofactutransaccion = new  ParametroFactuTransaccion();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroFactuTransaccion.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			parametrofactutransaccion=parametrofactutransaccionDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.parametrofactutransaccion,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ParametroFactuTransaccionConstantesFunciones.refrescarForeignKeysDescripcionesParametroFactuTransaccion(this.parametrofactutransaccion);
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
		parametrofactutransaccion = new  ParametroFactuTransaccion();
		  		  
        try {
			
			parametrofactutransaccion=parametrofactutransaccionDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.parametrofactutransaccion,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ParametroFactuTransaccionConstantesFunciones.refrescarForeignKeysDescripcionesParametroFactuTransaccion(this.parametrofactutransaccion);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		parametrofactutransaccion = new  ParametroFactuTransaccion();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroFactuTransaccion.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			parametrofactutransaccion=parametrofactutransaccionDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.parametrofactutransaccion,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ParametroFactuTransaccionConstantesFunciones.refrescarForeignKeysDescripcionesParametroFactuTransaccion(this.parametrofactutransaccion);
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
		parametrofactutransaccion = new  ParametroFactuTransaccion();
		  		  
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
		parametrofactutransaccion = new  ParametroFactuTransaccion();
		  		  
        try {
			
			parametrofactutransaccion=parametrofactutransaccionDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.parametrofactutransaccion,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ParametroFactuTransaccionConstantesFunciones.refrescarForeignKeysDescripcionesParametroFactuTransaccion(this.parametrofactutransaccion);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		parametrofactutransaccion = new  ParametroFactuTransaccion();
		  		  
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
		parametrofactutransaccion = new  ParametroFactuTransaccion();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroFactuTransaccion.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =parametrofactutransaccionDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		parametrofactutransaccion = new  ParametroFactuTransaccion();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=parametrofactutransaccionDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		parametrofactutransaccion = new  ParametroFactuTransaccion();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroFactuTransaccion.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =parametrofactutransaccionDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		parametrofactutransaccion = new  ParametroFactuTransaccion();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=parametrofactutransaccionDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		parametrofactutransaccion = new  ParametroFactuTransaccion();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroFactuTransaccion.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =parametrofactutransaccionDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		parametrofactutransaccion = new  ParametroFactuTransaccion();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=parametrofactutransaccionDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		parametrofactutransaccions = new  ArrayList<ParametroFactuTransaccion>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroFactuTransaccion.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			ParametroFactuTransaccionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametrofactutransaccions=parametrofactutransaccionDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarParametroFactuTransaccion(parametrofactutransaccions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroFactuTransaccionConstantesFunciones.refrescarForeignKeysDescripcionesParametroFactuTransaccion(this.parametrofactutransaccions);
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
		parametrofactutransaccions = new  ArrayList<ParametroFactuTransaccion>();
		  		  
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
		parametrofactutransaccions = new  ArrayList<ParametroFactuTransaccion>();
		  		  
        try {			
			ParametroFactuTransaccionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametrofactutransaccions=parametrofactutransaccionDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarParametroFactuTransaccion(parametrofactutransaccions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroFactuTransaccionConstantesFunciones.refrescarForeignKeysDescripcionesParametroFactuTransaccion(this.parametrofactutransaccions);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		parametrofactutransaccions = new  ArrayList<ParametroFactuTransaccion>();
		  		  
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
		parametrofactutransaccions = new  ArrayList<ParametroFactuTransaccion>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroFactuTransaccion.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			ParametroFactuTransaccionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametrofactutransaccions=parametrofactutransaccionDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarParametroFactuTransaccion(parametrofactutransaccions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroFactuTransaccionConstantesFunciones.refrescarForeignKeysDescripcionesParametroFactuTransaccion(this.parametrofactutransaccions);
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
		parametrofactutransaccions = new  ArrayList<ParametroFactuTransaccion>();
		  		  
        try {
			ParametroFactuTransaccionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametrofactutransaccions=parametrofactutransaccionDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarParametroFactuTransaccion(parametrofactutransaccions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroFactuTransaccionConstantesFunciones.refrescarForeignKeysDescripcionesParametroFactuTransaccion(this.parametrofactutransaccions);
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
		parametrofactutransaccions = new  ArrayList<ParametroFactuTransaccion>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroFactuTransaccion.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ParametroFactuTransaccionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametrofactutransaccions=parametrofactutransaccionDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarParametroFactuTransaccion(parametrofactutransaccions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroFactuTransaccionConstantesFunciones.refrescarForeignKeysDescripcionesParametroFactuTransaccion(this.parametrofactutransaccions);
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
		parametrofactutransaccions = new  ArrayList<ParametroFactuTransaccion>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ParametroFactuTransaccionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametrofactutransaccions=parametrofactutransaccionDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarParametroFactuTransaccion(parametrofactutransaccions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroFactuTransaccionConstantesFunciones.refrescarForeignKeysDescripcionesParametroFactuTransaccion(this.parametrofactutransaccions);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		parametrofactutransaccion = new  ParametroFactuTransaccion();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroFactuTransaccion.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ParametroFactuTransaccionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametrofactutransaccion=parametrofactutransaccionDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarParametroFactuTransaccion(parametrofactutransaccion);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroFactuTransaccionConstantesFunciones.refrescarForeignKeysDescripcionesParametroFactuTransaccion(this.parametrofactutransaccion);
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
		parametrofactutransaccion = new  ParametroFactuTransaccion();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ParametroFactuTransaccionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametrofactutransaccion=parametrofactutransaccionDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarParametroFactuTransaccion(parametrofactutransaccion);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroFactuTransaccionConstantesFunciones.refrescarForeignKeysDescripcionesParametroFactuTransaccion(this.parametrofactutransaccion);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		parametrofactutransaccions = new  ArrayList<ParametroFactuTransaccion>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroFactuTransaccion.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			ParametroFactuTransaccionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametrofactutransaccions=parametrofactutransaccionDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarParametroFactuTransaccion(parametrofactutransaccions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroFactuTransaccionConstantesFunciones.refrescarForeignKeysDescripcionesParametroFactuTransaccion(this.parametrofactutransaccions);
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
		parametrofactutransaccions = new  ArrayList<ParametroFactuTransaccion>();
		  		  
        try {
			ParametroFactuTransaccionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametrofactutransaccions=parametrofactutransaccionDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarParametroFactuTransaccion(parametrofactutransaccions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroFactuTransaccionConstantesFunciones.refrescarForeignKeysDescripcionesParametroFactuTransaccion(this.parametrofactutransaccions);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosParametroFactuTransaccionsWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		parametrofactutransaccions = new  ArrayList<ParametroFactuTransaccion>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroFactuTransaccion.class.getSimpleName()+"-getTodosParametroFactuTransaccionsWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ParametroFactuTransaccionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametrofactutransaccions=parametrofactutransaccionDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarParametroFactuTransaccion(parametrofactutransaccions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroFactuTransaccionConstantesFunciones.refrescarForeignKeysDescripcionesParametroFactuTransaccion(this.parametrofactutransaccions);
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
	
	public  void  getTodosParametroFactuTransaccions(String sFinalQuery,Pagination pagination)throws Exception {
		parametrofactutransaccions = new  ArrayList<ParametroFactuTransaccion>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ParametroFactuTransaccionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametrofactutransaccions=parametrofactutransaccionDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarParametroFactuTransaccion(parametrofactutransaccions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroFactuTransaccionConstantesFunciones.refrescarForeignKeysDescripcionesParametroFactuTransaccion(this.parametrofactutransaccions);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarParametroFactuTransaccion(ParametroFactuTransaccion parametrofactutransaccion) throws Exception {
		Boolean estaValidado=false;
		
		if(parametrofactutransaccion.getIsNew() || parametrofactutransaccion.getIsChanged()) { 
			this.invalidValues = parametrofactutransaccionValidator.getInvalidValues(parametrofactutransaccion);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(parametrofactutransaccion);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarParametroFactuTransaccion(List<ParametroFactuTransaccion> ParametroFactuTransaccions) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(ParametroFactuTransaccion parametrofactutransaccionLocal:parametrofactutransaccions) {				
			estaValidadoObjeto=this.validarGuardarParametroFactuTransaccion(parametrofactutransaccionLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarParametroFactuTransaccion(List<ParametroFactuTransaccion> ParametroFactuTransaccions) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarParametroFactuTransaccion(parametrofactutransaccions)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarParametroFactuTransaccion(ParametroFactuTransaccion ParametroFactuTransaccion) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarParametroFactuTransaccion(parametrofactutransaccion)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(ParametroFactuTransaccion parametrofactutransaccion) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+parametrofactutransaccion.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=ParametroFactuTransaccionConstantesFunciones.getParametroFactuTransaccionLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"parametrofactutransaccion","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(ParametroFactuTransaccionConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(ParametroFactuTransaccionConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveParametroFactuTransaccionWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroFactuTransaccion.class.getSimpleName()+"-saveParametroFactuTransaccionWithConnection");connexion.begin();			
			
			ParametroFactuTransaccionLogicAdditional.checkParametroFactuTransaccionToSave(this.parametrofactutransaccion,this.datosCliente,connexion,this.arrDatoGeneral);
			
			ParametroFactuTransaccionLogicAdditional.updateParametroFactuTransaccionToSave(this.parametrofactutransaccion,this.arrDatoGeneral);
			
			ParametroFactuTransaccionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.parametrofactutransaccion,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowParametroFactuTransaccion();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarParametroFactuTransaccion(this.parametrofactutransaccion)) {
				ParametroFactuTransaccionDataAccess.save(this.parametrofactutransaccion, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.parametrofactutransaccion,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			ParametroFactuTransaccionLogicAdditional.checkParametroFactuTransaccionToSaveAfter(this.parametrofactutransaccion,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowParametroFactuTransaccion();
			
			connexion.commit();			
			
			if(this.parametrofactutransaccion.getIsDeleted()) {
				this.parametrofactutransaccion=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveParametroFactuTransaccion()throws Exception {	
		try {	
			
			ParametroFactuTransaccionLogicAdditional.checkParametroFactuTransaccionToSave(this.parametrofactutransaccion,this.datosCliente,connexion,this.arrDatoGeneral);
			
			ParametroFactuTransaccionLogicAdditional.updateParametroFactuTransaccionToSave(this.parametrofactutransaccion,this.arrDatoGeneral);
			
			ParametroFactuTransaccionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.parametrofactutransaccion,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarParametroFactuTransaccion(this.parametrofactutransaccion)) {			
				ParametroFactuTransaccionDataAccess.save(this.parametrofactutransaccion, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.parametrofactutransaccion,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			ParametroFactuTransaccionLogicAdditional.checkParametroFactuTransaccionToSaveAfter(this.parametrofactutransaccion,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.parametrofactutransaccion.getIsDeleted()) {
				this.parametrofactutransaccion=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveParametroFactuTransaccionsWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroFactuTransaccion.class.getSimpleName()+"-saveParametroFactuTransaccionsWithConnection");connexion.begin();			
			
			ParametroFactuTransaccionLogicAdditional.checkParametroFactuTransaccionToSaves(parametrofactutransaccions,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowParametroFactuTransaccions();
			
			Boolean validadoTodosParametroFactuTransaccion=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(ParametroFactuTransaccion parametrofactutransaccionLocal:parametrofactutransaccions) {		
				if(parametrofactutransaccionLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				ParametroFactuTransaccionLogicAdditional.updateParametroFactuTransaccionToSave(parametrofactutransaccionLocal,this.arrDatoGeneral);
	        	
				ParametroFactuTransaccionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),parametrofactutransaccionLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarParametroFactuTransaccion(parametrofactutransaccionLocal)) {
					ParametroFactuTransaccionDataAccess.save(parametrofactutransaccionLocal, connexion);				
				} else {
					validadoTodosParametroFactuTransaccion=false;
				}
			}
			
			if(!validadoTodosParametroFactuTransaccion) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			ParametroFactuTransaccionLogicAdditional.checkParametroFactuTransaccionToSavesAfter(parametrofactutransaccions,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowParametroFactuTransaccions();
			
			connexion.commit();		
			
			this.quitarParametroFactuTransaccionsEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveParametroFactuTransaccions()throws Exception {				
		 try {	
			ParametroFactuTransaccionLogicAdditional.checkParametroFactuTransaccionToSaves(parametrofactutransaccions,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosParametroFactuTransaccion=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(ParametroFactuTransaccion parametrofactutransaccionLocal:parametrofactutransaccions) {				
				if(parametrofactutransaccionLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				ParametroFactuTransaccionLogicAdditional.updateParametroFactuTransaccionToSave(parametrofactutransaccionLocal,this.arrDatoGeneral);
	        	
				ParametroFactuTransaccionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),parametrofactutransaccionLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarParametroFactuTransaccion(parametrofactutransaccionLocal)) {				
					ParametroFactuTransaccionDataAccess.save(parametrofactutransaccionLocal, connexion);				
				} else {
					validadoTodosParametroFactuTransaccion=false;
				}
			}
			
			if(!validadoTodosParametroFactuTransaccion) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			ParametroFactuTransaccionLogicAdditional.checkParametroFactuTransaccionToSavesAfter(parametrofactutransaccions,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarParametroFactuTransaccionsEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public ParametroFactuTransaccionParameterReturnGeneral procesarAccionParametroFactuTransaccions(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<ParametroFactuTransaccion> parametrofactutransaccions,ParametroFactuTransaccionParameterReturnGeneral parametrofactutransaccionParameterGeneral)throws Exception {
		 try {	
			ParametroFactuTransaccionParameterReturnGeneral parametrofactutransaccionReturnGeneral=new ParametroFactuTransaccionParameterReturnGeneral();
	
			ParametroFactuTransaccionLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,parametrofactutransaccions,parametrofactutransaccionParameterGeneral,parametrofactutransaccionReturnGeneral);
			
			return parametrofactutransaccionReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public ParametroFactuTransaccionParameterReturnGeneral procesarAccionParametroFactuTransaccionsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<ParametroFactuTransaccion> parametrofactutransaccions,ParametroFactuTransaccionParameterReturnGeneral parametrofactutransaccionParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroFactuTransaccion.class.getSimpleName()+"-procesarAccionParametroFactuTransaccionsWithConnection");connexion.begin();			
			
			ParametroFactuTransaccionParameterReturnGeneral parametrofactutransaccionReturnGeneral=new ParametroFactuTransaccionParameterReturnGeneral();
	
			ParametroFactuTransaccionLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,parametrofactutransaccions,parametrofactutransaccionParameterGeneral,parametrofactutransaccionReturnGeneral);
			
			this.connexion.commit();
			
			return parametrofactutransaccionReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public ParametroFactuTransaccionParameterReturnGeneral procesarEventosParametroFactuTransaccions(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<ParametroFactuTransaccion> parametrofactutransaccions,ParametroFactuTransaccion parametrofactutransaccion,ParametroFactuTransaccionParameterReturnGeneral parametrofactutransaccionParameterGeneral,Boolean isEsNuevoParametroFactuTransaccion,ArrayList<Classe> clases)throws Exception {
		 try {	
			ParametroFactuTransaccionParameterReturnGeneral parametrofactutransaccionReturnGeneral=new ParametroFactuTransaccionParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				parametrofactutransaccionReturnGeneral.setConRecargarPropiedades(true);
			}
			
			ParametroFactuTransaccionLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,parametrofactutransaccions,parametrofactutransaccion,parametrofactutransaccionParameterGeneral,parametrofactutransaccionReturnGeneral,isEsNuevoParametroFactuTransaccion,clases);
			
			return parametrofactutransaccionReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public ParametroFactuTransaccionParameterReturnGeneral procesarEventosParametroFactuTransaccionsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<ParametroFactuTransaccion> parametrofactutransaccions,ParametroFactuTransaccion parametrofactutransaccion,ParametroFactuTransaccionParameterReturnGeneral parametrofactutransaccionParameterGeneral,Boolean isEsNuevoParametroFactuTransaccion,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroFactuTransaccion.class.getSimpleName()+"-procesarEventosParametroFactuTransaccionsWithConnection");connexion.begin();			
			
			ParametroFactuTransaccionParameterReturnGeneral parametrofactutransaccionReturnGeneral=new ParametroFactuTransaccionParameterReturnGeneral();
	
			parametrofactutransaccionReturnGeneral.setParametroFactuTransaccion(parametrofactutransaccion);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				parametrofactutransaccionReturnGeneral.setConRecargarPropiedades(true);
			}
			
			ParametroFactuTransaccionLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,parametrofactutransaccions,parametrofactutransaccion,parametrofactutransaccionParameterGeneral,parametrofactutransaccionReturnGeneral,isEsNuevoParametroFactuTransaccion,clases);
			
			this.connexion.commit();
			
			return parametrofactutransaccionReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public ParametroFactuTransaccionParameterReturnGeneral procesarImportacionParametroFactuTransaccionsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,ParametroFactuTransaccionParameterReturnGeneral parametrofactutransaccionParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroFactuTransaccion.class.getSimpleName()+"-procesarImportacionParametroFactuTransaccionsWithConnection");connexion.begin();			
			
			ParametroFactuTransaccionParameterReturnGeneral parametrofactutransaccionReturnGeneral=new ParametroFactuTransaccionParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.parametrofactutransaccions=new ArrayList<ParametroFactuTransaccion>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.parametrofactutransaccion=new ParametroFactuTransaccion();
				
				
				if(conColumnasBase) {this.parametrofactutransaccion.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.parametrofactutransaccion.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				
				this.parametrofactutransaccions.add(this.parametrofactutransaccion);
			}
			
			this.saveParametroFactuTransaccions();
			
			this.connexion.commit();
			
			parametrofactutransaccionReturnGeneral.setConRetornoEstaProcesado(true);
			parametrofactutransaccionReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return parametrofactutransaccionReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarParametroFactuTransaccionsEliminados() throws Exception {				
		
		List<ParametroFactuTransaccion> parametrofactutransaccionsAux= new ArrayList<ParametroFactuTransaccion>();
		
		for(ParametroFactuTransaccion parametrofactutransaccion:parametrofactutransaccions) {
			if(!parametrofactutransaccion.getIsDeleted()) {
				parametrofactutransaccionsAux.add(parametrofactutransaccion);
			}
		}
		
		parametrofactutransaccions=parametrofactutransaccionsAux;
	}
	
	public void quitarParametroFactuTransaccionsNulos() throws Exception {				
		
		List<ParametroFactuTransaccion> parametrofactutransaccionsAux= new ArrayList<ParametroFactuTransaccion>();
		
		for(ParametroFactuTransaccion parametrofactutransaccion : this.parametrofactutransaccions) {
			if(parametrofactutransaccion==null) {
				parametrofactutransaccionsAux.add(parametrofactutransaccion);
			}
		}
		
		//this.parametrofactutransaccions=parametrofactutransaccionsAux;
		
		this.parametrofactutransaccions.removeAll(parametrofactutransaccionsAux);
	}
	
	public void getSetVersionRowParametroFactuTransaccionWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(parametrofactutransaccion.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((parametrofactutransaccion.getIsDeleted() || (parametrofactutransaccion.getIsChanged()&&!parametrofactutransaccion.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=parametrofactutransaccionDataAccess.getSetVersionRowParametroFactuTransaccion(connexion,parametrofactutransaccion.getId());
				
				if(!parametrofactutransaccion.getVersionRow().equals(timestamp)) {	
					parametrofactutransaccion.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				parametrofactutransaccion.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowParametroFactuTransaccion()throws Exception {	
		
		if(parametrofactutransaccion.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((parametrofactutransaccion.getIsDeleted() || (parametrofactutransaccion.getIsChanged()&&!parametrofactutransaccion.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=parametrofactutransaccionDataAccess.getSetVersionRowParametroFactuTransaccion(connexion,parametrofactutransaccion.getId());
			
			try {							
				if(!parametrofactutransaccion.getVersionRow().equals(timestamp)) {	
					parametrofactutransaccion.setVersionRow(timestamp);
				}
				
				parametrofactutransaccion.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowParametroFactuTransaccionsWithConnection()throws Exception {	
		if(parametrofactutransaccions!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(ParametroFactuTransaccion parametrofactutransaccionAux:parametrofactutransaccions) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(parametrofactutransaccionAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(parametrofactutransaccionAux.getIsDeleted() || (parametrofactutransaccionAux.getIsChanged()&&!parametrofactutransaccionAux.getIsNew())) {
						
						timestamp=parametrofactutransaccionDataAccess.getSetVersionRowParametroFactuTransaccion(connexion,parametrofactutransaccionAux.getId());
						
						if(!parametrofactutransaccion.getVersionRow().equals(timestamp)) {	
							parametrofactutransaccionAux.setVersionRow(timestamp);
						}
								
						parametrofactutransaccionAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowParametroFactuTransaccions()throws Exception {	
		if(parametrofactutransaccions!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(ParametroFactuTransaccion parametrofactutransaccionAux:parametrofactutransaccions) {
					if(parametrofactutransaccionAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(parametrofactutransaccionAux.getIsDeleted() || (parametrofactutransaccionAux.getIsChanged()&&!parametrofactutransaccionAux.getIsNew())) {
						
						timestamp=parametrofactutransaccionDataAccess.getSetVersionRowParametroFactuTransaccion(connexion,parametrofactutransaccionAux.getId());
						
						if(!parametrofactutransaccionAux.getVersionRow().equals(timestamp)) {	
							parametrofactutransaccionAux.setVersionRow(timestamp);
						}
						
													
						parametrofactutransaccionAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public ParametroFactuTransaccionParameterReturnGeneral cargarCombosLoteForeignKeyParametroFactuTransaccionWithConnection(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalTransaccionInvenFactura,String finalQueryGlobalTransaccionInvenNotaCredito,String finalQueryGlobalTransaccionInvenNotaVenta,String finalQueryGlobalTransaccionCuentaCoFactura,String finalQueryGlobalTransaccionCuentaCoNotaCredito,String finalQueryGlobalTransaccionCuentaCoNotaVenta,String finalQueryGlobalTransaccionCuentaCoTarjeta,String finalQueryGlobalTransaccionCuentaPaFactura,String finalQueryGlobalTransaccionCuentaPaNotaCredito) throws Exception {
		ParametroFactuTransaccionParameterReturnGeneral  parametrofactutransaccionReturnGeneral =new ParametroFactuTransaccionParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroFactuTransaccion.class.getSimpleName()+"-cargarCombosLoteForeignKeyParametroFactuTransaccionWithConnection");connexion.begin();
			
			parametrofactutransaccionReturnGeneral =new ParametroFactuTransaccionParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			parametrofactutransaccionReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			parametrofactutransaccionReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Transaccion> transaccioninvenfacturasForeignKey=new ArrayList<Transaccion>();
			TransaccionLogic transaccioninvenfacturaLogic=new TransaccionLogic();
			transaccioninvenfacturaLogic.setConnexion(this.connexion);
			transaccioninvenfacturaLogic.getTransaccionDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTransaccionInvenFactura.equals("NONE")) {
				transaccioninvenfacturaLogic.getTodosTransaccions(finalQueryGlobalTransaccionInvenFactura,new Pagination());
				transaccioninvenfacturasForeignKey=transaccioninvenfacturaLogic.getTransaccions();
			}

			parametrofactutransaccionReturnGeneral.settransaccioninvenfacturasForeignKey(transaccioninvenfacturasForeignKey);


			List<Transaccion> transaccioninvennotacreditosForeignKey=new ArrayList<Transaccion>();
			TransaccionLogic transaccioninvennotacreditoLogic=new TransaccionLogic();
			transaccioninvennotacreditoLogic.setConnexion(this.connexion);
			transaccioninvennotacreditoLogic.getTransaccionDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTransaccionInvenNotaCredito.equals("NONE")) {
				transaccioninvennotacreditoLogic.getTodosTransaccions(finalQueryGlobalTransaccionInvenNotaCredito,new Pagination());
				transaccioninvennotacreditosForeignKey=transaccioninvennotacreditoLogic.getTransaccions();
			}

			parametrofactutransaccionReturnGeneral.settransaccioninvennotacreditosForeignKey(transaccioninvennotacreditosForeignKey);


			List<Transaccion> transaccioninvennotaventasForeignKey=new ArrayList<Transaccion>();
			TransaccionLogic transaccioninvennotaventaLogic=new TransaccionLogic();
			transaccioninvennotaventaLogic.setConnexion(this.connexion);
			transaccioninvennotaventaLogic.getTransaccionDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTransaccionInvenNotaVenta.equals("NONE")) {
				transaccioninvennotaventaLogic.getTodosTransaccions(finalQueryGlobalTransaccionInvenNotaVenta,new Pagination());
				transaccioninvennotaventasForeignKey=transaccioninvennotaventaLogic.getTransaccions();
			}

			parametrofactutransaccionReturnGeneral.settransaccioninvennotaventasForeignKey(transaccioninvennotaventasForeignKey);


			List<Transaccion> transaccioncuentacofacturasForeignKey=new ArrayList<Transaccion>();
			TransaccionLogic transaccioncuentacofacturaLogic=new TransaccionLogic();
			transaccioncuentacofacturaLogic.setConnexion(this.connexion);
			transaccioncuentacofacturaLogic.getTransaccionDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTransaccionCuentaCoFactura.equals("NONE")) {
				transaccioncuentacofacturaLogic.getTodosTransaccions(finalQueryGlobalTransaccionCuentaCoFactura,new Pagination());
				transaccioncuentacofacturasForeignKey=transaccioncuentacofacturaLogic.getTransaccions();
			}

			parametrofactutransaccionReturnGeneral.settransaccioncuentacofacturasForeignKey(transaccioncuentacofacturasForeignKey);


			List<Transaccion> transaccioncuentaconotacreditosForeignKey=new ArrayList<Transaccion>();
			TransaccionLogic transaccioncuentaconotacreditoLogic=new TransaccionLogic();
			transaccioncuentaconotacreditoLogic.setConnexion(this.connexion);
			transaccioncuentaconotacreditoLogic.getTransaccionDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTransaccionCuentaCoNotaCredito.equals("NONE")) {
				transaccioncuentaconotacreditoLogic.getTodosTransaccions(finalQueryGlobalTransaccionCuentaCoNotaCredito,new Pagination());
				transaccioncuentaconotacreditosForeignKey=transaccioncuentaconotacreditoLogic.getTransaccions();
			}

			parametrofactutransaccionReturnGeneral.settransaccioncuentaconotacreditosForeignKey(transaccioncuentaconotacreditosForeignKey);


			List<Transaccion> transaccioncuentaconotaventasForeignKey=new ArrayList<Transaccion>();
			TransaccionLogic transaccioncuentaconotaventaLogic=new TransaccionLogic();
			transaccioncuentaconotaventaLogic.setConnexion(this.connexion);
			transaccioncuentaconotaventaLogic.getTransaccionDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTransaccionCuentaCoNotaVenta.equals("NONE")) {
				transaccioncuentaconotaventaLogic.getTodosTransaccions(finalQueryGlobalTransaccionCuentaCoNotaVenta,new Pagination());
				transaccioncuentaconotaventasForeignKey=transaccioncuentaconotaventaLogic.getTransaccions();
			}

			parametrofactutransaccionReturnGeneral.settransaccioncuentaconotaventasForeignKey(transaccioncuentaconotaventasForeignKey);


			List<Transaccion> transaccioncuentacotarjetasForeignKey=new ArrayList<Transaccion>();
			TransaccionLogic transaccioncuentacotarjetaLogic=new TransaccionLogic();
			transaccioncuentacotarjetaLogic.setConnexion(this.connexion);
			transaccioncuentacotarjetaLogic.getTransaccionDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTransaccionCuentaCoTarjeta.equals("NONE")) {
				transaccioncuentacotarjetaLogic.getTodosTransaccions(finalQueryGlobalTransaccionCuentaCoTarjeta,new Pagination());
				transaccioncuentacotarjetasForeignKey=transaccioncuentacotarjetaLogic.getTransaccions();
			}

			parametrofactutransaccionReturnGeneral.settransaccioncuentacotarjetasForeignKey(transaccioncuentacotarjetasForeignKey);


			List<Transaccion> transaccioncuentapafacturasForeignKey=new ArrayList<Transaccion>();
			TransaccionLogic transaccioncuentapafacturaLogic=new TransaccionLogic();
			transaccioncuentapafacturaLogic.setConnexion(this.connexion);
			transaccioncuentapafacturaLogic.getTransaccionDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTransaccionCuentaPaFactura.equals("NONE")) {
				transaccioncuentapafacturaLogic.getTodosTransaccions(finalQueryGlobalTransaccionCuentaPaFactura,new Pagination());
				transaccioncuentapafacturasForeignKey=transaccioncuentapafacturaLogic.getTransaccions();
			}

			parametrofactutransaccionReturnGeneral.settransaccioncuentapafacturasForeignKey(transaccioncuentapafacturasForeignKey);


			List<Transaccion> transaccioncuentapanotacreditosForeignKey=new ArrayList<Transaccion>();
			TransaccionLogic transaccioncuentapanotacreditoLogic=new TransaccionLogic();
			transaccioncuentapanotacreditoLogic.setConnexion(this.connexion);
			transaccioncuentapanotacreditoLogic.getTransaccionDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTransaccionCuentaPaNotaCredito.equals("NONE")) {
				transaccioncuentapanotacreditoLogic.getTodosTransaccions(finalQueryGlobalTransaccionCuentaPaNotaCredito,new Pagination());
				transaccioncuentapanotacreditosForeignKey=transaccioncuentapanotacreditoLogic.getTransaccions();
			}

			parametrofactutransaccionReturnGeneral.settransaccioncuentapanotacreditosForeignKey(transaccioncuentapanotacreditosForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return parametrofactutransaccionReturnGeneral;
	}
	
	public ParametroFactuTransaccionParameterReturnGeneral cargarCombosLoteForeignKeyParametroFactuTransaccion(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalTransaccionInvenFactura,String finalQueryGlobalTransaccionInvenNotaCredito,String finalQueryGlobalTransaccionInvenNotaVenta,String finalQueryGlobalTransaccionCuentaCoFactura,String finalQueryGlobalTransaccionCuentaCoNotaCredito,String finalQueryGlobalTransaccionCuentaCoNotaVenta,String finalQueryGlobalTransaccionCuentaCoTarjeta,String finalQueryGlobalTransaccionCuentaPaFactura,String finalQueryGlobalTransaccionCuentaPaNotaCredito) throws Exception {
		ParametroFactuTransaccionParameterReturnGeneral  parametrofactutransaccionReturnGeneral =new ParametroFactuTransaccionParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			parametrofactutransaccionReturnGeneral =new ParametroFactuTransaccionParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			parametrofactutransaccionReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			parametrofactutransaccionReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Transaccion> transaccioninvenfacturasForeignKey=new ArrayList<Transaccion>();
			TransaccionLogic transaccioninvenfacturaLogic=new TransaccionLogic();
			transaccioninvenfacturaLogic.setConnexion(this.connexion);
			transaccioninvenfacturaLogic.getTransaccionDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTransaccionInvenFactura.equals("NONE")) {
				transaccioninvenfacturaLogic.getTodosTransaccions(finalQueryGlobalTransaccionInvenFactura,new Pagination());
				transaccioninvenfacturasForeignKey=transaccioninvenfacturaLogic.getTransaccions();
			}

			parametrofactutransaccionReturnGeneral.settransaccioninvenfacturasForeignKey(transaccioninvenfacturasForeignKey);


			List<Transaccion> transaccioninvennotacreditosForeignKey=new ArrayList<Transaccion>();
			TransaccionLogic transaccioninvennotacreditoLogic=new TransaccionLogic();
			transaccioninvennotacreditoLogic.setConnexion(this.connexion);
			transaccioninvennotacreditoLogic.getTransaccionDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTransaccionInvenNotaCredito.equals("NONE")) {
				transaccioninvennotacreditoLogic.getTodosTransaccions(finalQueryGlobalTransaccionInvenNotaCredito,new Pagination());
				transaccioninvennotacreditosForeignKey=transaccioninvennotacreditoLogic.getTransaccions();
			}

			parametrofactutransaccionReturnGeneral.settransaccioninvennotacreditosForeignKey(transaccioninvennotacreditosForeignKey);


			List<Transaccion> transaccioninvennotaventasForeignKey=new ArrayList<Transaccion>();
			TransaccionLogic transaccioninvennotaventaLogic=new TransaccionLogic();
			transaccioninvennotaventaLogic.setConnexion(this.connexion);
			transaccioninvennotaventaLogic.getTransaccionDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTransaccionInvenNotaVenta.equals("NONE")) {
				transaccioninvennotaventaLogic.getTodosTransaccions(finalQueryGlobalTransaccionInvenNotaVenta,new Pagination());
				transaccioninvennotaventasForeignKey=transaccioninvennotaventaLogic.getTransaccions();
			}

			parametrofactutransaccionReturnGeneral.settransaccioninvennotaventasForeignKey(transaccioninvennotaventasForeignKey);


			List<Transaccion> transaccioncuentacofacturasForeignKey=new ArrayList<Transaccion>();
			TransaccionLogic transaccioncuentacofacturaLogic=new TransaccionLogic();
			transaccioncuentacofacturaLogic.setConnexion(this.connexion);
			transaccioncuentacofacturaLogic.getTransaccionDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTransaccionCuentaCoFactura.equals("NONE")) {
				transaccioncuentacofacturaLogic.getTodosTransaccions(finalQueryGlobalTransaccionCuentaCoFactura,new Pagination());
				transaccioncuentacofacturasForeignKey=transaccioncuentacofacturaLogic.getTransaccions();
			}

			parametrofactutransaccionReturnGeneral.settransaccioncuentacofacturasForeignKey(transaccioncuentacofacturasForeignKey);


			List<Transaccion> transaccioncuentaconotacreditosForeignKey=new ArrayList<Transaccion>();
			TransaccionLogic transaccioncuentaconotacreditoLogic=new TransaccionLogic();
			transaccioncuentaconotacreditoLogic.setConnexion(this.connexion);
			transaccioncuentaconotacreditoLogic.getTransaccionDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTransaccionCuentaCoNotaCredito.equals("NONE")) {
				transaccioncuentaconotacreditoLogic.getTodosTransaccions(finalQueryGlobalTransaccionCuentaCoNotaCredito,new Pagination());
				transaccioncuentaconotacreditosForeignKey=transaccioncuentaconotacreditoLogic.getTransaccions();
			}

			parametrofactutransaccionReturnGeneral.settransaccioncuentaconotacreditosForeignKey(transaccioncuentaconotacreditosForeignKey);


			List<Transaccion> transaccioncuentaconotaventasForeignKey=new ArrayList<Transaccion>();
			TransaccionLogic transaccioncuentaconotaventaLogic=new TransaccionLogic();
			transaccioncuentaconotaventaLogic.setConnexion(this.connexion);
			transaccioncuentaconotaventaLogic.getTransaccionDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTransaccionCuentaCoNotaVenta.equals("NONE")) {
				transaccioncuentaconotaventaLogic.getTodosTransaccions(finalQueryGlobalTransaccionCuentaCoNotaVenta,new Pagination());
				transaccioncuentaconotaventasForeignKey=transaccioncuentaconotaventaLogic.getTransaccions();
			}

			parametrofactutransaccionReturnGeneral.settransaccioncuentaconotaventasForeignKey(transaccioncuentaconotaventasForeignKey);


			List<Transaccion> transaccioncuentacotarjetasForeignKey=new ArrayList<Transaccion>();
			TransaccionLogic transaccioncuentacotarjetaLogic=new TransaccionLogic();
			transaccioncuentacotarjetaLogic.setConnexion(this.connexion);
			transaccioncuentacotarjetaLogic.getTransaccionDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTransaccionCuentaCoTarjeta.equals("NONE")) {
				transaccioncuentacotarjetaLogic.getTodosTransaccions(finalQueryGlobalTransaccionCuentaCoTarjeta,new Pagination());
				transaccioncuentacotarjetasForeignKey=transaccioncuentacotarjetaLogic.getTransaccions();
			}

			parametrofactutransaccionReturnGeneral.settransaccioncuentacotarjetasForeignKey(transaccioncuentacotarjetasForeignKey);


			List<Transaccion> transaccioncuentapafacturasForeignKey=new ArrayList<Transaccion>();
			TransaccionLogic transaccioncuentapafacturaLogic=new TransaccionLogic();
			transaccioncuentapafacturaLogic.setConnexion(this.connexion);
			transaccioncuentapafacturaLogic.getTransaccionDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTransaccionCuentaPaFactura.equals("NONE")) {
				transaccioncuentapafacturaLogic.getTodosTransaccions(finalQueryGlobalTransaccionCuentaPaFactura,new Pagination());
				transaccioncuentapafacturasForeignKey=transaccioncuentapafacturaLogic.getTransaccions();
			}

			parametrofactutransaccionReturnGeneral.settransaccioncuentapafacturasForeignKey(transaccioncuentapafacturasForeignKey);


			List<Transaccion> transaccioncuentapanotacreditosForeignKey=new ArrayList<Transaccion>();
			TransaccionLogic transaccioncuentapanotacreditoLogic=new TransaccionLogic();
			transaccioncuentapanotacreditoLogic.setConnexion(this.connexion);
			transaccioncuentapanotacreditoLogic.getTransaccionDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTransaccionCuentaPaNotaCredito.equals("NONE")) {
				transaccioncuentapanotacreditoLogic.getTodosTransaccions(finalQueryGlobalTransaccionCuentaPaNotaCredito,new Pagination());
				transaccioncuentapanotacreditosForeignKey=transaccioncuentapanotacreditoLogic.getTransaccions();
			}

			parametrofactutransaccionReturnGeneral.settransaccioncuentapanotacreditosForeignKey(transaccioncuentapanotacreditosForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return parametrofactutransaccionReturnGeneral;
	}
	
	
	public void deepLoad(ParametroFactuTransaccion parametrofactutransaccion,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			ParametroFactuTransaccionLogicAdditional.updateParametroFactuTransaccionToGet(parametrofactutransaccion,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		parametrofactutransaccion.setEmpresa(parametrofactutransaccionDataAccess.getEmpresa(connexion,parametrofactutransaccion));
		parametrofactutransaccion.setSucursal(parametrofactutransaccionDataAccess.getSucursal(connexion,parametrofactutransaccion));
		parametrofactutransaccion.setTransaccionInvenFactura(parametrofactutransaccionDataAccess.getTransaccionInvenFactura(connexion,parametrofactutransaccion));
		parametrofactutransaccion.setTransaccionInvenNotaCredito(parametrofactutransaccionDataAccess.getTransaccionInvenNotaCredito(connexion,parametrofactutransaccion));
		parametrofactutransaccion.setTransaccionInvenNotaVenta(parametrofactutransaccionDataAccess.getTransaccionInvenNotaVenta(connexion,parametrofactutransaccion));
		parametrofactutransaccion.setTransaccionCuentaCoFactura(parametrofactutransaccionDataAccess.getTransaccionCuentaCoFactura(connexion,parametrofactutransaccion));
		parametrofactutransaccion.setTransaccionCuentaCoNotaCredito(parametrofactutransaccionDataAccess.getTransaccionCuentaCoNotaCredito(connexion,parametrofactutransaccion));
		parametrofactutransaccion.setTransaccionCuentaCoNotaVenta(parametrofactutransaccionDataAccess.getTransaccionCuentaCoNotaVenta(connexion,parametrofactutransaccion));
		parametrofactutransaccion.setTransaccionCuentaCoTarjeta(parametrofactutransaccionDataAccess.getTransaccionCuentaCoTarjeta(connexion,parametrofactutransaccion));
		parametrofactutransaccion.setTransaccionCuentaPaFactura(parametrofactutransaccionDataAccess.getTransaccionCuentaPaFactura(connexion,parametrofactutransaccion));
		parametrofactutransaccion.setTransaccionCuentaPaNotaCredito(parametrofactutransaccionDataAccess.getTransaccionCuentaPaNotaCredito(connexion,parametrofactutransaccion));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				parametrofactutransaccion.setEmpresa(parametrofactutransaccionDataAccess.getEmpresa(connexion,parametrofactutransaccion));
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				parametrofactutransaccion.setSucursal(parametrofactutransaccionDataAccess.getSucursal(connexion,parametrofactutransaccion));
				continue;
			}

			if(clas.clas.equals(Transaccion.class)) {
				parametrofactutransaccion.setTransaccionInvenFactura(parametrofactutransaccionDataAccess.getTransaccionInvenFactura(connexion,parametrofactutransaccion));
				continue;
			}

			if(clas.clas.equals(Transaccion.class)) {
				parametrofactutransaccion.setTransaccionInvenNotaCredito(parametrofactutransaccionDataAccess.getTransaccionInvenNotaCredito(connexion,parametrofactutransaccion));
				continue;
			}

			if(clas.clas.equals(Transaccion.class)) {
				parametrofactutransaccion.setTransaccionInvenNotaVenta(parametrofactutransaccionDataAccess.getTransaccionInvenNotaVenta(connexion,parametrofactutransaccion));
				continue;
			}

			if(clas.clas.equals(Transaccion.class)) {
				parametrofactutransaccion.setTransaccionCuentaCoFactura(parametrofactutransaccionDataAccess.getTransaccionCuentaCoFactura(connexion,parametrofactutransaccion));
				continue;
			}

			if(clas.clas.equals(Transaccion.class)) {
				parametrofactutransaccion.setTransaccionCuentaCoNotaCredito(parametrofactutransaccionDataAccess.getTransaccionCuentaCoNotaCredito(connexion,parametrofactutransaccion));
				continue;
			}

			if(clas.clas.equals(Transaccion.class)) {
				parametrofactutransaccion.setTransaccionCuentaCoNotaVenta(parametrofactutransaccionDataAccess.getTransaccionCuentaCoNotaVenta(connexion,parametrofactutransaccion));
				continue;
			}

			if(clas.clas.equals(Transaccion.class)) {
				parametrofactutransaccion.setTransaccionCuentaCoTarjeta(parametrofactutransaccionDataAccess.getTransaccionCuentaCoTarjeta(connexion,parametrofactutransaccion));
				continue;
			}

			if(clas.clas.equals(Transaccion.class)) {
				parametrofactutransaccion.setTransaccionCuentaPaFactura(parametrofactutransaccionDataAccess.getTransaccionCuentaPaFactura(connexion,parametrofactutransaccion));
				continue;
			}

			if(clas.clas.equals(Transaccion.class)) {
				parametrofactutransaccion.setTransaccionCuentaPaNotaCredito(parametrofactutransaccionDataAccess.getTransaccionCuentaPaNotaCredito(connexion,parametrofactutransaccion));
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
			parametrofactutransaccion.setEmpresa(parametrofactutransaccionDataAccess.getEmpresa(connexion,parametrofactutransaccion));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrofactutransaccion.setSucursal(parametrofactutransaccionDataAccess.getSucursal(connexion,parametrofactutransaccion));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Transaccion.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrofactutransaccion.setTransaccionInvenFactura(parametrofactutransaccionDataAccess.getTransaccionInvenFactura(connexion,parametrofactutransaccion));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Transaccion.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrofactutransaccion.setTransaccionInvenNotaCredito(parametrofactutransaccionDataAccess.getTransaccionInvenNotaCredito(connexion,parametrofactutransaccion));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Transaccion.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrofactutransaccion.setTransaccionInvenNotaVenta(parametrofactutransaccionDataAccess.getTransaccionInvenNotaVenta(connexion,parametrofactutransaccion));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Transaccion.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrofactutransaccion.setTransaccionCuentaCoFactura(parametrofactutransaccionDataAccess.getTransaccionCuentaCoFactura(connexion,parametrofactutransaccion));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Transaccion.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrofactutransaccion.setTransaccionCuentaCoNotaCredito(parametrofactutransaccionDataAccess.getTransaccionCuentaCoNotaCredito(connexion,parametrofactutransaccion));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Transaccion.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrofactutransaccion.setTransaccionCuentaCoNotaVenta(parametrofactutransaccionDataAccess.getTransaccionCuentaCoNotaVenta(connexion,parametrofactutransaccion));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Transaccion.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrofactutransaccion.setTransaccionCuentaCoTarjeta(parametrofactutransaccionDataAccess.getTransaccionCuentaCoTarjeta(connexion,parametrofactutransaccion));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Transaccion.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrofactutransaccion.setTransaccionCuentaPaFactura(parametrofactutransaccionDataAccess.getTransaccionCuentaPaFactura(connexion,parametrofactutransaccion));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Transaccion.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrofactutransaccion.setTransaccionCuentaPaNotaCredito(parametrofactutransaccionDataAccess.getTransaccionCuentaPaNotaCredito(connexion,parametrofactutransaccion));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		parametrofactutransaccion.setEmpresa(parametrofactutransaccionDataAccess.getEmpresa(connexion,parametrofactutransaccion));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(parametrofactutransaccion.getEmpresa(),isDeep,deepLoadType,clases);
				
		parametrofactutransaccion.setSucursal(parametrofactutransaccionDataAccess.getSucursal(connexion,parametrofactutransaccion));
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(parametrofactutransaccion.getSucursal(),isDeep,deepLoadType,clases);
				
		parametrofactutransaccion.setTransaccionInvenFactura(parametrofactutransaccionDataAccess.getTransaccionInvenFactura(connexion,parametrofactutransaccion));
		TransaccionLogic transaccioninvenfacturaLogic= new TransaccionLogic(connexion);
		transaccioninvenfacturaLogic.deepLoad(parametrofactutransaccion.getTransaccionInvenFactura(),isDeep,deepLoadType,clases);
				
		parametrofactutransaccion.setTransaccionInvenNotaCredito(parametrofactutransaccionDataAccess.getTransaccionInvenNotaCredito(connexion,parametrofactutransaccion));
		TransaccionLogic transaccioninvennotacreditoLogic= new TransaccionLogic(connexion);
		transaccioninvennotacreditoLogic.deepLoad(parametrofactutransaccion.getTransaccionInvenNotaCredito(),isDeep,deepLoadType,clases);
				
		parametrofactutransaccion.setTransaccionInvenNotaVenta(parametrofactutransaccionDataAccess.getTransaccionInvenNotaVenta(connexion,parametrofactutransaccion));
		TransaccionLogic transaccioninvennotaventaLogic= new TransaccionLogic(connexion);
		transaccioninvennotaventaLogic.deepLoad(parametrofactutransaccion.getTransaccionInvenNotaVenta(),isDeep,deepLoadType,clases);
				
		parametrofactutransaccion.setTransaccionCuentaCoFactura(parametrofactutransaccionDataAccess.getTransaccionCuentaCoFactura(connexion,parametrofactutransaccion));
		TransaccionLogic transaccioncuentacofacturaLogic= new TransaccionLogic(connexion);
		transaccioncuentacofacturaLogic.deepLoad(parametrofactutransaccion.getTransaccionCuentaCoFactura(),isDeep,deepLoadType,clases);
				
		parametrofactutransaccion.setTransaccionCuentaCoNotaCredito(parametrofactutransaccionDataAccess.getTransaccionCuentaCoNotaCredito(connexion,parametrofactutransaccion));
		TransaccionLogic transaccioncuentaconotacreditoLogic= new TransaccionLogic(connexion);
		transaccioncuentaconotacreditoLogic.deepLoad(parametrofactutransaccion.getTransaccionCuentaCoNotaCredito(),isDeep,deepLoadType,clases);
				
		parametrofactutransaccion.setTransaccionCuentaCoNotaVenta(parametrofactutransaccionDataAccess.getTransaccionCuentaCoNotaVenta(connexion,parametrofactutransaccion));
		TransaccionLogic transaccioncuentaconotaventaLogic= new TransaccionLogic(connexion);
		transaccioncuentaconotaventaLogic.deepLoad(parametrofactutransaccion.getTransaccionCuentaCoNotaVenta(),isDeep,deepLoadType,clases);
				
		parametrofactutransaccion.setTransaccionCuentaCoTarjeta(parametrofactutransaccionDataAccess.getTransaccionCuentaCoTarjeta(connexion,parametrofactutransaccion));
		TransaccionLogic transaccioncuentacotarjetaLogic= new TransaccionLogic(connexion);
		transaccioncuentacotarjetaLogic.deepLoad(parametrofactutransaccion.getTransaccionCuentaCoTarjeta(),isDeep,deepLoadType,clases);
				
		parametrofactutransaccion.setTransaccionCuentaPaFactura(parametrofactutransaccionDataAccess.getTransaccionCuentaPaFactura(connexion,parametrofactutransaccion));
		TransaccionLogic transaccioncuentapafacturaLogic= new TransaccionLogic(connexion);
		transaccioncuentapafacturaLogic.deepLoad(parametrofactutransaccion.getTransaccionCuentaPaFactura(),isDeep,deepLoadType,clases);
				
		parametrofactutransaccion.setTransaccionCuentaPaNotaCredito(parametrofactutransaccionDataAccess.getTransaccionCuentaPaNotaCredito(connexion,parametrofactutransaccion));
		TransaccionLogic transaccioncuentapanotacreditoLogic= new TransaccionLogic(connexion);
		transaccioncuentapanotacreditoLogic.deepLoad(parametrofactutransaccion.getTransaccionCuentaPaNotaCredito(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				parametrofactutransaccion.setEmpresa(parametrofactutransaccionDataAccess.getEmpresa(connexion,parametrofactutransaccion));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(parametrofactutransaccion.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				parametrofactutransaccion.setSucursal(parametrofactutransaccionDataAccess.getSucursal(connexion,parametrofactutransaccion));
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepLoad(parametrofactutransaccion.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Transaccion.class)) {
				parametrofactutransaccion.setTransaccionInvenFactura(parametrofactutransaccionDataAccess.getTransaccionInvenFactura(connexion,parametrofactutransaccion));
				TransaccionLogic transaccionLogic= new TransaccionLogic(connexion);
				transaccionLogic.deepLoad(parametrofactutransaccion.getTransaccionInvenFactura(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Transaccion.class)) {
				parametrofactutransaccion.setTransaccionInvenNotaCredito(parametrofactutransaccionDataAccess.getTransaccionInvenNotaCredito(connexion,parametrofactutransaccion));
				TransaccionLogic transaccionLogic= new TransaccionLogic(connexion);
				transaccionLogic.deepLoad(parametrofactutransaccion.getTransaccionInvenNotaCredito(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Transaccion.class)) {
				parametrofactutransaccion.setTransaccionInvenNotaVenta(parametrofactutransaccionDataAccess.getTransaccionInvenNotaVenta(connexion,parametrofactutransaccion));
				TransaccionLogic transaccionLogic= new TransaccionLogic(connexion);
				transaccionLogic.deepLoad(parametrofactutransaccion.getTransaccionInvenNotaVenta(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Transaccion.class)) {
				parametrofactutransaccion.setTransaccionCuentaCoFactura(parametrofactutransaccionDataAccess.getTransaccionCuentaCoFactura(connexion,parametrofactutransaccion));
				TransaccionLogic transaccionLogic= new TransaccionLogic(connexion);
				transaccionLogic.deepLoad(parametrofactutransaccion.getTransaccionCuentaCoFactura(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Transaccion.class)) {
				parametrofactutransaccion.setTransaccionCuentaCoNotaCredito(parametrofactutransaccionDataAccess.getTransaccionCuentaCoNotaCredito(connexion,parametrofactutransaccion));
				TransaccionLogic transaccionLogic= new TransaccionLogic(connexion);
				transaccionLogic.deepLoad(parametrofactutransaccion.getTransaccionCuentaCoNotaCredito(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Transaccion.class)) {
				parametrofactutransaccion.setTransaccionCuentaCoNotaVenta(parametrofactutransaccionDataAccess.getTransaccionCuentaCoNotaVenta(connexion,parametrofactutransaccion));
				TransaccionLogic transaccionLogic= new TransaccionLogic(connexion);
				transaccionLogic.deepLoad(parametrofactutransaccion.getTransaccionCuentaCoNotaVenta(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Transaccion.class)) {
				parametrofactutransaccion.setTransaccionCuentaCoTarjeta(parametrofactutransaccionDataAccess.getTransaccionCuentaCoTarjeta(connexion,parametrofactutransaccion));
				TransaccionLogic transaccionLogic= new TransaccionLogic(connexion);
				transaccionLogic.deepLoad(parametrofactutransaccion.getTransaccionCuentaCoTarjeta(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Transaccion.class)) {
				parametrofactutransaccion.setTransaccionCuentaPaFactura(parametrofactutransaccionDataAccess.getTransaccionCuentaPaFactura(connexion,parametrofactutransaccion));
				TransaccionLogic transaccionLogic= new TransaccionLogic(connexion);
				transaccionLogic.deepLoad(parametrofactutransaccion.getTransaccionCuentaPaFactura(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Transaccion.class)) {
				parametrofactutransaccion.setTransaccionCuentaPaNotaCredito(parametrofactutransaccionDataAccess.getTransaccionCuentaPaNotaCredito(connexion,parametrofactutransaccion));
				TransaccionLogic transaccionLogic= new TransaccionLogic(connexion);
				transaccionLogic.deepLoad(parametrofactutransaccion.getTransaccionCuentaPaNotaCredito(),isDeep,deepLoadType,clases);				
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
			parametrofactutransaccion.setEmpresa(parametrofactutransaccionDataAccess.getEmpresa(connexion,parametrofactutransaccion));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(parametrofactutransaccion.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrofactutransaccion.setSucursal(parametrofactutransaccionDataAccess.getSucursal(connexion,parametrofactutransaccion));
			SucursalLogic sucursalLogic= new SucursalLogic(connexion);
			sucursalLogic.deepLoad(parametrofactutransaccion.getSucursal(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Transaccion.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrofactutransaccion.setTransaccionInvenFactura(parametrofactutransaccionDataAccess.getTransaccionInvenFactura(connexion,parametrofactutransaccion));
			TransaccionLogic transaccionLogic= new TransaccionLogic(connexion);
			transaccionLogic.deepLoad(parametrofactutransaccion.getTransaccionInvenFactura(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Transaccion.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrofactutransaccion.setTransaccionInvenNotaCredito(parametrofactutransaccionDataAccess.getTransaccionInvenNotaCredito(connexion,parametrofactutransaccion));
			TransaccionLogic transaccionLogic= new TransaccionLogic(connexion);
			transaccionLogic.deepLoad(parametrofactutransaccion.getTransaccionInvenNotaCredito(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Transaccion.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrofactutransaccion.setTransaccionInvenNotaVenta(parametrofactutransaccionDataAccess.getTransaccionInvenNotaVenta(connexion,parametrofactutransaccion));
			TransaccionLogic transaccionLogic= new TransaccionLogic(connexion);
			transaccionLogic.deepLoad(parametrofactutransaccion.getTransaccionInvenNotaVenta(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Transaccion.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrofactutransaccion.setTransaccionCuentaCoFactura(parametrofactutransaccionDataAccess.getTransaccionCuentaCoFactura(connexion,parametrofactutransaccion));
			TransaccionLogic transaccionLogic= new TransaccionLogic(connexion);
			transaccionLogic.deepLoad(parametrofactutransaccion.getTransaccionCuentaCoFactura(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Transaccion.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrofactutransaccion.setTransaccionCuentaCoNotaCredito(parametrofactutransaccionDataAccess.getTransaccionCuentaCoNotaCredito(connexion,parametrofactutransaccion));
			TransaccionLogic transaccionLogic= new TransaccionLogic(connexion);
			transaccionLogic.deepLoad(parametrofactutransaccion.getTransaccionCuentaCoNotaCredito(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Transaccion.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrofactutransaccion.setTransaccionCuentaCoNotaVenta(parametrofactutransaccionDataAccess.getTransaccionCuentaCoNotaVenta(connexion,parametrofactutransaccion));
			TransaccionLogic transaccionLogic= new TransaccionLogic(connexion);
			transaccionLogic.deepLoad(parametrofactutransaccion.getTransaccionCuentaCoNotaVenta(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Transaccion.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrofactutransaccion.setTransaccionCuentaCoTarjeta(parametrofactutransaccionDataAccess.getTransaccionCuentaCoTarjeta(connexion,parametrofactutransaccion));
			TransaccionLogic transaccionLogic= new TransaccionLogic(connexion);
			transaccionLogic.deepLoad(parametrofactutransaccion.getTransaccionCuentaCoTarjeta(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Transaccion.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrofactutransaccion.setTransaccionCuentaPaFactura(parametrofactutransaccionDataAccess.getTransaccionCuentaPaFactura(connexion,parametrofactutransaccion));
			TransaccionLogic transaccionLogic= new TransaccionLogic(connexion);
			transaccionLogic.deepLoad(parametrofactutransaccion.getTransaccionCuentaPaFactura(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Transaccion.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrofactutransaccion.setTransaccionCuentaPaNotaCredito(parametrofactutransaccionDataAccess.getTransaccionCuentaPaNotaCredito(connexion,parametrofactutransaccion));
			TransaccionLogic transaccionLogic= new TransaccionLogic(connexion);
			transaccionLogic.deepLoad(parametrofactutransaccion.getTransaccionCuentaPaNotaCredito(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(ParametroFactuTransaccion parametrofactutransaccion,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			ParametroFactuTransaccionLogicAdditional.updateParametroFactuTransaccionToSave(parametrofactutransaccion,this.arrDatoGeneral);
			
ParametroFactuTransaccionDataAccess.save(parametrofactutransaccion, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(parametrofactutransaccion.getEmpresa(),connexion);

		SucursalDataAccess.save(parametrofactutransaccion.getSucursal(),connexion);

		TransaccionDataAccess.save(parametrofactutransaccion.getTransaccionInvenFactura(),connexion);

		TransaccionDataAccess.save(parametrofactutransaccion.getTransaccionInvenNotaCredito(),connexion);

		TransaccionDataAccess.save(parametrofactutransaccion.getTransaccionInvenNotaVenta(),connexion);

		TransaccionDataAccess.save(parametrofactutransaccion.getTransaccionCuentaCoFactura(),connexion);

		TransaccionDataAccess.save(parametrofactutransaccion.getTransaccionCuentaCoNotaCredito(),connexion);

		TransaccionDataAccess.save(parametrofactutransaccion.getTransaccionCuentaCoNotaVenta(),connexion);

		TransaccionDataAccess.save(parametrofactutransaccion.getTransaccionCuentaCoTarjeta(),connexion);

		TransaccionDataAccess.save(parametrofactutransaccion.getTransaccionCuentaPaFactura(),connexion);

		TransaccionDataAccess.save(parametrofactutransaccion.getTransaccionCuentaPaNotaCredito(),connexion);
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(parametrofactutransaccion.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(parametrofactutransaccion.getSucursal(),connexion);
				continue;
			}

			if(clas.clas.equals(Transaccion.class)) {
				TransaccionDataAccess.save(parametrofactutransaccion.getTransaccionInvenFactura(),connexion);
				continue;
			}

			if(clas.clas.equals(Transaccion.class)) {
				TransaccionDataAccess.save(parametrofactutransaccion.getTransaccionInvenNotaCredito(),connexion);
				continue;
			}

			if(clas.clas.equals(Transaccion.class)) {
				TransaccionDataAccess.save(parametrofactutransaccion.getTransaccionInvenNotaVenta(),connexion);
				continue;
			}

			if(clas.clas.equals(Transaccion.class)) {
				TransaccionDataAccess.save(parametrofactutransaccion.getTransaccionCuentaCoFactura(),connexion);
				continue;
			}

			if(clas.clas.equals(Transaccion.class)) {
				TransaccionDataAccess.save(parametrofactutransaccion.getTransaccionCuentaCoNotaCredito(),connexion);
				continue;
			}

			if(clas.clas.equals(Transaccion.class)) {
				TransaccionDataAccess.save(parametrofactutransaccion.getTransaccionCuentaCoNotaVenta(),connexion);
				continue;
			}

			if(clas.clas.equals(Transaccion.class)) {
				TransaccionDataAccess.save(parametrofactutransaccion.getTransaccionCuentaCoTarjeta(),connexion);
				continue;
			}

			if(clas.clas.equals(Transaccion.class)) {
				TransaccionDataAccess.save(parametrofactutransaccion.getTransaccionCuentaPaFactura(),connexion);
				continue;
			}

			if(clas.clas.equals(Transaccion.class)) {
				TransaccionDataAccess.save(parametrofactutransaccion.getTransaccionCuentaPaNotaCredito(),connexion);
				continue;
			}

		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(parametrofactutransaccion.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(parametrofactutransaccion.getEmpresa(),isDeep,deepLoadType,clases);
				

		SucursalDataAccess.save(parametrofactutransaccion.getSucursal(),connexion);
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(parametrofactutransaccion.getSucursal(),isDeep,deepLoadType,clases);
				

		TransaccionDataAccess.save(parametrofactutransaccion.getTransaccionInvenFactura(),connexion);
		TransaccionLogic transaccioninvenfacturaLogic= new TransaccionLogic(connexion);
		transaccioninvenfacturaLogic.deepLoad(parametrofactutransaccion.getTransaccionInvenFactura(),isDeep,deepLoadType,clases);
				

		TransaccionDataAccess.save(parametrofactutransaccion.getTransaccionInvenNotaCredito(),connexion);
		TransaccionLogic transaccioninvennotacreditoLogic= new TransaccionLogic(connexion);
		transaccioninvennotacreditoLogic.deepLoad(parametrofactutransaccion.getTransaccionInvenNotaCredito(),isDeep,deepLoadType,clases);
				

		TransaccionDataAccess.save(parametrofactutransaccion.getTransaccionInvenNotaVenta(),connexion);
		TransaccionLogic transaccioninvennotaventaLogic= new TransaccionLogic(connexion);
		transaccioninvennotaventaLogic.deepLoad(parametrofactutransaccion.getTransaccionInvenNotaVenta(),isDeep,deepLoadType,clases);
				

		TransaccionDataAccess.save(parametrofactutransaccion.getTransaccionCuentaCoFactura(),connexion);
		TransaccionLogic transaccioncuentacofacturaLogic= new TransaccionLogic(connexion);
		transaccioncuentacofacturaLogic.deepLoad(parametrofactutransaccion.getTransaccionCuentaCoFactura(),isDeep,deepLoadType,clases);
				

		TransaccionDataAccess.save(parametrofactutransaccion.getTransaccionCuentaCoNotaCredito(),connexion);
		TransaccionLogic transaccioncuentaconotacreditoLogic= new TransaccionLogic(connexion);
		transaccioncuentaconotacreditoLogic.deepLoad(parametrofactutransaccion.getTransaccionCuentaCoNotaCredito(),isDeep,deepLoadType,clases);
				

		TransaccionDataAccess.save(parametrofactutransaccion.getTransaccionCuentaCoNotaVenta(),connexion);
		TransaccionLogic transaccioncuentaconotaventaLogic= new TransaccionLogic(connexion);
		transaccioncuentaconotaventaLogic.deepLoad(parametrofactutransaccion.getTransaccionCuentaCoNotaVenta(),isDeep,deepLoadType,clases);
				

		TransaccionDataAccess.save(parametrofactutransaccion.getTransaccionCuentaCoTarjeta(),connexion);
		TransaccionLogic transaccioncuentacotarjetaLogic= new TransaccionLogic(connexion);
		transaccioncuentacotarjetaLogic.deepLoad(parametrofactutransaccion.getTransaccionCuentaCoTarjeta(),isDeep,deepLoadType,clases);
				

		TransaccionDataAccess.save(parametrofactutransaccion.getTransaccionCuentaPaFactura(),connexion);
		TransaccionLogic transaccioncuentapafacturaLogic= new TransaccionLogic(connexion);
		transaccioncuentapafacturaLogic.deepLoad(parametrofactutransaccion.getTransaccionCuentaPaFactura(),isDeep,deepLoadType,clases);
				

		TransaccionDataAccess.save(parametrofactutransaccion.getTransaccionCuentaPaNotaCredito(),connexion);
		TransaccionLogic transaccioncuentapanotacreditoLogic= new TransaccionLogic(connexion);
		transaccioncuentapanotacreditoLogic.deepLoad(parametrofactutransaccion.getTransaccionCuentaPaNotaCredito(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(parametrofactutransaccion.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(parametrofactutransaccion.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(parametrofactutransaccion.getSucursal(),connexion);
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepSave(parametrofactutransaccion.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Transaccion.class)) {
				TransaccionDataAccess.save(parametrofactutransaccion.getTransaccionInvenFactura(),connexion);
				TransaccionLogic transaccionLogic= new TransaccionLogic(connexion);
				transaccionLogic.deepSave(parametrofactutransaccion.getTransaccionInvenFactura(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Transaccion.class)) {
				TransaccionDataAccess.save(parametrofactutransaccion.getTransaccionInvenNotaCredito(),connexion);
				TransaccionLogic transaccionLogic= new TransaccionLogic(connexion);
				transaccionLogic.deepSave(parametrofactutransaccion.getTransaccionInvenNotaCredito(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Transaccion.class)) {
				TransaccionDataAccess.save(parametrofactutransaccion.getTransaccionInvenNotaVenta(),connexion);
				TransaccionLogic transaccionLogic= new TransaccionLogic(connexion);
				transaccionLogic.deepSave(parametrofactutransaccion.getTransaccionInvenNotaVenta(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Transaccion.class)) {
				TransaccionDataAccess.save(parametrofactutransaccion.getTransaccionCuentaCoFactura(),connexion);
				TransaccionLogic transaccionLogic= new TransaccionLogic(connexion);
				transaccionLogic.deepSave(parametrofactutransaccion.getTransaccionCuentaCoFactura(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Transaccion.class)) {
				TransaccionDataAccess.save(parametrofactutransaccion.getTransaccionCuentaCoNotaCredito(),connexion);
				TransaccionLogic transaccionLogic= new TransaccionLogic(connexion);
				transaccionLogic.deepSave(parametrofactutransaccion.getTransaccionCuentaCoNotaCredito(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Transaccion.class)) {
				TransaccionDataAccess.save(parametrofactutransaccion.getTransaccionCuentaCoNotaVenta(),connexion);
				TransaccionLogic transaccionLogic= new TransaccionLogic(connexion);
				transaccionLogic.deepSave(parametrofactutransaccion.getTransaccionCuentaCoNotaVenta(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Transaccion.class)) {
				TransaccionDataAccess.save(parametrofactutransaccion.getTransaccionCuentaCoTarjeta(),connexion);
				TransaccionLogic transaccionLogic= new TransaccionLogic(connexion);
				transaccionLogic.deepSave(parametrofactutransaccion.getTransaccionCuentaCoTarjeta(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Transaccion.class)) {
				TransaccionDataAccess.save(parametrofactutransaccion.getTransaccionCuentaPaFactura(),connexion);
				TransaccionLogic transaccionLogic= new TransaccionLogic(connexion);
				transaccionLogic.deepSave(parametrofactutransaccion.getTransaccionCuentaPaFactura(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Transaccion.class)) {
				TransaccionDataAccess.save(parametrofactutransaccion.getTransaccionCuentaPaNotaCredito(),connexion);
				TransaccionLogic transaccionLogic= new TransaccionLogic(connexion);
				transaccionLogic.deepSave(parametrofactutransaccion.getTransaccionCuentaPaNotaCredito(),isDeep,deepLoadType,clases);				
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
			this.getNewConnexionToDeep(ParametroFactuTransaccion.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(parametrofactutransaccion,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				ParametroFactuTransaccionConstantesFunciones.refrescarForeignKeysDescripcionesParametroFactuTransaccion(parametrofactutransaccion);
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
			this.deepLoad(this.parametrofactutransaccion,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				ParametroFactuTransaccionConstantesFunciones.refrescarForeignKeysDescripcionesParametroFactuTransaccion(this.parametrofactutransaccion);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(ParametroFactuTransaccion.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(parametrofactutransaccions!=null) {
				for(ParametroFactuTransaccion parametrofactutransaccion:parametrofactutransaccions) {
					this.deepLoad(parametrofactutransaccion,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					ParametroFactuTransaccionConstantesFunciones.refrescarForeignKeysDescripcionesParametroFactuTransaccion(parametrofactutransaccions);
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
			if(parametrofactutransaccions!=null) {
				for(ParametroFactuTransaccion parametrofactutransaccion:parametrofactutransaccions) {
					this.deepLoad(parametrofactutransaccion,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					ParametroFactuTransaccionConstantesFunciones.refrescarForeignKeysDescripcionesParametroFactuTransaccion(parametrofactutransaccions);
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
			this.getNewConnexionToDeep(ParametroFactuTransaccion.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(parametrofactutransaccion,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(ParametroFactuTransaccion.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(parametrofactutransaccions!=null) {
				for(ParametroFactuTransaccion parametrofactutransaccion:parametrofactutransaccions) {
					this.deepSave(parametrofactutransaccion,isDeep,deepLoadType,clases);
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
			if(parametrofactutransaccions!=null) {
				for(ParametroFactuTransaccion parametrofactutransaccion:parametrofactutransaccions) {
					this.deepSave(parametrofactutransaccion,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getParametroFactuTransaccionsFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroFactuTransaccion.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,ParametroFactuTransaccionConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			ParametroFactuTransaccionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrofactutransaccions=parametrofactutransaccionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroFactuTransaccionConstantesFunciones.refrescarForeignKeysDescripcionesParametroFactuTransaccion(this.parametrofactutransaccions);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getParametroFactuTransaccionsFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,ParametroFactuTransaccionConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			ParametroFactuTransaccionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrofactutransaccions=parametrofactutransaccionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroFactuTransaccionConstantesFunciones.refrescarForeignKeysDescripcionesParametroFactuTransaccion(this.parametrofactutransaccions);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getParametroFactuTransaccionsFK_IdSucursalWithConnection(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroFactuTransaccion.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,ParametroFactuTransaccionConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			ParametroFactuTransaccionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrofactutransaccions=parametrofactutransaccionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroFactuTransaccionConstantesFunciones.refrescarForeignKeysDescripcionesParametroFactuTransaccion(this.parametrofactutransaccions);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getParametroFactuTransaccionsFK_IdSucursal(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,ParametroFactuTransaccionConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			ParametroFactuTransaccionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrofactutransaccions=parametrofactutransaccionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroFactuTransaccionConstantesFunciones.refrescarForeignKeysDescripcionesParametroFactuTransaccion(this.parametrofactutransaccions);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getParametroFactuTransaccionsFK_IdTransaccionCuentaCoFacturaWithConnection(String sFinalQuery,Pagination pagination,Long id_transaccion_cuenta_co_factura)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroFactuTransaccion.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTransaccionCuentaCoFactura= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTransaccionCuentaCoFactura.setParameterSelectionGeneralEqual(ParameterType.LONG,id_transaccion_cuenta_co_factura,ParametroFactuTransaccionConstantesFunciones.IDTRANSACCIONCUENTACOFACTURA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTransaccionCuentaCoFactura);

			ParametroFactuTransaccionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTransaccionCuentaCoFactura","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrofactutransaccions=parametrofactutransaccionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroFactuTransaccionConstantesFunciones.refrescarForeignKeysDescripcionesParametroFactuTransaccion(this.parametrofactutransaccions);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getParametroFactuTransaccionsFK_IdTransaccionCuentaCoFactura(String sFinalQuery,Pagination pagination,Long id_transaccion_cuenta_co_factura)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTransaccionCuentaCoFactura= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTransaccionCuentaCoFactura.setParameterSelectionGeneralEqual(ParameterType.LONG,id_transaccion_cuenta_co_factura,ParametroFactuTransaccionConstantesFunciones.IDTRANSACCIONCUENTACOFACTURA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTransaccionCuentaCoFactura);

			ParametroFactuTransaccionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTransaccionCuentaCoFactura","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrofactutransaccions=parametrofactutransaccionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroFactuTransaccionConstantesFunciones.refrescarForeignKeysDescripcionesParametroFactuTransaccion(this.parametrofactutransaccions);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getParametroFactuTransaccionsFK_IdTransaccionCuentaCoNotaCreditoWithConnection(String sFinalQuery,Pagination pagination,Long id_transaccion_cuenta_co_nota_credito)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroFactuTransaccion.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTransaccionCuentaCoNotaCredito= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTransaccionCuentaCoNotaCredito.setParameterSelectionGeneralEqual(ParameterType.LONG,id_transaccion_cuenta_co_nota_credito,ParametroFactuTransaccionConstantesFunciones.IDTRANSACCIONCUENTACONOTACREDITO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTransaccionCuentaCoNotaCredito);

			ParametroFactuTransaccionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTransaccionCuentaCoNotaCredito","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrofactutransaccions=parametrofactutransaccionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroFactuTransaccionConstantesFunciones.refrescarForeignKeysDescripcionesParametroFactuTransaccion(this.parametrofactutransaccions);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getParametroFactuTransaccionsFK_IdTransaccionCuentaCoNotaCredito(String sFinalQuery,Pagination pagination,Long id_transaccion_cuenta_co_nota_credito)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTransaccionCuentaCoNotaCredito= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTransaccionCuentaCoNotaCredito.setParameterSelectionGeneralEqual(ParameterType.LONG,id_transaccion_cuenta_co_nota_credito,ParametroFactuTransaccionConstantesFunciones.IDTRANSACCIONCUENTACONOTACREDITO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTransaccionCuentaCoNotaCredito);

			ParametroFactuTransaccionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTransaccionCuentaCoNotaCredito","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrofactutransaccions=parametrofactutransaccionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroFactuTransaccionConstantesFunciones.refrescarForeignKeysDescripcionesParametroFactuTransaccion(this.parametrofactutransaccions);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getParametroFactuTransaccionsFK_IdTransaccionCuentaCoNotaVentaWithConnection(String sFinalQuery,Pagination pagination,Long id_transaccion_cuenta_co_nota_venta)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroFactuTransaccion.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTransaccionCuentaCoNotaVenta= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTransaccionCuentaCoNotaVenta.setParameterSelectionGeneralEqual(ParameterType.LONG,id_transaccion_cuenta_co_nota_venta,ParametroFactuTransaccionConstantesFunciones.IDTRANSACCIONCUENTACONOTAVENTA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTransaccionCuentaCoNotaVenta);

			ParametroFactuTransaccionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTransaccionCuentaCoNotaVenta","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrofactutransaccions=parametrofactutransaccionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroFactuTransaccionConstantesFunciones.refrescarForeignKeysDescripcionesParametroFactuTransaccion(this.parametrofactutransaccions);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getParametroFactuTransaccionsFK_IdTransaccionCuentaCoNotaVenta(String sFinalQuery,Pagination pagination,Long id_transaccion_cuenta_co_nota_venta)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTransaccionCuentaCoNotaVenta= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTransaccionCuentaCoNotaVenta.setParameterSelectionGeneralEqual(ParameterType.LONG,id_transaccion_cuenta_co_nota_venta,ParametroFactuTransaccionConstantesFunciones.IDTRANSACCIONCUENTACONOTAVENTA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTransaccionCuentaCoNotaVenta);

			ParametroFactuTransaccionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTransaccionCuentaCoNotaVenta","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrofactutransaccions=parametrofactutransaccionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroFactuTransaccionConstantesFunciones.refrescarForeignKeysDescripcionesParametroFactuTransaccion(this.parametrofactutransaccions);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getParametroFactuTransaccionsFK_IdTransaccionCuentaCoTarjetaWithConnection(String sFinalQuery,Pagination pagination,Long id_transaccion_cuenta_co_tarjeta)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroFactuTransaccion.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTransaccionCuentaCoTarjeta= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTransaccionCuentaCoTarjeta.setParameterSelectionGeneralEqual(ParameterType.LONG,id_transaccion_cuenta_co_tarjeta,ParametroFactuTransaccionConstantesFunciones.IDTRANSACCIONCUENTACOTARJETA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTransaccionCuentaCoTarjeta);

			ParametroFactuTransaccionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTransaccionCuentaCoTarjeta","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrofactutransaccions=parametrofactutransaccionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroFactuTransaccionConstantesFunciones.refrescarForeignKeysDescripcionesParametroFactuTransaccion(this.parametrofactutransaccions);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getParametroFactuTransaccionsFK_IdTransaccionCuentaCoTarjeta(String sFinalQuery,Pagination pagination,Long id_transaccion_cuenta_co_tarjeta)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTransaccionCuentaCoTarjeta= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTransaccionCuentaCoTarjeta.setParameterSelectionGeneralEqual(ParameterType.LONG,id_transaccion_cuenta_co_tarjeta,ParametroFactuTransaccionConstantesFunciones.IDTRANSACCIONCUENTACOTARJETA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTransaccionCuentaCoTarjeta);

			ParametroFactuTransaccionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTransaccionCuentaCoTarjeta","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrofactutransaccions=parametrofactutransaccionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroFactuTransaccionConstantesFunciones.refrescarForeignKeysDescripcionesParametroFactuTransaccion(this.parametrofactutransaccions);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getParametroFactuTransaccionsFK_IdTransaccionCuentaPaFacturaWithConnection(String sFinalQuery,Pagination pagination,Long id_transaccion_cuenta_pa_factura)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroFactuTransaccion.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTransaccionCuentaPaFactura= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTransaccionCuentaPaFactura.setParameterSelectionGeneralEqual(ParameterType.LONG,id_transaccion_cuenta_pa_factura,ParametroFactuTransaccionConstantesFunciones.IDTRANSACCIONCUENTAPAFACTURA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTransaccionCuentaPaFactura);

			ParametroFactuTransaccionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTransaccionCuentaPaFactura","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrofactutransaccions=parametrofactutransaccionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroFactuTransaccionConstantesFunciones.refrescarForeignKeysDescripcionesParametroFactuTransaccion(this.parametrofactutransaccions);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getParametroFactuTransaccionsFK_IdTransaccionCuentaPaFactura(String sFinalQuery,Pagination pagination,Long id_transaccion_cuenta_pa_factura)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTransaccionCuentaPaFactura= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTransaccionCuentaPaFactura.setParameterSelectionGeneralEqual(ParameterType.LONG,id_transaccion_cuenta_pa_factura,ParametroFactuTransaccionConstantesFunciones.IDTRANSACCIONCUENTAPAFACTURA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTransaccionCuentaPaFactura);

			ParametroFactuTransaccionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTransaccionCuentaPaFactura","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrofactutransaccions=parametrofactutransaccionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroFactuTransaccionConstantesFunciones.refrescarForeignKeysDescripcionesParametroFactuTransaccion(this.parametrofactutransaccions);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getParametroFactuTransaccionsFK_IdTransaccionCuentaPaNotaCreditoWithConnection(String sFinalQuery,Pagination pagination,Long id_transaccion_cuenta_pa_nota_credito)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroFactuTransaccion.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTransaccionCuentaPaNotaCredito= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTransaccionCuentaPaNotaCredito.setParameterSelectionGeneralEqual(ParameterType.LONG,id_transaccion_cuenta_pa_nota_credito,ParametroFactuTransaccionConstantesFunciones.IDTRANSACCIONCUENTAPANOTACREDITO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTransaccionCuentaPaNotaCredito);

			ParametroFactuTransaccionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTransaccionCuentaPaNotaCredito","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrofactutransaccions=parametrofactutransaccionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroFactuTransaccionConstantesFunciones.refrescarForeignKeysDescripcionesParametroFactuTransaccion(this.parametrofactutransaccions);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getParametroFactuTransaccionsFK_IdTransaccionCuentaPaNotaCredito(String sFinalQuery,Pagination pagination,Long id_transaccion_cuenta_pa_nota_credito)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTransaccionCuentaPaNotaCredito= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTransaccionCuentaPaNotaCredito.setParameterSelectionGeneralEqual(ParameterType.LONG,id_transaccion_cuenta_pa_nota_credito,ParametroFactuTransaccionConstantesFunciones.IDTRANSACCIONCUENTAPANOTACREDITO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTransaccionCuentaPaNotaCredito);

			ParametroFactuTransaccionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTransaccionCuentaPaNotaCredito","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrofactutransaccions=parametrofactutransaccionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroFactuTransaccionConstantesFunciones.refrescarForeignKeysDescripcionesParametroFactuTransaccion(this.parametrofactutransaccions);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getParametroFactuTransaccionsFK_IdTransaccionInvenFacturaWithConnection(String sFinalQuery,Pagination pagination,Long id_transaccion_inven_factura)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroFactuTransaccion.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTransaccionInvenFactura= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTransaccionInvenFactura.setParameterSelectionGeneralEqual(ParameterType.LONG,id_transaccion_inven_factura,ParametroFactuTransaccionConstantesFunciones.IDTRANSACCIONINVENFACTURA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTransaccionInvenFactura);

			ParametroFactuTransaccionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTransaccionInvenFactura","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrofactutransaccions=parametrofactutransaccionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroFactuTransaccionConstantesFunciones.refrescarForeignKeysDescripcionesParametroFactuTransaccion(this.parametrofactutransaccions);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getParametroFactuTransaccionsFK_IdTransaccionInvenFactura(String sFinalQuery,Pagination pagination,Long id_transaccion_inven_factura)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTransaccionInvenFactura= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTransaccionInvenFactura.setParameterSelectionGeneralEqual(ParameterType.LONG,id_transaccion_inven_factura,ParametroFactuTransaccionConstantesFunciones.IDTRANSACCIONINVENFACTURA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTransaccionInvenFactura);

			ParametroFactuTransaccionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTransaccionInvenFactura","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrofactutransaccions=parametrofactutransaccionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroFactuTransaccionConstantesFunciones.refrescarForeignKeysDescripcionesParametroFactuTransaccion(this.parametrofactutransaccions);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getParametroFactuTransaccionsFK_IdTransaccionInvenNotaCreditoWithConnection(String sFinalQuery,Pagination pagination,Long id_transaccion_inven_nota_credito)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroFactuTransaccion.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTransaccionInvenNotaCredito= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTransaccionInvenNotaCredito.setParameterSelectionGeneralEqual(ParameterType.LONG,id_transaccion_inven_nota_credito,ParametroFactuTransaccionConstantesFunciones.IDTRANSACCIONINVENNOTACREDITO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTransaccionInvenNotaCredito);

			ParametroFactuTransaccionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTransaccionInvenNotaCredito","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrofactutransaccions=parametrofactutransaccionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroFactuTransaccionConstantesFunciones.refrescarForeignKeysDescripcionesParametroFactuTransaccion(this.parametrofactutransaccions);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getParametroFactuTransaccionsFK_IdTransaccionInvenNotaCredito(String sFinalQuery,Pagination pagination,Long id_transaccion_inven_nota_credito)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTransaccionInvenNotaCredito= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTransaccionInvenNotaCredito.setParameterSelectionGeneralEqual(ParameterType.LONG,id_transaccion_inven_nota_credito,ParametroFactuTransaccionConstantesFunciones.IDTRANSACCIONINVENNOTACREDITO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTransaccionInvenNotaCredito);

			ParametroFactuTransaccionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTransaccionInvenNotaCredito","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrofactutransaccions=parametrofactutransaccionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroFactuTransaccionConstantesFunciones.refrescarForeignKeysDescripcionesParametroFactuTransaccion(this.parametrofactutransaccions);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getParametroFactuTransaccionsFK_IdTransaccionInvenNotaVentaWithConnection(String sFinalQuery,Pagination pagination,Long id_transaccion_inven_nota_venta)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroFactuTransaccion.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTransaccionInvenNotaVenta= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTransaccionInvenNotaVenta.setParameterSelectionGeneralEqual(ParameterType.LONG,id_transaccion_inven_nota_venta,ParametroFactuTransaccionConstantesFunciones.IDTRANSACCIONINVENNOTAVENTA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTransaccionInvenNotaVenta);

			ParametroFactuTransaccionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTransaccionInvenNotaVenta","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrofactutransaccions=parametrofactutransaccionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroFactuTransaccionConstantesFunciones.refrescarForeignKeysDescripcionesParametroFactuTransaccion(this.parametrofactutransaccions);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getParametroFactuTransaccionsFK_IdTransaccionInvenNotaVenta(String sFinalQuery,Pagination pagination,Long id_transaccion_inven_nota_venta)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTransaccionInvenNotaVenta= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTransaccionInvenNotaVenta.setParameterSelectionGeneralEqual(ParameterType.LONG,id_transaccion_inven_nota_venta,ParametroFactuTransaccionConstantesFunciones.IDTRANSACCIONINVENNOTAVENTA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTransaccionInvenNotaVenta);

			ParametroFactuTransaccionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTransaccionInvenNotaVenta","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrofactutransaccions=parametrofactutransaccionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroFactuTransaccionConstantesFunciones.refrescarForeignKeysDescripcionesParametroFactuTransaccion(this.parametrofactutransaccions);
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
			if(ParametroFactuTransaccionConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,ParametroFactuTransaccionDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,ParametroFactuTransaccion parametrofactutransaccion,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(ParametroFactuTransaccionConstantesFunciones.ISCONAUDITORIA) {
				if(parametrofactutransaccion.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,ParametroFactuTransaccionDataAccess.TABLENAME, parametrofactutransaccion.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(ParametroFactuTransaccionConstantesFunciones.ISCONAUDITORIADETALLE) {
						////ParametroFactuTransaccionLogic.registrarAuditoriaDetallesParametroFactuTransaccion(connexion,parametrofactutransaccion,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(parametrofactutransaccion.getIsDeleted()) {
					/*if(!parametrofactutransaccion.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,ParametroFactuTransaccionDataAccess.TABLENAME, parametrofactutransaccion.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////ParametroFactuTransaccionLogic.registrarAuditoriaDetallesParametroFactuTransaccion(connexion,parametrofactutransaccion,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,ParametroFactuTransaccionDataAccess.TABLENAME, parametrofactutransaccion.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(parametrofactutransaccion.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,ParametroFactuTransaccionDataAccess.TABLENAME, parametrofactutransaccion.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(ParametroFactuTransaccionConstantesFunciones.ISCONAUDITORIADETALLE) {
						////ParametroFactuTransaccionLogic.registrarAuditoriaDetallesParametroFactuTransaccion(connexion,parametrofactutransaccion,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesParametroFactuTransaccion(Connexion connexion,ParametroFactuTransaccion parametrofactutransaccion)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(parametrofactutransaccion.getIsNew()||!parametrofactutransaccion.getid_empresa().equals(parametrofactutransaccion.getParametroFactuTransaccionOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametrofactutransaccion.getParametroFactuTransaccionOriginal().getid_empresa()!=null)
				{
					strValorActual=parametrofactutransaccion.getParametroFactuTransaccionOriginal().getid_empresa().toString();
				}
				if(parametrofactutransaccion.getid_empresa()!=null)
				{
					strValorNuevo=parametrofactutransaccion.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroFactuTransaccionConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(parametrofactutransaccion.getIsNew()||!parametrofactutransaccion.getid_sucursal().equals(parametrofactutransaccion.getParametroFactuTransaccionOriginal().getid_sucursal()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametrofactutransaccion.getParametroFactuTransaccionOriginal().getid_sucursal()!=null)
				{
					strValorActual=parametrofactutransaccion.getParametroFactuTransaccionOriginal().getid_sucursal().toString();
				}
				if(parametrofactutransaccion.getid_sucursal()!=null)
				{
					strValorNuevo=parametrofactutransaccion.getid_sucursal().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroFactuTransaccionConstantesFunciones.IDSUCURSAL,strValorActual,strValorNuevo);
			}	
			
			if(parametrofactutransaccion.getIsNew()||!parametrofactutransaccion.getid_transaccion_inven_factura().equals(parametrofactutransaccion.getParametroFactuTransaccionOriginal().getid_transaccion_inven_factura()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametrofactutransaccion.getParametroFactuTransaccionOriginal().getid_transaccion_inven_factura()!=null)
				{
					strValorActual=parametrofactutransaccion.getParametroFactuTransaccionOriginal().getid_transaccion_inven_factura().toString();
				}
				if(parametrofactutransaccion.getid_transaccion_inven_factura()!=null)
				{
					strValorNuevo=parametrofactutransaccion.getid_transaccion_inven_factura().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroFactuTransaccionConstantesFunciones.IDTRANSACCIONINVENFACTURA,strValorActual,strValorNuevo);
			}	
			
			if(parametrofactutransaccion.getIsNew()||!parametrofactutransaccion.getid_transaccion_inven_nota_credito().equals(parametrofactutransaccion.getParametroFactuTransaccionOriginal().getid_transaccion_inven_nota_credito()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametrofactutransaccion.getParametroFactuTransaccionOriginal().getid_transaccion_inven_nota_credito()!=null)
				{
					strValorActual=parametrofactutransaccion.getParametroFactuTransaccionOriginal().getid_transaccion_inven_nota_credito().toString();
				}
				if(parametrofactutransaccion.getid_transaccion_inven_nota_credito()!=null)
				{
					strValorNuevo=parametrofactutransaccion.getid_transaccion_inven_nota_credito().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroFactuTransaccionConstantesFunciones.IDTRANSACCIONINVENNOTACREDITO,strValorActual,strValorNuevo);
			}	
			
			if(parametrofactutransaccion.getIsNew()||!parametrofactutransaccion.getid_transaccion_inven_nota_venta().equals(parametrofactutransaccion.getParametroFactuTransaccionOriginal().getid_transaccion_inven_nota_venta()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametrofactutransaccion.getParametroFactuTransaccionOriginal().getid_transaccion_inven_nota_venta()!=null)
				{
					strValorActual=parametrofactutransaccion.getParametroFactuTransaccionOriginal().getid_transaccion_inven_nota_venta().toString();
				}
				if(parametrofactutransaccion.getid_transaccion_inven_nota_venta()!=null)
				{
					strValorNuevo=parametrofactutransaccion.getid_transaccion_inven_nota_venta().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroFactuTransaccionConstantesFunciones.IDTRANSACCIONINVENNOTAVENTA,strValorActual,strValorNuevo);
			}	
			
			if(parametrofactutransaccion.getIsNew()||!parametrofactutransaccion.getid_transaccion_cuenta_co_factura().equals(parametrofactutransaccion.getParametroFactuTransaccionOriginal().getid_transaccion_cuenta_co_factura()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametrofactutransaccion.getParametroFactuTransaccionOriginal().getid_transaccion_cuenta_co_factura()!=null)
				{
					strValorActual=parametrofactutransaccion.getParametroFactuTransaccionOriginal().getid_transaccion_cuenta_co_factura().toString();
				}
				if(parametrofactutransaccion.getid_transaccion_cuenta_co_factura()!=null)
				{
					strValorNuevo=parametrofactutransaccion.getid_transaccion_cuenta_co_factura().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroFactuTransaccionConstantesFunciones.IDTRANSACCIONCUENTACOFACTURA,strValorActual,strValorNuevo);
			}	
			
			if(parametrofactutransaccion.getIsNew()||!parametrofactutransaccion.getid_transaccion_cuenta_co_nota_credito().equals(parametrofactutransaccion.getParametroFactuTransaccionOriginal().getid_transaccion_cuenta_co_nota_credito()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametrofactutransaccion.getParametroFactuTransaccionOriginal().getid_transaccion_cuenta_co_nota_credito()!=null)
				{
					strValorActual=parametrofactutransaccion.getParametroFactuTransaccionOriginal().getid_transaccion_cuenta_co_nota_credito().toString();
				}
				if(parametrofactutransaccion.getid_transaccion_cuenta_co_nota_credito()!=null)
				{
					strValorNuevo=parametrofactutransaccion.getid_transaccion_cuenta_co_nota_credito().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroFactuTransaccionConstantesFunciones.IDTRANSACCIONCUENTACONOTACREDITO,strValorActual,strValorNuevo);
			}	
			
			if(parametrofactutransaccion.getIsNew()||!parametrofactutransaccion.getid_transaccion_cuenta_co_nota_venta().equals(parametrofactutransaccion.getParametroFactuTransaccionOriginal().getid_transaccion_cuenta_co_nota_venta()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametrofactutransaccion.getParametroFactuTransaccionOriginal().getid_transaccion_cuenta_co_nota_venta()!=null)
				{
					strValorActual=parametrofactutransaccion.getParametroFactuTransaccionOriginal().getid_transaccion_cuenta_co_nota_venta().toString();
				}
				if(parametrofactutransaccion.getid_transaccion_cuenta_co_nota_venta()!=null)
				{
					strValorNuevo=parametrofactutransaccion.getid_transaccion_cuenta_co_nota_venta().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroFactuTransaccionConstantesFunciones.IDTRANSACCIONCUENTACONOTAVENTA,strValorActual,strValorNuevo);
			}	
			
			if(parametrofactutransaccion.getIsNew()||!parametrofactutransaccion.getid_transaccion_cuenta_co_tarjeta().equals(parametrofactutransaccion.getParametroFactuTransaccionOriginal().getid_transaccion_cuenta_co_tarjeta()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametrofactutransaccion.getParametroFactuTransaccionOriginal().getid_transaccion_cuenta_co_tarjeta()!=null)
				{
					strValorActual=parametrofactutransaccion.getParametroFactuTransaccionOriginal().getid_transaccion_cuenta_co_tarjeta().toString();
				}
				if(parametrofactutransaccion.getid_transaccion_cuenta_co_tarjeta()!=null)
				{
					strValorNuevo=parametrofactutransaccion.getid_transaccion_cuenta_co_tarjeta().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroFactuTransaccionConstantesFunciones.IDTRANSACCIONCUENTACOTARJETA,strValorActual,strValorNuevo);
			}	
			
			if(parametrofactutransaccion.getIsNew()||!parametrofactutransaccion.getid_transaccion_cuenta_pa_factura().equals(parametrofactutransaccion.getParametroFactuTransaccionOriginal().getid_transaccion_cuenta_pa_factura()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametrofactutransaccion.getParametroFactuTransaccionOriginal().getid_transaccion_cuenta_pa_factura()!=null)
				{
					strValorActual=parametrofactutransaccion.getParametroFactuTransaccionOriginal().getid_transaccion_cuenta_pa_factura().toString();
				}
				if(parametrofactutransaccion.getid_transaccion_cuenta_pa_factura()!=null)
				{
					strValorNuevo=parametrofactutransaccion.getid_transaccion_cuenta_pa_factura().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroFactuTransaccionConstantesFunciones.IDTRANSACCIONCUENTAPAFACTURA,strValorActual,strValorNuevo);
			}	
			
			if(parametrofactutransaccion.getIsNew()||!parametrofactutransaccion.getid_transaccion_cuenta_pa_nota_credito().equals(parametrofactutransaccion.getParametroFactuTransaccionOriginal().getid_transaccion_cuenta_pa_nota_credito()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametrofactutransaccion.getParametroFactuTransaccionOriginal().getid_transaccion_cuenta_pa_nota_credito()!=null)
				{
					strValorActual=parametrofactutransaccion.getParametroFactuTransaccionOriginal().getid_transaccion_cuenta_pa_nota_credito().toString();
				}
				if(parametrofactutransaccion.getid_transaccion_cuenta_pa_nota_credito()!=null)
				{
					strValorNuevo=parametrofactutransaccion.getid_transaccion_cuenta_pa_nota_credito().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroFactuTransaccionConstantesFunciones.IDTRANSACCIONCUENTAPANOTACREDITO,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveParametroFactuTransaccionRelacionesWithConnection(ParametroFactuTransaccion parametrofactutransaccion) throws Exception {

		if(!parametrofactutransaccion.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveParametroFactuTransaccionRelacionesBase(parametrofactutransaccion,true);
		}
	}

	public void saveParametroFactuTransaccionRelaciones(ParametroFactuTransaccion parametrofactutransaccion)throws Exception {

		if(!parametrofactutransaccion.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveParametroFactuTransaccionRelacionesBase(parametrofactutransaccion,false);
		}
	}

	public void saveParametroFactuTransaccionRelacionesBase(ParametroFactuTransaccion parametrofactutransaccion,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("ParametroFactuTransaccion-saveRelacionesWithConnection");}
	

			this.setParametroFactuTransaccion(parametrofactutransaccion);

			if(ParametroFactuTransaccionLogicAdditional.validarSaveRelaciones(parametrofactutransaccion,this)) {

				ParametroFactuTransaccionLogicAdditional.updateRelacionesToSave(parametrofactutransaccion,this);

				if((parametrofactutransaccion.getIsNew()||parametrofactutransaccion.getIsChanged())&&!parametrofactutransaccion.getIsDeleted()) {
					this.saveParametroFactuTransaccion();
					this.saveParametroFactuTransaccionRelacionesDetalles();

				} else if(parametrofactutransaccion.getIsDeleted()) {
					this.saveParametroFactuTransaccionRelacionesDetalles();
					this.saveParametroFactuTransaccion();
				}

				ParametroFactuTransaccionLogicAdditional.updateRelacionesToSaveAfter(parametrofactutransaccion,this);

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
	
	
	private void saveParametroFactuTransaccionRelacionesDetalles()throws Exception {
		try {
	

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfParametroFactuTransaccion(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=ParametroFactuTransaccionConstantesFunciones.getClassesForeignKeysOfParametroFactuTransaccion(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfParametroFactuTransaccion(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=ParametroFactuTransaccionConstantesFunciones.getClassesRelationshipsOfParametroFactuTransaccion(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

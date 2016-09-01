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
import com.bydan.erp.facturacion.util.LibroContableConstantesFunciones;
import com.bydan.erp.facturacion.util.LibroContableParameterReturnGeneral;
//import com.bydan.erp.facturacion.util.LibroContableParameterGeneral;
import com.bydan.erp.facturacion.business.entity.LibroContable;
import com.bydan.erp.facturacion.business.logic.LibroContableLogicAdditional;
import com.bydan.erp.facturacion.business.dataaccess.*;
import com.bydan.erp.facturacion.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;
import com.bydan.erp.inventario.business.logic.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.inventario.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.inventario.business.dataaccess.*;








@SuppressWarnings("unused")
public class LibroContableLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(LibroContableLogic.class);
	
	protected LibroContableDataAccess librocontableDataAccess; 	
	protected LibroContable librocontable;
	protected List<LibroContable> librocontables;
	protected Object librocontableObject;	
	protected List<Object> librocontablesObject;
	
	public static ClassValidator<LibroContable> librocontableValidator = new ClassValidator<LibroContable>(LibroContable.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected LibroContableLogicAdditional librocontableLogicAdditional=null;
	
	public LibroContableLogicAdditional getLibroContableLogicAdditional() {
		return this.librocontableLogicAdditional;
	}
	
	public void setLibroContableLogicAdditional(LibroContableLogicAdditional librocontableLogicAdditional) {
		try {
			this.librocontableLogicAdditional=librocontableLogicAdditional;
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
	
	
	
	
	public  LibroContableLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.librocontableDataAccess = new LibroContableDataAccess();
			
			this.librocontables= new ArrayList<LibroContable>();
			this.librocontable= new LibroContable();
			
			this.librocontableObject=new Object();
			this.librocontablesObject=new ArrayList<Object>();
				
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
			
			this.librocontableDataAccess.setConnexionType(this.connexionType);
			this.librocontableDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  LibroContableLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.librocontableDataAccess = new LibroContableDataAccess();
			this.librocontables= new ArrayList<LibroContable>();
			this.librocontable= new LibroContable();
			this.librocontableObject=new Object();
			this.librocontablesObject=new ArrayList<Object>();
			
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
			
			this.librocontableDataAccess.setConnexionType(this.connexionType);
			this.librocontableDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public LibroContable getLibroContable() throws Exception {	
		LibroContableLogicAdditional.checkLibroContableToGet(librocontable,this.datosCliente,this.arrDatoGeneral);
		LibroContableLogicAdditional.updateLibroContableToGet(librocontable,this.arrDatoGeneral);
		
		return librocontable;
	}
		
	public void setLibroContable(LibroContable newLibroContable) {
		this.librocontable = newLibroContable;
	}
	
	public LibroContableDataAccess getLibroContableDataAccess() {
		return librocontableDataAccess;
	}
	
	public void setLibroContableDataAccess(LibroContableDataAccess newlibrocontableDataAccess) {
		this.librocontableDataAccess = newlibrocontableDataAccess;
	}
	
	public List<LibroContable> getLibroContables() throws Exception {		
		this.quitarLibroContablesNulos();
		
		LibroContableLogicAdditional.checkLibroContableToGets(librocontables,this.datosCliente,this.arrDatoGeneral);
		
		for (LibroContable librocontableLocal: librocontables ) {
			LibroContableLogicAdditional.updateLibroContableToGet(librocontableLocal,this.arrDatoGeneral);
		}
		
		return librocontables;
	}
	
	public void setLibroContables(List<LibroContable> newLibroContables) {
		this.librocontables = newLibroContables;
	}
	
	public Object getLibroContableObject() {	
		this.librocontableObject=this.librocontableDataAccess.getEntityObject();
		return this.librocontableObject;
	}
		
	public void setLibroContableObject(Object newLibroContableObject) {
		this.librocontableObject = newLibroContableObject;
	}
	
	public List<Object> getLibroContablesObject() {		
		this.librocontablesObject=this.librocontableDataAccess.getEntitiesObject();
		return this.librocontablesObject;
	}
		
	public void setLibroContablesObject(List<Object> newLibroContablesObject) {
		this.librocontablesObject = newLibroContablesObject;
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
		
		if(this.librocontableDataAccess!=null) {
			this.librocontableDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,LibroContable.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			librocontableDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			librocontableDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		librocontable = new  LibroContable();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,LibroContable.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			librocontable=librocontableDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.librocontable,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				LibroContableConstantesFunciones.refrescarForeignKeysDescripcionesLibroContable(this.librocontable);
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
		librocontable = new  LibroContable();
		  		  
        try {
			
			librocontable=librocontableDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.librocontable,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				LibroContableConstantesFunciones.refrescarForeignKeysDescripcionesLibroContable(this.librocontable);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		librocontable = new  LibroContable();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,LibroContable.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			librocontable=librocontableDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.librocontable,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				LibroContableConstantesFunciones.refrescarForeignKeysDescripcionesLibroContable(this.librocontable);
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
		librocontable = new  LibroContable();
		  		  
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
		librocontable = new  LibroContable();
		  		  
        try {
			
			librocontable=librocontableDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.librocontable,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				LibroContableConstantesFunciones.refrescarForeignKeysDescripcionesLibroContable(this.librocontable);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		librocontable = new  LibroContable();
		  		  
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
		librocontable = new  LibroContable();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,LibroContable.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =librocontableDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		librocontable = new  LibroContable();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=librocontableDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		librocontable = new  LibroContable();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,LibroContable.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =librocontableDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		librocontable = new  LibroContable();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=librocontableDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		librocontable = new  LibroContable();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,LibroContable.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =librocontableDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		librocontable = new  LibroContable();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=librocontableDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		librocontables = new  ArrayList<LibroContable>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,LibroContable.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			LibroContableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			librocontables=librocontableDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarLibroContable(librocontables);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				LibroContableConstantesFunciones.refrescarForeignKeysDescripcionesLibroContable(this.librocontables);
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
		librocontables = new  ArrayList<LibroContable>();
		  		  
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
		librocontables = new  ArrayList<LibroContable>();
		  		  
        try {			
			LibroContableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			librocontables=librocontableDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarLibroContable(librocontables);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				LibroContableConstantesFunciones.refrescarForeignKeysDescripcionesLibroContable(this.librocontables);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		librocontables = new  ArrayList<LibroContable>();
		  		  
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
		librocontables = new  ArrayList<LibroContable>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,LibroContable.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			LibroContableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			librocontables=librocontableDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarLibroContable(librocontables);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				LibroContableConstantesFunciones.refrescarForeignKeysDescripcionesLibroContable(this.librocontables);
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
		librocontables = new  ArrayList<LibroContable>();
		  		  
        try {
			LibroContableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			librocontables=librocontableDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarLibroContable(librocontables);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				LibroContableConstantesFunciones.refrescarForeignKeysDescripcionesLibroContable(this.librocontables);
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
		librocontables = new  ArrayList<LibroContable>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,LibroContable.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			LibroContableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			librocontables=librocontableDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarLibroContable(librocontables);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				LibroContableConstantesFunciones.refrescarForeignKeysDescripcionesLibroContable(this.librocontables);
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
		librocontables = new  ArrayList<LibroContable>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			LibroContableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			librocontables=librocontableDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarLibroContable(librocontables);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				LibroContableConstantesFunciones.refrescarForeignKeysDescripcionesLibroContable(this.librocontables);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		librocontable = new  LibroContable();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,LibroContable.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			LibroContableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			librocontable=librocontableDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarLibroContable(librocontable);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				LibroContableConstantesFunciones.refrescarForeignKeysDescripcionesLibroContable(this.librocontable);
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
		librocontable = new  LibroContable();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			LibroContableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			librocontable=librocontableDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarLibroContable(librocontable);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				LibroContableConstantesFunciones.refrescarForeignKeysDescripcionesLibroContable(this.librocontable);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		librocontables = new  ArrayList<LibroContable>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,LibroContable.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			LibroContableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			librocontables=librocontableDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarLibroContable(librocontables);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				LibroContableConstantesFunciones.refrescarForeignKeysDescripcionesLibroContable(this.librocontables);
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
		librocontables = new  ArrayList<LibroContable>();
		  		  
        try {
			LibroContableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			librocontables=librocontableDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarLibroContable(librocontables);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				LibroContableConstantesFunciones.refrescarForeignKeysDescripcionesLibroContable(this.librocontables);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosLibroContablesWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		librocontables = new  ArrayList<LibroContable>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,LibroContable.class.getSimpleName()+"-getTodosLibroContablesWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			LibroContableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			librocontables=librocontableDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarLibroContable(librocontables);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				LibroContableConstantesFunciones.refrescarForeignKeysDescripcionesLibroContable(this.librocontables);
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
	
	public  void  getTodosLibroContables(String sFinalQuery,Pagination pagination)throws Exception {
		librocontables = new  ArrayList<LibroContable>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			LibroContableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			librocontables=librocontableDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarLibroContable(librocontables);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				LibroContableConstantesFunciones.refrescarForeignKeysDescripcionesLibroContable(this.librocontables);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarLibroContable(LibroContable librocontable) throws Exception {
		Boolean estaValidado=false;
		
		if(librocontable.getIsNew() || librocontable.getIsChanged()) { 
			this.invalidValues = librocontableValidator.getInvalidValues(librocontable);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(librocontable);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarLibroContable(List<LibroContable> LibroContables) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(LibroContable librocontableLocal:librocontables) {				
			estaValidadoObjeto=this.validarGuardarLibroContable(librocontableLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarLibroContable(List<LibroContable> LibroContables) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarLibroContable(librocontables)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarLibroContable(LibroContable LibroContable) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarLibroContable(librocontable)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(LibroContable librocontable) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+librocontable.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=LibroContableConstantesFunciones.getLibroContableLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"librocontable","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(LibroContableConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(LibroContableConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveLibroContableWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,LibroContable.class.getSimpleName()+"-saveLibroContableWithConnection");connexion.begin();			
			
			LibroContableLogicAdditional.checkLibroContableToSave(this.librocontable,this.datosCliente,connexion,this.arrDatoGeneral);
			
			LibroContableLogicAdditional.updateLibroContableToSave(this.librocontable,this.arrDatoGeneral);
			
			LibroContableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.librocontable,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowLibroContable();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarLibroContable(this.librocontable)) {
				LibroContableDataAccess.save(this.librocontable, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.librocontable,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			LibroContableLogicAdditional.checkLibroContableToSaveAfter(this.librocontable,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowLibroContable();
			
			connexion.commit();			
			
			if(this.librocontable.getIsDeleted()) {
				this.librocontable=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveLibroContable()throws Exception {	
		try {	
			
			LibroContableLogicAdditional.checkLibroContableToSave(this.librocontable,this.datosCliente,connexion,this.arrDatoGeneral);
			
			LibroContableLogicAdditional.updateLibroContableToSave(this.librocontable,this.arrDatoGeneral);
			
			LibroContableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.librocontable,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarLibroContable(this.librocontable)) {			
				LibroContableDataAccess.save(this.librocontable, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.librocontable,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			LibroContableLogicAdditional.checkLibroContableToSaveAfter(this.librocontable,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.librocontable.getIsDeleted()) {
				this.librocontable=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveLibroContablesWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,LibroContable.class.getSimpleName()+"-saveLibroContablesWithConnection");connexion.begin();			
			
			LibroContableLogicAdditional.checkLibroContableToSaves(librocontables,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowLibroContables();
			
			Boolean validadoTodosLibroContable=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(LibroContable librocontableLocal:librocontables) {		
				if(librocontableLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				LibroContableLogicAdditional.updateLibroContableToSave(librocontableLocal,this.arrDatoGeneral);
	        	
				LibroContableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),librocontableLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarLibroContable(librocontableLocal)) {
					LibroContableDataAccess.save(librocontableLocal, connexion);				
				} else {
					validadoTodosLibroContable=false;
				}
			}
			
			if(!validadoTodosLibroContable) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			LibroContableLogicAdditional.checkLibroContableToSavesAfter(librocontables,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowLibroContables();
			
			connexion.commit();		
			
			this.quitarLibroContablesEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveLibroContables()throws Exception {				
		 try {	
			LibroContableLogicAdditional.checkLibroContableToSaves(librocontables,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosLibroContable=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(LibroContable librocontableLocal:librocontables) {				
				if(librocontableLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				LibroContableLogicAdditional.updateLibroContableToSave(librocontableLocal,this.arrDatoGeneral);
	        	
				LibroContableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),librocontableLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarLibroContable(librocontableLocal)) {				
					LibroContableDataAccess.save(librocontableLocal, connexion);				
				} else {
					validadoTodosLibroContable=false;
				}
			}
			
			if(!validadoTodosLibroContable) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			LibroContableLogicAdditional.checkLibroContableToSavesAfter(librocontables,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarLibroContablesEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public LibroContableParameterReturnGeneral procesarAccionLibroContables(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<LibroContable> librocontables,LibroContableParameterReturnGeneral librocontableParameterGeneral)throws Exception {
		 try {	
			LibroContableParameterReturnGeneral librocontableReturnGeneral=new LibroContableParameterReturnGeneral();
	
			LibroContableLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,librocontables,librocontableParameterGeneral,librocontableReturnGeneral);
			
			return librocontableReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public LibroContableParameterReturnGeneral procesarAccionLibroContablesWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<LibroContable> librocontables,LibroContableParameterReturnGeneral librocontableParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,LibroContable.class.getSimpleName()+"-procesarAccionLibroContablesWithConnection");connexion.begin();			
			
			LibroContableParameterReturnGeneral librocontableReturnGeneral=new LibroContableParameterReturnGeneral();
	
			LibroContableLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,librocontables,librocontableParameterGeneral,librocontableReturnGeneral);
			
			this.connexion.commit();
			
			return librocontableReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public LibroContableParameterReturnGeneral procesarEventosLibroContables(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<LibroContable> librocontables,LibroContable librocontable,LibroContableParameterReturnGeneral librocontableParameterGeneral,Boolean isEsNuevoLibroContable,ArrayList<Classe> clases)throws Exception {
		 try {	
			LibroContableParameterReturnGeneral librocontableReturnGeneral=new LibroContableParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				librocontableReturnGeneral.setConRecargarPropiedades(true);
			}
			
			LibroContableLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,librocontables,librocontable,librocontableParameterGeneral,librocontableReturnGeneral,isEsNuevoLibroContable,clases);
			
			return librocontableReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public LibroContableParameterReturnGeneral procesarEventosLibroContablesWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<LibroContable> librocontables,LibroContable librocontable,LibroContableParameterReturnGeneral librocontableParameterGeneral,Boolean isEsNuevoLibroContable,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,LibroContable.class.getSimpleName()+"-procesarEventosLibroContablesWithConnection");connexion.begin();			
			
			LibroContableParameterReturnGeneral librocontableReturnGeneral=new LibroContableParameterReturnGeneral();
	
			librocontableReturnGeneral.setLibroContable(librocontable);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				librocontableReturnGeneral.setConRecargarPropiedades(true);
			}
			
			LibroContableLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,librocontables,librocontable,librocontableParameterGeneral,librocontableReturnGeneral,isEsNuevoLibroContable,clases);
			
			this.connexion.commit();
			
			return librocontableReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public LibroContableParameterReturnGeneral procesarImportacionLibroContablesWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,LibroContableParameterReturnGeneral librocontableParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,LibroContable.class.getSimpleName()+"-procesarImportacionLibroContablesWithConnection");connexion.begin();			
			
			LibroContableParameterReturnGeneral librocontableReturnGeneral=new LibroContableParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.librocontables=new ArrayList<LibroContable>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.librocontable=new LibroContable();
				
				
				if(conColumnasBase) {this.librocontable.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.librocontable.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.librocontable.setcodigo(arrColumnas[iColumn++]);
				this.librocontable.setnombre(arrColumnas[iColumn++]);
				
				this.librocontables.add(this.librocontable);
			}
			
			this.saveLibroContables();
			
			this.connexion.commit();
			
			librocontableReturnGeneral.setConRetornoEstaProcesado(true);
			librocontableReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return librocontableReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarLibroContablesEliminados() throws Exception {				
		
		List<LibroContable> librocontablesAux= new ArrayList<LibroContable>();
		
		for(LibroContable librocontable:librocontables) {
			if(!librocontable.getIsDeleted()) {
				librocontablesAux.add(librocontable);
			}
		}
		
		librocontables=librocontablesAux;
	}
	
	public void quitarLibroContablesNulos() throws Exception {				
		
		List<LibroContable> librocontablesAux= new ArrayList<LibroContable>();
		
		for(LibroContable librocontable : this.librocontables) {
			if(librocontable==null) {
				librocontablesAux.add(librocontable);
			}
		}
		
		//this.librocontables=librocontablesAux;
		
		this.librocontables.removeAll(librocontablesAux);
	}
	
	public void getSetVersionRowLibroContableWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(librocontable.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((librocontable.getIsDeleted() || (librocontable.getIsChanged()&&!librocontable.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=librocontableDataAccess.getSetVersionRowLibroContable(connexion,librocontable.getId());
				
				if(!librocontable.getVersionRow().equals(timestamp)) {	
					librocontable.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				librocontable.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowLibroContable()throws Exception {	
		
		if(librocontable.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((librocontable.getIsDeleted() || (librocontable.getIsChanged()&&!librocontable.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=librocontableDataAccess.getSetVersionRowLibroContable(connexion,librocontable.getId());
			
			try {							
				if(!librocontable.getVersionRow().equals(timestamp)) {	
					librocontable.setVersionRow(timestamp);
				}
				
				librocontable.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowLibroContablesWithConnection()throws Exception {	
		if(librocontables!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(LibroContable librocontableAux:librocontables) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(librocontableAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(librocontableAux.getIsDeleted() || (librocontableAux.getIsChanged()&&!librocontableAux.getIsNew())) {
						
						timestamp=librocontableDataAccess.getSetVersionRowLibroContable(connexion,librocontableAux.getId());
						
						if(!librocontable.getVersionRow().equals(timestamp)) {	
							librocontableAux.setVersionRow(timestamp);
						}
								
						librocontableAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowLibroContables()throws Exception {	
		if(librocontables!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(LibroContable librocontableAux:librocontables) {
					if(librocontableAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(librocontableAux.getIsDeleted() || (librocontableAux.getIsChanged()&&!librocontableAux.getIsNew())) {
						
						timestamp=librocontableDataAccess.getSetVersionRowLibroContable(connexion,librocontableAux.getId());
						
						if(!librocontableAux.getVersionRow().equals(timestamp)) {	
							librocontableAux.setVersionRow(timestamp);
						}
						
													
						librocontableAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public LibroContableParameterReturnGeneral cargarCombosLoteForeignKeyLibroContableWithConnection(String finalQueryGlobalEmpresa) throws Exception {
		LibroContableParameterReturnGeneral  librocontableReturnGeneral =new LibroContableParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,LibroContable.class.getSimpleName()+"-cargarCombosLoteForeignKeyLibroContableWithConnection");connexion.begin();
			
			librocontableReturnGeneral =new LibroContableParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			librocontableReturnGeneral.setempresasForeignKey(empresasForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return librocontableReturnGeneral;
	}
	
	public LibroContableParameterReturnGeneral cargarCombosLoteForeignKeyLibroContable(String finalQueryGlobalEmpresa) throws Exception {
		LibroContableParameterReturnGeneral  librocontableReturnGeneral =new LibroContableParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			librocontableReturnGeneral =new LibroContableParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			librocontableReturnGeneral.setempresasForeignKey(empresasForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return librocontableReturnGeneral;
	}
	
	public void cargarRelacionesLoteForeignKeyLibroContableWithConnection() throws Exception {
		ArrayList<Classe> classes=new ArrayList<Classe>();		
		
		
			ParametroFactuPrincipalLogic parametrofactuprincipalLogic=new ParametroFactuPrincipalLogic();
			DefinicionLogic definicionLogic=new DefinicionLogic();
		
		try {
			
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,LibroContable.class.getSimpleName()+"-cargarRelacionesLoteForeignKeyLibroContableWithConnection");connexion.begin();
			
			
			classes.add(new Classe(ParametroFactuPrincipal.class));
			classes.add(new Classe(Definicion.class));
											
			

			parametrofactuprincipalLogic.setConnexion(this.getConnexion());
			parametrofactuprincipalLogic.setDatosCliente(this.datosCliente);
			parametrofactuprincipalLogic.setIsConRefrescarForeignKeys(true);

			definicionLogic.setConnexion(this.getConnexion());
			definicionLogic.setDatosCliente(this.datosCliente);
			definicionLogic.setIsConRefrescarForeignKeys(true);
			
			this.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
			
			for(LibroContable librocontable:this.librocontables) {
				

				classes=new ArrayList<Classe>();
				classes=ParametroFactuPrincipalConstantesFunciones.getClassesForeignKeysOfParametroFactuPrincipal(new ArrayList<Classe>(),DeepLoadType.NONE);

				parametrofactuprincipalLogic.setParametroFactuPrincipals(librocontable.parametrofactuprincipals);
				parametrofactuprincipalLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=DefinicionConstantesFunciones.getClassesForeignKeysOfDefinicion(new ArrayList<Classe>(),DeepLoadType.NONE);

				definicionLogic.setDefinicions(librocontable.definicions);
				definicionLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
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
	
	public void deepLoad(LibroContable librocontable,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			LibroContableLogicAdditional.updateLibroContableToGet(librocontable,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		librocontable.setEmpresa(librocontableDataAccess.getEmpresa(connexion,librocontable));
		librocontable.setParametroFactuPrincipals(librocontableDataAccess.getParametroFactuPrincipals(connexion,librocontable));
		librocontable.setDefinicions(librocontableDataAccess.getDefinicions(connexion,librocontable));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				librocontable.setEmpresa(librocontableDataAccess.getEmpresa(connexion,librocontable));
				continue;
			}

			if(clas.clas.equals(ParametroFactuPrincipal.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				librocontable.setParametroFactuPrincipals(librocontableDataAccess.getParametroFactuPrincipals(connexion,librocontable));

				if(this.isConDeep) {
					ParametroFactuPrincipalLogic parametrofactuprincipalLogic= new ParametroFactuPrincipalLogic(this.connexion);
					parametrofactuprincipalLogic.setParametroFactuPrincipals(librocontable.getParametroFactuPrincipals());
					ArrayList<Classe> classesLocal=ParametroFactuPrincipalConstantesFunciones.getClassesForeignKeysOfParametroFactuPrincipal(new ArrayList<Classe>(),DeepLoadType.NONE);
					parametrofactuprincipalLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					ParametroFactuPrincipalConstantesFunciones.refrescarForeignKeysDescripcionesParametroFactuPrincipal(parametrofactuprincipalLogic.getParametroFactuPrincipals());
					librocontable.setParametroFactuPrincipals(parametrofactuprincipalLogic.getParametroFactuPrincipals());
				}

				continue;
			}

			if(clas.clas.equals(Definicion.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				librocontable.setDefinicions(librocontableDataAccess.getDefinicions(connexion,librocontable));

				if(this.isConDeep) {
					DefinicionLogic definicionLogic= new DefinicionLogic(this.connexion);
					definicionLogic.setDefinicions(librocontable.getDefinicions());
					ArrayList<Classe> classesLocal=DefinicionConstantesFunciones.getClassesForeignKeysOfDefinicion(new ArrayList<Classe>(),DeepLoadType.NONE);
					definicionLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					DefinicionConstantesFunciones.refrescarForeignKeysDescripcionesDefinicion(definicionLogic.getDefinicions());
					librocontable.setDefinicions(definicionLogic.getDefinicions());
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
			librocontable.setEmpresa(librocontableDataAccess.getEmpresa(connexion,librocontable));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(ParametroFactuPrincipal.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(ParametroFactuPrincipal.class));
			librocontable.setParametroFactuPrincipals(librocontableDataAccess.getParametroFactuPrincipals(connexion,librocontable));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Definicion.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(Definicion.class));
			librocontable.setDefinicions(librocontableDataAccess.getDefinicions(connexion,librocontable));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		librocontable.setEmpresa(librocontableDataAccess.getEmpresa(connexion,librocontable));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(librocontable.getEmpresa(),isDeep,deepLoadType,clases);
				

		librocontable.setParametroFactuPrincipals(librocontableDataAccess.getParametroFactuPrincipals(connexion,librocontable));

		for(ParametroFactuPrincipal parametrofactuprincipal:librocontable.getParametroFactuPrincipals()) {
			ParametroFactuPrincipalLogic parametrofactuprincipalLogic= new ParametroFactuPrincipalLogic(connexion);
			parametrofactuprincipalLogic.deepLoad(parametrofactuprincipal,isDeep,deepLoadType,clases);
		}

		librocontable.setDefinicions(librocontableDataAccess.getDefinicions(connexion,librocontable));

		for(Definicion definicion:librocontable.getDefinicions()) {
			DefinicionLogic definicionLogic= new DefinicionLogic(connexion);
			definicionLogic.deepLoad(definicion,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				librocontable.setEmpresa(librocontableDataAccess.getEmpresa(connexion,librocontable));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(librocontable.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(ParametroFactuPrincipal.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				librocontable.setParametroFactuPrincipals(librocontableDataAccess.getParametroFactuPrincipals(connexion,librocontable));

				for(ParametroFactuPrincipal parametrofactuprincipal:librocontable.getParametroFactuPrincipals()) {
					ParametroFactuPrincipalLogic parametrofactuprincipalLogic= new ParametroFactuPrincipalLogic(connexion);
					parametrofactuprincipalLogic.deepLoad(parametrofactuprincipal,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(Definicion.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				librocontable.setDefinicions(librocontableDataAccess.getDefinicions(connexion,librocontable));

				for(Definicion definicion:librocontable.getDefinicions()) {
					DefinicionLogic definicionLogic= new DefinicionLogic(connexion);
					definicionLogic.deepLoad(definicion,isDeep,deepLoadType,clases);
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
			librocontable.setEmpresa(librocontableDataAccess.getEmpresa(connexion,librocontable));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(librocontable.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(ParametroFactuPrincipal.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(ParametroFactuPrincipal.class));
			librocontable.setParametroFactuPrincipals(librocontableDataAccess.getParametroFactuPrincipals(connexion,librocontable));

			for(ParametroFactuPrincipal parametrofactuprincipal:librocontable.getParametroFactuPrincipals()) {
				ParametroFactuPrincipalLogic parametrofactuprincipalLogic= new ParametroFactuPrincipalLogic(connexion);
				parametrofactuprincipalLogic.deepLoad(parametrofactuprincipal,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Definicion.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(Definicion.class));
			librocontable.setDefinicions(librocontableDataAccess.getDefinicions(connexion,librocontable));

			for(Definicion definicion:librocontable.getDefinicions()) {
				DefinicionLogic definicionLogic= new DefinicionLogic(connexion);
				definicionLogic.deepLoad(definicion,isDeep,deepLoadType,clases);
			}
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(LibroContable librocontable,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			LibroContableLogicAdditional.updateLibroContableToSave(librocontable,this.arrDatoGeneral);
			
LibroContableDataAccess.save(librocontable, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(librocontable.getEmpresa(),connexion);

		for(ParametroFactuPrincipal parametrofactuprincipal:librocontable.getParametroFactuPrincipals()) {
			parametrofactuprincipal.setid_libro_contable(librocontable.getId());
			ParametroFactuPrincipalDataAccess.save(parametrofactuprincipal,connexion);
		}

		for(Definicion definicion:librocontable.getDefinicions()) {
			definicion.setid_libro_contable(librocontable.getId());
			DefinicionDataAccess.save(definicion,connexion);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(librocontable.getEmpresa(),connexion);
				continue;
			}


			if(clas.clas.equals(ParametroFactuPrincipal.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(ParametroFactuPrincipal parametrofactuprincipal:librocontable.getParametroFactuPrincipals()) {
					parametrofactuprincipal.setid_libro_contable(librocontable.getId());
					ParametroFactuPrincipalDataAccess.save(parametrofactuprincipal,connexion);
				}
				continue;
			}

			if(clas.clas.equals(Definicion.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(Definicion definicion:librocontable.getDefinicions()) {
					definicion.setid_libro_contable(librocontable.getId());
					DefinicionDataAccess.save(definicion,connexion);
				}
				continue;
			}
		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(librocontable.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(librocontable.getEmpresa(),isDeep,deepLoadType,clases);
				

		for(ParametroFactuPrincipal parametrofactuprincipal:librocontable.getParametroFactuPrincipals()) {
			ParametroFactuPrincipalLogic parametrofactuprincipalLogic= new ParametroFactuPrincipalLogic(connexion);
			parametrofactuprincipal.setid_libro_contable(librocontable.getId());
			ParametroFactuPrincipalDataAccess.save(parametrofactuprincipal,connexion);
			parametrofactuprincipalLogic.deepSave(parametrofactuprincipal,isDeep,deepLoadType,clases);
		}

		for(Definicion definicion:librocontable.getDefinicions()) {
			DefinicionLogic definicionLogic= new DefinicionLogic(connexion);
			definicion.setid_libro_contable(librocontable.getId());
			DefinicionDataAccess.save(definicion,connexion);
			definicionLogic.deepSave(definicion,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(librocontable.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(librocontable.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}


			if(clas.clas.equals(ParametroFactuPrincipal.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(ParametroFactuPrincipal parametrofactuprincipal:librocontable.getParametroFactuPrincipals()) {
					ParametroFactuPrincipalLogic parametrofactuprincipalLogic= new ParametroFactuPrincipalLogic(connexion);
					parametrofactuprincipal.setid_libro_contable(librocontable.getId());
					ParametroFactuPrincipalDataAccess.save(parametrofactuprincipal,connexion);
					parametrofactuprincipalLogic.deepSave(parametrofactuprincipal,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(Definicion.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(Definicion definicion:librocontable.getDefinicions()) {
					DefinicionLogic definicionLogic= new DefinicionLogic(connexion);
					definicion.setid_libro_contable(librocontable.getId());
					DefinicionDataAccess.save(definicion,connexion);
					definicionLogic.deepSave(definicion,isDeep,deepLoadType,clases);
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
			this.getNewConnexionToDeep(LibroContable.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(librocontable,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				LibroContableConstantesFunciones.refrescarForeignKeysDescripcionesLibroContable(librocontable);
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
			this.deepLoad(this.librocontable,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				LibroContableConstantesFunciones.refrescarForeignKeysDescripcionesLibroContable(this.librocontable);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(LibroContable.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(librocontables!=null) {
				for(LibroContable librocontable:librocontables) {
					this.deepLoad(librocontable,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					LibroContableConstantesFunciones.refrescarForeignKeysDescripcionesLibroContable(librocontables);
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
			if(librocontables!=null) {
				for(LibroContable librocontable:librocontables) {
					this.deepLoad(librocontable,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					LibroContableConstantesFunciones.refrescarForeignKeysDescripcionesLibroContable(librocontables);
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
			this.getNewConnexionToDeep(LibroContable.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(librocontable,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(LibroContable.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(librocontables!=null) {
				for(LibroContable librocontable:librocontables) {
					this.deepSave(librocontable,isDeep,deepLoadType,clases);
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
			if(librocontables!=null) {
				for(LibroContable librocontable:librocontables) {
					this.deepSave(librocontable,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getLibroContablesBusquedaPorCodigoWithConnection(String sFinalQuery,Pagination pagination,String codigo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,LibroContable.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralCodigo= new ParameterSelectionGeneral();
			parameterSelectionGeneralCodigo.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+codigo+"%",LibroContableConstantesFunciones.CODIGO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralCodigo);

			LibroContableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorCodigo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			librocontables=librocontableDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				LibroContableConstantesFunciones.refrescarForeignKeysDescripcionesLibroContable(this.librocontables);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getLibroContablesBusquedaPorCodigo(String sFinalQuery,Pagination pagination,String codigo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralCodigo= new ParameterSelectionGeneral();
			parameterSelectionGeneralCodigo.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+codigo+"%",LibroContableConstantesFunciones.CODIGO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralCodigo);

			LibroContableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorCodigo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			librocontables=librocontableDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				LibroContableConstantesFunciones.refrescarForeignKeysDescripcionesLibroContable(this.librocontables);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getLibroContablesBusquedaPorNombreWithConnection(String sFinalQuery,Pagination pagination,String nombre)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,LibroContable.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralNombre= new ParameterSelectionGeneral();
			parameterSelectionGeneralNombre.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+nombre+"%",LibroContableConstantesFunciones.NOMBRE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNombre);

			LibroContableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorNombre","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			librocontables=librocontableDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				LibroContableConstantesFunciones.refrescarForeignKeysDescripcionesLibroContable(this.librocontables);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getLibroContablesBusquedaPorNombre(String sFinalQuery,Pagination pagination,String nombre)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralNombre= new ParameterSelectionGeneral();
			parameterSelectionGeneralNombre.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+nombre+"%",LibroContableConstantesFunciones.NOMBRE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNombre);

			LibroContableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorNombre","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			librocontables=librocontableDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				LibroContableConstantesFunciones.refrescarForeignKeysDescripcionesLibroContable(this.librocontables);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getLibroContablesFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,LibroContable.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,LibroContableConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			LibroContableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			librocontables=librocontableDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				LibroContableConstantesFunciones.refrescarForeignKeysDescripcionesLibroContable(this.librocontables);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getLibroContablesFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,LibroContableConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			LibroContableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			librocontables=librocontableDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				LibroContableConstantesFunciones.refrescarForeignKeysDescripcionesLibroContable(this.librocontables);
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
			if(LibroContableConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,LibroContableDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,LibroContable librocontable,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(LibroContableConstantesFunciones.ISCONAUDITORIA) {
				if(librocontable.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,LibroContableDataAccess.TABLENAME, librocontable.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(LibroContableConstantesFunciones.ISCONAUDITORIADETALLE) {
						////LibroContableLogic.registrarAuditoriaDetallesLibroContable(connexion,librocontable,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(librocontable.getIsDeleted()) {
					/*if(!librocontable.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,LibroContableDataAccess.TABLENAME, librocontable.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////LibroContableLogic.registrarAuditoriaDetallesLibroContable(connexion,librocontable,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,LibroContableDataAccess.TABLENAME, librocontable.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(librocontable.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,LibroContableDataAccess.TABLENAME, librocontable.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(LibroContableConstantesFunciones.ISCONAUDITORIADETALLE) {
						////LibroContableLogic.registrarAuditoriaDetallesLibroContable(connexion,librocontable,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesLibroContable(Connexion connexion,LibroContable librocontable)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(librocontable.getIsNew()||!librocontable.getid_empresa().equals(librocontable.getLibroContableOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(librocontable.getLibroContableOriginal().getid_empresa()!=null)
				{
					strValorActual=librocontable.getLibroContableOriginal().getid_empresa().toString();
				}
				if(librocontable.getid_empresa()!=null)
				{
					strValorNuevo=librocontable.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),LibroContableConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(librocontable.getIsNew()||!librocontable.getcodigo().equals(librocontable.getLibroContableOriginal().getcodigo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(librocontable.getLibroContableOriginal().getcodigo()!=null)
				{
					strValorActual=librocontable.getLibroContableOriginal().getcodigo();
				}
				if(librocontable.getcodigo()!=null)
				{
					strValorNuevo=librocontable.getcodigo() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),LibroContableConstantesFunciones.CODIGO,strValorActual,strValorNuevo);
			}	
			
			if(librocontable.getIsNew()||!librocontable.getnombre().equals(librocontable.getLibroContableOriginal().getnombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(librocontable.getLibroContableOriginal().getnombre()!=null)
				{
					strValorActual=librocontable.getLibroContableOriginal().getnombre();
				}
				if(librocontable.getnombre()!=null)
				{
					strValorNuevo=librocontable.getnombre() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),LibroContableConstantesFunciones.NOMBRE,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveLibroContableRelacionesWithConnection(LibroContable librocontable,List<ParametroFactuPrincipal> parametrofactuprincipals,List<Definicion> definicions) throws Exception {

		if(!librocontable.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveLibroContableRelacionesBase(librocontable,parametrofactuprincipals,definicions,true);
		}
	}

	public void saveLibroContableRelaciones(LibroContable librocontable,List<ParametroFactuPrincipal> parametrofactuprincipals,List<Definicion> definicions)throws Exception {

		if(!librocontable.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveLibroContableRelacionesBase(librocontable,parametrofactuprincipals,definicions,false);
		}
	}

	public void saveLibroContableRelacionesBase(LibroContable librocontable,List<ParametroFactuPrincipal> parametrofactuprincipals,List<Definicion> definicions,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("LibroContable-saveRelacionesWithConnection");}
	
			librocontable.setParametroFactuPrincipals(parametrofactuprincipals);
			librocontable.setDefinicions(definicions);

			this.setLibroContable(librocontable);

			if(LibroContableLogicAdditional.validarSaveRelaciones(librocontable,this)) {

				LibroContableLogicAdditional.updateRelacionesToSave(librocontable,this);

				if((librocontable.getIsNew()||librocontable.getIsChanged())&&!librocontable.getIsDeleted()) {
					this.saveLibroContable();
					this.saveLibroContableRelacionesDetalles(parametrofactuprincipals,definicions);

				} else if(librocontable.getIsDeleted()) {
					this.saveLibroContableRelacionesDetalles(parametrofactuprincipals,definicions);
					this.saveLibroContable();
				}

				LibroContableLogicAdditional.updateRelacionesToSaveAfter(librocontable,this);

			} else {
				throw new Exception("LOS DATOS SON INVALIDOS");
			}

			if(conConexion) {connexion.commit();}

		} catch(Exception e) {
			
			ParametroFactuPrincipalConstantesFunciones.InicializarGeneralEntityAuxiliaresParametroFactuPrincipals(parametrofactuprincipals,true,true);
			DefinicionConstantesFunciones.InicializarGeneralEntityAuxiliaresDefinicions(definicions,true,true);

			if(conConexion){connexion.rollback();}
			Funciones.manageException(logger,e);
			throw e;

		} finally {
			if(conConexion){this.closeNewConnexionToDeep();}
		}
	}
	
	
	private void saveLibroContableRelacionesDetalles(List<ParametroFactuPrincipal> parametrofactuprincipals,List<Definicion> definicions)throws Exception {
		try {
	

			Long idLibroContableActual=this.getLibroContable().getId();

			ParametroFactuPrincipalLogic parametrofactuprincipalLogic_Desde_LibroContable=new ParametroFactuPrincipalLogic();
			parametrofactuprincipalLogic_Desde_LibroContable.setParametroFactuPrincipals(parametrofactuprincipals);

			parametrofactuprincipalLogic_Desde_LibroContable.setConnexion(this.getConnexion());
			parametrofactuprincipalLogic_Desde_LibroContable.setDatosCliente(this.datosCliente);

			for(ParametroFactuPrincipal parametrofactuprincipal_Desde_LibroContable:parametrofactuprincipalLogic_Desde_LibroContable.getParametroFactuPrincipals()) {
				parametrofactuprincipal_Desde_LibroContable.setid_libro_contable(idLibroContableActual);
			}

			parametrofactuprincipalLogic_Desde_LibroContable.saveParametroFactuPrincipals();

			DefinicionLogic definicionLogic_Desde_LibroContable=new DefinicionLogic();
			definicionLogic_Desde_LibroContable.setDefinicions(definicions);

			definicionLogic_Desde_LibroContable.setConnexion(this.getConnexion());
			definicionLogic_Desde_LibroContable.setDatosCliente(this.datosCliente);

			for(Definicion definicion_Desde_LibroContable:definicionLogic_Desde_LibroContable.getDefinicions()) {
				definicion_Desde_LibroContable.setid_libro_contable(idLibroContableActual);
			}

			definicionLogic_Desde_LibroContable.saveDefinicions();

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfLibroContable(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=LibroContableConstantesFunciones.getClassesForeignKeysOfLibroContable(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfLibroContable(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=LibroContableConstantesFunciones.getClassesRelationshipsOfLibroContable(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

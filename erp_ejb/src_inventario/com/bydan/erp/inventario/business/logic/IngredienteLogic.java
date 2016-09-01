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
import com.bydan.erp.inventario.util.IngredienteConstantesFunciones;
import com.bydan.erp.inventario.util.IngredienteParameterReturnGeneral;
//import com.bydan.erp.inventario.util.IngredienteParameterGeneral;
import com.bydan.erp.inventario.business.entity.Ingrediente;
import com.bydan.erp.inventario.business.logic.IngredienteLogicAdditional;
import com.bydan.erp.inventario.business.dataaccess.*;
import com.bydan.erp.inventario.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;


import com.bydan.erp.seguridad.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;








@SuppressWarnings("unused")
public class IngredienteLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(IngredienteLogic.class);
	
	protected IngredienteDataAccess ingredienteDataAccess; 	
	protected Ingrediente ingrediente;
	protected List<Ingrediente> ingredientes;
	protected Object ingredienteObject;	
	protected List<Object> ingredientesObject;
	
	public static ClassValidator<Ingrediente> ingredienteValidator = new ClassValidator<Ingrediente>(Ingrediente.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected IngredienteLogicAdditional ingredienteLogicAdditional=null;
	
	public IngredienteLogicAdditional getIngredienteLogicAdditional() {
		return this.ingredienteLogicAdditional;
	}
	
	public void setIngredienteLogicAdditional(IngredienteLogicAdditional ingredienteLogicAdditional) {
		try {
			this.ingredienteLogicAdditional=ingredienteLogicAdditional;
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
	
	
	
	
	public  IngredienteLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.ingredienteDataAccess = new IngredienteDataAccess();
			
			this.ingredientes= new ArrayList<Ingrediente>();
			this.ingrediente= new Ingrediente();
			
			this.ingredienteObject=new Object();
			this.ingredientesObject=new ArrayList<Object>();
				
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
			
			this.ingredienteDataAccess.setConnexionType(this.connexionType);
			this.ingredienteDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  IngredienteLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.ingredienteDataAccess = new IngredienteDataAccess();
			this.ingredientes= new ArrayList<Ingrediente>();
			this.ingrediente= new Ingrediente();
			this.ingredienteObject=new Object();
			this.ingredientesObject=new ArrayList<Object>();
			
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
			
			this.ingredienteDataAccess.setConnexionType(this.connexionType);
			this.ingredienteDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public Ingrediente getIngrediente() throws Exception {	
		IngredienteLogicAdditional.checkIngredienteToGet(ingrediente,this.datosCliente,this.arrDatoGeneral);
		IngredienteLogicAdditional.updateIngredienteToGet(ingrediente,this.arrDatoGeneral);
		
		return ingrediente;
	}
		
	public void setIngrediente(Ingrediente newIngrediente) {
		this.ingrediente = newIngrediente;
	}
	
	public IngredienteDataAccess getIngredienteDataAccess() {
		return ingredienteDataAccess;
	}
	
	public void setIngredienteDataAccess(IngredienteDataAccess newingredienteDataAccess) {
		this.ingredienteDataAccess = newingredienteDataAccess;
	}
	
	public List<Ingrediente> getIngredientes() throws Exception {		
		this.quitarIngredientesNulos();
		
		IngredienteLogicAdditional.checkIngredienteToGets(ingredientes,this.datosCliente,this.arrDatoGeneral);
		
		for (Ingrediente ingredienteLocal: ingredientes ) {
			IngredienteLogicAdditional.updateIngredienteToGet(ingredienteLocal,this.arrDatoGeneral);
		}
		
		return ingredientes;
	}
	
	public void setIngredientes(List<Ingrediente> newIngredientes) {
		this.ingredientes = newIngredientes;
	}
	
	public Object getIngredienteObject() {	
		this.ingredienteObject=this.ingredienteDataAccess.getEntityObject();
		return this.ingredienteObject;
	}
		
	public void setIngredienteObject(Object newIngredienteObject) {
		this.ingredienteObject = newIngredienteObject;
	}
	
	public List<Object> getIngredientesObject() {		
		this.ingredientesObject=this.ingredienteDataAccess.getEntitiesObject();
		return this.ingredientesObject;
	}
		
	public void setIngredientesObject(List<Object> newIngredientesObject) {
		this.ingredientesObject = newIngredientesObject;
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
		
		if(this.ingredienteDataAccess!=null) {
			this.ingredienteDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Ingrediente.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			ingredienteDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			ingredienteDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		ingrediente = new  Ingrediente();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Ingrediente.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			ingrediente=ingredienteDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.ingrediente,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				IngredienteConstantesFunciones.refrescarForeignKeysDescripcionesIngrediente(this.ingrediente);
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
		ingrediente = new  Ingrediente();
		  		  
        try {
			
			ingrediente=ingredienteDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.ingrediente,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				IngredienteConstantesFunciones.refrescarForeignKeysDescripcionesIngrediente(this.ingrediente);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		ingrediente = new  Ingrediente();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Ingrediente.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			ingrediente=ingredienteDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.ingrediente,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				IngredienteConstantesFunciones.refrescarForeignKeysDescripcionesIngrediente(this.ingrediente);
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
		ingrediente = new  Ingrediente();
		  		  
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
		ingrediente = new  Ingrediente();
		  		  
        try {
			
			ingrediente=ingredienteDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.ingrediente,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				IngredienteConstantesFunciones.refrescarForeignKeysDescripcionesIngrediente(this.ingrediente);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		ingrediente = new  Ingrediente();
		  		  
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
		ingrediente = new  Ingrediente();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Ingrediente.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =ingredienteDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		ingrediente = new  Ingrediente();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=ingredienteDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		ingrediente = new  Ingrediente();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Ingrediente.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =ingredienteDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		ingrediente = new  Ingrediente();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=ingredienteDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		ingrediente = new  Ingrediente();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Ingrediente.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =ingredienteDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		ingrediente = new  Ingrediente();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=ingredienteDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		ingredientes = new  ArrayList<Ingrediente>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Ingrediente.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			IngredienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			ingredientes=ingredienteDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarIngrediente(ingredientes);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				IngredienteConstantesFunciones.refrescarForeignKeysDescripcionesIngrediente(this.ingredientes);
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
		ingredientes = new  ArrayList<Ingrediente>();
		  		  
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
		ingredientes = new  ArrayList<Ingrediente>();
		  		  
        try {			
			IngredienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			ingredientes=ingredienteDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarIngrediente(ingredientes);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				IngredienteConstantesFunciones.refrescarForeignKeysDescripcionesIngrediente(this.ingredientes);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		ingredientes = new  ArrayList<Ingrediente>();
		  		  
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
		ingredientes = new  ArrayList<Ingrediente>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Ingrediente.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			IngredienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			ingredientes=ingredienteDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarIngrediente(ingredientes);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				IngredienteConstantesFunciones.refrescarForeignKeysDescripcionesIngrediente(this.ingredientes);
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
		ingredientes = new  ArrayList<Ingrediente>();
		  		  
        try {
			IngredienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			ingredientes=ingredienteDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarIngrediente(ingredientes);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				IngredienteConstantesFunciones.refrescarForeignKeysDescripcionesIngrediente(this.ingredientes);
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
		ingredientes = new  ArrayList<Ingrediente>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Ingrediente.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			IngredienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			ingredientes=ingredienteDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarIngrediente(ingredientes);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				IngredienteConstantesFunciones.refrescarForeignKeysDescripcionesIngrediente(this.ingredientes);
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
		ingredientes = new  ArrayList<Ingrediente>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			IngredienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			ingredientes=ingredienteDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarIngrediente(ingredientes);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				IngredienteConstantesFunciones.refrescarForeignKeysDescripcionesIngrediente(this.ingredientes);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		ingrediente = new  Ingrediente();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Ingrediente.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			IngredienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			ingrediente=ingredienteDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarIngrediente(ingrediente);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				IngredienteConstantesFunciones.refrescarForeignKeysDescripcionesIngrediente(this.ingrediente);
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
		ingrediente = new  Ingrediente();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			IngredienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			ingrediente=ingredienteDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarIngrediente(ingrediente);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				IngredienteConstantesFunciones.refrescarForeignKeysDescripcionesIngrediente(this.ingrediente);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		ingredientes = new  ArrayList<Ingrediente>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Ingrediente.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			IngredienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			ingredientes=ingredienteDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarIngrediente(ingredientes);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				IngredienteConstantesFunciones.refrescarForeignKeysDescripcionesIngrediente(this.ingredientes);
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
		ingredientes = new  ArrayList<Ingrediente>();
		  		  
        try {
			IngredienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			ingredientes=ingredienteDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarIngrediente(ingredientes);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				IngredienteConstantesFunciones.refrescarForeignKeysDescripcionesIngrediente(this.ingredientes);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosIngredientesWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		ingredientes = new  ArrayList<Ingrediente>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Ingrediente.class.getSimpleName()+"-getTodosIngredientesWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			IngredienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			ingredientes=ingredienteDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarIngrediente(ingredientes);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				IngredienteConstantesFunciones.refrescarForeignKeysDescripcionesIngrediente(this.ingredientes);
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
	
	public  void  getTodosIngredientes(String sFinalQuery,Pagination pagination)throws Exception {
		ingredientes = new  ArrayList<Ingrediente>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			IngredienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			ingredientes=ingredienteDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarIngrediente(ingredientes);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				IngredienteConstantesFunciones.refrescarForeignKeysDescripcionesIngrediente(this.ingredientes);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarIngrediente(Ingrediente ingrediente) throws Exception {
		Boolean estaValidado=false;
		
		if(ingrediente.getIsNew() || ingrediente.getIsChanged()) { 
			this.invalidValues = ingredienteValidator.getInvalidValues(ingrediente);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(ingrediente);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarIngrediente(List<Ingrediente> Ingredientes) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(Ingrediente ingredienteLocal:ingredientes) {				
			estaValidadoObjeto=this.validarGuardarIngrediente(ingredienteLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarIngrediente(List<Ingrediente> Ingredientes) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarIngrediente(ingredientes)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarIngrediente(Ingrediente Ingrediente) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarIngrediente(ingrediente)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(Ingrediente ingrediente) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+ingrediente.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=IngredienteConstantesFunciones.getIngredienteLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"ingrediente","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(IngredienteConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(IngredienteConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveIngredienteWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Ingrediente.class.getSimpleName()+"-saveIngredienteWithConnection");connexion.begin();			
			
			IngredienteLogicAdditional.checkIngredienteToSave(this.ingrediente,this.datosCliente,connexion,this.arrDatoGeneral);
			
			IngredienteLogicAdditional.updateIngredienteToSave(this.ingrediente,this.arrDatoGeneral);
			
			IngredienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.ingrediente,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowIngrediente();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarIngrediente(this.ingrediente)) {
				IngredienteDataAccess.save(this.ingrediente, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.ingrediente,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			IngredienteLogicAdditional.checkIngredienteToSaveAfter(this.ingrediente,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowIngrediente();
			
			connexion.commit();			
			
			if(this.ingrediente.getIsDeleted()) {
				this.ingrediente=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveIngrediente()throws Exception {	
		try {	
			
			IngredienteLogicAdditional.checkIngredienteToSave(this.ingrediente,this.datosCliente,connexion,this.arrDatoGeneral);
			
			IngredienteLogicAdditional.updateIngredienteToSave(this.ingrediente,this.arrDatoGeneral);
			
			IngredienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.ingrediente,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarIngrediente(this.ingrediente)) {			
				IngredienteDataAccess.save(this.ingrediente, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.ingrediente,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			IngredienteLogicAdditional.checkIngredienteToSaveAfter(this.ingrediente,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.ingrediente.getIsDeleted()) {
				this.ingrediente=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveIngredientesWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Ingrediente.class.getSimpleName()+"-saveIngredientesWithConnection");connexion.begin();			
			
			IngredienteLogicAdditional.checkIngredienteToSaves(ingredientes,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowIngredientes();
			
			Boolean validadoTodosIngrediente=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(Ingrediente ingredienteLocal:ingredientes) {		
				if(ingredienteLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				IngredienteLogicAdditional.updateIngredienteToSave(ingredienteLocal,this.arrDatoGeneral);
	        	
				IngredienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),ingredienteLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarIngrediente(ingredienteLocal)) {
					IngredienteDataAccess.save(ingredienteLocal, connexion);				
				} else {
					validadoTodosIngrediente=false;
				}
			}
			
			if(!validadoTodosIngrediente) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			IngredienteLogicAdditional.checkIngredienteToSavesAfter(ingredientes,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowIngredientes();
			
			connexion.commit();		
			
			this.quitarIngredientesEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveIngredientes()throws Exception {				
		 try {	
			IngredienteLogicAdditional.checkIngredienteToSaves(ingredientes,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosIngrediente=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(Ingrediente ingredienteLocal:ingredientes) {				
				if(ingredienteLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				IngredienteLogicAdditional.updateIngredienteToSave(ingredienteLocal,this.arrDatoGeneral);
	        	
				IngredienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),ingredienteLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarIngrediente(ingredienteLocal)) {				
					IngredienteDataAccess.save(ingredienteLocal, connexion);				
				} else {
					validadoTodosIngrediente=false;
				}
			}
			
			if(!validadoTodosIngrediente) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			IngredienteLogicAdditional.checkIngredienteToSavesAfter(ingredientes,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarIngredientesEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public IngredienteParameterReturnGeneral procesarAccionIngredientes(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<Ingrediente> ingredientes,IngredienteParameterReturnGeneral ingredienteParameterGeneral)throws Exception {
		 try {	
			IngredienteParameterReturnGeneral ingredienteReturnGeneral=new IngredienteParameterReturnGeneral();
	
			IngredienteLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,ingredientes,ingredienteParameterGeneral,ingredienteReturnGeneral);
			
			return ingredienteReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public IngredienteParameterReturnGeneral procesarAccionIngredientesWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<Ingrediente> ingredientes,IngredienteParameterReturnGeneral ingredienteParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Ingrediente.class.getSimpleName()+"-procesarAccionIngredientesWithConnection");connexion.begin();			
			
			IngredienteParameterReturnGeneral ingredienteReturnGeneral=new IngredienteParameterReturnGeneral();
	
			IngredienteLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,ingredientes,ingredienteParameterGeneral,ingredienteReturnGeneral);
			
			this.connexion.commit();
			
			return ingredienteReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public IngredienteParameterReturnGeneral procesarEventosIngredientes(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<Ingrediente> ingredientes,Ingrediente ingrediente,IngredienteParameterReturnGeneral ingredienteParameterGeneral,Boolean isEsNuevoIngrediente,ArrayList<Classe> clases)throws Exception {
		 try {	
			IngredienteParameterReturnGeneral ingredienteReturnGeneral=new IngredienteParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				ingredienteReturnGeneral.setConRecargarPropiedades(true);
			}
			
			IngredienteLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,ingredientes,ingrediente,ingredienteParameterGeneral,ingredienteReturnGeneral,isEsNuevoIngrediente,clases);
			
			return ingredienteReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public IngredienteParameterReturnGeneral procesarEventosIngredientesWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<Ingrediente> ingredientes,Ingrediente ingrediente,IngredienteParameterReturnGeneral ingredienteParameterGeneral,Boolean isEsNuevoIngrediente,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Ingrediente.class.getSimpleName()+"-procesarEventosIngredientesWithConnection");connexion.begin();			
			
			IngredienteParameterReturnGeneral ingredienteReturnGeneral=new IngredienteParameterReturnGeneral();
	
			ingredienteReturnGeneral.setIngrediente(ingrediente);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				ingredienteReturnGeneral.setConRecargarPropiedades(true);
			}
			
			IngredienteLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,ingredientes,ingrediente,ingredienteParameterGeneral,ingredienteReturnGeneral,isEsNuevoIngrediente,clases);
			
			this.connexion.commit();
			
			return ingredienteReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public IngredienteParameterReturnGeneral procesarImportacionIngredientesWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,IngredienteParameterReturnGeneral ingredienteParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Ingrediente.class.getSimpleName()+"-procesarImportacionIngredientesWithConnection");connexion.begin();			
			
			IngredienteParameterReturnGeneral ingredienteReturnGeneral=new IngredienteParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.ingredientes=new ArrayList<Ingrediente>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.ingrediente=new Ingrediente();
				
				
				if(conColumnasBase) {this.ingrediente.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.ingrediente.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.ingrediente.setcantidad(Integer.parseInt(arrColumnas[iColumn++]));
				this.ingrediente.setprecio(Double.parseDouble(arrColumnas[iColumn++]));
				
				this.ingredientes.add(this.ingrediente);
			}
			
			this.saveIngredientes();
			
			this.connexion.commit();
			
			ingredienteReturnGeneral.setConRetornoEstaProcesado(true);
			ingredienteReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return ingredienteReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarIngredientesEliminados() throws Exception {				
		
		List<Ingrediente> ingredientesAux= new ArrayList<Ingrediente>();
		
		for(Ingrediente ingrediente:ingredientes) {
			if(!ingrediente.getIsDeleted()) {
				ingredientesAux.add(ingrediente);
			}
		}
		
		ingredientes=ingredientesAux;
	}
	
	public void quitarIngredientesNulos() throws Exception {				
		
		List<Ingrediente> ingredientesAux= new ArrayList<Ingrediente>();
		
		for(Ingrediente ingrediente : this.ingredientes) {
			if(ingrediente==null) {
				ingredientesAux.add(ingrediente);
			}
		}
		
		//this.ingredientes=ingredientesAux;
		
		this.ingredientes.removeAll(ingredientesAux);
	}
	
	public void getSetVersionRowIngredienteWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(ingrediente.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((ingrediente.getIsDeleted() || (ingrediente.getIsChanged()&&!ingrediente.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=ingredienteDataAccess.getSetVersionRowIngrediente(connexion,ingrediente.getId());
				
				if(!ingrediente.getVersionRow().equals(timestamp)) {	
					ingrediente.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				ingrediente.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowIngrediente()throws Exception {	
		
		if(ingrediente.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((ingrediente.getIsDeleted() || (ingrediente.getIsChanged()&&!ingrediente.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=ingredienteDataAccess.getSetVersionRowIngrediente(connexion,ingrediente.getId());
			
			try {							
				if(!ingrediente.getVersionRow().equals(timestamp)) {	
					ingrediente.setVersionRow(timestamp);
				}
				
				ingrediente.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowIngredientesWithConnection()throws Exception {	
		if(ingredientes!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(Ingrediente ingredienteAux:ingredientes) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(ingredienteAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(ingredienteAux.getIsDeleted() || (ingredienteAux.getIsChanged()&&!ingredienteAux.getIsNew())) {
						
						timestamp=ingredienteDataAccess.getSetVersionRowIngrediente(connexion,ingredienteAux.getId());
						
						if(!ingrediente.getVersionRow().equals(timestamp)) {	
							ingredienteAux.setVersionRow(timestamp);
						}
								
						ingredienteAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowIngredientes()throws Exception {	
		if(ingredientes!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(Ingrediente ingredienteAux:ingredientes) {
					if(ingredienteAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(ingredienteAux.getIsDeleted() || (ingredienteAux.getIsChanged()&&!ingredienteAux.getIsNew())) {
						
						timestamp=ingredienteDataAccess.getSetVersionRowIngrediente(connexion,ingredienteAux.getId());
						
						if(!ingredienteAux.getVersionRow().equals(timestamp)) {	
							ingredienteAux.setVersionRow(timestamp);
						}
						
													
						ingredienteAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public IngredienteParameterReturnGeneral cargarCombosLoteForeignKeyIngredienteWithConnection(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalBodega,String finalQueryGlobalBodegaRelacion,String finalQueryGlobalProducto,String finalQueryGlobalProductoRelacion) throws Exception {
		IngredienteParameterReturnGeneral  ingredienteReturnGeneral =new IngredienteParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Ingrediente.class.getSimpleName()+"-cargarCombosLoteForeignKeyIngredienteWithConnection");connexion.begin();
			
			ingredienteReturnGeneral =new IngredienteParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			ingredienteReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			ingredienteReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Bodega> bodegasForeignKey=new ArrayList<Bodega>();
			BodegaLogic bodegaLogic=new BodegaLogic();
			bodegaLogic.setConnexion(this.connexion);
			bodegaLogic.getBodegaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalBodega.equals("NONE")) {
				bodegaLogic.getTodosBodegas(finalQueryGlobalBodega,new Pagination());
				bodegasForeignKey=bodegaLogic.getBodegas();
			}

			ingredienteReturnGeneral.setbodegasForeignKey(bodegasForeignKey);


			List<Bodega> bodegarelacionsForeignKey=new ArrayList<Bodega>();
			BodegaLogic bodegarelacionLogic=new BodegaLogic();
			bodegarelacionLogic.setConnexion(this.connexion);
			bodegarelacionLogic.getBodegaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalBodegaRelacion.equals("NONE")) {
				bodegarelacionLogic.getTodosBodegas(finalQueryGlobalBodegaRelacion,new Pagination());
				bodegarelacionsForeignKey=bodegarelacionLogic.getBodegas();
			}

			ingredienteReturnGeneral.setbodegarelacionsForeignKey(bodegarelacionsForeignKey);


			List<Producto> productosForeignKey=new ArrayList<Producto>();
			ProductoLogic productoLogic=new ProductoLogic();
			productoLogic.setConnexion(this.connexion);
			productoLogic.getProductoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalProducto.equals("NONE")) {
				productoLogic.getTodosProductos(finalQueryGlobalProducto,new Pagination());
				productosForeignKey=productoLogic.getProductos();
			}

			ingredienteReturnGeneral.setproductosForeignKey(productosForeignKey);


			List<Producto> productorelacionsForeignKey=new ArrayList<Producto>();
			ProductoLogic productorelacionLogic=new ProductoLogic();
			productorelacionLogic.setConnexion(this.connexion);
			productorelacionLogic.getProductoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalProductoRelacion.equals("NONE")) {
				productorelacionLogic.getTodosProductos(finalQueryGlobalProductoRelacion,new Pagination());
				productorelacionsForeignKey=productorelacionLogic.getProductos();
			}

			ingredienteReturnGeneral.setproductorelacionsForeignKey(productorelacionsForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return ingredienteReturnGeneral;
	}
	
	public IngredienteParameterReturnGeneral cargarCombosLoteForeignKeyIngrediente(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalBodega,String finalQueryGlobalBodegaRelacion,String finalQueryGlobalProducto,String finalQueryGlobalProductoRelacion) throws Exception {
		IngredienteParameterReturnGeneral  ingredienteReturnGeneral =new IngredienteParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			ingredienteReturnGeneral =new IngredienteParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			ingredienteReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			ingredienteReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Bodega> bodegasForeignKey=new ArrayList<Bodega>();
			BodegaLogic bodegaLogic=new BodegaLogic();
			bodegaLogic.setConnexion(this.connexion);
			bodegaLogic.getBodegaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalBodega.equals("NONE")) {
				bodegaLogic.getTodosBodegas(finalQueryGlobalBodega,new Pagination());
				bodegasForeignKey=bodegaLogic.getBodegas();
			}

			ingredienteReturnGeneral.setbodegasForeignKey(bodegasForeignKey);


			List<Bodega> bodegarelacionsForeignKey=new ArrayList<Bodega>();
			BodegaLogic bodegarelacionLogic=new BodegaLogic();
			bodegarelacionLogic.setConnexion(this.connexion);
			bodegarelacionLogic.getBodegaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalBodegaRelacion.equals("NONE")) {
				bodegarelacionLogic.getTodosBodegas(finalQueryGlobalBodegaRelacion,new Pagination());
				bodegarelacionsForeignKey=bodegarelacionLogic.getBodegas();
			}

			ingredienteReturnGeneral.setbodegarelacionsForeignKey(bodegarelacionsForeignKey);


			List<Producto> productosForeignKey=new ArrayList<Producto>();
			ProductoLogic productoLogic=new ProductoLogic();
			productoLogic.setConnexion(this.connexion);
			productoLogic.getProductoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalProducto.equals("NONE")) {
				productoLogic.getTodosProductos(finalQueryGlobalProducto,new Pagination());
				productosForeignKey=productoLogic.getProductos();
			}

			ingredienteReturnGeneral.setproductosForeignKey(productosForeignKey);


			List<Producto> productorelacionsForeignKey=new ArrayList<Producto>();
			ProductoLogic productorelacionLogic=new ProductoLogic();
			productorelacionLogic.setConnexion(this.connexion);
			productorelacionLogic.getProductoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalProductoRelacion.equals("NONE")) {
				productorelacionLogic.getTodosProductos(finalQueryGlobalProductoRelacion,new Pagination());
				productorelacionsForeignKey=productorelacionLogic.getProductos();
			}

			ingredienteReturnGeneral.setproductorelacionsForeignKey(productorelacionsForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return ingredienteReturnGeneral;
	}
	
	
	public void deepLoad(Ingrediente ingrediente,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			IngredienteLogicAdditional.updateIngredienteToGet(ingrediente,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		ingrediente.setEmpresa(ingredienteDataAccess.getEmpresa(connexion,ingrediente));
		ingrediente.setSucursal(ingredienteDataAccess.getSucursal(connexion,ingrediente));
		ingrediente.setBodega(ingredienteDataAccess.getBodega(connexion,ingrediente));
		ingrediente.setBodegaRelacion(ingredienteDataAccess.getBodegaRelacion(connexion,ingrediente));
		ingrediente.setProducto(ingredienteDataAccess.getProducto(connexion,ingrediente));
		ingrediente.setProductoRelacion(ingredienteDataAccess.getProductoRelacion(connexion,ingrediente));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				ingrediente.setEmpresa(ingredienteDataAccess.getEmpresa(connexion,ingrediente));
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				ingrediente.setSucursal(ingredienteDataAccess.getSucursal(connexion,ingrediente));
				continue;
			}

			if(clas.clas.equals(Bodega.class)) {
				ingrediente.setBodega(ingredienteDataAccess.getBodega(connexion,ingrediente));
				continue;
			}

			if(clas.clas.equals(Bodega.class)) {
				ingrediente.setBodegaRelacion(ingredienteDataAccess.getBodegaRelacion(connexion,ingrediente));
				continue;
			}

			if(clas.clas.equals(Producto.class)) {
				ingrediente.setProducto(ingredienteDataAccess.getProducto(connexion,ingrediente));
				continue;
			}

			if(clas.clas.equals(Producto.class)) {
				ingrediente.setProductoRelacion(ingredienteDataAccess.getProductoRelacion(connexion,ingrediente));
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
			ingrediente.setEmpresa(ingredienteDataAccess.getEmpresa(connexion,ingrediente));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			ingrediente.setSucursal(ingredienteDataAccess.getSucursal(connexion,ingrediente));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Bodega.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			ingrediente.setBodega(ingredienteDataAccess.getBodega(connexion,ingrediente));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Bodega.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			ingrediente.setBodegaRelacion(ingredienteDataAccess.getBodegaRelacion(connexion,ingrediente));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Producto.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			ingrediente.setProducto(ingredienteDataAccess.getProducto(connexion,ingrediente));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Producto.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			ingrediente.setProductoRelacion(ingredienteDataAccess.getProductoRelacion(connexion,ingrediente));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		ingrediente.setEmpresa(ingredienteDataAccess.getEmpresa(connexion,ingrediente));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(ingrediente.getEmpresa(),isDeep,deepLoadType,clases);
				
		ingrediente.setSucursal(ingredienteDataAccess.getSucursal(connexion,ingrediente));
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(ingrediente.getSucursal(),isDeep,deepLoadType,clases);
				
		ingrediente.setBodega(ingredienteDataAccess.getBodega(connexion,ingrediente));
		BodegaLogic bodegaLogic= new BodegaLogic(connexion);
		bodegaLogic.deepLoad(ingrediente.getBodega(),isDeep,deepLoadType,clases);
				
		ingrediente.setBodegaRelacion(ingredienteDataAccess.getBodegaRelacion(connexion,ingrediente));
		BodegaLogic bodegarelacionLogic= new BodegaLogic(connexion);
		bodegarelacionLogic.deepLoad(ingrediente.getBodegaRelacion(),isDeep,deepLoadType,clases);
				
		ingrediente.setProducto(ingredienteDataAccess.getProducto(connexion,ingrediente));
		ProductoLogic productoLogic= new ProductoLogic(connexion);
		productoLogic.deepLoad(ingrediente.getProducto(),isDeep,deepLoadType,clases);
				
		ingrediente.setProductoRelacion(ingredienteDataAccess.getProductoRelacion(connexion,ingrediente));
		ProductoLogic productorelacionLogic= new ProductoLogic(connexion);
		productorelacionLogic.deepLoad(ingrediente.getProductoRelacion(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				ingrediente.setEmpresa(ingredienteDataAccess.getEmpresa(connexion,ingrediente));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(ingrediente.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				ingrediente.setSucursal(ingredienteDataAccess.getSucursal(connexion,ingrediente));
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepLoad(ingrediente.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Bodega.class)) {
				ingrediente.setBodega(ingredienteDataAccess.getBodega(connexion,ingrediente));
				BodegaLogic bodegaLogic= new BodegaLogic(connexion);
				bodegaLogic.deepLoad(ingrediente.getBodega(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Bodega.class)) {
				ingrediente.setBodegaRelacion(ingredienteDataAccess.getBodegaRelacion(connexion,ingrediente));
				BodegaLogic bodegaLogic= new BodegaLogic(connexion);
				bodegaLogic.deepLoad(ingrediente.getBodegaRelacion(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Producto.class)) {
				ingrediente.setProducto(ingredienteDataAccess.getProducto(connexion,ingrediente));
				ProductoLogic productoLogic= new ProductoLogic(connexion);
				productoLogic.deepLoad(ingrediente.getProducto(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Producto.class)) {
				ingrediente.setProductoRelacion(ingredienteDataAccess.getProductoRelacion(connexion,ingrediente));
				ProductoLogic productoLogic= new ProductoLogic(connexion);
				productoLogic.deepLoad(ingrediente.getProductoRelacion(),isDeep,deepLoadType,clases);				
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
			ingrediente.setEmpresa(ingredienteDataAccess.getEmpresa(connexion,ingrediente));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(ingrediente.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			ingrediente.setSucursal(ingredienteDataAccess.getSucursal(connexion,ingrediente));
			SucursalLogic sucursalLogic= new SucursalLogic(connexion);
			sucursalLogic.deepLoad(ingrediente.getSucursal(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Bodega.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			ingrediente.setBodega(ingredienteDataAccess.getBodega(connexion,ingrediente));
			BodegaLogic bodegaLogic= new BodegaLogic(connexion);
			bodegaLogic.deepLoad(ingrediente.getBodega(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Bodega.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			ingrediente.setBodegaRelacion(ingredienteDataAccess.getBodegaRelacion(connexion,ingrediente));
			BodegaLogic bodegaLogic= new BodegaLogic(connexion);
			bodegaLogic.deepLoad(ingrediente.getBodegaRelacion(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Producto.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			ingrediente.setProducto(ingredienteDataAccess.getProducto(connexion,ingrediente));
			ProductoLogic productoLogic= new ProductoLogic(connexion);
			productoLogic.deepLoad(ingrediente.getProducto(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Producto.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			ingrediente.setProductoRelacion(ingredienteDataAccess.getProductoRelacion(connexion,ingrediente));
			ProductoLogic productoLogic= new ProductoLogic(connexion);
			productoLogic.deepLoad(ingrediente.getProductoRelacion(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(Ingrediente ingrediente,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			IngredienteLogicAdditional.updateIngredienteToSave(ingrediente,this.arrDatoGeneral);
			
IngredienteDataAccess.save(ingrediente, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(ingrediente.getEmpresa(),connexion);

		SucursalDataAccess.save(ingrediente.getSucursal(),connexion);

		BodegaDataAccess.save(ingrediente.getBodega(),connexion);

		BodegaDataAccess.save(ingrediente.getBodegaRelacion(),connexion);

		ProductoDataAccess.save(ingrediente.getProducto(),connexion);

		ProductoDataAccess.save(ingrediente.getProductoRelacion(),connexion);
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(ingrediente.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(ingrediente.getSucursal(),connexion);
				continue;
			}

			if(clas.clas.equals(Bodega.class)) {
				BodegaDataAccess.save(ingrediente.getBodega(),connexion);
				continue;
			}

			if(clas.clas.equals(Bodega.class)) {
				BodegaDataAccess.save(ingrediente.getBodegaRelacion(),connexion);
				continue;
			}

			if(clas.clas.equals(Producto.class)) {
				ProductoDataAccess.save(ingrediente.getProducto(),connexion);
				continue;
			}

			if(clas.clas.equals(Producto.class)) {
				ProductoDataAccess.save(ingrediente.getProductoRelacion(),connexion);
				continue;
			}

		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(ingrediente.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(ingrediente.getEmpresa(),isDeep,deepLoadType,clases);
				

		SucursalDataAccess.save(ingrediente.getSucursal(),connexion);
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(ingrediente.getSucursal(),isDeep,deepLoadType,clases);
				

		BodegaDataAccess.save(ingrediente.getBodega(),connexion);
		BodegaLogic bodegaLogic= new BodegaLogic(connexion);
		bodegaLogic.deepLoad(ingrediente.getBodega(),isDeep,deepLoadType,clases);
				

		BodegaDataAccess.save(ingrediente.getBodegaRelacion(),connexion);
		BodegaLogic bodegarelacionLogic= new BodegaLogic(connexion);
		bodegarelacionLogic.deepLoad(ingrediente.getBodegaRelacion(),isDeep,deepLoadType,clases);
				

		ProductoDataAccess.save(ingrediente.getProducto(),connexion);
		ProductoLogic productoLogic= new ProductoLogic(connexion);
		productoLogic.deepLoad(ingrediente.getProducto(),isDeep,deepLoadType,clases);
				

		ProductoDataAccess.save(ingrediente.getProductoRelacion(),connexion);
		ProductoLogic productorelacionLogic= new ProductoLogic(connexion);
		productorelacionLogic.deepLoad(ingrediente.getProductoRelacion(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(ingrediente.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(ingrediente.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(ingrediente.getSucursal(),connexion);
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepSave(ingrediente.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Bodega.class)) {
				BodegaDataAccess.save(ingrediente.getBodega(),connexion);
				BodegaLogic bodegaLogic= new BodegaLogic(connexion);
				bodegaLogic.deepSave(ingrediente.getBodega(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Bodega.class)) {
				BodegaDataAccess.save(ingrediente.getBodegaRelacion(),connexion);
				BodegaLogic bodegaLogic= new BodegaLogic(connexion);
				bodegaLogic.deepSave(ingrediente.getBodegaRelacion(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Producto.class)) {
				ProductoDataAccess.save(ingrediente.getProducto(),connexion);
				ProductoLogic productoLogic= new ProductoLogic(connexion);
				productoLogic.deepSave(ingrediente.getProducto(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Producto.class)) {
				ProductoDataAccess.save(ingrediente.getProductoRelacion(),connexion);
				ProductoLogic productoLogic= new ProductoLogic(connexion);
				productoLogic.deepSave(ingrediente.getProductoRelacion(),isDeep,deepLoadType,clases);				
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
			this.getNewConnexionToDeep(Ingrediente.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(ingrediente,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				IngredienteConstantesFunciones.refrescarForeignKeysDescripcionesIngrediente(ingrediente);
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
			this.deepLoad(this.ingrediente,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				IngredienteConstantesFunciones.refrescarForeignKeysDescripcionesIngrediente(this.ingrediente);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(Ingrediente.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(ingredientes!=null) {
				for(Ingrediente ingrediente:ingredientes) {
					this.deepLoad(ingrediente,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					IngredienteConstantesFunciones.refrescarForeignKeysDescripcionesIngrediente(ingredientes);
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
			if(ingredientes!=null) {
				for(Ingrediente ingrediente:ingredientes) {
					this.deepLoad(ingrediente,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					IngredienteConstantesFunciones.refrescarForeignKeysDescripcionesIngrediente(ingredientes);
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
			this.getNewConnexionToDeep(Ingrediente.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(ingrediente,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(Ingrediente.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(ingredientes!=null) {
				for(Ingrediente ingrediente:ingredientes) {
					this.deepSave(ingrediente,isDeep,deepLoadType,clases);
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
			if(ingredientes!=null) {
				for(Ingrediente ingrediente:ingredientes) {
					this.deepSave(ingrediente,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getIngredientesFK_IdBodegaWithConnection(String sFinalQuery,Pagination pagination,Long id_bodega)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Ingrediente.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidBodega= new ParameterSelectionGeneral();
			parameterSelectionGeneralidBodega.setParameterSelectionGeneralEqual(ParameterType.LONG,id_bodega,IngredienteConstantesFunciones.IDBODEGA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidBodega);

			IngredienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdBodega","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			ingredientes=ingredienteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				IngredienteConstantesFunciones.refrescarForeignKeysDescripcionesIngrediente(this.ingredientes);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getIngredientesFK_IdBodega(String sFinalQuery,Pagination pagination,Long id_bodega)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidBodega= new ParameterSelectionGeneral();
			parameterSelectionGeneralidBodega.setParameterSelectionGeneralEqual(ParameterType.LONG,id_bodega,IngredienteConstantesFunciones.IDBODEGA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidBodega);

			IngredienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdBodega","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			ingredientes=ingredienteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				IngredienteConstantesFunciones.refrescarForeignKeysDescripcionesIngrediente(this.ingredientes);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getIngredientesFK_IdBodegaRelacionWithConnection(String sFinalQuery,Pagination pagination,Long id_bodega_relacion)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Ingrediente.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidBodegaRelacion= new ParameterSelectionGeneral();
			parameterSelectionGeneralidBodegaRelacion.setParameterSelectionGeneralEqual(ParameterType.LONG,id_bodega_relacion,IngredienteConstantesFunciones.IDBODEGARELACION,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidBodegaRelacion);

			IngredienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdBodegaRelacion","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			ingredientes=ingredienteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				IngredienteConstantesFunciones.refrescarForeignKeysDescripcionesIngrediente(this.ingredientes);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getIngredientesFK_IdBodegaRelacion(String sFinalQuery,Pagination pagination,Long id_bodega_relacion)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidBodegaRelacion= new ParameterSelectionGeneral();
			parameterSelectionGeneralidBodegaRelacion.setParameterSelectionGeneralEqual(ParameterType.LONG,id_bodega_relacion,IngredienteConstantesFunciones.IDBODEGARELACION,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidBodegaRelacion);

			IngredienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdBodegaRelacion","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			ingredientes=ingredienteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				IngredienteConstantesFunciones.refrescarForeignKeysDescripcionesIngrediente(this.ingredientes);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getIngredientesFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Ingrediente.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,IngredienteConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			IngredienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			ingredientes=ingredienteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				IngredienteConstantesFunciones.refrescarForeignKeysDescripcionesIngrediente(this.ingredientes);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getIngredientesFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,IngredienteConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			IngredienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			ingredientes=ingredienteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				IngredienteConstantesFunciones.refrescarForeignKeysDescripcionesIngrediente(this.ingredientes);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getIngredientesFK_IdProductoWithConnection(String sFinalQuery,Pagination pagination,Long id_producto)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Ingrediente.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidProducto= new ParameterSelectionGeneral();
			parameterSelectionGeneralidProducto.setParameterSelectionGeneralEqual(ParameterType.LONG,id_producto,IngredienteConstantesFunciones.IDPRODUCTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidProducto);

			IngredienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdProducto","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			ingredientes=ingredienteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				IngredienteConstantesFunciones.refrescarForeignKeysDescripcionesIngrediente(this.ingredientes);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getIngredientesFK_IdProducto(String sFinalQuery,Pagination pagination,Long id_producto)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidProducto= new ParameterSelectionGeneral();
			parameterSelectionGeneralidProducto.setParameterSelectionGeneralEqual(ParameterType.LONG,id_producto,IngredienteConstantesFunciones.IDPRODUCTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidProducto);

			IngredienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdProducto","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			ingredientes=ingredienteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				IngredienteConstantesFunciones.refrescarForeignKeysDescripcionesIngrediente(this.ingredientes);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getIngredientesFK_IdProductoRelacionWithConnection(String sFinalQuery,Pagination pagination,Long id_producto_relacion)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Ingrediente.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidProductoRelacion= new ParameterSelectionGeneral();
			parameterSelectionGeneralidProductoRelacion.setParameterSelectionGeneralEqual(ParameterType.LONG,id_producto_relacion,IngredienteConstantesFunciones.IDPRODUCTORELACION,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidProductoRelacion);

			IngredienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdProductoRelacion","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			ingredientes=ingredienteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				IngredienteConstantesFunciones.refrescarForeignKeysDescripcionesIngrediente(this.ingredientes);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getIngredientesFK_IdProductoRelacion(String sFinalQuery,Pagination pagination,Long id_producto_relacion)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidProductoRelacion= new ParameterSelectionGeneral();
			parameterSelectionGeneralidProductoRelacion.setParameterSelectionGeneralEqual(ParameterType.LONG,id_producto_relacion,IngredienteConstantesFunciones.IDPRODUCTORELACION,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidProductoRelacion);

			IngredienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdProductoRelacion","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			ingredientes=ingredienteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				IngredienteConstantesFunciones.refrescarForeignKeysDescripcionesIngrediente(this.ingredientes);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getIngredientesFK_IdSucursalWithConnection(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Ingrediente.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,IngredienteConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			IngredienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			ingredientes=ingredienteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				IngredienteConstantesFunciones.refrescarForeignKeysDescripcionesIngrediente(this.ingredientes);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getIngredientesFK_IdSucursal(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,IngredienteConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			IngredienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			ingredientes=ingredienteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				IngredienteConstantesFunciones.refrescarForeignKeysDescripcionesIngrediente(this.ingredientes);
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
			if(IngredienteConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,IngredienteDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,Ingrediente ingrediente,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(IngredienteConstantesFunciones.ISCONAUDITORIA) {
				if(ingrediente.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,IngredienteDataAccess.TABLENAME, ingrediente.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(IngredienteConstantesFunciones.ISCONAUDITORIADETALLE) {
						////IngredienteLogic.registrarAuditoriaDetallesIngrediente(connexion,ingrediente,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(ingrediente.getIsDeleted()) {
					/*if(!ingrediente.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,IngredienteDataAccess.TABLENAME, ingrediente.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////IngredienteLogic.registrarAuditoriaDetallesIngrediente(connexion,ingrediente,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,IngredienteDataAccess.TABLENAME, ingrediente.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(ingrediente.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,IngredienteDataAccess.TABLENAME, ingrediente.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(IngredienteConstantesFunciones.ISCONAUDITORIADETALLE) {
						////IngredienteLogic.registrarAuditoriaDetallesIngrediente(connexion,ingrediente,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesIngrediente(Connexion connexion,Ingrediente ingrediente)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(ingrediente.getIsNew()||!ingrediente.getid_empresa().equals(ingrediente.getIngredienteOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(ingrediente.getIngredienteOriginal().getid_empresa()!=null)
				{
					strValorActual=ingrediente.getIngredienteOriginal().getid_empresa().toString();
				}
				if(ingrediente.getid_empresa()!=null)
				{
					strValorNuevo=ingrediente.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),IngredienteConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(ingrediente.getIsNew()||!ingrediente.getid_sucursal().equals(ingrediente.getIngredienteOriginal().getid_sucursal()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(ingrediente.getIngredienteOriginal().getid_sucursal()!=null)
				{
					strValorActual=ingrediente.getIngredienteOriginal().getid_sucursal().toString();
				}
				if(ingrediente.getid_sucursal()!=null)
				{
					strValorNuevo=ingrediente.getid_sucursal().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),IngredienteConstantesFunciones.IDSUCURSAL,strValorActual,strValorNuevo);
			}	
			
			if(ingrediente.getIsNew()||!ingrediente.getid_bodega().equals(ingrediente.getIngredienteOriginal().getid_bodega()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(ingrediente.getIngredienteOriginal().getid_bodega()!=null)
				{
					strValorActual=ingrediente.getIngredienteOriginal().getid_bodega().toString();
				}
				if(ingrediente.getid_bodega()!=null)
				{
					strValorNuevo=ingrediente.getid_bodega().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),IngredienteConstantesFunciones.IDBODEGA,strValorActual,strValorNuevo);
			}	
			
			if(ingrediente.getIsNew()||!ingrediente.getid_bodega_relacion().equals(ingrediente.getIngredienteOriginal().getid_bodega_relacion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(ingrediente.getIngredienteOriginal().getid_bodega_relacion()!=null)
				{
					strValorActual=ingrediente.getIngredienteOriginal().getid_bodega_relacion().toString();
				}
				if(ingrediente.getid_bodega_relacion()!=null)
				{
					strValorNuevo=ingrediente.getid_bodega_relacion().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),IngredienteConstantesFunciones.IDBODEGARELACION,strValorActual,strValorNuevo);
			}	
			
			if(ingrediente.getIsNew()||!ingrediente.getid_producto().equals(ingrediente.getIngredienteOriginal().getid_producto()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(ingrediente.getIngredienteOriginal().getid_producto()!=null)
				{
					strValorActual=ingrediente.getIngredienteOriginal().getid_producto().toString();
				}
				if(ingrediente.getid_producto()!=null)
				{
					strValorNuevo=ingrediente.getid_producto().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),IngredienteConstantesFunciones.IDPRODUCTO,strValorActual,strValorNuevo);
			}	
			
			if(ingrediente.getIsNew()||!ingrediente.getid_producto_relacion().equals(ingrediente.getIngredienteOriginal().getid_producto_relacion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(ingrediente.getIngredienteOriginal().getid_producto_relacion()!=null)
				{
					strValorActual=ingrediente.getIngredienteOriginal().getid_producto_relacion().toString();
				}
				if(ingrediente.getid_producto_relacion()!=null)
				{
					strValorNuevo=ingrediente.getid_producto_relacion().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),IngredienteConstantesFunciones.IDPRODUCTORELACION,strValorActual,strValorNuevo);
			}	
			
			if(ingrediente.getIsNew()||!ingrediente.getcantidad().equals(ingrediente.getIngredienteOriginal().getcantidad()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(ingrediente.getIngredienteOriginal().getcantidad()!=null)
				{
					strValorActual=ingrediente.getIngredienteOriginal().getcantidad().toString();
				}
				if(ingrediente.getcantidad()!=null)
				{
					strValorNuevo=ingrediente.getcantidad().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),IngredienteConstantesFunciones.CANTIDAD,strValorActual,strValorNuevo);
			}	
			
			if(ingrediente.getIsNew()||!ingrediente.getprecio().equals(ingrediente.getIngredienteOriginal().getprecio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(ingrediente.getIngredienteOriginal().getprecio()!=null)
				{
					strValorActual=ingrediente.getIngredienteOriginal().getprecio().toString();
				}
				if(ingrediente.getprecio()!=null)
				{
					strValorNuevo=ingrediente.getprecio().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),IngredienteConstantesFunciones.PRECIO,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveIngredienteRelacionesWithConnection(Ingrediente ingrediente) throws Exception {

		if(!ingrediente.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveIngredienteRelacionesBase(ingrediente,true);
		}
	}

	public void saveIngredienteRelaciones(Ingrediente ingrediente)throws Exception {

		if(!ingrediente.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveIngredienteRelacionesBase(ingrediente,false);
		}
	}

	public void saveIngredienteRelacionesBase(Ingrediente ingrediente,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("Ingrediente-saveRelacionesWithConnection");}
	

			this.setIngrediente(ingrediente);

			if(IngredienteLogicAdditional.validarSaveRelaciones(ingrediente,this)) {

				IngredienteLogicAdditional.updateRelacionesToSave(ingrediente,this);

				if((ingrediente.getIsNew()||ingrediente.getIsChanged())&&!ingrediente.getIsDeleted()) {
					this.saveIngrediente();
					this.saveIngredienteRelacionesDetalles();

				} else if(ingrediente.getIsDeleted()) {
					this.saveIngredienteRelacionesDetalles();
					this.saveIngrediente();
				}

				IngredienteLogicAdditional.updateRelacionesToSaveAfter(ingrediente,this);

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
	
	
	private void saveIngredienteRelacionesDetalles()throws Exception {
		try {
	

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfIngrediente(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=IngredienteConstantesFunciones.getClassesForeignKeysOfIngrediente(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfIngrediente(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=IngredienteConstantesFunciones.getClassesRelationshipsOfIngrediente(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

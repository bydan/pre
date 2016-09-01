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
package com.bydan.erp.seguridad.business.logic;

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
import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.seguridad.util.ModuloConstantesFunciones;
import com.bydan.erp.seguridad.util.ModuloParameterReturnGeneral;
//import com.bydan.erp.seguridad.util.ModuloParameterGeneral;
import com.bydan.erp.seguridad.business.entity.Modulo;
import com.bydan.erp.seguridad.business.logic.ModuloLogicAdditional;
import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.seguridad.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;
















@SuppressWarnings("unused")
public class ModuloLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(ModuloLogic.class);
	
	protected ModuloDataAccess moduloDataAccess; 	
	protected Modulo modulo;
	protected List<Modulo> modulos;
	protected Object moduloObject;	
	protected List<Object> modulosObject;
	
	public static ClassValidator<Modulo> moduloValidator = new ClassValidator<Modulo>(Modulo.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected ModuloLogicAdditional moduloLogicAdditional=null;
	
	public ModuloLogicAdditional getModuloLogicAdditional() {
		return this.moduloLogicAdditional;
	}
	
	public void setModuloLogicAdditional(ModuloLogicAdditional moduloLogicAdditional) {
		try {
			this.moduloLogicAdditional=moduloLogicAdditional;
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
	
	
	
	
	public  ModuloLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.moduloDataAccess = new ModuloDataAccess();
			
			this.modulos= new ArrayList<Modulo>();
			this.modulo= new Modulo();
			
			this.moduloObject=new Object();
			this.modulosObject=new ArrayList<Object>();
				
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
			
			this.moduloDataAccess.setConnexionType(this.connexionType);
			this.moduloDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  ModuloLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.moduloDataAccess = new ModuloDataAccess();
			this.modulos= new ArrayList<Modulo>();
			this.modulo= new Modulo();
			this.moduloObject=new Object();
			this.modulosObject=new ArrayList<Object>();
			
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
			
			this.moduloDataAccess.setConnexionType(this.connexionType);
			this.moduloDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public Modulo getModulo() throws Exception {	
		ModuloLogicAdditional.checkModuloToGet(modulo,this.datosCliente,this.arrDatoGeneral);
		ModuloLogicAdditional.updateModuloToGet(modulo,this.arrDatoGeneral);
		
		return modulo;
	}
		
	public void setModulo(Modulo newModulo) {
		this.modulo = newModulo;
	}
	
	public ModuloDataAccess getModuloDataAccess() {
		return moduloDataAccess;
	}
	
	public void setModuloDataAccess(ModuloDataAccess newmoduloDataAccess) {
		this.moduloDataAccess = newmoduloDataAccess;
	}
	
	public List<Modulo> getModulos() throws Exception {		
		this.quitarModulosNulos();
		
		ModuloLogicAdditional.checkModuloToGets(modulos,this.datosCliente,this.arrDatoGeneral);
		
		for (Modulo moduloLocal: modulos ) {
			ModuloLogicAdditional.updateModuloToGet(moduloLocal,this.arrDatoGeneral);
		}
		
		return modulos;
	}
	
	public void setModulos(List<Modulo> newModulos) {
		this.modulos = newModulos;
	}
	
	public Object getModuloObject() {	
		this.moduloObject=this.moduloDataAccess.getEntityObject();
		return this.moduloObject;
	}
		
	public void setModuloObject(Object newModuloObject) {
		this.moduloObject = newModuloObject;
	}
	
	public List<Object> getModulosObject() {		
		this.modulosObject=this.moduloDataAccess.getEntitiesObject();
		return this.modulosObject;
	}
		
	public void setModulosObject(List<Object> newModulosObject) {
		this.modulosObject = newModulosObject;
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
		
		if(this.moduloDataAccess!=null) {
			this.moduloDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Modulo.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			moduloDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			moduloDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		modulo = new  Modulo();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Modulo.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			modulo=moduloDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.modulo,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ModuloConstantesFunciones.refrescarForeignKeysDescripcionesModulo(this.modulo);
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
		modulo = new  Modulo();
		  		  
        try {
			
			modulo=moduloDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.modulo,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ModuloConstantesFunciones.refrescarForeignKeysDescripcionesModulo(this.modulo);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		modulo = new  Modulo();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Modulo.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			modulo=moduloDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.modulo,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ModuloConstantesFunciones.refrescarForeignKeysDescripcionesModulo(this.modulo);
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
		modulo = new  Modulo();
		  		  
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
		modulo = new  Modulo();
		  		  
        try {
			
			modulo=moduloDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.modulo,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ModuloConstantesFunciones.refrescarForeignKeysDescripcionesModulo(this.modulo);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		modulo = new  Modulo();
		  		  
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
		modulo = new  Modulo();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Modulo.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =moduloDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		modulo = new  Modulo();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=moduloDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		modulo = new  Modulo();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Modulo.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =moduloDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		modulo = new  Modulo();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=moduloDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		modulo = new  Modulo();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Modulo.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =moduloDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		modulo = new  Modulo();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=moduloDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		modulos = new  ArrayList<Modulo>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Modulo.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			ModuloLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			modulos=moduloDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarModulo(modulos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ModuloConstantesFunciones.refrescarForeignKeysDescripcionesModulo(this.modulos);
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
		modulos = new  ArrayList<Modulo>();
		  		  
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
		modulos = new  ArrayList<Modulo>();
		  		  
        try {			
			ModuloLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			modulos=moduloDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarModulo(modulos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ModuloConstantesFunciones.refrescarForeignKeysDescripcionesModulo(this.modulos);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		modulos = new  ArrayList<Modulo>();
		  		  
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
		modulos = new  ArrayList<Modulo>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Modulo.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			ModuloLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			modulos=moduloDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarModulo(modulos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ModuloConstantesFunciones.refrescarForeignKeysDescripcionesModulo(this.modulos);
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
		modulos = new  ArrayList<Modulo>();
		  		  
        try {
			ModuloLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			modulos=moduloDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarModulo(modulos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ModuloConstantesFunciones.refrescarForeignKeysDescripcionesModulo(this.modulos);
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
		modulos = new  ArrayList<Modulo>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Modulo.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ModuloLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			modulos=moduloDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarModulo(modulos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ModuloConstantesFunciones.refrescarForeignKeysDescripcionesModulo(this.modulos);
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
		modulos = new  ArrayList<Modulo>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ModuloLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			modulos=moduloDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarModulo(modulos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ModuloConstantesFunciones.refrescarForeignKeysDescripcionesModulo(this.modulos);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		modulo = new  Modulo();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Modulo.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ModuloLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			modulo=moduloDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarModulo(modulo);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ModuloConstantesFunciones.refrescarForeignKeysDescripcionesModulo(this.modulo);
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
		modulo = new  Modulo();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ModuloLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			modulo=moduloDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarModulo(modulo);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ModuloConstantesFunciones.refrescarForeignKeysDescripcionesModulo(this.modulo);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		modulos = new  ArrayList<Modulo>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Modulo.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			ModuloLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			modulos=moduloDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarModulo(modulos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ModuloConstantesFunciones.refrescarForeignKeysDescripcionesModulo(this.modulos);
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
		modulos = new  ArrayList<Modulo>();
		  		  
        try {
			ModuloLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			modulos=moduloDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarModulo(modulos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ModuloConstantesFunciones.refrescarForeignKeysDescripcionesModulo(this.modulos);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosModulosWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		modulos = new  ArrayList<Modulo>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Modulo.class.getSimpleName()+"-getTodosModulosWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ModuloLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			modulos=moduloDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarModulo(modulos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ModuloConstantesFunciones.refrescarForeignKeysDescripcionesModulo(this.modulos);
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
	
	public  void  getTodosModulos(String sFinalQuery,Pagination pagination)throws Exception {
		modulos = new  ArrayList<Modulo>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ModuloLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			modulos=moduloDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarModulo(modulos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ModuloConstantesFunciones.refrescarForeignKeysDescripcionesModulo(this.modulos);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarModulo(Modulo modulo) throws Exception {
		Boolean estaValidado=false;
		
		if(modulo.getIsNew() || modulo.getIsChanged()) { 
			this.invalidValues = moduloValidator.getInvalidValues(modulo);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(modulo);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarModulo(List<Modulo> Modulos) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(Modulo moduloLocal:modulos) {				
			estaValidadoObjeto=this.validarGuardarModulo(moduloLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarModulo(List<Modulo> Modulos) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarModulo(modulos)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarModulo(Modulo Modulo) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarModulo(modulo)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(Modulo modulo) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+modulo.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=ModuloConstantesFunciones.getModuloLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"modulo","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(ModuloConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(ModuloConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveModuloWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Modulo.class.getSimpleName()+"-saveModuloWithConnection");connexion.begin();			
			
			ModuloLogicAdditional.checkModuloToSave(this.modulo,this.datosCliente,connexion,this.arrDatoGeneral);
			
			ModuloLogicAdditional.updateModuloToSave(this.modulo,this.arrDatoGeneral);
			
			ModuloLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.modulo,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowModulo();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarModulo(this.modulo)) {
				ModuloDataAccess.save(this.modulo, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.modulo,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			ModuloLogicAdditional.checkModuloToSaveAfter(this.modulo,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowModulo();
			
			connexion.commit();			
			
			if(this.modulo.getIsDeleted()) {
				this.modulo=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveModulo()throws Exception {	
		try {	
			
			ModuloLogicAdditional.checkModuloToSave(this.modulo,this.datosCliente,connexion,this.arrDatoGeneral);
			
			ModuloLogicAdditional.updateModuloToSave(this.modulo,this.arrDatoGeneral);
			
			ModuloLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.modulo,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarModulo(this.modulo)) {			
				ModuloDataAccess.save(this.modulo, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.modulo,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			ModuloLogicAdditional.checkModuloToSaveAfter(this.modulo,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.modulo.getIsDeleted()) {
				this.modulo=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveModulosWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Modulo.class.getSimpleName()+"-saveModulosWithConnection");connexion.begin();			
			
			ModuloLogicAdditional.checkModuloToSaves(modulos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowModulos();
			
			Boolean validadoTodosModulo=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(Modulo moduloLocal:modulos) {		
				if(moduloLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				ModuloLogicAdditional.updateModuloToSave(moduloLocal,this.arrDatoGeneral);
	        	
				ModuloLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),moduloLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarModulo(moduloLocal)) {
					ModuloDataAccess.save(moduloLocal, connexion);				
				} else {
					validadoTodosModulo=false;
				}
			}
			
			if(!validadoTodosModulo) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			ModuloLogicAdditional.checkModuloToSavesAfter(modulos,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowModulos();
			
			connexion.commit();		
			
			this.quitarModulosEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveModulos()throws Exception {				
		 try {	
			ModuloLogicAdditional.checkModuloToSaves(modulos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosModulo=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(Modulo moduloLocal:modulos) {				
				if(moduloLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				ModuloLogicAdditional.updateModuloToSave(moduloLocal,this.arrDatoGeneral);
	        	
				ModuloLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),moduloLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarModulo(moduloLocal)) {				
					ModuloDataAccess.save(moduloLocal, connexion);				
				} else {
					validadoTodosModulo=false;
				}
			}
			
			if(!validadoTodosModulo) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			ModuloLogicAdditional.checkModuloToSavesAfter(modulos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarModulosEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public ModuloParameterReturnGeneral procesarAccionModulos(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<Modulo> modulos,ModuloParameterReturnGeneral moduloParameterGeneral)throws Exception {
		 try {	
			ModuloParameterReturnGeneral moduloReturnGeneral=new ModuloParameterReturnGeneral();
	
			ModuloLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,modulos,moduloParameterGeneral,moduloReturnGeneral);
			
			return moduloReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public ModuloParameterReturnGeneral procesarAccionModulosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<Modulo> modulos,ModuloParameterReturnGeneral moduloParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Modulo.class.getSimpleName()+"-procesarAccionModulosWithConnection");connexion.begin();			
			
			ModuloParameterReturnGeneral moduloReturnGeneral=new ModuloParameterReturnGeneral();
	
			ModuloLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,modulos,moduloParameterGeneral,moduloReturnGeneral);
			
			this.connexion.commit();
			
			return moduloReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public ModuloParameterReturnGeneral procesarEventosModulos(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<Modulo> modulos,Modulo modulo,ModuloParameterReturnGeneral moduloParameterGeneral,Boolean isEsNuevoModulo,ArrayList<Classe> clases)throws Exception {
		 try {	
			ModuloParameterReturnGeneral moduloReturnGeneral=new ModuloParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				moduloReturnGeneral.setConRecargarPropiedades(true);
			}
			
			ModuloLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,modulos,modulo,moduloParameterGeneral,moduloReturnGeneral,isEsNuevoModulo,clases);
			
			return moduloReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public ModuloParameterReturnGeneral procesarEventosModulosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<Modulo> modulos,Modulo modulo,ModuloParameterReturnGeneral moduloParameterGeneral,Boolean isEsNuevoModulo,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Modulo.class.getSimpleName()+"-procesarEventosModulosWithConnection");connexion.begin();			
			
			ModuloParameterReturnGeneral moduloReturnGeneral=new ModuloParameterReturnGeneral();
	
			moduloReturnGeneral.setModulo(modulo);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				moduloReturnGeneral.setConRecargarPropiedades(true);
			}
			
			ModuloLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,modulos,modulo,moduloParameterGeneral,moduloReturnGeneral,isEsNuevoModulo,clases);
			
			this.connexion.commit();
			
			return moduloReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public ModuloParameterReturnGeneral procesarImportacionModulosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,ModuloParameterReturnGeneral moduloParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Modulo.class.getSimpleName()+"-procesarImportacionModulosWithConnection");connexion.begin();			
			
			ModuloParameterReturnGeneral moduloReturnGeneral=new ModuloParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.modulos=new ArrayList<Modulo>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.modulo=new Modulo();
				
				
				if(conColumnasBase) {this.modulo.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.modulo.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.modulo.setcodigo(arrColumnas[iColumn++]);
				this.modulo.setnombre(arrColumnas[iColumn++]);
				this.modulo.settecla(arrColumnas[iColumn++]);
				this.modulo.setestado(Boolean.parseBoolean(arrColumnas[iColumn++]));
				this.modulo.setorden(Integer.parseInt(arrColumnas[iColumn++]));
			this.modulo.setdescripcion(arrColumnas[iColumn++]);
				
				this.modulos.add(this.modulo);
			}
			
			this.saveModulos();
			
			this.connexion.commit();
			
			moduloReturnGeneral.setConRetornoEstaProcesado(true);
			moduloReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return moduloReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarModulosEliminados() throws Exception {				
		
		List<Modulo> modulosAux= new ArrayList<Modulo>();
		
		for(Modulo modulo:modulos) {
			if(!modulo.getIsDeleted()) {
				modulosAux.add(modulo);
			}
		}
		
		modulos=modulosAux;
	}
	
	public void quitarModulosNulos() throws Exception {				
		
		List<Modulo> modulosAux= new ArrayList<Modulo>();
		
		for(Modulo modulo : this.modulos) {
			if(modulo==null) {
				modulosAux.add(modulo);
			}
		}
		
		//this.modulos=modulosAux;
		
		this.modulos.removeAll(modulosAux);
	}
	
	public void getSetVersionRowModuloWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(modulo.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((modulo.getIsDeleted() || (modulo.getIsChanged()&&!modulo.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=moduloDataAccess.getSetVersionRowModulo(connexion,modulo.getId());
				
				if(!modulo.getVersionRow().equals(timestamp)) {	
					modulo.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				modulo.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowModulo()throws Exception {	
		
		if(modulo.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((modulo.getIsDeleted() || (modulo.getIsChanged()&&!modulo.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=moduloDataAccess.getSetVersionRowModulo(connexion,modulo.getId());
			
			try {							
				if(!modulo.getVersionRow().equals(timestamp)) {	
					modulo.setVersionRow(timestamp);
				}
				
				modulo.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowModulosWithConnection()throws Exception {	
		if(modulos!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(Modulo moduloAux:modulos) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(moduloAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(moduloAux.getIsDeleted() || (moduloAux.getIsChanged()&&!moduloAux.getIsNew())) {
						
						timestamp=moduloDataAccess.getSetVersionRowModulo(connexion,moduloAux.getId());
						
						if(!modulo.getVersionRow().equals(timestamp)) {	
							moduloAux.setVersionRow(timestamp);
						}
								
						moduloAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowModulos()throws Exception {	
		if(modulos!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(Modulo moduloAux:modulos) {
					if(moduloAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(moduloAux.getIsDeleted() || (moduloAux.getIsChanged()&&!moduloAux.getIsNew())) {
						
						timestamp=moduloDataAccess.getSetVersionRowModulo(connexion,moduloAux.getId());
						
						if(!moduloAux.getVersionRow().equals(timestamp)) {	
							moduloAux.setVersionRow(timestamp);
						}
						
													
						moduloAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public ModuloParameterReturnGeneral cargarCombosLoteForeignKeyModuloWithConnection(String finalQueryGlobalSistema,String finalQueryGlobalPaquete,String finalQueryGlobalTipoTeclaMascara) throws Exception {
		ModuloParameterReturnGeneral  moduloReturnGeneral =new ModuloParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Modulo.class.getSimpleName()+"-cargarCombosLoteForeignKeyModuloWithConnection");connexion.begin();
			
			moduloReturnGeneral =new ModuloParameterReturnGeneral();
			
			

			List<Sistema> sistemasForeignKey=new ArrayList<Sistema>();
			SistemaLogic sistemaLogic=new SistemaLogic();
			sistemaLogic.setConnexion(this.connexion);
			sistemaLogic.getSistemaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSistema.equals("NONE")) {
				sistemaLogic.getTodosSistemas(finalQueryGlobalSistema,new Pagination());
				sistemasForeignKey=sistemaLogic.getSistemas();
			}

			moduloReturnGeneral.setsistemasForeignKey(sistemasForeignKey);


			List<Paquete> paquetesForeignKey=new ArrayList<Paquete>();
			PaqueteLogic paqueteLogic=new PaqueteLogic();
			paqueteLogic.setConnexion(this.connexion);
			paqueteLogic.getPaqueteDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPaquete.equals("NONE")) {
				paqueteLogic.getTodosPaquetes(finalQueryGlobalPaquete,new Pagination());
				paquetesForeignKey=paqueteLogic.getPaquetes();
			}

			moduloReturnGeneral.setpaquetesForeignKey(paquetesForeignKey);


			List<TipoTeclaMascara> tipoteclamascarasForeignKey=new ArrayList<TipoTeclaMascara>();
			TipoTeclaMascaraLogic tipoteclamascaraLogic=new TipoTeclaMascaraLogic();
			tipoteclamascaraLogic.setConnexion(this.connexion);
			tipoteclamascaraLogic.getTipoTeclaMascaraDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoTeclaMascara.equals("NONE")) {
				tipoteclamascaraLogic.getTodosTipoTeclaMascaras(finalQueryGlobalTipoTeclaMascara,new Pagination());
				tipoteclamascarasForeignKey=tipoteclamascaraLogic.getTipoTeclaMascaras();
			}

			moduloReturnGeneral.settipoteclamascarasForeignKey(tipoteclamascarasForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return moduloReturnGeneral;
	}
	
	public ModuloParameterReturnGeneral cargarCombosLoteForeignKeyModulo(String finalQueryGlobalSistema,String finalQueryGlobalPaquete,String finalQueryGlobalTipoTeclaMascara) throws Exception {
		ModuloParameterReturnGeneral  moduloReturnGeneral =new ModuloParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			moduloReturnGeneral =new ModuloParameterReturnGeneral();
			
			

			List<Sistema> sistemasForeignKey=new ArrayList<Sistema>();
			SistemaLogic sistemaLogic=new SistemaLogic();
			sistemaLogic.setConnexion(this.connexion);
			sistemaLogic.getSistemaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSistema.equals("NONE")) {
				sistemaLogic.getTodosSistemas(finalQueryGlobalSistema,new Pagination());
				sistemasForeignKey=sistemaLogic.getSistemas();
			}

			moduloReturnGeneral.setsistemasForeignKey(sistemasForeignKey);


			List<Paquete> paquetesForeignKey=new ArrayList<Paquete>();
			PaqueteLogic paqueteLogic=new PaqueteLogic();
			paqueteLogic.setConnexion(this.connexion);
			paqueteLogic.getPaqueteDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPaquete.equals("NONE")) {
				paqueteLogic.getTodosPaquetes(finalQueryGlobalPaquete,new Pagination());
				paquetesForeignKey=paqueteLogic.getPaquetes();
			}

			moduloReturnGeneral.setpaquetesForeignKey(paquetesForeignKey);


			List<TipoTeclaMascara> tipoteclamascarasForeignKey=new ArrayList<TipoTeclaMascara>();
			TipoTeclaMascaraLogic tipoteclamascaraLogic=new TipoTeclaMascaraLogic();
			tipoteclamascaraLogic.setConnexion(this.connexion);
			tipoteclamascaraLogic.getTipoTeclaMascaraDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoTeclaMascara.equals("NONE")) {
				tipoteclamascaraLogic.getTodosTipoTeclaMascaras(finalQueryGlobalTipoTeclaMascara,new Pagination());
				tipoteclamascarasForeignKey=tipoteclamascaraLogic.getTipoTeclaMascaras();
			}

			moduloReturnGeneral.settipoteclamascarasForeignKey(tipoteclamascarasForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return moduloReturnGeneral;
	}
	
	
	public void deepLoad(Modulo modulo,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			ModuloLogicAdditional.updateModuloToGet(modulo,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		modulo.setSistema(moduloDataAccess.getSistema(connexion,modulo));
		modulo.setPaquete(moduloDataAccess.getPaquete(connexion,modulo));
		modulo.setTipoTeclaMascara(moduloDataAccess.getTipoTeclaMascara(connexion,modulo));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Sistema.class)) {
				modulo.setSistema(moduloDataAccess.getSistema(connexion,modulo));
				continue;
			}

			if(clas.clas.equals(Paquete.class)) {
				modulo.setPaquete(moduloDataAccess.getPaquete(connexion,modulo));
				continue;
			}

			if(clas.clas.equals(TipoTeclaMascara.class)) {
				modulo.setTipoTeclaMascara(moduloDataAccess.getTipoTeclaMascara(connexion,modulo));
				continue;
			}
		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Sistema.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			modulo.setSistema(moduloDataAccess.getSistema(connexion,modulo));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Paquete.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			modulo.setPaquete(moduloDataAccess.getPaquete(connexion,modulo));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoTeclaMascara.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			modulo.setTipoTeclaMascara(moduloDataAccess.getTipoTeclaMascara(connexion,modulo));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		modulo.setSistema(moduloDataAccess.getSistema(connexion,modulo));
		SistemaLogic sistemaLogic= new SistemaLogic(connexion);
		sistemaLogic.deepLoad(modulo.getSistema(),isDeep,deepLoadType,clases);
				
		modulo.setPaquete(moduloDataAccess.getPaquete(connexion,modulo));
		PaqueteLogic paqueteLogic= new PaqueteLogic(connexion);
		paqueteLogic.deepLoad(modulo.getPaquete(),isDeep,deepLoadType,clases);
				
		modulo.setTipoTeclaMascara(moduloDataAccess.getTipoTeclaMascara(connexion,modulo));
		TipoTeclaMascaraLogic tipoteclamascaraLogic= new TipoTeclaMascaraLogic(connexion);
		tipoteclamascaraLogic.deepLoad(modulo.getTipoTeclaMascara(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Sistema.class)) {
				modulo.setSistema(moduloDataAccess.getSistema(connexion,modulo));
				SistemaLogic sistemaLogic= new SistemaLogic(connexion);
				sistemaLogic.deepLoad(modulo.getSistema(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Paquete.class)) {
				modulo.setPaquete(moduloDataAccess.getPaquete(connexion,modulo));
				PaqueteLogic paqueteLogic= new PaqueteLogic(connexion);
				paqueteLogic.deepLoad(modulo.getPaquete(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoTeclaMascara.class)) {
				modulo.setTipoTeclaMascara(moduloDataAccess.getTipoTeclaMascara(connexion,modulo));
				TipoTeclaMascaraLogic tipoteclamascaraLogic= new TipoTeclaMascaraLogic(connexion);
				tipoteclamascaraLogic.deepLoad(modulo.getTipoTeclaMascara(),isDeep,deepLoadType,clases);				
				continue;
			}

		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {


		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Sistema.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			modulo.setSistema(moduloDataAccess.getSistema(connexion,modulo));
			SistemaLogic sistemaLogic= new SistemaLogic(connexion);
			sistemaLogic.deepLoad(modulo.getSistema(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Paquete.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			modulo.setPaquete(moduloDataAccess.getPaquete(connexion,modulo));
			PaqueteLogic paqueteLogic= new PaqueteLogic(connexion);
			paqueteLogic.deepLoad(modulo.getPaquete(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoTeclaMascara.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			modulo.setTipoTeclaMascara(moduloDataAccess.getTipoTeclaMascara(connexion,modulo));
			TipoTeclaMascaraLogic tipoteclamascaraLogic= new TipoTeclaMascaraLogic(connexion);
			tipoteclamascaraLogic.deepLoad(modulo.getTipoTeclaMascara(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(Modulo modulo,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			ModuloLogicAdditional.updateModuloToSave(modulo,this.arrDatoGeneral);
			
ModuloDataAccess.save(modulo, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		SistemaDataAccess.save(modulo.getSistema(),connexion);

		PaqueteDataAccess.save(modulo.getPaquete(),connexion);

		TipoTeclaMascaraDataAccess.save(modulo.getTipoTeclaMascara(),connexion);
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Sistema.class)) {
				SistemaDataAccess.save(modulo.getSistema(),connexion);
				continue;
			}

			if(clas.clas.equals(Paquete.class)) {
				PaqueteDataAccess.save(modulo.getPaquete(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoTeclaMascara.class)) {
				TipoTeclaMascaraDataAccess.save(modulo.getTipoTeclaMascara(),connexion);
				continue;
			}

		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		SistemaDataAccess.save(modulo.getSistema(),connexion);
		SistemaLogic sistemaLogic= new SistemaLogic(connexion);
		sistemaLogic.deepLoad(modulo.getSistema(),isDeep,deepLoadType,clases);
				

		PaqueteDataAccess.save(modulo.getPaquete(),connexion);
		PaqueteLogic paqueteLogic= new PaqueteLogic(connexion);
		paqueteLogic.deepLoad(modulo.getPaquete(),isDeep,deepLoadType,clases);
				

		TipoTeclaMascaraDataAccess.save(modulo.getTipoTeclaMascara(),connexion);
		TipoTeclaMascaraLogic tipoteclamascaraLogic= new TipoTeclaMascaraLogic(connexion);
		tipoteclamascaraLogic.deepLoad(modulo.getTipoTeclaMascara(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Sistema.class)) {
				SistemaDataAccess.save(modulo.getSistema(),connexion);
				SistemaLogic sistemaLogic= new SistemaLogic(connexion);
				sistemaLogic.deepSave(modulo.getSistema(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Paquete.class)) {
				PaqueteDataAccess.save(modulo.getPaquete(),connexion);
				PaqueteLogic paqueteLogic= new PaqueteLogic(connexion);
				paqueteLogic.deepSave(modulo.getPaquete(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoTeclaMascara.class)) {
				TipoTeclaMascaraDataAccess.save(modulo.getTipoTeclaMascara(),connexion);
				TipoTeclaMascaraLogic tipoteclamascaraLogic= new TipoTeclaMascaraLogic(connexion);
				tipoteclamascaraLogic.deepSave(modulo.getTipoTeclaMascara(),isDeep,deepLoadType,clases);				
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
			this.getNewConnexionToDeep(Modulo.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(modulo,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				ModuloConstantesFunciones.refrescarForeignKeysDescripcionesModulo(modulo);
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
			this.deepLoad(this.modulo,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				ModuloConstantesFunciones.refrescarForeignKeysDescripcionesModulo(this.modulo);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(Modulo.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(modulos!=null) {
				for(Modulo modulo:modulos) {
					this.deepLoad(modulo,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					ModuloConstantesFunciones.refrescarForeignKeysDescripcionesModulo(modulos);
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
			if(modulos!=null) {
				for(Modulo modulo:modulos) {
					this.deepLoad(modulo,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					ModuloConstantesFunciones.refrescarForeignKeysDescripcionesModulo(modulos);
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
			this.getNewConnexionToDeep(Modulo.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(modulo,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(Modulo.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(modulos!=null) {
				for(Modulo modulo:modulos) {
					this.deepSave(modulo,isDeep,deepLoadType,clases);
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
			if(modulos!=null) {
				for(Modulo modulo:modulos) {
					this.deepSave(modulo,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getModulosBusquedaPorIdSistemaPorNombreWithConnection(String sFinalQuery,Pagination pagination,Long id_sistema,String nombre)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Modulo.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSistema= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSistema.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sistema,ModuloConstantesFunciones.IDSISTEMA,ParameterTypeOperator.AND);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSistema);

			ParameterSelectionGeneral parameterSelectionGeneralNombre= new ParameterSelectionGeneral();
			parameterSelectionGeneralNombre.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+nombre+"%",ModuloConstantesFunciones.NOMBRE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNombre);

			ModuloLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorIdSistemaPorNombre","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			modulos=moduloDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ModuloConstantesFunciones.refrescarForeignKeysDescripcionesModulo(this.modulos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getModulosBusquedaPorIdSistemaPorNombre(String sFinalQuery,Pagination pagination,Long id_sistema,String nombre)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSistema= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSistema.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sistema,ModuloConstantesFunciones.IDSISTEMA,ParameterTypeOperator.AND);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSistema);

			ParameterSelectionGeneral parameterSelectionGeneralNombre= new ParameterSelectionGeneral();
			parameterSelectionGeneralNombre.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+nombre+"%",ModuloConstantesFunciones.NOMBRE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNombre);

			ModuloLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorIdSistemaPorNombre","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			modulos=moduloDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ModuloConstantesFunciones.refrescarForeignKeysDescripcionesModulo(this.modulos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getModulosFK_IdPaqueteWithConnection(String sFinalQuery,Pagination pagination,Long id_paquete)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Modulo.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPaquete= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPaquete.setParameterSelectionGeneralEqual(ParameterType.LONG,id_paquete,ModuloConstantesFunciones.IDPAQUETE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPaquete);

			ModuloLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPaquete","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			modulos=moduloDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ModuloConstantesFunciones.refrescarForeignKeysDescripcionesModulo(this.modulos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getModulosFK_IdPaquete(String sFinalQuery,Pagination pagination,Long id_paquete)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPaquete= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPaquete.setParameterSelectionGeneralEqual(ParameterType.LONG,id_paquete,ModuloConstantesFunciones.IDPAQUETE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPaquete);

			ModuloLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPaquete","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			modulos=moduloDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ModuloConstantesFunciones.refrescarForeignKeysDescripcionesModulo(this.modulos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getModulosFK_IdSistemaWithConnection(String sFinalQuery,Pagination pagination,Long id_sistema)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Modulo.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSistema= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSistema.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sistema,ModuloConstantesFunciones.IDSISTEMA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSistema);

			ModuloLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSistema","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			modulos=moduloDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ModuloConstantesFunciones.refrescarForeignKeysDescripcionesModulo(this.modulos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getModulosFK_IdSistema(String sFinalQuery,Pagination pagination,Long id_sistema)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSistema= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSistema.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sistema,ModuloConstantesFunciones.IDSISTEMA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSistema);

			ModuloLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSistema","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			modulos=moduloDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ModuloConstantesFunciones.refrescarForeignKeysDescripcionesModulo(this.modulos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getModulosFK_IdTipoTeclaMascaraWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_tecla_mascara)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Modulo.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoTeclaMascara= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoTeclaMascara.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_tecla_mascara,ModuloConstantesFunciones.IDTIPOTECLAMASCARA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoTeclaMascara);

			ModuloLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoTeclaMascara","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			modulos=moduloDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ModuloConstantesFunciones.refrescarForeignKeysDescripcionesModulo(this.modulos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getModulosFK_IdTipoTeclaMascara(String sFinalQuery,Pagination pagination,Long id_tipo_tecla_mascara)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoTeclaMascara= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoTeclaMascara.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_tecla_mascara,ModuloConstantesFunciones.IDTIPOTECLAMASCARA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoTeclaMascara);

			ModuloLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoTeclaMascara","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			modulos=moduloDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ModuloConstantesFunciones.refrescarForeignKeysDescripcionesModulo(this.modulos);
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
			if(ModuloConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,ModuloDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,Modulo modulo,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(ModuloConstantesFunciones.ISCONAUDITORIA) {
				if(modulo.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,ModuloDataAccess.TABLENAME, modulo.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(ModuloConstantesFunciones.ISCONAUDITORIADETALLE) {
						////ModuloLogic.registrarAuditoriaDetallesModulo(connexion,modulo,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(modulo.getIsDeleted()) {
					/*if(!modulo.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,ModuloDataAccess.TABLENAME, modulo.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////ModuloLogic.registrarAuditoriaDetallesModulo(connexion,modulo,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,ModuloDataAccess.TABLENAME, modulo.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(modulo.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,ModuloDataAccess.TABLENAME, modulo.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(ModuloConstantesFunciones.ISCONAUDITORIADETALLE) {
						////ModuloLogic.registrarAuditoriaDetallesModulo(connexion,modulo,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesModulo(Connexion connexion,Modulo modulo)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(modulo.getIsNew()||!modulo.getid_sistema().equals(modulo.getModuloOriginal().getid_sistema()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(modulo.getModuloOriginal().getid_sistema()!=null)
				{
					strValorActual=modulo.getModuloOriginal().getid_sistema().toString();
				}
				if(modulo.getid_sistema()!=null)
				{
					strValorNuevo=modulo.getid_sistema().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ModuloConstantesFunciones.IDSISTEMA,strValorActual,strValorNuevo);
			}	
			
			if(modulo.getIsNew()||!modulo.getid_paquete().equals(modulo.getModuloOriginal().getid_paquete()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(modulo.getModuloOriginal().getid_paquete()!=null)
				{
					strValorActual=modulo.getModuloOriginal().getid_paquete().toString();
				}
				if(modulo.getid_paquete()!=null)
				{
					strValorNuevo=modulo.getid_paquete().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ModuloConstantesFunciones.IDPAQUETE,strValorActual,strValorNuevo);
			}	
			
			if(modulo.getIsNew()||!modulo.getcodigo().equals(modulo.getModuloOriginal().getcodigo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(modulo.getModuloOriginal().getcodigo()!=null)
				{
					strValorActual=modulo.getModuloOriginal().getcodigo();
				}
				if(modulo.getcodigo()!=null)
				{
					strValorNuevo=modulo.getcodigo() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ModuloConstantesFunciones.CODIGO,strValorActual,strValorNuevo);
			}	
			
			if(modulo.getIsNew()||!modulo.getnombre().equals(modulo.getModuloOriginal().getnombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(modulo.getModuloOriginal().getnombre()!=null)
				{
					strValorActual=modulo.getModuloOriginal().getnombre();
				}
				if(modulo.getnombre()!=null)
				{
					strValorNuevo=modulo.getnombre() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ModuloConstantesFunciones.NOMBRE,strValorActual,strValorNuevo);
			}	
			
			if(modulo.getIsNew()||!modulo.getid_tipo_tecla_mascara().equals(modulo.getModuloOriginal().getid_tipo_tecla_mascara()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(modulo.getModuloOriginal().getid_tipo_tecla_mascara()!=null)
				{
					strValorActual=modulo.getModuloOriginal().getid_tipo_tecla_mascara().toString();
				}
				if(modulo.getid_tipo_tecla_mascara()!=null)
				{
					strValorNuevo=modulo.getid_tipo_tecla_mascara().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ModuloConstantesFunciones.IDTIPOTECLAMASCARA,strValorActual,strValorNuevo);
			}	
			
			if(modulo.getIsNew()||!modulo.gettecla().equals(modulo.getModuloOriginal().gettecla()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(modulo.getModuloOriginal().gettecla()!=null)
				{
					strValorActual=modulo.getModuloOriginal().gettecla();
				}
				if(modulo.gettecla()!=null)
				{
					strValorNuevo=modulo.gettecla() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ModuloConstantesFunciones.TECLA,strValorActual,strValorNuevo);
			}	
			
			if(modulo.getIsNew()||!modulo.getestado().equals(modulo.getModuloOriginal().getestado()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(modulo.getModuloOriginal().getestado()!=null)
				{
					strValorActual=modulo.getModuloOriginal().getestado().toString();
				}
				if(modulo.getestado()!=null)
				{
					strValorNuevo=modulo.getestado().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ModuloConstantesFunciones.ESTADO,strValorActual,strValorNuevo);
			}	
			
			if(modulo.getIsNew()||!modulo.getorden().equals(modulo.getModuloOriginal().getorden()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(modulo.getModuloOriginal().getorden()!=null)
				{
					strValorActual=modulo.getModuloOriginal().getorden().toString();
				}
				if(modulo.getorden()!=null)
				{
					strValorNuevo=modulo.getorden().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ModuloConstantesFunciones.ORDEN,strValorActual,strValorNuevo);
			}	
			
			if(modulo.getIsNew()||!modulo.getdescripcion().equals(modulo.getModuloOriginal().getdescripcion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(modulo.getModuloOriginal().getdescripcion()!=null)
				{
					strValorActual=modulo.getModuloOriginal().getdescripcion();
				}
				if(modulo.getdescripcion()!=null)
				{
					strValorNuevo=modulo.getdescripcion() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ModuloConstantesFunciones.DESCRIPCION,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveModuloRelacionesWithConnection(Modulo modulo) throws Exception {

		if(!modulo.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveModuloRelacionesBase(modulo,true);
		}
	}

	public void saveModuloRelaciones(Modulo modulo)throws Exception {

		if(!modulo.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveModuloRelacionesBase(modulo,false);
		}
	}

	public void saveModuloRelacionesBase(Modulo modulo,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("Modulo-saveRelacionesWithConnection");}
	

			this.setModulo(modulo);

				if((modulo.getIsNew()||modulo.getIsChanged())&&!modulo.getIsDeleted()) {
					this.saveModulo();
					this.saveModuloRelacionesDetalles();

				} else if(modulo.getIsDeleted()) {
					this.saveModuloRelacionesDetalles();
					this.saveModulo();
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
	
	
	private void saveModuloRelacionesDetalles()throws Exception {
		try {
	

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfModulo(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=ModuloConstantesFunciones.getClassesForeignKeysOfModulo(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfModulo(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=ModuloConstantesFunciones.getClassesRelationshipsOfModulo(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

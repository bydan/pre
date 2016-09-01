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
import com.bydan.erp.seguridad.util.PerfilOpcionConstantesFunciones;
import com.bydan.erp.seguridad.util.PerfilOpcionParameterReturnGeneral;
//import com.bydan.erp.seguridad.util.PerfilOpcionParameterGeneral;
import com.bydan.erp.seguridad.business.entity.PerfilOpcion;
import com.bydan.erp.seguridad.business.logic.PerfilOpcionLogicAdditional;
import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.seguridad.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;
















@SuppressWarnings("unused")
public class PerfilOpcionLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(PerfilOpcionLogic.class);
	
	protected PerfilOpcionDataAccess perfilopcionDataAccess; 	
	protected PerfilOpcion perfilopcion;
	protected List<PerfilOpcion> perfilopcions;
	protected Object perfilopcionObject;	
	protected List<Object> perfilopcionsObject;
	
	public static ClassValidator<PerfilOpcion> perfilopcionValidator = new ClassValidator<PerfilOpcion>(PerfilOpcion.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected PerfilOpcionLogicAdditional perfilopcionLogicAdditional=null;
	
	public PerfilOpcionLogicAdditional getPerfilOpcionLogicAdditional() {
		return this.perfilopcionLogicAdditional;
	}
	
	public void setPerfilOpcionLogicAdditional(PerfilOpcionLogicAdditional perfilopcionLogicAdditional) {
		try {
			this.perfilopcionLogicAdditional=perfilopcionLogicAdditional;
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
	
	
	
	
	public  PerfilOpcionLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.perfilopcionDataAccess = new PerfilOpcionDataAccess();
			
			this.perfilopcions= new ArrayList<PerfilOpcion>();
			this.perfilopcion= new PerfilOpcion();
			
			this.perfilopcionObject=new Object();
			this.perfilopcionsObject=new ArrayList<Object>();
				
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
			
			this.perfilopcionDataAccess.setConnexionType(this.connexionType);
			this.perfilopcionDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  PerfilOpcionLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.perfilopcionDataAccess = new PerfilOpcionDataAccess();
			this.perfilopcions= new ArrayList<PerfilOpcion>();
			this.perfilopcion= new PerfilOpcion();
			this.perfilopcionObject=new Object();
			this.perfilopcionsObject=new ArrayList<Object>();
			
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
			
			this.perfilopcionDataAccess.setConnexionType(this.connexionType);
			this.perfilopcionDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public PerfilOpcion getPerfilOpcion() throws Exception {	
		PerfilOpcionLogicAdditional.checkPerfilOpcionToGet(perfilopcion,this.datosCliente,this.arrDatoGeneral);
		PerfilOpcionLogicAdditional.updatePerfilOpcionToGet(perfilopcion,this.arrDatoGeneral);
		
		return perfilopcion;
	}
		
	public void setPerfilOpcion(PerfilOpcion newPerfilOpcion) {
		this.perfilopcion = newPerfilOpcion;
	}
	
	public PerfilOpcionDataAccess getPerfilOpcionDataAccess() {
		return perfilopcionDataAccess;
	}
	
	public void setPerfilOpcionDataAccess(PerfilOpcionDataAccess newperfilopcionDataAccess) {
		this.perfilopcionDataAccess = newperfilopcionDataAccess;
	}
	
	public List<PerfilOpcion> getPerfilOpcions() throws Exception {		
		this.quitarPerfilOpcionsNulos();
		
		PerfilOpcionLogicAdditional.checkPerfilOpcionToGets(perfilopcions,this.datosCliente,this.arrDatoGeneral);
		
		for (PerfilOpcion perfilopcionLocal: perfilopcions ) {
			PerfilOpcionLogicAdditional.updatePerfilOpcionToGet(perfilopcionLocal,this.arrDatoGeneral);
		}
		
		return perfilopcions;
	}
	
	public void setPerfilOpcions(List<PerfilOpcion> newPerfilOpcions) {
		this.perfilopcions = newPerfilOpcions;
	}
	
	public Object getPerfilOpcionObject() {	
		this.perfilopcionObject=this.perfilopcionDataAccess.getEntityObject();
		return this.perfilopcionObject;
	}
		
	public void setPerfilOpcionObject(Object newPerfilOpcionObject) {
		this.perfilopcionObject = newPerfilOpcionObject;
	}
	
	public List<Object> getPerfilOpcionsObject() {		
		this.perfilopcionsObject=this.perfilopcionDataAccess.getEntitiesObject();
		return this.perfilopcionsObject;
	}
		
	public void setPerfilOpcionsObject(List<Object> newPerfilOpcionsObject) {
		this.perfilopcionsObject = newPerfilOpcionsObject;
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
		
		if(this.perfilopcionDataAccess!=null) {
			this.perfilopcionDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PerfilOpcion.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			perfilopcionDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			perfilopcionDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		perfilopcion = new  PerfilOpcion();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PerfilOpcion.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			perfilopcion=perfilopcionDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.perfilopcion,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				PerfilOpcionConstantesFunciones.refrescarForeignKeysDescripcionesPerfilOpcion(this.perfilopcion);
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
		perfilopcion = new  PerfilOpcion();
		  		  
        try {
			
			perfilopcion=perfilopcionDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.perfilopcion,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				PerfilOpcionConstantesFunciones.refrescarForeignKeysDescripcionesPerfilOpcion(this.perfilopcion);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		perfilopcion = new  PerfilOpcion();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PerfilOpcion.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			perfilopcion=perfilopcionDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.perfilopcion,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				PerfilOpcionConstantesFunciones.refrescarForeignKeysDescripcionesPerfilOpcion(this.perfilopcion);
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
		perfilopcion = new  PerfilOpcion();
		  		  
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
		perfilopcion = new  PerfilOpcion();
		  		  
        try {
			
			perfilopcion=perfilopcionDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.perfilopcion,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				PerfilOpcionConstantesFunciones.refrescarForeignKeysDescripcionesPerfilOpcion(this.perfilopcion);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		perfilopcion = new  PerfilOpcion();
		  		  
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
		perfilopcion = new  PerfilOpcion();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PerfilOpcion.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =perfilopcionDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		perfilopcion = new  PerfilOpcion();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=perfilopcionDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		perfilopcion = new  PerfilOpcion();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PerfilOpcion.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =perfilopcionDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		perfilopcion = new  PerfilOpcion();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=perfilopcionDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		perfilopcion = new  PerfilOpcion();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PerfilOpcion.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =perfilopcionDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		perfilopcion = new  PerfilOpcion();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=perfilopcionDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		perfilopcions = new  ArrayList<PerfilOpcion>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PerfilOpcion.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			PerfilOpcionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			perfilopcions=perfilopcionDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarPerfilOpcion(perfilopcions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PerfilOpcionConstantesFunciones.refrescarForeignKeysDescripcionesPerfilOpcion(this.perfilopcions);
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
		perfilopcions = new  ArrayList<PerfilOpcion>();
		  		  
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
		perfilopcions = new  ArrayList<PerfilOpcion>();
		  		  
        try {			
			PerfilOpcionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			perfilopcions=perfilopcionDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarPerfilOpcion(perfilopcions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PerfilOpcionConstantesFunciones.refrescarForeignKeysDescripcionesPerfilOpcion(this.perfilopcions);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		perfilopcions = new  ArrayList<PerfilOpcion>();
		  		  
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
		perfilopcions = new  ArrayList<PerfilOpcion>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PerfilOpcion.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			PerfilOpcionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			perfilopcions=perfilopcionDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarPerfilOpcion(perfilopcions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PerfilOpcionConstantesFunciones.refrescarForeignKeysDescripcionesPerfilOpcion(this.perfilopcions);
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
		perfilopcions = new  ArrayList<PerfilOpcion>();
		  		  
        try {
			PerfilOpcionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			perfilopcions=perfilopcionDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarPerfilOpcion(perfilopcions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PerfilOpcionConstantesFunciones.refrescarForeignKeysDescripcionesPerfilOpcion(this.perfilopcions);
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
		perfilopcions = new  ArrayList<PerfilOpcion>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PerfilOpcion.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			PerfilOpcionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			perfilopcions=perfilopcionDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarPerfilOpcion(perfilopcions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PerfilOpcionConstantesFunciones.refrescarForeignKeysDescripcionesPerfilOpcion(this.perfilopcions);
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
		perfilopcions = new  ArrayList<PerfilOpcion>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			PerfilOpcionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			perfilopcions=perfilopcionDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarPerfilOpcion(perfilopcions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PerfilOpcionConstantesFunciones.refrescarForeignKeysDescripcionesPerfilOpcion(this.perfilopcions);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		perfilopcion = new  PerfilOpcion();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PerfilOpcion.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			PerfilOpcionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			perfilopcion=perfilopcionDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarPerfilOpcion(perfilopcion);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PerfilOpcionConstantesFunciones.refrescarForeignKeysDescripcionesPerfilOpcion(this.perfilopcion);
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
		perfilopcion = new  PerfilOpcion();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			PerfilOpcionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			perfilopcion=perfilopcionDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarPerfilOpcion(perfilopcion);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PerfilOpcionConstantesFunciones.refrescarForeignKeysDescripcionesPerfilOpcion(this.perfilopcion);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		perfilopcions = new  ArrayList<PerfilOpcion>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PerfilOpcion.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			PerfilOpcionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			perfilopcions=perfilopcionDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarPerfilOpcion(perfilopcions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PerfilOpcionConstantesFunciones.refrescarForeignKeysDescripcionesPerfilOpcion(this.perfilopcions);
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
		perfilopcions = new  ArrayList<PerfilOpcion>();
		  		  
        try {
			PerfilOpcionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			perfilopcions=perfilopcionDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarPerfilOpcion(perfilopcions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PerfilOpcionConstantesFunciones.refrescarForeignKeysDescripcionesPerfilOpcion(this.perfilopcions);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosPerfilOpcionsWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		perfilopcions = new  ArrayList<PerfilOpcion>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PerfilOpcion.class.getSimpleName()+"-getTodosPerfilOpcionsWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			PerfilOpcionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			perfilopcions=perfilopcionDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarPerfilOpcion(perfilopcions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PerfilOpcionConstantesFunciones.refrescarForeignKeysDescripcionesPerfilOpcion(this.perfilopcions);
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
	
	public  void  getTodosPerfilOpcions(String sFinalQuery,Pagination pagination)throws Exception {
		perfilopcions = new  ArrayList<PerfilOpcion>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			PerfilOpcionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			perfilopcions=perfilopcionDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarPerfilOpcion(perfilopcions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PerfilOpcionConstantesFunciones.refrescarForeignKeysDescripcionesPerfilOpcion(this.perfilopcions);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarPerfilOpcion(PerfilOpcion perfilopcion) throws Exception {
		Boolean estaValidado=false;
		
		if(perfilopcion.getIsNew() || perfilopcion.getIsChanged()) { 
			this.invalidValues = perfilopcionValidator.getInvalidValues(perfilopcion);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(perfilopcion);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarPerfilOpcion(List<PerfilOpcion> PerfilOpcions) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(PerfilOpcion perfilopcionLocal:perfilopcions) {				
			estaValidadoObjeto=this.validarGuardarPerfilOpcion(perfilopcionLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarPerfilOpcion(List<PerfilOpcion> PerfilOpcions) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarPerfilOpcion(perfilopcions)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarPerfilOpcion(PerfilOpcion PerfilOpcion) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarPerfilOpcion(perfilopcion)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(PerfilOpcion perfilopcion) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+perfilopcion.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=PerfilOpcionConstantesFunciones.getPerfilOpcionLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"perfilopcion","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(PerfilOpcionConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(PerfilOpcionConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void savePerfilOpcionWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PerfilOpcion.class.getSimpleName()+"-savePerfilOpcionWithConnection");connexion.begin();			
			
			PerfilOpcionLogicAdditional.checkPerfilOpcionToSave(this.perfilopcion,this.datosCliente,connexion,this.arrDatoGeneral);
			
			PerfilOpcionLogicAdditional.updatePerfilOpcionToSave(this.perfilopcion,this.arrDatoGeneral);
			
			PerfilOpcionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.perfilopcion,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowPerfilOpcion();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarPerfilOpcion(this.perfilopcion)) {
				PerfilOpcionDataAccess.save(this.perfilopcion, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.perfilopcion,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			PerfilOpcionLogicAdditional.checkPerfilOpcionToSaveAfter(this.perfilopcion,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowPerfilOpcion();
			
			connexion.commit();			
			
			if(this.perfilopcion.getIsDeleted()) {
				this.perfilopcion=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void savePerfilOpcion()throws Exception {	
		try {	
			
			PerfilOpcionLogicAdditional.checkPerfilOpcionToSave(this.perfilopcion,this.datosCliente,connexion,this.arrDatoGeneral);
			
			PerfilOpcionLogicAdditional.updatePerfilOpcionToSave(this.perfilopcion,this.arrDatoGeneral);
			
			PerfilOpcionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.perfilopcion,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarPerfilOpcion(this.perfilopcion)) {			
				PerfilOpcionDataAccess.save(this.perfilopcion, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.perfilopcion,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			PerfilOpcionLogicAdditional.checkPerfilOpcionToSaveAfter(this.perfilopcion,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.perfilopcion.getIsDeleted()) {
				this.perfilopcion=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void savePerfilOpcionsWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PerfilOpcion.class.getSimpleName()+"-savePerfilOpcionsWithConnection");connexion.begin();			
			
			PerfilOpcionLogicAdditional.checkPerfilOpcionToSaves(perfilopcions,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowPerfilOpcions();
			
			Boolean validadoTodosPerfilOpcion=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(PerfilOpcion perfilopcionLocal:perfilopcions) {		
				if(perfilopcionLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				PerfilOpcionLogicAdditional.updatePerfilOpcionToSave(perfilopcionLocal,this.arrDatoGeneral);
	        	
				PerfilOpcionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),perfilopcionLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarPerfilOpcion(perfilopcionLocal)) {
					PerfilOpcionDataAccess.save(perfilopcionLocal, connexion);				
				} else {
					validadoTodosPerfilOpcion=false;
				}
			}
			
			if(!validadoTodosPerfilOpcion) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			PerfilOpcionLogicAdditional.checkPerfilOpcionToSavesAfter(perfilopcions,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowPerfilOpcions();
			
			connexion.commit();		
			
			this.quitarPerfilOpcionsEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void savePerfilOpcions()throws Exception {				
		 try {	
			PerfilOpcionLogicAdditional.checkPerfilOpcionToSaves(perfilopcions,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosPerfilOpcion=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(PerfilOpcion perfilopcionLocal:perfilopcions) {				
				if(perfilopcionLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				PerfilOpcionLogicAdditional.updatePerfilOpcionToSave(perfilopcionLocal,this.arrDatoGeneral);
	        	
				PerfilOpcionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),perfilopcionLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarPerfilOpcion(perfilopcionLocal)) {				
					PerfilOpcionDataAccess.save(perfilopcionLocal, connexion);				
				} else {
					validadoTodosPerfilOpcion=false;
				}
			}
			
			if(!validadoTodosPerfilOpcion) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			PerfilOpcionLogicAdditional.checkPerfilOpcionToSavesAfter(perfilopcions,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarPerfilOpcionsEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public PerfilOpcionParameterReturnGeneral procesarAccionPerfilOpcions(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<PerfilOpcion> perfilopcions,PerfilOpcionParameterReturnGeneral perfilopcionParameterGeneral)throws Exception {
		 try {	
			PerfilOpcionParameterReturnGeneral perfilopcionReturnGeneral=new PerfilOpcionParameterReturnGeneral();
	
			PerfilOpcionLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,perfilopcions,perfilopcionParameterGeneral,perfilopcionReturnGeneral);
			
			return perfilopcionReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public PerfilOpcionParameterReturnGeneral procesarAccionPerfilOpcionsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<PerfilOpcion> perfilopcions,PerfilOpcionParameterReturnGeneral perfilopcionParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PerfilOpcion.class.getSimpleName()+"-procesarAccionPerfilOpcionsWithConnection");connexion.begin();			
			
			PerfilOpcionParameterReturnGeneral perfilopcionReturnGeneral=new PerfilOpcionParameterReturnGeneral();
	
			PerfilOpcionLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,perfilopcions,perfilopcionParameterGeneral,perfilopcionReturnGeneral);
			
			this.connexion.commit();
			
			return perfilopcionReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public PerfilOpcionParameterReturnGeneral procesarEventosPerfilOpcions(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<PerfilOpcion> perfilopcions,PerfilOpcion perfilopcion,PerfilOpcionParameterReturnGeneral perfilopcionParameterGeneral,Boolean isEsNuevoPerfilOpcion,ArrayList<Classe> clases)throws Exception {
		 try {	
			PerfilOpcionParameterReturnGeneral perfilopcionReturnGeneral=new PerfilOpcionParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				perfilopcionReturnGeneral.setConRecargarPropiedades(true);
			}
			
			PerfilOpcionLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,perfilopcions,perfilopcion,perfilopcionParameterGeneral,perfilopcionReturnGeneral,isEsNuevoPerfilOpcion,clases);
			
			return perfilopcionReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public PerfilOpcionParameterReturnGeneral procesarEventosPerfilOpcionsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<PerfilOpcion> perfilopcions,PerfilOpcion perfilopcion,PerfilOpcionParameterReturnGeneral perfilopcionParameterGeneral,Boolean isEsNuevoPerfilOpcion,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PerfilOpcion.class.getSimpleName()+"-procesarEventosPerfilOpcionsWithConnection");connexion.begin();			
			
			PerfilOpcionParameterReturnGeneral perfilopcionReturnGeneral=new PerfilOpcionParameterReturnGeneral();
	
			perfilopcionReturnGeneral.setPerfilOpcion(perfilopcion);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				perfilopcionReturnGeneral.setConRecargarPropiedades(true);
			}
			
			PerfilOpcionLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,perfilopcions,perfilopcion,perfilopcionParameterGeneral,perfilopcionReturnGeneral,isEsNuevoPerfilOpcion,clases);
			
			this.connexion.commit();
			
			return perfilopcionReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public PerfilOpcionParameterReturnGeneral procesarImportacionPerfilOpcionsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,PerfilOpcionParameterReturnGeneral perfilopcionParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PerfilOpcion.class.getSimpleName()+"-procesarImportacionPerfilOpcionsWithConnection");connexion.begin();			
			
			PerfilOpcionParameterReturnGeneral perfilopcionReturnGeneral=new PerfilOpcionParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.perfilopcions=new ArrayList<PerfilOpcion>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.perfilopcion=new PerfilOpcion();
				
				
				if(conColumnasBase) {this.perfilopcion.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.perfilopcion.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.perfilopcion.settodo(Boolean.parseBoolean(arrColumnas[iColumn++]));
				this.perfilopcion.setingreso(Boolean.parseBoolean(arrColumnas[iColumn++]));
				this.perfilopcion.setmodificacion(Boolean.parseBoolean(arrColumnas[iColumn++]));
				this.perfilopcion.seteliminacion(Boolean.parseBoolean(arrColumnas[iColumn++]));
				this.perfilopcion.setguardar_cambios(Boolean.parseBoolean(arrColumnas[iColumn++]));
				this.perfilopcion.setconsulta(Boolean.parseBoolean(arrColumnas[iColumn++]));
				this.perfilopcion.setbusqueda(Boolean.parseBoolean(arrColumnas[iColumn++]));
				this.perfilopcion.setreporte(Boolean.parseBoolean(arrColumnas[iColumn++]));
				this.perfilopcion.setorden(Boolean.parseBoolean(arrColumnas[iColumn++]));
				this.perfilopcion.setpaginacion_medio(Boolean.parseBoolean(arrColumnas[iColumn++]));
				this.perfilopcion.setpaginacion_alto(Boolean.parseBoolean(arrColumnas[iColumn++]));
				this.perfilopcion.setpaginacion_todo(Boolean.parseBoolean(arrColumnas[iColumn++]));
				this.perfilopcion.setduplicar(Boolean.parseBoolean(arrColumnas[iColumn++]));
				this.perfilopcion.setcopiar(Boolean.parseBoolean(arrColumnas[iColumn++]));
				this.perfilopcion.setcon_precargar(Boolean.parseBoolean(arrColumnas[iColumn++]));
				this.perfilopcion.setestado(Boolean.parseBoolean(arrColumnas[iColumn++]));
				
				this.perfilopcions.add(this.perfilopcion);
			}
			
			this.savePerfilOpcions();
			
			this.connexion.commit();
			
			perfilopcionReturnGeneral.setConRetornoEstaProcesado(true);
			perfilopcionReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return perfilopcionReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarPerfilOpcionsEliminados() throws Exception {				
		
		List<PerfilOpcion> perfilopcionsAux= new ArrayList<PerfilOpcion>();
		
		for(PerfilOpcion perfilopcion:perfilopcions) {
			if(!perfilopcion.getIsDeleted()) {
				perfilopcionsAux.add(perfilopcion);
			}
		}
		
		perfilopcions=perfilopcionsAux;
	}
	
	public void quitarPerfilOpcionsNulos() throws Exception {				
		
		List<PerfilOpcion> perfilopcionsAux= new ArrayList<PerfilOpcion>();
		
		for(PerfilOpcion perfilopcion : this.perfilopcions) {
			if(perfilopcion==null) {
				perfilopcionsAux.add(perfilopcion);
			}
		}
		
		//this.perfilopcions=perfilopcionsAux;
		
		this.perfilopcions.removeAll(perfilopcionsAux);
	}
	
	public void getSetVersionRowPerfilOpcionWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(perfilopcion.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((perfilopcion.getIsDeleted() || (perfilopcion.getIsChanged()&&!perfilopcion.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=perfilopcionDataAccess.getSetVersionRowPerfilOpcion(connexion,perfilopcion.getId());
				
				if(!perfilopcion.getVersionRow().equals(timestamp)) {	
					perfilopcion.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				perfilopcion.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowPerfilOpcion()throws Exception {	
		
		if(perfilopcion.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((perfilopcion.getIsDeleted() || (perfilopcion.getIsChanged()&&!perfilopcion.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=perfilopcionDataAccess.getSetVersionRowPerfilOpcion(connexion,perfilopcion.getId());
			
			try {							
				if(!perfilopcion.getVersionRow().equals(timestamp)) {	
					perfilopcion.setVersionRow(timestamp);
				}
				
				perfilopcion.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowPerfilOpcionsWithConnection()throws Exception {	
		if(perfilopcions!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(PerfilOpcion perfilopcionAux:perfilopcions) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(perfilopcionAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(perfilopcionAux.getIsDeleted() || (perfilopcionAux.getIsChanged()&&!perfilopcionAux.getIsNew())) {
						
						timestamp=perfilopcionDataAccess.getSetVersionRowPerfilOpcion(connexion,perfilopcionAux.getId());
						
						if(!perfilopcion.getVersionRow().equals(timestamp)) {	
							perfilopcionAux.setVersionRow(timestamp);
						}
								
						perfilopcionAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowPerfilOpcions()throws Exception {	
		if(perfilopcions!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(PerfilOpcion perfilopcionAux:perfilopcions) {
					if(perfilopcionAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(perfilopcionAux.getIsDeleted() || (perfilopcionAux.getIsChanged()&&!perfilopcionAux.getIsNew())) {
						
						timestamp=perfilopcionDataAccess.getSetVersionRowPerfilOpcion(connexion,perfilopcionAux.getId());
						
						if(!perfilopcionAux.getVersionRow().equals(timestamp)) {	
							perfilopcionAux.setVersionRow(timestamp);
						}
						
													
						perfilopcionAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public PerfilOpcionParameterReturnGeneral cargarCombosLoteForeignKeyPerfilOpcionWithConnection(String finalQueryGlobalSistema,String finalQueryGlobalModulo,String finalQueryGlobalGrupoOpcion,String finalQueryGlobalPerfil,String finalQueryGlobalOpcion) throws Exception {
		PerfilOpcionParameterReturnGeneral  perfilopcionReturnGeneral =new PerfilOpcionParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PerfilOpcion.class.getSimpleName()+"-cargarCombosLoteForeignKeyPerfilOpcionWithConnection");connexion.begin();
			
			perfilopcionReturnGeneral =new PerfilOpcionParameterReturnGeneral();
			
			

			List<Sistema> sistemasForeignKey=new ArrayList<Sistema>();
			SistemaLogic sistemaLogic=new SistemaLogic();
			sistemaLogic.setConnexion(this.connexion);
			sistemaLogic.getSistemaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSistema.equals("NONE")) {
				sistemaLogic.getTodosSistemas(finalQueryGlobalSistema,new Pagination());
				sistemasForeignKey=sistemaLogic.getSistemas();
			}

			perfilopcionReturnGeneral.setsistemasForeignKey(sistemasForeignKey);


			List<Modulo> modulosForeignKey=new ArrayList<Modulo>();
			ModuloLogic moduloLogic=new ModuloLogic();
			moduloLogic.setConnexion(this.connexion);
			moduloLogic.getModuloDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalModulo.equals("NONE")) {
				moduloLogic.getTodosModulos(finalQueryGlobalModulo,new Pagination());
				modulosForeignKey=moduloLogic.getModulos();
			}

			perfilopcionReturnGeneral.setmodulosForeignKey(modulosForeignKey);


			List<GrupoOpcion> grupoopcionsForeignKey=new ArrayList<GrupoOpcion>();
			GrupoOpcionLogic grupoopcionLogic=new GrupoOpcionLogic();
			grupoopcionLogic.setConnexion(this.connexion);
			grupoopcionLogic.getGrupoOpcionDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalGrupoOpcion.equals("NONE")) {
				grupoopcionLogic.getTodosGrupoOpcions(finalQueryGlobalGrupoOpcion,new Pagination());
				grupoopcionsForeignKey=grupoopcionLogic.getGrupoOpcions();
			}

			perfilopcionReturnGeneral.setgrupoopcionsForeignKey(grupoopcionsForeignKey);


			List<Perfil> perfilsForeignKey=new ArrayList<Perfil>();
			PerfilLogic perfilLogic=new PerfilLogic();
			perfilLogic.setConnexion(this.connexion);
			perfilLogic.getPerfilDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPerfil.equals("NONE")) {
				perfilLogic.getTodosPerfils(finalQueryGlobalPerfil,new Pagination());
				perfilsForeignKey=perfilLogic.getPerfils();
			}

			perfilopcionReturnGeneral.setperfilsForeignKey(perfilsForeignKey);


			List<Opcion> opcionsForeignKey=new ArrayList<Opcion>();
			OpcionLogic opcionLogic=new OpcionLogic();
			opcionLogic.setConnexion(this.connexion);
			opcionLogic.getOpcionDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalOpcion.equals("NONE")) {
				opcionLogic.getTodosOpcions(finalQueryGlobalOpcion,new Pagination());
				opcionsForeignKey=opcionLogic.getOpcions();
			}

			perfilopcionReturnGeneral.setopcionsForeignKey(opcionsForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return perfilopcionReturnGeneral;
	}
	
	public PerfilOpcionParameterReturnGeneral cargarCombosLoteForeignKeyPerfilOpcion(String finalQueryGlobalSistema,String finalQueryGlobalModulo,String finalQueryGlobalGrupoOpcion,String finalQueryGlobalPerfil,String finalQueryGlobalOpcion) throws Exception {
		PerfilOpcionParameterReturnGeneral  perfilopcionReturnGeneral =new PerfilOpcionParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			perfilopcionReturnGeneral =new PerfilOpcionParameterReturnGeneral();
			
			

			List<Sistema> sistemasForeignKey=new ArrayList<Sistema>();
			SistemaLogic sistemaLogic=new SistemaLogic();
			sistemaLogic.setConnexion(this.connexion);
			sistemaLogic.getSistemaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSistema.equals("NONE")) {
				sistemaLogic.getTodosSistemas(finalQueryGlobalSistema,new Pagination());
				sistemasForeignKey=sistemaLogic.getSistemas();
			}

			perfilopcionReturnGeneral.setsistemasForeignKey(sistemasForeignKey);


			List<Modulo> modulosForeignKey=new ArrayList<Modulo>();
			ModuloLogic moduloLogic=new ModuloLogic();
			moduloLogic.setConnexion(this.connexion);
			moduloLogic.getModuloDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalModulo.equals("NONE")) {
				moduloLogic.getTodosModulos(finalQueryGlobalModulo,new Pagination());
				modulosForeignKey=moduloLogic.getModulos();
			}

			perfilopcionReturnGeneral.setmodulosForeignKey(modulosForeignKey);


			List<GrupoOpcion> grupoopcionsForeignKey=new ArrayList<GrupoOpcion>();
			GrupoOpcionLogic grupoopcionLogic=new GrupoOpcionLogic();
			grupoopcionLogic.setConnexion(this.connexion);
			grupoopcionLogic.getGrupoOpcionDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalGrupoOpcion.equals("NONE")) {
				grupoopcionLogic.getTodosGrupoOpcions(finalQueryGlobalGrupoOpcion,new Pagination());
				grupoopcionsForeignKey=grupoopcionLogic.getGrupoOpcions();
			}

			perfilopcionReturnGeneral.setgrupoopcionsForeignKey(grupoopcionsForeignKey);


			List<Perfil> perfilsForeignKey=new ArrayList<Perfil>();
			PerfilLogic perfilLogic=new PerfilLogic();
			perfilLogic.setConnexion(this.connexion);
			perfilLogic.getPerfilDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPerfil.equals("NONE")) {
				perfilLogic.getTodosPerfils(finalQueryGlobalPerfil,new Pagination());
				perfilsForeignKey=perfilLogic.getPerfils();
			}

			perfilopcionReturnGeneral.setperfilsForeignKey(perfilsForeignKey);


			List<Opcion> opcionsForeignKey=new ArrayList<Opcion>();
			OpcionLogic opcionLogic=new OpcionLogic();
			opcionLogic.setConnexion(this.connexion);
			opcionLogic.getOpcionDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalOpcion.equals("NONE")) {
				opcionLogic.getTodosOpcions(finalQueryGlobalOpcion,new Pagination());
				opcionsForeignKey=opcionLogic.getOpcions();
			}

			perfilopcionReturnGeneral.setopcionsForeignKey(opcionsForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return perfilopcionReturnGeneral;
	}
	
	
	public void deepLoad(PerfilOpcion perfilopcion,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			PerfilOpcionLogicAdditional.updatePerfilOpcionToGet(perfilopcion,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		perfilopcion.setSistema(perfilopcionDataAccess.getSistema(connexion,perfilopcion));
		perfilopcion.setModulo(perfilopcionDataAccess.getModulo(connexion,perfilopcion));
		perfilopcion.setGrupoOpcion(perfilopcionDataAccess.getGrupoOpcion(connexion,perfilopcion));
		perfilopcion.setPerfil(perfilopcionDataAccess.getPerfil(connexion,perfilopcion));
		perfilopcion.setOpcion(perfilopcionDataAccess.getOpcion(connexion,perfilopcion));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Sistema.class)) {
				perfilopcion.setSistema(perfilopcionDataAccess.getSistema(connexion,perfilopcion));
				continue;
			}

			if(clas.clas.equals(Modulo.class)) {
				perfilopcion.setModulo(perfilopcionDataAccess.getModulo(connexion,perfilopcion));
				continue;
			}

			if(clas.clas.equals(GrupoOpcion.class)) {
				perfilopcion.setGrupoOpcion(perfilopcionDataAccess.getGrupoOpcion(connexion,perfilopcion));
				continue;
			}

			if(clas.clas.equals(Perfil.class)) {
				perfilopcion.setPerfil(perfilopcionDataAccess.getPerfil(connexion,perfilopcion));
				continue;
			}

			if(clas.clas.equals(Opcion.class)) {
				perfilopcion.setOpcion(perfilopcionDataAccess.getOpcion(connexion,perfilopcion));
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
			perfilopcion.setSistema(perfilopcionDataAccess.getSistema(connexion,perfilopcion));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Modulo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			perfilopcion.setModulo(perfilopcionDataAccess.getModulo(connexion,perfilopcion));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(GrupoOpcion.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			perfilopcion.setGrupoOpcion(perfilopcionDataAccess.getGrupoOpcion(connexion,perfilopcion));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Perfil.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			perfilopcion.setPerfil(perfilopcionDataAccess.getPerfil(connexion,perfilopcion));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Opcion.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			perfilopcion.setOpcion(perfilopcionDataAccess.getOpcion(connexion,perfilopcion));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		perfilopcion.setSistema(perfilopcionDataAccess.getSistema(connexion,perfilopcion));
		SistemaLogic sistemaLogic= new SistemaLogic(connexion);
		sistemaLogic.deepLoad(perfilopcion.getSistema(),isDeep,deepLoadType,clases);
				
		perfilopcion.setModulo(perfilopcionDataAccess.getModulo(connexion,perfilopcion));
		ModuloLogic moduloLogic= new ModuloLogic(connexion);
		moduloLogic.deepLoad(perfilopcion.getModulo(),isDeep,deepLoadType,clases);
				
		perfilopcion.setGrupoOpcion(perfilopcionDataAccess.getGrupoOpcion(connexion,perfilopcion));
		GrupoOpcionLogic grupoopcionLogic= new GrupoOpcionLogic(connexion);
		grupoopcionLogic.deepLoad(perfilopcion.getGrupoOpcion(),isDeep,deepLoadType,clases);
				
		perfilopcion.setPerfil(perfilopcionDataAccess.getPerfil(connexion,perfilopcion));
		PerfilLogic perfilLogic= new PerfilLogic(connexion);
		perfilLogic.deepLoad(perfilopcion.getPerfil(),isDeep,deepLoadType,clases);
				
		perfilopcion.setOpcion(perfilopcionDataAccess.getOpcion(connexion,perfilopcion));
		OpcionLogic opcionLogic= new OpcionLogic(connexion);
		opcionLogic.deepLoad(perfilopcion.getOpcion(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Sistema.class)) {
				perfilopcion.setSistema(perfilopcionDataAccess.getSistema(connexion,perfilopcion));
				SistemaLogic sistemaLogic= new SistemaLogic(connexion);
				sistemaLogic.deepLoad(perfilopcion.getSistema(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Modulo.class)) {
				perfilopcion.setModulo(perfilopcionDataAccess.getModulo(connexion,perfilopcion));
				ModuloLogic moduloLogic= new ModuloLogic(connexion);
				moduloLogic.deepLoad(perfilopcion.getModulo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(GrupoOpcion.class)) {
				perfilopcion.setGrupoOpcion(perfilopcionDataAccess.getGrupoOpcion(connexion,perfilopcion));
				GrupoOpcionLogic grupoopcionLogic= new GrupoOpcionLogic(connexion);
				grupoopcionLogic.deepLoad(perfilopcion.getGrupoOpcion(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Perfil.class)) {
				perfilopcion.setPerfil(perfilopcionDataAccess.getPerfil(connexion,perfilopcion));
				PerfilLogic perfilLogic= new PerfilLogic(connexion);
				perfilLogic.deepLoad(perfilopcion.getPerfil(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Opcion.class)) {
				perfilopcion.setOpcion(perfilopcionDataAccess.getOpcion(connexion,perfilopcion));
				OpcionLogic opcionLogic= new OpcionLogic(connexion);
				opcionLogic.deepLoad(perfilopcion.getOpcion(),isDeep,deepLoadType,clases);				
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
			perfilopcion.setSistema(perfilopcionDataAccess.getSistema(connexion,perfilopcion));
			SistemaLogic sistemaLogic= new SistemaLogic(connexion);
			sistemaLogic.deepLoad(perfilopcion.getSistema(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Modulo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			perfilopcion.setModulo(perfilopcionDataAccess.getModulo(connexion,perfilopcion));
			ModuloLogic moduloLogic= new ModuloLogic(connexion);
			moduloLogic.deepLoad(perfilopcion.getModulo(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(GrupoOpcion.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			perfilopcion.setGrupoOpcion(perfilopcionDataAccess.getGrupoOpcion(connexion,perfilopcion));
			GrupoOpcionLogic grupoopcionLogic= new GrupoOpcionLogic(connexion);
			grupoopcionLogic.deepLoad(perfilopcion.getGrupoOpcion(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Perfil.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			perfilopcion.setPerfil(perfilopcionDataAccess.getPerfil(connexion,perfilopcion));
			PerfilLogic perfilLogic= new PerfilLogic(connexion);
			perfilLogic.deepLoad(perfilopcion.getPerfil(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Opcion.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			perfilopcion.setOpcion(perfilopcionDataAccess.getOpcion(connexion,perfilopcion));
			OpcionLogic opcionLogic= new OpcionLogic(connexion);
			opcionLogic.deepLoad(perfilopcion.getOpcion(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(PerfilOpcion perfilopcion,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			PerfilOpcionLogicAdditional.updatePerfilOpcionToSave(perfilopcion,this.arrDatoGeneral);
			
PerfilOpcionDataAccess.save(perfilopcion, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		SistemaDataAccess.save(perfilopcion.getSistema(),connexion);

		ModuloDataAccess.save(perfilopcion.getModulo(),connexion);

		GrupoOpcionDataAccess.save(perfilopcion.getGrupoOpcion(),connexion);

		PerfilDataAccess.save(perfilopcion.getPerfil(),connexion);

		OpcionDataAccess.save(perfilopcion.getOpcion(),connexion);
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Sistema.class)) {
				SistemaDataAccess.save(perfilopcion.getSistema(),connexion);
				continue;
			}

			if(clas.clas.equals(Modulo.class)) {
				ModuloDataAccess.save(perfilopcion.getModulo(),connexion);
				continue;
			}

			if(clas.clas.equals(GrupoOpcion.class)) {
				GrupoOpcionDataAccess.save(perfilopcion.getGrupoOpcion(),connexion);
				continue;
			}

			if(clas.clas.equals(Perfil.class)) {
				PerfilDataAccess.save(perfilopcion.getPerfil(),connexion);
				continue;
			}

			if(clas.clas.equals(Opcion.class)) {
				OpcionDataAccess.save(perfilopcion.getOpcion(),connexion);
				continue;
			}

		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		SistemaDataAccess.save(perfilopcion.getSistema(),connexion);
		SistemaLogic sistemaLogic= new SistemaLogic(connexion);
		sistemaLogic.deepLoad(perfilopcion.getSistema(),isDeep,deepLoadType,clases);
				

		ModuloDataAccess.save(perfilopcion.getModulo(),connexion);
		ModuloLogic moduloLogic= new ModuloLogic(connexion);
		moduloLogic.deepLoad(perfilopcion.getModulo(),isDeep,deepLoadType,clases);
				

		GrupoOpcionDataAccess.save(perfilopcion.getGrupoOpcion(),connexion);
		GrupoOpcionLogic grupoopcionLogic= new GrupoOpcionLogic(connexion);
		grupoopcionLogic.deepLoad(perfilopcion.getGrupoOpcion(),isDeep,deepLoadType,clases);
				

		PerfilDataAccess.save(perfilopcion.getPerfil(),connexion);
		PerfilLogic perfilLogic= new PerfilLogic(connexion);
		perfilLogic.deepLoad(perfilopcion.getPerfil(),isDeep,deepLoadType,clases);
				

		OpcionDataAccess.save(perfilopcion.getOpcion(),connexion);
		OpcionLogic opcionLogic= new OpcionLogic(connexion);
		opcionLogic.deepLoad(perfilopcion.getOpcion(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Sistema.class)) {
				SistemaDataAccess.save(perfilopcion.getSistema(),connexion);
				SistemaLogic sistemaLogic= new SistemaLogic(connexion);
				sistemaLogic.deepSave(perfilopcion.getSistema(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Modulo.class)) {
				ModuloDataAccess.save(perfilopcion.getModulo(),connexion);
				ModuloLogic moduloLogic= new ModuloLogic(connexion);
				moduloLogic.deepSave(perfilopcion.getModulo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(GrupoOpcion.class)) {
				GrupoOpcionDataAccess.save(perfilopcion.getGrupoOpcion(),connexion);
				GrupoOpcionLogic grupoopcionLogic= new GrupoOpcionLogic(connexion);
				grupoopcionLogic.deepSave(perfilopcion.getGrupoOpcion(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Perfil.class)) {
				PerfilDataAccess.save(perfilopcion.getPerfil(),connexion);
				PerfilLogic perfilLogic= new PerfilLogic(connexion);
				perfilLogic.deepSave(perfilopcion.getPerfil(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Opcion.class)) {
				OpcionDataAccess.save(perfilopcion.getOpcion(),connexion);
				OpcionLogic opcionLogic= new OpcionLogic(connexion);
				opcionLogic.deepSave(perfilopcion.getOpcion(),isDeep,deepLoadType,clases);				
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
			this.getNewConnexionToDeep(PerfilOpcion.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(perfilopcion,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				PerfilOpcionConstantesFunciones.refrescarForeignKeysDescripcionesPerfilOpcion(perfilopcion);
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
			this.deepLoad(this.perfilopcion,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				PerfilOpcionConstantesFunciones.refrescarForeignKeysDescripcionesPerfilOpcion(this.perfilopcion);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(PerfilOpcion.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(perfilopcions!=null) {
				for(PerfilOpcion perfilopcion:perfilopcions) {
					this.deepLoad(perfilopcion,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					PerfilOpcionConstantesFunciones.refrescarForeignKeysDescripcionesPerfilOpcion(perfilopcions);
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
			if(perfilopcions!=null) {
				for(PerfilOpcion perfilopcion:perfilopcions) {
					this.deepLoad(perfilopcion,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					PerfilOpcionConstantesFunciones.refrescarForeignKeysDescripcionesPerfilOpcion(perfilopcions);
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
			this.getNewConnexionToDeep(PerfilOpcion.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(perfilopcion,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(PerfilOpcion.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(perfilopcions!=null) {
				for(PerfilOpcion perfilopcion:perfilopcions) {
					this.deepSave(perfilopcion,isDeep,deepLoadType,clases);
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
			if(perfilopcions!=null) {
				for(PerfilOpcion perfilopcion:perfilopcions) {
					this.deepSave(perfilopcion,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getPerfilOpcionsBusquedaPorIdPerfilPorIdOpcionWithConnection(String sFinalQuery,Pagination pagination,Long id_sistema,Long id_modulo,Long id_grupo_opcion,Long id_perfil,Long id_opcion)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PerfilOpcion.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSistema= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSistema.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sistema,PerfilOpcionConstantesFunciones.IDSISTEMA,ParameterTypeOperator.AND);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSistema);

			ParameterSelectionGeneral parameterSelectionGeneralidModulo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidModulo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_modulo,PerfilOpcionConstantesFunciones.IDMODULO,ParameterTypeOperator.AND);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidModulo);

			ParameterSelectionGeneral parameterSelectionGeneralidGrupoOpcion= new ParameterSelectionGeneral();
			parameterSelectionGeneralidGrupoOpcion.setParameterSelectionGeneralEqual(ParameterType.LONG,id_grupo_opcion,PerfilOpcionConstantesFunciones.IDGRUPOOPCION,ParameterTypeOperator.AND);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidGrupoOpcion);

			ParameterSelectionGeneral parameterSelectionGeneralidPerfil= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPerfil.setParameterSelectionGeneralEqual(ParameterType.LONG,id_perfil,PerfilOpcionConstantesFunciones.IDPERFIL,ParameterTypeOperator.AND);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPerfil);

			ParameterSelectionGeneral parameterSelectionGeneralidOpcion= new ParameterSelectionGeneral();
			parameterSelectionGeneralidOpcion.setParameterSelectionGeneralEqual(ParameterType.LONG,id_opcion,PerfilOpcionConstantesFunciones.IDOPCION,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidOpcion);

			PerfilOpcionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorIdPerfilPorIdOpcion","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			perfilopcions=perfilopcionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PerfilOpcionConstantesFunciones.refrescarForeignKeysDescripcionesPerfilOpcion(this.perfilopcions);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPerfilOpcionsBusquedaPorIdPerfilPorIdOpcion(String sFinalQuery,Pagination pagination,Long id_sistema,Long id_modulo,Long id_grupo_opcion,Long id_perfil,Long id_opcion)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSistema= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSistema.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sistema,PerfilOpcionConstantesFunciones.IDSISTEMA,ParameterTypeOperator.AND);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSistema);

			ParameterSelectionGeneral parameterSelectionGeneralidModulo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidModulo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_modulo,PerfilOpcionConstantesFunciones.IDMODULO,ParameterTypeOperator.AND);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidModulo);

			ParameterSelectionGeneral parameterSelectionGeneralidGrupoOpcion= new ParameterSelectionGeneral();
			parameterSelectionGeneralidGrupoOpcion.setParameterSelectionGeneralEqual(ParameterType.LONG,id_grupo_opcion,PerfilOpcionConstantesFunciones.IDGRUPOOPCION,ParameterTypeOperator.AND);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidGrupoOpcion);

			ParameterSelectionGeneral parameterSelectionGeneralidPerfil= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPerfil.setParameterSelectionGeneralEqual(ParameterType.LONG,id_perfil,PerfilOpcionConstantesFunciones.IDPERFIL,ParameterTypeOperator.AND);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPerfil);

			ParameterSelectionGeneral parameterSelectionGeneralidOpcion= new ParameterSelectionGeneral();
			parameterSelectionGeneralidOpcion.setParameterSelectionGeneralEqual(ParameterType.LONG,id_opcion,PerfilOpcionConstantesFunciones.IDOPCION,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidOpcion);

			PerfilOpcionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorIdPerfilPorIdOpcion","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			perfilopcions=perfilopcionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PerfilOpcionConstantesFunciones.refrescarForeignKeysDescripcionesPerfilOpcion(this.perfilopcions);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getPerfilOpcionsBusquedaPorIdSisPorIdModPorIdPerWithConnection(String sFinalQuery,Pagination pagination,Long id_sistema,Long id_modulo,Long id_grupo_opcion,Long id_perfil)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PerfilOpcion.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSistema= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSistema.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sistema,PerfilOpcionConstantesFunciones.IDSISTEMA,ParameterTypeOperator.AND);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSistema);

			ParameterSelectionGeneral parameterSelectionGeneralidModulo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidModulo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_modulo,PerfilOpcionConstantesFunciones.IDMODULO,ParameterTypeOperator.AND);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidModulo);

			ParameterSelectionGeneral parameterSelectionGeneralidGrupoOpcion= new ParameterSelectionGeneral();
			parameterSelectionGeneralidGrupoOpcion.setParameterSelectionGeneralEqual(ParameterType.LONG,id_grupo_opcion,PerfilOpcionConstantesFunciones.IDGRUPOOPCION,ParameterTypeOperator.AND);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidGrupoOpcion);

			ParameterSelectionGeneral parameterSelectionGeneralidPerfil= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPerfil.setParameterSelectionGeneralEqual(ParameterType.LONG,id_perfil,PerfilOpcionConstantesFunciones.IDPERFIL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPerfil);

			PerfilOpcionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorIdSisPorIdModPorIdPer","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			perfilopcions=perfilopcionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PerfilOpcionConstantesFunciones.refrescarForeignKeysDescripcionesPerfilOpcion(this.perfilopcions);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPerfilOpcionsBusquedaPorIdSisPorIdModPorIdPer(String sFinalQuery,Pagination pagination,Long id_sistema,Long id_modulo,Long id_grupo_opcion,Long id_perfil)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSistema= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSistema.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sistema,PerfilOpcionConstantesFunciones.IDSISTEMA,ParameterTypeOperator.AND);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSistema);

			ParameterSelectionGeneral parameterSelectionGeneralidModulo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidModulo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_modulo,PerfilOpcionConstantesFunciones.IDMODULO,ParameterTypeOperator.AND);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidModulo);

			ParameterSelectionGeneral parameterSelectionGeneralidGrupoOpcion= new ParameterSelectionGeneral();
			parameterSelectionGeneralidGrupoOpcion.setParameterSelectionGeneralEqual(ParameterType.LONG,id_grupo_opcion,PerfilOpcionConstantesFunciones.IDGRUPOOPCION,ParameterTypeOperator.AND);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidGrupoOpcion);

			ParameterSelectionGeneral parameterSelectionGeneralidPerfil= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPerfil.setParameterSelectionGeneralEqual(ParameterType.LONG,id_perfil,PerfilOpcionConstantesFunciones.IDPERFIL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPerfil);

			PerfilOpcionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorIdSisPorIdModPorIdPer","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			perfilopcions=perfilopcionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PerfilOpcionConstantesFunciones.refrescarForeignKeysDescripcionesPerfilOpcion(this.perfilopcions);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getPerfilOpcionsFK_IdGrupoOpcionWithConnection(String sFinalQuery,Pagination pagination,Long id_grupo_opcion)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PerfilOpcion.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidGrupoOpcion= new ParameterSelectionGeneral();
			parameterSelectionGeneralidGrupoOpcion.setParameterSelectionGeneralEqual(ParameterType.LONG,id_grupo_opcion,PerfilOpcionConstantesFunciones.IDGRUPOOPCION,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidGrupoOpcion);

			PerfilOpcionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdGrupoOpcion","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			perfilopcions=perfilopcionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PerfilOpcionConstantesFunciones.refrescarForeignKeysDescripcionesPerfilOpcion(this.perfilopcions);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPerfilOpcionsFK_IdGrupoOpcion(String sFinalQuery,Pagination pagination,Long id_grupo_opcion)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidGrupoOpcion= new ParameterSelectionGeneral();
			parameterSelectionGeneralidGrupoOpcion.setParameterSelectionGeneralEqual(ParameterType.LONG,id_grupo_opcion,PerfilOpcionConstantesFunciones.IDGRUPOOPCION,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidGrupoOpcion);

			PerfilOpcionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdGrupoOpcion","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			perfilopcions=perfilopcionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PerfilOpcionConstantesFunciones.refrescarForeignKeysDescripcionesPerfilOpcion(this.perfilopcions);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getPerfilOpcionsFK_IdModuloWithConnection(String sFinalQuery,Pagination pagination,Long id_modulo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PerfilOpcion.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidModulo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidModulo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_modulo,PerfilOpcionConstantesFunciones.IDMODULO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidModulo);

			PerfilOpcionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdModulo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			perfilopcions=perfilopcionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PerfilOpcionConstantesFunciones.refrescarForeignKeysDescripcionesPerfilOpcion(this.perfilopcions);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPerfilOpcionsFK_IdModulo(String sFinalQuery,Pagination pagination,Long id_modulo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidModulo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidModulo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_modulo,PerfilOpcionConstantesFunciones.IDMODULO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidModulo);

			PerfilOpcionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdModulo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			perfilopcions=perfilopcionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PerfilOpcionConstantesFunciones.refrescarForeignKeysDescripcionesPerfilOpcion(this.perfilopcions);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getPerfilOpcionsFK_IdOpcionWithConnection(String sFinalQuery,Pagination pagination,Long id_opcion)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PerfilOpcion.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidOpcion= new ParameterSelectionGeneral();
			parameterSelectionGeneralidOpcion.setParameterSelectionGeneralEqual(ParameterType.LONG,id_opcion,PerfilOpcionConstantesFunciones.IDOPCION,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidOpcion);

			PerfilOpcionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdOpcion","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			perfilopcions=perfilopcionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PerfilOpcionConstantesFunciones.refrescarForeignKeysDescripcionesPerfilOpcion(this.perfilopcions);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPerfilOpcionsFK_IdOpcion(String sFinalQuery,Pagination pagination,Long id_opcion)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidOpcion= new ParameterSelectionGeneral();
			parameterSelectionGeneralidOpcion.setParameterSelectionGeneralEqual(ParameterType.LONG,id_opcion,PerfilOpcionConstantesFunciones.IDOPCION,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidOpcion);

			PerfilOpcionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdOpcion","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			perfilopcions=perfilopcionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PerfilOpcionConstantesFunciones.refrescarForeignKeysDescripcionesPerfilOpcion(this.perfilopcions);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getPerfilOpcionsFK_IdPerfilWithConnection(String sFinalQuery,Pagination pagination,Long id_perfil)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PerfilOpcion.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPerfil= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPerfil.setParameterSelectionGeneralEqual(ParameterType.LONG,id_perfil,PerfilOpcionConstantesFunciones.IDPERFIL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPerfil);

			PerfilOpcionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPerfil","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			perfilopcions=perfilopcionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PerfilOpcionConstantesFunciones.refrescarForeignKeysDescripcionesPerfilOpcion(this.perfilopcions);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPerfilOpcionsFK_IdPerfil(String sFinalQuery,Pagination pagination,Long id_perfil)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPerfil= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPerfil.setParameterSelectionGeneralEqual(ParameterType.LONG,id_perfil,PerfilOpcionConstantesFunciones.IDPERFIL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPerfil);

			PerfilOpcionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPerfil","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			perfilopcions=perfilopcionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PerfilOpcionConstantesFunciones.refrescarForeignKeysDescripcionesPerfilOpcion(this.perfilopcions);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getPerfilOpcionsFK_IdSistemaWithConnection(String sFinalQuery,Pagination pagination,Long id_sistema)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PerfilOpcion.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSistema= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSistema.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sistema,PerfilOpcionConstantesFunciones.IDSISTEMA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSistema);

			PerfilOpcionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSistema","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			perfilopcions=perfilopcionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PerfilOpcionConstantesFunciones.refrescarForeignKeysDescripcionesPerfilOpcion(this.perfilopcions);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPerfilOpcionsFK_IdSistema(String sFinalQuery,Pagination pagination,Long id_sistema)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSistema= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSistema.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sistema,PerfilOpcionConstantesFunciones.IDSISTEMA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSistema);

			PerfilOpcionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSistema","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			perfilopcions=perfilopcionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PerfilOpcionConstantesFunciones.refrescarForeignKeysDescripcionesPerfilOpcion(this.perfilopcions);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getPerfilOpcionPorIdPerfilPorIdOpcionWithConnection(Long id_perfil,Long id_opcion)throws Exception {
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PerfilOpcion.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			ParameterSelectionGeneral parameterSelectionGeneralidPerfil= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPerfil.setParameterSelectionGeneralEqual(ParameterType.LONG,id_perfil,PerfilOpcionConstantesFunciones.IDPERFIL,ParameterTypeOperator.AND);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPerfil);

			ParameterSelectionGeneral parameterSelectionGeneralidOpcion= new ParameterSelectionGeneral();
			parameterSelectionGeneralidOpcion.setParameterSelectionGeneralEqual(ParameterType.LONG,id_opcion,PerfilOpcionConstantesFunciones.IDOPCION,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidOpcion);

			perfilopcion=perfilopcionDataAccess.getEntity(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoad(this.perfilopcion,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());

				PerfilOpcionConstantesFunciones.refrescarForeignKeysDescripcionesPerfilOpcion(this.perfilopcion);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPerfilOpcionPorIdPerfilPorIdOpcion(Long id_perfil,Long id_opcion)throws Exception {
		try {

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			ParameterSelectionGeneral parameterSelectionGeneralidPerfil= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPerfil.setParameterSelectionGeneralEqual(ParameterType.LONG,id_perfil,PerfilOpcionConstantesFunciones.IDPERFIL,ParameterTypeOperator.AND);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPerfil);

			ParameterSelectionGeneral parameterSelectionGeneralidOpcion= new ParameterSelectionGeneral();
			parameterSelectionGeneralidOpcion.setParameterSelectionGeneralEqual(ParameterType.LONG,id_opcion,PerfilOpcionConstantesFunciones.IDOPCION,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidOpcion);

			perfilopcion=perfilopcionDataAccess.getEntity(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoad(this.perfilopcion,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());

				PerfilOpcionConstantesFunciones.refrescarForeignKeysDescripcionesPerfilOpcion(this.perfilopcion);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,String sProcesoBusqueda,String sDetalleProcesoBusqueda,QueryWhereSelectParameters queryWhereSelectParameters,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		//AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		//auditoriaLogicAdditional.setConnexion(connexion);
		//AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(PerfilOpcionConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				//auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,PerfilOpcionDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,PerfilOpcion perfilopcion,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		//AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		//auditoriaLogicAdditional.setConnexion(connexion);
		//AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(PerfilOpcionConstantesFunciones.ISCONAUDITORIA) {
				if(perfilopcion.getIsNew()) {
					//auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,PerfilOpcionDataAccess.TABLENAME, perfilopcion.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(PerfilOpcionConstantesFunciones.ISCONAUDITORIADETALLE) {
						//PerfilOpcionLogic.registrarAuditoriaDetallesPerfilOpcion(connexion,perfilopcion,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(perfilopcion.getIsDeleted()) {
					/*if(!perfilopcion.getIsExpired()) {
						//auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,PerfilOpcionDataAccess.TABLENAME, perfilopcion.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						//PerfilOpcionLogic.registrarAuditoriaDetallesPerfilOpcion(connexion,perfilopcion,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						//auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,PerfilOpcionDataAccess.TABLENAME, perfilopcion.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(perfilopcion.getIsChanged()) {
					//auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,PerfilOpcionDataAccess.TABLENAME, perfilopcion.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(PerfilOpcionConstantesFunciones.ISCONAUDITORIADETALLE) {
						//PerfilOpcionLogic.registrarAuditoriaDetallesPerfilOpcion(connexion,perfilopcion,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesPerfilOpcion(Connexion connexion,PerfilOpcion perfilopcion)throws Exception {		
		//AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		//auditoriaDetalleLogicAdditional.setConnexion(connexion);
		//AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(perfilopcion.getIsNew()||!perfilopcion.getid_sistema().equals(perfilopcion.getPerfilOpcionOriginal().getid_sistema()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(perfilopcion.getPerfilOpcionOriginal().getid_sistema()!=null)
				{
					strValorActual=perfilopcion.getPerfilOpcionOriginal().getid_sistema().toString();
				}
				if(perfilopcion.getid_sistema()!=null)
				{
					strValorNuevo=perfilopcion.getid_sistema().toString() ;
				}

				//auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PerfilOpcionConstantesFunciones.IDSISTEMA,strValorActual,strValorNuevo);
			}	
			
			if(perfilopcion.getIsNew()||!perfilopcion.getid_modulo().equals(perfilopcion.getPerfilOpcionOriginal().getid_modulo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(perfilopcion.getPerfilOpcionOriginal().getid_modulo()!=null)
				{
					strValorActual=perfilopcion.getPerfilOpcionOriginal().getid_modulo().toString();
				}
				if(perfilopcion.getid_modulo()!=null)
				{
					strValorNuevo=perfilopcion.getid_modulo().toString() ;
				}

				//auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PerfilOpcionConstantesFunciones.IDMODULO,strValorActual,strValorNuevo);
			}	
			
			if(perfilopcion.getIsNew()||!perfilopcion.getid_grupo_opcion().equals(perfilopcion.getPerfilOpcionOriginal().getid_grupo_opcion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(perfilopcion.getPerfilOpcionOriginal().getid_grupo_opcion()!=null)
				{
					strValorActual=perfilopcion.getPerfilOpcionOriginal().getid_grupo_opcion().toString();
				}
				if(perfilopcion.getid_grupo_opcion()!=null)
				{
					strValorNuevo=perfilopcion.getid_grupo_opcion().toString() ;
				}

				//auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PerfilOpcionConstantesFunciones.IDGRUPOOPCION,strValorActual,strValorNuevo);
			}	
			
			if(perfilopcion.getIsNew()||!perfilopcion.getid_perfil().equals(perfilopcion.getPerfilOpcionOriginal().getid_perfil()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(perfilopcion.getPerfilOpcionOriginal().getid_perfil()!=null)
				{
					strValorActual=perfilopcion.getPerfilOpcionOriginal().getid_perfil().toString();
				}
				if(perfilopcion.getid_perfil()!=null)
				{
					strValorNuevo=perfilopcion.getid_perfil().toString() ;
				}

				//auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PerfilOpcionConstantesFunciones.IDPERFIL,strValorActual,strValorNuevo);
			}	
			
			if(perfilopcion.getIsNew()||!perfilopcion.getid_opcion().equals(perfilopcion.getPerfilOpcionOriginal().getid_opcion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(perfilopcion.getPerfilOpcionOriginal().getid_opcion()!=null)
				{
					strValorActual=perfilopcion.getPerfilOpcionOriginal().getid_opcion().toString();
				}
				if(perfilopcion.getid_opcion()!=null)
				{
					strValorNuevo=perfilopcion.getid_opcion().toString() ;
				}

				//auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PerfilOpcionConstantesFunciones.IDOPCION,strValorActual,strValorNuevo);
			}	
			
			if(perfilopcion.getIsNew()||!perfilopcion.gettodo().equals(perfilopcion.getPerfilOpcionOriginal().gettodo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(perfilopcion.getPerfilOpcionOriginal().gettodo()!=null)
				{
					strValorActual=perfilopcion.getPerfilOpcionOriginal().gettodo().toString();
				}
				if(perfilopcion.gettodo()!=null)
				{
					strValorNuevo=perfilopcion.gettodo().toString() ;
				}

				//auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PerfilOpcionConstantesFunciones.TODO,strValorActual,strValorNuevo);
			}	
			
			if(perfilopcion.getIsNew()||!perfilopcion.getingreso().equals(perfilopcion.getPerfilOpcionOriginal().getingreso()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(perfilopcion.getPerfilOpcionOriginal().getingreso()!=null)
				{
					strValorActual=perfilopcion.getPerfilOpcionOriginal().getingreso().toString();
				}
				if(perfilopcion.getingreso()!=null)
				{
					strValorNuevo=perfilopcion.getingreso().toString() ;
				}

				//auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PerfilOpcionConstantesFunciones.INGRESO,strValorActual,strValorNuevo);
			}	
			
			if(perfilopcion.getIsNew()||!perfilopcion.getmodificacion().equals(perfilopcion.getPerfilOpcionOriginal().getmodificacion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(perfilopcion.getPerfilOpcionOriginal().getmodificacion()!=null)
				{
					strValorActual=perfilopcion.getPerfilOpcionOriginal().getmodificacion().toString();
				}
				if(perfilopcion.getmodificacion()!=null)
				{
					strValorNuevo=perfilopcion.getmodificacion().toString() ;
				}

				//auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PerfilOpcionConstantesFunciones.MODIFICACION,strValorActual,strValorNuevo);
			}	
			
			if(perfilopcion.getIsNew()||!perfilopcion.geteliminacion().equals(perfilopcion.getPerfilOpcionOriginal().geteliminacion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(perfilopcion.getPerfilOpcionOriginal().geteliminacion()!=null)
				{
					strValorActual=perfilopcion.getPerfilOpcionOriginal().geteliminacion().toString();
				}
				if(perfilopcion.geteliminacion()!=null)
				{
					strValorNuevo=perfilopcion.geteliminacion().toString() ;
				}

				//auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PerfilOpcionConstantesFunciones.ELIMINACION,strValorActual,strValorNuevo);
			}	
			
			if(perfilopcion.getIsNew()||!perfilopcion.getguardar_cambios().equals(perfilopcion.getPerfilOpcionOriginal().getguardar_cambios()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(perfilopcion.getPerfilOpcionOriginal().getguardar_cambios()!=null)
				{
					strValorActual=perfilopcion.getPerfilOpcionOriginal().getguardar_cambios().toString();
				}
				if(perfilopcion.getguardar_cambios()!=null)
				{
					strValorNuevo=perfilopcion.getguardar_cambios().toString() ;
				}

				//auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PerfilOpcionConstantesFunciones.GUARDARCAMBIOS,strValorActual,strValorNuevo);
			}	
			
			if(perfilopcion.getIsNew()||!perfilopcion.getconsulta().equals(perfilopcion.getPerfilOpcionOriginal().getconsulta()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(perfilopcion.getPerfilOpcionOriginal().getconsulta()!=null)
				{
					strValorActual=perfilopcion.getPerfilOpcionOriginal().getconsulta().toString();
				}
				if(perfilopcion.getconsulta()!=null)
				{
					strValorNuevo=perfilopcion.getconsulta().toString() ;
				}

				//auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PerfilOpcionConstantesFunciones.CONSULTA,strValorActual,strValorNuevo);
			}	
			
			if(perfilopcion.getIsNew()||!perfilopcion.getbusqueda().equals(perfilopcion.getPerfilOpcionOriginal().getbusqueda()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(perfilopcion.getPerfilOpcionOriginal().getbusqueda()!=null)
				{
					strValorActual=perfilopcion.getPerfilOpcionOriginal().getbusqueda().toString();
				}
				if(perfilopcion.getbusqueda()!=null)
				{
					strValorNuevo=perfilopcion.getbusqueda().toString() ;
				}

				//auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PerfilOpcionConstantesFunciones.BUSQUEDA,strValorActual,strValorNuevo);
			}	
			
			if(perfilopcion.getIsNew()||!perfilopcion.getreporte().equals(perfilopcion.getPerfilOpcionOriginal().getreporte()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(perfilopcion.getPerfilOpcionOriginal().getreporte()!=null)
				{
					strValorActual=perfilopcion.getPerfilOpcionOriginal().getreporte().toString();
				}
				if(perfilopcion.getreporte()!=null)
				{
					strValorNuevo=perfilopcion.getreporte().toString() ;
				}

				//auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PerfilOpcionConstantesFunciones.REPORTE,strValorActual,strValorNuevo);
			}	
			
			if(perfilopcion.getIsNew()||!perfilopcion.getorden().equals(perfilopcion.getPerfilOpcionOriginal().getorden()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(perfilopcion.getPerfilOpcionOriginal().getorden()!=null)
				{
					strValorActual=perfilopcion.getPerfilOpcionOriginal().getorden().toString();
				}
				if(perfilopcion.getorden()!=null)
				{
					strValorNuevo=perfilopcion.getorden().toString() ;
				}

				//auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PerfilOpcionConstantesFunciones.ORDEN,strValorActual,strValorNuevo);
			}	
			
			if(perfilopcion.getIsNew()||!perfilopcion.getpaginacion_medio().equals(perfilopcion.getPerfilOpcionOriginal().getpaginacion_medio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(perfilopcion.getPerfilOpcionOriginal().getpaginacion_medio()!=null)
				{
					strValorActual=perfilopcion.getPerfilOpcionOriginal().getpaginacion_medio().toString();
				}
				if(perfilopcion.getpaginacion_medio()!=null)
				{
					strValorNuevo=perfilopcion.getpaginacion_medio().toString() ;
				}

				//auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PerfilOpcionConstantesFunciones.PAGINACIONMEDIO,strValorActual,strValorNuevo);
			}	
			
			if(perfilopcion.getIsNew()||!perfilopcion.getpaginacion_alto().equals(perfilopcion.getPerfilOpcionOriginal().getpaginacion_alto()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(perfilopcion.getPerfilOpcionOriginal().getpaginacion_alto()!=null)
				{
					strValorActual=perfilopcion.getPerfilOpcionOriginal().getpaginacion_alto().toString();
				}
				if(perfilopcion.getpaginacion_alto()!=null)
				{
					strValorNuevo=perfilopcion.getpaginacion_alto().toString() ;
				}

				//auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PerfilOpcionConstantesFunciones.PAGINACIONALTO,strValorActual,strValorNuevo);
			}	
			
			if(perfilopcion.getIsNew()||!perfilopcion.getpaginacion_todo().equals(perfilopcion.getPerfilOpcionOriginal().getpaginacion_todo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(perfilopcion.getPerfilOpcionOriginal().getpaginacion_todo()!=null)
				{
					strValorActual=perfilopcion.getPerfilOpcionOriginal().getpaginacion_todo().toString();
				}
				if(perfilopcion.getpaginacion_todo()!=null)
				{
					strValorNuevo=perfilopcion.getpaginacion_todo().toString() ;
				}

				//auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PerfilOpcionConstantesFunciones.PAGINACIONTODO,strValorActual,strValorNuevo);
			}	
			
			if(perfilopcion.getIsNew()||!perfilopcion.getduplicar().equals(perfilopcion.getPerfilOpcionOriginal().getduplicar()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(perfilopcion.getPerfilOpcionOriginal().getduplicar()!=null)
				{
					strValorActual=perfilopcion.getPerfilOpcionOriginal().getduplicar().toString();
				}
				if(perfilopcion.getduplicar()!=null)
				{
					strValorNuevo=perfilopcion.getduplicar().toString() ;
				}

				//auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PerfilOpcionConstantesFunciones.DUPLICAR,strValorActual,strValorNuevo);
			}	
			
			if(perfilopcion.getIsNew()||!perfilopcion.getcopiar().equals(perfilopcion.getPerfilOpcionOriginal().getcopiar()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(perfilopcion.getPerfilOpcionOriginal().getcopiar()!=null)
				{
					strValorActual=perfilopcion.getPerfilOpcionOriginal().getcopiar().toString();
				}
				if(perfilopcion.getcopiar()!=null)
				{
					strValorNuevo=perfilopcion.getcopiar().toString() ;
				}

				//auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PerfilOpcionConstantesFunciones.COPIAR,strValorActual,strValorNuevo);
			}	
			
			if(perfilopcion.getIsNew()||!perfilopcion.getcon_precargar().equals(perfilopcion.getPerfilOpcionOriginal().getcon_precargar()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(perfilopcion.getPerfilOpcionOriginal().getcon_precargar()!=null)
				{
					strValorActual=perfilopcion.getPerfilOpcionOriginal().getcon_precargar().toString();
				}
				if(perfilopcion.getcon_precargar()!=null)
				{
					strValorNuevo=perfilopcion.getcon_precargar().toString() ;
				}

				//auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PerfilOpcionConstantesFunciones.CONPRECARGAR,strValorActual,strValorNuevo);
			}	
			
			if(perfilopcion.getIsNew()||!perfilopcion.getestado().equals(perfilopcion.getPerfilOpcionOriginal().getestado()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(perfilopcion.getPerfilOpcionOriginal().getestado()!=null)
				{
					strValorActual=perfilopcion.getPerfilOpcionOriginal().getestado().toString();
				}
				if(perfilopcion.getestado()!=null)
				{
					strValorNuevo=perfilopcion.getestado().toString() ;
				}

				//auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PerfilOpcionConstantesFunciones.ESTADO,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void savePerfilOpcionRelacionesWithConnection(PerfilOpcion perfilopcion) throws Exception {

		if(!perfilopcion.getsType().contains(Constantes2.S_TOTALES)) {
			this.savePerfilOpcionRelacionesBase(perfilopcion,true);
		}
	}

	public void savePerfilOpcionRelaciones(PerfilOpcion perfilopcion)throws Exception {

		if(!perfilopcion.getsType().contains(Constantes2.S_TOTALES)) {
			this.savePerfilOpcionRelacionesBase(perfilopcion,false);
		}
	}

	public void savePerfilOpcionRelacionesBase(PerfilOpcion perfilopcion,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("PerfilOpcion-saveRelacionesWithConnection");}
	

			this.setPerfilOpcion(perfilopcion);

			if(PerfilOpcionLogicAdditional.validarSaveRelaciones(perfilopcion,this)) {

				PerfilOpcionLogicAdditional.updateRelacionesToSave(perfilopcion,this);

				if((perfilopcion.getIsNew()||perfilopcion.getIsChanged())&&!perfilopcion.getIsDeleted()) {
					this.savePerfilOpcion();
					this.savePerfilOpcionRelacionesDetalles();

				} else if(perfilopcion.getIsDeleted()) {
					this.savePerfilOpcionRelacionesDetalles();
					this.savePerfilOpcion();
				}

				PerfilOpcionLogicAdditional.updateRelacionesToSaveAfter(perfilopcion,this);

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
	
	
	private void savePerfilOpcionRelacionesDetalles()throws Exception {
		try {
	

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfPerfilOpcion(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=PerfilOpcionConstantesFunciones.getClassesForeignKeysOfPerfilOpcion(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfPerfilOpcion(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=PerfilOpcionConstantesFunciones.getClassesRelationshipsOfPerfilOpcion(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

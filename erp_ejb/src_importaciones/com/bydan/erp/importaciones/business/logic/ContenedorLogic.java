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
package com.bydan.erp.importaciones.business.logic;

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
import com.bydan.erp.importaciones.util.*;
import com.bydan.erp.importaciones.util.ContenedorConstantesFunciones;
import com.bydan.erp.importaciones.util.ContenedorParameterReturnGeneral;
//import com.bydan.erp.importaciones.util.ContenedorParameterGeneral;
import com.bydan.erp.importaciones.business.entity.Contenedor;
import com.bydan.erp.importaciones.business.logic.ContenedorLogicAdditional;
import com.bydan.erp.importaciones.business.dataaccess.*;
import com.bydan.erp.importaciones.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;
import com.bydan.erp.facturacion.business.logic.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.facturacion.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.facturacion.business.dataaccess.*;








@SuppressWarnings("unused")
public class ContenedorLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(ContenedorLogic.class);
	
	protected ContenedorDataAccess contenedorDataAccess; 	
	protected Contenedor contenedor;
	protected List<Contenedor> contenedors;
	protected Object contenedorObject;	
	protected List<Object> contenedorsObject;
	
	public static ClassValidator<Contenedor> contenedorValidator = new ClassValidator<Contenedor>(Contenedor.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected ContenedorLogicAdditional contenedorLogicAdditional=null;
	
	public ContenedorLogicAdditional getContenedorLogicAdditional() {
		return this.contenedorLogicAdditional;
	}
	
	public void setContenedorLogicAdditional(ContenedorLogicAdditional contenedorLogicAdditional) {
		try {
			this.contenedorLogicAdditional=contenedorLogicAdditional;
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
	
	
	
	
	public  ContenedorLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.contenedorDataAccess = new ContenedorDataAccess();
			
			this.contenedors= new ArrayList<Contenedor>();
			this.contenedor= new Contenedor();
			
			this.contenedorObject=new Object();
			this.contenedorsObject=new ArrayList<Object>();
				
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
			
			this.contenedorDataAccess.setConnexionType(this.connexionType);
			this.contenedorDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  ContenedorLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.contenedorDataAccess = new ContenedorDataAccess();
			this.contenedors= new ArrayList<Contenedor>();
			this.contenedor= new Contenedor();
			this.contenedorObject=new Object();
			this.contenedorsObject=new ArrayList<Object>();
			
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
			
			this.contenedorDataAccess.setConnexionType(this.connexionType);
			this.contenedorDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public Contenedor getContenedor() throws Exception {	
		ContenedorLogicAdditional.checkContenedorToGet(contenedor,this.datosCliente,this.arrDatoGeneral);
		ContenedorLogicAdditional.updateContenedorToGet(contenedor,this.arrDatoGeneral);
		
		return contenedor;
	}
		
	public void setContenedor(Contenedor newContenedor) {
		this.contenedor = newContenedor;
	}
	
	public ContenedorDataAccess getContenedorDataAccess() {
		return contenedorDataAccess;
	}
	
	public void setContenedorDataAccess(ContenedorDataAccess newcontenedorDataAccess) {
		this.contenedorDataAccess = newcontenedorDataAccess;
	}
	
	public List<Contenedor> getContenedors() throws Exception {		
		this.quitarContenedorsNulos();
		
		ContenedorLogicAdditional.checkContenedorToGets(contenedors,this.datosCliente,this.arrDatoGeneral);
		
		for (Contenedor contenedorLocal: contenedors ) {
			ContenedorLogicAdditional.updateContenedorToGet(contenedorLocal,this.arrDatoGeneral);
		}
		
		return contenedors;
	}
	
	public void setContenedors(List<Contenedor> newContenedors) {
		this.contenedors = newContenedors;
	}
	
	public Object getContenedorObject() {	
		this.contenedorObject=this.contenedorDataAccess.getEntityObject();
		return this.contenedorObject;
	}
		
	public void setContenedorObject(Object newContenedorObject) {
		this.contenedorObject = newContenedorObject;
	}
	
	public List<Object> getContenedorsObject() {		
		this.contenedorsObject=this.contenedorDataAccess.getEntitiesObject();
		return this.contenedorsObject;
	}
		
	public void setContenedorsObject(List<Object> newContenedorsObject) {
		this.contenedorsObject = newContenedorsObject;
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
		
		if(this.contenedorDataAccess!=null) {
			this.contenedorDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Contenedor.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			contenedorDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			contenedorDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		contenedor = new  Contenedor();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Contenedor.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			contenedor=contenedorDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.contenedor,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ContenedorConstantesFunciones.refrescarForeignKeysDescripcionesContenedor(this.contenedor);
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
		contenedor = new  Contenedor();
		  		  
        try {
			
			contenedor=contenedorDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.contenedor,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ContenedorConstantesFunciones.refrescarForeignKeysDescripcionesContenedor(this.contenedor);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		contenedor = new  Contenedor();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Contenedor.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			contenedor=contenedorDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.contenedor,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ContenedorConstantesFunciones.refrescarForeignKeysDescripcionesContenedor(this.contenedor);
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
		contenedor = new  Contenedor();
		  		  
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
		contenedor = new  Contenedor();
		  		  
        try {
			
			contenedor=contenedorDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.contenedor,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ContenedorConstantesFunciones.refrescarForeignKeysDescripcionesContenedor(this.contenedor);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		contenedor = new  Contenedor();
		  		  
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
		contenedor = new  Contenedor();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Contenedor.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =contenedorDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		contenedor = new  Contenedor();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=contenedorDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		contenedor = new  Contenedor();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Contenedor.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =contenedorDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		contenedor = new  Contenedor();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=contenedorDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		contenedor = new  Contenedor();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Contenedor.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =contenedorDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		contenedor = new  Contenedor();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=contenedorDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		contenedors = new  ArrayList<Contenedor>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Contenedor.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			ContenedorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			contenedors=contenedorDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarContenedor(contenedors);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ContenedorConstantesFunciones.refrescarForeignKeysDescripcionesContenedor(this.contenedors);
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
		contenedors = new  ArrayList<Contenedor>();
		  		  
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
		contenedors = new  ArrayList<Contenedor>();
		  		  
        try {			
			ContenedorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			contenedors=contenedorDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarContenedor(contenedors);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ContenedorConstantesFunciones.refrescarForeignKeysDescripcionesContenedor(this.contenedors);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		contenedors = new  ArrayList<Contenedor>();
		  		  
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
		contenedors = new  ArrayList<Contenedor>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Contenedor.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			ContenedorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			contenedors=contenedorDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarContenedor(contenedors);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ContenedorConstantesFunciones.refrescarForeignKeysDescripcionesContenedor(this.contenedors);
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
		contenedors = new  ArrayList<Contenedor>();
		  		  
        try {
			ContenedorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			contenedors=contenedorDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarContenedor(contenedors);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ContenedorConstantesFunciones.refrescarForeignKeysDescripcionesContenedor(this.contenedors);
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
		contenedors = new  ArrayList<Contenedor>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Contenedor.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ContenedorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			contenedors=contenedorDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarContenedor(contenedors);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ContenedorConstantesFunciones.refrescarForeignKeysDescripcionesContenedor(this.contenedors);
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
		contenedors = new  ArrayList<Contenedor>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ContenedorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			contenedors=contenedorDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarContenedor(contenedors);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ContenedorConstantesFunciones.refrescarForeignKeysDescripcionesContenedor(this.contenedors);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		contenedor = new  Contenedor();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Contenedor.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ContenedorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			contenedor=contenedorDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarContenedor(contenedor);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ContenedorConstantesFunciones.refrescarForeignKeysDescripcionesContenedor(this.contenedor);
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
		contenedor = new  Contenedor();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ContenedorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			contenedor=contenedorDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarContenedor(contenedor);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ContenedorConstantesFunciones.refrescarForeignKeysDescripcionesContenedor(this.contenedor);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		contenedors = new  ArrayList<Contenedor>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Contenedor.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			ContenedorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			contenedors=contenedorDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarContenedor(contenedors);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ContenedorConstantesFunciones.refrescarForeignKeysDescripcionesContenedor(this.contenedors);
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
		contenedors = new  ArrayList<Contenedor>();
		  		  
        try {
			ContenedorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			contenedors=contenedorDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarContenedor(contenedors);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ContenedorConstantesFunciones.refrescarForeignKeysDescripcionesContenedor(this.contenedors);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosContenedorsWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		contenedors = new  ArrayList<Contenedor>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Contenedor.class.getSimpleName()+"-getTodosContenedorsWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ContenedorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			contenedors=contenedorDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarContenedor(contenedors);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ContenedorConstantesFunciones.refrescarForeignKeysDescripcionesContenedor(this.contenedors);
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
	
	public  void  getTodosContenedors(String sFinalQuery,Pagination pagination)throws Exception {
		contenedors = new  ArrayList<Contenedor>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ContenedorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			contenedors=contenedorDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarContenedor(contenedors);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ContenedorConstantesFunciones.refrescarForeignKeysDescripcionesContenedor(this.contenedors);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarContenedor(Contenedor contenedor) throws Exception {
		Boolean estaValidado=false;
		
		if(contenedor.getIsNew() || contenedor.getIsChanged()) { 
			this.invalidValues = contenedorValidator.getInvalidValues(contenedor);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(contenedor);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarContenedor(List<Contenedor> Contenedors) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(Contenedor contenedorLocal:contenedors) {				
			estaValidadoObjeto=this.validarGuardarContenedor(contenedorLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarContenedor(List<Contenedor> Contenedors) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarContenedor(contenedors)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarContenedor(Contenedor Contenedor) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarContenedor(contenedor)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(Contenedor contenedor) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+contenedor.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=ContenedorConstantesFunciones.getContenedorLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"contenedor","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(ContenedorConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(ContenedorConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveContenedorWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Contenedor.class.getSimpleName()+"-saveContenedorWithConnection");connexion.begin();			
			
			ContenedorLogicAdditional.checkContenedorToSave(this.contenedor,this.datosCliente,connexion,this.arrDatoGeneral);
			
			ContenedorLogicAdditional.updateContenedorToSave(this.contenedor,this.arrDatoGeneral);
			
			ContenedorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.contenedor,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowContenedor();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarContenedor(this.contenedor)) {
				ContenedorDataAccess.save(this.contenedor, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.contenedor,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			ContenedorLogicAdditional.checkContenedorToSaveAfter(this.contenedor,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowContenedor();
			
			connexion.commit();			
			
			if(this.contenedor.getIsDeleted()) {
				this.contenedor=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveContenedor()throws Exception {	
		try {	
			
			ContenedorLogicAdditional.checkContenedorToSave(this.contenedor,this.datosCliente,connexion,this.arrDatoGeneral);
			
			ContenedorLogicAdditional.updateContenedorToSave(this.contenedor,this.arrDatoGeneral);
			
			ContenedorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.contenedor,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarContenedor(this.contenedor)) {			
				ContenedorDataAccess.save(this.contenedor, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.contenedor,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			ContenedorLogicAdditional.checkContenedorToSaveAfter(this.contenedor,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.contenedor.getIsDeleted()) {
				this.contenedor=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveContenedorsWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Contenedor.class.getSimpleName()+"-saveContenedorsWithConnection");connexion.begin();			
			
			ContenedorLogicAdditional.checkContenedorToSaves(contenedors,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowContenedors();
			
			Boolean validadoTodosContenedor=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(Contenedor contenedorLocal:contenedors) {		
				if(contenedorLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				ContenedorLogicAdditional.updateContenedorToSave(contenedorLocal,this.arrDatoGeneral);
	        	
				ContenedorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),contenedorLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarContenedor(contenedorLocal)) {
					ContenedorDataAccess.save(contenedorLocal, connexion);				
				} else {
					validadoTodosContenedor=false;
				}
			}
			
			if(!validadoTodosContenedor) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			ContenedorLogicAdditional.checkContenedorToSavesAfter(contenedors,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowContenedors();
			
			connexion.commit();		
			
			this.quitarContenedorsEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveContenedors()throws Exception {				
		 try {	
			ContenedorLogicAdditional.checkContenedorToSaves(contenedors,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosContenedor=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(Contenedor contenedorLocal:contenedors) {				
				if(contenedorLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				ContenedorLogicAdditional.updateContenedorToSave(contenedorLocal,this.arrDatoGeneral);
	        	
				ContenedorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),contenedorLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarContenedor(contenedorLocal)) {				
					ContenedorDataAccess.save(contenedorLocal, connexion);				
				} else {
					validadoTodosContenedor=false;
				}
			}
			
			if(!validadoTodosContenedor) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			ContenedorLogicAdditional.checkContenedorToSavesAfter(contenedors,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarContenedorsEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public ContenedorParameterReturnGeneral procesarAccionContenedors(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<Contenedor> contenedors,ContenedorParameterReturnGeneral contenedorParameterGeneral)throws Exception {
		 try {	
			ContenedorParameterReturnGeneral contenedorReturnGeneral=new ContenedorParameterReturnGeneral();
	
			ContenedorLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,contenedors,contenedorParameterGeneral,contenedorReturnGeneral);
			
			return contenedorReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public ContenedorParameterReturnGeneral procesarAccionContenedorsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<Contenedor> contenedors,ContenedorParameterReturnGeneral contenedorParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Contenedor.class.getSimpleName()+"-procesarAccionContenedorsWithConnection");connexion.begin();			
			
			ContenedorParameterReturnGeneral contenedorReturnGeneral=new ContenedorParameterReturnGeneral();
	
			ContenedorLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,contenedors,contenedorParameterGeneral,contenedorReturnGeneral);
			
			this.connexion.commit();
			
			return contenedorReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public ContenedorParameterReturnGeneral procesarEventosContenedors(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<Contenedor> contenedors,Contenedor contenedor,ContenedorParameterReturnGeneral contenedorParameterGeneral,Boolean isEsNuevoContenedor,ArrayList<Classe> clases)throws Exception {
		 try {	
			ContenedorParameterReturnGeneral contenedorReturnGeneral=new ContenedorParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				contenedorReturnGeneral.setConRecargarPropiedades(true);
			}
			
			ContenedorLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,contenedors,contenedor,contenedorParameterGeneral,contenedorReturnGeneral,isEsNuevoContenedor,clases);
			
			return contenedorReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public ContenedorParameterReturnGeneral procesarEventosContenedorsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<Contenedor> contenedors,Contenedor contenedor,ContenedorParameterReturnGeneral contenedorParameterGeneral,Boolean isEsNuevoContenedor,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Contenedor.class.getSimpleName()+"-procesarEventosContenedorsWithConnection");connexion.begin();			
			
			ContenedorParameterReturnGeneral contenedorReturnGeneral=new ContenedorParameterReturnGeneral();
	
			contenedorReturnGeneral.setContenedor(contenedor);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				contenedorReturnGeneral.setConRecargarPropiedades(true);
			}
			
			ContenedorLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,contenedors,contenedor,contenedorParameterGeneral,contenedorReturnGeneral,isEsNuevoContenedor,clases);
			
			this.connexion.commit();
			
			return contenedorReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public ContenedorParameterReturnGeneral procesarImportacionContenedorsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,ContenedorParameterReturnGeneral contenedorParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Contenedor.class.getSimpleName()+"-procesarImportacionContenedorsWithConnection");connexion.begin();			
			
			ContenedorParameterReturnGeneral contenedorReturnGeneral=new ContenedorParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.contenedors=new ArrayList<Contenedor>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.contenedor=new Contenedor();
				
				
				if(conColumnasBase) {this.contenedor.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.contenedor.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.contenedor.setnumero(arrColumnas[iColumn++]);
				this.contenedor.setnumero_bl(arrColumnas[iColumn++]);
				this.contenedor.setdescripcion(arrColumnas[iColumn++]);
				
				this.contenedors.add(this.contenedor);
			}
			
			this.saveContenedors();
			
			this.connexion.commit();
			
			contenedorReturnGeneral.setConRetornoEstaProcesado(true);
			contenedorReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return contenedorReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarContenedorsEliminados() throws Exception {				
		
		List<Contenedor> contenedorsAux= new ArrayList<Contenedor>();
		
		for(Contenedor contenedor:contenedors) {
			if(!contenedor.getIsDeleted()) {
				contenedorsAux.add(contenedor);
			}
		}
		
		contenedors=contenedorsAux;
	}
	
	public void quitarContenedorsNulos() throws Exception {				
		
		List<Contenedor> contenedorsAux= new ArrayList<Contenedor>();
		
		for(Contenedor contenedor : this.contenedors) {
			if(contenedor==null) {
				contenedorsAux.add(contenedor);
			}
		}
		
		//this.contenedors=contenedorsAux;
		
		this.contenedors.removeAll(contenedorsAux);
	}
	
	public void getSetVersionRowContenedorWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(contenedor.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((contenedor.getIsDeleted() || (contenedor.getIsChanged()&&!contenedor.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=contenedorDataAccess.getSetVersionRowContenedor(connexion,contenedor.getId());
				
				if(!contenedor.getVersionRow().equals(timestamp)) {	
					contenedor.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				contenedor.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowContenedor()throws Exception {	
		
		if(contenedor.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((contenedor.getIsDeleted() || (contenedor.getIsChanged()&&!contenedor.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=contenedorDataAccess.getSetVersionRowContenedor(connexion,contenedor.getId());
			
			try {							
				if(!contenedor.getVersionRow().equals(timestamp)) {	
					contenedor.setVersionRow(timestamp);
				}
				
				contenedor.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowContenedorsWithConnection()throws Exception {	
		if(contenedors!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(Contenedor contenedorAux:contenedors) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(contenedorAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(contenedorAux.getIsDeleted() || (contenedorAux.getIsChanged()&&!contenedorAux.getIsNew())) {
						
						timestamp=contenedorDataAccess.getSetVersionRowContenedor(connexion,contenedorAux.getId());
						
						if(!contenedor.getVersionRow().equals(timestamp)) {	
							contenedorAux.setVersionRow(timestamp);
						}
								
						contenedorAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowContenedors()throws Exception {	
		if(contenedors!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(Contenedor contenedorAux:contenedors) {
					if(contenedorAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(contenedorAux.getIsDeleted() || (contenedorAux.getIsChanged()&&!contenedorAux.getIsNew())) {
						
						timestamp=contenedorDataAccess.getSetVersionRowContenedor(connexion,contenedorAux.getId());
						
						if(!contenedorAux.getVersionRow().equals(timestamp)) {	
							contenedorAux.setVersionRow(timestamp);
						}
						
													
						contenedorAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public ContenedorParameterReturnGeneral cargarCombosLoteForeignKeyContenedorWithConnection(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalPedido) throws Exception {
		ContenedorParameterReturnGeneral  contenedorReturnGeneral =new ContenedorParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Contenedor.class.getSimpleName()+"-cargarCombosLoteForeignKeyContenedorWithConnection");connexion.begin();
			
			contenedorReturnGeneral =new ContenedorParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			contenedorReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			contenedorReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Pedido> pedidosForeignKey=new ArrayList<Pedido>();
			PedidoLogic pedidoLogic=new PedidoLogic();
			pedidoLogic.setConnexion(this.connexion);
			pedidoLogic.getPedidoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPedido.equals("NONE")) {
				pedidoLogic.getTodosPedidos(finalQueryGlobalPedido,new Pagination());
				pedidosForeignKey=pedidoLogic.getPedidos();
			}

			contenedorReturnGeneral.setpedidosForeignKey(pedidosForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return contenedorReturnGeneral;
	}
	
	public ContenedorParameterReturnGeneral cargarCombosLoteForeignKeyContenedor(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalPedido) throws Exception {
		ContenedorParameterReturnGeneral  contenedorReturnGeneral =new ContenedorParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			contenedorReturnGeneral =new ContenedorParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			contenedorReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			contenedorReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Pedido> pedidosForeignKey=new ArrayList<Pedido>();
			PedidoLogic pedidoLogic=new PedidoLogic();
			pedidoLogic.setConnexion(this.connexion);
			pedidoLogic.getPedidoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPedido.equals("NONE")) {
				pedidoLogic.getTodosPedidos(finalQueryGlobalPedido,new Pagination());
				pedidosForeignKey=pedidoLogic.getPedidos();
			}

			contenedorReturnGeneral.setpedidosForeignKey(pedidosForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return contenedorReturnGeneral;
	}
	
	
	public void deepLoad(Contenedor contenedor,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			ContenedorLogicAdditional.updateContenedorToGet(contenedor,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		contenedor.setEmpresa(contenedorDataAccess.getEmpresa(connexion,contenedor));
		contenedor.setSucursal(contenedorDataAccess.getSucursal(connexion,contenedor));
		contenedor.setPedido(contenedorDataAccess.getPedido(connexion,contenedor));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				contenedor.setEmpresa(contenedorDataAccess.getEmpresa(connexion,contenedor));
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				contenedor.setSucursal(contenedorDataAccess.getSucursal(connexion,contenedor));
				continue;
			}

			if(clas.clas.equals(Pedido.class)) {
				contenedor.setPedido(contenedorDataAccess.getPedido(connexion,contenedor));
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
			contenedor.setEmpresa(contenedorDataAccess.getEmpresa(connexion,contenedor));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			contenedor.setSucursal(contenedorDataAccess.getSucursal(connexion,contenedor));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Pedido.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			contenedor.setPedido(contenedorDataAccess.getPedido(connexion,contenedor));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		contenedor.setEmpresa(contenedorDataAccess.getEmpresa(connexion,contenedor));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(contenedor.getEmpresa(),isDeep,deepLoadType,clases);
				
		contenedor.setSucursal(contenedorDataAccess.getSucursal(connexion,contenedor));
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(contenedor.getSucursal(),isDeep,deepLoadType,clases);
				
		contenedor.setPedido(contenedorDataAccess.getPedido(connexion,contenedor));
		PedidoLogic pedidoLogic= new PedidoLogic(connexion);
		pedidoLogic.deepLoad(contenedor.getPedido(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				contenedor.setEmpresa(contenedorDataAccess.getEmpresa(connexion,contenedor));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(contenedor.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				contenedor.setSucursal(contenedorDataAccess.getSucursal(connexion,contenedor));
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepLoad(contenedor.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Pedido.class)) {
				contenedor.setPedido(contenedorDataAccess.getPedido(connexion,contenedor));
				PedidoLogic pedidoLogic= new PedidoLogic(connexion);
				pedidoLogic.deepLoad(contenedor.getPedido(),isDeep,deepLoadType,clases);				
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
			contenedor.setEmpresa(contenedorDataAccess.getEmpresa(connexion,contenedor));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(contenedor.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			contenedor.setSucursal(contenedorDataAccess.getSucursal(connexion,contenedor));
			SucursalLogic sucursalLogic= new SucursalLogic(connexion);
			sucursalLogic.deepLoad(contenedor.getSucursal(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Pedido.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			contenedor.setPedido(contenedorDataAccess.getPedido(connexion,contenedor));
			PedidoLogic pedidoLogic= new PedidoLogic(connexion);
			pedidoLogic.deepLoad(contenedor.getPedido(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(Contenedor contenedor,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			ContenedorLogicAdditional.updateContenedorToSave(contenedor,this.arrDatoGeneral);
			
ContenedorDataAccess.save(contenedor, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(contenedor.getEmpresa(),connexion);

		SucursalDataAccess.save(contenedor.getSucursal(),connexion);

		PedidoDataAccess.save(contenedor.getPedido(),connexion);
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(contenedor.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(contenedor.getSucursal(),connexion);
				continue;
			}

			if(clas.clas.equals(Pedido.class)) {
				PedidoDataAccess.save(contenedor.getPedido(),connexion);
				continue;
			}

		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(contenedor.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(contenedor.getEmpresa(),isDeep,deepLoadType,clases);
				

		SucursalDataAccess.save(contenedor.getSucursal(),connexion);
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(contenedor.getSucursal(),isDeep,deepLoadType,clases);
				

		PedidoDataAccess.save(contenedor.getPedido(),connexion);
		PedidoLogic pedidoLogic= new PedidoLogic(connexion);
		pedidoLogic.deepLoad(contenedor.getPedido(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(contenedor.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(contenedor.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(contenedor.getSucursal(),connexion);
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepSave(contenedor.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Pedido.class)) {
				PedidoDataAccess.save(contenedor.getPedido(),connexion);
				PedidoLogic pedidoLogic= new PedidoLogic(connexion);
				pedidoLogic.deepSave(contenedor.getPedido(),isDeep,deepLoadType,clases);				
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
			this.getNewConnexionToDeep(Contenedor.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(contenedor,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				ContenedorConstantesFunciones.refrescarForeignKeysDescripcionesContenedor(contenedor);
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
			this.deepLoad(this.contenedor,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				ContenedorConstantesFunciones.refrescarForeignKeysDescripcionesContenedor(this.contenedor);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(Contenedor.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(contenedors!=null) {
				for(Contenedor contenedor:contenedors) {
					this.deepLoad(contenedor,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					ContenedorConstantesFunciones.refrescarForeignKeysDescripcionesContenedor(contenedors);
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
			if(contenedors!=null) {
				for(Contenedor contenedor:contenedors) {
					this.deepLoad(contenedor,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					ContenedorConstantesFunciones.refrescarForeignKeysDescripcionesContenedor(contenedors);
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
			this.getNewConnexionToDeep(Contenedor.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(contenedor,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(Contenedor.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(contenedors!=null) {
				for(Contenedor contenedor:contenedors) {
					this.deepSave(contenedor,isDeep,deepLoadType,clases);
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
			if(contenedors!=null) {
				for(Contenedor contenedor:contenedors) {
					this.deepSave(contenedor,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getContenedorsFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Contenedor.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,ContenedorConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			ContenedorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			contenedors=contenedorDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ContenedorConstantesFunciones.refrescarForeignKeysDescripcionesContenedor(this.contenedors);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getContenedorsFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,ContenedorConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			ContenedorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			contenedors=contenedorDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ContenedorConstantesFunciones.refrescarForeignKeysDescripcionesContenedor(this.contenedors);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getContenedorsFK_IdPedidoWithConnection(String sFinalQuery,Pagination pagination,Long id_pedido)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Contenedor.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPedido= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPedido.setParameterSelectionGeneralEqual(ParameterType.LONG,id_pedido,ContenedorConstantesFunciones.IDPEDIDO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPedido);

			ContenedorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPedido","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			contenedors=contenedorDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ContenedorConstantesFunciones.refrescarForeignKeysDescripcionesContenedor(this.contenedors);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getContenedorsFK_IdPedido(String sFinalQuery,Pagination pagination,Long id_pedido)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPedido= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPedido.setParameterSelectionGeneralEqual(ParameterType.LONG,id_pedido,ContenedorConstantesFunciones.IDPEDIDO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPedido);

			ContenedorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPedido","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			contenedors=contenedorDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ContenedorConstantesFunciones.refrescarForeignKeysDescripcionesContenedor(this.contenedors);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getContenedorsFK_IdSucursalWithConnection(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Contenedor.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,ContenedorConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			ContenedorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			contenedors=contenedorDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ContenedorConstantesFunciones.refrescarForeignKeysDescripcionesContenedor(this.contenedors);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getContenedorsFK_IdSucursal(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,ContenedorConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			ContenedorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			contenedors=contenedorDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ContenedorConstantesFunciones.refrescarForeignKeysDescripcionesContenedor(this.contenedors);
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
			if(ContenedorConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,ContenedorDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,Contenedor contenedor,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(ContenedorConstantesFunciones.ISCONAUDITORIA) {
				if(contenedor.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,ContenedorDataAccess.TABLENAME, contenedor.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(ContenedorConstantesFunciones.ISCONAUDITORIADETALLE) {
						////ContenedorLogic.registrarAuditoriaDetallesContenedor(connexion,contenedor,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(contenedor.getIsDeleted()) {
					/*if(!contenedor.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,ContenedorDataAccess.TABLENAME, contenedor.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////ContenedorLogic.registrarAuditoriaDetallesContenedor(connexion,contenedor,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,ContenedorDataAccess.TABLENAME, contenedor.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(contenedor.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,ContenedorDataAccess.TABLENAME, contenedor.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(ContenedorConstantesFunciones.ISCONAUDITORIADETALLE) {
						////ContenedorLogic.registrarAuditoriaDetallesContenedor(connexion,contenedor,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesContenedor(Connexion connexion,Contenedor contenedor)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(contenedor.getIsNew()||!contenedor.getid_empresa().equals(contenedor.getContenedorOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(contenedor.getContenedorOriginal().getid_empresa()!=null)
				{
					strValorActual=contenedor.getContenedorOriginal().getid_empresa().toString();
				}
				if(contenedor.getid_empresa()!=null)
				{
					strValorNuevo=contenedor.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ContenedorConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(contenedor.getIsNew()||!contenedor.getid_sucursal().equals(contenedor.getContenedorOriginal().getid_sucursal()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(contenedor.getContenedorOriginal().getid_sucursal()!=null)
				{
					strValorActual=contenedor.getContenedorOriginal().getid_sucursal().toString();
				}
				if(contenedor.getid_sucursal()!=null)
				{
					strValorNuevo=contenedor.getid_sucursal().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ContenedorConstantesFunciones.IDSUCURSAL,strValorActual,strValorNuevo);
			}	
			
			if(contenedor.getIsNew()||!contenedor.getid_pedido().equals(contenedor.getContenedorOriginal().getid_pedido()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(contenedor.getContenedorOriginal().getid_pedido()!=null)
				{
					strValorActual=contenedor.getContenedorOriginal().getid_pedido().toString();
				}
				if(contenedor.getid_pedido()!=null)
				{
					strValorNuevo=contenedor.getid_pedido().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ContenedorConstantesFunciones.IDPEDIDO,strValorActual,strValorNuevo);
			}	
			
			if(contenedor.getIsNew()||!contenedor.getnumero().equals(contenedor.getContenedorOriginal().getnumero()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(contenedor.getContenedorOriginal().getnumero()!=null)
				{
					strValorActual=contenedor.getContenedorOriginal().getnumero();
				}
				if(contenedor.getnumero()!=null)
				{
					strValorNuevo=contenedor.getnumero() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ContenedorConstantesFunciones.NUMERO,strValorActual,strValorNuevo);
			}	
			
			if(contenedor.getIsNew()||!contenedor.getnumero_bl().equals(contenedor.getContenedorOriginal().getnumero_bl()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(contenedor.getContenedorOriginal().getnumero_bl()!=null)
				{
					strValorActual=contenedor.getContenedorOriginal().getnumero_bl();
				}
				if(contenedor.getnumero_bl()!=null)
				{
					strValorNuevo=contenedor.getnumero_bl() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ContenedorConstantesFunciones.NUMEROBL,strValorActual,strValorNuevo);
			}	
			
			if(contenedor.getIsNew()||!contenedor.getdescripcion().equals(contenedor.getContenedorOriginal().getdescripcion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(contenedor.getContenedorOriginal().getdescripcion()!=null)
				{
					strValorActual=contenedor.getContenedorOriginal().getdescripcion();
				}
				if(contenedor.getdescripcion()!=null)
				{
					strValorNuevo=contenedor.getdescripcion() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ContenedorConstantesFunciones.DESCRIPCION,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveContenedorRelacionesWithConnection(Contenedor contenedor) throws Exception {

		if(!contenedor.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveContenedorRelacionesBase(contenedor,true);
		}
	}

	public void saveContenedorRelaciones(Contenedor contenedor)throws Exception {

		if(!contenedor.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveContenedorRelacionesBase(contenedor,false);
		}
	}

	public void saveContenedorRelacionesBase(Contenedor contenedor,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("Contenedor-saveRelacionesWithConnection");}
	

			this.setContenedor(contenedor);

			if(ContenedorLogicAdditional.validarSaveRelaciones(contenedor,this)) {

				ContenedorLogicAdditional.updateRelacionesToSave(contenedor,this);

				if((contenedor.getIsNew()||contenedor.getIsChanged())&&!contenedor.getIsDeleted()) {
					this.saveContenedor();
					this.saveContenedorRelacionesDetalles();

				} else if(contenedor.getIsDeleted()) {
					this.saveContenedorRelacionesDetalles();
					this.saveContenedor();
				}

				ContenedorLogicAdditional.updateRelacionesToSaveAfter(contenedor,this);

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
	
	
	private void saveContenedorRelacionesDetalles()throws Exception {
		try {
	

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfContenedor(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=ContenedorConstantesFunciones.getClassesForeignKeysOfContenedor(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfContenedor(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=ContenedorConstantesFunciones.getClassesRelationshipsOfContenedor(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

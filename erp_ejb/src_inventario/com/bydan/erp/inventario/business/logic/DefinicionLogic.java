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
import com.bydan.erp.inventario.util.DefinicionConstantesFunciones;
import com.bydan.erp.inventario.util.DefinicionParameterReturnGeneral;
//import com.bydan.erp.inventario.util.DefinicionParameterGeneral;
import com.bydan.erp.inventario.business.entity.Definicion;
import com.bydan.erp.inventario.business.logic.DefinicionLogicAdditional;
import com.bydan.erp.inventario.business.dataaccess.*;
import com.bydan.erp.inventario.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;
import com.bydan.erp.tesoreria.business.logic.*;
import com.bydan.erp.cartera.business.logic.*;
import com.bydan.erp.contabilidad.business.logic.*;
import com.bydan.erp.facturacion.business.logic.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.tesoreria.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.facturacion.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.tesoreria.business.dataaccess.*;
import com.bydan.erp.cartera.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;
import com.bydan.erp.facturacion.business.dataaccess.*;








@SuppressWarnings("unused")
public class DefinicionLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(DefinicionLogic.class);
	
	protected DefinicionDataAccess definicionDataAccess; 	
	protected Definicion definicion;
	protected List<Definicion> definicions;
	protected Object definicionObject;	
	protected List<Object> definicionsObject;
	
	public static ClassValidator<Definicion> definicionValidator = new ClassValidator<Definicion>(Definicion.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected DefinicionLogicAdditional definicionLogicAdditional=null;
	
	public DefinicionLogicAdditional getDefinicionLogicAdditional() {
		return this.definicionLogicAdditional;
	}
	
	public void setDefinicionLogicAdditional(DefinicionLogicAdditional definicionLogicAdditional) {
		try {
			this.definicionLogicAdditional=definicionLogicAdditional;
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
	
	
	
	
	public  DefinicionLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.definicionDataAccess = new DefinicionDataAccess();
			
			this.definicions= new ArrayList<Definicion>();
			this.definicion= new Definicion();
			
			this.definicionObject=new Object();
			this.definicionsObject=new ArrayList<Object>();
				
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
			
			this.definicionDataAccess.setConnexionType(this.connexionType);
			this.definicionDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  DefinicionLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.definicionDataAccess = new DefinicionDataAccess();
			this.definicions= new ArrayList<Definicion>();
			this.definicion= new Definicion();
			this.definicionObject=new Object();
			this.definicionsObject=new ArrayList<Object>();
			
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
			
			this.definicionDataAccess.setConnexionType(this.connexionType);
			this.definicionDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public Definicion getDefinicion() throws Exception {	
		DefinicionLogicAdditional.checkDefinicionToGet(definicion,this.datosCliente,this.arrDatoGeneral);
		DefinicionLogicAdditional.updateDefinicionToGet(definicion,this.arrDatoGeneral);
		
		return definicion;
	}
		
	public void setDefinicion(Definicion newDefinicion) {
		this.definicion = newDefinicion;
	}
	
	public DefinicionDataAccess getDefinicionDataAccess() {
		return definicionDataAccess;
	}
	
	public void setDefinicionDataAccess(DefinicionDataAccess newdefinicionDataAccess) {
		this.definicionDataAccess = newdefinicionDataAccess;
	}
	
	public List<Definicion> getDefinicions() throws Exception {		
		this.quitarDefinicionsNulos();
		
		DefinicionLogicAdditional.checkDefinicionToGets(definicions,this.datosCliente,this.arrDatoGeneral);
		
		for (Definicion definicionLocal: definicions ) {
			DefinicionLogicAdditional.updateDefinicionToGet(definicionLocal,this.arrDatoGeneral);
		}
		
		return definicions;
	}
	
	public void setDefinicions(List<Definicion> newDefinicions) {
		this.definicions = newDefinicions;
	}
	
	public Object getDefinicionObject() {	
		this.definicionObject=this.definicionDataAccess.getEntityObject();
		return this.definicionObject;
	}
		
	public void setDefinicionObject(Object newDefinicionObject) {
		this.definicionObject = newDefinicionObject;
	}
	
	public List<Object> getDefinicionsObject() {		
		this.definicionsObject=this.definicionDataAccess.getEntitiesObject();
		return this.definicionsObject;
	}
		
	public void setDefinicionsObject(List<Object> newDefinicionsObject) {
		this.definicionsObject = newDefinicionsObject;
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
		
		if(this.definicionDataAccess!=null) {
			this.definicionDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Definicion.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			definicionDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			definicionDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		definicion = new  Definicion();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Definicion.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			definicion=definicionDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.definicion,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				DefinicionConstantesFunciones.refrescarForeignKeysDescripcionesDefinicion(this.definicion);
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
		definicion = new  Definicion();
		  		  
        try {
			
			definicion=definicionDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.definicion,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				DefinicionConstantesFunciones.refrescarForeignKeysDescripcionesDefinicion(this.definicion);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		definicion = new  Definicion();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Definicion.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			definicion=definicionDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.definicion,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				DefinicionConstantesFunciones.refrescarForeignKeysDescripcionesDefinicion(this.definicion);
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
		definicion = new  Definicion();
		  		  
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
		definicion = new  Definicion();
		  		  
        try {
			
			definicion=definicionDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.definicion,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				DefinicionConstantesFunciones.refrescarForeignKeysDescripcionesDefinicion(this.definicion);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		definicion = new  Definicion();
		  		  
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
		definicion = new  Definicion();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Definicion.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =definicionDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		definicion = new  Definicion();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=definicionDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		definicion = new  Definicion();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Definicion.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =definicionDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		definicion = new  Definicion();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=definicionDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		definicion = new  Definicion();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Definicion.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =definicionDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		definicion = new  Definicion();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=definicionDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		definicions = new  ArrayList<Definicion>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Definicion.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			DefinicionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			definicions=definicionDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarDefinicion(definicions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DefinicionConstantesFunciones.refrescarForeignKeysDescripcionesDefinicion(this.definicions);
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
		definicions = new  ArrayList<Definicion>();
		  		  
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
		definicions = new  ArrayList<Definicion>();
		  		  
        try {			
			DefinicionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			definicions=definicionDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarDefinicion(definicions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DefinicionConstantesFunciones.refrescarForeignKeysDescripcionesDefinicion(this.definicions);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		definicions = new  ArrayList<Definicion>();
		  		  
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
		definicions = new  ArrayList<Definicion>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Definicion.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			DefinicionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			definicions=definicionDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarDefinicion(definicions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DefinicionConstantesFunciones.refrescarForeignKeysDescripcionesDefinicion(this.definicions);
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
		definicions = new  ArrayList<Definicion>();
		  		  
        try {
			DefinicionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			definicions=definicionDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarDefinicion(definicions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DefinicionConstantesFunciones.refrescarForeignKeysDescripcionesDefinicion(this.definicions);
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
		definicions = new  ArrayList<Definicion>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Definicion.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DefinicionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			definicions=definicionDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarDefinicion(definicions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DefinicionConstantesFunciones.refrescarForeignKeysDescripcionesDefinicion(this.definicions);
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
		definicions = new  ArrayList<Definicion>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DefinicionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			definicions=definicionDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarDefinicion(definicions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DefinicionConstantesFunciones.refrescarForeignKeysDescripcionesDefinicion(this.definicions);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		definicion = new  Definicion();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Definicion.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DefinicionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			definicion=definicionDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarDefinicion(definicion);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DefinicionConstantesFunciones.refrescarForeignKeysDescripcionesDefinicion(this.definicion);
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
		definicion = new  Definicion();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DefinicionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			definicion=definicionDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarDefinicion(definicion);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DefinicionConstantesFunciones.refrescarForeignKeysDescripcionesDefinicion(this.definicion);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		definicions = new  ArrayList<Definicion>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Definicion.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			DefinicionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			definicions=definicionDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarDefinicion(definicions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DefinicionConstantesFunciones.refrescarForeignKeysDescripcionesDefinicion(this.definicions);
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
		definicions = new  ArrayList<Definicion>();
		  		  
        try {
			DefinicionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			definicions=definicionDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarDefinicion(definicions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DefinicionConstantesFunciones.refrescarForeignKeysDescripcionesDefinicion(this.definicions);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosDefinicionsWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		definicions = new  ArrayList<Definicion>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Definicion.class.getSimpleName()+"-getTodosDefinicionsWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DefinicionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			definicions=definicionDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarDefinicion(definicions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DefinicionConstantesFunciones.refrescarForeignKeysDescripcionesDefinicion(this.definicions);
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
	
	public  void  getTodosDefinicions(String sFinalQuery,Pagination pagination)throws Exception {
		definicions = new  ArrayList<Definicion>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DefinicionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			definicions=definicionDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarDefinicion(definicions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DefinicionConstantesFunciones.refrescarForeignKeysDescripcionesDefinicion(this.definicions);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarDefinicion(Definicion definicion) throws Exception {
		Boolean estaValidado=false;
		
		if(definicion.getIsNew() || definicion.getIsChanged()) { 
			this.invalidValues = definicionValidator.getInvalidValues(definicion);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(definicion);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarDefinicion(List<Definicion> Definicions) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(Definicion definicionLocal:definicions) {				
			estaValidadoObjeto=this.validarGuardarDefinicion(definicionLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarDefinicion(List<Definicion> Definicions) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarDefinicion(definicions)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarDefinicion(Definicion Definicion) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarDefinicion(definicion)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(Definicion definicion) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+definicion.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=DefinicionConstantesFunciones.getDefinicionLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"definicion","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(DefinicionConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(DefinicionConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveDefinicionWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Definicion.class.getSimpleName()+"-saveDefinicionWithConnection");connexion.begin();			
			
			DefinicionLogicAdditional.checkDefinicionToSave(this.definicion,this.datosCliente,connexion,this.arrDatoGeneral);
			
			DefinicionLogicAdditional.updateDefinicionToSave(this.definicion,this.arrDatoGeneral);
			
			DefinicionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.definicion,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowDefinicion();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarDefinicion(this.definicion)) {
				DefinicionDataAccess.save(this.definicion, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.definicion,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			DefinicionLogicAdditional.checkDefinicionToSaveAfter(this.definicion,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowDefinicion();
			
			connexion.commit();			
			
			if(this.definicion.getIsDeleted()) {
				this.definicion=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveDefinicion()throws Exception {	
		try {	
			
			DefinicionLogicAdditional.checkDefinicionToSave(this.definicion,this.datosCliente,connexion,this.arrDatoGeneral);
			
			DefinicionLogicAdditional.updateDefinicionToSave(this.definicion,this.arrDatoGeneral);
			
			DefinicionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.definicion,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarDefinicion(this.definicion)) {			
				DefinicionDataAccess.save(this.definicion, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.definicion,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			DefinicionLogicAdditional.checkDefinicionToSaveAfter(this.definicion,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.definicion.getIsDeleted()) {
				this.definicion=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveDefinicionsWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Definicion.class.getSimpleName()+"-saveDefinicionsWithConnection");connexion.begin();			
			
			DefinicionLogicAdditional.checkDefinicionToSaves(definicions,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowDefinicions();
			
			Boolean validadoTodosDefinicion=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(Definicion definicionLocal:definicions) {		
				if(definicionLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				DefinicionLogicAdditional.updateDefinicionToSave(definicionLocal,this.arrDatoGeneral);
	        	
				DefinicionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),definicionLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarDefinicion(definicionLocal)) {
					DefinicionDataAccess.save(definicionLocal, connexion);				
				} else {
					validadoTodosDefinicion=false;
				}
			}
			
			if(!validadoTodosDefinicion) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			DefinicionLogicAdditional.checkDefinicionToSavesAfter(definicions,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowDefinicions();
			
			connexion.commit();		
			
			this.quitarDefinicionsEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveDefinicions()throws Exception {				
		 try {	
			DefinicionLogicAdditional.checkDefinicionToSaves(definicions,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosDefinicion=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(Definicion definicionLocal:definicions) {				
				if(definicionLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				DefinicionLogicAdditional.updateDefinicionToSave(definicionLocal,this.arrDatoGeneral);
	        	
				DefinicionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),definicionLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarDefinicion(definicionLocal)) {				
					DefinicionDataAccess.save(definicionLocal, connexion);				
				} else {
					validadoTodosDefinicion=false;
				}
			}
			
			if(!validadoTodosDefinicion) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			DefinicionLogicAdditional.checkDefinicionToSavesAfter(definicions,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarDefinicionsEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public DefinicionParameterReturnGeneral procesarAccionDefinicions(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<Definicion> definicions,DefinicionParameterReturnGeneral definicionParameterGeneral)throws Exception {
		 try {	
			DefinicionParameterReturnGeneral definicionReturnGeneral=new DefinicionParameterReturnGeneral();
	
			DefinicionLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,definicions,definicionParameterGeneral,definicionReturnGeneral);
			
			return definicionReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public DefinicionParameterReturnGeneral procesarAccionDefinicionsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<Definicion> definicions,DefinicionParameterReturnGeneral definicionParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Definicion.class.getSimpleName()+"-procesarAccionDefinicionsWithConnection");connexion.begin();			
			
			DefinicionParameterReturnGeneral definicionReturnGeneral=new DefinicionParameterReturnGeneral();
	
			DefinicionLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,definicions,definicionParameterGeneral,definicionReturnGeneral);
			
			this.connexion.commit();
			
			return definicionReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public DefinicionParameterReturnGeneral procesarEventosDefinicions(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<Definicion> definicions,Definicion definicion,DefinicionParameterReturnGeneral definicionParameterGeneral,Boolean isEsNuevoDefinicion,ArrayList<Classe> clases)throws Exception {
		 try {	
			DefinicionParameterReturnGeneral definicionReturnGeneral=new DefinicionParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				definicionReturnGeneral.setConRecargarPropiedades(true);
			}
			
			DefinicionLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,definicions,definicion,definicionParameterGeneral,definicionReturnGeneral,isEsNuevoDefinicion,clases);
			
			return definicionReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public DefinicionParameterReturnGeneral procesarEventosDefinicionsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<Definicion> definicions,Definicion definicion,DefinicionParameterReturnGeneral definicionParameterGeneral,Boolean isEsNuevoDefinicion,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Definicion.class.getSimpleName()+"-procesarEventosDefinicionsWithConnection");connexion.begin();			
			
			DefinicionParameterReturnGeneral definicionReturnGeneral=new DefinicionParameterReturnGeneral();
	
			definicionReturnGeneral.setDefinicion(definicion);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				definicionReturnGeneral.setConRecargarPropiedades(true);
			}
			
			DefinicionLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,definicions,definicion,definicionParameterGeneral,definicionReturnGeneral,isEsNuevoDefinicion,clases);
			
			this.connexion.commit();
			
			return definicionReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public DefinicionParameterReturnGeneral procesarImportacionDefinicionsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,DefinicionParameterReturnGeneral definicionParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Definicion.class.getSimpleName()+"-procesarImportacionDefinicionsWithConnection");connexion.begin();			
			
			DefinicionParameterReturnGeneral definicionReturnGeneral=new DefinicionParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.definicions=new ArrayList<Definicion>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.definicion=new Definicion();
				
				
				if(conColumnasBase) {this.definicion.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.definicion.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.definicion.setsecuencial_formato(arrColumnas[iColumn++]);
				this.definicion.setsecuencial(Long.parseLong(arrColumnas[iColumn++]));
				this.definicion.setcon_mostrar_bodega(Boolean.parseBoolean(arrColumnas[iColumn++]));
				this.definicion.setfactor(Double.parseDouble(arrColumnas[iColumn++]));
				this.definicion.setcon_otro_recargo(Boolean.parseBoolean(arrColumnas[iColumn++]));
				this.definicion.setcon_coa(Boolean.parseBoolean(arrColumnas[iColumn++]));
				this.definicion.setcon_retencion(Boolean.parseBoolean(arrColumnas[iColumn++]));
				this.definicion.setcon_novedad_producto(Boolean.parseBoolean(arrColumnas[iColumn++]));
				this.definicion.setcon_ice(Boolean.parseBoolean(arrColumnas[iColumn++]));
				this.definicion.setcon_cantidad(Boolean.parseBoolean(arrColumnas[iColumn++]));
				this.definicion.setcon_producto_por_proveedor(Boolean.parseBoolean(arrColumnas[iColumn++]));
				this.definicion.setcon_lote_cliente(Boolean.parseBoolean(arrColumnas[iColumn++]));
				this.definicion.setcon_cuenta_contable(Boolean.parseBoolean(arrColumnas[iColumn++]));
				this.definicion.setcon_detalle(Boolean.parseBoolean(arrColumnas[iColumn++]));
				this.definicion.setcon_iva_incluido(Boolean.parseBoolean(arrColumnas[iColumn++]));
				this.definicion.setcon_lotes(Boolean.parseBoolean(arrColumnas[iColumn++]));
				this.definicion.setnumero_descuentos(Integer.parseInt(arrColumnas[iColumn++]));
				this.definicion.setcon_precio(Boolean.parseBoolean(arrColumnas[iColumn++]));
				this.definicion.setnumero_registros(Integer.parseInt(arrColumnas[iColumn++]));
				this.definicion.setcon_centro_costo(Boolean.parseBoolean(arrColumnas[iColumn++]));
				this.definicion.setcon_orden_iva(Boolean.parseBoolean(arrColumnas[iColumn++]));
				this.definicion.setcon_multi_empresa(Boolean.parseBoolean(arrColumnas[iColumn++]));
				this.definicion.setcon_en_linea(Boolean.parseBoolean(arrColumnas[iColumn++]));
				this.definicion.setcon_evaluacion(Boolean.parseBoolean(arrColumnas[iColumn++]));
				this.definicion.setcon_ot(Boolean.parseBoolean(arrColumnas[iColumn++]));
				this.definicion.setcon_anticipo(Boolean.parseBoolean(arrColumnas[iColumn++]));
				this.definicion.setcon_cierre(Boolean.parseBoolean(arrColumnas[iColumn++]));
				this.definicion.setcon_general(Boolean.parseBoolean(arrColumnas[iColumn++]));
				this.definicion.setcon_por_producto(Boolean.parseBoolean(arrColumnas[iColumn++]));
				this.definicion.setcon_descuento(Boolean.parseBoolean(arrColumnas[iColumn++]));
				this.definicion.setcon_series(Boolean.parseBoolean(arrColumnas[iColumn++]));
				this.definicion.setcantidad(Integer.parseInt(arrColumnas[iColumn++]));
				this.definicion.setcon_interno(Boolean.parseBoolean(arrColumnas[iColumn++]));
				this.definicion.setcon_reserva(Boolean.parseBoolean(arrColumnas[iColumn++]));
				this.definicion.setcon_precio_proveedor(Boolean.parseBoolean(arrColumnas[iColumn++]));
				this.definicion.setcon_produccion(Boolean.parseBoolean(arrColumnas[iColumn++]));
				this.definicion.setcon_codigo_barra(Boolean.parseBoolean(arrColumnas[iColumn++]));
				this.definicion.setcon_romaneos(Boolean.parseBoolean(arrColumnas[iColumn++]));
				
				this.definicions.add(this.definicion);
			}
			
			this.saveDefinicions();
			
			this.connexion.commit();
			
			definicionReturnGeneral.setConRetornoEstaProcesado(true);
			definicionReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return definicionReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarDefinicionsEliminados() throws Exception {				
		
		List<Definicion> definicionsAux= new ArrayList<Definicion>();
		
		for(Definicion definicion:definicions) {
			if(!definicion.getIsDeleted()) {
				definicionsAux.add(definicion);
			}
		}
		
		definicions=definicionsAux;
	}
	
	public void quitarDefinicionsNulos() throws Exception {				
		
		List<Definicion> definicionsAux= new ArrayList<Definicion>();
		
		for(Definicion definicion : this.definicions) {
			if(definicion==null) {
				definicionsAux.add(definicion);
			}
		}
		
		//this.definicions=definicionsAux;
		
		this.definicions.removeAll(definicionsAux);
	}
	
	public void getSetVersionRowDefinicionWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(definicion.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((definicion.getIsDeleted() || (definicion.getIsChanged()&&!definicion.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=definicionDataAccess.getSetVersionRowDefinicion(connexion,definicion.getId());
				
				if(!definicion.getVersionRow().equals(timestamp)) {	
					definicion.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				definicion.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowDefinicion()throws Exception {	
		
		if(definicion.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((definicion.getIsDeleted() || (definicion.getIsChanged()&&!definicion.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=definicionDataAccess.getSetVersionRowDefinicion(connexion,definicion.getId());
			
			try {							
				if(!definicion.getVersionRow().equals(timestamp)) {	
					definicion.setVersionRow(timestamp);
				}
				
				definicion.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowDefinicionsWithConnection()throws Exception {	
		if(definicions!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(Definicion definicionAux:definicions) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(definicionAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(definicionAux.getIsDeleted() || (definicionAux.getIsChanged()&&!definicionAux.getIsNew())) {
						
						timestamp=definicionDataAccess.getSetVersionRowDefinicion(connexion,definicionAux.getId());
						
						if(!definicion.getVersionRow().equals(timestamp)) {	
							definicionAux.setVersionRow(timestamp);
						}
								
						definicionAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowDefinicions()throws Exception {	
		if(definicions!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(Definicion definicionAux:definicions) {
					if(definicionAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(definicionAux.getIsDeleted() || (definicionAux.getIsChanged()&&!definicionAux.getIsNew())) {
						
						timestamp=definicionDataAccess.getSetVersionRowDefinicion(connexion,definicionAux.getId());
						
						if(!definicionAux.getVersionRow().equals(timestamp)) {	
							definicionAux.setVersionRow(timestamp);
						}
						
													
						definicionAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public DefinicionParameterReturnGeneral cargarCombosLoteForeignKeyDefinicionWithConnection(String finalQueryGlobalEmpresa,String finalQueryGlobalModulo,String finalQueryGlobalTipoDefinicion,String finalQueryGlobalTransaccion,String finalQueryGlobalSucursal,String finalQueryGlobalTipoIvaItem,String finalQueryGlobalTipoGlobalCliente,String finalQueryGlobalTipoCosteoDefinicion,String finalQueryGlobalTipoCostoDefinicion,String finalQueryGlobalFormato,String finalQueryGlobalTipoTributario,String finalQueryGlobalTipoRetencion,String finalQueryGlobalTipoDocumento,String finalQueryGlobalLibroContable,String finalQueryGlobalTipoTransaccionModulo,String finalQueryGlobalCuentaContable) throws Exception {
		DefinicionParameterReturnGeneral  definicionReturnGeneral =new DefinicionParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Definicion.class.getSimpleName()+"-cargarCombosLoteForeignKeyDefinicionWithConnection");connexion.begin();
			
			definicionReturnGeneral =new DefinicionParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			definicionReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Modulo> modulosForeignKey=new ArrayList<Modulo>();
			ModuloLogic moduloLogic=new ModuloLogic();
			moduloLogic.setConnexion(this.connexion);
			moduloLogic.getModuloDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalModulo.equals("NONE")) {
				moduloLogic.getTodosModulos(finalQueryGlobalModulo,new Pagination());
				modulosForeignKey=moduloLogic.getModulos();
			}

			definicionReturnGeneral.setmodulosForeignKey(modulosForeignKey);


			List<TipoDefinicion> tipodefinicionsForeignKey=new ArrayList<TipoDefinicion>();
			TipoDefinicionLogic tipodefinicionLogic=new TipoDefinicionLogic();
			tipodefinicionLogic.setConnexion(this.connexion);
			tipodefinicionLogic.getTipoDefinicionDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoDefinicion.equals("NONE")) {
				tipodefinicionLogic.getTodosTipoDefinicions(finalQueryGlobalTipoDefinicion,new Pagination());
				tipodefinicionsForeignKey=tipodefinicionLogic.getTipoDefinicions();
			}

			definicionReturnGeneral.settipodefinicionsForeignKey(tipodefinicionsForeignKey);


			List<Transaccion> transaccionsForeignKey=new ArrayList<Transaccion>();
			TransaccionLogic transaccionLogic=new TransaccionLogic();
			transaccionLogic.setConnexion(this.connexion);
			transaccionLogic.getTransaccionDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTransaccion.equals("NONE")) {
				transaccionLogic.getTodosTransaccions(finalQueryGlobalTransaccion,new Pagination());
				transaccionsForeignKey=transaccionLogic.getTransaccions();
			}

			definicionReturnGeneral.settransaccionsForeignKey(transaccionsForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			definicionReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<TipoIvaItem> tipoivaitemsForeignKey=new ArrayList<TipoIvaItem>();
			TipoIvaItemLogic tipoivaitemLogic=new TipoIvaItemLogic();
			tipoivaitemLogic.setConnexion(this.connexion);
			tipoivaitemLogic.getTipoIvaItemDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoIvaItem.equals("NONE")) {
				tipoivaitemLogic.getTodosTipoIvaItems(finalQueryGlobalTipoIvaItem,new Pagination());
				tipoivaitemsForeignKey=tipoivaitemLogic.getTipoIvaItems();
			}

			definicionReturnGeneral.settipoivaitemsForeignKey(tipoivaitemsForeignKey);


			List<TipoGlobalCliente> tipoglobalclientesForeignKey=new ArrayList<TipoGlobalCliente>();
			TipoGlobalClienteLogic tipoglobalclienteLogic=new TipoGlobalClienteLogic();
			tipoglobalclienteLogic.setConnexion(this.connexion);
			tipoglobalclienteLogic.getTipoGlobalClienteDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoGlobalCliente.equals("NONE")) {
				tipoglobalclienteLogic.getTodosTipoGlobalClientes(finalQueryGlobalTipoGlobalCliente,new Pagination());
				tipoglobalclientesForeignKey=tipoglobalclienteLogic.getTipoGlobalClientes();
			}

			definicionReturnGeneral.settipoglobalclientesForeignKey(tipoglobalclientesForeignKey);


			List<TipoCosteoDefinicion> tipocosteodefinicionsForeignKey=new ArrayList<TipoCosteoDefinicion>();
			TipoCosteoDefinicionLogic tipocosteodefinicionLogic=new TipoCosteoDefinicionLogic();
			tipocosteodefinicionLogic.setConnexion(this.connexion);
			tipocosteodefinicionLogic.getTipoCosteoDefinicionDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoCosteoDefinicion.equals("NONE")) {
				tipocosteodefinicionLogic.getTodosTipoCosteoDefinicions(finalQueryGlobalTipoCosteoDefinicion,new Pagination());
				tipocosteodefinicionsForeignKey=tipocosteodefinicionLogic.getTipoCosteoDefinicions();
			}

			definicionReturnGeneral.settipocosteodefinicionsForeignKey(tipocosteodefinicionsForeignKey);


			List<TipoCostoDefinicion> tipocostodefinicionsForeignKey=new ArrayList<TipoCostoDefinicion>();
			TipoCostoDefinicionLogic tipocostodefinicionLogic=new TipoCostoDefinicionLogic();
			tipocostodefinicionLogic.setConnexion(this.connexion);
			tipocostodefinicionLogic.getTipoCostoDefinicionDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoCostoDefinicion.equals("NONE")) {
				tipocostodefinicionLogic.getTodosTipoCostoDefinicions(finalQueryGlobalTipoCostoDefinicion,new Pagination());
				tipocostodefinicionsForeignKey=tipocostodefinicionLogic.getTipoCostoDefinicions();
			}

			definicionReturnGeneral.settipocostodefinicionsForeignKey(tipocostodefinicionsForeignKey);


			List<Formato> formatosForeignKey=new ArrayList<Formato>();
			FormatoLogic formatoLogic=new FormatoLogic();
			formatoLogic.setConnexion(this.connexion);
			formatoLogic.getFormatoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalFormato.equals("NONE")) {
				formatoLogic.getTodosFormatos(finalQueryGlobalFormato,new Pagination());
				formatosForeignKey=formatoLogic.getFormatos();
			}

			definicionReturnGeneral.setformatosForeignKey(formatosForeignKey);


			List<TipoTributario> tipotributariosForeignKey=new ArrayList<TipoTributario>();
			TipoTributarioLogic tipotributarioLogic=new TipoTributarioLogic();
			tipotributarioLogic.setConnexion(this.connexion);
			tipotributarioLogic.getTipoTributarioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoTributario.equals("NONE")) {
				tipotributarioLogic.getTodosTipoTributarios(finalQueryGlobalTipoTributario,new Pagination());
				tipotributariosForeignKey=tipotributarioLogic.getTipoTributarios();
			}

			definicionReturnGeneral.settipotributariosForeignKey(tipotributariosForeignKey);


			List<TipoRetencion> tiporetencionsForeignKey=new ArrayList<TipoRetencion>();
			TipoRetencionLogic tiporetencionLogic=new TipoRetencionLogic();
			tiporetencionLogic.setConnexion(this.connexion);
			tiporetencionLogic.getTipoRetencionDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoRetencion.equals("NONE")) {
				tiporetencionLogic.getTodosTipoRetencions(finalQueryGlobalTipoRetencion,new Pagination());
				tiporetencionsForeignKey=tiporetencionLogic.getTipoRetencions();
			}

			definicionReturnGeneral.settiporetencionsForeignKey(tiporetencionsForeignKey);


			List<TipoDocumento> tipodocumentosForeignKey=new ArrayList<TipoDocumento>();
			TipoDocumentoLogic tipodocumentoLogic=new TipoDocumentoLogic();
			tipodocumentoLogic.setConnexion(this.connexion);
			tipodocumentoLogic.getTipoDocumentoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoDocumento.equals("NONE")) {
				tipodocumentoLogic.getTodosTipoDocumentos(finalQueryGlobalTipoDocumento,new Pagination());
				tipodocumentosForeignKey=tipodocumentoLogic.getTipoDocumentos();
			}

			definicionReturnGeneral.settipodocumentosForeignKey(tipodocumentosForeignKey);


			List<LibroContable> librocontablesForeignKey=new ArrayList<LibroContable>();
			LibroContableLogic librocontableLogic=new LibroContableLogic();
			librocontableLogic.setConnexion(this.connexion);
			librocontableLogic.getLibroContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalLibroContable.equals("NONE")) {
				librocontableLogic.getTodosLibroContables(finalQueryGlobalLibroContable,new Pagination());
				librocontablesForeignKey=librocontableLogic.getLibroContables();
			}

			definicionReturnGeneral.setlibrocontablesForeignKey(librocontablesForeignKey);


			List<TipoTransaccionModulo> tipotransaccionmodulosForeignKey=new ArrayList<TipoTransaccionModulo>();
			TipoTransaccionModuloLogic tipotransaccionmoduloLogic=new TipoTransaccionModuloLogic();
			tipotransaccionmoduloLogic.setConnexion(this.connexion);
			tipotransaccionmoduloLogic.getTipoTransaccionModuloDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoTransaccionModulo.equals("NONE")) {
				tipotransaccionmoduloLogic.getTodosTipoTransaccionModulos(finalQueryGlobalTipoTransaccionModulo,new Pagination());
				tipotransaccionmodulosForeignKey=tipotransaccionmoduloLogic.getTipoTransaccionModulos();
			}

			definicionReturnGeneral.settipotransaccionmodulosForeignKey(tipotransaccionmodulosForeignKey);


			List<CuentaContable> cuentacontablesForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontableLogic=new CuentaContableLogic();
			cuentacontableLogic.setConnexion(this.connexion);
			cuentacontableLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContable.equals("NONE")) {
				cuentacontableLogic.getTodosCuentaContables(finalQueryGlobalCuentaContable,new Pagination());
				cuentacontablesForeignKey=cuentacontableLogic.getCuentaContables();
			}

			definicionReturnGeneral.setcuentacontablesForeignKey(cuentacontablesForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return definicionReturnGeneral;
	}
	
	public DefinicionParameterReturnGeneral cargarCombosLoteForeignKeyDefinicion(String finalQueryGlobalEmpresa,String finalQueryGlobalModulo,String finalQueryGlobalTipoDefinicion,String finalQueryGlobalTransaccion,String finalQueryGlobalSucursal,String finalQueryGlobalTipoIvaItem,String finalQueryGlobalTipoGlobalCliente,String finalQueryGlobalTipoCosteoDefinicion,String finalQueryGlobalTipoCostoDefinicion,String finalQueryGlobalFormato,String finalQueryGlobalTipoTributario,String finalQueryGlobalTipoRetencion,String finalQueryGlobalTipoDocumento,String finalQueryGlobalLibroContable,String finalQueryGlobalTipoTransaccionModulo,String finalQueryGlobalCuentaContable) throws Exception {
		DefinicionParameterReturnGeneral  definicionReturnGeneral =new DefinicionParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			definicionReturnGeneral =new DefinicionParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			definicionReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Modulo> modulosForeignKey=new ArrayList<Modulo>();
			ModuloLogic moduloLogic=new ModuloLogic();
			moduloLogic.setConnexion(this.connexion);
			moduloLogic.getModuloDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalModulo.equals("NONE")) {
				moduloLogic.getTodosModulos(finalQueryGlobalModulo,new Pagination());
				modulosForeignKey=moduloLogic.getModulos();
			}

			definicionReturnGeneral.setmodulosForeignKey(modulosForeignKey);


			List<TipoDefinicion> tipodefinicionsForeignKey=new ArrayList<TipoDefinicion>();
			TipoDefinicionLogic tipodefinicionLogic=new TipoDefinicionLogic();
			tipodefinicionLogic.setConnexion(this.connexion);
			tipodefinicionLogic.getTipoDefinicionDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoDefinicion.equals("NONE")) {
				tipodefinicionLogic.getTodosTipoDefinicions(finalQueryGlobalTipoDefinicion,new Pagination());
				tipodefinicionsForeignKey=tipodefinicionLogic.getTipoDefinicions();
			}

			definicionReturnGeneral.settipodefinicionsForeignKey(tipodefinicionsForeignKey);


			List<Transaccion> transaccionsForeignKey=new ArrayList<Transaccion>();
			TransaccionLogic transaccionLogic=new TransaccionLogic();
			transaccionLogic.setConnexion(this.connexion);
			transaccionLogic.getTransaccionDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTransaccion.equals("NONE")) {
				transaccionLogic.getTodosTransaccions(finalQueryGlobalTransaccion,new Pagination());
				transaccionsForeignKey=transaccionLogic.getTransaccions();
			}

			definicionReturnGeneral.settransaccionsForeignKey(transaccionsForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			definicionReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<TipoIvaItem> tipoivaitemsForeignKey=new ArrayList<TipoIvaItem>();
			TipoIvaItemLogic tipoivaitemLogic=new TipoIvaItemLogic();
			tipoivaitemLogic.setConnexion(this.connexion);
			tipoivaitemLogic.getTipoIvaItemDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoIvaItem.equals("NONE")) {
				tipoivaitemLogic.getTodosTipoIvaItems(finalQueryGlobalTipoIvaItem,new Pagination());
				tipoivaitemsForeignKey=tipoivaitemLogic.getTipoIvaItems();
			}

			definicionReturnGeneral.settipoivaitemsForeignKey(tipoivaitemsForeignKey);


			List<TipoGlobalCliente> tipoglobalclientesForeignKey=new ArrayList<TipoGlobalCliente>();
			TipoGlobalClienteLogic tipoglobalclienteLogic=new TipoGlobalClienteLogic();
			tipoglobalclienteLogic.setConnexion(this.connexion);
			tipoglobalclienteLogic.getTipoGlobalClienteDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoGlobalCliente.equals("NONE")) {
				tipoglobalclienteLogic.getTodosTipoGlobalClientes(finalQueryGlobalTipoGlobalCliente,new Pagination());
				tipoglobalclientesForeignKey=tipoglobalclienteLogic.getTipoGlobalClientes();
			}

			definicionReturnGeneral.settipoglobalclientesForeignKey(tipoglobalclientesForeignKey);


			List<TipoCosteoDefinicion> tipocosteodefinicionsForeignKey=new ArrayList<TipoCosteoDefinicion>();
			TipoCosteoDefinicionLogic tipocosteodefinicionLogic=new TipoCosteoDefinicionLogic();
			tipocosteodefinicionLogic.setConnexion(this.connexion);
			tipocosteodefinicionLogic.getTipoCosteoDefinicionDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoCosteoDefinicion.equals("NONE")) {
				tipocosteodefinicionLogic.getTodosTipoCosteoDefinicions(finalQueryGlobalTipoCosteoDefinicion,new Pagination());
				tipocosteodefinicionsForeignKey=tipocosteodefinicionLogic.getTipoCosteoDefinicions();
			}

			definicionReturnGeneral.settipocosteodefinicionsForeignKey(tipocosteodefinicionsForeignKey);


			List<TipoCostoDefinicion> tipocostodefinicionsForeignKey=new ArrayList<TipoCostoDefinicion>();
			TipoCostoDefinicionLogic tipocostodefinicionLogic=new TipoCostoDefinicionLogic();
			tipocostodefinicionLogic.setConnexion(this.connexion);
			tipocostodefinicionLogic.getTipoCostoDefinicionDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoCostoDefinicion.equals("NONE")) {
				tipocostodefinicionLogic.getTodosTipoCostoDefinicions(finalQueryGlobalTipoCostoDefinicion,new Pagination());
				tipocostodefinicionsForeignKey=tipocostodefinicionLogic.getTipoCostoDefinicions();
			}

			definicionReturnGeneral.settipocostodefinicionsForeignKey(tipocostodefinicionsForeignKey);


			List<Formato> formatosForeignKey=new ArrayList<Formato>();
			FormatoLogic formatoLogic=new FormatoLogic();
			formatoLogic.setConnexion(this.connexion);
			formatoLogic.getFormatoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalFormato.equals("NONE")) {
				formatoLogic.getTodosFormatos(finalQueryGlobalFormato,new Pagination());
				formatosForeignKey=formatoLogic.getFormatos();
			}

			definicionReturnGeneral.setformatosForeignKey(formatosForeignKey);


			List<TipoTributario> tipotributariosForeignKey=new ArrayList<TipoTributario>();
			TipoTributarioLogic tipotributarioLogic=new TipoTributarioLogic();
			tipotributarioLogic.setConnexion(this.connexion);
			tipotributarioLogic.getTipoTributarioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoTributario.equals("NONE")) {
				tipotributarioLogic.getTodosTipoTributarios(finalQueryGlobalTipoTributario,new Pagination());
				tipotributariosForeignKey=tipotributarioLogic.getTipoTributarios();
			}

			definicionReturnGeneral.settipotributariosForeignKey(tipotributariosForeignKey);


			List<TipoRetencion> tiporetencionsForeignKey=new ArrayList<TipoRetencion>();
			TipoRetencionLogic tiporetencionLogic=new TipoRetencionLogic();
			tiporetencionLogic.setConnexion(this.connexion);
			tiporetencionLogic.getTipoRetencionDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoRetencion.equals("NONE")) {
				tiporetencionLogic.getTodosTipoRetencions(finalQueryGlobalTipoRetencion,new Pagination());
				tiporetencionsForeignKey=tiporetencionLogic.getTipoRetencions();
			}

			definicionReturnGeneral.settiporetencionsForeignKey(tiporetencionsForeignKey);


			List<TipoDocumento> tipodocumentosForeignKey=new ArrayList<TipoDocumento>();
			TipoDocumentoLogic tipodocumentoLogic=new TipoDocumentoLogic();
			tipodocumentoLogic.setConnexion(this.connexion);
			tipodocumentoLogic.getTipoDocumentoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoDocumento.equals("NONE")) {
				tipodocumentoLogic.getTodosTipoDocumentos(finalQueryGlobalTipoDocumento,new Pagination());
				tipodocumentosForeignKey=tipodocumentoLogic.getTipoDocumentos();
			}

			definicionReturnGeneral.settipodocumentosForeignKey(tipodocumentosForeignKey);


			List<LibroContable> librocontablesForeignKey=new ArrayList<LibroContable>();
			LibroContableLogic librocontableLogic=new LibroContableLogic();
			librocontableLogic.setConnexion(this.connexion);
			librocontableLogic.getLibroContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalLibroContable.equals("NONE")) {
				librocontableLogic.getTodosLibroContables(finalQueryGlobalLibroContable,new Pagination());
				librocontablesForeignKey=librocontableLogic.getLibroContables();
			}

			definicionReturnGeneral.setlibrocontablesForeignKey(librocontablesForeignKey);


			List<TipoTransaccionModulo> tipotransaccionmodulosForeignKey=new ArrayList<TipoTransaccionModulo>();
			TipoTransaccionModuloLogic tipotransaccionmoduloLogic=new TipoTransaccionModuloLogic();
			tipotransaccionmoduloLogic.setConnexion(this.connexion);
			tipotransaccionmoduloLogic.getTipoTransaccionModuloDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoTransaccionModulo.equals("NONE")) {
				tipotransaccionmoduloLogic.getTodosTipoTransaccionModulos(finalQueryGlobalTipoTransaccionModulo,new Pagination());
				tipotransaccionmodulosForeignKey=tipotransaccionmoduloLogic.getTipoTransaccionModulos();
			}

			definicionReturnGeneral.settipotransaccionmodulosForeignKey(tipotransaccionmodulosForeignKey);


			List<CuentaContable> cuentacontablesForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontableLogic=new CuentaContableLogic();
			cuentacontableLogic.setConnexion(this.connexion);
			cuentacontableLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContable.equals("NONE")) {
				cuentacontableLogic.getTodosCuentaContables(finalQueryGlobalCuentaContable,new Pagination());
				cuentacontablesForeignKey=cuentacontableLogic.getCuentaContables();
			}

			definicionReturnGeneral.setcuentacontablesForeignKey(cuentacontablesForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return definicionReturnGeneral;
	}
	
	
	public void deepLoad(Definicion definicion,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			DefinicionLogicAdditional.updateDefinicionToGet(definicion,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		definicion.setEmpresa(definicionDataAccess.getEmpresa(connexion,definicion));
		definicion.setModulo(definicionDataAccess.getModulo(connexion,definicion));
		definicion.setTipoDefinicion(definicionDataAccess.getTipoDefinicion(connexion,definicion));
		definicion.setTransaccion(definicionDataAccess.getTransaccion(connexion,definicion));
		definicion.setSucursal(definicionDataAccess.getSucursal(connexion,definicion));
		definicion.setTipoIvaItem(definicionDataAccess.getTipoIvaItem(connexion,definicion));
		definicion.setTipoGlobalCliente(definicionDataAccess.getTipoGlobalCliente(connexion,definicion));
		definicion.setTipoCosteoDefinicion(definicionDataAccess.getTipoCosteoDefinicion(connexion,definicion));
		definicion.setTipoCostoDefinicion(definicionDataAccess.getTipoCostoDefinicion(connexion,definicion));
		definicion.setFormato(definicionDataAccess.getFormato(connexion,definicion));
		definicion.setTipoTributario(definicionDataAccess.getTipoTributario(connexion,definicion));
		definicion.setTipoRetencion(definicionDataAccess.getTipoRetencion(connexion,definicion));
		definicion.setTipoDocumento(definicionDataAccess.getTipoDocumento(connexion,definicion));
		definicion.setLibroContable(definicionDataAccess.getLibroContable(connexion,definicion));
		definicion.setTipoTransaccionModulo(definicionDataAccess.getTipoTransaccionModulo(connexion,definicion));
		definicion.setCuentaContable(definicionDataAccess.getCuentaContable(connexion,definicion));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				definicion.setEmpresa(definicionDataAccess.getEmpresa(connexion,definicion));
				continue;
			}

			if(clas.clas.equals(Modulo.class)) {
				definicion.setModulo(definicionDataAccess.getModulo(connexion,definicion));
				continue;
			}

			if(clas.clas.equals(TipoDefinicion.class)) {
				definicion.setTipoDefinicion(definicionDataAccess.getTipoDefinicion(connexion,definicion));
				continue;
			}

			if(clas.clas.equals(Transaccion.class)) {
				definicion.setTransaccion(definicionDataAccess.getTransaccion(connexion,definicion));
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				definicion.setSucursal(definicionDataAccess.getSucursal(connexion,definicion));
				continue;
			}

			if(clas.clas.equals(TipoIvaItem.class)) {
				definicion.setTipoIvaItem(definicionDataAccess.getTipoIvaItem(connexion,definicion));
				continue;
			}

			if(clas.clas.equals(TipoGlobalCliente.class)) {
				definicion.setTipoGlobalCliente(definicionDataAccess.getTipoGlobalCliente(connexion,definicion));
				continue;
			}

			if(clas.clas.equals(TipoCosteoDefinicion.class)) {
				definicion.setTipoCosteoDefinicion(definicionDataAccess.getTipoCosteoDefinicion(connexion,definicion));
				continue;
			}

			if(clas.clas.equals(TipoCostoDefinicion.class)) {
				definicion.setTipoCostoDefinicion(definicionDataAccess.getTipoCostoDefinicion(connexion,definicion));
				continue;
			}

			if(clas.clas.equals(Formato.class)) {
				definicion.setFormato(definicionDataAccess.getFormato(connexion,definicion));
				continue;
			}

			if(clas.clas.equals(TipoTributario.class)) {
				definicion.setTipoTributario(definicionDataAccess.getTipoTributario(connexion,definicion));
				continue;
			}

			if(clas.clas.equals(TipoRetencion.class)) {
				definicion.setTipoRetencion(definicionDataAccess.getTipoRetencion(connexion,definicion));
				continue;
			}

			if(clas.clas.equals(TipoDocumento.class)) {
				definicion.setTipoDocumento(definicionDataAccess.getTipoDocumento(connexion,definicion));
				continue;
			}

			if(clas.clas.equals(LibroContable.class)) {
				definicion.setLibroContable(definicionDataAccess.getLibroContable(connexion,definicion));
				continue;
			}

			if(clas.clas.equals(TipoTransaccionModulo.class)) {
				definicion.setTipoTransaccionModulo(definicionDataAccess.getTipoTransaccionModulo(connexion,definicion));
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				definicion.setCuentaContable(definicionDataAccess.getCuentaContable(connexion,definicion));
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
			definicion.setEmpresa(definicionDataAccess.getEmpresa(connexion,definicion));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Modulo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			definicion.setModulo(definicionDataAccess.getModulo(connexion,definicion));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoDefinicion.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			definicion.setTipoDefinicion(definicionDataAccess.getTipoDefinicion(connexion,definicion));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Transaccion.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			definicion.setTransaccion(definicionDataAccess.getTransaccion(connexion,definicion));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			definicion.setSucursal(definicionDataAccess.getSucursal(connexion,definicion));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoIvaItem.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			definicion.setTipoIvaItem(definicionDataAccess.getTipoIvaItem(connexion,definicion));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoGlobalCliente.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			definicion.setTipoGlobalCliente(definicionDataAccess.getTipoGlobalCliente(connexion,definicion));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoCosteoDefinicion.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			definicion.setTipoCosteoDefinicion(definicionDataAccess.getTipoCosteoDefinicion(connexion,definicion));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoCostoDefinicion.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			definicion.setTipoCostoDefinicion(definicionDataAccess.getTipoCostoDefinicion(connexion,definicion));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Formato.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			definicion.setFormato(definicionDataAccess.getFormato(connexion,definicion));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoTributario.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			definicion.setTipoTributario(definicionDataAccess.getTipoTributario(connexion,definicion));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoRetencion.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			definicion.setTipoRetencion(definicionDataAccess.getTipoRetencion(connexion,definicion));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoDocumento.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			definicion.setTipoDocumento(definicionDataAccess.getTipoDocumento(connexion,definicion));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(LibroContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			definicion.setLibroContable(definicionDataAccess.getLibroContable(connexion,definicion));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoTransaccionModulo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			definicion.setTipoTransaccionModulo(definicionDataAccess.getTipoTransaccionModulo(connexion,definicion));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			definicion.setCuentaContable(definicionDataAccess.getCuentaContable(connexion,definicion));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		definicion.setEmpresa(definicionDataAccess.getEmpresa(connexion,definicion));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(definicion.getEmpresa(),isDeep,deepLoadType,clases);
				
		definicion.setModulo(definicionDataAccess.getModulo(connexion,definicion));
		ModuloLogic moduloLogic= new ModuloLogic(connexion);
		moduloLogic.deepLoad(definicion.getModulo(),isDeep,deepLoadType,clases);
				
		definicion.setTipoDefinicion(definicionDataAccess.getTipoDefinicion(connexion,definicion));
		TipoDefinicionLogic tipodefinicionLogic= new TipoDefinicionLogic(connexion);
		tipodefinicionLogic.deepLoad(definicion.getTipoDefinicion(),isDeep,deepLoadType,clases);
				
		definicion.setTransaccion(definicionDataAccess.getTransaccion(connexion,definicion));
		TransaccionLogic transaccionLogic= new TransaccionLogic(connexion);
		transaccionLogic.deepLoad(definicion.getTransaccion(),isDeep,deepLoadType,clases);
				
		definicion.setSucursal(definicionDataAccess.getSucursal(connexion,definicion));
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(definicion.getSucursal(),isDeep,deepLoadType,clases);
				
		definicion.setTipoIvaItem(definicionDataAccess.getTipoIvaItem(connexion,definicion));
		TipoIvaItemLogic tipoivaitemLogic= new TipoIvaItemLogic(connexion);
		tipoivaitemLogic.deepLoad(definicion.getTipoIvaItem(),isDeep,deepLoadType,clases);
				
		definicion.setTipoGlobalCliente(definicionDataAccess.getTipoGlobalCliente(connexion,definicion));
		TipoGlobalClienteLogic tipoglobalclienteLogic= new TipoGlobalClienteLogic(connexion);
		tipoglobalclienteLogic.deepLoad(definicion.getTipoGlobalCliente(),isDeep,deepLoadType,clases);
				
		definicion.setTipoCosteoDefinicion(definicionDataAccess.getTipoCosteoDefinicion(connexion,definicion));
		TipoCosteoDefinicionLogic tipocosteodefinicionLogic= new TipoCosteoDefinicionLogic(connexion);
		tipocosteodefinicionLogic.deepLoad(definicion.getTipoCosteoDefinicion(),isDeep,deepLoadType,clases);
				
		definicion.setTipoCostoDefinicion(definicionDataAccess.getTipoCostoDefinicion(connexion,definicion));
		TipoCostoDefinicionLogic tipocostodefinicionLogic= new TipoCostoDefinicionLogic(connexion);
		tipocostodefinicionLogic.deepLoad(definicion.getTipoCostoDefinicion(),isDeep,deepLoadType,clases);
				
		definicion.setFormato(definicionDataAccess.getFormato(connexion,definicion));
		FormatoLogic formatoLogic= new FormatoLogic(connexion);
		formatoLogic.deepLoad(definicion.getFormato(),isDeep,deepLoadType,clases);
				
		definicion.setTipoTributario(definicionDataAccess.getTipoTributario(connexion,definicion));
		TipoTributarioLogic tipotributarioLogic= new TipoTributarioLogic(connexion);
		tipotributarioLogic.deepLoad(definicion.getTipoTributario(),isDeep,deepLoadType,clases);
				
		definicion.setTipoRetencion(definicionDataAccess.getTipoRetencion(connexion,definicion));
		TipoRetencionLogic tiporetencionLogic= new TipoRetencionLogic(connexion);
		tiporetencionLogic.deepLoad(definicion.getTipoRetencion(),isDeep,deepLoadType,clases);
				
		definicion.setTipoDocumento(definicionDataAccess.getTipoDocumento(connexion,definicion));
		TipoDocumentoLogic tipodocumentoLogic= new TipoDocumentoLogic(connexion);
		tipodocumentoLogic.deepLoad(definicion.getTipoDocumento(),isDeep,deepLoadType,clases);
				
		definicion.setLibroContable(definicionDataAccess.getLibroContable(connexion,definicion));
		LibroContableLogic librocontableLogic= new LibroContableLogic(connexion);
		librocontableLogic.deepLoad(definicion.getLibroContable(),isDeep,deepLoadType,clases);
				
		definicion.setTipoTransaccionModulo(definicionDataAccess.getTipoTransaccionModulo(connexion,definicion));
		TipoTransaccionModuloLogic tipotransaccionmoduloLogic= new TipoTransaccionModuloLogic(connexion);
		tipotransaccionmoduloLogic.deepLoad(definicion.getTipoTransaccionModulo(),isDeep,deepLoadType,clases);
				
		definicion.setCuentaContable(definicionDataAccess.getCuentaContable(connexion,definicion));
		CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
		cuentacontableLogic.deepLoad(definicion.getCuentaContable(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				definicion.setEmpresa(definicionDataAccess.getEmpresa(connexion,definicion));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(definicion.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Modulo.class)) {
				definicion.setModulo(definicionDataAccess.getModulo(connexion,definicion));
				ModuloLogic moduloLogic= new ModuloLogic(connexion);
				moduloLogic.deepLoad(definicion.getModulo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoDefinicion.class)) {
				definicion.setTipoDefinicion(definicionDataAccess.getTipoDefinicion(connexion,definicion));
				TipoDefinicionLogic tipodefinicionLogic= new TipoDefinicionLogic(connexion);
				tipodefinicionLogic.deepLoad(definicion.getTipoDefinicion(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Transaccion.class)) {
				definicion.setTransaccion(definicionDataAccess.getTransaccion(connexion,definicion));
				TransaccionLogic transaccionLogic= new TransaccionLogic(connexion);
				transaccionLogic.deepLoad(definicion.getTransaccion(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				definicion.setSucursal(definicionDataAccess.getSucursal(connexion,definicion));
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepLoad(definicion.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoIvaItem.class)) {
				definicion.setTipoIvaItem(definicionDataAccess.getTipoIvaItem(connexion,definicion));
				TipoIvaItemLogic tipoivaitemLogic= new TipoIvaItemLogic(connexion);
				tipoivaitemLogic.deepLoad(definicion.getTipoIvaItem(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoGlobalCliente.class)) {
				definicion.setTipoGlobalCliente(definicionDataAccess.getTipoGlobalCliente(connexion,definicion));
				TipoGlobalClienteLogic tipoglobalclienteLogic= new TipoGlobalClienteLogic(connexion);
				tipoglobalclienteLogic.deepLoad(definicion.getTipoGlobalCliente(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoCosteoDefinicion.class)) {
				definicion.setTipoCosteoDefinicion(definicionDataAccess.getTipoCosteoDefinicion(connexion,definicion));
				TipoCosteoDefinicionLogic tipocosteodefinicionLogic= new TipoCosteoDefinicionLogic(connexion);
				tipocosteodefinicionLogic.deepLoad(definicion.getTipoCosteoDefinicion(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoCostoDefinicion.class)) {
				definicion.setTipoCostoDefinicion(definicionDataAccess.getTipoCostoDefinicion(connexion,definicion));
				TipoCostoDefinicionLogic tipocostodefinicionLogic= new TipoCostoDefinicionLogic(connexion);
				tipocostodefinicionLogic.deepLoad(definicion.getTipoCostoDefinicion(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Formato.class)) {
				definicion.setFormato(definicionDataAccess.getFormato(connexion,definicion));
				FormatoLogic formatoLogic= new FormatoLogic(connexion);
				formatoLogic.deepLoad(definicion.getFormato(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoTributario.class)) {
				definicion.setTipoTributario(definicionDataAccess.getTipoTributario(connexion,definicion));
				TipoTributarioLogic tipotributarioLogic= new TipoTributarioLogic(connexion);
				tipotributarioLogic.deepLoad(definicion.getTipoTributario(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoRetencion.class)) {
				definicion.setTipoRetencion(definicionDataAccess.getTipoRetencion(connexion,definicion));
				TipoRetencionLogic tiporetencionLogic= new TipoRetencionLogic(connexion);
				tiporetencionLogic.deepLoad(definicion.getTipoRetencion(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoDocumento.class)) {
				definicion.setTipoDocumento(definicionDataAccess.getTipoDocumento(connexion,definicion));
				TipoDocumentoLogic tipodocumentoLogic= new TipoDocumentoLogic(connexion);
				tipodocumentoLogic.deepLoad(definicion.getTipoDocumento(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(LibroContable.class)) {
				definicion.setLibroContable(definicionDataAccess.getLibroContable(connexion,definicion));
				LibroContableLogic librocontableLogic= new LibroContableLogic(connexion);
				librocontableLogic.deepLoad(definicion.getLibroContable(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoTransaccionModulo.class)) {
				definicion.setTipoTransaccionModulo(definicionDataAccess.getTipoTransaccionModulo(connexion,definicion));
				TipoTransaccionModuloLogic tipotransaccionmoduloLogic= new TipoTransaccionModuloLogic(connexion);
				tipotransaccionmoduloLogic.deepLoad(definicion.getTipoTransaccionModulo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				definicion.setCuentaContable(definicionDataAccess.getCuentaContable(connexion,definicion));
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepLoad(definicion.getCuentaContable(),isDeep,deepLoadType,clases);				
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
			definicion.setEmpresa(definicionDataAccess.getEmpresa(connexion,definicion));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(definicion.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Modulo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			definicion.setModulo(definicionDataAccess.getModulo(connexion,definicion));
			ModuloLogic moduloLogic= new ModuloLogic(connexion);
			moduloLogic.deepLoad(definicion.getModulo(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoDefinicion.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			definicion.setTipoDefinicion(definicionDataAccess.getTipoDefinicion(connexion,definicion));
			TipoDefinicionLogic tipodefinicionLogic= new TipoDefinicionLogic(connexion);
			tipodefinicionLogic.deepLoad(definicion.getTipoDefinicion(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Transaccion.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			definicion.setTransaccion(definicionDataAccess.getTransaccion(connexion,definicion));
			TransaccionLogic transaccionLogic= new TransaccionLogic(connexion);
			transaccionLogic.deepLoad(definicion.getTransaccion(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			definicion.setSucursal(definicionDataAccess.getSucursal(connexion,definicion));
			SucursalLogic sucursalLogic= new SucursalLogic(connexion);
			sucursalLogic.deepLoad(definicion.getSucursal(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoIvaItem.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			definicion.setTipoIvaItem(definicionDataAccess.getTipoIvaItem(connexion,definicion));
			TipoIvaItemLogic tipoivaitemLogic= new TipoIvaItemLogic(connexion);
			tipoivaitemLogic.deepLoad(definicion.getTipoIvaItem(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoGlobalCliente.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			definicion.setTipoGlobalCliente(definicionDataAccess.getTipoGlobalCliente(connexion,definicion));
			TipoGlobalClienteLogic tipoglobalclienteLogic= new TipoGlobalClienteLogic(connexion);
			tipoglobalclienteLogic.deepLoad(definicion.getTipoGlobalCliente(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoCosteoDefinicion.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			definicion.setTipoCosteoDefinicion(definicionDataAccess.getTipoCosteoDefinicion(connexion,definicion));
			TipoCosteoDefinicionLogic tipocosteodefinicionLogic= new TipoCosteoDefinicionLogic(connexion);
			tipocosteodefinicionLogic.deepLoad(definicion.getTipoCosteoDefinicion(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoCostoDefinicion.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			definicion.setTipoCostoDefinicion(definicionDataAccess.getTipoCostoDefinicion(connexion,definicion));
			TipoCostoDefinicionLogic tipocostodefinicionLogic= new TipoCostoDefinicionLogic(connexion);
			tipocostodefinicionLogic.deepLoad(definicion.getTipoCostoDefinicion(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Formato.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			definicion.setFormato(definicionDataAccess.getFormato(connexion,definicion));
			FormatoLogic formatoLogic= new FormatoLogic(connexion);
			formatoLogic.deepLoad(definicion.getFormato(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoTributario.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			definicion.setTipoTributario(definicionDataAccess.getTipoTributario(connexion,definicion));
			TipoTributarioLogic tipotributarioLogic= new TipoTributarioLogic(connexion);
			tipotributarioLogic.deepLoad(definicion.getTipoTributario(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoRetencion.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			definicion.setTipoRetencion(definicionDataAccess.getTipoRetencion(connexion,definicion));
			TipoRetencionLogic tiporetencionLogic= new TipoRetencionLogic(connexion);
			tiporetencionLogic.deepLoad(definicion.getTipoRetencion(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoDocumento.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			definicion.setTipoDocumento(definicionDataAccess.getTipoDocumento(connexion,definicion));
			TipoDocumentoLogic tipodocumentoLogic= new TipoDocumentoLogic(connexion);
			tipodocumentoLogic.deepLoad(definicion.getTipoDocumento(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(LibroContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			definicion.setLibroContable(definicionDataAccess.getLibroContable(connexion,definicion));
			LibroContableLogic librocontableLogic= new LibroContableLogic(connexion);
			librocontableLogic.deepLoad(definicion.getLibroContable(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoTransaccionModulo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			definicion.setTipoTransaccionModulo(definicionDataAccess.getTipoTransaccionModulo(connexion,definicion));
			TipoTransaccionModuloLogic tipotransaccionmoduloLogic= new TipoTransaccionModuloLogic(connexion);
			tipotransaccionmoduloLogic.deepLoad(definicion.getTipoTransaccionModulo(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			definicion.setCuentaContable(definicionDataAccess.getCuentaContable(connexion,definicion));
			CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
			cuentacontableLogic.deepLoad(definicion.getCuentaContable(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(Definicion definicion,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			DefinicionLogicAdditional.updateDefinicionToSave(definicion,this.arrDatoGeneral);
			
DefinicionDataAccess.save(definicion, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(definicion.getEmpresa(),connexion);

		ModuloDataAccess.save(definicion.getModulo(),connexion);

		TipoDefinicionDataAccess.save(definicion.getTipoDefinicion(),connexion);

		TransaccionDataAccess.save(definicion.getTransaccion(),connexion);

		SucursalDataAccess.save(definicion.getSucursal(),connexion);

		TipoIvaItemDataAccess.save(definicion.getTipoIvaItem(),connexion);

		TipoGlobalClienteDataAccess.save(definicion.getTipoGlobalCliente(),connexion);

		TipoCosteoDefinicionDataAccess.save(definicion.getTipoCosteoDefinicion(),connexion);

		TipoCostoDefinicionDataAccess.save(definicion.getTipoCostoDefinicion(),connexion);

		FormatoDataAccess.save(definicion.getFormato(),connexion);

		TipoTributarioDataAccess.save(definicion.getTipoTributario(),connexion);

		TipoRetencionDataAccess.save(definicion.getTipoRetencion(),connexion);

		TipoDocumentoDataAccess.save(definicion.getTipoDocumento(),connexion);

		LibroContableDataAccess.save(definicion.getLibroContable(),connexion);

		TipoTransaccionModuloDataAccess.save(definicion.getTipoTransaccionModulo(),connexion);

		CuentaContableDataAccess.save(definicion.getCuentaContable(),connexion);
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(definicion.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(Modulo.class)) {
				ModuloDataAccess.save(definicion.getModulo(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoDefinicion.class)) {
				TipoDefinicionDataAccess.save(definicion.getTipoDefinicion(),connexion);
				continue;
			}

			if(clas.clas.equals(Transaccion.class)) {
				TransaccionDataAccess.save(definicion.getTransaccion(),connexion);
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(definicion.getSucursal(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoIvaItem.class)) {
				TipoIvaItemDataAccess.save(definicion.getTipoIvaItem(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoGlobalCliente.class)) {
				TipoGlobalClienteDataAccess.save(definicion.getTipoGlobalCliente(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoCosteoDefinicion.class)) {
				TipoCosteoDefinicionDataAccess.save(definicion.getTipoCosteoDefinicion(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoCostoDefinicion.class)) {
				TipoCostoDefinicionDataAccess.save(definicion.getTipoCostoDefinicion(),connexion);
				continue;
			}

			if(clas.clas.equals(Formato.class)) {
				FormatoDataAccess.save(definicion.getFormato(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoTributario.class)) {
				TipoTributarioDataAccess.save(definicion.getTipoTributario(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoRetencion.class)) {
				TipoRetencionDataAccess.save(definicion.getTipoRetencion(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoDocumento.class)) {
				TipoDocumentoDataAccess.save(definicion.getTipoDocumento(),connexion);
				continue;
			}

			if(clas.clas.equals(LibroContable.class)) {
				LibroContableDataAccess.save(definicion.getLibroContable(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoTransaccionModulo.class)) {
				TipoTransaccionModuloDataAccess.save(definicion.getTipoTransaccionModulo(),connexion);
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(definicion.getCuentaContable(),connexion);
				continue;
			}

		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(definicion.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(definicion.getEmpresa(),isDeep,deepLoadType,clases);
				

		ModuloDataAccess.save(definicion.getModulo(),connexion);
		ModuloLogic moduloLogic= new ModuloLogic(connexion);
		moduloLogic.deepLoad(definicion.getModulo(),isDeep,deepLoadType,clases);
				

		TipoDefinicionDataAccess.save(definicion.getTipoDefinicion(),connexion);
		TipoDefinicionLogic tipodefinicionLogic= new TipoDefinicionLogic(connexion);
		tipodefinicionLogic.deepLoad(definicion.getTipoDefinicion(),isDeep,deepLoadType,clases);
				

		TransaccionDataAccess.save(definicion.getTransaccion(),connexion);
		TransaccionLogic transaccionLogic= new TransaccionLogic(connexion);
		transaccionLogic.deepLoad(definicion.getTransaccion(),isDeep,deepLoadType,clases);
				

		SucursalDataAccess.save(definicion.getSucursal(),connexion);
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(definicion.getSucursal(),isDeep,deepLoadType,clases);
				

		TipoIvaItemDataAccess.save(definicion.getTipoIvaItem(),connexion);
		TipoIvaItemLogic tipoivaitemLogic= new TipoIvaItemLogic(connexion);
		tipoivaitemLogic.deepLoad(definicion.getTipoIvaItem(),isDeep,deepLoadType,clases);
				

		TipoGlobalClienteDataAccess.save(definicion.getTipoGlobalCliente(),connexion);
		TipoGlobalClienteLogic tipoglobalclienteLogic= new TipoGlobalClienteLogic(connexion);
		tipoglobalclienteLogic.deepLoad(definicion.getTipoGlobalCliente(),isDeep,deepLoadType,clases);
				

		TipoCosteoDefinicionDataAccess.save(definicion.getTipoCosteoDefinicion(),connexion);
		TipoCosteoDefinicionLogic tipocosteodefinicionLogic= new TipoCosteoDefinicionLogic(connexion);
		tipocosteodefinicionLogic.deepLoad(definicion.getTipoCosteoDefinicion(),isDeep,deepLoadType,clases);
				

		TipoCostoDefinicionDataAccess.save(definicion.getTipoCostoDefinicion(),connexion);
		TipoCostoDefinicionLogic tipocostodefinicionLogic= new TipoCostoDefinicionLogic(connexion);
		tipocostodefinicionLogic.deepLoad(definicion.getTipoCostoDefinicion(),isDeep,deepLoadType,clases);
				

		FormatoDataAccess.save(definicion.getFormato(),connexion);
		FormatoLogic formatoLogic= new FormatoLogic(connexion);
		formatoLogic.deepLoad(definicion.getFormato(),isDeep,deepLoadType,clases);
				

		TipoTributarioDataAccess.save(definicion.getTipoTributario(),connexion);
		TipoTributarioLogic tipotributarioLogic= new TipoTributarioLogic(connexion);
		tipotributarioLogic.deepLoad(definicion.getTipoTributario(),isDeep,deepLoadType,clases);
				

		TipoRetencionDataAccess.save(definicion.getTipoRetencion(),connexion);
		TipoRetencionLogic tiporetencionLogic= new TipoRetencionLogic(connexion);
		tiporetencionLogic.deepLoad(definicion.getTipoRetencion(),isDeep,deepLoadType,clases);
				

		TipoDocumentoDataAccess.save(definicion.getTipoDocumento(),connexion);
		TipoDocumentoLogic tipodocumentoLogic= new TipoDocumentoLogic(connexion);
		tipodocumentoLogic.deepLoad(definicion.getTipoDocumento(),isDeep,deepLoadType,clases);
				

		LibroContableDataAccess.save(definicion.getLibroContable(),connexion);
		LibroContableLogic librocontableLogic= new LibroContableLogic(connexion);
		librocontableLogic.deepLoad(definicion.getLibroContable(),isDeep,deepLoadType,clases);
				

		TipoTransaccionModuloDataAccess.save(definicion.getTipoTransaccionModulo(),connexion);
		TipoTransaccionModuloLogic tipotransaccionmoduloLogic= new TipoTransaccionModuloLogic(connexion);
		tipotransaccionmoduloLogic.deepLoad(definicion.getTipoTransaccionModulo(),isDeep,deepLoadType,clases);
				

		CuentaContableDataAccess.save(definicion.getCuentaContable(),connexion);
		CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
		cuentacontableLogic.deepLoad(definicion.getCuentaContable(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(definicion.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(definicion.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Modulo.class)) {
				ModuloDataAccess.save(definicion.getModulo(),connexion);
				ModuloLogic moduloLogic= new ModuloLogic(connexion);
				moduloLogic.deepSave(definicion.getModulo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoDefinicion.class)) {
				TipoDefinicionDataAccess.save(definicion.getTipoDefinicion(),connexion);
				TipoDefinicionLogic tipodefinicionLogic= new TipoDefinicionLogic(connexion);
				tipodefinicionLogic.deepSave(definicion.getTipoDefinicion(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Transaccion.class)) {
				TransaccionDataAccess.save(definicion.getTransaccion(),connexion);
				TransaccionLogic transaccionLogic= new TransaccionLogic(connexion);
				transaccionLogic.deepSave(definicion.getTransaccion(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(definicion.getSucursal(),connexion);
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepSave(definicion.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoIvaItem.class)) {
				TipoIvaItemDataAccess.save(definicion.getTipoIvaItem(),connexion);
				TipoIvaItemLogic tipoivaitemLogic= new TipoIvaItemLogic(connexion);
				tipoivaitemLogic.deepSave(definicion.getTipoIvaItem(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoGlobalCliente.class)) {
				TipoGlobalClienteDataAccess.save(definicion.getTipoGlobalCliente(),connexion);
				TipoGlobalClienteLogic tipoglobalclienteLogic= new TipoGlobalClienteLogic(connexion);
				tipoglobalclienteLogic.deepSave(definicion.getTipoGlobalCliente(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoCosteoDefinicion.class)) {
				TipoCosteoDefinicionDataAccess.save(definicion.getTipoCosteoDefinicion(),connexion);
				TipoCosteoDefinicionLogic tipocosteodefinicionLogic= new TipoCosteoDefinicionLogic(connexion);
				tipocosteodefinicionLogic.deepSave(definicion.getTipoCosteoDefinicion(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoCostoDefinicion.class)) {
				TipoCostoDefinicionDataAccess.save(definicion.getTipoCostoDefinicion(),connexion);
				TipoCostoDefinicionLogic tipocostodefinicionLogic= new TipoCostoDefinicionLogic(connexion);
				tipocostodefinicionLogic.deepSave(definicion.getTipoCostoDefinicion(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Formato.class)) {
				FormatoDataAccess.save(definicion.getFormato(),connexion);
				FormatoLogic formatoLogic= new FormatoLogic(connexion);
				formatoLogic.deepSave(definicion.getFormato(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoTributario.class)) {
				TipoTributarioDataAccess.save(definicion.getTipoTributario(),connexion);
				TipoTributarioLogic tipotributarioLogic= new TipoTributarioLogic(connexion);
				tipotributarioLogic.deepSave(definicion.getTipoTributario(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoRetencion.class)) {
				TipoRetencionDataAccess.save(definicion.getTipoRetencion(),connexion);
				TipoRetencionLogic tiporetencionLogic= new TipoRetencionLogic(connexion);
				tiporetencionLogic.deepSave(definicion.getTipoRetencion(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoDocumento.class)) {
				TipoDocumentoDataAccess.save(definicion.getTipoDocumento(),connexion);
				TipoDocumentoLogic tipodocumentoLogic= new TipoDocumentoLogic(connexion);
				tipodocumentoLogic.deepSave(definicion.getTipoDocumento(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(LibroContable.class)) {
				LibroContableDataAccess.save(definicion.getLibroContable(),connexion);
				LibroContableLogic librocontableLogic= new LibroContableLogic(connexion);
				librocontableLogic.deepSave(definicion.getLibroContable(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoTransaccionModulo.class)) {
				TipoTransaccionModuloDataAccess.save(definicion.getTipoTransaccionModulo(),connexion);
				TipoTransaccionModuloLogic tipotransaccionmoduloLogic= new TipoTransaccionModuloLogic(connexion);
				tipotransaccionmoduloLogic.deepSave(definicion.getTipoTransaccionModulo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(definicion.getCuentaContable(),connexion);
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepSave(definicion.getCuentaContable(),isDeep,deepLoadType,clases);				
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
			this.getNewConnexionToDeep(Definicion.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(definicion,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				DefinicionConstantesFunciones.refrescarForeignKeysDescripcionesDefinicion(definicion);
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
			this.deepLoad(this.definicion,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				DefinicionConstantesFunciones.refrescarForeignKeysDescripcionesDefinicion(this.definicion);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(Definicion.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(definicions!=null) {
				for(Definicion definicion:definicions) {
					this.deepLoad(definicion,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					DefinicionConstantesFunciones.refrescarForeignKeysDescripcionesDefinicion(definicions);
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
			if(definicions!=null) {
				for(Definicion definicion:definicions) {
					this.deepLoad(definicion,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					DefinicionConstantesFunciones.refrescarForeignKeysDescripcionesDefinicion(definicions);
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
			this.getNewConnexionToDeep(Definicion.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(definicion,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(Definicion.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(definicions!=null) {
				for(Definicion definicion:definicions) {
					this.deepSave(definicion,isDeep,deepLoadType,clases);
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
			if(definicions!=null) {
				for(Definicion definicion:definicions) {
					this.deepSave(definicion,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getDefinicionsFK_IdCuentaContableWithConnection(String sFinalQuery,Pagination pagination,Long id_cuenta_contable)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Definicion.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContable= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContable.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable,DefinicionConstantesFunciones.IDCUENTACONTABLE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContable);

			DefinicionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContable","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			definicions=definicionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DefinicionConstantesFunciones.refrescarForeignKeysDescripcionesDefinicion(this.definicions);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDefinicionsFK_IdCuentaContable(String sFinalQuery,Pagination pagination,Long id_cuenta_contable)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContable= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContable.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable,DefinicionConstantesFunciones.IDCUENTACONTABLE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContable);

			DefinicionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContable","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			definicions=definicionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DefinicionConstantesFunciones.refrescarForeignKeysDescripcionesDefinicion(this.definicions);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDefinicionsFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Definicion.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,DefinicionConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			DefinicionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			definicions=definicionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DefinicionConstantesFunciones.refrescarForeignKeysDescripcionesDefinicion(this.definicions);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDefinicionsFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,DefinicionConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			DefinicionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			definicions=definicionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DefinicionConstantesFunciones.refrescarForeignKeysDescripcionesDefinicion(this.definicions);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDefinicionsFK_IdFormatoWithConnection(String sFinalQuery,Pagination pagination,Long id_formato)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Definicion.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidFormato= new ParameterSelectionGeneral();
			parameterSelectionGeneralidFormato.setParameterSelectionGeneralEqual(ParameterType.LONG,id_formato,DefinicionConstantesFunciones.IDFORMATO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidFormato);

			DefinicionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdFormato","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			definicions=definicionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DefinicionConstantesFunciones.refrescarForeignKeysDescripcionesDefinicion(this.definicions);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDefinicionsFK_IdFormato(String sFinalQuery,Pagination pagination,Long id_formato)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidFormato= new ParameterSelectionGeneral();
			parameterSelectionGeneralidFormato.setParameterSelectionGeneralEqual(ParameterType.LONG,id_formato,DefinicionConstantesFunciones.IDFORMATO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidFormato);

			DefinicionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdFormato","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			definicions=definicionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DefinicionConstantesFunciones.refrescarForeignKeysDescripcionesDefinicion(this.definicions);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDefinicionsFK_IdLibroContableWithConnection(String sFinalQuery,Pagination pagination,Long id_libro_contable)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Definicion.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidLibroContable= new ParameterSelectionGeneral();
			parameterSelectionGeneralidLibroContable.setParameterSelectionGeneralEqual(ParameterType.LONG,id_libro_contable,DefinicionConstantesFunciones.IDLIBROCONTABLE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidLibroContable);

			DefinicionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdLibroContable","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			definicions=definicionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DefinicionConstantesFunciones.refrescarForeignKeysDescripcionesDefinicion(this.definicions);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDefinicionsFK_IdLibroContable(String sFinalQuery,Pagination pagination,Long id_libro_contable)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidLibroContable= new ParameterSelectionGeneral();
			parameterSelectionGeneralidLibroContable.setParameterSelectionGeneralEqual(ParameterType.LONG,id_libro_contable,DefinicionConstantesFunciones.IDLIBROCONTABLE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidLibroContable);

			DefinicionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdLibroContable","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			definicions=definicionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DefinicionConstantesFunciones.refrescarForeignKeysDescripcionesDefinicion(this.definicions);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDefinicionsFK_IdModuloWithConnection(String sFinalQuery,Pagination pagination,Long id_modulo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Definicion.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidModulo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidModulo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_modulo,DefinicionConstantesFunciones.IDMODULO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidModulo);

			DefinicionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdModulo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			definicions=definicionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DefinicionConstantesFunciones.refrescarForeignKeysDescripcionesDefinicion(this.definicions);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDefinicionsFK_IdModulo(String sFinalQuery,Pagination pagination,Long id_modulo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidModulo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidModulo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_modulo,DefinicionConstantesFunciones.IDMODULO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidModulo);

			DefinicionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdModulo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			definicions=definicionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DefinicionConstantesFunciones.refrescarForeignKeysDescripcionesDefinicion(this.definicions);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDefinicionsFK_IdSucursalWithConnection(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Definicion.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,DefinicionConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			DefinicionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			definicions=definicionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DefinicionConstantesFunciones.refrescarForeignKeysDescripcionesDefinicion(this.definicions);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDefinicionsFK_IdSucursal(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,DefinicionConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			DefinicionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			definicions=definicionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DefinicionConstantesFunciones.refrescarForeignKeysDescripcionesDefinicion(this.definicions);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDefinicionsFK_IdTipoCosteoDefinicionWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_costeo_definicion)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Definicion.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoCosteoDefinicion= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoCosteoDefinicion.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_costeo_definicion,DefinicionConstantesFunciones.IDTIPOCOSTEODEFINICION,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoCosteoDefinicion);

			DefinicionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoCosteoDefinicion","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			definicions=definicionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DefinicionConstantesFunciones.refrescarForeignKeysDescripcionesDefinicion(this.definicions);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDefinicionsFK_IdTipoCosteoDefinicion(String sFinalQuery,Pagination pagination,Long id_tipo_costeo_definicion)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoCosteoDefinicion= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoCosteoDefinicion.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_costeo_definicion,DefinicionConstantesFunciones.IDTIPOCOSTEODEFINICION,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoCosteoDefinicion);

			DefinicionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoCosteoDefinicion","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			definicions=definicionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DefinicionConstantesFunciones.refrescarForeignKeysDescripcionesDefinicion(this.definicions);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDefinicionsFK_IdTipoCostoDefinicionWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_costo_definicion)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Definicion.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoCostoDefinicion= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoCostoDefinicion.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_costo_definicion,DefinicionConstantesFunciones.IDTIPOCOSTODEFINICION,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoCostoDefinicion);

			DefinicionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoCostoDefinicion","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			definicions=definicionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DefinicionConstantesFunciones.refrescarForeignKeysDescripcionesDefinicion(this.definicions);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDefinicionsFK_IdTipoCostoDefinicion(String sFinalQuery,Pagination pagination,Long id_tipo_costo_definicion)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoCostoDefinicion= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoCostoDefinicion.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_costo_definicion,DefinicionConstantesFunciones.IDTIPOCOSTODEFINICION,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoCostoDefinicion);

			DefinicionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoCostoDefinicion","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			definicions=definicionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DefinicionConstantesFunciones.refrescarForeignKeysDescripcionesDefinicion(this.definicions);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDefinicionsFK_IdTipoDefinicionWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_definicion)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Definicion.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoDefinicion= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoDefinicion.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_definicion,DefinicionConstantesFunciones.IDTIPODEFINICION,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoDefinicion);

			DefinicionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoDefinicion","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			definicions=definicionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DefinicionConstantesFunciones.refrescarForeignKeysDescripcionesDefinicion(this.definicions);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDefinicionsFK_IdTipoDefinicion(String sFinalQuery,Pagination pagination,Long id_tipo_definicion)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoDefinicion= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoDefinicion.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_definicion,DefinicionConstantesFunciones.IDTIPODEFINICION,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoDefinicion);

			DefinicionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoDefinicion","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			definicions=definicionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DefinicionConstantesFunciones.refrescarForeignKeysDescripcionesDefinicion(this.definicions);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDefinicionsFK_IdTipoDocumentoWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_documento)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Definicion.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoDocumento= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoDocumento.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_documento,DefinicionConstantesFunciones.IDTIPODOCUMENTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoDocumento);

			DefinicionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoDocumento","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			definicions=definicionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DefinicionConstantesFunciones.refrescarForeignKeysDescripcionesDefinicion(this.definicions);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDefinicionsFK_IdTipoDocumento(String sFinalQuery,Pagination pagination,Long id_tipo_documento)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoDocumento= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoDocumento.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_documento,DefinicionConstantesFunciones.IDTIPODOCUMENTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoDocumento);

			DefinicionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoDocumento","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			definicions=definicionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DefinicionConstantesFunciones.refrescarForeignKeysDescripcionesDefinicion(this.definicions);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDefinicionsFK_IdTipoGlobalClienteWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_global_cliente)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Definicion.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoGlobalCliente= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoGlobalCliente.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_global_cliente,DefinicionConstantesFunciones.IDTIPOGLOBALCLIENTE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoGlobalCliente);

			DefinicionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoGlobalCliente","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			definicions=definicionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DefinicionConstantesFunciones.refrescarForeignKeysDescripcionesDefinicion(this.definicions);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDefinicionsFK_IdTipoGlobalCliente(String sFinalQuery,Pagination pagination,Long id_tipo_global_cliente)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoGlobalCliente= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoGlobalCliente.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_global_cliente,DefinicionConstantesFunciones.IDTIPOGLOBALCLIENTE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoGlobalCliente);

			DefinicionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoGlobalCliente","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			definicions=definicionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DefinicionConstantesFunciones.refrescarForeignKeysDescripcionesDefinicion(this.definicions);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDefinicionsFK_IdTipoIvaItemWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_iva_item)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Definicion.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoIvaItem= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoIvaItem.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_iva_item,DefinicionConstantesFunciones.IDTIPOIVAITEM,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoIvaItem);

			DefinicionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoIvaItem","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			definicions=definicionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DefinicionConstantesFunciones.refrescarForeignKeysDescripcionesDefinicion(this.definicions);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDefinicionsFK_IdTipoIvaItem(String sFinalQuery,Pagination pagination,Long id_tipo_iva_item)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoIvaItem= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoIvaItem.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_iva_item,DefinicionConstantesFunciones.IDTIPOIVAITEM,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoIvaItem);

			DefinicionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoIvaItem","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			definicions=definicionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DefinicionConstantesFunciones.refrescarForeignKeysDescripcionesDefinicion(this.definicions);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDefinicionsFK_IdTipoRetencionWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_retencion)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Definicion.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoRetencion= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoRetencion.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_retencion,DefinicionConstantesFunciones.IDTIPORETENCION,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoRetencion);

			DefinicionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoRetencion","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			definicions=definicionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DefinicionConstantesFunciones.refrescarForeignKeysDescripcionesDefinicion(this.definicions);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDefinicionsFK_IdTipoRetencion(String sFinalQuery,Pagination pagination,Long id_tipo_retencion)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoRetencion= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoRetencion.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_retencion,DefinicionConstantesFunciones.IDTIPORETENCION,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoRetencion);

			DefinicionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoRetencion","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			definicions=definicionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DefinicionConstantesFunciones.refrescarForeignKeysDescripcionesDefinicion(this.definicions);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDefinicionsFK_IdTipoTransaccionModuloWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_transaccion_modulo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Definicion.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoTransaccionModulo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoTransaccionModulo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_transaccion_modulo,DefinicionConstantesFunciones.IDTIPOTRANSACCIONMODULO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoTransaccionModulo);

			DefinicionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoTransaccionModulo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			definicions=definicionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DefinicionConstantesFunciones.refrescarForeignKeysDescripcionesDefinicion(this.definicions);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDefinicionsFK_IdTipoTransaccionModulo(String sFinalQuery,Pagination pagination,Long id_tipo_transaccion_modulo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoTransaccionModulo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoTransaccionModulo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_transaccion_modulo,DefinicionConstantesFunciones.IDTIPOTRANSACCIONMODULO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoTransaccionModulo);

			DefinicionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoTransaccionModulo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			definicions=definicionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DefinicionConstantesFunciones.refrescarForeignKeysDescripcionesDefinicion(this.definicions);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDefinicionsFK_IdTipoTributarioWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_tributario)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Definicion.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoTributario= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoTributario.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_tributario,DefinicionConstantesFunciones.IDTIPOTRIBUTARIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoTributario);

			DefinicionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoTributario","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			definicions=definicionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DefinicionConstantesFunciones.refrescarForeignKeysDescripcionesDefinicion(this.definicions);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDefinicionsFK_IdTipoTributario(String sFinalQuery,Pagination pagination,Long id_tipo_tributario)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoTributario= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoTributario.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_tributario,DefinicionConstantesFunciones.IDTIPOTRIBUTARIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoTributario);

			DefinicionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoTributario","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			definicions=definicionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DefinicionConstantesFunciones.refrescarForeignKeysDescripcionesDefinicion(this.definicions);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDefinicionsFK_IdTransaccionWithConnection(String sFinalQuery,Pagination pagination,Long id_transaccion)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Definicion.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTransaccion= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTransaccion.setParameterSelectionGeneralEqual(ParameterType.LONG,id_transaccion,DefinicionConstantesFunciones.IDTRANSACCION,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTransaccion);

			DefinicionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTransaccion","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			definicions=definicionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DefinicionConstantesFunciones.refrescarForeignKeysDescripcionesDefinicion(this.definicions);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDefinicionsFK_IdTransaccion(String sFinalQuery,Pagination pagination,Long id_transaccion)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTransaccion= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTransaccion.setParameterSelectionGeneralEqual(ParameterType.LONG,id_transaccion,DefinicionConstantesFunciones.IDTRANSACCION,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTransaccion);

			DefinicionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTransaccion","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			definicions=definicionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DefinicionConstantesFunciones.refrescarForeignKeysDescripcionesDefinicion(this.definicions);
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
			if(DefinicionConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,DefinicionDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,Definicion definicion,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(DefinicionConstantesFunciones.ISCONAUDITORIA) {
				if(definicion.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,DefinicionDataAccess.TABLENAME, definicion.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(DefinicionConstantesFunciones.ISCONAUDITORIADETALLE) {
						////DefinicionLogic.registrarAuditoriaDetallesDefinicion(connexion,definicion,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(definicion.getIsDeleted()) {
					/*if(!definicion.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,DefinicionDataAccess.TABLENAME, definicion.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////DefinicionLogic.registrarAuditoriaDetallesDefinicion(connexion,definicion,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,DefinicionDataAccess.TABLENAME, definicion.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(definicion.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,DefinicionDataAccess.TABLENAME, definicion.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(DefinicionConstantesFunciones.ISCONAUDITORIADETALLE) {
						////DefinicionLogic.registrarAuditoriaDetallesDefinicion(connexion,definicion,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesDefinicion(Connexion connexion,Definicion definicion)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(definicion.getIsNew()||!definicion.getid_empresa().equals(definicion.getDefinicionOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(definicion.getDefinicionOriginal().getid_empresa()!=null)
				{
					strValorActual=definicion.getDefinicionOriginal().getid_empresa().toString();
				}
				if(definicion.getid_empresa()!=null)
				{
					strValorNuevo=definicion.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DefinicionConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(definicion.getIsNew()||!definicion.getid_modulo().equals(definicion.getDefinicionOriginal().getid_modulo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(definicion.getDefinicionOriginal().getid_modulo()!=null)
				{
					strValorActual=definicion.getDefinicionOriginal().getid_modulo().toString();
				}
				if(definicion.getid_modulo()!=null)
				{
					strValorNuevo=definicion.getid_modulo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DefinicionConstantesFunciones.IDMODULO,strValorActual,strValorNuevo);
			}	
			
			if(definicion.getIsNew()||!definicion.getsecuencial_formato().equals(definicion.getDefinicionOriginal().getsecuencial_formato()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(definicion.getDefinicionOriginal().getsecuencial_formato()!=null)
				{
					strValorActual=definicion.getDefinicionOriginal().getsecuencial_formato();
				}
				if(definicion.getsecuencial_formato()!=null)
				{
					strValorNuevo=definicion.getsecuencial_formato() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DefinicionConstantesFunciones.SECUENCIALFORMATO,strValorActual,strValorNuevo);
			}	
			
			if(definicion.getIsNew()||!definicion.getsecuencial().equals(definicion.getDefinicionOriginal().getsecuencial()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(definicion.getDefinicionOriginal().getsecuencial()!=null)
				{
					strValorActual=definicion.getDefinicionOriginal().getsecuencial().toString();
				}
				if(definicion.getsecuencial()!=null)
				{
					strValorNuevo=definicion.getsecuencial().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DefinicionConstantesFunciones.SECUENCIAL,strValorActual,strValorNuevo);
			}	
			
			if(definicion.getIsNew()||!definicion.getid_tipo_definicion().equals(definicion.getDefinicionOriginal().getid_tipo_definicion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(definicion.getDefinicionOriginal().getid_tipo_definicion()!=null)
				{
					strValorActual=definicion.getDefinicionOriginal().getid_tipo_definicion().toString();
				}
				if(definicion.getid_tipo_definicion()!=null)
				{
					strValorNuevo=definicion.getid_tipo_definicion().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DefinicionConstantesFunciones.IDTIPODEFINICION,strValorActual,strValorNuevo);
			}	
			
			if(definicion.getIsNew()||!definicion.getid_transaccion().equals(definicion.getDefinicionOriginal().getid_transaccion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(definicion.getDefinicionOriginal().getid_transaccion()!=null)
				{
					strValorActual=definicion.getDefinicionOriginal().getid_transaccion().toString();
				}
				if(definicion.getid_transaccion()!=null)
				{
					strValorNuevo=definicion.getid_transaccion().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DefinicionConstantesFunciones.IDTRANSACCION,strValorActual,strValorNuevo);
			}	
			
			if(definicion.getIsNew()||!definicion.getid_sucursal().equals(definicion.getDefinicionOriginal().getid_sucursal()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(definicion.getDefinicionOriginal().getid_sucursal()!=null)
				{
					strValorActual=definicion.getDefinicionOriginal().getid_sucursal().toString();
				}
				if(definicion.getid_sucursal()!=null)
				{
					strValorNuevo=definicion.getid_sucursal().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DefinicionConstantesFunciones.IDSUCURSAL,strValorActual,strValorNuevo);
			}	
			
			if(definicion.getIsNew()||!definicion.getid_tipo_iva_item().equals(definicion.getDefinicionOriginal().getid_tipo_iva_item()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(definicion.getDefinicionOriginal().getid_tipo_iva_item()!=null)
				{
					strValorActual=definicion.getDefinicionOriginal().getid_tipo_iva_item().toString();
				}
				if(definicion.getid_tipo_iva_item()!=null)
				{
					strValorNuevo=definicion.getid_tipo_iva_item().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DefinicionConstantesFunciones.IDTIPOIVAITEM,strValorActual,strValorNuevo);
			}	
			
			if(definicion.getIsNew()||!definicion.getcon_mostrar_bodega().equals(definicion.getDefinicionOriginal().getcon_mostrar_bodega()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(definicion.getDefinicionOriginal().getcon_mostrar_bodega()!=null)
				{
					strValorActual=definicion.getDefinicionOriginal().getcon_mostrar_bodega().toString();
				}
				if(definicion.getcon_mostrar_bodega()!=null)
				{
					strValorNuevo=definicion.getcon_mostrar_bodega().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DefinicionConstantesFunciones.CONMOSTRARBODEGA,strValorActual,strValorNuevo);
			}	
			
			if(definicion.getIsNew()||!definicion.getfactor().equals(definicion.getDefinicionOriginal().getfactor()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(definicion.getDefinicionOriginal().getfactor()!=null)
				{
					strValorActual=definicion.getDefinicionOriginal().getfactor().toString();
				}
				if(definicion.getfactor()!=null)
				{
					strValorNuevo=definicion.getfactor().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DefinicionConstantesFunciones.FACTOR,strValorActual,strValorNuevo);
			}	
			
			if(definicion.getIsNew()||!definicion.getcon_otro_recargo().equals(definicion.getDefinicionOriginal().getcon_otro_recargo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(definicion.getDefinicionOriginal().getcon_otro_recargo()!=null)
				{
					strValorActual=definicion.getDefinicionOriginal().getcon_otro_recargo().toString();
				}
				if(definicion.getcon_otro_recargo()!=null)
				{
					strValorNuevo=definicion.getcon_otro_recargo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DefinicionConstantesFunciones.CONOTRORECARGO,strValorActual,strValorNuevo);
			}	
			
			if(definicion.getIsNew()||!definicion.getid_tipo_global_cliente().equals(definicion.getDefinicionOriginal().getid_tipo_global_cliente()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(definicion.getDefinicionOriginal().getid_tipo_global_cliente()!=null)
				{
					strValorActual=definicion.getDefinicionOriginal().getid_tipo_global_cliente().toString();
				}
				if(definicion.getid_tipo_global_cliente()!=null)
				{
					strValorNuevo=definicion.getid_tipo_global_cliente().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DefinicionConstantesFunciones.IDTIPOGLOBALCLIENTE,strValorActual,strValorNuevo);
			}	
			
			if(definicion.getIsNew()||!definicion.getcon_coa().equals(definicion.getDefinicionOriginal().getcon_coa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(definicion.getDefinicionOriginal().getcon_coa()!=null)
				{
					strValorActual=definicion.getDefinicionOriginal().getcon_coa().toString();
				}
				if(definicion.getcon_coa()!=null)
				{
					strValorNuevo=definicion.getcon_coa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DefinicionConstantesFunciones.CONCOA,strValorActual,strValorNuevo);
			}	
			
			if(definicion.getIsNew()||!definicion.getid_tipo_costeo_definicion().equals(definicion.getDefinicionOriginal().getid_tipo_costeo_definicion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(definicion.getDefinicionOriginal().getid_tipo_costeo_definicion()!=null)
				{
					strValorActual=definicion.getDefinicionOriginal().getid_tipo_costeo_definicion().toString();
				}
				if(definicion.getid_tipo_costeo_definicion()!=null)
				{
					strValorNuevo=definicion.getid_tipo_costeo_definicion().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DefinicionConstantesFunciones.IDTIPOCOSTEODEFINICION,strValorActual,strValorNuevo);
			}	
			
			if(definicion.getIsNew()||!definicion.getcon_retencion().equals(definicion.getDefinicionOriginal().getcon_retencion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(definicion.getDefinicionOriginal().getcon_retencion()!=null)
				{
					strValorActual=definicion.getDefinicionOriginal().getcon_retencion().toString();
				}
				if(definicion.getcon_retencion()!=null)
				{
					strValorNuevo=definicion.getcon_retencion().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DefinicionConstantesFunciones.CONRETENCION,strValorActual,strValorNuevo);
			}	
			
			if(definicion.getIsNew()||!definicion.getid_tipo_costo_definicion().equals(definicion.getDefinicionOriginal().getid_tipo_costo_definicion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(definicion.getDefinicionOriginal().getid_tipo_costo_definicion()!=null)
				{
					strValorActual=definicion.getDefinicionOriginal().getid_tipo_costo_definicion().toString();
				}
				if(definicion.getid_tipo_costo_definicion()!=null)
				{
					strValorNuevo=definicion.getid_tipo_costo_definicion().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DefinicionConstantesFunciones.IDTIPOCOSTODEFINICION,strValorActual,strValorNuevo);
			}	
			
			if(definicion.getIsNew()||!definicion.getcon_novedad_producto().equals(definicion.getDefinicionOriginal().getcon_novedad_producto()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(definicion.getDefinicionOriginal().getcon_novedad_producto()!=null)
				{
					strValorActual=definicion.getDefinicionOriginal().getcon_novedad_producto().toString();
				}
				if(definicion.getcon_novedad_producto()!=null)
				{
					strValorNuevo=definicion.getcon_novedad_producto().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DefinicionConstantesFunciones.CONNOVEDADPRODUCTO,strValorActual,strValorNuevo);
			}	
			
			if(definicion.getIsNew()||!definicion.getcon_ice().equals(definicion.getDefinicionOriginal().getcon_ice()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(definicion.getDefinicionOriginal().getcon_ice()!=null)
				{
					strValorActual=definicion.getDefinicionOriginal().getcon_ice().toString();
				}
				if(definicion.getcon_ice()!=null)
				{
					strValorNuevo=definicion.getcon_ice().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DefinicionConstantesFunciones.CONICE,strValorActual,strValorNuevo);
			}	
			
			if(definicion.getIsNew()||!definicion.getcon_cantidad().equals(definicion.getDefinicionOriginal().getcon_cantidad()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(definicion.getDefinicionOriginal().getcon_cantidad()!=null)
				{
					strValorActual=definicion.getDefinicionOriginal().getcon_cantidad().toString();
				}
				if(definicion.getcon_cantidad()!=null)
				{
					strValorNuevo=definicion.getcon_cantidad().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DefinicionConstantesFunciones.CONCANTIDAD,strValorActual,strValorNuevo);
			}	
			
			if(definicion.getIsNew()||!definicion.getcon_producto_por_proveedor().equals(definicion.getDefinicionOriginal().getcon_producto_por_proveedor()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(definicion.getDefinicionOriginal().getcon_producto_por_proveedor()!=null)
				{
					strValorActual=definicion.getDefinicionOriginal().getcon_producto_por_proveedor().toString();
				}
				if(definicion.getcon_producto_por_proveedor()!=null)
				{
					strValorNuevo=definicion.getcon_producto_por_proveedor().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DefinicionConstantesFunciones.CONPRODUCTOPORPROVEEDOR,strValorActual,strValorNuevo);
			}	
			
			if(definicion.getIsNew()||!definicion.getcon_lote_cliente().equals(definicion.getDefinicionOriginal().getcon_lote_cliente()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(definicion.getDefinicionOriginal().getcon_lote_cliente()!=null)
				{
					strValorActual=definicion.getDefinicionOriginal().getcon_lote_cliente().toString();
				}
				if(definicion.getcon_lote_cliente()!=null)
				{
					strValorNuevo=definicion.getcon_lote_cliente().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DefinicionConstantesFunciones.CONLOTECLIENTE,strValorActual,strValorNuevo);
			}	
			
			if(definicion.getIsNew()||!definicion.getcon_cuenta_contable().equals(definicion.getDefinicionOriginal().getcon_cuenta_contable()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(definicion.getDefinicionOriginal().getcon_cuenta_contable()!=null)
				{
					strValorActual=definicion.getDefinicionOriginal().getcon_cuenta_contable().toString();
				}
				if(definicion.getcon_cuenta_contable()!=null)
				{
					strValorNuevo=definicion.getcon_cuenta_contable().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DefinicionConstantesFunciones.CONCUENTACONTABLE,strValorActual,strValorNuevo);
			}	
			
			if(definicion.getIsNew()||!definicion.getcon_detalle().equals(definicion.getDefinicionOriginal().getcon_detalle()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(definicion.getDefinicionOriginal().getcon_detalle()!=null)
				{
					strValorActual=definicion.getDefinicionOriginal().getcon_detalle().toString();
				}
				if(definicion.getcon_detalle()!=null)
				{
					strValorNuevo=definicion.getcon_detalle().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DefinicionConstantesFunciones.CONDETALLE,strValorActual,strValorNuevo);
			}	
			
			if(definicion.getIsNew()||!definicion.getcon_iva_incluido().equals(definicion.getDefinicionOriginal().getcon_iva_incluido()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(definicion.getDefinicionOriginal().getcon_iva_incluido()!=null)
				{
					strValorActual=definicion.getDefinicionOriginal().getcon_iva_incluido().toString();
				}
				if(definicion.getcon_iva_incluido()!=null)
				{
					strValorNuevo=definicion.getcon_iva_incluido().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DefinicionConstantesFunciones.CONIVAINCLUIDO,strValorActual,strValorNuevo);
			}	
			
			if(definicion.getIsNew()||!definicion.getcon_lotes().equals(definicion.getDefinicionOriginal().getcon_lotes()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(definicion.getDefinicionOriginal().getcon_lotes()!=null)
				{
					strValorActual=definicion.getDefinicionOriginal().getcon_lotes().toString();
				}
				if(definicion.getcon_lotes()!=null)
				{
					strValorNuevo=definicion.getcon_lotes().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DefinicionConstantesFunciones.CONLOTES,strValorActual,strValorNuevo);
			}	
			
			if(definicion.getIsNew()||!definicion.getnumero_descuentos().equals(definicion.getDefinicionOriginal().getnumero_descuentos()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(definicion.getDefinicionOriginal().getnumero_descuentos()!=null)
				{
					strValorActual=definicion.getDefinicionOriginal().getnumero_descuentos().toString();
				}
				if(definicion.getnumero_descuentos()!=null)
				{
					strValorNuevo=definicion.getnumero_descuentos().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DefinicionConstantesFunciones.NUMERODESCUENTOS,strValorActual,strValorNuevo);
			}	
			
			if(definicion.getIsNew()||!definicion.getcon_precio().equals(definicion.getDefinicionOriginal().getcon_precio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(definicion.getDefinicionOriginal().getcon_precio()!=null)
				{
					strValorActual=definicion.getDefinicionOriginal().getcon_precio().toString();
				}
				if(definicion.getcon_precio()!=null)
				{
					strValorNuevo=definicion.getcon_precio().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DefinicionConstantesFunciones.CONPRECIO,strValorActual,strValorNuevo);
			}	
			
			if(definicion.getIsNew()||!definicion.getnumero_registros().equals(definicion.getDefinicionOriginal().getnumero_registros()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(definicion.getDefinicionOriginal().getnumero_registros()!=null)
				{
					strValorActual=definicion.getDefinicionOriginal().getnumero_registros().toString();
				}
				if(definicion.getnumero_registros()!=null)
				{
					strValorNuevo=definicion.getnumero_registros().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DefinicionConstantesFunciones.NUMEROREGISTROS,strValorActual,strValorNuevo);
			}	
			
			if(definicion.getIsNew()||!definicion.getcon_centro_costo().equals(definicion.getDefinicionOriginal().getcon_centro_costo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(definicion.getDefinicionOriginal().getcon_centro_costo()!=null)
				{
					strValorActual=definicion.getDefinicionOriginal().getcon_centro_costo().toString();
				}
				if(definicion.getcon_centro_costo()!=null)
				{
					strValorNuevo=definicion.getcon_centro_costo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DefinicionConstantesFunciones.CONCENTROCOSTO,strValorActual,strValorNuevo);
			}	
			
			if(definicion.getIsNew()||!definicion.getcon_orden_iva().equals(definicion.getDefinicionOriginal().getcon_orden_iva()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(definicion.getDefinicionOriginal().getcon_orden_iva()!=null)
				{
					strValorActual=definicion.getDefinicionOriginal().getcon_orden_iva().toString();
				}
				if(definicion.getcon_orden_iva()!=null)
				{
					strValorNuevo=definicion.getcon_orden_iva().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DefinicionConstantesFunciones.CONORDENIVA,strValorActual,strValorNuevo);
			}	
			
			if(definicion.getIsNew()||!definicion.getcon_multi_empresa().equals(definicion.getDefinicionOriginal().getcon_multi_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(definicion.getDefinicionOriginal().getcon_multi_empresa()!=null)
				{
					strValorActual=definicion.getDefinicionOriginal().getcon_multi_empresa().toString();
				}
				if(definicion.getcon_multi_empresa()!=null)
				{
					strValorNuevo=definicion.getcon_multi_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DefinicionConstantesFunciones.CONMULTIEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(definicion.getIsNew()||!definicion.getid_formato().equals(definicion.getDefinicionOriginal().getid_formato()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(definicion.getDefinicionOriginal().getid_formato()!=null)
				{
					strValorActual=definicion.getDefinicionOriginal().getid_formato().toString();
				}
				if(definicion.getid_formato()!=null)
				{
					strValorNuevo=definicion.getid_formato().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DefinicionConstantesFunciones.IDFORMATO,strValorActual,strValorNuevo);
			}	
			
			if(definicion.getIsNew()||!definicion.getcon_en_linea().equals(definicion.getDefinicionOriginal().getcon_en_linea()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(definicion.getDefinicionOriginal().getcon_en_linea()!=null)
				{
					strValorActual=definicion.getDefinicionOriginal().getcon_en_linea().toString();
				}
				if(definicion.getcon_en_linea()!=null)
				{
					strValorNuevo=definicion.getcon_en_linea().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DefinicionConstantesFunciones.CONENLINEA,strValorActual,strValorNuevo);
			}	
			
			if(definicion.getIsNew()||!definicion.getid_tipo_tributario().equals(definicion.getDefinicionOriginal().getid_tipo_tributario()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(definicion.getDefinicionOriginal().getid_tipo_tributario()!=null)
				{
					strValorActual=definicion.getDefinicionOriginal().getid_tipo_tributario().toString();
				}
				if(definicion.getid_tipo_tributario()!=null)
				{
					strValorNuevo=definicion.getid_tipo_tributario().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DefinicionConstantesFunciones.IDTIPOTRIBUTARIO,strValorActual,strValorNuevo);
			}	
			
			if(definicion.getIsNew()||!definicion.getid_tipo_retencion().equals(definicion.getDefinicionOriginal().getid_tipo_retencion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(definicion.getDefinicionOriginal().getid_tipo_retencion()!=null)
				{
					strValorActual=definicion.getDefinicionOriginal().getid_tipo_retencion().toString();
				}
				if(definicion.getid_tipo_retencion()!=null)
				{
					strValorNuevo=definicion.getid_tipo_retencion().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DefinicionConstantesFunciones.IDTIPORETENCION,strValorActual,strValorNuevo);
			}	
			
			if(definicion.getIsNew()||!definicion.getcon_evaluacion().equals(definicion.getDefinicionOriginal().getcon_evaluacion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(definicion.getDefinicionOriginal().getcon_evaluacion()!=null)
				{
					strValorActual=definicion.getDefinicionOriginal().getcon_evaluacion().toString();
				}
				if(definicion.getcon_evaluacion()!=null)
				{
					strValorNuevo=definicion.getcon_evaluacion().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DefinicionConstantesFunciones.CONEVALUACION,strValorActual,strValorNuevo);
			}	
			
			if(definicion.getIsNew()||!definicion.getcon_ot().equals(definicion.getDefinicionOriginal().getcon_ot()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(definicion.getDefinicionOriginal().getcon_ot()!=null)
				{
					strValorActual=definicion.getDefinicionOriginal().getcon_ot().toString();
				}
				if(definicion.getcon_ot()!=null)
				{
					strValorNuevo=definicion.getcon_ot().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DefinicionConstantesFunciones.CONOT,strValorActual,strValorNuevo);
			}	
			
			if(definicion.getIsNew()||!definicion.getcon_anticipo().equals(definicion.getDefinicionOriginal().getcon_anticipo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(definicion.getDefinicionOriginal().getcon_anticipo()!=null)
				{
					strValorActual=definicion.getDefinicionOriginal().getcon_anticipo().toString();
				}
				if(definicion.getcon_anticipo()!=null)
				{
					strValorNuevo=definicion.getcon_anticipo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DefinicionConstantesFunciones.CONANTICIPO,strValorActual,strValorNuevo);
			}	
			
			if(definicion.getIsNew()||!definicion.getcon_cierre().equals(definicion.getDefinicionOriginal().getcon_cierre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(definicion.getDefinicionOriginal().getcon_cierre()!=null)
				{
					strValorActual=definicion.getDefinicionOriginal().getcon_cierre().toString();
				}
				if(definicion.getcon_cierre()!=null)
				{
					strValorNuevo=definicion.getcon_cierre().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DefinicionConstantesFunciones.CONCIERRE,strValorActual,strValorNuevo);
			}	
			
			if(definicion.getIsNew()||!definicion.getcon_general().equals(definicion.getDefinicionOriginal().getcon_general()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(definicion.getDefinicionOriginal().getcon_general()!=null)
				{
					strValorActual=definicion.getDefinicionOriginal().getcon_general().toString();
				}
				if(definicion.getcon_general()!=null)
				{
					strValorNuevo=definicion.getcon_general().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DefinicionConstantesFunciones.CONGENERAL,strValorActual,strValorNuevo);
			}	
			
			if(definicion.getIsNew()||!definicion.getcon_por_producto().equals(definicion.getDefinicionOriginal().getcon_por_producto()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(definicion.getDefinicionOriginal().getcon_por_producto()!=null)
				{
					strValorActual=definicion.getDefinicionOriginal().getcon_por_producto().toString();
				}
				if(definicion.getcon_por_producto()!=null)
				{
					strValorNuevo=definicion.getcon_por_producto().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DefinicionConstantesFunciones.CONPORPRODUCTO,strValorActual,strValorNuevo);
			}	
			
			if(definicion.getIsNew()||!definicion.getcon_descuento().equals(definicion.getDefinicionOriginal().getcon_descuento()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(definicion.getDefinicionOriginal().getcon_descuento()!=null)
				{
					strValorActual=definicion.getDefinicionOriginal().getcon_descuento().toString();
				}
				if(definicion.getcon_descuento()!=null)
				{
					strValorNuevo=definicion.getcon_descuento().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DefinicionConstantesFunciones.CONDESCUENTO,strValorActual,strValorNuevo);
			}	
			
			if(definicion.getIsNew()||!definicion.getcon_series().equals(definicion.getDefinicionOriginal().getcon_series()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(definicion.getDefinicionOriginal().getcon_series()!=null)
				{
					strValorActual=definicion.getDefinicionOriginal().getcon_series().toString();
				}
				if(definicion.getcon_series()!=null)
				{
					strValorNuevo=definicion.getcon_series().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DefinicionConstantesFunciones.CONSERIES,strValorActual,strValorNuevo);
			}	
			
			if(definicion.getIsNew()||!definicion.getcantidad().equals(definicion.getDefinicionOriginal().getcantidad()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(definicion.getDefinicionOriginal().getcantidad()!=null)
				{
					strValorActual=definicion.getDefinicionOriginal().getcantidad().toString();
				}
				if(definicion.getcantidad()!=null)
				{
					strValorNuevo=definicion.getcantidad().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DefinicionConstantesFunciones.CANTIDAD,strValorActual,strValorNuevo);
			}	
			
			if(definicion.getIsNew()||!definicion.getid_tipo_documento().equals(definicion.getDefinicionOriginal().getid_tipo_documento()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(definicion.getDefinicionOriginal().getid_tipo_documento()!=null)
				{
					strValorActual=definicion.getDefinicionOriginal().getid_tipo_documento().toString();
				}
				if(definicion.getid_tipo_documento()!=null)
				{
					strValorNuevo=definicion.getid_tipo_documento().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DefinicionConstantesFunciones.IDTIPODOCUMENTO,strValorActual,strValorNuevo);
			}	
			
			if(definicion.getIsNew()||!definicion.getid_libro_contable().equals(definicion.getDefinicionOriginal().getid_libro_contable()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(definicion.getDefinicionOriginal().getid_libro_contable()!=null)
				{
					strValorActual=definicion.getDefinicionOriginal().getid_libro_contable().toString();
				}
				if(definicion.getid_libro_contable()!=null)
				{
					strValorNuevo=definicion.getid_libro_contable().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DefinicionConstantesFunciones.IDLIBROCONTABLE,strValorActual,strValorNuevo);
			}	
			
			if(definicion.getIsNew()||!definicion.getcon_interno().equals(definicion.getDefinicionOriginal().getcon_interno()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(definicion.getDefinicionOriginal().getcon_interno()!=null)
				{
					strValorActual=definicion.getDefinicionOriginal().getcon_interno().toString();
				}
				if(definicion.getcon_interno()!=null)
				{
					strValorNuevo=definicion.getcon_interno().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DefinicionConstantesFunciones.CONINTERNO,strValorActual,strValorNuevo);
			}	
			
			if(definicion.getIsNew()||!definicion.getcon_reserva().equals(definicion.getDefinicionOriginal().getcon_reserva()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(definicion.getDefinicionOriginal().getcon_reserva()!=null)
				{
					strValorActual=definicion.getDefinicionOriginal().getcon_reserva().toString();
				}
				if(definicion.getcon_reserva()!=null)
				{
					strValorNuevo=definicion.getcon_reserva().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DefinicionConstantesFunciones.CONRESERVA,strValorActual,strValorNuevo);
			}	
			
			if(definicion.getIsNew()||!definicion.getcon_precio_proveedor().equals(definicion.getDefinicionOriginal().getcon_precio_proveedor()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(definicion.getDefinicionOriginal().getcon_precio_proveedor()!=null)
				{
					strValorActual=definicion.getDefinicionOriginal().getcon_precio_proveedor().toString();
				}
				if(definicion.getcon_precio_proveedor()!=null)
				{
					strValorNuevo=definicion.getcon_precio_proveedor().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DefinicionConstantesFunciones.CONPRECIOPROVEEDOR,strValorActual,strValorNuevo);
			}	
			
			if(definicion.getIsNew()||!definicion.getcon_produccion().equals(definicion.getDefinicionOriginal().getcon_produccion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(definicion.getDefinicionOriginal().getcon_produccion()!=null)
				{
					strValorActual=definicion.getDefinicionOriginal().getcon_produccion().toString();
				}
				if(definicion.getcon_produccion()!=null)
				{
					strValorNuevo=definicion.getcon_produccion().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DefinicionConstantesFunciones.CONPRODUCCION,strValorActual,strValorNuevo);
			}	
			
			if(definicion.getIsNew()||!definicion.getcon_codigo_barra().equals(definicion.getDefinicionOriginal().getcon_codigo_barra()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(definicion.getDefinicionOriginal().getcon_codigo_barra()!=null)
				{
					strValorActual=definicion.getDefinicionOriginal().getcon_codigo_barra().toString();
				}
				if(definicion.getcon_codigo_barra()!=null)
				{
					strValorNuevo=definicion.getcon_codigo_barra().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DefinicionConstantesFunciones.CONCODIGOBARRA,strValorActual,strValorNuevo);
			}	
			
			if(definicion.getIsNew()||!definicion.getcon_romaneos().equals(definicion.getDefinicionOriginal().getcon_romaneos()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(definicion.getDefinicionOriginal().getcon_romaneos()!=null)
				{
					strValorActual=definicion.getDefinicionOriginal().getcon_romaneos().toString();
				}
				if(definicion.getcon_romaneos()!=null)
				{
					strValorNuevo=definicion.getcon_romaneos().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DefinicionConstantesFunciones.CONROMANEOS,strValorActual,strValorNuevo);
			}	
			
			if(definicion.getIsNew()||!definicion.getid_tipo_transaccion_modulo().equals(definicion.getDefinicionOriginal().getid_tipo_transaccion_modulo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(definicion.getDefinicionOriginal().getid_tipo_transaccion_modulo()!=null)
				{
					strValorActual=definicion.getDefinicionOriginal().getid_tipo_transaccion_modulo().toString();
				}
				if(definicion.getid_tipo_transaccion_modulo()!=null)
				{
					strValorNuevo=definicion.getid_tipo_transaccion_modulo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DefinicionConstantesFunciones.IDTIPOTRANSACCIONMODULO,strValorActual,strValorNuevo);
			}	
			
			if(definicion.getIsNew()||!definicion.getid_cuenta_contable().equals(definicion.getDefinicionOriginal().getid_cuenta_contable()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(definicion.getDefinicionOriginal().getid_cuenta_contable()!=null)
				{
					strValorActual=definicion.getDefinicionOriginal().getid_cuenta_contable().toString();
				}
				if(definicion.getid_cuenta_contable()!=null)
				{
					strValorNuevo=definicion.getid_cuenta_contable().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DefinicionConstantesFunciones.IDCUENTACONTABLE,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveDefinicionRelacionesWithConnection(Definicion definicion) throws Exception {

		if(!definicion.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveDefinicionRelacionesBase(definicion,true);
		}
	}

	public void saveDefinicionRelaciones(Definicion definicion)throws Exception {

		if(!definicion.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveDefinicionRelacionesBase(definicion,false);
		}
	}

	public void saveDefinicionRelacionesBase(Definicion definicion,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("Definicion-saveRelacionesWithConnection");}
	

			this.setDefinicion(definicion);

			if(DefinicionLogicAdditional.validarSaveRelaciones(definicion,this)) {

				DefinicionLogicAdditional.updateRelacionesToSave(definicion,this);

				if((definicion.getIsNew()||definicion.getIsChanged())&&!definicion.getIsDeleted()) {
					this.saveDefinicion();
					this.saveDefinicionRelacionesDetalles();

				} else if(definicion.getIsDeleted()) {
					this.saveDefinicionRelacionesDetalles();
					this.saveDefinicion();
				}

				DefinicionLogicAdditional.updateRelacionesToSaveAfter(definicion,this);

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
	
	
	private void saveDefinicionRelacionesDetalles()throws Exception {
		try {
	

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfDefinicion(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=DefinicionConstantesFunciones.getClassesForeignKeysOfDefinicion(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfDefinicion(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=DefinicionConstantesFunciones.getClassesRelationshipsOfDefinicion(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

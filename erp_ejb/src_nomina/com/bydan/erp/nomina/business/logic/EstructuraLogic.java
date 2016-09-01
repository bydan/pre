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
import com.bydan.erp.nomina.util.EstructuraConstantesFunciones;
import com.bydan.erp.nomina.util.EstructuraParameterReturnGeneral;
//import com.bydan.erp.nomina.util.EstructuraParameterGeneral;
import com.bydan.erp.nomina.business.entity.Estructura;
import com.bydan.erp.nomina.business.logic.EstructuraLogicAdditional;
import com.bydan.erp.nomina.business.dataaccess.*;
import com.bydan.erp.nomina.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.activosfijos.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;
import com.bydan.erp.contabilidad.business.logic.*;
import com.bydan.erp.inventario.business.logic.*;
import com.bydan.erp.tesoreria.business.logic.*;
import com.bydan.erp.cartera.business.logic.*;
import com.bydan.erp.activosfijos.business.logic.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.inventario.util.*;
import com.bydan.erp.tesoreria.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.activosfijos.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;
import com.bydan.erp.inventario.business.dataaccess.*;
import com.bydan.erp.tesoreria.business.dataaccess.*;
import com.bydan.erp.cartera.business.dataaccess.*;
import com.bydan.erp.activosfijos.business.dataaccess.*;








@SuppressWarnings("unused")
public class EstructuraLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(EstructuraLogic.class);
	
	protected EstructuraDataAccess estructuraDataAccess; 	
	protected Estructura estructura;
	protected List<Estructura> estructuras;
	protected Object estructuraObject;	
	protected List<Object> estructurasObject;
	
	public static ClassValidator<Estructura> estructuraValidator = new ClassValidator<Estructura>(Estructura.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected EstructuraLogicAdditional estructuraLogicAdditional=null;
	
	public EstructuraLogicAdditional getEstructuraLogicAdditional() {
		return this.estructuraLogicAdditional;
	}
	
	public void setEstructuraLogicAdditional(EstructuraLogicAdditional estructuraLogicAdditional) {
		try {
			this.estructuraLogicAdditional=estructuraLogicAdditional;
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
	
	
	
	
	public  EstructuraLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.estructuraDataAccess = new EstructuraDataAccess();
			
			//SE QUITA INICIALIZACION INICIAL, RAPIDEZ PANTALLA
			
			this.estructuraObject=new Object();
			this.estructurasObject=new ArrayList<Object>();
				
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
			
			this.estructuraDataAccess.setConnexionType(this.connexionType);
			this.estructuraDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  EstructuraLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.estructuraDataAccess = new EstructuraDataAccess();
			this.estructuras= new ArrayList<Estructura>();
			this.estructura= new Estructura();
			this.estructuraObject=new Object();
			this.estructurasObject=new ArrayList<Object>();
			
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
			
			this.estructuraDataAccess.setConnexionType(this.connexionType);
			this.estructuraDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public Estructura getEstructura() throws Exception {	
		EstructuraLogicAdditional.checkEstructuraToGet(estructura,this.datosCliente,this.arrDatoGeneral);
		EstructuraLogicAdditional.updateEstructuraToGet(estructura,this.arrDatoGeneral);
		
		return estructura;
	}
		
	public void setEstructura(Estructura newEstructura) {
		this.estructura = newEstructura;
	}
	
	public EstructuraDataAccess getEstructuraDataAccess() {
		return estructuraDataAccess;
	}
	
	public void setEstructuraDataAccess(EstructuraDataAccess newestructuraDataAccess) {
		this.estructuraDataAccess = newestructuraDataAccess;
	}
	
	public List<Estructura> getEstructuras() throws Exception {		
		this.quitarEstructurasNulos();
		
		EstructuraLogicAdditional.checkEstructuraToGets(estructuras,this.datosCliente,this.arrDatoGeneral);
		
		for (Estructura estructuraLocal: estructuras ) {
			EstructuraLogicAdditional.updateEstructuraToGet(estructuraLocal,this.arrDatoGeneral);
		}
		
		return estructuras;
	}
	
	public void setEstructuras(List<Estructura> newEstructuras) {
		this.estructuras = newEstructuras;
	}
	
	public Object getEstructuraObject() {	
		this.estructuraObject=this.estructuraDataAccess.getEntityObject();
		return this.estructuraObject;
	}
		
	public void setEstructuraObject(Object newEstructuraObject) {
		this.estructuraObject = newEstructuraObject;
	}
	
	public List<Object> getEstructurasObject() {		
		this.estructurasObject=this.estructuraDataAccess.getEntitiesObject();
		return this.estructurasObject;
	}
		
	public void setEstructurasObject(List<Object> newEstructurasObject) {
		this.estructurasObject = newEstructurasObject;
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
		
		if(this.estructuraDataAccess!=null) {
			this.estructuraDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Estructura.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			estructuraDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			estructuraDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		estructura = new  Estructura();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Estructura.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			estructura=estructuraDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.estructura,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				EstructuraConstantesFunciones.refrescarForeignKeysDescripcionesEstructura(this.estructura);
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
		estructura = new  Estructura();
		  		  
        try {
			
			estructura=estructuraDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.estructura,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				EstructuraConstantesFunciones.refrescarForeignKeysDescripcionesEstructura(this.estructura);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		estructura = new  Estructura();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Estructura.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			estructura=estructuraDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.estructura,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				EstructuraConstantesFunciones.refrescarForeignKeysDescripcionesEstructura(this.estructura);
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
		estructura = new  Estructura();
		  		  
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
		estructura = new  Estructura();
		  		  
        try {
			
			estructura=estructuraDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.estructura,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				EstructuraConstantesFunciones.refrescarForeignKeysDescripcionesEstructura(this.estructura);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		estructura = new  Estructura();
		  		  
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
		estructura = new  Estructura();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Estructura.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =estructuraDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		estructura = new  Estructura();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=estructuraDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		estructura = new  Estructura();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Estructura.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =estructuraDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		estructura = new  Estructura();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=estructuraDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		estructura = new  Estructura();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Estructura.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =estructuraDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		estructura = new  Estructura();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=estructuraDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		estructuras = new  ArrayList<Estructura>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Estructura.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			EstructuraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estructuras=estructuraDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarEstructura(estructuras);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstructuraConstantesFunciones.refrescarForeignKeysDescripcionesEstructura(this.estructuras);
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
		estructuras = new  ArrayList<Estructura>();
		  		  
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
		estructuras = new  ArrayList<Estructura>();
		  		  
        try {			
			EstructuraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estructuras=estructuraDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarEstructura(estructuras);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstructuraConstantesFunciones.refrescarForeignKeysDescripcionesEstructura(this.estructuras);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		estructuras = new  ArrayList<Estructura>();
		  		  
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
		estructuras = new  ArrayList<Estructura>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Estructura.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			EstructuraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estructuras=estructuraDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarEstructura(estructuras);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstructuraConstantesFunciones.refrescarForeignKeysDescripcionesEstructura(this.estructuras);
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
		estructuras = new  ArrayList<Estructura>();
		  		  
        try {
			EstructuraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estructuras=estructuraDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarEstructura(estructuras);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstructuraConstantesFunciones.refrescarForeignKeysDescripcionesEstructura(this.estructuras);
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
		estructuras = new  ArrayList<Estructura>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Estructura.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EstructuraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estructuras=estructuraDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarEstructura(estructuras);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstructuraConstantesFunciones.refrescarForeignKeysDescripcionesEstructura(this.estructuras);
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
		estructuras = new  ArrayList<Estructura>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EstructuraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estructuras=estructuraDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarEstructura(estructuras);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstructuraConstantesFunciones.refrescarForeignKeysDescripcionesEstructura(this.estructuras);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		estructura = new  Estructura();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Estructura.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EstructuraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estructura=estructuraDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarEstructura(estructura);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstructuraConstantesFunciones.refrescarForeignKeysDescripcionesEstructura(this.estructura);
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
		estructura = new  Estructura();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EstructuraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estructura=estructuraDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarEstructura(estructura);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstructuraConstantesFunciones.refrescarForeignKeysDescripcionesEstructura(this.estructura);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		estructuras = new  ArrayList<Estructura>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Estructura.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			EstructuraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estructuras=estructuraDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarEstructura(estructuras);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstructuraConstantesFunciones.refrescarForeignKeysDescripcionesEstructura(this.estructuras);
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
		estructuras = new  ArrayList<Estructura>();
		  		  
        try {
			EstructuraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estructuras=estructuraDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarEstructura(estructuras);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstructuraConstantesFunciones.refrescarForeignKeysDescripcionesEstructura(this.estructuras);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosEstructurasWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		estructuras = new  ArrayList<Estructura>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Estructura.class.getSimpleName()+"-getTodosEstructurasWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EstructuraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estructuras=estructuraDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarEstructura(estructuras);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstructuraConstantesFunciones.refrescarForeignKeysDescripcionesEstructura(this.estructuras);
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
	
	public  void  getTodosEstructuras(String sFinalQuery,Pagination pagination)throws Exception {
		estructuras = new  ArrayList<Estructura>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EstructuraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estructuras=estructuraDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarEstructura(estructuras);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstructuraConstantesFunciones.refrescarForeignKeysDescripcionesEstructura(this.estructuras);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarEstructura(Estructura estructura) throws Exception {
		Boolean estaValidado=false;
		
		if(estructura.getIsNew() || estructura.getIsChanged()) { 
			this.invalidValues = estructuraValidator.getInvalidValues(estructura);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(estructura);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarEstructura(List<Estructura> Estructuras) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(Estructura estructuraLocal:estructuras) {				
			estaValidadoObjeto=this.validarGuardarEstructura(estructuraLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarEstructura(List<Estructura> Estructuras) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarEstructura(estructuras)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarEstructura(Estructura Estructura) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarEstructura(estructura)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(Estructura estructura) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+estructura.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=EstructuraConstantesFunciones.getEstructuraLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"estructura","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(EstructuraConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(EstructuraConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveEstructuraWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Estructura.class.getSimpleName()+"-saveEstructuraWithConnection");connexion.begin();			
			
			EstructuraLogicAdditional.checkEstructuraToSave(this.estructura,this.datosCliente,connexion,this.arrDatoGeneral);
			
			EstructuraLogicAdditional.updateEstructuraToSave(this.estructura,this.arrDatoGeneral);
			
			EstructuraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.estructura,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowEstructura();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarEstructura(this.estructura)) {
				EstructuraDataAccess.save(this.estructura, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.estructura,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			EstructuraLogicAdditional.checkEstructuraToSaveAfter(this.estructura,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowEstructura();
			
			connexion.commit();			
			
			if(this.estructura.getIsDeleted()) {
				this.estructura=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveEstructura()throws Exception {	
		try {	
			
			EstructuraLogicAdditional.checkEstructuraToSave(this.estructura,this.datosCliente,connexion,this.arrDatoGeneral);
			
			EstructuraLogicAdditional.updateEstructuraToSave(this.estructura,this.arrDatoGeneral);
			
			EstructuraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.estructura,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarEstructura(this.estructura)) {			
				EstructuraDataAccess.save(this.estructura, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.estructura,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			EstructuraLogicAdditional.checkEstructuraToSaveAfter(this.estructura,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.estructura.getIsDeleted()) {
				this.estructura=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveEstructurasWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Estructura.class.getSimpleName()+"-saveEstructurasWithConnection");connexion.begin();			
			
			EstructuraLogicAdditional.checkEstructuraToSaves(estructuras,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowEstructuras();
			
			Boolean validadoTodosEstructura=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(Estructura estructuraLocal:estructuras) {		
				if(estructuraLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				EstructuraLogicAdditional.updateEstructuraToSave(estructuraLocal,this.arrDatoGeneral);
	        	
				EstructuraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),estructuraLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarEstructura(estructuraLocal)) {
					EstructuraDataAccess.save(estructuraLocal, connexion);				
				} else {
					validadoTodosEstructura=false;
				}
			}
			
			if(!validadoTodosEstructura) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			EstructuraLogicAdditional.checkEstructuraToSavesAfter(estructuras,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowEstructuras();
			
			connexion.commit();		
			
			this.quitarEstructurasEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveEstructuras()throws Exception {				
		 try {	
			EstructuraLogicAdditional.checkEstructuraToSaves(estructuras,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosEstructura=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(Estructura estructuraLocal:estructuras) {				
				if(estructuraLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				EstructuraLogicAdditional.updateEstructuraToSave(estructuraLocal,this.arrDatoGeneral);
	        	
				EstructuraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),estructuraLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarEstructura(estructuraLocal)) {				
					EstructuraDataAccess.save(estructuraLocal, connexion);				
				} else {
					validadoTodosEstructura=false;
				}
			}
			
			if(!validadoTodosEstructura) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			EstructuraLogicAdditional.checkEstructuraToSavesAfter(estructuras,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarEstructurasEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public EstructuraParameterReturnGeneral procesarAccionEstructuras(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<Estructura> estructuras,EstructuraParameterReturnGeneral estructuraParameterGeneral)throws Exception {
		 try {	
			EstructuraParameterReturnGeneral estructuraReturnGeneral=new EstructuraParameterReturnGeneral();
	
			EstructuraLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,estructuras,estructuraParameterGeneral,estructuraReturnGeneral);
			
			return estructuraReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public EstructuraParameterReturnGeneral procesarAccionEstructurasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<Estructura> estructuras,EstructuraParameterReturnGeneral estructuraParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Estructura.class.getSimpleName()+"-procesarAccionEstructurasWithConnection");connexion.begin();			
			
			EstructuraParameterReturnGeneral estructuraReturnGeneral=new EstructuraParameterReturnGeneral();
	
			EstructuraLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,estructuras,estructuraParameterGeneral,estructuraReturnGeneral);
			
			this.connexion.commit();
			
			return estructuraReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public EstructuraParameterReturnGeneral procesarEventosEstructuras(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<Estructura> estructuras,Estructura estructura,EstructuraParameterReturnGeneral estructuraParameterGeneral,Boolean isEsNuevoEstructura,ArrayList<Classe> clases)throws Exception {
		 try {	
			EstructuraParameterReturnGeneral estructuraReturnGeneral=new EstructuraParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				estructuraReturnGeneral.setConRecargarPropiedades(true);
			}
			
			EstructuraLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,estructuras,estructura,estructuraParameterGeneral,estructuraReturnGeneral,isEsNuevoEstructura,clases);
			
			return estructuraReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public EstructuraParameterReturnGeneral procesarEventosEstructurasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<Estructura> estructuras,Estructura estructura,EstructuraParameterReturnGeneral estructuraParameterGeneral,Boolean isEsNuevoEstructura,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Estructura.class.getSimpleName()+"-procesarEventosEstructurasWithConnection");connexion.begin();			
			
			EstructuraParameterReturnGeneral estructuraReturnGeneral=new EstructuraParameterReturnGeneral();
	
			estructuraReturnGeneral.setEstructura(estructura);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				estructuraReturnGeneral.setConRecargarPropiedades(true);
			}
			
			EstructuraLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,estructuras,estructura,estructuraParameterGeneral,estructuraReturnGeneral,isEsNuevoEstructura,clases);
			
			this.connexion.commit();
			
			return estructuraReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public EstructuraParameterReturnGeneral procesarImportacionEstructurasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,EstructuraParameterReturnGeneral estructuraParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Estructura.class.getSimpleName()+"-procesarImportacionEstructurasWithConnection");connexion.begin();			
			
			EstructuraParameterReturnGeneral estructuraReturnGeneral=new EstructuraParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.estructuras=new ArrayList<Estructura>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.estructura=new Estructura();
				
				
				if(conColumnasBase) {this.estructura.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.estructura.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.estructura.setcodigo(arrColumnas[iColumn++]);
				this.estructura.setnumero(arrColumnas[iColumn++]);
				this.estructura.setvalor_anticipo(Double.parseDouble(arrColumnas[iColumn++]));
				this.estructura.setporcentaje_anticipo(Double.parseDouble(arrColumnas[iColumn++]));
				this.estructura.setnombre(arrColumnas[iColumn++]);
				this.estructura.setes_jefe(Boolean.parseBoolean(arrColumnas[iColumn++]));
				this.estructura.setes_anual(Boolean.parseBoolean(arrColumnas[iColumn++]));
				this.estructura.setporcentaje(Double.parseDouble(arrColumnas[iColumn++]));
				this.estructura.setvalor(Double.parseDouble(arrColumnas[iColumn++]));
				
				this.estructuras.add(this.estructura);
			}
			
			this.saveEstructuras();
			
			this.connexion.commit();
			
			estructuraReturnGeneral.setConRetornoEstaProcesado(true);
			estructuraReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return estructuraReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarEstructurasEliminados() throws Exception {				
		
		List<Estructura> estructurasAux= new ArrayList<Estructura>();
		
		for(Estructura estructura:estructuras) {
			if(!estructura.getIsDeleted()) {
				estructurasAux.add(estructura);
			}
		}
		
		estructuras=estructurasAux;
	}
	
	public void quitarEstructurasNulos() throws Exception {				
		
		List<Estructura> estructurasAux= new ArrayList<Estructura>();
		
		for(Estructura estructura : this.estructuras) {
			if(estructura==null) {
				estructurasAux.add(estructura);
			}
		}
		
		//this.estructuras=estructurasAux;
		
		this.estructuras.removeAll(estructurasAux);
	}
	
	public void getSetVersionRowEstructuraWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(estructura.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((estructura.getIsDeleted() || (estructura.getIsChanged()&&!estructura.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=estructuraDataAccess.getSetVersionRowEstructura(connexion,estructura.getId());
				
				if(!estructura.getVersionRow().equals(timestamp)) {	
					estructura.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				estructura.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowEstructura()throws Exception {	
		
		if(estructura.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((estructura.getIsDeleted() || (estructura.getIsChanged()&&!estructura.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=estructuraDataAccess.getSetVersionRowEstructura(connexion,estructura.getId());
			
			try {							
				if(!estructura.getVersionRow().equals(timestamp)) {	
					estructura.setVersionRow(timestamp);
				}
				
				estructura.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowEstructurasWithConnection()throws Exception {	
		if(estructuras!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(Estructura estructuraAux:estructuras) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(estructuraAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(estructuraAux.getIsDeleted() || (estructuraAux.getIsChanged()&&!estructuraAux.getIsNew())) {
						
						timestamp=estructuraDataAccess.getSetVersionRowEstructura(connexion,estructuraAux.getId());
						
						if(!estructura.getVersionRow().equals(timestamp)) {	
							estructuraAux.setVersionRow(timestamp);
						}
								
						estructuraAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowEstructuras()throws Exception {	
		if(estructuras!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(Estructura estructuraAux:estructuras) {
					if(estructuraAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(estructuraAux.getIsDeleted() || (estructuraAux.getIsChanged()&&!estructuraAux.getIsNew())) {
						
						timestamp=estructuraDataAccess.getSetVersionRowEstructura(connexion,estructuraAux.getId());
						
						if(!estructuraAux.getVersionRow().equals(timestamp)) {	
							estructuraAux.setVersionRow(timestamp);
						}
						
													
						estructuraAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public EstructuraParameterReturnGeneral cargarCombosLoteForeignKeyEstructuraWithConnection(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalEstructura,String finalQueryGlobalTipoPago_NM,String finalQueryGlobalNumeroPatronal,String finalQueryGlobalCuentaContable,String finalQueryGlobalTipoEstructura,String finalQueryGlobalPais,String finalQueryGlobalCiudad) throws Exception {
		EstructuraParameterReturnGeneral  estructuraReturnGeneral =new EstructuraParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Estructura.class.getSimpleName()+"-cargarCombosLoteForeignKeyEstructuraWithConnection");connexion.begin();
			
			estructuraReturnGeneral =new EstructuraParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			estructuraReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			estructuraReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Estructura> estructurasForeignKey=new ArrayList<Estructura>();
			EstructuraLogic estructuraLogic=new EstructuraLogic();
			estructuraLogic.setConnexion(this.connexion);
			estructuraLogic.getEstructuraDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEstructura.equals("NONE")) {
				estructuraLogic.getTodosEstructuras(finalQueryGlobalEstructura,new Pagination());
				estructurasForeignKey=estructuraLogic.getEstructuras();
			}

			estructuraReturnGeneral.setestructurasForeignKey(estructurasForeignKey);


			List<TipoPago_NM> tipopago_nmsForeignKey=new ArrayList<TipoPago_NM>();
			TipoPago_NMLogic tipopago_nmLogic=new TipoPago_NMLogic();
			tipopago_nmLogic.setConnexion(this.connexion);
			tipopago_nmLogic.getTipoPago_NMDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoPago_NM.equals("NONE")) {
				tipopago_nmLogic.getTodosTipoPago_NMs(finalQueryGlobalTipoPago_NM,new Pagination());
				tipopago_nmsForeignKey=tipopago_nmLogic.getTipoPago_NMs();
			}

			estructuraReturnGeneral.settipopago_nmsForeignKey(tipopago_nmsForeignKey);


			List<NumeroPatronal> numeropatronalsForeignKey=new ArrayList<NumeroPatronal>();
			NumeroPatronalLogic numeropatronalLogic=new NumeroPatronalLogic();
			numeropatronalLogic.setConnexion(this.connexion);
			numeropatronalLogic.getNumeroPatronalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalNumeroPatronal.equals("NONE")) {
				numeropatronalLogic.getTodosNumeroPatronals(finalQueryGlobalNumeroPatronal,new Pagination());
				numeropatronalsForeignKey=numeropatronalLogic.getNumeroPatronals();
			}

			estructuraReturnGeneral.setnumeropatronalsForeignKey(numeropatronalsForeignKey);


			List<CuentaContable> cuentacontablesForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontableLogic=new CuentaContableLogic();
			cuentacontableLogic.setConnexion(this.connexion);
			cuentacontableLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContable.equals("NONE")) {
				cuentacontableLogic.getTodosCuentaContables(finalQueryGlobalCuentaContable,new Pagination());
				cuentacontablesForeignKey=cuentacontableLogic.getCuentaContables();
			}

			estructuraReturnGeneral.setcuentacontablesForeignKey(cuentacontablesForeignKey);


			List<TipoEstructura> tipoestructurasForeignKey=new ArrayList<TipoEstructura>();
			TipoEstructuraLogic tipoestructuraLogic=new TipoEstructuraLogic();
			tipoestructuraLogic.setConnexion(this.connexion);
			tipoestructuraLogic.getTipoEstructuraDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoEstructura.equals("NONE")) {
				tipoestructuraLogic.getTodosTipoEstructuras(finalQueryGlobalTipoEstructura,new Pagination());
				tipoestructurasForeignKey=tipoestructuraLogic.getTipoEstructuras();
			}

			estructuraReturnGeneral.settipoestructurasForeignKey(tipoestructurasForeignKey);


			List<Pais> paissForeignKey=new ArrayList<Pais>();
			PaisLogic paisLogic=new PaisLogic();
			paisLogic.setConnexion(this.connexion);
			paisLogic.getPaisDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPais.equals("NONE")) {
				paisLogic.getTodosPaiss(finalQueryGlobalPais,new Pagination());
				paissForeignKey=paisLogic.getPaiss();
			}

			estructuraReturnGeneral.setpaissForeignKey(paissForeignKey);


			List<Ciudad> ciudadsForeignKey=new ArrayList<Ciudad>();
			CiudadLogic ciudadLogic=new CiudadLogic();
			ciudadLogic.setConnexion(this.connexion);
			ciudadLogic.getCiudadDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCiudad.equals("NONE")) {
				ciudadLogic.getTodosCiudads(finalQueryGlobalCiudad,new Pagination());
				ciudadsForeignKey=ciudadLogic.getCiudads();
			}

			estructuraReturnGeneral.setciudadsForeignKey(ciudadsForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return estructuraReturnGeneral;
	}
	
	public EstructuraParameterReturnGeneral cargarCombosLoteForeignKeyEstructura(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalEstructura,String finalQueryGlobalTipoPago_NM,String finalQueryGlobalNumeroPatronal,String finalQueryGlobalCuentaContable,String finalQueryGlobalTipoEstructura,String finalQueryGlobalPais,String finalQueryGlobalCiudad) throws Exception {
		EstructuraParameterReturnGeneral  estructuraReturnGeneral =new EstructuraParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			estructuraReturnGeneral =new EstructuraParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			estructuraReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			estructuraReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Estructura> estructurasForeignKey=new ArrayList<Estructura>();
			EstructuraLogic estructuraLogic=new EstructuraLogic();
			estructuraLogic.setConnexion(this.connexion);
			estructuraLogic.getEstructuraDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEstructura.equals("NONE")) {
				estructuraLogic.getTodosEstructuras(finalQueryGlobalEstructura,new Pagination());
				estructurasForeignKey=estructuraLogic.getEstructuras();
			}

			estructuraReturnGeneral.setestructurasForeignKey(estructurasForeignKey);


			List<TipoPago_NM> tipopago_nmsForeignKey=new ArrayList<TipoPago_NM>();
			TipoPago_NMLogic tipopago_nmLogic=new TipoPago_NMLogic();
			tipopago_nmLogic.setConnexion(this.connexion);
			tipopago_nmLogic.getTipoPago_NMDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoPago_NM.equals("NONE")) {
				tipopago_nmLogic.getTodosTipoPago_NMs(finalQueryGlobalTipoPago_NM,new Pagination());
				tipopago_nmsForeignKey=tipopago_nmLogic.getTipoPago_NMs();
			}

			estructuraReturnGeneral.settipopago_nmsForeignKey(tipopago_nmsForeignKey);


			List<NumeroPatronal> numeropatronalsForeignKey=new ArrayList<NumeroPatronal>();
			NumeroPatronalLogic numeropatronalLogic=new NumeroPatronalLogic();
			numeropatronalLogic.setConnexion(this.connexion);
			numeropatronalLogic.getNumeroPatronalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalNumeroPatronal.equals("NONE")) {
				numeropatronalLogic.getTodosNumeroPatronals(finalQueryGlobalNumeroPatronal,new Pagination());
				numeropatronalsForeignKey=numeropatronalLogic.getNumeroPatronals();
			}

			estructuraReturnGeneral.setnumeropatronalsForeignKey(numeropatronalsForeignKey);


			List<CuentaContable> cuentacontablesForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontableLogic=new CuentaContableLogic();
			cuentacontableLogic.setConnexion(this.connexion);
			cuentacontableLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContable.equals("NONE")) {
				cuentacontableLogic.getTodosCuentaContables(finalQueryGlobalCuentaContable,new Pagination());
				cuentacontablesForeignKey=cuentacontableLogic.getCuentaContables();
			}

			estructuraReturnGeneral.setcuentacontablesForeignKey(cuentacontablesForeignKey);


			List<TipoEstructura> tipoestructurasForeignKey=new ArrayList<TipoEstructura>();
			TipoEstructuraLogic tipoestructuraLogic=new TipoEstructuraLogic();
			tipoestructuraLogic.setConnexion(this.connexion);
			tipoestructuraLogic.getTipoEstructuraDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoEstructura.equals("NONE")) {
				tipoestructuraLogic.getTodosTipoEstructuras(finalQueryGlobalTipoEstructura,new Pagination());
				tipoestructurasForeignKey=tipoestructuraLogic.getTipoEstructuras();
			}

			estructuraReturnGeneral.settipoestructurasForeignKey(tipoestructurasForeignKey);


			List<Pais> paissForeignKey=new ArrayList<Pais>();
			PaisLogic paisLogic=new PaisLogic();
			paisLogic.setConnexion(this.connexion);
			paisLogic.getPaisDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPais.equals("NONE")) {
				paisLogic.getTodosPaiss(finalQueryGlobalPais,new Pagination());
				paissForeignKey=paisLogic.getPaiss();
			}

			estructuraReturnGeneral.setpaissForeignKey(paissForeignKey);


			List<Ciudad> ciudadsForeignKey=new ArrayList<Ciudad>();
			CiudadLogic ciudadLogic=new CiudadLogic();
			ciudadLogic.setConnexion(this.connexion);
			ciudadLogic.getCiudadDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCiudad.equals("NONE")) {
				ciudadLogic.getTodosCiudads(finalQueryGlobalCiudad,new Pagination());
				ciudadsForeignKey=ciudadLogic.getCiudads();
			}

			estructuraReturnGeneral.setciudadsForeignKey(ciudadsForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return estructuraReturnGeneral;
	}
	
	public void cargarRelacionesLoteForeignKeyEstructuraWithConnection() throws Exception {
		ArrayList<Classe> classes=new ArrayList<Classe>();		
		
		
			CentroCostoEstructuraLogic centrocostoestructuraLogic=new CentroCostoEstructuraLogic();
			PlaniVacacionLogic planivacacionLogic=new PlaniVacacionLogic();
			AsistenciaMensualLogic asistenciamensualLogic=new AsistenciaMensualLogic();
			EmpleadoProcesoRubroLogic empleadoprocesorubroLogic=new EmpleadoProcesoRubroLogic();
			EmpleadoPagoRubroLogic empleadopagorubroLogic=new EmpleadoPagoRubroLogic();
			ProvisionEmpleadoLogic provisionempleadoLogic=new ProvisionEmpleadoLogic();
			EmpleadoLogic empleadoLogic=new EmpleadoLogic();
			EstructuraLogic estructuraLogic=new EstructuraLogic();
			EvaluacionEmpleadoLogic evaluacionempleadoLogic=new EvaluacionEmpleadoLogic();
			EmpleadoImpuestoRentaLogic empleadoimpuestorentaLogic=new EmpleadoImpuestoRentaLogic();
			RubroEstructuraLogic rubroestructuraLogic=new RubroEstructuraLogic();
			CierreRolMensualLogic cierrerolmensualLogic=new CierreRolMensualLogic();
			FormatoNomiLogic formatonomiLogic=new FormatoNomiLogic();
			EmpleadoEstructuraLogic empleadoestructuraLogic=new EmpleadoEstructuraLogic();
			HistorialPagoNomiLogic historialpagonomiLogic=new HistorialPagoNomiLogic();
			AsistenciaDiariaLogic asistenciadiariaLogic=new AsistenciaDiariaLogic();
			FuncionEstrucLogic funcionestrucLogic=new FuncionEstrucLogic();
			SolicitudReemplazoLogic solicitudreemplazoLogic=new SolicitudReemplazoLogic();
			SolicitudHoraExtraLogic solicitudhoraextraLogic=new SolicitudHoraExtraLogic();
			EvaluacionNomiLogic evaluacionnomiLogic=new EvaluacionNomiLogic();
			SolicitudVacacionLogic solicitudvacacionLogic=new SolicitudVacacionLogic();
			ResponsableActivoFijoLogic responsableactivofijoLogic=new ResponsableActivoFijoLogic();
			RubroEmpleaCuentaContableLogic rubroempleacuentacontableLogic=new RubroEmpleaCuentaContableLogic();
		
		try {
			
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Estructura.class.getSimpleName()+"-cargarRelacionesLoteForeignKeyEstructuraWithConnection");connexion.begin();
			
			
			classes.add(new Classe(CentroCostoEstructura.class));
			classes.add(new Classe(PlaniVacacion.class));
			classes.add(new Classe(AsistenciaMensual.class));
			classes.add(new Classe(EmpleadoProcesoRubro.class));
			classes.add(new Classe(EmpleadoPagoRubro.class));
			classes.add(new Classe(ProvisionEmpleado.class));
			classes.add(new Classe(Empleado.class));
			classes.add(new Classe(Estructura.class));
			classes.add(new Classe(EvaluacionEmpleado.class));
			classes.add(new Classe(EmpleadoImpuestoRenta.class));
			classes.add(new Classe(RubroEstructura.class));
			classes.add(new Classe(CierreRolMensual.class));
			classes.add(new Classe(FormatoNomi.class));
			classes.add(new Classe(EmpleadoEstructura.class));
			classes.add(new Classe(HistorialPagoNomi.class));
			classes.add(new Classe(AsistenciaDiaria.class));
			classes.add(new Classe(FuncionEstruc.class));
			classes.add(new Classe(SolicitudReemplazo.class));
			classes.add(new Classe(SolicitudHoraExtra.class));
			classes.add(new Classe(EvaluacionNomi.class));
			classes.add(new Classe(SolicitudVacacion.class));
			classes.add(new Classe(ResponsableActivoFijo.class));
			classes.add(new Classe(RubroEmpleaCuentaContable.class));
											
			

			centrocostoestructuraLogic.setConnexion(this.getConnexion());
			centrocostoestructuraLogic.setDatosCliente(this.datosCliente);
			centrocostoestructuraLogic.setIsConRefrescarForeignKeys(true);

			planivacacionLogic.setConnexion(this.getConnexion());
			planivacacionLogic.setDatosCliente(this.datosCliente);
			planivacacionLogic.setIsConRefrescarForeignKeys(true);

			asistenciamensualLogic.setConnexion(this.getConnexion());
			asistenciamensualLogic.setDatosCliente(this.datosCliente);
			asistenciamensualLogic.setIsConRefrescarForeignKeys(true);

			empleadoprocesorubroLogic.setConnexion(this.getConnexion());
			empleadoprocesorubroLogic.setDatosCliente(this.datosCliente);
			empleadoprocesorubroLogic.setIsConRefrescarForeignKeys(true);

			empleadopagorubroLogic.setConnexion(this.getConnexion());
			empleadopagorubroLogic.setDatosCliente(this.datosCliente);
			empleadopagorubroLogic.setIsConRefrescarForeignKeys(true);

			provisionempleadoLogic.setConnexion(this.getConnexion());
			provisionempleadoLogic.setDatosCliente(this.datosCliente);
			provisionempleadoLogic.setIsConRefrescarForeignKeys(true);

			empleadoLogic.setConnexion(this.getConnexion());
			empleadoLogic.setDatosCliente(this.datosCliente);
			empleadoLogic.setIsConRefrescarForeignKeys(true);

			estructuraLogic.setConnexion(this.getConnexion());
			estructuraLogic.setDatosCliente(this.datosCliente);
			estructuraLogic.setIsConRefrescarForeignKeys(true);

			evaluacionempleadoLogic.setConnexion(this.getConnexion());
			evaluacionempleadoLogic.setDatosCliente(this.datosCliente);
			evaluacionempleadoLogic.setIsConRefrescarForeignKeys(true);

			empleadoimpuestorentaLogic.setConnexion(this.getConnexion());
			empleadoimpuestorentaLogic.setDatosCliente(this.datosCliente);
			empleadoimpuestorentaLogic.setIsConRefrescarForeignKeys(true);

			rubroestructuraLogic.setConnexion(this.getConnexion());
			rubroestructuraLogic.setDatosCliente(this.datosCliente);
			rubroestructuraLogic.setIsConRefrescarForeignKeys(true);

			cierrerolmensualLogic.setConnexion(this.getConnexion());
			cierrerolmensualLogic.setDatosCliente(this.datosCliente);
			cierrerolmensualLogic.setIsConRefrescarForeignKeys(true);

			formatonomiLogic.setConnexion(this.getConnexion());
			formatonomiLogic.setDatosCliente(this.datosCliente);
			formatonomiLogic.setIsConRefrescarForeignKeys(true);

			empleadoestructuraLogic.setConnexion(this.getConnexion());
			empleadoestructuraLogic.setDatosCliente(this.datosCliente);
			empleadoestructuraLogic.setIsConRefrescarForeignKeys(true);

			historialpagonomiLogic.setConnexion(this.getConnexion());
			historialpagonomiLogic.setDatosCliente(this.datosCliente);
			historialpagonomiLogic.setIsConRefrescarForeignKeys(true);

			asistenciadiariaLogic.setConnexion(this.getConnexion());
			asistenciadiariaLogic.setDatosCliente(this.datosCliente);
			asistenciadiariaLogic.setIsConRefrescarForeignKeys(true);

			funcionestrucLogic.setConnexion(this.getConnexion());
			funcionestrucLogic.setDatosCliente(this.datosCliente);
			funcionestrucLogic.setIsConRefrescarForeignKeys(true);

			solicitudreemplazoLogic.setConnexion(this.getConnexion());
			solicitudreemplazoLogic.setDatosCliente(this.datosCliente);
			solicitudreemplazoLogic.setIsConRefrescarForeignKeys(true);

			solicitudhoraextraLogic.setConnexion(this.getConnexion());
			solicitudhoraextraLogic.setDatosCliente(this.datosCliente);
			solicitudhoraextraLogic.setIsConRefrescarForeignKeys(true);

			evaluacionnomiLogic.setConnexion(this.getConnexion());
			evaluacionnomiLogic.setDatosCliente(this.datosCliente);
			evaluacionnomiLogic.setIsConRefrescarForeignKeys(true);

			solicitudvacacionLogic.setConnexion(this.getConnexion());
			solicitudvacacionLogic.setDatosCliente(this.datosCliente);
			solicitudvacacionLogic.setIsConRefrescarForeignKeys(true);

			responsableactivofijoLogic.setConnexion(this.getConnexion());
			responsableactivofijoLogic.setDatosCliente(this.datosCliente);
			responsableactivofijoLogic.setIsConRefrescarForeignKeys(true);

			rubroempleacuentacontableLogic.setConnexion(this.getConnexion());
			rubroempleacuentacontableLogic.setDatosCliente(this.datosCliente);
			rubroempleacuentacontableLogic.setIsConRefrescarForeignKeys(true);
			
			this.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
			
			for(Estructura estructura:this.estructuras) {
				

				classes=new ArrayList<Classe>();
				classes=CentroCostoEstructuraConstantesFunciones.getClassesForeignKeysOfCentroCostoEstructura(new ArrayList<Classe>(),DeepLoadType.NONE);

				centrocostoestructuraLogic.setCentroCostoEstructuras(estructura.centrocostoestructuras);
				centrocostoestructuraLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=PlaniVacacionConstantesFunciones.getClassesForeignKeysOfPlaniVacacion(new ArrayList<Classe>(),DeepLoadType.NONE);

				planivacacionLogic.setPlaniVacacions(estructura.planivacacionCargos);
				planivacacionLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=AsistenciaMensualConstantesFunciones.getClassesForeignKeysOfAsistenciaMensual(new ArrayList<Classe>(),DeepLoadType.NONE);

				asistenciamensualLogic.setAsistenciaMensuals(estructura.asistenciamensuals);
				asistenciamensualLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=EmpleadoProcesoRubroConstantesFunciones.getClassesForeignKeysOfEmpleadoProcesoRubro(new ArrayList<Classe>(),DeepLoadType.NONE);

				empleadoprocesorubroLogic.setEmpleadoProcesoRubros(estructura.empleadoprocesorubros);
				empleadoprocesorubroLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=EmpleadoPagoRubroConstantesFunciones.getClassesForeignKeysOfEmpleadoPagoRubro(new ArrayList<Classe>(),DeepLoadType.NONE);

				empleadopagorubroLogic.setEmpleadoPagoRubros(estructura.empleadopagorubros);
				empleadopagorubroLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=ProvisionEmpleadoConstantesFunciones.getClassesForeignKeysOfProvisionEmpleado(new ArrayList<Classe>(),DeepLoadType.NONE);

				provisionempleadoLogic.setProvisionEmpleados(estructura.provisionempleados);
				provisionempleadoLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=EmpleadoConstantesFunciones.getClassesForeignKeysOfEmpleado(new ArrayList<Classe>(),DeepLoadType.NONE);

				empleadoLogic.setEmpleados(estructura.empleados);
				empleadoLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=EstructuraConstantesFunciones.getClassesForeignKeysOfEstructura(new ArrayList<Classe>(),DeepLoadType.NONE);

				estructuraLogic.setEstructuras(estructura.estructuras);
				estructuraLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=EvaluacionEmpleadoConstantesFunciones.getClassesForeignKeysOfEvaluacionEmpleado(new ArrayList<Classe>(),DeepLoadType.NONE);

				evaluacionempleadoLogic.setEvaluacionEmpleados(estructura.evaluacionempleados);
				evaluacionempleadoLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=EmpleadoImpuestoRentaConstantesFunciones.getClassesForeignKeysOfEmpleadoImpuestoRenta(new ArrayList<Classe>(),DeepLoadType.NONE);

				empleadoimpuestorentaLogic.setEmpleadoImpuestoRentas(estructura.empleadoimpuestorentas);
				empleadoimpuestorentaLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=RubroEstructuraConstantesFunciones.getClassesForeignKeysOfRubroEstructura(new ArrayList<Classe>(),DeepLoadType.NONE);

				rubroestructuraLogic.setRubroEstructuras(estructura.rubroestructuras);
				rubroestructuraLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=CierreRolMensualConstantesFunciones.getClassesForeignKeysOfCierreRolMensual(new ArrayList<Classe>(),DeepLoadType.NONE);

				cierrerolmensualLogic.setCierreRolMensuals(estructura.cierrerolmensuals);
				cierrerolmensualLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=FormatoNomiConstantesFunciones.getClassesForeignKeysOfFormatoNomi(new ArrayList<Classe>(),DeepLoadType.NONE);

				formatonomiLogic.setFormatoNomis(estructura.formatonomis);
				formatonomiLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=EmpleadoEstructuraConstantesFunciones.getClassesForeignKeysOfEmpleadoEstructura(new ArrayList<Classe>(),DeepLoadType.NONE);

				empleadoestructuraLogic.setEmpleadoEstructuras(estructura.empleadoestructuras);
				empleadoestructuraLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=HistorialPagoNomiConstantesFunciones.getClassesForeignKeysOfHistorialPagoNomi(new ArrayList<Classe>(),DeepLoadType.NONE);

				historialpagonomiLogic.setHistorialPagoNomis(estructura.historialpagonomis);
				historialpagonomiLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=AsistenciaDiariaConstantesFunciones.getClassesForeignKeysOfAsistenciaDiaria(new ArrayList<Classe>(),DeepLoadType.NONE);

				asistenciadiariaLogic.setAsistenciaDiarias(estructura.asistenciadiarias);
				asistenciadiariaLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=FuncionEstrucConstantesFunciones.getClassesForeignKeysOfFuncionEstruc(new ArrayList<Classe>(),DeepLoadType.NONE);

				funcionestrucLogic.setFuncionEstrucs(estructura.funcionestrucs);
				funcionestrucLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=SolicitudReemplazoConstantesFunciones.getClassesForeignKeysOfSolicitudReemplazo(new ArrayList<Classe>(),DeepLoadType.NONE);

				solicitudreemplazoLogic.setSolicitudReemplazos(estructura.solicitudreemplazos);
				solicitudreemplazoLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=SolicitudHoraExtraConstantesFunciones.getClassesForeignKeysOfSolicitudHoraExtra(new ArrayList<Classe>(),DeepLoadType.NONE);

				solicitudhoraextraLogic.setSolicitudHoraExtras(estructura.solicitudhoraextras);
				solicitudhoraextraLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=EvaluacionNomiConstantesFunciones.getClassesForeignKeysOfEvaluacionNomi(new ArrayList<Classe>(),DeepLoadType.NONE);

				evaluacionnomiLogic.setEvaluacionNomis(estructura.evaluacionnomis);
				evaluacionnomiLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=SolicitudVacacionConstantesFunciones.getClassesForeignKeysOfSolicitudVacacion(new ArrayList<Classe>(),DeepLoadType.NONE);

				solicitudvacacionLogic.setSolicitudVacacions(estructura.solicitudvacacions);
				solicitudvacacionLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=ResponsableActivoFijoConstantesFunciones.getClassesForeignKeysOfResponsableActivoFijo(new ArrayList<Classe>(),DeepLoadType.NONE);

				responsableactivofijoLogic.setResponsableActivoFijos(estructura.responsableactivofijos);
				responsableactivofijoLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=RubroEmpleaCuentaContableConstantesFunciones.getClassesForeignKeysOfRubroEmpleaCuentaContable(new ArrayList<Classe>(),DeepLoadType.NONE);

				rubroempleacuentacontableLogic.setRubroEmpleaCuentaContables(estructura.rubroempleacuentacontables);
				rubroempleacuentacontableLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
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
	
	public void deepLoad(Estructura estructura,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			EstructuraLogicAdditional.updateEstructuraToGet(estructura,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		estructura.setEmpresa(estructuraDataAccess.getEmpresa(connexion,estructura));
		estructura.setSucursal(estructuraDataAccess.getSucursal(connexion,estructura));
		estructura.setEstructura(estructuraDataAccess.getEstructura(connexion,estructura));
		estructura.setTipoPago_NM(estructuraDataAccess.getTipoPago_NM(connexion,estructura));
		estructura.setNumeroPatronal(estructuraDataAccess.getNumeroPatronal(connexion,estructura));
		estructura.setCuentaContable(estructuraDataAccess.getCuentaContable(connexion,estructura));
		estructura.setTipoEstructura(estructuraDataAccess.getTipoEstructura(connexion,estructura));
		estructura.setPais(estructuraDataAccess.getPais(connexion,estructura));
		estructura.setCiudad(estructuraDataAccess.getCiudad(connexion,estructura));
		estructura.setCentroCostoEstructuras(estructuraDataAccess.getCentroCostoEstructuras(connexion,estructura));
		estructura.setPlaniVacacionCargos(estructuraDataAccess.getPlaniVacacionCargos(connexion,estructura));
		estructura.setAsistenciaMensuals(estructuraDataAccess.getAsistenciaMensuals(connexion,estructura));
		estructura.setEmpleadoProcesoRubros(estructuraDataAccess.getEmpleadoProcesoRubros(connexion,estructura));
		estructura.setEmpleadoPagoRubros(estructuraDataAccess.getEmpleadoPagoRubros(connexion,estructura));
		estructura.setProvisionEmpleados(estructuraDataAccess.getProvisionEmpleados(connexion,estructura));
		estructura.setEmpleados(estructuraDataAccess.getEmpleados(connexion,estructura));
		estructura.setEstructuras(estructuraDataAccess.getEstructuras(connexion,estructura));
		estructura.setEvaluacionEmpleados(estructuraDataAccess.getEvaluacionEmpleados(connexion,estructura));
		estructura.setEmpleadoImpuestoRentas(estructuraDataAccess.getEmpleadoImpuestoRentas(connexion,estructura));
		estructura.setRubroEstructuras(estructuraDataAccess.getRubroEstructuras(connexion,estructura));
		estructura.setCierreRolMensuals(estructuraDataAccess.getCierreRolMensuals(connexion,estructura));
		estructura.setFormatoNomis(estructuraDataAccess.getFormatoNomis(connexion,estructura));
		estructura.setEmpleadoEstructuras(estructuraDataAccess.getEmpleadoEstructuras(connexion,estructura));
		estructura.setHistorialPagoNomis(estructuraDataAccess.getHistorialPagoNomis(connexion,estructura));
		estructura.setAsistenciaDiarias(estructuraDataAccess.getAsistenciaDiarias(connexion,estructura));
		estructura.setFuncionEstrucs(estructuraDataAccess.getFuncionEstrucs(connexion,estructura));
		estructura.setSolicitudReemplazos(estructuraDataAccess.getSolicitudReemplazos(connexion,estructura));
		estructura.setSolicitudHoraExtras(estructuraDataAccess.getSolicitudHoraExtras(connexion,estructura));
		estructura.setEvaluacionNomis(estructuraDataAccess.getEvaluacionNomis(connexion,estructura));
		estructura.setSolicitudVacacions(estructuraDataAccess.getSolicitudVacacions(connexion,estructura));
		estructura.setResponsableActivoFijos(estructuraDataAccess.getResponsableActivoFijos(connexion,estructura));
		estructura.setRubroEmpleaCuentaContables(estructuraDataAccess.getRubroEmpleaCuentaContables(connexion,estructura));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				estructura.setEmpresa(estructuraDataAccess.getEmpresa(connexion,estructura));
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				estructura.setSucursal(estructuraDataAccess.getSucursal(connexion,estructura));
				continue;
			}

			if(clas.clas.equals(Estructura.class)) {
				estructura.setEstructura(estructuraDataAccess.getEstructura(connexion,estructura));
				continue;
			}

			if(clas.clas.equals(TipoPago_NM.class)) {
				estructura.setTipoPago_NM(estructuraDataAccess.getTipoPago_NM(connexion,estructura));
				continue;
			}

			if(clas.clas.equals(NumeroPatronal.class)) {
				estructura.setNumeroPatronal(estructuraDataAccess.getNumeroPatronal(connexion,estructura));
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				estructura.setCuentaContable(estructuraDataAccess.getCuentaContable(connexion,estructura));
				continue;
			}

			if(clas.clas.equals(TipoEstructura.class)) {
				estructura.setTipoEstructura(estructuraDataAccess.getTipoEstructura(connexion,estructura));
				continue;
			}

			if(clas.clas.equals(Pais.class)) {
				estructura.setPais(estructuraDataAccess.getPais(connexion,estructura));
				continue;
			}

			if(clas.clas.equals(Ciudad.class)) {
				estructura.setCiudad(estructuraDataAccess.getCiudad(connexion,estructura));
				continue;
			}

			if(clas.clas.equals(CentroCostoEstructura.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				estructura.setCentroCostoEstructuras(estructuraDataAccess.getCentroCostoEstructuras(connexion,estructura));

				if(this.isConDeep) {
					CentroCostoEstructuraLogic centrocostoestructuraLogic= new CentroCostoEstructuraLogic(this.connexion);
					centrocostoestructuraLogic.setCentroCostoEstructuras(estructura.getCentroCostoEstructuras());
					ArrayList<Classe> classesLocal=CentroCostoEstructuraConstantesFunciones.getClassesForeignKeysOfCentroCostoEstructura(new ArrayList<Classe>(),DeepLoadType.NONE);
					centrocostoestructuraLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					CentroCostoEstructuraConstantesFunciones.refrescarForeignKeysDescripcionesCentroCostoEstructura(centrocostoestructuraLogic.getCentroCostoEstructuras());
					estructura.setCentroCostoEstructuras(centrocostoestructuraLogic.getCentroCostoEstructuras());
				}

				continue;
			}

			if(clas.clas.equals(PlaniVacacion.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				estructura.setPlaniVacacionCargos(estructuraDataAccess.getPlaniVacacionCargos(connexion,estructura));

				if(this.isConDeep) {
					PlaniVacacionLogic planivacacionLogic= new PlaniVacacionLogic(this.connexion);
					planivacacionLogic.setPlaniVacacions(estructura.getPlaniVacacionCargos());
					ArrayList<Classe> classesLocal=PlaniVacacionConstantesFunciones.getClassesForeignKeysOfPlaniVacacion(new ArrayList<Classe>(),DeepLoadType.NONE);
					planivacacionLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					PlaniVacacionConstantesFunciones.refrescarForeignKeysDescripcionesPlaniVacacion(planivacacionLogic.getPlaniVacacions());
					estructura.setPlaniVacacionCargos(planivacacionLogic.getPlaniVacacions());
				}

				continue;
			}

			if(clas.clas.equals(AsistenciaMensual.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				estructura.setAsistenciaMensuals(estructuraDataAccess.getAsistenciaMensuals(connexion,estructura));

				if(this.isConDeep) {
					AsistenciaMensualLogic asistenciamensualLogic= new AsistenciaMensualLogic(this.connexion);
					asistenciamensualLogic.setAsistenciaMensuals(estructura.getAsistenciaMensuals());
					ArrayList<Classe> classesLocal=AsistenciaMensualConstantesFunciones.getClassesForeignKeysOfAsistenciaMensual(new ArrayList<Classe>(),DeepLoadType.NONE);
					asistenciamensualLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					AsistenciaMensualConstantesFunciones.refrescarForeignKeysDescripcionesAsistenciaMensual(asistenciamensualLogic.getAsistenciaMensuals());
					estructura.setAsistenciaMensuals(asistenciamensualLogic.getAsistenciaMensuals());
				}

				continue;
			}

			if(clas.clas.equals(EmpleadoProcesoRubro.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				estructura.setEmpleadoProcesoRubros(estructuraDataAccess.getEmpleadoProcesoRubros(connexion,estructura));

				if(this.isConDeep) {
					EmpleadoProcesoRubroLogic empleadoprocesorubroLogic= new EmpleadoProcesoRubroLogic(this.connexion);
					empleadoprocesorubroLogic.setEmpleadoProcesoRubros(estructura.getEmpleadoProcesoRubros());
					ArrayList<Classe> classesLocal=EmpleadoProcesoRubroConstantesFunciones.getClassesForeignKeysOfEmpleadoProcesoRubro(new ArrayList<Classe>(),DeepLoadType.NONE);
					empleadoprocesorubroLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					EmpleadoProcesoRubroConstantesFunciones.refrescarForeignKeysDescripcionesEmpleadoProcesoRubro(empleadoprocesorubroLogic.getEmpleadoProcesoRubros());
					estructura.setEmpleadoProcesoRubros(empleadoprocesorubroLogic.getEmpleadoProcesoRubros());
				}

				continue;
			}

			if(clas.clas.equals(EmpleadoPagoRubro.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				estructura.setEmpleadoPagoRubros(estructuraDataAccess.getEmpleadoPagoRubros(connexion,estructura));

				if(this.isConDeep) {
					EmpleadoPagoRubroLogic empleadopagorubroLogic= new EmpleadoPagoRubroLogic(this.connexion);
					empleadopagorubroLogic.setEmpleadoPagoRubros(estructura.getEmpleadoPagoRubros());
					ArrayList<Classe> classesLocal=EmpleadoPagoRubroConstantesFunciones.getClassesForeignKeysOfEmpleadoPagoRubro(new ArrayList<Classe>(),DeepLoadType.NONE);
					empleadopagorubroLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					EmpleadoPagoRubroConstantesFunciones.refrescarForeignKeysDescripcionesEmpleadoPagoRubro(empleadopagorubroLogic.getEmpleadoPagoRubros());
					estructura.setEmpleadoPagoRubros(empleadopagorubroLogic.getEmpleadoPagoRubros());
				}

				continue;
			}

			if(clas.clas.equals(ProvisionEmpleado.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				estructura.setProvisionEmpleados(estructuraDataAccess.getProvisionEmpleados(connexion,estructura));

				if(this.isConDeep) {
					ProvisionEmpleadoLogic provisionempleadoLogic= new ProvisionEmpleadoLogic(this.connexion);
					provisionempleadoLogic.setProvisionEmpleados(estructura.getProvisionEmpleados());
					ArrayList<Classe> classesLocal=ProvisionEmpleadoConstantesFunciones.getClassesForeignKeysOfProvisionEmpleado(new ArrayList<Classe>(),DeepLoadType.NONE);
					provisionempleadoLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					ProvisionEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesProvisionEmpleado(provisionempleadoLogic.getProvisionEmpleados());
					estructura.setProvisionEmpleados(provisionempleadoLogic.getProvisionEmpleados());
				}

				continue;
			}

			if(clas.clas.equals(Empleado.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				estructura.setEmpleados(estructuraDataAccess.getEmpleados(connexion,estructura));

				if(this.isConDeep) {
					EmpleadoLogic empleadoLogic= new EmpleadoLogic(this.connexion);
					empleadoLogic.setEmpleados(estructura.getEmpleados());
					ArrayList<Classe> classesLocal=EmpleadoConstantesFunciones.getClassesForeignKeysOfEmpleado(new ArrayList<Classe>(),DeepLoadType.NONE);
					empleadoLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					EmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesEmpleado(empleadoLogic.getEmpleados());
					estructura.setEmpleados(empleadoLogic.getEmpleados());
				}

				continue;
			}

			if(clas.clas.equals(Estructura.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				estructura.setEstructuras(estructuraDataAccess.getEstructuras(connexion,estructura));

				if(this.isConDeep) {
					EstructuraLogic estructuraLogic= new EstructuraLogic(this.connexion);
					estructuraLogic.setEstructuras(estructura.getEstructuras());
					ArrayList<Classe> classesLocal=EstructuraConstantesFunciones.getClassesForeignKeysOfEstructura(new ArrayList<Classe>(),DeepLoadType.NONE);
					estructuraLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					EstructuraConstantesFunciones.refrescarForeignKeysDescripcionesEstructura(estructuraLogic.getEstructuras());
					estructura.setEstructuras(estructuraLogic.getEstructuras());
				}

				continue;
			}

			if(clas.clas.equals(EvaluacionEmpleado.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				estructura.setEvaluacionEmpleados(estructuraDataAccess.getEvaluacionEmpleados(connexion,estructura));

				if(this.isConDeep) {
					EvaluacionEmpleadoLogic evaluacionempleadoLogic= new EvaluacionEmpleadoLogic(this.connexion);
					evaluacionempleadoLogic.setEvaluacionEmpleados(estructura.getEvaluacionEmpleados());
					ArrayList<Classe> classesLocal=EvaluacionEmpleadoConstantesFunciones.getClassesForeignKeysOfEvaluacionEmpleado(new ArrayList<Classe>(),DeepLoadType.NONE);
					evaluacionempleadoLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					EvaluacionEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesEvaluacionEmpleado(evaluacionempleadoLogic.getEvaluacionEmpleados());
					estructura.setEvaluacionEmpleados(evaluacionempleadoLogic.getEvaluacionEmpleados());
				}

				continue;
			}

			if(clas.clas.equals(EmpleadoImpuestoRenta.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				estructura.setEmpleadoImpuestoRentas(estructuraDataAccess.getEmpleadoImpuestoRentas(connexion,estructura));

				if(this.isConDeep) {
					EmpleadoImpuestoRentaLogic empleadoimpuestorentaLogic= new EmpleadoImpuestoRentaLogic(this.connexion);
					empleadoimpuestorentaLogic.setEmpleadoImpuestoRentas(estructura.getEmpleadoImpuestoRentas());
					ArrayList<Classe> classesLocal=EmpleadoImpuestoRentaConstantesFunciones.getClassesForeignKeysOfEmpleadoImpuestoRenta(new ArrayList<Classe>(),DeepLoadType.NONE);
					empleadoimpuestorentaLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					EmpleadoImpuestoRentaConstantesFunciones.refrescarForeignKeysDescripcionesEmpleadoImpuestoRenta(empleadoimpuestorentaLogic.getEmpleadoImpuestoRentas());
					estructura.setEmpleadoImpuestoRentas(empleadoimpuestorentaLogic.getEmpleadoImpuestoRentas());
				}

				continue;
			}

			if(clas.clas.equals(RubroEstructura.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				estructura.setRubroEstructuras(estructuraDataAccess.getRubroEstructuras(connexion,estructura));

				if(this.isConDeep) {
					RubroEstructuraLogic rubroestructuraLogic= new RubroEstructuraLogic(this.connexion);
					rubroestructuraLogic.setRubroEstructuras(estructura.getRubroEstructuras());
					ArrayList<Classe> classesLocal=RubroEstructuraConstantesFunciones.getClassesForeignKeysOfRubroEstructura(new ArrayList<Classe>(),DeepLoadType.NONE);
					rubroestructuraLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					RubroEstructuraConstantesFunciones.refrescarForeignKeysDescripcionesRubroEstructura(rubroestructuraLogic.getRubroEstructuras());
					estructura.setRubroEstructuras(rubroestructuraLogic.getRubroEstructuras());
				}

				continue;
			}

			if(clas.clas.equals(CierreRolMensual.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				estructura.setCierreRolMensuals(estructuraDataAccess.getCierreRolMensuals(connexion,estructura));

				if(this.isConDeep) {
					CierreRolMensualLogic cierrerolmensualLogic= new CierreRolMensualLogic(this.connexion);
					cierrerolmensualLogic.setCierreRolMensuals(estructura.getCierreRolMensuals());
					ArrayList<Classe> classesLocal=CierreRolMensualConstantesFunciones.getClassesForeignKeysOfCierreRolMensual(new ArrayList<Classe>(),DeepLoadType.NONE);
					cierrerolmensualLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					CierreRolMensualConstantesFunciones.refrescarForeignKeysDescripcionesCierreRolMensual(cierrerolmensualLogic.getCierreRolMensuals());
					estructura.setCierreRolMensuals(cierrerolmensualLogic.getCierreRolMensuals());
				}

				continue;
			}

			if(clas.clas.equals(FormatoNomi.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				estructura.setFormatoNomis(estructuraDataAccess.getFormatoNomis(connexion,estructura));

				if(this.isConDeep) {
					FormatoNomiLogic formatonomiLogic= new FormatoNomiLogic(this.connexion);
					formatonomiLogic.setFormatoNomis(estructura.getFormatoNomis());
					ArrayList<Classe> classesLocal=FormatoNomiConstantesFunciones.getClassesForeignKeysOfFormatoNomi(new ArrayList<Classe>(),DeepLoadType.NONE);
					formatonomiLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					FormatoNomiConstantesFunciones.refrescarForeignKeysDescripcionesFormatoNomi(formatonomiLogic.getFormatoNomis());
					estructura.setFormatoNomis(formatonomiLogic.getFormatoNomis());
				}

				continue;
			}

			if(clas.clas.equals(EmpleadoEstructura.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				estructura.setEmpleadoEstructuras(estructuraDataAccess.getEmpleadoEstructuras(connexion,estructura));

				if(this.isConDeep) {
					EmpleadoEstructuraLogic empleadoestructuraLogic= new EmpleadoEstructuraLogic(this.connexion);
					empleadoestructuraLogic.setEmpleadoEstructuras(estructura.getEmpleadoEstructuras());
					ArrayList<Classe> classesLocal=EmpleadoEstructuraConstantesFunciones.getClassesForeignKeysOfEmpleadoEstructura(new ArrayList<Classe>(),DeepLoadType.NONE);
					empleadoestructuraLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					EmpleadoEstructuraConstantesFunciones.refrescarForeignKeysDescripcionesEmpleadoEstructura(empleadoestructuraLogic.getEmpleadoEstructuras());
					estructura.setEmpleadoEstructuras(empleadoestructuraLogic.getEmpleadoEstructuras());
				}

				continue;
			}

			if(clas.clas.equals(HistorialPagoNomi.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				estructura.setHistorialPagoNomis(estructuraDataAccess.getHistorialPagoNomis(connexion,estructura));

				if(this.isConDeep) {
					HistorialPagoNomiLogic historialpagonomiLogic= new HistorialPagoNomiLogic(this.connexion);
					historialpagonomiLogic.setHistorialPagoNomis(estructura.getHistorialPagoNomis());
					ArrayList<Classe> classesLocal=HistorialPagoNomiConstantesFunciones.getClassesForeignKeysOfHistorialPagoNomi(new ArrayList<Classe>(),DeepLoadType.NONE);
					historialpagonomiLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					HistorialPagoNomiConstantesFunciones.refrescarForeignKeysDescripcionesHistorialPagoNomi(historialpagonomiLogic.getHistorialPagoNomis());
					estructura.setHistorialPagoNomis(historialpagonomiLogic.getHistorialPagoNomis());
				}

				continue;
			}

			if(clas.clas.equals(AsistenciaDiaria.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				estructura.setAsistenciaDiarias(estructuraDataAccess.getAsistenciaDiarias(connexion,estructura));

				if(this.isConDeep) {
					AsistenciaDiariaLogic asistenciadiariaLogic= new AsistenciaDiariaLogic(this.connexion);
					asistenciadiariaLogic.setAsistenciaDiarias(estructura.getAsistenciaDiarias());
					ArrayList<Classe> classesLocal=AsistenciaDiariaConstantesFunciones.getClassesForeignKeysOfAsistenciaDiaria(new ArrayList<Classe>(),DeepLoadType.NONE);
					asistenciadiariaLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					AsistenciaDiariaConstantesFunciones.refrescarForeignKeysDescripcionesAsistenciaDiaria(asistenciadiariaLogic.getAsistenciaDiarias());
					estructura.setAsistenciaDiarias(asistenciadiariaLogic.getAsistenciaDiarias());
				}

				continue;
			}

			if(clas.clas.equals(FuncionEstruc.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				estructura.setFuncionEstrucs(estructuraDataAccess.getFuncionEstrucs(connexion,estructura));

				if(this.isConDeep) {
					FuncionEstrucLogic funcionestrucLogic= new FuncionEstrucLogic(this.connexion);
					funcionestrucLogic.setFuncionEstrucs(estructura.getFuncionEstrucs());
					ArrayList<Classe> classesLocal=FuncionEstrucConstantesFunciones.getClassesForeignKeysOfFuncionEstruc(new ArrayList<Classe>(),DeepLoadType.NONE);
					funcionestrucLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					FuncionEstrucConstantesFunciones.refrescarForeignKeysDescripcionesFuncionEstruc(funcionestrucLogic.getFuncionEstrucs());
					estructura.setFuncionEstrucs(funcionestrucLogic.getFuncionEstrucs());
				}

				continue;
			}

			if(clas.clas.equals(SolicitudReemplazo.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				estructura.setSolicitudReemplazos(estructuraDataAccess.getSolicitudReemplazos(connexion,estructura));

				if(this.isConDeep) {
					SolicitudReemplazoLogic solicitudreemplazoLogic= new SolicitudReemplazoLogic(this.connexion);
					solicitudreemplazoLogic.setSolicitudReemplazos(estructura.getSolicitudReemplazos());
					ArrayList<Classe> classesLocal=SolicitudReemplazoConstantesFunciones.getClassesForeignKeysOfSolicitudReemplazo(new ArrayList<Classe>(),DeepLoadType.NONE);
					solicitudreemplazoLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					SolicitudReemplazoConstantesFunciones.refrescarForeignKeysDescripcionesSolicitudReemplazo(solicitudreemplazoLogic.getSolicitudReemplazos());
					estructura.setSolicitudReemplazos(solicitudreemplazoLogic.getSolicitudReemplazos());
				}

				continue;
			}

			if(clas.clas.equals(SolicitudHoraExtra.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				estructura.setSolicitudHoraExtras(estructuraDataAccess.getSolicitudHoraExtras(connexion,estructura));

				if(this.isConDeep) {
					SolicitudHoraExtraLogic solicitudhoraextraLogic= new SolicitudHoraExtraLogic(this.connexion);
					solicitudhoraextraLogic.setSolicitudHoraExtras(estructura.getSolicitudHoraExtras());
					ArrayList<Classe> classesLocal=SolicitudHoraExtraConstantesFunciones.getClassesForeignKeysOfSolicitudHoraExtra(new ArrayList<Classe>(),DeepLoadType.NONE);
					solicitudhoraextraLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					SolicitudHoraExtraConstantesFunciones.refrescarForeignKeysDescripcionesSolicitudHoraExtra(solicitudhoraextraLogic.getSolicitudHoraExtras());
					estructura.setSolicitudHoraExtras(solicitudhoraextraLogic.getSolicitudHoraExtras());
				}

				continue;
			}

			if(clas.clas.equals(EvaluacionNomi.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				estructura.setEvaluacionNomis(estructuraDataAccess.getEvaluacionNomis(connexion,estructura));

				if(this.isConDeep) {
					EvaluacionNomiLogic evaluacionnomiLogic= new EvaluacionNomiLogic(this.connexion);
					evaluacionnomiLogic.setEvaluacionNomis(estructura.getEvaluacionNomis());
					ArrayList<Classe> classesLocal=EvaluacionNomiConstantesFunciones.getClassesForeignKeysOfEvaluacionNomi(new ArrayList<Classe>(),DeepLoadType.NONE);
					evaluacionnomiLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					EvaluacionNomiConstantesFunciones.refrescarForeignKeysDescripcionesEvaluacionNomi(evaluacionnomiLogic.getEvaluacionNomis());
					estructura.setEvaluacionNomis(evaluacionnomiLogic.getEvaluacionNomis());
				}

				continue;
			}

			if(clas.clas.equals(SolicitudVacacion.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				estructura.setSolicitudVacacions(estructuraDataAccess.getSolicitudVacacions(connexion,estructura));

				if(this.isConDeep) {
					SolicitudVacacionLogic solicitudvacacionLogic= new SolicitudVacacionLogic(this.connexion);
					solicitudvacacionLogic.setSolicitudVacacions(estructura.getSolicitudVacacions());
					ArrayList<Classe> classesLocal=SolicitudVacacionConstantesFunciones.getClassesForeignKeysOfSolicitudVacacion(new ArrayList<Classe>(),DeepLoadType.NONE);
					solicitudvacacionLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					SolicitudVacacionConstantesFunciones.refrescarForeignKeysDescripcionesSolicitudVacacion(solicitudvacacionLogic.getSolicitudVacacions());
					estructura.setSolicitudVacacions(solicitudvacacionLogic.getSolicitudVacacions());
				}

				continue;
			}

			if(clas.clas.equals(ResponsableActivoFijo.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				estructura.setResponsableActivoFijos(estructuraDataAccess.getResponsableActivoFijos(connexion,estructura));

				if(this.isConDeep) {
					ResponsableActivoFijoLogic responsableactivofijoLogic= new ResponsableActivoFijoLogic(this.connexion);
					responsableactivofijoLogic.setResponsableActivoFijos(estructura.getResponsableActivoFijos());
					ArrayList<Classe> classesLocal=ResponsableActivoFijoConstantesFunciones.getClassesForeignKeysOfResponsableActivoFijo(new ArrayList<Classe>(),DeepLoadType.NONE);
					responsableactivofijoLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					ResponsableActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesResponsableActivoFijo(responsableactivofijoLogic.getResponsableActivoFijos());
					estructura.setResponsableActivoFijos(responsableactivofijoLogic.getResponsableActivoFijos());
				}

				continue;
			}

			if(clas.clas.equals(RubroEmpleaCuentaContable.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				estructura.setRubroEmpleaCuentaContables(estructuraDataAccess.getRubroEmpleaCuentaContables(connexion,estructura));

				if(this.isConDeep) {
					RubroEmpleaCuentaContableLogic rubroempleacuentacontableLogic= new RubroEmpleaCuentaContableLogic(this.connexion);
					rubroempleacuentacontableLogic.setRubroEmpleaCuentaContables(estructura.getRubroEmpleaCuentaContables());
					ArrayList<Classe> classesLocal=RubroEmpleaCuentaContableConstantesFunciones.getClassesForeignKeysOfRubroEmpleaCuentaContable(new ArrayList<Classe>(),DeepLoadType.NONE);
					rubroempleacuentacontableLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					RubroEmpleaCuentaContableConstantesFunciones.refrescarForeignKeysDescripcionesRubroEmpleaCuentaContable(rubroempleacuentacontableLogic.getRubroEmpleaCuentaContables());
					estructura.setRubroEmpleaCuentaContables(rubroempleacuentacontableLogic.getRubroEmpleaCuentaContables());
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
			estructura.setEmpresa(estructuraDataAccess.getEmpresa(connexion,estructura));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			estructura.setSucursal(estructuraDataAccess.getSucursal(connexion,estructura));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Estructura.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			estructura.setEstructura(estructuraDataAccess.getEstructura(connexion,estructura));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoPago_NM.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			estructura.setTipoPago_NM(estructuraDataAccess.getTipoPago_NM(connexion,estructura));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(NumeroPatronal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			estructura.setNumeroPatronal(estructuraDataAccess.getNumeroPatronal(connexion,estructura));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			estructura.setCuentaContable(estructuraDataAccess.getCuentaContable(connexion,estructura));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoEstructura.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			estructura.setTipoEstructura(estructuraDataAccess.getTipoEstructura(connexion,estructura));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Pais.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			estructura.setPais(estructuraDataAccess.getPais(connexion,estructura));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Ciudad.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			estructura.setCiudad(estructuraDataAccess.getCiudad(connexion,estructura));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CentroCostoEstructura.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(CentroCostoEstructura.class));
			estructura.setCentroCostoEstructuras(estructuraDataAccess.getCentroCostoEstructuras(connexion,estructura));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(PlaniVacacion.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(PlaniVacacion.class));
			estructura.setPlaniVacacionCargos(estructuraDataAccess.getPlaniVacacionCargos(connexion,estructura));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(AsistenciaMensual.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(AsistenciaMensual.class));
			estructura.setAsistenciaMensuals(estructuraDataAccess.getAsistenciaMensuals(connexion,estructura));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(EmpleadoProcesoRubro.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(EmpleadoProcesoRubro.class));
			estructura.setEmpleadoProcesoRubros(estructuraDataAccess.getEmpleadoProcesoRubros(connexion,estructura));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(EmpleadoPagoRubro.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(EmpleadoPagoRubro.class));
			estructura.setEmpleadoPagoRubros(estructuraDataAccess.getEmpleadoPagoRubros(connexion,estructura));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(ProvisionEmpleado.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(ProvisionEmpleado.class));
			estructura.setProvisionEmpleados(estructuraDataAccess.getProvisionEmpleados(connexion,estructura));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Empleado.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(Empleado.class));
			estructura.setEmpleados(estructuraDataAccess.getEmpleados(connexion,estructura));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Estructura.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(Estructura.class));
			estructura.setEstructuras(estructuraDataAccess.getEstructuras(connexion,estructura));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(EvaluacionEmpleado.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(EvaluacionEmpleado.class));
			estructura.setEvaluacionEmpleados(estructuraDataAccess.getEvaluacionEmpleados(connexion,estructura));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(EmpleadoImpuestoRenta.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(EmpleadoImpuestoRenta.class));
			estructura.setEmpleadoImpuestoRentas(estructuraDataAccess.getEmpleadoImpuestoRentas(connexion,estructura));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(RubroEstructura.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(RubroEstructura.class));
			estructura.setRubroEstructuras(estructuraDataAccess.getRubroEstructuras(connexion,estructura));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CierreRolMensual.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(CierreRolMensual.class));
			estructura.setCierreRolMensuals(estructuraDataAccess.getCierreRolMensuals(connexion,estructura));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(FormatoNomi.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(FormatoNomi.class));
			estructura.setFormatoNomis(estructuraDataAccess.getFormatoNomis(connexion,estructura));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(EmpleadoEstructura.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(EmpleadoEstructura.class));
			estructura.setEmpleadoEstructuras(estructuraDataAccess.getEmpleadoEstructuras(connexion,estructura));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(HistorialPagoNomi.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(HistorialPagoNomi.class));
			estructura.setHistorialPagoNomis(estructuraDataAccess.getHistorialPagoNomis(connexion,estructura));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(AsistenciaDiaria.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(AsistenciaDiaria.class));
			estructura.setAsistenciaDiarias(estructuraDataAccess.getAsistenciaDiarias(connexion,estructura));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(FuncionEstruc.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(FuncionEstruc.class));
			estructura.setFuncionEstrucs(estructuraDataAccess.getFuncionEstrucs(connexion,estructura));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(SolicitudReemplazo.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(SolicitudReemplazo.class));
			estructura.setSolicitudReemplazos(estructuraDataAccess.getSolicitudReemplazos(connexion,estructura));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(SolicitudHoraExtra.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(SolicitudHoraExtra.class));
			estructura.setSolicitudHoraExtras(estructuraDataAccess.getSolicitudHoraExtras(connexion,estructura));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(EvaluacionNomi.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(EvaluacionNomi.class));
			estructura.setEvaluacionNomis(estructuraDataAccess.getEvaluacionNomis(connexion,estructura));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(SolicitudVacacion.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(SolicitudVacacion.class));
			estructura.setSolicitudVacacions(estructuraDataAccess.getSolicitudVacacions(connexion,estructura));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(ResponsableActivoFijo.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(ResponsableActivoFijo.class));
			estructura.setResponsableActivoFijos(estructuraDataAccess.getResponsableActivoFijos(connexion,estructura));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(RubroEmpleaCuentaContable.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(RubroEmpleaCuentaContable.class));
			estructura.setRubroEmpleaCuentaContables(estructuraDataAccess.getRubroEmpleaCuentaContables(connexion,estructura));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		estructura.setEmpresa(estructuraDataAccess.getEmpresa(connexion,estructura));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(estructura.getEmpresa(),isDeep,deepLoadType,clases);
				
		estructura.setSucursal(estructuraDataAccess.getSucursal(connexion,estructura));
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(estructura.getSucursal(),isDeep,deepLoadType,clases);
				
		estructura.setEstructura(estructuraDataAccess.getEstructura(connexion,estructura));
		EstructuraLogic estructuraLogic= new EstructuraLogic(connexion);
		estructuraLogic.deepLoad(estructura.getEstructura(),isDeep,deepLoadType,clases);
				
		estructura.setTipoPago_NM(estructuraDataAccess.getTipoPago_NM(connexion,estructura));
		TipoPago_NMLogic tipopago_nmLogic= new TipoPago_NMLogic(connexion);
		tipopago_nmLogic.deepLoad(estructura.getTipoPago_NM(),isDeep,deepLoadType,clases);
				
		estructura.setNumeroPatronal(estructuraDataAccess.getNumeroPatronal(connexion,estructura));
		NumeroPatronalLogic numeropatronalLogic= new NumeroPatronalLogic(connexion);
		numeropatronalLogic.deepLoad(estructura.getNumeroPatronal(),isDeep,deepLoadType,clases);
				
		estructura.setCuentaContable(estructuraDataAccess.getCuentaContable(connexion,estructura));
		CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
		cuentacontableLogic.deepLoad(estructura.getCuentaContable(),isDeep,deepLoadType,clases);
				
		estructura.setTipoEstructura(estructuraDataAccess.getTipoEstructura(connexion,estructura));
		TipoEstructuraLogic tipoestructuraLogic= new TipoEstructuraLogic(connexion);
		tipoestructuraLogic.deepLoad(estructura.getTipoEstructura(),isDeep,deepLoadType,clases);
				
		estructura.setPais(estructuraDataAccess.getPais(connexion,estructura));
		PaisLogic paisLogic= new PaisLogic(connexion);
		paisLogic.deepLoad(estructura.getPais(),isDeep,deepLoadType,clases);
				
		estructura.setCiudad(estructuraDataAccess.getCiudad(connexion,estructura));
		CiudadLogic ciudadLogic= new CiudadLogic(connexion);
		ciudadLogic.deepLoad(estructura.getCiudad(),isDeep,deepLoadType,clases);
				

		estructura.setCentroCostoEstructuras(estructuraDataAccess.getCentroCostoEstructuras(connexion,estructura));

		for(CentroCostoEstructura centrocostoestructura:estructura.getCentroCostoEstructuras()) {
			CentroCostoEstructuraLogic centrocostoestructuraLogic= new CentroCostoEstructuraLogic(connexion);
			centrocostoestructuraLogic.deepLoad(centrocostoestructura,isDeep,deepLoadType,clases);
		}

		estructura.setPlaniVacacionCargos(estructuraDataAccess.getPlaniVacacionCargos(connexion,estructura));

		for(PlaniVacacion planivacacion:estructura.getPlaniVacacionCargos()) {
			PlaniVacacionLogic planivacacionLogic= new PlaniVacacionLogic(connexion);
			planivacacionLogic.deepLoad(planivacacion,isDeep,deepLoadType,clases);
		}

		estructura.setAsistenciaMensuals(estructuraDataAccess.getAsistenciaMensuals(connexion,estructura));

		for(AsistenciaMensual asistenciamensual:estructura.getAsistenciaMensuals()) {
			AsistenciaMensualLogic asistenciamensualLogic= new AsistenciaMensualLogic(connexion);
			asistenciamensualLogic.deepLoad(asistenciamensual,isDeep,deepLoadType,clases);
		}

		estructura.setEmpleadoProcesoRubros(estructuraDataAccess.getEmpleadoProcesoRubros(connexion,estructura));

		for(EmpleadoProcesoRubro empleadoprocesorubro:estructura.getEmpleadoProcesoRubros()) {
			EmpleadoProcesoRubroLogic empleadoprocesorubroLogic= new EmpleadoProcesoRubroLogic(connexion);
			empleadoprocesorubroLogic.deepLoad(empleadoprocesorubro,isDeep,deepLoadType,clases);
		}

		estructura.setEmpleadoPagoRubros(estructuraDataAccess.getEmpleadoPagoRubros(connexion,estructura));

		for(EmpleadoPagoRubro empleadopagorubro:estructura.getEmpleadoPagoRubros()) {
			EmpleadoPagoRubroLogic empleadopagorubroLogic= new EmpleadoPagoRubroLogic(connexion);
			empleadopagorubroLogic.deepLoad(empleadopagorubro,isDeep,deepLoadType,clases);
		}

		estructura.setProvisionEmpleados(estructuraDataAccess.getProvisionEmpleados(connexion,estructura));

		for(ProvisionEmpleado provisionempleado:estructura.getProvisionEmpleados()) {
			ProvisionEmpleadoLogic provisionempleadoLogic= new ProvisionEmpleadoLogic(connexion);
			provisionempleadoLogic.deepLoad(provisionempleado,isDeep,deepLoadType,clases);
		}

		estructura.setEmpleados(estructuraDataAccess.getEmpleados(connexion,estructura));

		for(Empleado empleado:estructura.getEmpleados()) {
			EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
			empleadoLogic.deepLoad(empleado,isDeep,deepLoadType,clases);
		}

		estructura.setEstructuras(estructuraDataAccess.getEstructuras(connexion,estructura));

		for(Estructura estructuraRecursivo:estructura.getEstructuras()) {
			EstructuraLogic estructuraRecursivoLogic= new EstructuraLogic(connexion);
			estructuraRecursivoLogic.deepLoad(estructuraRecursivo,isDeep,deepLoadType,clases);
		}

		estructura.setEvaluacionEmpleados(estructuraDataAccess.getEvaluacionEmpleados(connexion,estructura));

		for(EvaluacionEmpleado evaluacionempleado:estructura.getEvaluacionEmpleados()) {
			EvaluacionEmpleadoLogic evaluacionempleadoLogic= new EvaluacionEmpleadoLogic(connexion);
			evaluacionempleadoLogic.deepLoad(evaluacionempleado,isDeep,deepLoadType,clases);
		}

		estructura.setEmpleadoImpuestoRentas(estructuraDataAccess.getEmpleadoImpuestoRentas(connexion,estructura));

		for(EmpleadoImpuestoRenta empleadoimpuestorenta:estructura.getEmpleadoImpuestoRentas()) {
			EmpleadoImpuestoRentaLogic empleadoimpuestorentaLogic= new EmpleadoImpuestoRentaLogic(connexion);
			empleadoimpuestorentaLogic.deepLoad(empleadoimpuestorenta,isDeep,deepLoadType,clases);
		}

		estructura.setRubroEstructuras(estructuraDataAccess.getRubroEstructuras(connexion,estructura));

		for(RubroEstructura rubroestructura:estructura.getRubroEstructuras()) {
			RubroEstructuraLogic rubroestructuraLogic= new RubroEstructuraLogic(connexion);
			rubroestructuraLogic.deepLoad(rubroestructura,isDeep,deepLoadType,clases);
		}

		estructura.setCierreRolMensuals(estructuraDataAccess.getCierreRolMensuals(connexion,estructura));

		for(CierreRolMensual cierrerolmensual:estructura.getCierreRolMensuals()) {
			CierreRolMensualLogic cierrerolmensualLogic= new CierreRolMensualLogic(connexion);
			cierrerolmensualLogic.deepLoad(cierrerolmensual,isDeep,deepLoadType,clases);
		}

		estructura.setFormatoNomis(estructuraDataAccess.getFormatoNomis(connexion,estructura));

		for(FormatoNomi formatonomi:estructura.getFormatoNomis()) {
			FormatoNomiLogic formatonomiLogic= new FormatoNomiLogic(connexion);
			formatonomiLogic.deepLoad(formatonomi,isDeep,deepLoadType,clases);
		}

		estructura.setEmpleadoEstructuras(estructuraDataAccess.getEmpleadoEstructuras(connexion,estructura));

		for(EmpleadoEstructura empleadoestructura:estructura.getEmpleadoEstructuras()) {
			EmpleadoEstructuraLogic empleadoestructuraLogic= new EmpleadoEstructuraLogic(connexion);
			empleadoestructuraLogic.deepLoad(empleadoestructura,isDeep,deepLoadType,clases);
		}

		estructura.setHistorialPagoNomis(estructuraDataAccess.getHistorialPagoNomis(connexion,estructura));

		for(HistorialPagoNomi historialpagonomi:estructura.getHistorialPagoNomis()) {
			HistorialPagoNomiLogic historialpagonomiLogic= new HistorialPagoNomiLogic(connexion);
			historialpagonomiLogic.deepLoad(historialpagonomi,isDeep,deepLoadType,clases);
		}

		estructura.setAsistenciaDiarias(estructuraDataAccess.getAsistenciaDiarias(connexion,estructura));

		for(AsistenciaDiaria asistenciadiaria:estructura.getAsistenciaDiarias()) {
			AsistenciaDiariaLogic asistenciadiariaLogic= new AsistenciaDiariaLogic(connexion);
			asistenciadiariaLogic.deepLoad(asistenciadiaria,isDeep,deepLoadType,clases);
		}

		estructura.setFuncionEstrucs(estructuraDataAccess.getFuncionEstrucs(connexion,estructura));

		for(FuncionEstruc funcionestruc:estructura.getFuncionEstrucs()) {
			FuncionEstrucLogic funcionestrucLogic= new FuncionEstrucLogic(connexion);
			funcionestrucLogic.deepLoad(funcionestruc,isDeep,deepLoadType,clases);
		}

		estructura.setSolicitudReemplazos(estructuraDataAccess.getSolicitudReemplazos(connexion,estructura));

		for(SolicitudReemplazo solicitudreemplazo:estructura.getSolicitudReemplazos()) {
			SolicitudReemplazoLogic solicitudreemplazoLogic= new SolicitudReemplazoLogic(connexion);
			solicitudreemplazoLogic.deepLoad(solicitudreemplazo,isDeep,deepLoadType,clases);
		}

		estructura.setSolicitudHoraExtras(estructuraDataAccess.getSolicitudHoraExtras(connexion,estructura));

		for(SolicitudHoraExtra solicitudhoraextra:estructura.getSolicitudHoraExtras()) {
			SolicitudHoraExtraLogic solicitudhoraextraLogic= new SolicitudHoraExtraLogic(connexion);
			solicitudhoraextraLogic.deepLoad(solicitudhoraextra,isDeep,deepLoadType,clases);
		}

		estructura.setEvaluacionNomis(estructuraDataAccess.getEvaluacionNomis(connexion,estructura));

		for(EvaluacionNomi evaluacionnomi:estructura.getEvaluacionNomis()) {
			EvaluacionNomiLogic evaluacionnomiLogic= new EvaluacionNomiLogic(connexion);
			evaluacionnomiLogic.deepLoad(evaluacionnomi,isDeep,deepLoadType,clases);
		}

		estructura.setSolicitudVacacions(estructuraDataAccess.getSolicitudVacacions(connexion,estructura));

		for(SolicitudVacacion solicitudvacacion:estructura.getSolicitudVacacions()) {
			SolicitudVacacionLogic solicitudvacacionLogic= new SolicitudVacacionLogic(connexion);
			solicitudvacacionLogic.deepLoad(solicitudvacacion,isDeep,deepLoadType,clases);
		}

		estructura.setResponsableActivoFijos(estructuraDataAccess.getResponsableActivoFijos(connexion,estructura));

		for(ResponsableActivoFijo responsableactivofijo:estructura.getResponsableActivoFijos()) {
			ResponsableActivoFijoLogic responsableactivofijoLogic= new ResponsableActivoFijoLogic(connexion);
			responsableactivofijoLogic.deepLoad(responsableactivofijo,isDeep,deepLoadType,clases);
		}

		estructura.setRubroEmpleaCuentaContables(estructuraDataAccess.getRubroEmpleaCuentaContables(connexion,estructura));

		for(RubroEmpleaCuentaContable rubroempleacuentacontable:estructura.getRubroEmpleaCuentaContables()) {
			RubroEmpleaCuentaContableLogic rubroempleacuentacontableLogic= new RubroEmpleaCuentaContableLogic(connexion);
			rubroempleacuentacontableLogic.deepLoad(rubroempleacuentacontable,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				estructura.setEmpresa(estructuraDataAccess.getEmpresa(connexion,estructura));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(estructura.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				estructura.setSucursal(estructuraDataAccess.getSucursal(connexion,estructura));
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepLoad(estructura.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Estructura.class)) {
				estructura.setEstructura(estructuraDataAccess.getEstructura(connexion,estructura));
				EstructuraLogic estructuraLogic= new EstructuraLogic(connexion);
				estructuraLogic.deepLoad(estructura.getEstructura(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoPago_NM.class)) {
				estructura.setTipoPago_NM(estructuraDataAccess.getTipoPago_NM(connexion,estructura));
				TipoPago_NMLogic tipopago_nmLogic= new TipoPago_NMLogic(connexion);
				tipopago_nmLogic.deepLoad(estructura.getTipoPago_NM(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(NumeroPatronal.class)) {
				estructura.setNumeroPatronal(estructuraDataAccess.getNumeroPatronal(connexion,estructura));
				NumeroPatronalLogic numeropatronalLogic= new NumeroPatronalLogic(connexion);
				numeropatronalLogic.deepLoad(estructura.getNumeroPatronal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				estructura.setCuentaContable(estructuraDataAccess.getCuentaContable(connexion,estructura));
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepLoad(estructura.getCuentaContable(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoEstructura.class)) {
				estructura.setTipoEstructura(estructuraDataAccess.getTipoEstructura(connexion,estructura));
				TipoEstructuraLogic tipoestructuraLogic= new TipoEstructuraLogic(connexion);
				tipoestructuraLogic.deepLoad(estructura.getTipoEstructura(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Pais.class)) {
				estructura.setPais(estructuraDataAccess.getPais(connexion,estructura));
				PaisLogic paisLogic= new PaisLogic(connexion);
				paisLogic.deepLoad(estructura.getPais(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Ciudad.class)) {
				estructura.setCiudad(estructuraDataAccess.getCiudad(connexion,estructura));
				CiudadLogic ciudadLogic= new CiudadLogic(connexion);
				ciudadLogic.deepLoad(estructura.getCiudad(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CentroCostoEstructura.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				estructura.setCentroCostoEstructuras(estructuraDataAccess.getCentroCostoEstructuras(connexion,estructura));

				for(CentroCostoEstructura centrocostoestructura:estructura.getCentroCostoEstructuras()) {
					CentroCostoEstructuraLogic centrocostoestructuraLogic= new CentroCostoEstructuraLogic(connexion);
					centrocostoestructuraLogic.deepLoad(centrocostoestructura,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(PlaniVacacion.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				estructura.setPlaniVacacionCargos(estructuraDataAccess.getPlaniVacacionCargos(connexion,estructura));

				for(PlaniVacacion planivacacion:estructura.getPlaniVacacionCargos()) {
					PlaniVacacionLogic planivacacionLogic= new PlaniVacacionLogic(connexion);
					planivacacionLogic.deepLoad(planivacacion,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(AsistenciaMensual.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				estructura.setAsistenciaMensuals(estructuraDataAccess.getAsistenciaMensuals(connexion,estructura));

				for(AsistenciaMensual asistenciamensual:estructura.getAsistenciaMensuals()) {
					AsistenciaMensualLogic asistenciamensualLogic= new AsistenciaMensualLogic(connexion);
					asistenciamensualLogic.deepLoad(asistenciamensual,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(EmpleadoProcesoRubro.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				estructura.setEmpleadoProcesoRubros(estructuraDataAccess.getEmpleadoProcesoRubros(connexion,estructura));

				for(EmpleadoProcesoRubro empleadoprocesorubro:estructura.getEmpleadoProcesoRubros()) {
					EmpleadoProcesoRubroLogic empleadoprocesorubroLogic= new EmpleadoProcesoRubroLogic(connexion);
					empleadoprocesorubroLogic.deepLoad(empleadoprocesorubro,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(EmpleadoPagoRubro.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				estructura.setEmpleadoPagoRubros(estructuraDataAccess.getEmpleadoPagoRubros(connexion,estructura));

				for(EmpleadoPagoRubro empleadopagorubro:estructura.getEmpleadoPagoRubros()) {
					EmpleadoPagoRubroLogic empleadopagorubroLogic= new EmpleadoPagoRubroLogic(connexion);
					empleadopagorubroLogic.deepLoad(empleadopagorubro,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(ProvisionEmpleado.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				estructura.setProvisionEmpleados(estructuraDataAccess.getProvisionEmpleados(connexion,estructura));

				for(ProvisionEmpleado provisionempleado:estructura.getProvisionEmpleados()) {
					ProvisionEmpleadoLogic provisionempleadoLogic= new ProvisionEmpleadoLogic(connexion);
					provisionempleadoLogic.deepLoad(provisionempleado,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(Empleado.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				estructura.setEmpleados(estructuraDataAccess.getEmpleados(connexion,estructura));

				for(Empleado empleado:estructura.getEmpleados()) {
					EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
					empleadoLogic.deepLoad(empleado,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(Estructura.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				estructura.setEstructuras(estructuraDataAccess.getEstructuras(connexion,estructura));

				for(Estructura estructuraRecursivo:estructura.getEstructuras()) {
					EstructuraLogic estructuraRecursivoLogic= new EstructuraLogic(connexion);
					estructuraRecursivoLogic.deepLoad(estructuraRecursivo,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(EvaluacionEmpleado.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				estructura.setEvaluacionEmpleados(estructuraDataAccess.getEvaluacionEmpleados(connexion,estructura));

				for(EvaluacionEmpleado evaluacionempleado:estructura.getEvaluacionEmpleados()) {
					EvaluacionEmpleadoLogic evaluacionempleadoLogic= new EvaluacionEmpleadoLogic(connexion);
					evaluacionempleadoLogic.deepLoad(evaluacionempleado,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(EmpleadoImpuestoRenta.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				estructura.setEmpleadoImpuestoRentas(estructuraDataAccess.getEmpleadoImpuestoRentas(connexion,estructura));

				for(EmpleadoImpuestoRenta empleadoimpuestorenta:estructura.getEmpleadoImpuestoRentas()) {
					EmpleadoImpuestoRentaLogic empleadoimpuestorentaLogic= new EmpleadoImpuestoRentaLogic(connexion);
					empleadoimpuestorentaLogic.deepLoad(empleadoimpuestorenta,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(RubroEstructura.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				estructura.setRubroEstructuras(estructuraDataAccess.getRubroEstructuras(connexion,estructura));

				for(RubroEstructura rubroestructura:estructura.getRubroEstructuras()) {
					RubroEstructuraLogic rubroestructuraLogic= new RubroEstructuraLogic(connexion);
					rubroestructuraLogic.deepLoad(rubroestructura,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(CierreRolMensual.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				estructura.setCierreRolMensuals(estructuraDataAccess.getCierreRolMensuals(connexion,estructura));

				for(CierreRolMensual cierrerolmensual:estructura.getCierreRolMensuals()) {
					CierreRolMensualLogic cierrerolmensualLogic= new CierreRolMensualLogic(connexion);
					cierrerolmensualLogic.deepLoad(cierrerolmensual,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(FormatoNomi.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				estructura.setFormatoNomis(estructuraDataAccess.getFormatoNomis(connexion,estructura));

				for(FormatoNomi formatonomi:estructura.getFormatoNomis()) {
					FormatoNomiLogic formatonomiLogic= new FormatoNomiLogic(connexion);
					formatonomiLogic.deepLoad(formatonomi,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(EmpleadoEstructura.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				estructura.setEmpleadoEstructuras(estructuraDataAccess.getEmpleadoEstructuras(connexion,estructura));

				for(EmpleadoEstructura empleadoestructura:estructura.getEmpleadoEstructuras()) {
					EmpleadoEstructuraLogic empleadoestructuraLogic= new EmpleadoEstructuraLogic(connexion);
					empleadoestructuraLogic.deepLoad(empleadoestructura,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(HistorialPagoNomi.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				estructura.setHistorialPagoNomis(estructuraDataAccess.getHistorialPagoNomis(connexion,estructura));

				for(HistorialPagoNomi historialpagonomi:estructura.getHistorialPagoNomis()) {
					HistorialPagoNomiLogic historialpagonomiLogic= new HistorialPagoNomiLogic(connexion);
					historialpagonomiLogic.deepLoad(historialpagonomi,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(AsistenciaDiaria.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				estructura.setAsistenciaDiarias(estructuraDataAccess.getAsistenciaDiarias(connexion,estructura));

				for(AsistenciaDiaria asistenciadiaria:estructura.getAsistenciaDiarias()) {
					AsistenciaDiariaLogic asistenciadiariaLogic= new AsistenciaDiariaLogic(connexion);
					asistenciadiariaLogic.deepLoad(asistenciadiaria,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(FuncionEstruc.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				estructura.setFuncionEstrucs(estructuraDataAccess.getFuncionEstrucs(connexion,estructura));

				for(FuncionEstruc funcionestruc:estructura.getFuncionEstrucs()) {
					FuncionEstrucLogic funcionestrucLogic= new FuncionEstrucLogic(connexion);
					funcionestrucLogic.deepLoad(funcionestruc,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(SolicitudReemplazo.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				estructura.setSolicitudReemplazos(estructuraDataAccess.getSolicitudReemplazos(connexion,estructura));

				for(SolicitudReemplazo solicitudreemplazo:estructura.getSolicitudReemplazos()) {
					SolicitudReemplazoLogic solicitudreemplazoLogic= new SolicitudReemplazoLogic(connexion);
					solicitudreemplazoLogic.deepLoad(solicitudreemplazo,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(SolicitudHoraExtra.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				estructura.setSolicitudHoraExtras(estructuraDataAccess.getSolicitudHoraExtras(connexion,estructura));

				for(SolicitudHoraExtra solicitudhoraextra:estructura.getSolicitudHoraExtras()) {
					SolicitudHoraExtraLogic solicitudhoraextraLogic= new SolicitudHoraExtraLogic(connexion);
					solicitudhoraextraLogic.deepLoad(solicitudhoraextra,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(EvaluacionNomi.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				estructura.setEvaluacionNomis(estructuraDataAccess.getEvaluacionNomis(connexion,estructura));

				for(EvaluacionNomi evaluacionnomi:estructura.getEvaluacionNomis()) {
					EvaluacionNomiLogic evaluacionnomiLogic= new EvaluacionNomiLogic(connexion);
					evaluacionnomiLogic.deepLoad(evaluacionnomi,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(SolicitudVacacion.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				estructura.setSolicitudVacacions(estructuraDataAccess.getSolicitudVacacions(connexion,estructura));

				for(SolicitudVacacion solicitudvacacion:estructura.getSolicitudVacacions()) {
					SolicitudVacacionLogic solicitudvacacionLogic= new SolicitudVacacionLogic(connexion);
					solicitudvacacionLogic.deepLoad(solicitudvacacion,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(ResponsableActivoFijo.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				estructura.setResponsableActivoFijos(estructuraDataAccess.getResponsableActivoFijos(connexion,estructura));

				for(ResponsableActivoFijo responsableactivofijo:estructura.getResponsableActivoFijos()) {
					ResponsableActivoFijoLogic responsableactivofijoLogic= new ResponsableActivoFijoLogic(connexion);
					responsableactivofijoLogic.deepLoad(responsableactivofijo,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(RubroEmpleaCuentaContable.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				estructura.setRubroEmpleaCuentaContables(estructuraDataAccess.getRubroEmpleaCuentaContables(connexion,estructura));

				for(RubroEmpleaCuentaContable rubroempleacuentacontable:estructura.getRubroEmpleaCuentaContables()) {
					RubroEmpleaCuentaContableLogic rubroempleacuentacontableLogic= new RubroEmpleaCuentaContableLogic(connexion);
					rubroempleacuentacontableLogic.deepLoad(rubroempleacuentacontable,isDeep,deepLoadType,clases);
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
			estructura.setEmpresa(estructuraDataAccess.getEmpresa(connexion,estructura));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(estructura.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			estructura.setSucursal(estructuraDataAccess.getSucursal(connexion,estructura));
			SucursalLogic sucursalLogic= new SucursalLogic(connexion);
			sucursalLogic.deepLoad(estructura.getSucursal(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Estructura.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			estructura.setEstructura(estructuraDataAccess.getEstructura(connexion,estructura));
			EstructuraLogic estructuraLogic= new EstructuraLogic(connexion);
			estructuraLogic.deepLoad(estructura.getEstructura(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoPago_NM.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			estructura.setTipoPago_NM(estructuraDataAccess.getTipoPago_NM(connexion,estructura));
			TipoPago_NMLogic tipopago_nmLogic= new TipoPago_NMLogic(connexion);
			tipopago_nmLogic.deepLoad(estructura.getTipoPago_NM(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(NumeroPatronal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			estructura.setNumeroPatronal(estructuraDataAccess.getNumeroPatronal(connexion,estructura));
			NumeroPatronalLogic numeropatronalLogic= new NumeroPatronalLogic(connexion);
			numeropatronalLogic.deepLoad(estructura.getNumeroPatronal(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			estructura.setCuentaContable(estructuraDataAccess.getCuentaContable(connexion,estructura));
			CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
			cuentacontableLogic.deepLoad(estructura.getCuentaContable(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoEstructura.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			estructura.setTipoEstructura(estructuraDataAccess.getTipoEstructura(connexion,estructura));
			TipoEstructuraLogic tipoestructuraLogic= new TipoEstructuraLogic(connexion);
			tipoestructuraLogic.deepLoad(estructura.getTipoEstructura(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Pais.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			estructura.setPais(estructuraDataAccess.getPais(connexion,estructura));
			PaisLogic paisLogic= new PaisLogic(connexion);
			paisLogic.deepLoad(estructura.getPais(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Ciudad.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			estructura.setCiudad(estructuraDataAccess.getCiudad(connexion,estructura));
			CiudadLogic ciudadLogic= new CiudadLogic(connexion);
			ciudadLogic.deepLoad(estructura.getCiudad(),isDeep,deepLoadType,clases);
				
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CentroCostoEstructura.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(CentroCostoEstructura.class));
			estructura.setCentroCostoEstructuras(estructuraDataAccess.getCentroCostoEstructuras(connexion,estructura));

			for(CentroCostoEstructura centrocostoestructura:estructura.getCentroCostoEstructuras()) {
				CentroCostoEstructuraLogic centrocostoestructuraLogic= new CentroCostoEstructuraLogic(connexion);
				centrocostoestructuraLogic.deepLoad(centrocostoestructura,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(PlaniVacacion.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(PlaniVacacion.class));
			estructura.setPlaniVacacionCargos(estructuraDataAccess.getPlaniVacacionCargos(connexion,estructura));

			for(PlaniVacacion planivacacion:estructura.getPlaniVacacionCargos()) {
				PlaniVacacionLogic planivacacionLogic= new PlaniVacacionLogic(connexion);
				planivacacionLogic.deepLoad(planivacacion,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(AsistenciaMensual.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(AsistenciaMensual.class));
			estructura.setAsistenciaMensuals(estructuraDataAccess.getAsistenciaMensuals(connexion,estructura));

			for(AsistenciaMensual asistenciamensual:estructura.getAsistenciaMensuals()) {
				AsistenciaMensualLogic asistenciamensualLogic= new AsistenciaMensualLogic(connexion);
				asistenciamensualLogic.deepLoad(asistenciamensual,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(EmpleadoProcesoRubro.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(EmpleadoProcesoRubro.class));
			estructura.setEmpleadoProcesoRubros(estructuraDataAccess.getEmpleadoProcesoRubros(connexion,estructura));

			for(EmpleadoProcesoRubro empleadoprocesorubro:estructura.getEmpleadoProcesoRubros()) {
				EmpleadoProcesoRubroLogic empleadoprocesorubroLogic= new EmpleadoProcesoRubroLogic(connexion);
				empleadoprocesorubroLogic.deepLoad(empleadoprocesorubro,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(EmpleadoPagoRubro.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(EmpleadoPagoRubro.class));
			estructura.setEmpleadoPagoRubros(estructuraDataAccess.getEmpleadoPagoRubros(connexion,estructura));

			for(EmpleadoPagoRubro empleadopagorubro:estructura.getEmpleadoPagoRubros()) {
				EmpleadoPagoRubroLogic empleadopagorubroLogic= new EmpleadoPagoRubroLogic(connexion);
				empleadopagorubroLogic.deepLoad(empleadopagorubro,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(ProvisionEmpleado.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(ProvisionEmpleado.class));
			estructura.setProvisionEmpleados(estructuraDataAccess.getProvisionEmpleados(connexion,estructura));

			for(ProvisionEmpleado provisionempleado:estructura.getProvisionEmpleados()) {
				ProvisionEmpleadoLogic provisionempleadoLogic= new ProvisionEmpleadoLogic(connexion);
				provisionempleadoLogic.deepLoad(provisionempleado,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Empleado.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(Empleado.class));
			estructura.setEmpleados(estructuraDataAccess.getEmpleados(connexion,estructura));

			for(Empleado empleado:estructura.getEmpleados()) {
				EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
				empleadoLogic.deepLoad(empleado,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Estructura.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(Estructura.class));
			estructura.setEstructuras(estructuraDataAccess.getEstructuras(connexion,estructura));

			for(Estructura estructuraRecursivo:estructura.getEstructuras()) {
				EstructuraLogic estructuraRecursivoLogic= new EstructuraLogic(connexion);
				estructuraRecursivoLogic.deepLoad(estructuraRecursivo,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(EvaluacionEmpleado.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(EvaluacionEmpleado.class));
			estructura.setEvaluacionEmpleados(estructuraDataAccess.getEvaluacionEmpleados(connexion,estructura));

			for(EvaluacionEmpleado evaluacionempleado:estructura.getEvaluacionEmpleados()) {
				EvaluacionEmpleadoLogic evaluacionempleadoLogic= new EvaluacionEmpleadoLogic(connexion);
				evaluacionempleadoLogic.deepLoad(evaluacionempleado,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(EmpleadoImpuestoRenta.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(EmpleadoImpuestoRenta.class));
			estructura.setEmpleadoImpuestoRentas(estructuraDataAccess.getEmpleadoImpuestoRentas(connexion,estructura));

			for(EmpleadoImpuestoRenta empleadoimpuestorenta:estructura.getEmpleadoImpuestoRentas()) {
				EmpleadoImpuestoRentaLogic empleadoimpuestorentaLogic= new EmpleadoImpuestoRentaLogic(connexion);
				empleadoimpuestorentaLogic.deepLoad(empleadoimpuestorenta,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(RubroEstructura.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(RubroEstructura.class));
			estructura.setRubroEstructuras(estructuraDataAccess.getRubroEstructuras(connexion,estructura));

			for(RubroEstructura rubroestructura:estructura.getRubroEstructuras()) {
				RubroEstructuraLogic rubroestructuraLogic= new RubroEstructuraLogic(connexion);
				rubroestructuraLogic.deepLoad(rubroestructura,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CierreRolMensual.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(CierreRolMensual.class));
			estructura.setCierreRolMensuals(estructuraDataAccess.getCierreRolMensuals(connexion,estructura));

			for(CierreRolMensual cierrerolmensual:estructura.getCierreRolMensuals()) {
				CierreRolMensualLogic cierrerolmensualLogic= new CierreRolMensualLogic(connexion);
				cierrerolmensualLogic.deepLoad(cierrerolmensual,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(FormatoNomi.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(FormatoNomi.class));
			estructura.setFormatoNomis(estructuraDataAccess.getFormatoNomis(connexion,estructura));

			for(FormatoNomi formatonomi:estructura.getFormatoNomis()) {
				FormatoNomiLogic formatonomiLogic= new FormatoNomiLogic(connexion);
				formatonomiLogic.deepLoad(formatonomi,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(EmpleadoEstructura.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(EmpleadoEstructura.class));
			estructura.setEmpleadoEstructuras(estructuraDataAccess.getEmpleadoEstructuras(connexion,estructura));

			for(EmpleadoEstructura empleadoestructura:estructura.getEmpleadoEstructuras()) {
				EmpleadoEstructuraLogic empleadoestructuraLogic= new EmpleadoEstructuraLogic(connexion);
				empleadoestructuraLogic.deepLoad(empleadoestructura,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(HistorialPagoNomi.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(HistorialPagoNomi.class));
			estructura.setHistorialPagoNomis(estructuraDataAccess.getHistorialPagoNomis(connexion,estructura));

			for(HistorialPagoNomi historialpagonomi:estructura.getHistorialPagoNomis()) {
				HistorialPagoNomiLogic historialpagonomiLogic= new HistorialPagoNomiLogic(connexion);
				historialpagonomiLogic.deepLoad(historialpagonomi,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(AsistenciaDiaria.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(AsistenciaDiaria.class));
			estructura.setAsistenciaDiarias(estructuraDataAccess.getAsistenciaDiarias(connexion,estructura));

			for(AsistenciaDiaria asistenciadiaria:estructura.getAsistenciaDiarias()) {
				AsistenciaDiariaLogic asistenciadiariaLogic= new AsistenciaDiariaLogic(connexion);
				asistenciadiariaLogic.deepLoad(asistenciadiaria,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(FuncionEstruc.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(FuncionEstruc.class));
			estructura.setFuncionEstrucs(estructuraDataAccess.getFuncionEstrucs(connexion,estructura));

			for(FuncionEstruc funcionestruc:estructura.getFuncionEstrucs()) {
				FuncionEstrucLogic funcionestrucLogic= new FuncionEstrucLogic(connexion);
				funcionestrucLogic.deepLoad(funcionestruc,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(SolicitudReemplazo.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(SolicitudReemplazo.class));
			estructura.setSolicitudReemplazos(estructuraDataAccess.getSolicitudReemplazos(connexion,estructura));

			for(SolicitudReemplazo solicitudreemplazo:estructura.getSolicitudReemplazos()) {
				SolicitudReemplazoLogic solicitudreemplazoLogic= new SolicitudReemplazoLogic(connexion);
				solicitudreemplazoLogic.deepLoad(solicitudreemplazo,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(SolicitudHoraExtra.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(SolicitudHoraExtra.class));
			estructura.setSolicitudHoraExtras(estructuraDataAccess.getSolicitudHoraExtras(connexion,estructura));

			for(SolicitudHoraExtra solicitudhoraextra:estructura.getSolicitudHoraExtras()) {
				SolicitudHoraExtraLogic solicitudhoraextraLogic= new SolicitudHoraExtraLogic(connexion);
				solicitudhoraextraLogic.deepLoad(solicitudhoraextra,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(EvaluacionNomi.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(EvaluacionNomi.class));
			estructura.setEvaluacionNomis(estructuraDataAccess.getEvaluacionNomis(connexion,estructura));

			for(EvaluacionNomi evaluacionnomi:estructura.getEvaluacionNomis()) {
				EvaluacionNomiLogic evaluacionnomiLogic= new EvaluacionNomiLogic(connexion);
				evaluacionnomiLogic.deepLoad(evaluacionnomi,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(SolicitudVacacion.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(SolicitudVacacion.class));
			estructura.setSolicitudVacacions(estructuraDataAccess.getSolicitudVacacions(connexion,estructura));

			for(SolicitudVacacion solicitudvacacion:estructura.getSolicitudVacacions()) {
				SolicitudVacacionLogic solicitudvacacionLogic= new SolicitudVacacionLogic(connexion);
				solicitudvacacionLogic.deepLoad(solicitudvacacion,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(ResponsableActivoFijo.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(ResponsableActivoFijo.class));
			estructura.setResponsableActivoFijos(estructuraDataAccess.getResponsableActivoFijos(connexion,estructura));

			for(ResponsableActivoFijo responsableactivofijo:estructura.getResponsableActivoFijos()) {
				ResponsableActivoFijoLogic responsableactivofijoLogic= new ResponsableActivoFijoLogic(connexion);
				responsableactivofijoLogic.deepLoad(responsableactivofijo,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(RubroEmpleaCuentaContable.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(RubroEmpleaCuentaContable.class));
			estructura.setRubroEmpleaCuentaContables(estructuraDataAccess.getRubroEmpleaCuentaContables(connexion,estructura));

			for(RubroEmpleaCuentaContable rubroempleacuentacontable:estructura.getRubroEmpleaCuentaContables()) {
				RubroEmpleaCuentaContableLogic rubroempleacuentacontableLogic= new RubroEmpleaCuentaContableLogic(connexion);
				rubroempleacuentacontableLogic.deepLoad(rubroempleacuentacontable,isDeep,deepLoadType,clases);
			}
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(Estructura estructura,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			EstructuraLogicAdditional.updateEstructuraToSave(estructura,this.arrDatoGeneral);
			
EstructuraDataAccess.save(estructura, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(estructura.getEmpresa(),connexion);

		SucursalDataAccess.save(estructura.getSucursal(),connexion);

		EstructuraDataAccess.save(estructura.getEstructura(),connexion);

		TipoPago_NMDataAccess.save(estructura.getTipoPago_NM(),connexion);

		NumeroPatronalDataAccess.save(estructura.getNumeroPatronal(),connexion);

		CuentaContableDataAccess.save(estructura.getCuentaContable(),connexion);

		TipoEstructuraDataAccess.save(estructura.getTipoEstructura(),connexion);

		PaisDataAccess.save(estructura.getPais(),connexion);

		CiudadDataAccess.save(estructura.getCiudad(),connexion);

		for(CentroCostoEstructura centrocostoestructura:estructura.getCentroCostoEstructuras()) {
			centrocostoestructura.setid_estructura(estructura.getId());
			CentroCostoEstructuraDataAccess.save(centrocostoestructura,connexion);
		}

		for(PlaniVacacion planivacacion:estructura.getPlaniVacacionCargos()) {
			planivacacion.setid_estructura_cargo(estructura.getId());
			PlaniVacacionDataAccess.save(planivacacion,connexion);
		}

		for(AsistenciaMensual asistenciamensual:estructura.getAsistenciaMensuals()) {
			asistenciamensual.setid_estructura(estructura.getId());
			AsistenciaMensualDataAccess.save(asistenciamensual,connexion);
		}

		for(EmpleadoProcesoRubro empleadoprocesorubro:estructura.getEmpleadoProcesoRubros()) {
			empleadoprocesorubro.setid_estructura(estructura.getId());
			EmpleadoProcesoRubroDataAccess.save(empleadoprocesorubro,connexion);
		}

		for(EmpleadoPagoRubro empleadopagorubro:estructura.getEmpleadoPagoRubros()) {
			empleadopagorubro.setid_estructura(estructura.getId());
			EmpleadoPagoRubroDataAccess.save(empleadopagorubro,connexion);
		}

		for(ProvisionEmpleado provisionempleado:estructura.getProvisionEmpleados()) {
			provisionempleado.setid_estructura(estructura.getId());
			ProvisionEmpleadoDataAccess.save(provisionempleado,connexion);
		}

		for(Empleado empleado:estructura.getEmpleados()) {
			empleado.setid_estructura(estructura.getId());
			EmpleadoDataAccess.save(empleado,connexion);
		}

		for(Estructura estructuraRecursivo:estructura.getEstructuras()) {
			estructuraRecursivo.setid_estructura(estructura.getId());
			EstructuraDataAccess.save(estructuraRecursivo,connexion);
		}

		for(EvaluacionEmpleado evaluacionempleado:estructura.getEvaluacionEmpleados()) {
			evaluacionempleado.setid_estructura(estructura.getId());
			EvaluacionEmpleadoDataAccess.save(evaluacionempleado,connexion);
		}

		for(EmpleadoImpuestoRenta empleadoimpuestorenta:estructura.getEmpleadoImpuestoRentas()) {
			empleadoimpuestorenta.setid_estructura(estructura.getId());
			EmpleadoImpuestoRentaDataAccess.save(empleadoimpuestorenta,connexion);
		}

		for(RubroEstructura rubroestructura:estructura.getRubroEstructuras()) {
			rubroestructura.setid_estructura(estructura.getId());
			RubroEstructuraDataAccess.save(rubroestructura,connexion);
		}

		for(CierreRolMensual cierrerolmensual:estructura.getCierreRolMensuals()) {
			cierrerolmensual.setid_estructura(estructura.getId());
			CierreRolMensualDataAccess.save(cierrerolmensual,connexion);
		}

		for(FormatoNomi formatonomi:estructura.getFormatoNomis()) {
			formatonomi.setid_estructura(estructura.getId());
			FormatoNomiDataAccess.save(formatonomi,connexion);
		}

		for(EmpleadoEstructura empleadoestructura:estructura.getEmpleadoEstructuras()) {
			empleadoestructura.setid_estructura(estructura.getId());
			EmpleadoEstructuraDataAccess.save(empleadoestructura,connexion);
		}

		for(HistorialPagoNomi historialpagonomi:estructura.getHistorialPagoNomis()) {
			historialpagonomi.setid_estructura(estructura.getId());
			HistorialPagoNomiDataAccess.save(historialpagonomi,connexion);
		}

		for(AsistenciaDiaria asistenciadiaria:estructura.getAsistenciaDiarias()) {
			asistenciadiaria.setid_estructura(estructura.getId());
			AsistenciaDiariaDataAccess.save(asistenciadiaria,connexion);
		}

		for(FuncionEstruc funcionestruc:estructura.getFuncionEstrucs()) {
			funcionestruc.setid_estructura(estructura.getId());
			FuncionEstrucDataAccess.save(funcionestruc,connexion);
		}

		for(SolicitudReemplazo solicitudreemplazo:estructura.getSolicitudReemplazos()) {
			solicitudreemplazo.setid_estructura(estructura.getId());
			SolicitudReemplazoDataAccess.save(solicitudreemplazo,connexion);
		}

		for(SolicitudHoraExtra solicitudhoraextra:estructura.getSolicitudHoraExtras()) {
			solicitudhoraextra.setid_estructura(estructura.getId());
			SolicitudHoraExtraDataAccess.save(solicitudhoraextra,connexion);
		}

		for(EvaluacionNomi evaluacionnomi:estructura.getEvaluacionNomis()) {
			evaluacionnomi.setid_estructura(estructura.getId());
			EvaluacionNomiDataAccess.save(evaluacionnomi,connexion);
		}

		for(SolicitudVacacion solicitudvacacion:estructura.getSolicitudVacacions()) {
			solicitudvacacion.setid_estructura(estructura.getId());
			SolicitudVacacionDataAccess.save(solicitudvacacion,connexion);
		}

		for(ResponsableActivoFijo responsableactivofijo:estructura.getResponsableActivoFijos()) {
			responsableactivofijo.setid_estructura(estructura.getId());
			ResponsableActivoFijoDataAccess.save(responsableactivofijo,connexion);
		}

		for(RubroEmpleaCuentaContable rubroempleacuentacontable:estructura.getRubroEmpleaCuentaContables()) {
			rubroempleacuentacontable.setid_estructura(estructura.getId());
			RubroEmpleaCuentaContableDataAccess.save(rubroempleacuentacontable,connexion);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(estructura.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(estructura.getSucursal(),connexion);
				continue;
			}

			if(clas.clas.equals(Estructura.class)) {
				EstructuraDataAccess.save(estructura.getEstructura(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoPago_NM.class)) {
				TipoPago_NMDataAccess.save(estructura.getTipoPago_NM(),connexion);
				continue;
			}

			if(clas.clas.equals(NumeroPatronal.class)) {
				NumeroPatronalDataAccess.save(estructura.getNumeroPatronal(),connexion);
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(estructura.getCuentaContable(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoEstructura.class)) {
				TipoEstructuraDataAccess.save(estructura.getTipoEstructura(),connexion);
				continue;
			}

			if(clas.clas.equals(Pais.class)) {
				PaisDataAccess.save(estructura.getPais(),connexion);
				continue;
			}

			if(clas.clas.equals(Ciudad.class)) {
				CiudadDataAccess.save(estructura.getCiudad(),connexion);
				continue;
			}


			if(clas.clas.equals(CentroCostoEstructura.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(CentroCostoEstructura centrocostoestructura:estructura.getCentroCostoEstructuras()) {
					centrocostoestructura.setid_estructura(estructura.getId());
					CentroCostoEstructuraDataAccess.save(centrocostoestructura,connexion);
				}
				continue;
			}

			if(clas.clas.equals(PlaniVacacion.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(PlaniVacacion planivacacion:estructura.getPlaniVacacionCargos()) {
					planivacacion.setid_estructura_cargo(estructura.getId());
					PlaniVacacionDataAccess.save(planivacacion,connexion);
				}
				continue;
			}

			if(clas.clas.equals(AsistenciaMensual.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(AsistenciaMensual asistenciamensual:estructura.getAsistenciaMensuals()) {
					asistenciamensual.setid_estructura(estructura.getId());
					AsistenciaMensualDataAccess.save(asistenciamensual,connexion);
				}
				continue;
			}

			if(clas.clas.equals(EmpleadoProcesoRubro.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(EmpleadoProcesoRubro empleadoprocesorubro:estructura.getEmpleadoProcesoRubros()) {
					empleadoprocesorubro.setid_estructura(estructura.getId());
					EmpleadoProcesoRubroDataAccess.save(empleadoprocesorubro,connexion);
				}
				continue;
			}

			if(clas.clas.equals(EmpleadoPagoRubro.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(EmpleadoPagoRubro empleadopagorubro:estructura.getEmpleadoPagoRubros()) {
					empleadopagorubro.setid_estructura(estructura.getId());
					EmpleadoPagoRubroDataAccess.save(empleadopagorubro,connexion);
				}
				continue;
			}

			if(clas.clas.equals(ProvisionEmpleado.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(ProvisionEmpleado provisionempleado:estructura.getProvisionEmpleados()) {
					provisionempleado.setid_estructura(estructura.getId());
					ProvisionEmpleadoDataAccess.save(provisionempleado,connexion);
				}
				continue;
			}

			if(clas.clas.equals(Empleado.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(Empleado empleado:estructura.getEmpleados()) {
					empleado.setid_estructura(estructura.getId());
					EmpleadoDataAccess.save(empleado,connexion);
				}
				continue;
			}

			if(clas.clas.equals(Estructura.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(Estructura estructuraRecursivo:estructura.getEstructuras()) {
					estructuraRecursivo.setid_estructura(estructura.getId());
					EstructuraDataAccess.save(estructuraRecursivo,connexion);
				}
				continue;
			}

			if(clas.clas.equals(EvaluacionEmpleado.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(EvaluacionEmpleado evaluacionempleado:estructura.getEvaluacionEmpleados()) {
					evaluacionempleado.setid_estructura(estructura.getId());
					EvaluacionEmpleadoDataAccess.save(evaluacionempleado,connexion);
				}
				continue;
			}

			if(clas.clas.equals(EmpleadoImpuestoRenta.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(EmpleadoImpuestoRenta empleadoimpuestorenta:estructura.getEmpleadoImpuestoRentas()) {
					empleadoimpuestorenta.setid_estructura(estructura.getId());
					EmpleadoImpuestoRentaDataAccess.save(empleadoimpuestorenta,connexion);
				}
				continue;
			}

			if(clas.clas.equals(RubroEstructura.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(RubroEstructura rubroestructura:estructura.getRubroEstructuras()) {
					rubroestructura.setid_estructura(estructura.getId());
					RubroEstructuraDataAccess.save(rubroestructura,connexion);
				}
				continue;
			}

			if(clas.clas.equals(CierreRolMensual.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(CierreRolMensual cierrerolmensual:estructura.getCierreRolMensuals()) {
					cierrerolmensual.setid_estructura(estructura.getId());
					CierreRolMensualDataAccess.save(cierrerolmensual,connexion);
				}
				continue;
			}

			if(clas.clas.equals(FormatoNomi.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(FormatoNomi formatonomi:estructura.getFormatoNomis()) {
					formatonomi.setid_estructura(estructura.getId());
					FormatoNomiDataAccess.save(formatonomi,connexion);
				}
				continue;
			}

			if(clas.clas.equals(EmpleadoEstructura.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(EmpleadoEstructura empleadoestructura:estructura.getEmpleadoEstructuras()) {
					empleadoestructura.setid_estructura(estructura.getId());
					EmpleadoEstructuraDataAccess.save(empleadoestructura,connexion);
				}
				continue;
			}

			if(clas.clas.equals(HistorialPagoNomi.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(HistorialPagoNomi historialpagonomi:estructura.getHistorialPagoNomis()) {
					historialpagonomi.setid_estructura(estructura.getId());
					HistorialPagoNomiDataAccess.save(historialpagonomi,connexion);
				}
				continue;
			}

			if(clas.clas.equals(AsistenciaDiaria.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(AsistenciaDiaria asistenciadiaria:estructura.getAsistenciaDiarias()) {
					asistenciadiaria.setid_estructura(estructura.getId());
					AsistenciaDiariaDataAccess.save(asistenciadiaria,connexion);
				}
				continue;
			}

			if(clas.clas.equals(FuncionEstruc.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(FuncionEstruc funcionestruc:estructura.getFuncionEstrucs()) {
					funcionestruc.setid_estructura(estructura.getId());
					FuncionEstrucDataAccess.save(funcionestruc,connexion);
				}
				continue;
			}

			if(clas.clas.equals(SolicitudReemplazo.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(SolicitudReemplazo solicitudreemplazo:estructura.getSolicitudReemplazos()) {
					solicitudreemplazo.setid_estructura(estructura.getId());
					SolicitudReemplazoDataAccess.save(solicitudreemplazo,connexion);
				}
				continue;
			}

			if(clas.clas.equals(SolicitudHoraExtra.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(SolicitudHoraExtra solicitudhoraextra:estructura.getSolicitudHoraExtras()) {
					solicitudhoraextra.setid_estructura(estructura.getId());
					SolicitudHoraExtraDataAccess.save(solicitudhoraextra,connexion);
				}
				continue;
			}

			if(clas.clas.equals(EvaluacionNomi.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(EvaluacionNomi evaluacionnomi:estructura.getEvaluacionNomis()) {
					evaluacionnomi.setid_estructura(estructura.getId());
					EvaluacionNomiDataAccess.save(evaluacionnomi,connexion);
				}
				continue;
			}

			if(clas.clas.equals(SolicitudVacacion.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(SolicitudVacacion solicitudvacacion:estructura.getSolicitudVacacions()) {
					solicitudvacacion.setid_estructura(estructura.getId());
					SolicitudVacacionDataAccess.save(solicitudvacacion,connexion);
				}
				continue;
			}

			if(clas.clas.equals(ResponsableActivoFijo.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(ResponsableActivoFijo responsableactivofijo:estructura.getResponsableActivoFijos()) {
					responsableactivofijo.setid_estructura(estructura.getId());
					ResponsableActivoFijoDataAccess.save(responsableactivofijo,connexion);
				}
				continue;
			}

			if(clas.clas.equals(RubroEmpleaCuentaContable.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(RubroEmpleaCuentaContable rubroempleacuentacontable:estructura.getRubroEmpleaCuentaContables()) {
					rubroempleacuentacontable.setid_estructura(estructura.getId());
					RubroEmpleaCuentaContableDataAccess.save(rubroempleacuentacontable,connexion);
				}
				continue;
			}
		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(estructura.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(estructura.getEmpresa(),isDeep,deepLoadType,clases);
				

		SucursalDataAccess.save(estructura.getSucursal(),connexion);
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(estructura.getSucursal(),isDeep,deepLoadType,clases);
				

		EstructuraDataAccess.save(estructura.getEstructura(),connexion);
		EstructuraLogic estructuraLogic= new EstructuraLogic(connexion);
		estructuraLogic.deepLoad(estructura.getEstructura(),isDeep,deepLoadType,clases);
				

		TipoPago_NMDataAccess.save(estructura.getTipoPago_NM(),connexion);
		TipoPago_NMLogic tipopago_nmLogic= new TipoPago_NMLogic(connexion);
		tipopago_nmLogic.deepLoad(estructura.getTipoPago_NM(),isDeep,deepLoadType,clases);
				

		NumeroPatronalDataAccess.save(estructura.getNumeroPatronal(),connexion);
		NumeroPatronalLogic numeropatronalLogic= new NumeroPatronalLogic(connexion);
		numeropatronalLogic.deepLoad(estructura.getNumeroPatronal(),isDeep,deepLoadType,clases);
				

		CuentaContableDataAccess.save(estructura.getCuentaContable(),connexion);
		CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
		cuentacontableLogic.deepLoad(estructura.getCuentaContable(),isDeep,deepLoadType,clases);
				

		TipoEstructuraDataAccess.save(estructura.getTipoEstructura(),connexion);
		TipoEstructuraLogic tipoestructuraLogic= new TipoEstructuraLogic(connexion);
		tipoestructuraLogic.deepLoad(estructura.getTipoEstructura(),isDeep,deepLoadType,clases);
				

		PaisDataAccess.save(estructura.getPais(),connexion);
		PaisLogic paisLogic= new PaisLogic(connexion);
		paisLogic.deepLoad(estructura.getPais(),isDeep,deepLoadType,clases);
				

		CiudadDataAccess.save(estructura.getCiudad(),connexion);
		CiudadLogic ciudadLogic= new CiudadLogic(connexion);
		ciudadLogic.deepLoad(estructura.getCiudad(),isDeep,deepLoadType,clases);
				

		for(CentroCostoEstructura centrocostoestructura:estructura.getCentroCostoEstructuras()) {
			CentroCostoEstructuraLogic centrocostoestructuraLogic= new CentroCostoEstructuraLogic(connexion);
			centrocostoestructura.setid_estructura(estructura.getId());
			CentroCostoEstructuraDataAccess.save(centrocostoestructura,connexion);
			centrocostoestructuraLogic.deepSave(centrocostoestructura,isDeep,deepLoadType,clases);
		}

		for(PlaniVacacion planivacacion:estructura.getPlaniVacacionCargos()) {
			PlaniVacacionLogic planivacacionLogic= new PlaniVacacionLogic(connexion);
			planivacacion.setid_estructura_cargo(estructura.getId());
			PlaniVacacionDataAccess.save(planivacacion,connexion);
			planivacacionLogic.deepSave(planivacacion,isDeep,deepLoadType,clases);
		}

		for(AsistenciaMensual asistenciamensual:estructura.getAsistenciaMensuals()) {
			AsistenciaMensualLogic asistenciamensualLogic= new AsistenciaMensualLogic(connexion);
			asistenciamensual.setid_estructura(estructura.getId());
			AsistenciaMensualDataAccess.save(asistenciamensual,connexion);
			asistenciamensualLogic.deepSave(asistenciamensual,isDeep,deepLoadType,clases);
		}

		for(EmpleadoProcesoRubro empleadoprocesorubro:estructura.getEmpleadoProcesoRubros()) {
			EmpleadoProcesoRubroLogic empleadoprocesorubroLogic= new EmpleadoProcesoRubroLogic(connexion);
			empleadoprocesorubro.setid_estructura(estructura.getId());
			EmpleadoProcesoRubroDataAccess.save(empleadoprocesorubro,connexion);
			empleadoprocesorubroLogic.deepSave(empleadoprocesorubro,isDeep,deepLoadType,clases);
		}

		for(EmpleadoPagoRubro empleadopagorubro:estructura.getEmpleadoPagoRubros()) {
			EmpleadoPagoRubroLogic empleadopagorubroLogic= new EmpleadoPagoRubroLogic(connexion);
			empleadopagorubro.setid_estructura(estructura.getId());
			EmpleadoPagoRubroDataAccess.save(empleadopagorubro,connexion);
			empleadopagorubroLogic.deepSave(empleadopagorubro,isDeep,deepLoadType,clases);
		}

		for(ProvisionEmpleado provisionempleado:estructura.getProvisionEmpleados()) {
			ProvisionEmpleadoLogic provisionempleadoLogic= new ProvisionEmpleadoLogic(connexion);
			provisionempleado.setid_estructura(estructura.getId());
			ProvisionEmpleadoDataAccess.save(provisionempleado,connexion);
			provisionempleadoLogic.deepSave(provisionempleado,isDeep,deepLoadType,clases);
		}

		for(Empleado empleado:estructura.getEmpleados()) {
			EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
			empleado.setid_estructura(estructura.getId());
			EmpleadoDataAccess.save(empleado,connexion);
			empleadoLogic.deepSave(empleado,isDeep,deepLoadType,clases);
		}

		for(Estructura estructuraRecursivo:estructura.getEstructuras()) {
			EstructuraLogic estructuraRecursivoLogic= new EstructuraLogic(connexion);
			estructuraRecursivo.setid_estructura(estructura.getId());
			EstructuraDataAccess.save(estructuraRecursivo,connexion);
			estructuraRecursivoLogic.deepSave(estructuraRecursivo,isDeep,deepLoadType,clases);
		}

		for(EvaluacionEmpleado evaluacionempleado:estructura.getEvaluacionEmpleados()) {
			EvaluacionEmpleadoLogic evaluacionempleadoLogic= new EvaluacionEmpleadoLogic(connexion);
			evaluacionempleado.setid_estructura(estructura.getId());
			EvaluacionEmpleadoDataAccess.save(evaluacionempleado,connexion);
			evaluacionempleadoLogic.deepSave(evaluacionempleado,isDeep,deepLoadType,clases);
		}

		for(EmpleadoImpuestoRenta empleadoimpuestorenta:estructura.getEmpleadoImpuestoRentas()) {
			EmpleadoImpuestoRentaLogic empleadoimpuestorentaLogic= new EmpleadoImpuestoRentaLogic(connexion);
			empleadoimpuestorenta.setid_estructura(estructura.getId());
			EmpleadoImpuestoRentaDataAccess.save(empleadoimpuestorenta,connexion);
			empleadoimpuestorentaLogic.deepSave(empleadoimpuestorenta,isDeep,deepLoadType,clases);
		}

		for(RubroEstructura rubroestructura:estructura.getRubroEstructuras()) {
			RubroEstructuraLogic rubroestructuraLogic= new RubroEstructuraLogic(connexion);
			rubroestructura.setid_estructura(estructura.getId());
			RubroEstructuraDataAccess.save(rubroestructura,connexion);
			rubroestructuraLogic.deepSave(rubroestructura,isDeep,deepLoadType,clases);
		}

		for(CierreRolMensual cierrerolmensual:estructura.getCierreRolMensuals()) {
			CierreRolMensualLogic cierrerolmensualLogic= new CierreRolMensualLogic(connexion);
			cierrerolmensual.setid_estructura(estructura.getId());
			CierreRolMensualDataAccess.save(cierrerolmensual,connexion);
			cierrerolmensualLogic.deepSave(cierrerolmensual,isDeep,deepLoadType,clases);
		}

		for(FormatoNomi formatonomi:estructura.getFormatoNomis()) {
			FormatoNomiLogic formatonomiLogic= new FormatoNomiLogic(connexion);
			formatonomi.setid_estructura(estructura.getId());
			FormatoNomiDataAccess.save(formatonomi,connexion);
			formatonomiLogic.deepSave(formatonomi,isDeep,deepLoadType,clases);
		}

		for(EmpleadoEstructura empleadoestructura:estructura.getEmpleadoEstructuras()) {
			EmpleadoEstructuraLogic empleadoestructuraLogic= new EmpleadoEstructuraLogic(connexion);
			empleadoestructura.setid_estructura(estructura.getId());
			EmpleadoEstructuraDataAccess.save(empleadoestructura,connexion);
			empleadoestructuraLogic.deepSave(empleadoestructura,isDeep,deepLoadType,clases);
		}

		for(HistorialPagoNomi historialpagonomi:estructura.getHistorialPagoNomis()) {
			HistorialPagoNomiLogic historialpagonomiLogic= new HistorialPagoNomiLogic(connexion);
			historialpagonomi.setid_estructura(estructura.getId());
			HistorialPagoNomiDataAccess.save(historialpagonomi,connexion);
			historialpagonomiLogic.deepSave(historialpagonomi,isDeep,deepLoadType,clases);
		}

		for(AsistenciaDiaria asistenciadiaria:estructura.getAsistenciaDiarias()) {
			AsistenciaDiariaLogic asistenciadiariaLogic= new AsistenciaDiariaLogic(connexion);
			asistenciadiaria.setid_estructura(estructura.getId());
			AsistenciaDiariaDataAccess.save(asistenciadiaria,connexion);
			asistenciadiariaLogic.deepSave(asistenciadiaria,isDeep,deepLoadType,clases);
		}

		for(FuncionEstruc funcionestruc:estructura.getFuncionEstrucs()) {
			FuncionEstrucLogic funcionestrucLogic= new FuncionEstrucLogic(connexion);
			funcionestruc.setid_estructura(estructura.getId());
			FuncionEstrucDataAccess.save(funcionestruc,connexion);
			funcionestrucLogic.deepSave(funcionestruc,isDeep,deepLoadType,clases);
		}

		for(SolicitudReemplazo solicitudreemplazo:estructura.getSolicitudReemplazos()) {
			SolicitudReemplazoLogic solicitudreemplazoLogic= new SolicitudReemplazoLogic(connexion);
			solicitudreemplazo.setid_estructura(estructura.getId());
			SolicitudReemplazoDataAccess.save(solicitudreemplazo,connexion);
			solicitudreemplazoLogic.deepSave(solicitudreemplazo,isDeep,deepLoadType,clases);
		}

		for(SolicitudHoraExtra solicitudhoraextra:estructura.getSolicitudHoraExtras()) {
			SolicitudHoraExtraLogic solicitudhoraextraLogic= new SolicitudHoraExtraLogic(connexion);
			solicitudhoraextra.setid_estructura(estructura.getId());
			SolicitudHoraExtraDataAccess.save(solicitudhoraextra,connexion);
			solicitudhoraextraLogic.deepSave(solicitudhoraextra,isDeep,deepLoadType,clases);
		}

		for(EvaluacionNomi evaluacionnomi:estructura.getEvaluacionNomis()) {
			EvaluacionNomiLogic evaluacionnomiLogic= new EvaluacionNomiLogic(connexion);
			evaluacionnomi.setid_estructura(estructura.getId());
			EvaluacionNomiDataAccess.save(evaluacionnomi,connexion);
			evaluacionnomiLogic.deepSave(evaluacionnomi,isDeep,deepLoadType,clases);
		}

		for(SolicitudVacacion solicitudvacacion:estructura.getSolicitudVacacions()) {
			SolicitudVacacionLogic solicitudvacacionLogic= new SolicitudVacacionLogic(connexion);
			solicitudvacacion.setid_estructura(estructura.getId());
			SolicitudVacacionDataAccess.save(solicitudvacacion,connexion);
			solicitudvacacionLogic.deepSave(solicitudvacacion,isDeep,deepLoadType,clases);
		}

		for(ResponsableActivoFijo responsableactivofijo:estructura.getResponsableActivoFijos()) {
			ResponsableActivoFijoLogic responsableactivofijoLogic= new ResponsableActivoFijoLogic(connexion);
			responsableactivofijo.setid_estructura(estructura.getId());
			ResponsableActivoFijoDataAccess.save(responsableactivofijo,connexion);
			responsableactivofijoLogic.deepSave(responsableactivofijo,isDeep,deepLoadType,clases);
		}

		for(RubroEmpleaCuentaContable rubroempleacuentacontable:estructura.getRubroEmpleaCuentaContables()) {
			RubroEmpleaCuentaContableLogic rubroempleacuentacontableLogic= new RubroEmpleaCuentaContableLogic(connexion);
			rubroempleacuentacontable.setid_estructura(estructura.getId());
			RubroEmpleaCuentaContableDataAccess.save(rubroempleacuentacontable,connexion);
			rubroempleacuentacontableLogic.deepSave(rubroempleacuentacontable,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(estructura.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(estructura.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(estructura.getSucursal(),connexion);
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepSave(estructura.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Estructura.class)) {
				EstructuraDataAccess.save(estructura.getEstructura(),connexion);
				EstructuraLogic estructuraLogic= new EstructuraLogic(connexion);
				estructuraLogic.deepSave(estructura.getEstructura(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoPago_NM.class)) {
				TipoPago_NMDataAccess.save(estructura.getTipoPago_NM(),connexion);
				TipoPago_NMLogic tipopago_nmLogic= new TipoPago_NMLogic(connexion);
				tipopago_nmLogic.deepSave(estructura.getTipoPago_NM(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(NumeroPatronal.class)) {
				NumeroPatronalDataAccess.save(estructura.getNumeroPatronal(),connexion);
				NumeroPatronalLogic numeropatronalLogic= new NumeroPatronalLogic(connexion);
				numeropatronalLogic.deepSave(estructura.getNumeroPatronal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(estructura.getCuentaContable(),connexion);
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepSave(estructura.getCuentaContable(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoEstructura.class)) {
				TipoEstructuraDataAccess.save(estructura.getTipoEstructura(),connexion);
				TipoEstructuraLogic tipoestructuraLogic= new TipoEstructuraLogic(connexion);
				tipoestructuraLogic.deepSave(estructura.getTipoEstructura(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Pais.class)) {
				PaisDataAccess.save(estructura.getPais(),connexion);
				PaisLogic paisLogic= new PaisLogic(connexion);
				paisLogic.deepSave(estructura.getPais(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Ciudad.class)) {
				CiudadDataAccess.save(estructura.getCiudad(),connexion);
				CiudadLogic ciudadLogic= new CiudadLogic(connexion);
				ciudadLogic.deepSave(estructura.getCiudad(),isDeep,deepLoadType,clases);				
				continue;
			}


			if(clas.clas.equals(CentroCostoEstructura.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(CentroCostoEstructura centrocostoestructura:estructura.getCentroCostoEstructuras()) {
					CentroCostoEstructuraLogic centrocostoestructuraLogic= new CentroCostoEstructuraLogic(connexion);
					centrocostoestructura.setid_estructura(estructura.getId());
					CentroCostoEstructuraDataAccess.save(centrocostoestructura,connexion);
					centrocostoestructuraLogic.deepSave(centrocostoestructura,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(PlaniVacacion.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(PlaniVacacion planivacacion:estructura.getPlaniVacacionCargos()) {
					PlaniVacacionLogic planivacacionLogic= new PlaniVacacionLogic(connexion);
					planivacacion.setid_estructura_cargo(estructura.getId());
					PlaniVacacionDataAccess.save(planivacacion,connexion);
					planivacacionLogic.deepSave(planivacacion,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(AsistenciaMensual.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(AsistenciaMensual asistenciamensual:estructura.getAsistenciaMensuals()) {
					AsistenciaMensualLogic asistenciamensualLogic= new AsistenciaMensualLogic(connexion);
					asistenciamensual.setid_estructura(estructura.getId());
					AsistenciaMensualDataAccess.save(asistenciamensual,connexion);
					asistenciamensualLogic.deepSave(asistenciamensual,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(EmpleadoProcesoRubro.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(EmpleadoProcesoRubro empleadoprocesorubro:estructura.getEmpleadoProcesoRubros()) {
					EmpleadoProcesoRubroLogic empleadoprocesorubroLogic= new EmpleadoProcesoRubroLogic(connexion);
					empleadoprocesorubro.setid_estructura(estructura.getId());
					EmpleadoProcesoRubroDataAccess.save(empleadoprocesorubro,connexion);
					empleadoprocesorubroLogic.deepSave(empleadoprocesorubro,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(EmpleadoPagoRubro.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(EmpleadoPagoRubro empleadopagorubro:estructura.getEmpleadoPagoRubros()) {
					EmpleadoPagoRubroLogic empleadopagorubroLogic= new EmpleadoPagoRubroLogic(connexion);
					empleadopagorubro.setid_estructura(estructura.getId());
					EmpleadoPagoRubroDataAccess.save(empleadopagorubro,connexion);
					empleadopagorubroLogic.deepSave(empleadopagorubro,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(ProvisionEmpleado.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(ProvisionEmpleado provisionempleado:estructura.getProvisionEmpleados()) {
					ProvisionEmpleadoLogic provisionempleadoLogic= new ProvisionEmpleadoLogic(connexion);
					provisionempleado.setid_estructura(estructura.getId());
					ProvisionEmpleadoDataAccess.save(provisionempleado,connexion);
					provisionempleadoLogic.deepSave(provisionempleado,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(Empleado.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(Empleado empleado:estructura.getEmpleados()) {
					EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
					empleado.setid_estructura(estructura.getId());
					EmpleadoDataAccess.save(empleado,connexion);
					empleadoLogic.deepSave(empleado,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(Estructura.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(Estructura estructuraRecursivo:estructura.getEstructuras()) {
					EstructuraLogic estructuraRecursivoLogic= new EstructuraLogic(connexion);
					estructuraRecursivo.setid_estructura(estructura.getId());
					EstructuraDataAccess.save(estructuraRecursivo,connexion);
					estructuraRecursivoLogic.deepSave(estructuraRecursivo,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(EvaluacionEmpleado.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(EvaluacionEmpleado evaluacionempleado:estructura.getEvaluacionEmpleados()) {
					EvaluacionEmpleadoLogic evaluacionempleadoLogic= new EvaluacionEmpleadoLogic(connexion);
					evaluacionempleado.setid_estructura(estructura.getId());
					EvaluacionEmpleadoDataAccess.save(evaluacionempleado,connexion);
					evaluacionempleadoLogic.deepSave(evaluacionempleado,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(EmpleadoImpuestoRenta.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(EmpleadoImpuestoRenta empleadoimpuestorenta:estructura.getEmpleadoImpuestoRentas()) {
					EmpleadoImpuestoRentaLogic empleadoimpuestorentaLogic= new EmpleadoImpuestoRentaLogic(connexion);
					empleadoimpuestorenta.setid_estructura(estructura.getId());
					EmpleadoImpuestoRentaDataAccess.save(empleadoimpuestorenta,connexion);
					empleadoimpuestorentaLogic.deepSave(empleadoimpuestorenta,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(RubroEstructura.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(RubroEstructura rubroestructura:estructura.getRubroEstructuras()) {
					RubroEstructuraLogic rubroestructuraLogic= new RubroEstructuraLogic(connexion);
					rubroestructura.setid_estructura(estructura.getId());
					RubroEstructuraDataAccess.save(rubroestructura,connexion);
					rubroestructuraLogic.deepSave(rubroestructura,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(CierreRolMensual.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(CierreRolMensual cierrerolmensual:estructura.getCierreRolMensuals()) {
					CierreRolMensualLogic cierrerolmensualLogic= new CierreRolMensualLogic(connexion);
					cierrerolmensual.setid_estructura(estructura.getId());
					CierreRolMensualDataAccess.save(cierrerolmensual,connexion);
					cierrerolmensualLogic.deepSave(cierrerolmensual,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(FormatoNomi.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(FormatoNomi formatonomi:estructura.getFormatoNomis()) {
					FormatoNomiLogic formatonomiLogic= new FormatoNomiLogic(connexion);
					formatonomi.setid_estructura(estructura.getId());
					FormatoNomiDataAccess.save(formatonomi,connexion);
					formatonomiLogic.deepSave(formatonomi,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(EmpleadoEstructura.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(EmpleadoEstructura empleadoestructura:estructura.getEmpleadoEstructuras()) {
					EmpleadoEstructuraLogic empleadoestructuraLogic= new EmpleadoEstructuraLogic(connexion);
					empleadoestructura.setid_estructura(estructura.getId());
					EmpleadoEstructuraDataAccess.save(empleadoestructura,connexion);
					empleadoestructuraLogic.deepSave(empleadoestructura,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(HistorialPagoNomi.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(HistorialPagoNomi historialpagonomi:estructura.getHistorialPagoNomis()) {
					HistorialPagoNomiLogic historialpagonomiLogic= new HistorialPagoNomiLogic(connexion);
					historialpagonomi.setid_estructura(estructura.getId());
					HistorialPagoNomiDataAccess.save(historialpagonomi,connexion);
					historialpagonomiLogic.deepSave(historialpagonomi,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(AsistenciaDiaria.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(AsistenciaDiaria asistenciadiaria:estructura.getAsistenciaDiarias()) {
					AsistenciaDiariaLogic asistenciadiariaLogic= new AsistenciaDiariaLogic(connexion);
					asistenciadiaria.setid_estructura(estructura.getId());
					AsistenciaDiariaDataAccess.save(asistenciadiaria,connexion);
					asistenciadiariaLogic.deepSave(asistenciadiaria,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(FuncionEstruc.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(FuncionEstruc funcionestruc:estructura.getFuncionEstrucs()) {
					FuncionEstrucLogic funcionestrucLogic= new FuncionEstrucLogic(connexion);
					funcionestruc.setid_estructura(estructura.getId());
					FuncionEstrucDataAccess.save(funcionestruc,connexion);
					funcionestrucLogic.deepSave(funcionestruc,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(SolicitudReemplazo.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(SolicitudReemplazo solicitudreemplazo:estructura.getSolicitudReemplazos()) {
					SolicitudReemplazoLogic solicitudreemplazoLogic= new SolicitudReemplazoLogic(connexion);
					solicitudreemplazo.setid_estructura(estructura.getId());
					SolicitudReemplazoDataAccess.save(solicitudreemplazo,connexion);
					solicitudreemplazoLogic.deepSave(solicitudreemplazo,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(SolicitudHoraExtra.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(SolicitudHoraExtra solicitudhoraextra:estructura.getSolicitudHoraExtras()) {
					SolicitudHoraExtraLogic solicitudhoraextraLogic= new SolicitudHoraExtraLogic(connexion);
					solicitudhoraextra.setid_estructura(estructura.getId());
					SolicitudHoraExtraDataAccess.save(solicitudhoraextra,connexion);
					solicitudhoraextraLogic.deepSave(solicitudhoraextra,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(EvaluacionNomi.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(EvaluacionNomi evaluacionnomi:estructura.getEvaluacionNomis()) {
					EvaluacionNomiLogic evaluacionnomiLogic= new EvaluacionNomiLogic(connexion);
					evaluacionnomi.setid_estructura(estructura.getId());
					EvaluacionNomiDataAccess.save(evaluacionnomi,connexion);
					evaluacionnomiLogic.deepSave(evaluacionnomi,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(SolicitudVacacion.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(SolicitudVacacion solicitudvacacion:estructura.getSolicitudVacacions()) {
					SolicitudVacacionLogic solicitudvacacionLogic= new SolicitudVacacionLogic(connexion);
					solicitudvacacion.setid_estructura(estructura.getId());
					SolicitudVacacionDataAccess.save(solicitudvacacion,connexion);
					solicitudvacacionLogic.deepSave(solicitudvacacion,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(ResponsableActivoFijo.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(ResponsableActivoFijo responsableactivofijo:estructura.getResponsableActivoFijos()) {
					ResponsableActivoFijoLogic responsableactivofijoLogic= new ResponsableActivoFijoLogic(connexion);
					responsableactivofijo.setid_estructura(estructura.getId());
					ResponsableActivoFijoDataAccess.save(responsableactivofijo,connexion);
					responsableactivofijoLogic.deepSave(responsableactivofijo,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(RubroEmpleaCuentaContable.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(RubroEmpleaCuentaContable rubroempleacuentacontable:estructura.getRubroEmpleaCuentaContables()) {
					RubroEmpleaCuentaContableLogic rubroempleacuentacontableLogic= new RubroEmpleaCuentaContableLogic(connexion);
					rubroempleacuentacontable.setid_estructura(estructura.getId());
					RubroEmpleaCuentaContableDataAccess.save(rubroempleacuentacontable,connexion);
					rubroempleacuentacontableLogic.deepSave(rubroempleacuentacontable,isDeep,deepLoadType,clases);
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
			this.getNewConnexionToDeep(Estructura.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(estructura,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				EstructuraConstantesFunciones.refrescarForeignKeysDescripcionesEstructura(estructura);
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
			this.deepLoad(this.estructura,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				EstructuraConstantesFunciones.refrescarForeignKeysDescripcionesEstructura(this.estructura);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(Estructura.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(estructuras!=null) {
				for(Estructura estructura:estructuras) {
					this.deepLoad(estructura,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					EstructuraConstantesFunciones.refrescarForeignKeysDescripcionesEstructura(estructuras);
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
			if(estructuras!=null) {
				for(Estructura estructura:estructuras) {
					this.deepLoad(estructura,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					EstructuraConstantesFunciones.refrescarForeignKeysDescripcionesEstructura(estructuras);
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
			this.getNewConnexionToDeep(Estructura.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(estructura,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(Estructura.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(estructuras!=null) {
				for(Estructura estructura:estructuras) {
					this.deepSave(estructura,isDeep,deepLoadType,clases);
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
			if(estructuras!=null) {
				for(Estructura estructura:estructuras) {
					this.deepSave(estructura,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getEstructurasFK_IdCiudadWithConnection(String sFinalQuery,Pagination pagination,Long id_ciudad)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Estructura.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCiudad= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCiudad.setParameterSelectionGeneralEqual(ParameterType.LONG,id_ciudad,EstructuraConstantesFunciones.IDCIUDAD,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCiudad);

			EstructuraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCiudad","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			estructuras=estructuraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				EstructuraConstantesFunciones.refrescarForeignKeysDescripcionesEstructura(this.estructuras);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getEstructurasFK_IdCiudad(String sFinalQuery,Pagination pagination,Long id_ciudad)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCiudad= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCiudad.setParameterSelectionGeneralEqual(ParameterType.LONG,id_ciudad,EstructuraConstantesFunciones.IDCIUDAD,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCiudad);

			EstructuraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCiudad","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			estructuras=estructuraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				EstructuraConstantesFunciones.refrescarForeignKeysDescripcionesEstructura(this.estructuras);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getEstructurasFK_IdCuentaContableWithConnection(String sFinalQuery,Pagination pagination,Long id_cuenta_contable)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Estructura.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContable= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContable.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable,EstructuraConstantesFunciones.IDCUENTACONTABLE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContable);

			EstructuraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContable","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			estructuras=estructuraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				EstructuraConstantesFunciones.refrescarForeignKeysDescripcionesEstructura(this.estructuras);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getEstructurasFK_IdCuentaContable(String sFinalQuery,Pagination pagination,Long id_cuenta_contable)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContable= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContable.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable,EstructuraConstantesFunciones.IDCUENTACONTABLE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContable);

			EstructuraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContable","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			estructuras=estructuraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				EstructuraConstantesFunciones.refrescarForeignKeysDescripcionesEstructura(this.estructuras);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getEstructurasFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Estructura.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,EstructuraConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			EstructuraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			estructuras=estructuraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				EstructuraConstantesFunciones.refrescarForeignKeysDescripcionesEstructura(this.estructuras);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getEstructurasFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,EstructuraConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			EstructuraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			estructuras=estructuraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				EstructuraConstantesFunciones.refrescarForeignKeysDescripcionesEstructura(this.estructuras);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getEstructurasFK_IdEstructuraWithConnection(String sFinalQuery,Pagination pagination,Long id_estructura)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Estructura.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEstructura= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEstructura.setParameterSelectionGeneralEqual(ParameterType.LONG,id_estructura,EstructuraConstantesFunciones.IDESTRUCTURA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEstructura);

			EstructuraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEstructura","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			estructuras=estructuraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				EstructuraConstantesFunciones.refrescarForeignKeysDescripcionesEstructura(this.estructuras);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getEstructurasFK_IdEstructura(String sFinalQuery,Pagination pagination,Long id_estructura)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEstructura= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEstructura.setParameterSelectionGeneralEqual(ParameterType.LONG,id_estructura,EstructuraConstantesFunciones.IDESTRUCTURA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEstructura);

			EstructuraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEstructura","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			estructuras=estructuraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				EstructuraConstantesFunciones.refrescarForeignKeysDescripcionesEstructura(this.estructuras);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getEstructurasFK_IdNumeroPatronalWithConnection(String sFinalQuery,Pagination pagination,Long id_numero_patronal)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Estructura.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidNumeroPatronal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidNumeroPatronal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_numero_patronal,EstructuraConstantesFunciones.IDNUMEROPATRONAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidNumeroPatronal);

			EstructuraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdNumeroPatronal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			estructuras=estructuraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				EstructuraConstantesFunciones.refrescarForeignKeysDescripcionesEstructura(this.estructuras);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getEstructurasFK_IdNumeroPatronal(String sFinalQuery,Pagination pagination,Long id_numero_patronal)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidNumeroPatronal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidNumeroPatronal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_numero_patronal,EstructuraConstantesFunciones.IDNUMEROPATRONAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidNumeroPatronal);

			EstructuraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdNumeroPatronal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			estructuras=estructuraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				EstructuraConstantesFunciones.refrescarForeignKeysDescripcionesEstructura(this.estructuras);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getEstructurasFK_IdPaisWithConnection(String sFinalQuery,Pagination pagination,Long id_pais)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Estructura.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPais= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPais.setParameterSelectionGeneralEqual(ParameterType.LONG,id_pais,EstructuraConstantesFunciones.IDPAIS,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPais);

			EstructuraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPais","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			estructuras=estructuraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				EstructuraConstantesFunciones.refrescarForeignKeysDescripcionesEstructura(this.estructuras);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getEstructurasFK_IdPais(String sFinalQuery,Pagination pagination,Long id_pais)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPais= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPais.setParameterSelectionGeneralEqual(ParameterType.LONG,id_pais,EstructuraConstantesFunciones.IDPAIS,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPais);

			EstructuraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPais","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			estructuras=estructuraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				EstructuraConstantesFunciones.refrescarForeignKeysDescripcionesEstructura(this.estructuras);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getEstructurasFK_IdSucursalWithConnection(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Estructura.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,EstructuraConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			EstructuraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			estructuras=estructuraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				EstructuraConstantesFunciones.refrescarForeignKeysDescripcionesEstructura(this.estructuras);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getEstructurasFK_IdSucursal(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,EstructuraConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			EstructuraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			estructuras=estructuraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				EstructuraConstantesFunciones.refrescarForeignKeysDescripcionesEstructura(this.estructuras);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getEstructurasFK_IdTipoEstructuraWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_estructura)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Estructura.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoEstructura= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoEstructura.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_estructura,EstructuraConstantesFunciones.IDTIPOESTRUCTURA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoEstructura);

			EstructuraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoEstructura","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			estructuras=estructuraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				EstructuraConstantesFunciones.refrescarForeignKeysDescripcionesEstructura(this.estructuras);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getEstructurasFK_IdTipoEstructura(String sFinalQuery,Pagination pagination,Long id_tipo_estructura)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoEstructura= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoEstructura.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_estructura,EstructuraConstantesFunciones.IDTIPOESTRUCTURA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoEstructura);

			EstructuraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoEstructura","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			estructuras=estructuraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				EstructuraConstantesFunciones.refrescarForeignKeysDescripcionesEstructura(this.estructuras);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getEstructurasFK_IdTipoPago_NMWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_pago__n_m)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Estructura.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoPago_NM= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoPago_NM.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_pago__n_m,EstructuraConstantesFunciones.IDTIPOPAGO_NM,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoPago_NM);

			EstructuraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoPago_NM","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			estructuras=estructuraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				EstructuraConstantesFunciones.refrescarForeignKeysDescripcionesEstructura(this.estructuras);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getEstructurasFK_IdTipoPago_NM(String sFinalQuery,Pagination pagination,Long id_tipo_pago__n_m)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoPago_NM= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoPago_NM.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_pago__n_m,EstructuraConstantesFunciones.IDTIPOPAGO_NM,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoPago_NM);

			EstructuraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoPago_NM","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			estructuras=estructuraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				EstructuraConstantesFunciones.refrescarForeignKeysDescripcionesEstructura(this.estructuras);
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
			if(EstructuraConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,EstructuraDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,Estructura estructura,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(EstructuraConstantesFunciones.ISCONAUDITORIA) {
				if(estructura.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,EstructuraDataAccess.TABLENAME, estructura.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(EstructuraConstantesFunciones.ISCONAUDITORIADETALLE) {
						////EstructuraLogic.registrarAuditoriaDetallesEstructura(connexion,estructura,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(estructura.getIsDeleted()) {
					/*if(!estructura.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,EstructuraDataAccess.TABLENAME, estructura.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////EstructuraLogic.registrarAuditoriaDetallesEstructura(connexion,estructura,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,EstructuraDataAccess.TABLENAME, estructura.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(estructura.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,EstructuraDataAccess.TABLENAME, estructura.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(EstructuraConstantesFunciones.ISCONAUDITORIADETALLE) {
						////EstructuraLogic.registrarAuditoriaDetallesEstructura(connexion,estructura,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesEstructura(Connexion connexion,Estructura estructura)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(estructura.getIsNew()||!estructura.getid_empresa().equals(estructura.getEstructuraOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(estructura.getEstructuraOriginal().getid_empresa()!=null)
				{
					strValorActual=estructura.getEstructuraOriginal().getid_empresa().toString();
				}
				if(estructura.getid_empresa()!=null)
				{
					strValorNuevo=estructura.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),EstructuraConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(estructura.getIsNew()||!estructura.getid_sucursal().equals(estructura.getEstructuraOriginal().getid_sucursal()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(estructura.getEstructuraOriginal().getid_sucursal()!=null)
				{
					strValorActual=estructura.getEstructuraOriginal().getid_sucursal().toString();
				}
				if(estructura.getid_sucursal()!=null)
				{
					strValorNuevo=estructura.getid_sucursal().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),EstructuraConstantesFunciones.IDSUCURSAL,strValorActual,strValorNuevo);
			}	
			
			if(estructura.getIsNew()||!estructura.getid_estructura().equals(estructura.getEstructuraOriginal().getid_estructura()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(estructura.getEstructuraOriginal().getid_estructura()!=null)
				{
					strValorActual=estructura.getEstructuraOriginal().getid_estructura().toString();
				}
				if(estructura.getid_estructura()!=null)
				{
					strValorNuevo=estructura.getid_estructura().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),EstructuraConstantesFunciones.IDESTRUCTURA,strValorActual,strValorNuevo);
			}	
			
			if(estructura.getIsNew()||!estructura.getid_tipo_pago__n_m().equals(estructura.getEstructuraOriginal().getid_tipo_pago__n_m()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(estructura.getEstructuraOriginal().getid_tipo_pago__n_m()!=null)
				{
					strValorActual=estructura.getEstructuraOriginal().getid_tipo_pago__n_m().toString();
				}
				if(estructura.getid_tipo_pago__n_m()!=null)
				{
					strValorNuevo=estructura.getid_tipo_pago__n_m().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),EstructuraConstantesFunciones.IDTIPOPAGO_NM,strValorActual,strValorNuevo);
			}	
			
			if(estructura.getIsNew()||!estructura.getid_numero_patronal().equals(estructura.getEstructuraOriginal().getid_numero_patronal()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(estructura.getEstructuraOriginal().getid_numero_patronal()!=null)
				{
					strValorActual=estructura.getEstructuraOriginal().getid_numero_patronal().toString();
				}
				if(estructura.getid_numero_patronal()!=null)
				{
					strValorNuevo=estructura.getid_numero_patronal().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),EstructuraConstantesFunciones.IDNUMEROPATRONAL,strValorActual,strValorNuevo);
			}	
			
			if(estructura.getIsNew()||!estructura.getid_cuenta_contable().equals(estructura.getEstructuraOriginal().getid_cuenta_contable()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(estructura.getEstructuraOriginal().getid_cuenta_contable()!=null)
				{
					strValorActual=estructura.getEstructuraOriginal().getid_cuenta_contable().toString();
				}
				if(estructura.getid_cuenta_contable()!=null)
				{
					strValorNuevo=estructura.getid_cuenta_contable().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),EstructuraConstantesFunciones.IDCUENTACONTABLE,strValorActual,strValorNuevo);
			}	
			
			if(estructura.getIsNew()||!estructura.getid_tipo_estructura().equals(estructura.getEstructuraOriginal().getid_tipo_estructura()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(estructura.getEstructuraOriginal().getid_tipo_estructura()!=null)
				{
					strValorActual=estructura.getEstructuraOriginal().getid_tipo_estructura().toString();
				}
				if(estructura.getid_tipo_estructura()!=null)
				{
					strValorNuevo=estructura.getid_tipo_estructura().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),EstructuraConstantesFunciones.IDTIPOESTRUCTURA,strValorActual,strValorNuevo);
			}	
			
			if(estructura.getIsNew()||!estructura.getid_pais().equals(estructura.getEstructuraOriginal().getid_pais()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(estructura.getEstructuraOriginal().getid_pais()!=null)
				{
					strValorActual=estructura.getEstructuraOriginal().getid_pais().toString();
				}
				if(estructura.getid_pais()!=null)
				{
					strValorNuevo=estructura.getid_pais().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),EstructuraConstantesFunciones.IDPAIS,strValorActual,strValorNuevo);
			}	
			
			if(estructura.getIsNew()||!estructura.getid_ciudad().equals(estructura.getEstructuraOriginal().getid_ciudad()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(estructura.getEstructuraOriginal().getid_ciudad()!=null)
				{
					strValorActual=estructura.getEstructuraOriginal().getid_ciudad().toString();
				}
				if(estructura.getid_ciudad()!=null)
				{
					strValorNuevo=estructura.getid_ciudad().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),EstructuraConstantesFunciones.IDCIUDAD,strValorActual,strValorNuevo);
			}	
			
			if(estructura.getIsNew()||!estructura.getcodigo().equals(estructura.getEstructuraOriginal().getcodigo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(estructura.getEstructuraOriginal().getcodigo()!=null)
				{
					strValorActual=estructura.getEstructuraOriginal().getcodigo();
				}
				if(estructura.getcodigo()!=null)
				{
					strValorNuevo=estructura.getcodigo() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),EstructuraConstantesFunciones.CODIGO,strValorActual,strValorNuevo);
			}	
			
			if(estructura.getIsNew()||!estructura.getnumero().equals(estructura.getEstructuraOriginal().getnumero()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(estructura.getEstructuraOriginal().getnumero()!=null)
				{
					strValorActual=estructura.getEstructuraOriginal().getnumero();
				}
				if(estructura.getnumero()!=null)
				{
					strValorNuevo=estructura.getnumero() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),EstructuraConstantesFunciones.NUMERO,strValorActual,strValorNuevo);
			}	
			
			if(estructura.getIsNew()||!estructura.getvalor_anticipo().equals(estructura.getEstructuraOriginal().getvalor_anticipo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(estructura.getEstructuraOriginal().getvalor_anticipo()!=null)
				{
					strValorActual=estructura.getEstructuraOriginal().getvalor_anticipo().toString();
				}
				if(estructura.getvalor_anticipo()!=null)
				{
					strValorNuevo=estructura.getvalor_anticipo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),EstructuraConstantesFunciones.VALORANTICIPO,strValorActual,strValorNuevo);
			}	
			
			if(estructura.getIsNew()||!estructura.getporcentaje_anticipo().equals(estructura.getEstructuraOriginal().getporcentaje_anticipo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(estructura.getEstructuraOriginal().getporcentaje_anticipo()!=null)
				{
					strValorActual=estructura.getEstructuraOriginal().getporcentaje_anticipo().toString();
				}
				if(estructura.getporcentaje_anticipo()!=null)
				{
					strValorNuevo=estructura.getporcentaje_anticipo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),EstructuraConstantesFunciones.PORCENTAJEANTICIPO,strValorActual,strValorNuevo);
			}	
			
			if(estructura.getIsNew()||!estructura.getnombre().equals(estructura.getEstructuraOriginal().getnombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(estructura.getEstructuraOriginal().getnombre()!=null)
				{
					strValorActual=estructura.getEstructuraOriginal().getnombre();
				}
				if(estructura.getnombre()!=null)
				{
					strValorNuevo=estructura.getnombre() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),EstructuraConstantesFunciones.NOMBRE,strValorActual,strValorNuevo);
			}	
			
			if(estructura.getIsNew()||!estructura.getes_jefe().equals(estructura.getEstructuraOriginal().getes_jefe()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(estructura.getEstructuraOriginal().getes_jefe()!=null)
				{
					strValorActual=estructura.getEstructuraOriginal().getes_jefe().toString();
				}
				if(estructura.getes_jefe()!=null)
				{
					strValorNuevo=estructura.getes_jefe().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),EstructuraConstantesFunciones.ESJEFE,strValorActual,strValorNuevo);
			}	
			
			if(estructura.getIsNew()||!estructura.getes_anual().equals(estructura.getEstructuraOriginal().getes_anual()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(estructura.getEstructuraOriginal().getes_anual()!=null)
				{
					strValorActual=estructura.getEstructuraOriginal().getes_anual().toString();
				}
				if(estructura.getes_anual()!=null)
				{
					strValorNuevo=estructura.getes_anual().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),EstructuraConstantesFunciones.ESANUAL,strValorActual,strValorNuevo);
			}	
			
			if(estructura.getIsNew()||!estructura.getporcentaje().equals(estructura.getEstructuraOriginal().getporcentaje()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(estructura.getEstructuraOriginal().getporcentaje()!=null)
				{
					strValorActual=estructura.getEstructuraOriginal().getporcentaje().toString();
				}
				if(estructura.getporcentaje()!=null)
				{
					strValorNuevo=estructura.getporcentaje().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),EstructuraConstantesFunciones.PORCENTAJE,strValorActual,strValorNuevo);
			}	
			
			if(estructura.getIsNew()||!estructura.getvalor().equals(estructura.getEstructuraOriginal().getvalor()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(estructura.getEstructuraOriginal().getvalor()!=null)
				{
					strValorActual=estructura.getEstructuraOriginal().getvalor().toString();
				}
				if(estructura.getvalor()!=null)
				{
					strValorNuevo=estructura.getvalor().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),EstructuraConstantesFunciones.VALOR,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveEstructuraRelacionesWithConnection(Estructura estructura,List<CentroCostoEstructura> centrocostoestructuras,List<PlaniVacacion> planivacacionCargos,List<AsistenciaMensual> asistenciamensuals,List<EmpleadoProcesoRubro> empleadoprocesorubros,List<EmpleadoPagoRubro> empleadopagorubros,List<ProvisionEmpleado> provisionempleados,List<Empleado> empleados,List<Estructura> estructuras,List<EvaluacionEmpleado> evaluacionempleados,List<EmpleadoImpuestoRenta> empleadoimpuestorentas,List<RubroEstructura> rubroestructuras,List<CierreRolMensual> cierrerolmensuals,List<FormatoNomi> formatonomis,List<EmpleadoEstructura> empleadoestructuras,List<HistorialPagoNomi> historialpagonomis,List<AsistenciaDiaria> asistenciadiarias,List<FuncionEstruc> funcionestrucs,List<SolicitudReemplazo> solicitudreemplazos,List<SolicitudHoraExtra> solicitudhoraextras,List<EvaluacionNomi> evaluacionnomis,List<SolicitudVacacion> solicitudvacacions,List<ResponsableActivoFijo> responsableactivofijos,List<RubroEmpleaCuentaContable> rubroempleacuentacontables) throws Exception {

		if(!estructura.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveEstructuraRelacionesBase(estructura,centrocostoestructuras,planivacacionCargos,asistenciamensuals,empleadoprocesorubros,empleadopagorubros,provisionempleados,empleados,estructuras,evaluacionempleados,empleadoimpuestorentas,rubroestructuras,cierrerolmensuals,formatonomis,empleadoestructuras,historialpagonomis,asistenciadiarias,funcionestrucs,solicitudreemplazos,solicitudhoraextras,evaluacionnomis,solicitudvacacions,responsableactivofijos,rubroempleacuentacontables,true);
		}
	}

	public void saveEstructuraRelaciones(Estructura estructura,List<CentroCostoEstructura> centrocostoestructuras,List<PlaniVacacion> planivacacionCargos,List<AsistenciaMensual> asistenciamensuals,List<EmpleadoProcesoRubro> empleadoprocesorubros,List<EmpleadoPagoRubro> empleadopagorubros,List<ProvisionEmpleado> provisionempleados,List<Empleado> empleados,List<Estructura> estructuras,List<EvaluacionEmpleado> evaluacionempleados,List<EmpleadoImpuestoRenta> empleadoimpuestorentas,List<RubroEstructura> rubroestructuras,List<CierreRolMensual> cierrerolmensuals,List<FormatoNomi> formatonomis,List<EmpleadoEstructura> empleadoestructuras,List<HistorialPagoNomi> historialpagonomis,List<AsistenciaDiaria> asistenciadiarias,List<FuncionEstruc> funcionestrucs,List<SolicitudReemplazo> solicitudreemplazos,List<SolicitudHoraExtra> solicitudhoraextras,List<EvaluacionNomi> evaluacionnomis,List<SolicitudVacacion> solicitudvacacions,List<ResponsableActivoFijo> responsableactivofijos,List<RubroEmpleaCuentaContable> rubroempleacuentacontables)throws Exception {

		if(!estructura.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveEstructuraRelacionesBase(estructura,centrocostoestructuras,planivacacionCargos,asistenciamensuals,empleadoprocesorubros,empleadopagorubros,provisionempleados,empleados,estructuras,evaluacionempleados,empleadoimpuestorentas,rubroestructuras,cierrerolmensuals,formatonomis,empleadoestructuras,historialpagonomis,asistenciadiarias,funcionestrucs,solicitudreemplazos,solicitudhoraextras,evaluacionnomis,solicitudvacacions,responsableactivofijos,rubroempleacuentacontables,false);
		}
	}

	public void saveEstructuraRelacionesBase(Estructura estructura,List<CentroCostoEstructura> centrocostoestructuras,List<PlaniVacacion> planivacacionCargos,List<AsistenciaMensual> asistenciamensuals,List<EmpleadoProcesoRubro> empleadoprocesorubros,List<EmpleadoPagoRubro> empleadopagorubros,List<ProvisionEmpleado> provisionempleados,List<Empleado> empleados,List<Estructura> estructuras,List<EvaluacionEmpleado> evaluacionempleados,List<EmpleadoImpuestoRenta> empleadoimpuestorentas,List<RubroEstructura> rubroestructuras,List<CierreRolMensual> cierrerolmensuals,List<FormatoNomi> formatonomis,List<EmpleadoEstructura> empleadoestructuras,List<HistorialPagoNomi> historialpagonomis,List<AsistenciaDiaria> asistenciadiarias,List<FuncionEstruc> funcionestrucs,List<SolicitudReemplazo> solicitudreemplazos,List<SolicitudHoraExtra> solicitudhoraextras,List<EvaluacionNomi> evaluacionnomis,List<SolicitudVacacion> solicitudvacacions,List<ResponsableActivoFijo> responsableactivofijos,List<RubroEmpleaCuentaContable> rubroempleacuentacontables,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("Estructura-saveRelacionesWithConnection");}
	
			estructura.setCentroCostoEstructuras(centrocostoestructuras);
			estructura.setPlaniVacacionCargos(planivacacionCargos);
			estructura.setAsistenciaMensuals(asistenciamensuals);
			estructura.setEmpleadoProcesoRubros(empleadoprocesorubros);
			estructura.setEmpleadoPagoRubros(empleadopagorubros);
			estructura.setProvisionEmpleados(provisionempleados);
			estructura.setEmpleados(empleados);
			estructura.setEstructuras(estructuras);
			estructura.setEvaluacionEmpleados(evaluacionempleados);
			estructura.setEmpleadoImpuestoRentas(empleadoimpuestorentas);
			estructura.setRubroEstructuras(rubroestructuras);
			estructura.setCierreRolMensuals(cierrerolmensuals);
			estructura.setFormatoNomis(formatonomis);
			estructura.setEmpleadoEstructuras(empleadoestructuras);
			estructura.setHistorialPagoNomis(historialpagonomis);
			estructura.setAsistenciaDiarias(asistenciadiarias);
			estructura.setFuncionEstrucs(funcionestrucs);
			estructura.setSolicitudReemplazos(solicitudreemplazos);
			estructura.setSolicitudHoraExtras(solicitudhoraextras);
			estructura.setEvaluacionNomis(evaluacionnomis);
			estructura.setSolicitudVacacions(solicitudvacacions);
			estructura.setResponsableActivoFijos(responsableactivofijos);
			estructura.setRubroEmpleaCuentaContables(rubroempleacuentacontables);

			this.setEstructura(estructura);

			if(EstructuraLogicAdditional.validarSaveRelaciones(estructura,this)) {

				EstructuraLogicAdditional.updateRelacionesToSave(estructura,this);

				if((estructura.getIsNew()||estructura.getIsChanged())&&!estructura.getIsDeleted()) {
					this.saveEstructura();
					this.saveEstructuraRelacionesDetalles(centrocostoestructuras,planivacacionCargos,asistenciamensuals,empleadoprocesorubros,empleadopagorubros,provisionempleados,empleados,estructuras,evaluacionempleados,empleadoimpuestorentas,rubroestructuras,cierrerolmensuals,formatonomis,empleadoestructuras,historialpagonomis,asistenciadiarias,funcionestrucs,solicitudreemplazos,solicitudhoraextras,evaluacionnomis,solicitudvacacions,responsableactivofijos,rubroempleacuentacontables);

				} else if(estructura.getIsDeleted()) {
					this.saveEstructuraRelacionesDetalles(centrocostoestructuras,planivacacionCargos,asistenciamensuals,empleadoprocesorubros,empleadopagorubros,provisionempleados,empleados,estructuras,evaluacionempleados,empleadoimpuestorentas,rubroestructuras,cierrerolmensuals,formatonomis,empleadoestructuras,historialpagonomis,asistenciadiarias,funcionestrucs,solicitudreemplazos,solicitudhoraextras,evaluacionnomis,solicitudvacacions,responsableactivofijos,rubroempleacuentacontables);
					this.saveEstructura();
				}

				EstructuraLogicAdditional.updateRelacionesToSaveAfter(estructura,this);

			} else {
				throw new Exception("LOS DATOS SON INVALIDOS");
			}

			if(conConexion) {connexion.commit();}

		} catch(Exception e) {
			
			CentroCostoEstructuraConstantesFunciones.InicializarGeneralEntityAuxiliaresCentroCostoEstructuras(centrocostoestructuras,true,true);
			PlaniVacacionConstantesFunciones.InicializarGeneralEntityAuxiliaresPlaniVacacions(planivacacionCargos,true,true);
			AsistenciaMensualConstantesFunciones.InicializarGeneralEntityAuxiliaresAsistenciaMensuals(asistenciamensuals,true,true);
			EmpleadoProcesoRubroConstantesFunciones.InicializarGeneralEntityAuxiliaresEmpleadoProcesoRubros(empleadoprocesorubros,true,true);
			EmpleadoPagoRubroConstantesFunciones.InicializarGeneralEntityAuxiliaresEmpleadoPagoRubros(empleadopagorubros,true,true);
			ProvisionEmpleadoConstantesFunciones.InicializarGeneralEntityAuxiliaresProvisionEmpleados(provisionempleados,true,true);
			EmpleadoConstantesFunciones.InicializarGeneralEntityAuxiliaresEmpleados(empleados,true,true);
			EstructuraConstantesFunciones.InicializarGeneralEntityAuxiliaresEstructuras(estructuras,true,true);
			EvaluacionEmpleadoConstantesFunciones.InicializarGeneralEntityAuxiliaresEvaluacionEmpleados(evaluacionempleados,true,true);
			EmpleadoImpuestoRentaConstantesFunciones.InicializarGeneralEntityAuxiliaresEmpleadoImpuestoRentas(empleadoimpuestorentas,true,true);
			RubroEstructuraConstantesFunciones.InicializarGeneralEntityAuxiliaresRubroEstructuras(rubroestructuras,true,true);
			CierreRolMensualConstantesFunciones.InicializarGeneralEntityAuxiliaresCierreRolMensuals(cierrerolmensuals,true,true);
			FormatoNomiConstantesFunciones.InicializarGeneralEntityAuxiliaresFormatoNomis(formatonomis,true,true);
			EmpleadoEstructuraConstantesFunciones.InicializarGeneralEntityAuxiliaresEmpleadoEstructuras(empleadoestructuras,true,true);
			HistorialPagoNomiConstantesFunciones.InicializarGeneralEntityAuxiliaresHistorialPagoNomis(historialpagonomis,true,true);
			AsistenciaDiariaConstantesFunciones.InicializarGeneralEntityAuxiliaresAsistenciaDiarias(asistenciadiarias,true,true);
			FuncionEstrucConstantesFunciones.InicializarGeneralEntityAuxiliaresFuncionEstrucs(funcionestrucs,true,true);
			SolicitudReemplazoConstantesFunciones.InicializarGeneralEntityAuxiliaresSolicitudReemplazos(solicitudreemplazos,true,true);
			SolicitudHoraExtraConstantesFunciones.InicializarGeneralEntityAuxiliaresSolicitudHoraExtras(solicitudhoraextras,true,true);
			EvaluacionNomiConstantesFunciones.InicializarGeneralEntityAuxiliaresEvaluacionNomis(evaluacionnomis,true,true);
			SolicitudVacacionConstantesFunciones.InicializarGeneralEntityAuxiliaresSolicitudVacacions(solicitudvacacions,true,true);
			ResponsableActivoFijoConstantesFunciones.InicializarGeneralEntityAuxiliaresResponsableActivoFijos(responsableactivofijos,true,true);
			RubroEmpleaCuentaContableConstantesFunciones.InicializarGeneralEntityAuxiliaresRubroEmpleaCuentaContables(rubroempleacuentacontables,true,true);

			if(conConexion){connexion.rollback();}
			Funciones.manageException(logger,e);
			throw e;

		} finally {
			if(conConexion){this.closeNewConnexionToDeep();}
		}
	}
	
	
	private void saveEstructuraRelacionesDetalles(List<CentroCostoEstructura> centrocostoestructuras,List<PlaniVacacion> planivacacionCargos,List<AsistenciaMensual> asistenciamensuals,List<EmpleadoProcesoRubro> empleadoprocesorubros,List<EmpleadoPagoRubro> empleadopagorubros,List<ProvisionEmpleado> provisionempleados,List<Empleado> empleados,List<Estructura> estructuras,List<EvaluacionEmpleado> evaluacionempleados,List<EmpleadoImpuestoRenta> empleadoimpuestorentas,List<RubroEstructura> rubroestructuras,List<CierreRolMensual> cierrerolmensuals,List<FormatoNomi> formatonomis,List<EmpleadoEstructura> empleadoestructuras,List<HistorialPagoNomi> historialpagonomis,List<AsistenciaDiaria> asistenciadiarias,List<FuncionEstruc> funcionestrucs,List<SolicitudReemplazo> solicitudreemplazos,List<SolicitudHoraExtra> solicitudhoraextras,List<EvaluacionNomi> evaluacionnomis,List<SolicitudVacacion> solicitudvacacions,List<ResponsableActivoFijo> responsableactivofijos,List<RubroEmpleaCuentaContable> rubroempleacuentacontables)throws Exception {
		try {
	

			Long idEstructuraActual=this.getEstructura().getId();

			CentroCostoEstructuraLogic centrocostoestructuraLogic_Desde_Estructura=new CentroCostoEstructuraLogic();
			centrocostoestructuraLogic_Desde_Estructura.setCentroCostoEstructuras(centrocostoestructuras);

			centrocostoestructuraLogic_Desde_Estructura.setConnexion(this.getConnexion());
			centrocostoestructuraLogic_Desde_Estructura.setDatosCliente(this.datosCliente);

			for(CentroCostoEstructura centrocostoestructura_Desde_Estructura:centrocostoestructuraLogic_Desde_Estructura.getCentroCostoEstructuras()) {
				centrocostoestructura_Desde_Estructura.setid_estructura(idEstructuraActual);
			}

			centrocostoestructuraLogic_Desde_Estructura.saveCentroCostoEstructuras();

			PlaniVacacionLogic planivacacionCargoLogic_Desde_Estructura=new PlaniVacacionLogic();
			planivacacionCargoLogic_Desde_Estructura.setPlaniVacacions(planivacacionCargos);

			planivacacionCargoLogic_Desde_Estructura.setConnexion(this.getConnexion());
			planivacacionCargoLogic_Desde_Estructura.setDatosCliente(this.datosCliente);

			for(PlaniVacacion planivacacion_Desde_Estructura:planivacacionCargoLogic_Desde_Estructura.getPlaniVacacions()) {
				planivacacion_Desde_Estructura.setid_estructura_cargo(idEstructuraActual);
			}

			planivacacionCargoLogic_Desde_Estructura.savePlaniVacacions();

			AsistenciaMensualLogic asistenciamensualLogic_Desde_Estructura=new AsistenciaMensualLogic();
			asistenciamensualLogic_Desde_Estructura.setAsistenciaMensuals(asistenciamensuals);

			asistenciamensualLogic_Desde_Estructura.setConnexion(this.getConnexion());
			asistenciamensualLogic_Desde_Estructura.setDatosCliente(this.datosCliente);

			for(AsistenciaMensual asistenciamensual_Desde_Estructura:asistenciamensualLogic_Desde_Estructura.getAsistenciaMensuals()) {
				asistenciamensual_Desde_Estructura.setid_estructura(idEstructuraActual);
			}

			asistenciamensualLogic_Desde_Estructura.saveAsistenciaMensuals();

			EmpleadoProcesoRubroLogic empleadoprocesorubroLogic_Desde_Estructura=new EmpleadoProcesoRubroLogic();
			empleadoprocesorubroLogic_Desde_Estructura.setEmpleadoProcesoRubros(empleadoprocesorubros);

			empleadoprocesorubroLogic_Desde_Estructura.setConnexion(this.getConnexion());
			empleadoprocesorubroLogic_Desde_Estructura.setDatosCliente(this.datosCliente);

			for(EmpleadoProcesoRubro empleadoprocesorubro_Desde_Estructura:empleadoprocesorubroLogic_Desde_Estructura.getEmpleadoProcesoRubros()) {
				empleadoprocesorubro_Desde_Estructura.setid_estructura(idEstructuraActual);
			}

			empleadoprocesorubroLogic_Desde_Estructura.saveEmpleadoProcesoRubros();

			EmpleadoPagoRubroLogic empleadopagorubroLogic_Desde_Estructura=new EmpleadoPagoRubroLogic();
			empleadopagorubroLogic_Desde_Estructura.setEmpleadoPagoRubros(empleadopagorubros);

			empleadopagorubroLogic_Desde_Estructura.setConnexion(this.getConnexion());
			empleadopagorubroLogic_Desde_Estructura.setDatosCliente(this.datosCliente);

			for(EmpleadoPagoRubro empleadopagorubro_Desde_Estructura:empleadopagorubroLogic_Desde_Estructura.getEmpleadoPagoRubros()) {
				empleadopagorubro_Desde_Estructura.setid_estructura(idEstructuraActual);
			}

			empleadopagorubroLogic_Desde_Estructura.saveEmpleadoPagoRubros();

			ProvisionEmpleadoLogic provisionempleadoLogic_Desde_Estructura=new ProvisionEmpleadoLogic();
			provisionempleadoLogic_Desde_Estructura.setProvisionEmpleados(provisionempleados);

			provisionempleadoLogic_Desde_Estructura.setConnexion(this.getConnexion());
			provisionempleadoLogic_Desde_Estructura.setDatosCliente(this.datosCliente);

			for(ProvisionEmpleado provisionempleado_Desde_Estructura:provisionempleadoLogic_Desde_Estructura.getProvisionEmpleados()) {
				provisionempleado_Desde_Estructura.setid_estructura(idEstructuraActual);
			}

			provisionempleadoLogic_Desde_Estructura.saveProvisionEmpleados();

			EmpleadoLogic empleadoLogic_Desde_Estructura=new EmpleadoLogic();
			empleadoLogic_Desde_Estructura.setEmpleados(empleados);

			empleadoLogic_Desde_Estructura.setConnexion(this.getConnexion());
			empleadoLogic_Desde_Estructura.setDatosCliente(this.datosCliente);

			for(Empleado empleado_Desde_Estructura:empleadoLogic_Desde_Estructura.getEmpleados()) {
				empleado_Desde_Estructura.setid_estructura(idEstructuraActual);

				empleadoLogic_Desde_Estructura.setEmpleado(empleado_Desde_Estructura);
				empleadoLogic_Desde_Estructura.saveEmpleado();
			}


			EstructuraLogic estructuraLogicHijos_Desde_Estructura=new EstructuraLogic();
			estructuraLogicHijos_Desde_Estructura.setEstructuras(estructuras);

			estructuraLogicHijos_Desde_Estructura.setConnexion(this.getConnexion());
			estructuraLogicHijos_Desde_Estructura.setDatosCliente(this.datosCliente);

			for(Estructura estructuraHijos_Desde_Estructura:estructuraLogicHijos_Desde_Estructura.getEstructuras()) {
				estructuraHijos_Desde_Estructura.setid_estructura(idEstructuraActual);

				estructuraLogicHijos_Desde_Estructura.setEstructura(estructuraHijos_Desde_Estructura);
				estructuraLogicHijos_Desde_Estructura.saveEstructura();
			}


			EvaluacionEmpleadoLogic evaluacionempleadoLogic_Desde_Estructura=new EvaluacionEmpleadoLogic();
			evaluacionempleadoLogic_Desde_Estructura.setEvaluacionEmpleados(evaluacionempleados);

			evaluacionempleadoLogic_Desde_Estructura.setConnexion(this.getConnexion());
			evaluacionempleadoLogic_Desde_Estructura.setDatosCliente(this.datosCliente);

			for(EvaluacionEmpleado evaluacionempleado_Desde_Estructura:evaluacionempleadoLogic_Desde_Estructura.getEvaluacionEmpleados()) {
				evaluacionempleado_Desde_Estructura.setid_estructura(idEstructuraActual);

				evaluacionempleadoLogic_Desde_Estructura.setEvaluacionEmpleado(evaluacionempleado_Desde_Estructura);
				evaluacionempleadoLogic_Desde_Estructura.saveEvaluacionEmpleado();

				Long idEvaluacionEmpleadoActual=evaluacionempleado_Desde_Estructura.getId();

				CalificacionEmpleadoLogic calificacionempleadoLogic_Desde_EvaluacionEmpleado=new CalificacionEmpleadoLogic();

				if(evaluacionempleado_Desde_Estructura.getCalificacionEmpleados()==null){
					evaluacionempleado_Desde_Estructura.setCalificacionEmpleados(new ArrayList<CalificacionEmpleado>());
				}

				calificacionempleadoLogic_Desde_EvaluacionEmpleado.setCalificacionEmpleados(evaluacionempleado_Desde_Estructura.getCalificacionEmpleados());

				calificacionempleadoLogic_Desde_EvaluacionEmpleado.setConnexion(this.getConnexion());
				calificacionempleadoLogic_Desde_EvaluacionEmpleado.setDatosCliente(this.datosCliente);

				for(CalificacionEmpleado calificacionempleado_Desde_EvaluacionEmpleado:calificacionempleadoLogic_Desde_EvaluacionEmpleado.getCalificacionEmpleados()) {
					calificacionempleado_Desde_EvaluacionEmpleado.setid_evaluacion_empleado(idEvaluacionEmpleadoActual);
				}

				calificacionempleadoLogic_Desde_EvaluacionEmpleado.saveCalificacionEmpleados();
			}


			EmpleadoImpuestoRentaLogic empleadoimpuestorentaLogic_Desde_Estructura=new EmpleadoImpuestoRentaLogic();
			empleadoimpuestorentaLogic_Desde_Estructura.setEmpleadoImpuestoRentas(empleadoimpuestorentas);

			empleadoimpuestorentaLogic_Desde_Estructura.setConnexion(this.getConnexion());
			empleadoimpuestorentaLogic_Desde_Estructura.setDatosCliente(this.datosCliente);

			for(EmpleadoImpuestoRenta empleadoimpuestorenta_Desde_Estructura:empleadoimpuestorentaLogic_Desde_Estructura.getEmpleadoImpuestoRentas()) {
				empleadoimpuestorenta_Desde_Estructura.setid_estructura(idEstructuraActual);
			}

			empleadoimpuestorentaLogic_Desde_Estructura.saveEmpleadoImpuestoRentas();

			RubroEstructuraLogic rubroestructuraLogic_Desde_Estructura=new RubroEstructuraLogic();
			rubroestructuraLogic_Desde_Estructura.setRubroEstructuras(rubroestructuras);

			rubroestructuraLogic_Desde_Estructura.setConnexion(this.getConnexion());
			rubroestructuraLogic_Desde_Estructura.setDatosCliente(this.datosCliente);

			for(RubroEstructura rubroestructura_Desde_Estructura:rubroestructuraLogic_Desde_Estructura.getRubroEstructuras()) {
				rubroestructura_Desde_Estructura.setid_estructura(idEstructuraActual);
			}

			rubroestructuraLogic_Desde_Estructura.saveRubroEstructuras();

			CierreRolMensualLogic cierrerolmensualLogic_Desde_Estructura=new CierreRolMensualLogic();
			cierrerolmensualLogic_Desde_Estructura.setCierreRolMensuals(cierrerolmensuals);

			cierrerolmensualLogic_Desde_Estructura.setConnexion(this.getConnexion());
			cierrerolmensualLogic_Desde_Estructura.setDatosCliente(this.datosCliente);

			for(CierreRolMensual cierrerolmensual_Desde_Estructura:cierrerolmensualLogic_Desde_Estructura.getCierreRolMensuals()) {
				cierrerolmensual_Desde_Estructura.setid_estructura(idEstructuraActual);
			}

			cierrerolmensualLogic_Desde_Estructura.saveCierreRolMensuals();

			FormatoNomiLogic formatonomiLogic_Desde_Estructura=new FormatoNomiLogic();
			formatonomiLogic_Desde_Estructura.setFormatoNomis(formatonomis);

			formatonomiLogic_Desde_Estructura.setConnexion(this.getConnexion());
			formatonomiLogic_Desde_Estructura.setDatosCliente(this.datosCliente);

			for(FormatoNomi formatonomi_Desde_Estructura:formatonomiLogic_Desde_Estructura.getFormatoNomis()) {
				formatonomi_Desde_Estructura.setid_estructura(idEstructuraActual);

				formatonomiLogic_Desde_Estructura.setFormatoNomi(formatonomi_Desde_Estructura);
				formatonomiLogic_Desde_Estructura.saveFormatoNomi();

				Long idFormatoNomiActual=formatonomi_Desde_Estructura.getId();

				FormatoNomiPreguntaNomiLogic formatonomipreguntanomiLogic_Desde_FormatoNomi=new FormatoNomiPreguntaNomiLogic();

				if(formatonomi_Desde_Estructura.getFormatoNomiPreguntaNomis()==null){
					formatonomi_Desde_Estructura.setFormatoNomiPreguntaNomis(new ArrayList<FormatoNomiPreguntaNomi>());
				}

				formatonomipreguntanomiLogic_Desde_FormatoNomi.setFormatoNomiPreguntaNomis(formatonomi_Desde_Estructura.getFormatoNomiPreguntaNomis());

				formatonomipreguntanomiLogic_Desde_FormatoNomi.setConnexion(this.getConnexion());
				formatonomipreguntanomiLogic_Desde_FormatoNomi.setDatosCliente(this.datosCliente);

				for(FormatoNomiPreguntaNomi formatonomipreguntanomi_Desde_FormatoNomi:formatonomipreguntanomiLogic_Desde_FormatoNomi.getFormatoNomiPreguntaNomis()) {
					formatonomipreguntanomi_Desde_FormatoNomi.setid_formato_nomi(idFormatoNomiActual);

					formatonomipreguntanomiLogic_Desde_FormatoNomi.setFormatoNomiPreguntaNomi(formatonomipreguntanomi_Desde_FormatoNomi);
					formatonomipreguntanomiLogic_Desde_FormatoNomi.saveFormatoNomiPreguntaNomi();

					Long idFormatoNomiPreguntaNomiActual=formatonomipreguntanomi_Desde_FormatoNomi.getId();

					CalificacionEmpleadoLogic calificacionempleadoLogic_Desde_FormatoNomiPreguntaNomi=new CalificacionEmpleadoLogic();

					if(formatonomipreguntanomi_Desde_FormatoNomi.getCalificacionEmpleados()==null){
						formatonomipreguntanomi_Desde_FormatoNomi.setCalificacionEmpleados(new ArrayList<CalificacionEmpleado>());
					}

					calificacionempleadoLogic_Desde_FormatoNomiPreguntaNomi.setCalificacionEmpleados(formatonomipreguntanomi_Desde_FormatoNomi.getCalificacionEmpleados());

					calificacionempleadoLogic_Desde_FormatoNomiPreguntaNomi.setConnexion(this.getConnexion());
					calificacionempleadoLogic_Desde_FormatoNomiPreguntaNomi.setDatosCliente(this.datosCliente);

					for(CalificacionEmpleado calificacionempleado_Desde_FormatoNomiPreguntaNomi:calificacionempleadoLogic_Desde_FormatoNomiPreguntaNomi.getCalificacionEmpleados()) {
						calificacionempleado_Desde_FormatoNomiPreguntaNomi.setid_formato_nomi_pregunta_nomi(idFormatoNomiPreguntaNomiActual);
					}

					calificacionempleadoLogic_Desde_FormatoNomiPreguntaNomi.saveCalificacionEmpleados();
				}


				FormatoNomiFactorNomiLogic formatonomifactornomiLogic_Desde_FormatoNomi=new FormatoNomiFactorNomiLogic();

				if(formatonomi_Desde_Estructura.getFormatoNomiFactorNomis()==null){
					formatonomi_Desde_Estructura.setFormatoNomiFactorNomis(new ArrayList<FormatoNomiFactorNomi>());
				}

				formatonomifactornomiLogic_Desde_FormatoNomi.setFormatoNomiFactorNomis(formatonomi_Desde_Estructura.getFormatoNomiFactorNomis());

				formatonomifactornomiLogic_Desde_FormatoNomi.setConnexion(this.getConnexion());
				formatonomifactornomiLogic_Desde_FormatoNomi.setDatosCliente(this.datosCliente);

				for(FormatoNomiFactorNomi formatonomifactornomi_Desde_FormatoNomi:formatonomifactornomiLogic_Desde_FormatoNomi.getFormatoNomiFactorNomis()) {
					formatonomifactornomi_Desde_FormatoNomi.setid_formato_nomi(idFormatoNomiActual);

					formatonomifactornomiLogic_Desde_FormatoNomi.setFormatoNomiFactorNomi(formatonomifactornomi_Desde_FormatoNomi);
					formatonomifactornomiLogic_Desde_FormatoNomi.saveFormatoNomiFactorNomi();

					Long idFormatoNomiFactorNomiActual=formatonomifactornomi_Desde_FormatoNomi.getId();

					CalificacionEmpleadoLogic calificacionempleadoLogic_Desde_FormatoNomiFactorNomi=new CalificacionEmpleadoLogic();

					if(formatonomifactornomi_Desde_FormatoNomi.getCalificacionEmpleados()==null){
						formatonomifactornomi_Desde_FormatoNomi.setCalificacionEmpleados(new ArrayList<CalificacionEmpleado>());
					}

					calificacionempleadoLogic_Desde_FormatoNomiFactorNomi.setCalificacionEmpleados(formatonomifactornomi_Desde_FormatoNomi.getCalificacionEmpleados());

					calificacionempleadoLogic_Desde_FormatoNomiFactorNomi.setConnexion(this.getConnexion());
					calificacionempleadoLogic_Desde_FormatoNomiFactorNomi.setDatosCliente(this.datosCliente);

					for(CalificacionEmpleado calificacionempleado_Desde_FormatoNomiFactorNomi:calificacionempleadoLogic_Desde_FormatoNomiFactorNomi.getCalificacionEmpleados()) {
						calificacionempleado_Desde_FormatoNomiFactorNomi.setid_formato_nomi_factor_nomi(idFormatoNomiFactorNomiActual);
					}

					calificacionempleadoLogic_Desde_FormatoNomiFactorNomi.saveCalificacionEmpleados();
				}


				EvaluacionNomiLogic evaluacionnomiLogic_Desde_FormatoNomi=new EvaluacionNomiLogic();

				if(formatonomi_Desde_Estructura.getEvaluacionNomis()==null){
					formatonomi_Desde_Estructura.setEvaluacionNomis(new ArrayList<EvaluacionNomi>());
				}

				evaluacionnomiLogic_Desde_FormatoNomi.setEvaluacionNomis(formatonomi_Desde_Estructura.getEvaluacionNomis());

				evaluacionnomiLogic_Desde_FormatoNomi.setConnexion(this.getConnexion());
				evaluacionnomiLogic_Desde_FormatoNomi.setDatosCliente(this.datosCliente);

				for(EvaluacionNomi evaluacionnomi_Desde_FormatoNomi:evaluacionnomiLogic_Desde_FormatoNomi.getEvaluacionNomis()) {
					evaluacionnomi_Desde_FormatoNomi.setid_formato_nomi(idFormatoNomiActual);

					evaluacionnomiLogic_Desde_FormatoNomi.setEvaluacionNomi(evaluacionnomi_Desde_FormatoNomi);
					evaluacionnomiLogic_Desde_FormatoNomi.saveEvaluacionNomi();
				}


				DetalleEvaluacionNomiLogic detalleevaluacionnomiLogic_Desde_FormatoNomi=new DetalleEvaluacionNomiLogic();

				if(formatonomi_Desde_Estructura.getDetalleEvaluacionNomis()==null){
					formatonomi_Desde_Estructura.setDetalleEvaluacionNomis(new ArrayList<DetalleEvaluacionNomi>());
				}

				detalleevaluacionnomiLogic_Desde_FormatoNomi.setDetalleEvaluacionNomis(formatonomi_Desde_Estructura.getDetalleEvaluacionNomis());

				detalleevaluacionnomiLogic_Desde_FormatoNomi.setConnexion(this.getConnexion());
				detalleevaluacionnomiLogic_Desde_FormatoNomi.setDatosCliente(this.datosCliente);

				for(DetalleEvaluacionNomi detalleevaluacionnomi_Desde_FormatoNomi:detalleevaluacionnomiLogic_Desde_FormatoNomi.getDetalleEvaluacionNomis()) {
					detalleevaluacionnomi_Desde_FormatoNomi.setid_formato_nomi(idFormatoNomiActual);
				}

				detalleevaluacionnomiLogic_Desde_FormatoNomi.saveDetalleEvaluacionNomis();
			}


			EmpleadoEstructuraLogic empleadoestructuraLogic_Desde_Estructura=new EmpleadoEstructuraLogic();
			empleadoestructuraLogic_Desde_Estructura.setEmpleadoEstructuras(empleadoestructuras);

			empleadoestructuraLogic_Desde_Estructura.setConnexion(this.getConnexion());
			empleadoestructuraLogic_Desde_Estructura.setDatosCliente(this.datosCliente);

			for(EmpleadoEstructura empleadoestructura_Desde_Estructura:empleadoestructuraLogic_Desde_Estructura.getEmpleadoEstructuras()) {
				empleadoestructura_Desde_Estructura.setid_estructura(idEstructuraActual);
			}

			empleadoestructuraLogic_Desde_Estructura.saveEmpleadoEstructuras();

			HistorialPagoNomiLogic historialpagonomiLogic_Desde_Estructura=new HistorialPagoNomiLogic();
			historialpagonomiLogic_Desde_Estructura.setHistorialPagoNomis(historialpagonomis);

			historialpagonomiLogic_Desde_Estructura.setConnexion(this.getConnexion());
			historialpagonomiLogic_Desde_Estructura.setDatosCliente(this.datosCliente);

			for(HistorialPagoNomi historialpagonomi_Desde_Estructura:historialpagonomiLogic_Desde_Estructura.getHistorialPagoNomis()) {
				historialpagonomi_Desde_Estructura.setid_estructura(idEstructuraActual);
			}

			historialpagonomiLogic_Desde_Estructura.saveHistorialPagoNomis();

			AsistenciaDiariaLogic asistenciadiariaLogic_Desde_Estructura=new AsistenciaDiariaLogic();
			asistenciadiariaLogic_Desde_Estructura.setAsistenciaDiarias(asistenciadiarias);

			asistenciadiariaLogic_Desde_Estructura.setConnexion(this.getConnexion());
			asistenciadiariaLogic_Desde_Estructura.setDatosCliente(this.datosCliente);

			for(AsistenciaDiaria asistenciadiaria_Desde_Estructura:asistenciadiariaLogic_Desde_Estructura.getAsistenciaDiarias()) {
				asistenciadiaria_Desde_Estructura.setid_estructura(idEstructuraActual);
			}

			asistenciadiariaLogic_Desde_Estructura.saveAsistenciaDiarias();

			FuncionEstrucLogic funcionestrucLogic_Desde_Estructura=new FuncionEstrucLogic();
			funcionestrucLogic_Desde_Estructura.setFuncionEstrucs(funcionestrucs);

			funcionestrucLogic_Desde_Estructura.setConnexion(this.getConnexion());
			funcionestrucLogic_Desde_Estructura.setDatosCliente(this.datosCliente);

			for(FuncionEstruc funcionestruc_Desde_Estructura:funcionestrucLogic_Desde_Estructura.getFuncionEstrucs()) {
				funcionestruc_Desde_Estructura.setid_estructura(idEstructuraActual);
			}

			funcionestrucLogic_Desde_Estructura.saveFuncionEstrucs();

			SolicitudReemplazoLogic solicitudreemplazoLogic_Desde_Estructura=new SolicitudReemplazoLogic();
			solicitudreemplazoLogic_Desde_Estructura.setSolicitudReemplazos(solicitudreemplazos);

			solicitudreemplazoLogic_Desde_Estructura.setConnexion(this.getConnexion());
			solicitudreemplazoLogic_Desde_Estructura.setDatosCliente(this.datosCliente);

			for(SolicitudReemplazo solicitudreemplazo_Desde_Estructura:solicitudreemplazoLogic_Desde_Estructura.getSolicitudReemplazos()) {
				solicitudreemplazo_Desde_Estructura.setid_estructura(idEstructuraActual);
			}

			solicitudreemplazoLogic_Desde_Estructura.saveSolicitudReemplazos();

			SolicitudHoraExtraLogic solicitudhoraextraLogic_Desde_Estructura=new SolicitudHoraExtraLogic();
			solicitudhoraextraLogic_Desde_Estructura.setSolicitudHoraExtras(solicitudhoraextras);

			solicitudhoraextraLogic_Desde_Estructura.setConnexion(this.getConnexion());
			solicitudhoraextraLogic_Desde_Estructura.setDatosCliente(this.datosCliente);

			for(SolicitudHoraExtra solicitudhoraextra_Desde_Estructura:solicitudhoraextraLogic_Desde_Estructura.getSolicitudHoraExtras()) {
				solicitudhoraextra_Desde_Estructura.setid_estructura(idEstructuraActual);
			}

			solicitudhoraextraLogic_Desde_Estructura.saveSolicitudHoraExtras();

			EvaluacionNomiLogic evaluacionnomiLogic_Desde_Estructura=new EvaluacionNomiLogic();
			evaluacionnomiLogic_Desde_Estructura.setEvaluacionNomis(evaluacionnomis);

			evaluacionnomiLogic_Desde_Estructura.setConnexion(this.getConnexion());
			evaluacionnomiLogic_Desde_Estructura.setDatosCliente(this.datosCliente);

			for(EvaluacionNomi evaluacionnomi_Desde_Estructura:evaluacionnomiLogic_Desde_Estructura.getEvaluacionNomis()) {
				evaluacionnomi_Desde_Estructura.setid_estructura(idEstructuraActual);

				evaluacionnomiLogic_Desde_Estructura.setEvaluacionNomi(evaluacionnomi_Desde_Estructura);
				evaluacionnomiLogic_Desde_Estructura.saveEvaluacionNomi();
			}


			SolicitudVacacionLogic solicitudvacacionLogic_Desde_Estructura=new SolicitudVacacionLogic();
			solicitudvacacionLogic_Desde_Estructura.setSolicitudVacacions(solicitudvacacions);

			solicitudvacacionLogic_Desde_Estructura.setConnexion(this.getConnexion());
			solicitudvacacionLogic_Desde_Estructura.setDatosCliente(this.datosCliente);

			for(SolicitudVacacion solicitudvacacion_Desde_Estructura:solicitudvacacionLogic_Desde_Estructura.getSolicitudVacacions()) {
				solicitudvacacion_Desde_Estructura.setid_estructura(idEstructuraActual);
			}

			solicitudvacacionLogic_Desde_Estructura.saveSolicitudVacacions();

			ResponsableActivoFijoLogic responsableactivofijoLogic_Desde_Estructura=new ResponsableActivoFijoLogic();
			responsableactivofijoLogic_Desde_Estructura.setResponsableActivoFijos(responsableactivofijos);

			responsableactivofijoLogic_Desde_Estructura.setConnexion(this.getConnexion());
			responsableactivofijoLogic_Desde_Estructura.setDatosCliente(this.datosCliente);

			for(ResponsableActivoFijo responsableactivofijo_Desde_Estructura:responsableactivofijoLogic_Desde_Estructura.getResponsableActivoFijos()) {
				responsableactivofijo_Desde_Estructura.setid_estructura(idEstructuraActual);
			}

			responsableactivofijoLogic_Desde_Estructura.saveResponsableActivoFijos();

			RubroEmpleaCuentaContableLogic rubroempleacuentacontableLogic_Desde_Estructura=new RubroEmpleaCuentaContableLogic();
			rubroempleacuentacontableLogic_Desde_Estructura.setRubroEmpleaCuentaContables(rubroempleacuentacontables);

			rubroempleacuentacontableLogic_Desde_Estructura.setConnexion(this.getConnexion());
			rubroempleacuentacontableLogic_Desde_Estructura.setDatosCliente(this.datosCliente);

			for(RubroEmpleaCuentaContable rubroempleacuentacontable_Desde_Estructura:rubroempleacuentacontableLogic_Desde_Estructura.getRubroEmpleaCuentaContables()) {
				rubroempleacuentacontable_Desde_Estructura.setid_estructura(idEstructuraActual);
			}

			rubroempleacuentacontableLogic_Desde_Estructura.saveRubroEmpleaCuentaContables();

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfEstructura(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=EstructuraConstantesFunciones.getClassesForeignKeysOfEstructura(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfEstructura(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=EstructuraConstantesFunciones.getClassesRelationshipsOfEstructura(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

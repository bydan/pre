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
import com.bydan.erp.seguridad.util.ContinenteConstantesFunciones;
import com.bydan.erp.seguridad.util.ContinenteParameterReturnGeneral;
//import com.bydan.erp.seguridad.util.ContinenteParameterGeneral;
import com.bydan.erp.seguridad.business.entity.Continente;
import com.bydan.erp.seguridad.business.logic.ContinenteLogicAdditional;
import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.seguridad.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.activosfijos.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;


import com.bydan.erp.nomina.business.logic.*;
import com.bydan.erp.seguridad.business.logic.*;
import com.bydan.erp.contabilidad.business.logic.*;
import com.bydan.erp.inventario.business.logic.*;
import com.bydan.erp.activosfijos.business.logic.*;
import com.bydan.erp.cartera.business.logic.*;


import com.bydan.erp.nomina.util.*;
import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.inventario.util.*;
import com.bydan.erp.activosfijos.util.*;
import com.bydan.erp.cartera.util.*;


import com.bydan.erp.nomina.business.dataaccess.*;
import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;
import com.bydan.erp.inventario.business.dataaccess.*;
import com.bydan.erp.activosfijos.business.dataaccess.*;
import com.bydan.erp.cartera.business.dataaccess.*;








@SuppressWarnings("unused")
public class ContinenteLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(ContinenteLogic.class);
	
	protected ContinenteDataAccess continenteDataAccess; 	
	protected Continente continente;
	protected List<Continente> continentes;
	protected Object continenteObject;	
	protected List<Object> continentesObject;
	
	public static ClassValidator<Continente> continenteValidator = new ClassValidator<Continente>(Continente.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected ContinenteLogicAdditional continenteLogicAdditional=null;
	
	public ContinenteLogicAdditional getContinenteLogicAdditional() {
		return this.continenteLogicAdditional;
	}
	
	public void setContinenteLogicAdditional(ContinenteLogicAdditional continenteLogicAdditional) {
		try {
			this.continenteLogicAdditional=continenteLogicAdditional;
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
	
	
	
	
	public  ContinenteLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.continenteDataAccess = new ContinenteDataAccess();
			
			this.continentes= new ArrayList<Continente>();
			this.continente= new Continente();
			
			this.continenteObject=new Object();
			this.continentesObject=new ArrayList<Object>();
				
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
			
			this.continenteDataAccess.setConnexionType(this.connexionType);
			this.continenteDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  ContinenteLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.continenteDataAccess = new ContinenteDataAccess();
			this.continentes= new ArrayList<Continente>();
			this.continente= new Continente();
			this.continenteObject=new Object();
			this.continentesObject=new ArrayList<Object>();
			
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
			
			this.continenteDataAccess.setConnexionType(this.connexionType);
			this.continenteDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public Continente getContinente() throws Exception {	
		ContinenteLogicAdditional.checkContinenteToGet(continente,this.datosCliente,this.arrDatoGeneral);
		ContinenteLogicAdditional.updateContinenteToGet(continente,this.arrDatoGeneral);
		
		return continente;
	}
		
	public void setContinente(Continente newContinente) {
		this.continente = newContinente;
	}
	
	public ContinenteDataAccess getContinenteDataAccess() {
		return continenteDataAccess;
	}
	
	public void setContinenteDataAccess(ContinenteDataAccess newcontinenteDataAccess) {
		this.continenteDataAccess = newcontinenteDataAccess;
	}
	
	public List<Continente> getContinentes() throws Exception {		
		this.quitarContinentesNulos();
		
		ContinenteLogicAdditional.checkContinenteToGets(continentes,this.datosCliente,this.arrDatoGeneral);
		
		for (Continente continenteLocal: continentes ) {
			ContinenteLogicAdditional.updateContinenteToGet(continenteLocal,this.arrDatoGeneral);
		}
		
		return continentes;
	}
	
	public void setContinentes(List<Continente> newContinentes) {
		this.continentes = newContinentes;
	}
	
	public Object getContinenteObject() {	
		this.continenteObject=this.continenteDataAccess.getEntityObject();
		return this.continenteObject;
	}
		
	public void setContinenteObject(Object newContinenteObject) {
		this.continenteObject = newContinenteObject;
	}
	
	public List<Object> getContinentesObject() {		
		this.continentesObject=this.continenteDataAccess.getEntitiesObject();
		return this.continentesObject;
	}
		
	public void setContinentesObject(List<Object> newContinentesObject) {
		this.continentesObject = newContinentesObject;
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
		
		if(this.continenteDataAccess!=null) {
			this.continenteDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Continente.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			continenteDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			continenteDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		continente = new  Continente();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Continente.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			continente=continenteDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.continente,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ContinenteConstantesFunciones.refrescarForeignKeysDescripcionesContinente(this.continente);
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
		continente = new  Continente();
		  		  
        try {
			
			continente=continenteDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.continente,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ContinenteConstantesFunciones.refrescarForeignKeysDescripcionesContinente(this.continente);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		continente = new  Continente();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Continente.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			continente=continenteDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.continente,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ContinenteConstantesFunciones.refrescarForeignKeysDescripcionesContinente(this.continente);
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
		continente = new  Continente();
		  		  
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
		continente = new  Continente();
		  		  
        try {
			
			continente=continenteDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.continente,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ContinenteConstantesFunciones.refrescarForeignKeysDescripcionesContinente(this.continente);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		continente = new  Continente();
		  		  
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
		continente = new  Continente();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Continente.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =continenteDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		continente = new  Continente();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=continenteDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		continente = new  Continente();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Continente.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =continenteDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		continente = new  Continente();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=continenteDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		continente = new  Continente();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Continente.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =continenteDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		continente = new  Continente();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=continenteDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		continentes = new  ArrayList<Continente>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Continente.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			ContinenteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			continentes=continenteDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarContinente(continentes);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ContinenteConstantesFunciones.refrescarForeignKeysDescripcionesContinente(this.continentes);
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
		continentes = new  ArrayList<Continente>();
		  		  
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
		continentes = new  ArrayList<Continente>();
		  		  
        try {			
			ContinenteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			continentes=continenteDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarContinente(continentes);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ContinenteConstantesFunciones.refrescarForeignKeysDescripcionesContinente(this.continentes);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		continentes = new  ArrayList<Continente>();
		  		  
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
		continentes = new  ArrayList<Continente>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Continente.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			ContinenteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			continentes=continenteDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarContinente(continentes);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ContinenteConstantesFunciones.refrescarForeignKeysDescripcionesContinente(this.continentes);
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
		continentes = new  ArrayList<Continente>();
		  		  
        try {
			ContinenteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			continentes=continenteDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarContinente(continentes);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ContinenteConstantesFunciones.refrescarForeignKeysDescripcionesContinente(this.continentes);
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
		continentes = new  ArrayList<Continente>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Continente.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ContinenteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			continentes=continenteDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarContinente(continentes);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ContinenteConstantesFunciones.refrescarForeignKeysDescripcionesContinente(this.continentes);
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
		continentes = new  ArrayList<Continente>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ContinenteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			continentes=continenteDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarContinente(continentes);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ContinenteConstantesFunciones.refrescarForeignKeysDescripcionesContinente(this.continentes);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		continente = new  Continente();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Continente.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ContinenteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			continente=continenteDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarContinente(continente);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ContinenteConstantesFunciones.refrescarForeignKeysDescripcionesContinente(this.continente);
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
		continente = new  Continente();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ContinenteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			continente=continenteDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarContinente(continente);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ContinenteConstantesFunciones.refrescarForeignKeysDescripcionesContinente(this.continente);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		continentes = new  ArrayList<Continente>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Continente.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			ContinenteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			continentes=continenteDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarContinente(continentes);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ContinenteConstantesFunciones.refrescarForeignKeysDescripcionesContinente(this.continentes);
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
		continentes = new  ArrayList<Continente>();
		  		  
        try {
			ContinenteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			continentes=continenteDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarContinente(continentes);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ContinenteConstantesFunciones.refrescarForeignKeysDescripcionesContinente(this.continentes);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosContinentesWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		continentes = new  ArrayList<Continente>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Continente.class.getSimpleName()+"-getTodosContinentesWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ContinenteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			continentes=continenteDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarContinente(continentes);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ContinenteConstantesFunciones.refrescarForeignKeysDescripcionesContinente(this.continentes);
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
	
	public  void  getTodosContinentes(String sFinalQuery,Pagination pagination)throws Exception {
		continentes = new  ArrayList<Continente>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ContinenteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			continentes=continenteDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarContinente(continentes);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ContinenteConstantesFunciones.refrescarForeignKeysDescripcionesContinente(this.continentes);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarContinente(Continente continente) throws Exception {
		Boolean estaValidado=false;
		
		if(continente.getIsNew() || continente.getIsChanged()) { 
			this.invalidValues = continenteValidator.getInvalidValues(continente);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(continente);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarContinente(List<Continente> Continentes) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(Continente continenteLocal:continentes) {				
			estaValidadoObjeto=this.validarGuardarContinente(continenteLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarContinente(List<Continente> Continentes) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarContinente(continentes)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarContinente(Continente Continente) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarContinente(continente)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(Continente continente) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+continente.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=ContinenteConstantesFunciones.getContinenteLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"continente","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(ContinenteConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(ContinenteConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveContinenteWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Continente.class.getSimpleName()+"-saveContinenteWithConnection");connexion.begin();			
			
			ContinenteLogicAdditional.checkContinenteToSave(this.continente,this.datosCliente,connexion,this.arrDatoGeneral);
			
			ContinenteLogicAdditional.updateContinenteToSave(this.continente,this.arrDatoGeneral);
			
			ContinenteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.continente,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowContinente();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarContinente(this.continente)) {
				ContinenteDataAccess.save(this.continente, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.continente,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			ContinenteLogicAdditional.checkContinenteToSaveAfter(this.continente,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowContinente();
			
			connexion.commit();			
			
			if(this.continente.getIsDeleted()) {
				this.continente=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveContinente()throws Exception {	
		try {	
			
			ContinenteLogicAdditional.checkContinenteToSave(this.continente,this.datosCliente,connexion,this.arrDatoGeneral);
			
			ContinenteLogicAdditional.updateContinenteToSave(this.continente,this.arrDatoGeneral);
			
			ContinenteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.continente,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarContinente(this.continente)) {			
				ContinenteDataAccess.save(this.continente, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.continente,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			ContinenteLogicAdditional.checkContinenteToSaveAfter(this.continente,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.continente.getIsDeleted()) {
				this.continente=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveContinentesWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Continente.class.getSimpleName()+"-saveContinentesWithConnection");connexion.begin();			
			
			ContinenteLogicAdditional.checkContinenteToSaves(continentes,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowContinentes();
			
			Boolean validadoTodosContinente=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(Continente continenteLocal:continentes) {		
				if(continenteLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				ContinenteLogicAdditional.updateContinenteToSave(continenteLocal,this.arrDatoGeneral);
	        	
				ContinenteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),continenteLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarContinente(continenteLocal)) {
					ContinenteDataAccess.save(continenteLocal, connexion);				
				} else {
					validadoTodosContinente=false;
				}
			}
			
			if(!validadoTodosContinente) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			ContinenteLogicAdditional.checkContinenteToSavesAfter(continentes,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowContinentes();
			
			connexion.commit();		
			
			this.quitarContinentesEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveContinentes()throws Exception {				
		 try {	
			ContinenteLogicAdditional.checkContinenteToSaves(continentes,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosContinente=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(Continente continenteLocal:continentes) {				
				if(continenteLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				ContinenteLogicAdditional.updateContinenteToSave(continenteLocal,this.arrDatoGeneral);
	        	
				ContinenteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),continenteLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarContinente(continenteLocal)) {				
					ContinenteDataAccess.save(continenteLocal, connexion);				
				} else {
					validadoTodosContinente=false;
				}
			}
			
			if(!validadoTodosContinente) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			ContinenteLogicAdditional.checkContinenteToSavesAfter(continentes,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarContinentesEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public ContinenteParameterReturnGeneral procesarAccionContinentes(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<Continente> continentes,ContinenteParameterReturnGeneral continenteParameterGeneral)throws Exception {
		 try {	
			ContinenteParameterReturnGeneral continenteReturnGeneral=new ContinenteParameterReturnGeneral();
	
			ContinenteLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,continentes,continenteParameterGeneral,continenteReturnGeneral);
			
			return continenteReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public ContinenteParameterReturnGeneral procesarAccionContinentesWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<Continente> continentes,ContinenteParameterReturnGeneral continenteParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Continente.class.getSimpleName()+"-procesarAccionContinentesWithConnection");connexion.begin();			
			
			ContinenteParameterReturnGeneral continenteReturnGeneral=new ContinenteParameterReturnGeneral();
	
			ContinenteLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,continentes,continenteParameterGeneral,continenteReturnGeneral);
			
			this.connexion.commit();
			
			return continenteReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public ContinenteParameterReturnGeneral procesarEventosContinentes(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<Continente> continentes,Continente continente,ContinenteParameterReturnGeneral continenteParameterGeneral,Boolean isEsNuevoContinente,ArrayList<Classe> clases)throws Exception {
		 try {	
			ContinenteParameterReturnGeneral continenteReturnGeneral=new ContinenteParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				continenteReturnGeneral.setConRecargarPropiedades(true);
			}
			
			ContinenteLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,continentes,continente,continenteParameterGeneral,continenteReturnGeneral,isEsNuevoContinente,clases);
			
			return continenteReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public ContinenteParameterReturnGeneral procesarEventosContinentesWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<Continente> continentes,Continente continente,ContinenteParameterReturnGeneral continenteParameterGeneral,Boolean isEsNuevoContinente,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Continente.class.getSimpleName()+"-procesarEventosContinentesWithConnection");connexion.begin();			
			
			ContinenteParameterReturnGeneral continenteReturnGeneral=new ContinenteParameterReturnGeneral();
	
			continenteReturnGeneral.setContinente(continente);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				continenteReturnGeneral.setConRecargarPropiedades(true);
			}
			
			ContinenteLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,continentes,continente,continenteParameterGeneral,continenteReturnGeneral,isEsNuevoContinente,clases);
			
			this.connexion.commit();
			
			return continenteReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public ContinenteParameterReturnGeneral procesarImportacionContinentesWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,ContinenteParameterReturnGeneral continenteParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Continente.class.getSimpleName()+"-procesarImportacionContinentesWithConnection");connexion.begin();			
			
			ContinenteParameterReturnGeneral continenteReturnGeneral=new ContinenteParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.continentes=new ArrayList<Continente>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.continente=new Continente();
				
				
				if(conColumnasBase) {this.continente.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.continente.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.continente.setcodigo(arrColumnas[iColumn++]);
				this.continente.setnombre(arrColumnas[iColumn++]);
				
				this.continentes.add(this.continente);
			}
			
			this.saveContinentes();
			
			this.connexion.commit();
			
			continenteReturnGeneral.setConRetornoEstaProcesado(true);
			continenteReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return continenteReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarContinentesEliminados() throws Exception {				
		
		List<Continente> continentesAux= new ArrayList<Continente>();
		
		for(Continente continente:continentes) {
			if(!continente.getIsDeleted()) {
				continentesAux.add(continente);
			}
		}
		
		continentes=continentesAux;
	}
	
	public void quitarContinentesNulos() throws Exception {				
		
		List<Continente> continentesAux= new ArrayList<Continente>();
		
		for(Continente continente : this.continentes) {
			if(continente==null) {
				continentesAux.add(continente);
			}
		}
		
		//this.continentes=continentesAux;
		
		this.continentes.removeAll(continentesAux);
	}
	
	public void getSetVersionRowContinenteWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(continente.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((continente.getIsDeleted() || (continente.getIsChanged()&&!continente.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=continenteDataAccess.getSetVersionRowContinente(connexion,continente.getId());
				
				if(!continente.getVersionRow().equals(timestamp)) {	
					continente.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				continente.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowContinente()throws Exception {	
		
		if(continente.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((continente.getIsDeleted() || (continente.getIsChanged()&&!continente.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=continenteDataAccess.getSetVersionRowContinente(connexion,continente.getId());
			
			try {							
				if(!continente.getVersionRow().equals(timestamp)) {	
					continente.setVersionRow(timestamp);
				}
				
				continente.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowContinentesWithConnection()throws Exception {	
		if(continentes!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(Continente continenteAux:continentes) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(continenteAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(continenteAux.getIsDeleted() || (continenteAux.getIsChanged()&&!continenteAux.getIsNew())) {
						
						timestamp=continenteDataAccess.getSetVersionRowContinente(connexion,continenteAux.getId());
						
						if(!continente.getVersionRow().equals(timestamp)) {	
							continenteAux.setVersionRow(timestamp);
						}
								
						continenteAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowContinentes()throws Exception {	
		if(continentes!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(Continente continenteAux:continentes) {
					if(continenteAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(continenteAux.getIsDeleted() || (continenteAux.getIsChanged()&&!continenteAux.getIsNew())) {
						
						timestamp=continenteDataAccess.getSetVersionRowContinente(connexion,continenteAux.getId());
						
						if(!continenteAux.getVersionRow().equals(timestamp)) {	
							continenteAux.setVersionRow(timestamp);
						}
						
													
						continenteAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	
	public void cargarRelacionesLoteForeignKeyContinenteWithConnection() throws Exception {
		ArrayList<Classe> classes=new ArrayList<Classe>();		
		
		
			PaisLogic paisLogic=new PaisLogic();
		
		try {
			
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Continente.class.getSimpleName()+"-cargarRelacionesLoteForeignKeyContinenteWithConnection");connexion.begin();
			
			
			classes.add(new Classe(Pais.class));
											
			

			paisLogic.setConnexion(this.getConnexion());
			paisLogic.setDatosCliente(this.datosCliente);
			paisLogic.setIsConRefrescarForeignKeys(true);
			
			this.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
			
			for(Continente continente:this.continentes) {
				

				classes=new ArrayList<Classe>();
				classes=PaisConstantesFunciones.getClassesForeignKeysOfPais(new ArrayList<Classe>(),DeepLoadType.NONE);

				paisLogic.setPaiss(continente.paiss);
				paisLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
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
	
	public void deepLoad(Continente continente,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			ContinenteLogicAdditional.updateContinenteToGet(continente,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		continente.setPaiss(continenteDataAccess.getPaiss(connexion,continente));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Pais.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				continente.setPaiss(continenteDataAccess.getPaiss(connexion,continente));

				if(this.isConDeep) {
					PaisLogic paisLogic= new PaisLogic(this.connexion);
					paisLogic.setPaiss(continente.getPaiss());
					ArrayList<Classe> classesLocal=PaisConstantesFunciones.getClassesForeignKeysOfPais(new ArrayList<Classe>(),DeepLoadType.NONE);
					paisLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					PaisConstantesFunciones.refrescarForeignKeysDescripcionesPais(paisLogic.getPaiss());
					continente.setPaiss(paisLogic.getPaiss());
				}

				continue;
			}
		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {


		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Pais.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(Pais.class));
			continente.setPaiss(continenteDataAccess.getPaiss(connexion,continente));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {


		continente.setPaiss(continenteDataAccess.getPaiss(connexion,continente));

		for(Pais pais:continente.getPaiss()) {
			PaisLogic paisLogic= new PaisLogic(connexion);
			paisLogic.deepLoad(pais,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Pais.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				continente.setPaiss(continenteDataAccess.getPaiss(connexion,continente));

				for(Pais pais:continente.getPaiss()) {
					PaisLogic paisLogic= new PaisLogic(connexion);
					paisLogic.deepLoad(pais,isDeep,deepLoadType,clases);
				}
				continue;
			}

		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {


		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Pais.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(Pais.class));
			continente.setPaiss(continenteDataAccess.getPaiss(connexion,continente));

			for(Pais pais:continente.getPaiss()) {
				PaisLogic paisLogic= new PaisLogic(connexion);
				paisLogic.deepLoad(pais,isDeep,deepLoadType,clases);
			}
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(Continente continente,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			ContinenteLogicAdditional.updateContinenteToSave(continente,this.arrDatoGeneral);
			
ContinenteDataAccess.save(continente, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		for(Pais pais:continente.getPaiss()) {
			pais.setid_continente(continente.getId());
			PaisDataAccess.save(pais,connexion);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {

			if(clas.clas.equals(Pais.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(Pais pais:continente.getPaiss()) {
					pais.setid_continente(continente.getId());
					PaisDataAccess.save(pais,connexion);
				}
				continue;
			}
		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		for(Pais pais:continente.getPaiss()) {
			PaisLogic paisLogic= new PaisLogic(connexion);
			pais.setid_continente(continente.getId());
			PaisDataAccess.save(pais,connexion);
			paisLogic.deepSave(pais,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {

			if(clas.clas.equals(Pais.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(Pais pais:continente.getPaiss()) {
					PaisLogic paisLogic= new PaisLogic(connexion);
					pais.setid_continente(continente.getId());
					PaisDataAccess.save(pais,connexion);
					paisLogic.deepSave(pais,isDeep,deepLoadType,clases);
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
			this.getNewConnexionToDeep(Continente.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(continente,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				ContinenteConstantesFunciones.refrescarForeignKeysDescripcionesContinente(continente);
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
			this.deepLoad(this.continente,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				ContinenteConstantesFunciones.refrescarForeignKeysDescripcionesContinente(this.continente);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(Continente.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(continentes!=null) {
				for(Continente continente:continentes) {
					this.deepLoad(continente,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					ContinenteConstantesFunciones.refrescarForeignKeysDescripcionesContinente(continentes);
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
			if(continentes!=null) {
				for(Continente continente:continentes) {
					this.deepLoad(continente,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					ContinenteConstantesFunciones.refrescarForeignKeysDescripcionesContinente(continentes);
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
			this.getNewConnexionToDeep(Continente.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(continente,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(Continente.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(continentes!=null) {
				for(Continente continente:continentes) {
					this.deepSave(continente,isDeep,deepLoadType,clases);
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
			if(continentes!=null) {
				for(Continente continente:continentes) {
					this.deepSave(continente,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getContinentePorNombreWithConnection(String nombre)throws Exception {
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Continente.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			ParameterSelectionGeneral parameterSelectionGeneralNombre= new ParameterSelectionGeneral();
			parameterSelectionGeneralNombre.setParameterSelectionGeneralEqual(ParameterType.STRING,nombre,ContinenteConstantesFunciones.NOMBRE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNombre);

			continente=continenteDataAccess.getEntity(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoad(this.continente,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());

				ContinenteConstantesFunciones.refrescarForeignKeysDescripcionesContinente(this.continente);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getContinentePorNombre(String nombre)throws Exception {
		try {

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			ParameterSelectionGeneral parameterSelectionGeneralNombre= new ParameterSelectionGeneral();
			parameterSelectionGeneralNombre.setParameterSelectionGeneralEqual(ParameterType.STRING,nombre,ContinenteConstantesFunciones.NOMBRE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNombre);

			continente=continenteDataAccess.getEntity(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoad(this.continente,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());

				ContinenteConstantesFunciones.refrescarForeignKeysDescripcionesContinente(this.continente);
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
			if(ContinenteConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,ContinenteDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,Continente continente,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(ContinenteConstantesFunciones.ISCONAUDITORIA) {
				if(continente.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,ContinenteDataAccess.TABLENAME, continente.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(ContinenteConstantesFunciones.ISCONAUDITORIADETALLE) {
						////ContinenteLogic.registrarAuditoriaDetallesContinente(connexion,continente,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(continente.getIsDeleted()) {
					/*if(!continente.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,ContinenteDataAccess.TABLENAME, continente.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////ContinenteLogic.registrarAuditoriaDetallesContinente(connexion,continente,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,ContinenteDataAccess.TABLENAME, continente.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(continente.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,ContinenteDataAccess.TABLENAME, continente.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(ContinenteConstantesFunciones.ISCONAUDITORIADETALLE) {
						////ContinenteLogic.registrarAuditoriaDetallesContinente(connexion,continente,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesContinente(Connexion connexion,Continente continente)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(continente.getIsNew()||!continente.getcodigo().equals(continente.getContinenteOriginal().getcodigo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(continente.getContinenteOriginal().getcodigo()!=null)
				{
					strValorActual=continente.getContinenteOriginal().getcodigo();
				}
				if(continente.getcodigo()!=null)
				{
					strValorNuevo=continente.getcodigo() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ContinenteConstantesFunciones.CODIGO,strValorActual,strValorNuevo);
			}	
			
			if(continente.getIsNew()||!continente.getnombre().equals(continente.getContinenteOriginal().getnombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(continente.getContinenteOriginal().getnombre()!=null)
				{
					strValorActual=continente.getContinenteOriginal().getnombre();
				}
				if(continente.getnombre()!=null)
				{
					strValorNuevo=continente.getnombre() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ContinenteConstantesFunciones.NOMBRE,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveContinenteRelacionesWithConnection(Continente continente,List<Pais> paiss) throws Exception {

		if(!continente.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveContinenteRelacionesBase(continente,paiss,true);
		}
	}

	public void saveContinenteRelaciones(Continente continente,List<Pais> paiss)throws Exception {

		if(!continente.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveContinenteRelacionesBase(continente,paiss,false);
		}
	}

	public void saveContinenteRelacionesBase(Continente continente,List<Pais> paiss,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("Continente-saveRelacionesWithConnection");}
	
			continente.setPaiss(paiss);

			this.setContinente(continente);

				if((continente.getIsNew()||continente.getIsChanged())&&!continente.getIsDeleted()) {
					this.saveContinente();
					this.saveContinenteRelacionesDetalles(paiss);

				} else if(continente.getIsDeleted()) {
					this.saveContinenteRelacionesDetalles(paiss);
					this.saveContinente();
				}

			if(conConexion) {connexion.commit();}

		} catch(Exception e) {
			
			PaisConstantesFunciones.InicializarGeneralEntityAuxiliaresPaiss(paiss,true,true);

			if(conConexion){connexion.rollback();}
			Funciones.manageException(logger,e);
			throw e;

		} finally {
			if(conConexion){this.closeNewConnexionToDeep();}
		}
	}
	
	
	private void saveContinenteRelacionesDetalles(List<Pais> paiss)throws Exception {
		try {
	

			Long idContinenteActual=this.getContinente().getId();

			PaisLogic paisLogic_Desde_Continente=new PaisLogic();
			paisLogic_Desde_Continente.setPaiss(paiss);

			paisLogic_Desde_Continente.setConnexion(this.getConnexion());
			paisLogic_Desde_Continente.setDatosCliente(this.datosCliente);

			for(Pais pais_Desde_Continente:paisLogic_Desde_Continente.getPaiss()) {
				pais_Desde_Continente.setid_continente(idContinenteActual);

				paisLogic_Desde_Continente.setPais(pais_Desde_Continente);
				paisLogic_Desde_Continente.savePais();

				Long idPaisActual=pais_Desde_Continente.getId();

				CiudadLogic ciudadLogic_Desde_Pais=new CiudadLogic();

				if(pais_Desde_Continente.getCiudads()==null){
					pais_Desde_Continente.setCiudads(new ArrayList<Ciudad>());
				}

				ciudadLogic_Desde_Pais.setCiudads(pais_Desde_Continente.getCiudads());

				ciudadLogic_Desde_Pais.setConnexion(this.getConnexion());
				ciudadLogic_Desde_Pais.setDatosCliente(this.datosCliente);

				for(Ciudad ciudad_Desde_Pais:ciudadLogic_Desde_Pais.getCiudads()) {
					ciudad_Desde_Pais.setid_pais(idPaisActual);
				}

				ciudadLogic_Desde_Pais.saveCiudads();

				ProvinciaLogic provinciaLogic_Desde_Pais=new ProvinciaLogic();

				if(pais_Desde_Continente.getProvincias()==null){
					pais_Desde_Continente.setProvincias(new ArrayList<Provincia>());
				}

				provinciaLogic_Desde_Pais.setProvincias(pais_Desde_Continente.getProvincias());

				provinciaLogic_Desde_Pais.setConnexion(this.getConnexion());
				provinciaLogic_Desde_Pais.setDatosCliente(this.datosCliente);

				for(Provincia provincia_Desde_Pais:provinciaLogic_Desde_Pais.getProvincias()) {
					provincia_Desde_Pais.setid_pais(idPaisActual);

					provinciaLogic_Desde_Pais.setProvincia(provincia_Desde_Pais);
					provinciaLogic_Desde_Pais.saveProvincia();
				}


				RegionLogic regionLogic_Desde_Pais=new RegionLogic();

				if(pais_Desde_Continente.getRegions()==null){
					pais_Desde_Continente.setRegions(new ArrayList<Region>());
				}

				regionLogic_Desde_Pais.setRegions(pais_Desde_Continente.getRegions());

				regionLogic_Desde_Pais.setConnexion(this.getConnexion());
				regionLogic_Desde_Pais.setDatosCliente(this.datosCliente);

				for(Region region_Desde_Pais:regionLogic_Desde_Pais.getRegions()) {
					region_Desde_Pais.setid_pais(idPaisActual);

					regionLogic_Desde_Pais.setRegion(region_Desde_Pais);
					regionLogic_Desde_Pais.saveRegion();

					Long idRegionActual=region_Desde_Pais.getId();

					ClienteLogic clienteLogic_Desde_Region=new ClienteLogic();

					if(region_Desde_Pais.getClientes()==null){
						region_Desde_Pais.setClientes(new ArrayList<Cliente>());
					}

					clienteLogic_Desde_Region.setClientes(region_Desde_Pais.getClientes());

					clienteLogic_Desde_Region.setConnexion(this.getConnexion());
					clienteLogic_Desde_Region.setDatosCliente(this.datosCliente);

					for(Cliente cliente_Desde_Region:clienteLogic_Desde_Region.getClientes()) {
						cliente_Desde_Region.setid_region(idRegionActual);

						clienteLogic_Desde_Region.setCliente(cliente_Desde_Region);
						clienteLogic_Desde_Region.saveCliente();
					}


					ProvinciaLogic provinciaLogic_Desde_Region=new ProvinciaLogic();

					if(region_Desde_Pais.getProvincias()==null){
						region_Desde_Pais.setProvincias(new ArrayList<Provincia>());
					}

					provinciaLogic_Desde_Region.setProvincias(region_Desde_Pais.getProvincias());

					provinciaLogic_Desde_Region.setConnexion(this.getConnexion());
					provinciaLogic_Desde_Region.setDatosCliente(this.datosCliente);

					for(Provincia provincia_Desde_Region:provinciaLogic_Desde_Region.getProvincias()) {
						provincia_Desde_Region.setid_region(idRegionActual);

						provinciaLogic_Desde_Region.setProvincia(provincia_Desde_Region);
						provinciaLogic_Desde_Region.saveProvincia();
					}


					ParametroCarteraDefectoLogic parametrocarteradefectoLogic_Desde_Region=new ParametroCarteraDefectoLogic();

					if(region_Desde_Pais.getParametroCarteraDefectos()==null){
						region_Desde_Pais.setParametroCarteraDefectos(new ArrayList<ParametroCarteraDefecto>());
					}

					parametrocarteradefectoLogic_Desde_Region.setParametroCarteraDefectos(region_Desde_Pais.getParametroCarteraDefectos());

					parametrocarteradefectoLogic_Desde_Region.setConnexion(this.getConnexion());
					parametrocarteradefectoLogic_Desde_Region.setDatosCliente(this.datosCliente);

					for(ParametroCarteraDefecto parametrocarteradefecto_Desde_Region:parametrocarteradefectoLogic_Desde_Region.getParametroCarteraDefectos()) {
						parametrocarteradefecto_Desde_Region.setid_region(idRegionActual);
					}

					parametrocarteradefectoLogic_Desde_Region.saveParametroCarteraDefectos();
				}

			}


		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfContinente(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=ContinenteConstantesFunciones.getClassesForeignKeysOfContinente(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfContinente(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=ContinenteConstantesFunciones.getClassesRelationshipsOfContinente(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

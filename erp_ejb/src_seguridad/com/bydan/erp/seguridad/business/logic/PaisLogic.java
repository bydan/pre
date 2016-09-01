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
import com.bydan.erp.seguridad.util.PaisConstantesFunciones;
import com.bydan.erp.seguridad.util.PaisParameterReturnGeneral;
//import com.bydan.erp.seguridad.util.PaisParameterGeneral;
import com.bydan.erp.seguridad.business.entity.Pais;
import com.bydan.erp.seguridad.business.logic.PaisLogicAdditional;
import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.seguridad.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.activosfijos.business.entity.*;


import com.bydan.erp.nomina.business.logic.*;
import com.bydan.erp.seguridad.business.logic.*;
import com.bydan.erp.contabilidad.business.logic.*;
import com.bydan.erp.inventario.business.logic.*;
import com.bydan.erp.tesoreria.business.logic.*;
import com.bydan.erp.cartera.business.logic.*;
import com.bydan.erp.activosfijos.business.logic.*;


import com.bydan.erp.nomina.util.*;
import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.inventario.util.*;
import com.bydan.erp.tesoreria.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.activosfijos.util.*;


import com.bydan.erp.nomina.business.dataaccess.*;
import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;
import com.bydan.erp.inventario.business.dataaccess.*;
import com.bydan.erp.tesoreria.business.dataaccess.*;
import com.bydan.erp.cartera.business.dataaccess.*;
import com.bydan.erp.activosfijos.business.dataaccess.*;








@SuppressWarnings("unused")
public class PaisLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(PaisLogic.class);
	
	protected PaisDataAccess paisDataAccess; 	
	protected Pais pais;
	protected List<Pais> paiss;
	protected Object paisObject;	
	protected List<Object> paissObject;
	
	public static ClassValidator<Pais> paisValidator = new ClassValidator<Pais>(Pais.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected PaisLogicAdditional paisLogicAdditional=null;
	
	public PaisLogicAdditional getPaisLogicAdditional() {
		return this.paisLogicAdditional;
	}
	
	public void setPaisLogicAdditional(PaisLogicAdditional paisLogicAdditional) {
		try {
			this.paisLogicAdditional=paisLogicAdditional;
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
	
	
	
	
	public  PaisLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.paisDataAccess = new PaisDataAccess();
			
			this.paiss= new ArrayList<Pais>();
			this.pais= new Pais();
			
			this.paisObject=new Object();
			this.paissObject=new ArrayList<Object>();
				
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
			
			this.paisDataAccess.setConnexionType(this.connexionType);
			this.paisDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  PaisLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.paisDataAccess = new PaisDataAccess();
			this.paiss= new ArrayList<Pais>();
			this.pais= new Pais();
			this.paisObject=new Object();
			this.paissObject=new ArrayList<Object>();
			
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
			
			this.paisDataAccess.setConnexionType(this.connexionType);
			this.paisDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public Pais getPais() throws Exception {	
		PaisLogicAdditional.checkPaisToGet(pais,this.datosCliente,this.arrDatoGeneral);
		PaisLogicAdditional.updatePaisToGet(pais,this.arrDatoGeneral);
		
		return pais;
	}
		
	public void setPais(Pais newPais) {
		this.pais = newPais;
	}
	
	public PaisDataAccess getPaisDataAccess() {
		return paisDataAccess;
	}
	
	public void setPaisDataAccess(PaisDataAccess newpaisDataAccess) {
		this.paisDataAccess = newpaisDataAccess;
	}
	
	public List<Pais> getPaiss() throws Exception {		
		this.quitarPaissNulos();
		
		PaisLogicAdditional.checkPaisToGets(paiss,this.datosCliente,this.arrDatoGeneral);
		
		for (Pais paisLocal: paiss ) {
			PaisLogicAdditional.updatePaisToGet(paisLocal,this.arrDatoGeneral);
		}
		
		return paiss;
	}
	
	public void setPaiss(List<Pais> newPaiss) {
		this.paiss = newPaiss;
	}
	
	public Object getPaisObject() {	
		this.paisObject=this.paisDataAccess.getEntityObject();
		return this.paisObject;
	}
		
	public void setPaisObject(Object newPaisObject) {
		this.paisObject = newPaisObject;
	}
	
	public List<Object> getPaissObject() {		
		this.paissObject=this.paisDataAccess.getEntitiesObject();
		return this.paissObject;
	}
		
	public void setPaissObject(List<Object> newPaissObject) {
		this.paissObject = newPaissObject;
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
		
		if(this.paisDataAccess!=null) {
			this.paisDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Pais.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			paisDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			paisDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		pais = new  Pais();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Pais.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			pais=paisDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.pais,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				PaisConstantesFunciones.refrescarForeignKeysDescripcionesPais(this.pais);
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
		pais = new  Pais();
		  		  
        try {
			
			pais=paisDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.pais,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				PaisConstantesFunciones.refrescarForeignKeysDescripcionesPais(this.pais);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		pais = new  Pais();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Pais.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			pais=paisDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.pais,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				PaisConstantesFunciones.refrescarForeignKeysDescripcionesPais(this.pais);
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
		pais = new  Pais();
		  		  
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
		pais = new  Pais();
		  		  
        try {
			
			pais=paisDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.pais,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				PaisConstantesFunciones.refrescarForeignKeysDescripcionesPais(this.pais);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		pais = new  Pais();
		  		  
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
		pais = new  Pais();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Pais.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =paisDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		pais = new  Pais();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=paisDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		pais = new  Pais();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Pais.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =paisDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		pais = new  Pais();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=paisDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		pais = new  Pais();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Pais.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =paisDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		pais = new  Pais();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=paisDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		paiss = new  ArrayList<Pais>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Pais.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			PaisLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			paiss=paisDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarPais(paiss);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PaisConstantesFunciones.refrescarForeignKeysDescripcionesPais(this.paiss);
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
		paiss = new  ArrayList<Pais>();
		  		  
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
		paiss = new  ArrayList<Pais>();
		  		  
        try {			
			PaisLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			paiss=paisDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarPais(paiss);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PaisConstantesFunciones.refrescarForeignKeysDescripcionesPais(this.paiss);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		paiss = new  ArrayList<Pais>();
		  		  
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
		paiss = new  ArrayList<Pais>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Pais.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			PaisLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			paiss=paisDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarPais(paiss);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PaisConstantesFunciones.refrescarForeignKeysDescripcionesPais(this.paiss);
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
		paiss = new  ArrayList<Pais>();
		  		  
        try {
			PaisLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			paiss=paisDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarPais(paiss);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PaisConstantesFunciones.refrescarForeignKeysDescripcionesPais(this.paiss);
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
		paiss = new  ArrayList<Pais>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Pais.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			PaisLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			paiss=paisDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarPais(paiss);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PaisConstantesFunciones.refrescarForeignKeysDescripcionesPais(this.paiss);
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
		paiss = new  ArrayList<Pais>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			PaisLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			paiss=paisDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarPais(paiss);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PaisConstantesFunciones.refrescarForeignKeysDescripcionesPais(this.paiss);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		pais = new  Pais();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Pais.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			PaisLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			pais=paisDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarPais(pais);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PaisConstantesFunciones.refrescarForeignKeysDescripcionesPais(this.pais);
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
		pais = new  Pais();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			PaisLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			pais=paisDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarPais(pais);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PaisConstantesFunciones.refrescarForeignKeysDescripcionesPais(this.pais);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		paiss = new  ArrayList<Pais>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Pais.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			PaisLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			paiss=paisDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarPais(paiss);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PaisConstantesFunciones.refrescarForeignKeysDescripcionesPais(this.paiss);
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
		paiss = new  ArrayList<Pais>();
		  		  
        try {
			PaisLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			paiss=paisDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarPais(paiss);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PaisConstantesFunciones.refrescarForeignKeysDescripcionesPais(this.paiss);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosPaissWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		paiss = new  ArrayList<Pais>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Pais.class.getSimpleName()+"-getTodosPaissWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			PaisLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			paiss=paisDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarPais(paiss);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PaisConstantesFunciones.refrescarForeignKeysDescripcionesPais(this.paiss);
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
	
	public  void  getTodosPaiss(String sFinalQuery,Pagination pagination)throws Exception {
		paiss = new  ArrayList<Pais>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			PaisLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			paiss=paisDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarPais(paiss);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PaisConstantesFunciones.refrescarForeignKeysDescripcionesPais(this.paiss);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarPais(Pais pais) throws Exception {
		Boolean estaValidado=false;
		
		if(pais.getIsNew() || pais.getIsChanged()) { 
			this.invalidValues = paisValidator.getInvalidValues(pais);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(pais);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarPais(List<Pais> Paiss) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(Pais paisLocal:paiss) {				
			estaValidadoObjeto=this.validarGuardarPais(paisLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarPais(List<Pais> Paiss) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarPais(paiss)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarPais(Pais Pais) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarPais(pais)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(Pais pais) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+pais.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=PaisConstantesFunciones.getPaisLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"pais","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(PaisConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(PaisConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void savePaisWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Pais.class.getSimpleName()+"-savePaisWithConnection");connexion.begin();			
			
			PaisLogicAdditional.checkPaisToSave(this.pais,this.datosCliente,connexion,this.arrDatoGeneral);
			
			PaisLogicAdditional.updatePaisToSave(this.pais,this.arrDatoGeneral);
			
			PaisLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.pais,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowPais();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarPais(this.pais)) {
				PaisDataAccess.save(this.pais, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.pais,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			PaisLogicAdditional.checkPaisToSaveAfter(this.pais,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowPais();
			
			connexion.commit();			
			
			if(this.pais.getIsDeleted()) {
				this.pais=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void savePais()throws Exception {	
		try {	
			
			PaisLogicAdditional.checkPaisToSave(this.pais,this.datosCliente,connexion,this.arrDatoGeneral);
			
			PaisLogicAdditional.updatePaisToSave(this.pais,this.arrDatoGeneral);
			
			PaisLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.pais,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarPais(this.pais)) {			
				PaisDataAccess.save(this.pais, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.pais,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			PaisLogicAdditional.checkPaisToSaveAfter(this.pais,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.pais.getIsDeleted()) {
				this.pais=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void savePaissWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Pais.class.getSimpleName()+"-savePaissWithConnection");connexion.begin();			
			
			PaisLogicAdditional.checkPaisToSaves(paiss,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowPaiss();
			
			Boolean validadoTodosPais=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(Pais paisLocal:paiss) {		
				if(paisLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				PaisLogicAdditional.updatePaisToSave(paisLocal,this.arrDatoGeneral);
	        	
				PaisLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),paisLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarPais(paisLocal)) {
					PaisDataAccess.save(paisLocal, connexion);				
				} else {
					validadoTodosPais=false;
				}
			}
			
			if(!validadoTodosPais) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			PaisLogicAdditional.checkPaisToSavesAfter(paiss,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowPaiss();
			
			connexion.commit();		
			
			this.quitarPaissEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void savePaiss()throws Exception {				
		 try {	
			PaisLogicAdditional.checkPaisToSaves(paiss,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosPais=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(Pais paisLocal:paiss) {				
				if(paisLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				PaisLogicAdditional.updatePaisToSave(paisLocal,this.arrDatoGeneral);
	        	
				PaisLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),paisLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarPais(paisLocal)) {				
					PaisDataAccess.save(paisLocal, connexion);				
				} else {
					validadoTodosPais=false;
				}
			}
			
			if(!validadoTodosPais) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			PaisLogicAdditional.checkPaisToSavesAfter(paiss,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarPaissEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public PaisParameterReturnGeneral procesarAccionPaiss(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<Pais> paiss,PaisParameterReturnGeneral paisParameterGeneral)throws Exception {
		 try {	
			PaisParameterReturnGeneral paisReturnGeneral=new PaisParameterReturnGeneral();
	
			PaisLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,paiss,paisParameterGeneral,paisReturnGeneral);
			
			return paisReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public PaisParameterReturnGeneral procesarAccionPaissWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<Pais> paiss,PaisParameterReturnGeneral paisParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Pais.class.getSimpleName()+"-procesarAccionPaissWithConnection");connexion.begin();			
			
			PaisParameterReturnGeneral paisReturnGeneral=new PaisParameterReturnGeneral();
	
			PaisLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,paiss,paisParameterGeneral,paisReturnGeneral);
			
			this.connexion.commit();
			
			return paisReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public PaisParameterReturnGeneral procesarEventosPaiss(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<Pais> paiss,Pais pais,PaisParameterReturnGeneral paisParameterGeneral,Boolean isEsNuevoPais,ArrayList<Classe> clases)throws Exception {
		 try {	
			PaisParameterReturnGeneral paisReturnGeneral=new PaisParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				paisReturnGeneral.setConRecargarPropiedades(true);
			}
			
			PaisLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,paiss,pais,paisParameterGeneral,paisReturnGeneral,isEsNuevoPais,clases);
			
			return paisReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public PaisParameterReturnGeneral procesarEventosPaissWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<Pais> paiss,Pais pais,PaisParameterReturnGeneral paisParameterGeneral,Boolean isEsNuevoPais,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Pais.class.getSimpleName()+"-procesarEventosPaissWithConnection");connexion.begin();			
			
			PaisParameterReturnGeneral paisReturnGeneral=new PaisParameterReturnGeneral();
	
			paisReturnGeneral.setPais(pais);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				paisReturnGeneral.setConRecargarPropiedades(true);
			}
			
			PaisLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,paiss,pais,paisParameterGeneral,paisReturnGeneral,isEsNuevoPais,clases);
			
			this.connexion.commit();
			
			return paisReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public PaisParameterReturnGeneral procesarImportacionPaissWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,PaisParameterReturnGeneral paisParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Pais.class.getSimpleName()+"-procesarImportacionPaissWithConnection");connexion.begin();			
			
			PaisParameterReturnGeneral paisReturnGeneral=new PaisParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.paiss=new ArrayList<Pais>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.pais=new Pais();
				
				
				if(conColumnasBase) {this.pais.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.pais.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.pais.setcodigo(arrColumnas[iColumn++]);
			this.pais.setnombre(arrColumnas[iColumn++]);
				this.pais.setnacionalidad(arrColumnas[iColumn++]);
				
				this.paiss.add(this.pais);
			}
			
			this.savePaiss();
			
			this.connexion.commit();
			
			paisReturnGeneral.setConRetornoEstaProcesado(true);
			paisReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return paisReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarPaissEliminados() throws Exception {				
		
		List<Pais> paissAux= new ArrayList<Pais>();
		
		for(Pais pais:paiss) {
			if(!pais.getIsDeleted()) {
				paissAux.add(pais);
			}
		}
		
		paiss=paissAux;
	}
	
	public void quitarPaissNulos() throws Exception {				
		
		List<Pais> paissAux= new ArrayList<Pais>();
		
		for(Pais pais : this.paiss) {
			if(pais==null) {
				paissAux.add(pais);
			}
		}
		
		//this.paiss=paissAux;
		
		this.paiss.removeAll(paissAux);
	}
	
	public void getSetVersionRowPaisWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(pais.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((pais.getIsDeleted() || (pais.getIsChanged()&&!pais.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=paisDataAccess.getSetVersionRowPais(connexion,pais.getId());
				
				if(!pais.getVersionRow().equals(timestamp)) {	
					pais.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				pais.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowPais()throws Exception {	
		
		if(pais.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((pais.getIsDeleted() || (pais.getIsChanged()&&!pais.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=paisDataAccess.getSetVersionRowPais(connexion,pais.getId());
			
			try {							
				if(!pais.getVersionRow().equals(timestamp)) {	
					pais.setVersionRow(timestamp);
				}
				
				pais.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowPaissWithConnection()throws Exception {	
		if(paiss!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(Pais paisAux:paiss) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(paisAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(paisAux.getIsDeleted() || (paisAux.getIsChanged()&&!paisAux.getIsNew())) {
						
						timestamp=paisDataAccess.getSetVersionRowPais(connexion,paisAux.getId());
						
						if(!pais.getVersionRow().equals(timestamp)) {	
							paisAux.setVersionRow(timestamp);
						}
								
						paisAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowPaiss()throws Exception {	
		if(paiss!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(Pais paisAux:paiss) {
					if(paisAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(paisAux.getIsDeleted() || (paisAux.getIsChanged()&&!paisAux.getIsNew())) {
						
						timestamp=paisDataAccess.getSetVersionRowPais(connexion,paisAux.getId());
						
						if(!paisAux.getVersionRow().equals(timestamp)) {	
							paisAux.setVersionRow(timestamp);
						}
						
													
						paisAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public PaisParameterReturnGeneral cargarCombosLoteForeignKeyPaisWithConnection(String finalQueryGlobalContinente) throws Exception {
		PaisParameterReturnGeneral  paisReturnGeneral =new PaisParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Pais.class.getSimpleName()+"-cargarCombosLoteForeignKeyPaisWithConnection");connexion.begin();
			
			paisReturnGeneral =new PaisParameterReturnGeneral();
			
			

			List<Continente> continentesForeignKey=new ArrayList<Continente>();
			ContinenteLogic continenteLogic=new ContinenteLogic();
			continenteLogic.setConnexion(this.connexion);
			continenteLogic.getContinenteDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalContinente.equals("NONE")) {
				continenteLogic.getTodosContinentes(finalQueryGlobalContinente,new Pagination());
				continentesForeignKey=continenteLogic.getContinentes();
			}

			paisReturnGeneral.setcontinentesForeignKey(continentesForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return paisReturnGeneral;
	}
	
	public PaisParameterReturnGeneral cargarCombosLoteForeignKeyPais(String finalQueryGlobalContinente) throws Exception {
		PaisParameterReturnGeneral  paisReturnGeneral =new PaisParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			paisReturnGeneral =new PaisParameterReturnGeneral();
			
			

			List<Continente> continentesForeignKey=new ArrayList<Continente>();
			ContinenteLogic continenteLogic=new ContinenteLogic();
			continenteLogic.setConnexion(this.connexion);
			continenteLogic.getContinenteDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalContinente.equals("NONE")) {
				continenteLogic.getTodosContinentes(finalQueryGlobalContinente,new Pagination());
				continentesForeignKey=continenteLogic.getContinentes();
			}

			paisReturnGeneral.setcontinentesForeignKey(continentesForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return paisReturnGeneral;
	}
	
	public void cargarRelacionesLoteForeignKeyPaisWithConnection() throws Exception {
		ArrayList<Classe> classes=new ArrayList<Classe>();		
		
		
			CiudadLogic ciudadLogic=new CiudadLogic();
			ProvinciaLogic provinciaLogic=new ProvinciaLogic();
			RegionLogic regionLogic=new RegionLogic();
		
		try {
			
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Pais.class.getSimpleName()+"-cargarRelacionesLoteForeignKeyPaisWithConnection");connexion.begin();
			
			
			classes.add(new Classe(Ciudad.class));
			classes.add(new Classe(Provincia.class));
			classes.add(new Classe(Region.class));
											
			

			ciudadLogic.setConnexion(this.getConnexion());
			ciudadLogic.setDatosCliente(this.datosCliente);
			ciudadLogic.setIsConRefrescarForeignKeys(true);

			provinciaLogic.setConnexion(this.getConnexion());
			provinciaLogic.setDatosCliente(this.datosCliente);
			provinciaLogic.setIsConRefrescarForeignKeys(true);

			regionLogic.setConnexion(this.getConnexion());
			regionLogic.setDatosCliente(this.datosCliente);
			regionLogic.setIsConRefrescarForeignKeys(true);
			
			this.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
			
			for(Pais pais:this.paiss) {
				

				classes=new ArrayList<Classe>();
				classes=CiudadConstantesFunciones.getClassesForeignKeysOfCiudad(new ArrayList<Classe>(),DeepLoadType.NONE);

				ciudadLogic.setCiudads(pais.ciudads);
				ciudadLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=ProvinciaConstantesFunciones.getClassesForeignKeysOfProvincia(new ArrayList<Classe>(),DeepLoadType.NONE);

				provinciaLogic.setProvincias(pais.provincias);
				provinciaLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=RegionConstantesFunciones.getClassesForeignKeysOfRegion(new ArrayList<Classe>(),DeepLoadType.NONE);

				regionLogic.setRegions(pais.regions);
				regionLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
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
	
	public void deepLoad(Pais pais,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			PaisLogicAdditional.updatePaisToGet(pais,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		pais.setContinente(paisDataAccess.getContinente(connexion,pais));
		pais.setCiudads(paisDataAccess.getCiudads(connexion,pais));
		pais.setProvincias(paisDataAccess.getProvincias(connexion,pais));
		pais.setRegions(paisDataAccess.getRegions(connexion,pais));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Continente.class)) {
				pais.setContinente(paisDataAccess.getContinente(connexion,pais));
				continue;
			}

			if(clas.clas.equals(Ciudad.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				pais.setCiudads(paisDataAccess.getCiudads(connexion,pais));

				if(this.isConDeep) {
					CiudadLogic ciudadLogic= new CiudadLogic(this.connexion);
					ciudadLogic.setCiudads(pais.getCiudads());
					ArrayList<Classe> classesLocal=CiudadConstantesFunciones.getClassesForeignKeysOfCiudad(new ArrayList<Classe>(),DeepLoadType.NONE);
					ciudadLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					CiudadConstantesFunciones.refrescarForeignKeysDescripcionesCiudad(ciudadLogic.getCiudads());
					pais.setCiudads(ciudadLogic.getCiudads());
				}

				continue;
			}

			if(clas.clas.equals(Provincia.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				pais.setProvincias(paisDataAccess.getProvincias(connexion,pais));

				if(this.isConDeep) {
					ProvinciaLogic provinciaLogic= new ProvinciaLogic(this.connexion);
					provinciaLogic.setProvincias(pais.getProvincias());
					ArrayList<Classe> classesLocal=ProvinciaConstantesFunciones.getClassesForeignKeysOfProvincia(new ArrayList<Classe>(),DeepLoadType.NONE);
					provinciaLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					ProvinciaConstantesFunciones.refrescarForeignKeysDescripcionesProvincia(provinciaLogic.getProvincias());
					pais.setProvincias(provinciaLogic.getProvincias());
				}

				continue;
			}

			if(clas.clas.equals(Region.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				pais.setRegions(paisDataAccess.getRegions(connexion,pais));

				if(this.isConDeep) {
					RegionLogic regionLogic= new RegionLogic(this.connexion);
					regionLogic.setRegions(pais.getRegions());
					ArrayList<Classe> classesLocal=RegionConstantesFunciones.getClassesForeignKeysOfRegion(new ArrayList<Classe>(),DeepLoadType.NONE);
					regionLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					RegionConstantesFunciones.refrescarForeignKeysDescripcionesRegion(regionLogic.getRegions());
					pais.setRegions(regionLogic.getRegions());
				}

				continue;
			}
		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Continente.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			pais.setContinente(paisDataAccess.getContinente(connexion,pais));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Ciudad.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(Ciudad.class));
			pais.setCiudads(paisDataAccess.getCiudads(connexion,pais));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Provincia.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(Provincia.class));
			pais.setProvincias(paisDataAccess.getProvincias(connexion,pais));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Region.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(Region.class));
			pais.setRegions(paisDataAccess.getRegions(connexion,pais));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		pais.setContinente(paisDataAccess.getContinente(connexion,pais));
		ContinenteLogic continenteLogic= new ContinenteLogic(connexion);
		continenteLogic.deepLoad(pais.getContinente(),isDeep,deepLoadType,clases);
				

		pais.setCiudads(paisDataAccess.getCiudads(connexion,pais));

		for(Ciudad ciudad:pais.getCiudads()) {
			CiudadLogic ciudadLogic= new CiudadLogic(connexion);
			ciudadLogic.deepLoad(ciudad,isDeep,deepLoadType,clases);
		}

		pais.setProvincias(paisDataAccess.getProvincias(connexion,pais));

		for(Provincia provincia:pais.getProvincias()) {
			ProvinciaLogic provinciaLogic= new ProvinciaLogic(connexion);
			provinciaLogic.deepLoad(provincia,isDeep,deepLoadType,clases);
		}

		pais.setRegions(paisDataAccess.getRegions(connexion,pais));

		for(Region region:pais.getRegions()) {
			RegionLogic regionLogic= new RegionLogic(connexion);
			regionLogic.deepLoad(region,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Continente.class)) {
				pais.setContinente(paisDataAccess.getContinente(connexion,pais));
				ContinenteLogic continenteLogic= new ContinenteLogic(connexion);
				continenteLogic.deepLoad(pais.getContinente(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Ciudad.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				pais.setCiudads(paisDataAccess.getCiudads(connexion,pais));

				for(Ciudad ciudad:pais.getCiudads()) {
					CiudadLogic ciudadLogic= new CiudadLogic(connexion);
					ciudadLogic.deepLoad(ciudad,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(Provincia.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				pais.setProvincias(paisDataAccess.getProvincias(connexion,pais));

				for(Provincia provincia:pais.getProvincias()) {
					ProvinciaLogic provinciaLogic= new ProvinciaLogic(connexion);
					provinciaLogic.deepLoad(provincia,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(Region.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				pais.setRegions(paisDataAccess.getRegions(connexion,pais));

				for(Region region:pais.getRegions()) {
					RegionLogic regionLogic= new RegionLogic(connexion);
					regionLogic.deepLoad(region,isDeep,deepLoadType,clases);
				}
				continue;
			}

		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {


		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Continente.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			pais.setContinente(paisDataAccess.getContinente(connexion,pais));
			ContinenteLogic continenteLogic= new ContinenteLogic(connexion);
			continenteLogic.deepLoad(pais.getContinente(),isDeep,deepLoadType,clases);
				
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Ciudad.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(Ciudad.class));
			pais.setCiudads(paisDataAccess.getCiudads(connexion,pais));

			for(Ciudad ciudad:pais.getCiudads()) {
				CiudadLogic ciudadLogic= new CiudadLogic(connexion);
				ciudadLogic.deepLoad(ciudad,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Provincia.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(Provincia.class));
			pais.setProvincias(paisDataAccess.getProvincias(connexion,pais));

			for(Provincia provincia:pais.getProvincias()) {
				ProvinciaLogic provinciaLogic= new ProvinciaLogic(connexion);
				provinciaLogic.deepLoad(provincia,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Region.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(Region.class));
			pais.setRegions(paisDataAccess.getRegions(connexion,pais));

			for(Region region:pais.getRegions()) {
				RegionLogic regionLogic= new RegionLogic(connexion);
				regionLogic.deepLoad(region,isDeep,deepLoadType,clases);
			}
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(Pais pais,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			PaisLogicAdditional.updatePaisToSave(pais,this.arrDatoGeneral);
			
PaisDataAccess.save(pais, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		ContinenteDataAccess.save(pais.getContinente(),connexion);

		for(Ciudad ciudad:pais.getCiudads()) {
			ciudad.setid_pais(pais.getId());
			CiudadDataAccess.save(ciudad,connexion);
		}

		for(Provincia provincia:pais.getProvincias()) {
			provincia.setid_pais(pais.getId());
			ProvinciaDataAccess.save(provincia,connexion);
		}

		for(Region region:pais.getRegions()) {
			region.setid_pais(pais.getId());
			RegionDataAccess.save(region,connexion);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Continente.class)) {
				ContinenteDataAccess.save(pais.getContinente(),connexion);
				continue;
			}


			if(clas.clas.equals(Ciudad.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(Ciudad ciudad:pais.getCiudads()) {
					ciudad.setid_pais(pais.getId());
					CiudadDataAccess.save(ciudad,connexion);
				}
				continue;
			}

			if(clas.clas.equals(Provincia.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(Provincia provincia:pais.getProvincias()) {
					provincia.setid_pais(pais.getId());
					ProvinciaDataAccess.save(provincia,connexion);
				}
				continue;
			}

			if(clas.clas.equals(Region.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(Region region:pais.getRegions()) {
					region.setid_pais(pais.getId());
					RegionDataAccess.save(region,connexion);
				}
				continue;
			}
		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		ContinenteDataAccess.save(pais.getContinente(),connexion);
		ContinenteLogic continenteLogic= new ContinenteLogic(connexion);
		continenteLogic.deepLoad(pais.getContinente(),isDeep,deepLoadType,clases);
				

		for(Ciudad ciudad:pais.getCiudads()) {
			CiudadLogic ciudadLogic= new CiudadLogic(connexion);
			ciudad.setid_pais(pais.getId());
			CiudadDataAccess.save(ciudad,connexion);
			ciudadLogic.deepSave(ciudad,isDeep,deepLoadType,clases);
		}

		for(Provincia provincia:pais.getProvincias()) {
			ProvinciaLogic provinciaLogic= new ProvinciaLogic(connexion);
			provincia.setid_pais(pais.getId());
			ProvinciaDataAccess.save(provincia,connexion);
			provinciaLogic.deepSave(provincia,isDeep,deepLoadType,clases);
		}

		for(Region region:pais.getRegions()) {
			RegionLogic regionLogic= new RegionLogic(connexion);
			region.setid_pais(pais.getId());
			RegionDataAccess.save(region,connexion);
			regionLogic.deepSave(region,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Continente.class)) {
				ContinenteDataAccess.save(pais.getContinente(),connexion);
				ContinenteLogic continenteLogic= new ContinenteLogic(connexion);
				continenteLogic.deepSave(pais.getContinente(),isDeep,deepLoadType,clases);				
				continue;
			}


			if(clas.clas.equals(Ciudad.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(Ciudad ciudad:pais.getCiudads()) {
					CiudadLogic ciudadLogic= new CiudadLogic(connexion);
					ciudad.setid_pais(pais.getId());
					CiudadDataAccess.save(ciudad,connexion);
					ciudadLogic.deepSave(ciudad,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(Provincia.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(Provincia provincia:pais.getProvincias()) {
					ProvinciaLogic provinciaLogic= new ProvinciaLogic(connexion);
					provincia.setid_pais(pais.getId());
					ProvinciaDataAccess.save(provincia,connexion);
					provinciaLogic.deepSave(provincia,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(Region.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(Region region:pais.getRegions()) {
					RegionLogic regionLogic= new RegionLogic(connexion);
					region.setid_pais(pais.getId());
					RegionDataAccess.save(region,connexion);
					regionLogic.deepSave(region,isDeep,deepLoadType,clases);
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
			this.getNewConnexionToDeep(Pais.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(pais,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				PaisConstantesFunciones.refrescarForeignKeysDescripcionesPais(pais);
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
			this.deepLoad(this.pais,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				PaisConstantesFunciones.refrescarForeignKeysDescripcionesPais(this.pais);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(Pais.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(paiss!=null) {
				for(Pais pais:paiss) {
					this.deepLoad(pais,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					PaisConstantesFunciones.refrescarForeignKeysDescripcionesPais(paiss);
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
			if(paiss!=null) {
				for(Pais pais:paiss) {
					this.deepLoad(pais,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					PaisConstantesFunciones.refrescarForeignKeysDescripcionesPais(paiss);
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
			this.getNewConnexionToDeep(Pais.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(pais,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(Pais.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(paiss!=null) {
				for(Pais pais:paiss) {
					this.deepSave(pais,isDeep,deepLoadType,clases);
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
			if(paiss!=null) {
				for(Pais pais:paiss) {
					this.deepSave(pais,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getPaissBusquedaPorIdContinentePorNombreWithConnection(String sFinalQuery,Pagination pagination,Long id_continente,String nombre)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Pais.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidContinente= new ParameterSelectionGeneral();
			parameterSelectionGeneralidContinente.setParameterSelectionGeneralEqual(ParameterType.LONG,id_continente,PaisConstantesFunciones.IDCONTINENTE,ParameterTypeOperator.AND);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidContinente);

			ParameterSelectionGeneral parameterSelectionGeneralNombre= new ParameterSelectionGeneral();
			parameterSelectionGeneralNombre.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+nombre+"%",PaisConstantesFunciones.NOMBRE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNombre);

			PaisLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorIdContinentePorNombre","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			paiss=paisDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PaisConstantesFunciones.refrescarForeignKeysDescripcionesPais(this.paiss);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPaissBusquedaPorIdContinentePorNombre(String sFinalQuery,Pagination pagination,Long id_continente,String nombre)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidContinente= new ParameterSelectionGeneral();
			parameterSelectionGeneralidContinente.setParameterSelectionGeneralEqual(ParameterType.LONG,id_continente,PaisConstantesFunciones.IDCONTINENTE,ParameterTypeOperator.AND);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidContinente);

			ParameterSelectionGeneral parameterSelectionGeneralNombre= new ParameterSelectionGeneral();
			parameterSelectionGeneralNombre.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+nombre+"%",PaisConstantesFunciones.NOMBRE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNombre);

			PaisLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorIdContinentePorNombre","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			paiss=paisDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PaisConstantesFunciones.refrescarForeignKeysDescripcionesPais(this.paiss);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getPaissFK_IdContinenteWithConnection(String sFinalQuery,Pagination pagination,Long id_continente)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Pais.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidContinente= new ParameterSelectionGeneral();
			parameterSelectionGeneralidContinente.setParameterSelectionGeneralEqual(ParameterType.LONG,id_continente,PaisConstantesFunciones.IDCONTINENTE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidContinente);

			PaisLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdContinente","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			paiss=paisDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PaisConstantesFunciones.refrescarForeignKeysDescripcionesPais(this.paiss);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPaissFK_IdContinente(String sFinalQuery,Pagination pagination,Long id_continente)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidContinente= new ParameterSelectionGeneral();
			parameterSelectionGeneralidContinente.setParameterSelectionGeneralEqual(ParameterType.LONG,id_continente,PaisConstantesFunciones.IDCONTINENTE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidContinente);

			PaisLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdContinente","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			paiss=paisDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PaisConstantesFunciones.refrescarForeignKeysDescripcionesPais(this.paiss);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getPaisPorIdContinentePorNombreWithConnection(Long id_continente,String nombre)throws Exception {
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Pais.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			ParameterSelectionGeneral parameterSelectionGeneralidContinente= new ParameterSelectionGeneral();
			parameterSelectionGeneralidContinente.setParameterSelectionGeneralEqual(ParameterType.LONG,id_continente,PaisConstantesFunciones.IDCONTINENTE,ParameterTypeOperator.AND);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidContinente);

			ParameterSelectionGeneral parameterSelectionGeneralNombre= new ParameterSelectionGeneral();
			parameterSelectionGeneralNombre.setParameterSelectionGeneralEqual(ParameterType.STRING,nombre,PaisConstantesFunciones.NOMBRE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNombre);

			pais=paisDataAccess.getEntity(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoad(this.pais,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());

				PaisConstantesFunciones.refrescarForeignKeysDescripcionesPais(this.pais);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPaisPorIdContinentePorNombre(Long id_continente,String nombre)throws Exception {
		try {

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			ParameterSelectionGeneral parameterSelectionGeneralidContinente= new ParameterSelectionGeneral();
			parameterSelectionGeneralidContinente.setParameterSelectionGeneralEqual(ParameterType.LONG,id_continente,PaisConstantesFunciones.IDCONTINENTE,ParameterTypeOperator.AND);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidContinente);

			ParameterSelectionGeneral parameterSelectionGeneralNombre= new ParameterSelectionGeneral();
			parameterSelectionGeneralNombre.setParameterSelectionGeneralEqual(ParameterType.STRING,nombre,PaisConstantesFunciones.NOMBRE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNombre);

			pais=paisDataAccess.getEntity(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoad(this.pais,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());

				PaisConstantesFunciones.refrescarForeignKeysDescripcionesPais(this.pais);
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
			if(PaisConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,PaisDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,Pais pais,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(PaisConstantesFunciones.ISCONAUDITORIA) {
				if(pais.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,PaisDataAccess.TABLENAME, pais.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(PaisConstantesFunciones.ISCONAUDITORIADETALLE) {
						////PaisLogic.registrarAuditoriaDetallesPais(connexion,pais,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(pais.getIsDeleted()) {
					/*if(!pais.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,PaisDataAccess.TABLENAME, pais.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////PaisLogic.registrarAuditoriaDetallesPais(connexion,pais,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,PaisDataAccess.TABLENAME, pais.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(pais.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,PaisDataAccess.TABLENAME, pais.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(PaisConstantesFunciones.ISCONAUDITORIADETALLE) {
						////PaisLogic.registrarAuditoriaDetallesPais(connexion,pais,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesPais(Connexion connexion,Pais pais)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(pais.getIsNew()||!pais.getid_continente().equals(pais.getPaisOriginal().getid_continente()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(pais.getPaisOriginal().getid_continente()!=null)
				{
					strValorActual=pais.getPaisOriginal().getid_continente().toString();
				}
				if(pais.getid_continente()!=null)
				{
					strValorNuevo=pais.getid_continente().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PaisConstantesFunciones.IDCONTINENTE,strValorActual,strValorNuevo);
			}	
			
			if(pais.getIsNew()||!pais.getcodigo().equals(pais.getPaisOriginal().getcodigo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(pais.getPaisOriginal().getcodigo()!=null)
				{
					strValorActual=pais.getPaisOriginal().getcodigo();
				}
				if(pais.getcodigo()!=null)
				{
					strValorNuevo=pais.getcodigo() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PaisConstantesFunciones.CODIGO,strValorActual,strValorNuevo);
			}	
			
			if(pais.getIsNew()||!pais.getnombre().equals(pais.getPaisOriginal().getnombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(pais.getPaisOriginal().getnombre()!=null)
				{
					strValorActual=pais.getPaisOriginal().getnombre();
				}
				if(pais.getnombre()!=null)
				{
					strValorNuevo=pais.getnombre() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PaisConstantesFunciones.NOMBRE,strValorActual,strValorNuevo);
			}	
			
			if(pais.getIsNew()||!pais.getnacionalidad().equals(pais.getPaisOriginal().getnacionalidad()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(pais.getPaisOriginal().getnacionalidad()!=null)
				{
					strValorActual=pais.getPaisOriginal().getnacionalidad();
				}
				if(pais.getnacionalidad()!=null)
				{
					strValorNuevo=pais.getnacionalidad() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PaisConstantesFunciones.NACIONALIDAD,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void savePaisRelacionesWithConnection(Pais pais,List<Ciudad> ciudads,List<Provincia> provincias,List<Region> regions) throws Exception {

		if(!pais.getsType().contains(Constantes2.S_TOTALES)) {
			this.savePaisRelacionesBase(pais,ciudads,provincias,regions,true);
		}
	}

	public void savePaisRelaciones(Pais pais,List<Ciudad> ciudads,List<Provincia> provincias,List<Region> regions)throws Exception {

		if(!pais.getsType().contains(Constantes2.S_TOTALES)) {
			this.savePaisRelacionesBase(pais,ciudads,provincias,regions,false);
		}
	}

	public void savePaisRelacionesBase(Pais pais,List<Ciudad> ciudads,List<Provincia> provincias,List<Region> regions,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("Pais-saveRelacionesWithConnection");}
	
			pais.setCiudads(ciudads);
			pais.setProvincias(provincias);
			pais.setRegions(regions);

			this.setPais(pais);

			if(PaisLogicAdditional.validarSaveRelaciones(pais,this)) {

				PaisLogicAdditional.updateRelacionesToSave(pais,this);

				if((pais.getIsNew()||pais.getIsChanged())&&!pais.getIsDeleted()) {
					this.savePais();
					this.savePaisRelacionesDetalles(ciudads,provincias,regions);

				} else if(pais.getIsDeleted()) {
					this.savePaisRelacionesDetalles(ciudads,provincias,regions);
					this.savePais();
				}

				PaisLogicAdditional.updateRelacionesToSaveAfter(pais,this);

			} else {
				throw new Exception("LOS DATOS SON INVALIDOS");
			}

			if(conConexion) {connexion.commit();}

		} catch(Exception e) {
			
			CiudadConstantesFunciones.InicializarGeneralEntityAuxiliaresCiudads(ciudads,true,true);
			ProvinciaConstantesFunciones.InicializarGeneralEntityAuxiliaresProvincias(provincias,true,true);
			RegionConstantesFunciones.InicializarGeneralEntityAuxiliaresRegions(regions,true,true);

			if(conConexion){connexion.rollback();}
			Funciones.manageException(logger,e);
			throw e;

		} finally {
			if(conConexion){this.closeNewConnexionToDeep();}
		}
	}
	
	
	private void savePaisRelacionesDetalles(List<Ciudad> ciudads,List<Provincia> provincias,List<Region> regions)throws Exception {
		try {
	

			Long idPaisActual=this.getPais().getId();

			CiudadLogic ciudadLogic_Desde_Pais=new CiudadLogic();
			ciudadLogic_Desde_Pais.setCiudads(ciudads);

			ciudadLogic_Desde_Pais.setConnexion(this.getConnexion());
			ciudadLogic_Desde_Pais.setDatosCliente(this.datosCliente);

			for(Ciudad ciudad_Desde_Pais:ciudadLogic_Desde_Pais.getCiudads()) {
				ciudad_Desde_Pais.setid_pais(idPaisActual);
			}

			ciudadLogic_Desde_Pais.saveCiudads();

			ProvinciaLogic provinciaLogic_Desde_Pais=new ProvinciaLogic();
			provinciaLogic_Desde_Pais.setProvincias(provincias);

			provinciaLogic_Desde_Pais.setConnexion(this.getConnexion());
			provinciaLogic_Desde_Pais.setDatosCliente(this.datosCliente);

			for(Provincia provincia_Desde_Pais:provinciaLogic_Desde_Pais.getProvincias()) {
				provincia_Desde_Pais.setid_pais(idPaisActual);

				provinciaLogic_Desde_Pais.setProvincia(provincia_Desde_Pais);
				provinciaLogic_Desde_Pais.saveProvincia();
			}


			RegionLogic regionLogic_Desde_Pais=new RegionLogic();
			regionLogic_Desde_Pais.setRegions(regions);

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


		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfPais(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=PaisConstantesFunciones.getClassesForeignKeysOfPais(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfPais(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=PaisConstantesFunciones.getClassesRelationshipsOfPais(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

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
import com.bydan.erp.nomina.util.RubroEstructuraConstantesFunciones;
import com.bydan.erp.nomina.util.RubroEstructuraParameterReturnGeneral;
//import com.bydan.erp.nomina.util.RubroEstructuraParameterGeneral;
import com.bydan.erp.nomina.business.entity.RubroEstructura;
import com.bydan.erp.nomina.business.logic.RubroEstructuraLogicAdditional;
import com.bydan.erp.nomina.business.dataaccess.*;
import com.bydan.erp.nomina.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;


import com.bydan.erp.seguridad.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;








@SuppressWarnings("unused")
public class RubroEstructuraLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(RubroEstructuraLogic.class);
	
	protected RubroEstructuraDataAccess rubroestructuraDataAccess; 	
	protected RubroEstructura rubroestructura;
	protected List<RubroEstructura> rubroestructuras;
	protected Object rubroestructuraObject;	
	protected List<Object> rubroestructurasObject;
	
	public static ClassValidator<RubroEstructura> rubroestructuraValidator = new ClassValidator<RubroEstructura>(RubroEstructura.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected RubroEstructuraLogicAdditional rubroestructuraLogicAdditional=null;
	
	public RubroEstructuraLogicAdditional getRubroEstructuraLogicAdditional() {
		return this.rubroestructuraLogicAdditional;
	}
	
	public void setRubroEstructuraLogicAdditional(RubroEstructuraLogicAdditional rubroestructuraLogicAdditional) {
		try {
			this.rubroestructuraLogicAdditional=rubroestructuraLogicAdditional;
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
	
	
	
	
	public  RubroEstructuraLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.rubroestructuraDataAccess = new RubroEstructuraDataAccess();
			
			this.rubroestructuras= new ArrayList<RubroEstructura>();
			this.rubroestructura= new RubroEstructura();
			
			this.rubroestructuraObject=new Object();
			this.rubroestructurasObject=new ArrayList<Object>();
				
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
			
			this.rubroestructuraDataAccess.setConnexionType(this.connexionType);
			this.rubroestructuraDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  RubroEstructuraLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.rubroestructuraDataAccess = new RubroEstructuraDataAccess();
			this.rubroestructuras= new ArrayList<RubroEstructura>();
			this.rubroestructura= new RubroEstructura();
			this.rubroestructuraObject=new Object();
			this.rubroestructurasObject=new ArrayList<Object>();
			
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
			
			this.rubroestructuraDataAccess.setConnexionType(this.connexionType);
			this.rubroestructuraDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public RubroEstructura getRubroEstructura() throws Exception {	
		RubroEstructuraLogicAdditional.checkRubroEstructuraToGet(rubroestructura,this.datosCliente,this.arrDatoGeneral);
		RubroEstructuraLogicAdditional.updateRubroEstructuraToGet(rubroestructura,this.arrDatoGeneral);
		
		return rubroestructura;
	}
		
	public void setRubroEstructura(RubroEstructura newRubroEstructura) {
		this.rubroestructura = newRubroEstructura;
	}
	
	public RubroEstructuraDataAccess getRubroEstructuraDataAccess() {
		return rubroestructuraDataAccess;
	}
	
	public void setRubroEstructuraDataAccess(RubroEstructuraDataAccess newrubroestructuraDataAccess) {
		this.rubroestructuraDataAccess = newrubroestructuraDataAccess;
	}
	
	public List<RubroEstructura> getRubroEstructuras() throws Exception {		
		this.quitarRubroEstructurasNulos();
		
		RubroEstructuraLogicAdditional.checkRubroEstructuraToGets(rubroestructuras,this.datosCliente,this.arrDatoGeneral);
		
		for (RubroEstructura rubroestructuraLocal: rubroestructuras ) {
			RubroEstructuraLogicAdditional.updateRubroEstructuraToGet(rubroestructuraLocal,this.arrDatoGeneral);
		}
		
		return rubroestructuras;
	}
	
	public void setRubroEstructuras(List<RubroEstructura> newRubroEstructuras) {
		this.rubroestructuras = newRubroEstructuras;
	}
	
	public Object getRubroEstructuraObject() {	
		this.rubroestructuraObject=this.rubroestructuraDataAccess.getEntityObject();
		return this.rubroestructuraObject;
	}
		
	public void setRubroEstructuraObject(Object newRubroEstructuraObject) {
		this.rubroestructuraObject = newRubroEstructuraObject;
	}
	
	public List<Object> getRubroEstructurasObject() {		
		this.rubroestructurasObject=this.rubroestructuraDataAccess.getEntitiesObject();
		return this.rubroestructurasObject;
	}
		
	public void setRubroEstructurasObject(List<Object> newRubroEstructurasObject) {
		this.rubroestructurasObject = newRubroEstructurasObject;
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
		
		if(this.rubroestructuraDataAccess!=null) {
			this.rubroestructuraDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RubroEstructura.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			rubroestructuraDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			rubroestructuraDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		rubroestructura = new  RubroEstructura();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RubroEstructura.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			rubroestructura=rubroestructuraDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.rubroestructura,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				RubroEstructuraConstantesFunciones.refrescarForeignKeysDescripcionesRubroEstructura(this.rubroestructura);
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
		rubroestructura = new  RubroEstructura();
		  		  
        try {
			
			rubroestructura=rubroestructuraDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.rubroestructura,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				RubroEstructuraConstantesFunciones.refrescarForeignKeysDescripcionesRubroEstructura(this.rubroestructura);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		rubroestructura = new  RubroEstructura();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RubroEstructura.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			rubroestructura=rubroestructuraDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.rubroestructura,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				RubroEstructuraConstantesFunciones.refrescarForeignKeysDescripcionesRubroEstructura(this.rubroestructura);
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
		rubroestructura = new  RubroEstructura();
		  		  
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
		rubroestructura = new  RubroEstructura();
		  		  
        try {
			
			rubroestructura=rubroestructuraDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.rubroestructura,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				RubroEstructuraConstantesFunciones.refrescarForeignKeysDescripcionesRubroEstructura(this.rubroestructura);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		rubroestructura = new  RubroEstructura();
		  		  
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
		rubroestructura = new  RubroEstructura();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RubroEstructura.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =rubroestructuraDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		rubroestructura = new  RubroEstructura();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=rubroestructuraDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		rubroestructura = new  RubroEstructura();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RubroEstructura.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =rubroestructuraDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		rubroestructura = new  RubroEstructura();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=rubroestructuraDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		rubroestructura = new  RubroEstructura();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RubroEstructura.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =rubroestructuraDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		rubroestructura = new  RubroEstructura();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=rubroestructuraDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		rubroestructuras = new  ArrayList<RubroEstructura>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RubroEstructura.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			RubroEstructuraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			rubroestructuras=rubroestructuraDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarRubroEstructura(rubroestructuras);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				RubroEstructuraConstantesFunciones.refrescarForeignKeysDescripcionesRubroEstructura(this.rubroestructuras);
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
		rubroestructuras = new  ArrayList<RubroEstructura>();
		  		  
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
		rubroestructuras = new  ArrayList<RubroEstructura>();
		  		  
        try {			
			RubroEstructuraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			rubroestructuras=rubroestructuraDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarRubroEstructura(rubroestructuras);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				RubroEstructuraConstantesFunciones.refrescarForeignKeysDescripcionesRubroEstructura(this.rubroestructuras);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		rubroestructuras = new  ArrayList<RubroEstructura>();
		  		  
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
		rubroestructuras = new  ArrayList<RubroEstructura>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RubroEstructura.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			RubroEstructuraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			rubroestructuras=rubroestructuraDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarRubroEstructura(rubroestructuras);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				RubroEstructuraConstantesFunciones.refrescarForeignKeysDescripcionesRubroEstructura(this.rubroestructuras);
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
		rubroestructuras = new  ArrayList<RubroEstructura>();
		  		  
        try {
			RubroEstructuraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			rubroestructuras=rubroestructuraDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarRubroEstructura(rubroestructuras);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				RubroEstructuraConstantesFunciones.refrescarForeignKeysDescripcionesRubroEstructura(this.rubroestructuras);
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
		rubroestructuras = new  ArrayList<RubroEstructura>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RubroEstructura.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			RubroEstructuraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			rubroestructuras=rubroestructuraDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarRubroEstructura(rubroestructuras);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				RubroEstructuraConstantesFunciones.refrescarForeignKeysDescripcionesRubroEstructura(this.rubroestructuras);
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
		rubroestructuras = new  ArrayList<RubroEstructura>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			RubroEstructuraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			rubroestructuras=rubroestructuraDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarRubroEstructura(rubroestructuras);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				RubroEstructuraConstantesFunciones.refrescarForeignKeysDescripcionesRubroEstructura(this.rubroestructuras);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		rubroestructura = new  RubroEstructura();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RubroEstructura.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			RubroEstructuraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			rubroestructura=rubroestructuraDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarRubroEstructura(rubroestructura);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				RubroEstructuraConstantesFunciones.refrescarForeignKeysDescripcionesRubroEstructura(this.rubroestructura);
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
		rubroestructura = new  RubroEstructura();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			RubroEstructuraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			rubroestructura=rubroestructuraDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarRubroEstructura(rubroestructura);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				RubroEstructuraConstantesFunciones.refrescarForeignKeysDescripcionesRubroEstructura(this.rubroestructura);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		rubroestructuras = new  ArrayList<RubroEstructura>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RubroEstructura.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			RubroEstructuraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			rubroestructuras=rubroestructuraDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarRubroEstructura(rubroestructuras);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				RubroEstructuraConstantesFunciones.refrescarForeignKeysDescripcionesRubroEstructura(this.rubroestructuras);
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
		rubroestructuras = new  ArrayList<RubroEstructura>();
		  		  
        try {
			RubroEstructuraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			rubroestructuras=rubroestructuraDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarRubroEstructura(rubroestructuras);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				RubroEstructuraConstantesFunciones.refrescarForeignKeysDescripcionesRubroEstructura(this.rubroestructuras);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosRubroEstructurasWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		rubroestructuras = new  ArrayList<RubroEstructura>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RubroEstructura.class.getSimpleName()+"-getTodosRubroEstructurasWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			RubroEstructuraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			rubroestructuras=rubroestructuraDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarRubroEstructura(rubroestructuras);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				RubroEstructuraConstantesFunciones.refrescarForeignKeysDescripcionesRubroEstructura(this.rubroestructuras);
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
	
	public  void  getTodosRubroEstructuras(String sFinalQuery,Pagination pagination)throws Exception {
		rubroestructuras = new  ArrayList<RubroEstructura>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			RubroEstructuraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			rubroestructuras=rubroestructuraDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarRubroEstructura(rubroestructuras);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				RubroEstructuraConstantesFunciones.refrescarForeignKeysDescripcionesRubroEstructura(this.rubroestructuras);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarRubroEstructura(RubroEstructura rubroestructura) throws Exception {
		Boolean estaValidado=false;
		
		if(rubroestructura.getIsNew() || rubroestructura.getIsChanged()) { 
			this.invalidValues = rubroestructuraValidator.getInvalidValues(rubroestructura);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(rubroestructura);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarRubroEstructura(List<RubroEstructura> RubroEstructuras) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(RubroEstructura rubroestructuraLocal:rubroestructuras) {				
			estaValidadoObjeto=this.validarGuardarRubroEstructura(rubroestructuraLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarRubroEstructura(List<RubroEstructura> RubroEstructuras) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarRubroEstructura(rubroestructuras)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarRubroEstructura(RubroEstructura RubroEstructura) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarRubroEstructura(rubroestructura)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(RubroEstructura rubroestructura) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+rubroestructura.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=RubroEstructuraConstantesFunciones.getRubroEstructuraLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"rubroestructura","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(RubroEstructuraConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(RubroEstructuraConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveRubroEstructuraWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RubroEstructura.class.getSimpleName()+"-saveRubroEstructuraWithConnection");connexion.begin();			
			
			RubroEstructuraLogicAdditional.checkRubroEstructuraToSave(this.rubroestructura,this.datosCliente,connexion,this.arrDatoGeneral);
			
			RubroEstructuraLogicAdditional.updateRubroEstructuraToSave(this.rubroestructura,this.arrDatoGeneral);
			
			RubroEstructuraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.rubroestructura,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowRubroEstructura();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarRubroEstructura(this.rubroestructura)) {
				RubroEstructuraDataAccess.save(this.rubroestructura, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.rubroestructura,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			RubroEstructuraLogicAdditional.checkRubroEstructuraToSaveAfter(this.rubroestructura,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowRubroEstructura();
			
			connexion.commit();			
			
			if(this.rubroestructura.getIsDeleted()) {
				this.rubroestructura=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveRubroEstructura()throws Exception {	
		try {	
			
			RubroEstructuraLogicAdditional.checkRubroEstructuraToSave(this.rubroestructura,this.datosCliente,connexion,this.arrDatoGeneral);
			
			RubroEstructuraLogicAdditional.updateRubroEstructuraToSave(this.rubroestructura,this.arrDatoGeneral);
			
			RubroEstructuraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.rubroestructura,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarRubroEstructura(this.rubroestructura)) {			
				RubroEstructuraDataAccess.save(this.rubroestructura, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.rubroestructura,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			RubroEstructuraLogicAdditional.checkRubroEstructuraToSaveAfter(this.rubroestructura,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.rubroestructura.getIsDeleted()) {
				this.rubroestructura=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveRubroEstructurasWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RubroEstructura.class.getSimpleName()+"-saveRubroEstructurasWithConnection");connexion.begin();			
			
			RubroEstructuraLogicAdditional.checkRubroEstructuraToSaves(rubroestructuras,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowRubroEstructuras();
			
			Boolean validadoTodosRubroEstructura=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(RubroEstructura rubroestructuraLocal:rubroestructuras) {		
				if(rubroestructuraLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				RubroEstructuraLogicAdditional.updateRubroEstructuraToSave(rubroestructuraLocal,this.arrDatoGeneral);
	        	
				RubroEstructuraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),rubroestructuraLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarRubroEstructura(rubroestructuraLocal)) {
					RubroEstructuraDataAccess.save(rubroestructuraLocal, connexion);				
				} else {
					validadoTodosRubroEstructura=false;
				}
			}
			
			if(!validadoTodosRubroEstructura) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			RubroEstructuraLogicAdditional.checkRubroEstructuraToSavesAfter(rubroestructuras,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowRubroEstructuras();
			
			connexion.commit();		
			
			this.quitarRubroEstructurasEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveRubroEstructuras()throws Exception {				
		 try {	
			RubroEstructuraLogicAdditional.checkRubroEstructuraToSaves(rubroestructuras,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosRubroEstructura=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(RubroEstructura rubroestructuraLocal:rubroestructuras) {				
				if(rubroestructuraLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				RubroEstructuraLogicAdditional.updateRubroEstructuraToSave(rubroestructuraLocal,this.arrDatoGeneral);
	        	
				RubroEstructuraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),rubroestructuraLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarRubroEstructura(rubroestructuraLocal)) {				
					RubroEstructuraDataAccess.save(rubroestructuraLocal, connexion);				
				} else {
					validadoTodosRubroEstructura=false;
				}
			}
			
			if(!validadoTodosRubroEstructura) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			RubroEstructuraLogicAdditional.checkRubroEstructuraToSavesAfter(rubroestructuras,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarRubroEstructurasEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public RubroEstructuraParameterReturnGeneral procesarAccionRubroEstructuras(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<RubroEstructura> rubroestructuras,RubroEstructuraParameterReturnGeneral rubroestructuraParameterGeneral)throws Exception {
		 try {	
			RubroEstructuraParameterReturnGeneral rubroestructuraReturnGeneral=new RubroEstructuraParameterReturnGeneral();
	
			RubroEstructuraLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,rubroestructuras,rubroestructuraParameterGeneral,rubroestructuraReturnGeneral);
			
			return rubroestructuraReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public RubroEstructuraParameterReturnGeneral procesarAccionRubroEstructurasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<RubroEstructura> rubroestructuras,RubroEstructuraParameterReturnGeneral rubroestructuraParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RubroEstructura.class.getSimpleName()+"-procesarAccionRubroEstructurasWithConnection");connexion.begin();			
			
			RubroEstructuraParameterReturnGeneral rubroestructuraReturnGeneral=new RubroEstructuraParameterReturnGeneral();
	
			RubroEstructuraLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,rubroestructuras,rubroestructuraParameterGeneral,rubroestructuraReturnGeneral);
			
			this.connexion.commit();
			
			return rubroestructuraReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public RubroEstructuraParameterReturnGeneral procesarEventosRubroEstructuras(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<RubroEstructura> rubroestructuras,RubroEstructura rubroestructura,RubroEstructuraParameterReturnGeneral rubroestructuraParameterGeneral,Boolean isEsNuevoRubroEstructura,ArrayList<Classe> clases)throws Exception {
		 try {	
			RubroEstructuraParameterReturnGeneral rubroestructuraReturnGeneral=new RubroEstructuraParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				rubroestructuraReturnGeneral.setConRecargarPropiedades(true);
			}
			
			RubroEstructuraLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,rubroestructuras,rubroestructura,rubroestructuraParameterGeneral,rubroestructuraReturnGeneral,isEsNuevoRubroEstructura,clases);
			
			return rubroestructuraReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public RubroEstructuraParameterReturnGeneral procesarEventosRubroEstructurasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<RubroEstructura> rubroestructuras,RubroEstructura rubroestructura,RubroEstructuraParameterReturnGeneral rubroestructuraParameterGeneral,Boolean isEsNuevoRubroEstructura,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RubroEstructura.class.getSimpleName()+"-procesarEventosRubroEstructurasWithConnection");connexion.begin();			
			
			RubroEstructuraParameterReturnGeneral rubroestructuraReturnGeneral=new RubroEstructuraParameterReturnGeneral();
	
			rubroestructuraReturnGeneral.setRubroEstructura(rubroestructura);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				rubroestructuraReturnGeneral.setConRecargarPropiedades(true);
			}
			
			RubroEstructuraLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,rubroestructuras,rubroestructura,rubroestructuraParameterGeneral,rubroestructuraReturnGeneral,isEsNuevoRubroEstructura,clases);
			
			this.connexion.commit();
			
			return rubroestructuraReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public RubroEstructuraParameterReturnGeneral procesarImportacionRubroEstructurasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,RubroEstructuraParameterReturnGeneral rubroestructuraParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RubroEstructura.class.getSimpleName()+"-procesarImportacionRubroEstructurasWithConnection");connexion.begin();			
			
			RubroEstructuraParameterReturnGeneral rubroestructuraReturnGeneral=new RubroEstructuraParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.rubroestructuras=new ArrayList<RubroEstructura>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.rubroestructura=new RubroEstructura();
				
				
				if(conColumnasBase) {this.rubroestructura.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.rubroestructura.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.rubroestructura.setesta_activo(Boolean.parseBoolean(arrColumnas[iColumn++]));
				
				this.rubroestructuras.add(this.rubroestructura);
			}
			
			this.saveRubroEstructuras();
			
			this.connexion.commit();
			
			rubroestructuraReturnGeneral.setConRetornoEstaProcesado(true);
			rubroestructuraReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return rubroestructuraReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarRubroEstructurasEliminados() throws Exception {				
		
		List<RubroEstructura> rubroestructurasAux= new ArrayList<RubroEstructura>();
		
		for(RubroEstructura rubroestructura:rubroestructuras) {
			if(!rubroestructura.getIsDeleted()) {
				rubroestructurasAux.add(rubroestructura);
			}
		}
		
		rubroestructuras=rubroestructurasAux;
	}
	
	public void quitarRubroEstructurasNulos() throws Exception {				
		
		List<RubroEstructura> rubroestructurasAux= new ArrayList<RubroEstructura>();
		
		for(RubroEstructura rubroestructura : this.rubroestructuras) {
			if(rubroestructura==null) {
				rubroestructurasAux.add(rubroestructura);
			}
		}
		
		//this.rubroestructuras=rubroestructurasAux;
		
		this.rubroestructuras.removeAll(rubroestructurasAux);
	}
	
	public void getSetVersionRowRubroEstructuraWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(rubroestructura.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((rubroestructura.getIsDeleted() || (rubroestructura.getIsChanged()&&!rubroestructura.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=rubroestructuraDataAccess.getSetVersionRowRubroEstructura(connexion,rubroestructura.getId());
				
				if(!rubroestructura.getVersionRow().equals(timestamp)) {	
					rubroestructura.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				rubroestructura.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowRubroEstructura()throws Exception {	
		
		if(rubroestructura.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((rubroestructura.getIsDeleted() || (rubroestructura.getIsChanged()&&!rubroestructura.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=rubroestructuraDataAccess.getSetVersionRowRubroEstructura(connexion,rubroestructura.getId());
			
			try {							
				if(!rubroestructura.getVersionRow().equals(timestamp)) {	
					rubroestructura.setVersionRow(timestamp);
				}
				
				rubroestructura.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowRubroEstructurasWithConnection()throws Exception {	
		if(rubroestructuras!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(RubroEstructura rubroestructuraAux:rubroestructuras) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(rubroestructuraAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(rubroestructuraAux.getIsDeleted() || (rubroestructuraAux.getIsChanged()&&!rubroestructuraAux.getIsNew())) {
						
						timestamp=rubroestructuraDataAccess.getSetVersionRowRubroEstructura(connexion,rubroestructuraAux.getId());
						
						if(!rubroestructura.getVersionRow().equals(timestamp)) {	
							rubroestructuraAux.setVersionRow(timestamp);
						}
								
						rubroestructuraAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowRubroEstructuras()throws Exception {	
		if(rubroestructuras!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(RubroEstructura rubroestructuraAux:rubroestructuras) {
					if(rubroestructuraAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(rubroestructuraAux.getIsDeleted() || (rubroestructuraAux.getIsChanged()&&!rubroestructuraAux.getIsNew())) {
						
						timestamp=rubroestructuraDataAccess.getSetVersionRowRubroEstructura(connexion,rubroestructuraAux.getId());
						
						if(!rubroestructuraAux.getVersionRow().equals(timestamp)) {	
							rubroestructuraAux.setVersionRow(timestamp);
						}
						
													
						rubroestructuraAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public RubroEstructuraParameterReturnGeneral cargarCombosLoteForeignKeyRubroEstructuraWithConnection(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalEstructura,String finalQueryGlobalRubroEmplea) throws Exception {
		RubroEstructuraParameterReturnGeneral  rubroestructuraReturnGeneral =new RubroEstructuraParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RubroEstructura.class.getSimpleName()+"-cargarCombosLoteForeignKeyRubroEstructuraWithConnection");connexion.begin();
			
			rubroestructuraReturnGeneral =new RubroEstructuraParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			rubroestructuraReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			rubroestructuraReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Estructura> estructurasForeignKey=new ArrayList<Estructura>();
			EstructuraLogic estructuraLogic=new EstructuraLogic();
			estructuraLogic.setConnexion(this.connexion);
			estructuraLogic.getEstructuraDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEstructura.equals("NONE")) {
				estructuraLogic.getTodosEstructuras(finalQueryGlobalEstructura,new Pagination());
				estructurasForeignKey=estructuraLogic.getEstructuras();
			}

			rubroestructuraReturnGeneral.setestructurasForeignKey(estructurasForeignKey);


			List<RubroEmplea> rubroempleasForeignKey=new ArrayList<RubroEmplea>();
			RubroEmpleaLogic rubroempleaLogic=new RubroEmpleaLogic();
			rubroempleaLogic.setConnexion(this.connexion);
			rubroempleaLogic.getRubroEmpleaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalRubroEmplea.equals("NONE")) {
				rubroempleaLogic.getTodosRubroEmpleas(finalQueryGlobalRubroEmplea,new Pagination());
				rubroempleasForeignKey=rubroempleaLogic.getRubroEmpleas();
			}

			rubroestructuraReturnGeneral.setrubroempleasForeignKey(rubroempleasForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return rubroestructuraReturnGeneral;
	}
	
	public RubroEstructuraParameterReturnGeneral cargarCombosLoteForeignKeyRubroEstructura(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalEstructura,String finalQueryGlobalRubroEmplea) throws Exception {
		RubroEstructuraParameterReturnGeneral  rubroestructuraReturnGeneral =new RubroEstructuraParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			rubroestructuraReturnGeneral =new RubroEstructuraParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			rubroestructuraReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			rubroestructuraReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Estructura> estructurasForeignKey=new ArrayList<Estructura>();
			EstructuraLogic estructuraLogic=new EstructuraLogic();
			estructuraLogic.setConnexion(this.connexion);
			estructuraLogic.getEstructuraDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEstructura.equals("NONE")) {
				estructuraLogic.getTodosEstructuras(finalQueryGlobalEstructura,new Pagination());
				estructurasForeignKey=estructuraLogic.getEstructuras();
			}

			rubroestructuraReturnGeneral.setestructurasForeignKey(estructurasForeignKey);


			List<RubroEmplea> rubroempleasForeignKey=new ArrayList<RubroEmplea>();
			RubroEmpleaLogic rubroempleaLogic=new RubroEmpleaLogic();
			rubroempleaLogic.setConnexion(this.connexion);
			rubroempleaLogic.getRubroEmpleaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalRubroEmplea.equals("NONE")) {
				rubroempleaLogic.getTodosRubroEmpleas(finalQueryGlobalRubroEmplea,new Pagination());
				rubroempleasForeignKey=rubroempleaLogic.getRubroEmpleas();
			}

			rubroestructuraReturnGeneral.setrubroempleasForeignKey(rubroempleasForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return rubroestructuraReturnGeneral;
	}
	
	
	public void deepLoad(RubroEstructura rubroestructura,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			RubroEstructuraLogicAdditional.updateRubroEstructuraToGet(rubroestructura,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		rubroestructura.setEmpresa(rubroestructuraDataAccess.getEmpresa(connexion,rubroestructura));
		rubroestructura.setSucursal(rubroestructuraDataAccess.getSucursal(connexion,rubroestructura));
		rubroestructura.setEstructura(rubroestructuraDataAccess.getEstructura(connexion,rubroestructura));
		rubroestructura.setRubroEmplea(rubroestructuraDataAccess.getRubroEmplea(connexion,rubroestructura));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				rubroestructura.setEmpresa(rubroestructuraDataAccess.getEmpresa(connexion,rubroestructura));
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				rubroestructura.setSucursal(rubroestructuraDataAccess.getSucursal(connexion,rubroestructura));
				continue;
			}

			if(clas.clas.equals(Estructura.class)) {
				rubroestructura.setEstructura(rubroestructuraDataAccess.getEstructura(connexion,rubroestructura));
				continue;
			}

			if(clas.clas.equals(RubroEmplea.class)) {
				rubroestructura.setRubroEmplea(rubroestructuraDataAccess.getRubroEmplea(connexion,rubroestructura));
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
			rubroestructura.setEmpresa(rubroestructuraDataAccess.getEmpresa(connexion,rubroestructura));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			rubroestructura.setSucursal(rubroestructuraDataAccess.getSucursal(connexion,rubroestructura));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Estructura.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			rubroestructura.setEstructura(rubroestructuraDataAccess.getEstructura(connexion,rubroestructura));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(RubroEmplea.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			rubroestructura.setRubroEmplea(rubroestructuraDataAccess.getRubroEmplea(connexion,rubroestructura));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		rubroestructura.setEmpresa(rubroestructuraDataAccess.getEmpresa(connexion,rubroestructura));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(rubroestructura.getEmpresa(),isDeep,deepLoadType,clases);
				
		rubroestructura.setSucursal(rubroestructuraDataAccess.getSucursal(connexion,rubroestructura));
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(rubroestructura.getSucursal(),isDeep,deepLoadType,clases);
				
		rubroestructura.setEstructura(rubroestructuraDataAccess.getEstructura(connexion,rubroestructura));
		EstructuraLogic estructuraLogic= new EstructuraLogic(connexion);
		estructuraLogic.deepLoad(rubroestructura.getEstructura(),isDeep,deepLoadType,clases);
				
		rubroestructura.setRubroEmplea(rubroestructuraDataAccess.getRubroEmplea(connexion,rubroestructura));
		RubroEmpleaLogic rubroempleaLogic= new RubroEmpleaLogic(connexion);
		rubroempleaLogic.deepLoad(rubroestructura.getRubroEmplea(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				rubroestructura.setEmpresa(rubroestructuraDataAccess.getEmpresa(connexion,rubroestructura));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(rubroestructura.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				rubroestructura.setSucursal(rubroestructuraDataAccess.getSucursal(connexion,rubroestructura));
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepLoad(rubroestructura.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Estructura.class)) {
				rubroestructura.setEstructura(rubroestructuraDataAccess.getEstructura(connexion,rubroestructura));
				EstructuraLogic estructuraLogic= new EstructuraLogic(connexion);
				estructuraLogic.deepLoad(rubroestructura.getEstructura(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(RubroEmplea.class)) {
				rubroestructura.setRubroEmplea(rubroestructuraDataAccess.getRubroEmplea(connexion,rubroestructura));
				RubroEmpleaLogic rubroempleaLogic= new RubroEmpleaLogic(connexion);
				rubroempleaLogic.deepLoad(rubroestructura.getRubroEmplea(),isDeep,deepLoadType,clases);				
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
			rubroestructura.setEmpresa(rubroestructuraDataAccess.getEmpresa(connexion,rubroestructura));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(rubroestructura.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			rubroestructura.setSucursal(rubroestructuraDataAccess.getSucursal(connexion,rubroestructura));
			SucursalLogic sucursalLogic= new SucursalLogic(connexion);
			sucursalLogic.deepLoad(rubroestructura.getSucursal(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Estructura.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			rubroestructura.setEstructura(rubroestructuraDataAccess.getEstructura(connexion,rubroestructura));
			EstructuraLogic estructuraLogic= new EstructuraLogic(connexion);
			estructuraLogic.deepLoad(rubroestructura.getEstructura(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(RubroEmplea.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			rubroestructura.setRubroEmplea(rubroestructuraDataAccess.getRubroEmplea(connexion,rubroestructura));
			RubroEmpleaLogic rubroempleaLogic= new RubroEmpleaLogic(connexion);
			rubroempleaLogic.deepLoad(rubroestructura.getRubroEmplea(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(RubroEstructura rubroestructura,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			RubroEstructuraLogicAdditional.updateRubroEstructuraToSave(rubroestructura,this.arrDatoGeneral);
			
RubroEstructuraDataAccess.save(rubroestructura, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(rubroestructura.getEmpresa(),connexion);

		SucursalDataAccess.save(rubroestructura.getSucursal(),connexion);

		EstructuraDataAccess.save(rubroestructura.getEstructura(),connexion);

		RubroEmpleaDataAccess.save(rubroestructura.getRubroEmplea(),connexion);
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(rubroestructura.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(rubroestructura.getSucursal(),connexion);
				continue;
			}

			if(clas.clas.equals(Estructura.class)) {
				EstructuraDataAccess.save(rubroestructura.getEstructura(),connexion);
				continue;
			}

			if(clas.clas.equals(RubroEmplea.class)) {
				RubroEmpleaDataAccess.save(rubroestructura.getRubroEmplea(),connexion);
				continue;
			}

		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(rubroestructura.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(rubroestructura.getEmpresa(),isDeep,deepLoadType,clases);
				

		SucursalDataAccess.save(rubroestructura.getSucursal(),connexion);
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(rubroestructura.getSucursal(),isDeep,deepLoadType,clases);
				

		EstructuraDataAccess.save(rubroestructura.getEstructura(),connexion);
		EstructuraLogic estructuraLogic= new EstructuraLogic(connexion);
		estructuraLogic.deepLoad(rubroestructura.getEstructura(),isDeep,deepLoadType,clases);
				

		RubroEmpleaDataAccess.save(rubroestructura.getRubroEmplea(),connexion);
		RubroEmpleaLogic rubroempleaLogic= new RubroEmpleaLogic(connexion);
		rubroempleaLogic.deepLoad(rubroestructura.getRubroEmplea(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(rubroestructura.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(rubroestructura.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(rubroestructura.getSucursal(),connexion);
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepSave(rubroestructura.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Estructura.class)) {
				EstructuraDataAccess.save(rubroestructura.getEstructura(),connexion);
				EstructuraLogic estructuraLogic= new EstructuraLogic(connexion);
				estructuraLogic.deepSave(rubroestructura.getEstructura(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(RubroEmplea.class)) {
				RubroEmpleaDataAccess.save(rubroestructura.getRubroEmplea(),connexion);
				RubroEmpleaLogic rubroempleaLogic= new RubroEmpleaLogic(connexion);
				rubroempleaLogic.deepSave(rubroestructura.getRubroEmplea(),isDeep,deepLoadType,clases);				
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
			this.getNewConnexionToDeep(RubroEstructura.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(rubroestructura,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				RubroEstructuraConstantesFunciones.refrescarForeignKeysDescripcionesRubroEstructura(rubroestructura);
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
			this.deepLoad(this.rubroestructura,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				RubroEstructuraConstantesFunciones.refrescarForeignKeysDescripcionesRubroEstructura(this.rubroestructura);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(RubroEstructura.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(rubroestructuras!=null) {
				for(RubroEstructura rubroestructura:rubroestructuras) {
					this.deepLoad(rubroestructura,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					RubroEstructuraConstantesFunciones.refrescarForeignKeysDescripcionesRubroEstructura(rubroestructuras);
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
			if(rubroestructuras!=null) {
				for(RubroEstructura rubroestructura:rubroestructuras) {
					this.deepLoad(rubroestructura,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					RubroEstructuraConstantesFunciones.refrescarForeignKeysDescripcionesRubroEstructura(rubroestructuras);
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
			this.getNewConnexionToDeep(RubroEstructura.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(rubroestructura,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(RubroEstructura.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(rubroestructuras!=null) {
				for(RubroEstructura rubroestructura:rubroestructuras) {
					this.deepSave(rubroestructura,isDeep,deepLoadType,clases);
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
			if(rubroestructuras!=null) {
				for(RubroEstructura rubroestructura:rubroestructuras) {
					this.deepSave(rubroestructura,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getRubroEstructurasFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RubroEstructura.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,RubroEstructuraConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			RubroEstructuraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			rubroestructuras=rubroestructuraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				RubroEstructuraConstantesFunciones.refrescarForeignKeysDescripcionesRubroEstructura(this.rubroestructuras);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getRubroEstructurasFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,RubroEstructuraConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			RubroEstructuraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			rubroestructuras=rubroestructuraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				RubroEstructuraConstantesFunciones.refrescarForeignKeysDescripcionesRubroEstructura(this.rubroestructuras);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getRubroEstructurasFK_IdEstructuraWithConnection(String sFinalQuery,Pagination pagination,Long id_estructura)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RubroEstructura.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEstructura= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEstructura.setParameterSelectionGeneralEqual(ParameterType.LONG,id_estructura,RubroEstructuraConstantesFunciones.IDESTRUCTURA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEstructura);

			RubroEstructuraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEstructura","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			rubroestructuras=rubroestructuraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				RubroEstructuraConstantesFunciones.refrescarForeignKeysDescripcionesRubroEstructura(this.rubroestructuras);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getRubroEstructurasFK_IdEstructura(String sFinalQuery,Pagination pagination,Long id_estructura)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEstructura= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEstructura.setParameterSelectionGeneralEqual(ParameterType.LONG,id_estructura,RubroEstructuraConstantesFunciones.IDESTRUCTURA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEstructura);

			RubroEstructuraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEstructura","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			rubroestructuras=rubroestructuraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				RubroEstructuraConstantesFunciones.refrescarForeignKeysDescripcionesRubroEstructura(this.rubroestructuras);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getRubroEstructurasFK_IdRubroEmpleaWithConnection(String sFinalQuery,Pagination pagination,Long id_rubro_emplea)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RubroEstructura.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidRubroEmplea= new ParameterSelectionGeneral();
			parameterSelectionGeneralidRubroEmplea.setParameterSelectionGeneralEqual(ParameterType.LONG,id_rubro_emplea,RubroEstructuraConstantesFunciones.IDRUBROEMPLEA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidRubroEmplea);

			RubroEstructuraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdRubroEmplea","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			rubroestructuras=rubroestructuraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				RubroEstructuraConstantesFunciones.refrescarForeignKeysDescripcionesRubroEstructura(this.rubroestructuras);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getRubroEstructurasFK_IdRubroEmplea(String sFinalQuery,Pagination pagination,Long id_rubro_emplea)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidRubroEmplea= new ParameterSelectionGeneral();
			parameterSelectionGeneralidRubroEmplea.setParameterSelectionGeneralEqual(ParameterType.LONG,id_rubro_emplea,RubroEstructuraConstantesFunciones.IDRUBROEMPLEA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidRubroEmplea);

			RubroEstructuraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdRubroEmplea","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			rubroestructuras=rubroestructuraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				RubroEstructuraConstantesFunciones.refrescarForeignKeysDescripcionesRubroEstructura(this.rubroestructuras);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getRubroEstructurasFK_IdSucursalWithConnection(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RubroEstructura.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,RubroEstructuraConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			RubroEstructuraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			rubroestructuras=rubroestructuraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				RubroEstructuraConstantesFunciones.refrescarForeignKeysDescripcionesRubroEstructura(this.rubroestructuras);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getRubroEstructurasFK_IdSucursal(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,RubroEstructuraConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			RubroEstructuraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			rubroestructuras=rubroestructuraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				RubroEstructuraConstantesFunciones.refrescarForeignKeysDescripcionesRubroEstructura(this.rubroestructuras);
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
			if(RubroEstructuraConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,RubroEstructuraDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,RubroEstructura rubroestructura,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(RubroEstructuraConstantesFunciones.ISCONAUDITORIA) {
				if(rubroestructura.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,RubroEstructuraDataAccess.TABLENAME, rubroestructura.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(RubroEstructuraConstantesFunciones.ISCONAUDITORIADETALLE) {
						////RubroEstructuraLogic.registrarAuditoriaDetallesRubroEstructura(connexion,rubroestructura,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(rubroestructura.getIsDeleted()) {
					/*if(!rubroestructura.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,RubroEstructuraDataAccess.TABLENAME, rubroestructura.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////RubroEstructuraLogic.registrarAuditoriaDetallesRubroEstructura(connexion,rubroestructura,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,RubroEstructuraDataAccess.TABLENAME, rubroestructura.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(rubroestructura.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,RubroEstructuraDataAccess.TABLENAME, rubroestructura.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(RubroEstructuraConstantesFunciones.ISCONAUDITORIADETALLE) {
						////RubroEstructuraLogic.registrarAuditoriaDetallesRubroEstructura(connexion,rubroestructura,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesRubroEstructura(Connexion connexion,RubroEstructura rubroestructura)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(rubroestructura.getIsNew()||!rubroestructura.getid_empresa().equals(rubroestructura.getRubroEstructuraOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(rubroestructura.getRubroEstructuraOriginal().getid_empresa()!=null)
				{
					strValorActual=rubroestructura.getRubroEstructuraOriginal().getid_empresa().toString();
				}
				if(rubroestructura.getid_empresa()!=null)
				{
					strValorNuevo=rubroestructura.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),RubroEstructuraConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(rubroestructura.getIsNew()||!rubroestructura.getid_sucursal().equals(rubroestructura.getRubroEstructuraOriginal().getid_sucursal()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(rubroestructura.getRubroEstructuraOriginal().getid_sucursal()!=null)
				{
					strValorActual=rubroestructura.getRubroEstructuraOriginal().getid_sucursal().toString();
				}
				if(rubroestructura.getid_sucursal()!=null)
				{
					strValorNuevo=rubroestructura.getid_sucursal().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),RubroEstructuraConstantesFunciones.IDSUCURSAL,strValorActual,strValorNuevo);
			}	
			
			if(rubroestructura.getIsNew()||!rubroestructura.getid_estructura().equals(rubroestructura.getRubroEstructuraOriginal().getid_estructura()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(rubroestructura.getRubroEstructuraOriginal().getid_estructura()!=null)
				{
					strValorActual=rubroestructura.getRubroEstructuraOriginal().getid_estructura().toString();
				}
				if(rubroestructura.getid_estructura()!=null)
				{
					strValorNuevo=rubroestructura.getid_estructura().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),RubroEstructuraConstantesFunciones.IDESTRUCTURA,strValorActual,strValorNuevo);
			}	
			
			if(rubroestructura.getIsNew()||!rubroestructura.getid_rubro_emplea().equals(rubroestructura.getRubroEstructuraOriginal().getid_rubro_emplea()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(rubroestructura.getRubroEstructuraOriginal().getid_rubro_emplea()!=null)
				{
					strValorActual=rubroestructura.getRubroEstructuraOriginal().getid_rubro_emplea().toString();
				}
				if(rubroestructura.getid_rubro_emplea()!=null)
				{
					strValorNuevo=rubroestructura.getid_rubro_emplea().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),RubroEstructuraConstantesFunciones.IDRUBROEMPLEA,strValorActual,strValorNuevo);
			}	
			
			if(rubroestructura.getIsNew()||!rubroestructura.getesta_activo().equals(rubroestructura.getRubroEstructuraOriginal().getesta_activo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(rubroestructura.getRubroEstructuraOriginal().getesta_activo()!=null)
				{
					strValorActual=rubroestructura.getRubroEstructuraOriginal().getesta_activo().toString();
				}
				if(rubroestructura.getesta_activo()!=null)
				{
					strValorNuevo=rubroestructura.getesta_activo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),RubroEstructuraConstantesFunciones.ESTAACTIVO,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveRubroEstructuraRelacionesWithConnection(RubroEstructura rubroestructura) throws Exception {

		if(!rubroestructura.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveRubroEstructuraRelacionesBase(rubroestructura,true);
		}
	}

	public void saveRubroEstructuraRelaciones(RubroEstructura rubroestructura)throws Exception {

		if(!rubroestructura.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveRubroEstructuraRelacionesBase(rubroestructura,false);
		}
	}

	public void saveRubroEstructuraRelacionesBase(RubroEstructura rubroestructura,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("RubroEstructura-saveRelacionesWithConnection");}
	

			this.setRubroEstructura(rubroestructura);

			if(RubroEstructuraLogicAdditional.validarSaveRelaciones(rubroestructura,this)) {

				RubroEstructuraLogicAdditional.updateRelacionesToSave(rubroestructura,this);

				if((rubroestructura.getIsNew()||rubroestructura.getIsChanged())&&!rubroestructura.getIsDeleted()) {
					this.saveRubroEstructura();
					this.saveRubroEstructuraRelacionesDetalles();

				} else if(rubroestructura.getIsDeleted()) {
					this.saveRubroEstructuraRelacionesDetalles();
					this.saveRubroEstructura();
				}

				RubroEstructuraLogicAdditional.updateRelacionesToSaveAfter(rubroestructura,this);

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
	
	
	private void saveRubroEstructuraRelacionesDetalles()throws Exception {
		try {
	

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfRubroEstructura(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=RubroEstructuraConstantesFunciones.getClassesForeignKeysOfRubroEstructura(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfRubroEstructura(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=RubroEstructuraConstantesFunciones.getClassesRelationshipsOfRubroEstructura(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}
